package com.amap.api.maps.model.particle;

import com.autonavi.amap.mapcore.AMapNativeParticleSystem;
import java.util.Random;

public class RandomColorBetWeenTwoConstants extends ColorGenerate {
    private float a;
    private float a1;
    private float b;
    private float b1;
    private float[] color = new float[]{1.0f, 1.0f, 1.0f, 1.0f};
    private float g;
    private float g1;
    private float r;
    private float r1;
    private Random random = new Random();

    public RandomColorBetWeenTwoConstants(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        this.r = f / 255.0f;
        this.g = f2 / 255.0f;
        this.b = f3 / 255.0f;
        this.a = f4 / 255.0f;
        this.r1 = f5 / 255.0f;
        this.g1 = f6 / 255.0f;
        this.b1 = f7 / 255.0f;
        this.a1 = f8 / 255.0f;
        createNativeInstace();
        this.type = 0;
    }

    public void createNativeInstace() {
        try {
            this.nativeInstance = AMapNativeParticleSystem.nativeCreateRandomColorBetWeenTwoConstants(this.r, this.g, this.b, this.a, this.r1, this.g1, this.b1, this.a1);
        } catch (Throwable unused) {
        }
    }

    public float[] getColor() {
        this.color[0] = (this.random.nextFloat() * (this.r1 - this.r)) + this.r;
        this.color[1] = (this.random.nextFloat() * (this.g1 - this.g)) + this.g;
        this.color[2] = (this.random.nextFloat() * (this.b1 - this.b)) + this.b;
        this.color[3] = (this.random.nextFloat() * (this.a1 - this.a)) + this.a;
        return this.color;
    }
}
