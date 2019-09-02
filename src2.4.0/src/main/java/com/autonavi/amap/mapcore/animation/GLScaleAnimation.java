package com.autonavi.amap.mapcore.animation;

public class GLScaleAnimation extends GLAnimation {
    private float mFromX;
    private float mFromY;
    private float mPivotX = 0.0f;
    private float mPivotY = 0.0f;
    private float mToX;
    private float mToY;

    public GLScaleAnimation(float f, float f2, float f3, float f4) {
        this.mFromX = f;
        this.mToX = f2;
        this.mFromY = f3;
        this.mToY = f4;
    }

    /* Access modifiers changed, original: protected */
    public void applyTransformation(float f, GLTransformation gLTransformation) {
        float f2 = 1.0f;
        float f3 = (this.mFromX == 1.0f && this.mToX == 1.0f) ? 1.0f : this.mFromX + ((this.mToX - this.mFromX) * f);
        if (!(this.mFromY == 1.0f && this.mToY == 1.0f)) {
            f2 = this.mFromY + ((this.mToY - this.mFromY) * f);
        }
        if (this.mPivotX == 0.0f && this.mPivotY == 0.0f) {
            gLTransformation.scaleX = (double) f3;
            gLTransformation.scaleY = (double) f2;
            return;
        }
        gLTransformation.scaleX = (double) f3;
        gLTransformation.scaleY = (double) f2;
    }
}
