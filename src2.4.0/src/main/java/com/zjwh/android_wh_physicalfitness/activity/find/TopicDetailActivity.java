package com.zjwh.android_wh_physicalfitness.activity.find;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.ms.square.android.expandabletextview.ExpandableTextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.MultiImageSelectorActivity;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.TopicBean;
import com.zjwh.android_wh_physicalfitness.ui.dynamic.DynamicFragment;
import com.zjwh.android_wh_physicalfitness.ui.dynamic.DynamicFragment$O000000o;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O000o000;
import com.zjwh.android_wh_physicalfitness.utils.O00O00o;
import com.zjwh.android_wh_physicalfitness.utils.O00O0O0o;
import com.zjwh.android_wh_physicalfitness.utils.O00O0o0;
import com.zjwh.android_wh_physicalfitness.utils.O00OOOo;
import defpackage.O00Oo;
import defpackage.gi;
import defpackage.gj;
import defpackage.gk;
import java.util.ArrayList;
import java.util.Locale;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionSuccess;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback.CancelledException;
import org.xutils.common.util.DensityUtil;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class TopicDetailActivity extends BaseActivity implements DynamicFragment$O000000o {
    public static final int O000000o = 1000;
    public static final String O00000Oo = "topic_id";
    private static final String O00000o = "fragment_tag_middle";
    private static final String O00000o0 = "fragment_tag_left";
    private static final String O00000oO = "fragment_tag_right";
    @ViewInject(2131296734)
    private View O00000oo;
    @ViewInject(2131296740)
    private ImageButton O0000O0o;
    @ViewInject(2131297158)
    private TextView O0000OOo;
    @ViewInject(2131297160)
    private View O0000Oo;
    @ViewInject(2131296972)
    private ImageButton O0000Oo0;
    @ViewInject(2131297173)
    private TextView O0000o;
    @ViewInject(2131296305)
    private AppBarLayout O0000oO;
    @ViewInject(2131297172)
    private TextView O0000oO0;
    @ViewInject(2131296527)
    private ExpandableTextView O0000oOO;
    @ViewInject(2131297171)
    private ImageView O0000oOo;
    @ViewInject(2131296526)
    private ImageButton O0000oo;
    @ViewInject(2131296528)
    private TextView O0000oo0;
    @ViewInject(2131297175)
    private TextView O0000ooO;
    @ViewInject(2131297176)
    private TextView O0000ooo;
    private FragmentManager O000O00o;
    private TopicBean O000O0OO;
    private int O000O0Oo;
    @ViewInject(2131297177)
    private TextView O00oOooO;
    @ViewInject(2131297165)
    private CollapsingToolbarLayout O00oOooo;

    static {
        C.i(16777303);
    }

    public static native void O000000o(Activity activity, int i);

    private native void O000000o(Bundle bundle);

    private native void O000000o(TextView textView, FragmentTransaction fragmentTransaction, DynamicFragment dynamicFragment);

    private native void O000000o(TextView textView, FragmentTransaction fragmentTransaction, DynamicFragment dynamicFragment, int i, String str);

    private native void O0000O0o();

    @Event(type = OnClickListener.class, value = {2131297175, 2131297176, 2131297177})
    private void onTabClick(View view) {
        FragmentTransaction beginTransaction = this.O000O00o.beginTransaction();
        DynamicFragment dynamicFragment = (DynamicFragment) this.O000O00o.findFragmentByTag(O00000o0);
        DynamicFragment dynamicFragment2 = (DynamicFragment) this.O000O00o.findFragmentByTag(O00000o);
        DynamicFragment dynamicFragment3 = (DynamicFragment) this.O000O00o.findFragmentByTag(O00000oO);
        switch (view.getId()) {
            case R.id.topic_tab_left_tv /*2131297175*/:
                O000000o(this.O0000ooo, beginTransaction, dynamicFragment2);
                O000000o(this.O00oOooO, beginTransaction, dynamicFragment3);
                O000000o(this.O0000ooO, beginTransaction, dynamicFragment, 1, O00000o0);
                break;
            case R.id.topic_tab_middle_tv /*2131297176*/:
                O000000o(this.O0000ooO, beginTransaction, dynamicFragment);
                O000000o(this.O00oOooO, beginTransaction, dynamicFragment3);
                O000000o(this.O0000ooo, beginTransaction, dynamicFragment2, 2, O00000o);
                break;
            case R.id.topic_tab_right_tv /*2131297177*/:
                O000000o(this.O0000ooO, beginTransaction, dynamicFragment);
                O000000o(this.O0000ooo, beginTransaction, dynamicFragment2);
                O000000o(this.O00oOooO, beginTransaction, dynamicFragment3, 3, O00000oO);
                break;
        }
        if (!isFinishing()) {
            beginTransaction.commit();
        }
    }

    @Event(type = OnClickListener.class, value = {2131296740, 2131296972})
    private void onTopClick(View view) {
        int id = view.getId();
        if (id == R.id.left_image) {
            onBackPressed();
        } else if (id == R.id.right_image) {
            O00O00o.O00000o(this);
        }
    }

    @Event(type = OnLongClickListener.class, value = {2131296972})
    private boolean onTopLongClick(View view) {
        if (this.O000O0OO != null) {
            DynamicPublishActivity.O000000o(this, this.O000O0Oo, this.O000O0OO.getTitle(), -1.0f);
        }
        return false;
    }

    public native int O000000o();

    public native void O00000Oo();

    @PermissionSuccess(requestCode = 100)
    public void O00000o() {
        O00O0o0.O000000o((Activity) this, 9, 1);
    }

    @PermissionFail(requestCode = 100)
    public void O00000oO() {
        O00O00o.O000000o(this, 100);
    }

    public void O00000oo() {
        gj gjVar = new gj(gk.O0000ooo);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("topicId", this.O000O0Oo);
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        O000000o(HttpUtil.post(this, gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
                if (!TopicDetailActivity.this.isFinishing()) {
                    TopicDetailActivity.this.O0000oO.setExpanded(false);
                    TopicDetailActivity.this.O0000OOo.setText("话题详情");
                    if (responseError.getError() == gi.O0000OOo || responseError.getError() == gi.O0000Oo0) {
                        TopicDetailActivity.this.O000000o(TopicDetailActivity.this.getString(R.string.read_fail), responseError.getMessage(), new OnClickListener() {
                            public void onClick(View view) {
                                TopicDetailActivity.this.finish();
                            }
                        });
                    }
                }
            }

            public void onFinished() {
            }

            public void onSuccess(String str) {
                if (!TopicDetailActivity.this.isFinishing()) {
                    TopicDetailActivity.this.O0000Oo0.setEnabled(true);
                    TopicDetailActivity.this.O0000Oo0.setVisibility(0);
                    TopicDetailActivity.this.O000O0OO = (TopicBean) O000o000.O000000o().fromJson(str, TopicBean.class);
                    if (TopicDetailActivity.this.O000O0OO != null) {
                        TopicDetailActivity.this.O0000OOo.setText(TopicDetailActivity.this.O000O0OO.getTitle());
                        TopicDetailActivity.this.O0000o.setText(TopicDetailActivity.this.O000O0OO.getTitle());
                        TopicDetailActivity.this.O0000oO0.setText(String.format(Locale.getDefault(), "活跃度：%d", new Object[]{Integer.valueOf(TopicDetailActivity.this.O000O0OO.getParticipateNum())}));
                        if (TextUtils.isEmpty(TopicDetailActivity.this.O000O0OO.getImgUrl())) {
                            O00Oo.O000000o(TopicDetailActivity.this).O000000o(Integer.valueOf(R.color.window_background)).O000000o(TopicDetailActivity.this.O0000oOo);
                        } else {
                            O00Oo.O000000o(TopicDetailActivity.this).O000000o(TopicDetailActivity.this.O000O0OO.getImgUrl()).O00000oO(R.color.window_background).O0000O0o((int) R.color.window_background).O000000o(TopicDetailActivity.this.O0000oOo);
                        }
                        TopicDetailActivity.this.O0000oOO.setText(TopicDetailActivity.this.O000O0OO.getSummary());
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                                if (!TopicDetailActivity.this.isFinishing()) {
                                    TopicDetailActivity.this.O0000oo.setVisibility(TopicDetailActivity.this.O0000oo0.getLineCount() <= 4 ? 8 : 0);
                                }
                            }
                        }, 20);
                    }
                }
            }
        }));
    }

    public void n_() {
        if (VERSION.SDK_INT < 19) {
            this.O00oOooo.setMinimumHeight(DensityUtil.dip2px(45.0f));
        } else {
            this.O00oOooo.setMinimumHeight(DensityUtil.dip2px(45.0f) + O00OOOo.O000000o((Context) this));
        }
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        if (i != 1000) {
            switch (i) {
                case 0:
                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra(MultiImageSelectorActivity.O00000o);
                    DynamicPublishActivity.O000000o(this, this.O000O0Oo, stringArrayListExtra, this.O000O0OO != null ? this.O000O0OO.getTitle() : "", O00O0O0o.O000000o((String) stringArrayListExtra.get(0)));
                    return;
                case 1:
                    String string = PreferenceManager.getDefaultSharedPreferences(this.O0000o0).getString(O00O0O0o.O00000Oo, null);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(string);
                    DynamicPublishActivity.O000000o(this, this.O000O0Oo, arrayList, this.O000O0OO != null ? this.O000O0OO.getTitle() : "", O00O0O0o.O000000o(string));
                    return;
                default:
                    return;
            }
        }
        onTabClick(this.O0000ooo);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O00OOOo.O000000o((Activity) this, 0, this.O00000oo);
        O000000o(bundle);
        if (!isFinishing()) {
            this.O000O00o = getSupportFragmentManager();
            this.O0000o0O = true;
            O0000O0o();
            O00000oo();
        }
    }

    public native void onDestroy();

    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public native void onSaveInstanceState(Bundle bundle);
}
