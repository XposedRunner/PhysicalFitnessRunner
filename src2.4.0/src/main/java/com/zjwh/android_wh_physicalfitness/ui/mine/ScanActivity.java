package com.zjwh.android_wh_physicalfitness.ui.mine;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.google.zxing.Result;
import com.zjwh.android_wh_physicalfitness.utils.O000o0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import com.zxing.activity.CaptureActivity;
import s.h.e.l.l.C;

public class ScanActivity extends CaptureActivity {
    static {
        C.i(16777340);
    }

    public static native void O000000o(Activity activity);

    public void O000000o(Result result, Bitmap bitmap) {
        super.O000000o(result, bitmap);
        String text = result.getText();
        if (text.equals("")) {
            O00Oo00.O00000Oo("请扫描正确二维码");
            O000000o();
            return;
        }
        try {
            if (O000o0.O000000o(this, text)) {
                finish();
            } else {
                O00Oo00.O00000Oo("请扫描正确二维码");
            }
        } catch (Exception e) {
            e.printStackTrace();
            O00Oo00.O00000Oo("请扫描正确二维码");
        } catch (Throwable th) {
            O000000o();
        }
        O000000o();
    }

    public native void onCreate(Bundle bundle);

    public native void onDestroy();
}
