package com.google.zxing.oned;

import com.alibaba.wireless.security.SecExceptionCode;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.baidu.mapapi.UIMsg.m_AppUI;
import com.google.zxing.client.result.ExpandedProductParsedResult;
import java.util.ArrayList;
import java.util.List;

final class EANManufacturerOrgSupport {
    private final List<String> countryIdentifiers = new ArrayList();
    private final List<int[]> ranges = new ArrayList();

    EANManufacturerOrgSupport() {
    }

    private void add(int[] iArr, String str) {
        this.ranges.add(iArr);
        this.countryIdentifiers.add(str);
    }

    private synchronized void initIfNeeded() {
        if (this.ranges.isEmpty()) {
            add(new int[]{0, 19}, "US/CA");
            add(new int[]{30, 39}, "US");
            add(new int[]{60, 139}, "US/CA");
            add(new int[]{SecExceptionCode.SEC_ERROR_STA_ENC, 379}, "FR");
            add(new int[]{380}, "BG");
            add(new int[]{383}, "SI");
            add(new int[]{385}, "HR");
            add(new int[]{387}, "BA");
            add(new int[]{SecExceptionCode.SEC_ERROR_DYN_ENC, 440}, "DE");
            add(new int[]{450, 459}, "JP");
            add(new int[]{460, 469}, "RU");
            add(new int[]{471}, "TW");
            add(new int[]{474}, "EE");
            add(new int[]{475}, "LV");
            add(new int[]{476}, "AZ");
            add(new int[]{477}, "LT");
            add(new int[]{478}, "UZ");
            add(new int[]{479}, "LK");
            add(new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH}, "PH");
            add(new int[]{481}, "BY");
            add(new int[]{482}, "UA");
            add(new int[]{484}, "MD");
            add(new int[]{485}, "AM");
            add(new int[]{486}, "GE");
            add(new int[]{487}, "KZ");
            add(new int[]{489}, "HK");
            add(new int[]{490, SecExceptionCode.SEC_ERROR_DYN_ENC_UNKNOWN_ERROR}, "JP");
            add(new int[]{500, 509}, "GB");
            add(new int[]{m_AppUI.MSG_PLACEFIELD_RELOAD}, "GR");
            add(new int[]{528}, ExpandedProductParsedResult.POUND);
            add(new int[]{529}, "CY");
            add(new int[]{531}, "MK");
            add(new int[]{535}, "MT");
            add(new int[]{539}, "IE");
            add(new int[]{540, 549}, "BE/LU");
            add(new int[]{560}, "PT");
            add(new int[]{569}, "IS");
            add(new int[]{570, 579}, "DK");
            add(new int[]{590}, "PL");
            add(new int[]{594}, "RO");
            add(new int[]{SecExceptionCode.SEC_ERROR_DYN_STORE_UNKNOWN_ERROR}, "HU");
            add(new int[]{SecExceptionCode.SEC_ERROR_SIGNATRUE, 601}, "ZA");
            add(new int[]{SecExceptionCode.SEC_ERROR_SIGNATURE_HASHHEX_FAILED}, "GH");
            add(new int[]{SecExceptionCode.SEC_ERROR_SIGNATURE_NO_DATA_FILE}, "BH");
            add(new int[]{SecExceptionCode.SEC_ERROR_SIGNATURE_INCORRECT_DATA_FILE}, "MU");
            add(new int[]{611}, "MA");
            add(new int[]{SecExceptionCode.SEC_ERROR_SIGNATURE_ATLAS_KEY_NOT_EXSITED}, "DZ");
            add(new int[]{616}, "KE");
            add(new int[]{618}, "CI");
            add(new int[]{619}, "TN");
            add(new int[]{621}, "SY");
            add(new int[]{622}, "EG");
            add(new int[]{624}, "LY");
            add(new int[]{625}, "JO");
            add(new int[]{626}, "IR");
            add(new int[]{627}, "KW");
            add(new int[]{628}, "SA");
            add(new int[]{629}, "AE");
            add(new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH, 649}, "FI");
            add(new int[]{690, 695}, "CN");
            add(new int[]{SecExceptionCode.SEC_ERROR_STA_KEY_ENC, 709}, "NO");
            add(new int[]{729}, "IL");
            add(new int[]{730, 739}, "SE");
            add(new int[]{740}, "GT");
            add(new int[]{741}, "SV");
            add(new int[]{742}, "HN");
            add(new int[]{743}, "NI");
            add(new int[]{744}, "CR");
            add(new int[]{745}, "PA");
            add(new int[]{746}, "DO");
            add(new int[]{750}, "MX");
            add(new int[]{754, 755}, "CA");
            add(new int[]{759}, "VE");
            add(new int[]{760, 769}, "CH");
            add(new int[]{770}, "CO");
            add(new int[]{773}, "UY");
            add(new int[]{775}, "PE");
            add(new int[]{777}, "BO");
            add(new int[]{779}, "AR");
            add(new int[]{780}, "CL");
            add(new int[]{784}, "PY");
            add(new int[]{785}, "PE");
            add(new int[]{786}, "EC");
            add(new int[]{789, 790}, "BR");
            add(new int[]{800, 839}, "IT");
            add(new int[]{840, 849}, "ES");
            add(new int[]{850}, "CU");
            add(new int[]{858}, "SK");
            add(new int[]{859}, "CZ");
            add(new int[]{860}, "YU");
            add(new int[]{865}, "MN");
            add(new int[]{867}, "KP");
            add(new int[]{868, 869}, "TR");
            add(new int[]{870, 879}, "NL");
            add(new int[]{880}, "KR");
            add(new int[]{885}, "TH");
            add(new int[]{888}, "SG");
            add(new int[]{890}, "IN");
            add(new int[]{893}, "VN");
            add(new int[]{896}, "PK");
            add(new int[]{SecExceptionCode.SEC_ERROR_PKG_VALID_UNKNOWN_ERR}, "ID");
            add(new int[]{SecExceptionCode.SEC_ERROR_UMID_VALID, 919}, "AT");
            add(new int[]{930, 939}, "AU");
            add(new int[]{940, 949}, "AZ");
            add(new int[]{955}, "MY");
            add(new int[]{958}, "MO");
        }
    }

    /* Access modifiers changed, original: 0000 */
    public String lookupCountryIdentifier(String str) {
        initIfNeeded();
        int parseInt = Integer.parseInt(str.substring(0, 3));
        int size = this.ranges.size();
        for (int i = 0; i < size; i++) {
            int[] iArr = (int[]) this.ranges.get(i);
            int i2 = iArr[0];
            if (parseInt < i2) {
                return null;
            }
            if (iArr.length != 1) {
                i2 = iArr[1];
            }
            if (parseInt <= i2) {
                return (String) this.countryIdentifiers.get(i);
            }
        }
        return null;
    }
}
