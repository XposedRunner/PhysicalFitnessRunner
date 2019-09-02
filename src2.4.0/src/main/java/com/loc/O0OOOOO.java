package com.loc;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.webkit.WebView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.AMapLocationMode;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.AMapLocationQualityReport;
import com.amap.api.location.APSService;
import com.amap.api.location.LocationManagerBase;
import com.amap.api.location.UmidtokenInfo;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import java.util.ArrayList;
import java.util.Iterator;
import s.h.e.l.l.C;

/* compiled from: AmapLocationManager */
public class O0OOOOO implements LocationManagerBase {
    private static boolean O00oOoOo;
    AMapLocationClientOption O000000o = new AMapLocationClientOption();
    public O00000o0 O00000Oo;
    ArrayList<AMapLocationListener> O00000o = new ArrayList();
    OO00O0 O00000o0 = null;
    boolean O00000oO = false;
    public boolean O00000oo = true;
    OO00O O0000O0o;
    Messenger O0000OOo = null;
    Intent O0000Oo = null;
    Messenger O0000Oo0 = null;
    int O0000OoO = 0;
    O00000Oo O0000Ooo = null;
    boolean O0000o = false;
    AMapLocationMode O0000o0 = AMapLocationMode.Hight_Accuracy;
    boolean O0000o00 = false;
    Object O0000o0O = new Object();
    ooO0Ooo O0000o0o = null;
    String O0000oO = null;
    OO000o O0000oO0 = null;
    AMapLocationQualityReport O0000oOO = null;
    boolean O0000oOo = false;
    O000000o O0000oo = null;
    boolean O0000oo0 = false;
    String O0000ooO = null;
    boolean O0000ooo = false;
    private volatile boolean O000O00o = false;
    private boolean O000O0OO = true;
    private boolean O000O0Oo = true;
    private ServiceConnection O000O0o = new ServiceConnection() {
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                O0OOOOO.this.O0000OOo = new Messenger(iBinder);
                O0OOOOO.this.O00oOooo = true;
                O0OOOOO.this.O0000o = true;
            } catch (Throwable th) {
                O0o0000.O000000o(th, "AmapLocationManager", "onServiceConnected");
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            O0OOOOO.this.O0000OOo = null;
            O0OOOOO.this.O00oOooo = false;
        }
    };
    private OO00O0o O000O0o0 = null;
    private Context O00oOooO;
    private boolean O00oOooo = false;

    /* compiled from: AmapLocationManager */
    public class O000000o extends Handler {
        public O000000o(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            try {
                super.handleMessage(message);
                switch (message.what) {
                    case 1002:
                        try {
                            O0OOOOO.O000000o(O0OOOOO.this, (AMapLocationListener) message.obj);
                            return;
                        } catch (Throwable th) {
                            O0o0000.O000000o(th, "AMapLocationManage$MHandlerr", "handleMessage SET_LISTENER");
                            return;
                        }
                    case 1003:
                        try {
                            O0OOOOO.this.O00000o();
                            return;
                        } catch (Throwable th2) {
                            O0o0000.O000000o(th2, "AMapLocationManage$MHandlerr", "handleMessage START_LOCATION");
                            return;
                        }
                    case 1004:
                        try {
                            O0OOOOO.this.O00000oO();
                            return;
                        } catch (Throwable th22) {
                            O0o0000.O000000o(th22, "AMapLocationManage$MHandlerr", "handleMessage STOP_LOCATION");
                            return;
                        }
                    case 1005:
                        try {
                            O0OOOOO.O00000Oo(O0OOOOO.this, (AMapLocationListener) message.obj);
                            return;
                        } catch (Throwable th222) {
                            O0o0000.O000000o(th222, "AMapLocationManage$MHandlerr", "handleMessage REMOVE_LISTENER");
                            return;
                        }
                    case 1006:
                    case 1007:
                        break;
                    case 1008:
                        try {
                            O0OOOOO.O0000Oo0(O0OOOOO.this);
                            return;
                        } catch (Throwable th2222) {
                            O0o0000.O000000o(th2222, "AMapLocationManage$MHandlerr", "handleMessage START_SOCKET");
                            return;
                        }
                    case 1009:
                        try {
                            O0OOOOO.O0000Oo(O0OOOOO.this);
                            return;
                        } catch (Throwable th22222) {
                            O0o0000.O000000o(th22222, "AMapLocationManage$MHandlerr", "handleMessage STOP_SOCKET");
                            return;
                        }
                    case 1010:
                        break;
                    case 1011:
                        try {
                            O0OOOOO.this.O000000o();
                            return;
                        } catch (Throwable th222222) {
                            O0o0000.O000000o(th222222, "AMapLocationManage$MHandlerr", "handleMessage DESTROY");
                            return;
                        }
                    case PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW /*1014*/:
                        O0OOOOO.O00000Oo(O0OOOOO.this, message);
                        return;
                    case PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW /*1015*/:
                        try {
                            O0OOOOO.this.O00000o0.O000000o(O0OOOOO.this.O000000o);
                            O0OOOOO.this.O000000o(1025, null, 300000);
                            return;
                        } catch (Throwable th2222222) {
                            O0o0000.O000000o(th2222222, "AMapLocationManage$MHandlerr", "handleMessage START_GPS_LOCATION");
                            return;
                        }
                    case PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW /*1016*/:
                        try {
                            if (O0OOOOO.this.O00000o0.O00000Oo()) {
                                O0OOOOO.this.O000000o((int) PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null, 1000);
                                return;
                            } else {
                                O0OOOOO.O00000oo(O0OOOOO.this);
                                return;
                            }
                        } catch (Throwable th22222222) {
                            O0o0000.O000000o(th22222222, "AMapLocationManage$MHandlerr", "handleMessage START_LBS_LOCATION");
                            return;
                        }
                    case PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW /*1017*/:
                        try {
                            O0OOOOO.this.O00000o0.O000000o();
                            O0OOOOO.this.O000000o(1025);
                            return;
                        } catch (Throwable th222222222) {
                            O0o0000.O000000o(th222222222, "AMapLocationManage$MHandlerr", "handleMessage STOP_GPS_LOCATION");
                            return;
                        }
                    case PointerIconCompat.TYPE_ZOOM_IN /*1018*/:
                        try {
                            O0OOOOO.this.O000000o = (AMapLocationClientOption) message.obj;
                            if (O0OOOOO.this.O000000o != null) {
                                O0OOOOO.O0000OOo(O0OOOOO.this);
                            }
                            return;
                        } catch (Throwable th2222222222) {
                            O0o0000.O000000o(th2222222222, "AMapLocationManage$MHandlerr", "handleMessage SET_OPTION");
                            return;
                        }
                    case PointerIconCompat.TYPE_ZOOM_OUT /*1019*/:
                    case 1020:
                    case 1021:
                    case 1022:
                        break;
                    case 1023:
                        try {
                            O0OOOOO.O00000o0(O0OOOOO.this, message);
                            return;
                        } catch (Throwable th22222222222) {
                            O0o0000.O000000o(th22222222222, "AMapLocationManage$MHandlerr", "handleMessage ACTION_ENABLE_BACKGROUND");
                            return;
                        }
                    case 1024:
                        try {
                            O0OOOOO.O00000o(O0OOOOO.this, message);
                            return;
                        } catch (Throwable th222222222222) {
                            O0o0000.O000000o(th222222222222, "AMapLocationManage$MHandlerr", "handleMessage ACTION_DISABLE_BACKGROUND");
                            return;
                        }
                    case 1025:
                        if (O0OOOOO.this.O00000o0 != null) {
                            if (O0OOOOO.this.O00000o0.O00000oo()) {
                                O0OOOOO.this.O00000o0.O000000o();
                                O0OOOOO.this.O00000o0.O000000o(O0OOOOO.this.O000000o);
                            }
                            O0OOOOO.this.O000000o(1025, null, 300000);
                        }
                        return;
                    default:
                        return;
                }
            } catch (Throwable th2222222222222) {
                O0o0000.O000000o(th2222222222222, "AMapLocationManage$MHandlerr", "handleMessage");
            }
        }
    }

    /* compiled from: AmapLocationManager */
    static class O00000Oo extends HandlerThread {
        O0OOOOO O000000o = null;

        public O00000Oo(String str, O0OOOOO o0ooooo) {
            super(str);
            this.O000000o = o0ooooo;
        }

        /* Access modifiers changed, original: protected|final */
        public final void onLooperPrepared() {
            try {
                this.O000000o.O0000O0o.O000000o();
                this.O000000o.O0000O0o();
                super.onLooperPrepared();
            } catch (Throwable unused) {
            }
        }

        public final void run() {
            try {
                super.run();
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: AmapLocationManager */
    public class O00000o0 extends Handler {
        public O00000o0(Looper looper) {
            super(looper);
        }

        /* JADX WARNING: Missing block: B:44:?, code skipped:
            com.loc.O0OOOOO.O000000o(r2.O000000o, r3);
     */
        /* JADX WARNING: Missing block: B:45:0x0094, code skipped:
            return;
     */
        /* JADX WARNING: Missing block: B:46:0x0095, code skipped:
            r3 = move-exception;
     */
        /* JADX WARNING: Missing block: B:48:?, code skipped:
            com.loc.O0o0000.O000000o(r3, "AmapLocationManager$ActionHandler", "handleMessage RESULT_GPS_LOCATIONSUCCESS");
     */
        /* JADX WARNING: Missing block: B:49:0x009d, code skipped:
            return;
     */
        public final void handleMessage(android.os.Message r3) {
            /*
            r2 = this;
            super.handleMessage(r3);	 Catch:{ Throwable -> 0x00c0 }
            r0 = com.loc.O0OOOOO.this;	 Catch:{ Throwable -> 0x00c0 }
            r0 = r0.O0000o00;	 Catch:{ Throwable -> 0x00c0 }
            if (r0 == 0) goto L_0x0010;
        L_0x0009:
            r0 = com.loc.O0o0000.O00000o();	 Catch:{ Throwable -> 0x00c0 }
            if (r0 != 0) goto L_0x0010;
        L_0x000f:
            return;
        L_0x0010:
            r0 = r3.what;	 Catch:{ Throwable -> 0x00c0 }
            r1 = 100;
            if (r0 == r1) goto L_0x00b1;
        L_0x0016:
            switch(r0) {
                case 1: goto L_0x009e;
                case 2: goto L_0x008f;
                case 3: goto L_0x008e;
                default: goto L_0x0019;
            };
        L_0x0019:
            switch(r0) {
                case 5: goto L_0x006f;
                case 6: goto L_0x0054;
                case 7: goto L_0x003b;
                case 8: goto L_0x0034;
                case 9: goto L_0x001d;
                default: goto L_0x001c;
            };
        L_0x001c:
            return;
        L_0x001d:
            r3 = r3.getData();	 Catch:{ Throwable -> 0x002b }
            r0 = "installMockApp";
            r3 = r3.getBoolean(r0);	 Catch:{ Throwable -> 0x002b }
            com.loc.O0OOOOO.O00oOoOo = r3;	 Catch:{ Throwable -> 0x002b }
            return;
        L_0x002b:
            r3 = move-exception;
            r0 = "AmapLocationManager$ActionHandler";
            r1 = "handleMessage RESULT_INSTALLED_MOCK_APP";
            com.loc.O0o0000.O000000o(r3, r0, r1);	 Catch:{ Throwable -> 0x00c0 }
            return;
        L_0x0034:
            r0 = 0;
            r1 = 2141; // 0x85d float:3.0E-42 double:1.058E-320;
            com.loc.ooO0Ooo.O000000o(r0, r1);	 Catch:{ Throwable -> 0x00c0 }
            goto L_0x008f;
        L_0x003b:
            r3 = r3.getData();	 Catch:{ Throwable -> 0x004b }
            r0 = com.loc.O0OOOOO.this;	 Catch:{ Throwable -> 0x004b }
            r1 = "ngpsAble";
            r3 = r3.getBoolean(r1);	 Catch:{ Throwable -> 0x004b }
            r0.O000O0Oo = r3;	 Catch:{ Throwable -> 0x004b }
            return;
        L_0x004b:
            r3 = move-exception;
            r0 = "AmapLocationManager$ActionHandler";
            r1 = "handleMessage RESULT_NGPS_ABLE";
            com.loc.O0o0000.O000000o(r3, r0, r1);	 Catch:{ Throwable -> 0x00c0 }
            return;
        L_0x0054:
            r3 = r3.getData();	 Catch:{ Throwable -> 0x0066 }
            r0 = com.loc.O0OOOOO.this;	 Catch:{ Throwable -> 0x0066 }
            r0 = r0.O00000o0;	 Catch:{ Throwable -> 0x0066 }
            if (r0 == 0) goto L_0x0065;
        L_0x005e:
            r0 = com.loc.O0OOOOO.this;	 Catch:{ Throwable -> 0x0066 }
            r0 = r0.O00000o0;	 Catch:{ Throwable -> 0x0066 }
            r0.O000000o(r3);	 Catch:{ Throwable -> 0x0066 }
        L_0x0065:
            return;
        L_0x0066:
            r3 = move-exception;
            r0 = "AmapLocationManager$ActionHandler";
            r1 = "handleMessage RESULT_GPS_GEO_SUCCESS";
            com.loc.O0o0000.O000000o(r3, r0, r1);	 Catch:{ Throwable -> 0x00c0 }
            return;
        L_0x006f:
            r3 = r3.getData();	 Catch:{ Throwable -> 0x0086 }
            r0 = "optBundle";
            r1 = com.loc.O0OOOOO.this;	 Catch:{ Throwable -> 0x0086 }
            r1 = r1.O000000o;	 Catch:{ Throwable -> 0x0086 }
            r1 = com.loc.O0o0000.O000000o(r1);	 Catch:{ Throwable -> 0x0086 }
            r3.putBundle(r0, r1);	 Catch:{ Throwable -> 0x0086 }
            r0 = com.loc.O0OOOOO.this;	 Catch:{ Throwable -> 0x0086 }
            r0.O000000o(10, r3);	 Catch:{ Throwable -> 0x0086 }
            return;
        L_0x0086:
            r3 = move-exception;
            r0 = "AmapLocationManager$ActionHandler";
            r1 = "handleMessage RESULT_GPS_LOCATIONCHANGE";
            com.loc.O0o0000.O000000o(r3, r0, r1);	 Catch:{ Throwable -> 0x00c0 }
        L_0x008e:
            return;
        L_0x008f:
            r0 = com.loc.O0OOOOO.this;	 Catch:{ Throwable -> 0x0095 }
            com.loc.O0OOOOO.O000000o(r0, r3);	 Catch:{ Throwable -> 0x0095 }
            return;
        L_0x0095:
            r3 = move-exception;
            r0 = "AmapLocationManager$ActionHandler";
            r1 = "handleMessage RESULT_GPS_LOCATIONSUCCESS";
            com.loc.O0o0000.O000000o(r3, r0, r1);	 Catch:{ Throwable -> 0x00c0 }
            return;
        L_0x009e:
            r3 = r3.getData();	 Catch:{ Throwable -> 0x00a8 }
            r0 = com.loc.O0OOOOO.this;	 Catch:{ Throwable -> 0x00a8 }
            com.loc.O0OOOOO.O000000o(r0, r3);	 Catch:{ Throwable -> 0x00a8 }
            return;
        L_0x00a8:
            r3 = move-exception;
            r0 = "AmapLocationManager$ActionHandler";
            r1 = "handleMessage RESULT_LBS_LOCATIONSUCCESS";
            com.loc.O0o0000.O000000o(r3, r0, r1);	 Catch:{ Throwable -> 0x00c0 }
            return;
        L_0x00b1:
            r3 = com.loc.O0OOOOO.this;	 Catch:{ Throwable -> 0x00b7 }
            com.loc.O0OOOOO.O000000o(r3);	 Catch:{ Throwable -> 0x00b7 }
            return;
        L_0x00b7:
            r3 = move-exception;
            r0 = "AmapLocationManager$ActionHandler";
            r1 = "handleMessage RESULT_FASTSKY";
            com.loc.O0o0000.O000000o(r3, r0, r1);	 Catch:{ Throwable -> 0x00c0 }
            return;
        L_0x00c0:
            r3 = move-exception;
            r0 = "AmapLocationManager$MainHandler";
            r1 = "handleMessage";
            com.loc.O0o0000.O000000o(r3, r0, r1);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.loc.O0OOOOO$O00000o0.handleMessage(android.os.Message):void");
        }
    }

    static {
        C.i(21);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x007d A:{Catch:{ Throwable -> 0x0083 }} */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x006f A:{Catch:{ Throwable -> 0x0083 }} */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00de  */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0069 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(13:0|(2:2|3)|4|5|(1:7)(1:9)|8|12|13|17|20|21|24|(2:26|27)(1:28)) */
    /* JADX WARNING: Missing block: B:10:0x0083, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:11:0x0084, code skipped:
            com.loc.O0o0000.O000000o(r4, "AmapLocationManager", "init 1");
     */
    public O0OOOOO(android.content.Context r4, android.content.Intent r5) {
        /*
        r3 = this;
        r3.<init>();
        r0 = new com.amap.api.location.AMapLocationClientOption;
        r0.<init>();
        r3.O000000o = r0;
        r0 = 0;
        r3.O00000o0 = r0;
        r1 = 0;
        r3.O00oOooo = r1;
        r3.O000O00o = r1;
        r2 = new java.util.ArrayList;
        r2.<init>();
        r3.O00000o = r2;
        r3.O00000oO = r1;
        r2 = 1;
        r3.O000O0OO = r2;
        r3.O00000oo = r2;
        r3.O0000OOo = r0;
        r3.O0000Oo0 = r0;
        r3.O0000Oo = r0;
        r3.O0000OoO = r1;
        r3.O000O0Oo = r2;
        r3.O0000Ooo = r0;
        r3.O0000o00 = r1;
        r2 = com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
        r3.O0000o0 = r2;
        r2 = new java.lang.Object;
        r2.<init>();
        r3.O0000o0O = r2;
        r3.O0000o0o = r0;
        r3.O0000o = r1;
        r3.O0000oO0 = r0;
        r3.O000O0o0 = r0;
        r3.O0000oO = r0;
        r2 = new com.loc.O0OOOOO$1;
        r2.<init>();
        r3.O000O0o = r2;
        r3.O0000oOO = r0;
        r3.O0000oOo = r1;
        r3.O0000oo0 = r1;
        r3.O0000oo = r0;
        r3.O0000ooO = r0;
        r3.O0000ooo = r1;
        r3.O00oOooO = r4;
        r3.O0000Oo = r5;
        r4 = com.loc.O0o0000.O00000o();
        if (r4 == 0) goto L_0x0069;
    L_0x0060:
        r4 = com.loc.O0o0000.O00000Oo();	 Catch:{ Throwable -> 0x0069 }
        r5 = r3.O00oOooO;	 Catch:{ Throwable -> 0x0069 }
        com.loc.OO0000.O000000o(r5, r4);	 Catch:{ Throwable -> 0x0069 }
    L_0x0069:
        r4 = android.os.Looper.myLooper();	 Catch:{ Throwable -> 0x0083 }
        if (r4 != 0) goto L_0x007d;
    L_0x006f:
        r4 = new com.loc.O0OOOOO$O00000o0;	 Catch:{ Throwable -> 0x0083 }
        r5 = r3.O00oOooO;	 Catch:{ Throwable -> 0x0083 }
        r5 = r5.getMainLooper();	 Catch:{ Throwable -> 0x0083 }
        r4.<init>(r5);	 Catch:{ Throwable -> 0x0083 }
    L_0x007a:
        r3.O00000Oo = r4;	 Catch:{ Throwable -> 0x0083 }
        goto L_0x008b;
    L_0x007d:
        r4 = new com.loc.O0OOOOO$O00000o0;	 Catch:{ Throwable -> 0x0083 }
        r4.<init>();	 Catch:{ Throwable -> 0x0083 }
        goto L_0x007a;
    L_0x0083:
        r4 = move-exception;
        r5 = "AmapLocationManager";
        r0 = "init 1";
        com.loc.O0o0000.O000000o(r4, r5, r0);
    L_0x008b:
        r4 = new com.loc.OO00O;	 Catch:{ Throwable -> 0x0095 }
        r5 = r3.O00oOooO;	 Catch:{ Throwable -> 0x0095 }
        r4.<init>(r5);	 Catch:{ Throwable -> 0x0095 }
        r3.O0000O0o = r4;	 Catch:{ Throwable -> 0x0095 }
        goto L_0x009d;
    L_0x0095:
        r4 = move-exception;
        r5 = "AmapLocationManager";
        r0 = "init 2";
        com.loc.O0o0000.O000000o(r4, r5, r0);	 Catch:{ Throwable -> 0x00be }
    L_0x009d:
        r4 = new com.loc.O0OOOOO$O00000Oo;	 Catch:{ Throwable -> 0x00be }
        r5 = "amapLocManagerThread";
        r4.<init>(r5, r3);	 Catch:{ Throwable -> 0x00be }
        r3.O0000Ooo = r4;	 Catch:{ Throwable -> 0x00be }
        r4 = r3.O0000Ooo;	 Catch:{ Throwable -> 0x00be }
        r5 = 5;
        r4.setPriority(r5);	 Catch:{ Throwable -> 0x00be }
        r4 = r3.O0000Ooo;	 Catch:{ Throwable -> 0x00be }
        r4.start();	 Catch:{ Throwable -> 0x00be }
        r4 = r3.O0000Ooo;	 Catch:{ Throwable -> 0x00be }
        r4 = r4.getLooper();	 Catch:{ Throwable -> 0x00be }
        r4 = r3.O000000o(r4);	 Catch:{ Throwable -> 0x00be }
        r3.O0000oo = r4;	 Catch:{ Throwable -> 0x00be }
        goto L_0x00c6;
    L_0x00be:
        r4 = move-exception;
        r5 = "AmapLocationManager";
        r0 = "init 5";
        com.loc.O0o0000.O000000o(r4, r5, r0);
    L_0x00c6:
        r4 = new com.loc.OO00O0;	 Catch:{ Throwable -> 0x00d2 }
        r5 = r3.O00oOooO;	 Catch:{ Throwable -> 0x00d2 }
        r0 = r3.O00000Oo;	 Catch:{ Throwable -> 0x00d2 }
        r4.<init>(r5, r0);	 Catch:{ Throwable -> 0x00d2 }
        r3.O00000o0 = r4;	 Catch:{ Throwable -> 0x00d2 }
        goto L_0x00da;
    L_0x00d2:
        r4 = move-exception;
        r5 = "AmapLocationManager";
        r0 = "init 3";
        com.loc.O0o0000.O000000o(r4, r5, r0);
    L_0x00da:
        r4 = r3.O0000o0o;
        if (r4 != 0) goto L_0x00e5;
    L_0x00de:
        r4 = new com.loc.ooO0Ooo;
        r4.<init>();
        r3.O0000o0o = r4;
    L_0x00e5:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0OOOOO.<init>(android.content.Context, android.content.Intent):void");
    }

    private AMapLocationServer O000000o(O0O0OOO o0o0ooo) {
        if (this.O000000o.isLocationCacheEnable()) {
            try {
                return o0o0ooo.O0000Oo();
            } catch (Throwable th) {
                O0o0000.O000000o(th, "AmapLocationManager", "doFirstCacheLoc");
            }
        }
        return null;
    }

    private O000000o O000000o(Looper looper) {
        O000000o o000000o;
        synchronized (this.O0000o0O) {
            this.O0000oo = new O000000o(looper);
            o000000o = this.O0000oo;
        }
        return o000000o;
    }

    private void O000000o(int i) {
        synchronized (this.O0000o0O) {
            if (this.O0000oo != null) {
                this.O0000oo.removeMessages(i);
            }
        }
    }

    private void O000000o(int i, Bundle bundle) {
        if (bundle == null) {
            try {
                bundle = new Bundle();
            } catch (Throwable th) {
                boolean z = (th instanceof IllegalStateException) && th.getMessage().contains("sending message to a Handler on a dead thread");
                if ((th instanceof RemoteException) || z) {
                    this.O0000OOo = null;
                    this.O00oOooo = false;
                }
                O0o0000.O000000o(th, "AmapLocationManager", "sendLocMessage");
                return;
            }
        }
        if (TextUtils.isEmpty(this.O0000oO)) {
            this.O0000oO = O0o0000.O00000Oo(this.O00oOooO);
        }
        bundle.putString("c", this.O0000oO);
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.setData(bundle);
        obtain.replyTo = this.O0000Oo0;
        if (this.O0000OOo != null) {
            this.O0000OOo.send(obtain);
        }
    }

    private void O000000o(int i, Object obj, long j) {
        synchronized (this.O0000o0O) {
            if (this.O0000oo != null) {
                Message obtain = Message.obtain();
                obtain.what = i;
                if (obj instanceof Bundle) {
                    obtain.setData((Bundle) obj);
                } else {
                    obtain.obj = obj;
                }
                this.O0000oo.sendMessageDelayed(obtain, j);
            }
        }
    }

    private void O000000o(Intent intent, boolean z) {
        if (this.O00oOooO != null) {
            if (VERSION.SDK_INT >= 26 && z) {
                try {
                    this.O00oOooO.getClass().getMethod("startForegroundService", new Class[]{Intent.class}).invoke(this.O00oOooO, new Object[]{intent});
                } catch (Throwable unused) {
                }
                this.O0000ooo = true;
            }
            this.O00oOooO.startService(intent);
            this.O0000ooo = true;
        }
    }

    private void O000000o(AMapLocation aMapLocation) {
        try {
            if (aMapLocation.getErrorCode() != 0) {
                aMapLocation.setLocationType(0);
            }
            if (aMapLocation.getErrorCode() == 0) {
                double latitude = aMapLocation.getLatitude();
                double longitude = aMapLocation.getLongitude();
                if ((latitude == 0.0d && longitude == 0.0d) || latitude < -90.0d || latitude > 90.0d || longitude < -180.0d || longitude > 180.0d) {
                    ooO0Ooo.O000000o("errorLatLng", aMapLocation.toStr());
                    aMapLocation.setLocationType(0);
                    aMapLocation.setErrorCode(8);
                    aMapLocation.setLocationDetail("LatLng is error#0802");
                }
            }
            if ("gps".equalsIgnoreCase(aMapLocation.getProvider()) || !this.O00000o0.O00000Oo()) {
                aMapLocation.setAltitude(OO000OO.O00000Oo(aMapLocation.getAltitude()));
                aMapLocation.setBearing(OO000OO.O000000o(aMapLocation.getBearing()));
                aMapLocation.setSpeed(OO000OO.O000000o(aMapLocation.getSpeed()));
                Iterator it = this.O00000o.iterator();
                while (it.hasNext()) {
                    try {
                        ((AMapLocationListener) it.next()).onLocationChanged(aMapLocation);
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }

    /* JADX WARNING: Missing block: B:49:0x0105, code skipped:
            return;
     */
    private synchronized void O000000o(com.amap.api.location.AMapLocation r4, java.lang.Throwable r5, long r6) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = com.loc.O0o0000.O00000o();	 Catch:{ Throwable -> 0x0108 }
        if (r0 == 0) goto L_0x0023;
    L_0x0007:
        if (r4 != 0) goto L_0x0023;
    L_0x0009:
        if (r5 == 0) goto L_0x0018;
    L_0x000b:
        r4 = r3.O00oOooO;	 Catch:{ Throwable -> 0x0108 }
        r6 = "loc";
        r5 = r5.getMessage();	 Catch:{ Throwable -> 0x0108 }
        com.loc.OO0000.O000000o(r4, r6, r5);	 Catch:{ Throwable -> 0x0108 }
        monitor-exit(r3);
        return;
    L_0x0018:
        r4 = r3.O00oOooO;	 Catch:{ Throwable -> 0x0108 }
        r5 = "loc";
        r6 = "amaplocation is null";
        com.loc.OO0000.O000000o(r4, r5, r6);	 Catch:{ Throwable -> 0x0108 }
        monitor-exit(r3);
        return;
    L_0x0023:
        if (r4 != 0) goto L_0x0036;
    L_0x0025:
        r4 = new com.amap.api.location.AMapLocation;	 Catch:{ Throwable -> 0x0108 }
        r5 = "";
        r4.<init>(r5);	 Catch:{ Throwable -> 0x0108 }
        r5 = 8;
        r4.setErrorCode(r5);	 Catch:{ Throwable -> 0x0108 }
        r5 = "amapLocation is null#0801";
        r4.setLocationDetail(r5);	 Catch:{ Throwable -> 0x0108 }
    L_0x0036:
        r5 = "gps";
        r0 = r4.getProvider();	 Catch:{ Throwable -> 0x0108 }
        r5 = r5.equalsIgnoreCase(r0);	 Catch:{ Throwable -> 0x0108 }
        if (r5 != 0) goto L_0x0047;
    L_0x0042:
        r5 = "lbs";
        r4.setProvider(r5);	 Catch:{ Throwable -> 0x0108 }
    L_0x0047:
        r5 = r3.O0000oOO;	 Catch:{ Throwable -> 0x0108 }
        if (r5 != 0) goto L_0x0052;
    L_0x004b:
        r5 = new com.amap.api.location.AMapLocationQualityReport;	 Catch:{ Throwable -> 0x0108 }
        r5.<init>();	 Catch:{ Throwable -> 0x0108 }
        r3.O0000oOO = r5;	 Catch:{ Throwable -> 0x0108 }
    L_0x0052:
        r5 = r3.O0000oOO;	 Catch:{ Throwable -> 0x0108 }
        r0 = r3.O000000o;	 Catch:{ Throwable -> 0x0108 }
        r0 = r0.getLocationMode();	 Catch:{ Throwable -> 0x0108 }
        r5.setLocationMode(r0);	 Catch:{ Throwable -> 0x0108 }
        r5 = r3.O00000o0;	 Catch:{ Throwable -> 0x0108 }
        if (r5 == 0) goto L_0x0077;
    L_0x0061:
        r5 = r3.O0000oOO;	 Catch:{ Throwable -> 0x0108 }
        r0 = r3.O00000o0;	 Catch:{ Throwable -> 0x0108 }
        r0 = r0.O00000oO();	 Catch:{ Throwable -> 0x0108 }
        r5.setGPSSatellites(r0);	 Catch:{ Throwable -> 0x0108 }
        r5 = r3.O0000oOO;	 Catch:{ Throwable -> 0x0108 }
        r0 = r3.O00000o0;	 Catch:{ Throwable -> 0x0108 }
        r0 = r0.O00000o();	 Catch:{ Throwable -> 0x0108 }
        r5.setGpsStatus(r0);	 Catch:{ Throwable -> 0x0108 }
    L_0x0077:
        r5 = r3.O00oOooO;	 Catch:{ Throwable -> 0x0108 }
        r5 = com.loc.OO000OO.O0000O0o(r5);	 Catch:{ Throwable -> 0x0108 }
        r0 = r3.O0000oOO;	 Catch:{ Throwable -> 0x0108 }
        r0.setWifiAble(r5);	 Catch:{ Throwable -> 0x0108 }
        r5 = r3.O0000oOO;	 Catch:{ Throwable -> 0x0108 }
        r0 = r3.O00oOooO;	 Catch:{ Throwable -> 0x0108 }
        r0 = com.loc.OO000OO.O0000OOo(r0);	 Catch:{ Throwable -> 0x0108 }
        r5.setNetworkType(r0);	 Catch:{ Throwable -> 0x0108 }
        r5 = r4.getLocationType();	 Catch:{ Throwable -> 0x0108 }
        r0 = 1;
        r1 = 0;
        if (r5 == r0) goto L_0x00a2;
    L_0x0096:
        r5 = "gps";
        r0 = r4.getProvider();	 Catch:{ Throwable -> 0x0108 }
        r5 = r5.equalsIgnoreCase(r0);	 Catch:{ Throwable -> 0x0108 }
        if (r5 == 0) goto L_0x00a3;
    L_0x00a2:
        r6 = r1;
    L_0x00a3:
        r5 = r3.O0000oOO;	 Catch:{ Throwable -> 0x0108 }
        r5.setNetUseTime(r6);	 Catch:{ Throwable -> 0x0108 }
        r5 = r3.O0000oOO;	 Catch:{ Throwable -> 0x0108 }
        r6 = O00oOoOo;	 Catch:{ Throwable -> 0x0108 }
        r5.setInstallHighDangerMockApp(r6);	 Catch:{ Throwable -> 0x0108 }
        r5 = r3.O0000oOO;	 Catch:{ Throwable -> 0x0108 }
        r4.setLocationQualityReport(r5);	 Catch:{ Throwable -> 0x0108 }
        r5 = r3.O000O00o;	 Catch:{ Throwable -> 0x00e0 }
        if (r5 == 0) goto L_0x00e8;
    L_0x00b8:
        r5 = r3.O0000ooO;	 Catch:{ Throwable -> 0x00e0 }
        r6 = new android.os.Bundle;	 Catch:{ Throwable -> 0x00e0 }
        r6.<init>();	 Catch:{ Throwable -> 0x00e0 }
        r7 = "loc";
        r6.putParcelable(r7, r4);	 Catch:{ Throwable -> 0x00e0 }
        r7 = "lastLocNb";
        r6.putString(r7, r5);	 Catch:{ Throwable -> 0x00e0 }
        r5 = 1014; // 0x3f6 float:1.421E-42 double:5.01E-321;
        r3.O000000o(r5, r6, r1);	 Catch:{ Throwable -> 0x00e0 }
        r5 = r3.O00oOooO;	 Catch:{ Throwable -> 0x00e0 }
        com.loc.ooO0Ooo.O000000o(r5, r4);	 Catch:{ Throwable -> 0x00e0 }
        r5 = r3.O00oOooO;	 Catch:{ Throwable -> 0x00e0 }
        com.loc.ooO0Ooo.O00000Oo(r5, r4);	 Catch:{ Throwable -> 0x00e0 }
        r4 = r4.clone();	 Catch:{ Throwable -> 0x00e0 }
        r3.O000000o(r4);	 Catch:{ Throwable -> 0x00e0 }
        goto L_0x00e8;
    L_0x00e0:
        r4 = move-exception;
        r5 = "AmapLocationManager";
        r6 = "handlerLocation part2";
        com.loc.O0o0000.O000000o(r4, r5, r6);	 Catch:{ Throwable -> 0x0108 }
    L_0x00e8:
        r4 = r3.O0000o00;	 Catch:{ Throwable -> 0x0108 }
        if (r4 == 0) goto L_0x00f4;
    L_0x00ec:
        r4 = com.loc.O0o0000.O00000o();	 Catch:{ Throwable -> 0x0108 }
        if (r4 != 0) goto L_0x00f4;
    L_0x00f2:
        monitor-exit(r3);
        return;
    L_0x00f4:
        r4 = r3.O00oOooO;	 Catch:{ Throwable -> 0x0108 }
        com.loc.OO0000.O00000Oo(r4);	 Catch:{ Throwable -> 0x0108 }
        r4 = r3.O000000o;	 Catch:{ Throwable -> 0x0108 }
        r4 = r4.isOnceLocation();	 Catch:{ Throwable -> 0x0108 }
        if (r4 == 0) goto L_0x0104;
    L_0x0101:
        r3.O00000oO();	 Catch:{ Throwable -> 0x0108 }
    L_0x0104:
        monitor-exit(r3);
        return;
    L_0x0106:
        r4 = move-exception;
        goto L_0x0112;
    L_0x0108:
        r4 = move-exception;
        r5 = "AmapLocationManager";
        r6 = "handlerLocation part3";
        com.loc.O0o0000.O000000o(r4, r5, r6);	 Catch:{ all -> 0x0106 }
        monitor-exit(r3);
        return;
    L_0x0112:
        monitor-exit(r3);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0OOOOO.O000000o(com.amap.api.location.AMapLocation, java.lang.Throwable, long):void");
    }

    private static void O000000o(O0O0OOO o0o0ooo, AMapLocationServer aMapLocationServer) {
        if (aMapLocationServer != null) {
            try {
                if (aMapLocationServer.getErrorCode() == 0) {
                    o0o0ooo.O000000o(aMapLocationServer);
                }
            } catch (Throwable th) {
                O0o0000.O000000o(th, "AmapLocationManager", "apsLocation:doFirstAddCache");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0093 A:{Catch:{ Throwable -> 0x00ba, Throwable -> 0x0115 }} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00c9 A:{Catch:{ Throwable -> 0x00eb }} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0093 A:{Catch:{ Throwable -> 0x00ba, Throwable -> 0x0115 }} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00c9 A:{Catch:{ Throwable -> 0x00eb }} */
    /* JADX WARNING: Missing block: B:72:0x010f, code skipped:
            if (r14 == null) goto L_0x0126;
     */
    /* JADX WARNING: Missing block: B:74:?, code skipped:
            r14.O00000oo();
     */
    /* JADX WARNING: Missing block: B:75:0x0114, code skipped:
            return r2;
     */
    /* JADX WARNING: Missing block: B:82:0x0123, code skipped:
            if (r14 != null) goto L_0x0111;
     */
    /* JADX WARNING: Missing block: B:83:0x0126, code skipped:
            return r2;
     */
    private com.autonavi.aps.amapapi.model.AMapLocationServer O00000Oo(com.loc.O0O0OOO r14) {
        /*
        r13 = this;
        r0 = 0;
        r1 = new com.loc.Oo0OOo;	 Catch:{ Throwable -> 0x0119 }
        r1.<init>();	 Catch:{ Throwable -> 0x0119 }
        r2 = 0;
        r3 = com.loc.OO000OO.O00000o0();	 Catch:{ Throwable -> 0x0119 }
        r1.O000000o(r3);	 Catch:{ Throwable -> 0x0119 }
        r3 = com.amap.api.location.AMapLocationClientOption.getAPIKEY();	 Catch:{ Throwable -> 0x001e }
        r4 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Throwable -> 0x001e }
        if (r4 != 0) goto L_0x0026;
    L_0x0018:
        r4 = r13.O00oOooO;	 Catch:{ Throwable -> 0x001e }
        com.loc.OO0O00o.O000000o(r4, r3);	 Catch:{ Throwable -> 0x001e }
        goto L_0x0026;
    L_0x001e:
        r3 = move-exception;
        r4 = "AmapLocationManager";
        r5 = "apsLocation setAuthKey";
        com.loc.O0o0000.O000000o(r3, r4, r5);	 Catch:{ Throwable -> 0x0119 }
    L_0x0026:
        r3 = com.amap.api.location.UmidtokenInfo.getUmidtoken();	 Catch:{ Throwable -> 0x0034 }
        r4 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Throwable -> 0x0034 }
        if (r4 != 0) goto L_0x003c;
    L_0x0030:
        com.loc.OO0O0o0.O000000o(r3);	 Catch:{ Throwable -> 0x0034 }
        goto L_0x003c;
    L_0x0034:
        r3 = move-exception;
        r4 = "AmapLocationManager";
        r5 = "apsLocation setUmidToken";
        com.loc.O0o0000.O000000o(r3, r4, r5);	 Catch:{ Throwable -> 0x0119 }
    L_0x003c:
        r3 = r13.O00oOooO;	 Catch:{ Throwable -> 0x004c }
        r14.O000000o(r3);	 Catch:{ Throwable -> 0x004c }
        r3 = r13.O000000o;	 Catch:{ Throwable -> 0x004c }
        r14.O000000o(r3);	 Catch:{ Throwable -> 0x004c }
        r3 = r13.O00oOooO;	 Catch:{ Throwable -> 0x004c }
        r14.O0000Oo0();	 Catch:{ Throwable -> 0x004c }
        goto L_0x0054;
    L_0x004c:
        r3 = move-exception;
        r4 = "AmapLocationManager";
        r5 = "initApsBase";
        com.loc.O0o0000.O000000o(r3, r4, r5);	 Catch:{ Throwable -> 0x0119 }
    L_0x0054:
        r3 = 0;
        r5 = com.loc.OoO0o.O000O0OO();	 Catch:{ Throwable -> 0x0119 }
        r6 = r13.O000000o(r14);	 Catch:{ Throwable -> 0x0119 }
        r7 = 1;
        if (r6 != 0) goto L_0x0084;
    L_0x0061:
        r2 = r5 ^ 1;
        r2 = r14.O000000o(r2);	 Catch:{ Throwable -> 0x0078 }
        if (r2 == 0) goto L_0x0071;
    L_0x0069:
        r8 = r2.k();	 Catch:{ Throwable -> 0x006f }
        r3 = r8;
        goto L_0x0071;
    L_0x006f:
        r6 = move-exception;
        goto L_0x007c;
    L_0x0071:
        if (r5 != 0) goto L_0x0076;
    L_0x0073:
        O000000o(r14, r2);	 Catch:{ Throwable -> 0x006f }
    L_0x0076:
        r6 = r7;
        goto L_0x0087;
    L_0x0078:
        r2 = move-exception;
        r12 = r6;
        r6 = r2;
        r2 = r12;
    L_0x007c:
        r8 = "AmapLocationManager";
        r9 = "apsLocation:doFirstNetLocate";
        com.loc.O0o0000.O000000o(r6, r8, r9);	 Catch:{ Throwable -> 0x0115 }
        goto L_0x0076;
    L_0x0084:
        r12 = r6;
        r6 = r2;
        r2 = r12;
    L_0x0087:
        r8 = com.loc.OO000OO.O00000o0();	 Catch:{ Throwable -> 0x0115 }
        r1.O00000Oo(r8);	 Catch:{ Throwable -> 0x0115 }
        r1.O000000o(r2);	 Catch:{ Throwable -> 0x0115 }
        if (r2 == 0) goto L_0x009f;
    L_0x0093:
        r0 = r2.l();	 Catch:{ Throwable -> 0x0115 }
        r8 = r2.clone();	 Catch:{ Throwable -> 0x0115 }
        r12 = r8;
        r8 = r0;
        r0 = r12;
        goto L_0x00a0;
    L_0x009f:
        r8 = r0;
    L_0x00a0:
        r9 = r13.O000000o;	 Catch:{ Throwable -> 0x00ba }
        r9 = r9.isLocationCacheEnable();	 Catch:{ Throwable -> 0x00ba }
        if (r9 == 0) goto L_0x00c2;
    L_0x00a8:
        r9 = r13.O0000O0o;	 Catch:{ Throwable -> 0x00ba }
        if (r9 == 0) goto L_0x00c2;
    L_0x00ac:
        r9 = r13.O0000O0o;	 Catch:{ Throwable -> 0x00ba }
        r10 = r13.O000000o;	 Catch:{ Throwable -> 0x00ba }
        r10 = r10.getLastLocationLifeCycle();	 Catch:{ Throwable -> 0x00ba }
        r8 = r9.O000000o(r0, r8, r10);	 Catch:{ Throwable -> 0x00ba }
        r0 = r8;
        goto L_0x00c2;
    L_0x00ba:
        r8 = move-exception;
        r9 = "AmapLocationManager";
        r10 = "fixLastLocation";
        com.loc.O0o0000.O000000o(r8, r9, r10);	 Catch:{ Throwable -> 0x0115 }
    L_0x00c2:
        r8 = new android.os.Bundle;	 Catch:{ Throwable -> 0x00eb }
        r8.<init>();	 Catch:{ Throwable -> 0x00eb }
        if (r0 == 0) goto L_0x00dc;
    L_0x00c9:
        r9 = "loc";
        r8.putParcelable(r9, r0);	 Catch:{ Throwable -> 0x00eb }
        r0 = "nb";
        r9 = r2.l();	 Catch:{ Throwable -> 0x00eb }
        r8.putString(r0, r9);	 Catch:{ Throwable -> 0x00eb }
        r0 = "netUseTime";
        r8.putLong(r0, r3);	 Catch:{ Throwable -> 0x00eb }
    L_0x00dc:
        r0 = android.os.Message.obtain();	 Catch:{ Throwable -> 0x00eb }
        r0.setData(r8);	 Catch:{ Throwable -> 0x00eb }
        r0.what = r7;	 Catch:{ Throwable -> 0x00eb }
        r3 = r13.O00000Oo;	 Catch:{ Throwable -> 0x00eb }
        r3.sendMessage(r0);	 Catch:{ Throwable -> 0x00eb }
        goto L_0x00f3;
    L_0x00eb:
        r0 = move-exception;
        r3 = "AmapLocationManager";
        r4 = "apsLocation:callback";
        com.loc.O0o0000.O000000o(r0, r3, r4);	 Catch:{ Throwable -> 0x0115 }
    L_0x00f3:
        r0 = r13.O00oOooO;	 Catch:{ Throwable -> 0x0115 }
        com.loc.ooO0Ooo.O000000o(r0, r1);	 Catch:{ Throwable -> 0x0115 }
        if (r6 == 0) goto L_0x010f;
    L_0x00fa:
        if (r5 == 0) goto L_0x010f;
    L_0x00fc:
        r14.O00000o0();	 Catch:{ Throwable -> 0x0107 }
        r0 = r14.O000000o(r7);	 Catch:{ Throwable -> 0x0107 }
        O000000o(r14, r0);	 Catch:{ Throwable -> 0x0107 }
        goto L_0x010f;
    L_0x0107:
        r0 = move-exception;
        r1 = "AmapLocationManager";
        r3 = "apsLocation:doFirstNetLocate 2";
        com.loc.O0o0000.O000000o(r0, r1, r3);	 Catch:{ Throwable -> 0x0115 }
    L_0x010f:
        if (r14 == 0) goto L_0x0126;
    L_0x0111:
        r14.O00000oo();	 Catch:{ Throwable -> 0x0126 }
        return r2;
    L_0x0115:
        r0 = move-exception;
        goto L_0x011c;
    L_0x0117:
        r0 = move-exception;
        goto L_0x0127;
    L_0x0119:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
    L_0x011c:
        r1 = "AmapLocationManager";
        r3 = "apsLocation";
        com.loc.O0o0000.O000000o(r0, r1, r3);	 Catch:{ all -> 0x0117 }
        if (r14 == 0) goto L_0x0126;
    L_0x0125:
        goto L_0x0111;
    L_0x0126:
        return r2;
    L_0x0127:
        if (r14 == 0) goto L_0x012c;
    L_0x0129:
        r14.O00000oo();	 Catch:{ Throwable -> 0x012c }
    L_0x012c:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0OOOOO.O00000Oo(com.loc.O0O0OOO):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    private boolean O00000Oo() {
        boolean z = false;
        int i = 0;
        do {
            try {
                if (this.O0000OOo != null) {
                    break;
                }
                Thread.sleep(100);
                i++;
            } catch (Throwable th) {
                O0o0000.O000000o(th, "AmapLocationManager", "checkAPSManager");
            }
        } while (i < 50);
        if (this.O0000OOo == null) {
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            AMapLocation aMapLocation = new AMapLocation("");
            aMapLocation.setErrorCode(10);
            aMapLocation.setLocationDetail(!OO000OO.O0000OoO(this.O00oOooO.getApplicationContext()) ? "请检查配置文件是否配置服务，并且manifest中service标签是否配置在application标签内#1003" : "启动ApsServcie失败#1001");
            bundle.putParcelable("loc", aMapLocation);
            obtain.setData(bundle);
            obtain.what = 1;
            this.O00000Oo.sendMessage(obtain);
        } else {
            z = true;
        }
        if (z) {
            return z;
        }
        ooO0Ooo.O000000o(null, !OO000OO.O0000OoO(this.O00oOooO.getApplicationContext()) ? 2103 : 2101);
        return z;
    }

    /* JADX WARNING: Missing block: B:29:0x005e, code skipped:
            return;
     */
    private synchronized void O00000o() {
        /*
        r6 = this;
        monitor-enter(r6);
        r0 = r6.O000000o;	 Catch:{ all -> 0x005f }
        if (r0 != 0) goto L_0x000c;
    L_0x0005:
        r0 = new com.amap.api.location.AMapLocationClientOption;	 Catch:{ all -> 0x005f }
        r0.<init>();	 Catch:{ all -> 0x005f }
        r6.O000000o = r0;	 Catch:{ all -> 0x005f }
    L_0x000c:
        r0 = r6.O000O00o;	 Catch:{ all -> 0x005f }
        if (r0 == 0) goto L_0x0012;
    L_0x0010:
        monitor-exit(r6);
        return;
    L_0x0012:
        r0 = 1;
        r6.O000O00o = r0;	 Catch:{ all -> 0x005f }
        r0 = com.loc.O0OOOOO.AnonymousClass4.O000000o;	 Catch:{ all -> 0x005f }
        r1 = r6.O000000o;	 Catch:{ all -> 0x005f }
        r1 = r1.getLocationMode();	 Catch:{ all -> 0x005f }
        r1 = r1.ordinal();	 Catch:{ all -> 0x005f }
        r0 = r0[r1];	 Catch:{ all -> 0x005f }
        r1 = 1015; // 0x3f7 float:1.422E-42 double:5.015E-321;
        r2 = 1016; // 0x3f8 float:1.424E-42 double:5.02E-321;
        r3 = 0;
        r4 = 0;
        switch(r0) {
            case 1: goto L_0x0053;
            case 2: goto L_0x004b;
            case 3: goto L_0x002e;
            default: goto L_0x002d;
        };	 Catch:{ all -> 0x005f }
    L_0x002d:
        goto L_0x005d;
    L_0x002e:
        r6.O000000o(r1, r3, r4);	 Catch:{ all -> 0x005f }
        r0 = r6.O000000o;	 Catch:{ all -> 0x005f }
        r0 = r0.isGpsFirst();	 Catch:{ all -> 0x005f }
        if (r0 == 0) goto L_0x0047;
    L_0x0039:
        r0 = r6.O000000o;	 Catch:{ all -> 0x005f }
        r0 = r0.isOnceLocation();	 Catch:{ all -> 0x005f }
        if (r0 == 0) goto L_0x0047;
    L_0x0041:
        r0 = r6.O000000o;	 Catch:{ all -> 0x005f }
        r4 = r0.getGpsFirstTimeout();	 Catch:{ all -> 0x005f }
    L_0x0047:
        r6.O000000o(r2, r3, r4);	 Catch:{ all -> 0x005f }
        goto L_0x005d;
    L_0x004b:
        r6.O000000o(r2);	 Catch:{ all -> 0x005f }
        r6.O000000o(r1, r3, r4);	 Catch:{ all -> 0x005f }
        monitor-exit(r6);
        return;
    L_0x0053:
        r0 = 1017; // 0x3f9 float:1.425E-42 double:5.025E-321;
        r6.O000000o(r0, r3, r4);	 Catch:{ all -> 0x005f }
        r6.O000000o(r2, r3, r4);	 Catch:{ all -> 0x005f }
        monitor-exit(r6);
        return;
    L_0x005d:
        monitor-exit(r6);
        return;
    L_0x005f:
        r0 = move-exception;
        monitor-exit(r6);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0OOOOO.O00000o():void");
    }

    static /* synthetic */ void O00000o(O0OOOOO o0ooooo, Message message) {
        if (message != null) {
            try {
                Bundle data = message.getData();
                if (data != null) {
                    boolean z = data.getBoolean("j", true);
                    Intent O0000OOo = o0ooooo.O0000OOo();
                    O0000OOo.putExtra("j", z);
                    O0000OOo.putExtra("g", 2);
                    o0ooooo.O000000o(O0000OOo, false);
                }
            } catch (Throwable th) {
                O0o0000.O000000o(th, "AmapLocationManager", "doDisableBackgroundLocation");
            }
        }
    }

    private void O00000o0() {
        Intent intent;
        try {
            intent = new Intent();
            intent.setComponent(new ComponentName("com.autonavi.minimap", OoO0o.O0000OoO()));
            intent.setFlags(AMapEngineUtils.MAX_P20_WIDTH);
            intent.setData(Uri.parse(OoO0o.O0000Oo0()));
            this.O00oOooO.startActivity(intent);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AmapLocationManager", "callAMap part2");
        }
    }

    static /* synthetic */ void O00000o0(O0OOOOO o0ooooo, Message message) {
        if (message != null) {
            try {
                Bundle data = message.getData();
                if (data != null) {
                    int i = data.getInt("i", 0);
                    Notification notification = (Notification) data.getParcelable("h");
                    Intent O0000OOo = o0ooooo.O0000OOo();
                    O0000OOo.putExtra("i", i);
                    O0000OOo.putExtra("h", notification);
                    O0000OOo.putExtra("g", 1);
                    o0ooooo.O000000o(O0000OOo, true);
                }
            } catch (Throwable th) {
                O0o0000.O000000o(th, "AmapLocationManager", "doEnableBackgroundLocation");
            }
        }
    }

    private void O00000oO() {
        try {
            O000000o(1025);
            if (this.O00000o0 != null) {
                this.O00000o0.O000000o();
            }
            O000000o((int) PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW);
            this.O000O00o = false;
            this.O0000OoO = 0;
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AmapLocationManager", "stopLocation");
        }
    }

    private void O00000oo() {
        if (this.O000000o.getLocationMode() != AMapLocationMode.Device_Sensors) {
            long j = 1000;
            if (this.O000000o.getInterval() >= 1000) {
                j = this.O000000o.getInterval();
            }
            O000000o((int) PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null, j);
        }
    }

    static /* synthetic */ void O00000oo(O0OOOOO o0ooooo) {
        try {
            if (o0ooooo.O000O0OO) {
                o0ooooo.O000O0OO = false;
                AMapLocationServer O00000Oo = o0ooooo.O00000Oo(new O0O0OOO());
                if (o0ooooo.O00000Oo()) {
                    Bundle bundle = new Bundle();
                    String str = "0";
                    if (O00000Oo != null && (O00000Oo.getLocationType() == 2 || O00000Oo.getLocationType() == 4)) {
                        str = "1";
                    }
                    bundle.putBundle("optBundle", O0o0000.O000000o(o0ooooo.O000000o));
                    bundle.putString("isCacheLoc", str);
                    o0ooooo.O000000o(0, bundle);
                }
            } else {
                if (!(!o0ooooo.O0000o || o0ooooo.isStarted() || o0ooooo.O0000oo0)) {
                    o0ooooo.O0000oo0 = true;
                    o0ooooo.O0000O0o();
                }
                if (o0ooooo.O00000Oo()) {
                    o0ooooo.O0000oo0 = false;
                    Bundle bundle2 = new Bundle();
                    bundle2.putBundle("optBundle", O0o0000.O000000o(o0ooooo.O000000o));
                    bundle2.putString("d", UmidtokenInfo.getUmidtoken());
                    if (!o0ooooo.O00000o0.O00000Oo()) {
                        o0ooooo.O000000o(1, bundle2);
                    }
                }
            }
        } catch (Throwable th) {
            try {
                O0o0000.O000000o(th, "AmapLocationManager", "doLBSLocation");
                try {
                    if (!o0ooooo.O000000o.isOnceLocation()) {
                        o0ooooo.O00000oo();
                    }
                } catch (Throwable unused) {
                }
                return;
            } catch (Throwable unused2) {
            }
        }
        try {
            if (!o0ooooo.O000000o.isOnceLocation()) {
                o0ooooo.O00000oo();
            }
        } catch (Throwable unused3) {
        }
    }

    private void O0000O0o() {
        try {
            if (this.O0000Oo0 == null) {
                this.O0000Oo0 = new Messenger(this.O00000Oo);
            }
            this.O00oOooO.bindService(O0000OOo(), this.O000O0o, 1);
        } catch (Throwable unused) {
        }
    }

    private Intent O0000OOo() {
        String apikey;
        if (this.O0000Oo == null) {
            this.O0000Oo = new Intent(this.O00oOooO, APSService.class);
        }
        String str = "";
        try {
            apikey = !TextUtils.isEmpty(AMapLocationClientOption.getAPIKEY()) ? AMapLocationClientOption.getAPIKEY() : OO00o00.O00000oo(this.O00oOooO);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AmapLocationManager", "startServiceImpl p2");
            apikey = str;
        }
        this.O0000Oo.putExtra("a", apikey);
        this.O0000Oo.putExtra("b", OO00o00.O00000o0(this.O00oOooO));
        this.O0000Oo.putExtra("d", UmidtokenInfo.getUmidtoken());
        this.O0000Oo.putExtra("f", AMapLocationClientOption.isDownloadCoordinateConvertLibrary());
        return this.O0000Oo;
    }

    static /* synthetic */ void O0000OOo(O0OOOOO o0ooooo) {
        o0ooooo.O00000o0.O00000Oo(o0ooooo.O000000o);
        if (o0ooooo.O000O00o && !o0ooooo.O000000o.getLocationMode().equals(o0ooooo.O0000o0)) {
            o0ooooo.O00000oO();
            o0ooooo.O00000o();
        }
        o0ooooo.O0000o0 = o0ooooo.O000000o.getLocationMode();
        if (o0ooooo.O0000o0o != null) {
            ooO0Ooo ooo0ooo;
            Context context;
            int i;
            if (o0ooooo.O000000o.isOnceLocation()) {
                ooo0ooo = o0ooooo.O0000o0o;
                context = o0ooooo.O00oOooO;
                i = 0;
            } else {
                ooo0ooo = o0ooooo.O0000o0o;
                context = o0ooooo.O00oOooO;
                i = 1;
            }
            ooo0ooo.O000000o(context, i);
            o0ooooo.O0000o0o.O000000o(o0ooooo.O00oOooO, o0ooooo.O000000o);
        }
    }

    static /* synthetic */ void O0000Oo(O0OOOOO o0ooooo) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBundle("optBundle", O0o0000.O000000o(o0ooooo.O000000o));
            o0ooooo.O000000o(3, bundle);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AmapLocationManager", "stopAssistantLocationImpl");
        }
    }

    static /* synthetic */ void O0000Oo0(O0OOOOO o0ooooo) {
        try {
            if (o0ooooo.O0000OOo != null) {
                o0ooooo.O0000OoO = 0;
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", O0o0000.O000000o(o0ooooo.O000000o));
                o0ooooo.O000000o(2, bundle);
                return;
            }
            o0ooooo.O0000OoO++;
            if (o0ooooo.O0000OoO < 10) {
                o0ooooo.O000000o(1008, null, 50);
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AmapLocationManager", "startAssistantLocationImpl");
        }
    }

    /* Access modifiers changed, original: final */
    public final void O000000o() {
        O000000o(12, null);
        this.O000O0OO = true;
        this.O00000oo = true;
        this.O00oOooo = false;
        this.O0000o = false;
        O00000oO();
        if (this.O0000o0o != null) {
            this.O0000o0o.O00000Oo(this.O00oOooO);
        }
        ooO0Ooo.O000000o(this.O00oOooO);
        if (this.O0000oO0 != null) {
            this.O0000oO0.O00000Oo().sendEmptyMessage(11);
        } else if (this.O000O0o != null) {
            this.O00oOooO.unbindService(this.O000O0o);
        }
        try {
            if (this.O0000ooo) {
                this.O00oOooO.stopService(O0000OOo());
            }
        } catch (Throwable unused) {
        }
        this.O0000ooo = false;
        if (this.O00000o != null) {
            this.O00000o.clear();
            this.O00000o = null;
        }
        this.O000O0o = null;
        synchronized (this.O0000o0O) {
            if (this.O0000oo != null) {
                this.O0000oo.removeCallbacksAndMessages(null);
            }
            this.O0000oo = null;
        }
        if (this.O0000Ooo != null) {
            if (VERSION.SDK_INT >= 18) {
                try {
                    O0o.O000000o(this.O0000Ooo, HandlerThread.class, "quitSafely", new Object[0]);
                } catch (Throwable unused2) {
                }
            }
            this.O0000Ooo.quit();
        }
        this.O0000Ooo = null;
        if (this.O00000Oo != null) {
            this.O00000Oo.removeCallbacksAndMessages(null);
        }
        if (this.O0000O0o != null) {
            this.O0000O0o.O00000o0();
            this.O0000O0o = null;
        }
    }

    public void disableBackgroundLocation(boolean z) {
        try {
            Object bundle = new Bundle();
            bundle.putBoolean("j", z);
            O000000o(1024, bundle, 0);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AmapLocationManager", "disableBackgroundLocation");
        }
    }

    public void enableBackgroundLocation(int i, Notification notification) {
        if (i != 0 && notification != null) {
            try {
                Object bundle = new Bundle();
                bundle.putInt("i", i);
                bundle.putParcelable("h", notification);
                O000000o(1023, bundle, 0);
            } catch (Throwable th) {
                O0o0000.O000000o(th, "AmapLocationManager", "disableBackgroundLocation");
            }
        }
    }

    public AMapLocation getLastKnownLocation() {
        Throwable th;
        AMapLocation aMapLocation = null;
        try {
            if (this.O0000O0o != null) {
                AMapLocation O00000Oo = this.O0000O0o.O00000Oo();
                if (O00000Oo != null) {
                    try {
                        O00000Oo.setTrustedLevel(3);
                    } catch (Throwable th2) {
                        AMapLocation aMapLocation2 = O00000Oo;
                        th = th2;
                        aMapLocation = aMapLocation2;
                    }
                }
                return O00000Oo;
            }
        } catch (Throwable th3) {
            th = th3;
            O0o0000.O000000o(th, "AmapLocationManager", "getLastKnownLocation");
            return aMapLocation;
        }
        return aMapLocation;
    }

    public native boolean isStarted();

    public void onDestroy() {
        try {
            if (this.O000O0o0 != null) {
                this.O000O0o0.O00000Oo();
                this.O000O0o0 = null;
            }
            O000000o(1011, null, 0);
            this.O0000o00 = true;
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AmapLocationManager", "onDestroy");
        }
    }

    public void setLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            O000000o(1002, (Object) aMapLocationListener, 0);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AmapLocationManager", "setLocationListener");
        }
    }

    public void setLocationOption(AMapLocationClientOption aMapLocationClientOption) {
        try {
            O000000o((int) PointerIconCompat.TYPE_ZOOM_IN, aMapLocationClientOption.clone(), 0);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AmapLocationManager", "setLocationOption");
        }
    }

    public void startAssistantLocation() {
        try {
            O000000o(1008, null, 0);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AmapLocationManager", "startAssistantLocation");
        }
    }

    public native void startAssistantLocation(WebView webView);

    public void startLocation() {
        try {
            O000000o(1003, null, 0);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AmapLocationManager", "startLocation");
        }
    }

    public void stopAssistantLocation() {
        try {
            if (this.O000O0o0 != null) {
                this.O000O0o0.O00000Oo();
                this.O000O0o0 = null;
            }
            O000000o(1009, null, 0);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AmapLocationManager", "stopAssistantLocation");
        }
    }

    public void stopLocation() {
        try {
            O000000o(1004, null, 0);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AmapLocationManager", "stopLocation");
        }
    }

    public void unRegisterLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            O000000o(1005, (Object) aMapLocationListener, 0);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AmapLocationManager", "unRegisterLocationListener");
        }
    }
}
