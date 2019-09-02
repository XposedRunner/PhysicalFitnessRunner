package org.apache.commons.codec.language;

import com.umeng.commonsdk.proguard.e;
import com.ximalaya.ting.android.opensdk.auth.constants.XmlyConstants.ClientOSType;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import java.util.Locale;

public class Caverphone2 extends AbstractCaverphone {
    private static final String TEN_1 = "1111111111";

    public String encode(String str) {
        if (str == null || str.length() == 0) {
            return TEN_1;
        }
        str = str.toLowerCase(Locale.ENGLISH).replaceAll("[^a-z]", "").replaceAll("e$", "").replaceAll("^cough", "cou2f").replaceAll("^rough", "rou2f").replaceAll("^tough", "tou2f").replaceAll("^enough", "enou2f").replaceAll("^trough", "trou2f").replaceAll("^gn", "2n").replaceAll("mb$", "m2").replaceAll("cq", "2q").replaceAll("ci", "si").replaceAll("ce", "se").replaceAll("cy", "sy").replaceAll("tch", "2ch").replaceAll("c", "k").replaceAll(DTransferConstants.SEARCH_KEY, "k").replaceAll("x", "k").replaceAll("v", "f").replaceAll("dg", "2g").replaceAll("tio", "sio").replaceAll("tia", "sia").replaceAll(e.am, e.ar).replaceAll("ph", "fh").replaceAll("b", e.ao).replaceAll("sh", "s2").replaceAll("z", e.ap).replaceAll("^[aeiou]", "A").replaceAll("[aeiou]", ClientOSType.WEB_OR_H5).replaceAll("j", "y").replaceAll("^y3", "Y3").replaceAll("^y", "A").replaceAll("y", ClientOSType.WEB_OR_H5).replaceAll("3gh3", "3kh3").replaceAll("gh", "22").replaceAll("g", "k").replaceAll("s+", "S").replaceAll("t+", "T").replaceAll("p+", "P").replaceAll("k+", "K").replaceAll("f+", "F").replaceAll("m+", "M").replaceAll("n+", "N").replaceAll("w3", "W3").replaceAll("wh3", "Wh3").replaceAll("w$", ClientOSType.WEB_OR_H5).replaceAll("w", ClientOSType.ANDROID).replaceAll("^h", "A").replaceAll("h", ClientOSType.ANDROID).replaceAll("r3", "R3").replaceAll("r$", ClientOSType.WEB_OR_H5).replaceAll("r", ClientOSType.ANDROID).replaceAll("l3", "L3").replaceAll("l$", ClientOSType.WEB_OR_H5).replaceAll("l", ClientOSType.ANDROID).replaceAll(ClientOSType.ANDROID, "").replaceAll("3$", "A").replaceAll(ClientOSType.WEB_OR_H5, "");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(TEN_1);
        return stringBuilder.toString().substring(0, TEN_1.length());
    }
}
