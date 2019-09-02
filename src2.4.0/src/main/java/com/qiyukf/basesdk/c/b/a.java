package com.qiyukf.basesdk.c.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.Html.ImageGetter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class a implements ImageGetter {
    private static final Pattern a = Pattern.compile("<(img|IMG)\\s+([^>]*)>");
    private static final Pattern b = Pattern.compile("(width|WIDTH)\\s*=\\s*\"?(\\w+)\"?");
    private static final Pattern c = Pattern.compile("(height|HEIGHT)\\s*=\\s*\"?(\\w+)\"?");
    private TextView d;
    private b e;
    private List<b> f = new ArrayList();
    private int g;

    private class a extends BitmapDrawable {
        private final int b;
        private Drawable c;

        public a(int i) {
            this.b = i;
        }

        private int a() {
            return a.this.d.getResources().getDisplayMetrics().heightPixels;
        }

        private int a(float f) {
            return (int) ((f * a.this.d.getResources().getDisplayMetrics().density) + 0.5f);
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x008b  */
        public final void a(android.graphics.drawable.Drawable r4, boolean r5) {
            /*
            r3 = this;
            r3.c = r4;
            r4 = r3.c;
            r0 = 0;
            if (r4 != 0) goto L_0x000b;
        L_0x0007:
            r3.setBounds(r0, r0, r0, r0);
            return;
        L_0x000b:
            r4 = com.qiyukf.basesdk.c.b.a.this;
            r4 = r4.e;
            if (r4 != 0) goto L_0x0015;
        L_0x0013:
            r4 = r0;
            goto L_0x001f;
        L_0x0015:
            r4 = com.qiyukf.basesdk.c.b.a.this;
            r4 = r4.e;
            r4 = r4.c();
        L_0x001f:
            r1 = com.qiyukf.basesdk.c.b.a.this;
            r1 = r1.e;
            if (r1 == 0) goto L_0x002c;
        L_0x0027:
            r1 = com.qiyukf.basesdk.c.b.a.this;
            r1.e;
        L_0x002c:
            if (r5 == 0) goto L_0x006a;
        L_0x002e:
            r5 = com.qiyukf.basesdk.c.b.a.this;
            r5 = r5.f;
            r5 = r5.size();
            r1 = r3.b;
            if (r5 <= r1) goto L_0x004b;
        L_0x003c:
            r5 = com.qiyukf.basesdk.c.b.a.this;
            r5 = r5.f;
            r1 = r3.b;
            r5 = r5.get(r1);
            r5 = (com.qiyukf.basesdk.c.b.a.b) r5;
            goto L_0x004c;
        L_0x004b:
            r5 = 0;
        L_0x004c:
            if (r5 == 0) goto L_0x006a;
        L_0x004e:
            r1 = r5.a();
            if (r1 == 0) goto L_0x006a;
        L_0x0054:
            r1 = r5.a;
            r1 = (float) r1;
            r1 = r3.a(r1);
            r5 = r5.b;
            r5 = (float) r5;
            r5 = r3.a(r5);
            r2 = r1;
            r1 = r5;
            r5 = r2;
            goto L_0x0076;
        L_0x006a:
            r5 = r3.c;
            r5 = r5.getIntrinsicWidth();
            r1 = r3.c;
            r1 = r1.getIntrinsicHeight();
        L_0x0076:
            if (r5 <= 0) goto L_0x008f;
        L_0x0078:
            if (r1 <= 0) goto L_0x008f;
        L_0x007a:
            if (r4 <= 0) goto L_0x0085;
        L_0x007c:
            if (r5 <= r4) goto L_0x0085;
        L_0x007e:
            r1 = (float) r1;
            r5 = (float) r5;
            r1 = r1 / r5;
            r5 = (float) r4;
            r1 = r1 * r5;
            r1 = (int) r1;
            r5 = r4;
        L_0x0085:
            r4 = r3.a();
            if (r1 <= r4) goto L_0x008f;
        L_0x008b:
            r1 = r3.a();
        L_0x008f:
            r4 = r3.c;
            r4.setBounds(r0, r0, r5, r1);
            r3.setBounds(r0, r0, r5, r1);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.c.b.a$a.a(android.graphics.drawable.Drawable, boolean):void");
        }

        public final void draw(Canvas canvas) {
            if (this.c != null) {
                if (this.c instanceof BitmapDrawable) {
                    Bitmap bitmap = ((BitmapDrawable) this.c).getBitmap();
                    if (bitmap == null || bitmap.isRecycled()) {
                        return;
                    }
                }
                this.c.draw(canvas);
            }
        }
    }

    private static class b {
        private final int a;
        private final int b;

        public b(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public final boolean a() {
            return this.a >= 0 && this.b >= 0;
        }
    }

    static /* synthetic */ void a(a aVar, Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            aVar.d.post(runnable);
        }
    }

    private static int b(String str) {
        try {
            return Integer.valueOf(str).intValue();
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public final void a(TextView textView) {
        this.d = textView;
    }

    public final void a(b bVar) {
        this.e = bVar;
    }

    public final void a(String str) {
        Matcher matcher = a.matcher(str);
        while (matcher.find()) {
            String trim = matcher.group(2).trim();
            Matcher matcher2 = b.matcher(trim);
            int i = -1;
            int b = matcher2.find() ? b(matcher2.group(2).trim()) : -1;
            Matcher matcher3 = c.matcher(trim);
            if (matcher3.find()) {
                i = b(matcher3.group(2).trim());
            }
            this.f.add(new b(b, i));
        }
    }

    public final Drawable getDrawable(String str) {
        int i = this.g;
        this.g = i + 1;
        final a aVar = new a(i);
        if (this.e != null) {
            aVar.a(this.e.a(), false);
            this.e.a(str, new com.qiyukf.basesdk.c.b.b.a() {
                public final void a() {
                    a.a(a.this, new Runnable() {
                        public final void run() {
                            aVar.a(a.this.e.b(), false);
                            a.this.d.setText(a.this.d.getText());
                        }
                    });
                }

                public final void a(@NonNull final Bitmap bitmap) {
                    a.a(a.this, new Runnable() {
                        public final void run() {
                            aVar.a(new BitmapDrawable(a.this.d.getResources(), bitmap), true);
                            a.this.d.setText(a.this.d.getText());
                        }
                    });
                }
            });
        }
        return aVar;
    }
}
