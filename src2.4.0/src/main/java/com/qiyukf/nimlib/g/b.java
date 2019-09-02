package com.qiyukf.nimlib.g;

import android.app.KeyguardManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.qiyukf.nimlib.d;
import com.qiyukf.nimlib.i.a;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.nimlib.sdk.uinfo.UserInfoProvider;
import com.qiyukf.nimlib.sdk.uinfo.UserInfoProvider.UserInfo;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.StatusBarNotificationConfig;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class b {
    private static b k;
    protected Context a = com.qiyukf.nimlib.b.a();
    private SimpleDateFormat b = new SimpleDateFormat("HH:mm", Locale.getDefault());
    private NotificationManager c = ((NotificationManager) this.a.getSystemService("notification"));
    private Map<String, a> d = new HashMap();
    private String e;
    private String f;
    private String g;
    private String h;
    private int i;
    private long j = 0;

    private b() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.getPackageName());
        stringBuilder.append(".unicorn");
        this.h = stringBuilder.toString();
        AnonymousClass1 anonymousClass1 = new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("android.intent.action.USER_PRESENT")) {
                    b.a(b.this);
                } else if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
                    if (!((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
                        b.a(b.this);
                    }
                } else {
                    if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                        d.c(false);
                    }
                }
            }
        };
        d.c(true);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        com.qiyukf.nimlib.b.a().registerReceiver(anonymousClass1, intentFilter);
        if (VERSION.SDK_INT >= 26) {
            this.c.createNotificationChannel(new NotificationChannel(this.h, this.a.getString(R.string.ysf_app_name), 3));
        }
    }

    private int a(StatusBarNotificationConfig statusBarNotificationConfig) {
        return statusBarNotificationConfig.notificationSmallIconId == 0 ? this.a.getApplicationInfo().icon : statusBarNotificationConfig.notificationSmallIconId;
    }

    private Bitmap a(IMMessage iMMessage) {
        if (com.qiyukf.nimlib.b.d().userInfoProvider == null || this.d.size() > 1) {
            return null;
        }
        String str = com.qiyukf.unicorn.d.e().statusBarNotificationConfig != null ? com.qiyukf.unicorn.d.e().statusBarNotificationConfig.bigIconUri : null;
        if (TextUtils.isEmpty(str)) {
            UserInfoProvider userInfoProvider = com.qiyukf.nimlib.b.d().userInfoProvider;
            if (iMMessage.getSessionType() == SessionTypeEnum.P2P || iMMessage.getSessionType() == SessionTypeEnum.Ysf) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(iMMessage.getFromAccount());
                stringBuilder.append(iMMessage.getUuid());
                UserInfo userInfo = userInfoProvider.getUserInfo(stringBuilder.toString());
                if (userInfo != null) {
                    str = userInfo.getAvatar();
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                int a = com.qiyukf.basesdk.c.d.d.a(72.0f);
                Bitmap a2 = com.qiyukf.nim.uikit.a.a(str);
                if (a2 == null) {
                    a2 = com.qiyukf.nim.uikit.a.a(str, a, a);
                }
                if (a2 != null && (a2.getWidth() < (a << 1) / 3 || a2.getWidth() > (a * 3) / 2)) {
                    a2 = Bitmap.createScaledBitmap(a2, a, a, false);
                }
                if (a2 == null) {
                    com.qiyukf.nim.uikit.a.a(str, a, a, null);
                }
                return a2;
            } catch (Throwable th) {
                th.printStackTrace();
                com.qiyukf.basesdk.a.a.a("MN", "user custom image loader exception");
            }
        }
        return null;
    }

    public static void a() {
        if (c()) {
            b().d();
        }
    }

    public static void a(a aVar, String str, int i) {
        if (c()) {
            b().b(aVar, str, i);
        }
    }

    private static b b() {
        if (k == null) {
            k = new b();
        }
        return k;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0235  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0235  */
    /* JADX WARNING: Missing block: B:29:0x0085, code skipped:
            if (r5.compareTo(r4) > 0) goto L_0x0089;
     */
    private synchronized void b(com.qiyukf.nimlib.i.a r12, java.lang.String r13, int r14) {
        /*
        r11 = this;
        monitor-enter(r11);
        r0 = com.qiyukf.nimlib.d.c();	 Catch:{ all -> 0x02f5 }
        r1 = 1;
        r0 = r0 ^ r1;
        if (r0 == 0) goto L_0x000c;
    L_0x0009:
        r0 = "";
        goto L_0x0010;
    L_0x000c:
        r0 = com.qiyukf.nimlib.d.d();	 Catch:{ all -> 0x02f5 }
    L_0x0010:
        r2 = r12.getSessionId();	 Catch:{ all -> 0x02f5 }
        r3 = r12.getSessionType();	 Catch:{ all -> 0x02f5 }
        r3 = r3.getValue();	 Catch:{ all -> 0x02f5 }
        r2 = com.qiyukf.nimlib.i.g.a(r2, r3);	 Catch:{ all -> 0x02f5 }
        r2 = r0.equals(r2);	 Catch:{ all -> 0x02f5 }
        r3 = 0;
        if (r2 != 0) goto L_0x0031;
    L_0x0027:
        r2 = "all";
        r0 = r0.equals(r2);	 Catch:{ all -> 0x02f5 }
        if (r0 != 0) goto L_0x0031;
    L_0x002f:
        r0 = r1;
        goto L_0x0032;
    L_0x0031:
        r0 = r3;
    L_0x0032:
        if (r0 == 0) goto L_0x02f3;
    L_0x0034:
        r0 = com.qiyukf.unicorn.d.e();	 Catch:{ all -> 0x02f5 }
        r0 = r0.statusBarNotificationConfig;	 Catch:{ all -> 0x02f5 }
        r2 = com.qiyukf.unicorn.d.e();	 Catch:{ all -> 0x02f5 }
        r2 = r2.statusBarNotificationConfig;	 Catch:{ all -> 0x02f5 }
        r2 = r2.downTimeToggle;	 Catch:{ all -> 0x02f5 }
        if (r2 == 0) goto L_0x0089;
    L_0x0044:
        r2 = com.qiyukf.unicorn.d.e();	 Catch:{ all -> 0x02f5 }
        r2 = r2.statusBarNotificationConfig;	 Catch:{ all -> 0x02f5 }
        r2 = r2.downTimeBegin;	 Catch:{ all -> 0x02f5 }
        r4 = com.qiyukf.unicorn.d.e();	 Catch:{ all -> 0x02f5 }
        r4 = r4.statusBarNotificationConfig;	 Catch:{ all -> 0x02f5 }
        r4 = r4.downTimeEnd;	 Catch:{ all -> 0x02f5 }
        if (r2 == 0) goto L_0x0089;
    L_0x0056:
        if (r4 != 0) goto L_0x0059;
    L_0x0058:
        goto L_0x0089;
    L_0x0059:
        r5 = r11.b;	 Catch:{ all -> 0x02f5 }
        r6 = new java.util.Date;	 Catch:{ all -> 0x02f5 }
        r7 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x02f5 }
        r6.<init>(r7);	 Catch:{ all -> 0x02f5 }
        r5 = r5.format(r6);	 Catch:{ all -> 0x02f5 }
        r6 = r2.compareTo(r4);	 Catch:{ all -> 0x02f5 }
        if (r6 > 0) goto L_0x007b;
    L_0x006e:
        r2 = r5.compareTo(r2);	 Catch:{ all -> 0x02f5 }
        if (r2 < 0) goto L_0x0089;
    L_0x0074:
        r2 = r5.compareTo(r4);	 Catch:{ all -> 0x02f5 }
        if (r2 > 0) goto L_0x0089;
    L_0x007a:
        goto L_0x0087;
    L_0x007b:
        r2 = r5.compareTo(r2);	 Catch:{ all -> 0x02f5 }
        if (r2 >= 0) goto L_0x0087;
    L_0x0081:
        r2 = r5.compareTo(r4);	 Catch:{ all -> 0x02f5 }
        if (r2 > 0) goto L_0x0089;
    L_0x0087:
        r2 = r1;
        goto L_0x008a;
    L_0x0089:
        r2 = r3;
    L_0x008a:
        r4 = android.os.SystemClock.elapsedRealtime();	 Catch:{ all -> 0x02f5 }
        r6 = r11.j;	 Catch:{ all -> 0x02f5 }
        r8 = r4 - r6;
        r6 = 1500; // 0x5dc float:2.102E-42 double:7.41E-321;
        r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
        if (r10 < 0) goto L_0x009c;
    L_0x0098:
        r11.j = r4;	 Catch:{ all -> 0x02f5 }
        r4 = r3;
        goto L_0x009d;
    L_0x009c:
        r4 = r1;
    L_0x009d:
        r5 = r0.ring;	 Catch:{ all -> 0x02f5 }
        if (r5 == 0) goto L_0x00a7;
    L_0x00a1:
        if (r4 != 0) goto L_0x00a7;
    L_0x00a3:
        if (r2 != 0) goto L_0x00a7;
    L_0x00a5:
        r5 = r1;
        goto L_0x00a8;
    L_0x00a7:
        r5 = r3;
    L_0x00a8:
        r6 = r0.vibrate;	 Catch:{ all -> 0x02f5 }
        if (r6 == 0) goto L_0x00b2;
    L_0x00ac:
        if (r4 != 0) goto L_0x00b2;
    L_0x00ae:
        if (r2 != 0) goto L_0x00b2;
    L_0x00b0:
        r2 = r1;
        goto L_0x00b3;
    L_0x00b2:
        r2 = r3;
    L_0x00b3:
        r4 = r11.i;	 Catch:{ all -> 0x02f5 }
        r4 = r4 + r14;
        r11.i = r4;	 Catch:{ all -> 0x02f5 }
        r14 = com.qiyukf.nimlib.b.d();	 Catch:{ all -> 0x02f5 }
        r14 = r14.userInfoProvider;	 Catch:{ all -> 0x02f5 }
        if (r14 == 0) goto L_0x00e2;
    L_0x00c0:
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02f5 }
        r4.<init>();	 Catch:{ all -> 0x02f5 }
        r6 = r12.getFromAccount();	 Catch:{ all -> 0x02f5 }
        r4.append(r6);	 Catch:{ all -> 0x02f5 }
        r6 = r12.getUuid();	 Catch:{ all -> 0x02f5 }
        r4.append(r6);	 Catch:{ all -> 0x02f5 }
        r4 = r4.toString();	 Catch:{ all -> 0x02f5 }
        r14 = r14.getUserInfo(r4);	 Catch:{ all -> 0x02f5 }
        if (r14 == 0) goto L_0x00e2;
    L_0x00dd:
        r13 = r14.getName();	 Catch:{ all -> 0x02f5 }
        goto L_0x00ec;
    L_0x00e2:
        r14 = android.text.TextUtils.isEmpty(r13);	 Catch:{ all -> 0x02f5 }
        if (r14 == 0) goto L_0x00ec;
    L_0x00e8:
        r13 = r12.getFromAccount();	 Catch:{ all -> 0x02f5 }
    L_0x00ec:
        r14 = r0.hideContent;	 Catch:{ all -> 0x02f5 }
        r0 = r12.getSessionId();	 Catch:{ all -> 0x02f5 }
        r4 = r12.getSessionType();	 Catch:{ all -> 0x02f5 }
        r4 = r4.getValue();	 Catch:{ all -> 0x02f5 }
        r0 = com.qiyukf.nimlib.i.g.a(r0, r4);	 Catch:{ all -> 0x02f5 }
        r4 = "";
        r11.e = r4;	 Catch:{ all -> 0x02f5 }
        r4 = "";
        r11.f = r4;	 Catch:{ all -> 0x02f5 }
        r4 = r11.d;	 Catch:{ all -> 0x02f5 }
        r4 = r4.containsKey(r0);	 Catch:{ all -> 0x02f5 }
        if (r4 != 0) goto L_0x0113;
    L_0x010e:
        r4 = r11.d;	 Catch:{ all -> 0x02f5 }
        r4.put(r0, r12);	 Catch:{ all -> 0x02f5 }
    L_0x0113:
        r0 = r12.getSessionType();	 Catch:{ all -> 0x02f5 }
        r4 = com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum.P2P;	 Catch:{ all -> 0x02f5 }
        if (r0 != r4) goto L_0x011c;
    L_0x011b:
        goto L_0x0158;
    L_0x011c:
        r13 = r12.getSessionType();	 Catch:{ all -> 0x02f5 }
        r0 = com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum.Ysf;	 Catch:{ all -> 0x02f5 }
        if (r13 != r0) goto L_0x0154;
    L_0x0124:
        r13 = com.qiyukf.unicorn.d.e();	 Catch:{ all -> 0x02f5 }
        r13 = r13.onShopEventListener;	 Catch:{ all -> 0x02f5 }
        if (r13 == 0) goto L_0x013d;
    L_0x012c:
        r0 = r11.a;	 Catch:{ all -> 0x02f5 }
        r4 = r12.getSessionId();	 Catch:{ all -> 0x02f5 }
        r13 = r13.getNotificationTitle(r0, r4);	 Catch:{ all -> 0x02f5 }
        r0 = android.text.TextUtils.isEmpty(r13);	 Catch:{ all -> 0x02f5 }
        if (r0 != 0) goto L_0x013d;
    L_0x013c:
        goto L_0x0158;
    L_0x013d:
        r13 = com.qiyukf.unicorn.d.e();	 Catch:{ all -> 0x02f5 }
        r13 = r13.statusBarNotificationConfig;	 Catch:{ all -> 0x02f5 }
        r13 = r13.contentTitle;	 Catch:{ all -> 0x02f5 }
        r13 = android.text.TextUtils.isEmpty(r13);	 Catch:{ all -> 0x02f5 }
        if (r13 != 0) goto L_0x0154;
    L_0x014b:
        r13 = com.qiyukf.unicorn.d.e();	 Catch:{ all -> 0x02f5 }
        r13 = r13.statusBarNotificationConfig;	 Catch:{ all -> 0x02f5 }
        r13 = r13.contentTitle;	 Catch:{ all -> 0x02f5 }
        goto L_0x0158;
    L_0x0154:
        r13 = r11.e();	 Catch:{ all -> 0x02f5 }
    L_0x0158:
        r0 = r11.d;	 Catch:{ all -> 0x02f5 }
        r0 = r0.size();	 Catch:{ all -> 0x02f5 }
        if (r0 != r1) goto L_0x01a2;
    L_0x0160:
        r11.e = r13;	 Catch:{ all -> 0x02f5 }
        r0 = r11.i;	 Catch:{ all -> 0x02f5 }
        r4 = 99;
        if (r0 <= r4) goto L_0x0169;
    L_0x0168:
        goto L_0x016b;
    L_0x0169:
        r4 = r11.i;	 Catch:{ all -> 0x02f5 }
    L_0x016b:
        r11.i = r4;	 Catch:{ all -> 0x02f5 }
        r0 = r11.i;	 Catch:{ all -> 0x02f5 }
        if (r0 <= r1) goto L_0x0190;
    L_0x0171:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02f5 }
        r0.<init>();	 Catch:{ all -> 0x02f5 }
        r4 = r11.e;	 Catch:{ all -> 0x02f5 }
        r0.append(r4);	 Catch:{ all -> 0x02f5 }
        r4 = "(";
        r0.append(r4);	 Catch:{ all -> 0x02f5 }
        r4 = r11.i;	 Catch:{ all -> 0x02f5 }
        r0.append(r4);	 Catch:{ all -> 0x02f5 }
        r4 = ")";
        r0.append(r4);	 Catch:{ all -> 0x02f5 }
        r0 = r0.toString();	 Catch:{ all -> 0x02f5 }
        r11.e = r0;	 Catch:{ all -> 0x02f5 }
    L_0x0190:
        if (r14 == 0) goto L_0x019d;
    L_0x0192:
        r14 = r11.a;	 Catch:{ all -> 0x02f5 }
        r0 = com.qiyukf.unicorn.R.string.ysf_msg_notify_hide;	 Catch:{ all -> 0x02f5 }
        r14 = r14.getString(r0);	 Catch:{ all -> 0x02f5 }
    L_0x019a:
        r11.f = r14;	 Catch:{ all -> 0x02f5 }
        goto L_0x01bf;
    L_0x019d:
        r14 = com.qiyukf.nimlib.i.g.a(r12);	 Catch:{ all -> 0x02f5 }
        goto L_0x019a;
    L_0x01a2:
        r14 = r11.e();	 Catch:{ all -> 0x02f5 }
        r11.e = r14;	 Catch:{ all -> 0x02f5 }
        r14 = r11.a;	 Catch:{ all -> 0x02f5 }
        r0 = com.qiyukf.unicorn.R.string.ysf_msg_notify_multi_person;	 Catch:{ all -> 0x02f5 }
        r4 = new java.lang.Object[r1];	 Catch:{ all -> 0x02f5 }
        r6 = r11.d;	 Catch:{ all -> 0x02f5 }
        r6 = r6.size();	 Catch:{ all -> 0x02f5 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x02f5 }
        r4[r3] = r6;	 Catch:{ all -> 0x02f5 }
        r14 = r14.getString(r0, r4);	 Catch:{ all -> 0x02f5 }
        goto L_0x019a;
    L_0x01bf:
        r14 = r11.a;	 Catch:{ all -> 0x02f5 }
        r0 = com.qiyukf.unicorn.R.string.ysf_msg_notify_ticker_text;	 Catch:{ all -> 0x02f5 }
        r4 = new java.lang.Object[r1];	 Catch:{ all -> 0x02f5 }
        r4[r3] = r13;	 Catch:{ all -> 0x02f5 }
        r13 = r14.getString(r0, r4);	 Catch:{ all -> 0x02f5 }
        r11.g = r13;	 Catch:{ all -> 0x02f5 }
        r13 = new android.content.Intent;	 Catch:{ all -> 0x02f5 }
        r13.<init>();	 Catch:{ all -> 0x02f5 }
        r14 = com.qiyukf.unicorn.d.e();	 Catch:{ all -> 0x02f5 }
        r14 = r14.statusBarNotificationConfig;	 Catch:{ all -> 0x02f5 }
        r14 = r14.notificationEntrance;	 Catch:{ all -> 0x02f5 }
        if (r14 != 0) goto L_0x01f1;
    L_0x01dc:
        r14 = r11.a;	 Catch:{ all -> 0x02f5 }
        r14 = r14.getPackageManager();	 Catch:{ all -> 0x02f5 }
        r0 = r11.a;	 Catch:{ all -> 0x02f5 }
        r0 = r0.getPackageName();	 Catch:{ all -> 0x02f5 }
        r14 = r14.getLaunchIntentForPackage(r0);	 Catch:{ all -> 0x02f5 }
        r14 = r14.getComponent();	 Catch:{ all -> 0x02f5 }
        goto L_0x01f9;
    L_0x01f1:
        r0 = new android.content.ComponentName;	 Catch:{ all -> 0x02f5 }
        r4 = r11.a;	 Catch:{ all -> 0x02f5 }
        r0.<init>(r4, r14);	 Catch:{ all -> 0x02f5 }
        r14 = r0;
    L_0x01f9:
        r13.setComponent(r14);	 Catch:{ all -> 0x02f5 }
        r14 = "com.netease.nim.EXTRA.NOTIFY_CONTENT.UNICORN";
        r0 = r11.d;	 Catch:{ all -> 0x02f5 }
        r0 = r0.values();	 Catch:{ all -> 0x02f5 }
        r0 = r0.iterator();	 Catch:{ all -> 0x02f5 }
        r0 = r0.next();	 Catch:{ all -> 0x02f5 }
        r0 = (java.io.Serializable) r0;	 Catch:{ all -> 0x02f5 }
        r13.putExtra(r14, r0);	 Catch:{ all -> 0x02f5 }
        r14 = "com.qiyukf.EXTRA.MSG_CONTENT";
        r0 = r11.f;	 Catch:{ all -> 0x02f5 }
        r13.putExtra(r14, r0);	 Catch:{ all -> 0x02f5 }
        r14 = 603979776; // 0x24000000 float:2.7755576E-17 double:2.98405658E-315;
        r13.addFlags(r14);	 Catch:{ all -> 0x02f5 }
        r14 = "android.intent.action.VIEW";
        r13.setAction(r14);	 Catch:{ all -> 0x02f5 }
        r14 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r13.addFlags(r14);	 Catch:{ all -> 0x02f5 }
        r0 = r11.a;	 Catch:{ all -> 0x02f5 }
        r4 = com.qiyukf.nimlib.g.c.MESSAGE;	 Catch:{ all -> 0x02f5 }
        r4 = r4.ordinal();	 Catch:{ all -> 0x02f5 }
        r13 = android.app.PendingIntent.getActivity(r0, r4, r13, r14);	 Catch:{ all -> 0x02f5 }
        if (r13 == 0) goto L_0x02f3;
    L_0x0235:
        r6 = r12.getTime();	 Catch:{ all -> 0x02f5 }
        r14 = com.qiyukf.unicorn.d.e();	 Catch:{ all -> 0x02f5 }
        r14 = r14.statusBarNotificationConfig;	 Catch:{ all -> 0x02f5 }
        r0 = 4;
        r4 = 0;
        if (r2 == 0) goto L_0x0244;
    L_0x0243:
        r0 = 6;
    L_0x0244:
        if (r5 == 0) goto L_0x0253;
    L_0x0246:
        r2 = r14.notificationSound;	 Catch:{ all -> 0x02f5 }
        if (r2 == 0) goto L_0x0251;
    L_0x024a:
        r2 = r14.notificationSound;	 Catch:{ all -> 0x02f5 }
        r4 = android.net.Uri.parse(r2);	 Catch:{ all -> 0x02f5 }
        goto L_0x0253;
    L_0x0251:
        r0 = r0 | 1;
    L_0x0253:
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x02f5 }
        r5 = 26;
        if (r2 < r5) goto L_0x02a2;
    L_0x0259:
        r2 = new android.app.Notification$Builder;	 Catch:{ all -> 0x02f5 }
        r5 = r11.a;	 Catch:{ all -> 0x02f5 }
        r8 = r11.h;	 Catch:{ all -> 0x02f5 }
        r2.<init>(r5, r8);	 Catch:{ all -> 0x02f5 }
        r5 = r11.e;	 Catch:{ all -> 0x02f5 }
        r5 = r2.setContentTitle(r5);	 Catch:{ all -> 0x02f5 }
        r8 = r11.f;	 Catch:{ all -> 0x02f5 }
        r5 = r5.setContentText(r8);	 Catch:{ all -> 0x02f5 }
        r1 = r5.setAutoCancel(r1);	 Catch:{ all -> 0x02f5 }
        r13 = r1.setContentIntent(r13);	 Catch:{ all -> 0x02f5 }
        r1 = r11.g;	 Catch:{ all -> 0x02f5 }
        r13 = r13.setTicker(r1);	 Catch:{ all -> 0x02f5 }
        r1 = r11.a(r14);	 Catch:{ all -> 0x02f5 }
        r13 = r13.setSmallIcon(r1);	 Catch:{ all -> 0x02f5 }
        r13 = r13.setWhen(r6);	 Catch:{ all -> 0x02f5 }
        r12 = r11.a(r12);	 Catch:{ all -> 0x02f5 }
        r12 = r13.setLargeIcon(r12);	 Catch:{ all -> 0x02f5 }
        r13 = r14.color;	 Catch:{ all -> 0x02f5 }
        r12.setColor(r13);	 Catch:{ all -> 0x02f5 }
        r2.setDefaults(r0);	 Catch:{ all -> 0x02f5 }
        if (r4 == 0) goto L_0x029d;
    L_0x029a:
        r2.setSound(r4);	 Catch:{ all -> 0x02f5 }
    L_0x029d:
        r12 = r2.build();	 Catch:{ all -> 0x02f5 }
        goto L_0x02e8;
    L_0x02a2:
        r2 = new android.support.v4.app.NotificationCompat$Builder;	 Catch:{ all -> 0x02f5 }
        r5 = r11.a;	 Catch:{ all -> 0x02f5 }
        r2.<init>(r5);	 Catch:{ all -> 0x02f5 }
        r5 = r11.e;	 Catch:{ all -> 0x02f5 }
        r5 = r2.setContentTitle(r5);	 Catch:{ all -> 0x02f5 }
        r8 = r11.f;	 Catch:{ all -> 0x02f5 }
        r5 = r5.setContentText(r8);	 Catch:{ all -> 0x02f5 }
        r1 = r5.setAutoCancel(r1);	 Catch:{ all -> 0x02f5 }
        r13 = r1.setContentIntent(r13);	 Catch:{ all -> 0x02f5 }
        r1 = r11.g;	 Catch:{ all -> 0x02f5 }
        r13 = r13.setTicker(r1);	 Catch:{ all -> 0x02f5 }
        r1 = r11.a(r14);	 Catch:{ all -> 0x02f5 }
        r13 = r13.setSmallIcon(r1);	 Catch:{ all -> 0x02f5 }
        r13 = r13.setWhen(r6);	 Catch:{ all -> 0x02f5 }
        r12 = r11.a(r12);	 Catch:{ all -> 0x02f5 }
        r12 = r13.setLargeIcon(r12);	 Catch:{ all -> 0x02f5 }
        r13 = r14.color;	 Catch:{ all -> 0x02f5 }
        r12.setColor(r13);	 Catch:{ all -> 0x02f5 }
        r2.setDefaults(r0);	 Catch:{ all -> 0x02f5 }
        if (r4 == 0) goto L_0x02e4;
    L_0x02e1:
        r2.setSound(r4);	 Catch:{ all -> 0x02f5 }
    L_0x02e4:
        r12 = r2.build();	 Catch:{ all -> 0x02f5 }
    L_0x02e8:
        r13 = r11.c;	 Catch:{ all -> 0x02f5 }
        r14 = com.qiyukf.nimlib.g.c.MESSAGE;	 Catch:{ all -> 0x02f5 }
        r14 = r14.a();	 Catch:{ all -> 0x02f5 }
        r13.notify(r14, r3, r12);	 Catch:{ all -> 0x02f5 }
    L_0x02f3:
        monitor-exit(r11);
        return;
    L_0x02f5:
        r12 = move-exception;
        monitor-exit(r11);
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.g.b.b(com.qiyukf.nimlib.i.a, java.lang.String, int):void");
    }

    private static boolean c() {
        return com.qiyukf.unicorn.d.e().statusBarNotificationConfig != null && com.qiyukf.unicorn.b.b.k();
    }

    private synchronized void d() {
        this.c.cancel(c.MESSAGE.a(), 0);
        this.i = 0;
        this.d.clear();
    }

    private String e() {
        CharSequence charSequence;
        if (this.a.getApplicationInfo().labelRes == 0) {
            PackageManager packageManager = this.a.getPackageManager();
            try {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(this.a.getPackageName(), 0);
                charSequence = (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : "");
            } catch (Exception unused) {
                charSequence = null;
            }
        } else {
            charSequence = this.a.getString(this.a.getApplicationInfo().labelRes);
        }
        return TextUtils.isEmpty(charSequence) ? this.a.getString(R.string.ysf_msg_notify_default_title) : charSequence;
    }
}
