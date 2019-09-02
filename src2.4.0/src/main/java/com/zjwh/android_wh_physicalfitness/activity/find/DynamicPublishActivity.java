package com.zjwh.android_wh_physicalfitness.activity.find;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import cn.jiguang.net.HttpUtils;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.application.MyApplication;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000o0;
import com.zjwh.android_wh_physicalfitness.entity.Eventbus.AddDynamicPhotoEvt;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.database.TopicTagBean;
import com.zjwh.android_wh_physicalfitness.ui.dynamic.DynamicFragment;
import com.zjwh.android_wh_physicalfitness.utils.O000o;
import com.zjwh.android_wh_physicalfitness.utils.O00O00o;
import com.zjwh.android_wh_physicalfitness.utils.O00O0O0o;
import com.zjwh.android_wh_physicalfitness.utils.O00O0o0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import defpackage.gs$O00000Oo;
import java.util.ArrayList;
import java.util.Locale;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionSuccess;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.xutils.db.sqlite.WhereBuilder;
import org.xutils.ex.DbException;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class DynamicPublishActivity extends BaseActivity implements TextWatcher, gs$O00000Oo {
    public static final String O000000o = "extra_topic_id";
    public static final String O00000Oo = "extra_title";
    public static final String O00000o = "extra_dynamic_tip";
    public static final String O00000o0 = "extra_img_rate";
    public static final int O00000oO = 1000;
    public static final String O00000oo = "extra_img_list";
    private static final String O0000O0o = "key_topic_tip";
    @ViewInject(2131296740)
    private ImageButton O0000OOo;
    @ViewInject(2131297158)
    private TextView O0000Oo;
    @ViewInject(2131296741)
    private TextView O0000Oo0;
    @ViewInject(2131296974)
    private TextView O0000o;
    @ViewInject(2131296482)
    private EditText O0000oO;
    @ViewInject(2131296483)
    private TextView O0000oO0;
    @ViewInject(2131296487)
    private View O0000oOO;
    @ViewInject(2131296945)
    private RecyclerView O0000oOo;
    private fe O0000oo;
    @ViewInject(2131297218)
    private TextView O0000oo0;
    private O00000o0 O0000ooO;
    private View O0000ooo;
    private int O000O00o;
    private String O000O0OO;
    private float O000O0Oo = -1.0f;
    private String O00oOoOo;
    private O000000o O00oOooO;
    private ArrayList<String> O00oOooo;

    static {
        C.i(38);
    }

    public static void O000000o(Activity activity) {
        O000000o(activity, -1, null, "", -1.0f, "");
    }

    public static void O000000o(Activity activity, int i, String str, float f) {
        O000000o(activity, i, null, str, f, "");
    }

    public static void O000000o(Activity activity, int i, ArrayList<String> arrayList, String str, float f) {
        O000000o(activity, i, (ArrayList) arrayList, str, f, "");
    }

    public static void O000000o(Activity activity, int i, ArrayList<String> arrayList, String str, float f, String str2) {
        Intent intent = new Intent(activity, DynamicPublishActivity.class);
        intent.putExtra("extra_topic_id", i);
        intent.putExtra(O00000Oo, str);
        intent.putStringArrayListExtra(O00000oo, arrayList);
        intent.putExtra(O00000o0, f);
        intent.putExtra(O00000o, str2);
        activity.startActivityForResult(intent, 1000);
    }

    public static void O000000o(Activity activity, String str) {
        O000000o(activity, -1, null, "", -1.0f, str);
    }

    public static void O000000o(Activity activity, ArrayList<String> arrayList, float f) {
        O000000o(activity, -1, (ArrayList) arrayList, "", f, "");
    }

    public static void O000000o(Activity activity, ArrayList<String> arrayList, float f, String str) {
        O000000o(activity, -1, (ArrayList) arrayList, "", f, str);
    }

    private native void O000000o(Bundle bundle);

    public static void O000000o(Fragment fragment) {
        O000000o(fragment, -1, null, "", -1.0f, "");
    }

    public static void O000000o(Fragment fragment, int i, ArrayList<String> arrayList, String str, float f, String str2) {
        Intent intent = new Intent(fragment.getContext(), DynamicPublishActivity.class);
        intent.putExtra("extra_topic_id", i);
        intent.putExtra(O00000Oo, str);
        intent.putStringArrayListExtra(O00000oo, arrayList);
        intent.putExtra(O00000o0, f);
        intent.putExtra(O00000o, str2);
        fragment.startActivityForResult(intent, 1000);
    }

    public static void O000000o(Fragment fragment, ArrayList<String> arrayList, float f) {
        O000000o(fragment, -1, (ArrayList) arrayList, "", f, "");
    }

    private O000000o O0000O0o() {
        if (this.O00oOooO == null) {
            this.O00oOooO = new jo(this);
        }
        return this.O00oOooO;
    }

    private boolean O0000OOo() {
        return !TextUtils.isEmpty(this.O0000oO.getText().toString().trim()) || O0000Oo0();
    }

    private native boolean O0000Oo0();

    private native void O0000o0();

    @Event(type = OnClickListener.class, value = {2131296740, 2131296974, 2131296486, 2131296762})
    private void onClick(View view) {
        int id = view.getId();
        if (id == 2131296486) {
            this.O000O00o = -1;
            this.O000O0OO = "";
            this.O0000oOO.setVisibility(4);
        } else if (id == 2131296740) {
            onBackPressed();
        } else if (id == 2131296762) {
            AddTopicTagActivity.O000000o(this, this.O000O00o, this.O000O0OO);
        } else if (id == 2131296974) {
            O000o.O000000o(view);
            O0000O0o().O000000o(this.O0000o0, this.O0000oo.O000000o(), this.O0000oO.getText().toString().trim(), this.O00oOoOo, this.O000O00o, this.O000O0Oo);
        }
    }

    public native int O000000o();

    public native void O000000o(ResponseError responseError);

    public native void O00000Oo();

    public native void O00000Oo(ResponseError responseError);

    @PermissionSuccess(requestCode = 100)
    public void O00000o() {
        O00O0o0.O000000o(this, 9, 1);
    }

    public void O00000o0(ResponseError responseError) {
        O00000Oo(getString(2131689562), responseError.getMessage());
        try {
            O00Oo0.O0000O0o().delete(TopicTagBean.class, WhereBuilder.b("topicId", HttpUtils.EQUAL_SIGN, Integer.valueOf(this.O000O00o)));
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    @PermissionFail(requestCode = 100)
    public void O00000oO() {
        O00O00o.O000000o(this, 100);
    }

    public void O00000oo() {
        if (this.O000O00o > 0 && !TextUtils.isEmpty(this.O000O0OO)) {
            O00Oo0.O000000o(this.O000O00o, this.O000O0OO, System.currentTimeMillis());
        }
        if (!isFinishing()) {
            O00Oo00.O000000o(getString(2131689563), true);
            LocalBroadcastManager.getInstance(MyApplication.O000000o()).sendBroadcast(new Intent(DynamicFragment.O0000o00));
            setResult(-1);
            finish();
        }
    }

    public void afterTextChanged(Editable editable) {
        TextView textView = this.O0000o;
        boolean z = !TextUtils.isEmpty(editable.toString().trim()) || O0000Oo0();
        textView.setEnabled(z);
        this.O0000oo0.setText(String.format(Locale.getDefault(), "%d/200", new Object[]{Integer.valueOf(editable.length())}));
    }

    public native void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3);

    public native boolean dispatchTouchEvent(MotionEvent motionEvent);

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handleAddImg(AddDynamicPhotoEvt addDynamicPhotoEvt) {
        if (addDynamicPhotoEvt != null) {
            this.O0000ooo.setVisibility(addDynamicPhotoEvt.getPhotoNum() >= 9 ? 8 : 0);
        }
    }

    public void n_() {
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            int i3 = 0;
            if (i != 1000) {
                switch (i) {
                    case 0:
                        this.O00oOooo = intent.getStringArrayListExtra("select_result");
                        if (O0000Oo0()) {
                            this.O000O0Oo = O00O0O0o.O000000o((String) this.O00oOooo.get(0));
                            this.O0000oo.O000000o(this.O00oOooo);
                        }
                        this.O0000o.setEnabled(O0000OOo());
                        return;
                    case 1:
                        String string = PreferenceManager.getDefaultSharedPreferences(this.O0000o0).getString("pl.aprilapps.easyphotopicker.last_photo", null);
                        this.O00oOooo.add(string);
                        this.O000O0Oo = O00O0O0o.O000000o(string);
                        this.O0000oo.O000000o(string);
                        this.O0000o.setEnabled(O0000OOo());
                        return;
                    default:
                        return;
                }
            }
            this.O000O0OO = intent.getStringExtra("extra_topic_name");
            this.O000O00o = intent.getIntExtra("extra_topic_id", -1);
            this.O0000oO0.setText(this.O000O0OO);
            View view = this.O0000oOO;
            if (this.O000O00o == -1) {
                i3 = 4;
            }
            view.setVisibility(i3);
        }
    }

    public native void onBackPressed();

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O000000o(bundle);
        if (!isFinishing()) {
            org.greenrobot.eventbus.O00000o0.O000000o().O000000o(this);
            O0000o0();
        }
    }

    public native void onDestroy();

    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public native void onSaveInstanceState(Bundle bundle);

    public native void onTextChanged(CharSequence charSequence, int i, int i2, int i3);
}
