package com.zjwh.android_wh_physicalfitness.ui.run;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.LocalBroadcastManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.yalantis.ucrop.view.CropImageView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.database.FivePoint;
import com.zjwh.android_wh_physicalfitness.entity.statistics.PvDataInfoV29;
import com.zjwh.android_wh_physicalfitness.service.RunLocationService;
import com.zjwh.android_wh_physicalfitness.ui.music.MusicMainActivity;
import com.zjwh.android_wh_physicalfitness.utils.O00O00o;
import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00OO0O;
import com.zjwh.android_wh_physicalfitness.utils.O00OOOo;
import com.zjwh.android_wh_physicalfitness.utils.O00OOo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.view.dialog.O0000O0o;
import com.zjwh.android_wh_physicalfitness.view.dialog.O0000Oo;
import com.zjwh.sw.map.entity.SWLatLng;
import defpackage.gf;
import defpackage.gg;
import defpackage.ia.O000000o;
import defpackage.ia.O00000Oo;
import java.util.List;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import org.xutils.common.util.DensityUtil;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public abstract class BaseRunActivity<T extends O000000o> extends BaseActivity implements OnDismissListener, O00000Oo {
    public static final int O000000o = 1;
    public static final int O00000Oo = 2;
    protected RunOperateFragment O00000o;
    protected BaseRunFragment O00000o0;
    protected FragmentManager O00000oO;
    protected T O00000oo;
    protected boolean O0000O0o = true;
    protected WakeLock O0000OOo = null;
    protected Handler O0000Oo = new Handler();
    protected Vibrator O0000Oo0 = null;
    protected Runnable O0000o;
    protected O0000O0o O0000oO;
    protected long[] O0000oO0 = new long[]{100, 400, 100, 400};
    protected Handler O0000oOO;
    protected Runnable O0000oOo;
    @ViewInject(2131296873)
    private View O0000oo;
    @ViewInject(2131297016)
    private View O0000oo0;
    private Dialog O0000ooO = null;
    private O0000Oo O0000ooo;
    private O0000Oo O000O00o;
    private LocalBroadcastManager O000O0OO;
    private BroadcastReceiver O000O0Oo;
    private boolean O00oOoOo = true;
    private O0000Oo O00oOooO;
    private O0000Oo O00oOooo;

    /* renamed from: com.zjwh.android_wh_physicalfitness.ui.run.BaseRunActivity$10 */
    class AnonymousClass10 implements OnClickListener {
        final /* synthetic */ boolean O000000o;
        final /* synthetic */ boolean O00000Oo;

        AnonymousClass10(boolean z, boolean z2) {
            this.O000000o = z;
            this.O00000Oo = z2;
        }

        public void onClick(View view) {
            int i = this.O000000o ? gg.O000OooO : this.O00000Oo ? gg.O000o0 : gg.O000o00;
            O00Oo0.O000000o(i, O00Oo0.O0000oO());
            if (this.O00000Oo) {
                O00O0Oo0.O000000o(RunLocationService.O0000O0o, Long.valueOf(System.currentTimeMillis()));
                BaseRunActivity.this.O0000o0().O0000oo0();
            }
            BaseRunActivity.this.O0000o0().O0000O0o();
            BaseRunActivity.this.O0000o0().O0000OOo();
            BaseRunActivity.this.finish();
        }
    }

    /* renamed from: com.zjwh.android_wh_physicalfitness.ui.run.BaseRunActivity$11 */
    class AnonymousClass11 implements OnClickListener {
        final /* synthetic */ boolean O000000o;
        final /* synthetic */ boolean O00000Oo;

        AnonymousClass11(boolean z, boolean z2) {
            this.O000000o = z;
            this.O00000Oo = z2;
        }

        public void onClick(View view) {
            int i = this.O000000o ? gg.O000Oooo : this.O00000Oo ? gg.O000o00o : gg.O000o00O;
            O00Oo0.O000000o(i, O00Oo0.O0000oO());
            BaseRunActivity.this.O0000o0().O0000oOo();
        }
    }

    /* renamed from: com.zjwh.android_wh_physicalfitness.ui.run.BaseRunActivity$5 */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ String O000000o;

        AnonymousClass5(String str) {
            this.O000000o = str;
        }

        public void run() {
            if (BaseRunActivity.this.O00000o0 != null) {
                BaseRunActivity.this.O00000o0.O000000o(this.O000000o);
            }
            if (BaseRunActivity.this.O00000o != null) {
                BaseRunActivity.this.O00000o.O000000o(this.O000000o);
            }
        }
    }

    /* renamed from: com.zjwh.android_wh_physicalfitness.ui.run.BaseRunActivity$6 */
    class AnonymousClass6 implements Runnable {
        final /* synthetic */ String O000000o;

        AnonymousClass6(String str) {
            this.O000000o = str;
        }

        public void run() {
            if (BaseRunActivity.this.O00000o0 != null) {
                BaseRunActivity.this.O00000o0.O00000o(this.O000000o);
            }
            if (BaseRunActivity.this.O00000o != null) {
                BaseRunActivity.this.O00000o.O00000o(this.O000000o);
            }
        }
    }

    /* renamed from: com.zjwh.android_wh_physicalfitness.ui.run.BaseRunActivity$7 */
    class AnonymousClass7 implements Runnable {
        final /* synthetic */ int O000000o;
        final /* synthetic */ int O00000Oo;

        AnonymousClass7(int i, int i2) {
            this.O000000o = i;
            this.O00000Oo = i2;
        }

        public void run() {
            if (BaseRunActivity.this.O00000o0 != null) {
                BaseRunActivity.this.O00000o0.O00000Oo(this.O000000o, this.O00000Oo);
            }
            if (BaseRunActivity.this.O00000o != null) {
                BaseRunActivity.this.O00000o.O00000Oo(this.O000000o, this.O00000Oo);
            }
        }
    }

    static {
        C.i(16777359);
    }

    @TargetApi(21)
    private void O00000Oo(final boolean z) {
        float hypot = (float) Math.hypot((double) this.O0000oo0.getHeight(), (double) this.O0000oo0.getWidth());
        float f = z ? hypot : CropImageView.DEFAULT_ASPECT_RATIO;
        if (z) {
            hypot = CropImageView.DEFAULT_ASPECT_RATIO;
        }
        if (!isFinishing()) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(this.O0000oo0, DensityUtil.getScreenWidth() - DensityUtil.dip2px(40.0f), DensityUtil.dip2px(50.0f), f, hypot);
            createCircularReveal.setDuration(400);
            createCircularReveal.setInterpolator(new AccelerateDecelerateInterpolator());
            createCircularReveal.addListener(new AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    BaseRunActivity.this.runOnUiThread(new Runnable() {
                        public void run() {
                            if (!BaseRunActivity.this.isFinishing()) {
                                BaseRunActivity.this.O0000oo0.setVisibility(z ? 8 : 0);
                            }
                        }
                    });
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }
            });
            if (!isFinishing()) {
                createCircularReveal.start();
            }
        }
    }

    private void O0000oo() {
        this.O0000Oo0 = (Vibrator) getApplicationContext().getSystemService("vibrator");
        PowerManager powerManager = (PowerManager) getApplicationContext().getSystemService("power");
        if (powerManager != null) {
            this.O0000OOo = powerManager.newWakeLock(6, ":screenLock");
            this.O0000OOo.setReferenceCounted(false);
        }
    }

    private void O0000oo0() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(AutoFixActivity.O000000o);
        intentFilter.addAction(AutoFixActivity.O00000o);
        this.O000O0Oo = O0000o0().O0000oOO();
        this.O000O0OO = LocalBroadcastManager.getInstance(this);
        this.O000O0OO.registerReceiver(this.O000O0Oo, intentFilter);
    }

    @Event({2131296353})
    private void onClick(View view) {
        if (!O00OOo0.O000000o()) {
            O00OO0O.O000000o(new PvDataInfoV29(gf.O000O0oO, "run_to_start_music"));
            MusicMainActivity.O000000o((Activity) this);
        }
    }

    public native int O000000o();

    public void O000000o(double d, double d2, float f) {
        if (this.O00000o0 != null) {
            this.O00000o0.O000000o(d, d2, f);
        }
    }

    public native void O000000o(int i);

    public native void O000000o(int i, int i2);

    public native void O000000o(Intent intent, ServiceConnection serviceConnection);

    public native void O000000o(ServiceConnection serviceConnection);

    public native void O000000o(SWLatLng sWLatLng);

    public void O000000o(SWLatLng sWLatLng, SWLatLng sWLatLng2, double d, int i, double d2, double d3, int i2) {
        if (this.O00000o0 != null) {
            this.O00000o0.O000000o(sWLatLng, sWLatLng2, d, i, d2, d3, i2);
        }
    }

    public native void O000000o(String str);

    public native void O000000o(String str, boolean z);

    public void O000000o(List<FivePoint> list, SWLatLng sWLatLng) {
        if (!O0000o0().O000000o(30005)) {
            O0000o0().O00000oO();
        }
    }

    public native void O000000o(boolean z);

    public native void O000000o(boolean z, boolean z2);

    public native void O00000Oo();

    public native void O00000Oo(String str);

    public void O00000o() {
        O00Oo0.O000000o(this.O0000o0, gf.O00000oO);
        this.O0000oO = new O0000O0o(this);
        this.O0000oO.setCancelable(false);
        this.O0000oO.setCanceledOnTouchOutside(false);
        this.O0000oO.show();
        if (this.O0000oOO == null) {
            this.O0000oOO = new Handler();
        }
        if (this.O0000oOo == null) {
            this.O0000oOo = new Runnable() {
                public void run() {
                    if (!BaseRunActivity.this.isFinishing()) {
                        if (BaseRunActivity.this.O0000oO.isShowing()) {
                            BaseRunActivity.this.O0000oO.cancel();
                        }
                        if (((Boolean) O00O0Oo0.O00000o0(gg.O000000o, Boolean.valueOf(true))).booleanValue()) {
                            BaseRunActivity.this.O0000oO0();
                            O00O0Oo0.O000000o(gg.O000000o, Boolean.valueOf(false));
                        } else if (BaseRunActivity.this.O0000o0().O0000o0()) {
                            BaseRunActivity.this.O0000o0o();
                        }
                    }
                }
            };
        }
        this.O0000oOO.postDelayed(this.O0000oOo, 3000);
    }

    public native void O00000o0(String str);

    public native void O00000oO();

    public native void O00000oO(int i);

    public native void O00000oo();

    public native void O0000O0o();

    public native void O0000OOo();

    public native void O0000Oo0();

    public native void O0000Ooo();

    public native void O0000o();

    public abstract T O0000o0();

    public abstract void O0000o0O();

    public native void O0000o0o();

    public native boolean O0000oO();

    public native void O0000oO0();

    public native void O0000oOO();

    @PermissionFail(requestCode = 101)
    public void O0000oOo() {
        O00O00o.O000000o(this, 101);
    }

    public native void finish();

    public void n_() {
    }

    public native void onActivityResult(int i, int i2, Intent intent);

    public native void onConfigurationChanged(Configuration configuration);

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O00OOOo.O00000o0((Activity) this, null);
        O000000o O0000o0 = O0000o0();
        if (bundle == null) {
            bundle = getIntent().getExtras();
        }
        O0000o0.O000000o(bundle);
    }

    public native void onDestroy();

    public native void onDismiss(DialogInterface dialogInterface);

    public native boolean onKeyDown(int i, KeyEvent keyEvent);

    public native void onPause();

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        PermissionGen.onRequestPermissionsResult((Activity) this, i, strArr, iArr);
    }

    /* Access modifiers changed, original: protected */
    public void onResume() {
        super.onResume();
        this.O0000O0o = true;
        if (this.O00oOoOo) {
            if (O0000o0().O00000o0()) {
                this.O00000oO = getSupportFragmentManager();
                this.O00000o0 = (BaseRunFragment) this.O00000oO.findFragmentById(R.id.run_fragment);
                this.O00000o = (RunOperateFragment) this.O00000oO.findFragmentById(R.id.operate_fragment);
                O0000oo();
                O0000oo0();
                this.O00oOoOo = false;
                O00O00o.O00000o0((Activity) this);
            } else {
                O00000oO();
                return;
            }
        }
        try {
            if (this.O0000OOo != null) {
                this.O0000OOo.acquire(1800000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        O0000o0().O000000o();
    }

    public native void onSaveInstanceState(Bundle bundle);
}
