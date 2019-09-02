package com.amap.api.maps.model.particle;

import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;

public class ParticleOverlayOptionsFactory {
    public static final int PARTICLE_TYPE_HAZE = 3;
    public static final int PARTICLE_TYPE_RAIN = 1;
    public static final int PARTICLE_TYPE_SNOWY = 2;
    public static final int PARTICLE_TYPE_SUNNY = 0;

    private static List<ParticleOverlayOptions> a() {
        ArrayList arrayList = new ArrayList();
        ParticleOverlayOptions particleOverlayOptions = new ParticleOverlayOptions();
        particleOverlayOptions.setLoop(false);
        particleOverlayOptions.setMaxParticles(1);
        particleOverlayOptions.setDuration(10000);
        particleOverlayOptions.setParticleEmissionModule(new ParticleEmissionModule(1, (int) 10000));
        particleOverlayOptions.setParticleShapeModule(new SinglePointParticleShape(0.5f, 0.5f, 0.0f, true));
        particleOverlayOptions.setParticleLifeTime(10000);
        particleOverlayOptions.setParticleStartSpeed(new RandomVelocityBetweenTwoConstants(-10.0f, -0.0f, -0.0f, -20.0f, 0.0f, 0.0f));
        BitmapDescriptor fromAsset = BitmapDescriptorFactory.fromAsset("map_custom/particle/fog.png");
        particleOverlayOptions.icon(fromAsset);
        particleOverlayOptions.setStartParticleSize(fromAsset.getWidth() * 5, fromAsset.getWidth() * 5);
        arrayList.add(particleOverlayOptions);
        ParticleOverlayOptions particleOverlayOptions2 = new ParticleOverlayOptions();
        particleOverlayOptions2.setMaxParticles(1000);
        particleOverlayOptions2.setDuration(10000);
        particleOverlayOptions2.setParticleEmissionModule(new ParticleEmissionModule(30, (int) 2500));
        particleOverlayOptions2.setLoop(true);
        particleOverlayOptions2.setParticleShapeModule(new RectParticleShape(0.5f, 0.5f, 1.0f, 1.0f, true));
        particleOverlayOptions2.setParticleLifeTime(10000);
        particleOverlayOptions2.setParticleStartSpeed(new RandomVelocityBetweenTwoConstants(-100.0f, -100.0f, -1.0f, -200.0f, 100.0f, 1.0f));
        BitmapDescriptor fromAsset2 = BitmapDescriptorFactory.fromAsset("map_custom/particle/haze.png");
        particleOverlayOptions2.icon(fromAsset2);
        particleOverlayOptions2.setStartParticleSize(fromAsset2.getWidth(), fromAsset2.getHeight());
        particleOverlayOptions2.setParticleStartColor(new RandomColorBetWeenTwoConstants(255.0f, 255.0f, 255.0f, 102.0f, 255.0f, 255.0f, 255.0f, 255.0f));
        arrayList.add(particleOverlayOptions2);
        return arrayList;
    }

    private static ParticleOverlayOptions b() {
        ParticleOverlayOptions particleOverlayOptions = new ParticleOverlayOptions();
        particleOverlayOptions.setMaxParticles(1000);
        particleOverlayOptions.setDuration(5000);
        particleOverlayOptions.setParticleEmissionModule(new ParticleEmissionModule(20, 1000));
        particleOverlayOptions.setLoop(true);
        particleOverlayOptions.setParticleShapeModule(new RectParticleShape(0.0f, 0.0f, 1.0f, 0.1f, true));
        particleOverlayOptions.setParticleLifeTime(10000);
        particleOverlayOptions.setParticleStartSpeed(new RandomVelocityBetweenTwoConstants(-50.0f, 100.0f, 0.0f, 50.0f, 200.0f, 0.0f));
        BitmapDescriptor fromAsset = BitmapDescriptorFactory.fromAsset("map_custom/particle/snow.png");
        particleOverlayOptions.icon(fromAsset);
        particleOverlayOptions.setStartParticleSize(fromAsset.getWidth(), fromAsset.getHeight());
        return particleOverlayOptions;
    }

    private static ParticleOverlayOptions c() {
        ParticleOverlayOptions particleOverlayOptions = new ParticleOverlayOptions();
        particleOverlayOptions.setMaxParticles(1000);
        particleOverlayOptions.setDuration(5000);
        particleOverlayOptions.setParticleEmissionModule(new ParticleEmissionModule(100, 1000));
        particleOverlayOptions.setLoop(true);
        particleOverlayOptions.setParticleLifeTime(5000);
        particleOverlayOptions.setParticleStartSpeed(new RandomVelocityBetweenTwoConstants(10.0f, 1000.0f, 0.0f, 100.0f, 1000.0f, 0.0f));
        particleOverlayOptions.setParticleShapeModule(new RectParticleShape(0.0f, 0.0f, 1.0f, 0.1f, true));
        BitmapDescriptor fromAsset = BitmapDescriptorFactory.fromAsset("map_custom/particle/rain.png");
        particleOverlayOptions.icon(fromAsset);
        particleOverlayOptions.setStartParticleSize(fromAsset.getWidth() * 2, fromAsset.getHeight() * 2);
        return particleOverlayOptions;
    }

    private static List<ParticleOverlayOptions> d() {
        ArrayList arrayList = new ArrayList();
        ParticleOverlayOptions particleOverlayOptions = new ParticleOverlayOptions();
        particleOverlayOptions.setMaxParticles(1);
        particleOverlayOptions.setDuration(10000);
        int i = (int) 2500;
        particleOverlayOptions.setParticleEmissionModule(new ParticleEmissionModule(1, i));
        particleOverlayOptions.setLoop(true);
        particleOverlayOptions.setParticleShapeModule(new SinglePointParticleShape(0.0f, 0.0f, 0.0f));
        particleOverlayOptions.setParticleLifeTime(10000);
        particleOverlayOptions.setParticleStartSpeed(new RandomVelocityBetweenTwoConstants(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));
        particleOverlayOptions.setParticleOverLifeModule(new ParticleOverLifeModule());
        particleOverlayOptions.icon(BitmapDescriptorFactory.fromAsset("map_custom/particle/sun_0.png"));
        particleOverlayOptions.setStartParticleSize(1000, 1000);
        arrayList.add(particleOverlayOptions);
        particleOverlayOptions = new ParticleOverlayOptions();
        particleOverlayOptions.setMaxParticles(1);
        particleOverlayOptions.setDuration(10000);
        particleOverlayOptions.setParticleEmissionModule(new ParticleEmissionModule(1, i));
        particleOverlayOptions.setLoop(true);
        particleOverlayOptions.setParticleShapeModule(new SinglePointParticleShape(0.0f, 0.0f, 0.0f));
        particleOverlayOptions.setParticleLifeTime(10000);
        particleOverlayOptions.setParticleStartSpeed(new RandomVelocityBetweenTwoConstants(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));
        ParticleOverLifeModule particleOverLifeModule = new ParticleOverLifeModule();
        particleOverLifeModule.setRotateOverLife(new ConstantRotationOverLife(45.0f));
        particleOverlayOptions.setParticleOverLifeModule(particleOverLifeModule);
        particleOverlayOptions.icon(BitmapDescriptorFactory.fromAsset("map_custom/particle/sun_1.png"));
        particleOverlayOptions.setStartParticleSize(1000, 1000);
        arrayList.add(particleOverlayOptions);
        return arrayList;
    }

    public static List<ParticleOverlayOptions> defaultOptions(int i) {
        ArrayList arrayList = new ArrayList();
        switch (i) {
            case 0:
                arrayList.addAll(d());
                break;
            case 1:
                arrayList.add(c());
                break;
            case 2:
                arrayList.add(b());
                break;
            case 3:
                arrayList.addAll(a());
                break;
        }
        return arrayList;
    }
}
