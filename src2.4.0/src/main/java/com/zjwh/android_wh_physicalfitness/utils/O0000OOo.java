package com.zjwh.android_wh_physicalfitness.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.ArticleDetailActivity;
import com.zjwh.android_wh_physicalfitness.activity.find.TopicDetailActivity;
import com.zjwh.android_wh_physicalfitness.entity.BannerBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.CacheCallback;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.view.banner.O000000o.O00000o0;
import defpackage.gj;
import defpackage.gk;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback.Cancelable;
import org.xutils.common.Callback.CancelledException;

/* compiled from: BannerUtils */
public class O0000OOo {
    public static final int O000000o = 1;
    public static final int O00000Oo = 2;
    public static final int O00000o0 = 3;

    /* compiled from: BannerUtils */
    public interface O000000o {
        void O000000o();

        void O000000o(List<BannerBean> list);
    }

    public static Cancelable O000000o(Context context, int i) {
        gj gjVar = new gj(gk.O00oOooO);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", i);
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return HttpUtil.post(context, gjVar, new MyCallback<String>() {
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

    public static Cancelable O000000o(Context context, int i, final boolean z, final O000000o o000000o) {
        gj gjVar = new gj(gk.O00O0oo);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("positionType", i);
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        gjVar.setCacheMaxAge(com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O000000o.O00000oo);
        return HttpUtil.postCache(context, gjVar, new CacheCallback() {
            public boolean onCache(String str) {
                return z;
            }

            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
                o000000o.O000000o();
            }

            public void onFinished() {
            }

            public void onSuccess(String str) {
                List list = (List) O000o000.O000000o().fromJson(str, new TypeToken<List<BannerBean>>() {
                }.getType());
                if (list != null && list.size() > 0) {
                    o000000o.O000000o(list);
                }
            }
        });
    }

    public static void O000000o(Activity activity, int i, String str, int i2) {
        switch (i2) {
            case 1:
                ArticleDetailActivity.O000000o(activity, i);
                return;
            case 2:
                TopicDetailActivity.O000000o(activity, i);
                return;
            case 5:
            case 6:
                try {
                    if (!TextUtils.isEmpty(str)) {
                        str = O00000o0.O000000o(str);
                        break;
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    break;
                }
                break;
            case 7:
            case 8:
                break;
            default:
                return;
        }
        O000o0.O000000o(activity, str);
    }

    public static void O000000o(com.zjwh.android_wh_physicalfitness.view.banner.O000000o o000000o, BannerBean bannerBean, int i) {
        String str;
        switch (bannerBean.getType()) {
            case 1:
                str = "阅读";
                break;
            case 2:
                str = "话题";
                break;
            case 6:
                str = "活动";
                break;
            case 7:
                str = "小程序";
                break;
            default:
                str = null;
                break;
        }
        o000000o.O000000o(bannerBean.getBody().getUrl()).O00000o(bannerBean.getType()).O00000Oo(TextUtils.isEmpty(bannerBean.getImgUrl()) ? "2131230876" : bannerBean.getImgUrl()).O000000o((int) R.drawable.default_banner).O00000Oo((int) R.drawable.default_banner).O000000o(O00000o0.FitCenterCrop).O00000o0(str).O00000oo(bannerBean.getBody().getId()).O00000oO(bannerBean.getId()).O0000O0o(i);
    }
}
