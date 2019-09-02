package com.amap.api.maps.model.particle;

import android.text.TextUtils;
import com.amap.api.mapcore.util.O0o0000;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BaseOverlay;
import java.lang.ref.WeakReference;

public class ParticleOverlay extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private ParticleOverlayOptions options;
    private O0o0000 overlayDelegate;
    private String overlayName;

    public ParticleOverlay(O0o0000 o0o0000) {
        this.overlayDelegate = o0o0000;
    }

    public ParticleOverlay(IGlOverlayLayer iGlOverlayLayer, ParticleOverlayOptions particleOverlayOptions) {
        this.glOverlayLayerRef = new WeakReference(iGlOverlayLayer);
        this.options = particleOverlayOptions;
        this.overlayName = "";
    }

    private void a() {
        IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
        if (!TextUtils.isEmpty(this.overlayName) && iGlOverlayLayer != null) {
            iGlOverlayLayer.updateOption(this.overlayName, this.options);
        }
    }

    public void destroy() {
        try {
            if (this.overlayDelegate != null) {
                this.overlayDelegate.destroy();
                return;
            }
            IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getCurrentParticleNum() {
        int i = 0;
        try {
            if (this.overlayDelegate != null) {
                return this.overlayDelegate.O00000Oo();
            }
            IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                i = iGlOverlayLayer.getCurrentParticleNum(this.overlayName);
            }
            return i;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public void setDuration(long j) {
        try {
            if (this.overlayDelegate != null) {
                this.overlayDelegate.O000000o(j);
            } else if (this.options != null) {
                this.options.setDuration(j);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setLoop(boolean z) {
        try {
            if (this.overlayDelegate != null) {
                this.overlayDelegate.O000000o(z);
            } else if (this.options != null) {
                this.options.setLoop(z);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setMaxParticles(int i) {
        try {
            if (this.overlayDelegate != null) {
                this.overlayDelegate.O000000o(i);
            } else if (this.options != null) {
                this.options.setMaxParticles(i);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleEmission(ParticleEmissionModule particleEmissionModule) {
        try {
            if (this.overlayDelegate != null) {
                this.overlayDelegate.O000000o(particleEmissionModule);
            } else if (this.options != null) {
                this.options.setParticleEmissionModule(particleEmissionModule);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleLifeTime(long j) {
        try {
            if (this.overlayDelegate != null) {
                this.overlayDelegate.O00000Oo(j);
            } else if (this.options != null) {
                this.options.setParticleLifeTime(j);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleOverLifeModule(ParticleOverLifeModule particleOverLifeModule) {
        try {
            if (this.overlayDelegate != null) {
                this.overlayDelegate.O000000o(particleOverLifeModule);
            } else if (this.options != null) {
                this.options.setParticleOverLifeModule(particleOverLifeModule);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleShapeModule(ParticleShapeModule particleShapeModule) {
        try {
            if (this.overlayDelegate != null) {
                this.overlayDelegate.O000000o(particleShapeModule);
            } else if (this.options != null) {
                this.options.setParticleShapeModule(particleShapeModule);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleStartSpeed(VelocityGenerate velocityGenerate) {
        try {
            if (this.overlayDelegate != null) {
                this.overlayDelegate.O000000o(velocityGenerate);
            } else if (this.options != null) {
                this.options.setParticleStartSpeed(velocityGenerate);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setStartColor(ColorGenerate colorGenerate) {
        try {
            if (this.overlayDelegate != null) {
                this.overlayDelegate.O000000o(colorGenerate);
            } else if (this.options != null) {
                this.options.setParticleStartColor(colorGenerate);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setStartParticleSize(int i, int i2) {
        try {
            if (this.overlayDelegate != null) {
                this.overlayDelegate.O000000o(i, i2);
            } else if (this.options != null) {
                this.options.setStartParticleSize(i, i2);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setVisible(boolean z) {
        try {
            if (this.overlayDelegate != null) {
                this.overlayDelegate.setVisible(z);
            } else if (this.options != null) {
                this.options.setVisible(z);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
