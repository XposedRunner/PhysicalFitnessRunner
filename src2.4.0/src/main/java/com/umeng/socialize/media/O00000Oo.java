package com.umeng.socialize.media;

import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.utils.O0000o00.O0000o0;
import com.umeng.socialize.utils.O0000o00.O0000o00;
import com.zjwh.android_wh_physicalfitness.activity.ArticleDetailActivity;
import defpackage.db;

/* compiled from: QQShareContent */
public class O00000Oo extends O00000o {
    public int O000000o = 1;
    private String O0000OOo = "";
    private String O0000Oo0 = "";

    public O00000Oo(ShareContent shareContent) {
        super(shareContent);
        if (shareContent.mMedia != null && (shareContent.mMedia instanceof O00oOooO)) {
            O000000o((O00oOooO) shareContent.mMedia);
        }
        if (shareContent.mMedia != null && (shareContent.mMedia instanceof O0000o0)) {
            O000000o((O0000o0) shareContent.mMedia);
        }
    }

    private void O000000o(Bundle bundle) {
        if (O0000o0() == null) {
            return;
        }
        if (O0000o0().O0000OoO() != null) {
            try {
                bundle.putString("imageLocalUrl", O0000o0().O0000OoO().toString());
                return;
            } catch (Exception unused) {
                bundle.putString("error", O0000o00.O0000OoO);
                return;
            }
        }
        bundle.putString("error", O0000o00.O0000OoO);
    }

    private void O00000Oo(Bundle bundle) {
        bundle.putString(db.O000Oooo, O0000o00());
    }

    private void O00000o(Bundle bundle) {
        bundle.putString("title", O000000o((O000000o) O0000OoO()));
        bundle.putString(db.O000Oooo, O00000Oo((O000000o) O0000OoO()));
        O0000Oo O00000o = O0000OoO().O00000o();
        if (O00000o != null) {
            if (O00000o.O00000oO()) {
                bundle.putString("imageUrl", O00000o.O00000o0());
            } else if (O00000o == null || O00000o.O0000OoO() == null) {
                bundle.putString("error", O0000o00.O0000OoO);
            } else {
                bundle.putString("imageLocalUrl", O00000o.O0000OoO().toString());
            }
        }
        if (TextUtils.isEmpty(O0000OoO().O00000o0())) {
            bundle.putString("error", O0000o0.O000O00o);
        }
        bundle.putString("targetUrl", O0000OoO().O00000o0());
    }

    private void O00000o0(Bundle bundle) {
        bundle.putString("title", O000000o((O000000o) O0000o()));
        bundle.putString(db.O000Oooo, O00000Oo((O000000o) O0000o()));
        O0000Oo O00000o = O0000o().O00000o();
        if (O00000o != null) {
            if (O00000o.O00000oO()) {
                bundle.putString("imageUrl", O00000o.O00000o0());
            } else if (O00000o == null || O00000o.O0000OoO() == null) {
                bundle.putString("error", O0000o00.O0000OoO);
            } else {
                bundle.putString("imageLocalUrl", O00000o.O0000OoO().toString());
            }
        }
        bundle.putString("targetUrl", O0000o().O00000o0());
    }

    private void O00000oO(Bundle bundle) {
        bundle.putString("title", O000000o((O000000o) O0000o0o()));
        bundle.putString(db.O000Oooo, O00000Oo((O000000o) O0000o0o()));
        O0000Oo O00000o = O0000o0o().O00000o();
        if (O00000o != null) {
            if (O00000o.O00000oO()) {
                bundle.putString("imageUrl", O00000o.O00000o0());
            } else if (O00000o == null || O00000o.O0000OoO() == null) {
                bundle.putString("error", O0000o00.O0000OoO);
            } else {
                bundle.putString("imageLocalUrl", O00000o.O0000OoO().toString());
            }
        }
        if (TextUtils.isEmpty(O0000o0o().O0000Oo())) {
            bundle.putString("targetUrl", O0000o0o().O00000o0());
        } else {
            bundle.putString("targetUrl", O0000o0o().O0000Oo());
        }
        bundle.putString("audio_url", O0000o0o().O00000o0());
    }

    public Bundle O000000o(boolean z, String str) {
        Bundle bundle = new Bundle();
        if (O0000Oo() == 2 || O0000Oo() == 3) {
            this.O000000o = 5;
            O000000o(bundle);
        } else if (O0000Oo() == 4) {
            if (O0000o0o() != null) {
                this.O000000o = 2;
            }
            O00000oO(bundle);
        } else if (O0000Oo() == 16) {
            O00000o(bundle);
        } else if (O0000Oo() == 8) {
            O00000o0(bundle);
        } else {
            bundle.putString("error", com.umeng.socialize.utils.O0000o00.O000000o(false, ArticleDetailActivity.O00000o));
        }
        bundle.putInt("req_type", this.O000000o);
        if (z) {
            bundle.putInt("cflag", 2);
        } else {
            bundle.putInt("cflag", 1);
        }
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("appName", str);
        }
        return bundle;
    }
}
