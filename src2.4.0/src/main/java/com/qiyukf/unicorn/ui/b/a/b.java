package com.qiyukf.unicorn.ui.b.a;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.qiyukf.basesdk.c.d.d;
import com.qiyukf.nim.uikit.a;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.ImageLoaderListener;

public final class b {
    public static void a(final com.qiyukf.unicorn.f.a.a.a.e.b bVar, ViewGroup viewGroup, int i, boolean z) {
        if (TextUtils.equals("image", bVar.a())) {
            final float dimension = (((z ? viewGroup.getResources().getDimension(R.dimen.ysf_bubble_content_max_width) : (float) d.a()) - ((float) viewGroup.getPaddingLeft())) - ((float) viewGroup.getPaddingRight())) / ((float) i);
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ysf_message_item_card_image, viewGroup, false);
            final ImageView imageView = (ImageView) inflate.findViewById(R.id.ysf_card_image);
            viewGroup.addView(inflate);
            a.a(bVar.b(), new ImageLoaderListener() {
                public final void onLoadComplete(@NonNull Bitmap bitmap) {
                    int min = (int) Math.min(((float) bitmap.getWidth()) * imageView.getResources().getDisplayMetrics().density, dimension);
                    imageView.setImageBitmap(bitmap);
                    LayoutParams layoutParams = (LayoutParams) imageView.getLayoutParams();
                    layoutParams.width = min;
                    layoutParams.gravity = b.c(bVar);
                    imageView.setLayoutParams(layoutParams);
                }

                public final void onLoadFailed(Throwable th) {
                }
            });
            return;
        }
        TextView textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ysf_message_item_card_text, viewGroup, false);
        viewGroup.addView(textView);
        textView.setText(bVar.b());
        textView.setTextColor(b(bVar));
        textView.setTextSize(z ? 14.0f : 16.0f);
        textView.setGravity(c(bVar));
        textView.setMaxLines(bVar.a(8) ? 1 : 3);
        TextPaint paint = textView.getPaint();
        if (bVar.a(1)) {
            paint.setFakeBoldText(true);
        }
        if (bVar.a(2)) {
            if (!TextUtils.isEmpty(bVar.b())) {
                textView.setText(bVar.b().concat(" "));
            }
            paint.setTextSkewX(-0.2f);
        }
        if (bVar.a(4)) {
            paint.setUnderlineText(true);
        }
    }

    @ColorInt
    private static int b(com.qiyukf.unicorn.f.a.a.a.e.b bVar) {
        try {
            return Color.parseColor(bVar.c());
        } catch (Exception unused) {
            return ViewCompat.MEASURED_STATE_MASK;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003e  */
    private static int c(com.qiyukf.unicorn.f.a.a.a.e.b r2) {
        /*
        r2 = r2.d();
        r0 = r2.hashCode();
        r1 = -1364013995; // 0xffffffffaeb2cc55 float:-8.1307995E-11 double:NaN;
        if (r0 == r1) goto L_0x002c;
    L_0x000d:
        r1 = 3317767; // 0x32a007 float:4.649182E-39 double:1.6391947E-317;
        if (r0 == r1) goto L_0x0022;
    L_0x0012:
        r1 = 108511772; // 0x677c21c float:4.6598146E-35 double:5.36119387E-316;
        if (r0 == r1) goto L_0x0018;
    L_0x0017:
        goto L_0x0036;
    L_0x0018:
        r0 = "right";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0036;
    L_0x0020:
        r2 = 0;
        goto L_0x0037;
    L_0x0022:
        r0 = "left";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0036;
    L_0x002a:
        r2 = 2;
        goto L_0x0037;
    L_0x002c:
        r0 = "center";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0036;
    L_0x0034:
        r2 = 1;
        goto L_0x0037;
    L_0x0036:
        r2 = -1;
    L_0x0037:
        switch(r2) {
            case 0: goto L_0x0041;
            case 1: goto L_0x003e;
            default: goto L_0x003a;
        };
    L_0x003a:
        r2 = 8388611; // 0x800003 float:1.1754948E-38 double:4.1445245E-317;
        return r2;
    L_0x003e:
        r2 = 17;
        return r2;
    L_0x0041:
        r2 = 8388613; // 0x800005 float:1.175495E-38 double:4.1445255E-317;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.ui.b.a.b.c(com.qiyukf.unicorn.f.a.a.a.e$b):int");
    }
}
