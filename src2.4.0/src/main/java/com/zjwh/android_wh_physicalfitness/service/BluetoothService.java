package com.zjwh.android_wh_physicalfitness.service;

import android.app.Service;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager.WakeLock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.alibaba.wireless.security.jaq.SecurityCipher;
import com.google.gson.reflect.TypeToken;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.database.BluetoothDeviceBean;
import com.zjwh.android_wh_physicalfitness.entity.database.BluetoothSignBean;
import com.zjwh.android_wh_physicalfitness.entity.request.BluetoothUploadInfo;
import com.zjwh.android_wh_physicalfitness.entity.request.BluetoothUploadInfoItem;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O0000o00;
import com.zjwh.android_wh_physicalfitness.utils.O000o000;
import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import defpackage.gj;
import defpackage.gk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.DbManager;
import org.xutils.common.Callback.CancelledException;
import org.xutils.ex.DbException;
import s.h.e.l.l.C;

public class BluetoothService extends Service {
    public static final String O000000o = "bluetooth_sign_device";
    Runnable O00000Oo = new Runnable() {
        public void run() {
            try {
                BluetoothService.this.O0000oOO = BluetoothService.this.O0000oOO + 1;
                if (BluetoothService.this.O0000o0O) {
                    BluetoothService.this.O0000oOo = BluetoothService.this.O0000oOo + 1;
                }
                if (BluetoothService.this.O00000o != null) {
                    BluetoothService.this.O00000o.O000000o(BluetoothService.this.O0000oOo);
                }
                if ((!BluetoothService.this.O0000o0o || BluetoothService.this.O0000oOO % 10 == 0) && BluetoothService.this.O0000o0) {
                    BluetoothService.this.O0000oOO = 0;
                    BluetoothService.this.O00000oo();
                }
                if (BluetoothService.this.O0000Ooo) {
                    BluetoothService.this.O0000oo = BluetoothService.this.O0000oo + 1;
                    if (BluetoothService.this.O00000o != null && BluetoothService.this.O0000oo % 60 == 0) {
                        BluetoothService.this.O00000o.O000000o(BluetoothService.this.O0000oo / 60, true);
                    }
                } else {
                    if (BluetoothService.this.O0000o % 180 == 0 && BluetoothService.this.O0000o00) {
                        if (BluetoothService.this.O0000OOo == null) {
                            BluetoothService.this.O00000o0.postDelayed(BluetoothService.this.O00000Oo, 1000);
                            return;
                        }
                        BluetoothService.this.O0000O0o();
                    }
                    if (BluetoothService.this.O0000o00) {
                        BluetoothService.this.O0000o = BluetoothService.this.O0000o + 1;
                    }
                    if ((BluetoothService.this.O0000oO0 + (BluetoothService.this.O0000oOo * 1000)) - BluetoothService.this.O0000oO > 0 && BluetoothService.this.O0000oO0 > 0 && BluetoothService.this.O0000oO > 0) {
                        BluetoothService.this.O0000OOo();
                    }
                }
            } catch (DbException e) {
                e.printStackTrace();
            }
            BluetoothService.this.O00000o0.postDelayed(BluetoothService.this.O00000Oo, 1000);
        }
    };
    private O00000Oo O00000o;
    private Handler O00000o0 = new Handler();
    private O0000o00 O00000oO;
    private DbManager O00000oo;
    private WakeLock O0000O0o = null;
    private BluetoothSignBean O0000OOo;
    private List<String> O0000Oo = new ArrayList();
    private HashMap<String, Integer> O0000Oo0;
    private boolean O0000OoO = true;
    private boolean O0000Ooo;
    private long O0000o;
    private boolean O0000o0;
    private boolean O0000o00;
    private boolean O0000o0O;
    private boolean O0000o0o = false;
    private long O0000oO;
    private long O0000oO0;
    private long O0000oOO;
    private long O0000oOo;
    private long O0000oo;
    private long O0000oo0;
    private com.zjwh.android_wh_physicalfitness.utils.O0000o00.O000000o O0000ooO = new com.zjwh.android_wh_physicalfitness.utils.O0000o00.O000000o() {
        public void O000000o(BluetoothDevice bluetoothDevice) {
            BluetoothService.this.O0000Oo.add(bluetoothDevice.getAddress());
        }
    };

    public class O000000o extends Binder {
        public BluetoothService O000000o() {
            return BluetoothService.this;
        }
    }

    public interface O00000Oo {
        void O000000o(long j);

        void O000000o(long j, boolean z);

        void O000000o(boolean z);

        void O00000Oo(long j);
    }

    static {
        C.i(16777314);
    }

    private void O000000o(long j, long j2, boolean z) throws DbException {
        ArrayList arrayList = new ArrayList();
        long j3 = j2 - j;
        int i = 180000;
        int i2 = ((int) j3) / 180000;
        int i3 = (j3 > 180000 ? 1 : (j3 == 180000 ? 0 : -1));
        int i4 = 1;
        if (i3 <= 0) {
            i2 = 1;
        } else if (z) {
            i2++;
        }
        long validTime = this.O0000OOo.getValidTime();
        long j4 = j;
        while (i4 <= i2) {
            long j5 = j + ((long) (i4 * i));
            long j6 = j5 >= j2 ? j2 : j5;
            List list = BluetoothDeviceBean.getList(j4, j6, this.O0000OOo.getRecordId());
            BluetoothUploadInfoItem bluetoothUploadInfoItem = r13;
            BluetoothUploadInfoItem bluetoothUploadInfoItem2 = new BluetoothUploadInfoItem(j6, j4, this.O0000OOo.getRecordId(), O00Oo0.O0000Oo0(), list);
            arrayList.add(bluetoothUploadInfoItem);
            if (list != null && list.size() > 0) {
                validTime += 3;
            }
            i4++;
            j4 = j6;
            i = 180000;
        }
        gj gjVar = new gj(gk.O000oO0O);
        gjVar.setBodyContent(O000o000.O000000o().toJson(new BluetoothUploadInfo(arrayList)));
        final long j7 = validTime;
        final long j8 = j4;
        final long j9 = j2;
        final boolean z2 = z;
        HttpUtil.postOp(this, gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
                if (BluetoothService.this.O00000o != null) {
                    BluetoothService.this.O00000o.O000000o(j7, false);
                }
            }

            public void onFinished() {
            }

            public void onSuccess(String str) {
                try {
                    BluetoothService.this.O0000OOo.setValidTime(j7);
                    BluetoothService.this.O0000OOo.setLastUploadTime(j8);
                    BluetoothService.this.O0000Ooo().saveOrUpdate(BluetoothService.this.O0000OOo);
                    BluetoothService.this.O0000oo0 = j9;
                    if (BluetoothService.this.O00000o != null) {
                        BluetoothService.this.O00000o.O000000o(j7, true);
                    }
                    BluetoothDeviceBean.cleanOldData(j9, BluetoothService.this.O0000OOo.getRecordId());
                    if ((new JSONObject(str).getBoolean("isFinished") || z2) && BluetoothService.this.O0000o00) {
                        BluetoothService.this.O0000o00 = false;
                        BluetoothService.this.O000000o(false);
                        if (BluetoothService.this.O00000o != null) {
                            BluetoothService.this.O00000o.O00000Oo(BluetoothService.this.O0000OOo.getValidTime());
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (DbException e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    private synchronized void O00000oo() throws DbException {
        boolean z = false;
        if (this.O0000Oo0 != null) {
            for (Entry entry : this.O0000Oo0.entrySet()) {
                for (String equalsIgnoreCase : this.O0000Oo) {
                    if (equalsIgnoreCase.equalsIgnoreCase((String) entry.getKey())) {
                        z = true;
                        if (this.O0000o00) {
                            O0000Ooo().saveBindingId(new BluetoothDeviceBean(((Integer) entry.getValue()).intValue(), this.O0000oO0 + (this.O0000oOo * 1000), this.O0000OOo.getRecordId()));
                        }
                    }
                }
            }
        }
        this.O0000o0o = z;
        this.O0000Oo.clear();
        if (this.O00000o != null) {
            this.O00000o.O000000o(z);
        }
    }

    private void O0000O0o() throws DbException {
        if (this.O0000o == 0) {
            this.O0000oo0 = this.O0000OOo.getLastUploadTime() == 0 ? this.O0000oO0 + (this.O0000oOo * 1000) : this.O0000OOo.getLastUploadTime();
            this.O0000OOo.setLastUploadTime(this.O0000oo0);
            O0000Ooo().saveOrUpdate(this.O0000OOo);
            return;
        }
        O000000o(this.O0000OOo.getLastUploadTime(), this.O0000oO0 + (this.O0000oOo * 1000), false);
    }

    private void O0000OOo() throws DbException {
        if (this.O0000o00) {
            this.O0000o00 = false;
            O000000o(this.O0000OOo.getLastUploadTime(), this.O0000oO0 + (this.O0000oOo * 1000), true);
        } else if (this.O00000o != null) {
            this.O00000o.O00000Oo(this.O0000OOo != null ? this.O0000OOo.getValidTime() : 0);
        }
    }

    private synchronized void O0000Oo() {
        if (this.O0000O0o != null && this.O0000O0o.isHeld()) {
            try {
                this.O0000O0o.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.O0000O0o = null;
        }
    }

    /* JADX WARNING: Missing block: B:14:0x0029, code skipped:
            return;
     */
    private synchronized void O0000Oo0() {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.O0000O0o;	 Catch:{ all -> 0x002a }
        if (r0 != 0) goto L_0x0028;
    L_0x0005:
        r0 = "power";
        r0 = r3.getSystemService(r0);	 Catch:{ all -> 0x002a }
        r0 = (android.os.PowerManager) r0;	 Catch:{ all -> 0x002a }
        if (r0 != 0) goto L_0x0011;
    L_0x000f:
        monitor-exit(r3);
        return;
    L_0x0011:
        r1 = 536870913; // 0x20000001 float:1.0842023E-19 double:2.652494744E-315;
        r2 = ":BluetoothService";
        r0 = r0.newWakeLock(r1, r2);	 Catch:{ all -> 0x002a }
        r3.O0000O0o = r0;	 Catch:{ all -> 0x002a }
        r0 = r3.O0000O0o;	 Catch:{ all -> 0x002a }
        if (r0 == 0) goto L_0x0028;
    L_0x0020:
        r0 = r3.O0000O0o;	 Catch:{ all -> 0x002a }
        r1 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        r0.acquire(r1);	 Catch:{ all -> 0x002a }
    L_0x0028:
        monitor-exit(r3);
        return;
    L_0x002a:
        r0 = move-exception;
        monitor-exit(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zjwh.android_wh_physicalfitness.service.BluetoothService.O0000Oo0():void");
    }

    private void O0000OoO() {
        if (this.O0000Oo0 == null) {
            try {
                String str = (String) O00O0Oo0.O00000o0(O000000o, "");
                if (!TextUtils.isEmpty(str)) {
                    String decryptString = new SecurityCipher(getApplicationContext()).decryptString(str, getString(R.string.ali_app_key));
                    if (TextUtils.isEmpty(str)) {
                        this.O0000Oo0 = new HashMap();
                    } else {
                        this.O0000Oo0 = (HashMap) O000o000.O000000o().fromJson(decryptString, new TypeToken<HashMap<String, Integer>>() {
                        }.getType());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private native DbManager O0000Ooo();

    private native void O0000o00();

    public void O000000o(long j) {
        this.O0000o0O = true;
        this.O0000oOo = 0;
        this.O0000oO0 = j;
    }

    public void O000000o(O00000Oo o00000Oo) {
        this.O00000o = o00000Oo;
    }

    public native void O000000o(boolean z);

    public native boolean O000000o();

    public long O00000Oo() {
        return this.O0000oo0;
    }

    public void O00000Oo(long j) {
        this.O0000oO = j;
    }

    public native void O00000o();

    public native void O00000o0();

    public void O00000o0(long j) {
        this.O0000Ooo = false;
        this.O0000oo = 0;
        if (!this.O0000o00) {
            this.O0000o00 = true;
            try {
                if (this.O0000OOo == null) {
                    this.O0000OOo = BluetoothSignBean.getBean(j);
                }
            } catch (DbException e) {
                e.printStackTrace();
            }
        }
    }

    public native boolean O00000oO();

    @Nullable
    public IBinder onBind(Intent intent) {
        this.O00000Oo.run();
        return new O000000o();
    }

    public native void onCreate();

    public native void onDestroy();

    public native int onStartCommand(Intent intent, int i, int i2);

    public native boolean onUnbind(Intent intent);
}
