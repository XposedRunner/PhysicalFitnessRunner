package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.mapcore.util.o0O0O0o0.O000000o;
import com.amap.api.mapcore.util.o0O0O0o0.O000000o.O00000o;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.tencent.open.SocialConstants;
import com.tencent.stat.DeviceInfo;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: AuthTask */
public class g extends Thread {
    WeakReference<ca> O000000o = null;
    private Context O00000Oo;

    public g(Context context, ca caVar) {
        this.O00000Oo = context;
        this.O000000o = new WeakReference(caVar);
    }

    private void O000000o(Context context, o0OO0o00 o0oo0o00, O000000o o000000o) {
        if (o000000o != null && o000000o.O0000oo != null) {
            try {
                JSONObject optJSONObject = o000000o.O0000oo.optJSONObject("15S");
                String optString = optJSONObject.optString(SocialConstants.PARAM_URL, "");
                String optString2 = optJSONObject.optString("md5", "");
                boolean O000000o = o0O0O0o0.O000000o(optJSONObject.optString("able", ""), false);
                boolean O000000o2 = o0O0O0o0.O000000o(optJSONObject.optString("on", ""), false);
                boolean O000000o3 = o0O0O0o0.O000000o(optJSONObject.optString("mobileable", ""), false);
                boolean O000000o4 = o0O0O0o0.O000000o(optJSONObject.optString("di", ""), false);
                String optString3 = optJSONObject.optString("dis", "");
                if (!O000000o4 || o0OOOO00.O00000oo(optString3)) {
                    String optString4 = optJSONObject.optString("cg");
                    O00000Oo(this.O00000Oo, OOo000.O00000oO(), o000000o);
                    oO0O000o.O000000o().O000000o(this.O00000Oo, o0oo0o00, oO0O00Oo.O000000o(OOo000.O00000oO(), optString, optString2, O000000o, O000000o2, O000000o3, optString4));
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void O000000o(O000000o o000000o) {
        try {
            O000000o.O000000o o000000o2 = o000000o.O0000ooO;
            if (o000000o2 != null) {
                OOOOO0o.O000000o(this.O00000Oo, "maploc", "ue", Boolean.valueOf(o000000o2.O000000o));
                JSONObject jSONObject = o000000o2.O00000o0;
                int optInt = jSONObject.optInt("fn", 1000);
                int optInt2 = jSONObject.optInt("mpn", 0);
                if (optInt2 > 500) {
                    optInt2 = 500;
                }
                if (optInt2 < 30) {
                    optInt2 = 30;
                }
                oOOO0OO0.O000000o(optInt, o0O0O0o0.O000000o(jSONObject.optString("igu"), false));
                OOOOO0o.O000000o(this.O00000Oo, "maploc", "opn", Integer.valueOf(optInt2));
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "AuthUtil", "loadConfigDataUploadException");
        }
    }

    private void O00000Oo(Context context, o0OO0o00 o0oo0o00, O000000o o000000o) {
        if (o000000o != null && o000000o.O0000oo != null) {
            try {
                oO0O000o.O000000o().O000000o(context, o0oo0o00, o0O0O0o0.O000000o(o000000o.O0000oo.optJSONObject("151").optString("able", ""), false));
            } catch (Throwable unused) {
            }
        }
    }

    public void run() {
        try {
            if (MapsInitializer.getNetWorkEnable()) {
                JSONObject optJSONObject;
                o0OO00OO.O000000o().O000000o(this.O00000Oo);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("14S");
                stringBuilder.append(";");
                stringBuilder.append("11K");
                stringBuilder.append(";");
                stringBuilder.append("001");
                stringBuilder.append(";");
                stringBuilder.append("14M");
                stringBuilder.append(";");
                stringBuilder.append("14L");
                stringBuilder.append(";");
                stringBuilder.append("151");
                stringBuilder.append(";");
                stringBuilder.append("14Z");
                stringBuilder.append(";");
                stringBuilder.append("154");
                stringBuilder.append(";");
                stringBuilder.append("156");
                stringBuilder.append(";");
                stringBuilder.append("15C");
                stringBuilder.append(";");
                stringBuilder.append("15S");
                O000000o O000000o = o0O0O0o0.O000000o(this.O00000Oo, OOo000.O00000oO(), stringBuilder.toString(), null);
                if (!(o0O0O0o0.O000000o == 1 || O000000o == null || this.O000000o == null || this.O000000o.get() == null)) {
                    Message obtainMessage = ((ca) this.O000000o.get()).getMainHandler().obtainMessage();
                    obtainMessage.what = 2;
                    if (O000000o.O000000o != null) {
                        obtainMessage.obj = O000000o.O000000o;
                    }
                    ((ca) this.O000000o.get()).getMainHandler().sendMessage(obtainMessage);
                }
                if (!(O000000o == null || O000000o.O0000oo == null)) {
                    optJSONObject = O000000o.O0000oo.optJSONObject("154");
                    if (optJSONObject != null && o0O0O0o0.O000000o(optJSONObject.getString("able"), true)) {
                        Object optString = optJSONObject.optString(DeviceInfo.TAG_MAC);
                        Object optString2 = optJSONObject.optString("si");
                        if (!TextUtils.isEmpty(optString)) {
                            OOOO00O.O000000o(this.O00000Oo, "approval_number", DeviceInfo.TAG_MAC, optString);
                        }
                        if (!TextUtils.isEmpty(optString2)) {
                            OOOO00O.O000000o(this.O00000Oo, "approval_number", "si", optString2);
                        }
                    }
                }
                if (!(O000000o == null || O000000o.O0000ooO == null)) {
                    o0OO0o00 O00000oO = OOo000.O00000oO();
                    if (O00000oO != null) {
                        O00000oO.O000000o(O000000o.O0000ooO.O000000o);
                    }
                }
                if (!(!MapsInitializer.isDownloadCoordinateConvertLibrary() || O000000o == null || O000000o.O000O00o == null)) {
                    new o0O0Oo00(this.O00000Oo, "3dmap", O000000o.O000O00o.O000000o, O000000o.O000O00o.O00000Oo).O000000o();
                }
                if (O000000o != null) {
                    O000000o(O000000o);
                }
                String str = "able";
                if (O000000o != null) {
                    if (O000000o.O0000oo != null) {
                        JSONObject optJSONObject2 = O000000o.O0000oo.optJSONObject("14M");
                        if (optJSONObject2 != null && optJSONObject2.has(str) && o0O0O0o0.O000000o(optJSONObject2.getString(str), true)) {
                            int i = 2592000;
                            String str2 = "time";
                            if (optJSONObject2.has(str2)) {
                                i = Math.max(60, optJSONObject2.getInt(str2));
                            }
                            if (!(System.currentTimeMillis() - OOOO00O.O000000o(this.O00000Oo, "Map3DCache", "time", Long.valueOf(0)).longValue() <= ((long) (i * 1000)) || this.O000000o == null || this.O000000o.get() == null)) {
                                ((ca) this.O000000o.get()).O00000Oo();
                            }
                        }
                    }
                }
                if (!(O000000o == null || O000000o.O0000oo == null)) {
                    try {
                        JSONObject optJSONObject3 = O000000o.O0000oo.optJSONObject("14L");
                        if (optJSONObject3 != null && optJSONObject3.has(str)) {
                            boolean O000000o2 = o0O0O0o0.O000000o(optJSONObject3.getString(str), false);
                            if (!(this.O000000o == null || this.O000000o.get() == null)) {
                                ((ca) this.O000000o.get()).O0000Oo0(O000000o2 ^ 1);
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                if (!(O000000o == null || O000000o.O0000ooo == null)) {
                    O00000o o00000o = O000000o.O0000ooo;
                    if (o00000o != null) {
                        String str3 = o00000o.O00000Oo;
                        String str4 = o00000o.O000000o;
                        str = o00000o.O00000o0;
                        if (!(TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4))) {
                            if (!TextUtils.isEmpty(str)) {
                                new oOo00OO0(this.O00000Oo, new oO00OO0O(str4, str3, str), OOo000.O00000oO()).O000000o();
                            }
                        }
                        new oOo00OO0(this.O00000Oo, null, OOo000.O00000oO()).O000000o();
                    } else {
                        new oOo00OO0(this.O00000Oo, null, OOo000.O00000oO()).O000000o();
                    }
                }
                if (!(O000000o == null || O000000o.O0000oo == null)) {
                    optJSONObject = O000000o.O0000oo.optJSONObject("156");
                    if (optJSONObject != null) {
                        OOO0O0O.O000000o(o0O0O0o0.O000000o(optJSONObject.optString("able"), false));
                    }
                }
                if (!(O000000o == null || O000000o.O0000oo == null)) {
                    optJSONObject = O000000o.O0000oo.optJSONObject("15C");
                    if (optJSONObject != null) {
                        final boolean O000000o3 = o0O0O0o0.O000000o(optJSONObject.optString("able"), false);
                        final String optString3 = optJSONObject.optString("logo_day_url");
                        final String optString4 = optJSONObject.optString("logo_day_md5");
                        final String optString5 = optJSONObject.optString("logo_night_url");
                        final String optString6 = optJSONObject.optString("logo_night_md5");
                        OOOo000.O000000o().O000000o(new Runnable() {
                            public void run() {
                                boolean z;
                                String str;
                                String str2;
                                String str3;
                                O00000o o00000o;
                                if (!(TextUtils.isEmpty(optString4) || TextUtils.isEmpty(optString3))) {
                                    z = O000000o3;
                                    str = AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME;
                                    str2 = optString3;
                                    str3 = optString4;
                                    if (z) {
                                        o00000o = new O00000o(str2, str3, str);
                                        o00000o.O000000o("amap_web_logo", "md5_day");
                                        new ah(g.this.O00000Oo, o00000o, OOo000.O00000oO()).O000000o();
                                    }
                                    if (!(g.this.O000000o == null || g.this.O000000o.get() == null)) {
                                        ((ca) g.this.O000000o.get()).O000000o(str, z, 0);
                                    }
                                }
                                if (!TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString5)) {
                                    z = O000000o3;
                                    str = AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME;
                                    str2 = optString5;
                                    str3 = optString6;
                                    if (z) {
                                        o00000o = new O00000o(str2, str3, str);
                                        o00000o.O000000o("amap_web_logo", "md5_night");
                                        new ah(g.this.O00000Oo, o00000o, OOo000.O00000oO()).O000000o();
                                    }
                                    if (g.this.O000000o != null && g.this.O000000o.get() != null) {
                                        ((ca) g.this.O000000o.get()).O000000o(str, z, 1);
                                    }
                                }
                            }
                        });
                    }
                }
                if (!(O000000o == null || O000000o.O0000oo == null)) {
                    O000000o(this.O00000Oo, OOo000.O00000oO(), O000000o);
                }
                ooOOOOoo.O000000o(this.O00000Oo, OOo000.O00000oO());
                interrupt();
                if (!(this.O000000o == null || this.O000000o.get() == null)) {
                    ((ca) this.O000000o.get()).setRunLowFrame(false);
                }
            }
        } catch (Throwable th2) {
            interrupt();
            ooOOOOoo.O00000o0(th2, "AMapDelegateImpGLSurfaceView", "mVerfy");
            th2.printStackTrace();
        }
    }
}
