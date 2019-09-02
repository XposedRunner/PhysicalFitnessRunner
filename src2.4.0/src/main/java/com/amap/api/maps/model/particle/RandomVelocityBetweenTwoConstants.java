package com.amap.api.maps.model.particle;

import com.autonavi.amap.mapcore.AMapNativeParticleSystem;
import java.util.Random;

public class RandomVelocityBetweenTwoConstants extends VelocityGenerate {
    private Random random = new Random();
    private float x1;
    private float x2;
    private float y1;
    private float y2;
    private float z1;
    private float z2;

    public RandomVelocityBetweenTwoConstants(float f, float f2, float f3, float f4, float f5, float f6) {
        this.x1 = f;
        this.y1 = f2;
        this.z1 = f3;
        this.x2 = f4;
        this.y2 = f5;
        this.z2 = f6;
        createNativeInstace();
        this.type = 0;
    }

    public void createNativeInstace() {
        try {
            this.nativeInstance = AMapNativeParticleSystem.nativeCreateRandomVelocityBetweenTwoConstants(this.x1, this.y1, this.z1, this.x2, this.y2, this.z2);
        } catch (Throwable unused) {
        }
    }

    public float getX() {
        return (this.random.nextFloat() * (this.x2 - this.x1)) + this.x1;
    }

    public float getY() {
        return (this.random.nextFloat() * (this.y2 - this.y1)) + this.y1;
    }

    public float getZ() {
        return (this.random.nextFloat() * (this.z2 - this.z1)) + this.z1;
    }
}
