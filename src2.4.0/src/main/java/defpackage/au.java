package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.ximalaya.ting.android.player.XMediaPlayerConstants;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import jp.co.cyberagent.android.gpuimage.O000000o;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: EventTracker */
/* renamed from: au */
public class au {
    private static final String O000000o = "fs_lc_tl_uapp";
    private static final String O00000oo = "-1";
    private static Context O0000O0o;
    private final int O00000Oo;
    private final int O00000o;
    private final int O00000o0;
    private final int O00000oO;
    private JSONObject O0000OOo;

    /* compiled from: EventTracker */
    /* renamed from: au$O000000o */
    private static class O000000o {
        private static final au O000000o = new au();

        private O000000o() {
        }
    }

    private au() {
        this.O00000Oo = 128;
        this.O00000o0 = O000000o.O00000oO;
        this.O00000o = XMediaPlayerConstants.SEND_BUFFER_QUEUE_SIZE_FOR_LIVE;
        this.O00000oO = 10;
        this.O0000OOo = null;
        try {
            if (this.O0000OOo == null) {
                O00000Oo(O0000O0o);
            }
        } catch (Throwable unused) {
        }
    }

    public static au O000000o(Context context) {
        if (O0000O0o == null && context != null) {
            O0000O0o = context.getApplicationContext();
        }
        return O000000o.O000000o;
    }

    private JSONObject O000000o(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Entry entry : map.entrySet()) {
                try {
                    String str = (String) entry.getKey();
                    if (str != null) {
                        str = HelperUtils.subStr(str, 128);
                        Object value = entry.getValue();
                        if (value != null) {
                            int i = 0;
                            JSONArray jSONArray;
                            if (value.getClass().isArray()) {
                                if (value instanceof int[]) {
                                    int[] iArr = (int[]) value;
                                    jSONArray = new JSONArray();
                                    while (i < iArr.length) {
                                        jSONArray.put(iArr[i]);
                                        i++;
                                    }
                                    jSONObject.put(str, jSONArray);
                                } else if (value instanceof double[]) {
                                    double[] dArr = (double[]) value;
                                    jSONArray = new JSONArray();
                                    while (i < dArr.length) {
                                        jSONArray.put(dArr[i]);
                                        i++;
                                    }
                                    jSONObject.put(str, jSONArray);
                                } else if (value instanceof long[]) {
                                    long[] jArr = (long[]) value;
                                    jSONArray = new JSONArray();
                                    while (i < jArr.length) {
                                        jSONArray.put(jArr[i]);
                                        i++;
                                    }
                                    jSONObject.put(str, jSONArray);
                                } else if (value instanceof float[]) {
                                    float[] fArr = (float[]) value;
                                    jSONArray = new JSONArray();
                                    while (i < fArr.length) {
                                        jSONArray.put((double) fArr[i]);
                                        i++;
                                    }
                                    jSONObject.put(str, jSONArray);
                                } else if (value instanceof short[]) {
                                    short[] sArr = (short[]) value;
                                    jSONArray = new JSONArray();
                                    while (i < sArr.length) {
                                        jSONArray.put(sArr[i]);
                                        i++;
                                    }
                                    jSONObject.put(str, jSONArray);
                                }
                            } else if (value instanceof List) {
                                List list = (List) value;
                                jSONArray = new JSONArray();
                                while (i < list.size()) {
                                    Object obj = list.get(i);
                                    if ((obj instanceof String) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Short)) {
                                        jSONArray.put(list.get(i));
                                    }
                                    i++;
                                }
                                if (jSONArray.length() > 0) {
                                    jSONObject.put(str, jSONArray);
                                }
                            } else if (value instanceof String) {
                                jSONObject.put(str, HelperUtils.subStr(value.toString(), O000000o.O00000oO));
                            } else {
                                if (!((value instanceof Long) || (value instanceof Integer) || (value instanceof Float) || (value instanceof Double))) {
                                    if (!(value instanceof Short)) {
                                        MLog.e("The param has not support type. please check !");
                                    }
                                }
                                jSONObject.put(str, value);
                            }
                        }
                    }
                } catch (Exception e) {
                    MLog.e(e);
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void O000000o() {
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(O0000O0o, "track_list", "");
            if (!TextUtils.isEmpty(imprintProperty)) {
                String[] split = imprintProperty.split("!");
                JSONObject jSONObject = new JSONObject();
                int i = 0;
                if (this.O0000OOo != null) {
                    for (String subStr : split) {
                        String subStr2 = HelperUtils.subStr(subStr2, 128);
                        if (this.O0000OOo.has(subStr2)) {
                            jSONObject.put(subStr2, this.O0000OOo.get(subStr2));
                        }
                    }
                }
                this.O0000OOo = new JSONObject();
                if (split.length >= 10) {
                    while (i < 10) {
                        O000000o(split[i], jSONObject);
                        i++;
                    }
                } else {
                    while (i < split.length) {
                        O000000o(split[i], jSONObject);
                        i++;
                    }
                }
                O00000o0(O0000O0o);
            }
        } catch (Exception unused) {
        }
    }

    private void O000000o(String str, JSONObject jSONObject) throws JSONException {
        str = HelperUtils.subStr(str, 128);
        if (jSONObject.has(str)) {
            O000000o(str, ((Boolean) jSONObject.get(str)).booleanValue());
        } else {
            O000000o(str, false);
        }
    }

    private void O000000o(String str, boolean z) {
        try {
            if (!ah.O000OoO.equals(str) && !ah.O000OoO0.equals(str) && !"id".equals(str) && !"ts".equals(str) && !this.O0000OOo.has(str)) {
                this.O0000OOo.put(str, z);
            }
        } catch (Exception unused) {
        }
    }

    private boolean O000000o(String str) {
        if (str != null) {
            try {
                int length = str.trim().getBytes().length;
                if (length > 0 && length <= 128) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("key is ");
        stringBuilder.append(str);
        stringBuilder.append(", please check key, illegal");
        MLog.e(stringBuilder.toString());
        return false;
    }

    private void O00000Oo(Context context) {
        try {
            String string = PreferenceWrapper.getDefault(context).getString(O000000o, null);
            if (!TextUtils.isEmpty(string)) {
                this.O0000OOo = new JSONObject(string);
            }
            O000000o();
        } catch (Exception unused) {
        }
    }

    private boolean O00000Oo(String str) {
        if (str == null) {
            return true;
        }
        try {
            if (str.trim().getBytes().length <= O000000o.O00000oO) {
                return true;
            }
        } catch (Exception unused) {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("value is ");
        stringBuilder.append(str);
        stringBuilder.append(", please check value, illegal");
        MLog.e(stringBuilder.toString());
        return false;
    }

    private boolean O00000Oo(Map<String, Object> map) {
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    for (Entry entry : map.entrySet()) {
                        if (!O000000o((String) entry.getKey())) {
                            UMLog.aq(an.O0000OOo, 0, "\\|");
                            return false;
                        } else if (entry.getValue() == null) {
                            UMLog.aq(an.O0000Oo0, 0, "\\|");
                            return false;
                        } else if (entry.getValue() instanceof String) {
                            if (ah.O000oOo.equals(entry.getKey())) {
                                if (!O00000o0(entry.getValue().toString())) {
                                    UMLog.aq(an.O000OOo, 0, "\\|");
                                    return false;
                                }
                            } else if (!O00000Oo(entry.getValue().toString())) {
                                UMLog.aq(an.O0000Oo, 0, "\\|");
                                return false;
                            }
                        }
                    }
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        UMLog.aq(an.O0000O0o, 0, "\\|");
        return false;
    }

    private void O00000o0(Context context) {
        try {
            if (this.O0000OOo != null) {
                PreferenceWrapper.getDefault(O0000O0o).edit().putString(O000000o, this.O0000OOo.toString()).commit();
            }
        } catch (Throwable unused) {
        }
    }

    private boolean O00000o0(String str) {
        if (str == null) {
            return true;
        }
        try {
            if (str.trim().getBytes().length <= XMediaPlayerConstants.SEND_BUFFER_QUEUE_SIZE_FOR_LIVE) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00b4 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public void O000000o(java.lang.String r7, java.lang.String r8, long r9, int r11, java.lang.String r12) {
        /*
        r6 = this;
        r11 = r6.O000000o(r7);	 Catch:{ Throwable -> 0x010b }
        r0 = 0;
        if (r11 == 0) goto L_0x0103;
    L_0x0007:
        r11 = r6.O00000Oo(r8);	 Catch:{ Throwable -> 0x010b }
        if (r11 != 0) goto L_0x000f;
    L_0x000d:
        goto L_0x0103;
    L_0x000f:
        r11 = defpackage.ah.O000oOoo;	 Catch:{ Throwable -> 0x010b }
        r11 = java.util.Arrays.asList(r11);	 Catch:{ Throwable -> 0x010b }
        r11 = r11.contains(r7);	 Catch:{ Throwable -> 0x010b }
        if (r11 == 0) goto L_0x003c;
    L_0x001b:
        r8 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x010b }
        r8.<init>();	 Catch:{ Throwable -> 0x010b }
        r9 = "key is ";
        r8.append(r9);	 Catch:{ Throwable -> 0x010b }
        r8.append(r7);	 Catch:{ Throwable -> 0x010b }
        r7 = ", please check key, illegal";
        r8.append(r7);	 Catch:{ Throwable -> 0x010b }
        r7 = r8.toString();	 Catch:{ Throwable -> 0x010b }
        com.umeng.commonsdk.statistics.common.MLog.e(r7);	 Catch:{ Throwable -> 0x010b }
        r7 = defpackage.an.O0000o00;	 Catch:{ Throwable -> 0x010b }
        r8 = "\\|";
        com.umeng.commonsdk.debug.UMLog.aq(r7, r0, r8);	 Catch:{ Throwable -> 0x010b }
        return;
    L_0x003c:
        r1 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x010b }
        r11 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x010b }
        r11.<init>();	 Catch:{ Throwable -> 0x010b }
        r3 = "id";
        r11.put(r3, r7);	 Catch:{ Throwable -> 0x010b }
        r3 = "ts";
        r11.put(r3, r1);	 Catch:{ Throwable -> 0x010b }
        r3 = 0;
        r5 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1));
        if (r5 <= 0) goto L_0x005a;
    L_0x0055:
        r3 = "du";
        r11.put(r3, r9);	 Catch:{ Throwable -> 0x010b }
    L_0x005a:
        r9 = "__t";
        r10 = 2049; // 0x801 float:2.871E-42 double:1.0123E-320;
        r11.put(r9, r10);	 Catch:{ Throwable -> 0x010b }
        if (r8 != 0) goto L_0x0065;
    L_0x0063:
        r8 = "";
    L_0x0065:
        r11.put(r7, r8);	 Catch:{ Throwable -> 0x010b }
        r8 = com.umeng.commonsdk.service.UMGlobalContext.getInstance();	 Catch:{ Throwable -> 0x010b }
        r9 = O0000O0o;	 Catch:{ Throwable -> 0x010b }
        r8 = r8.isMainProcess(r9);	 Catch:{ Throwable -> 0x010b }
        if (r8 == 0) goto L_0x0083;
    L_0x0074:
        r8 = defpackage.ba.O000000o();	 Catch:{ Throwable -> 0x010b }
        r9 = O0000O0o;	 Catch:{ Throwable -> 0x010b }
        r9 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext(r9);	 Catch:{ Throwable -> 0x010b }
        r8 = r8.O00000o(r9);	 Catch:{ Throwable -> 0x010b }
        goto L_0x0091;
    L_0x0083:
        r8 = defpackage.ba.O000000o();	 Catch:{ Throwable -> 0x010b }
        r9 = O0000O0o;	 Catch:{ Throwable -> 0x010b }
        r9 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext(r9);	 Catch:{ Throwable -> 0x010b }
        r8 = r8.O000000o(r9, r1);	 Catch:{ Throwable -> 0x010b }
    L_0x0091:
        r9 = "__i";
        r10 = android.text.TextUtils.isEmpty(r8);	 Catch:{ Throwable -> 0x010b }
        if (r10 == 0) goto L_0x009b;
    L_0x0099:
        r8 = "-1";
    L_0x009b:
        r11.put(r9, r8);	 Catch:{ Throwable -> 0x010b }
        r8 = android.text.TextUtils.isEmpty(r12);	 Catch:{ Throwable -> 0x010b }
        if (r8 != 0) goto L_0x00b4;
    L_0x00a4:
        r8 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00b4 }
        r8.<init>(r12);	 Catch:{ JSONException -> 0x00b4 }
        r9 = r8.length();	 Catch:{ JSONException -> 0x00b4 }
        if (r9 <= 0) goto L_0x00b4;
    L_0x00af:
        r9 = "_$sp";
        r11.put(r9, r8);	 Catch:{ JSONException -> 0x00b4 }
    L_0x00b4:
        r8 = "ds";
        r11.put(r8, r0);	 Catch:{ Throwable -> 0x010b }
        r8 = "pn";
        r9 = com.umeng.commonsdk.service.UMGlobalContext.getInstance();	 Catch:{ Throwable -> 0x010b }
        r10 = O0000O0o;	 Catch:{ Throwable -> 0x010b }
        r9 = r9.getProcessName(r10);	 Catch:{ Throwable -> 0x010b }
        r11.put(r8, r9);	 Catch:{ Throwable -> 0x010b }
        r6.O000000o();	 Catch:{ Throwable -> 0x010b }
        r8 = r6.O0000OOo;	 Catch:{ Throwable -> 0x010b }
        if (r8 == 0) goto L_0x00f5;
    L_0x00cf:
        r8 = r6.O0000OOo;	 Catch:{ Throwable -> 0x010b }
        r8 = r8.has(r7);	 Catch:{ Throwable -> 0x010b }
        if (r8 == 0) goto L_0x00f5;
    L_0x00d7:
        r8 = r6.O0000OOo;	 Catch:{ Throwable -> 0x010b }
        r8 = r8.get(r7);	 Catch:{ Throwable -> 0x010b }
        r8 = (java.lang.Boolean) r8;	 Catch:{ Throwable -> 0x010b }
        r8 = r8.booleanValue();	 Catch:{ Throwable -> 0x010b }
        if (r8 != 0) goto L_0x00f5;
    L_0x00e5:
        r8 = "$st_fl";
        r9 = 1;
        r11.put(r8, r9);	 Catch:{ Throwable -> 0x010b }
        r8 = r6.O0000OOo;	 Catch:{ Throwable -> 0x010b }
        r8.put(r7, r9);	 Catch:{ Throwable -> 0x010b }
        r7 = O0000O0o;	 Catch:{ Throwable -> 0x010b }
        r6.O00000o0(r7);	 Catch:{ Throwable -> 0x010b }
    L_0x00f5:
        r7 = O0000O0o;	 Catch:{ Throwable -> 0x010b }
        r8 = 4097; // 0x1001 float:5.741E-42 double:2.024E-320;
        r9 = O0000O0o;	 Catch:{ Throwable -> 0x010b }
        r9 = defpackage.v.O000000o(r9);	 Catch:{ Throwable -> 0x010b }
        com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(r7, r8, r9, r11);	 Catch:{ Throwable -> 0x010b }
        goto L_0x010b;
    L_0x0103:
        r7 = defpackage.an.O0000Ooo;	 Catch:{ Throwable -> 0x010b }
        r8 = "\\|";
        com.umeng.commonsdk.debug.UMLog.aq(r7, r0, r8);	 Catch:{ Throwable -> 0x010b }
        return;
    L_0x010b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.au.O000000o(java.lang.String, java.lang.String, long, int, java.lang.String):void");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:132:0x0278 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public void O000000o(java.lang.String r8, java.util.Map<java.lang.String, java.lang.Object> r9, long r10, java.lang.String r12) {
        /*
        r7 = this;
        r0 = r7.O000000o(r8);	 Catch:{ Throwable -> 0x02de }
        r1 = 0;
        if (r0 != 0) goto L_0x000f;
    L_0x0007:
        r8 = defpackage.an.O00000oo;	 Catch:{ Throwable -> 0x02de }
        r9 = "\\|";
        com.umeng.commonsdk.debug.UMLog.aq(r8, r1, r9);	 Catch:{ Throwable -> 0x02de }
        return;
    L_0x000f:
        r0 = r7.O00000Oo(r9);	 Catch:{ Throwable -> 0x02de }
        if (r0 != 0) goto L_0x0016;
    L_0x0015:
        return;
    L_0x0016:
        r0 = r9.size();	 Catch:{ Throwable -> 0x02de }
        r2 = 10;
        if (r0 <= r2) goto L_0x003c;
    L_0x001e:
        r8 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x02de }
        r8.<init>();	 Catch:{ Throwable -> 0x02de }
        r10 = "map size is ";
        r8.append(r10);	 Catch:{ Throwable -> 0x02de }
        r9 = r9.size();	 Catch:{ Throwable -> 0x02de }
        r8.append(r9);	 Catch:{ Throwable -> 0x02de }
        r9 = ", please check";
        r8.append(r9);	 Catch:{ Throwable -> 0x02de }
        r8 = r8.toString();	 Catch:{ Throwable -> 0x02de }
        com.umeng.commonsdk.statistics.common.MLog.e(r8);	 Catch:{ Throwable -> 0x02de }
        return;
    L_0x003c:
        r0 = defpackage.ah.O000oOoo;	 Catch:{ Throwable -> 0x02de }
        r0 = java.util.Arrays.asList(r0);	 Catch:{ Throwable -> 0x02de }
        r0 = r0.contains(r8);	 Catch:{ Throwable -> 0x02de }
        if (r0 == 0) goto L_0x0069;
    L_0x0048:
        r9 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x02de }
        r9.<init>();	 Catch:{ Throwable -> 0x02de }
        r10 = "key is ";
        r9.append(r10);	 Catch:{ Throwable -> 0x02de }
        r9.append(r8);	 Catch:{ Throwable -> 0x02de }
        r8 = ", please check key, illegal";
        r9.append(r8);	 Catch:{ Throwable -> 0x02de }
        r8 = r9.toString();	 Catch:{ Throwable -> 0x02de }
        com.umeng.commonsdk.statistics.common.MLog.e(r8);	 Catch:{ Throwable -> 0x02de }
        r8 = defpackage.an.O00000Oo;	 Catch:{ Throwable -> 0x02de }
        r9 = "\\|";
        com.umeng.commonsdk.debug.UMLog.aq(r8, r1, r9);	 Catch:{ Throwable -> 0x02de }
        return;
    L_0x0069:
        r0 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x02de }
        r0.<init>();	 Catch:{ Throwable -> 0x02de }
        r3 = "id";
        r0.put(r3, r8);	 Catch:{ Throwable -> 0x02de }
        r3 = "ts";
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x02de }
        r0.put(r3, r4);	 Catch:{ Throwable -> 0x02de }
        r3 = 0;
        r5 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1));
        if (r5 <= 0) goto L_0x0087;
    L_0x0082:
        r3 = "du";
        r0.put(r3, r10);	 Catch:{ Throwable -> 0x02de }
    L_0x0087:
        r10 = "__t";
        r11 = 2049; // 0x801 float:2.871E-42 double:1.0123E-320;
        r0.put(r10, r11);	 Catch:{ Throwable -> 0x02de }
        r10 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x02de }
        r10.<init>();	 Catch:{ Throwable -> 0x02de }
        r11 = "befort ekv map, event is ";
        r10.append(r11);	 Catch:{ Throwable -> 0x02de }
        r11 = r0.toString();	 Catch:{ Throwable -> 0x02de }
        r10.append(r11);	 Catch:{ Throwable -> 0x02de }
        r10 = r10.toString();	 Catch:{ Throwable -> 0x02de }
        com.umeng.commonsdk.statistics.common.ULog.i(r10);	 Catch:{ Throwable -> 0x02de }
        r9 = r9.entrySet();	 Catch:{ Throwable -> 0x02de }
        r9 = r9.iterator();	 Catch:{ Throwable -> 0x02de }
    L_0x00ae:
        r10 = r9.hasNext();	 Catch:{ Throwable -> 0x02de }
        if (r10 == 0) goto L_0x0226;
    L_0x00b4:
        r10 = r9.next();	 Catch:{ Throwable -> 0x02de }
        r10 = (java.util.Map.Entry) r10;	 Catch:{ Throwable -> 0x02de }
        r11 = defpackage.ah.O000oOoo;	 Catch:{ Throwable -> 0x02de }
        r11 = java.util.Arrays.asList(r11);	 Catch:{ Throwable -> 0x02de }
        r3 = r10.getKey();	 Catch:{ Throwable -> 0x02de }
        r11 = r11.contains(r3);	 Catch:{ Throwable -> 0x02de }
        if (r11 != 0) goto L_0x021e;
    L_0x00ca:
        r11 = r10.getValue();	 Catch:{ Throwable -> 0x02de }
        r3 = r11 instanceof java.lang.String;	 Catch:{ Throwable -> 0x02de }
        if (r3 != 0) goto L_0x0213;
    L_0x00d2:
        r3 = r11 instanceof java.lang.Integer;	 Catch:{ Throwable -> 0x02de }
        if (r3 != 0) goto L_0x0213;
    L_0x00d6:
        r3 = r11 instanceof java.lang.Long;	 Catch:{ Throwable -> 0x02de }
        if (r3 != 0) goto L_0x0213;
    L_0x00da:
        r3 = r11 instanceof java.lang.Short;	 Catch:{ Throwable -> 0x02de }
        if (r3 != 0) goto L_0x0213;
    L_0x00de:
        r3 = r11 instanceof java.lang.Float;	 Catch:{ Throwable -> 0x02de }
        if (r3 != 0) goto L_0x0213;
    L_0x00e2:
        r3 = r11 instanceof java.lang.Double;	 Catch:{ Throwable -> 0x02de }
        if (r3 == 0) goto L_0x00e8;
    L_0x00e6:
        goto L_0x0213;
    L_0x00e8:
        r3 = r11.getClass();	 Catch:{ Throwable -> 0x02de }
        r3 = r3.isArray();	 Catch:{ Throwable -> 0x02de }
        if (r3 == 0) goto L_0x020d;
    L_0x00f2:
        r3 = r11 instanceof int[];	 Catch:{ Throwable -> 0x02de }
        if (r3 == 0) goto L_0x011c;
    L_0x00f6:
        r11 = (int[]) r11;	 Catch:{ Throwable -> 0x02de }
        r3 = r11.length;	 Catch:{ Throwable -> 0x02de }
        if (r3 <= r2) goto L_0x0101;
    L_0x00fb:
        r8 = "please check key or value, size overlength!";
        com.umeng.commonsdk.statistics.common.MLog.e(r8);	 Catch:{ Throwable -> 0x02de }
        return;
    L_0x0101:
        r3 = new org.json.JSONArray;	 Catch:{ Throwable -> 0x02de }
        r3.<init>();	 Catch:{ Throwable -> 0x02de }
        r4 = r1;
    L_0x0107:
        r5 = r11.length;	 Catch:{ Throwable -> 0x02de }
        if (r4 >= r5) goto L_0x0112;
    L_0x010a:
        r5 = r11[r4];	 Catch:{ Throwable -> 0x02de }
        r3.put(r5);	 Catch:{ Throwable -> 0x02de }
        r4 = r4 + 1;
        goto L_0x0107;
    L_0x0112:
        r10 = r10.getKey();	 Catch:{ Throwable -> 0x02de }
        r10 = (java.lang.String) r10;	 Catch:{ Throwable -> 0x02de }
        r0.put(r10, r3);	 Catch:{ Throwable -> 0x02de }
        goto L_0x00ae;
    L_0x011c:
        r3 = r11 instanceof double[];	 Catch:{ Throwable -> 0x02de }
        if (r3 == 0) goto L_0x0147;
    L_0x0120:
        r11 = (double[]) r11;	 Catch:{ Throwable -> 0x02de }
        r3 = r11.length;	 Catch:{ Throwable -> 0x02de }
        if (r3 <= r2) goto L_0x012b;
    L_0x0125:
        r8 = "please check key or value, size overlength!";
        com.umeng.commonsdk.statistics.common.MLog.e(r8);	 Catch:{ Throwable -> 0x02de }
        return;
    L_0x012b:
        r3 = new org.json.JSONArray;	 Catch:{ Throwable -> 0x02de }
        r3.<init>();	 Catch:{ Throwable -> 0x02de }
        r4 = r1;
    L_0x0131:
        r5 = r11.length;	 Catch:{ Throwable -> 0x02de }
        if (r4 >= r5) goto L_0x013c;
    L_0x0134:
        r5 = r11[r4];	 Catch:{ Throwable -> 0x02de }
        r3.put(r5);	 Catch:{ Throwable -> 0x02de }
        r4 = r4 + 1;
        goto L_0x0131;
    L_0x013c:
        r10 = r10.getKey();	 Catch:{ Throwable -> 0x02de }
        r10 = (java.lang.String) r10;	 Catch:{ Throwable -> 0x02de }
        r0.put(r10, r3);	 Catch:{ Throwable -> 0x02de }
        goto L_0x00ae;
    L_0x0147:
        r3 = r11 instanceof long[];	 Catch:{ Throwable -> 0x02de }
        if (r3 == 0) goto L_0x0172;
    L_0x014b:
        r11 = (long[]) r11;	 Catch:{ Throwable -> 0x02de }
        r3 = r11.length;	 Catch:{ Throwable -> 0x02de }
        if (r3 <= r2) goto L_0x0156;
    L_0x0150:
        r8 = "please check key or value, size overlength!";
        com.umeng.commonsdk.statistics.common.MLog.e(r8);	 Catch:{ Throwable -> 0x02de }
        return;
    L_0x0156:
        r3 = new org.json.JSONArray;	 Catch:{ Throwable -> 0x02de }
        r3.<init>();	 Catch:{ Throwable -> 0x02de }
        r4 = r1;
    L_0x015c:
        r5 = r11.length;	 Catch:{ Throwable -> 0x02de }
        if (r4 >= r5) goto L_0x0167;
    L_0x015f:
        r5 = r11[r4];	 Catch:{ Throwable -> 0x02de }
        r3.put(r5);	 Catch:{ Throwable -> 0x02de }
        r4 = r4 + 1;
        goto L_0x015c;
    L_0x0167:
        r10 = r10.getKey();	 Catch:{ Throwable -> 0x02de }
        r10 = (java.lang.String) r10;	 Catch:{ Throwable -> 0x02de }
        r0.put(r10, r3);	 Catch:{ Throwable -> 0x02de }
        goto L_0x00ae;
    L_0x0172:
        r3 = r11 instanceof float[];	 Catch:{ Throwable -> 0x02de }
        if (r3 == 0) goto L_0x019e;
    L_0x0176:
        r11 = (float[]) r11;	 Catch:{ Throwable -> 0x02de }
        r3 = r11.length;	 Catch:{ Throwable -> 0x02de }
        if (r3 <= r2) goto L_0x0181;
    L_0x017b:
        r8 = "please check key or value, size overlength!";
        com.umeng.commonsdk.statistics.common.MLog.e(r8);	 Catch:{ Throwable -> 0x02de }
        return;
    L_0x0181:
        r3 = new org.json.JSONArray;	 Catch:{ Throwable -> 0x02de }
        r3.<init>();	 Catch:{ Throwable -> 0x02de }
        r4 = r1;
    L_0x0187:
        r5 = r11.length;	 Catch:{ Throwable -> 0x02de }
        if (r4 >= r5) goto L_0x0193;
    L_0x018a:
        r5 = r11[r4];	 Catch:{ Throwable -> 0x02de }
        r5 = (double) r5;	 Catch:{ Throwable -> 0x02de }
        r3.put(r5);	 Catch:{ Throwable -> 0x02de }
        r4 = r4 + 1;
        goto L_0x0187;
    L_0x0193:
        r10 = r10.getKey();	 Catch:{ Throwable -> 0x02de }
        r10 = (java.lang.String) r10;	 Catch:{ Throwable -> 0x02de }
        r0.put(r10, r3);	 Catch:{ Throwable -> 0x02de }
        goto L_0x00ae;
    L_0x019e:
        r3 = r11 instanceof short[];	 Catch:{ Throwable -> 0x02de }
        if (r3 == 0) goto L_0x01c9;
    L_0x01a2:
        r11 = (short[]) r11;	 Catch:{ Throwable -> 0x02de }
        r3 = r11.length;	 Catch:{ Throwable -> 0x02de }
        if (r3 <= r2) goto L_0x01ad;
    L_0x01a7:
        r8 = "please check key or value, size overlength!";
        com.umeng.commonsdk.statistics.common.MLog.e(r8);	 Catch:{ Throwable -> 0x02de }
        return;
    L_0x01ad:
        r3 = new org.json.JSONArray;	 Catch:{ Throwable -> 0x02de }
        r3.<init>();	 Catch:{ Throwable -> 0x02de }
        r4 = r1;
    L_0x01b3:
        r5 = r11.length;	 Catch:{ Throwable -> 0x02de }
        if (r4 >= r5) goto L_0x01be;
    L_0x01b6:
        r5 = r11[r4];	 Catch:{ Throwable -> 0x02de }
        r3.put(r5);	 Catch:{ Throwable -> 0x02de }
        r4 = r4 + 1;
        goto L_0x01b3;
    L_0x01be:
        r10 = r10.getKey();	 Catch:{ Throwable -> 0x02de }
        r10 = (java.lang.String) r10;	 Catch:{ Throwable -> 0x02de }
        r0.put(r10, r3);	 Catch:{ Throwable -> 0x02de }
        goto L_0x00ae;
    L_0x01c9:
        r3 = r11 instanceof java.lang.String[];	 Catch:{ Throwable -> 0x02de }
        if (r3 == 0) goto L_0x0207;
    L_0x01cd:
        r11 = (java.lang.String[]) r11;	 Catch:{ Throwable -> 0x02de }
        r3 = r11.length;	 Catch:{ Throwable -> 0x02de }
        if (r3 <= r2) goto L_0x01d8;
    L_0x01d2:
        r8 = "please check key or value, size overlength!";
        com.umeng.commonsdk.statistics.common.MLog.e(r8);	 Catch:{ Throwable -> 0x02de }
        return;
    L_0x01d8:
        r3 = new org.json.JSONArray;	 Catch:{ Throwable -> 0x02de }
        r3.<init>();	 Catch:{ Throwable -> 0x02de }
        r4 = r1;
    L_0x01de:
        r5 = r11.length;	 Catch:{ Throwable -> 0x02de }
        if (r4 >= r5) goto L_0x01fc;
    L_0x01e1:
        r5 = r11[r4];	 Catch:{ Throwable -> 0x02de }
        if (r5 != 0) goto L_0x01eb;
    L_0x01e5:
        r8 = "please check array, null item!";
        com.umeng.commonsdk.statistics.common.MLog.e(r8);	 Catch:{ Throwable -> 0x02de }
        return;
    L_0x01eb:
        r5 = r11[r4];	 Catch:{ Throwable -> 0x02de }
        r5 = r7.O00000Oo(r5);	 Catch:{ Throwable -> 0x02de }
        if (r5 != 0) goto L_0x01f4;
    L_0x01f3:
        return;
    L_0x01f4:
        r5 = r11[r4];	 Catch:{ Throwable -> 0x02de }
        r3.put(r5);	 Catch:{ Throwable -> 0x02de }
        r4 = r4 + 1;
        goto L_0x01de;
    L_0x01fc:
        r10 = r10.getKey();	 Catch:{ Throwable -> 0x02de }
        r10 = (java.lang.String) r10;	 Catch:{ Throwable -> 0x02de }
        r0.put(r10, r3);	 Catch:{ Throwable -> 0x02de }
        goto L_0x00ae;
    L_0x0207:
        r8 = "please check key or value, illegal type!";
        com.umeng.commonsdk.statistics.common.MLog.e(r8);	 Catch:{ Throwable -> 0x02de }
        return;
    L_0x020d:
        r8 = "please check key or value, illegal type!";
        com.umeng.commonsdk.statistics.common.MLog.e(r8);	 Catch:{ Throwable -> 0x02de }
        return;
    L_0x0213:
        r10 = r10.getKey();	 Catch:{ Throwable -> 0x02de }
        r10 = (java.lang.String) r10;	 Catch:{ Throwable -> 0x02de }
        r0.put(r10, r11);	 Catch:{ Throwable -> 0x02de }
        goto L_0x00ae;
    L_0x021e:
        r8 = defpackage.an.O00000oO;	 Catch:{ Throwable -> 0x02de }
        r9 = "\\|";
        com.umeng.commonsdk.debug.UMLog.aq(r8, r1, r9);	 Catch:{ Throwable -> 0x02de }
        return;
    L_0x0226:
        r9 = com.umeng.commonsdk.service.UMGlobalContext.getInstance();	 Catch:{ Throwable -> 0x02de }
        r10 = O0000O0o;	 Catch:{ Throwable -> 0x02de }
        r9 = r9.isMainProcess(r10);	 Catch:{ Throwable -> 0x02de }
        if (r9 == 0) goto L_0x0241;
    L_0x0232:
        r9 = defpackage.ba.O000000o();	 Catch:{ Throwable -> 0x02de }
        r10 = O0000O0o;	 Catch:{ Throwable -> 0x02de }
        r10 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext(r10);	 Catch:{ Throwable -> 0x02de }
        r9 = r9.O00000o(r10);	 Catch:{ Throwable -> 0x02de }
        goto L_0x0255;
    L_0x0241:
        r9 = defpackage.ba.O000000o();	 Catch:{ Throwable -> 0x02de }
        r10 = O0000O0o;	 Catch:{ Throwable -> 0x02de }
        r10 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext(r10);	 Catch:{ Throwable -> 0x02de }
        r11 = "ts";
        r2 = r0.getLong(r11);	 Catch:{ Throwable -> 0x02de }
        r9 = r9.O000000o(r10, r2);	 Catch:{ Throwable -> 0x02de }
    L_0x0255:
        r10 = "__i";
        r11 = android.text.TextUtils.isEmpty(r9);	 Catch:{ Throwable -> 0x02de }
        if (r11 == 0) goto L_0x025f;
    L_0x025d:
        r9 = "-1";
    L_0x025f:
        r0.put(r10, r9);	 Catch:{ Throwable -> 0x02de }
        r9 = android.text.TextUtils.isEmpty(r12);	 Catch:{ Throwable -> 0x02de }
        if (r9 != 0) goto L_0x0278;
    L_0x0268:
        r9 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0278 }
        r9.<init>(r12);	 Catch:{ JSONException -> 0x0278 }
        r10 = r9.length();	 Catch:{ JSONException -> 0x0278 }
        if (r10 <= 0) goto L_0x0278;
    L_0x0273:
        r10 = "_$sp";
        r0.put(r10, r9);	 Catch:{ JSONException -> 0x0278 }
    L_0x0278:
        r9 = "ds";
        r0.put(r9, r1);	 Catch:{ Throwable -> 0x02de }
        r9 = "pn";
        r10 = com.umeng.commonsdk.service.UMGlobalContext.getInstance();	 Catch:{ Throwable -> 0x02de }
        r11 = O0000O0o;	 Catch:{ Throwable -> 0x02de }
        r10 = r10.getProcessName(r11);	 Catch:{ Throwable -> 0x02de }
        r0.put(r9, r10);	 Catch:{ Throwable -> 0x02de }
        r7.O000000o();	 Catch:{ Throwable -> 0x02de }
        r9 = r7.O0000OOo;	 Catch:{ Throwable -> 0x02de }
        if (r9 == 0) goto L_0x02b9;
    L_0x0293:
        r9 = r7.O0000OOo;	 Catch:{ Throwable -> 0x02de }
        r9 = r9.has(r8);	 Catch:{ Throwable -> 0x02de }
        if (r9 == 0) goto L_0x02b9;
    L_0x029b:
        r9 = r7.O0000OOo;	 Catch:{ Throwable -> 0x02de }
        r9 = r9.get(r8);	 Catch:{ Throwable -> 0x02de }
        r9 = (java.lang.Boolean) r9;	 Catch:{ Throwable -> 0x02de }
        r9 = r9.booleanValue();	 Catch:{ Throwable -> 0x02de }
        if (r9 != 0) goto L_0x02b9;
    L_0x02a9:
        r9 = "$st_fl";
        r10 = 1;
        r0.put(r9, r10);	 Catch:{ Throwable -> 0x02de }
        r9 = r7.O0000OOo;	 Catch:{ Throwable -> 0x02de }
        r9.put(r8, r10);	 Catch:{ Throwable -> 0x02de }
        r8 = O0000O0o;	 Catch:{ Throwable -> 0x02de }
        r7.O00000o0(r8);	 Catch:{ Throwable -> 0x02de }
    L_0x02b9:
        r8 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x02de }
        r8.<init>();	 Catch:{ Throwable -> 0x02de }
        r9 = "----->>>>>ekv event json is ";
        r8.append(r9);	 Catch:{ Throwable -> 0x02de }
        r9 = r0.toString();	 Catch:{ Throwable -> 0x02de }
        r8.append(r9);	 Catch:{ Throwable -> 0x02de }
        r8 = r8.toString();	 Catch:{ Throwable -> 0x02de }
        com.umeng.commonsdk.statistics.common.ULog.i(r8);	 Catch:{ Throwable -> 0x02de }
        r8 = O0000O0o;	 Catch:{ Throwable -> 0x02de }
        r9 = 4097; // 0x1001 float:5.741E-42 double:2.024E-320;
        r10 = O0000O0o;	 Catch:{ Throwable -> 0x02de }
        r10 = defpackage.v.O000000o(r10);	 Catch:{ Throwable -> 0x02de }
        com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(r8, r9, r10, r0);	 Catch:{ Throwable -> 0x02de }
    L_0x02de:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.au.O000000o(java.lang.String, java.util.Map, long, java.lang.String):void");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x00d5 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public void O000000o(java.lang.String r6, java.util.Map<java.lang.String, java.lang.Object> r7, java.lang.String r8) {
        /*
        r5 = this;
        r0 = r5.O000000o(r6);	 Catch:{ Throwable -> 0x010e }
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x010e }
        r0.<init>();	 Catch:{ Throwable -> 0x010e }
        r1 = "id";
        r0.put(r1, r6);	 Catch:{ Throwable -> 0x010e }
        r6 = "ts";
        r1 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x010e }
        r0.put(r6, r1);	 Catch:{ Throwable -> 0x010e }
        r6 = "du";
        r1 = 0;
        r0.put(r6, r1);	 Catch:{ Throwable -> 0x010e }
        r6 = "__t";
        r2 = 2050; // 0x802 float:2.873E-42 double:1.013E-320;
        r0.put(r6, r2);	 Catch:{ Throwable -> 0x010e }
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x010e }
        r6.<init>();	 Catch:{ Throwable -> 0x010e }
        r2 = "befort gkv map, event is ";
        r6.append(r2);	 Catch:{ Throwable -> 0x010e }
        r2 = r0.toString();	 Catch:{ Throwable -> 0x010e }
        r6.append(r2);	 Catch:{ Throwable -> 0x010e }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x010e }
        com.umeng.commonsdk.statistics.common.ULog.i(r6);	 Catch:{ Throwable -> 0x010e }
        r6 = r7.entrySet();	 Catch:{ Throwable -> 0x010e }
        r6 = r6.iterator();	 Catch:{ Throwable -> 0x010e }
        r7 = r1;
    L_0x0048:
        r2 = 10;
        if (r7 >= r2) goto L_0x00a4;
    L_0x004c:
        r2 = r6.hasNext();	 Catch:{ Throwable -> 0x010e }
        if (r2 == 0) goto L_0x00a4;
    L_0x0052:
        r2 = r6.next();	 Catch:{ Throwable -> 0x010e }
        r2 = (java.util.Map.Entry) r2;	 Catch:{ Throwable -> 0x010e }
        r3 = "$st_fl";
        r4 = r2.getKey();	 Catch:{ Throwable -> 0x010e }
        r3 = r3.equals(r4);	 Catch:{ Throwable -> 0x010e }
        if (r3 != 0) goto L_0x00a1;
    L_0x0064:
        r3 = "du";
        r4 = r2.getKey();	 Catch:{ Throwable -> 0x010e }
        r3 = r3.equals(r4);	 Catch:{ Throwable -> 0x010e }
        if (r3 != 0) goto L_0x00a1;
    L_0x0070:
        r3 = "id";
        r4 = r2.getKey();	 Catch:{ Throwable -> 0x010e }
        r3 = r3.equals(r4);	 Catch:{ Throwable -> 0x010e }
        if (r3 != 0) goto L_0x00a1;
    L_0x007c:
        r3 = "ts";
        r4 = r2.getKey();	 Catch:{ Throwable -> 0x010e }
        r3 = r3.equals(r4);	 Catch:{ Throwable -> 0x010e }
        if (r3 != 0) goto L_0x00a1;
    L_0x0088:
        r3 = r2.getValue();	 Catch:{ Throwable -> 0x010e }
        r4 = r3 instanceof java.lang.String;	 Catch:{ Throwable -> 0x010e }
        if (r4 != 0) goto L_0x0098;
    L_0x0090:
        r4 = r3 instanceof java.lang.Integer;	 Catch:{ Throwable -> 0x010e }
        if (r4 != 0) goto L_0x0098;
    L_0x0094:
        r4 = r3 instanceof java.lang.Long;	 Catch:{ Throwable -> 0x010e }
        if (r4 == 0) goto L_0x00a1;
    L_0x0098:
        r2 = r2.getKey();	 Catch:{ Throwable -> 0x010e }
        r2 = (java.lang.String) r2;	 Catch:{ Throwable -> 0x010e }
        r0.put(r2, r3);	 Catch:{ Throwable -> 0x010e }
    L_0x00a1:
        r7 = r7 + 1;
        goto L_0x0048;
    L_0x00a4:
        r6 = defpackage.ba.O000000o();	 Catch:{ Throwable -> 0x010e }
        r7 = O0000O0o;	 Catch:{ Throwable -> 0x010e }
        r7 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext(r7);	 Catch:{ Throwable -> 0x010e }
        r6 = r6.O00000o(r7);	 Catch:{ Throwable -> 0x010e }
        r7 = "__i";
        r2 = android.text.TextUtils.isEmpty(r6);	 Catch:{ Throwable -> 0x010e }
        if (r2 == 0) goto L_0x00bc;
    L_0x00ba:
        r6 = "-1";
    L_0x00bc:
        r0.put(r7, r6);	 Catch:{ Throwable -> 0x010e }
        r6 = android.text.TextUtils.isEmpty(r8);	 Catch:{ Throwable -> 0x010e }
        if (r6 != 0) goto L_0x00d5;
    L_0x00c5:
        r6 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00d5 }
        r6.<init>(r8);	 Catch:{ JSONException -> 0x00d5 }
        r7 = r6.length();	 Catch:{ JSONException -> 0x00d5 }
        if (r7 <= 0) goto L_0x00d5;
    L_0x00d0:
        r7 = "_$sp";
        r0.put(r7, r6);	 Catch:{ JSONException -> 0x00d5 }
    L_0x00d5:
        r6 = "ds";
        r0.put(r6, r1);	 Catch:{ Throwable -> 0x010e }
        r6 = "pn";
        r7 = com.umeng.commonsdk.service.UMGlobalContext.getInstance();	 Catch:{ Throwable -> 0x010e }
        r8 = O0000O0o;	 Catch:{ Throwable -> 0x010e }
        r7 = r7.getProcessName(r8);	 Catch:{ Throwable -> 0x010e }
        r0.put(r6, r7);	 Catch:{ Throwable -> 0x010e }
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x010e }
        r6.<init>();	 Catch:{ Throwable -> 0x010e }
        r7 = "----->>>>>gkv event json is ";
        r6.append(r7);	 Catch:{ Throwable -> 0x010e }
        r7 = r0.toString();	 Catch:{ Throwable -> 0x010e }
        r6.append(r7);	 Catch:{ Throwable -> 0x010e }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x010e }
        com.umeng.commonsdk.statistics.common.ULog.i(r6);	 Catch:{ Throwable -> 0x010e }
        r6 = O0000O0o;	 Catch:{ Throwable -> 0x010e }
        r7 = 4098; // 0x1002 float:5.743E-42 double:2.0247E-320;
        r8 = O0000O0o;	 Catch:{ Throwable -> 0x010e }
        r8 = defpackage.v.O000000o(r8);	 Catch:{ Throwable -> 0x010e }
        com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(r6, r7, r8, r0);	 Catch:{ Throwable -> 0x010e }
    L_0x010e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.au.O000000o(java.lang.String, java.util.Map, java.lang.String):void");
    }

    public void O000000o(List<String> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    O000000o();
                    int size;
                    if (this.O0000OOo == null) {
                        this.O0000OOo = new JSONObject();
                        size = list.size();
                        for (int i = 0; i < size; i++) {
                            if (this.O0000OOo != null) {
                                if (this.O0000OOo.length() >= 5) {
                                    break;
                                }
                            }
                            this.O0000OOo = new JSONObject();
                            String str = (String) list.get(i);
                            if (!TextUtils.isEmpty(str)) {
                                O000000o(HelperUtils.subStr(str, 128), false);
                            }
                        }
                        O00000o0(O0000O0o);
                    } else if (this.O0000OOo.length() >= 5) {
                        MLog.d("already setFistLaunchEvent, igone.");
                        return;
                    } else {
                        size = 0;
                        while (size < list.size()) {
                            if (this.O0000OOo.length() >= 5) {
                                MLog.d(" add setFistLaunchEvent over.");
                                return;
                            } else {
                                O000000o(HelperUtils.subStr((String) list.get(size), 128), false);
                                size++;
                            }
                        }
                        O00000o0(O0000O0o);
                    }
                    return;
                }
            } catch (Exception unused) {
            }
        }
        UMLog.aq(an.O000o0O0, 0, "\\|");
    }
}
