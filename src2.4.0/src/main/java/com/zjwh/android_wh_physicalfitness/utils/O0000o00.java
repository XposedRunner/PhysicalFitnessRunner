package com.zjwh.android_wh_physicalfitness.utils;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.Build.VERSION;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: BluetoothUtils */
public class O0000o00 {
    private BluetoothAdapter O000000o;
    private LeScanCallback O00000Oo;
    private O000000o O00000o;
    private ScanCallback O00000o0;
    private Timer O00000oO = new Timer();

    /* compiled from: BluetoothUtils */
    public interface O000000o {
        void O000000o(BluetoothDevice bluetoothDevice);
    }

    public O0000o00(BluetoothAdapter bluetoothAdapter) {
        this.O000000o = bluetoothAdapter;
    }

    public static boolean O000000o() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        return defaultAdapter != null && defaultAdapter.isEnabled();
    }

    public static boolean O000000o(Context context) {
        return VERSION.SDK_INT >= 18 && BluetoothAdapter.getDefaultAdapter() != null && context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    public void O000000o(O000000o o000000o) {
        this.O00000o = o000000o;
    }

    public void O00000Oo() {
        if (this.O000000o != null) {
            if (VERSION.SDK_INT >= 21) {
                BluetoothLeScanner bluetoothLeScanner = this.O000000o.getBluetoothLeScanner();
                if (bluetoothLeScanner != null) {
                    this.O00000o0 = new ScanCallback() {
                        public void onScanResult(int i, ScanResult scanResult) {
                            super.onScanResult(i, scanResult);
                            if (VERSION.SDK_INT >= 21) {
                                O0000o00.this.O00000o.O000000o(scanResult.getDevice());
                            }
                        }
                    };
                    bluetoothLeScanner.startScan(this.O00000o0);
                }
            } else if (VERSION.SDK_INT >= 18) {
                this.O00000Oo = new LeScanCallback() {
                    public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
                        if (O0000o00.this.O00000o != null) {
                            O0000o00.this.O00000o.O000000o(bluetoothDevice);
                        }
                    }
                };
                if (this.O00000oO != null) {
                    this.O00000oO.scheduleAtFixedRate(new TimerTask() {
                        public void run() {
                            if (VERSION.SDK_INT >= 18) {
                                O0000o00.this.O000000o.startLeScan(O0000o00.this.O00000Oo);
                                try {
                                    Thread.sleep(600);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                O0000o00.this.O000000o.stopLeScan(O0000o00.this.O00000Oo);
                            }
                        }
                    }, 1, 800);
                }
            }
        }
    }

    public void O00000o0() {
        if (this.O000000o != null) {
            if (VERSION.SDK_INT >= 21) {
                BluetoothLeScanner bluetoothLeScanner = this.O000000o.getBluetoothLeScanner();
                if (bluetoothLeScanner != null && this.O00000o0 != null) {
                    bluetoothLeScanner.stopScan(this.O00000o0);
                }
            } else if (VERSION.SDK_INT >= 18 && this.O00000Oo != null) {
                this.O000000o.stopLeScan(this.O00000Oo);
                if (this.O00000oO != null) {
                    this.O00000oO.cancel();
                    this.O00000oO = null;
                }
            }
        }
    }
}
