package com.zjwh.android_wh_physicalfitness.application;

import android.os.Handler;
import android.support.multidex.MultiDexApplication;
import com.alibaba.wireless.security.jaq.JAQException;
import com.alibaba.wireless.security.jaq.SecurityInit;
import com.qiyukf.unicorn.api.YSFOptions;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.view.dialog.MusicPlayerDialog;
import com.zjwh.android_wh_physicalfitness.view.dialog.O0000Oo;
import defpackage.x;
import defpackage.x.O00000Oo;
import java.util.Map;
import org.xutils.DbManager$DaoConfig;
import s.h.e.l.l.C;

public class MyApplication extends MultiDexApplication {
    public static Map<String, Long> O000000o = null;
    public static MyApplication O00000Oo = null;
    public static String O00000o0 = "000049";
    private DbManager$DaoConfig O00000o;
    private boolean O00000oO = false;

    /* renamed from: com.zjwh.android_wh_physicalfitness.application.MyApplication$5 */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ BaseActivity O000000o;
        final /* synthetic */ Handler O00000Oo;

        AnonymousClass5(BaseActivity baseActivity, Handler handler) {
            this.O000000o = baseActivity;
            this.O00000Oo = handler;
        }

        public void run() {
            if (!this.O000000o.O0000o0o) {
                this.O00000Oo.postDelayed(this, 100);
            } else if (!this.O000000o.isFinishing()) {
                new O0000Oo(this.O000000o).O000000o().O000000o("流量提醒").O00000Oo("非WIFI环境，继续播放将产生流量").O000000o("取消", null).O00000Oo("继续播放", new 1(this)).O00000Oo();
            }
        }
    }

    /* renamed from: com.zjwh.android_wh_physicalfitness.application.MyApplication$6 */
    class AnonymousClass6 implements Runnable {
        final /* synthetic */ BaseActivity O000000o;
        final /* synthetic */ Handler O00000Oo;

        AnonymousClass6(BaseActivity baseActivity, Handler handler) {
            this.O000000o = baseActivity;
            this.O00000Oo = handler;
        }

        public void run() {
            if (!this.O000000o.O0000o0o) {
                this.O00000Oo.postDelayed(this, 100);
            } else if (!this.O000000o.isFinishing()) {
                this.O000000o.j_();
            }
        }
    }

    static {
        C.i(42);
    }

    public static native MyApplication O000000o();

    private native void O00000oo();

    private native void O0000O0o();

    private native void O0000OOo();

    private native YSFOptions O0000Oo();

    private void O0000Oo0() {
        O0000OOo();
        try {
            SecurityInit.Initialize(getApplicationContext());
        } catch (JAQException e) {
            e.printStackTrace();
        }
    }

    private native boolean O0000OoO();

    private void O0000Ooo() throws Exception {
        UMConfigure.init(this, getString(2131690042), "000", 1, "");
        PlatformConfig.setWeixin(getString(2131690069), getString(2131690070));
        PlatformConfig.setQQZone(getString(2131689804), getString(2131689805));
        PlatformConfig.setSinaWeibo(getString(2131689858), getString(2131689859), "http://sns.whalecloud.com/sina2/callback");
        x.O000000o(O00000Oo.LEGACY_MANUAL);
        x.O00000Oo(false);
        UMConfigure.setLogEnabled(this.O00000oO);
        UMShareAPI.get(this);
    }

    private native void O0000o00();

    public void O000000o(String str, String str2, long j, String str3, int i, int i2, boolean z, long j2) {
        final BaseActivity baseActivity = (BaseActivity) com.zjwh.android_wh_physicalfitness.utils.O00000Oo.O00000Oo();
        if (baseActivity != null) {
            Handler handler = new Handler();
            final String str4 = str;
            final String str5 = str2;
            final long j3 = j;
            final String str6 = str3;
            final int i3 = i;
            final int i4 = i2;
            final boolean z2 = z;
            final long j4 = j2;
            final Handler handler2 = handler;
            handler.post(new Runnable() {
                public void run() {
                    if (!baseActivity.O0000o0o) {
                        handler2.postDelayed(this, 100);
                    } else if (!baseActivity.isFinishing()) {
                        MusicPlayerDialog.O000000o(str4, str5, j3, str6, i3, i4, z2, j4).show(baseActivity.getSupportFragmentManager(), MusicPlayerDialog.O000000o);
                    }
                }
            });
        }
    }

    public DbManager$DaoConfig O00000Oo() {
        return this.O00000o;
    }

    public native void O00000o();

    public native void O00000o0();

    public native void O00000oO();

    public native void onCreate();
}
