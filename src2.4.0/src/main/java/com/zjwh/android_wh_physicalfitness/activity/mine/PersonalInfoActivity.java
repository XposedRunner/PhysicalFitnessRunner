package com.zjwh.android_wh_physicalfitness.activity.mine;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.load.resource.bitmap.O0000O0o;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.view.CropImageView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.MultiImageSelectorActivity;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.database.UserInfo;
import com.zjwh.android_wh_physicalfitness.entity.request.QEditUserInfo;
import com.zjwh.android_wh_physicalfitness.ui.mine.ChangeMyCampusActivity;
import com.zjwh.android_wh_physicalfitness.ui.mine.ChangeMyClassActivity;
import com.zjwh.android_wh_physicalfitness.ui.mine.ChangeMyDepartActivity;
import com.zjwh.android_wh_physicalfitness.ui.mine.ChangeNameSchoolNumberActivity;
import com.zjwh.android_wh_physicalfitness.ui.mine.CheckMyPhoneNumActivity;
import com.zjwh.android_wh_physicalfitness.ui.mine.QrCodeActivity;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O000o00;
import com.zjwh.android_wh_physicalfitness.utils.O000o00.O00000o;
import com.zjwh.android_wh_physicalfitness.utils.O00O00o;
import com.zjwh.android_wh_physicalfitness.utils.O00O0O0o;
import com.zjwh.android_wh_physicalfitness.utils.O00O0o0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import com.zjwh.android_wh_physicalfitness.view.dialog.O00000Oo;
import com.zjwh.android_wh_physicalfitness.view.dialog.O00000Oo.O000000o;
import defpackage.O00OOo;
import defpackage.O00Oo;
import defpackage.gj;
import defpackage.gk;
import defpackage.jp;
import defpackage.la;
import java.io.File;
import java.util.ArrayList;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionSuccess;
import org.json.JSONObject;
import org.xutils.common.Callback.CancelledException;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class PersonalInfoActivity extends BaseActivity {
    @ViewInject(2131296691)
    public ImageView O000000o;
    @ViewInject(2131297382)
    public TextView O00000Oo;
    @ViewInject(2131297404)
    public TextView O00000o;
    @ViewInject(2131297371)
    public TextView O00000o0;
    @ViewInject(2131297319)
    public TextView O00000oO;
    @ViewInject(2131297344)
    public TextView O00000oo;
    @ViewInject(2131297355)
    public TextView O0000O0o;
    private String O0000OOo = "";
    @ViewInject(2131297365)
    private TextView O0000Oo;
    private int O0000Oo0 = -1;
    @ViewInject(2131297438)
    private TextView O0000o;
    @ViewInject(2131297384)
    private TextView O0000oO;
    @ViewInject(2131297318)
    private TextView O0000oO0;
    @ViewInject(2131297327)
    private TextView O0000oOO;
    @ViewInject(2131296986)
    private View O0000oOo;
    private UserInfo O0000oo0 = null;

    /* renamed from: com.zjwh.android_wh_physicalfitness.activity.mine.PersonalInfoActivity$6 */
    class AnonymousClass6 implements MyCallback<String> {
        final /* synthetic */ File O000000o;

        AnonymousClass6(File file) {
            this.O000000o = file;
        }

        public void onCancelled(CancelledException cancelledException) {
        }

        public void onError(ResponseError responseError) {
            O00Oo00.O000000o(responseError.getMessage(), false);
        }

        public void onFinished() {
            PersonalInfoActivity.this.O0000OoO();
        }

        public void onSuccess(String str) {
            try {
                O00Oo00.O000000o(PersonalInfoActivity.this.O0000o0, (int) R.string.msg_head_upload_success);
                str = new JSONObject(str).optString("fileUrl");
                O00Oo0.O000000o(PersonalInfoActivity.this, str, PersonalInfoActivity.this.O000000o, PersonalInfoActivity.this.O0000oo0 != null ? PersonalInfoActivity.this.O0000oo0.getSex() : 1);
                this.O000000o.deleteOnExit();
                PersonalInfoActivity.this.O0000oo0.setIcon(str);
                O00Oo0.O000000o(PersonalInfoActivity.this.O0000oo0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static {
        C.i(16777310);
    }

    private void O000000o(final int i, final int i2) {
        try {
            O00000oO(getString(R.string.txt_saving_record));
            QEditUserInfo qEditUserInfo = new QEditUserInfo();
            if (i2 == 1) {
                qEditUserInfo.setHeight((float) i);
                qEditUserInfo.setUpdateHeight(true);
            } else if (i2 == 2) {
                qEditUserInfo.setWeight((float) i);
                qEditUserInfo.setUpdateWeight(true);
            }
            gj gjVar = new gj(gk.O000OoOO);
            gjVar.setBodyContent(this.O0000OoO.toJson(qEditUserInfo));
            O000000o(HttpUtil.post(this.O0000o0, gjVar, new MyCallback<String>() {
                public void onCancelled(CancelledException cancelledException) {
                }

                public void onError(ResponseError responseError) {
                    O00Oo00.O000000o(responseError.getMessage(), false);
                }

                public void onFinished() {
                    PersonalInfoActivity.this.O0000OoO();
                }

                public void onSuccess(String str) {
                    if (i2 == 1) {
                        PersonalInfoActivity.this.O0000oo0.setHeight((float) i);
                    } else if (i2 == 2) {
                        PersonalInfoActivity.this.O0000oo0.setWeight((float) i);
                    }
                    O00Oo0.O000000o(PersonalInfoActivity.this.O0000oo0);
                }
            }));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static native void O000000o(Activity activity);

    private native void O000000o(File file);

    private void O00000oo() {
        try {
            CharSequence stringBuilder;
            CharSequence charSequence;
            StringBuilder stringBuilder2;
            this.O0000oo0 = O00Oo0.O00000o0();
            this.O0000Oo0 = this.O0000oo0.getUid();
            this.O00000Oo.setText(!TextUtils.isEmpty(this.O0000oo0.getPsign()) ? this.O0000oo0.getPsign() : getString(R.string.msg_signature));
            this.O00000o0.setText(this.O0000oo0.getName());
            this.O00000o.setText(this.O0000oo0.getSex() == 1 ? R.string.sex_male : R.string.sex_female);
            this.O0000oO0.setText(this.O0000oo0.getCampusName());
            this.O00000oO.setText(this.O0000oo0.getCampusId());
            this.O00000oo.setText(this.O0000oo0.getDepart());
            int enrollmentYear = this.O0000oo0.getEnrollmentYear();
            TextView textView = this.O0000O0o;
            if (enrollmentYear > 1970) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(enrollmentYear);
                stringBuilder3.append("");
                stringBuilder = stringBuilder3.toString();
            } else {
                stringBuilder = getString(R.string.msg_edit_enrollmentYear);
            }
            textView.setText(stringBuilder);
            this.O0000oO.setText(this.O0000oo0.getUsername());
            enrollmentYear = this.O0000oo0.getSex() == 0 ? R.drawable.default_round_female : R.drawable.default_round_male;
            O00OOo O0000Oo = O00Oo.O000000o((FragmentActivity) this).O000000o(this.O0000oo0.getIcon()).O0000O0o(enrollmentYear).O00000oO(enrollmentYear);
            O0000O0o[] o0000O0oArr = new O0000O0o[1];
            int i = 0;
            o0000O0oArr[0] = new la(this.O0000o0);
            O0000Oo.O000000o(o0000O0oArr).O000000o(this.O000000o);
            TextView textView2 = this.O0000Oo;
            if (this.O0000oo0.getHeight() <= CropImageView.DEFAULT_ASPECT_RATIO) {
                charSequence = this.O0000oo0.getSex() == 0 ? "160CM" : "170CM";
            } else {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append((int) this.O0000oo0.getHeight());
                stringBuilder2.append("CM");
                charSequence = stringBuilder2.toString();
            }
            textView2.setText(charSequence);
            textView2 = this.O0000o;
            if (this.O0000oo0.getWeight() <= CropImageView.DEFAULT_ASPECT_RATIO) {
                charSequence = this.O0000oo0.getSex() == 0 ? "50KG" : "60KG";
            } else {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append((int) this.O0000oo0.getWeight());
                stringBuilder2.append("KG");
                charSequence = stringBuilder2.toString();
            }
            textView2.setText(charSequence);
            this.O0000oOO.setText(this.O0000oo0.getGradeClass());
            View view = this.O0000oOo;
            if (!this.O0000oo0.isShowClassEnum()) {
                i = 8;
            }
            view.setVisibility(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Event(type = OnClickListener.class, value = {2131296589, 2131296995, 2131296994, 2131296996, 2131296850, 2131296985, 2131297001, 2131296990, 2131296997, 2131296998, 2131296986})
    private void onClick(View view) {
        int id = view.getId();
        if (id == R.id.head_layout) {
            O00O00o.O00000o(this);
        } else if (id == R.id.name_layout) {
            ChangeNameSchoolNumberActivity.O000000o((Activity) this);
        } else if (id == R.id.rl_depart) {
            ChangeMyDepartActivity.O000000o((Activity) this);
        } else if (id != R.id.rl_school_number) {
            switch (id) {
                case R.id.rl_campus /*2131296985*/:
                    ChangeMyCampusActivity.O000000o((Activity) this);
                    return;
                case R.id.rl_class /*2131296986*/:
                    ChangeMyClassActivity.O000000o(this, this.O0000oo0.getDepartmentId(), this.O0000oo0.getDepart(), this.O0000oo0.getUnid(), this.O0000oo0.getCampusName().split(" ")[0]);
                    return;
                default:
                    int i = 1;
                    final ArrayList arrayList;
                    StringBuilder stringBuilder;
                    String trim;
                    String str;
                    switch (id) {
                        case R.id.rl_p_height /*2131296994*/:
                            try {
                                arrayList = new ArrayList();
                                while (i <= 300) {
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append(i);
                                    stringBuilder.append("");
                                    arrayList.add(stringBuilder.toString());
                                    i++;
                                }
                                trim = this.O0000Oo.getText().toString().trim();
                                str = (String) (this.O0000oo0.getSex() == 0 ? arrayList.get(159) : arrayList.get(169));
                                if (trim.contains("CM")) {
                                    str = trim.substring(0, trim.indexOf("CM"));
                                }
                                new O00000Oo(this).O000000o().O000000o((int) R.string.txt_sel_height).O000000o(arrayList).O000000o(str).O000000o(new O000000o() {
                                    public void O000000o(int i) {
                                        PersonalInfoActivity.this.O0000Oo.setText(String.format("%sCM", new Object[]{arrayList.get(i)}));
                                        try {
                                            PersonalInfoActivity.this.O000000o(i + 1, 1);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }).O00000Oo();
                                return;
                            } catch (Exception e) {
                                e.printStackTrace();
                                return;
                            }
                        case R.id.rl_p_sign /*2131296995*/:
                            Intent intent = new Intent(this.O0000o0, EditUserInfoActivity.class);
                            intent.putExtra("type", 3);
                            startActivityForResult(intent, 3);
                            return;
                        case R.id.rl_p_weight /*2131296996*/:
                            try {
                                arrayList = new ArrayList();
                                while (i <= 200) {
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append(i);
                                    stringBuilder.append("");
                                    arrayList.add(stringBuilder.toString());
                                    i++;
                                }
                                trim = this.O0000o.getText().toString().trim();
                                str = (String) (this.O0000oo0.getSex() == 0 ? arrayList.get(49) : arrayList.get(59));
                                if (trim.contains("KG")) {
                                    str = trim.substring(0, trim.indexOf("KG"));
                                }
                                new O00000Oo(this).O000000o().O000000o((int) R.string.txt_sel_weight).O000000o(arrayList).O000000o(str).O000000o(new O000000o() {
                                    public void O000000o(int i) {
                                        PersonalInfoActivity.this.O0000o.setText(String.format("%sKG", new Object[]{arrayList.get(i)}));
                                        try {
                                            PersonalInfoActivity.this.O000000o(i + 1, 2);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }).O00000Oo();
                                return;
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                return;
                            }
                        case R.id.rl_phone_number /*2131296997*/:
                            CheckMyPhoneNumActivity.O000000o((Activity) this);
                            return;
                        case R.id.rl_qrcode /*2131296998*/:
                            QrCodeActivity.O000000o(this);
                            return;
                        default:
                            return;
                    }
            }
        } else {
            ChangeNameSchoolNumberActivity.O000000o((Activity) this);
        }
    }

    public native int O000000o();

    public native void O00000Oo();

    @PermissionSuccess(requestCode = 100)
    public void O00000o() {
        O00O0o0.O000000o((Activity) this, 1, 0);
    }

    @PermissionFail(requestCode = 100)
    public void O00000oO() {
        O00O00o.O000000o(this, 100);
    }

    public void n_() {
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        if (i == 69) {
            Uri output = UCrop.getOutput(intent);
            if (output != null) {
                String path = output.getPath();
                O00000oO(getString(R.string.txt_saving_record));
                O000o00.O000000o(this.O0000o0).O000000o(path).O000000o(new O00000o() {
                    public void O000000o() {
                        PersonalInfoActivity.this.O0000OoO();
                        O00Oo00.O000000o(PersonalInfoActivity.this.O0000o0, (int) R.string.msg_set_pic_error);
                    }

                    public void O000000o(File file) {
                        PersonalInfoActivity.this.O000000o(file);
                    }
                });
            }
        } else if (i == 96) {
            O00Oo00.O000000o(this.O0000o0, (int) R.string.msg_set_pic_error);
        } else if (i != 10000) {
            switch (i) {
                case 0:
                    O00O0O0o.O00000Oo(this.O0000o0, intent.getStringArrayListExtra(MultiImageSelectorActivity.O00000o));
                    return;
                case 1:
                    O00O0O0o.O00000oo(this.O0000o0);
                    return;
                case 2:
                    this.O0000OOo = O00O0O0o.O0000O0o(this.O0000o0);
                    if (TextUtils.isEmpty(this.O0000OOo)) {
                        O00Oo00.O000000o(this.O0000o0, (int) R.string.msg_set_pic_error);
                        return;
                    } else {
                        O000000o(new File(this.O0000OOo));
                        return;
                    }
                case 3:
                    O00000oo();
                    return;
                default:
                    return;
            }
        } else {
            UserInfo O00000o0 = O00Oo0.O00000o0();
            O00000o0.setClassId(intent.getIntExtra(jp.O00000o, -1));
            O00000o0.setGradeClass(intent.getStringExtra(jp.O00000oO));
            O00000o0.setShowClassEnum(true);
            O00Oo0.O000000o(O00000o0);
            this.O0000oOO.setText(O00000o0.getGradeClass());
        }
    }

    public native void onCreate(Bundle bundle);

    public native boolean onKeyDown(int i, KeyEvent keyEvent);

    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public native void onResume();
}
