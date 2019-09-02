package com.zjwh.android_wh_physicalfitness.ui.mine;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.School;
import com.zjwh.android_wh_physicalfitness.entity.database.UserInfo;
import com.zjwh.android_wh_physicalfitness.entity.request.SchoolNumBackBean;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.O000o00;
import com.zjwh.android_wh_physicalfitness.utils.O000o000;
import com.zjwh.android_wh_physicalfitness.utils.O00O00o;
import com.zjwh.android_wh_physicalfitness.utils.O00O0O0o;
import com.zjwh.android_wh_physicalfitness.utils.O00O0OOo;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import com.zjwh.android_wh_physicalfitness.view.dialog.O0000Oo0;
import defpackage.do$O00000Oo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionSuccess;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class SchoolNumBackActivity extends BaseActivity implements do$O00000Oo {
    @ViewInject(2131296519)
    private EditText O000000o;
    @ViewInject(2131296520)
    private EditText O00000Oo;
    @ViewInject(2131296522)
    private EditText O00000o;
    @ViewInject(2131297400)
    private TextView O00000o0;
    @ViewInject(2131296370)
    private Button O00000oO;
    @ViewInject(2131296945)
    private RecyclerView O00000oo;
    private do O0000O0o;
    private List<String> O0000OOo = new ArrayList();
    private int O0000Oo;
    private Dialog O0000Oo0;

    static {
        C.i(48);
    }

    public static native void O000000o(Activity activity);

    private native void O000000o(File file);

    private native void O00000oo();

    private native GridLayoutManager O0000O0o();

    private void O0000OOo() {
        String trim = this.O00000o0.getText().toString().trim();
        String trim2 = this.O00000o.getText().toString().trim();
        String trim3 = this.O000000o.getText().toString().trim();
        String trim4 = this.O00000Oo.getText().toString().trim();
        if (TextUtils.isEmpty(trim3)) {
            O00Oo00.O000000o("姓名不能为空");
        } else if (TextUtils.isEmpty(trim4)) {
            O00Oo00.O000000o("手机号不能为空");
        } else if (TextUtils.isEmpty(trim)) {
            O00Oo00.O000000o("学校不能为空");
        } else if (TextUtils.isEmpty(trim2)) {
            O00Oo00.O000000o("学号不能为空");
        } else if (this.O0000OOo.size() < 1) {
            O00Oo00.O000000o("请添加1-2张照片");
        } else if (O00O0OOo.O000000o(trim4)) {
            O00000oO(getString(2131689965));
            SchoolNumBackBean schoolNumBackBean = new SchoolNumBackBean(trim, trim2, this.O0000OOo, trim3, trim4, this.O0000Oo);
            gj gjVar = new gj("/api/v19/user/retrievecampusid");
            gjVar.setBodyContent(O000o000.O000000o().toJson((Object) schoolNumBackBean));
            O000000o(HttpUtil.postOp(this.O0000o0, gjVar, new 8(this)));
        } else {
            O00Oo00.O000000o(2131689720);
        }
    }

    public native int O000000o();

    public native void O000000o(int i);

    public native void O00000Oo();

    @PermissionSuccess(requestCode = 100)
    public void O00000o() {
        O00O0O0o.O00000Oo(this.O0000o0);
    }

    @PermissionFail(requestCode = 100)
    public void O00000oO() {
        O00O00o.O000000o(this, 100);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handleChooseSchool(School school) {
        if (school != null) {
            this.O00000o0.setText(school.getName());
            this.O0000Oo = school.getUnid();
        }
    }

    public void n_() {
        UserInfo O00000o0 = O00Oo0.O00000o0();
        if (O00000o0 == null) {
            O00Oo00.O000000o("数据错误，请退出后重试！");
            return;
        }
        this.O000000o.setText(TextUtils.isEmpty(O00000o0.getName()) ? "" : O00000o0.getName());
        this.O00000Oo.setText(TextUtils.isEmpty(O00000o0.getUsername()) ? "" : O00000o0.getUsername());
        this.O00000o0.setText(TextUtils.isEmpty(O00000o0.getCampusName()) ? "" : O00000o0.getCampusName());
        this.O0000Oo = O00000o0.getUnid();
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 1) {
            try {
                String string = PreferenceManager.getDefaultSharedPreferences(this.O0000o0).getString("pl.aprilapps.easyphotopicker.last_photo", null);
                if (!TextUtils.isEmpty(string)) {
                    O00O0O0o.O00000Oo(this.O0000o0, Uri.parse(string));
                }
                if (!TextUtils.isEmpty(string)) {
                    this.O0000Oo0 = O0000Oo0.O000000o(this.O0000o0, 2131689875);
                    this.O0000Oo0.show();
                    O000o00.O000000o(this.O0000o0).O000000o(string).O000000o(new 5(this));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public native void onCreate(Bundle bundle);

    public native void onDestroy();

    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
}
