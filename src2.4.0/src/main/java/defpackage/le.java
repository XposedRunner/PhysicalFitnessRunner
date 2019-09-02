package defpackage;

import android.content.Context;
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

/* compiled from: MusicPlayDrawable */
/* renamed from: le */
public class le extends Drawable implements Animatable {
    private Paint O000000o;
    private O000000o O00000Oo;
    private int O00000o0;

    /* compiled from: MusicPlayDrawable */
    /* renamed from: le$O000000o */
    private static class O000000o extends Handler {
        private final WeakReference<le> O000000o;

        public O000000o(le leVar) {
        }

        public void handleMessage(Message message) {
        }
    }

    public le(Context context) {
    }

    private void O000000o(Context context) {
    }

    public void draw(@NonNull Canvas canvas) {
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        return true;
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
