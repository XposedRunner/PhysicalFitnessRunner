package com.zjwh.android_wh_physicalfitness.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.application.MyApplication;
import com.zjwh.android_wh_physicalfitness.entity.AdModuleBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.database.ChatFriendBean;
import com.zjwh.android_wh_physicalfitness.entity.database.UserInfo;
import com.zjwh.android_wh_physicalfitness.entity.statistics.PvDataInfoV29;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O00000Oo;
import com.zjwh.android_wh_physicalfitness.utils.O00000o0;
import com.zjwh.android_wh_physicalfitness.utils.O000OO0o;
import com.zjwh.android_wh_physicalfitness.utils.O000o0;
import com.zjwh.android_wh_physicalfitness.utils.O000o000;
import com.zjwh.android_wh_physicalfitness.utils.O00O00o;
import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00OO0O;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o.O000000o;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0o0;
import com.zjwh.android_wh_physicalfitness.view.dialog.O0000Oo;
import defpackage.O00Oo;
import defpackage.gf;
import defpackage.gj;
import defpackage.gk;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback.Cancelable;
import org.xutils.common.Callback.CancelledException;
import s.h.e.l.l.C;

public class SplashActivity extends Activity {
    public static final String O000000o = "data";
    private View O00000Oo;
    private ImageView O00000o;
    private ImageView O00000o0;
    private TextView O00000oO;
    private TextView O00000oo;
    private TextView O0000O0o;
    private Cancelable O0000OOo;
    private Runnable O0000Oo;
    private Handler O0000Oo0 = new Handler();
    private O00Oo0o0 O0000OoO;
    private Runnable O0000Ooo;
    private boolean O0000o = false;
    private String O0000o0;
    private ChatFriendBean O0000o00;
    private String O0000o0O;
    private boolean O0000o0o = false;
    private O0000Oo O0000oO;
    private long O0000oO0 = 3000;
    private boolean O0000oOO = false;

    static {
        C.i(16777289);
    }

    private void O000000o(int i) {
        O00OO0O.O000000o(new PvDataInfoV29(50000, "splash_load_iydsj"));
        gj gjVar = new gj(gk.O00O000o);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", 1);
            jSONObject.put("unid", i);
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.O0000OOo = HttpUtil.post(MyApplication.O000000o(), gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
            }

            public void onFinished() {
            }

            public void onSuccess(String str) {
                final AdModuleBean adModuleBean = (AdModuleBean) O000o000.O000000o().fromJson(str, AdModuleBean.class);
                if (adModuleBean != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(gf.O000o00);
                    stringBuilder.append(adModuleBean.getId());
                    O00OO0O.O000000o(new PvDataInfoV29(50000, stringBuilder.toString()));
                    SplashActivity.this.O0000Oo0.removeCallbacks(SplashActivity.this.O0000Oo);
                    SplashActivity.this.O0000Ooo = new Runnable() {
                        public void run() {
                            if (!SplashActivity.this.isFinishing()) {
                                SplashActivity.this.O0000oO0 = SplashActivity.this.O0000oO0 - 1000;
                                SplashActivity.this.O00000oO.setText(String.format(Locale.CHINA, "跳过 %1$ds", new Object[]{Long.valueOf(SplashActivity.this.O0000oO0 / 1000)}));
                                if (SplashActivity.this.O0000oO0 <= 0) {
                                    SplashActivity.this.O0000OOo();
                                } else {
                                    SplashActivity.this.O0000OoO.O00000Oo(SplashActivity.this.O0000Ooo, 1000);
                                }
                            }
                        }
                    };
                    if (SplashActivity.this.O0000OoO != null) {
                        SplashActivity.this.O0000OoO.O00000Oo(SplashActivity.this.O0000Ooo, 1000);
                    }
                    SplashActivity.this.O00000Oo.setVisibility(0);
                    String imageUrl = adModuleBean.getImageUrl();
                    if (!TextUtils.isEmpty(imageUrl)) {
                        O00Oo.O000000o(SplashActivity.this).O000000o(imageUrl).O000000o(SplashActivity.this.O00000o0);
                        SplashActivity splashActivity = SplashActivity.this;
                        String str2 = O000000o.O000000o;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(gf.O000o00);
                        stringBuilder.append(adModuleBean.getId());
                        O00Oo00o.O000000o(splashActivity, str2, stringBuilder.toString());
                    }
                    imageUrl = adModuleBean.getLogoUrl();
                    if (!TextUtils.isEmpty(imageUrl)) {
                        O00Oo.O000000o(SplashActivity.this).O000000o(imageUrl).O000000o(SplashActivity.this.O00000o);
                    }
                    if (!TextUtils.isEmpty(adModuleBean.getAdExposingCodes())) {
                        O00000o0.O00000Oo(adModuleBean.getAdExposingCodes());
                    }
                    SplashActivity.this.O00000oo.setText(TextUtils.isEmpty(adModuleBean.getTitle()) ? SplashActivity.this.getString(2131689512) : adModuleBean.getTitle());
                    SplashActivity.this.O0000O0o.setText(TextUtils.isEmpty(adModuleBean.getSubTitle()) ? SplashActivity.this.getString(R.string.txt_run_young) : adModuleBean.getSubTitle());
                    SplashActivity.this.O00000o0.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            if (!SplashActivity.this.O0000o0o) {
                                SplashActivity.this.O0000o0o = true;
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(gf.O000o00O);
                                stringBuilder.append(adModuleBean.getId());
                                O00OO0O.O000000o(new PvDataInfoV29(50000, stringBuilder.toString()));
                                SplashActivity splashActivity = SplashActivity.this;
                                String str = O000000o.O000000o;
                                stringBuilder = new StringBuilder();
                                stringBuilder.append(gf.O000o00O);
                                stringBuilder.append(adModuleBean.getId());
                                O00Oo00o.O000000o(splashActivity, str, stringBuilder.toString());
                                if (!TextUtils.isEmpty(adModuleBean.getJumpUrl())) {
                                    SplashActivity.this.O0000OOo();
                                    String jumpUrl = adModuleBean.getJumpUrl();
                                    try {
                                        if (!TextUtils.isEmpty(jumpUrl)) {
                                            jumpUrl = O00000o0.O000000o(jumpUrl);
                                        }
                                    } catch (UnsupportedEncodingException e) {
                                        e.printStackTrace();
                                    }
                                    O000o0.O000000o(SplashActivity.this, jumpUrl);
                                }
                            }
                        }
                    });
                    SplashActivity.this.O00000oO.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(gf.O000o00o);
                            stringBuilder.append(adModuleBean.getId());
                            O00OO0O.O000000o(new PvDataInfoV29(50000, stringBuilder.toString()));
                            SplashActivity splashActivity = SplashActivity.this;
                            String str = O000000o.O000000o;
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(gf.O000o00o);
                            stringBuilder2.append(adModuleBean.getId());
                            O00Oo00o.O000000o(splashActivity, str, stringBuilder2.toString());
                            SplashActivity.this.O0000OOo();
                        }
                    });
                }
            }
        });
    }

    private void O000000o(boolean z, String str, String str2, String str3, String str4, int i) {
        O000OO0o.O000000o(2, i);
        O00O0Oo0.O000000o("receiver_broadcast", Boolean.valueOf(true));
        final boolean z2 = z;
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        HttpUtil.get(MyApplication.O000000o(), new gj(gk.O000oo0), new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
            }

            public void onFinished() {
                O00O0Oo0.O000000o("receiver_broadcast");
                LocalBroadcastManager.getInstance(MyApplication.O000000o()).sendBroadcast(new Intent("action_update_user_info"));
            }

            public void onSuccess(String str) {
                UserInfo userInfo = (UserInfo) new Gson().fromJson(str, UserInfo.class);
                if (userInfo != null) {
                    userInfo.setRegisted(z2);
                    userInfo.setAlias(str5);
                    userInfo.setUserTag(str6);
                    userInfo.setToken(str7);
                    userInfo.setPsw(str8);
                    O00Oo0.O000000o(userInfo);
                }
            }
        });
    }

    private void O00000o() {
        this.O0000OoO = new O00Oo0o0();
        Intent intent = getIntent();
        if (intent != null) {
            this.O0000o0 = intent.getStringExtra("data");
            this.O0000o00 = (ChatFriendBean) intent.getParcelableExtra("extra_info");
            if (intent.getData() != null) {
                this.O0000o0O = intent.getDataString();
            }
        }
        O00Oo0.O0000OOo();
        O00O0Oo0.O000000o(O00000o0.O000000o, (Object) "");
        O00OO0O.O000000o();
        UserInfo O00000o0 = O00Oo0.O00000o0();
        if (O00000o0 != null && !O00000o0.isLogout()) {
            O000000o(O00000o0.isRegisted(), O00000o0.getAlias(), O00000o0.getUserTag(), O00000o0.getToken(), O00000o0.getPsw(), O00000o0.getUid());
            O000000o(O00000o0.getUnid());
        }
    }

    private native void O00000o0();

    private native void O00000oO();

    private native void O00000oo();

    private native void O0000O0o();

    private native void O0000OOo();

    @PermissionSuccess(requestCode = 103)
    public void O000000o() {
        O0000O0o();
        if (!this.O0000oOO) {
            this.O0000oOO = true;
            O00000o();
            if (this.O0000Oo0 != null) {
                this.O0000Oo = new Runnable() {
                    public void run() {
                        SplashActivity.this.O0000OOo();
                    }
                };
                this.O0000Oo0.postDelayed(this.O0000Oo, 3000);
                return;
            }
            O0000OOo();
        }
    }

    @PermissionFail(requestCode = 103)
    public void O00000Oo() {
        this.O0000oOO = false;
        O00000oO();
        if (this.O0000oO == null) {
            this.O0000oO = new O0000Oo(this).O000000o().O000000o(false).O00000Oo(false).O00000Oo((int) R.string.open_read_phone_permission).O000000o((int) R.string.open_default_permission_title).O000000o("取消", new OnClickListener() {
                public void onClick(View view) {
                    SplashActivity.this.O0000O0o();
                    O00000Oo.O00000Oo(SplashActivity.this);
                }
            }).O00000Oo("开启", new OnClickListener() {
                public void onClick(View view) {
                    SplashActivity.this.O0000O0o();
                    O00O00o.O000000o(SplashActivity.this);
                }
            });
        }
        if (!(isFinishing() || this.O0000oO.O00000oO())) {
            this.O0000oO.O00000Oo();
        }
    }

    public native void onCreate(Bundle bundle);

    public native void onPause();

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.O0000oO == null || !this.O0000oO.O00000oO()) {
            PermissionGen.onRequestPermissionsResult((Activity) this, i, strArr, iArr);
        }
    }

    public native void onResume();
}
