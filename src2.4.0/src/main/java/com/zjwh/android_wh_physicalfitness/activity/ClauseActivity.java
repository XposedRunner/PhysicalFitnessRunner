package com.zjwh.android_wh_physicalfitness.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class ClauseActivity extends BaseActivity {
    @ViewInject(2131297328)
    public TextView O000000o;

    static {
        C.i(16777277);
    }

    private void O00000o() {
        try {
            InputStream open = getAssets().open("xieyi.txt");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[2048];
            while (true) {
                int read = open.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    String str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    open.close();
                    byteArrayOutputStream.close();
                    this.O000000o.setText(str);
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Event({2131296679})
    private void onClick(View view) {
        if (view.getId() == R.id.iv_cancel) {
            finish();
        }
    }

    public native int O000000o();

    public native void O00000Oo();

    public void n_() {
    }

    public native void onCreate(Bundle bundle);
}
