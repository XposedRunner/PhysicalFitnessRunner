package com.zjwh.android_wh_physicalfitness.utils;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.webkit.WebView;
import android.webkit.WebView.HitTestResult;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.view.dialog.O0000Oo;
import defpackage.O00Oo;
import defpackage.oO00OOOo;
import defpackage.oOo0oooO;
import defpackage.ooOOO0Oo;

/* compiled from: Utils */
class O00Oo0$6 implements OnLongClickListener {
    final /* synthetic */ WebView O000000o;

    O00Oo0$6(WebView webView) {
        this.O000000o = webView;
    }

    public boolean onLongClick(View view) {
        final HitTestResult hitTestResult = this.O000000o.getHitTestResult();
        if ((hitTestResult.getType() != 5 && hitTestResult.getType() != 8) || hitTestResult.getExtra() == null) {
            return false;
        }
        new O0000Oo(this.O000000o.getContext()).O000000o().O000000o(false).O00000Oo(false).O000000o("提示").O00000Oo("保存图片到本地").O000000o((int) R.string.cancel, null).O00000Oo((int) R.string.sure, new OnClickListener() {
            public void onClick(View view) {
                if (hitTestResult.getExtra().contains("http")) {
                    O00Oo.O00000o0(O00Oo0$6.this.O000000o.getContext()).O000000o(hitTestResult.getExtra()).O0000Oo().O00000Oo((ooOOO0Oo) new oOo0oooO<Bitmap>() {
                        public void O000000o(Bitmap bitmap, oO00OOOo<? super Bitmap> oo00oooo) {
                            O0000Oo.O000000o(O00Oo0$6.this.O000000o.getContext(), bitmap);
                        }
                    });
                    return;
                }
                try {
                    Bitmap O00000oO = O00Oo0.O00000oO(hitTestResult.getExtra());
                    if (O00000oO != null) {
                        O0000Oo.O000000o(O00Oo0$6.this.O000000o.getContext(), O00000oO);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).O00000Oo();
        return true;
    }
}
