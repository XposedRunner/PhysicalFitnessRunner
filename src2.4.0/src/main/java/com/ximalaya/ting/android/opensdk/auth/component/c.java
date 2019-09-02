package com.ximalaya.ting.android.opensdk.auth.component;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.auth.call.IXmlyAuthListener;
import com.ximalaya.ting.android.opensdk.auth.model.XmlyAuthInfo;

/* compiled from: XmlyAuthRequestParam */
public final class c extends d {
    public static final String a = "key_auth_info";
    public static final String b = "key_listener";
    private XmlyAuthInfo k;
    private IXmlyAuthListener l;
    private String m;

    public c(Context context) {
        super(context);
    }

    public final XmlyAuthInfo a() {
        return this.k;
    }

    public final void a(Activity activity) {
        if (this.l != null) {
            this.l.onCancel();
        }
        XmlyBrowserComponent.closeBrowser(activity, this.m);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(a);
        if (bundle2 != null) {
            this.k = XmlyAuthInfo.parseBundleData(this.h, bundle2);
        }
        this.m = bundle.getString(b);
        if (!TextUtils.isEmpty(this.m)) {
            this.l = e.a(this.h).a(this.m);
        }
    }

    public final void a(IXmlyAuthListener iXmlyAuthListener) {
        this.l = iXmlyAuthListener;
    }

    public final void a(XmlyAuthInfo xmlyAuthInfo) {
        this.k = xmlyAuthInfo;
    }

    public final IXmlyAuthListener b() {
        return this.l;
    }

    /* Access modifiers changed, original: protected|final */
    public final void b(Bundle bundle) {
        if (this.k != null) {
            bundle.putBundle(a, this.k.getAuthBundle());
        }
        if (this.l != null) {
            e a = e.a(this.h);
            this.m = String.valueOf(System.currentTimeMillis());
            a.a(this.m, this.l);
            bundle.putString(b, this.m);
        }
    }

    public final String c() {
        return this.m;
    }
}
