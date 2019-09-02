package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;

/* compiled from: OfflineDownloadManager */
public class O00O0O0o {
    public static String O000000o = "";
    public static boolean O00000Oo = false;
    public static String O00000o = "";
    private static volatile O00O0O0o O0000OoO;
    List<bf> O00000o0 = new Vector();
    O00000Oo O00000oO = null;
    public O00O0o0 O00000oo;
    O00OO0O O0000O0o;
    O00O0o00 O0000OOo = null;
    private boolean O0000Oo = true;
    private Context O0000Oo0;
    private O000000o O0000Ooo;
    private ExecutorService O0000o = null;
    private O00Oo O0000o0;
    private O00OOo O0000o00;
    private ExecutorService O0000o0O = null;
    private ExecutorService O0000o0o = null;
    private boolean O0000oO0 = true;

    /* compiled from: OfflineDownloadManager */
    public interface O000000o {
        void a();

        void a(bf bfVar);

        void b(bf bfVar);

        void c(bf bfVar);
    }

    /* compiled from: OfflineDownloadManager */
    class O00000Oo extends Handler {
        public O00000Oo(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            try {
                message.getData();
                Object obj = message.obj;
                if (obj instanceof bf) {
                    bf bfVar = (bf) obj;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("OfflineMapHandler handleMessage CitObj  name: ");
                    stringBuilder.append(bfVar.getCity());
                    stringBuilder.append(" complete: ");
                    stringBuilder.append(bfVar.getcompleteCode());
                    stringBuilder.append(" status: ");
                    stringBuilder.append(bfVar.getState());
                    O00o.O000000o(stringBuilder.toString());
                    if (O00O0O0o.this.O0000Ooo != null) {
                        O00O0O0o.this.O0000Ooo.a(bfVar);
                        return;
                    }
                    return;
                }
                O00o.O000000o("Do not callback by CityObject! ");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private O00O0O0o(Context context) {
        this.O0000Oo0 = context;
    }

    public static O00O0O0o O000000o(Context context) {
        if (O0000OoO == null) {
            synchronized (O00O0O0o.class) {
                if (O0000OoO == null && !O00000Oo) {
                    O0000OoO = new O00O0O0o(context.getApplicationContext());
                }
            }
        }
        return O0000OoO;
    }

    private void O000000o(final bf bfVar, final boolean z) {
        if (this.O0000O0o == null) {
            this.O0000O0o = new O00OO0O(this.O0000Oo0);
        }
        if (this.O0000o0o == null) {
            long j = (long) 1;
            this.O0000o0o = new ThreadPoolExecutor(1, 2, j, TimeUnit.SECONDS, new LinkedBlockingQueue(), new OOO0o00("AMapOfflineRemove"), new AbortPolicy());
        }
        try {
            this.O0000o0o.execute(new Runnable() {
                public void run() {
                    try {
                        if (bfVar.O00000o0().equals(bfVar.O000000o)) {
                            if (O00O0O0o.this.O0000Ooo != null) {
                                O00O0O0o.this.O0000Ooo.c(bfVar);
                            }
                            return;
                        }
                        if (bfVar.getState() != 7) {
                            if (bfVar.getState() != -1) {
                                O00O0O0o.this.O0000O0o.O000000o(bfVar);
                                if (O00O0O0o.this.O0000Ooo != null) {
                                    O00O0O0o.this.O0000Ooo.c(bfVar);
                                }
                            }
                        }
                        O00O0O0o.this.O0000O0o.O000000o(bfVar);
                        if (z && O00O0O0o.this.O0000Ooo != null) {
                            O00O0O0o.this.O0000Ooo.c(bfVar);
                        }
                    } catch (Throwable th) {
                        ooOOOOoo.O00000o0(th, "requestDelete", "removeExcecRunnable");
                    }
                }
            });
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "requestDelete", "removeExcecRunnable");
        }
    }

    private boolean O000000o(String str, String str2) {
        int i = 0;
        while (i < str2.length()) {
            try {
                if (str.charAt(i) > str2.charAt(i)) {
                    return true;
                }
                if (str.charAt(i) < str2.charAt(i)) {
                    return false;
                }
                i++;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static void O00000oo() {
        O0000OoO = null;
        O00000Oo = true;
    }

    private void O00000oo(final bf bfVar) throws AMapException {
        O0000OoO();
        if (bfVar == null) {
            throw new AMapException(AMapException.ERROR_INVALID_PARAMETER);
        }
        if (this.O0000o == null) {
            long j = (long) 1;
            this.O0000o = new ThreadPoolExecutor(1, 2, j, TimeUnit.SECONDS, new LinkedBlockingQueue(), new OOO0o00("AMapOfflineDownload"), new AbortPolicy());
        }
        try {
            this.O0000o.execute(new Runnable() {
                public void run() {
                    try {
                        if (O00O0O0o.this.O0000Oo) {
                            O00O0O0o.this.O0000OoO();
                            O00O0OOo o00O0OOo = (O00O0OOo) new O00O0Oo0(O00O0O0o.this.O0000Oo0, O00O0O0o.O00000o).O00000o0();
                            if (o00O0OOo != null) {
                                O00O0O0o.this.O0000Oo = false;
                                if (o00O0OOo.O000000o()) {
                                    O00O0O0o.this.O00000Oo();
                                }
                            }
                        }
                        bfVar.setVersion(O00O0O0o.O00000o);
                        bfVar.O00000oo();
                    } catch (AMapException e) {
                        e.printStackTrace();
                    } catch (Throwable th) {
                        ooOOOOoo.O00000o0(th, "OfflineDownloadManager", "startDownloadRunnable");
                    }
                }
            });
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "startDownload", "downloadExcecRunnable");
        }
    }

    public static void O0000O0o(String str) {
        O000000o = str;
    }

    private void O0000OOo() {
        try {
            String str = "000001";
            O00Oo00 O000000o = this.O0000o0.O000000o(str);
            if (O000000o != null) {
                this.O0000o0.O00000o0(str);
                O000000o.O00000o0("100000");
                this.O0000o0.O000000o(O000000o);
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "OfflineDownloadManager", "changeBadCase");
        }
    }

    /* JADX WARNING: Missing block: B:8:0x001d, code skipped:
            return;
     */
    private void O0000OOo(java.lang.String r2) throws org.json.JSONException {
        /*
        r1 = this;
        r0 = r1.O0000Oo0;
        r0 = r0.getApplicationContext();
        r2 = com.amap.api.mapcore.util.O00o.O000000o(r2, r0);
        if (r2 == 0) goto L_0x001d;
    L_0x000c:
        r0 = r2.size();
        if (r0 != 0) goto L_0x0013;
    L_0x0012:
        goto L_0x001d;
    L_0x0013:
        r0 = r1.O00000oo;
        if (r0 == 0) goto L_0x001c;
    L_0x0017:
        r0 = r1.O00000oo;
        r0.O000000o(r2);
    L_0x001c:
        return;
    L_0x001d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.O00O0O0o.O0000OOo(java.lang.String):void");
    }

    private bf O0000Oo(String str) {
        if (str == null || str.length() < 1) {
            return null;
        }
        synchronized (this.O00000o0) {
            for (bf bfVar : this.O00000o0) {
                if (str.equals(bfVar.getCode())) {
                    return bfVar;
                }
            }
            return null;
        }
    }

    private void O0000Oo() {
        Iterator it = this.O0000o0.O000000o().iterator();
        while (it.hasNext()) {
            O00Oo00 o00Oo00 = (O00Oo00) it.next();
            if (!(o00Oo00 == null || o00Oo00.O00000o() == null)) {
                if (o00Oo00.O00000oo().length() >= 1) {
                    if (!(o00Oo00.O0000Ooo == 4 || o00Oo00.O0000Ooo == 7 || o00Oo00.O0000Ooo < 0)) {
                        o00Oo00.O0000Ooo = 3;
                    }
                    bf O0000Oo0 = O0000Oo0(o00Oo00.O00000o());
                    if (O0000Oo0 != null) {
                        String O00000oO = o00Oo00.O00000oO();
                        if (O00000oO == null || !O000000o(O00000o, O00000oO)) {
                            O0000Oo0.O000000o(o00Oo00.O0000Ooo);
                            O0000Oo0.setCompleteCode(o00Oo00.O0000OOo());
                        } else {
                            O0000Oo0.O000000o(7);
                        }
                        if (o00Oo00.O00000oO().length() > 0) {
                            O0000Oo0.setVersion(o00Oo00.O00000oO());
                        }
                        List<String> O00000Oo = this.O0000o0.O00000Oo(o00Oo00.O00000oo());
                        StringBuffer stringBuffer = new StringBuffer();
                        for (String append : O00000Oo) {
                            stringBuffer.append(append);
                            stringBuffer.append(";");
                        }
                        O0000Oo0.O000000o(stringBuffer.toString());
                        if (this.O00000oo != null) {
                            this.O00000oo.O000000o(O0000Oo0);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Missing block: B:15:0x0035, code skipped:
            return r3;
     */
    private com.amap.api.mapcore.util.bf O0000Oo0(java.lang.String r6) {
        /*
        r5 = this;
        r0 = 0;
        if (r6 == 0) goto L_0x003b;
    L_0x0003:
        r1 = r6.length();
        r2 = 1;
        if (r1 >= r2) goto L_0x000b;
    L_0x000a:
        goto L_0x003b;
    L_0x000b:
        r1 = r5.O00000o0;
        monitor-enter(r1);
        r2 = r5.O00000o0;	 Catch:{ all -> 0x0038 }
        r2 = r2.iterator();	 Catch:{ all -> 0x0038 }
    L_0x0014:
        r3 = r2.hasNext();	 Catch:{ all -> 0x0038 }
        if (r3 == 0) goto L_0x0036;
    L_0x001a:
        r3 = r2.next();	 Catch:{ all -> 0x0038 }
        r3 = (com.amap.api.mapcore.util.bf) r3;	 Catch:{ all -> 0x0038 }
        r4 = r3.getCity();	 Catch:{ all -> 0x0038 }
        r4 = r6.equals(r4);	 Catch:{ all -> 0x0038 }
        if (r4 != 0) goto L_0x0034;
    L_0x002a:
        r4 = r3.getPinyin();	 Catch:{ all -> 0x0038 }
        r4 = r6.equals(r4);	 Catch:{ all -> 0x0038 }
        if (r4 == 0) goto L_0x0014;
    L_0x0034:
        monitor-exit(r1);	 Catch:{ all -> 0x0038 }
        return r3;
    L_0x0036:
        monitor-exit(r1);	 Catch:{ all -> 0x0038 }
        return r0;
    L_0x0038:
        r6 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0038 }
        throw r6;
    L_0x003b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.O00O0O0o.O0000Oo0(java.lang.String):com.amap.api.mapcore.util.bf");
    }

    private void O0000Oo0() {
        if (!"".equals(OOo000.O00000o0(this.O0000Oo0))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(OOo000.O00000o0(this.O0000Oo0));
            stringBuilder.append("offlinemapv4.png");
            File file = new File(stringBuilder.toString());
            String O000000o = !file.exists() ? O00o.O000000o(this.O0000Oo0, "offlinemapv4.png") : O00o.O00000o0(file);
            if (O000000o != null) {
                try {
                    O0000OOo(O000000o);
                } catch (JSONException e) {
                    if (file.exists()) {
                        file.delete();
                    }
                    ooOOOOoo.O00000o0(e, "MapDownloadManager", "paseJson io");
                    e.printStackTrace();
                }
            }
        }
    }

    private void O0000OoO() throws AMapException {
        if (!OOo000.O00000o(this.O0000Oo0)) {
            throw new AMapException(AMapException.ERROR_CONNECTION);
        }
    }

    public void O000000o() {
        this.O0000o0 = O00Oo.O000000o(this.O0000Oo0.getApplicationContext());
        O0000OOo();
        this.O00000oO = new O00000Oo(this.O0000Oo0.getMainLooper());
        this.O00000oo = new O00O0o0(this.O0000Oo0, this.O00000oO);
        this.O0000o00 = O00OOo.O000000o(1);
        O0000O0o(OOo000.O00000o0(this.O0000Oo0));
        try {
            O0000Oo0();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        synchronized (this.O00000o0) {
            Iterator it = this.O00000oo.O000000o().iterator();
            while (it.hasNext()) {
                Iterator it2 = ((OfflineMapProvince) it.next()).getCityList().iterator();
                while (it2.hasNext()) {
                    OfflineMapCity offlineMapCity = (OfflineMapCity) it2.next();
                    if (offlineMapCity != null) {
                        this.O00000o0.add(new bf(this.O0000Oo0, offlineMapCity));
                    }
                }
            }
        }
        this.O0000OOo = new O00O0o00(this.O0000Oo0);
        this.O0000OOo.start();
    }

    public void O000000o(O000000o o000000o) {
        this.O0000Ooo = o000000o;
    }

    public void O000000o(bf bfVar) {
        O000000o(bfVar, false);
    }

    public void O000000o(final String str) {
        if (str == null) {
            try {
                if (this.O0000Ooo != null) {
                    this.O0000Ooo.b(null);
                }
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "OfflineDownloadManager", "checkUpdate");
            }
        } else {
            if (this.O0000o0O == null) {
                long j = (long) 1;
                this.O0000o0O = new ThreadPoolExecutor(1, 2, j, TimeUnit.SECONDS, new LinkedBlockingQueue(), new OOO0o00("AMapOfflineCheckUpdate"), new AbortPolicy());
            }
            this.O0000o0O.execute(new Runnable() {
                public void run() {
                    bf O000000o = O00O0O0o.this.O0000Oo0(str);
                    if (O000000o != null) {
                        try {
                            if (!O000000o.O00000o0().equals(O000000o.O00000o0)) {
                                if (!O000000o.O00000o0().equals(O000000o.O00000oO)) {
                                    String pinyin = O000000o.getPinyin();
                                    if (pinyin.length() > 0) {
                                        pinyin = O00O0O0o.this.O0000o0.O00000o(pinyin);
                                        if (pinyin == null) {
                                            pinyin = O000000o.getVersion();
                                        }
                                        if (O00O0O0o.O00000o.length() > 0 && r1 != null && O00O0O0o.this.O000000o(O00O0O0o.O00000o, r1)) {
                                            O000000o.O0000Oo();
                                        }
                                    }
                                }
                            }
                            if (O00O0O0o.this.O0000Ooo != null) {
                                synchronized (O00O0O0o.this) {
                                    try {
                                        O00O0O0o.this.O0000Ooo.b(O000000o);
                                    } catch (Throwable th) {
                                        ooOOOOoo.O00000o0(th, "OfflineDownloadManager", "checkUpdatefinally");
                                    }
                                }
                            }
                            return;
                        } catch (Exception unused) {
                            if (O00O0O0o.this.O0000Ooo != null) {
                                synchronized (O00O0O0o.this) {
                                    O00O0O0o.this.O0000Ooo.b(O000000o);
                                }
                            }
                        } catch (Throwable th2) {
                            ooOOOOoo.O00000o0(th2, "OfflineDownloadManager", "checkUpdatefinally");
                        }
                    }
                    O00O0O0o.this.O0000OoO();
                    O00O0OOo o00O0OOo = (O00O0OOo) new O00O0Oo0(O00O0O0o.this.O0000Oo0, O00O0O0o.O00000o).O00000o0();
                    if (O00O0O0o.this.O0000Ooo != null) {
                        if (o00O0OOo == null) {
                            if (O00O0O0o.this.O0000Ooo != null) {
                                synchronized (O00O0O0o.this) {
                                    try {
                                        O00O0O0o.this.O0000Ooo.b(O000000o);
                                    } catch (Throwable th22) {
                                        ooOOOOoo.O00000o0(th22, "OfflineDownloadManager", "checkUpdatefinally");
                                    }
                                }
                            }
                            return;
                        } else if (o00O0OOo.O000000o()) {
                            O00O0O0o.this.O00000Oo();
                        }
                    }
                    if (O00O0O0o.this.O0000Ooo != null) {
                        synchronized (O00O0O0o.this) {
                            try {
                                O00O0O0o.this.O0000Ooo.b(O000000o);
                            } catch (Throwable th222) {
                                ooOOOOoo.O00000o0(th222, "OfflineDownloadManager", "checkUpdatefinally");
                            }
                        }
                    }
                }
            });
        }
    }

    public void O000000o(ArrayList<O00Oo00> arrayList) {
        O0000Oo();
        if (this.O0000Ooo != null) {
            try {
                this.O0000Ooo.a();
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "OfflineDownloadManager", "verifyCallBack");
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void O00000Oo() throws AMapException {
        if (this.O00000oo != null) {
            O00OOOo o00OOOo = new O00OOOo(this.O0000Oo0, "");
            o00OOOo.O000000o(this.O0000Oo0);
            List list = (List) o00OOOo.O00000o0();
            if (this.O00000o0 != null) {
                this.O00000oo.O000000o(list);
            }
            if (this.O00000o0 != null) {
                synchronized (this.O00000o0) {
                    Iterator it = this.O00000oo.O000000o().iterator();
                    while (it.hasNext()) {
                        Iterator it2 = ((OfflineMapProvince) it.next()).getCityList().iterator();
                        while (it2.hasNext()) {
                            OfflineMapCity offlineMapCity = (OfflineMapCity) it2.next();
                            for (bf bfVar : this.O00000o0) {
                                if (offlineMapCity.getPinyin().equals(bfVar.getPinyin())) {
                                    String version = bfVar.getVersion();
                                    if (bfVar.getState() == 4 && O00000o.length() > 0 && O000000o(O00000o, version)) {
                                        bfVar.O0000Oo();
                                        bfVar.setUrl(offlineMapCity.getUrl());
                                        bfVar.O0000oOO();
                                    } else {
                                        bfVar.setCity(offlineMapCity.getCity());
                                        bfVar.setUrl(offlineMapCity.getUrl());
                                        bfVar.O0000oOO();
                                        bfVar.setAdcode(offlineMapCity.getAdcode());
                                        bfVar.setVersion(offlineMapCity.getVersion());
                                        bfVar.setSize(offlineMapCity.getSize());
                                        bfVar.setCode(offlineMapCity.getCode());
                                        bfVar.setJianpin(offlineMapCity.getJianpin());
                                        bfVar.setPinyin(offlineMapCity.getPinyin());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void O00000Oo(bf bfVar) {
        try {
            if (this.O0000o00 != null) {
                this.O0000o00.O000000o(bfVar, this.O0000Oo0, null);
            }
        } catch (o0O0oo0o e) {
            e.printStackTrace();
        }
    }

    public boolean O00000Oo(String str) {
        return O0000Oo0(str) != null;
    }

    public void O00000o() {
        synchronized (this.O00000o0) {
            for (bf bfVar : this.O00000o0) {
                if (bfVar.O00000o0().equals(bfVar.O00000o0)) {
                    bfVar.O0000O0o();
                    break;
                }
            }
        }
    }

    public void O00000o(bf bfVar) {
        if (this.O0000o00 != null) {
            this.O0000o00.O000000o((O00OOo0) bfVar);
        }
    }

    public void O00000o(String str) throws AMapException {
        bf O0000Oo0 = O0000Oo0(str);
        if (str == null || str.length() < 1 || O0000Oo0 == null) {
            throw new AMapException(AMapException.ERROR_INVALID_PARAMETER);
        }
        O00000oo(O0000Oo0);
    }

    public void O00000o0() {
        synchronized (this.O00000o0) {
            for (bf bfVar : this.O00000o0) {
                if (bfVar.O00000o0().equals(bfVar.O00000o0) || bfVar.O00000o0().equals(bfVar.O00000Oo)) {
                    O00000o(bfVar);
                    bfVar.O0000O0o();
                }
            }
        }
    }

    public void O00000o0(bf bfVar) {
        if (this.O00000oo != null) {
            this.O00000oo.O000000o(bfVar);
        }
        if (this.O00000oO != null) {
            Message obtainMessage = this.O00000oO.obtainMessage();
            obtainMessage.obj = bfVar;
            this.O00000oO.sendMessage(obtainMessage);
        }
    }

    public void O00000o0(String str) {
        bf O0000Oo0 = O0000Oo0(str);
        if (O0000Oo0 == null) {
            if (this.O0000Ooo != null) {
                try {
                    this.O0000Ooo.c(O0000Oo0);
                } catch (Throwable th) {
                    ooOOOOoo.O00000o0(th, "OfflineDownloadManager", "remove");
                }
            }
            return;
        }
        O00000o(O0000Oo0);
        O000000o(O0000Oo0, true);
    }

    public void O00000oO() {
        if (!(this.O0000o0O == null || this.O0000o0O.isShutdown())) {
            this.O0000o0O.shutdownNow();
        }
        if (!(this.O0000o == null || this.O0000o.isShutdown())) {
            this.O0000o.shutdownNow();
        }
        if (this.O0000OOo != null) {
            if (this.O0000OOo.isAlive()) {
                this.O0000OOo.interrupt();
            }
            this.O0000OOo = null;
        }
        if (this.O00000oO != null) {
            this.O00000oO.removeCallbacksAndMessages(null);
            this.O00000oO = null;
        }
        if (this.O0000o00 != null) {
            this.O0000o00.O00000Oo();
        }
        if (this.O00000oo != null) {
            this.O00000oo.O0000O0o();
        }
        O00000oo();
        this.O0000Oo = true;
        O0000O0o();
    }

    public void O00000oO(bf bfVar) {
        if (this.O0000o00 != null) {
            this.O0000o00.O00000Oo(bfVar);
        }
    }

    public void O00000oO(String str) throws AMapException {
        bf O0000Oo = O0000Oo(str);
        if (O0000Oo != null) {
            O00000oo(O0000Oo);
            return;
        }
        throw new AMapException(AMapException.ERROR_INVALID_PARAMETER);
    }

    public String O00000oo(String str) {
        String str2 = "";
        if (str == null) {
            return str2;
        }
        bf O0000Oo0 = O0000Oo0(str);
        return O0000Oo0 == null ? str2 : O0000Oo0.getAdcode();
    }

    public void O0000O0o() {
        synchronized (this) {
            this.O0000Ooo = null;
        }
    }
}
