package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.socialize.Config;
import com.umeng.socialize.media.O0000Oo;
import com.umeng.socialize.media.O0000o;
import com.umeng.socialize.media.O0000o0;
import com.umeng.socialize.media.O0000o00;
import com.umeng.socialize.media.O00oOooO;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.utils.O0000Oo0;
import defpackage.dd.O00000o;

/* compiled from: AnalyticsReqeust */
/* renamed from: co */
public class co extends cs {
    private static final String O0000o = "/share/multi_add/";
    private static final int O0000oO0 = 9;
    private String O0000oO;
    private String O0000oOO;
    private String O0000oOo;
    private String O0000oo;
    private String O0000oo0;
    private String O0000ooO;
    private String O0000ooo;
    private UMediaObject O00oOooO;

    public co(Context context, String str, String str2) {
        super(context, "", cp.class, 9, O00000o.POST);
        this.O0000Oo0 = context;
        this.O0000oOO = str;
        this.O0000ooo = str2;
    }

    public void O000000o() {
        super.O000000o();
        String str = "{\"%s\":\"%s\"}";
        Object[] objArr = new Object[2];
        objArr[0] = this.O0000oOO;
        objArr[1] = this.O0000oO == null ? "" : this.O0000oO;
        str = String.format(str, objArr);
        String O000000o = O0000Oo0.O000000o(this.O0000Oo0);
        O000000o(db.O0000oO, Config.Descriptor);
        O000000o("to", str);
        O000000o(db.O000OO, str);
        O000000o(db.O0000o0O, O000000o);
        O000000o("type", this.O0000oo0);
        O000000o(db.O000OO0o, this.O0000oO);
        O000000o("ct", this.O0000ooo);
        if (!TextUtils.isEmpty(this.O0000ooO)) {
            O000000o("url", this.O0000ooO);
        }
        if (!TextUtils.isEmpty(this.O0000oo)) {
            O000000o("title", this.O0000oo);
        }
        O00000Oo(this.O00oOooO);
    }

    public void O000000o(UMediaObject uMediaObject) {
        if (uMediaObject instanceof O0000Oo) {
            this.O00oOooO = uMediaObject;
        } else if (uMediaObject instanceof O00oOooO) {
            O00oOooO o00oOooO = (O00oOooO) uMediaObject;
            this.O0000oo = o00oOooO.O00000oo();
            this.O0000ooO = o00oOooO.O00000o0();
            this.O0000ooo = o00oOooO.O000000o();
            this.O00oOooO = o00oOooO.O00000o();
        } else if (uMediaObject instanceof O0000o0) {
            O0000o0 o0000o0 = (O0000o0) uMediaObject;
            this.O0000oo = o0000o0.O00000oo();
            this.O0000ooO = o0000o0.O00000o0();
            this.O0000ooo = o0000o0.O000000o();
            this.O00oOooO = o0000o0.O00000o();
        } else if (uMediaObject instanceof O0000o) {
            O0000o o0000o = (O0000o) uMediaObject;
            this.O0000oo = o0000o.O00000oo();
            this.O0000ooO = o0000o.O00000o0();
            this.O0000ooo = o0000o.O000000o();
            this.O00oOooO = o0000o.O00000o();
        } else if (uMediaObject instanceof O0000o00) {
            O0000o00 o0000o00 = (O0000o00) uMediaObject;
            this.O0000oo = o0000o00.O00000oo();
            this.O0000ooO = o0000o00.O00000o0();
            this.O0000ooo = o0000o00.O000000o();
            this.O00oOooO = o0000o00.O00000o();
        }
    }

    public void O000000o(String str) {
        this.O0000oOO = str;
    }

    /* Access modifiers changed, original: protected */
    public String O00000Oo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(O0000o);
        stringBuilder.append(O0000Oo0.O000000o(this.O0000Oo0));
        stringBuilder.append("/");
        stringBuilder.append(Config.EntityKey);
        stringBuilder.append("/");
        return stringBuilder.toString();
    }

    public void O00000Oo(String str) {
        this.O0000oOo = str;
    }

    public void O00000o(String str) {
        this.O0000ooo = str;
    }

    public void O00000o0(String str) {
        this.O0000oo0 = str;
    }

    public void O00000oO(String str) {
        this.O0000oO = str;
    }
}
