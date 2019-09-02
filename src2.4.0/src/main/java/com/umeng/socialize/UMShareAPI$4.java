package com.umeng.socialize;

import android.app.Activity;
import android.content.Context;
import defpackage.bp;
import defpackage.cc.O000000o;
import java.lang.ref.WeakReference;

class UMShareAPI$4 extends O000000o<Void> {
    final /* synthetic */ WeakReference O000000o;
    final /* synthetic */ ShareAction O00000Oo;
    final /* synthetic */ UMShareAPI O00000o;
    final /* synthetic */ UMShareListener O00000o0;

    UMShareAPI$4(UMShareAPI uMShareAPI, Context context, WeakReference weakReference, ShareAction shareAction, UMShareListener uMShareListener) {
        this.O00000o = uMShareAPI;
        this.O000000o = weakReference;
        this.O00000Oo = shareAction;
        this.O00000o0 = uMShareListener;
        super(context);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: O000000o */
    public Void O00000Oo() {
        if (this.O000000o.get() == null || ((Activity) this.O000000o.get()).isFinishing()) {
            return null;
        }
        if (UMShareAPI.a(this.O00000o) != null) {
            UMShareAPI.a(this.O00000o).O000000o((Activity) this.O000000o.get(), this.O00000Oo, this.O00000o0);
        } else {
            UMShareAPI.a(this.O00000o, new bp((Context) this.O000000o.get()));
            UMShareAPI.a(this.O00000o).O000000o((Activity) this.O000000o.get(), this.O00000Oo, this.O00000o0);
        }
        return null;
    }
}
