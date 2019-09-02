package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.support.transition.TransitionPort.TransitionListenerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

@TargetApi(14)
@RequiresApi(14)
class FadePort extends VisibilityPort {
    private static boolean DBG = false;
    public static final int IN = 1;
    private static final String LOG_TAG = "Fade";
    public static final int OUT = 2;
    private static final String PROPNAME_SCREEN_X = "android:fade:screenX";
    private static final String PROPNAME_SCREEN_Y = "android:fade:screenY";
    private int mFadingMode;

    public FadePort() {
        this(3);
    }

    public FadePort(int i) {
        this.mFadingMode = i;
    }

    private void captureValues(TransitionValues transitionValues) {
        int[] iArr = new int[2];
        transitionValues.view.getLocationOnScreen(iArr);
        transitionValues.values.put(PROPNAME_SCREEN_X, Integer.valueOf(iArr[0]));
        transitionValues.values.put(PROPNAME_SCREEN_Y, Integer.valueOf(iArr[1]));
    }

    private Animator createAnimation(View view, float f, float f2, AnimatorListenerAdapter animatorListenerAdapter) {
        if (f == f2) {
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationEnd(null);
            }
            return null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{f, f2});
        if (DBG) {
            String str = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Created animator ");
            stringBuilder.append(ofFloat);
            Log.d(str, stringBuilder.toString());
        }
        if (animatorListenerAdapter != null) {
            ofFloat.addListener(animatorListenerAdapter);
        }
        return ofFloat;
    }

    public void captureStartValues(TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        captureValues(transitionValues);
    }

    public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
        if ((this.mFadingMode & 1) != 1 || transitionValues2 == null) {
            return null;
        }
        final View view = transitionValues2.view;
        if (DBG) {
            Object obj = transitionValues != null ? transitionValues.view : null;
            String str = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fade.onAppear: startView, startVis, endView, endVis = ");
            stringBuilder.append(obj);
            stringBuilder.append(", ");
            stringBuilder.append(i);
            stringBuilder.append(", ");
            stringBuilder.append(view);
            stringBuilder.append(", ");
            stringBuilder.append(i2);
            Log.d(str, stringBuilder.toString());
        }
        view.setAlpha(0.0f);
        addListener(new TransitionListenerAdapter() {
            boolean mCanceled = false;
            float mPausedAlpha;

            public void onTransitionCancel(TransitionPort transitionPort) {
                view.setAlpha(1.0f);
                this.mCanceled = true;
            }

            public void onTransitionEnd(TransitionPort transitionPort) {
                if (!this.mCanceled) {
                    view.setAlpha(1.0f);
                }
            }

            public void onTransitionPause(TransitionPort transitionPort) {
                this.mPausedAlpha = view.getAlpha();
                view.setAlpha(1.0f);
            }

            public void onTransitionResume(TransitionPort transitionPort) {
                view.setAlpha(this.mPausedAlpha);
            }
        });
        return createAnimation(view, 0.0f, 1.0f, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a0  */
    public android.animation.Animator onDisappear(android.view.ViewGroup r11, android.support.transition.TransitionValues r12, int r13, android.support.transition.TransitionValues r14, int r15) {
        /*
        r10 = this;
        r0 = r10.mFadingMode;
        r1 = 2;
        r0 = r0 & r1;
        r2 = 0;
        if (r0 == r1) goto L_0x0008;
    L_0x0007:
        return r2;
    L_0x0008:
        if (r12 == 0) goto L_0x000d;
    L_0x000a:
        r0 = r12.view;
        goto L_0x000e;
    L_0x000d:
        r0 = r2;
    L_0x000e:
        if (r14 == 0) goto L_0x0013;
    L_0x0010:
        r14 = r14.view;
        goto L_0x0014;
    L_0x0013:
        r14 = r2;
    L_0x0014:
        r3 = DBG;
        if (r3 == 0) goto L_0x0046;
    L_0x0018:
        r3 = "Fade";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Fade.onDisappear: startView, startVis, endView, endVis = ";
        r4.append(r5);
        r4.append(r0);
        r5 = ", ";
        r4.append(r5);
        r4.append(r13);
        r13 = ", ";
        r4.append(r13);
        r4.append(r14);
        r13 = ", ";
        r4.append(r13);
        r4.append(r15);
        r13 = r4.toString();
        android.util.Log.d(r3, r13);
    L_0x0046:
        if (r14 == 0) goto L_0x0058;
    L_0x0048:
        r13 = r14.getParent();
        if (r13 != 0) goto L_0x004f;
    L_0x004e:
        goto L_0x0058;
    L_0x004f:
        r13 = 4;
        if (r15 != r13) goto L_0x0053;
    L_0x0052:
        goto L_0x0055;
    L_0x0053:
        if (r0 != r14) goto L_0x0065;
    L_0x0055:
        r6 = r14;
        r8 = r2;
        goto L_0x009a;
    L_0x0058:
        if (r14 == 0) goto L_0x005d;
    L_0x005a:
        r8 = r14;
    L_0x005b:
        r6 = r2;
        goto L_0x009a;
    L_0x005d:
        if (r0 == 0) goto L_0x0097;
    L_0x005f:
        r13 = r0.getParent();
        if (r13 != 0) goto L_0x0067;
    L_0x0065:
        r14 = r0;
        goto L_0x005a;
    L_0x0067:
        r13 = r0.getParent();
        r13 = r13 instanceof android.view.View;
        if (r13 == 0) goto L_0x0097;
    L_0x006f:
        r13 = r0.getParent();
        r13 = r13.getParent();
        if (r13 != 0) goto L_0x0097;
    L_0x0079:
        r13 = r0.getParent();
        r13 = (android.view.View) r13;
        r13 = r13.getId();
        r14 = -1;
        if (r13 == r14) goto L_0x0092;
    L_0x0086:
        r13 = r11.findViewById(r13);
        if (r13 == 0) goto L_0x0092;
    L_0x008c:
        r13 = r10.mCanRemoveViews;
        if (r13 == 0) goto L_0x0092;
    L_0x0090:
        r13 = r0;
        goto L_0x0094;
    L_0x0092:
        r13 = r2;
        r0 = r13;
    L_0x0094:
        r8 = r13;
        r14 = r0;
        goto L_0x005b;
    L_0x0097:
        r14 = r2;
        r6 = r14;
        r8 = r6;
    L_0x009a:
        r13 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0 = 0;
        r3 = 0;
        if (r8 == 0) goto L_0x00ee;
    L_0x00a0:
        r2 = r12.values;
        r4 = "android:fade:screenX";
        r2 = r2.get(r4);
        r2 = (java.lang.Integer) r2;
        r2 = r2.intValue();
        r12 = r12.values;
        r4 = "android:fade:screenY";
        r12 = r12.get(r4);
        r12 = (java.lang.Integer) r12;
        r12 = r12.intValue();
        r1 = new int[r1];
        r11.getLocationOnScreen(r1);
        r3 = r1[r3];
        r2 = r2 - r3;
        r3 = r8.getLeft();
        r2 = r2 - r3;
        android.support.v4.view.ViewCompat.offsetLeftAndRight(r8, r2);
        r2 = 1;
        r1 = r1[r2];
        r12 = r12 - r1;
        r1 = r8.getTop();
        r12 = r12 - r1;
        android.support.v4.view.ViewCompat.offsetTopAndBottom(r8, r12);
        r12 = android.support.transition.ViewGroupOverlay.createFrom(r11);
        r12.add(r8);
        r12 = new android.support.transition.FadePort$2;
        r3 = r12;
        r4 = r10;
        r5 = r14;
        r7 = r15;
        r9 = r11;
        r3.<init>(r5, r6, r7, r8, r9);
        r11 = r10.createAnimation(r14, r13, r0, r12);
        return r11;
    L_0x00ee:
        if (r6 == 0) goto L_0x0102;
    L_0x00f0:
        r6.setVisibility(r3);
        r12 = new android.support.transition.FadePort$3;
        r3 = r12;
        r4 = r10;
        r5 = r14;
        r7 = r15;
        r9 = r11;
        r3.<init>(r5, r6, r7, r8, r9);
        r11 = r10.createAnimation(r14, r13, r0, r12);
        return r11;
    L_0x0102:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.FadePort.onDisappear(android.view.ViewGroup, android.support.transition.TransitionValues, int, android.support.transition.TransitionValues, int):android.animation.Animator");
    }
}
