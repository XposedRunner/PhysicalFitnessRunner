package com.geetest.sdk.views;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: GT3GeetestButton */
final class O000000o implements OnClickListener {
    final /* synthetic */ Context O000000o;
    final /* synthetic */ GT3GeetestButton O00000Oo;

    O000000o(GT3GeetestButton gT3GeetestButton, Context context) {
        this.O00000Oo = gT3GeetestButton;
        this.O000000o = context;
    }

    public final void onClick(View view) {
        try {
            this.O000000o.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.geetest.com/first_page")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
