package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.socialize.Config;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.media.O0000Oo;
import com.umeng.socialize.media.O0000o;
import com.umeng.socialize.media.O0000o0;
import com.umeng.socialize.media.O0000o00;
import com.umeng.socialize.media.O00oOooO;
import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000Oo0;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DplusApi */
/* renamed from: cv */
public class cv {
    private static final String O000000o = "true";
    private static final String O00000Oo = "false";
    private static ExecutorService O00000o0 = Executors.newSingleThreadExecutor();

    public static JSONObject O000000o() throws JSONException {
        JSONObject O00000o0 = cv.O00000o0(by.SINA, "test");
        O00000o0.put(cu.O000OO0o, "testetstttttttttttttttttttttttttttttttt");
        O00000o0.put(cu.O000Oo00, true);
        O00000o0.put(cu.O0000oo, "sso");
        O00000o0.put(cu.O000O00o, 0);
        return O00000o0;
    }

    public static void O000000o(final Context context) {
        O00000o0.execute(new Runnable() {
            public void run() {
                try {
                    cw.O000000o(context, ce.O00oOooo, cv.O00000o0());
                } catch (JSONException e) {
                    O0000O0o.O000000o(e);
                }
            }
        });
    }

    public static void O000000o(final Context context, final by byVar, final String str) {
        O00000o0.execute(new Runnable() {
            public void run() {
                try {
                    cw.O000000o(context, ce.O00oOoOo, cv.O00000Oo(byVar, str));
                } catch (JSONException e) {
                    O0000O0o.O000000o(e);
                }
            }
        });
    }

    public static void O000000o(Context context, by byVar, String str, String str2, String str3) {
        final by byVar2 = byVar;
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final Context context2 = context;
        O00000o0.execute(new Runnable() {
            public void run() {
                try {
                    cw.O000000o(context2, ce.O00oOoOo, cv.O00000oo(byVar2, str4, str5, str6));
                } catch (JSONException e) {
                    O0000O0o.O000000o(e);
                }
            }
        });
    }

    public static void O000000o(Context context, ShareContent shareContent, boolean z, by byVar, String str, boolean z2) {
        final ShareContent shareContent2 = shareContent;
        final boolean z3 = z;
        final by byVar2 = byVar;
        final String str2 = str;
        final Context context2 = context;
        O00000o0.execute(new Runnable() {
            public void run() {
                try {
                    cw.O000000o(context2, ce.O000O00o, cv.O00000Oo(shareContent2, z3, byVar2, str2));
                } catch (JSONException e) {
                    O0000O0o.O000000o(e);
                }
            }
        });
        final boolean z4 = z2;
        final String str3 = str;
        final Context context3 = context;
        O00000o0.execute(new Runnable() {
            public void run() {
                try {
                    cw.O000000o(context3, ce.O00oOoOo, cv.O00000Oo(shareContent2, z3, byVar2, z4, str3));
                } catch (JSONException e) {
                    O0000O0o.O000000o(e);
                }
            }
        });
    }

    public static void O000000o(final Context context, final Map<String, String> map, final int i) {
        O00000o0.execute(new Runnable() {
            public void run() {
                try {
                    cw.O000000o(context, ce.O000O0o, cv.O00000Oo(map, i));
                } catch (JSONException e) {
                    O0000O0o.O000000o(e);
                }
            }
        });
    }

    public static void O000000o(final Context context, final Map<String, String> map, final by byVar, final String str) {
        O00000o0.execute(new Runnable() {
            public void run() {
                try {
                    cw.O000000o(context, ce.O000O0Oo, cv.O00000Oo(map, byVar, str));
                } catch (JSONException e) {
                    O0000O0o.O000000o(e);
                }
            }
        });
    }

    public static void O000000o(Context context, Map<String, String> map, boolean z, by byVar, String str) {
        final Map<String, String> map2 = map;
        final boolean z2 = z;
        final by byVar2 = byVar;
        final String str2 = str;
        final Context context2 = context;
        O00000o0.execute(new Runnable() {
            public void run() {
                try {
                    cw.O000000o(context2, ce.O000O0OO, cv.O00000Oo(map2, z2, byVar2, str2));
                } catch (JSONException e) {
                    O0000O0o.O000000o(e);
                }
            }
        });
    }

    public static void O000000o(final Context context, final boolean z, final by byVar, final String str) {
        O00000o0.execute(new Runnable() {
            public void run() {
                try {
                    cw.O000000o(context, ce.O00oOoOo, cv.O00000Oo(z, byVar, str));
                } catch (JSONException e) {
                    O0000O0o.O000000o(e);
                }
            }
        });
    }

    private static JSONObject O00000Oo(by byVar, String str) throws JSONException {
        JSONObject O00000o0 = cv.O00000o0(byVar, str);
        O00000o0.put(cu.O000OO0o, cu.O000Ooo);
        return O00000o0;
    }

    private static JSONObject O00000Oo(ShareContent shareContent, boolean z, by byVar, String str) throws JSONException {
        JSONObject O00000o0 = cv.O00000o0(byVar, str);
        Object obj = shareContent.mText;
        O00000o0.put(cu.O000O00o, shareContent.getShareType());
        O00000o0.put(cu.O0000oo, byVar.O00000Oo(z));
        if (!TextUtils.isEmpty(obj) && obj.length() > 10240) {
            obj = obj.substring(0, 10240);
        }
        if (shareContent.getShareType() == 2 || shareContent.getShareType() == 3) {
            O0000Oo o0000Oo = (O0000Oo) shareContent.mMedia;
            if (o0000Oo != null) {
                if (o0000Oo.O00000oO()) {
                    O00000o0.put(cu.O0000ooo, o0000Oo.O0000Ooo());
                } else {
                    O00000o0.put("pic", O0000Oo0.O00000oO(O0000Oo0.O00000Oo(o0000Oo.O0000O0o())));
                }
            }
            O00000o0.put("ct", obj);
        } else if (shareContent.getShareType() == 1) {
            O00000o0.put("ct", obj);
        } else if (shareContent.getShareType() == 8) {
            O0000o0 o0000o0 = (O0000o0) shareContent.mMedia;
            if (o0000o0.O00000o() != null) {
                if (o0000o0.O00000o().O00000oO()) {
                    O00000o0.put(cu.O0000ooo, o0000o0.O00000o().O0000Ooo());
                } else {
                    O00000o0.put("pic", O0000Oo0.O00000oO(O0000Oo0.O00000Oo(o0000o0.O00000o().O0000O0o())));
                }
            }
            if (byVar == by.SINA) {
                O00000o0.put("ct", obj);
            } else {
                O00000o0.put("ct", o0000o0.O000000o());
            }
            O00000o0.put("title", o0000o0.O00000oo());
            O00000o0.put("url", o0000o0.O00000o0());
        } else if (shareContent.getShareType() == 4) {
            O00oOooO o00oOooO = (O00oOooO) shareContent.mMedia;
            if (o00oOooO.O00000o() != null) {
                if (o00oOooO.O00000o().O00000oO()) {
                    O00000o0.put(cu.O0000ooo, o00oOooO.O00000o().O0000Ooo());
                } else {
                    O00000o0.put("pic", O0000Oo0.O00000oO(O0000Oo0.O00000Oo(o00oOooO.O00000o().O0000O0o())));
                }
            }
            if (byVar == by.SINA) {
                O00000o0.put("ct", obj);
            } else {
                O00000o0.put("ct", o00oOooO.O000000o());
            }
            O00000o0.put("title", o00oOooO.O00000oo());
            O00000o0.put(cu.O000O0o0, o00oOooO.O00000o0());
            O00000o0.put("url", o00oOooO.O0000Oo());
        } else if (shareContent.getShareType() == 32) {
            O00000o0.put("ct", obj);
        } else if (shareContent.getShareType() == 64) {
            com.umeng.socialize.media.O0000Oo0 o0000Oo0 = (com.umeng.socialize.media.O0000Oo0) shareContent.mMedia;
            if (o0000Oo0 != null) {
                if (o0000Oo0.O00000oO()) {
                    O00000o0.put(cu.O0000ooo, o0000Oo0.O0000Ooo());
                } else {
                    O00000o0.put("pic", O0000Oo0.O00000Oo(o0000Oo0.O0000O0o()));
                }
            }
            O00000o0.put("ct", obj);
        } else if (shareContent.getShareType() == 128) {
            O0000o00 o0000o00 = (O0000o00) shareContent.mMedia;
            if (o0000o00.O00000o() != null) {
                if (o0000o00.O00000o().O00000oO()) {
                    O00000o0.put(cu.O0000ooo, o0000o00.O00000o().O0000Ooo());
                } else {
                    O00000o0.put("pic", O0000Oo0.O00000oO(O0000Oo0.O00000Oo(o0000o00.O00000o().O0000O0o())));
                }
            }
            O00000o0.put("ct", o0000o00.O000000o());
            O00000o0.put("title", o0000o00.O00000oo());
            O00000o0.put("url", o0000o00.O00000o0());
            O00000o0.put(cu.O000O0Oo, o0000o00.O0000OoO());
            O00000o0.put(cu.O00oOoOo, o0000o00.O0000Oo());
        } else if (shareContent.getShareType() == 16) {
            O0000o o0000o = (O0000o) shareContent.mMedia;
            if (o0000o.O00000o() != null) {
                if (o0000o.O00000o().O00000oO()) {
                    O00000o0.put(cu.O0000ooo, o0000o.O00000o().O0000Ooo());
                } else {
                    O00000o0.put("pic", O0000Oo0.O00000oO(O0000Oo0.O00000Oo(o0000o.O00000o().O0000O0o())));
                }
            }
            if (byVar == by.SINA) {
                O00000o0.put("ct", obj);
            } else {
                O00000o0.put("ct", o0000o.O000000o());
            }
            O00000o0.put("title", o0000o.O00000oo());
            O00000o0.put("url", o0000o.O00000o0());
        }
        return O00000o0;
    }

    private static JSONObject O00000Oo(ShareContent shareContent, boolean z, by byVar, boolean z2, String str) throws JSONException {
        JSONObject O00000o0 = cv.O00000o0(byVar, str);
        O00000o0.put(cu.O000OO0o, cu.O000OOoo);
        String str2 = cu.O000Oo00;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(z2);
        stringBuilder.append("");
        O00000o0.put(str2, stringBuilder.toString());
        O00000o0.put(cu.O0000oo, byVar.O00000Oo(z));
        O00000o0.put(cu.O000O00o, shareContent.getShareType());
        return O00000o0;
    }

    private static JSONObject O00000Oo(Map<String, String> map, int i) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(cu.O000OO0o, cu.O000OO);
        jSONObject.put(cu.O000OOOo, i);
        if (map != null) {
            JSONObject jSONObject2 = new JSONObject();
            if (!(TextUtils.isEmpty((CharSequence) map.get(cu.O000OOo)) || TextUtils.isEmpty((CharSequence) map.get(cu.O000OOoO)))) {
                jSONObject2.put(cu.O000OOo, map.get(cu.O000OOo));
                jSONObject2.put(cu.O000OOoO, map.get(cu.O000OOoO));
                jSONObject.put(cu.O000OOo0, jSONObject2);
            }
        }
        return jSONObject;
    }

    private static JSONObject O00000Oo(Map<String, String> map, by byVar, String str) throws JSONException {
        JSONObject O00000o0 = cv.O00000o0(byVar, str);
        if (map != null) {
            O00000o0.put(cu.O000O0o, map.get(cu.O000OO0o));
            O00000o0.put(cu.O000O0oO, map.get("iconurl"));
            O00000o0.put(cu.O000O0oo, map.get("gender"));
            if (TextUtils.isEmpty((CharSequence) map.get(ce.O0000oo0))) {
                O00000o0.put(cu.O000OO00, map.get("city"));
            } else {
                O00000o0.put(cu.O000OO00, map.get(ce.O0000oo0));
            }
            if (byVar.toString().equals("WEIXIN")) {
                O00000o0.put("uid", map.get(db.O000OOoO));
            } else {
                O00000o0.put("uid", map.get("uid"));
            }
            O00000o0.put(cu.O0000oO, map.get(cu.O0000oO));
            O00000o0.put("ts", System.currentTimeMillis());
        }
        return O00000o0;
    }

    private static JSONObject O00000Oo(Map<String, String> map, boolean z, by byVar, String str) throws JSONException {
        JSONObject O00000o0 = cv.O00000o0(byVar, str);
        if (map != null) {
            O00000o0.put(cu.O0000o, byVar.O00000Oo(z));
            if (byVar.toString().equals("WEIXIN")) {
                O00000o0.put("uid", map.get(db.O000OOoO));
            } else {
                O00000o0.put("uid", map.get("uid"));
            }
            O00000o0.put(cu.O0000oO, map.get(cu.O0000oO));
            O00000o0.put("aid", map.get("aid"));
            O00000o0.put(cu.O0000oOo, map.get(cu.O0000oOo));
            if (TextUtils.isEmpty((CharSequence) map.get("access_token"))) {
                O00000o0.put("at", map.get("accessToken"));
            } else {
                O00000o0.put("at", map.get("access_token"));
            }
        }
        return O00000o0;
    }

    private static JSONObject O00000Oo(boolean z, by byVar, String str) throws JSONException {
        JSONObject O00000o0 = cv.O00000o0(byVar, str);
        O00000o0.put(cu.O000OO0o, cu.O000OoOo);
        O00000o0.put(cu.O0000o, byVar.O00000Oo(z));
        return O00000o0;
    }

    public static void O00000Oo(Context context, by byVar, String str, String str2, String str3) {
        final by byVar2 = byVar;
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final Context context2 = context;
        O00000o0.execute(new Runnable() {
            public void run() {
                try {
                    cw.O000000o(context2, ce.O00oOoOo, cv.O00000oO(byVar2, str4, str5, str6));
                } catch (JSONException e) {
                    O0000O0o.O000000o(e);
                }
            }
        });
    }

    private static JSONObject O00000o(by byVar, String str, String str2, String str3) throws JSONException {
        JSONObject O00000o0 = cv.O00000o0(byVar, str);
        O00000o0.put(cu.O000OO0o, cu.O000OooO);
        O00000o0.put(cu.O000Oo0O, str2);
        if (!TextUtils.isEmpty(str3)) {
            O00000o0.put(cu.O000OoOO, str3);
        }
        return O00000o0;
    }

    private static JSONObject O00000o0() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ts", System.currentTimeMillis());
        jSONObject.put(cu.O0000o0, Config.shareType);
        return jSONObject;
    }

    private static JSONObject O00000o0(by byVar, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String byVar2 = byVar.toString();
        jSONObject.put(cu.O0000o0O, byVar.O00000Oo());
        if ((byVar2.equals(by.QQ.toString()) || byVar2.equals(by.QZONE.toString())) && Config.isUmengQQ.booleanValue()) {
            jSONObject.put(cu.O0000o0o, O000000o);
        } else if ((byVar2.equals(by.WEIXIN.toString()) || byVar2.equals(by.WEIXIN_CIRCLE.toString()) || byVar2.equals(by.WEIXIN_FAVORITE.toString())) && Config.isUmengWx.booleanValue()) {
            jSONObject.put(cu.O0000o0o, O000000o);
        } else if (byVar2.equals(by.SINA.toString()) && Config.isUmengSina.booleanValue()) {
            jSONObject.put(cu.O0000o0o, O000000o);
        } else {
            jSONObject.put(cu.O0000o0o, O00000Oo);
        }
        jSONObject.put("ts", System.currentTimeMillis());
        jSONObject.put("tag", str);
        return jSONObject;
    }

    public static void O00000o0(Context context, by byVar, String str, String str2, String str3) {
        final by byVar2 = byVar;
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final Context context2 = context;
        O00000o0.execute(new Runnable() {
            public void run() {
                try {
                    cw.O000000o(context2, ce.O00oOoOo, cv.O00000o(byVar2, str4, str5, str6));
                } catch (JSONException e) {
                    O0000O0o.O000000o(e);
                }
            }
        });
    }

    private static JSONObject O00000oO(by byVar, String str, String str2, String str3) throws JSONException {
        JSONObject O00000o0 = cv.O00000o0(byVar, str);
        O00000o0.put(cu.O000OO0o, cu.O000Oo0o);
        O00000o0.put(cu.O000Oo0O, str2);
        if (!TextUtils.isEmpty(str3)) {
            O00000o0.put(cu.O000OoOO, str3);
        }
        return O00000o0;
    }

    private static JSONObject O00000oo(by byVar, String str, String str2, String str3) throws JSONException {
        JSONObject O00000o0 = cv.O00000o0(byVar, str);
        O00000o0.put(cu.O000OO0o, cu.O000Ooo0);
        O00000o0.put(cu.O000Oo0O, str2);
        if (!TextUtils.isEmpty(str3)) {
            O00000o0.put(cu.O000OoOO, str3);
        }
        return O00000o0;
    }
}
