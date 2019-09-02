package com.loc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/* compiled from: ApsManager */
public final class OO000o {
    static boolean O0000O0o;
    String O000000o = null;
    O00000Oo O00000Oo = null;
    O000000o O00000o = null;
    AMapLocation O00000o0 = null;
    Context O00000oO = null;
    O0O0OOO O00000oo = null;
    HashMap<Messenger, Long> O0000OOo = new HashMap();
    long O0000Oo = 0;
    ooO0Ooo O0000Oo0 = null;
    long O0000OoO = 0;
    String O0000Ooo = null;
    Socket O0000o = null;
    AMapLocationClientOption O0000o0 = new AMapLocationClientOption();
    AMapLocationClientOption O0000o00 = null;
    ServerSocket O0000o0O = null;
    boolean O0000o0o = false;
    O00000o0 O0000oO = null;
    boolean O0000oO0 = false;
    private boolean O0000oOO = false;
    private boolean O0000oOo = false;
    private long O0000oo = 0;
    private long O0000oo0 = 0;
    private AMapLocationServer O0000ooO = null;
    private long O0000ooo = 0;
    private boolean O000O00o = true;
    private String O000O0OO = "";
    private final int O000O0Oo = 5000;
    private String O00oOoOo = "jsonp1";
    private int O00oOooO = 0;
    private OO00O O00oOooo = null;

    /* compiled from: ApsManager */
    public class O000000o extends Handler {
        public O000000o(Looper looper) {
            super(looper);
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x004d A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00ca A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00bf A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00aa A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0095 A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x008a A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x007f A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0074 A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0069 A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x005d A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0056 A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x004f A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x004d A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00ca A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00bf A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00aa A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0095 A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x008a A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x007f A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0074 A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0069 A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x005d A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0056 A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x004f A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x004d A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00ca A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00bf A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00aa A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0095 A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x008a A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x007f A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0074 A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0069 A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x005d A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0056 A:{Catch:{ Throwable -> 0x00d8 }} */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x004f A:{Catch:{ Throwable -> 0x00d8 }} */
        public final void handleMessage(android.os.Message r7) {
            /*
            r6 = this;
            r0 = 0;
            r1 = r7.getData();	 Catch:{ Throwable -> 0x003e }
            r2 = r7.replyTo;	 Catch:{ Throwable -> 0x003b }
            if (r1 == 0) goto L_0x0048;
        L_0x0009:
            r3 = r1.isEmpty();	 Catch:{ Throwable -> 0x0039 }
            if (r3 != 0) goto L_0x0048;
        L_0x000f:
            r3 = "c";
            r3 = r1.getString(r3);	 Catch:{ Throwable -> 0x0039 }
            r4 = com.loc.OO000o.this;	 Catch:{ Throwable -> 0x0039 }
            r3 = r4.O000000o(r3);	 Catch:{ Throwable -> 0x0039 }
            if (r3 != 0) goto L_0x0048;
        L_0x001d:
            r3 = r7.what;	 Catch:{ Throwable -> 0x0039 }
            r4 = 1;
            if (r3 != r4) goto L_0x0038;
        L_0x0022:
            r3 = 2102; // 0x836 float:2.946E-42 double:1.0385E-320;
            com.loc.ooO0Ooo.O000000o(r0, r3);	 Catch:{ Throwable -> 0x0039 }
            r3 = com.loc.OO000o.this;	 Catch:{ Throwable -> 0x0039 }
            r3 = "invalid handlder scode!!!#1002";
            r3 = com.loc.OO000o.O000000o(10, r3);	 Catch:{ Throwable -> 0x0039 }
            r4 = com.loc.OO000o.this;	 Catch:{ Throwable -> 0x0039 }
            r5 = r3.l();	 Catch:{ Throwable -> 0x0039 }
            r4.O000000o(r2, r3, r5, 0);	 Catch:{ Throwable -> 0x0039 }
        L_0x0038:
            return;
        L_0x0039:
            r3 = move-exception;
            goto L_0x0041;
        L_0x003b:
            r3 = move-exception;
            r2 = r0;
            goto L_0x0041;
        L_0x003e:
            r3 = move-exception;
            r1 = r0;
            r2 = r1;
        L_0x0041:
            r4 = "ApsServiceCore";
            r5 = "ActionHandler handlerMessage";
            com.loc.O0o0000.O000000o(r3, r4, r5);	 Catch:{ Throwable -> 0x00d8 }
        L_0x0048:
            r3 = r7.what;	 Catch:{ Throwable -> 0x00d8 }
            switch(r3) {
                case 0: goto L_0x00ca;
                case 1: goto L_0x00bf;
                case 2: goto L_0x00aa;
                case 3: goto L_0x0095;
                case 4: goto L_0x008a;
                case 5: goto L_0x007f;
                case 6: goto L_0x004d;
                case 7: goto L_0x0074;
                case 8: goto L_0x004d;
                case 9: goto L_0x0069;
                case 10: goto L_0x005d;
                case 11: goto L_0x0056;
                case 12: goto L_0x004f;
                default: goto L_0x004d;
            };	 Catch:{ Throwable -> 0x00d8 }
        L_0x004d:
            goto L_0x00d4;
        L_0x004f:
            r0 = com.loc.OO000o.this;	 Catch:{ Throwable -> 0x00d8 }
            r0.O0000OOo.remove(r2);	 Catch:{ Throwable -> 0x00d8 }
            goto L_0x00d4;
        L_0x0056:
            r0 = com.loc.OO000o.this;	 Catch:{ Throwable -> 0x00d8 }
            r0.O00000oO();	 Catch:{ Throwable -> 0x00d8 }
            goto L_0x00d4;
        L_0x005d:
            r0 = com.loc.OO000o.this;	 Catch:{ Throwable -> 0x00d8 }
            r0.O000000o(r1);	 Catch:{ Throwable -> 0x00d8 }
            r0 = com.loc.OO000o.this;	 Catch:{ Throwable -> 0x00d8 }
            r0.O000000o(r2, r1);	 Catch:{ Throwable -> 0x00d8 }
            goto L_0x00d4;
        L_0x0069:
            r0 = com.loc.OO000o.this;	 Catch:{ Throwable -> 0x00d8 }
            r0.O000000o(r1);	 Catch:{ Throwable -> 0x00d8 }
            r0 = com.loc.OO000o.this;	 Catch:{ Throwable -> 0x00d8 }
            com.loc.OO000o.O000000o(r0, r2);	 Catch:{ Throwable -> 0x00d8 }
            goto L_0x00d4;
        L_0x0074:
            r0 = com.loc.OO000o.this;	 Catch:{ Throwable -> 0x00d8 }
            r0.O000000o(r1);	 Catch:{ Throwable -> 0x00d8 }
            r0 = com.loc.OO000o.this;	 Catch:{ Throwable -> 0x00d8 }
            com.loc.OO000o.O00000o0(r0);	 Catch:{ Throwable -> 0x00d8 }
            goto L_0x00d4;
        L_0x007f:
            r0 = com.loc.OO000o.this;	 Catch:{ Throwable -> 0x00d8 }
            r0.O000000o(r1);	 Catch:{ Throwable -> 0x00d8 }
            r0 = com.loc.OO000o.this;	 Catch:{ Throwable -> 0x00d8 }
            com.loc.OO000o.O00000Oo(r0);	 Catch:{ Throwable -> 0x00d8 }
            goto L_0x00d4;
        L_0x008a:
            r0 = com.loc.OO000o.this;	 Catch:{ Throwable -> 0x00d8 }
            r0.O000000o(r1);	 Catch:{ Throwable -> 0x00d8 }
            r0 = com.loc.OO000o.this;	 Catch:{ Throwable -> 0x00d8 }
            com.loc.OO000o.O000000o(r0);	 Catch:{ Throwable -> 0x00d8 }
            goto L_0x00d4;
        L_0x0095:
            if (r1 == 0) goto L_0x00a9;
        L_0x0097:
            r1 = r1.isEmpty();	 Catch:{ Throwable -> 0x00d8 }
            if (r1 == 0) goto L_0x009e;
        L_0x009d:
            return;
        L_0x009e:
            r1 = com.loc.OO000o.this;	 Catch:{ Throwable -> 0x00d8 }
            r1.O000000o(r0);	 Catch:{ Throwable -> 0x00d8 }
            r0 = com.loc.OO000o.this;	 Catch:{ Throwable -> 0x00d8 }
            r0.O00000o();	 Catch:{ Throwable -> 0x00d8 }
            goto L_0x00d4;
        L_0x00a9:
            return;
        L_0x00aa:
            if (r1 == 0) goto L_0x00be;
        L_0x00ac:
            r1 = r1.isEmpty();	 Catch:{ Throwable -> 0x00d8 }
            if (r1 == 0) goto L_0x00b3;
        L_0x00b2:
            return;
        L_0x00b3:
            r1 = com.loc.OO000o.this;	 Catch:{ Throwable -> 0x00d8 }
            r1.O000000o(r0);	 Catch:{ Throwable -> 0x00d8 }
            r0 = com.loc.OO000o.this;	 Catch:{ Throwable -> 0x00d8 }
            r0.O00000o0();	 Catch:{ Throwable -> 0x00d8 }
            goto L_0x00d4;
        L_0x00be:
            return;
        L_0x00bf:
            r0 = com.loc.OO000o.this;	 Catch:{ Throwable -> 0x00d8 }
            r0.O000000o(r1);	 Catch:{ Throwable -> 0x00d8 }
            r0 = com.loc.OO000o.this;	 Catch:{ Throwable -> 0x00d8 }
            com.loc.OO000o.O00000Oo(r0, r2, r1);	 Catch:{ Throwable -> 0x00d8 }
            goto L_0x00d4;
        L_0x00ca:
            r0 = com.loc.OO000o.this;	 Catch:{ Throwable -> 0x00d8 }
            r0.O000000o(r1);	 Catch:{ Throwable -> 0x00d8 }
            r0 = com.loc.OO000o.this;	 Catch:{ Throwable -> 0x00d8 }
            com.loc.OO000o.O000000o(r0, r2, r1);	 Catch:{ Throwable -> 0x00d8 }
        L_0x00d4:
            super.handleMessage(r7);	 Catch:{ Throwable -> 0x00d8 }
            return;
        L_0x00d8:
            r7 = move-exception;
            r0 = "actionHandler";
            r1 = "handleMessage";
            com.loc.O0o0000.O000000o(r7, r0, r1);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.loc.OO000o$O000000o.handleMessage(android.os.Message):void");
        }
    }

    /* compiled from: ApsManager */
    class O00000Oo extends HandlerThread {
        public O00000Oo(String str) {
            super(str);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onLooperPrepared() {
            try {
                OO000o.this.O00oOooo = new OO00O(OO000o.this.O00000oO);
            } catch (Throwable th) {
                O0o0000.O000000o(th, "APSManager$ActionThread", "onLooperPrepared");
                return;
            }
            OO000o.this.O00000oo = new O0O0OOO();
            super.onLooperPrepared();
        }

        public final void run() {
            try {
                super.run();
            } catch (Throwable th) {
                O0o0000.O000000o(th, "APSManager$ActionThread", "run");
            }
        }
    }

    /* compiled from: ApsManager */
    class O00000o0 extends Thread {
        O00000o0() {
        }

        public final void run() {
            try {
                if (!OO000o.this.O0000o0o) {
                    OO000o.this.O0000o0o = true;
                    OO000o.this.O0000o0O = new ServerSocket(43689);
                }
                while (OO000o.this.O0000o0o && OO000o.this.O0000o0O != null) {
                    OO000o.this.O0000o = OO000o.this.O0000o0O.accept();
                    OO000o.O000000o(OO000o.this, OO000o.this.O0000o);
                }
            } catch (Throwable th) {
                O0o0000.O000000o(th, "ApsServiceCore", "run");
            }
            super.run();
        }
    }

    public OO000o(Context context) {
        this.O00000oO = context;
    }

    private static AMapLocationServer O000000o(int i, String str) {
        try {
            AMapLocationServer aMapLocationServer = new AMapLocationServer("");
            aMapLocationServer.setErrorCode(i);
            aMapLocationServer.setLocationDetail(str);
            return aMapLocationServer;
        } catch (Throwable th) {
            O0o0000.O000000o(th, "ApsServiceCore", "newInstanceAMapLoc");
            return null;
        }
    }

    private void O000000o(Bundle bundle) {
        try {
            if (!this.O0000oOO) {
                O0o0000.O000000o(this.O00000oO);
                if (bundle != null) {
                    this.O0000o0 = O0o0000.O000000o(bundle.getBundle("optBundle"));
                }
                this.O00000oo.O000000o(this.O00000oO);
                this.O00000oo.O000000o();
                O000000o(this.O0000o0);
                this.O00000oo.O00000Oo();
                this.O0000oOO = true;
                this.O000O00o = true;
                this.O000O0OO = "";
            }
        } catch (Throwable th) {
            this.O000O00o = false;
            this.O000O0OO = th.getMessage();
            O0o0000.O000000o(th, "ApsServiceCore", "init");
        }
    }

    private void O000000o(Messenger messenger) {
        try {
            if (OoO0o.O00000o(this.O00000oO)) {
                O000000o(messenger, 100, null);
            }
            this.O00000o.removeMessages(4);
            if (OoO0o.O000000o()) {
                this.O00000o.sendEmptyMessage(4);
            }
            this.O00000o.removeMessages(5);
            if (OoO0o.O00000o0() && OoO0o.O00000o() > 2) {
                this.O00000o.sendEmptyMessage(5);
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "ApsServiceCore", "checkConfig");
        }
    }

    private static void O000000o(Messenger messenger, int i, Bundle bundle) {
        if (messenger != null) {
            try {
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = i;
                messenger.send(obtain);
            } catch (Throwable th) {
                O0o0000.O000000o(th, "ApsServiceCore", "sendMessage");
            }
        }
    }

    private void O000000o(Messenger messenger, AMapLocation aMapLocation, String str, long j) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(AMapLocation.class.getClassLoader());
        bundle.putParcelable("loc", aMapLocation);
        bundle.putString("nb", str);
        bundle.putLong("netUseTime", j);
        this.O0000OOo.put(messenger, Long.valueOf(OO000OO.O00000o0()));
        O000000o(messenger, 1, bundle);
    }

    private void O000000o(AMapLocationClientOption aMapLocationClientOption) {
        try {
            if (this.O00000oo != null) {
                this.O00000oo.O000000o(aMapLocationClientOption);
            }
            if (aMapLocationClientOption != null) {
                O0000O0o = aMapLocationClientOption.isKillProcess();
                if (!(this.O0000o00 == null || (aMapLocationClientOption.isOffset() == this.O0000o00.isOffset() && aMapLocationClientOption.isNeedAddress() == this.O0000o00.isNeedAddress() && aMapLocationClientOption.isLocationCacheEnable() == this.O0000o00.isLocationCacheEnable() && this.O0000o00.getGeoLanguage() == aMapLocationClientOption.getGeoLanguage()))) {
                    this.O0000oo = 0;
                    this.O00000o0 = null;
                }
                this.O0000o00 = aMapLocationClientOption;
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "ApsServiceCore", "setExtra");
        }
    }

    private void O000000o(BufferedReader bufferedReader) throws Exception {
        String readLine = bufferedReader.readLine();
        int i = 30000;
        if (readLine != null && readLine.length() > 0) {
            String[] split = readLine.split(" ");
            if (split != null && split.length > 1) {
                split = split[1].split("\\?");
                if (split != null && split.length > 1) {
                    split = split[1].split(HttpUtils.PARAMETERS_SEPARATOR);
                    if (split != null && split.length > 0) {
                        int i2 = 30000;
                        for (String split2 : split) {
                            String[] split3 = split2.split(HttpUtils.EQUAL_SIGN);
                            if (split3 != null && split3.length > 1) {
                                if ("to".equals(split3[0])) {
                                    i2 = OO000OO.O0000OOo(split3[1]);
                                }
                                if ("callback".equals(split3[0])) {
                                    this.O00oOoOo = split3[1];
                                }
                            }
                        }
                        i = i2;
                    }
                }
            }
        }
        O0o0000.O00000oo = i;
    }

    private AMapLocationClientOption O00000Oo(Bundle bundle) {
        AMapLocationClientOption O000000o = O0o0000.O000000o(bundle.getBundle("optBundle"));
        O000000o(O000000o);
        try {
            String string = bundle.getString("d");
            if (!TextUtils.isEmpty(string)) {
                OO0O0o0.O000000o(string);
                return O000000o;
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "APSManager", "parseBundle");
        }
        return O000000o;
    }

    private void O00000Oo(Messenger messenger) {
        try {
            Bundle bundle;
            O0O0OOO o0o0ooo = this.O00000oo;
            O0O0OOO.O00000Oo(this.O00000oO);
            if (OoO0o.O0000o()) {
                bundle = new Bundle();
                bundle.putBoolean("ngpsAble", OoO0o.O0000oO());
                O000000o(messenger, 7, bundle);
                OoO0o.O0000oO0();
            }
            if (OoO0o.O00oOooo()) {
                bundle = new Bundle();
                bundle.putBoolean("installMockApp", true);
                O000000o(messenger, 9, bundle);
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "ApsServiceCore", "initAuth");
        }
    }

    static /* synthetic */ void O00000Oo(OO000o oO000o, Messenger messenger, Bundle bundle) {
        OO000o oO000o2 = oO000o;
        Messenger messenger2 = messenger;
        Bundle bundle2 = bundle;
        if (bundle2 != null) {
            try {
                if (!bundle.isEmpty()) {
                    AMapLocationClientOption O00000Oo = oO000o2.O00000Oo(bundle2);
                    if (oO000o2.O0000OOo.containsKey(messenger2) && !O00000Oo.isOnceLocation()) {
                        if (OO000OO.O00000o0() - ((Long) oO000o2.O0000OOo.get(messenger2)).longValue() < 800) {
                            return;
                        }
                    }
                    AMapLocation aMapLocation = null;
                    if (oO000o2.O000O00o) {
                        long O00000o0 = OO000OO.O00000o0();
                        long j = 0;
                        if (!OO000OO.O000000o(oO000o2.O0000ooO) || O00000o0 - oO000o2.O0000oo >= 600) {
                            String str;
                            AMapLocation aMapLocation2;
                            Oo0OOo oo0OOo = new Oo0OOo();
                            oo0OOo.O000000o(OO000OO.O00000o0());
                            oO000o2.O0000ooO = oO000o2.O00000oo.O00000o();
                            if (oO000o2.O0000ooO.getLocationType() == 6 || oO000o2.O0000ooO.getLocationType() == 5) {
                                j = oO000o2.O0000ooO.k();
                            }
                            oo0OOo.O000000o(oO000o2.O0000ooO);
                            oO000o2.O0000ooO = oO000o2.O00000oo.O000000o(oO000o2.O0000ooO, new String[0]);
                            long j2 = j;
                            oo0OOo.O00000Oo(OO000OO.O00000o0());
                            if (OO000OO.O000000o(oO000o2.O0000ooO)) {
                                oO000o2.O0000oo = OO000OO.O00000o0();
                            }
                            if (oO000o2.O0000ooO == null) {
                                oO000o2.O0000ooO = O000000o(8, "loc is null#0801");
                            }
                            if (oO000o2.O0000ooO != null) {
                                String l = oO000o2.O0000ooO.l();
                                aMapLocation = oO000o2.O0000ooO.clone();
                                str = l;
                            } else {
                                str = null;
                            }
                            try {
                                AMapLocation O000000o = (!O00000Oo.isLocationCacheEnable() || oO000o2.O00oOooo == null) ? aMapLocation : oO000o2.O00oOooo.O000000o(aMapLocation, str, O00000Oo.getLastLocationLifeCycle());
                                aMapLocation2 = O000000o;
                            } catch (Throwable th) {
                                O0o0000.O000000o(th, "ApsServiceCore", "fixLastLocation");
                                aMapLocation2 = aMapLocation;
                            }
                            oO000o2.O000000o(messenger2, aMapLocation2, str, j2);
                            ooO0Ooo.O000000o(oO000o2.O00000oO, oo0OOo);
                        } else {
                            oO000o2.O000000o(messenger2, oO000o2.O0000ooO, oO000o2.O0000ooO.l(), 0);
                        }
                        oO000o.O00000Oo(messenger);
                        if (OoO0o.O000O00o()) {
                            oO000o.O000000o(messenger);
                        }
                        if (OoO0o.O000000o(oO000o2.O0000ooo) && oO000o2.O0000ooO != null && (oO000o2.O0000ooO.getLocationType() == 2 || oO000o2.O0000ooO.getLocationType() == 4 || oO000o2.O0000ooO.getLocationType() == 9)) {
                            oO000o2.O0000ooo = OO000OO.O00000o0();
                            oO000o2.O00000oo.O00000oO();
                        }
                        oO000o2.O0000OOo();
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder("init error : ");
                    stringBuilder.append(oO000o2.O000O0OO);
                    stringBuilder.append("#0901");
                    oO000o2.O0000ooO = O000000o(9, stringBuilder.toString());
                    oO000o2.O000000o(messenger2, oO000o2.O0000ooO, oO000o2.O0000ooO.l(), 0);
                    ooO0Ooo.O000000o(null, 2091);
                }
            } catch (Throwable th2) {
                O0o0000.O000000o(th2, "ApsServiceCore", "doLocation");
            }
        }
    }

    private void O00000o0(String str) throws UnsupportedEncodingException, IOException {
        PrintStream printStream = new PrintStream(this.O0000o.getOutputStream(), true, HttpUtils.ENCODING_UTF_8);
        printStream.println("HTTP/1.0 200 OK");
        StringBuilder stringBuilder = new StringBuilder("Content-Length:");
        stringBuilder.append(str.getBytes(HttpUtils.ENCODING_UTF_8).length);
        printStream.println(stringBuilder.toString());
        printStream.println();
        printStream.println(str);
        printStream.close();
    }

    public static void O00000oo() {
        O0000O0o = false;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:21:0x010e in {2, 4, 8, 11, 13, 16, 19, 20} preds:[]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:242)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    private java.lang.String O0000O0o() {
        /*
        r6 = this;
        r0 = java.lang.System.currentTimeMillis();
        r2 = r6.O00000oO;
        r2 = com.loc.OO000OO.O00000oO(r2);
        if (r2 == 0) goto L_0x0034;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r6.O00oOoOo;
        r0.append(r1);
        r1 = "&&";
        r0.append(r1);
        r1 = r6.O00oOoOo;
        r0.append(r1);
        r1 = "({'package':'";
        r0.append(r1);
        r1 = r6.O000000o;
        r0.append(r1);
        r1 = "','error_code':36,'error':'app is background'})";
        r0.append(r1);
        r0 = r0.toString();
        return r0;
        r2 = r6.O0000ooO;
        if (r2 == 0) goto L_0x0046;
        r2 = r6.O0000ooO;
        r2 = r2.getTime();
        r4 = r0 - r2;
        r0 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r2 <= 0) goto L_0x0057;
        r0 = r6.O00000oo;	 Catch:{ Throwable -> 0x004f }
        r0 = r0.O00000o();	 Catch:{ Throwable -> 0x004f }
        r6.O0000ooO = r0;	 Catch:{ Throwable -> 0x004f }
        goto L_0x0057;
        r0 = move-exception;
        r1 = "ApsServiceCore";
        r2 = "getSocketLocResult";
        com.loc.O0o0000.O000000o(r0, r1, r2);
        r0 = r6.O0000ooO;
        if (r0 != 0) goto L_0x007c;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r6.O00oOoOo;
        r0.append(r1);
        r1 = "&&";
        r0.append(r1);
        r1 = r6.O00oOoOo;
        r0.append(r1);
        r1 = "({'package':'";
        r0.append(r1);
        r1 = r6.O000000o;
        r0.append(r1);
        r1 = "','error_code':8,'error':'unknown error'})";
        goto L_0x002c;
        r0 = r6.O0000ooO;
        r0 = r0.getErrorCode();
        if (r0 == 0) goto L_0x00c2;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r6.O00oOoOo;
        r0.append(r1);
        r1 = "&&";
        r0.append(r1);
        r1 = r6.O00oOoOo;
        r0.append(r1);
        r1 = "({'package':'";
        r0.append(r1);
        r1 = r6.O000000o;
        r0.append(r1);
        r1 = "','error_code':";
        r0.append(r1);
        r1 = r6.O0000ooO;
        r1 = r1.getErrorCode();
        r0.append(r1);
        r1 = ",'error':'";
        r0.append(r1);
        r1 = r6.O0000ooO;
        r1 = r1.getErrorInfo();
        r0.append(r1);
        r1 = "'})";
        goto L_0x002c;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r6.O00oOoOo;
        r0.append(r1);
        r1 = "&&";
        r0.append(r1);
        r1 = r6.O00oOoOo;
        r0.append(r1);
        r1 = "({'package':'";
        r0.append(r1);
        r1 = r6.O000000o;
        r0.append(r1);
        r1 = "','error_code':0,'error':'','location':{'y':";
        r0.append(r1);
        r1 = r6.O0000ooO;
        r1 = r1.getLatitude();
        r0.append(r1);
        r1 = ",'precision':";
        r0.append(r1);
        r1 = r6.O0000ooO;
        r1 = r1.getAccuracy();
        r0.append(r1);
        r1 = ",'x':";
        r0.append(r1);
        r1 = r6.O0000ooO;
        r1 = r1.getLongitude();
        r0.append(r1);
        r1 = "},'version_code':'4.6.0','version':'4.6.0'})";
        goto L_0x002c;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.OO000o.O0000O0o():java.lang.String");
    }

    private void O0000OOo() {
        try {
            if (this.O00000oo != null) {
                this.O00000oo.O0000OoO();
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "ApsServiceCore", "startColl");
        }
    }

    public final void O000000o() {
        try {
            this.O0000Oo0 = new ooO0Ooo();
            this.O00000Oo = new O00000Oo("amapLocCoreThread");
            this.O00000Oo.setPriority(5);
            this.O00000Oo.start();
            this.O00000o = new O000000o(this.O00000Oo.getLooper());
        } catch (Throwable th) {
            O0o0000.O000000o(th, "ApsServiceCore", "onCreate");
        }
    }

    public final void O000000o(Intent intent) {
        if ("true".equals(intent.getStringExtra("as")) && this.O00000o != null) {
            this.O00000o.sendEmptyMessageDelayed(9, 100);
        }
    }

    /* Access modifiers changed, original: final */
    public final void O000000o(Messenger messenger, Bundle bundle) {
        if (bundle != null) {
            try {
                if (!bundle.isEmpty() && OoO0o.O0000ooO()) {
                    float O000000o;
                    double d = bundle.getDouble("lat");
                    double d2 = bundle.getDouble("lon");
                    O00000Oo(bundle);
                    if (this.O00000o0 != null) {
                        O000000o = OO000OO.O000000o(new double[]{d, d2, this.O00000o0.getLatitude(), this.O00000o0.getLongitude()});
                        if (O000000o < ((float) (OoO0o.O0000ooo() * 3))) {
                            Bundle bundle2 = new Bundle();
                            bundle2.setClassLoader(AMapLocation.class.getClassLoader());
                            bundle2.putInt("I_MAX_GEO_DIS", OoO0o.O0000ooo() * 3);
                            bundle2.putInt("I_MIN_GEO_DIS", OoO0o.O0000ooo());
                            bundle2.putParcelable("loc", this.O00000o0);
                            O000000o(messenger, 6, bundle2);
                        }
                    } else {
                        O000000o = -1.0f;
                    }
                    if (O000000o == -1.0f || O000000o > ((float) OoO0o.O0000ooo())) {
                        O000000o(bundle);
                        this.O00000o0 = this.O00000oo.O000000o(d, d2);
                    }
                }
            } catch (Throwable th) {
                O0o0000.O000000o(th, "ApsServiceCore", "doLocationGeo");
            }
        }
    }

    public final boolean O000000o(String str) {
        if (TextUtils.isEmpty(this.O0000Ooo)) {
            this.O0000Ooo = O0o0000.O00000Oo(this.O00000oO);
        }
        return !TextUtils.isEmpty(str) && str.equals(this.O0000Ooo);
    }

    public final Handler O00000Oo() {
        return this.O00000o;
    }

    public final void O00000Oo(Intent intent) {
        String stringExtra = intent.getStringExtra("a");
        if (!TextUtils.isEmpty(stringExtra)) {
            OO0O00o.O000000o(this.O00000oO, stringExtra);
        }
        this.O000000o = intent.getStringExtra("b");
        OO00o00.O000000o(this.O000000o);
        stringExtra = intent.getStringExtra("d");
        if (!TextUtils.isEmpty(stringExtra)) {
            OO0O0o0.O000000o(stringExtra);
        }
        OoO0o.O000000o = intent.getBooleanExtra("f", true);
    }

    public final void O00000o() {
        try {
            if (this.O0000o != null) {
                this.O0000o.close();
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "ApsServiceCore", "doStopScocket 1");
        }
        try {
            if (this.O0000o0O != null) {
                this.O0000o0O.close();
            }
        } catch (Throwable th2) {
            O0o0000.O000000o(th2, "ApsServiceCore", "doStopScocket 2");
        }
        try {
            if (this.O0000oO != null) {
                this.O0000oO.interrupt();
            }
        } catch (Throwable unused) {
        }
        this.O0000oO = null;
        this.O0000o0O = null;
        this.O0000o0o = false;
        this.O0000oO0 = false;
    }

    public final void O00000o0() {
        try {
            if (!this.O0000oO0) {
                this.O0000oO = new O00000o0();
                this.O0000oO.start();
                this.O0000oO0 = true;
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "ApsServiceCore", "startSocket");
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0033 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public final void O00000oO() {
        /*
        r11 = this;
        r0 = r11.O0000OOo;	 Catch:{ Throwable -> 0x00a3 }
        r0.clear();	 Catch:{ Throwable -> 0x00a3 }
        r0 = 0;
        r11.O0000OOo = r0;	 Catch:{ Throwable -> 0x00a3 }
        r1 = r11.O00000oo;	 Catch:{ Throwable -> 0x00a3 }
        if (r1 == 0) goto L_0x0013;
    L_0x000c:
        r1 = r11.O00000oo;	 Catch:{ Throwable -> 0x00a3 }
        r1 = r11.O00000oO;	 Catch:{ Throwable -> 0x00a3 }
        com.loc.O0O0OOO.O00000Oo(r1);	 Catch:{ Throwable -> 0x00a3 }
    L_0x0013:
        r1 = r11.O00000o;	 Catch:{ Throwable -> 0x00a3 }
        if (r1 == 0) goto L_0x001c;
    L_0x0017:
        r1 = r11.O00000o;	 Catch:{ Throwable -> 0x00a3 }
        r1.removeCallbacksAndMessages(r0);	 Catch:{ Throwable -> 0x00a3 }
    L_0x001c:
        r1 = r11.O00000Oo;	 Catch:{ Throwable -> 0x00a3 }
        r2 = 0;
        if (r1 == 0) goto L_0x003c;
    L_0x0021:
        r1 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x00a3 }
        r3 = 18;
        if (r1 < r3) goto L_0x0039;
    L_0x0027:
        r1 = r11.O00000Oo;	 Catch:{ Throwable -> 0x0033 }
        r3 = android.os.HandlerThread.class;
        r4 = "quitSafely";
        r5 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0033 }
        com.loc.O0o.O000000o(r1, r3, r4, r5);	 Catch:{ Throwable -> 0x0033 }
        goto L_0x003c;
    L_0x0033:
        r1 = r11.O00000Oo;	 Catch:{ Throwable -> 0x00a3 }
    L_0x0035:
        r1.quit();	 Catch:{ Throwable -> 0x00a3 }
        goto L_0x003c;
    L_0x0039:
        r1 = r11.O00000Oo;	 Catch:{ Throwable -> 0x00a3 }
        goto L_0x0035;
    L_0x003c:
        r11.O00000Oo = r0;	 Catch:{ Throwable -> 0x00a3 }
        r11.O00000o = r0;	 Catch:{ Throwable -> 0x00a3 }
        r1 = r11.O00oOooo;	 Catch:{ Throwable -> 0x00a3 }
        if (r1 == 0) goto L_0x004b;
    L_0x0044:
        r1 = r11.O00oOooo;	 Catch:{ Throwable -> 0x00a3 }
        r1.O00000o0();	 Catch:{ Throwable -> 0x00a3 }
        r11.O00oOooo = r0;	 Catch:{ Throwable -> 0x00a3 }
    L_0x004b:
        r11.O00000o();	 Catch:{ Throwable -> 0x00a3 }
        r11.O0000oOO = r2;	 Catch:{ Throwable -> 0x00a3 }
        r11.O0000oOo = r2;	 Catch:{ Throwable -> 0x00a3 }
        r0 = r11.O00000oo;	 Catch:{ Throwable -> 0x00a3 }
        r0.O00000oo();	 Catch:{ Throwable -> 0x00a3 }
        r0 = r11.O00000oO;	 Catch:{ Throwable -> 0x00a3 }
        com.loc.ooO0Ooo.O000000o(r0);	 Catch:{ Throwable -> 0x00a3 }
        r0 = r11.O0000Oo0;	 Catch:{ Throwable -> 0x00a3 }
        if (r0 == 0) goto L_0x0094;
    L_0x0060:
        r0 = r11.O0000Oo;	 Catch:{ Throwable -> 0x00a3 }
        r2 = 0;
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r4 == 0) goto L_0x0094;
    L_0x0068:
        r0 = r11.O0000OoO;	 Catch:{ Throwable -> 0x00a3 }
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r4 == 0) goto L_0x0094;
    L_0x006e:
        r0 = com.loc.OO000OO.O00000o0();	 Catch:{ Throwable -> 0x00a3 }
        r2 = r11.O0000Oo;	 Catch:{ Throwable -> 0x00a3 }
        r9 = r0 - r2;
        r0 = r11.O0000Oo0;	 Catch:{ Throwable -> 0x00a3 }
        r1 = r11.O00000oO;	 Catch:{ Throwable -> 0x00a3 }
        r5 = r0.O00000o0(r1);	 Catch:{ Throwable -> 0x00a3 }
        r0 = r11.O0000Oo0;	 Catch:{ Throwable -> 0x00a3 }
        r1 = r11.O00000oO;	 Catch:{ Throwable -> 0x00a3 }
        r6 = r0.O00000o(r1);	 Catch:{ Throwable -> 0x00a3 }
        r4 = r11.O00000oO;	 Catch:{ Throwable -> 0x00a3 }
        r7 = r11.O0000OoO;	 Catch:{ Throwable -> 0x00a3 }
        com.loc.ooO0Ooo.O000000o(r4, r5, r6, r7, r9);	 Catch:{ Throwable -> 0x00a3 }
        r0 = r11.O0000Oo0;	 Catch:{ Throwable -> 0x00a3 }
        r1 = r11.O00000oO;	 Catch:{ Throwable -> 0x00a3 }
        r0.O00000oO(r1);	 Catch:{ Throwable -> 0x00a3 }
    L_0x0094:
        com.loc.O0000o.O00000Oo();	 Catch:{ Throwable -> 0x00a3 }
        r0 = O0000O0o;	 Catch:{ Throwable -> 0x00a3 }
        if (r0 == 0) goto L_0x00a2;
    L_0x009b:
        r0 = android.os.Process.myPid();	 Catch:{ Throwable -> 0x00a3 }
        android.os.Process.killProcess(r0);	 Catch:{ Throwable -> 0x00a3 }
    L_0x00a2:
        return;
    L_0x00a3:
        r0 = move-exception;
        r1 = "ApsServiceCore";
        r2 = "threadDestroy";
        com.loc.O0o0000.O000000o(r0, r1, r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.OO000o.O00000oO():void");
    }
}
