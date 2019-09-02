package com.zjwh.android_wh_physicalfitness.activity.common;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.media.O0000Oo;
import com.umeng.socialize.media.O0000o;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.application.MyApplication;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.ShareInfoBean;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O00OOo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import defpackage.by;
import defpackage.fw;
import defpackage.fx.O000000o;
import defpackage.ga;
import defpackage.gj;
import defpackage.gk;
import defpackage.kz;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback.CancelledException;
import org.xutils.common.util.DensityUtil;
import s.h.e.l.l.C;

public class BaseShareActivity extends BaseActivity {
    protected static final int O0000oOo = 10001;
    protected static final int O0000oo0 = 10002;
    private Dialog O000000o;
    private Integer[] O00000Oo = new Integer[]{Integer.valueOf(R.mipmap.dg_weixin), Integer.valueOf(R.mipmap.dg_friendcirlce), Integer.valueOf(R.mipmap.dg_share_qq), Integer.valueOf(R.mipmap.dg_qqzone), Integer.valueOf(R.mipmap.dg_sina)};
    private int[] O00000o0 = new int[]{R.string.umeng_socialize_text_weixin_key, R.string.umeng_socialize_text_weixin_circle_key, R.string.umeng_socialize_text_qq_key, R.string.umeng_socialize_text_qq_zone_key, R.string.umeng_socialize_text_sina_key};
    protected ShareInfoBean O0000oo;
    protected int O0000ooO = -1;
    protected int O0000ooo = -1;
    protected UMShareListener O00oOooO = new UMShareListener() {
        public void onCancel(by byVar) {
            BaseShareActivity.this.O0000OoO();
        }

        public void onError(by byVar, Throwable th) {
            O00Oo00.O00000Oo((int) R.string.share_failed);
            if (th != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("throw:");
                stringBuilder.append(th.getMessage());
                kz.O00000oO("throw", stringBuilder.toString());
            }
            BaseShareActivity.this.O0000OoO();
        }

        public void onResult(by byVar) {
            BaseShareActivity.this.O0000OoO();
            O00Oo00.O00000Oo((int) R.string.share_success);
        }

        public void onStart(by byVar) {
            BaseShareActivity.this.O00000oO(BaseShareActivity.this.getString(R.string.txt_loading));
        }
    };

    static {
        C.i(16777296);
    }

    private void O00000Oo(int i) {
        if (this.O0000ooO != -1 && this.O0000ooo != -1) {
            gj gjVar = new gj(gk.O00OoOo);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("shareType", this.O0000ooO);
                jSONObject.put("itemId", this.O0000ooo);
                jSONObject.put("shareChannel", i);
                gjVar.setBodyContent(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            HttpUtil.post(MyApplication.O000000o(), gjVar, new MyCallback<String>() {
                public void onCancelled(CancelledException cancelledException) {
                }

                public void onError(ResponseError responseError) {
                }

                public void onFinished() {
                }

                public void onSuccess(String str) {
                }
            });
        }
    }

    private void O00000o() {
        if (this.O000000o != null && this.O000000o.isShowing()) {
            this.O000000o.cancel();
            this.O000000o = null;
        }
    }

    public native int O000000o();

    /* Access modifiers changed, original: protected */
    public void O000000o(int i) {
        if (this.O0000oo == null) {
            O00Oo00.O00000Oo("数据异常！");
            return;
        }
        by byVar;
        String str = "";
        by byVar2 = null;
        switch (i) {
            case 0:
                str = getString(R.string.umeng_socialize_text_wechat_no_install);
                byVar2 = by.WEIXIN;
                byVar = by.WEIXIN;
                break;
            case 1:
                str = getString(R.string.umeng_socialize_text_wechat_no_install);
                byVar2 = by.WEIXIN_CIRCLE;
                byVar = by.WEIXIN;
                break;
            case 2:
                str = getString(R.string.umeng_socialize_text_qq_no_install);
                byVar2 = by.QQ;
                byVar = by.QQ;
                break;
            case 3:
                str = getString(R.string.umeng_socialize_text_qq_no_install);
                byVar2 = by.QZONE;
                byVar = by.QQ;
                break;
            case 4:
                str = getString(R.string.umeng_socialize_text_sina_no_install);
                byVar2 = by.SINA;
                byVar = by.SINA;
                break;
            default:
                byVar = null;
                break;
        }
        if (byVar == null || UMShareAPI.get(getApplicationContext()).isInstall(this, byVar)) {
            if (byVar2 != null) {
                str = this.O0000oo.getTitle();
                String string = TextUtils.isEmpty(this.O0000oo.getSummary()) ? getString(R.string.share_summary_default) : this.O0000oo.getSummary();
                if (byVar2 == by.SINA) {
                    str = TextUtils.isEmpty(this.O0000oo.getSummary()) ? getString(R.string.share_summary_default) : this.O0000oo.getSummary();
                    string = this.O0000oo.getTitle();
                }
                O0000o o0000o = new O0000o(this.O0000oo.getShareUrl());
                o0000o.O00000Oo(str);
                o0000o.O000000o(new O0000Oo(this.O0000o0, this.O0000oo.getImageUrl()));
                o0000o.O000000o(string);
                new ShareAction(this).setPlatform(byVar2).setCallback(this.O00oOooO).withMedia(o0000o).withText(string).share();
                O00000Oo(i);
            }
            return;
        }
        O00Oo00.O000000o(this.O0000o0, str);
    }

    public native void O00000Oo();

    /* Access modifiers changed, original: protected */
    public void O0000Oo0() {
        if (!isFinishing()) {
            View inflate = View.inflate(this, R.layout.layout_share_dialog, null);
            int screenHeight = DensityUtil.getScreenHeight();
            ((TextView) inflate.findViewById(2131297158)).setText("分享该内容到");
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.rv_share);
            recyclerView.setOverScrollMode(2);
            recyclerView.setLayoutManager(new LinearLayoutManager(this, 0, false));
            final int i = screenHeight;
            AnonymousClass1 anonymousClass1 = new fw<Integer>(this.O0000o0, R.layout.layout_item_share_icon, Arrays.asList(this.O00000Oo)) {
                /* Access modifiers changed, original: protected */
                public void O000000o(ga gaVar, Integer num, int i) {
                    gaVar.O000000o((int) R.id.tv_share_name, BaseShareActivity.this.O00000o0[i]);
                    gaVar.O00000Oo((int) R.id.iv_share_icon, BaseShareActivity.this.O00000Oo[i].intValue());
                    ImageView imageView = (ImageView) gaVar.O000000o(R.id.iv_share_icon);
                    LayoutParams layoutParams = imageView.getLayoutParams();
                    i = (int) (((double) i) * 0.09d);
                    layoutParams.width = i;
                    layoutParams.height = i;
                    imageView.setLayoutParams(layoutParams);
                }
            };
            recyclerView.setAdapter(anonymousClass1);
            anonymousClass1.O000000o((O000000o) new O000000o() {
                public void O000000o(View view, ViewHolder viewHolder, int i) {
                    if (!O00OOo0.O000000o()) {
                        BaseShareActivity.this.O00000o();
                    }
                    BaseShareActivity.this.O000000o(i);
                }

                public boolean O00000Oo(View view, ViewHolder viewHolder, int i) {
                    return false;
                }
            });
            TextView textView = (TextView) inflate.findViewById(R.id.tv_cancle);
            double d = (double) screenHeight;
            textView.setHeight((int) (0.075d * d));
            textView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (BaseShareActivity.this.O000000o != null) {
                        BaseShareActivity.this.O000000o.dismiss();
                        BaseShareActivity.this.O000000o = null;
                    }
                }
            });
            this.O000000o = new Dialog(this, R.style.ActionSheetDialogStyle2);
            this.O000000o.setContentView(inflate);
            Window window = this.O000000o.getWindow();
            if (window != null) {
                window.setGravity(83);
                this.O000000o.setCancelable(true);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.x = 0;
                attributes.y = 0;
                attributes.height = (int) (d * 0.32d);
                attributes.width = DensityUtil.getScreenWidth();
                window.setAttributes(attributes);
                if (!isFinishing()) {
                    this.O000000o.show();
                }
            }
        }
    }

    public void n_() {
    }

    public native void onActivityResult(int i, int i2, Intent intent);

    public native void onDestroy();
}
