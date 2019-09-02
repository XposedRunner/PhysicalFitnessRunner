package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import defpackage.ai.O00000o;
import defpackage.ba.O000000o;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* compiled from: SessionTracker */
/* renamed from: aw */
public class aw implements O000000o {
    public static final String O000000o = "session_start_time";
    public static final String O00000Oo = "session_end_time";
    public static final String O00000o = "pre_session_id";
    public static final String O00000o0 = "session_id";
    public static final String O00000oO = "a_start_time";
    public static final String O00000oo = "a_end_time";
    private static String O0000O0o;
    private static Context O0000OOo;
    private static boolean O0000Oo0;

    /* compiled from: SessionTracker */
    /* renamed from: aw$O000000o */
    private static class O000000o {
        private static final aw O000000o = new aw();

        private O000000o() {
        }
    }

    private aw() {
        ba.O000000o().O000000o((O000000o) this);
    }

    public static aw O000000o() {
        return O000000o.O000000o;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0062 */
    /* JADX WARNING: Failed to process nested try/catch */
    private void O000000o(android.content.Context r3, java.lang.String r4, long r5, long r7) {
        /*
        r2 = this;
        r0 = O0000O0o;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x0014;
    L_0x0008:
        r0 = defpackage.ba.O000000o();
        r1 = O0000OOo;
        r0 = r0.O000000o(r1);
        O0000O0o = r0;
    L_0x0014:
        r0 = android.text.TextUtils.isEmpty(r4);
        if (r0 != 0) goto L_0x0078;
    L_0x001a:
        r0 = O0000O0o;
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x0023;
    L_0x0022:
        goto L_0x0078;
    L_0x0023:
        r0 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0062 }
        r0.<init>();	 Catch:{ Exception -> 0x0062 }
        r1 = "__f";
        r0.put(r1, r7);	 Catch:{ Exception -> 0x0062 }
        r7 = defpackage.z.O000000o();	 Catch:{ Exception -> 0x0062 }
        r7 = r7.O00000Oo();	 Catch:{ Exception -> 0x0062 }
        if (r7 == 0) goto L_0x0042;
    L_0x0037:
        r8 = r7.length();	 Catch:{ Exception -> 0x0062 }
        if (r8 <= 0) goto L_0x0042;
    L_0x003d:
        r8 = "__sp";
        r0.put(r8, r7);	 Catch:{ Exception -> 0x0062 }
    L_0x0042:
        r7 = defpackage.z.O000000o();	 Catch:{ Exception -> 0x0062 }
        r7 = r7.O00000o0();	 Catch:{ Exception -> 0x0062 }
        if (r7 == 0) goto L_0x0057;
    L_0x004c:
        r8 = r7.length();	 Catch:{ Exception -> 0x0062 }
        if (r8 <= 0) goto L_0x0057;
    L_0x0052:
        r8 = "__pp";
        r0.put(r8, r7);	 Catch:{ Exception -> 0x0062 }
    L_0x0057:
        r7 = defpackage.am.O000000o(r3);	 Catch:{ Exception -> 0x0062 }
        r8 = O0000O0o;	 Catch:{ Exception -> 0x0062 }
        r1 = defpackage.am.O000000o.END;	 Catch:{ Exception -> 0x0062 }
        r7.O000000o(r8, r0, r1);	 Catch:{ Exception -> 0x0062 }
    L_0x0062:
        r7 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0075 }
        r7.<init>();	 Catch:{ Exception -> 0x0075 }
        r8 = "__e";
        r7.put(r8, r5);	 Catch:{ Exception -> 0x0075 }
        r3 = defpackage.am.O000000o(r3);	 Catch:{ Exception -> 0x0075 }
        r5 = defpackage.am.O000000o.BEGIN;	 Catch:{ Exception -> 0x0075 }
        r3.O000000o(r4, r7, r5);	 Catch:{ Exception -> 0x0075 }
    L_0x0075:
        O0000O0o = r4;
        return;
    L_0x0078:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.aw.O000000o(android.content.Context, java.lang.String, long, long):void");
    }

    private void O000000o(String str, long j) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(O0000OOo);
        if (sharedPreferences != null) {
            long j2 = sharedPreferences.getLong(O00000Oo, 0);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("__ii", str);
                jSONObject.put("__e", j);
                jSONObject.put(O00000o.O000000o.O0000O0o, j2);
                double[] O000000o = u.O000000o();
                if (O000000o != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("lat", O000000o[0]);
                    jSONObject2.put("lng", O000000o[1]);
                    jSONObject2.put("ts", System.currentTimeMillis());
                    jSONObject.put(O00000o.O000000o.O00000oO, jSONObject2);
                }
                Class cls = Class.forName("android.net.TrafficStats");
                Method method = cls.getMethod("getUidRxBytes", new Class[]{Integer.TYPE});
                Method method2 = cls.getMethod("getUidTxBytes", new Class[]{Integer.TYPE});
                if (O0000OOo.getApplicationInfo().uid != -1) {
                    long longValue = ((Long) method.invoke(null, new Object[]{Integer.valueOf(O0000OOo.getApplicationInfo().uid)})).longValue();
                    j = ((Long) method2.invoke(null, new Object[]{Integer.valueOf(r5)})).longValue();
                    if (longValue > 0) {
                        if (j > 0) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put(ah.O000O0o, longValue);
                            jSONObject3.put(ah.O000O0o0, j);
                            jSONObject.put(O00000o.O000000o.O00000o, jSONObject3);
                        }
                    }
                    am.O000000o(O0000OOo).O000000o(str, jSONObject, am.O000000o.NEWSESSION);
                    ax.O000000o(O0000OOo);
                    ap.O000000o(O0000OOo);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private String O00000Oo(Context context) {
        if (O0000OOo == null && context != null) {
            O0000OOo = context.getApplicationContext();
        }
        String O00000o = ba.O000000o().O00000o(O0000OOo);
        try {
            O00000o0(context);
            aq.O000000o(O0000OOo).O00000o(null);
        } catch (Throwable unused) {
        }
        return O00000o;
    }

    private void O00000o0(Context context) {
        aq.O000000o(context).O00000Oo(context);
        aq.O000000o(context).O00000o();
    }

    public String O000000o(Context context) {
        try {
            if (O0000O0o == null) {
                return PreferenceWrapper.getDefault(context).getString(O00000o0, null);
            }
        } catch (Throwable unused) {
        }
        return O0000O0o;
    }

    public String O000000o(Context context, long j, boolean z) {
        String O00000Oo = ba.O000000o().O00000Oo(context);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("--->>> onInstantSessionInternal: current session id = ");
        stringBuilder.append(O00000Oo);
        UMRTLog.i("MobclickRT", stringBuilder.toString());
        try {
            Object jSONObject = new JSONObject();
            jSONObject.put("__e", j);
            JSONObject O00000Oo2 = z.O000000o().O00000Oo();
            if (O00000Oo2 != null && O00000Oo2.length() > 0) {
                jSONObject.put("__sp", O00000Oo2);
            }
            O00000Oo2 = z.O000000o().O00000o0();
            if (O00000Oo2 != null && O00000Oo2.length() > 0) {
                jSONObject.put("__pp", O00000Oo2);
            }
            am.O000000o(context).O000000o(O00000Oo, (JSONObject) jSONObject, am.O000000o.INSTANTSESSIONBEGIN);
            aq.O000000o(context).O000000o(jSONObject, z);
        } catch (Throwable unused) {
        }
        return O00000Oo;
    }

    public void O000000o(Context context, long j) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(O0000OOo);
        if (sharedPreferences != null) {
            Editor edit = sharedPreferences.edit();
            if (edit != null) {
                edit.putLong(O000000o, j);
                edit.commit();
            }
        }
    }

    public void O000000o(Context context, Object obj) {
        try {
            if (O0000OOo == null && context != null) {
                O0000OOo = context.getApplicationContext();
            }
            long longValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(O0000OOo);
            if (sharedPreferences != null) {
                Editor edit = sharedPreferences.edit();
                if (edit != null) {
                    String string = sharedPreferences.getString(ah.O000oOO0, "");
                    String appVersionName = UMUtils.getAppVersionName(O0000OOo);
                    if (TextUtils.isEmpty(string)) {
                        edit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                        edit.putString(ah.O000oOO0, appVersionName);
                        edit.commit();
                    } else if (!string.equals(appVersionName)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("--->>> onStartSessionInternal: upgrade version: ");
                        stringBuilder.append(string);
                        stringBuilder.append("-> ");
                        stringBuilder.append(appVersionName);
                        UMRTLog.i("MobclickRT", stringBuilder.toString());
                        int i = sharedPreferences.getInt("versioncode", 0);
                        String string2 = sharedPreferences.getString("pre_date", "");
                        String string3 = sharedPreferences.getString("pre_version", "");
                        String string4 = sharedPreferences.getString(ah.O000oOO0, "");
                        edit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                        edit.putString(ah.O000oOO0, appVersionName);
                        edit.putString("vers_date", string2);
                        edit.putString("vers_pre_version", string3);
                        edit.putString("cur_version", string4);
                        edit.putInt("vers_code", i);
                        edit.putString("vers_name", string);
                        if (longValue - sharedPreferences.getLong(O00000oo, 0) < ba.O000000o().O00000Oo()) {
                            edit.putLong(O00000oo, 0);
                            edit.commit();
                            if (O0000Oo0) {
                                O0000Oo0 = false;
                                O00000Oo(O0000OOo, longValue);
                                O00000o0(O0000OOo, longValue);
                            }
                            return;
                        }
                        edit.commit();
                    }
                    StringBuilder stringBuilder2;
                    if (O0000Oo0) {
                        O0000Oo0 = false;
                        O0000O0o = O00000Oo(context);
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append("Start new session: ");
                        stringBuilder3.append(O0000O0o);
                        MLog.i(stringBuilder3.toString());
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("mSessionChanged flag has been set, Start new session: ");
                        stringBuilder2.append(O0000O0o);
                        UMRTLog.i("MobclickRT", stringBuilder2.toString());
                    } else {
                        O0000O0o = sharedPreferences.getString(O00000o0, null);
                        edit.putLong(O00000oO, longValue);
                        edit.putLong(O00000oo, 0);
                        edit.commit();
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Extend current session: ");
                        stringBuilder2.append(O0000O0o);
                        MLog.i(stringBuilder2.toString());
                        StringBuilder stringBuilder4 = new StringBuilder();
                        stringBuilder4.append("Extend current session: ");
                        stringBuilder4.append(O0000O0o);
                        UMRTLog.i("MobclickRT", stringBuilder4.toString());
                        O00000o0(context);
                        aq.O000000o(O0000OOo).O000000o(false);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void O000000o(String str, long j, long j2) {
        if (!TextUtils.isEmpty(str)) {
            O000000o(str, j);
        }
    }

    public void O000000o(String str, String str2, long j, long j2) {
        O000000o(O0000OOo, str2, j, j2);
        UMRTLog.i("MobclickRT", "saveSessionToDB: complete");
        if (AnalyticsConstants.SUB_PROCESS_EVENT) {
            UMWorkDispatch.sendEvent(O0000OOo, bh.O000000o, bh.O000000o(O0000OOo), Long.valueOf(System.currentTimeMillis()));
        }
    }

    public String O00000Oo() {
        return O0000O0o;
    }

    public void O00000Oo(Context context, Object obj) {
        try {
            if (O0000OOo == null) {
                O0000OOo = UMGlobalContext.getAppContext(context);
            }
            long currentTimeMillis = obj == null ? System.currentTimeMillis() : ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(O0000OOo);
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString(ah.O000oOO0, "");
                String appVersionName = UMUtils.getAppVersionName(O0000OOo);
                Editor edit = sharedPreferences.edit();
                if (edit != null) {
                    if (TextUtils.isEmpty(string) || string.equals(appVersionName)) {
                        if (ba.O000000o().O00000oO(O0000OOo)) {
                            UMRTLog.i("MobclickRT", "--->>> More then 30 sec from last session.");
                            O0000Oo0 = true;
                            edit.putLong(O000000o, currentTimeMillis);
                            edit.commit();
                            O000000o(O0000OOo, currentTimeMillis, false);
                        } else {
                            UMRTLog.i("MobclickRT", "--->>> less then 30 sec from last session, do nothing.");
                            O0000Oo0 = false;
                        }
                        return;
                    }
                    UMRTLog.i("MobclickRT", "--->>> requestNewInstantSessionIf: version upgrade");
                    edit.putLong(O000000o, currentTimeMillis);
                    edit.commit();
                    aq.O000000o(O0000OOo).O000000o(null, true);
                    String O00000o0 = ba.O000000o().O00000o0(O0000OOo);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("--->>> force generate new session: session id = ");
                    stringBuilder.append(O00000o0);
                    UMRTLog.i("MobclickRT", stringBuilder.toString());
                    O0000Oo0 = true;
                    O000000o(O0000OOo, currentTimeMillis, true);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public boolean O00000Oo(Context context, long j) {
        boolean z = false;
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (sharedPreferences == null) {
                return false;
            }
            String O000000o = ba.O000000o().O000000o(O0000OOo);
            if (O000000o == null) {
                return false;
            }
            long j2 = sharedPreferences.getLong(O00000oO, 0);
            long j3 = sharedPreferences.getLong(O00000oo, 0);
            if (j2 > 0 && j3 == 0) {
                z = true;
                O00000o0(O0000OOo, Long.valueOf(j));
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(O00000o.O000000o.O0000O0o, j);
                JSONObject O00000Oo = z.O000000o().O00000Oo();
                if (O00000Oo != null && O00000Oo.length() > 0) {
                    jSONObject.put("__sp", O00000Oo);
                }
                O00000Oo = z.O000000o().O00000o0();
                if (O00000Oo != null && O00000Oo.length() > 0) {
                    jSONObject.put("__pp", O00000Oo);
                }
                am.O000000o(context).O000000o(O000000o, jSONObject, am.O000000o.END);
                aq.O000000o(O0000OOo).O00000oO();
            }
            return z;
        } catch (Throwable unused) {
        }
    }

    public String O00000o0() {
        return O000000o(O0000OOo);
    }

    public void O00000o0(Context context, long j) {
        if (PreferenceWrapper.getDefault(context) != null) {
            try {
                aq.O000000o(O0000OOo).O00000o0(null);
            } catch (Throwable unused) {
            }
        }
    }

    public void O00000o0(Context context, Object obj) {
        try {
            if (O0000OOo == null && context != null) {
                O0000OOo = context.getApplicationContext();
            }
            long longValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (sharedPreferences != null) {
                if (sharedPreferences.getLong(O00000oO, 0) == 0) {
                    MLog.e("onPause called before onResume");
                } else {
                    Editor edit = sharedPreferences.edit();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("--->>> onEndSessionInternal: write activity end time = ");
                    stringBuilder.append(longValue);
                    UMRTLog.i("MobclickRT", stringBuilder.toString());
                    edit.putLong(O00000oo, longValue);
                    edit.putLong(O00000Oo, longValue);
                    edit.commit();
                }
            }
        } catch (Throwable unused) {
        }
    }
}
