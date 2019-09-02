package com.umeng.socialize.media;

import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.socialize.ShareContent;
import defpackage.db;
import java.io.File;
import java.util.ArrayList;

/* compiled from: QZoneShareContent */
public class O00000o0 extends O00000o {
    public int O000000o = 1;
    private UMediaObject O0000OOo;
    private boolean O0000Oo0 = false;

    public O00000o0(ShareContent shareContent) {
        super(shareContent);
        this.O0000OOo = shareContent.mMedia;
    }

    private void O000000o(Bundle bundle) {
        O0000Oo O00000o = O00000oo().O00000o();
        if (O00000o.O00000oO()) {
            bundle.putString("imageUrl", O00000o.O00000o0());
        } else {
            bundle.putString("imageLocalUrl", O00000o.O0000OoO().toString());
        }
        bundle.putString("targetUrl", O00000oo().O00000o0());
        if (O0000o0o() != null) {
            bundle.putString("targetUrl", O0000o0o().O0000Oo());
        }
        bundle.putString("title", O000000o(O00000oo()));
        bundle.putString(db.O000Oooo, O00000Oo(O00000oo()));
        bundle.putString("audio_url", O00000oo().O00000o0());
    }

    private void O00000Oo(Bundle bundle) {
        if (O0000o0() != null && O0000o0().O0000OoO() != null) {
            bundle.putString("imageUrl", O0000o0().O0000OoO().toString());
        }
    }

    private void O00000o0(Bundle bundle) {
        O0000Oo O00000o = O0000OoO().O00000o();
        if (O00000o != null) {
            if (O00000o.O00000oO()) {
                bundle.putString("imageUrl", O00000o.O00000o0());
            } else {
                bundle.putString("imageLocalUrl", O00000o.O0000OoO().toString());
            }
        }
        bundle.putString("targetUrl", O0000OoO().O00000o0());
        bundle.putString("title", O000000o((O000000o) O0000OoO()));
        bundle.putString(db.O000Oooo, O00000Oo((O000000o) O0000OoO()));
    }

    public UMediaObject O000000o() {
        return this.O0000OOo;
    }

    public boolean O00000Oo() {
        return this.O0000Oo0;
    }

    public Bundle O00000o0() {
        Bundle bundle = new Bundle();
        int i = 0;
        this.O0000Oo0 = false;
        int i2 = 3;
        if (O0000Oo() == 2 || O0000Oo() == 3) {
            this.O000000o = 5;
            O00000Oo(bundle);
            this.O0000Oo0 = true;
        } else {
            if (O0000Oo() == 4) {
                this.O000000o = 2;
                O000000o(bundle);
            } else if (O0000Oo() == 16) {
                O00000o0(bundle);
            } else if (O0000Oo() == 8) {
                O000000o(bundle);
            } else {
                this.O0000Oo0 = true;
                bundle.putString(db.O000Oooo, O0000o00());
            }
            i2 = 1;
        }
        ArrayList arrayList = new ArrayList();
        if (O0000o0O() == null || O0000o0O().length <= 0) {
            String string = bundle.getString("imageUrl");
            bundle.remove("imageUrl");
            if (!TextUtils.isEmpty(string)) {
                arrayList.add(string);
            }
            bundle.putStringArrayList("imageUrl", arrayList);
            string = bundle.getString("imageLocalUrl");
            bundle.remove("imageLocalUrl");
            if (!TextUtils.isEmpty(string)) {
                arrayList.add(string);
            }
            bundle.putStringArrayList("imageLocalUrl", arrayList);
        } else {
            O0000Oo[] O0000o0O = O0000o0O();
            int length = O0000o0O.length;
            while (i < length) {
                File O0000OoO = O0000o0O[i].O0000OoO();
                if (O0000OoO != null) {
                    arrayList.add(O0000OoO.toString());
                }
                i++;
            }
            bundle.remove("imageLocalUrl");
            bundle.putStringArrayList("imageUrl", arrayList);
        }
        bundle.putInt("req_type", i2);
        return bundle;
    }
}
