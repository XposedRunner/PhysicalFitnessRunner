package defpackage;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.socialize.Config;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.utils.O00000o0;
import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000Oo0;
import com.umeng.socialize.utils.O0000o00.O0000Oo;
import defpackage.dd.O000000o;
import defpackage.dd.O00000o;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

/* compiled from: SocializeRequest */
/* renamed from: cs */
public abstract class cs extends dd {
    public static final int O000000o = 0;
    public static final int O00000Oo = 1;
    public static final int O00000o0 = 2;
    private static final String O0000o = "https://log.umsns.com/";
    private static final String O0000oOO = "SocializeRequest";
    public int O00000o;
    private int O0000oO = 1;
    private Map<String, O000000o> O0000oO0 = new HashMap();

    /* compiled from: SocializeRequest */
    /* renamed from: cs$1 */
    static /* synthetic */ class 1 {
        static final /* synthetic */ int[] O000000o = new int[O00000o.values().length];

        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Missing block: B:7:?, code skipped:
            return;
     */
        static {
            /*
            r0 = defpackage.dd.O00000o.values();
            r0 = r0.length;
            r0 = new int[r0];
            O000000o = r0;
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = defpackage.dd.O00000o.POST;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = defpackage.dd.O00000o.GET;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.cs$1.<clinit>():void");
        }
    }

    /* compiled from: SocializeRequest */
    /* renamed from: cs$O000000o */
    public enum O000000o {
        IMAGE,
        VEDIO
    }

    public cs(Context context, String str, Class<? extends ct> cls, int i, O00000o o00000o) {
        super("");
        this.O0000OOo = cls;
        this.O00000o = i;
        this.O0000Oo0 = context;
        this.O0000Oo = o00000o;
        O00000oo("https://log.umsns.com/");
    }

    public static Map<String, Object> O000000o(Context context) {
        HashMap hashMap = new HashMap();
        String O000000o = com.umeng.socialize.utils.O00000o.O000000o(context);
        if (!TextUtils.isEmpty(O000000o)) {
            hashMap.put("imei", O000000o);
        }
        Object O00000oo = com.umeng.socialize.utils.O00000o.O00000oo(context);
        if (TextUtils.isEmpty(O00000oo)) {
            O00000oo = O00000o0.O00000o0();
            O0000O0o.O00000Oo(O0000Oo.O0000OOo);
        }
        hashMap.put(db.O00000oo, O00000oo);
        if (!TextUtils.isEmpty(ce.O00000oO)) {
            hashMap.put("uid", ce.O00000oO);
        }
        try {
            hashMap.put(db.O0000Oo0, com.umeng.socialize.utils.O00000o.O00000Oo(context)[0]);
        } catch (Exception unused) {
            hashMap.put(db.O0000Oo0, "Unknown");
        }
        hashMap.put(db.O0000Oo, Build.MODEL);
        hashMap.put(db.O0000OoO, "6.9.4");
        hashMap.put("os", "Android");
        hashMap.put(db.O000000o, com.umeng.socialize.utils.O00000o.O00000oO(context));
        hashMap.put("sn", com.umeng.socialize.utils.O00000o.O000000o());
        hashMap.put("os_version", com.umeng.socialize.utils.O00000o.O00000o0());
        hashMap.put(db.O0000o00, Long.valueOf(System.currentTimeMillis()));
        hashMap.put(db.O0000o0O, O0000Oo0.O000000o(context));
        hashMap.put(db.O00oOooo, ce.O0000Oo0);
        hashMap.put(ce.O0000ooo, Config.shareType);
        if (!TextUtils.isEmpty(Config.EntityKey)) {
            hashMap.put(db.O0000o0o, Config.EntityKey);
        }
        if (!TextUtils.isEmpty(Config.SessionId)) {
            hashMap.put(db.O0000o, Config.SessionId);
        }
        try {
            hashMap.put(db.O0000oO0, Integer.valueOf(0));
        } catch (Exception e) {
            O0000O0o.O000000o(e);
        }
        return hashMap;
    }

    private String O00000Oo(Map<String, Object> map) {
        if (this.O0000O0o.isEmpty()) {
            return null;
        }
        try {
            return new JSONObject(map).toString();
        } catch (Exception e) {
            O0000O0o.O000000o(e);
            return null;
        }
    }

    public void O000000o() {
        O000000o("pcv", ce.O0000Oo0);
        O000000o(ce.O0000ooo, Config.shareType);
        O000000o("imei", com.umeng.socialize.utils.O00000o.O000000o(this.O0000Oo0));
        O000000o(db.O0000Oo, Build.MODEL);
        O000000o(db.O00000oo, com.umeng.socialize.utils.O00000o.O00000oo(this.O0000Oo0));
        O000000o("os", "Android");
        O000000o(db.O0000Oo0, com.umeng.socialize.utils.O00000o.O00000Oo(this.O0000Oo0)[0]);
        O000000o("uid", null);
        O000000o(db.O0000OoO, "6.9.4");
        O000000o(db.O0000o00, String.valueOf(System.currentTimeMillis()));
    }

    public void O000000o(int i) {
        this.O0000oO = i;
    }

    public void O000000o(byte[] bArr, O000000o o000000o, String str) {
        if (O000000o.IMAGE == o000000o) {
            String O00000o0 = bq.O00000o0(bArr);
            if (TextUtils.isEmpty(O00000o0)) {
                O00000o0 = "png";
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(O0000Oo0.O00000Oo(bArr));
            stringBuilder.append(".");
            stringBuilder.append(O00000o0);
            this.O0000oO0.put(db.O0000oo0, new O000000o(stringBuilder.toString(), bArr));
        }
    }

    public abstract String O00000Oo();

    public void O00000Oo(UMediaObject uMediaObject) {
        if (uMediaObject != null) {
            if (uMediaObject instanceof com.umeng.socialize.media.O000000o) {
                O000000o(db.O0000ooo, ((com.umeng.socialize.media.O000000o) uMediaObject).O00000oo());
            }
            if (uMediaObject.O00000oO()) {
                for (Entry entry : uMediaObject.O0000OOo().entrySet()) {
                    O000000o((String) entry.getKey(), entry.getValue().toString());
                }
            } else {
                byte[] O0000O0o = uMediaObject.O0000O0o();
                if (O0000O0o != null) {
                    O000000o(O0000O0o, O000000o.IMAGE, null);
                }
            }
        }
    }

    public Map<String, Object> O00000o() {
        Map O000000o = cs.O000000o(this.O0000Oo0);
        if (!TextUtils.isEmpty(Config.EntityKey)) {
            O000000o.put(db.O0000o0o, Config.EntityKey);
        }
        if (!TextUtils.isEmpty(Config.SessionId)) {
            O000000o.put(db.O0000o, Config.SessionId);
        }
        O000000o.put(db.O0000oO0, Integer.valueOf(this.O0000oO));
        O000000o.put(db.O0000o0, Integer.valueOf(this.O00000o));
        O000000o.put("uid", UMUtils.getUMId(this.O0000Oo0));
        O000000o.putAll(this.O0000O0o);
        return O000000o;
    }

    public String O00000o0() {
        return O000000o(O0000OOo(), O00000o());
    }

    public Map<String, Object> O00000oO() {
        return O00000o();
    }

    public Map<String, O000000o> O00000oo() {
        return this.O0000oO0;
    }

    public void O00000oo(String str) {
        String str2 = "";
        try {
            if (!TextUtils.isEmpty(O00000Oo())) {
                str2 = new URL(new URL(str), O00000Oo()).toString();
            }
        } catch (Exception e) {
            O0000O0o.O000000o(O0000Oo.O000000o(str), e);
        }
        super.O00000oo(str2);
    }

    /* Access modifiers changed, original: protected */
    public String O0000O0o() {
        return 1.O000000o[this.O0000Oo.ordinal()] != 1 ? O0000o00 : O0000Ooo;
    }

    public String O0000O0o(String str) {
        return str;
    }

    public String O0000OOo(String str) {
        return str;
    }

    public JSONObject e_() {
        return null;
    }
}
