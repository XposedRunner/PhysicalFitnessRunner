package com.ximalaya.ting.android.player.soundtouch;

public final class SoundTouch {
    public static final int CHANNELS_DEFAULT = 2;
    public static boolean ENABLE_SOUND_TOUCH = true;
    public static final int PITCH_DEFAULT = 0;
    public static final int RATE_DEFAULT = 1;
    public static final int SAMPLE_RATE_DEFAULT = 44100;
    public static final int TEMPO_DEFAULT = 1;
    private static SoundTouch mSoundTouch;
    private long handle;

    static {
        try {
            System.loadLibrary("soundtouch");
        } catch (Exception unused) {
            ENABLE_SOUND_TOUCH = false;
        } catch (Throwable unused2) {
            ENABLE_SOUND_TOUCH = false;
        }
    }

    private SoundTouch() {
        this.handle = 0;
        this.handle = newInstance(44100, 2);
        ENABLE_SOUND_TOUCH = true;
    }

    public SoundTouch(int i, int i2) {
        this.handle = 0;
        this.handle = newInstance(i, i2);
    }

    private final native void deleteInstance(long j);

    public static final native String getErrorString();

    public static SoundTouch getInstance() {
        if (mSoundTouch == null) {
            synchronized (SoundTouch.class) {
                if (mSoundTouch == null) {
                    mSoundTouch = new SoundTouch();
                }
            }
        }
        return mSoundTouch;
    }

    public static final native String getVersionString();

    private static final native long newInstance(int i, int i2);

    private final native int processBytes(long j, SoundTouchDataModel soundTouchDataModel);

    private final native void setPitch(long j, float f);

    private final native void setPitchSemiTones(long j, float f);

    private final native void setRate(long j, float f);

    private final native void setTempo(long j, float f);

    public void close() {
        deleteInstance(this.handle);
        this.handle = 0;
    }

    public int processBytes(SoundTouchDataModel soundTouchDataModel) {
        return processBytes(this.handle, soundTouchDataModel);
    }

    public void setPitch(float f) {
        setPitch(this.handle, f);
    }

    public void setPitchSemiTones(float f) {
        setPitchSemiTones(this.handle, f);
    }

    public void setRate(float f) {
        setRate(this.handle, f);
    }

    public void setTempo(float f) {
        setTempo(this.handle, f);
    }
}
