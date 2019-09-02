package defpackage;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.lang.ref.WeakReference;

/* compiled from: SportStartDrawable */
/* renamed from: lf */
public class lf extends Drawable implements Animatable {
    private volatile boolean O000000o;
    private final O000000o O00000Oo;
    private Paint O00000o;
    private Paint O00000o0;
    private float O00000oO;
    private float O00000oo;
    private int O0000O0o;
    private int O0000OOo;
    private int O0000Oo0;

    /* compiled from: SportStartDrawable */
    /* renamed from: lf$O000000o */
    private static class O000000o extends Handler {
        private final WeakReference<lf> O000000o;

        O000000o(lf lfVar) {
        }

        public void handleMessage(Message message) {
        }
    }

    public lf(int i, int i2) {
    }

    private void O000000o() {
    }

    public void draw(@NonNull Canvas canvas) {
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        return false;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }

    public void start() {
    }

    public void stop() {
    }
}
