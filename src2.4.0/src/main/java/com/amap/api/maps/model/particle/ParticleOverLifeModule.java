package com.amap.api.maps.model.particle;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.autonavi.amap.mapcore.AMapNativeParticleSystem;
import com.autonavi.amap.mapcore.AbstractNativeInstance;

public class ParticleOverLifeModule extends AbstractNativeInstance implements Parcelable {
    public static final Creator<ParticleOverLifeModule> CREATOR = new Creator<ParticleOverLifeModule>() {
        /* renamed from: a */
        public ParticleOverLifeModule createFromParcel(Parcel parcel) {
            return new ParticleOverLifeModule(parcel);
        }

        /* renamed from: a */
        public ParticleOverLifeModule[] newArray(int i) {
            return new ParticleOverLifeModule[i];
        }
    };
    private static final int TYPE_COLOR = 3;
    private static final int TYPE_ROTATE = 1;
    private static final int TYPE_SCALE = 2;
    private static final int TYPE_VEL = 0;
    private ColorGenerate colorGenerate;
    private boolean isNeedReloadColorGenerate = false;
    private boolean isNeedReloadRotationOverLife = false;
    private boolean isNeedReloadSizeOverLife = false;
    private boolean isNeedReloadVelocityGenerate = false;
    private VelocityGenerate overLife = null;
    private RotationOverLife rotateOverLife;
    private SizeOverLife sizeOverLife;
    private VelocityGenerate velocityOverLife = null;

    public ParticleOverLifeModule() {
        createNativeInstace();
    }

    protected ParticleOverLifeModule(Parcel parcel) {
        this.nativeInstance = parcel.readLong();
    }

    public void createNativeInstace() {
        try {
            this.nativeInstance = AMapNativeParticleSystem.nativeCreateParticleOverLifeModule();
            if (this.isNeedReloadVelocityGenerate) {
                setVelocityOverLife(this.overLife);
                this.isNeedReloadVelocityGenerate = false;
            }
            if (this.isNeedReloadRotationOverLife) {
                setRotateOverLife(this.rotateOverLife);
                this.isNeedReloadRotationOverLife = false;
            }
            if (this.isNeedReloadSizeOverLife) {
                setSizeOverLife(this.sizeOverLife);
                this.isNeedReloadSizeOverLife = false;
            }
            if (this.isNeedReloadColorGenerate) {
                setColorGenerate(this.colorGenerate);
                this.isNeedReloadColorGenerate = false;
            }
        } catch (Throwable unused) {
        }
    }

    public int describeContents() {
        return 0;
    }

    /* Access modifiers changed, original: protected */
    public void finalize() throws Throwable {
        super.finalize();
        if (this.nativeInstance != 0) {
            AMapNativeParticleSystem.nativeReleaseParticleOverLifeModule(this.nativeInstance);
            this.nativeInstance = 0;
        }
    }

    public void setColorGenerate(ColorGenerate colorGenerate) {
        this.colorGenerate = colorGenerate;
        if (this.nativeInstance == 0) {
            this.isNeedReloadColorGenerate = true;
        } else if (this.colorGenerate != null) {
            if (this.colorGenerate.getNativeInstance() == 0) {
                this.colorGenerate.createNativeInstace();
            }
            AMapNativeParticleSystem.nativeSetOverLifeItem(this.nativeInstance, this.colorGenerate.getNativeInstance(), 3);
        } else {
            AMapNativeParticleSystem.nativeSetOverLifeItem(this.nativeInstance, 0, 3);
        }
    }

    public void setRotateOverLife(RotationOverLife rotationOverLife) {
        this.rotateOverLife = rotationOverLife;
        if (this.nativeInstance == 0) {
            this.isNeedReloadRotationOverLife = true;
        } else if (this.rotateOverLife != null) {
            if (this.rotateOverLife.getNativeInstance() == 0) {
                this.rotateOverLife.createNativeInstace();
            }
            AMapNativeParticleSystem.nativeSetOverLifeItem(this.nativeInstance, this.rotateOverLife.getNativeInstance(), 1);
        } else {
            AMapNativeParticleSystem.nativeSetOverLifeItem(this.nativeInstance, 0, 1);
        }
    }

    public void setSizeOverLife(SizeOverLife sizeOverLife) {
        this.sizeOverLife = sizeOverLife;
        if (this.nativeInstance == 0) {
            this.isNeedReloadSizeOverLife = true;
        } else if (this.sizeOverLife != null) {
            if (this.sizeOverLife.getNativeInstance() == 0) {
                this.sizeOverLife.createNativeInstace();
            }
            AMapNativeParticleSystem.nativeSetOverLifeItem(this.nativeInstance, this.sizeOverLife.getNativeInstance(), 2);
        } else {
            AMapNativeParticleSystem.nativeSetOverLifeItem(this.nativeInstance, 0, 2);
        }
    }

    public void setVelocityOverLife(VelocityGenerate velocityGenerate) {
        this.overLife = velocityGenerate;
        this.velocityOverLife = velocityGenerate;
        if (this.nativeInstance == 0) {
            this.isNeedReloadVelocityGenerate = true;
        } else if (this.overLife != null) {
            if (this.overLife.getNativeInstance() == 0) {
                this.overLife.createNativeInstace();
            }
            AMapNativeParticleSystem.nativeSetOverLifeItem(this.nativeInstance, this.overLife.getNativeInstance(), 0);
        } else {
            AMapNativeParticleSystem.nativeSetOverLifeItem(this.nativeInstance, 0, 0);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.nativeInstance);
    }
}
