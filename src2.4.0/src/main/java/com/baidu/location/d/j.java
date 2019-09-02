package com.baidu.location.d;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.g.e;
import com.baidu.mapapi.synchronization.SynchronizationConstants;
import com.sina.weibo.sdk.statistic.LogBuilder;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

final class j {
    private static final String d = String.format(Locale.US, "DELETE FROM LOG WHERE timestamp NOT IN (SELECT timestamp FROM LOG ORDER BY timestamp DESC LIMIT %d);", new Object[]{Integer.valueOf(SynchronizationConstants.LBS_STATUS_CODE_START_DEGRADED_DISPLAY)});
    private static final String e = String.format(Locale.US, "SELECT * FROM LOG ORDER BY timestamp DESC LIMIT %d;", new Object[]{Integer.valueOf(3)});
    private String a = null;
    private final SQLiteDatabase b;
    private final a c;

    private class a extends e {
        private int b;
        private long c;
        private String d;
        private boolean e;
        private boolean f;
        private j q;

        a(j jVar) {
            this.q = jVar;
            this.d = null;
            this.e = false;
            this.f = false;
            this.k = new HashMap();
            this.b = 0;
            this.c = -1;
        }

        private void b() {
            if (!this.e) {
                this.d = this.q.b();
                if (this.c != -1 && this.c + LogBuilder.MAX_INTERVAL <= System.currentTimeMillis()) {
                    this.b = 0;
                    this.c = -1;
                }
                if (this.d != null && this.b < 2) {
                    this.e = true;
                    c("https://ofloc.map.baidu.com/offline_loc");
                }
            }
        }

        public void a() {
            this.k.clear();
            this.k.put("qt", "ofbh");
            this.k.put("req", this.d);
            this.h = g.b;
        }

        public void a(boolean z) {
            this.f = false;
            if (z && this.j != null) {
                try {
                    JSONObject jSONObject = new JSONObject(this.j);
                    if (jSONObject != null && jSONObject.has("error") && jSONObject.getInt("error") == BDLocation.TypeNetWorkLocation) {
                        this.f = true;
                    }
                } catch (Exception unused) {
                }
            }
            if (!this.f) {
                this.b++;
                this.c = System.currentTimeMillis();
            }
            this.q.a(this.f);
            this.e = false;
        }
    }

    j(SQLiteDatabase sQLiteDatabase) {
        this.b = sQLiteDatabase;
        this.c = new a(this);
        if (this.b != null && this.b.isOpen()) {
            try {
                this.b.execSQL("CREATE TABLE IF NOT EXISTS LOG(timestamp LONG PRIMARY KEY, log VARCHAR(4000))");
            } catch (Exception unused) {
            }
        }
    }

    private void a(boolean z) {
        if (z && this.a != null) {
            String format = String.format("DELETE FROM LOG WHERE timestamp in (%s);", new Object[]{this.a});
            try {
                if (this.a.length() > 0) {
                    this.b.execSQL(format);
                }
            } catch (Exception unused) {
            }
        }
        this.a = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0065 A:{SYNTHETIC, Splitter:B:28:0x0065} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0052 */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:7|(5:10|(1:12)|13|14|8)|15|16|17|18|19) */
    /* JADX WARNING: Missing block: B:21:0x005b, code skipped:
            if (r3 != null) goto L_0x005d;
     */
    /* JADX WARNING: Missing block: B:23:?, code skipped:
            r3.close();
     */
    /* JADX WARNING: Missing block: B:24:0x0060, code skipped:
            return r2;
     */
    /* JADX WARNING: Missing block: B:34:0x006a, code skipped:
            if (r3 == null) goto L_0x006d;
     */
    /* JADX WARNING: Missing block: B:36:0x006d, code skipped:
            return r2;
     */
    private java.lang.String b() {
        /*
        r7 = this;
        r0 = new org.json.JSONArray;
        r0.<init>();
        r1 = new org.json.JSONObject;
        r1.<init>();
        r2 = 0;
        r3 = r7.b;	 Catch:{ Exception -> 0x0069, all -> 0x0061 }
        r4 = e;	 Catch:{ Exception -> 0x0069, all -> 0x0061 }
        r3 = r3.rawQuery(r4, r2);	 Catch:{ Exception -> 0x0069, all -> 0x0061 }
        if (r3 == 0) goto L_0x005b;
    L_0x0015:
        r4 = r3.getCount();	 Catch:{ Exception -> 0x006a, all -> 0x0059 }
        if (r4 <= 0) goto L_0x005b;
    L_0x001b:
        r4 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x006a, all -> 0x0059 }
        r4.<init>();	 Catch:{ Exception -> 0x006a, all -> 0x0059 }
        r3.moveToFirst();	 Catch:{ Exception -> 0x006a, all -> 0x0059 }
    L_0x0023:
        r5 = r3.isAfterLast();	 Catch:{ Exception -> 0x006a, all -> 0x0059 }
        if (r5 != 0) goto L_0x0048;
    L_0x0029:
        r5 = 1;
        r5 = r3.getString(r5);	 Catch:{ Exception -> 0x006a, all -> 0x0059 }
        r0.put(r5);	 Catch:{ Exception -> 0x006a, all -> 0x0059 }
        r5 = r4.length();	 Catch:{ Exception -> 0x006a, all -> 0x0059 }
        if (r5 == 0) goto L_0x003c;
    L_0x0037:
        r5 = ",";
        r4.append(r5);	 Catch:{ Exception -> 0x006a, all -> 0x0059 }
    L_0x003c:
        r5 = 0;
        r5 = r3.getLong(r5);	 Catch:{ Exception -> 0x006a, all -> 0x0059 }
        r4.append(r5);	 Catch:{ Exception -> 0x006a, all -> 0x0059 }
        r3.moveToNext();	 Catch:{ Exception -> 0x006a, all -> 0x0059 }
        goto L_0x0023;
    L_0x0048:
        r5 = "ofloc";
        r1.put(r5, r0);	 Catch:{ JSONException -> 0x0052 }
        r0 = r1.toString();	 Catch:{ JSONException -> 0x0052 }
        r2 = r0;
    L_0x0052:
        r0 = r4.toString();	 Catch:{ Exception -> 0x006a, all -> 0x0059 }
        r7.a = r0;	 Catch:{ Exception -> 0x006a, all -> 0x0059 }
        goto L_0x005b;
    L_0x0059:
        r0 = move-exception;
        goto L_0x0063;
    L_0x005b:
        if (r3 == 0) goto L_0x006d;
    L_0x005d:
        r3.close();	 Catch:{ Exception -> 0x006d }
        return r2;
    L_0x0061:
        r0 = move-exception;
        r3 = r2;
    L_0x0063:
        if (r3 == 0) goto L_0x0068;
    L_0x0065:
        r3.close();	 Catch:{ Exception -> 0x0068 }
    L_0x0068:
        throw r0;
    L_0x0069:
        r3 = r2;
    L_0x006a:
        if (r3 == 0) goto L_0x006d;
    L_0x006c:
        goto L_0x005d;
    L_0x006d:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.d.j.b():java.lang.String");
    }

    /* Access modifiers changed, original: 0000 */
    public void a() {
        this.c.b();
    }

    /* Access modifiers changed, original: 0000 */
    public void a(String str) {
        str = Jni.encodeOfflineLocationUpdateRequest(str);
        try {
            this.b.execSQL(String.format(Locale.US, "INSERT OR IGNORE INTO LOG VALUES (%d,\"%s\");", new Object[]{Long.valueOf(System.currentTimeMillis()), str}));
            this.b.execSQL(d);
        } catch (Exception unused) {
        }
    }
}
