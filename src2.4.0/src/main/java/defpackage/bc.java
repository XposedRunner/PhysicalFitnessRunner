package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;

/* compiled from: EncryptHelper */
/* renamed from: bc */
public class bc {
    private static String O000000o = null;
    private static final String O00000Oo = "umeng+";
    private static final String O00000o = "ek_key";
    private static final String O00000o0 = "ek__id";
    private static bc O00000oO;

    private bc() {
    }

    public static bc O000000o() {
        if (O00000oO == null) {
            synchronized (bc.class) {
                if (O00000oO == null) {
                    O00000oO = new bc();
                }
            }
        }
        return O00000oO;
    }

    public String O000000o(String str) {
        try {
            return TextUtils.isEmpty(O000000o) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), O000000o.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    public void O000000o(Context context) {
        try {
            if (TextUtils.isEmpty(O000000o)) {
                String substring;
                CharSequence multiProcessSP = UMUtils.getMultiProcessSP(context, O00000o0);
                if (TextUtils.isEmpty(multiProcessSP)) {
                    multiProcessSP = DeviceConfig.getDBencryptID(context);
                    if (!TextUtils.isEmpty(multiProcessSP)) {
                        UMUtils.setMultiProcessSP(context, O00000o0, multiProcessSP);
                    }
                }
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    substring = multiProcessSP.substring(1, 9);
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < substring.length(); i++) {
                        char charAt = substring.charAt(i);
                        if (!Character.isDigit(charAt)) {
                            stringBuilder.append(charAt);
                        } else if (Integer.parseInt(Character.toString(charAt)) == 0) {
                            stringBuilder.append(0);
                        } else {
                            stringBuilder.append(10 - Integer.parseInt(Character.toString(charAt)));
                        }
                    }
                    O000000o = stringBuilder.toString();
                }
                if (!TextUtils.isEmpty(O000000o)) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(O000000o);
                    stringBuilder2.append(new StringBuilder(O000000o).reverse().toString());
                    O000000o = stringBuilder2.toString();
                    substring = UMUtils.getMultiProcessSP(context, O00000o);
                    if (TextUtils.isEmpty(substring)) {
                        UMUtils.setMultiProcessSP(context, O00000o, O000000o(O00000Oo));
                    } else {
                        O00000Oo.equals(O00000Oo(substring));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public String O00000Oo(String str) {
        try {
            return TextUtils.isEmpty(O000000o) ? str : new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), O000000o.getBytes()));
        } catch (Exception unused) {
            return null;
        }
    }
}
