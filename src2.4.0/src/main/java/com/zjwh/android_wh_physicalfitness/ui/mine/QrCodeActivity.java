package com.zjwh.android_wh_physicalfitness.ui.mine;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.zxing.WriterException;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.database.UserInfo;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import defpackage.mn;
import org.xutils.common.util.DensityUtil;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class QrCodeActivity extends BaseActivity {
    public static final String O000000o = "zjwh://studentInfo?id=";
    @ViewInject(2131296626)
    private ImageView O00000Oo;
    @ViewInject(2131297371)
    private TextView O00000o;
    @ViewInject(2131296691)
    private ImageView O00000o0;
    @ViewInject(2131297404)
    private TextView O00000oO;
    @ViewInject(2131297344)
    private TextView O00000oo;
    @ViewInject(2131297401)
    private TextView O0000O0o;
    private UserInfo O0000OOo;

    static {
        C.i(16777337);
    }

    public static native void O000000o(Activity activity);

    private void O00000o() {
        O00Oo0.O000000o(this.O0000o0, this.O0000OOo.getIcon(), this.O00000o0, this.O0000OOo.getSex());
        this.O00000o.setText(TextUtils.isEmpty(this.O0000OOo.getName()) ? "" : this.O0000OOo.getName());
        this.O00000oO.setText(this.O0000OOo.getSex() == 0 ? "女" : "男");
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(this.O0000OOo.getCampusName())) {
            stringBuilder.append(this.O0000OOo.getCampusName().split(" ")[0]);
            stringBuilder.append(" ");
        }
        if (!TextUtils.isEmpty(this.O0000OOo.getDepart())) {
            stringBuilder.append(this.O0000OOo.getDepart());
        }
        this.O00000oo.setText(stringBuilder.toString());
        this.O0000O0o.setText(TextUtils.isEmpty(this.O0000OOo.getCampusId()) ? "" : this.O0000OOo.getCampusId());
        Bitmap bitmap = null;
        try {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(O000000o);
            stringBuilder2.append(this.O0000OOo.getUid());
            bitmap = mn.O000000o(stringBuilder2.toString(), DensityUtil.dip2px(245.0f), DensityUtil.dip2px(245.0f));
        } catch (WriterException e) {
            e.printStackTrace();
        }
        if (bitmap != null) {
            this.O00000Oo.setImageBitmap(bitmap);
        }
    }

    public native int O000000o();

    public native void O00000Oo();

    public void n_() {
        this.O0000OOo = O00Oo0.O00000o0();
    }

    public native void onCreate(Bundle bundle);
}
