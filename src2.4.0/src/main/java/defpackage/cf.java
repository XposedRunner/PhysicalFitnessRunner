package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.socialize.Config;
import com.umeng.socialize.utils.O0000Oo0;
import defpackage.dd.O00000o;

/* compiled from: ActionBarRequest */
/* renamed from: cf */
public class cf extends cs {
    private static final String O0000o = "/bar/get/";
    private static final int O0000oO0 = 1;
    private int O0000oO = 0;

    public cf(Context context, boolean z) {
        super(context, "", cg.class, 1, O00000o.GET);
        this.O0000Oo0 = context;
        this.O0000oO = z;
        this.O0000Oo = O00000o.GET;
    }

    public void O000000o() {
        O000000o(db.O0000oO, Config.Descriptor);
        O000000o(db.O000O00o, String.valueOf(this.O0000oO));
        if (!TextUtils.isEmpty(Config.EntityName)) {
            O000000o(db.O000O0OO, Config.EntityName);
        }
    }

    /* Access modifiers changed, original: protected */
    public String O00000Oo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(O0000o);
        stringBuilder.append(O0000Oo0.O000000o(this.O0000Oo0));
        stringBuilder.append("/");
        return stringBuilder.toString();
    }
}
