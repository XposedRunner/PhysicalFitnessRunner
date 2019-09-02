package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.SurfaceHolder;
import java.io.IOException;

/* compiled from: CameraManager */
/* renamed from: mc */
public final class mc {
    static final int O000000o;
    private static final String O00000Oo = "mc";
    private static mc O00000o0;
    private final Context O00000o;
    private final mb O00000oO;
    private Camera O00000oo;
    private Rect O0000O0o;
    private Rect O0000OOo;
    private boolean O0000Oo;
    private boolean O0000Oo0;
    private final boolean O0000OoO;
    private final mf O0000Ooo;
    private final ma O0000o00;

    static {
        int parseInt;
        try {
            parseInt = Integer.parseInt(VERSION.SDK);
        } catch (NumberFormatException unused) {
            parseInt = 10000;
        }
        O000000o = parseInt;
    }

    private mc(Context context) {
    }

    private int O000000o(float f) {
        return 0;
    }

    public static mc O000000o() {
        return null;
    }

    public static void O000000o(Context context) {
    }

    public me O000000o(byte[] bArr, int i, int i2) {
        return null;
    }

    public void O000000o(Handler handler, int i) {
    }

    public void O000000o(SurfaceHolder surfaceHolder) throws IOException {
    }

    public void O00000Oo() {
    }

    public void O00000Oo(Handler handler, int i) {
    }

    public void O00000o() {
    }

    public void O00000o0() {
    }

    public Rect O00000oO() {
        return null;
    }

    public Rect O00000oo() {
        return null;
    }

    public Context O0000O0o() {
        return null;
    }
}
