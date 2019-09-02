package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.util.ArrayMap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(14)
@RequiresApi(14)
abstract class TransitionPort implements Cloneable {
    static final boolean DBG = false;
    private static final String LOG_TAG = "Transition";
    private static ThreadLocal<ArrayMap<Animator, AnimationInfo>> sRunningAnimators = new ThreadLocal();
    ArrayList<Animator> mAnimators = new ArrayList();
    boolean mCanRemoveViews = false;
    ArrayList<Animator> mCurrentAnimators = new ArrayList();
    long mDuration = -1;
    private TransitionValuesMaps mEndValues = new TransitionValuesMaps();
    private boolean mEnded = false;
    TimeInterpolator mInterpolator = null;
    ArrayList<TransitionListener> mListeners = null;
    private String mName = getClass().getName();
    int mNumInstances = 0;
    TransitionSetPort mParent = null;
    boolean mPaused = false;
    ViewGroup mSceneRoot = null;
    long mStartDelay = -1;
    private TransitionValuesMaps mStartValues = new TransitionValuesMaps();
    ArrayList<View> mTargetChildExcludes = null;
    ArrayList<View> mTargetExcludes = null;
    ArrayList<Integer> mTargetIdChildExcludes = null;
    ArrayList<Integer> mTargetIdExcludes = null;
    ArrayList<Integer> mTargetIds = new ArrayList();
    ArrayList<Class> mTargetTypeChildExcludes = null;
    ArrayList<Class> mTargetTypeExcludes = null;
    ArrayList<View> mTargets = new ArrayList();

    public interface TransitionListener {
        void onTransitionCancel(TransitionPort transitionPort);

        void onTransitionEnd(TransitionPort transitionPort);

        void onTransitionPause(TransitionPort transitionPort);

        void onTransitionResume(TransitionPort transitionPort);

        void onTransitionStart(TransitionPort transitionPort);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public static class TransitionListenerAdapter implements TransitionListener {
        public void onTransitionCancel(TransitionPort transitionPort) {
        }

        public void onTransitionEnd(TransitionPort transitionPort) {
        }

        public void onTransitionPause(TransitionPort transitionPort) {
        }

        public void onTransitionResume(TransitionPort transitionPort) {
        }

        public void onTransitionStart(TransitionPort transitionPort) {
        }
    }

    private static class AnimationInfo {
        String name;
        TransitionValues values;
        View view;
        WindowIdPort windowId;

        AnimationInfo(View view, String str, WindowIdPort windowIdPort, TransitionValues transitionValues) {
            this.view = view;
            this.name = str;
            this.values = transitionValues;
            this.windowId = windowIdPort;
        }
    }

    private static class ArrayListManager {
        private ArrayListManager() {
        }

        static <T> ArrayList<T> add(ArrayList<T> arrayList, T t) {
            ArrayList arrayList2;
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
            }
            if (!arrayList2.contains(t)) {
                arrayList2.add(t);
            }
            return arrayList2;
        }

        static <T> ArrayList<T> remove(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                return arrayList;
            }
            arrayList.remove(t);
            return arrayList.isEmpty() ? null : arrayList;
        }
    }

    private void captureHierarchy(View view, boolean z) {
        if (view != null) {
            int i = 0;
            int i2 = view.getParent() instanceof ListView ? 1 : 0;
            if (i2 == 0 || ((ListView) view.getParent()).getAdapter().hasStableIds()) {
                int i3 = -1;
                long j = -1;
                if (i2 == 0) {
                    i3 = view.getId();
                } else {
                    ListView listView = (ListView) view.getParent();
                    j = listView.getItemIdAtPosition(listView.getPositionForView(view));
                }
                if (this.mTargetIdExcludes != null && this.mTargetIdExcludes.contains(Integer.valueOf(i3))) {
                    return;
                }
                if (this.mTargetExcludes == null || !this.mTargetExcludes.contains(view)) {
                    if (!(this.mTargetTypeExcludes == null || view == null)) {
                        int size = this.mTargetTypeExcludes.size();
                        int i4 = 0;
                        while (i4 < size) {
                            if (!((Class) this.mTargetTypeExcludes.get(i4)).isInstance(view)) {
                                i4++;
                            } else {
                                return;
                            }
                        }
                    }
                    TransitionValues transitionValues = new TransitionValues();
                    transitionValues.view = view;
                    if (z) {
                        captureStartValues(transitionValues);
                    } else {
                        captureEndValues(transitionValues);
                    }
                    if (z) {
                        if (i2 == 0) {
                            this.mStartValues.viewValues.put(view, transitionValues);
                            if (i3 >= 0) {
                                this.mStartValues.idValues.put(i3, transitionValues);
                            }
                        } else {
                            this.mStartValues.itemIdValues.put(j, transitionValues);
                        }
                    } else if (i2 == 0) {
                        this.mEndValues.viewValues.put(view, transitionValues);
                        if (i3 >= 0) {
                            this.mEndValues.idValues.put(i3, transitionValues);
                        }
                    } else {
                        this.mEndValues.itemIdValues.put(j, transitionValues);
                    }
                    if ((view instanceof ViewGroup) && (this.mTargetIdChildExcludes == null || !this.mTargetIdChildExcludes.contains(Integer.valueOf(i3)))) {
                        if (this.mTargetChildExcludes == null || !this.mTargetChildExcludes.contains(view)) {
                            if (!(this.mTargetTypeChildExcludes == null || view == null)) {
                                i2 = this.mTargetTypeChildExcludes.size();
                                i3 = 0;
                                while (i3 < i2) {
                                    if (!((Class) this.mTargetTypeChildExcludes.get(i3)).isInstance(view)) {
                                        i3++;
                                    } else {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            while (i < viewGroup.getChildCount()) {
                                captureHierarchy(viewGroup.getChildAt(i), z);
                                i++;
                            }
                        }
                    }
                }
            }
        }
    }

    private ArrayList<Integer> excludeId(ArrayList<Integer> arrayList, int i, boolean z) {
        return i > 0 ? z ? ArrayListManager.add(arrayList, Integer.valueOf(i)) : ArrayListManager.remove(arrayList, Integer.valueOf(i)) : arrayList;
    }

    private ArrayList<Class> excludeType(ArrayList<Class> arrayList, Class cls, boolean z) {
        return cls != null ? z ? ArrayListManager.add(arrayList, cls) : ArrayListManager.remove(arrayList, cls) : arrayList;
    }

    private ArrayList<View> excludeView(ArrayList<View> arrayList, View view, boolean z) {
        return view != null ? z ? ArrayListManager.add(arrayList, view) : ArrayListManager.remove(arrayList, view) : arrayList;
    }

    private static ArrayMap<Animator, AnimationInfo> getRunningAnimators() {
        ArrayMap arrayMap = (ArrayMap) sRunningAnimators.get();
        if (arrayMap != null) {
            return arrayMap;
        }
        arrayMap = new ArrayMap();
        sRunningAnimators.set(arrayMap);
        return arrayMap;
    }

    private void runAnimator(Animator animator, final ArrayMap<Animator, AnimationInfo> arrayMap) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    arrayMap.remove(animator);
                    TransitionPort.this.mCurrentAnimators.remove(animator);
                }

                public void onAnimationStart(Animator animator) {
                    TransitionPort.this.mCurrentAnimators.add(animator);
                }
            });
            animate(animator);
        }
    }

    public TransitionPort addListener(TransitionListener transitionListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList();
        }
        this.mListeners.add(transitionListener);
        return this;
    }

    public TransitionPort addTarget(int i) {
        if (i > 0) {
            this.mTargetIds.add(Integer.valueOf(i));
        }
        return this;
    }

    public TransitionPort addTarget(View view) {
        this.mTargets.add(view);
        return this;
    }

    /* Access modifiers changed, original: protected */
    @RestrictTo({Scope.LIBRARY_GROUP})
    public void animate(Animator animator) {
        if (animator == null) {
            end();
            return;
        }
        if (getDuration() >= 0) {
            animator.setDuration(getDuration());
        }
        if (getStartDelay() >= 0) {
            animator.setStartDelay(getStartDelay());
        }
        if (getInterpolator() != null) {
            animator.setInterpolator(getInterpolator());
        }
        animator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                TransitionPort.this.end();
                animator.removeListener(this);
            }
        });
        animator.start();
    }

    /* Access modifiers changed, original: protected */
    @RestrictTo({Scope.LIBRARY_GROUP})
    public void cancel() {
        for (int size = this.mCurrentAnimators.size() - 1; size >= 0; size--) {
            ((Animator) this.mCurrentAnimators.get(size)).cancel();
        }
        if (this.mListeners != null && this.mListeners.size() > 0) {
            ArrayList arrayList = (ArrayList) this.mListeners.clone();
            int size2 = arrayList.size();
            for (int i = 0; i < size2; i++) {
                ((TransitionListener) arrayList.get(i)).onTransitionCancel(this);
            }
        }
    }

    public abstract void captureEndValues(TransitionValues transitionValues);

    public abstract void captureStartValues(TransitionValues transitionValues);

    /* Access modifiers changed, original: 0000 */
    public void captureValues(ViewGroup viewGroup, boolean z) {
        clearValues(z);
        if (this.mTargetIds.size() > 0 || this.mTargets.size() > 0) {
            int i = 0;
            if (this.mTargetIds.size() > 0) {
                for (int i2 = 0; i2 < this.mTargetIds.size(); i2++) {
                    int intValue = ((Integer) this.mTargetIds.get(i2)).intValue();
                    View findViewById = viewGroup.findViewById(intValue);
                    if (findViewById != null) {
                        TransitionValues transitionValues = new TransitionValues();
                        transitionValues.view = findViewById;
                        if (z) {
                            captureStartValues(transitionValues);
                        } else {
                            captureEndValues(transitionValues);
                        }
                        if (z) {
                            this.mStartValues.viewValues.put(findViewById, transitionValues);
                            if (intValue >= 0) {
                                this.mStartValues.idValues.put(intValue, transitionValues);
                            }
                        } else {
                            this.mEndValues.viewValues.put(findViewById, transitionValues);
                            if (intValue >= 0) {
                                this.mEndValues.idValues.put(intValue, transitionValues);
                            }
                        }
                    }
                }
            }
            if (this.mTargets.size() > 0) {
                while (i < this.mTargets.size()) {
                    View view = (View) this.mTargets.get(i);
                    if (view != null) {
                        TransitionValues transitionValues2 = new TransitionValues();
                        transitionValues2.view = view;
                        if (z) {
                            captureStartValues(transitionValues2);
                        } else {
                            captureEndValues(transitionValues2);
                        }
                        if (z) {
                            this.mStartValues.viewValues.put(view, transitionValues2);
                        } else {
                            this.mEndValues.viewValues.put(view, transitionValues2);
                        }
                    }
                    i++;
                }
                return;
            }
            return;
        }
        captureHierarchy(viewGroup, z);
    }

    /* Access modifiers changed, original: 0000 */
    public void clearValues(boolean z) {
        if (z) {
            this.mStartValues.viewValues.clear();
            this.mStartValues.idValues.clear();
            this.mStartValues.itemIdValues.clear();
            return;
        }
        this.mEndValues.viewValues.clear();
        this.mEndValues.idValues.clear();
        this.mEndValues.itemIdValues.clear();
    }

    public TransitionPort clone() {
        try {
            TransitionPort transitionPort = (TransitionPort) super.clone();
            try {
                transitionPort.mAnimators = new ArrayList();
                transitionPort.mStartValues = new TransitionValuesMaps();
                transitionPort.mEndValues = new TransitionValuesMaps();
                return transitionPort;
            } catch (CloneNotSupportedException unused) {
                return transitionPort;
            }
        } catch (CloneNotSupportedException unused2) {
            return null;
        }
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x012a A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x02b5 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x02a0  */
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void createAnimators(android.view.ViewGroup r20, android.support.transition.TransitionValuesMaps r21, android.support.transition.TransitionValuesMaps r22) {
        /*
        r19 = this;
        r0 = r19;
        r1 = r21;
        r2 = r22;
        r3 = new android.support.v4.util.ArrayMap;
        r4 = r2.viewValues;
        r3.<init>(r4);
        r4 = new android.util.SparseArray;
        r5 = r2.idValues;
        r5 = r5.size();
        r4.<init>(r5);
        r6 = 0;
    L_0x0019:
        r7 = r2.idValues;
        r7 = r7.size();
        if (r6 >= r7) goto L_0x0033;
    L_0x0021:
        r7 = r2.idValues;
        r7 = r7.keyAt(r6);
        r8 = r2.idValues;
        r8 = r8.valueAt(r6);
        r4.put(r7, r8);
        r6 = r6 + 1;
        goto L_0x0019;
    L_0x0033:
        r6 = new android.support.v4.util.LongSparseArray;
        r7 = r2.itemIdValues;
        r7 = r7.size();
        r6.<init>(r7);
        r7 = 0;
    L_0x003f:
        r8 = r2.itemIdValues;
        r8 = r8.size();
        if (r7 >= r8) goto L_0x0059;
    L_0x0047:
        r8 = r2.itemIdValues;
        r8 = r8.keyAt(r7);
        r10 = r2.itemIdValues;
        r10 = r10.valueAt(r7);
        r6.put(r8, r10);
        r7 = r7 + 1;
        goto L_0x003f;
    L_0x0059:
        r7 = new java.util.ArrayList;
        r7.<init>();
        r8 = new java.util.ArrayList;
        r8.<init>();
        r9 = r1.viewValues;
        r9 = r9.keySet();
        r9 = r9.iterator();
    L_0x006d:
        r10 = r9.hasNext();
        r11 = 0;
        if (r10 == 0) goto L_0x012e;
    L_0x0074:
        r10 = r9.next();
        r10 = (android.view.View) r10;
        r12 = r10.getParent();
        r12 = r12 instanceof android.widget.ListView;
        if (r12 == 0) goto L_0x0084;
    L_0x0082:
        r12 = 1;
        goto L_0x0085;
    L_0x0084:
        r12 = 0;
    L_0x0085:
        if (r12 != 0) goto L_0x00ff;
    L_0x0087:
        r12 = r10.getId();
        r13 = r1.viewValues;
        r13 = r13.get(r10);
        if (r13 == 0) goto L_0x009c;
    L_0x0093:
        r13 = r1.viewValues;
        r13 = r13.get(r10);
    L_0x0099:
        r13 = (android.support.transition.TransitionValues) r13;
        goto L_0x00a3;
    L_0x009c:
        r13 = r1.idValues;
        r13 = r13.get(r12);
        goto L_0x0099;
    L_0x00a3:
        r14 = r2.viewValues;
        r14 = r14.get(r10);
        if (r14 == 0) goto L_0x00b9;
    L_0x00ab:
        r11 = r2.viewValues;
        r11 = r11.get(r10);
        r11 = (android.support.transition.TransitionValues) r11;
        r3.remove(r10);
    L_0x00b6:
        r17 = r9;
        goto L_0x00ee;
    L_0x00b9:
        r14 = -1;
        if (r12 == r14) goto L_0x00b6;
    L_0x00bc:
        r14 = r2.idValues;
        r14 = r14.get(r12);
        r14 = (android.support.transition.TransitionValues) r14;
        r15 = r3.keySet();
        r15 = r15.iterator();
    L_0x00cc:
        r16 = r15.hasNext();
        if (r16 == 0) goto L_0x00e6;
    L_0x00d2:
        r16 = r15.next();
        r5 = r16;
        r5 = (android.view.View) r5;
        r17 = r9;
        r9 = r5.getId();
        if (r9 != r12) goto L_0x00e3;
    L_0x00e2:
        r11 = r5;
    L_0x00e3:
        r9 = r17;
        goto L_0x00cc;
    L_0x00e6:
        r17 = r9;
        if (r11 == 0) goto L_0x00ed;
    L_0x00ea:
        r3.remove(r11);
    L_0x00ed:
        r11 = r14;
    L_0x00ee:
        r4.remove(r12);
        r14 = (long) r12;
        r5 = r0.isValidTarget(r10, r14);
        if (r5 == 0) goto L_0x012a;
    L_0x00f8:
        r7.add(r13);
        r8.add(r11);
        goto L_0x012a;
    L_0x00ff:
        r17 = r9;
        r5 = r10.getParent();
        r5 = (android.widget.ListView) r5;
        r9 = r5.getAdapter();
        r9 = r9.hasStableIds();
        if (r9 == 0) goto L_0x012a;
    L_0x0111:
        r9 = r5.getPositionForView(r10);
        r9 = r5.getItemIdAtPosition(r9);
        r5 = r1.itemIdValues;
        r5 = r5.get(r9);
        r5 = (android.support.transition.TransitionValues) r5;
        r6.remove(r9);
        r7.add(r5);
        r8.add(r11);
    L_0x012a:
        r9 = r17;
        goto L_0x006d;
    L_0x012e:
        r5 = r1.itemIdValues;
        r5 = r5.size();
        r9 = 0;
    L_0x0135:
        if (r9 >= r5) goto L_0x015f;
    L_0x0137:
        r10 = r1.itemIdValues;
        r12 = r10.keyAt(r9);
        r10 = r0.isValidTarget(r11, r12);
        if (r10 == 0) goto L_0x015c;
    L_0x0143:
        r10 = r1.itemIdValues;
        r10 = r10.get(r12);
        r10 = (android.support.transition.TransitionValues) r10;
        r14 = r2.itemIdValues;
        r14 = r14.get(r12);
        r14 = (android.support.transition.TransitionValues) r14;
        r6.remove(r12);
        r7.add(r10);
        r8.add(r14);
    L_0x015c:
        r9 = r9 + 1;
        goto L_0x0135;
    L_0x015f:
        r5 = r3.keySet();
        r5 = r5.iterator();
    L_0x0167:
        r9 = r5.hasNext();
        if (r9 == 0) goto L_0x01a6;
    L_0x016d:
        r9 = r5.next();
        r9 = (android.view.View) r9;
        r10 = r9.getId();
        r12 = (long) r10;
        r12 = r0.isValidTarget(r9, r12);
        if (r12 == 0) goto L_0x0167;
    L_0x017e:
        r12 = r1.viewValues;
        r12 = r12.get(r9);
        if (r12 == 0) goto L_0x018f;
    L_0x0186:
        r12 = r1.viewValues;
        r12 = r12.get(r9);
    L_0x018c:
        r12 = (android.support.transition.TransitionValues) r12;
        goto L_0x0196;
    L_0x018f:
        r12 = r1.idValues;
        r12 = r12.get(r10);
        goto L_0x018c;
    L_0x0196:
        r9 = r3.get(r9);
        r9 = (android.support.transition.TransitionValues) r9;
        r4.remove(r10);
        r7.add(r12);
        r8.add(r9);
        goto L_0x0167;
    L_0x01a6:
        r3 = r4.size();
        r5 = 0;
    L_0x01ab:
        if (r5 >= r3) goto L_0x01cf;
    L_0x01ad:
        r9 = r4.keyAt(r5);
        r12 = (long) r9;
        r10 = r0.isValidTarget(r11, r12);
        if (r10 == 0) goto L_0x01cc;
    L_0x01b8:
        r10 = r1.idValues;
        r10 = r10.get(r9);
        r10 = (android.support.transition.TransitionValues) r10;
        r9 = r4.get(r9);
        r9 = (android.support.transition.TransitionValues) r9;
        r7.add(r10);
        r8.add(r9);
    L_0x01cc:
        r5 = r5 + 1;
        goto L_0x01ab;
    L_0x01cf:
        r3 = r6.size();
        r4 = 0;
    L_0x01d4:
        if (r4 >= r3) goto L_0x01f1;
    L_0x01d6:
        r9 = r6.keyAt(r4);
        r5 = r1.itemIdValues;
        r5 = r5.get(r9);
        r5 = (android.support.transition.TransitionValues) r5;
        r9 = r6.get(r9);
        r9 = (android.support.transition.TransitionValues) r9;
        r7.add(r5);
        r8.add(r9);
        r4 = r4 + 1;
        goto L_0x01d4;
    L_0x01f1:
        r1 = getRunningAnimators();
        r3 = 0;
    L_0x01f6:
        r4 = r7.size();
        if (r3 >= r4) goto L_0x02bc;
    L_0x01fc:
        r4 = r7.get(r3);
        r4 = (android.support.transition.TransitionValues) r4;
        r5 = r8.get(r3);
        r5 = (android.support.transition.TransitionValues) r5;
        if (r4 != 0) goto L_0x0211;
    L_0x020a:
        if (r5 == 0) goto L_0x020d;
    L_0x020c:
        goto L_0x0211;
    L_0x020d:
        r6 = r20;
        goto L_0x02b5;
    L_0x0211:
        if (r4 == 0) goto L_0x0219;
    L_0x0213:
        r6 = r4.equals(r5);
        if (r6 != 0) goto L_0x020d;
    L_0x0219:
        r6 = r20;
        r9 = r0.createAnimator(r6, r4, r5);
        if (r9 == 0) goto L_0x02b5;
    L_0x0221:
        if (r5 == 0) goto L_0x029b;
    L_0x0223:
        r4 = r5.view;
        r5 = r19.getTransitionProperties();
        if (r4 == 0) goto L_0x029d;
    L_0x022b:
        if (r5 == 0) goto L_0x029d;
    L_0x022d:
        r10 = r5.length;
        if (r10 <= 0) goto L_0x029d;
    L_0x0230:
        r10 = new android.support.transition.TransitionValues;
        r10.<init>();
        r10.view = r4;
        r12 = r2.viewValues;
        r12 = r12.get(r4);
        r12 = (android.support.transition.TransitionValues) r12;
        if (r12 == 0) goto L_0x025a;
    L_0x0241:
        r13 = 0;
    L_0x0242:
        r14 = r5.length;
        if (r13 >= r14) goto L_0x025a;
    L_0x0245:
        r14 = r10.values;
        r15 = r5[r13];
        r11 = r12.values;
        r2 = r5[r13];
        r2 = r11.get(r2);
        r14.put(r15, r2);
        r13 = r13 + 1;
        r2 = r22;
        r11 = 0;
        goto L_0x0242;
    L_0x025a:
        r2 = r1.size();
        r5 = 0;
    L_0x025f:
        if (r5 >= r2) goto L_0x0299;
    L_0x0261:
        r11 = r1.keyAt(r5);
        r11 = (android.animation.Animator) r11;
        r11 = r1.get(r11);
        r11 = (android.support.transition.TransitionPort.AnimationInfo) r11;
        r12 = r11.values;
        if (r12 == 0) goto L_0x0296;
    L_0x0271:
        r12 = r11.view;
        if (r12 != r4) goto L_0x0296;
    L_0x0275:
        r12 = r11.name;
        if (r12 != 0) goto L_0x027f;
    L_0x0279:
        r12 = r19.getName();
        if (r12 == 0) goto L_0x028b;
    L_0x027f:
        r12 = r11.name;
        r13 = r19.getName();
        r12 = r12.equals(r13);
        if (r12 == 0) goto L_0x0296;
    L_0x028b:
        r11 = r11.values;
        r11 = r11.equals(r10);
        if (r11 == 0) goto L_0x0296;
    L_0x0293:
        r11 = r10;
        r9 = 0;
        goto L_0x029e;
    L_0x0296:
        r5 = r5 + 1;
        goto L_0x025f;
    L_0x0299:
        r11 = r10;
        goto L_0x029e;
    L_0x029b:
        r4 = r4.view;
    L_0x029d:
        r11 = 0;
    L_0x029e:
        if (r9 == 0) goto L_0x02b5;
    L_0x02a0:
        r2 = new android.support.transition.TransitionPort$AnimationInfo;
        r5 = r19.getName();
        r10 = android.support.transition.WindowIdPort.getWindowId(r20);
        r2.<init>(r4, r5, r10, r11);
        r1.put(r9, r2);
        r2 = r0.mAnimators;
        r2.add(r9);
    L_0x02b5:
        r3 = r3 + 1;
        r2 = r22;
        r11 = 0;
        goto L_0x01f6;
    L_0x02bc:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.TransitionPort.createAnimators(android.view.ViewGroup, android.support.transition.TransitionValuesMaps, android.support.transition.TransitionValuesMaps):void");
    }

    /* Access modifiers changed, original: protected */
    @RestrictTo({Scope.LIBRARY_GROUP})
    public void end() {
        this.mNumInstances--;
        if (this.mNumInstances == 0) {
            int i = 0;
            if (this.mListeners != null && this.mListeners.size() > 0) {
                ArrayList arrayList = (ArrayList) this.mListeners.clone();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((TransitionListener) arrayList.get(i2)).onTransitionEnd(this);
                }
            }
            for (int i3 = 0; i3 < this.mStartValues.itemIdValues.size(); i3++) {
                View view = ((TransitionValues) this.mStartValues.itemIdValues.valueAt(i3)).view;
            }
            while (i < this.mEndValues.itemIdValues.size()) {
                View view2 = ((TransitionValues) this.mEndValues.itemIdValues.valueAt(i)).view;
                i++;
            }
            this.mEnded = true;
        }
    }

    public TransitionPort excludeChildren(int i, boolean z) {
        this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, i, z);
        return this;
    }

    public TransitionPort excludeChildren(View view, boolean z) {
        this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, view, z);
        return this;
    }

    public TransitionPort excludeChildren(Class cls, boolean z) {
        this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, cls, z);
        return this;
    }

    public TransitionPort excludeTarget(int i, boolean z) {
        this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, i, z);
        return this;
    }

    public TransitionPort excludeTarget(View view, boolean z) {
        this.mTargetExcludes = excludeView(this.mTargetExcludes, view, z);
        return this;
    }

    public TransitionPort excludeTarget(Class cls, boolean z) {
        this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, cls, z);
        return this;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    public String getName() {
        return this.mName;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    public List<View> getTargets() {
        return this.mTargets;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public TransitionValues getTransitionValues(View view, boolean z) {
        if (this.mParent != null) {
            return this.mParent.getTransitionValues(view, z);
        }
        TransitionValuesMaps transitionValuesMaps = z ? this.mStartValues : this.mEndValues;
        TransitionValues transitionValues = (TransitionValues) transitionValuesMaps.viewValues.get(view);
        if (transitionValues == null) {
            int id = view.getId();
            if (id >= 0) {
                transitionValues = (TransitionValues) transitionValuesMaps.idValues.get(id);
            }
            if (transitionValues == null && (view.getParent() instanceof ListView)) {
                ListView listView = (ListView) view.getParent();
                transitionValues = (TransitionValues) transitionValuesMaps.itemIdValues.get(listView.getItemIdAtPosition(listView.getPositionForView(view)));
            }
        }
        return transitionValues;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean isValidTarget(View view, long j) {
        if (this.mTargetIdExcludes != null && this.mTargetIdExcludes.contains(Integer.valueOf((int) j))) {
            return false;
        }
        if (this.mTargetExcludes != null && this.mTargetExcludes.contains(view)) {
            return false;
        }
        int size;
        if (!(this.mTargetTypeExcludes == null || view == null)) {
            size = this.mTargetTypeExcludes.size();
            for (int i = 0; i < size; i++) {
                if (((Class) this.mTargetTypeExcludes.get(i)).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.mTargetIds.size() == 0 && this.mTargets.size() == 0) {
            return true;
        }
        if (this.mTargetIds.size() > 0) {
            for (size = 0; size < this.mTargetIds.size(); size++) {
                if (((long) ((Integer) this.mTargetIds.get(size)).intValue()) == j) {
                    return true;
                }
            }
        }
        if (view != null && this.mTargets.size() > 0) {
            for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                if (this.mTargets.get(i2) == view) {
                    return true;
                }
            }
        }
        return false;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void pause(View view) {
        if (!this.mEnded) {
            ArrayMap runningAnimators = getRunningAnimators();
            int size = runningAnimators.size();
            WindowIdPort windowId = WindowIdPort.getWindowId(view);
            for (size--; size >= 0; size--) {
                AnimationInfo animationInfo = (AnimationInfo) runningAnimators.valueAt(size);
                if (animationInfo.view != null && windowId.equals(animationInfo.windowId)) {
                    ((Animator) runningAnimators.keyAt(size)).cancel();
                }
            }
            if (this.mListeners != null && this.mListeners.size() > 0) {
                ArrayList arrayList = (ArrayList) this.mListeners.clone();
                int size2 = arrayList.size();
                for (size = 0; size < size2; size++) {
                    ((TransitionListener) arrayList.get(size)).onTransitionPause(this);
                }
            }
            this.mPaused = true;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void playTransition(ViewGroup viewGroup) {
        ArrayMap runningAnimators = getRunningAnimators();
        for (int size = runningAnimators.size() - 1; size >= 0; size--) {
            Animator animator = (Animator) runningAnimators.keyAt(size);
            if (animator != null) {
                AnimationInfo animationInfo = (AnimationInfo) runningAnimators.get(animator);
                if (!(animationInfo == null || animationInfo.view == null || animationInfo.view.getContext() != viewGroup.getContext())) {
                    int i = 0;
                    TransitionValues transitionValues = animationInfo.values;
                    View view = animationInfo.view;
                    TransitionValues transitionValues2 = this.mEndValues.viewValues != null ? (TransitionValues) this.mEndValues.viewValues.get(view) : null;
                    if (transitionValues2 == null) {
                        transitionValues2 = (TransitionValues) this.mEndValues.idValues.get(view.getId());
                    }
                    if (transitionValues != null && transitionValues2 != null) {
                        for (String str : transitionValues.values.keySet()) {
                            Object obj = transitionValues.values.get(str);
                            Object obj2 = transitionValues2.values.get(str);
                            if (obj != null && obj2 != null && !obj.equals(obj2)) {
                                i = 1;
                                break;
                            }
                        }
                    }
                    if (i != 0) {
                        if (animator.isRunning() || animator.isStarted()) {
                            animator.cancel();
                        } else {
                            runningAnimators.remove(animator);
                        }
                    }
                }
            }
        }
        createAnimators(viewGroup, this.mStartValues, this.mEndValues);
        runAnimators();
    }

    public TransitionPort removeListener(TransitionListener transitionListener) {
        if (this.mListeners == null) {
            return this;
        }
        this.mListeners.remove(transitionListener);
        if (this.mListeners.size() == 0) {
            this.mListeners = null;
        }
        return this;
    }

    public TransitionPort removeTarget(int i) {
        if (i > 0) {
            this.mTargetIds.remove(Integer.valueOf(i));
        }
        return this;
    }

    public TransitionPort removeTarget(View view) {
        if (view != null) {
            this.mTargets.remove(view);
        }
        return this;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void resume(View view) {
        if (this.mPaused) {
            if (!this.mEnded) {
                ArrayMap runningAnimators = getRunningAnimators();
                int size = runningAnimators.size();
                WindowIdPort windowId = WindowIdPort.getWindowId(view);
                for (size--; size >= 0; size--) {
                    AnimationInfo animationInfo = (AnimationInfo) runningAnimators.valueAt(size);
                    if (animationInfo.view != null && windowId.equals(animationInfo.windowId)) {
                        ((Animator) runningAnimators.keyAt(size)).end();
                    }
                }
                if (this.mListeners != null && this.mListeners.size() > 0) {
                    ArrayList arrayList = (ArrayList) this.mListeners.clone();
                    int size2 = arrayList.size();
                    for (size = 0; size < size2; size++) {
                        ((TransitionListener) arrayList.get(size)).onTransitionResume(this);
                    }
                }
            }
            this.mPaused = false;
        }
    }

    /* Access modifiers changed, original: protected */
    @RestrictTo({Scope.LIBRARY_GROUP})
    public void runAnimators() {
        start();
        ArrayMap runningAnimators = getRunningAnimators();
        Iterator it = this.mAnimators.iterator();
        while (it.hasNext()) {
            Animator animator = (Animator) it.next();
            if (runningAnimators.containsKey(animator)) {
                start();
                runAnimator(animator, runningAnimators);
            }
        }
        this.mAnimators.clear();
        end();
    }

    /* Access modifiers changed, original: 0000 */
    public void setCanRemoveViews(boolean z) {
        this.mCanRemoveViews = z;
    }

    public TransitionPort setDuration(long j) {
        this.mDuration = j;
        return this;
    }

    public TransitionPort setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    /* Access modifiers changed, original: 0000 */
    public TransitionPort setSceneRoot(ViewGroup viewGroup) {
        this.mSceneRoot = viewGroup;
        return this;
    }

    public TransitionPort setStartDelay(long j) {
        this.mStartDelay = j;
        return this;
    }

    /* Access modifiers changed, original: protected */
    @RestrictTo({Scope.LIBRARY_GROUP})
    public void start() {
        if (this.mNumInstances == 0) {
            if (this.mListeners != null && this.mListeners.size() > 0) {
                ArrayList arrayList = (ArrayList) this.mListeners.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((TransitionListener) arrayList.get(i)).onTransitionStart(this);
                }
            }
            this.mEnded = false;
        }
        this.mNumInstances++;
    }

    public String toString() {
        return toString("");
    }

    /* Access modifiers changed, original: 0000 */
    public String toString(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        stringBuilder.append(": ");
        str = stringBuilder.toString();
        if (this.mDuration != -1) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("dur(");
            stringBuilder.append(this.mDuration);
            stringBuilder.append(") ");
            str = stringBuilder.toString();
        }
        if (this.mStartDelay != -1) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("dly(");
            stringBuilder.append(this.mStartDelay);
            stringBuilder.append(") ");
            str = stringBuilder.toString();
        }
        if (this.mInterpolator != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("interp(");
            stringBuilder.append(this.mInterpolator);
            stringBuilder.append(") ");
            str = stringBuilder.toString();
        }
        if (this.mTargetIds.size() <= 0 && this.mTargets.size() <= 0) {
            return str;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("tgts(");
        str = stringBuilder.toString();
        int i = 0;
        if (this.mTargetIds.size() > 0) {
            String str2 = str;
            for (int i2 = 0; i2 < this.mTargetIds.size(); i2++) {
                StringBuilder stringBuilder2;
                if (i2 > 0) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str2);
                    stringBuilder2.append(", ");
                    str2 = stringBuilder2.toString();
                }
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str2);
                stringBuilder2.append(this.mTargetIds.get(i2));
                str2 = stringBuilder2.toString();
            }
            str = str2;
        }
        if (this.mTargets.size() > 0) {
            while (i < this.mTargets.size()) {
                if (i > 0) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(", ");
                    str = stringBuilder.toString();
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(this.mTargets.get(i));
                str = stringBuilder.toString();
                i++;
            }
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
