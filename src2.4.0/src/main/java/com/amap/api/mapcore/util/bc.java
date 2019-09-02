package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.util.List;
import org.json.JSONObject;

/* compiled from: MapParser */
public final class bc {
    private StringBuilder O000000o = new StringBuilder();

    public final ls O000000o(String str, Context context, oOO0Oo00 ooo0oo00) {
        StringBuilder stringBuilder;
        ls lsVar = new ls("");
        lsVar.setErrorCode(7);
        StringBuilder stringBuilder2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!(jSONObject.has("status") && jSONObject.has("info"))) {
                stringBuilder2 = this.O000000o;
                StringBuilder stringBuilder3 = new StringBuilder("json is error ");
                stringBuilder3.append(str);
                stringBuilder2.append(stringBuilder3.toString());
            }
            str = jSONObject.getString("status");
            String string = jSONObject.getString("info");
            if (str.equals("0")) {
                StringBuilder stringBuilder4 = this.O000000o;
                stringBuilder2 = new StringBuilder("auth fail:");
                stringBuilder2.append(string);
                stringBuilder4.append(stringBuilder2.toString());
            }
        } catch (Throwable th) {
            stringBuilder = this.O000000o;
            stringBuilder2 = new StringBuilder("json exception error:");
            stringBuilder2.append(th.getMessage());
            stringBuilder.append(stringBuilder2.toString());
            bp.O000000o(th, "MapParser", "paseAuthFailurJson");
        }
        try {
            stringBuilder = this.O000000o;
            stringBuilder.append("#SHA1AndPackage#");
            stringBuilder.append(o0O0O0Oo.O00000oO(context));
            String str2 = (String) ((List) ooo0oo00.O00000Oo.get("gsid")).get(0);
            if (!TextUtils.isEmpty(str2)) {
                stringBuilder = this.O000000o;
                stringBuilder.append(" #gsid#");
                stringBuilder.append(str2);
            }
            str2 = ooo0oo00.O00000o0;
            if (!TextUtils.isEmpty(str2)) {
                StringBuilder stringBuilder5 = this.O000000o;
                stringBuilder = new StringBuilder(" #csid#");
                stringBuilder.append(str2);
                stringBuilder5.append(stringBuilder.toString());
            }
        } catch (Throwable unused) {
        }
        lsVar.setLocationDetail(this.O000000o.toString());
        if (this.O000000o.length() > 0) {
            this.O000000o.delete(0, this.O000000o.length());
        }
        return lsVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:83:0x0185 A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01af A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01bd A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01cb A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x00dc */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0185 A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01af A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01bd A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01cb A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x020e A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x0122 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:118:0x0262 */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0185 A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01af A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01bd A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01cb A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x020e A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x00c5 */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0185 A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01af A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01bd A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01cb A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x020e A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:76:0x0165 */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0185 A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01af A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01bd A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01cb A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x020e A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x010d */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0185 A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01af A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01bd A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01cb A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x020e A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x00ae */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0185 A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01af A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01bd A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01cb A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x020e A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:68:0x014e */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0185 A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01af A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01bd A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01cb A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x020e A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x00f3 */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02fa  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x027d A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x028c A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:122:0x0277 */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0185 A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01af A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01bd A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01cb A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x020e A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:64:0x0139 */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0185 A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01af A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01bd A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01cb A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x020e A:{Catch:{ Throwable -> 0x02ac }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:80:0x017a */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Can't wrap try/catch for region: R(50:17|18|19|20|21|(4:22|23|24|25)|28|29|(4:30|31|32|33)|36|37|(4:38|39|40|41)|44|45|46|47|48|49|52|53|54|55|56|57|(4:58|59|60|61)|64|65|66|67|68|69|(4:70|71|72|73)|76|77|78|79|80|81|(1:83)|84|(1:90)|91|(1:93)|94|(1:96)|97|(3:99|(1:101)|102)|103|(1:109)(1:107)|108) */
    /* JADX WARNING: Missing block: B:132:0x02a6, code skipped:
            if (r15 != null) goto L_0x02a8;
     */
    /* JADX WARNING: Missing block: B:134:0x02a8, code skipped:
            r15.clear();
     */
    /* JADX WARNING: Missing block: B:135:0x02ac, code skipped:
            r2 = th;
     */
    /* JADX WARNING: Missing block: B:142:0x02e0, code skipped:
            if (r15 != null) goto L_0x02a8;
     */
    /* JADX WARNING: Missing block: B:144:0x02e9, code skipped:
            if (r14.O000000o.length() <= 0) goto L_0x02f6;
     */
    /* JADX WARNING: Missing block: B:145:0x02eb, code skipped:
            r14.O000000o.delete(0, r14.O000000o.length());
     */
    /* JADX WARNING: Missing block: B:146:0x02f6, code skipped:
            return r3;
     */
    public final com.amap.api.mapcore.util.ls O000000o(byte[] r15) {
        /*
        r14 = this;
        r0 = 0;
        r1 = 5;
        r2 = 0;
        r3 = new com.amap.api.mapcore.util.ls;	 Catch:{ Throwable -> 0x02b2, all -> 0x02ae }
        r4 = "";
        r3.<init>(r4);	 Catch:{ Throwable -> 0x02b2, all -> 0x02ae }
        if (r15 != 0) goto L_0x002b;
    L_0x000c:
        r3.setErrorCode(r1);	 Catch:{ Throwable -> 0x02b2, all -> 0x02ae }
        r15 = r14.O000000o;	 Catch:{ Throwable -> 0x02b2, all -> 0x02ae }
        r4 = "byte[] is null";
        r15.append(r4);	 Catch:{ Throwable -> 0x02b2, all -> 0x02ae }
        r15 = r14.O000000o;	 Catch:{ Throwable -> 0x02b2, all -> 0x02ae }
        r15 = r15.toString();	 Catch:{ Throwable -> 0x02b2, all -> 0x02ae }
        r3.setLocationDetail(r15);	 Catch:{ Throwable -> 0x02b2, all -> 0x02ae }
        r15 = r14.O000000o;	 Catch:{ Throwable -> 0x02b2, all -> 0x02ae }
        r4 = r14.O000000o;	 Catch:{ Throwable -> 0x02b2, all -> 0x02ae }
        r4 = r4.length();	 Catch:{ Throwable -> 0x02b2, all -> 0x02ae }
        r15.delete(r0, r4);	 Catch:{ Throwable -> 0x02b2, all -> 0x02ae }
        return r3;
    L_0x002b:
        r15 = java.nio.ByteBuffer.wrap(r15);	 Catch:{ Throwable -> 0x02b2, all -> 0x02ae }
        r2 = r15.get();	 Catch:{ Throwable -> 0x02ac }
        if (r2 != 0) goto L_0x0049;
    L_0x0035:
        r2 = r15.getShort();	 Catch:{ Throwable -> 0x02ac }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ Throwable -> 0x02ac }
        r3.O00000Oo(r2);	 Catch:{ Throwable -> 0x02ac }
        r15.clear();	 Catch:{ Throwable -> 0x02ac }
        if (r15 == 0) goto L_0x0048;
    L_0x0045:
        r15.clear();
    L_0x0048:
        return r3;
    L_0x0049:
        r2 = r15.getInt();	 Catch:{ Throwable -> 0x02ac }
        r4 = (double) r2;	 Catch:{ Throwable -> 0x02ac }
        r6 = 4696837146684686336; // 0x412e848000000000 float:0.0 double:1000000.0;
        r4 = r4 / r6;
        r4 = com.amap.api.mapcore.util.bt.O000000o(r4);	 Catch:{ Throwable -> 0x02ac }
        r3.setLongitude(r4);	 Catch:{ Throwable -> 0x02ac }
        r2 = r15.getInt();	 Catch:{ Throwable -> 0x02ac }
        r4 = (double) r2;	 Catch:{ Throwable -> 0x02ac }
        r4 = r4 / r6;
        r4 = com.amap.api.mapcore.util.bt.O000000o(r4);	 Catch:{ Throwable -> 0x02ac }
        r3.setLatitude(r4);	 Catch:{ Throwable -> 0x02ac }
        r2 = r15.getShort();	 Catch:{ Throwable -> 0x02ac }
        r2 = (float) r2;	 Catch:{ Throwable -> 0x02ac }
        r3.setAccuracy(r2);	 Catch:{ Throwable -> 0x02ac }
        r2 = r15.get();	 Catch:{ Throwable -> 0x02ac }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ Throwable -> 0x02ac }
        r3.O00000o0(r2);	 Catch:{ Throwable -> 0x02ac }
        r2 = r15.get();	 Catch:{ Throwable -> 0x02ac }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ Throwable -> 0x02ac }
        r3.O00000o(r2);	 Catch:{ Throwable -> 0x02ac }
        r2 = r15.get();	 Catch:{ Throwable -> 0x02ac }
        r4 = 1;
        if (r2 != r4) goto L_0x022d;
    L_0x008d:
        r2 = "";
        r5 = "";
        r6 = "";
        r7 = "";
        r8 = "";
        r9 = "";
        r10 = r15.get();	 Catch:{ Throwable -> 0x02ac }
        r10 = r10 & 255;
        r10 = new byte[r10];	 Catch:{ Throwable -> 0x02ac }
        r15.get(r10);	 Catch:{ Throwable -> 0x02ac }
        r11 = new java.lang.String;	 Catch:{ Throwable -> 0x00ae }
        r12 = "UTF-8";
        r11.<init>(r10, r12);	 Catch:{ Throwable -> 0x00ae }
        r3.setCountry(r11);	 Catch:{ Throwable -> 0x00ae }
    L_0x00ae:
        r10 = r15.get();	 Catch:{ Throwable -> 0x02ac }
        r10 = r10 & 255;
        r10 = new byte[r10];	 Catch:{ Throwable -> 0x02ac }
        r15.get(r10);	 Catch:{ Throwable -> 0x02ac }
        r11 = new java.lang.String;	 Catch:{ Throwable -> 0x00c4 }
        r12 = "UTF-8";
        r11.<init>(r10, r12);	 Catch:{ Throwable -> 0x00c4 }
        r3.setProvince(r11);	 Catch:{ Throwable -> 0x00c5 }
        goto L_0x00c5;
    L_0x00c4:
        r11 = r2;
    L_0x00c5:
        r2 = r15.get();	 Catch:{ Throwable -> 0x02ac }
        r2 = r2 & 255;
        r2 = new byte[r2];	 Catch:{ Throwable -> 0x02ac }
        r15.get(r2);	 Catch:{ Throwable -> 0x02ac }
        r10 = new java.lang.String;	 Catch:{ Throwable -> 0x00db }
        r12 = "UTF-8";
        r10.<init>(r2, r12);	 Catch:{ Throwable -> 0x00db }
        r3.setCity(r10);	 Catch:{ Throwable -> 0x00dc }
        goto L_0x00dc;
    L_0x00db:
        r10 = r5;
    L_0x00dc:
        r2 = r15.get();	 Catch:{ Throwable -> 0x02ac }
        r2 = r2 & 255;
        r2 = new byte[r2];	 Catch:{ Throwable -> 0x02ac }
        r15.get(r2);	 Catch:{ Throwable -> 0x02ac }
        r5 = new java.lang.String;	 Catch:{ Throwable -> 0x00f2 }
        r12 = "UTF-8";
        r5.<init>(r2, r12);	 Catch:{ Throwable -> 0x00f2 }
        r3.setDistrict(r5);	 Catch:{ Throwable -> 0x00f3 }
        goto L_0x00f3;
    L_0x00f2:
        r5 = r6;
    L_0x00f3:
        r2 = r15.get();	 Catch:{ Throwable -> 0x02ac }
        r2 = r2 & 255;
        r2 = new byte[r2];	 Catch:{ Throwable -> 0x02ac }
        r15.get(r2);	 Catch:{ Throwable -> 0x02ac }
        r6 = new java.lang.String;	 Catch:{ Throwable -> 0x010c }
        r12 = "UTF-8";
        r6.<init>(r2, r12);	 Catch:{ Throwable -> 0x010c }
        r3.setStreet(r6);	 Catch:{ Throwable -> 0x010d }
        r3.setRoad(r6);	 Catch:{ Throwable -> 0x010d }
        goto L_0x010d;
    L_0x010c:
        r6 = r7;
    L_0x010d:
        r2 = r15.get();	 Catch:{ Throwable -> 0x02ac }
        r2 = r2 & 255;
        r2 = new byte[r2];	 Catch:{ Throwable -> 0x02ac }
        r15.get(r2);	 Catch:{ Throwable -> 0x02ac }
        r7 = new java.lang.String;	 Catch:{ Throwable -> 0x0122 }
        r12 = "UTF-8";
        r7.<init>(r2, r12);	 Catch:{ Throwable -> 0x0122 }
        r3.setNumber(r7);	 Catch:{ Throwable -> 0x0122 }
    L_0x0122:
        r2 = r15.get();	 Catch:{ Throwable -> 0x02ac }
        r2 = r2 & 255;
        r2 = new byte[r2];	 Catch:{ Throwable -> 0x02ac }
        r15.get(r2);	 Catch:{ Throwable -> 0x02ac }
        r7 = new java.lang.String;	 Catch:{ Throwable -> 0x0138 }
        r12 = "UTF-8";
        r7.<init>(r2, r12);	 Catch:{ Throwable -> 0x0138 }
        r3.setPoiName(r7);	 Catch:{ Throwable -> 0x0139 }
        goto L_0x0139;
    L_0x0138:
        r7 = r8;
    L_0x0139:
        r2 = r15.get();	 Catch:{ Throwable -> 0x02ac }
        r2 = r2 & 255;
        r2 = new byte[r2];	 Catch:{ Throwable -> 0x02ac }
        r15.get(r2);	 Catch:{ Throwable -> 0x02ac }
        r8 = new java.lang.String;	 Catch:{ Throwable -> 0x014e }
        r12 = "UTF-8";
        r8.<init>(r2, r12);	 Catch:{ Throwable -> 0x014e }
        r3.setAoiName(r8);	 Catch:{ Throwable -> 0x014e }
    L_0x014e:
        r2 = r15.get();	 Catch:{ Throwable -> 0x02ac }
        r2 = r2 & 255;
        r2 = new byte[r2];	 Catch:{ Throwable -> 0x02ac }
        r15.get(r2);	 Catch:{ Throwable -> 0x02ac }
        r8 = new java.lang.String;	 Catch:{ Throwable -> 0x0164 }
        r12 = "UTF-8";
        r8.<init>(r2, r12);	 Catch:{ Throwable -> 0x0164 }
        r3.setAdCode(r8);	 Catch:{ Throwable -> 0x0165 }
        goto L_0x0165;
    L_0x0164:
        r8 = r9;
    L_0x0165:
        r2 = r15.get();	 Catch:{ Throwable -> 0x02ac }
        r2 = r2 & 255;
        r2 = new byte[r2];	 Catch:{ Throwable -> 0x02ac }
        r15.get(r2);	 Catch:{ Throwable -> 0x02ac }
        r9 = new java.lang.String;	 Catch:{ Throwable -> 0x017a }
        r12 = "UTF-8";
        r9.<init>(r2, r12);	 Catch:{ Throwable -> 0x017a }
        r3.setCityCode(r9);	 Catch:{ Throwable -> 0x017a }
    L_0x017a:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x02ac }
        r2.<init>();	 Catch:{ Throwable -> 0x02ac }
        r9 = android.text.TextUtils.isEmpty(r11);	 Catch:{ Throwable -> 0x02ac }
        if (r9 != 0) goto L_0x018d;
    L_0x0185:
        r2.append(r11);	 Catch:{ Throwable -> 0x02ac }
        r9 = " ";
        r2.append(r9);	 Catch:{ Throwable -> 0x02ac }
    L_0x018d:
        r9 = android.text.TextUtils.isEmpty(r10);	 Catch:{ Throwable -> 0x02ac }
        if (r9 != 0) goto L_0x01a9;
    L_0x0193:
        r9 = "市";
        r9 = r11.contains(r9);	 Catch:{ Throwable -> 0x02ac }
        if (r9 == 0) goto L_0x01a1;
    L_0x019b:
        r9 = r11.equals(r10);	 Catch:{ Throwable -> 0x02ac }
        if (r9 != 0) goto L_0x01a9;
    L_0x01a1:
        r2.append(r10);	 Catch:{ Throwable -> 0x02ac }
        r9 = " ";
        r2.append(r9);	 Catch:{ Throwable -> 0x02ac }
    L_0x01a9:
        r9 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Throwable -> 0x02ac }
        if (r9 != 0) goto L_0x01b7;
    L_0x01af:
        r2.append(r5);	 Catch:{ Throwable -> 0x02ac }
        r5 = " ";
        r2.append(r5);	 Catch:{ Throwable -> 0x02ac }
    L_0x01b7:
        r5 = android.text.TextUtils.isEmpty(r6);	 Catch:{ Throwable -> 0x02ac }
        if (r5 != 0) goto L_0x01c5;
    L_0x01bd:
        r2.append(r6);	 Catch:{ Throwable -> 0x02ac }
        r5 = " ";
        r2.append(r5);	 Catch:{ Throwable -> 0x02ac }
    L_0x01c5:
        r5 = android.text.TextUtils.isEmpty(r7);	 Catch:{ Throwable -> 0x02ac }
        if (r5 != 0) goto L_0x01de;
    L_0x01cb:
        r5 = android.text.TextUtils.isEmpty(r8);	 Catch:{ Throwable -> 0x02ac }
        if (r5 != 0) goto L_0x01d6;
    L_0x01d1:
        r5 = "靠近";
        r2.append(r5);	 Catch:{ Throwable -> 0x02ac }
    L_0x01d6:
        r2.append(r7);	 Catch:{ Throwable -> 0x02ac }
        r5 = " ";
        r2.append(r5);	 Catch:{ Throwable -> 0x02ac }
    L_0x01de:
        r5 = new android.os.Bundle;	 Catch:{ Throwable -> 0x02ac }
        r5.<init>();	 Catch:{ Throwable -> 0x02ac }
        r6 = "citycode";
        r7 = r3.getCityCode();	 Catch:{ Throwable -> 0x02ac }
        r5.putString(r6, r7);	 Catch:{ Throwable -> 0x02ac }
        r6 = "desc";
        r7 = r2.toString();	 Catch:{ Throwable -> 0x02ac }
        r5.putString(r6, r7);	 Catch:{ Throwable -> 0x02ac }
        r6 = "adcode";
        r7 = r3.getAdCode();	 Catch:{ Throwable -> 0x02ac }
        r5.putString(r6, r7);	 Catch:{ Throwable -> 0x02ac }
        r3.setExtras(r5);	 Catch:{ Throwable -> 0x02ac }
        r5 = r2.toString();	 Catch:{ Throwable -> 0x02ac }
        r3.O00000oO(r5);	 Catch:{ Throwable -> 0x02ac }
        r5 = r3.getAdCode();	 Catch:{ Throwable -> 0x02ac }
        if (r5 == 0) goto L_0x0228;
    L_0x020e:
        r5 = r5.trim();	 Catch:{ Throwable -> 0x02ac }
        r5 = r5.length();	 Catch:{ Throwable -> 0x02ac }
        if (r5 <= 0) goto L_0x0228;
    L_0x0218:
        r2 = r2.toString();	 Catch:{ Throwable -> 0x02ac }
        r5 = " ";
        r6 = "";
        r2 = r2.replace(r5, r6);	 Catch:{ Throwable -> 0x02ac }
    L_0x0224:
        r3.setAddress(r2);	 Catch:{ Throwable -> 0x02ac }
        goto L_0x022d;
    L_0x0228:
        r2 = r2.toString();	 Catch:{ Throwable -> 0x02ac }
        goto L_0x0224;
    L_0x022d:
        r2 = r15.get();	 Catch:{ Throwable -> 0x02ac }
        r2 = r2 & 255;
        r2 = new byte[r2];	 Catch:{ Throwable -> 0x02ac }
        r15.get(r2);	 Catch:{ Throwable -> 0x02ac }
        r2 = r15.get();	 Catch:{ Throwable -> 0x02ac }
        if (r2 != r4) goto L_0x0247;
    L_0x023e:
        r15.getInt();	 Catch:{ Throwable -> 0x02ac }
        r15.getInt();	 Catch:{ Throwable -> 0x02ac }
        r15.getShort();	 Catch:{ Throwable -> 0x02ac }
    L_0x0247:
        r2 = r15.get();	 Catch:{ Throwable -> 0x02ac }
        if (r2 != r4) goto L_0x0277;
    L_0x024d:
        r2 = r15.get();	 Catch:{ Throwable -> 0x02ac }
        r2 = r2 & 255;
        r2 = new byte[r2];	 Catch:{ Throwable -> 0x02ac }
        r15.get(r2);	 Catch:{ Throwable -> 0x02ac }
        r5 = new java.lang.String;	 Catch:{ Throwable -> 0x0262 }
        r6 = "UTF-8";
        r5.<init>(r2, r6);	 Catch:{ Throwable -> 0x0262 }
        r3.setBuildingId(r5);	 Catch:{ Throwable -> 0x0262 }
    L_0x0262:
        r2 = r15.get();	 Catch:{ Throwable -> 0x02ac }
        r2 = r2 & 255;
        r2 = new byte[r2];	 Catch:{ Throwable -> 0x02ac }
        r15.get(r2);	 Catch:{ Throwable -> 0x02ac }
        r5 = new java.lang.String;	 Catch:{ Throwable -> 0x0277 }
        r6 = "UTF-8";
        r5.<init>(r2, r6);	 Catch:{ Throwable -> 0x0277 }
        r3.setFloor(r5);	 Catch:{ Throwable -> 0x0277 }
    L_0x0277:
        r2 = r15.get();	 Catch:{ Throwable -> 0x02ac }
        if (r2 != r4) goto L_0x0286;
    L_0x027d:
        r15.get();	 Catch:{ Throwable -> 0x02ac }
        r15.getInt();	 Catch:{ Throwable -> 0x02ac }
        r15.get();	 Catch:{ Throwable -> 0x02ac }
    L_0x0286:
        r2 = r15.get();	 Catch:{ Throwable -> 0x02ac }
        if (r2 != r4) goto L_0x0293;
    L_0x028c:
        r4 = r15.getLong();	 Catch:{ Throwable -> 0x02ac }
        r3.setTime(r4);	 Catch:{ Throwable -> 0x02ac }
    L_0x0293:
        r2 = r15.getShort();	 Catch:{ Throwable -> 0x02ac }
        r2 = new byte[r2];	 Catch:{ Throwable -> 0x02ac }
        r15.get(r2);	 Catch:{ Throwable -> 0x02ac }
        r1 = new java.lang.String;	 Catch:{ Throwable -> 0x02a6 }
        r4 = "UTF-8";
        r1.<init>(r2, r4);	 Catch:{ Throwable -> 0x02a6 }
        r3.O000000o(r1);	 Catch:{ Throwable -> 0x02a6 }
    L_0x02a6:
        if (r15 == 0) goto L_0x02e3;
    L_0x02a8:
        r15.clear();
        goto L_0x02e3;
    L_0x02ac:
        r2 = move-exception;
        goto L_0x02b6;
    L_0x02ae:
        r15 = move-exception;
        r0 = r15;
        r15 = r2;
        goto L_0x02f8;
    L_0x02b2:
        r15 = move-exception;
        r13 = r2;
        r2 = r15;
        r15 = r13;
    L_0x02b6:
        r3 = new com.amap.api.mapcore.util.ls;	 Catch:{ all -> 0x02f7 }
        r4 = "";
        r3.<init>(r4);	 Catch:{ all -> 0x02f7 }
        r3.setErrorCode(r1);	 Catch:{ all -> 0x02f7 }
        r1 = r14.O000000o;	 Catch:{ all -> 0x02f7 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02f7 }
        r5 = "parser data error:";
        r4.<init>(r5);	 Catch:{ all -> 0x02f7 }
        r2 = r2.getMessage();	 Catch:{ all -> 0x02f7 }
        r4.append(r2);	 Catch:{ all -> 0x02f7 }
        r2 = r4.toString();	 Catch:{ all -> 0x02f7 }
        r1.append(r2);	 Catch:{ all -> 0x02f7 }
        r1 = r14.O000000o;	 Catch:{ all -> 0x02f7 }
        r1 = r1.toString();	 Catch:{ all -> 0x02f7 }
        r3.setLocationDetail(r1);	 Catch:{ all -> 0x02f7 }
        if (r15 == 0) goto L_0x02e3;
    L_0x02e2:
        goto L_0x02a8;
    L_0x02e3:
        r15 = r14.O000000o;
        r15 = r15.length();
        if (r15 <= 0) goto L_0x02f6;
    L_0x02eb:
        r15 = r14.O000000o;
        r1 = r14.O000000o;
        r1 = r1.length();
        r15.delete(r0, r1);
    L_0x02f6:
        return r3;
    L_0x02f7:
        r0 = move-exception;
    L_0x02f8:
        if (r15 == 0) goto L_0x02fd;
    L_0x02fa:
        r15.clear();
    L_0x02fd:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.bc.O000000o(byte[]):com.amap.api.mapcore.util.ls");
    }
}
