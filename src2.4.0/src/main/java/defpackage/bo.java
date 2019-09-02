package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import com.yalantis.ucrop.view.CropImageView;

/* compiled from: UMWaterMark */
/* renamed from: bo */
class bo {
    static final int O000000o = 1;
    static final int O00000Oo = 2;
    static final int O00000o = 4;
    static final int O00000o0 = 3;
    private static final String O00000oO = "bo";
    private float O00000oo = 0.3f;
    private int O0000O0o;
    private int O0000OOo;
    private int O0000Oo;
    private int O0000Oo0;
    private Rect O0000OoO = new Rect();
    private int O0000Ooo = -1;
    private float O0000o = -1.0f;
    private int O0000o0 = 51;
    private int O0000o00 = -1;
    private boolean O0000o0O = false;
    private boolean O0000o0o = false;
    private Context O0000oO;
    private int O0000oO0 = -1;
    private Rect O0000oOO = new Rect();

    bo() {
    }

    private void O000000o(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            } catch (Exception unused) {
            }
        }
    }

    private float O00000oO(int i) {
        int i2 = this.O0000o0 & 112;
        return i2 != 16 ? i2 != 80 ? CropImageView.DEFAULT_ASPECT_RATIO : (float) i : (float) (i / 2);
    }

    private float O00000oo(int i) {
        int i2 = this.O0000o0 & 7;
        return i2 != 1 ? i2 != 5 ? CropImageView.DEFAULT_ASPECT_RATIO : (float) i : (float) (i / 2);
    }

    private float O0000O0o(int i) {
        float f = (float) this.O0000OoO.top;
        float f2 = (float) this.O0000OoO.bottom;
        switch (this.O0000Ooo) {
            case 1:
                return f2 + ((float) O00000o0((float) this.O0000Oo0));
            case 2:
                return (f - ((float) O0000Oo())) + ((float) (-O00000o0((float) this.O0000Oo)));
            default:
                return O0000Oo0(i);
        }
    }

    private float O0000OOo(int i) {
        float f = (float) this.O0000OoO.left;
        float f2 = (float) this.O0000OoO.right;
        switch (this.O0000o00) {
            case 3:
                return f2 + ((float) O00000o0((float) this.O0000OOo));
            case 4:
                return (f - ((float) O0000Oo0())) + ((float) (-O00000o0((float) this.O0000O0o)));
            default:
                return O0000Oo(i);
        }
    }

    private float O0000Oo(int i) {
        int O00000o0 = O00000o0((float) this.O0000OOo);
        int i2 = -O00000o0((float) this.O0000O0o);
        int i3 = this.O0000o0 & 7;
        if (i3 != 1) {
            return i3 != 5 ? (float) O00000o0 : (float) ((i - O0000Oo0()) + i2);
        } else {
            if (O00000o0 == 0) {
                O00000o0 = i2;
            }
            return ((((float) (i - O0000Oo0())) * 1.0f) / 2.0f) + ((float) O00000o0);
        }
    }

    private int O0000Oo() {
        return O000000o() == null ? -1 : O000000o().getHeight();
    }

    private float O0000Oo0(int i) {
        int i2 = -O00000o0((float) this.O0000Oo);
        int O00000o0 = O00000o0((float) this.O0000Oo0);
        int i3 = this.O0000o0 & 112;
        if (i3 != 16) {
            return i3 != 80 ? (float) O00000o0 : (float) ((i - O0000Oo()) + i2);
        } else {
            if (O00000o0 != 0) {
                i2 = O00000o0;
            }
            return ((((float) (i - O0000Oo())) * 1.0f) / 2.0f) + ((float) i2);
        }
    }

    private int O0000Oo0() {
        return O000000o() == null ? -1 : O000000o().getWidth();
    }

    /* Access modifiers changed, original: 0000 */
    public Bitmap O000000o() {
        return null;
    }

    /* Access modifiers changed, original: 0000 */
    public Rect O000000o(int i, int i2) {
        int i3;
        int i4 = 0;
        if (O00000oo()) {
            i = 0;
            i3 = i;
        } else {
            i = (int) O0000Oo(i);
            i3 = O0000Oo0() + i;
        }
        if (O00000oO()) {
            i2 = 0;
        } else {
            i4 = (int) O0000Oo0(i2);
            i2 = O0000Oo() + i4;
        }
        this.O0000oOO.set(i, i4, i3, i2);
        return this.O0000oOO;
    }

    public void O000000o(float f) {
        if (f >= CropImageView.DEFAULT_ASPECT_RATIO && f <= 1.0f) {
            this.O0000o = f;
        }
    }

    public void O000000o(int i) {
        if (i >= 0 && i <= 360) {
            this.O0000oO0 = i;
        }
    }

    public void O000000o(int i, int i2, int i3, int i4) {
        this.O0000OOo = i;
        this.O0000Oo0 = i2;
        this.O0000O0o = i3;
        this.O0000Oo = i4;
    }

    public void O000000o(Context context) {
        this.O0000oO = context;
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(Rect rect) {
        this.O0000OoO.set(rect.left, this.O0000OoO.top, rect.right, this.O0000OoO.bottom);
    }

    public Bitmap O00000Oo(Bitmap bitmap) {
        if (bitmap == null) {
            try {
                Log.e(O00000oO, "scr bitmap is null");
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        Bitmap O000000o = O000000o();
        if (O000000o == null) {
            Log.e(O00000oO, "mark bitmap is null");
            return bitmap;
        }
        String str;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > 0) {
            if (height > 0) {
                int O0000Oo0 = O0000Oo0();
                int O0000Oo = O0000Oo();
                if (O0000Oo0 > 0) {
                    if (O0000Oo > 0) {
                        Bitmap createBitmap;
                        Canvas canvas;
                        if (this.O0000o0O) {
                            createBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
                            canvas = new Canvas(createBitmap);
                            canvas.drawColor(0);
                        } else {
                            createBitmap = Bitmap.createBitmap(width, height, Config.RGB_565);
                            canvas = new Canvas(createBitmap);
                        }
                        canvas.drawBitmap(bitmap, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null);
                        Matrix matrix = new Matrix();
                        float min = (this.O00000oo * ((float) Math.min(bitmap.getWidth(), bitmap.getHeight()))) / ((float) Math.max(O0000Oo0, O0000Oo));
                        matrix.postScale(min, min, O00000oo(O0000Oo0), O00000oO(O0000Oo));
                        if (this.O0000oO0 != -1) {
                            matrix.postRotate((float) this.O0000oO0, (float) (O0000Oo0 / 2), (float) (O0000Oo / 2));
                        }
                        matrix.postTranslate(O00000oo() ? O0000OOo(width) : O0000Oo(width), O00000oO() ? O0000O0o(height) : O0000Oo0(height));
                        if (this.O0000o != -1.0f) {
                            Paint paint = new Paint();
                            paint.setAlpha((int) (255.0f * this.O0000o));
                            canvas.drawBitmap(O000000o, matrix, paint);
                        } else {
                            canvas.drawBitmap(O000000o, matrix, null);
                        }
                        canvas.save(31);
                        canvas.restore();
                        O000000o(bitmap);
                        O000000o(O000000o);
                        O0000OOo();
                        return createBitmap;
                    }
                }
                str = O00000oO;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("mark bitmap is error, markWidth:");
                stringBuilder.append(O0000Oo0);
                stringBuilder.append(", markHeight:");
                stringBuilder.append(O0000Oo);
                Log.e(str, stringBuilder.toString());
                return bitmap;
            }
        }
        str = O00000oO;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("mark bitmap is error, markWidth:");
        stringBuilder2.append(width);
        stringBuilder2.append(", markHeight:");
        stringBuilder2.append(height);
        Log.e(str, stringBuilder2.toString());
        return bitmap;
    }

    public void O00000Oo() {
        this.O0000o0O = true;
    }

    public void O00000Oo(float f) {
        if (f >= CropImageView.DEFAULT_ASPECT_RATIO && f <= 1.0f) {
            this.O00000oo = f;
        }
    }

    public void O00000Oo(int i) {
        if (i > 0 && this.O0000o0 != i) {
            this.O0000o0 = i;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void O00000Oo(Rect rect) {
        this.O0000OoO = rect;
        this.O0000OoO.set(this.O0000OoO.left, rect.top, this.O0000OoO.right, rect.bottom);
    }

    /* Access modifiers changed, original: 0000 */
    public void O00000o() {
        this.O0000o00 = -1;
        this.O0000Ooo = -1;
    }

    /* Access modifiers changed, original: 0000 */
    public void O00000o(int i) {
        this.O0000Ooo = i;
    }

    /* Access modifiers changed, original: 0000 */
    public int O00000o0(float f) {
        return (int) ((f * this.O0000oO.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void O00000o0() {
        this.O0000o0o = true;
    }

    /* Access modifiers changed, original: 0000 */
    public void O00000o0(int i) {
        this.O0000o00 = i;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean O00000oO() {
        return this.O0000Ooo != -1;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean O00000oo() {
        return this.O0000o00 != -1;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean O0000O0o() {
        return this.O0000o0o;
    }

    /* Access modifiers changed, original: 0000 */
    public void O0000OOo() {
    }
}
