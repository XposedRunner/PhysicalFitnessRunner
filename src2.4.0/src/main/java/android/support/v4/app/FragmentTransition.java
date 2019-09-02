package android.support.v4.app;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;

class FragmentTransition {
    private static final int[] INVERSE_OPS = new int[]{0, 3, 0, 1, 5, 4, 7, 6};

    static class FragmentContainerTransition {
        public Fragment firstOut;
        public boolean firstOutIsPop;
        public BackStackRecord firstOutTransaction;
        public Fragment lastIn;
        public boolean lastInIsPop;
        public BackStackRecord lastInTransaction;

        FragmentContainerTransition() {
        }
    }

    FragmentTransition() {
    }

    private static void addSharedElementsWithMatchingNames(ArrayList<View> arrayList, ArrayMap<String, View> arrayMap, Collection<String> collection) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View view = (View) arrayMap.valueAt(size);
            if (collection.contains(ViewCompat.getTransitionName(view))) {
                arrayList.add(view);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x0097  */
    /* JADX WARNING: Missing block: B:16:0x0032, code skipped:
            if (r10.mAdded != false) goto L_0x0088;
     */
    /* JADX WARNING: Missing block: B:38:0x006a, code skipped:
            r1 = 1;
     */
    /* JADX WARNING: Missing block: B:39:0x006c, code skipped:
            r1 = null;
     */
    /* JADX WARNING: Missing block: B:44:0x0077, code skipped:
            r13 = r1;
            r1 = null;
            r12 = 1;
     */
    /* JADX WARNING: Missing block: B:50:0x0086, code skipped:
            if (r10.mHidden == false) goto L_0x0088;
     */
    /* JADX WARNING: Missing block: B:51:0x0088, code skipped:
            r1 = true;
     */
    private static void addToFirstInLastOut(android.support.v4.app.BackStackRecord r16, android.support.v4.app.BackStackRecord.Op r17, android.util.SparseArray<android.support.v4.app.FragmentTransition.FragmentContainerTransition> r18, boolean r19, boolean r20) {
        /*
        r0 = r16;
        r1 = r17;
        r2 = r18;
        r3 = r19;
        r10 = r1.fragment;
        r11 = r10.mContainerId;
        if (r11 != 0) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        if (r3 == 0) goto L_0x0018;
    L_0x0011:
        r4 = INVERSE_OPS;
        r1 = r1.cmd;
        r1 = r4[r1];
        goto L_0x001a;
    L_0x0018:
        r1 = r1.cmd;
    L_0x001a:
        r4 = 0;
        r5 = 1;
        if (r1 == r5) goto L_0x007b;
    L_0x001e:
        switch(r1) {
            case 3: goto L_0x0051;
            case 4: goto L_0x0039;
            case 5: goto L_0x0026;
            case 6: goto L_0x0051;
            case 7: goto L_0x007b;
            default: goto L_0x0021;
        };
    L_0x0021:
        r1 = r4;
        r12 = r1;
        r13 = r12;
        goto L_0x008f;
    L_0x0026:
        if (r20 == 0) goto L_0x0035;
    L_0x0028:
        r1 = r10.mHiddenChanged;
        if (r1 == 0) goto L_0x008a;
    L_0x002c:
        r1 = r10.mHidden;
        if (r1 != 0) goto L_0x008a;
    L_0x0030:
        r1 = r10.mAdded;
        if (r1 == 0) goto L_0x008a;
    L_0x0034:
        goto L_0x0088;
    L_0x0035:
        r1 = r10.mHidden;
        goto L_0x008b;
    L_0x0039:
        if (r20 == 0) goto L_0x0048;
    L_0x003b:
        r1 = r10.mHiddenChanged;
        if (r1 == 0) goto L_0x006c;
    L_0x003f:
        r1 = r10.mAdded;
        if (r1 == 0) goto L_0x006c;
    L_0x0043:
        r1 = r10.mHidden;
        if (r1 == 0) goto L_0x006c;
    L_0x0047:
        goto L_0x006a;
    L_0x0048:
        r1 = r10.mAdded;
        if (r1 == 0) goto L_0x006c;
    L_0x004c:
        r1 = r10.mHidden;
        if (r1 != 0) goto L_0x006c;
    L_0x0050:
        goto L_0x0047;
    L_0x0051:
        if (r20 == 0) goto L_0x006e;
    L_0x0053:
        r1 = r10.mAdded;
        if (r1 != 0) goto L_0x006c;
    L_0x0057:
        r1 = r10.mView;
        if (r1 == 0) goto L_0x006c;
    L_0x005b:
        r1 = r10.mView;
        r1 = r1.getVisibility();
        if (r1 != 0) goto L_0x006c;
    L_0x0063:
        r1 = r10.mPostponedAlpha;
        r6 = 0;
        r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1));
        if (r1 < 0) goto L_0x006c;
    L_0x006a:
        r1 = r5;
        goto L_0x0077;
    L_0x006c:
        r1 = r4;
        goto L_0x0077;
    L_0x006e:
        r1 = r10.mAdded;
        if (r1 == 0) goto L_0x006c;
    L_0x0072:
        r1 = r10.mHidden;
        if (r1 != 0) goto L_0x006c;
    L_0x0076:
        goto L_0x006a;
    L_0x0077:
        r13 = r1;
        r1 = r4;
        r12 = r5;
        goto L_0x008f;
    L_0x007b:
        if (r20 == 0) goto L_0x0080;
    L_0x007d:
        r1 = r10.mIsNewlyAdded;
        goto L_0x008b;
    L_0x0080:
        r1 = r10.mAdded;
        if (r1 != 0) goto L_0x008a;
    L_0x0084:
        r1 = r10.mHidden;
        if (r1 != 0) goto L_0x008a;
    L_0x0088:
        r1 = r5;
        goto L_0x008b;
    L_0x008a:
        r1 = r4;
    L_0x008b:
        r12 = r4;
        r13 = r12;
        r4 = r1;
        r1 = r5;
    L_0x008f:
        r6 = r2.get(r11);
        r6 = (android.support.v4.app.FragmentTransition.FragmentContainerTransition) r6;
        if (r4 == 0) goto L_0x00a1;
    L_0x0097:
        r6 = ensureContainer(r6, r2, r11);
        r6.lastIn = r10;
        r6.lastInIsPop = r3;
        r6.lastInTransaction = r0;
    L_0x00a1:
        r14 = r6;
        r9 = 0;
        if (r20 != 0) goto L_0x00c9;
    L_0x00a5:
        if (r1 == 0) goto L_0x00c9;
    L_0x00a7:
        if (r14 == 0) goto L_0x00af;
    L_0x00a9:
        r1 = r14.firstOut;
        if (r1 != r10) goto L_0x00af;
    L_0x00ad:
        r14.firstOut = r9;
    L_0x00af:
        r4 = r0.mManager;
        r1 = r10.mState;
        if (r1 >= r5) goto L_0x00c9;
    L_0x00b5:
        r1 = r4.mCurState;
        if (r1 < r5) goto L_0x00c9;
    L_0x00b9:
        r1 = r0.mAllowOptimization;
        if (r1 != 0) goto L_0x00c9;
    L_0x00bd:
        r4.makeActive(r10);
        r6 = 1;
        r7 = 0;
        r8 = 0;
        r1 = 0;
        r5 = r10;
        r9 = r1;
        r4.moveToState(r5, r6, r7, r8, r9);
    L_0x00c9:
        if (r13 == 0) goto L_0x00db;
    L_0x00cb:
        if (r14 == 0) goto L_0x00d1;
    L_0x00cd:
        r1 = r14.firstOut;
        if (r1 != 0) goto L_0x00db;
    L_0x00d1:
        r14 = ensureContainer(r14, r2, r11);
        r14.firstOut = r10;
        r14.firstOutIsPop = r3;
        r14.firstOutTransaction = r0;
    L_0x00db:
        if (r20 != 0) goto L_0x00e8;
    L_0x00dd:
        if (r12 == 0) goto L_0x00e8;
    L_0x00df:
        if (r14 == 0) goto L_0x00e8;
    L_0x00e1:
        r0 = r14.lastIn;
        if (r0 != r10) goto L_0x00e8;
    L_0x00e5:
        r0 = 0;
        r14.lastIn = r0;
    L_0x00e8:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentTransition.addToFirstInLastOut(android.support.v4.app.BackStackRecord, android.support.v4.app.BackStackRecord$Op, android.util.SparseArray, boolean, boolean):void");
    }

    public static void calculateFragments(BackStackRecord backStackRecord, SparseArray<FragmentContainerTransition> sparseArray, boolean z) {
        int size = backStackRecord.mOps.size();
        for (int i = 0; i < size; i++) {
            addToFirstInLastOut(backStackRecord, (Op) backStackRecord.mOps.get(i), sparseArray, false, z);
        }
    }

    private static ArrayMap<String, String> calculateNameOverrides(int i, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayMap arrayMap = new ArrayMap();
        for (i3--; i3 >= i2; i3--) {
            BackStackRecord backStackRecord = (BackStackRecord) arrayList.get(i3);
            if (backStackRecord.interactsWith(i)) {
                boolean booleanValue = ((Boolean) arrayList2.get(i3)).booleanValue();
                if (backStackRecord.mSharedElementSourceNames != null) {
                    ArrayList arrayList3;
                    ArrayList arrayList4;
                    int size = backStackRecord.mSharedElementSourceNames.size();
                    if (booleanValue) {
                        arrayList3 = backStackRecord.mSharedElementSourceNames;
                        arrayList4 = backStackRecord.mSharedElementTargetNames;
                    } else {
                        ArrayList arrayList5 = backStackRecord.mSharedElementSourceNames;
                        arrayList3 = backStackRecord.mSharedElementTargetNames;
                        arrayList4 = arrayList5;
                    }
                    for (int i4 = 0; i4 < size; i4++) {
                        String str = (String) arrayList4.get(i4);
                        String str2 = (String) arrayList3.get(i4);
                        String str3 = (String) arrayMap.remove(str2);
                        if (str3 != null) {
                            arrayMap.put(str, str3);
                        } else {
                            arrayMap.put(str, str2);
                        }
                    }
                }
            }
        }
        return arrayMap;
    }

    public static void calculatePopFragments(BackStackRecord backStackRecord, SparseArray<FragmentContainerTransition> sparseArray, boolean z) {
        if (backStackRecord.mManager.mContainer.onHasView()) {
            for (int size = backStackRecord.mOps.size() - 1; size >= 0; size--) {
                addToFirstInLastOut(backStackRecord, (Op) backStackRecord.mOps.get(size), sparseArray, true, z);
            }
        }
    }

    private static void callSharedElementStartEnd(Fragment fragment, Fragment fragment2, boolean z, ArrayMap<String, View> arrayMap, boolean z2) {
        SharedElementCallback enterTransitionCallback = z ? fragment2.getEnterTransitionCallback() : fragment.getEnterTransitionCallback();
        if (enterTransitionCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            int size = arrayMap == null ? 0 : arrayMap.size();
            while (i < size) {
                arrayList2.add(arrayMap.keyAt(i));
                arrayList.add(arrayMap.valueAt(i));
                i++;
            }
            if (z2) {
                enterTransitionCallback.onSharedElementStart(arrayList2, arrayList, null);
            } else {
                enterTransitionCallback.onSharedElementEnd(arrayList2, arrayList, null);
            }
        }
    }

    private static ArrayMap<String, View> captureInSharedElements(ArrayMap<String, String> arrayMap, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        Fragment fragment = fragmentContainerTransition.lastIn;
        View view = fragment.getView();
        if (arrayMap.isEmpty() || obj == null || view == null) {
            arrayMap.clear();
            return null;
        }
        SharedElementCallback exitTransitionCallback;
        Collection collection;
        ArrayMap arrayMap2 = new ArrayMap();
        FragmentTransitionCompat21.findNamedViews(arrayMap2, view);
        BackStackRecord backStackRecord = fragmentContainerTransition.lastInTransaction;
        if (fragmentContainerTransition.lastInIsPop) {
            exitTransitionCallback = fragment.getExitTransitionCallback();
            collection = backStackRecord.mSharedElementSourceNames;
        } else {
            exitTransitionCallback = fragment.getEnterTransitionCallback();
            collection = backStackRecord.mSharedElementTargetNames;
        }
        if (collection != null) {
            arrayMap2.retainAll(collection);
        }
        if (exitTransitionCallback != null) {
            exitTransitionCallback.onMapSharedElements(collection, arrayMap2);
            for (int size = collection.size() - 1; size >= 0; size--) {
                String str = (String) collection.get(size);
                View view2 = (View) arrayMap2.get(str);
                if (view2 == null) {
                    str = findKeyForValue(arrayMap, str);
                    if (str != null) {
                        arrayMap.remove(str);
                    }
                } else if (!str.equals(ViewCompat.getTransitionName(view2))) {
                    str = findKeyForValue(arrayMap, str);
                    if (str != null) {
                        arrayMap.put(str, ViewCompat.getTransitionName(view2));
                    }
                }
            }
        } else {
            retainValues(arrayMap, arrayMap2);
        }
        return arrayMap2;
    }

    private static ArrayMap<String, View> captureOutSharedElements(ArrayMap<String, String> arrayMap, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        if (arrayMap.isEmpty() || obj == null) {
            arrayMap.clear();
            return null;
        }
        SharedElementCallback enterTransitionCallback;
        Collection collection;
        Fragment fragment = fragmentContainerTransition.firstOut;
        ArrayMap arrayMap2 = new ArrayMap();
        FragmentTransitionCompat21.findNamedViews(arrayMap2, fragment.getView());
        BackStackRecord backStackRecord = fragmentContainerTransition.firstOutTransaction;
        if (fragmentContainerTransition.firstOutIsPop) {
            enterTransitionCallback = fragment.getEnterTransitionCallback();
            collection = backStackRecord.mSharedElementTargetNames;
        } else {
            enterTransitionCallback = fragment.getExitTransitionCallback();
            collection = backStackRecord.mSharedElementSourceNames;
        }
        arrayMap2.retainAll(collection);
        if (enterTransitionCallback != null) {
            enterTransitionCallback.onMapSharedElements(collection, arrayMap2);
            for (int size = collection.size() - 1; size >= 0; size--) {
                String str = (String) collection.get(size);
                View view = (View) arrayMap2.get(str);
                if (view == null) {
                    arrayMap.remove(str);
                } else if (!str.equals(ViewCompat.getTransitionName(view))) {
                    arrayMap.put(ViewCompat.getTransitionName(view), (String) arrayMap.remove(str));
                }
            }
        } else {
            arrayMap.retainAll(arrayMap2.keySet());
        }
        return arrayMap2;
    }

    private static ArrayList<View> configureEnteringExitingViews(Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        View view2 = fragment.getView();
        if (view2 != null) {
            FragmentTransitionCompat21.captureTransitioningViews(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        FragmentTransitionCompat21.addTargets(obj, arrayList2);
        return arrayList2;
    }

    private static Object configureSharedElementsOptimized(ViewGroup viewGroup, View view, ArrayMap<String, String> arrayMap, FragmentContainerTransition fragmentContainerTransition, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Fragment fragment = fragmentContainerTransition.lastIn;
        Fragment fragment2 = fragmentContainerTransition.firstOut;
        if (fragment != null) {
            fragment.getView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = fragmentContainerTransition.lastInIsPop;
        Object sharedElementTransition = arrayMap.isEmpty() ? null : getSharedElementTransition(fragment, fragment2, z);
        ArrayMap captureOutSharedElements = captureOutSharedElements(arrayMap, sharedElementTransition, fragmentContainerTransition);
        ArrayMap captureInSharedElements = captureInSharedElements(arrayMap, sharedElementTransition, fragmentContainerTransition);
        if (arrayMap.isEmpty()) {
            if (captureOutSharedElements != null) {
                captureOutSharedElements.clear();
            }
            if (captureInSharedElements != null) {
                captureInSharedElements.clear();
            }
            sharedElementTransition = null;
        } else {
            addSharedElementsWithMatchingNames(arrayList, captureOutSharedElements, arrayMap.keySet());
            addSharedElementsWithMatchingNames(arrayList2, captureInSharedElements, arrayMap.values());
        }
        if (obj == null && obj2 == null && sharedElementTransition == null) {
            return null;
        }
        Rect rect;
        View view2;
        callSharedElementStartEnd(fragment, fragment2, z, captureOutSharedElements, true);
        if (sharedElementTransition != null) {
            arrayList2.add(view);
            FragmentTransitionCompat21.setSharedElementTargets(sharedElementTransition, view, arrayList);
            setOutEpicenter(sharedElementTransition, obj2, captureOutSharedElements, fragmentContainerTransition.firstOutIsPop, fragmentContainerTransition.firstOutTransaction);
            Rect rect2 = new Rect();
            View inEpicenterView = getInEpicenterView(captureInSharedElements, fragmentContainerTransition, obj, z);
            if (inEpicenterView != null) {
                FragmentTransitionCompat21.setEpicenter(obj, rect2);
            }
            rect = rect2;
            view2 = inEpicenterView;
        } else {
            view2 = null;
            rect = view2;
        }
        final Fragment fragment3 = fragment;
        final Fragment fragment4 = fragment2;
        final boolean z2 = z;
        final ArrayMap arrayMap2 = captureInSharedElements;
        OneShotPreDrawListener.add(viewGroup, new Runnable() {
            public void run() {
                FragmentTransition.callSharedElementStartEnd(fragment3, fragment4, z2, arrayMap2, false);
                if (view2 != null) {
                    FragmentTransitionCompat21.getBoundsOnScreen(view2, rect);
                }
            }
        });
        return sharedElementTransition;
    }

    private static Object configureSharedElementsUnoptimized(ViewGroup viewGroup, View view, ArrayMap<String, String> arrayMap, FragmentContainerTransition fragmentContainerTransition, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        final FragmentContainerTransition fragmentContainerTransition2 = fragmentContainerTransition;
        final ArrayList<View> arrayList3 = arrayList;
        final Object obj3 = obj;
        Object obj4 = obj2;
        final Fragment fragment = fragmentContainerTransition2.lastIn;
        final Fragment fragment2 = fragmentContainerTransition2.firstOut;
        Rect rect = null;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        ArrayMap arrayMap2;
        Object obj5;
        Object obj6;
        final boolean z = fragmentContainerTransition2.lastInIsPop;
        if (arrayMap.isEmpty()) {
            arrayMap2 = arrayMap;
            obj5 = null;
        } else {
            obj5 = getSharedElementTransition(fragment, fragment2, z);
            arrayMap2 = arrayMap;
        }
        ArrayMap captureOutSharedElements = captureOutSharedElements(arrayMap2, obj5, fragmentContainerTransition2);
        if (arrayMap.isEmpty()) {
            obj6 = null;
        } else {
            arrayList3.addAll(captureOutSharedElements.values());
            obj6 = obj5;
        }
        if (obj3 == null && obj4 == null && obj6 == null) {
            return null;
        }
        View view2;
        callSharedElementStartEnd(fragment, fragment2, z, captureOutSharedElements, true);
        if (obj6 != null) {
            rect = new Rect();
            view2 = view;
            FragmentTransitionCompat21.setSharedElementTargets(obj6, view2, arrayList3);
            setOutEpicenter(obj6, obj4, captureOutSharedElements, fragmentContainerTransition2.firstOutIsPop, fragmentContainerTransition2.firstOutTransaction);
            if (obj3 != null) {
                FragmentTransitionCompat21.setEpicenter(obj3, rect);
            }
        } else {
            view2 = view;
        }
        Rect rect2 = rect;
        final ArrayMap arrayMap3 = arrayMap2;
        final Object obj7 = obj6;
        final ArrayList<View> arrayList4 = arrayList2;
        final View view3 = view2;
        final Rect rect3 = rect2;
        OneShotPreDrawListener.add(viewGroup, new Runnable() {
            public void run() {
                ArrayMap access$300 = FragmentTransition.captureInSharedElements(arrayMap3, obj7, fragmentContainerTransition2);
                if (access$300 != null) {
                    arrayList4.addAll(access$300.values());
                    arrayList4.add(view3);
                }
                FragmentTransition.callSharedElementStartEnd(fragment, fragment2, z, access$300, false);
                if (obj7 != null) {
                    FragmentTransitionCompat21.swapSharedElementTargets(obj7, arrayList3, arrayList4);
                    View access$400 = FragmentTransition.getInEpicenterView(access$300, fragmentContainerTransition2, obj3, z);
                    if (access$400 != null) {
                        FragmentTransitionCompat21.getBoundsOnScreen(access$400, rect3);
                    }
                }
            }
        });
        return obj6;
    }

    private static void configureTransitionsOptimized(FragmentManagerImpl fragmentManagerImpl, int i, FragmentContainerTransition fragmentContainerTransition, View view, ArrayMap<String, String> arrayMap) {
        FragmentManagerImpl fragmentManagerImpl2 = fragmentManagerImpl;
        FragmentContainerTransition fragmentContainerTransition2 = fragmentContainerTransition;
        View view2 = view;
        ViewGroup viewGroup = fragmentManagerImpl2.mContainer.onHasView() ? (ViewGroup) fragmentManagerImpl2.mContainer.onFindViewById(i) : null;
        if (viewGroup != null) {
            Object obj;
            Fragment fragment = fragmentContainerTransition2.lastIn;
            Fragment fragment2 = fragmentContainerTransition2.firstOut;
            boolean z = fragmentContainerTransition2.lastInIsPop;
            boolean z2 = fragmentContainerTransition2.firstOutIsPop;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Object enterTransition = getEnterTransition(fragment, z);
            Object exitTransition = getExitTransition(fragment2, z2);
            Object obj2 = exitTransition;
            Object configureSharedElementsOptimized = configureSharedElementsOptimized(viewGroup, view2, arrayMap, fragmentContainerTransition2, arrayList2, arrayList, enterTransition, exitTransition);
            if (enterTransition == null && configureSharedElementsOptimized == null) {
                obj = obj2;
                if (obj == null) {
                    return;
                }
            }
            obj = obj2;
            ArrayList configureEnteringExitingViews = configureEnteringExitingViews(obj, fragment2, arrayList2, view2);
            ArrayList configureEnteringExitingViews2 = configureEnteringExitingViews(enterTransition, fragment, arrayList, view2);
            setViewVisibility(configureEnteringExitingViews2, 4);
            Object mergeTransitions = mergeTransitions(enterTransition, obj, configureSharedElementsOptimized, fragment, z);
            if (mergeTransitions != null) {
                replaceHide(obj, fragment2, configureEnteringExitingViews);
                ArrayList prepareSetNameOverridesOptimized = FragmentTransitionCompat21.prepareSetNameOverridesOptimized(arrayList);
                FragmentTransitionCompat21.scheduleRemoveTargets(mergeTransitions, enterTransition, configureEnteringExitingViews2, obj, configureEnteringExitingViews, configureSharedElementsOptimized, arrayList);
                FragmentTransitionCompat21.beginDelayedTransition(viewGroup, mergeTransitions);
                FragmentTransitionCompat21.setNameOverridesOptimized(viewGroup, arrayList2, arrayList, prepareSetNameOverridesOptimized, arrayMap);
                setViewVisibility(configureEnteringExitingViews2, 0);
                FragmentTransitionCompat21.swapSharedElementTargets(configureSharedElementsOptimized, arrayList2, arrayList);
            }
        }
    }

    private static void configureTransitionsUnoptimized(FragmentManagerImpl fragmentManagerImpl, int i, FragmentContainerTransition fragmentContainerTransition, View view, ArrayMap<String, String> arrayMap) {
        FragmentManagerImpl fragmentManagerImpl2 = fragmentManagerImpl;
        FragmentContainerTransition fragmentContainerTransition2 = fragmentContainerTransition;
        View view2 = view;
        ArrayMap<String, String> arrayMap2 = arrayMap;
        View view3 = fragmentManagerImpl2.mContainer.onHasView() ? (ViewGroup) fragmentManagerImpl2.mContainer.onFindViewById(i) : null;
        if (view3 != null) {
            Object obj;
            Fragment fragment = fragmentContainerTransition2.lastIn;
            Fragment fragment2 = fragmentContainerTransition2.firstOut;
            boolean z = fragmentContainerTransition2.lastInIsPop;
            boolean z2 = fragmentContainerTransition2.firstOutIsPop;
            Object enterTransition = getEnterTransition(fragment, z);
            Object exitTransition = getExitTransition(fragment2, z2);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = arrayList2;
            ArrayList arrayList4 = arrayList;
            Object obj2 = exitTransition;
            exitTransition = configureSharedElementsUnoptimized(view3, view2, arrayMap2, fragmentContainerTransition2, arrayList, arrayList2, enterTransition, exitTransition);
            if (enterTransition == null && exitTransition == null) {
                obj = obj2;
                if (obj == null) {
                    return;
                }
            }
            obj = obj2;
            arrayList4 = configureEnteringExitingViews(obj, fragment2, arrayList4, view2);
            Object obj3 = (arrayList4 == null || arrayList4.isEmpty()) ? null : obj;
            FragmentTransitionCompat21.addTarget(enterTransition, view2);
            Object mergeTransitions = mergeTransitions(enterTransition, obj3, exitTransition, fragment, fragmentContainerTransition2.lastInIsPop);
            if (mergeTransitions != null) {
                ArrayList arrayList5 = new ArrayList();
                FragmentTransitionCompat21.scheduleRemoveTargets(mergeTransitions, enterTransition, arrayList5, obj3, arrayList4, exitTransition, arrayList3);
                Object obj4 = mergeTransitions;
                scheduleTargetChange(view3, fragment, view2, arrayList3, enterTransition, arrayList5, obj3, arrayList4);
                arrayList5 = arrayList3;
                FragmentTransitionCompat21.setNameOverridesUnoptimized(view3, arrayList5, arrayMap2);
                FragmentTransitionCompat21.beginDelayedTransition(view3, obj4);
                FragmentTransitionCompat21.scheduleNameReset(view3, arrayList5, arrayMap2);
            }
        }
    }

    private static FragmentContainerTransition ensureContainer(FragmentContainerTransition fragmentContainerTransition, SparseArray<FragmentContainerTransition> sparseArray, int i) {
        if (fragmentContainerTransition != null) {
            return fragmentContainerTransition;
        }
        fragmentContainerTransition = new FragmentContainerTransition();
        sparseArray.put(i, fragmentContainerTransition);
        return fragmentContainerTransition;
    }

    private static String findKeyForValue(ArrayMap<String, String> arrayMap, String str) {
        int size = arrayMap.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(arrayMap.valueAt(i))) {
                return (String) arrayMap.keyAt(i);
            }
        }
        return null;
    }

    private static Object getEnterTransition(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return FragmentTransitionCompat21.cloneTransition(z ? fragment.getReenterTransition() : fragment.getEnterTransition());
    }

    private static Object getExitTransition(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return FragmentTransitionCompat21.cloneTransition(z ? fragment.getReturnTransition() : fragment.getExitTransition());
    }

    private static View getInEpicenterView(ArrayMap<String, View> arrayMap, FragmentContainerTransition fragmentContainerTransition, Object obj, boolean z) {
        BackStackRecord backStackRecord = fragmentContainerTransition.lastInTransaction;
        if (obj == null || arrayMap == null || backStackRecord.mSharedElementSourceNames == null || backStackRecord.mSharedElementSourceNames.isEmpty()) {
            return null;
        }
        return (View) arrayMap.get(z ? (String) backStackRecord.mSharedElementSourceNames.get(0) : (String) backStackRecord.mSharedElementTargetNames.get(0));
    }

    private static Object getSharedElementTransition(Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return FragmentTransitionCompat21.wrapTransitionInSet(FragmentTransitionCompat21.cloneTransition(z ? fragment2.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition()));
    }

    private static Object mergeTransitions(Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean allowReturnTransitionOverlap = (obj == null || obj2 == null || fragment == null) ? true : z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        return allowReturnTransitionOverlap ? FragmentTransitionCompat21.mergeTransitionsTogether(obj2, obj, obj3) : FragmentTransitionCompat21.mergeTransitionsInSequence(obj2, obj, obj3);
    }

    private static void replaceHide(Object obj, Fragment fragment, final ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            FragmentTransitionCompat21.scheduleHideFragmentView(obj, fragment.getView(), arrayList);
            OneShotPreDrawListener.add(fragment.mContainer, new Runnable() {
                public void run() {
                    FragmentTransition.setViewVisibility(arrayList, 4);
                }
            });
        }
    }

    private static void retainValues(ArrayMap<String, String> arrayMap, ArrayMap<String, View> arrayMap2) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            if (!arrayMap2.containsKey((String) arrayMap.valueAt(size))) {
                arrayMap.removeAt(size);
            }
        }
    }

    private static void scheduleTargetChange(ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        final Object obj3 = obj;
        final View view2 = view;
        final Fragment fragment2 = fragment;
        final ArrayList<View> arrayList4 = arrayList;
        final ArrayList<View> arrayList5 = arrayList2;
        final ArrayList<View> arrayList6 = arrayList3;
        final Object obj4 = obj2;
        OneShotPreDrawListener.add(viewGroup, new Runnable() {
            public void run() {
                if (obj3 != null) {
                    FragmentTransitionCompat21.removeTarget(obj3, view2);
                    arrayList5.addAll(FragmentTransition.configureEnteringExitingViews(obj3, fragment2, arrayList4, view2));
                }
                if (arrayList6 != null) {
                    if (obj4 != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(view2);
                        FragmentTransitionCompat21.replaceTargets(obj4, arrayList6, arrayList);
                    }
                    arrayList6.clear();
                    arrayList6.add(view2);
                }
            }
        });
    }

    private static void setOutEpicenter(Object obj, Object obj2, ArrayMap<String, View> arrayMap, boolean z, BackStackRecord backStackRecord) {
        if (backStackRecord.mSharedElementSourceNames != null && !backStackRecord.mSharedElementSourceNames.isEmpty()) {
            View view = (View) arrayMap.get(z ? (String) backStackRecord.mSharedElementTargetNames.get(0) : (String) backStackRecord.mSharedElementSourceNames.get(0));
            FragmentTransitionCompat21.setEpicenter(obj, view);
            if (obj2 != null) {
                FragmentTransitionCompat21.setEpicenter(obj2, view);
            }
        }
    }

    private static void setViewVisibility(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((View) arrayList.get(size)).setVisibility(i);
            }
        }
    }

    static void startTransitions(FragmentManagerImpl fragmentManagerImpl, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (fragmentManagerImpl.mCurState >= 1 && VERSION.SDK_INT >= 21) {
            SparseArray sparseArray = new SparseArray();
            for (int i3 = i; i3 < i2; i3++) {
                BackStackRecord backStackRecord = (BackStackRecord) arrayList.get(i3);
                if (((Boolean) arrayList2.get(i3)).booleanValue()) {
                    calculatePopFragments(backStackRecord, sparseArray, z);
                } else {
                    calculateFragments(backStackRecord, sparseArray, z);
                }
            }
            if (sparseArray.size() != 0) {
                View view = new View(fragmentManagerImpl.mHost.getContext());
                int size = sparseArray.size();
                for (int i4 = 0; i4 < size; i4++) {
                    int keyAt = sparseArray.keyAt(i4);
                    ArrayMap calculateNameOverrides = calculateNameOverrides(keyAt, arrayList, arrayList2, i, i2);
                    FragmentContainerTransition fragmentContainerTransition = (FragmentContainerTransition) sparseArray.valueAt(i4);
                    if (z) {
                        configureTransitionsOptimized(fragmentManagerImpl, keyAt, fragmentContainerTransition, view, calculateNameOverrides);
                    } else {
                        configureTransitionsUnoptimized(fragmentManagerImpl, keyAt, fragmentContainerTransition, view, calculateNameOverrides);
                    }
                }
            }
        }
    }
}
