package cn.jpush.android.e.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageButton;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.d.f;
import com.autonavi.amap.mapcore.AMapEngineUtils;

public final class e {
    private Context a;
    private WindowManager b;
    private WebView c;
    private ImageButton d;

    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            f.d("SystemAlertWebViewCallback", "The activity name is null or empty, Give up..");
        }
        if (this.a != null) {
            try {
                Class cls = Class.forName(str);
                if (cls != null) {
                    Intent intent = new Intent(this.a, cls);
                    intent.putExtra(JPushInterface.EXTRA_ACTIVITY_PARAM, str2);
                    intent.setFlags(AMapEngineUtils.MAX_P20_WIDTH);
                    this.a.startActivity(intent);
                    cn.jpush.android.api.e.a(this.b, this.c, this.d);
                }
            } catch (Exception unused) {
                f.d("SystemAlertWebViewCallback", "The activity name is invalid, Give up..");
            }
        }
    }
}
