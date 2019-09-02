package defpackage;

import com.alibaba.wireless.security.jaq.JAQException;
import com.alibaba.wireless.security.jaq.SecurityCipher;
import com.zjwh.android_wh_physicalfitness.O000000o;
import com.zjwh.android_wh_physicalfitness.application.MyApplication;
import com.zjwh.android_wh_physicalfitness.utils.O000OO00;
import org.xutils.http.RequestParams;

/* compiled from: RequestParam */
/* renamed from: gj */
public class gj extends RequestParams {
    public gj(String str) {
        StringBuilder stringBuilder;
        String O00000o0;
        if (O000OO00.O00000Oo().booleanValue()) {
            stringBuilder = new StringBuilder();
            O00000o0 = O000OO00.O00000o0();
        } else {
            stringBuilder = new StringBuilder();
            O00000o0 = O000000o.O0000O0o;
        }
        stringBuilder.append(O00000o0);
        stringBuilder.append(str);
        super(stringBuilder.toString());
    }

    public gj(String str, boolean z) {
        super(str);
    }

    private String O000000o(String str) {
        try {
            return new SecurityCipher(MyApplication.O000000o()).atlasEncryptString(str);
        } catch (JAQException unused) {
            return str;
        }
    }

    public void setBodyContent(String str) {
        super.setBodyContent(O000000o(str));
    }
}
