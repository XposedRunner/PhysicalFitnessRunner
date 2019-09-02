package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.particle.ColorGenerate;
import com.amap.api.maps.model.particle.ParticleEmissionModule;
import com.amap.api.maps.model.particle.ParticleOverLifeModule;
import com.amap.api.maps.model.particle.ParticleOverlayOptions;
import com.amap.api.maps.model.particle.ParticleShapeModule;
import com.amap.api.maps.model.particle.VelocityGenerate;
import com.autonavi.amap.mapcore.AMapNativeParticleSystem;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ParticleLayerDelegateImp */
public class OO0000o implements O0o0000 {
    float O000000o = 1.0f;
    int O00000Oo = 0;
    private long O00000o = 0;
    int O00000o0 = 0;
    private OO00O O00000oO;
    private by O00000oo;
    private boolean O0000O0o = true;
    private float O0000OOo = 1.0f;
    private BitmapDescriptor O0000Oo;
    private String O0000Oo0;
    private boolean O0000OoO = false;
    private List<O0000O0o> O0000Ooo = new ArrayList();
    private float O0000o = -1.0f;
    private ParticleOverlayOptions O0000o0 = new ParticleOverlayOptions();
    private int O0000o00 = 0;
    private boolean O0000o0O = false;
    private float O0000o0o = -1.0f;
    private float[] O0000oO = new float[16];
    private float[] O0000oO0 = new float[16];
    private float[] O0000oOO = new float[16];

    public OO0000o(by byVar) {
        this.O00000oo = byVar;
    }

    private int O000000o(boolean z, BitmapDescriptor bitmapDescriptor) {
        O0000O0o O000000o;
        O00000oO();
        if (z) {
            O000000o = this.O00000oo.O000000o(bitmapDescriptor);
            if (O000000o != null) {
                int O0000OoO = O000000o.O0000OoO();
                O000000o(O000000o);
                return O0000OoO;
            }
        }
        O000000o = null;
        int i = 0;
        if (O000000o == null) {
            O000000o = new O0000O0o(bitmapDescriptor, 0);
        }
        Bitmap bitmap = bitmapDescriptor.getBitmap();
        if (!(bitmap == null || bitmap.isRecycled())) {
            i = O00000oo();
            O000000o.O000000o(i);
            if (z) {
                this.O00000oo.O0000O0o().O000000o(O000000o);
            }
            O000000o(O000000o);
            OOo000.O00000Oo(i, bitmap, true);
        }
        return i;
    }

    private void O000000o(O0000O0o o0000O0o) {
        if (o0000O0o != null) {
            this.O0000Ooo.add(o0000O0o);
            o0000O0o.O0000Ooo();
        }
    }

    private int O00000o() {
        if (this.O0000OoO) {
            return this.O0000o00;
        }
        int O000000o = O000000o(VERSION.SDK_INT >= 12, this.O0000Oo);
        this.O0000OoO = true;
        return O000000o;
    }

    private void O00000oO() {
        if (this.O0000Ooo != null) {
            for (O0000O0o o0000O0o : this.O0000Ooo) {
                if (!(o0000O0o == null || this.O00000oo == null)) {
                    this.O00000oo.O000000o(o0000O0o);
                }
            }
            this.O0000Ooo.clear();
        }
    }

    private int O00000oo() {
        int[] iArr = new int[]{0};
        GLES20.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    private void O0000O0o() {
        if (this.O00000o != 0) {
            O000000o(this.O0000o0.getMaxParticles());
            O000000o(this.O0000o0.getDuration());
            O000000o(this.O0000o0.isLoop());
            O00000Oo(true);
            O00000Oo(this.O0000o0.getParticleLifeTime());
            O000000o(this.O0000o0.getParticleStartSpeed());
            if (this.O0000o0.getParticleEmissionModule() != null) {
                O000000o(this.O0000o0.getParticleEmissionModule());
            }
            if (this.O0000o0.getParticleShapeModule() != null) {
                O000000o(this.O0000o0.getParticleShapeModule());
            }
            if (this.O0000o0.getParticleStartColor() != null) {
                O000000o(this.O0000o0.getParticleStartColor());
            }
            if (this.O0000o0.getParticleOverLifeModule() != null) {
                O000000o(this.O0000o0.getParticleOverLifeModule());
            }
            O000000o(this.O0000o0.getStartParticleW(), this.O0000o0.getstartParticleH());
        }
    }

    public void O000000o(int i) {
        if (this.O0000o0 != null) {
            this.O0000o0.setMaxParticles(i);
        }
        if (this.O00000o != 0) {
            AMapNativeParticleSystem.setMaxParticles(this.O00000o, i);
        } else if (this.O0000o0 != null) {
            synchronized (this) {
                this.O0000o0O = true;
            }
        }
    }

    public void O000000o(int i, int i2) {
        if (this.O0000o0 != null) {
            this.O0000o0.setStartParticleSize(i, i2);
        }
        if (this.O00000o != 0) {
            AMapNativeParticleSystem.setStartParticleSize(this.O00000o, (float) i, (float) i2);
        }
    }

    public void O000000o(long j) {
        if (this.O0000o0 != null) {
            this.O0000o0.setDuration(j);
        }
        if (this.O00000o != 0) {
            AMapNativeParticleSystem.setDuration(this.O00000o, j);
        } else if (this.O0000o0 != null) {
            synchronized (this) {
                this.O0000o0O = true;
            }
        }
    }

    public void O000000o(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            synchronized (this) {
                if (bitmapDescriptor.equals(this.O0000Oo)) {
                    return;
                }
                this.O0000OoO = false;
                this.O0000Oo = bitmapDescriptor;
            }
        }
    }

    public void O000000o(ColorGenerate colorGenerate) {
        if (this.O0000o0 != null) {
            this.O0000o0.setParticleStartColor(colorGenerate);
        }
        if (this.O00000o != 0 && colorGenerate != null) {
            if (colorGenerate.getNativeInstance() == 0) {
                colorGenerate.createNativeInstace();
            }
            AMapNativeParticleSystem.setStartColor(this.O00000o, colorGenerate.getNativeInstance());
        } else if (this.O0000o0 != null) {
            synchronized (this) {
                this.O0000o0O = true;
            }
        }
    }

    public void O000000o(ParticleEmissionModule particleEmissionModule) {
        if (this.O0000o0 != null) {
            this.O0000o0.setParticleEmissionModule(particleEmissionModule);
        }
        if (this.O00000o != 0 && particleEmissionModule != null) {
            if (particleEmissionModule.getNativeInstance() == 0) {
                particleEmissionModule.createNativeInstace();
            }
            AMapNativeParticleSystem.setParticleEmission(this.O00000o, particleEmissionModule.getNativeInstance());
        } else if (this.O0000o0 != null) {
            synchronized (this) {
                this.O0000o0O = true;
            }
        }
    }

    public void O000000o(ParticleOverLifeModule particleOverLifeModule) {
        if (this.O0000o0 != null) {
            this.O0000o0.setParticleOverLifeModule(particleOverLifeModule);
        }
        if (this.O00000o != 0 && particleOverLifeModule != null) {
            if (particleOverLifeModule.getNativeInstance() == 0) {
                particleOverLifeModule.createNativeInstace();
            }
            AMapNativeParticleSystem.setParticleOverLifeModule(this.O00000o, particleOverLifeModule.getNativeInstance());
        } else if (this.O0000o0 != null) {
            synchronized (this) {
                this.O0000o0O = true;
            }
        }
    }

    public void O000000o(ParticleOverlayOptions particleOverlayOptions) {
        synchronized (this) {
            if (particleOverlayOptions != null) {
                try {
                    O000000o(particleOverlayOptions.getIcon());
                    this.O0000o0.setMaxParticles(particleOverlayOptions.getMaxParticles());
                    this.O0000o0.setLoop(particleOverlayOptions.isLoop());
                    this.O0000o0.setDuration(particleOverlayOptions.getDuration());
                    this.O0000o0.setParticleLifeTime(particleOverlayOptions.getParticleLifeTime());
                    this.O0000o0.setParticleEmissionModule(particleOverlayOptions.getParticleEmissionModule());
                    this.O0000o0.setParticleShapeModule(particleOverlayOptions.getParticleShapeModule());
                    this.O0000o0.setParticleStartSpeed(particleOverlayOptions.getParticleStartSpeed());
                    this.O0000o0.setParticleStartColor(particleOverlayOptions.getParticleStartColor());
                    this.O0000o0.setParticleOverLifeModule(particleOverlayOptions.getParticleOverLifeModule());
                    this.O0000o0.setStartParticleSize(particleOverlayOptions.getStartParticleW(), particleOverlayOptions.getstartParticleH());
                    this.O0000o0.zIndex(particleOverlayOptions.getZIndex());
                    this.O0000OOo = this.O0000o0.getZIndex();
                    this.O0000o0.setVisible(particleOverlayOptions.isVisibile());
                    this.O0000O0o = this.O0000o0.isVisibile();
                    this.O0000o0O = true;
                } catch (Throwable th) {
                }
            }
        }
    }

    public void O000000o(ParticleShapeModule particleShapeModule) {
        if (this.O0000o0 != null) {
            this.O0000o0.setParticleShapeModule(particleShapeModule);
        }
        if (this.O00000o != 0 && particleShapeModule != null) {
            if (particleShapeModule.getNativeInstance() == 0) {
                particleShapeModule.createNativeInstace();
            }
            AMapNativeParticleSystem.setParticleShapeModule(this.O00000o, particleShapeModule.getNativeInstance());
        } else if (this.O0000o0 != null) {
            synchronized (this) {
                this.O0000o0O = true;
            }
        }
    }

    public void O000000o(VelocityGenerate velocityGenerate) {
        if (this.O0000o0 != null) {
            this.O0000o0.setParticleStartSpeed(velocityGenerate);
        }
        if (this.O00000o != 0 && velocityGenerate != null) {
            if (velocityGenerate.getNativeInstance() == 0) {
                velocityGenerate.createNativeInstace();
            }
            AMapNativeParticleSystem.setParticleStartSpeed(this.O00000o, velocityGenerate.getNativeInstance());
        } else if (this.O0000o0 != null) {
            synchronized (this) {
                this.O0000o0O = true;
            }
        }
    }

    public void O000000o(MapConfig mapConfig) throws RemoteException {
        if (this.O00000oO == null) {
            this.O00000oO = this.O00000oo.O00000Oo();
        }
        if (this.O00000oO != null) {
            if (this.O00000o == 0) {
                this.O00000o = AMapNativeParticleSystem.nativeCreate();
                if (!(this.O00000o == 0 || this.O00000oO == null)) {
                    AMapNativeParticleSystem.nativeSetGLShaderManager(this.O00000o, this.O00000oO.O000000o());
                }
            }
            if (this.O00000o != 0) {
                synchronized (this) {
                    try {
                        if (this.O0000o0O) {
                            O0000O0o();
                            this.O0000o0O = false;
                        }
                    } catch (Throwable th) {
                        while (true) {
                            Throwable th2 = th;
                        }
                    }
                }
                this.O0000o00 = O00000o();
                if (this.O0000o00 != 0) {
                    AMapNativeParticleSystem.nativeSetTextureId(this.O00000o, this.O0000o00);
                    if (this.O00000oo != null) {
                        this.O00000oo.O000000o(false);
                    }
                    if (!(this.O00000Oo == mapConfig.getMapWidth() && this.O00000o0 == mapConfig.getMapHeight())) {
                        float f;
                        int i;
                        this.O00000Oo = mapConfig.getMapWidth();
                        this.O00000o0 = mapConfig.getMapHeight();
                        if (this.O00000Oo > this.O00000o0) {
                            f = (float) this.O00000Oo;
                            i = this.O00000o0;
                        } else {
                            f = (float) this.O00000o0;
                            i = this.O00000Oo;
                        }
                        this.O000000o = f / ((float) i);
                        if (this.O00000Oo > this.O00000o0) {
                            this.O0000o0o = -this.O000000o;
                            this.O0000o = 1.0f;
                        } else {
                            this.O0000o0o = -1.0f;
                            this.O0000o = this.O000000o;
                        }
                        Matrix.orthoM(this.O0000oO0, 0, this.O0000o0o, -this.O0000o0o, -this.O0000o, this.O0000o, 3.0f, 7.0f);
                        Matrix.setLookAtM(this.O0000oO, 0, 0.0f, 0.0f, 3.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
                    }
                    Matrix.multiplyMM(this.O0000oOO, 0, this.O0000oO0, 0, this.O0000oO, 0);
                    Matrix.translateM(this.O0000oOO, 0, this.O0000o0o, this.O0000o, 0.0f);
                    Matrix.scaleM(this.O0000oOO, 0, Math.abs(this.O0000o0o * 2.0f) / ((float) this.O00000Oo), Math.abs(2.0f * this.O0000o) / ((float) this.O00000o0), 0.0f);
                    AMapNativeParticleSystem.nativeRender(this.O00000o, (float[]) this.O0000oOO.clone(), mapConfig.getProjectionMatrix(), mapConfig.getSX(), mapConfig.getSY(), mapConfig.getSZ(), (float) this.O00000Oo, (float) this.O00000o0);
                }
            }
        }
    }

    public void O000000o(boolean z) {
        if (this.O0000o0 != null) {
            this.O0000o0.setLoop(z);
        }
        if (this.O00000o != 0) {
            AMapNativeParticleSystem.setLoop(this.O00000o, z);
        } else if (this.O0000o0 != null) {
            synchronized (this) {
                this.O0000o0O = true;
            }
        }
    }

    public boolean O000000o() {
        return true;
    }

    public int O00000Oo() {
        return this.O00000o != 0 ? AMapNativeParticleSystem.getCurrentParticleNum(this.O00000o) : 0;
    }

    public void O00000Oo(long j) {
        if (this.O0000o0 != null) {
            this.O0000o0.setParticleLifeTime(j);
        }
        if (this.O00000o != 0) {
            AMapNativeParticleSystem.setParticleLifeTime(this.O00000o, j);
        } else if (this.O0000o0 != null) {
            synchronized (this) {
                this.O0000o0O = true;
            }
        }
    }

    public void O00000Oo(boolean z) {
        if (this.O00000o != 0) {
            AMapNativeParticleSystem.setPreWram(this.O00000o, z);
        }
    }

    public boolean O00000o0() {
        return false;
    }

    public void destroy() {
        if (this.O0000Ooo != null && this.O0000Ooo.size() > 0) {
            for (int i = 0; i < this.O0000Ooo.size(); i++) {
                O0000O0o o0000O0o = (O0000O0o) this.O0000Ooo.get(i);
                if (o0000O0o != null) {
                    if (this.O00000oo != null) {
                        this.O00000oo.O000000o(o0000O0o);
                    }
                    if (this.O00000oo.O0000O0o() != null) {
                        this.O00000oo.O0000O0o().O00000o0(o0000O0o.O0000o0O());
                    }
                }
            }
            this.O0000Ooo.clear();
        }
        if (this.O0000Oo != null) {
            Bitmap bitmap = this.O0000Oo.getBitmap();
            if (bitmap != null) {
                bitmap.recycle();
                this.O0000Oo = null;
            }
        }
        if (this.O00000o != 0) {
            AMapNativeParticleSystem.nativeDestroy(this.O00000o);
        }
    }

    public boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return false;
    }

    public String getId() throws RemoteException {
        if (this.O0000Oo0 == null) {
            this.O0000Oo0 = this.O00000oo.O000000o("Particle");
        }
        return this.O0000Oo0;
    }

    public float getZIndex() throws RemoteException {
        return this.O0000OOo;
    }

    public int hashCodeRemote() throws RemoteException {
        return 0;
    }

    public boolean isAboveMaskLayer() {
        return false;
    }

    public boolean isVisible() throws RemoteException {
        return this.O0000O0o;
    }

    public void remove() throws RemoteException {
    }

    public void setAboveMaskLayer(boolean z) {
    }

    public void setVisible(boolean z) throws RemoteException {
        this.O0000O0o = z;
    }

    public void setZIndex(float f) throws RemoteException {
        this.O0000OOo = f;
    }
}
