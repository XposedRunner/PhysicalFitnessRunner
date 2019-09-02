package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.RequiresApi;
import android.support.transition.TransitionPort.TransitionListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

@TargetApi(14)
@RequiresApi(14)
class ChangeBoundsPort extends TransitionPort {
    private static final String LOG_TAG = "ChangeBounds";
    private static final String PROPNAME_BOUNDS = "android:changeBounds:bounds";
    private static final String PROPNAME_PARENT = "android:changeBounds:parent";
    private static final String PROPNAME_WINDOW_X = "android:changeBounds:windowX";
    private static final String PROPNAME_WINDOW_Y = "android:changeBounds:windowY";
    private static RectEvaluator sRectEvaluator = new RectEvaluator();
    private static final String[] sTransitionProperties = new String[]{PROPNAME_BOUNDS, PROPNAME_PARENT, PROPNAME_WINDOW_X, PROPNAME_WINDOW_Y};
    boolean mReparent = false;
    boolean mResizeClip = false;
    int[] tempLocation = new int[2];

    ChangeBoundsPort() {
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        transitionValues.values.put(PROPNAME_BOUNDS, new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        transitionValues.values.put(PROPNAME_PARENT, transitionValues.view.getParent());
        transitionValues.view.getLocationInWindow(this.tempLocation);
        transitionValues.values.put(PROPNAME_WINDOW_X, Integer.valueOf(this.tempLocation[0]));
        transitionValues.values.put(PROPNAME_WINDOW_Y, Integer.valueOf(this.tempLocation[1]));
    }

    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        final ViewGroup viewGroup2 = viewGroup;
        TransitionValues transitionValues3 = transitionValues;
        TransitionValues transitionValues4 = transitionValues2;
        if (transitionValues3 == null || transitionValues4 == null) {
            return null;
        }
        ViewGroup viewGroup3 = (ViewGroup) transitionValues3.values.get(PROPNAME_PARENT);
        ViewGroup viewGroup4 = (ViewGroup) transitionValues4.values.get(PROPNAME_PARENT);
        if (viewGroup3 == null || viewGroup4 == null) {
            return null;
        }
        final View view = transitionValues4.view;
        int i = 0;
        int i2 = (viewGroup3 == viewGroup4 || viewGroup3.getId() == viewGroup4.getId()) ? 1 : 0;
        int intValue;
        int intValue2;
        int intValue3;
        Rect rect;
        if (this.mReparent && i2 == 0) {
            i2 = ((Integer) transitionValues3.values.get(PROPNAME_WINDOW_X)).intValue();
            intValue = ((Integer) transitionValues3.values.get(PROPNAME_WINDOW_Y)).intValue();
            intValue2 = ((Integer) transitionValues4.values.get(PROPNAME_WINDOW_X)).intValue();
            intValue3 = ((Integer) transitionValues4.values.get(PROPNAME_WINDOW_Y)).intValue();
            if (!(i2 == intValue2 && intValue == intValue3)) {
                viewGroup2.getLocationInWindow(this.tempLocation);
                Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.ARGB_8888);
                view.draw(new Canvas(createBitmap));
                final BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
                view.setVisibility(4);
                ViewOverlay.createFrom(viewGroup).add(bitmapDrawable);
                Rect rect2 = new Rect(i2 - this.tempLocation[0], intValue - this.tempLocation[1], (i2 - this.tempLocation[0]) + view.getWidth(), (intValue - this.tempLocation[1]) + view.getHeight());
                rect = new Rect(intValue2 - this.tempLocation[0], intValue3 - this.tempLocation[1], (intValue2 - this.tempLocation[0]) + view.getWidth(), (intValue3 - this.tempLocation[1]) + view.getHeight());
                ObjectAnimator ofObject = ObjectAnimator.ofObject(bitmapDrawable, "bounds", sRectEvaluator, new Object[]{rect2, rect});
                ofObject.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        ViewOverlay.createFrom(viewGroup2).remove(bitmapDrawable);
                        view.setVisibility(0);
                    }
                });
                return ofObject;
            }
        }
        Rect rect3 = (Rect) transitionValues3.values.get(PROPNAME_BOUNDS);
        rect = (Rect) transitionValues4.values.get(PROPNAME_BOUNDS);
        intValue3 = rect3.left;
        i2 = rect.left;
        intValue2 = rect3.top;
        int i3 = rect.top;
        int i4 = rect3.right;
        int i5 = rect.right;
        int i6 = rect3.bottom;
        intValue = rect.bottom;
        int i7 = i4 - intValue3;
        int i8 = i6 - intValue2;
        int i9 = i5 - i2;
        int i10 = intValue - i3;
        if (!(i7 == 0 || i8 == 0 || i9 == 0 || i10 == 0)) {
            int i11 = intValue3 != i2 ? 1 : 0;
            if (intValue2 != i3) {
                i11++;
            }
            if (i4 != i5) {
                i11++;
            }
            if (i6 != intValue) {
                i11++;
            }
            i = i11;
        }
        if (i > 0) {
            int i12;
            ObjectAnimator ofPropertyValuesHolder;
            ViewGroup viewGroup5;
            if (this.mResizeClip) {
                int i13;
                if (i7 != i9) {
                    view.setRight(Math.max(i7, i9) + i2);
                }
                if (i8 != i10) {
                    view.setBottom(Math.max(i8, i10) + i3);
                }
                if (intValue3 != i2) {
                    view.setTranslationX((float) (intValue3 - i2));
                }
                if (intValue2 != i3) {
                    view.setTranslationY((float) (intValue2 - i3));
                }
                float f = (float) (i2 - intValue3);
                float f2 = (float) (i3 - intValue2);
                intValue3 = i9 - i7;
                i2 = i10 - i8;
                i = f != 0.0f ? 1 : 0;
                if (f2 != 0.0f) {
                    i++;
                }
                if (!(intValue3 == 0 && i2 == 0)) {
                    i++;
                }
                PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[i];
                if (f != 0.0f) {
                    i13 = 2;
                    r11 = new float[2];
                    i12 = 0;
                    r11[0] = view.getTranslationX();
                    i4 = 1;
                    r11[1] = 0.0f;
                    propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat("translationX", r11);
                    i6 = 1;
                } else {
                    i13 = 2;
                    i4 = 1;
                    i12 = 0;
                    i6 = 0;
                }
                if (f2 != 0.0f) {
                    float[] fArr = new float[i13];
                    fArr[i12] = view.getTranslationY();
                    fArr[i4] = 0.0f;
                    propertyValuesHolderArr[i6] = PropertyValuesHolder.ofFloat("translationY", fArr);
                }
                if (!(intValue3 == 0 && i2 == 0)) {
                    rect3 = new Rect(0, 0, i7, i8);
                    rect3 = new Rect(0, 0, i9, i10);
                }
                ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderArr);
                if (view.getParent() instanceof ViewGroup) {
                    viewGroup5 = (ViewGroup) view.getParent();
                    addListener(new TransitionListenerAdapter() {
                        boolean mCanceled = false;

                        public void onTransitionCancel(TransitionPort transitionPort) {
                            this.mCanceled = true;
                        }

                        public void onTransitionEnd(TransitionPort transitionPort) {
                            boolean z = this.mCanceled;
                        }

                        public void onTransitionPause(TransitionPort transitionPort) {
                        }

                        public void onTransitionResume(TransitionPort transitionPort) {
                        }
                    });
                }
                ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                    }
                });
                return ofPropertyValuesHolder;
            }
            int[] iArr;
            int i14;
            PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[i];
            if (intValue3 != i2) {
                view.setLeft(intValue3);
            }
            if (intValue2 != i3) {
                view.setTop(intValue2);
            }
            if (i4 != i5) {
                view.setRight(i4);
            }
            if (i6 != intValue) {
                view.setBottom(i6);
            }
            if (intValue3 != i2) {
                i10 = 2;
                iArr = new int[2];
                i12 = 0;
                iArr[0] = intValue3;
                i14 = 1;
                iArr[1] = i2;
                propertyValuesHolderArr2[0] = PropertyValuesHolder.ofInt("left", iArr);
                intValue3 = 1;
            } else {
                i10 = 2;
                i14 = 1;
                i12 = 0;
                intValue3 = 0;
            }
            if (intValue2 != i3) {
                i2 = intValue3 + 1;
                iArr = new int[i10];
                iArr[i12] = intValue2;
                iArr[i14] = i3;
                propertyValuesHolderArr2[intValue3] = PropertyValuesHolder.ofInt("top", iArr);
                intValue3 = i2;
            }
            if (i4 != i5) {
                i2 = intValue3 + 1;
                int[] iArr2 = new int[i10];
                iArr2[i12] = i4;
                iArr2[i14] = i5;
                propertyValuesHolderArr2[intValue3] = PropertyValuesHolder.ofInt("right", iArr2);
                intValue3 = i2;
            }
            if (i6 != intValue) {
                int[] iArr3 = new int[i10];
                iArr3[i12] = i6;
                iArr3[i14] = intValue;
                propertyValuesHolderArr2[intValue3] = PropertyValuesHolder.ofInt("bottom", iArr3);
            }
            ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderArr2);
            if (view.getParent() instanceof ViewGroup) {
                viewGroup5 = (ViewGroup) view.getParent();
                addListener(new TransitionListenerAdapter() {
                    boolean mCanceled = false;

                    public void onTransitionCancel(TransitionPort transitionPort) {
                        this.mCanceled = true;
                    }

                    public void onTransitionEnd(TransitionPort transitionPort) {
                        boolean z = this.mCanceled;
                    }

                    public void onTransitionPause(TransitionPort transitionPort) {
                    }

                    public void onTransitionResume(TransitionPort transitionPort) {
                    }
                });
            }
            return ofPropertyValuesHolder;
        }
        return null;
    }

    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public void setReparent(boolean z) {
        this.mReparent = z;
    }

    public void setResizeClip(boolean z) {
        this.mResizeClip = z;
    }
}
