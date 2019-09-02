package com.autonavi.ae.gmap.glanimation;

public abstract class AbstractAdglAnimationParam {
    protected float factor;
    protected boolean hasCheckedParam;
    protected boolean hasFromValue;
    protected boolean hasToValue;
    protected int interpolationType;
    protected float mult;
    protected boolean needToCaculate;
    protected float normalizedTime;

    public AbstractAdglAnimationParam() {
        this.hasCheckedParam = false;
        this.needToCaculate = false;
        this.interpolationType = 0;
        this.factor = 1.0f;
        this.hasCheckedParam = false;
        this.needToCaculate = false;
        this.hasFromValue = false;
        this.hasToValue = false;
    }

    static float bounce(float f) {
        return (f * f) * 8.0f;
    }

    public abstract void checkParam();

    public float getCurMult() {
        return this.mult;
    }

    public int getInterpolatorType() {
        return this.interpolationType;
    }

    public boolean needToCaculate() {
        if (!this.hasCheckedParam) {
            checkParam();
        }
        return this.hasCheckedParam && this.needToCaculate;
    }

    public void reset() {
        this.hasCheckedParam = false;
        this.needToCaculate = false;
        this.interpolationType = 0;
        this.factor = 1.0f;
        this.hasCheckedParam = false;
        this.needToCaculate = false;
        this.hasFromValue = false;
        this.hasToValue = false;
    }

    public void setInterpolatorType(int i, float f) {
        this.interpolationType = i;
        this.factor = f;
    }

    public void setNormalizedTime(float r8) {
        /*
        r7 = this;
        r7.normalizedTime = r8;
        r0 = r7.interpolationType;
        r1 = 0;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r3 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        switch(r0) {
            case 0: goto L_0x00c9;
            case 1: goto L_0x00bf;
            case 2: goto L_0x00a4;
            case 3: goto L_0x0090;
            case 4: goto L_0x004a;
            case 5: goto L_0x003e;
            case 6: goto L_0x000f;
            default: goto L_0x000c;
        };
    L_0x000c:
        r8 = r1;
        goto L_0x00c9;
    L_0x000f:
        r0 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1));
        if (r0 >= 0) goto L_0x0014;
    L_0x0013:
        goto L_0x000c;
    L_0x0014:
        r0 = 1048576000; // 0x3e800000 float:0.25 double:5.180653787E-315;
        r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1));
        r4 = 1082130432; // 0x40800000 float:4.0 double:5.34643471E-315;
        if (r0 >= 0) goto L_0x001f;
    L_0x001c:
        r8 = r8 * r4;
        goto L_0x00c9;
    L_0x001f:
        r0 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1));
        if (r0 >= 0) goto L_0x002a;
    L_0x0025:
        r4 = r4 * r8;
        r8 = r2 - r4;
        goto L_0x00c9;
    L_0x002a:
        r0 = 1061158912; // 0x3f400000 float:0.75 double:5.24282163E-315;
        r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1));
        if (r0 >= 0) goto L_0x0035;
    L_0x0030:
        r4 = r4 * r8;
        r8 = r4 - r2;
        goto L_0x00c9;
    L_0x0035:
        r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1));
        if (r0 > 0) goto L_0x000c;
    L_0x0039:
        r8 = r8 * r4;
        r8 = r4 - r8;
        goto L_0x00c9;
    L_0x003e:
        r8 = r8 - r3;
        r0 = r8 * r8;
        r1 = 1077936128; // 0x40400000 float:3.0 double:5.325712093E-315;
        r1 = r1 * r8;
        r1 = r1 + r2;
        r0 = r0 * r1;
        r8 = r0 + r3;
        goto L_0x00c9;
    L_0x004a:
        r0 = 1066381659; // 0x3f8fb15b float:1.1226 double:5.26862543E-315;
        r8 = r8 * r0;
        r0 = 1052048884; // 0x3eb4fdf4 float:0.3535 double:5.197812113E-315;
        r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1));
        if (r0 >= 0) goto L_0x005b;
    L_0x0055:
        r8 = bounce(r8);
        goto L_0x00c9;
    L_0x005b:
        r0 = 1061004562; // 0x3f3da512 float:0.7408 double:5.24205904E-315;
        r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1));
        if (r0 >= 0) goto L_0x006f;
    L_0x0062:
        r0 = 1057756325; // 0x3f0c14a5 float:0.54719 double:5.22601062E-315;
        r8 = r8 - r0;
        r8 = bounce(r8);
        r0 = 1060320051; // 0x3f333333 float:0.7 double:5.23867711E-315;
        r8 = r8 + r0;
        goto L_0x00c9;
    L_0x006f:
        r0 = 1064755947; // 0x3f76e2eb float:0.9644 double:5.260593346E-315;
        r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1));
        if (r0 >= 0) goto L_0x0083;
    L_0x0076:
        r0 = 1062880254; // 0x3f5a43fe float:0.8526 double:5.25132619E-315;
        r8 = r8 - r0;
        r8 = bounce(r8);
        r0 = 1063675494; // 0x3f666666 float:0.9 double:5.2552552E-315;
        r8 = r8 + r0;
        goto L_0x00c9;
    L_0x0083:
        r0 = 1065718120; // 0x3f859168 float:1.0435 double:5.26534711E-315;
        r8 = r8 - r0;
        r8 = bounce(r8);
        r0 = 1064514355; // 0x3f733333 float:0.95 double:5.259399723E-315;
        r8 = r8 + r0;
        goto L_0x00c9;
    L_0x0090:
        r8 = r8 + r3;
        r0 = (double) r8;
        r2 = 4614256656552045848; // 0x400921fb54442d18 float:3.37028055E12 double:3.141592653589793;
        r0 = r0 * r2;
        r0 = java.lang.Math.cos(r0);
        r2 = 4611686018427387904; // 0x4000000000000000 float:0.0 double:2.0;
        r0 = r0 / r2;
        r2 = 4602678819172646912; // 0x3fe0000000000000 float:0.0 double:0.5;
        r0 = r0 + r2;
        r8 = (float) r0;
        goto L_0x00c9;
    L_0x00a4:
        r0 = r7.factor;
        r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1));
        if (r0 != 0) goto L_0x00b0;
    L_0x00aa:
        r8 = r3 - r8;
        r8 = r8 * r8;
        r8 = r3 - r8;
        goto L_0x00c9;
    L_0x00b0:
        r0 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r3 = r3 - r8;
        r3 = (double) r3;
        r8 = r7.factor;
        r2 = r2 * r8;
        r5 = (double) r2;
        r2 = java.lang.Math.pow(r3, r5);
        r0 = r0 - r2;
        r8 = (float) r0;
        goto L_0x00c9;
    L_0x00bf:
        r0 = (double) r8;
        r8 = r7.factor;
        r2 = r2 * r8;
        r2 = (double) r2;
        r0 = java.lang.Math.pow(r0, r2);
        r8 = (float) r0;
    L_0x00c9:
        r7.mult = r8;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.ae.gmap.glanimation.AbstractAdglAnimationParam.setNormalizedTime(float):void");
    }
}
