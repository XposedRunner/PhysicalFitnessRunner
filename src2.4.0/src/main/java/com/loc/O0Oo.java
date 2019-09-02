package com.loc;

import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.GeoLanguage;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.tencent.open.SocialConstants;

/* compiled from: Parser */
public final class O0Oo {
    private StringBuilder O000000o = new StringBuilder();
    private AMapLocationClientOption O00000Oo = new AMapLocationClientOption();

    private void O000000o(AMapLocationServer aMapLocationServer, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str);
            stringBuilder.append(" ");
        }
        if (!TextUtils.isEmpty(str2) && (this.O00000Oo.getGeoLanguage() != GeoLanguage.EN ? !(str.contains("市") && str.equals(str2)) : !str2.equals(str))) {
            stringBuilder.append(str2);
            stringBuilder.append(" ");
        }
        if (!TextUtils.isEmpty(str3)) {
            stringBuilder.append(str3);
            stringBuilder.append(" ");
        }
        if (!TextUtils.isEmpty(str4)) {
            stringBuilder.append(str4);
            stringBuilder.append(" ");
        }
        if (!TextUtils.isEmpty(str5)) {
            stringBuilder.append(str5);
            stringBuilder.append(" ");
        }
        if (!TextUtils.isEmpty(str6)) {
            StringBuilder stringBuilder2;
            if (TextUtils.isEmpty(str7) || this.O00000Oo.getGeoLanguage() == GeoLanguage.EN) {
                stringBuilder2 = new StringBuilder("Near ");
                stringBuilder2.append(str6);
                stringBuilder.append(stringBuilder2.toString());
                stringBuilder2 = new StringBuilder("Near ");
                stringBuilder2.append(str6);
            } else {
                stringBuilder.append("靠近");
                stringBuilder.append(str6);
                stringBuilder.append(" ");
                stringBuilder2 = new StringBuilder("在");
                stringBuilder2.append(str6);
                stringBuilder2.append("附近");
            }
            aMapLocationServer.setDescription(stringBuilder2.toString());
        }
        Bundle bundle = new Bundle();
        bundle.putString("citycode", aMapLocationServer.getCityCode());
        bundle.putString(SocialConstants.PARAM_APP_DESC, stringBuilder.toString());
        bundle.putString("adcode", aMapLocationServer.getAdCode());
        aMapLocationServer.setExtras(bundle);
        aMapLocationServer.g(stringBuilder.toString());
        str = aMapLocationServer.getAdCode();
        str = (str == null || str.trim().length() <= 0 || this.O00000Oo.getGeoLanguage() == GeoLanguage.EN) ? stringBuilder.toString() : stringBuilder.toString().replace(" ", "");
        aMapLocationServer.setAddress(str);
    }

    private static String O00000Oo(String str) {
        return "[]".equals(str) ? "" : str;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:87:0x0161 */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x02c8  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x026e A:{Splitter:B:23:0x00b6, ExcHandler: all (r0_2 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x026e A:{Splitter:B:23:0x00b6, ExcHandler: all (r0_2 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x026e A:{Splitter:B:23:0x00b6, ExcHandler: all (r0_2 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x026e A:{Splitter:B:23:0x00b6, ExcHandler: all (r0_2 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x026e A:{Splitter:B:23:0x00b6, ExcHandler: all (r0_2 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x026e A:{Splitter:B:23:0x00b6, ExcHandler: all (r0_2 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x022a A:{Catch:{ Throwable -> 0x0271, all -> 0x026e }} */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0242 A:{Catch:{ Throwable -> 0x0271, all -> 0x026e }} */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x026a  */
    /* JADX WARNING: Missing exception handler attribute for start block: B:132:0x0224 */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x026e A:{Splitter:B:23:0x00b6, ExcHandler: all (r0_2 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x02b7  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x026e A:{Splitter:B:23:0x00b6, ExcHandler: all (r0_2 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x026e A:{Splitter:B:23:0x00b6, ExcHandler: all (r0_2 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x026e A:{Splitter:B:23:0x00b6, ExcHandler: all (r0_2 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x02ab  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x02b7  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x02c8  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x026e A:{Splitter:B:23:0x00b6, ExcHandler: all (r0_2 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x026e A:{Splitter:B:23:0x00b6, ExcHandler: all (r0_2 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01f2 A:{Catch:{ Throwable -> 0x0271, all -> 0x026e }} */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0201 A:{Catch:{ Throwable -> 0x0271, all -> 0x026e }} */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x020e A:{Catch:{ Throwable -> 0x0271, all -> 0x026e }} */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x022a A:{Catch:{ Throwable -> 0x0271, all -> 0x026e }} */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0242 A:{Catch:{ Throwable -> 0x0271, all -> 0x026e }} */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x026a  */
    /* JADX WARNING: Missing exception handler attribute for start block: B:118:0x01ec */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x026e A:{Splitter:B:23:0x00b6, ExcHandler: all (r0_2 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x026e A:{Splitter:B:23:0x00b6, ExcHandler: all (r0_2 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x026e A:{Splitter:B:23:0x00b6, ExcHandler: all (r0_2 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x026e A:{Splitter:B:23:0x00b6, ExcHandler: all (r0_2 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x026e A:{Splitter:B:23:0x00b6, ExcHandler: all (r0_2 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x026e A:{Splitter:B:23:0x00b6, ExcHandler: all (r0_2 'th' java.lang.Throwable)} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:114:0x01d7 */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x026e A:{Splitter:B:23:0x00b6, ExcHandler: all (r0_2 'th' java.lang.Throwable)} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x00b6 */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x026e A:{Splitter:B:23:0x00b6, ExcHandler: all (r0_2 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01b3 A:{Catch:{ Throwable -> 0x0271, all -> 0x026e }} */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01c2 A:{Catch:{ Throwable -> 0x0271, all -> 0x026e }} */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01f2 A:{Catch:{ Throwable -> 0x0271, all -> 0x026e }} */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0201 A:{Catch:{ Throwable -> 0x0271, all -> 0x026e }} */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x020e A:{Catch:{ Throwable -> 0x0271, all -> 0x026e }} */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x022a A:{Catch:{ Throwable -> 0x0271, all -> 0x026e }} */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0242 A:{Catch:{ Throwable -> 0x0271, all -> 0x026e }} */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x026a  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x02b7  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01b3 A:{Catch:{ Throwable -> 0x0271, all -> 0x026e }} */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01c2 A:{Catch:{ Throwable -> 0x0271, all -> 0x026e }} */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01f2 A:{Catch:{ Throwable -> 0x0271, all -> 0x026e }} */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0201 A:{Catch:{ Throwable -> 0x0271, all -> 0x026e }} */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x020e A:{Catch:{ Throwable -> 0x0271, all -> 0x026e }} */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x022a A:{Catch:{ Throwable -> 0x0271, all -> 0x026e }} */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0242 A:{Catch:{ Throwable -> 0x0271, all -> 0x026e }} */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x026a  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x02b7  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x026e A:{Splitter:B:23:0x00b6, ExcHandler: all (r0_2 'th' java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(61:20|21|22|23|24|25|26|27|28|33|34|35|36|37|38|43|44|45|46|47|48|51|53|54|55|56|57|58|61|63|64|65|66|67|68|71|73|74|75|76|77|78|81|83|84|85|86|87|88|89|90|91|92|95|97|98|99|100|101|103|104) */
    /* JADX WARNING: Missing block: B:29:0x00cc, code skipped:
            r1 = r9;
     */
    /* JADX WARNING: Missing block: B:39:0x00e4, code skipped:
            r2 = r8;
     */
    /* JADX WARNING: Missing block: B:49:0x00fc, code skipped:
            r2 = r3;
     */
    /* JADX WARNING: Missing block: B:59:0x0117, code skipped:
            r2 = r4;
     */
    /* JADX WARNING: Missing block: B:69:0x0130, code skipped:
            r2 = r5;
     */
    /* JADX WARNING: Missing block: B:79:0x0149, code skipped:
            r2 = r6;
     */
    /* JADX WARNING: Missing block: B:93:0x0177, code skipped:
            r2 = r7;
     */
    /* JADX WARNING: Missing block: B:152:0x026e, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:153:0x026f, code skipped:
            r1 = r0;
     */
    /* JADX WARNING: Missing block: B:168:0x02c8, code skipped:
            r15.clear();
     */
    public final com.autonavi.aps.amapapi.model.AMapLocationServer O000000o(com.autonavi.aps.amapapi.model.AMapLocationServer r21, byte[] r22) {
        /*
        r20 = this;
        r10 = r20;
        r11 = r21;
        r12 = 5;
        r14 = 0;
        if (r22 != 0) goto L_0x0031;
    L_0x0008:
        r11.setErrorCode(r12);	 Catch:{ Throwable -> 0x002c, all -> 0x0027 }
        r1 = r10.O000000o;	 Catch:{ Throwable -> 0x002c, all -> 0x0027 }
        r2 = "binaryResult is null#0504";
        r1.append(r2);	 Catch:{ Throwable -> 0x002c, all -> 0x0027 }
        r1 = r10.O000000o;	 Catch:{ Throwable -> 0x002c, all -> 0x0027 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x002c, all -> 0x0027 }
        r11.setLocationDetail(r1);	 Catch:{ Throwable -> 0x002c, all -> 0x0027 }
        r1 = r10.O000000o;	 Catch:{ Throwable -> 0x002c, all -> 0x0027 }
        r2 = r10.O000000o;	 Catch:{ Throwable -> 0x002c, all -> 0x0027 }
        r2 = r2.length();	 Catch:{ Throwable -> 0x002c, all -> 0x0027 }
        r1.delete(r14, r2);	 Catch:{ Throwable -> 0x002c, all -> 0x0027 }
        return r11;
    L_0x0027:
        r0 = move-exception;
        r1 = r0;
        r15 = 0;
        goto L_0x02c6;
    L_0x002c:
        r0 = move-exception;
        r1 = r0;
        r13 = 0;
        goto L_0x0274;
    L_0x0031:
        r15 = java.nio.ByteBuffer.wrap(r22);	 Catch:{ Throwable -> 0x002c, all -> 0x0027 }
        r1 = r15.get();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        if (r1 != 0) goto L_0x004f;
    L_0x003b:
        r1 = r15.getShort();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r11.b(r1);	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r15.clear();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        if (r15 == 0) goto L_0x004e;
    L_0x004b:
        r15.clear();
    L_0x004e:
        return r11;
    L_0x004f:
        r1 = r15.getInt();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r1 = (double) r1;	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r3 = 4696837146684686336; // 0x412e848000000000 float:0.0 double:1000000.0;
        r1 = r1 / r3;
        r1 = com.loc.OO000OO.O000000o(r1);	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r11.setLongitude(r1);	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r1 = r15.getInt();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r1 = (double) r1;	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r1 = r1 / r3;
        r1 = com.loc.OO000OO.O000000o(r1);	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r11.setLatitude(r1);	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r1 = r15.getShort();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r1 = (float) r1;	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r11.setAccuracy(r1);	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r1 = r15.get();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r11.c(r1);	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r1 = r15.get();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r11.d(r1);	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r1 = r15.get();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r9 = 1;
        if (r1 != r9) goto L_0x01a1;
    L_0x0093:
        r1 = "";
        r2 = "";
        r3 = "";
        r4 = "";
        r5 = "";
        r6 = "";
        r7 = "";
        r8 = r15.get();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r8 = r8 & 255;
        r8 = new byte[r8];	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r15.get(r8);	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r9 = new java.lang.String;	 Catch:{ Throwable -> 0x00b6, all -> 0x026e }
        r13 = "UTF-8";
        r9.<init>(r8, r13);	 Catch:{ Throwable -> 0x00b6, all -> 0x026e }
        r11.setCountry(r9);	 Catch:{ Throwable -> 0x00b6, all -> 0x026e }
    L_0x00b6:
        r8 = r15.get();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r8 = r8 & 255;
        r8 = new byte[r8];	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r15.get(r8);	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r9 = new java.lang.String;	 Catch:{ Throwable -> 0x00cd, all -> 0x026e }
        r13 = "UTF-8";
        r9.<init>(r8, r13);	 Catch:{ Throwable -> 0x00cd, all -> 0x026e }
        r11.setProvince(r9);	 Catch:{ Throwable -> 0x00cc, all -> 0x026e }
        goto L_0x00ce;
    L_0x00cc:
        r1 = r9;
    L_0x00cd:
        r9 = r1;
    L_0x00ce:
        r1 = r15.get();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r1 = r1 & 255;
        r1 = new byte[r1];	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r15.get(r1);	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r8 = new java.lang.String;	 Catch:{ Throwable -> 0x00e5, all -> 0x026e }
        r13 = "UTF-8";
        r8.<init>(r1, r13);	 Catch:{ Throwable -> 0x00e5, all -> 0x026e }
        r11.setCity(r8);	 Catch:{ Throwable -> 0x00e4, all -> 0x026e }
        goto L_0x00e6;
    L_0x00e4:
        r2 = r8;
    L_0x00e5:
        r8 = r2;
    L_0x00e6:
        r1 = r15.get();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r1 = r1 & 255;
        r1 = new byte[r1];	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r15.get(r1);	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r2 = new java.lang.String;	 Catch:{ Throwable -> 0x00fc, all -> 0x026e }
        r13 = "UTF-8";
        r2.<init>(r1, r13);	 Catch:{ Throwable -> 0x00fc, all -> 0x026e }
        r11.setDistrict(r2);	 Catch:{ Throwable -> 0x00fd, all -> 0x026e }
        goto L_0x00fd;
    L_0x00fc:
        r2 = r3;
    L_0x00fd:
        r13 = r2;
        r1 = r15.get();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r1 = r1 & 255;
        r1 = new byte[r1];	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r15.get(r1);	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r2 = new java.lang.String;	 Catch:{ Throwable -> 0x0117, all -> 0x026e }
        r3 = "UTF-8";
        r2.<init>(r1, r3);	 Catch:{ Throwable -> 0x0117, all -> 0x026e }
        r11.setStreet(r2);	 Catch:{ Throwable -> 0x0118, all -> 0x026e }
        r11.setRoad(r2);	 Catch:{ Throwable -> 0x0118, all -> 0x026e }
        goto L_0x0118;
    L_0x0117:
        r2 = r4;
    L_0x0118:
        r16 = r2;
        r1 = r15.get();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r1 = r1 & 255;
        r1 = new byte[r1];	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r15.get(r1);	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r2 = new java.lang.String;	 Catch:{ Throwable -> 0x0130, all -> 0x026e }
        r3 = "UTF-8";
        r2.<init>(r1, r3);	 Catch:{ Throwable -> 0x0130, all -> 0x026e }
        r11.setNumber(r2);	 Catch:{ Throwable -> 0x0131, all -> 0x026e }
        goto L_0x0131;
    L_0x0130:
        r2 = r5;
    L_0x0131:
        r17 = r2;
        r1 = r15.get();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r1 = r1 & 255;
        r1 = new byte[r1];	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r15.get(r1);	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r2 = new java.lang.String;	 Catch:{ Throwable -> 0x0149, all -> 0x026e }
        r3 = "UTF-8";
        r2.<init>(r1, r3);	 Catch:{ Throwable -> 0x0149, all -> 0x026e }
        r11.setPoiName(r2);	 Catch:{ Throwable -> 0x014a, all -> 0x026e }
        goto L_0x014a;
    L_0x0149:
        r2 = r6;
    L_0x014a:
        r18 = r2;
        r1 = r15.get();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r1 = r1 & 255;
        r1 = new byte[r1];	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r15.get(r1);	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r2 = new java.lang.String;	 Catch:{ Throwable -> 0x0161, all -> 0x026e }
        r3 = "UTF-8";
        r2.<init>(r1, r3);	 Catch:{ Throwable -> 0x0161, all -> 0x026e }
        r11.setAoiName(r2);	 Catch:{ Throwable -> 0x0161, all -> 0x026e }
    L_0x0161:
        r1 = r15.get();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r1 = r1 & 255;
        r1 = new byte[r1];	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r15.get(r1);	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r2 = new java.lang.String;	 Catch:{ Throwable -> 0x0177, all -> 0x026e }
        r3 = "UTF-8";
        r2.<init>(r1, r3);	 Catch:{ Throwable -> 0x0177, all -> 0x026e }
        r11.setAdCode(r2);	 Catch:{ Throwable -> 0x0178, all -> 0x026e }
        goto L_0x0178;
    L_0x0177:
        r2 = r7;
    L_0x0178:
        r19 = r2;
        r1 = r15.get();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r1 = r1 & 255;
        r1 = new byte[r1];	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r15.get(r1);	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r2 = new java.lang.String;	 Catch:{ Throwable -> 0x018f, all -> 0x026e }
        r3 = "UTF-8";
        r2.<init>(r1, r3);	 Catch:{ Throwable -> 0x018f, all -> 0x026e }
        r11.setCityCode(r2);	 Catch:{ Throwable -> 0x018f, all -> 0x026e }
    L_0x018f:
        r1 = r10;
        r2 = r11;
        r3 = r9;
        r4 = r8;
        r5 = r13;
        r6 = r16;
        r7 = r17;
        r8 = r18;
        r13 = 1;
        r9 = r19;
        r1.O000000o(r2, r3, r4, r5, r6, r7, r8, r9);	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        goto L_0x01a2;
    L_0x01a1:
        r13 = r9;
    L_0x01a2:
        r1 = r15.get();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r1 = r1 & 255;
        r1 = new byte[r1];	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r15.get(r1);	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r1 = r15.get();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        if (r1 != r13) goto L_0x01bc;
    L_0x01b3:
        r15.getInt();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r15.getInt();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r15.getShort();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
    L_0x01bc:
        r1 = r15.get();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        if (r1 != r13) goto L_0x01ec;
    L_0x01c2:
        r1 = r15.get();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r1 = r1 & 255;
        r1 = new byte[r1];	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r15.get(r1);	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r2 = new java.lang.String;	 Catch:{ Throwable -> 0x01d7, all -> 0x026e }
        r3 = "UTF-8";
        r2.<init>(r1, r3);	 Catch:{ Throwable -> 0x01d7, all -> 0x026e }
        r11.setBuildingId(r2);	 Catch:{ Throwable -> 0x01d7, all -> 0x026e }
    L_0x01d7:
        r1 = r15.get();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r1 = r1 & 255;
        r1 = new byte[r1];	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r15.get(r1);	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r2 = new java.lang.String;	 Catch:{ Throwable -> 0x01ec, all -> 0x026e }
        r3 = "UTF-8";
        r2.<init>(r1, r3);	 Catch:{ Throwable -> 0x01ec, all -> 0x026e }
        r11.setFloor(r2);	 Catch:{ Throwable -> 0x01ec, all -> 0x026e }
    L_0x01ec:
        r1 = r15.get();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        if (r1 != r13) goto L_0x01fb;
    L_0x01f2:
        r15.get();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r15.getInt();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r15.get();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
    L_0x01fb:
        r1 = r15.get();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        if (r1 != r13) goto L_0x0208;
    L_0x0201:
        r1 = r15.getLong();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r11.setTime(r1);	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
    L_0x0208:
        r1 = r15.getShort();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        if (r1 <= 0) goto L_0x0224;
    L_0x020e:
        r1 = new byte[r1];	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r15.get(r1);	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r2 = r1.length;	 Catch:{ Throwable -> 0x0224, all -> 0x026e }
        if (r2 <= 0) goto L_0x0224;
    L_0x0216:
        r1 = android.util.Base64.decode(r1, r14);	 Catch:{ Throwable -> 0x0224, all -> 0x026e }
        r2 = new java.lang.String;	 Catch:{ Throwable -> 0x0224, all -> 0x026e }
        r3 = "UTF-8";
        r2.<init>(r1, r3);	 Catch:{ Throwable -> 0x0224, all -> 0x026e }
        r11.a(r2);	 Catch:{ Throwable -> 0x0224, all -> 0x026e }
    L_0x0224:
        r1 = r15.getShort();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        if (r1 <= 0) goto L_0x022f;
    L_0x022a:
        r1 = new byte[r1];	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r15.get(r1);	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
    L_0x022f:
        r1 = "5.1";
        r1 = java.lang.Double.valueOf(r1);	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r1 = r1.doubleValue();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r3 = 4617428107952285286; // 0x4014666666666666 float:2.720083E23 double:5.1;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 < 0) goto L_0x0268;
    L_0x0242:
        r1 = r15.getShort();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r2 = "-1";
        r3 = r21.d();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        r2 = r2.equals(r3);	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        if (r2 != 0) goto L_0x025e;
    L_0x0252:
        r2 = -1;
        if (r1 != r2) goto L_0x0257;
    L_0x0255:
        r1 = r14;
        goto L_0x025a;
    L_0x0257:
        if (r1 != 0) goto L_0x025a;
    L_0x0259:
        r1 = r2;
    L_0x025a:
        r11.setConScenario(r1);	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
        goto L_0x0265;
    L_0x025e:
        r2 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r1 != r2) goto L_0x025a;
    L_0x0262:
        r1 = 100;
        goto L_0x025a;
    L_0x0265:
        r15.get();	 Catch:{ Throwable -> 0x0271, all -> 0x026e }
    L_0x0268:
        if (r15 == 0) goto L_0x02af;
    L_0x026a:
        r15.clear();
        goto L_0x02af;
    L_0x026e:
        r0 = move-exception;
        r1 = r0;
        goto L_0x02c6;
    L_0x0271:
        r0 = move-exception;
        r1 = r0;
        r13 = r15;
    L_0x0274:
        r2 = new com.autonavi.aps.amapapi.model.AMapLocationServer;	 Catch:{ all -> 0x02c3 }
        r3 = "";
        r2.<init>(r3);	 Catch:{ all -> 0x02c3 }
        r2.setErrorCode(r12);	 Catch:{ all -> 0x02c3 }
        r3 = r10.O000000o;	 Catch:{ all -> 0x02c3 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02c3 }
        r5 = "parser data error:";
        r4.<init>(r5);	 Catch:{ all -> 0x02c3 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x02c3 }
        r4.append(r1);	 Catch:{ all -> 0x02c3 }
        r1 = "#0505";
        r4.append(r1);	 Catch:{ all -> 0x02c3 }
        r1 = r4.toString();	 Catch:{ all -> 0x02c3 }
        r3.append(r1);	 Catch:{ all -> 0x02c3 }
        r1 = 2054; // 0x806 float:2.878E-42 double:1.015E-320;
        r3 = 0;
        com.loc.ooO0Ooo.O000000o(r3, r1);	 Catch:{ all -> 0x02c3 }
        r1 = r10.O000000o;	 Catch:{ all -> 0x02c3 }
        r1 = r1.toString();	 Catch:{ all -> 0x02c3 }
        r2.setLocationDetail(r1);	 Catch:{ all -> 0x02c3 }
        if (r13 == 0) goto L_0x02ae;
    L_0x02ab:
        r13.clear();
    L_0x02ae:
        r11 = r2;
    L_0x02af:
        r1 = r10.O000000o;
        r1 = r1.length();
        if (r1 <= 0) goto L_0x02c2;
    L_0x02b7:
        r1 = r10.O000000o;
        r2 = r10.O000000o;
        r2 = r2.length();
        r1.delete(r14, r2);
    L_0x02c2:
        return r11;
    L_0x02c3:
        r0 = move-exception;
        r1 = r0;
        r15 = r13;
    L_0x02c6:
        if (r15 == 0) goto L_0x02cb;
    L_0x02c8:
        r15.clear();
    L_0x02cb:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0Oo.O000000o(com.autonavi.aps.amapapi.model.AMapLocationServer, byte[]):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0088 A:{Catch:{ Throwable -> 0x010b }} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0083 A:{Catch:{ Throwable -> 0x010b }} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00e6 A:{Catch:{ Throwable -> 0x010b }} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d3 A:{Catch:{ Throwable -> 0x010b }} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00f3 A:{Catch:{ Throwable -> 0x010b }} */
    public final com.autonavi.aps.amapapi.model.AMapLocationServer O000000o(java.lang.String r13) {
        /*
        r12 = this;
        r0 = 0;
        r10 = new com.autonavi.aps.amapapi.model.AMapLocationServer;	 Catch:{ Throwable -> 0x010b }
        r1 = "";
        r10.<init>(r1);	 Catch:{ Throwable -> 0x010b }
        r1 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x010b }
        r1.<init>(r13);	 Catch:{ Throwable -> 0x010b }
        r13 = "regeocode";
        r13 = r1.optJSONObject(r13);	 Catch:{ Throwable -> 0x010b }
        r1 = "addressComponent";
        r1 = r13.optJSONObject(r1);	 Catch:{ Throwable -> 0x010b }
        r2 = "country";
        r2 = r1.optString(r2);	 Catch:{ Throwable -> 0x010b }
        r2 = O00000Oo(r2);	 Catch:{ Throwable -> 0x010b }
        r10.setCountry(r2);	 Catch:{ Throwable -> 0x010b }
        r2 = "province";
        r2 = r1.optString(r2);	 Catch:{ Throwable -> 0x010b }
        r3 = O00000Oo(r2);	 Catch:{ Throwable -> 0x010b }
        r10.setProvince(r3);	 Catch:{ Throwable -> 0x010b }
        r2 = "citycode";
        r2 = r1.optString(r2);	 Catch:{ Throwable -> 0x010b }
        r2 = O00000Oo(r2);	 Catch:{ Throwable -> 0x010b }
        r10.setCityCode(r2);	 Catch:{ Throwable -> 0x010b }
        r4 = "city";
        r4 = r1.optString(r4);	 Catch:{ Throwable -> 0x010b }
        r5 = "010";
        r5 = r2.endsWith(r5);	 Catch:{ Throwable -> 0x010b }
        if (r5 != 0) goto L_0x006f;
    L_0x004e:
        r5 = "021";
        r5 = r2.endsWith(r5);	 Catch:{ Throwable -> 0x010b }
        if (r5 != 0) goto L_0x006f;
    L_0x0056:
        r5 = "022";
        r5 = r2.endsWith(r5);	 Catch:{ Throwable -> 0x010b }
        if (r5 != 0) goto L_0x006f;
    L_0x005e:
        r5 = "023";
        r2 = r2.endsWith(r5);	 Catch:{ Throwable -> 0x010b }
        if (r2 == 0) goto L_0x0067;
    L_0x0066:
        goto L_0x006f;
    L_0x0067:
        r2 = O00000Oo(r4);	 Catch:{ Throwable -> 0x010b }
        r10.setCity(r2);	 Catch:{ Throwable -> 0x010b }
        goto L_0x007d;
    L_0x006f:
        if (r3 == 0) goto L_0x007c;
    L_0x0071:
        r2 = r3.length();	 Catch:{ Throwable -> 0x010b }
        if (r2 <= 0) goto L_0x007c;
    L_0x0077:
        r10.setCity(r3);	 Catch:{ Throwable -> 0x010b }
        r2 = r3;
        goto L_0x007d;
    L_0x007c:
        r2 = r4;
    L_0x007d:
        r4 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x010b }
        if (r4 == 0) goto L_0x0088;
    L_0x0083:
        r10.setCity(r3);	 Catch:{ Throwable -> 0x010b }
        r4 = r3;
        goto L_0x0089;
    L_0x0088:
        r4 = r2;
    L_0x0089:
        r2 = "district";
        r2 = r1.optString(r2);	 Catch:{ Throwable -> 0x010b }
        r5 = O00000Oo(r2);	 Catch:{ Throwable -> 0x010b }
        r10.setDistrict(r5);	 Catch:{ Throwable -> 0x010b }
        r2 = "adcode";
        r2 = r1.optString(r2);	 Catch:{ Throwable -> 0x010b }
        r9 = O00000Oo(r2);	 Catch:{ Throwable -> 0x010b }
        r10.setAdCode(r9);	 Catch:{ Throwable -> 0x010b }
        r2 = "streetNumber";
        r1 = r1.optJSONObject(r2);	 Catch:{ Throwable -> 0x010b }
        r2 = "street";
        r2 = r1.optString(r2);	 Catch:{ Throwable -> 0x010b }
        r6 = O00000Oo(r2);	 Catch:{ Throwable -> 0x010b }
        r10.setStreet(r6);	 Catch:{ Throwable -> 0x010b }
        r10.setRoad(r6);	 Catch:{ Throwable -> 0x010b }
        r2 = "number";
        r1 = r1.optString(r2);	 Catch:{ Throwable -> 0x010b }
        r7 = O00000Oo(r1);	 Catch:{ Throwable -> 0x010b }
        r10.setNumber(r7);	 Catch:{ Throwable -> 0x010b }
        r1 = "pois";
        r1 = r13.optJSONArray(r1);	 Catch:{ Throwable -> 0x010b }
        r2 = r1.length();	 Catch:{ Throwable -> 0x010b }
        r8 = 0;
        if (r2 <= 0) goto L_0x00e6;
    L_0x00d3:
        r1 = r1.getJSONObject(r8);	 Catch:{ Throwable -> 0x010b }
        r2 = "name";
        r1 = r1.optString(r2);	 Catch:{ Throwable -> 0x010b }
        r1 = O00000Oo(r1);	 Catch:{ Throwable -> 0x010b }
        r10.setPoiName(r1);	 Catch:{ Throwable -> 0x010b }
        r11 = r1;
        goto L_0x00e7;
    L_0x00e6:
        r11 = r0;
    L_0x00e7:
        r1 = "aois";
        r13 = r13.optJSONArray(r1);	 Catch:{ Throwable -> 0x010b }
        r1 = r13.length();	 Catch:{ Throwable -> 0x010b }
        if (r1 <= 0) goto L_0x0104;
    L_0x00f3:
        r13 = r13.getJSONObject(r8);	 Catch:{ Throwable -> 0x010b }
        r1 = "name";
        r13 = r13.optString(r1);	 Catch:{ Throwable -> 0x010b }
        r13 = O00000Oo(r13);	 Catch:{ Throwable -> 0x010b }
        r10.setAoiName(r13);	 Catch:{ Throwable -> 0x010b }
    L_0x0104:
        r1 = r12;
        r2 = r10;
        r8 = r11;
        r1.O000000o(r2, r3, r4, r5, r6, r7, r8, r9);	 Catch:{ Throwable -> 0x010b }
        return r10;
    L_0x010b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0Oo.O000000o(java.lang.String):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0095 A:{Catch:{ Throwable -> 0x00ad }} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00dc  */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0054 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|(1:4)|5|(1:7)|8|9|(1:13)|14|(1:16)|19|(1:21)|22) */
    /* JADX WARNING: Missing block: B:17:0x00ad, code skipped:
            r6 = move-exception;
     */
    /* JADX WARNING: Missing block: B:18:0x00ae, code skipped:
            r7 = r5.O000000o;
            r7.append("json exception error:");
            r7.append(r6.getMessage());
            r7.append(r1);
            r7.append("#0703");
            com.loc.O0o0000.O000000o(r6, "parser", "paseAuthFailurJson");
     */
    public final com.autonavi.aps.amapapi.model.AMapLocationServer O000000o(java.lang.String r6, android.content.Context r7, com.loc.O00Oo00 r8) {
        /*
        r5 = this;
        r0 = new com.autonavi.aps.amapapi.model.AMapLocationServer;
        r1 = "";
        r0.<init>(r1);
        r1 = 7;
        r0.setErrorCode(r1);
        r1 = new java.lang.StringBuffer;
        r1.<init>();
        r2 = 0;
        r3 = "#SHA1AndPackage#";
        r1.append(r3);	 Catch:{ Throwable -> 0x0054 }
        r7 = com.loc.OO00o00.O00000oO(r7);	 Catch:{ Throwable -> 0x0054 }
        r1.append(r7);	 Catch:{ Throwable -> 0x0054 }
        r7 = r8.O00000Oo;	 Catch:{ Throwable -> 0x0054 }
        r3 = "gsid";
        r7 = r7.get(r3);	 Catch:{ Throwable -> 0x0054 }
        r7 = (java.util.List) r7;	 Catch:{ Throwable -> 0x0054 }
        r7 = r7.get(r2);	 Catch:{ Throwable -> 0x0054 }
        r7 = (java.lang.String) r7;	 Catch:{ Throwable -> 0x0054 }
        r3 = android.text.TextUtils.isEmpty(r7);	 Catch:{ Throwable -> 0x0054 }
        if (r3 != 0) goto L_0x003b;
    L_0x0033:
        r3 = "#gsid#";
        r1.append(r3);	 Catch:{ Throwable -> 0x0054 }
        r1.append(r7);	 Catch:{ Throwable -> 0x0054 }
    L_0x003b:
        r7 = r8.O00000o0;	 Catch:{ Throwable -> 0x0054 }
        r3 = android.text.TextUtils.isEmpty(r7);	 Catch:{ Throwable -> 0x0054 }
        if (r3 != 0) goto L_0x0054;
    L_0x0043:
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0054 }
        r4 = "#csid#";
        r3.<init>(r4);	 Catch:{ Throwable -> 0x0054 }
        r3.append(r7);	 Catch:{ Throwable -> 0x0054 }
        r7 = r3.toString();	 Catch:{ Throwable -> 0x0054 }
        r1.append(r7);	 Catch:{ Throwable -> 0x0054 }
    L_0x0054:
        r7 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x00ad }
        r7.<init>(r6);	 Catch:{ Throwable -> 0x00ad }
        r3 = "status";
        r3 = r7.has(r3);	 Catch:{ Throwable -> 0x00ad }
        if (r3 == 0) goto L_0x0069;
    L_0x0061:
        r3 = "info";
        r3 = r7.has(r3);	 Catch:{ Throwable -> 0x00ad }
        if (r3 != 0) goto L_0x007b;
    L_0x0069:
        r3 = r5.O000000o;	 Catch:{ Throwable -> 0x00ad }
        r4 = "json is error:";
        r3.append(r4);	 Catch:{ Throwable -> 0x00ad }
        r3.append(r6);	 Catch:{ Throwable -> 0x00ad }
        r3.append(r1);	 Catch:{ Throwable -> 0x00ad }
        r6 = "#0702";
        r3.append(r6);	 Catch:{ Throwable -> 0x00ad }
    L_0x007b:
        r6 = "status";
        r6 = r7.getString(r6);	 Catch:{ Throwable -> 0x00ad }
        r3 = "info";
        r3 = r7.getString(r3);	 Catch:{ Throwable -> 0x00ad }
        r4 = "infocode";
        r7 = r7.getString(r4);	 Catch:{ Throwable -> 0x00ad }
        r4 = "0";
        r6 = r4.equals(r6);	 Catch:{ Throwable -> 0x00ad }
        if (r6 == 0) goto L_0x00cb;
    L_0x0095:
        r6 = r5.O000000o;	 Catch:{ Throwable -> 0x00ad }
        r4 = "auth fail:";
        r6.append(r4);	 Catch:{ Throwable -> 0x00ad }
        r6.append(r3);	 Catch:{ Throwable -> 0x00ad }
        r6.append(r1);	 Catch:{ Throwable -> 0x00ad }
        r4 = "#0701";
        r6.append(r4);	 Catch:{ Throwable -> 0x00ad }
        r6 = r8.O00000o;	 Catch:{ Throwable -> 0x00ad }
        com.loc.ooO0Ooo.O000000o(r6, r7, r3);	 Catch:{ Throwable -> 0x00ad }
        goto L_0x00cb;
    L_0x00ad:
        r6 = move-exception;
        r7 = r5.O000000o;
        r8 = "json exception error:";
        r7.append(r8);
        r8 = r6.getMessage();
        r7.append(r8);
        r7.append(r1);
        r8 = "#0703";
        r7.append(r8);
        r7 = "parser";
        r8 = "paseAuthFailurJson";
        com.loc.O0o0000.O000000o(r6, r7, r8);
    L_0x00cb:
        r6 = r5.O000000o;
        r6 = r6.toString();
        r0.setLocationDetail(r6);
        r6 = r5.O000000o;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x00e7;
    L_0x00dc:
        r6 = r5.O000000o;
        r7 = r5.O000000o;
        r7 = r7.length();
        r6.delete(r2, r7);
    L_0x00e7:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0Oo.O000000o(java.lang.String, android.content.Context, com.loc.O00Oo00):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    public final void O000000o(AMapLocationClientOption aMapLocationClientOption) {
        if (aMapLocationClientOption == null) {
            this.O00000Oo = new AMapLocationClientOption();
        } else {
            this.O00000Oo = aMapLocationClientOption;
        }
    }
}
