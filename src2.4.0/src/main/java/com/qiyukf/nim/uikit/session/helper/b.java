package com.qiyukf.nim.uikit.session.helper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.qiyukf.unicorn.api.OnMessageItemClickListener;
import com.qiyukf.unicorn.d;

public class b extends ClickableSpan {
    private Context a;
    private String b;
    private int c = 0;
    private String d;

    public b(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    public static void a(Context context, String str, String str2) {
        try {
            Uri parse = Uri.parse(str);
            if (TextUtils.isEmpty(parse.getScheme())) {
                StringBuilder stringBuilder = new StringBuilder("http://");
                stringBuilder.append(str);
                parse = Uri.parse(stringBuilder.toString());
            }
            if (parse.getScheme().toLowerCase().equals("qiyu")) {
                if ("action.qiyukf.com".equals(parse.getHost().toLowerCase())) {
                    String queryParameter = parse.getQueryParameter("command");
                    if (!TextUtils.isEmpty(queryParameter) && queryParameter.equalsIgnoreCase("applyHumanStaff")) {
                        d.g().a(str2, true, null, 2);
                    }
                }
                return;
            }
            OnMessageItemClickListener onMessageItemClickListener = d.e().onMessageItemClickListener;
            if (onMessageItemClickListener != null) {
                onMessageItemClickListener.onURLClicked(context, parse.toString());
            } else {
                context.startActivity(new Intent("android.intent.action.VIEW", parse));
            }
        } catch (Exception unused) {
        }
    }

    public final void a(String str) {
        this.d = str;
    }

    public void onClick(View view) {
        a(this.a, this.b, this.d);
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(true);
        if (this.c != 0) {
            textPaint.setColor(this.c);
        }
    }
}
