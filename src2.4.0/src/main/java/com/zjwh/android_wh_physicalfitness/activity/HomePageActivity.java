package com.zjwh.android_wh_physicalfitness.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.yalantis.ucrop.UCrop;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.activity.find.DynamicPublishActivity;
import com.zjwh.android_wh_physicalfitness.activity.mine.PersonalInfoActivity;
import com.zjwh.android_wh_physicalfitness.entity.EBRankBcgr;
import com.zjwh.android_wh_physicalfitness.entity.HomePageHeadInfoBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.SignIntegralBean;
import com.zjwh.android_wh_physicalfitness.entity.database.ChatFriendBean;
import com.zjwh.android_wh_physicalfitness.entity.database.UserInfo;
import com.zjwh.android_wh_physicalfitness.ui.chat.ChatActivity;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O00000Oo;
import com.zjwh.android_wh_physicalfitness.utils.O000o00;
import com.zjwh.android_wh_physicalfitness.utils.O000o00.O00000o;
import com.zjwh.android_wh_physicalfitness.utils.O000o000;
import com.zjwh.android_wh_physicalfitness.utils.O00O00o;
import com.zjwh.android_wh_physicalfitness.utils.O00O0O0o;
import com.zjwh.android_wh_physicalfitness.utils.O00O0o0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import com.zjwh.android_wh_physicalfitness.view.dialog.O000000o;
import com.zjwh.android_wh_physicalfitness.view.dialog.O0000Oo0;
import defpackage.O00Oo;
import defpackage.gj;
import defpackage.gk;
import java.io.File;
import java.util.ArrayList;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionSuccess;
import org.greenrobot.eventbus.O00000o0;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback.CancelledException;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class HomePageActivity extends BaseActivity {
    public static final String O000000o = "extra_user_id";
    public static final String O00000Oo = "save_photo_operate";
    public static final String O00000o = "key_interest_user_id";
    public static final String O00000o0 = "key_interest_status";
    @ViewInject(2131297158)
    private TextView O00000oO;
    @ViewInject(2131296740)
    private ImageButton O00000oo;
    @ViewInject(2131296734)
    private View O0000O0o;
    @ViewInject(2131296304)
    private AppBarLayout O0000OOo;
    @ViewInject(2131296643)
    private ImageView O0000Oo;
    @ViewInject(2131297165)
    private View O0000Oo0;
    @ViewInject(2131297235)
    private TextView O0000o;
    @ViewInject(2131296674)
    private ImageView O0000oO;
    @ViewInject(2131296648)
    private ImageView O0000oO0;
    @ViewInject(2131297256)
    private TextView O0000oOO;
    @ViewInject(2131297196)
    private TextView O0000oOo;
    @ViewInject(2131297221)
    private TextView O0000oo;
    @ViewInject(2131297268)
    private TextView O0000oo0;
    @ViewInject(2131297206)
    private TextView O0000ooO;
    @ViewInject(2131297191)
    private TextView O0000ooo;
    @ViewInject(2131296766)
    private LinearLayout O000O00o;
    @ViewInject(2131296634)
    private ImageView O000O0OO;
    @ViewInject(2131297205)
    private TextView O000O0Oo;
    @ViewInject(2131296663)
    private ImageView O000O0o;
    @ViewInject(2131296652)
    private ImageView O000O0o0;
    @ViewInject(2131296769)
    private LinearLayout O000O0oO;
    private boolean O000O0oo;
    private Dialog O000OO;
    private int O000OO00 = -1;
    private int O000OO0o = 0;
    private UserInfo O000OOOo = null;
    private SignIntegralBean O000OOo;
    private HomePageHeadInfoBean O000OOo0;
    private BroadcastReceiver O000OOoO;
    private LocalBroadcastManager O000OOoo;
    private int O000Oo0 = -1;
    private boolean O000Oo00;
    @ViewInject(2131297160)
    private View O00oOoOo;
    @ViewInject(2131297231)
    private TextView O00oOooO;
    @ViewInject(2131296763)
    private LinearLayout O00oOooo;

    /* renamed from: com.zjwh.android_wh_physicalfitness.activity.HomePageActivity$7 */
    class AnonymousClass7 implements MyCallback<String> {
        final /* synthetic */ File O000000o;

        AnonymousClass7(File file) {
            this.O000000o = file;
        }

        public void onCancelled(CancelledException cancelledException) {
        }

        public void onError(ResponseError responseError) {
            O00Oo00.O000000o(responseError.getMessage(), false);
        }

        public void onFinished() {
            if (HomePageActivity.this.O000OO != null && HomePageActivity.this.O000OO.isShowing()) {
                HomePageActivity.this.O000OO.cancel();
            }
        }

        public void onSuccess(String str) {
            if (!HomePageActivity.this.isFinishing()) {
                try {
                    O00Oo00.O000000o(HomePageActivity.this.O0000o0, (int) R.string.msg_cover_upload_success);
                    str = new JSONObject(str).optString("fileUrl");
                    O00Oo.O00000o0(HomePageActivity.this.O0000o0).O000000o(str).O00000oO(R.drawable.homepage_default_bg).O00000oO(R.drawable.homepage_default_bg).O0000O0o((int) R.drawable.homepage_default_bg).O00000Oo().O000000o(HomePageActivity.this.O0000oO);
                    O00000o0.O000000o().O00000o(new EBRankBcgr(HomePageActivity.this.O000OO00, str));
                    this.O000000o.deleteOnExit();
                    HomePageActivity.this.O000OOOo.setbIcon(str);
                    HomePageActivity.this.O000OOo0.setbIcon(str);
                    O00Oo0.O000000o(HomePageActivity.this.O000OOOo);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static {
        C.i(16777282);
    }

    @Event({2131297205, 2131296766, 2131296763, 2131296671, 2131296634, 2131296643, 2131296674, 2131296663})
    private void MyClick(View view) {
        switch (view.getId()) {
            case R.id.ivChat /*2131296634*/:
                if (this.O000OOo0 != null) {
                    O00000Oo.O00000Oo(ChatActivity.class);
                    ChatFriendBean chatFriendBean = new ChatFriendBean();
                    chatFriendBean.setInterestStatus(this.O000OOo0.getInterestStatus());
                    chatFriendBean.setAvatarUrl(this.O000OOo0.getIcon());
                    chatFriendBean.setGender(this.O000OOo0.getGender());
                    chatFriendBean.setFriendUId(this.O000OO00);
                    chatFriendBean.setMyselfUId(this.O000OOOo.getUid());
                    chatFriendBean.setName(this.O000OOo0.getName());
                    chatFriendBean.setId(O00Oo0.O0000Oo0());
                    ChatActivity.O000000o(this, chatFriendBean);
                    break;
                }
                return;
            case R.id.ivEditInfo /*2131296643*/:
                Intent intent = new Intent(this.O0000o0, PersonalInfoActivity.class);
                intent.putExtra("type", 8);
                startActivityForResult(intent, 8);
                break;
            case R.id.ivPublishDynamic /*2131296663*/:
                this.O000Oo0 = 2;
                O00O00o.O00000o(this);
                break;
            case R.id.ivSportData /*2131296671*/:
                SportsDataActivity.O000000o((Activity) this, this.O000OO00);
                break;
            case R.id.ivZoomView /*2131296674*/:
                this.O000Oo0 = 1;
                O00O00o.O00000o(this);
                break;
            case R.id.llConcern /*2131296763*/:
                if (this.O000OOo0 != null) {
                    ConcernListActivity.O000000o(this, this.O000OO00, this.O000OOo0.getName());
                    break;
                }
                return;
            case R.id.llFans /*2131296766*/:
                if (this.O000OOo0 != null) {
                    FansListActivity.O000000o(this, this.O000OO00, this.O000OOo0.getName());
                    break;
                }
                return;
            case R.id.tvConcern /*2131297205*/:
                if (this.O000OO0o != 1) {
                    new O000000o(this.O0000o0).O000000o().O000000o("你确定取消关注该用户么").O000000o(true).O00000Oo(true).O000000o("取消关注", O000000o.O00000o0.Green, new O000000o.O000000o() {
                        public void O000000o(int i) {
                            HomePageActivity.this.O00000Oo(2);
                        }
                    }).O00000Oo();
                    break;
                } else {
                    O00000Oo(1);
                    break;
                }
        }
    }

    private native void O000000o(int i);

    public static native void O000000o(Activity activity, int i);

    public static native void O000000o(Activity activity, int i, int i2);

    private native void O000000o(Bundle bundle);

    private native void O000000o(File file);

    private native void O00000Oo(int i);

    private native void O00000oo();

    private native void O0000O0o();

    private native void O0000OOo();

    private void O0000Oo0() {
        this.O000Oo00 = true;
        gj gjVar = new gj(gk.O000ooo);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uid", this.O000OO00);
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        O000000o(HttpUtil.post(this.O0000o0, gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
            }

            public void onFinished() {
                HomePageActivity.this.O000Oo00 = false;
            }

            public void onSuccess(String str) {
                HomePageActivity.this.O000OOo = (SignIntegralBean) O000o000.O000000o().fromJson(str, SignIntegralBean.class);
                if (HomePageActivity.this.O000OOo != null) {
                    HomePageActivity.this.O00oOooO.setText(HomePageActivity.this.O000OOo.getRankName());
                    HomePageActivity.this.O000O0o0.setImageResource(O00Oo0.O00000Oo[HomePageActivity.this.O000OOo.getRank()]);
                    int rank = (HomePageActivity.this.O000OOo.getRank() < 0 || HomePageActivity.this.O000OOo.getRank() > 12) ? 0 : HomePageActivity.this.O000OOo.getRank();
                    int i = R.drawable.run_level_pink_bg;
                    if (rank >= 3) {
                        if (rank < 6) {
                            i = R.drawable.run_level_orange_bg;
                        } else if (rank < 9) {
                            i = R.drawable.run_level_purple_bg;
                        } else if (rank < 13) {
                            i = R.drawable.run_level_green_bg;
                        }
                    }
                    HomePageActivity.this.O000O0oO.setBackgroundResource(i);
                }
            }
        }));
    }

    @Event({2131296740, 2131296769})
    private void onClick(View view) {
        int id = view.getId();
        if (id == R.id.left_image) {
            setResult(-1);
            onBackPressed();
        } else if (id == R.id.llLevel && this.O000O0oo) {
            WebViewActivity.O000000o((Activity) this, com.zjwh.android_wh_physicalfitness.O000000o.O0000Oo);
        }
    }

    @Event(type = OnLongClickListener.class, value = {2131296663})
    private boolean onTopLongClick(View view) {
        DynamicPublishActivity.O000000o(this);
        return false;
    }

    public native int O000000o();

    public native void O00000Oo();

    @PermissionSuccess(requestCode = 100)
    public void O00000o() {
        switch (this.O000Oo0) {
            case 1:
                O00O0o0.O000000o((Activity) this, 1, 0);
                return;
            case 2:
                O00O0o0.O000000o((Activity) this, 9, 1);
                return;
            default:
                return;
        }
    }

    @PermissionFail(requestCode = 100)
    public void O00000oO() {
        O00O00o.O000000o(this, 100);
    }

    public void n_() {
        this.O000OOOo = O00Oo0.O00000o0();
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        String path;
        if (i == 8) {
            String str;
            this.O000OOOo = O00Oo0.O00000o0();
            this.O0000o.setText(TextUtils.isEmpty(this.O000OOOo.getName()) ? "" : this.O000OOOo.getName());
            this.O0000oo0.setText(TextUtils.isEmpty(this.O000OOOo.getPsign()) ? "请编辑个性签名" : this.O000OOOo.getPsign());
            O00Oo0.O000000o(this, this.O000OOOo.getIcon(), this.O0000oO0, this.O000OOOo.getSex());
            TextView textView = this.O0000oOo;
            String str2 = "%s %s";
            Object[] objArr = new Object[2];
            objArr[0] = TextUtils.isEmpty(this.O000OOOo.getDepart()) ? "" : this.O000OOOo.getDepart();
            if (this.O000OOOo.getEnrollmentYear() == 0) {
                str = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.O000OOOo.getEnrollmentYear());
                stringBuilder.append("级");
                str = stringBuilder.toString();
            }
            objArr[1] = str;
            textView.setText(String.format(str2, objArr));
            this.O0000oOO.setText(this.O000OOOo.getCampusName());
        } else if (i == 69) {
            Uri output = UCrop.getOutput(intent);
            if (output != null) {
                path = output.getPath();
                this.O000OO = O0000Oo0.O000000o(this.O0000o0, (int) R.string.txt_saving_record);
                this.O000OO.show();
                O000o00.O000000o(this.O0000o0).O000000o(path).O000000o(new O00000o() {
                    public void O000000o() {
                        if (HomePageActivity.this.O000OO != null && HomePageActivity.this.O000OO.isShowing()) {
                            HomePageActivity.this.O000OO.dismiss();
                        }
                        O00Oo00.O000000o(HomePageActivity.this.getString(R.string.msg_set_pic_error), false);
                    }

                    public void O000000o(File file) {
                        HomePageActivity.this.O000000o(file);
                    }
                });
            }
        } else if (i != 96) {
            switch (i) {
                case 0:
                    if (this.O000Oo0 == 1) {
                        O00O0O0o.O000000o(this.O0000o0, intent.getStringArrayListExtra(MultiImageSelectorActivity.O00000o), 6, 5);
                        return;
                    } else if (this.O000Oo0 == 2) {
                        ArrayList stringArrayListExtra = intent.getStringArrayListExtra(MultiImageSelectorActivity.O00000o);
                        DynamicPublishActivity.O000000o(this, stringArrayListExtra, O00O0O0o.O000000o((String) stringArrayListExtra.get(0)));
                        return;
                    } else {
                        return;
                    }
                case 1:
                    if (this.O000Oo0 == 1) {
                        O00O0O0o.O000000o(this.O0000o0, 6, 5);
                        return;
                    } else if (this.O000Oo0 == 2) {
                        path = PreferenceManager.getDefaultSharedPreferences(this.O0000o0).getString(O00O0O0o.O00000Oo, null);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(path);
                        DynamicPublishActivity.O000000o(this, arrayList, O00O0O0o.O000000o(path));
                        return;
                    } else {
                        return;
                    }
                case 2:
                    path = O00O0O0o.O0000O0o(this.O0000o0);
                    if (TextUtils.isEmpty(path)) {
                        O00Oo00.O000000o(this.O0000o0, (int) R.string.msg_set_pic_error);
                        return;
                    } else {
                        O000000o(new File(path));
                        return;
                    }
                default:
                    return;
            }
        } else {
            O00Oo00.O000000o(getString(R.string.msg_set_pic_error), false);
        }
    }

    public native void onCreate(Bundle bundle);

    public native void onDestroy();

    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public native void onResume();

    public native void onSaveInstanceState(Bundle bundle);
}
