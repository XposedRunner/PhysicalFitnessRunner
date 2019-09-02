package cn.jiguang.a.c;

import android.content.Context;

final class d implements Runnable {
    private Context a;
    private int b;

    public d(Context context, int i) {
        this.a = context;
        this.b = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x022d A:{Catch:{ Throwable -> 0x02fe }} */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0291 A:{Catch:{ Throwable -> 0x02fe }} */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x029b A:{SYNTHETIC, Splitter:B:67:0x029b} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x02a5 A:{SYNTHETIC, Splitter:B:72:0x02a5} */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x02cd A:{SYNTHETIC, Splitter:B:84:0x02cd} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02da A:{SYNTHETIC, Splitter:B:89:0x02da} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x02f9 A:{Catch:{ Throwable -> 0x02fe }} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x016e A:{Catch:{ Throwable -> 0x02fe }} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0162 A:{Catch:{ Throwable -> 0x02fe }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0183 A:{Catch:{ Throwable -> 0x02fe }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0245 A:{Catch:{ Throwable -> 0x02fe }} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x01c4 A:{Catch:{ Throwable -> 0x02fe }} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0262 A:{Catch:{ Throwable -> 0x02fe }} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0281 A:{SKIP, Catch:{ Throwable -> 0x02fe }} */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0291 A:{Catch:{ Throwable -> 0x02fe }} */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x029b A:{SYNTHETIC, Splitter:B:67:0x029b} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x02a5 A:{SYNTHETIC, Splitter:B:72:0x02a5} */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x02cd A:{SYNTHETIC, Splitter:B:84:0x02cd} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02da A:{SYNTHETIC, Splitter:B:89:0x02da} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x02f9 A:{Catch:{ Throwable -> 0x02fe }} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x02f9 A:{Catch:{ Throwable -> 0x02fe }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:93:0x02ee */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x02a5 A:{SYNTHETIC, Splitter:B:72:0x02a5} */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x02cd A:{SYNTHETIC, Splitter:B:84:0x02cd} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02da A:{SYNTHETIC, Splitter:B:89:0x02da} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x02f9 A:{Catch:{ Throwable -> 0x02fe }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x02a1 */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02da A:{SYNTHETIC, Splitter:B:89:0x02da} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x02f9 A:{Catch:{ Throwable -> 0x02fe }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:86:0x02d6 */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x02cd A:{SYNTHETIC, Splitter:B:84:0x02cd} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02da A:{SYNTHETIC, Splitter:B:89:0x02da} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x02f9 A:{Catch:{ Throwable -> 0x02fe }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:81:0x02c9 */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x02cd A:{SYNTHETIC, Splitter:B:84:0x02cd} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02da A:{SYNTHETIC, Splitter:B:89:0x02da} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x02f9 A:{Catch:{ Throwable -> 0x02fe }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:74:0x02aa */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Can't wrap try/catch for region: R(39:5|(1:7)(1:8)|9|(4:11|(2:13|(1:15))|16|(35:18|20|(1:22)(1:23)|24|(2:26|(2:28|(1:30)(1:31)))|32|(2:34|(1:36)(2:37|(5:39|(1:(1:42)(3:43|(1:46)|47))|44|(0)|47)(1:48)))(1:49)|50|(2:52|(1:54)(23:55|57|(1:61)(1:60)|62|(1:64)|65|(2:67|68)|69|70|(2:72|73)|74|75|(2:79|80)|81|82|(2:84|85)|86|87|(3:89|90|(1:92))|93|94|(1:96)|97))|56|57|(0)|61|62|(0)|65|(0)|69|70|(0)|74|75|77|79|80|81|82|(0)|86|87|(0)|93|94|(0)|97))|19|20|(0)(0)|24|(0)|32|(0)(0)|50|(0)|56|57|(0)|61|62|(0)|65|(0)|69|70|(0)|74|75|77|79|80|81|82|(0)|86|87|(0)|93|94|(0)|97) */
    public final void run() {
        /*
        r29 = this;
        r0 = r29;
        r1 = r0.a;	 Catch:{ Throwable -> 0x02fe }
        cn.jiguang.d.d.x.c(r1);	 Catch:{ Throwable -> 0x02fe }
        r1 = "ReportHelper";
        r2 = "periodTasks...";
        cn.jiguang.e.c.b(r1, r2);	 Catch:{ Throwable -> 0x02fe }
        r1 = r0.a;	 Catch:{ Throwable -> 0x02fe }
        r1 = cn.jiguang.d.a.d.d(r1);	 Catch:{ Throwable -> 0x02fe }
        if (r1 != 0) goto L_0x0017;
    L_0x0016:
        return;
    L_0x0017:
        r1 = r0.a;	 Catch:{ Throwable -> 0x02fe }
        r2 = new cn.jiguang.g.b.a;	 Catch:{ Throwable -> 0x02fe }
        r2.<init>();	 Catch:{ Throwable -> 0x02fe }
        r3 = "last_report_device_info";
        r4 = 0;
        r6 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x02fe }
        r2 = r2.a(r3, r6);	 Catch:{ Throwable -> 0x02fe }
        r3 = "lbs_report_enable";
        r6 = 1;
        r7 = java.lang.Boolean.valueOf(r6);	 Catch:{ Throwable -> 0x02fe }
        r2 = r2.a(r3, r7);	 Catch:{ Throwable -> 0x02fe }
        r3 = "last_collection_location";
        r7 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x02fe }
        r2 = r2.a(r3, r7);	 Catch:{ Throwable -> 0x02fe }
        r3 = "location_report_delay";
        r7 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x02fe }
        r2 = r2.a(r3, r7);	 Catch:{ Throwable -> 0x02fe }
        r3 = "location_collect_frequency";
        r7 = 900000; // 0xdbba0 float:1.261169E-39 double:4.44659E-318;
        r9 = java.lang.Long.valueOf(r7);	 Catch:{ Throwable -> 0x02fe }
        r2 = r2.a(r3, r9);	 Catch:{ Throwable -> 0x02fe }
        r3 = "last_check_userapp_status";
        r9 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x02fe }
        r2 = r2.a(r3, r9);	 Catch:{ Throwable -> 0x02fe }
        r3 = "nb_upload";
        r9 = 0;
        r10 = java.lang.Boolean.valueOf(r9);	 Catch:{ Throwable -> 0x02fe }
        r2 = r2.a(r3, r10);	 Catch:{ Throwable -> 0x02fe }
        r3 = "nb_lasttime";
        r10 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x02fe }
        r2 = r2.a(r3, r10);	 Catch:{ Throwable -> 0x02fe }
        r3 = "app_running_collect_enable";
        r10 = java.lang.Boolean.valueOf(r6);	 Catch:{ Throwable -> 0x02fe }
        r2 = r2.a(r3, r10);	 Catch:{ Throwable -> 0x02fe }
        r3 = "app_running_collect_interval";
        r10 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        r12 = java.lang.Long.valueOf(r10);	 Catch:{ Throwable -> 0x02fe }
        r2 = r2.a(r3, r12);	 Catch:{ Throwable -> 0x02fe }
        r3 = "app_running_last_collect_time";
        r12 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x02fe }
        r2 = r2.a(r3, r12);	 Catch:{ Throwable -> 0x02fe }
        r3 = "app_running_collect_app_type";
        r12 = java.lang.Integer.valueOf(r6);	 Catch:{ Throwable -> 0x02fe }
        r2 = r2.a(r3, r12);	 Catch:{ Throwable -> 0x02fe }
        r3 = "app_running_collect_process_type";
        r12 = java.lang.Integer.valueOf(r6);	 Catch:{ Throwable -> 0x02fe }
        r2 = r2.a(r3, r12);	 Catch:{ Throwable -> 0x02fe }
        r3 = "battery_last_collect_time";
        r12 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x02fe }
        r2 = r2.a(r3, r12);	 Catch:{ Throwable -> 0x02fe }
        r2 = cn.jiguang.d.a.d.b(r1, r2);	 Catch:{ Throwable -> 0x02fe }
        r3 = new cn.jiguang.g.b.a;	 Catch:{ Throwable -> 0x02fe }
        r3.<init>();	 Catch:{ Throwable -> 0x02fe }
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x02fe }
        r14 = "last_report_device_info";
        r15 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x02fe }
        r14 = r2.b(r14, r15);	 Catch:{ Throwable -> 0x02fe }
        r14 = (java.lang.Long) r14;	 Catch:{ Throwable -> 0x02fe }
        r14 = r14.longValue();	 Catch:{ Throwable -> 0x02fe }
        r16 = r12 - r14;
        r14 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r18 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1));
        if (r18 <= 0) goto L_0x00dd;
    L_0x00da:
        r20 = r6;
        goto L_0x00df;
    L_0x00dd:
        r20 = r9;
    L_0x00df:
        r14 = "lbs_report_enable";
        r15 = java.lang.Boolean.valueOf(r6);	 Catch:{ Throwable -> 0x02fe }
        r14 = r2.b(r14, r15);	 Catch:{ Throwable -> 0x02fe }
        r14 = (java.lang.Boolean) r14;	 Catch:{ Throwable -> 0x02fe }
        r14 = r14.booleanValue();	 Catch:{ Throwable -> 0x02fe }
        if (r14 == 0) goto L_0x0148;
    L_0x00f1:
        r15 = "last_collection_location";
        r6 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x02fe }
        r6 = r2.b(r15, r6);	 Catch:{ Throwable -> 0x02fe }
        r6 = (java.lang.Long) r6;	 Catch:{ Throwable -> 0x02fe }
        r15 = r6.longValue();	 Catch:{ Throwable -> 0x02fe }
        r6 = "location_collect_frequency";
        r7 = java.lang.Long.valueOf(r7);	 Catch:{ Throwable -> 0x02fe }
        r6 = r2.b(r6, r7);	 Catch:{ Throwable -> 0x02fe }
        r6 = (java.lang.Long) r6;	 Catch:{ Throwable -> 0x02fe }
        r6 = r6.longValue();	 Catch:{ Throwable -> 0x02fe }
        r8 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1));
        if (r8 > 0) goto L_0x0137;
    L_0x0115:
        r8 = "location_report_delay";
        r9 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x02fe }
        r8 = r2.b(r8, r9);	 Catch:{ Throwable -> 0x02fe }
        r8 = (java.lang.Long) r8;	 Catch:{ Throwable -> 0x02fe }
        r8 = r8.longValue();	 Catch:{ Throwable -> 0x02fe }
        r17 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
        if (r17 <= 0) goto L_0x0137;
    L_0x0129:
        r15 = r12 + r8;
        r8 = r15 - r6;
        r15 = "last_collection_location";
        r10 = java.lang.Long.valueOf(r8);	 Catch:{ Throwable -> 0x02fe }
        r3.a(r15, r10);	 Catch:{ Throwable -> 0x02fe }
        r15 = r8;
    L_0x0137:
        r8 = r12 - r15;
        r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
        if (r10 < 0) goto L_0x0148;
    L_0x013d:
        r6 = "last_collection_location";
        r7 = java.lang.Long.valueOf(r12);	 Catch:{ Throwable -> 0x02fe }
        r3.a(r6, r7);	 Catch:{ Throwable -> 0x02fe }
        r6 = 1;
        goto L_0x0149;
    L_0x0148:
        r6 = 0;
    L_0x0149:
        r7 = "last_check_userapp_status";
        r8 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x02fe }
        r7 = r2.b(r7, r8);	 Catch:{ Throwable -> 0x02fe }
        r7 = (java.lang.Long) r7;	 Catch:{ Throwable -> 0x02fe }
        r7 = r7.longValue();	 Catch:{ Throwable -> 0x02fe }
        r9 = r12 - r7;
        r7 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1));
        if (r11 <= 0) goto L_0x016e;
    L_0x0162:
        r7 = "last_check_userapp_status";
        r8 = java.lang.Long.valueOf(r12);	 Catch:{ Throwable -> 0x02fe }
        r3.a(r7, r8);	 Catch:{ Throwable -> 0x02fe }
        r22 = 1;
        goto L_0x0170;
    L_0x016e:
        r22 = 0;
    L_0x0170:
        r7 = "nb_upload";
        r8 = 0;
        r9 = java.lang.Boolean.valueOf(r8);	 Catch:{ Throwable -> 0x02fe }
        r7 = r2.b(r7, r9);	 Catch:{ Throwable -> 0x02fe }
        r7 = (java.lang.Boolean) r7;	 Catch:{ Throwable -> 0x02fe }
        r7 = r7.booleanValue();	 Catch:{ Throwable -> 0x02fe }
        if (r7 == 0) goto L_0x01af;
    L_0x0183:
        r7 = cn.jiguang.g.a.e(r1);	 Catch:{ Throwable -> 0x02fe }
        r7 = r7.toUpperCase();	 Catch:{ Throwable -> 0x02fe }
        r8 = "WIFI";
        r7 = r7.startsWith(r8);	 Catch:{ Throwable -> 0x02fe }
        if (r7 == 0) goto L_0x01af;
    L_0x0193:
        r7 = "nb_lasttime";
        r8 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x02fe }
        r7 = r2.b(r7, r8);	 Catch:{ Throwable -> 0x02fe }
        r7 = (java.lang.Long) r7;	 Catch:{ Throwable -> 0x02fe }
        r7 = r7.longValue();	 Catch:{ Throwable -> 0x02fe }
        r9 = r12 - r7;
        r7 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1));
        if (r11 <= 0) goto L_0x01ae;
    L_0x01ac:
        r7 = 1;
        goto L_0x01af;
    L_0x01ae:
        r7 = 0;
    L_0x01af:
        r23 = r7;
        r7 = "app_running_collect_enable";
        r8 = 1;
        r9 = java.lang.Boolean.valueOf(r8);	 Catch:{ Throwable -> 0x02fe }
        r7 = r2.b(r7, r9);	 Catch:{ Throwable -> 0x02fe }
        r7 = (java.lang.Boolean) r7;	 Catch:{ Throwable -> 0x02fe }
        r7 = r7.booleanValue();	 Catch:{ Throwable -> 0x02fe }
        if (r7 == 0) goto L_0x0245;
    L_0x01c4:
        r7 = "app_running_last_collect_time";
        r8 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x02fe }
        r7 = r2.b(r7, r8);	 Catch:{ Throwable -> 0x02fe }
        r7 = (java.lang.Long) r7;	 Catch:{ Throwable -> 0x02fe }
        r7 = r7.longValue();	 Catch:{ Throwable -> 0x02fe }
        r9 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1));
        if (r9 > 0) goto L_0x01e9;
    L_0x01d8:
        r7 = "app_running_last_collect_time";
        r8 = java.lang.Long.valueOf(r12);	 Catch:{ Throwable -> 0x02fe }
        r3.a(r7, r8);	 Catch:{ Throwable -> 0x02fe }
        r5 = 1;
        r24 = 1;
        r25 = 1;
        r26 = 1;
        goto L_0x024c;
    L_0x01e9:
        r9 = r12 - r7;
        r7 = "app_running_collect_interval";
        r4 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        r8 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x02fe }
        r4 = r2.b(r7, r8);	 Catch:{ Throwable -> 0x02fe }
        r4 = (java.lang.Long) r4;	 Catch:{ Throwable -> 0x02fe }
        r4 = r4.longValue();	 Catch:{ Throwable -> 0x02fe }
        r7 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1));
        if (r7 < 0) goto L_0x023d;
    L_0x0202:
        r4 = "app_running_collect_app_type";
        r5 = 1;
        r7 = java.lang.Integer.valueOf(r5);	 Catch:{ Throwable -> 0x02fe }
        r4 = r2.b(r4, r7);	 Catch:{ Throwable -> 0x02fe }
        r4 = (java.lang.Integer) r4;	 Catch:{ Throwable -> 0x02fe }
        r4 = r4.intValue();	 Catch:{ Throwable -> 0x02fe }
        r7 = "app_running_collect_process_type";
        r8 = java.lang.Integer.valueOf(r5);	 Catch:{ Throwable -> 0x02fe }
        r7 = r2.b(r7, r8);	 Catch:{ Throwable -> 0x02fe }
        r7 = (java.lang.Integer) r7;	 Catch:{ Throwable -> 0x02fe }
        r7 = r7.intValue();	 Catch:{ Throwable -> 0x02fe }
        if (r4 != 0) goto L_0x022a;
    L_0x0225:
        if (r7 == 0) goto L_0x0228;
    L_0x0227:
        goto L_0x022a;
    L_0x0228:
        r8 = 0;
        goto L_0x022b;
    L_0x022a:
        r8 = r5;
    L_0x022b:
        if (r8 == 0) goto L_0x0236;
    L_0x022d:
        r9 = "app_running_last_collect_time";
        r10 = java.lang.Long.valueOf(r12);	 Catch:{ Throwable -> 0x02fe }
        r3.a(r9, r10);	 Catch:{ Throwable -> 0x02fe }
    L_0x0236:
        r25 = r4;
        r26 = r7;
        r24 = r8;
        goto L_0x024c;
    L_0x023d:
        r5 = 1;
        r25 = r5;
        r26 = r25;
        r24 = 0;
        goto L_0x024c;
    L_0x0245:
        r5 = 1;
        r25 = r5;
        r26 = r25;
        r24 = r7;
    L_0x024c:
        r4 = "battery_last_collect_time";
        r7 = 0;
        r9 = java.lang.Long.valueOf(r7);	 Catch:{ Throwable -> 0x02fe }
        r2 = r2.b(r4, r9);	 Catch:{ Throwable -> 0x02fe }
        r2 = (java.lang.Long) r2;	 Catch:{ Throwable -> 0x02fe }
        r9 = r2.longValue();	 Catch:{ Throwable -> 0x02fe }
        r2 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1));
        if (r2 <= 0) goto L_0x026f;
    L_0x0262:
        r7 = r12 - r9;
        r9 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));
        if (r2 < 0) goto L_0x026c;
    L_0x026b:
        goto L_0x026f;
    L_0x026c:
        r27 = 0;
        goto L_0x027a;
    L_0x026f:
        r2 = "battery_last_collect_time";
        r4 = java.lang.Long.valueOf(r12);	 Catch:{ Throwable -> 0x02fe }
        r3.a(r2, r4);	 Catch:{ Throwable -> 0x02fe }
        r27 = r5;
    L_0x027a:
        cn.jiguang.d.a.d.a(r1, r3);	 Catch:{ Throwable -> 0x02fe }
        r1 = new cn.jiguang.a.b.b;	 Catch:{ Throwable -> 0x02fe }
        if (r14 == 0) goto L_0x0286;
    L_0x0281:
        if (r6 == 0) goto L_0x0286;
    L_0x0283:
        r21 = r5;
        goto L_0x0288;
    L_0x0286:
        r21 = 0;
    L_0x0288:
        r19 = r1;
        r19.<init>(r20, r21, r22, r23, r24, r25, r26, r27);	 Catch:{ Throwable -> 0x02fe }
        r2 = r1.b;	 Catch:{ Throwable -> 0x02fe }
        if (r2 == 0) goto L_0x0297;
    L_0x0291:
        r2 = r0.a;	 Catch:{ Throwable -> 0x02fe }
        r3 = 0;
        cn.jiguang.a.c.c.a(r2, r3);	 Catch:{ Throwable -> 0x02fe }
    L_0x0297:
        r2 = r1.c;	 Catch:{ Throwable -> 0x02fe }
        if (r2 == 0) goto L_0x02a1;
    L_0x029b:
        r2 = r0.a;	 Catch:{ Throwable -> 0x02a1 }
        r3 = 0;
        cn.jiguang.a.c.c.a(r2, r3);	 Catch:{ Throwable -> 0x02a1 }
    L_0x02a1:
        r2 = r1.d;	 Catch:{ Throwable -> 0x02fe }
        if (r2 == 0) goto L_0x02aa;
    L_0x02a5:
        r2 = r0.a;	 Catch:{ Throwable -> 0x02aa }
        cn.jiguang.a.a.c.i.a(r2);	 Catch:{ Throwable -> 0x02aa }
    L_0x02aa:
        r2 = r0.a;	 Catch:{ Throwable -> 0x02fe }
        r2 = cn.jiguang.g.a.d(r2);	 Catch:{ Throwable -> 0x02fe }
        if (r2 == 0) goto L_0x02c9;
    L_0x02b2:
        r2 = r0.a;	 Catch:{ Throwable -> 0x02fe }
        r2 = cn.jiguang.g.a.e(r2);	 Catch:{ Throwable -> 0x02fe }
        r2 = r2.toUpperCase();	 Catch:{ Throwable -> 0x02fe }
        r3 = "WIFI";
        r2 = r2.startsWith(r3);	 Catch:{ Throwable -> 0x02fe }
        if (r2 == 0) goto L_0x02c9;
    L_0x02c4:
        r2 = r0.a;	 Catch:{ Throwable -> 0x02c9 }
        cn.jiguang.a.a.a.c.a(r2);	 Catch:{ Throwable -> 0x02c9 }
    L_0x02c9:
        r2 = r1.e;	 Catch:{ Throwable -> 0x02fe }
        if (r2 == 0) goto L_0x02d6;
    L_0x02cd:
        r2 = r0.a;	 Catch:{ Throwable -> 0x02d6 }
        r3 = r1.f;	 Catch:{ Throwable -> 0x02d6 }
        r4 = r1.g;	 Catch:{ Throwable -> 0x02d6 }
        cn.jiguang.g.d.a(r2, r3, r4);	 Catch:{ Throwable -> 0x02d6 }
    L_0x02d6:
        r2 = r1.h;	 Catch:{ Throwable -> 0x02fe }
        if (r2 == 0) goto L_0x02ee;
    L_0x02da:
        r2 = r0.a;	 Catch:{ Throwable -> 0x02ee }
        r3 = cn.jiguang.d.h.a.a(r2);	 Catch:{ Throwable -> 0x02ee }
        if (r3 == 0) goto L_0x02ee;
    L_0x02e2:
        r3 = r3.a();	 Catch:{ Throwable -> 0x02ee }
        r4 = "battery";
        cn.jiguang.d.d.x.a(r2, r3, r4);	 Catch:{ Throwable -> 0x02ee }
        cn.jiguang.d.d.x.a(r2, r3);	 Catch:{ Throwable -> 0x02ee }
    L_0x02ee:
        r2 = r0.a;	 Catch:{ Throwable -> 0x02fe }
        r3 = r0.b;	 Catch:{ Throwable -> 0x02fe }
        cn.jiguang.a.c.c.b(r2, r3);	 Catch:{ Throwable -> 0x02fe }
        r1 = r1.a;	 Catch:{ Throwable -> 0x02fe }
        if (r1 == 0) goto L_0x02fe;
    L_0x02f9:
        r1 = r0.a;	 Catch:{ Throwable -> 0x02fe }
        cn.jiguang.a.a.c.b.b(r1);	 Catch:{ Throwable -> 0x02fe }
    L_0x02fe:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.c.d.run():void");
    }
}
