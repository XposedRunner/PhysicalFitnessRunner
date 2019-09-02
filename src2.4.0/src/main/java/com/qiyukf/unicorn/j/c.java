package com.qiyukf.unicorn.j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.TextView;
import cn.jiguang.net.HttpUtils;
import com.qiyukf.basesdk.c.b.b;
import com.qiyukf.basesdk.c.b.b.a;
import com.qiyukf.basesdk.c.d.d;
import com.qiyukf.nim.uikit.session.helper.e;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.ImageLoaderListener;
import com.qiyukf.unicorn.ui.activity.UrlImagePreviewActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c {
    private static final int a = d.a(90.0f);
    private static final String b = String.format(Locale.getDefault(), "imageView&thumbnail=%dx0", new Object[]{Integer.valueOf(a)});

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? str : Html.fromHtml(str.replaceAll("<(img|IMG)\\s+([^>]*)>", com.qiyukf.unicorn.d.c().getString(R.string.ysf_msg_notify_image))).toString();
    }

    public static void a(final TextView textView, String str, final int i, String str2) {
        final Context context = textView.getContext();
        final AtomicBoolean atomicBoolean = new AtomicBoolean();
        final com.qiyukf.basesdk.c.b.d a = com.qiyukf.basesdk.c.b.d.a(str).b(str2).a(new b() {
            public final Drawable a() {
                return ContextCompat.getDrawable(context, R.drawable.ysf_image_placeholder_loading);
            }

            public final void a(String str, final a aVar) {
                com.qiyukf.nim.uikit.a.a(c.c(str), new ImageLoaderListener() {
                    public final void onLoadComplete(@NonNull Bitmap bitmap) {
                        aVar.a(bitmap);
                    }

                    public final void onLoadFailed(Throwable th) {
                        atomicBoolean.set(true);
                        aVar.a();
                    }
                });
            }

            public final Drawable b() {
                return ContextCompat.getDrawable(context, R.drawable.ysf_image_placeholder_fail);
            }

            public final int c() {
                return i;
            }
        }).a(new com.qiyukf.basesdk.c.b.d.a() {
            public final CharSequence a(SpannableStringBuilder spannableStringBuilder) {
                return e.a(context, com.qiyukf.nim.uikit.session.emoji.e.a(context, spannableStringBuilder));
            }
        });
        a.a(new com.qiyukf.basesdk.c.b.e() {
            public final void a(Context context, String str, String str2) {
                com.qiyukf.nim.uikit.session.helper.b.a(context, str, str2);
            }

            public final void a(Context context, List<String> list, int i) {
                if (atomicBoolean.get()) {
                    atomicBoolean.set(false);
                    a.a(textView);
                }
                UrlImagePreviewActivity.start(context, (ArrayList) list, i);
            }
        });
        a.a(textView);
    }

    public static boolean b(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = Uri.parse(str).getHost();
            if (!TextUtils.isEmpty(str) && (str.endsWith("nosdn.127.net") || str.endsWith("nos.netease.com"))) {
                return true;
            }
        }
        return false;
    }

    public static String c(String str) {
        if (!b(str)) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(str.contains(HttpUtils.URL_AND_PARA_SEPARATOR) ? HttpUtils.PARAMETERS_SEPARATOR : HttpUtils.URL_AND_PARA_SEPARATOR);
        str = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(b);
        return stringBuilder.toString();
    }
}
