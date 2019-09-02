package com.tencent.bugly.crashreport.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Parcelable;
import com.sina.weibo.sdk.statistic.LogBuilder;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.List;

/* compiled from: BUGLY */
public final class a {
    private Context a;
    private long b;
    private int c;
    private boolean d = true;

    /* compiled from: BUGLY */
    class a implements Runnable {
        private boolean a;
        private UserInfoBean b;

        public a(UserInfoBean userInfoBean, boolean z) {
            this.b = userInfoBean;
            this.a = z;
        }

        public final void run() {
            try {
                if (this.b != null) {
                    UserInfoBean userInfoBean = this.b;
                    if (userInfoBean != null) {
                        com.tencent.bugly.crashreport.common.info.a b = com.tencent.bugly.crashreport.common.info.a.b();
                        if (b != null) {
                            userInfoBean.j = b.e();
                        }
                    }
                    x.c("[UserInfo] Record user info.", new Object[0]);
                    a.a(a.this, this.b, false);
                }
                if (this.a) {
                    a aVar = a.this;
                    w a = w.a();
                    if (a != null) {
                        a.a(new Runnable() {
                            public final void run() {
                                try {
                                    a.this.c();
                                } catch (Throwable th) {
                                    x.a(th);
                                }
                            }
                        });
                    }
                }
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* compiled from: BUGLY */
    class b implements Runnable {
        b() {
        }

        public final void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < a.this.b) {
                w.a().a(new b(), (a.this.b - currentTimeMillis) + 5000);
                return;
            }
            a.this.a(3, false, 0);
            a.this.a();
        }
    }

    /* compiled from: BUGLY */
    class c implements Runnable {
        private long a = 21600000;

        public c(long j) {
            this.a = j;
        }

        public final void run() {
            a aVar = a.this;
            w a = w.a();
            if (a != null) {
                a.a(/* anonymous class already generated */);
            }
            aVar = a.this;
            long j = this.a;
            w.a().a(new c(j), j);
        }
    }

    public a(Context context, boolean z) {
        this.a = context;
        this.d = z;
    }

    private static ContentValues a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (userInfoBean.a > 0) {
                contentValues.put("_id", Long.valueOf(userInfoBean.a));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f));
            contentValues.put("_tp", Integer.valueOf(userInfoBean.b));
            contentValues.put("_pc", userInfoBean.c);
            contentValues.put("_dt", z.a((Parcelable) userInfoBean));
            return contentValues;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static UserInfoBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex("_id"));
            UserInfoBean userInfoBean = (UserInfoBean) z.a(blob, UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.a = j;
            }
            return userInfoBean;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static void a(List<UserInfoBean> list) {
        if (list != null && list.size() != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            while (i < list.size() && i < 50) {
                UserInfoBean userInfoBean = (UserInfoBean) list.get(i);
                stringBuilder.append(" or _id");
                stringBuilder.append(" = ");
                stringBuilder.append(userInfoBean.a);
                i++;
            }
            String stringBuilder2 = stringBuilder.toString();
            if (stringBuilder2.length() > 0) {
                stringBuilder2 = stringBuilder2.substring(4);
            }
            String str = stringBuilder2;
            stringBuilder.setLength(0);
            try {
                int a = p.a().a("t_ui", str, null, null, true);
                x.c("[Database] deleted %s data %d", "t_ui", Integer.valueOf(a));
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x00f5 A:{Catch:{ all -> 0x018e }} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00fa A:{Catch:{ all -> 0x018e }} */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00f5 A:{Catch:{ all -> 0x018e }} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00fa A:{Catch:{ all -> 0x018e }} */
    private synchronized void c() {
        /*
        r18 = this;
        r1 = r18;
        monitor-enter(r18);
        r2 = r1.d;	 Catch:{ all -> 0x018e }
        if (r2 != 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r18);
        return;
    L_0x0009:
        r2 = com.tencent.bugly.proguard.u.a();	 Catch:{ all -> 0x018e }
        if (r2 != 0) goto L_0x0011;
    L_0x000f:
        monitor-exit(r18);
        return;
    L_0x0011:
        r3 = com.tencent.bugly.crashreport.common.strategy.a.a();	 Catch:{ all -> 0x018e }
        if (r3 != 0) goto L_0x0019;
    L_0x0017:
        monitor-exit(r18);
        return;
    L_0x0019:
        r3 = r3.b();	 Catch:{ all -> 0x018e }
        if (r3 == 0) goto L_0x0029;
    L_0x001f:
        r3 = 1001; // 0x3e9 float:1.403E-42 double:4.946E-321;
        r3 = r2.b(r3);	 Catch:{ all -> 0x018e }
        if (r3 != 0) goto L_0x0029;
    L_0x0027:
        monitor-exit(r18);
        return;
    L_0x0029:
        r3 = r1.a;	 Catch:{ all -> 0x018e }
        r3 = com.tencent.bugly.crashreport.common.info.a.a(r3);	 Catch:{ all -> 0x018e }
        r3 = r3.d;	 Catch:{ all -> 0x018e }
        r4 = new java.util.ArrayList;	 Catch:{ all -> 0x018e }
        r4.<init>();	 Catch:{ all -> 0x018e }
        r3 = r1.a(r3);	 Catch:{ all -> 0x018e }
        r5 = 0;
        r6 = 1;
        if (r3 == 0) goto L_0x00e9;
    L_0x003e:
        r7 = r3.size();	 Catch:{ all -> 0x018e }
        r7 = r7 + -20;
        if (r7 <= 0) goto L_0x008d;
    L_0x0046:
        r8 = r5;
    L_0x0047:
        r9 = r3.size();	 Catch:{ all -> 0x018e }
        r9 = r9 - r6;
        if (r8 >= r9) goto L_0x0080;
    L_0x004e:
        r9 = r8 + 1;
        r10 = r9;
    L_0x0051:
        r11 = r3.size();	 Catch:{ all -> 0x018e }
        if (r10 >= r11) goto L_0x007e;
    L_0x0057:
        r11 = r3.get(r8);	 Catch:{ all -> 0x018e }
        r11 = (com.tencent.bugly.crashreport.biz.UserInfoBean) r11;	 Catch:{ all -> 0x018e }
        r11 = r11.e;	 Catch:{ all -> 0x018e }
        r13 = r3.get(r10);	 Catch:{ all -> 0x018e }
        r13 = (com.tencent.bugly.crashreport.biz.UserInfoBean) r13;	 Catch:{ all -> 0x018e }
        r13 = r13.e;	 Catch:{ all -> 0x018e }
        r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1));
        if (r15 <= 0) goto L_0x007b;
    L_0x006b:
        r11 = r3.get(r8);	 Catch:{ all -> 0x018e }
        r11 = (com.tencent.bugly.crashreport.biz.UserInfoBean) r11;	 Catch:{ all -> 0x018e }
        r12 = r3.get(r10);	 Catch:{ all -> 0x018e }
        r3.set(r8, r12);	 Catch:{ all -> 0x018e }
        r3.set(r10, r11);	 Catch:{ all -> 0x018e }
    L_0x007b:
        r10 = r10 + 1;
        goto L_0x0051;
    L_0x007e:
        r8 = r9;
        goto L_0x0047;
    L_0x0080:
        r8 = r5;
    L_0x0081:
        if (r8 >= r7) goto L_0x008d;
    L_0x0083:
        r9 = r3.get(r8);	 Catch:{ all -> 0x018e }
        r4.add(r9);	 Catch:{ all -> 0x018e }
        r8 = r8 + 1;
        goto L_0x0081;
    L_0x008d:
        r7 = r3.iterator();	 Catch:{ all -> 0x018e }
        r8 = r5;
    L_0x0092:
        r9 = r7.hasNext();	 Catch:{ all -> 0x018e }
        if (r9 == 0) goto L_0x00d6;
    L_0x0098:
        r9 = r7.next();	 Catch:{ all -> 0x018e }
        r9 = (com.tencent.bugly.crashreport.biz.UserInfoBean) r9;	 Catch:{ all -> 0x018e }
        r10 = r9.f;	 Catch:{ all -> 0x018e }
        r12 = -1;
        r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r14 == 0) goto L_0x00b6;
    L_0x00a6:
        r7.remove();	 Catch:{ all -> 0x018e }
        r10 = r9.e;	 Catch:{ all -> 0x018e }
        r12 = com.tencent.bugly.proguard.z.b();	 Catch:{ all -> 0x018e }
        r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r14 >= 0) goto L_0x00b6;
    L_0x00b3:
        r4.add(r9);	 Catch:{ all -> 0x018e }
    L_0x00b6:
        r10 = r9.e;	 Catch:{ all -> 0x018e }
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x018e }
        r14 = 600000; // 0x927c0 float:8.40779E-40 double:2.964394E-318;
        r16 = r12 - r14;
        r12 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1));
        if (r12 <= 0) goto L_0x0092;
    L_0x00c5:
        r10 = r9.b;	 Catch:{ all -> 0x018e }
        if (r10 == r6) goto L_0x00d3;
    L_0x00c9:
        r10 = r9.b;	 Catch:{ all -> 0x018e }
        r11 = 4;
        if (r10 == r11) goto L_0x00d3;
    L_0x00ce:
        r9 = r9.b;	 Catch:{ all -> 0x018e }
        r10 = 3;
        if (r9 != r10) goto L_0x0092;
    L_0x00d3:
        r8 = r8 + 1;
        goto L_0x0092;
    L_0x00d6:
        r7 = 15;
        if (r8 <= r7) goto L_0x00ee;
    L_0x00da:
        r7 = "[UserInfo] Upload user info too many times in 10 min: %d";
        r9 = new java.lang.Object[r6];	 Catch:{ all -> 0x018e }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x018e }
        r9[r5] = r8;	 Catch:{ all -> 0x018e }
        com.tencent.bugly.proguard.x.d(r7, r9);	 Catch:{ all -> 0x018e }
        r7 = r5;
        goto L_0x00ef;
    L_0x00e9:
        r3 = new java.util.ArrayList;	 Catch:{ all -> 0x018e }
        r3.<init>();	 Catch:{ all -> 0x018e }
    L_0x00ee:
        r7 = r6;
    L_0x00ef:
        r8 = r4.size();	 Catch:{ all -> 0x018e }
        if (r8 <= 0) goto L_0x00f8;
    L_0x00f5:
        a(r4);	 Catch:{ all -> 0x018e }
    L_0x00f8:
        if (r7 == 0) goto L_0x0185;
    L_0x00fa:
        r4 = r3.size();	 Catch:{ all -> 0x018e }
        if (r4 != 0) goto L_0x0102;
    L_0x0100:
        goto L_0x0185;
    L_0x0102:
        r4 = "[UserInfo] Upload user info(size: %d)";
        r7 = new java.lang.Object[r6];	 Catch:{ all -> 0x018e }
        r8 = r3.size();	 Catch:{ all -> 0x018e }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x018e }
        r7[r5] = r8;	 Catch:{ all -> 0x018e }
        com.tencent.bugly.proguard.x.c(r4, r7);	 Catch:{ all -> 0x018e }
        r4 = r1.c;	 Catch:{ all -> 0x018e }
        if (r4 != r6) goto L_0x0119;
    L_0x0117:
        r4 = r6;
        goto L_0x011a;
    L_0x0119:
        r4 = 2;
    L_0x011a:
        r4 = com.tencent.bugly.proguard.a.a(r3, r4);	 Catch:{ all -> 0x018e }
        if (r4 != 0) goto L_0x0129;
    L_0x0120:
        r2 = "[UserInfo] Failed to create UserInfoPackage.";
        r3 = new java.lang.Object[r5];	 Catch:{ all -> 0x018e }
        com.tencent.bugly.proguard.x.d(r2, r3);	 Catch:{ all -> 0x018e }
        monitor-exit(r18);
        return;
    L_0x0129:
        r4 = com.tencent.bugly.proguard.a.a(r4);	 Catch:{ all -> 0x018e }
        if (r4 != 0) goto L_0x0138;
    L_0x012f:
        r2 = "[UserInfo] Failed to encode data.";
        r3 = new java.lang.Object[r5];	 Catch:{ all -> 0x018e }
        com.tencent.bugly.proguard.x.d(r2, r3);	 Catch:{ all -> 0x018e }
        monitor-exit(r18);
        return;
    L_0x0138:
        r7 = r2.a;	 Catch:{ all -> 0x018e }
        if (r7 == 0) goto L_0x013f;
    L_0x013c:
        r7 = 840; // 0x348 float:1.177E-42 double:4.15E-321;
        goto L_0x0141;
    L_0x013f:
        r7 = 640; // 0x280 float:8.97E-43 double:3.16E-321;
    L_0x0141:
        r8 = r1.a;	 Catch:{ all -> 0x018e }
        r11 = com.tencent.bugly.proguard.a.a(r8, r7, r4);	 Catch:{ all -> 0x018e }
        if (r11 != 0) goto L_0x0152;
    L_0x0149:
        r2 = "[UserInfo] Request package is null.";
        r3 = new java.lang.Object[r5];	 Catch:{ all -> 0x018e }
        com.tencent.bugly.proguard.x.d(r2, r3);	 Catch:{ all -> 0x018e }
        monitor-exit(r18);
        return;
    L_0x0152:
        r14 = new com.tencent.bugly.crashreport.biz.a$1;	 Catch:{ all -> 0x018e }
        r14.<init>(r3);	 Catch:{ all -> 0x018e }
        r3 = com.tencent.bugly.crashreport.common.strategy.a.a();	 Catch:{ all -> 0x018e }
        r3 = r3.c();	 Catch:{ all -> 0x018e }
        r4 = r2.a;	 Catch:{ all -> 0x018e }
        if (r4 == 0) goto L_0x0166;
    L_0x0163:
        r3 = r3.r;	 Catch:{ all -> 0x018e }
        goto L_0x0168;
    L_0x0166:
        r3 = r3.t;	 Catch:{ all -> 0x018e }
    L_0x0168:
        r12 = r3;
        r2 = r2.a;	 Catch:{ all -> 0x018e }
        if (r2 == 0) goto L_0x0170;
    L_0x016d:
        r2 = com.tencent.bugly.crashreport.common.strategy.StrategyBean.b;	 Catch:{ all -> 0x018e }
        goto L_0x0172;
    L_0x0170:
        r2 = com.tencent.bugly.crashreport.common.strategy.StrategyBean.a;	 Catch:{ all -> 0x018e }
    L_0x0172:
        r13 = r2;
        r9 = com.tencent.bugly.proguard.u.a();	 Catch:{ all -> 0x018e }
        r10 = 1001; // 0x3e9 float:1.403E-42 double:4.946E-321;
        r2 = r1.c;	 Catch:{ all -> 0x018e }
        if (r2 != r6) goto L_0x017f;
    L_0x017d:
        r15 = r6;
        goto L_0x0180;
    L_0x017f:
        r15 = r5;
    L_0x0180:
        r9.a(r10, r11, r12, r13, r14, r15);	 Catch:{ all -> 0x018e }
        monitor-exit(r18);
        return;
    L_0x0185:
        r2 = "[UserInfo] There is no user info in local database.";
        r3 = new java.lang.Object[r5];	 Catch:{ all -> 0x018e }
        com.tencent.bugly.proguard.x.c(r2, r3);	 Catch:{ all -> 0x018e }
        monitor-exit(r18);
        return;
    L_0x018e:
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r18);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.biz.a.c():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b2 A:{Catch:{ all -> 0x00bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00be  */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0066 */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:22|23|50) */
    /* JADX WARNING: Missing block: B:23:?, code skipped:
            com.tencent.bugly.proguard.x.d("[Database] unknown id.", new java.lang.Object[0]);
     */
    public final java.util.List<com.tencent.bugly.crashreport.biz.UserInfoBean> a(java.lang.String r13) {
        /*
        r12 = this;
        r0 = 0;
        r1 = com.tencent.bugly.proguard.z.a(r13);	 Catch:{ Throwable -> 0x00aa, all -> 0x00a5 }
        if (r1 == 0) goto L_0x0009;
    L_0x0007:
        r4 = r0;
        goto L_0x001d;
    L_0x0009:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00aa, all -> 0x00a5 }
        r2 = "_pc = '";
        r1.<init>(r2);	 Catch:{ Throwable -> 0x00aa, all -> 0x00a5 }
        r1.append(r13);	 Catch:{ Throwable -> 0x00aa, all -> 0x00a5 }
        r13 = "'";
        r1.append(r13);	 Catch:{ Throwable -> 0x00aa, all -> 0x00a5 }
        r13 = r1.toString();	 Catch:{ Throwable -> 0x00aa, all -> 0x00a5 }
        r4 = r13;
    L_0x001d:
        r1 = com.tencent.bugly.proguard.p.a();	 Catch:{ Throwable -> 0x00aa, all -> 0x00a5 }
        r2 = "t_ui";
        r3 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 1;
        r13 = r1.a(r2, r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x00aa, all -> 0x00a5 }
        if (r13 != 0) goto L_0x0033;
    L_0x002d:
        if (r13 == 0) goto L_0x0032;
    L_0x002f:
        r13.close();
    L_0x0032:
        return r0;
    L_0x0033:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00a3 }
        r1.<init>();	 Catch:{ Throwable -> 0x00a3 }
        r2 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x00a3 }
        r2.<init>();	 Catch:{ Throwable -> 0x00a3 }
    L_0x003d:
        r3 = r13.moveToNext();	 Catch:{ Throwable -> 0x00a3 }
        r4 = 0;
        if (r3 == 0) goto L_0x006e;
    L_0x0044:
        r3 = a(r13);	 Catch:{ Throwable -> 0x00a3 }
        if (r3 == 0) goto L_0x004e;
    L_0x004a:
        r2.add(r3);	 Catch:{ Throwable -> 0x00a3 }
        goto L_0x003d;
    L_0x004e:
        r3 = "_id";
        r3 = r13.getColumnIndex(r3);	 Catch:{ Throwable -> 0x0066 }
        r5 = r13.getLong(r3);	 Catch:{ Throwable -> 0x0066 }
        r3 = " or _id";
        r1.append(r3);	 Catch:{ Throwable -> 0x0066 }
        r3 = " = ";
        r1.append(r3);	 Catch:{ Throwable -> 0x0066 }
        r1.append(r5);	 Catch:{ Throwable -> 0x0066 }
        goto L_0x003d;
    L_0x0066:
        r3 = "[Database] unknown id.";
        r4 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x00a3 }
        com.tencent.bugly.proguard.x.d(r3, r4);	 Catch:{ Throwable -> 0x00a3 }
        goto L_0x003d;
    L_0x006e:
        r1 = r1.toString();	 Catch:{ Throwable -> 0x00a3 }
        r3 = r1.length();	 Catch:{ Throwable -> 0x00a3 }
        if (r3 <= 0) goto L_0x009d;
    L_0x0078:
        r3 = 4;
        r7 = r1.substring(r3);	 Catch:{ Throwable -> 0x00a3 }
        r5 = com.tencent.bugly.proguard.p.a();	 Catch:{ Throwable -> 0x00a3 }
        r6 = "t_ui";
        r8 = 0;
        r9 = 0;
        r10 = 1;
        r1 = r5.a(r6, r7, r8, r9, r10);	 Catch:{ Throwable -> 0x00a3 }
        r3 = "[Database] deleted %s error data %d";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x00a3 }
        r6 = "t_ui";
        r5[r4] = r6;	 Catch:{ Throwable -> 0x00a3 }
        r4 = 1;
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Throwable -> 0x00a3 }
        r5[r4] = r1;	 Catch:{ Throwable -> 0x00a3 }
        com.tencent.bugly.proguard.x.d(r3, r5);	 Catch:{ Throwable -> 0x00a3 }
    L_0x009d:
        if (r13 == 0) goto L_0x00a2;
    L_0x009f:
        r13.close();
    L_0x00a2:
        return r2;
    L_0x00a3:
        r1 = move-exception;
        goto L_0x00ac;
    L_0x00a5:
        r13 = move-exception;
        r11 = r0;
        r0 = r13;
        r13 = r11;
        goto L_0x00bc;
    L_0x00aa:
        r1 = move-exception;
        r13 = r0;
    L_0x00ac:
        r2 = com.tencent.bugly.proguard.x.a(r1);	 Catch:{ all -> 0x00bb }
        if (r2 != 0) goto L_0x00b5;
    L_0x00b2:
        r1.printStackTrace();	 Catch:{ all -> 0x00bb }
    L_0x00b5:
        if (r13 == 0) goto L_0x00ba;
    L_0x00b7:
        r13.close();
    L_0x00ba:
        return r0;
    L_0x00bb:
        r0 = move-exception;
    L_0x00bc:
        if (r13 == 0) goto L_0x00c1;
    L_0x00be:
        r13.close();
    L_0x00c1:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.biz.a.a(java.lang.String):java.util.List");
    }

    public final void a() {
        this.b = z.b() + LogBuilder.MAX_INTERVAL;
        w.a().a(new b(), (this.b - System.currentTimeMillis()) + 5000);
    }

    public final void a(int i, boolean z, long j) {
        com.tencent.bugly.crashreport.common.strategy.a a = com.tencent.bugly.crashreport.common.strategy.a.a();
        int i2 = 0;
        if (a == null || a.c().h || i == 1 || i == 3) {
            if (i == 1 || i == 3) {
                this.c++;
            }
            com.tencent.bugly.crashreport.common.info.a a2 = com.tencent.bugly.crashreport.common.info.a.a(this.a);
            UserInfoBean userInfoBean = new UserInfoBean();
            userInfoBean.b = i;
            userInfoBean.c = a2.d;
            userInfoBean.d = a2.g();
            userInfoBean.e = System.currentTimeMillis();
            userInfoBean.f = -1;
            userInfoBean.n = a2.j;
            if (i == 1) {
                i2 = 1;
            }
            userInfoBean.o = i2;
            userInfoBean.l = a2.a();
            userInfoBean.m = a2.p;
            userInfoBean.g = a2.q;
            userInfoBean.h = a2.r;
            userInfoBean.i = a2.s;
            userInfoBean.k = a2.t;
            userInfoBean.r = a2.B();
            userInfoBean.s = a2.G();
            userInfoBean.p = a2.H();
            userInfoBean.q = a2.I();
            w.a().a(new a(userInfoBean, z), 0);
            return;
        }
        x.e("UserInfo is disable", new Object[0]);
    }

    public final void b() {
        w a = w.a();
        if (a != null) {
            a.a(/* anonymous class already generated */);
        }
    }
}
