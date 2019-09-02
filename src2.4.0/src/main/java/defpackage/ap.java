package defpackage;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import defpackage.ai.O00000o.O000000o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AutoViewPageTracker */
/* renamed from: ap */
public class ap {
    public static String O000000o;
    private static JSONArray O00000oO = new JSONArray();
    private static Object O00000oo = new Object();
    boolean O00000Oo = false;
    private final Map<String, Long> O00000o = new HashMap();
    ActivityLifecycleCallbacks O00000o0 = new 1();
    private Application O0000O0o = null;
    private boolean O0000OOo = false;

    /* compiled from: AutoViewPageTracker */
    /* renamed from: ap$1 */
    class 1 implements ActivityLifecycleCallbacks {
        1() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
            if (u.O00000oO == O00000Oo.O000000o) {
                ap.this.O00000Oo(activity);
                z.O000000o().O0000Oo0();
                ap.this.O00000Oo = false;
            }
        }

        public void onActivityResumed(Activity activity) {
            if (u.O00000oO == O00000Oo.O000000o && activity != null) {
                if (ap.this.O00000Oo) {
                    ap.this.O00000Oo = false;
                    if (TextUtils.isEmpty(ap.O000000o)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(activity.getPackageName());
                        stringBuilder.append(".");
                        stringBuilder.append(activity.getLocalClassName());
                        ap.O000000o = stringBuilder.toString();
                    } else {
                        String str = ap.O000000o;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(activity.getPackageName());
                        stringBuilder2.append(".");
                        stringBuilder2.append(activity.getLocalClassName());
                        if (!str.equals(stringBuilder2.toString())) {
                            ap.this.O000000o(activity);
                            z.O000000o().O0000OOo();
                        }
                    }
                } else {
                    ap.this.O000000o(activity);
                    z.O000000o().O0000OOo();
                }
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
            if (u.O00000oO == O00000Oo.O000000o) {
            }
        }
    }

    public ap(Context context) {
        synchronized (this) {
            if (this.O0000O0o == null && context != null) {
                if (context instanceof Activity) {
                    this.O0000O0o = ((Activity) context).getApplication();
                } else if (context instanceof Application) {
                    this.O0000O0o = (Application) context;
                }
                if (this.O0000O0o != null) {
                    O00000Oo(context);
                }
            }
        }
    }

    private void O000000o(Activity activity) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(activity.getPackageName());
        stringBuilder.append(".");
        stringBuilder.append(activity.getLocalClassName());
        O000000o = stringBuilder.toString();
        synchronized (this.O00000o) {
            this.O00000o.put(O000000o, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static void O000000o(Context context) {
        if (context != null) {
            try {
                String jSONArray;
                JSONObject jSONObject = new JSONObject();
                synchronized (O00000oo) {
                    jSONArray = O00000oO.toString();
                    O00000oO = new JSONArray();
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put(O000000o.O00000o0, new JSONArray(jSONArray));
                    am.O000000o(context).O000000o(aw.O000000o().O00000o0(), jSONObject, am.O000000o.AUTOPAGE);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0082 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    private void O00000Oo(android.app.Activity r8) {
        /*
        r7 = this;
        r0 = r7.O00000o;	 Catch:{ Throwable -> 0x0089 }
        monitor-enter(r0);	 Catch:{ Throwable -> 0x0089 }
        r1 = O000000o;	 Catch:{ all -> 0x0086 }
        if (r1 != 0) goto L_0x0027;
    L_0x0007:
        if (r8 == 0) goto L_0x0027;
    L_0x0009:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0086 }
        r1.<init>();	 Catch:{ all -> 0x0086 }
        r2 = r8.getPackageName();	 Catch:{ all -> 0x0086 }
        r1.append(r2);	 Catch:{ all -> 0x0086 }
        r2 = ".";
        r1.append(r2);	 Catch:{ all -> 0x0086 }
        r8 = r8.getLocalClassName();	 Catch:{ all -> 0x0086 }
        r1.append(r8);	 Catch:{ all -> 0x0086 }
        r8 = r1.toString();	 Catch:{ all -> 0x0086 }
        O000000o = r8;	 Catch:{ all -> 0x0086 }
    L_0x0027:
        r8 = O000000o;	 Catch:{ all -> 0x0086 }
        r8 = android.text.TextUtils.isEmpty(r8);	 Catch:{ all -> 0x0086 }
        r1 = 0;
        if (r8 != 0) goto L_0x0059;
    L_0x0031:
        r8 = r7.O00000o;	 Catch:{ all -> 0x0086 }
        r3 = O000000o;	 Catch:{ all -> 0x0086 }
        r8 = r8.containsKey(r3);	 Catch:{ all -> 0x0086 }
        if (r8 == 0) goto L_0x0059;
    L_0x003b:
        r8 = r7.O00000o;	 Catch:{ all -> 0x0086 }
        r1 = O000000o;	 Catch:{ all -> 0x0086 }
        r8 = r8.get(r1);	 Catch:{ all -> 0x0086 }
        r8 = (java.lang.Long) r8;	 Catch:{ all -> 0x0086 }
        r1 = r8.longValue();	 Catch:{ all -> 0x0086 }
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0086 }
        r5 = r3 - r1;
        r8 = r7.O00000o;	 Catch:{ all -> 0x0086 }
        r3 = O000000o;	 Catch:{ all -> 0x0086 }
        r8.remove(r3);	 Catch:{ all -> 0x0086 }
        r3 = r1;
        r1 = r5;
        goto L_0x005a;
    L_0x0059:
        r3 = r1;
    L_0x005a:
        monitor-exit(r0);	 Catch:{ all -> 0x0086 }
        r8 = O00000oo;	 Catch:{ Throwable -> 0x0089 }
        monitor-enter(r8);	 Catch:{ Throwable -> 0x0089 }
        r0 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0082 }
        r0.<init>();	 Catch:{ Throwable -> 0x0082 }
        r5 = "page_name";
        r6 = O000000o;	 Catch:{ Throwable -> 0x0082 }
        r0.put(r5, r6);	 Catch:{ Throwable -> 0x0082 }
        r5 = "duration";
        r0.put(r5, r1);	 Catch:{ Throwable -> 0x0082 }
        r1 = "page_start";
        r0.put(r1, r3);	 Catch:{ Throwable -> 0x0082 }
        r1 = "type";
        r2 = 0;
        r0.put(r1, r2);	 Catch:{ Throwable -> 0x0082 }
        r1 = O00000oO;	 Catch:{ Throwable -> 0x0082 }
        r1.put(r0);	 Catch:{ Throwable -> 0x0082 }
        goto L_0x0082;
    L_0x0080:
        r0 = move-exception;
        goto L_0x0084;
    L_0x0082:
        monitor-exit(r8);	 Catch:{ all -> 0x0080 }
        goto L_0x0089;
    L_0x0084:
        monitor-exit(r8);	 Catch:{ all -> 0x0080 }
        throw r0;	 Catch:{ Throwable -> 0x0089 }
    L_0x0086:
        r8 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0086 }
        throw r8;	 Catch:{ Throwable -> 0x0089 }
    L_0x0089:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ap.O00000Oo(android.app.Activity):void");
    }

    private void O00000Oo(Context context) {
        if (!this.O0000OOo) {
            this.O0000OOo = true;
            if (this.O0000O0o != null && VERSION.SDK_INT >= 14) {
                this.O0000O0o.registerActivityLifecycleCallbacks(this.O00000o0);
            }
        }
    }

    public boolean O000000o() {
        return this.O0000OOo;
    }

    public void O00000Oo() {
        this.O0000OOo = false;
        if (this.O0000O0o != null) {
            if (VERSION.SDK_INT >= 14) {
                this.O0000O0o.unregisterActivityLifecycleCallbacks(this.O00000o0);
            }
            this.O0000O0o = null;
        }
    }

    public void O00000o0() {
        O00000Oo(null);
        O00000Oo();
    }
}
