package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.socialize.Config;
import com.umeng.socialize.media.O000000o;
import com.umeng.socialize.media.O0000Oo;
import com.umeng.socialize.media.O0000o;
import com.umeng.socialize.media.O0000o0;
import com.umeng.socialize.media.O00oOooO;
import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000Oo0;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerService;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o0;
import defpackage.dd.O00000o;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LinkcardRequest */
/* renamed from: ck */
public class ck extends cs {
    private static final String O0000o = "/share/linkcard/";
    private O000000o O0000oO;
    private String O0000oO0;

    public ck(Context context) {
        super(context, "", cj.class, 0, O00000o.POST);
    }

    private String O0000Oo() {
        return this.O0000oO instanceof O0000o ? "webpage" : this.O0000oO instanceof O0000o0 ? "video" : this.O0000oO instanceof O00oOooO ? "audio" : "webpage";
    }

    private JSONObject O0000Oo0() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("display_name", this.O0000oO.O00000oo());
            jSONObject.put(db.O000Ooo, O0000o0());
            jSONObject.put(db.O000Oooo, O0000Ooo());
            jSONObject.put(db.O000OooO, O0000o0o());
            jSONObject.put("url", this.O0000oO.O00000o0());
            jSONObject.put(db.O000o00, O0000o());
            jSONObject.put(db.O000o00O, O0000o00());
            jSONObject.put(db.O000o00o, O0000OoO());
            jSONObject.put(db.O000o0, O0000Oo());
        } catch (JSONException e) {
            O0000O0o.O000000o(e);
        }
        return jSONObject;
    }

    private String O0000OoO() {
        return new SimpleDateFormat(O000O0o0.O0000Ooo).format(new Date(System.currentTimeMillis()));
    }

    private String O0000Ooo() {
        return (TextUtils.isEmpty(this.O0000oO.O000000o()) || this.O0000oO.O000000o().length() <= 300) ? this.O0000oO.O000000o() : this.O0000oO.O000000o().substring(0, 300);
    }

    private JSONObject O0000o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.O0000oO.O00000o0());
        } catch (JSONException e) {
            O0000O0o.O000000o(e);
        }
        return jSONObject;
    }

    private JSONObject O0000o0() {
        JSONObject jSONObject = new JSONObject();
        try {
            O0000Oo O00000o = this.O0000oO.O00000o();
            if (O00000o == null || !O00000o.O00000oO()) {
                jSONObject.put("url", "https://mobile.umeng.com/images/pic/home/social/img-1.png");
            } else {
                jSONObject.put("url", O00000o.O0000Ooo());
            }
            int[] O0000o0O = O0000o0O();
            jSONObject.put(db.O000o0O, O0000o0O[0]);
            jSONObject.put(db.O000o0OO, O0000o0O[1]);
        } catch (JSONException e) {
            O0000O0o.O000000o(e);
        }
        return jSONObject;
    }

    private JSONArray O0000o00() {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("display_name", Config.Descriptor);
            jSONArray.put(jSONObject);
        } catch (JSONException e) {
            O0000O0o.O000000o(e);
        }
        return jSONArray;
    }

    private int[] O0000o0O() {
        int[] iArr = new int[]{XmPlayerService.CODE_GET_SUBJECTDETAIL, XmPlayerService.CODE_GET_SUBJECTDETAIL};
        if (!(this.O0000oO == null || this.O0000oO.O00000Oo() == null)) {
            Map O00000Oo = this.O0000oO.O00000Oo();
            if (O00000Oo.containsKey(db.O000o0O)) {
                iArr[0] = ((Integer) O00000Oo.get(db.O000o0O)).intValue();
            }
            if (O00000Oo.containsKey(db.O000o0OO)) {
                iArr[1] = ((Integer) O00000Oo.get(db.O000o0OO)).intValue();
            }
        }
        return iArr;
    }

    private JSONObject O0000o0o() {
        JSONObject jSONObject = new JSONObject();
        try {
            O0000Oo O00000o = this.O0000oO.O00000o();
            if (O00000o == null || !O00000o.O00000oO()) {
                jSONObject.put("url", "https://mobile.umeng.com/images/pic/home/social/img-1.png");
            } else {
                jSONObject.put("url", O00000o.O0000Ooo());
            }
            int[] O0000o0O = O0000o0O();
            jSONObject.put(db.O000o0O, O0000o0O[0]);
            jSONObject.put(db.O000o0OO, O0000o0O[1]);
        } catch (JSONException e) {
            O0000O0o.O000000o(e);
        }
        return jSONObject;
    }

    public void O000000o() {
        super.O000000o();
        O000000o("linkcard_info", O0000Oo0().toString());
    }

    public void O000000o(O000000o o000000o) {
        this.O0000oO = o000000o;
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
}
