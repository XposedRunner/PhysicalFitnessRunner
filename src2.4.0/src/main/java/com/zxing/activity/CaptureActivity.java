package com.zxing.activity;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.qf.qrcode.R;
import com.zxing.view.ViewfinderView;
import defpackage.mc;
import defpackage.mg;
import defpackage.ml;
import java.io.IOException;
import java.util.Vector;
import s.h.e.l.l.C;

public class CaptureActivity extends Activity implements Callback {
    private static final float O0000Oo0 = 0.1f;
    private static final long O0000OoO = 200;
    private mg O000000o;
    private ViewfinderView O00000Oo;
    private Vector<BarcodeFormat> O00000o;
    private boolean O00000o0;
    private String O00000oO;
    private ml O00000oo;
    private MediaPlayer O0000O0o;
    private boolean O0000OOo;
    private boolean O0000Oo;
    private final OnCompletionListener O0000Ooo = new OnCompletionListener() {
        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.seekTo(0);
        }
    };

    static {
        C.i(16777381);
    }

    private void O000000o(SurfaceHolder surfaceHolder) {
        try {
            mc.O000000o().O000000o(surfaceHolder);
            if (this.O000000o == null) {
                this.O000000o = new mg(this, this.O00000o, this.O00000oO);
            }
        } catch (IOException unused) {
        } catch (RuntimeException unused2) {
        }
    }

    private void O00000oO() {
        if (this.O0000OOo && this.O0000O0o == null) {
            setVolumeControlStream(3);
            this.O0000O0o = new MediaPlayer();
            this.O0000O0o.setAudioStreamType(3);
            this.O0000O0o.setOnCompletionListener(this.O0000Ooo);
            AssetFileDescriptor openRawResourceFd = getResources().openRawResourceFd(R.raw.beep);
            try {
                this.O0000O0o.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                openRawResourceFd.close();
                this.O0000O0o.setVolume(O0000Oo0, O0000Oo0);
                this.O0000O0o.prepare();
            } catch (IOException unused) {
                this.O0000O0o = null;
            }
        }
    }

    private void O00000oo() {
        if (this.O0000OOo && this.O0000O0o != null) {
            this.O0000O0o.start();
        }
        if (this.O0000Oo) {
            ((Vibrator) getSystemService("vibrator")).vibrate(O0000OoO);
        }
    }

    public native void O000000o();

    public native void O000000o(Result result, Bitmap bitmap);

    public native ViewfinderView O00000Oo();

    public native void O00000o();

    public native Handler O00000o0();

    public native void onCreate(Bundle bundle);

    public native void onDestroy();

    public native void onPause();

    public native void onResume();

    public native void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3);

    public native void surfaceCreated(SurfaceHolder surfaceHolder);

    public native void surfaceDestroyed(SurfaceHolder surfaceHolder);
}
