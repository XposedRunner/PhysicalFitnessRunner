package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import defpackage.am.O000000o;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ViewPageTracker */
/* renamed from: ax */
public class ax {
    private static final int O00000Oo = 5;
    private static Object O00000o = new Object();
    private static JSONArray O00000o0 = new JSONArray();
    Stack<String> O000000o = new Stack();
    private final Map<String, Long> O00000oO = new HashMap();

    public static void O000000o(Context context) {
        if (context != null) {
            try {
                String jSONArray;
                JSONObject jSONObject = new JSONObject();
                synchronized (O00000o) {
                    jSONArray = O00000o0.toString();
                    O00000o0 = new JSONArray();
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("__a", new JSONArray(jSONArray));
                    if (jSONObject.length() > 0) {
                        am.O000000o(context).O000000o(aw.O000000o().O00000o0(), jSONObject, O000000o.PAGE);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public int O000000o() {
        return 2;
    }

    public void O000000o(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (UMConfigure.isDebugLog() && this.O000000o.size() != 0) {
                String str2 = (String) this.O000000o.peek();
                UMLog.aq(an.O000O0o0, 0, "\\|", new String[]{"@"}, new String[]{str2}, null, null);
            }
            synchronized (this.O00000oO) {
                this.O00000oO.put(str, Long.valueOf(System.currentTimeMillis()));
                if (UMConfigure.isDebugLog()) {
                    this.O000000o.push(str);
                }
            }
        }
    }

    public void O00000Oo() {
        String str;
        synchronized (this.O00000oO) {
            str = null;
            long j = 0;
            for (Entry entry : this.O00000oO.entrySet()) {
                if (((Long) entry.getValue()).longValue() > j) {
                    long longValue = ((Long) entry.getValue()).longValue();
                    str = (String) entry.getKey();
                    j = longValue;
                }
            }
        }
        if (str != null) {
            O00000Oo(str);
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0089 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public void O00000Oo(java.lang.String r11) {
        /*
        r10 = this;
        r0 = android.text.TextUtils.isEmpty(r11);
        if (r0 != 0) goto L_0x00d4;
    L_0x0006:
        r0 = r10.O00000oO;
        r0 = r0.containsKey(r11);
        r1 = 0;
        r2 = 1;
        if (r0 == 0) goto L_0x00b2;
    L_0x0010:
        r0 = r10.O00000oO;
        monitor-enter(r0);
        r3 = r10.O00000oO;	 Catch:{ all -> 0x00af }
        r3 = r3.get(r11);	 Catch:{ all -> 0x00af }
        r3 = (java.lang.Long) r3;	 Catch:{ all -> 0x00af }
        monitor-exit(r0);	 Catch:{ all -> 0x00af }
        if (r3 != 0) goto L_0x001f;
    L_0x001e:
        return;
    L_0x001f:
        r0 = com.umeng.commonsdk.UMConfigure.isDebugLog();
        if (r0 == 0) goto L_0x003e;
    L_0x0025:
        r0 = r10.O000000o;
        r0 = r0.size();
        if (r0 <= 0) goto L_0x003e;
    L_0x002d:
        r0 = r10.O000000o;
        r0 = r0.peek();
        r0 = r11.equals(r0);
        if (r0 == 0) goto L_0x003e;
    L_0x0039:
        r0 = r10.O000000o;
        r0.pop();
    L_0x003e:
        r4 = java.lang.System.currentTimeMillis();
        r6 = r3.longValue();
        r8 = r4 - r6;
        r4 = O00000o;
        monitor-enter(r4);
        r0 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0089 }
        r0.<init>();	 Catch:{ Throwable -> 0x0089 }
        r5 = "page_name";
        r0.put(r5, r11);	 Catch:{ Throwable -> 0x0089 }
        r5 = "duration";
        r0.put(r5, r8);	 Catch:{ Throwable -> 0x0089 }
        r5 = "page_start";
        r0.put(r5, r3);	 Catch:{ Throwable -> 0x0089 }
        r3 = "type";
        r5 = r10.O000000o();	 Catch:{ Throwable -> 0x0089 }
        r0.put(r3, r5);	 Catch:{ Throwable -> 0x0089 }
        r3 = O00000o0;	 Catch:{ Throwable -> 0x0089 }
        r3.put(r0);	 Catch:{ Throwable -> 0x0089 }
        r0 = O00000o0;	 Catch:{ Throwable -> 0x0089 }
        r0 = r0.length();	 Catch:{ Throwable -> 0x0089 }
        r3 = 5;
        if (r0 < r3) goto L_0x0089;
    L_0x0076:
        r0 = 0;
        r3 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext(r0);	 Catch:{ Throwable -> 0x0089 }
        if (r3 == 0) goto L_0x0089;
    L_0x007d:
        r5 = 4099; // 0x1003 float:5.744E-42 double:2.025E-320;
        r6 = defpackage.v.O000000o(r3);	 Catch:{ Throwable -> 0x0089 }
        com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(r3, r5, r6, r0);	 Catch:{ Throwable -> 0x0089 }
        goto L_0x0089;
    L_0x0087:
        r11 = move-exception;
        goto L_0x00ad;
    L_0x0089:
        monitor-exit(r4);	 Catch:{ all -> 0x0087 }
        r0 = com.umeng.commonsdk.UMConfigure.isDebugLog();
        if (r0 == 0) goto L_0x00d4;
    L_0x0090:
        r0 = r10.O000000o;
        r0 = r0.size();
        if (r0 == 0) goto L_0x00d4;
    L_0x0098:
        r6 = new java.lang.String[r2];
        r0 = "@";
        r6[r1] = r0;
        r7 = new java.lang.String[r2];
        r7[r1] = r11;
        r3 = defpackage.an.O00oOoOo;
        r4 = 0;
        r5 = "\\|";
        r8 = 0;
        r9 = 0;
        com.umeng.commonsdk.debug.UMLog.aq(r3, r4, r5, r6, r7, r8, r9);
        goto L_0x00d4;
    L_0x00ad:
        monitor-exit(r4);	 Catch:{ all -> 0x0087 }
        throw r11;
    L_0x00af:
        r11 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00af }
        throw r11;
    L_0x00b2:
        r0 = com.umeng.commonsdk.UMConfigure.isDebugLog();
        if (r0 == 0) goto L_0x00d4;
    L_0x00b8:
        r0 = r10.O000000o;
        r0 = r0.size();
        if (r0 != 0) goto L_0x00d4;
    L_0x00c0:
        r6 = new java.lang.String[r2];
        r0 = "@";
        r6[r1] = r0;
        r7 = new java.lang.String[r2];
        r7[r1] = r11;
        r3 = defpackage.an.O000O0o;
        r4 = 0;
        r5 = "\\|";
        r8 = 0;
        r9 = 0;
        com.umeng.commonsdk.debug.UMLog.aq(r3, r4, r5, r6, r7, r8, r9);
    L_0x00d4:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ax.O00000Oo(java.lang.String):void");
    }
}
