package com.zjwh.android_wh_physicalfitness.activity.mine;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.maps.MapView;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.media.O0000Oo;
import com.yalantis.ucrop.UCrop;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.MultiImageSelectorActivity;
import com.zjwh.android_wh_physicalfitness.activity.WebViewActivity;
import com.zjwh.android_wh_physicalfitness.activity.appeal.AppealActivity;
import com.zjwh.android_wh_physicalfitness.activity.appeal.MyAppealInfoActivity;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseShareActivity;
import com.zjwh.android_wh_physicalfitness.entity.ActivityTipBean;
import com.zjwh.android_wh_physicalfitness.entity.DrawWinBean;
import com.zjwh.android_wh_physicalfitness.entity.GetDrawChanceBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.SportMoodMatchBean;
import com.zjwh.android_wh_physicalfitness.entity.database.UserInfo;
import com.zjwh.android_wh_physicalfitness.entity.statistics.PvDataInfo;
import com.zjwh.android_wh_physicalfitness.entity.statistics.PvDataInfoV29;
import com.zjwh.android_wh_physicalfitness.utils.O00000o;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o0;
import com.zjwh.android_wh_physicalfitness.utils.O00O00o;
import com.zjwh.android_wh_physicalfitness.utils.O00O0O0o;
import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00O0o0;
import com.zjwh.android_wh_physicalfitness.utils.O00OO0O;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o.O00000o0;
import com.zjwh.android_wh_physicalfitness.view.MyLinearLayout;
import com.zjwh.android_wh_physicalfitness.view.dialog.LotteryDialog;
import com.zjwh.android_wh_physicalfitness.view.dialog.MyDrawWinDialog;
import com.zjwh.android_wh_physicalfitness.view.dialog.MyPrizeResultDialog;
import com.zjwh.android_wh_physicalfitness.view.dialog.SportMoodAddDialog;
import com.zjwh.android_wh_physicalfitness.view.dialog.SportMoodShareDialog;
import com.zjwh.sw.map.entity.SWFixedPoint;
import com.zjwh.sw.map.entity.SWLatLng;
import defpackage.by;
import defpackage.dn;
import defpackage.gf;
import defpackage.gg;
import defpackage.hk.O000000o;
import defpackage.hk.O00000Oo;
import defpackage.ig;
import defpackage.js;
import defpackage.lo;
import defpackage.ly;
import java.util.List;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class RunHistoryDetailActivity extends BaseShareActivity implements O00000Oo {
    public static final int O000000o = 1000;
    public static final String O00000Oo = "extra_sports_type";
    public static final String O00000o = "extra_need_show_share_dialog";
    public static final String O00000o0 = "extra_has_draw_chance";
    @ViewInject(2131296690)
    public ImageView O00000oO;
    @ViewInject(2131297371)
    public TextView O00000oo;
    @ViewInject(2131297343)
    public TextView O0000O0o;
    @ViewInject(2131297424)
    public TextView O0000OOo;
    @ViewInject(2131297408)
    public TextView O0000Oo;
    @ViewInject(2131297352)
    public TextView O0000Oo0;
    @ViewInject(2131297317)
    public TextView O0000o;
    Handler O0000oO = new Handler();
    @ViewInject(2131297332)
    public TextView O0000oO0;
    Runnable O0000oOO = new Runnable() {
        public void run() {
            RunHistoryDetailActivity.this.O00000o().O0000Oo0();
        }
    };
    Runnable O000O00o = new Runnable() {
        public void run() {
            RunHistoryDetailActivity.this.O00000o().O00000o0();
        }
    };
    @ViewInject(2131296734)
    private View O000O0OO;
    @ViewInject(2131296777)
    private MyLinearLayout O000O0Oo;
    @ViewInject(2131296360)
    private Button O000O0o;
    @ViewInject(2131296983)
    private LinearLayout O000O0o0;
    @ViewInject(2131296306)
    private TextView O000O0oO;
    @ViewInject(2131297000)
    private RelativeLayout O000O0oo;
    @ViewInject(2131296942)
    private RecyclerView O000OO;
    @ViewInject(2131296554)
    private LinearLayout O000OO00;
    @ViewInject(2131297411)
    private TextView O000OO0o;
    @ViewInject(2131296847)
    private MapView O000OOOo;
    @ViewInject(2131297298)
    private TextView O000OOo;
    @ViewInject(2131297278)
    private TextView O000OOo0;
    private float O000OOoO;
    private lo O000OOoo;
    private dn O000Oo0;
    private O000000o O000Oo00;
    private LotteryDialog O000Oo0O;
    private MyDrawWinDialog O000Oo0o;
    private SportMoodAddDialog O000OoO0;
    private SportMoodShareDialog O00O0Oo;
    @ViewInject(2131296345)
    private View O00oOoOo;
    Handler O00oOooo = new Handler();

    /* renamed from: com.zjwh.android_wh_physicalfitness.activity.mine.RunHistoryDetailActivity$2 */
    class AnonymousClass2 implements ly {
        final /* synthetic */ int O000000o;

        AnonymousClass2(int i) {
            this.O000000o = i;
        }

        public void O000000o(Bitmap bitmap) {
            by byVar;
            String str = "";
            by byVar2 = null;
            switch (this.O000000o) {
                case 0:
                    str = RunHistoryDetailActivity.this.getString(R.string.umeng_socialize_text_wechat_no_install);
                    byVar2 = by.WEIXIN;
                    byVar = by.WEIXIN;
                    break;
                case 1:
                    str = RunHistoryDetailActivity.this.getString(R.string.umeng_socialize_text_wechat_no_install);
                    byVar2 = by.WEIXIN_CIRCLE;
                    byVar = by.WEIXIN;
                    break;
                case 2:
                    str = RunHistoryDetailActivity.this.getString(R.string.umeng_socialize_text_qq_no_install);
                    byVar2 = by.QQ;
                    byVar = by.QQ;
                    break;
                case 3:
                    str = RunHistoryDetailActivity.this.getString(R.string.umeng_socialize_text_qq_no_install);
                    byVar2 = by.QZONE;
                    byVar = by.QQ;
                    break;
                case 4:
                    str = RunHistoryDetailActivity.this.getString(R.string.umeng_socialize_text_sina_no_install);
                    byVar2 = by.SINA;
                    byVar = by.SINA;
                    break;
                default:
                    byVar = null;
                    break;
            }
            if (byVar == null || UMShareAPI.get(RunHistoryDetailActivity.this.getApplicationContext()).isInstall(RunHistoryDetailActivity.this, byVar)) {
                if (byVar2 != null) {
                    new ShareAction(RunHistoryDetailActivity.this).setPlatform(byVar2).setCallback(RunHistoryDetailActivity.this.O00oOooO).withText(RunHistoryDetailActivity.this.getResources().getString(R.string.banner_txt_1)).withMedia(new O0000Oo(RunHistoryDetailActivity.this.O0000o0, bitmap)).share();
                }
                return;
            }
            O00Oo00.O000000o(RunHistoryDetailActivity.this.O0000o0, str);
        }
    }

    static {
        C.i(16777311);
    }

    public static void O000000o(Activity activity, int i, GetDrawChanceBean getDrawChanceBean, boolean z, int i2) {
        O000000o(activity, i, getDrawChanceBean, z, i2, "");
    }

    public static void O000000o(Activity activity, int i, GetDrawChanceBean getDrawChanceBean, boolean z, int i2, String str) {
        O000000o(activity, i, getDrawChanceBean, z, i2, str, -1);
    }

    public static native void O000000o(Activity activity, int i, GetDrawChanceBean getDrawChanceBean, boolean z, int i2, String str, int i3);

    public static void O000000o(Activity activity, int i, String str, boolean z) {
        O000000o(activity, -1, null, z, i, str);
    }

    public static native void O000000o(Activity activity, int i, boolean z);

    public static native void O000000o(Activity activity, int i, boolean z, int i2);

    private native void O000000o(Bundle bundle);

    private void O0000oo() {
        try {
            if (this.O000Oo0O != null && this.O000Oo0O.getDialog() != null && this.O000Oo0O.getDialog().isShowing()) {
                this.O000Oo0O.dismiss();
                this.O000Oo0O = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private native void O0000oo0();

    private void O0000ooO() {
        try {
            if (this.O000Oo0o != null && this.O000Oo0o.getDialog() != null && this.O000Oo0o.getDialog().isShowing()) {
                this.O000Oo0o.dismiss();
                this.O000Oo0o = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void O0000ooo() {
        try {
            if (this.O000OoO0 != null) {
                this.O000OoO0.dismiss();
                this.O000OoO0 = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private native void O00oOooO();

    @Event({2131296360, 2131296404, 2131297298})
    private void clickEvent(View view) {
        int id = view.getId();
        if (id != R.id.btn_appeal) {
            if (id != R.id.check_chart) {
                if (id == R.id.tvUnCompleteTip) {
                    WebViewActivity.O000000o((Activity) this, com.zjwh.android_wh_physicalfitness.O000000o.O0000o00);
                }
            } else if (O00000o().O00000oo() <= 0) {
                O00000Oo(getString(R.string.tip), "请先上传成绩，再查看详细图表");
            } else {
                WebViewActivity.O000000o(this, com.zjwh.android_wh_physicalfitness.O000000o.O0000Ooo, O00000o().O00000oo());
            }
        } else if (O00000o().O0000O0o() == 1) {
            if (ig.O000000o(this) || ig.O00000o0(this) || ig.O00000Oo() || ig.O000000o() || ig.O00000Oo(this)) {
                O00000Oo("无法上传跑步成绩", getString(R.string.cheat_xposed_check));
                O00OO0O.O000000o(new PvDataInfo(gf.O000OOOo, gf.O000Oooo));
                return;
            }
            O00oOooO();
        } else if (O00000o().O0000O0o() == 2) {
            AppealActivity.O000000o((Activity) this, O00000o().O00000oo());
        } else if (O00000o().O0000O0o() == 3) {
            MyAppealInfoActivity.O000000o((Activity) this, O00000o().O00000oo());
        }
    }

    @Event({2131296740, 2131296369})
    private void topClickEvent(View view) {
        int id = view.getId();
        if (id == R.id.btn_share) {
            O00000o.O000000o(view, new Runnable() {
                public void run() {
                    if (!RunHistoryDetailActivity.this.isFinishing()) {
                        O00O00o.O00000oO(RunHistoryDetailActivity.this);
                    }
                }
            });
        } else if (id == R.id.left_image) {
            finish();
        }
    }

    public native int O000000o();

    public void O000000o(double d, double d2, long j, int i, long j2, boolean z, String str, int i2, String str2, String str3, List<SWLatLng> list) {
        try {
            this.O0000Oo0.setText(O00Oo0.O00000o0(d));
            this.O0000Oo.setText(O00Oo0.O0000O0o(d2));
            this.O0000o.setText(String.valueOf(i == 0 ? O00Oo0.O000000o((float) d) : i));
            this.O0000OOo.setText(O00Oo0.O000000o(j));
            this.O0000O0o.setText(O000O0o0.O000000o(O000O0o0.O0000o00, j2));
            this.O000OOo.setVisibility(z ? 8 : 0);
            this.O000OOo0.setText(str);
            this.O000OOo0.setBackgroundResource(i2);
            this.O0000oO0.setText(str2);
            UserInfo O00000o0 = O00Oo0.O00000o0();
            if (O00000o0 != null) {
                this.O00000oo.setText(O00000o0.getName());
                this.O00000oO.setVisibility(0);
                O00Oo0.O000000o(this, O00000o0.getIcon(), this.O00000oO, O00000o0.getSex());
            }
            this.O000OO0o.setText(getString(R.string.run_history_run_type, new Object[]{str3}));
            if (list.size() > 0) {
                this.O000OOoo.O000000o((List) list);
            }
            this.O00oOooo.postDelayed(this.O000O00o, 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public native void O000000o(int i);

    public native void O000000o(int i, int i2);

    public void O000000o(long j, int i, double d, double d2, long j2, int i2) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager != null) {
            this.O000OoO0 = (SportMoodAddDialog) supportFragmentManager.findFragmentByTag(SportMoodAddDialog.O000000o);
            O0000ooo();
            if (this.O000OoO0 == null) {
                this.O000OoO0 = SportMoodAddDialog.O000000o(j, i, d, d2, j2, i2);
                this.O000OoO0.O000000o(new SportMoodAddDialog.O000000o() {
                    public void O000000o() {
                        O00Oo00o.O000000o(RunHistoryDetailActivity.this, O00Oo00o.O000000o.O0000o00, O00000o0.O00000Oo);
                        O00O00o.O00000o(RunHistoryDetailActivity.this);
                    }
                });
                if (!isFinishing()) {
                    this.O000OoO0.show(getSupportFragmentManager(), SportMoodAddDialog.O000000o);
                    O00000o().O00000o();
                    O00Oo00o.O000000o(this, O00Oo00o.O000000o.O0000o00, O00000o0.O000000o);
                }
            }
        }
    }

    public void O000000o(DrawWinBean drawWinBean) {
        O0000ooO();
        O0000oo();
        if (drawWinBean != null) {
            DialogFragment O000000o = drawWinBean.isGetPrize() ? MyDrawWinDialog.O000000o(drawWinBean) : MyPrizeResultDialog.O000000o(drawWinBean);
            try {
                if (!isFinishing()) {
                    if (O000000o != null) {
                        O000000o.show(getSupportFragmentManager(), null);
                        if (drawWinBean.isGetPrize()) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(O00Oo0.O00000oO());
                            stringBuilder.append(gg.O0000ooo);
                            O00O0Oo0.O000000o(stringBuilder.toString(), Boolean.valueOf(true));
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void O000000o(DrawWinBean drawWinBean, boolean z) {
        if (drawWinBean != null) {
            this.O000Oo0o = MyDrawWinDialog.O000000o(drawWinBean);
            if (z) {
                this.O000Oo0o.O000000o(true);
                this.O000Oo0o.O000000o(new MyDrawWinDialog.O000000o() {
                    public void O000000o() {
                        O00OO0O.O000000o(new PvDataInfoV29(gf.O000OOoO, "click_sjcj"));
                        O00Oo00o.O000000o(RunHistoryDetailActivity.this.O0000o0, O00Oo00o.O000000o.O00000oO, "rbutton1");
                        RunHistoryDetailActivity.this.O000Oo0o.O00000Oo(false);
                        RunHistoryDetailActivity.this.O0000oO.post(RunHistoryDetailActivity.this.O0000oOO);
                    }
                });
                O00OO0O.O000000o(new PvDataInfoV29(gf.O000OOoO, "exposure_sjcj"));
            }
            if (!isFinishing()) {
                try {
                    this.O000Oo0o.show(getSupportFragmentManager(), null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(O00Oo0.O00000oO());
                stringBuilder.append(gg.O0000ooo);
                O00O0Oo0.O000000o(stringBuilder.toString(), Boolean.valueOf(true));
            }
        }
    }

    public native void O000000o(ResponseError responseError);

    public native void O000000o(SportMoodMatchBean sportMoodMatchBean);

    public void O000000o(SWLatLng sWLatLng) {
        try {
            this.O000OOoo.O000000o(sWLatLng);
        } catch (com.zjwh.sw.map.O00000o e) {
            e.printStackTrace();
        }
    }

    public void O000000o(SWLatLng sWLatLng, SWLatLng sWLatLng2, double d, int i, double d2, double d3, int i2) {
        try {
            this.O000OOoo.O000000o(sWLatLng, sWLatLng2, d, i, d2, d3, i2);
        } catch (com.zjwh.sw.map.O00000o e) {
            e.printStackTrace();
        }
    }

    public void O000000o(List<ActivityTipBean> list) {
        if (this.O000Oo0 != null) {
            this.O000Oo0.O000000o((List) list);
        }
    }

    public void O000000o(List<SWFixedPoint> list, int i, int i2) {
        try {
            this.O000OOoo.O000000o(list, i, i2);
        } catch (com.zjwh.sw.map.O00000o e) {
            e.printStackTrace();
        }
    }

    public native void O000000o(boolean z);

    public native void O000000o(boolean z, boolean z2, int i, String str);

    public native void O00000Oo(ResponseError responseError);

    public void O00000Oo(SWLatLng sWLatLng) {
        try {
            this.O000OOoo.O00000Oo(sWLatLng);
        } catch (com.zjwh.sw.map.O00000o e) {
            e.printStackTrace();
        }
    }

    public O000000o O00000o() {
        if (this.O000Oo00 == null) {
            this.O000Oo00 = new js(this.O0000o0, this);
        }
        return this.O000Oo00;
    }

    public native void O00000oO();

    public native void O00000oo();

    public void O0000O0o() {
        this.O000Oo0O = LotteryDialog.O000000o();
        this.O000Oo0O.O000000o(new LotteryDialog.O000000o() {
            public void O00000oo() {
                O00Oo00o.O000000o(RunHistoryDetailActivity.this.O0000o0, O00Oo00o.O000000o.O00000oO, "rbutton2");
                O00OO0O.O000000o(new PvDataInfoV29(gf.O000OOoO, "click_sjcj"));
                RunHistoryDetailActivity.this.O0000oO.postDelayed(RunHistoryDetailActivity.this.O0000oOO, 500);
            }
        });
        try {
            if (!isFinishing()) {
                O00OO0O.O000000o(new PvDataInfoV29(gf.O000OOoO, "exposure_sjcj"));
                this.O000Oo0O.show(getSupportFragmentManager(), null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public native void O0000OOo();

    public native void O0000o();

    public native void O0000o0();

    public native void O0000o0O();

    public native void O0000o0o();

    @PermissionFail(requestCode = 102)
    public void O0000oO() {
        O00O00o.O000000o(this, 102);
    }

    @PermissionSuccess(requestCode = 102)
    public void O0000oO0() {
        O0000Oo0();
    }

    @PermissionSuccess(requestCode = 100)
    public void O0000oOO() {
        O00O0o0.O000000o((Activity) this, 1, 0);
    }

    @PermissionFail(requestCode = 100)
    public void O0000oOo() {
        O00O00o.O000000o(this, 100);
    }

    public void n_() {
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1000) {
            if (i2 == 1000) {
                O00000o().O000000o(intent.getStringExtra("extra_info"));
            } else if (i2 == 1001) {
                O000000o(true);
            }
        } else if (i2 == -1) {
            if (i == 69) {
                Uri output = UCrop.getOutput(intent);
                if (output != null) {
                    O0000ooo();
                    if (this.O00O0Oo != null) {
                        this.O00O0Oo.dismiss();
                    }
                    this.O00O0Oo = O00000o().O00000Oo(output.getPath());
                    if (this.O00O0Oo != null) {
                        this.O00O0Oo.O000000o(new SportMoodShareDialog.O00000Oo() {
                            public void O000000o() {
                                O00O00o.O00000o(RunHistoryDetailActivity.this);
                                O00Oo00o.O000000o(RunHistoryDetailActivity.this, O00Oo00o.O000000o.O0000o00, O00000o0.O00000oO);
                            }

                            public void O000000o(int i, int i2) {
                                RunHistoryDetailActivity.this.O00000o().O000000o(RunHistoryDetailActivity.this.O0000o0, i, i2);
                            }

                            public void O000000o(String str) {
                                Bitmap decodeFile = BitmapFactory.decodeFile(str);
                                float height = (((float) decodeFile.getHeight()) * 1.0f) / ((float) decodeFile.getWidth());
                                decodeFile.recycle();
                                RunHistoryDetailActivity.this.O00000o().O000000o(str, RunHistoryDetailActivity.this.O0000o0, height, RunHistoryDetailActivity.this.O00000o().O00000oo());
                                O00Oo00o.O000000o(RunHistoryDetailActivity.this, O00Oo00o.O000000o.O0000o00, "share");
                            }
                        });
                        if (!isFinishing()) {
                            this.O00O0Oo.show(getSupportFragmentManager(), null);
                        }
                    }
                }
            } else if (i != 96) {
                switch (i) {
                    case 0:
                        O00O0O0o.O000000o(this.O0000o0, intent.getStringArrayListExtra(MultiImageSelectorActivity.O00000o), 1, 1);
                        break;
                    case 1:
                        O00O0O0o.O000000o(this.O0000o0, 1, 1);
                        break;
                }
            } else {
                O00Oo00.O000000o(getString(R.string.msg_set_pic_error), false);
            }
        }
    }

    public native void onConfigurationChanged(Configuration configuration);

    public native void onCreate(Bundle bundle);

    public native void onDestroy();

    public native void onPause();

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        PermissionGen.onRequestPermissionsResult((Activity) this, i, strArr, iArr);
    }

    public native void onResume();

    public native void onSaveInstanceState(Bundle bundle);

    public native void onStop();
}
