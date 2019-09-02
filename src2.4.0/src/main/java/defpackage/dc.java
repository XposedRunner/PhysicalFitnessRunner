package defpackage;

import android.text.TextUtils;
import com.umeng.socialize.Config;
import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000o00;
import com.umeng.socialize.utils.O0000o00.O0000Oo;
import defpackage.dd.O000000o;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

/* compiled from: UClient */
/* renamed from: dc */
public class dc {
    private static final String O000000o = "UClient";
    private static final String O00000Oo = "\r\n";

    /* compiled from: UClient */
    /* renamed from: dc$O000000o */
    protected static class O000000o {
        public JSONObject O000000o;
        public int O00000Oo;

        protected O000000o() {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:87:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x016d A:{Splitter:B:12:0x002c, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0197  */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:44:0x00bd, code skipped:
            if (r4.size() <= 0) goto L_0x00bf;
     */
    /* JADX WARNING: Missing block: B:75:0x016d, code skipped:
            r8 = th;
     */
    /* JADX WARNING: Missing block: B:76:0x016e, code skipped:
            r1 = null;
     */
    /* JADX WARNING: Missing block: B:77:0x0170, code skipped:
            r8 = th;
     */
    /* JADX WARNING: Missing block: B:78:0x0171, code skipped:
            r0 = null;
            r1 = r0;
     */
    /* JADX WARNING: Missing block: B:87:0x0189, code skipped:
            r3.disconnect();
     */
    /* JADX WARNING: Missing block: B:93:0x0197, code skipped:
            r3.disconnect();
     */
    private defpackage.dc.O000000o O000000o(defpackage.dd r8) {
        /*
        r7 = this;
        r0 = r8.e_();
        if (r0 != 0) goto L_0x0009;
    L_0x0006:
        r0 = "";
        goto L_0x0011;
    L_0x0009:
        r0 = r8.e_();
        r0 = r0.toString();
    L_0x0011:
        r1 = java.util.UUID.randomUUID();
        r1 = r1.toString();
        r2 = 0;
        r3 = r7.O00000o0(r8);	 Catch:{ Throwable -> 0x0178, all -> 0x0174 }
        if (r3 != 0) goto L_0x002c;
    L_0x0020:
        r7.O000000o(r2);
        r7.O000000o(r2);
        if (r3 == 0) goto L_0x002b;
    L_0x0028:
        r3.disconnect();
    L_0x002b:
        return r2;
    L_0x002c:
        r4 = r8.O00000oO();	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r5 = r8.O00000oO;	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        if (r5 == 0) goto L_0x0061;
    L_0x0034:
        r0 = "data";
        r0 = r4.get(r0);	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r0 = (java.lang.String) r0;	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r1 = "Content-Type";
        r4 = r8.O00000oO;	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r3.setRequestProperty(r1, r4);	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r1 = r3.getOutputStream();	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r4 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x005d, all -> 0x005a }
        if (r4 != 0) goto L_0x011b;
    L_0x0051:
        r0 = r0.getBytes();	 Catch:{ Throwable -> 0x005d, all -> 0x005a }
        r1.write(r0);	 Catch:{ Throwable -> 0x005d, all -> 0x005a }
        goto L_0x011b;
    L_0x005a:
        r8 = move-exception;
        goto L_0x018f;
    L_0x005d:
        r8 = move-exception;
    L_0x005e:
        r0 = r2;
        goto L_0x017c;
    L_0x0061:
        r5 = r8.O0000OoO;	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r6 = defpackage.dd.O00000o0.APPLICATION;	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        if (r5 != r6) goto L_0x00b7;
    L_0x0067:
        r0 = "Content-Type";
        r1 = "application/x-www-form-urlencoded";
        r3.setRequestProperty(r0, r1);	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r0 = new android.net.Uri$Builder;	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r0.<init>();	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r1 = r4.keySet();	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r1 = r1.iterator();	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
    L_0x007b:
        r5 = r1.hasNext();	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        if (r5 == 0) goto L_0x0098;
    L_0x0081:
        r5 = r1.next();	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r5 = (java.lang.String) r5;	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r6 = r4.get(r5);	 Catch:{ Throwable -> 0x0093, all -> 0x016d }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x0093, all -> 0x016d }
        r0.appendQueryParameter(r5, r6);	 Catch:{ Throwable -> 0x0093, all -> 0x016d }
        goto L_0x007b;
    L_0x0093:
        r5 = move-exception;
        com.umeng.socialize.utils.O0000O0o.O000000o(r5);	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        goto L_0x007b;
    L_0x0098:
        r0 = r0.build();	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r0 = r0.getEncodedQuery();	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r1 = new java.io.DataOutputStream;	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r4 = r3.getOutputStream();	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r1.<init>(r4);	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r4 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x005d, all -> 0x005a }
        if (r4 != 0) goto L_0x011b;
    L_0x00af:
        r0 = r0.getBytes();	 Catch:{ Throwable -> 0x005d, all -> 0x005a }
        r1.write(r0);	 Catch:{ Throwable -> 0x005d, all -> 0x005a }
        goto L_0x011b;
    L_0x00b7:
        if (r4 == 0) goto L_0x00bf;
    L_0x00b9:
        r4 = r4.size();	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        if (r4 > 0) goto L_0x00c5;
    L_0x00bf:
        r4 = r8.O0000OoO;	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r5 = defpackage.dd.O00000o0.MULTIPART;	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        if (r4 != r5) goto L_0x00ec;
    L_0x00c5:
        r0 = "Content-Type";
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r4.<init>();	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r5 = "multipart/form-data; boundary=";
        r4.append(r5);	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r4.append(r1);	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r3.setRequestProperty(r0, r4);	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r0 = r3.getOutputStream();	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r7.O000000o(r8, r0, r1);	 Catch:{ Throwable -> 0x00e8, all -> 0x00e4 }
        r1 = r0;
        goto L_0x011b;
    L_0x00e4:
        r8 = move-exception;
        r1 = r0;
        goto L_0x018f;
    L_0x00e8:
        r8 = move-exception;
        r1 = r0;
        goto L_0x005e;
    L_0x00ec:
        r1 = "Content-Type";
        r4 = "application/x-www-form-urlencoded";
        r3.setRequestProperty(r1, r4);	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r1 = new android.net.Uri$Builder;	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r1.<init>();	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r4 = "content";
        r1.appendQueryParameter(r4, r0);	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r0 = r1.build();	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r0 = r0.getEncodedQuery();	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r1 = new java.io.DataOutputStream;	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r4 = r3.getOutputStream();	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r1.<init>(r4);	 Catch:{ Throwable -> 0x0170, all -> 0x016d }
        r4 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x005d, all -> 0x005a }
        if (r4 != 0) goto L_0x011b;
    L_0x0114:
        r0 = r0.getBytes();	 Catch:{ Throwable -> 0x005d, all -> 0x005a }
        r1.write(r0);	 Catch:{ Throwable -> 0x005d, all -> 0x005a }
    L_0x011b:
        r1.flush();	 Catch:{ Throwable -> 0x005d, all -> 0x005a }
        r0 = r3.getResponseCode();	 Catch:{ Throwable -> 0x005d, all -> 0x005a }
        r4 = new dc$O000000o;	 Catch:{ Throwable -> 0x005d, all -> 0x005a }
        r4.<init>();	 Catch:{ Throwable -> 0x005d, all -> 0x005a }
        r4.O00000Oo = r0;	 Catch:{ Throwable -> 0x005d, all -> 0x005a }
        r5 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 != r5) goto L_0x0161;
    L_0x012d:
        r0 = r3.getInputStream();	 Catch:{ Throwable -> 0x005d, all -> 0x005a }
        r5 = r3.getContentEncoding();	 Catch:{ Throwable -> 0x015f }
        r6 = r3.getRequestMethod();	 Catch:{ Throwable -> 0x015f }
        r8 = r7.O000000o(r8, r6, r5, r0);	 Catch:{ Throwable -> 0x015f }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x015f }
        r5.<init>();	 Catch:{ Throwable -> 0x015f }
        r6 = com.umeng.socialize.utils.O0000o00.O0000Oo.O0000Oo0;	 Catch:{ Throwable -> 0x015f }
        r5.append(r6);	 Catch:{ Throwable -> 0x015f }
        r5.append(r8);	 Catch:{ Throwable -> 0x015f }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x015f }
        com.umeng.socialize.utils.O0000O0o.O00000o0(r5);	 Catch:{ Throwable -> 0x015f }
        r4.O000000o = r8;	 Catch:{ Throwable -> 0x015f }
        r7.O000000o(r0);
        r7.O000000o(r1);
        if (r3 == 0) goto L_0x015e;
    L_0x015b:
        r3.disconnect();
    L_0x015e:
        return r4;
    L_0x015f:
        r8 = move-exception;
        goto L_0x017c;
    L_0x0161:
        r7.O000000o(r2);
        r7.O000000o(r1);
        if (r3 == 0) goto L_0x016c;
    L_0x0169:
        r3.disconnect();
    L_0x016c:
        return r2;
    L_0x016d:
        r8 = move-exception;
        r1 = r2;
        goto L_0x018f;
    L_0x0170:
        r8 = move-exception;
        r0 = r2;
        r1 = r0;
        goto L_0x017c;
    L_0x0174:
        r8 = move-exception;
        r1 = r2;
        r3 = r1;
        goto L_0x018f;
    L_0x0178:
        r8 = move-exception;
        r0 = r2;
        r1 = r0;
        r3 = r1;
    L_0x017c:
        r4 = com.umeng.socialize.utils.O0000o00.O0000Oo.O000000o;	 Catch:{ all -> 0x018d }
        com.umeng.socialize.utils.O0000O0o.O000000o(r4, r8);	 Catch:{ all -> 0x018d }
        r7.O000000o(r0);
        r7.O000000o(r1);
        if (r3 == 0) goto L_0x018c;
    L_0x0189:
        r3.disconnect();
    L_0x018c:
        return r2;
    L_0x018d:
        r8 = move-exception;
        r2 = r0;
    L_0x018f:
        r7.O000000o(r2);
        r7.O000000o(r1);
        if (r3 == 0) goto L_0x019a;
    L_0x0197:
        r3.disconnect();
    L_0x019a:
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dc.O000000o(dd):dc$O000000o");
    }

    private JSONObject O000000o(dd ddVar, String str) {
        try {
            return new JSONObject(ddVar.O0000OOo(str));
        } catch (Throwable th) {
            O0000O0o.O000000o(O0000Oo.O00000oO, th);
            return null;
        }
    }

    private void O000000o(dd ddVar, OutputStream outputStream, String str) throws IOException {
        Object obj;
        StringBuilder stringBuilder = new StringBuilder();
        Map O00000oO = ddVar.O00000oO();
        for (String str2 : O00000oO.keySet()) {
            if (O00000oO.get(str2) != null) {
                O000000o(stringBuilder, str2, O00000oO.get(str2).toString(), str);
            }
        }
        if (stringBuilder.length() > 0) {
            OutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.write(stringBuilder.toString().getBytes());
            outputStream = dataOutputStream;
            obj = 1;
        } else {
            obj = null;
        }
        Map O00000oo = ddVar.O00000oo();
        if (O00000oo != null && O00000oo.size() > 0) {
            for (String str22 : O00000oo.keySet()) {
                O000000o o000000o = (O000000o) O00000oo.get(str22);
                byte[] bArr = o000000o.O00000Oo;
                if (bArr != null) {
                    if (bArr.length >= 1) {
                        O000000o(o000000o.O000000o, bArr, str, outputStream);
                        obj = 1;
                    }
                }
            }
        }
        if (obj != null) {
            O000000o(outputStream, str);
        }
    }

    private void O000000o(OutputStream outputStream, String str) throws IOException {
        outputStream.write(O00000Oo.getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("--");
        stringBuilder.append(str);
        stringBuilder.append("--");
        outputStream.write(stringBuilder.toString().getBytes());
        outputStream.write(O00000Oo.getBytes());
        outputStream.flush();
        outputStream.close();
    }

    private void O000000o(String str) {
        if (TextUtils.isEmpty(str) || dd.O0000o00.equals(str.trim()) == dd.O0000Ooo.equals(str.trim())) {
            throw new RuntimeException(O0000o00.O000000o(str));
        }
    }

    private void O000000o(String str, byte[] bArr, String str2, OutputStream outputStream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("--");
        stringBuilder.append(str2);
        stringBuilder.append(O00000Oo);
        stringBuilder.append("Content-Disposition: form-data; name=\"");
        stringBuilder.append("pic");
        stringBuilder.append("\"; filename=\"");
        stringBuilder.append(str);
        stringBuilder.append("\"");
        stringBuilder.append(O00000Oo);
        stringBuilder.append("Content-Type: ");
        stringBuilder.append("application/octet-stream");
        stringBuilder.append(O00000Oo);
        stringBuilder.append("Content-Transfer-Encoding: binary");
        stringBuilder.append(O00000Oo);
        stringBuilder.append(O00000Oo);
        outputStream.write(stringBuilder.toString().getBytes());
        outputStream.write(bArr);
        outputStream.write(O00000Oo.getBytes());
    }

    private void O000000o(StringBuilder stringBuilder, String str, String str2, String str3) {
        stringBuilder.append("--");
        stringBuilder.append(str3);
        stringBuilder.append(O00000Oo);
        stringBuilder.append("Content-Disposition: form-data; name=\"");
        stringBuilder.append(str);
        stringBuilder.append("\"");
        stringBuilder.append(O00000Oo);
        stringBuilder.append("Content-Type: text/plain; charset=");
        stringBuilder.append("UTF-8");
        stringBuilder.append(O00000Oo);
        stringBuilder.append(O00000Oo);
        stringBuilder.append(str2);
        stringBuilder.append(O00000Oo);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x006b  */
    private defpackage.dc.O000000o O00000Oo(defpackage.dd r7) {
        /*
        r6 = this;
        r0 = 0;
        r1 = r6.O00000o0(r7);	 Catch:{ Throwable -> 0x0054, all -> 0x0050 }
        if (r1 != 0) goto L_0x0010;
    L_0x0007:
        r6.O000000o(r0);
        if (r1 == 0) goto L_0x000f;
    L_0x000c:
        r1.disconnect();
    L_0x000f:
        return r0;
    L_0x0010:
        r2 = r1.getResponseCode();	 Catch:{ Throwable -> 0x004d, all -> 0x004a }
        r3 = new dc$O000000o;	 Catch:{ Throwable -> 0x004d, all -> 0x004a }
        r3.<init>();	 Catch:{ Throwable -> 0x004d, all -> 0x004a }
        r3.O00000Oo = r2;	 Catch:{ Throwable -> 0x004d, all -> 0x004a }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r2 != r4) goto L_0x0041;
    L_0x001f:
        r2 = r1.getInputStream();	 Catch:{ Throwable -> 0x004d, all -> 0x004a }
        r4 = r1.getContentEncoding();	 Catch:{ Throwable -> 0x003f }
        r5 = r1.getRequestMethod();	 Catch:{ Throwable -> 0x003f }
        r7 = r6.O000000o(r7, r5, r4, r2);	 Catch:{ Throwable -> 0x003f }
        r3.O000000o = r7;	 Catch:{ Throwable -> 0x003f }
        r7 = com.umeng.socialize.utils.O0000o00.O0000Oo.O0000Oo;	 Catch:{ Throwable -> 0x003f }
        com.umeng.socialize.utils.O0000O0o.O00000o0(r7);	 Catch:{ Throwable -> 0x003f }
        r6.O000000o(r2);
        if (r1 == 0) goto L_0x003e;
    L_0x003b:
        r1.disconnect();
    L_0x003e:
        return r3;
    L_0x003f:
        r7 = move-exception;
        goto L_0x0057;
    L_0x0041:
        r6.O000000o(r0);
        if (r1 == 0) goto L_0x0049;
    L_0x0046:
        r1.disconnect();
    L_0x0049:
        return r0;
    L_0x004a:
        r7 = move-exception;
        r2 = r0;
        goto L_0x0066;
    L_0x004d:
        r7 = move-exception;
        r2 = r0;
        goto L_0x0057;
    L_0x0050:
        r7 = move-exception;
        r1 = r0;
        r2 = r1;
        goto L_0x0066;
    L_0x0054:
        r7 = move-exception;
        r1 = r0;
        r2 = r1;
    L_0x0057:
        r3 = com.umeng.socialize.utils.O0000o00.O0000Oo.O000000o;	 Catch:{ all -> 0x0065 }
        com.umeng.socialize.utils.O0000O0o.O000000o(r3, r7);	 Catch:{ all -> 0x0065 }
        r6.O000000o(r2);
        if (r1 == 0) goto L_0x0064;
    L_0x0061:
        r1.disconnect();
    L_0x0064:
        return r0;
    L_0x0065:
        r7 = move-exception;
    L_0x0066:
        r6.O000000o(r2);
        if (r1 == 0) goto L_0x006e;
    L_0x006b:
        r1.disconnect();
    L_0x006e:
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dc.O00000Oo(dd):dc$O000000o");
    }

    private HttpURLConnection O00000o0(dd ddVar) throws IOException {
        String trim = ddVar.O0000O0o().trim();
        CharSequence O00000o0 = dd.O0000o00.equals(trim) ? ddVar.O00000o0() : dd.O0000Ooo.equals(trim) ? ddVar.O0000o0o : null;
        if (TextUtils.isEmpty(O00000o0)) {
            return null;
        }
        URL url = new URL(O00000o0);
        HttpURLConnection httpURLConnection = "https".equals(url.getProtocol()) ? (HttpsURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(Config.connectionTimeOut);
        httpURLConnection.setReadTimeout(Config.readSocketTimeOut);
        httpURLConnection.setRequestMethod(trim);
        if (dd.O0000o00.equals(trim)) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            if (ddVar.O00000oo != null && ddVar.O00000oo.size() > 0) {
                for (String str : ddVar.O00000oo.keySet()) {
                    httpURLConnection.setRequestProperty(str, (String) ddVar.O00000oo.get(str));
                }
            }
        } else if (dd.O0000Ooo.equals(trim)) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
        }
        return httpURLConnection;
    }

    /* Access modifiers changed, original: protected */
    public <T extends de> T O000000o(O000000o o000000o, Class<T> cls) {
        if (o000000o == null) {
            return null;
        }
        try {
            return (de) cls.getConstructor(new Class[]{Integer.class, JSONObject.class}).newInstance(new Object[]{Integer.valueOf(o000000o.O00000Oo), o000000o.O000000o});
        } catch (Throwable th) {
            O0000O0o.O000000o(O0000Oo.O00000oO, th);
            return null;
        }
    }

    public <T extends de> T O000000o(dd ddVar, Class<T> cls) {
        ddVar.O000000o();
        String trim = ddVar.O0000O0o().trim();
        O000000o(trim);
        O000000o O00000Oo = dd.O0000o00.equals(trim) ? O00000Oo(ddVar) : dd.O0000Ooo.equals(trim) ? O000000o(ddVar) : null;
        return O000000o(O00000Oo, (Class) cls);
    }

    /* Access modifiers changed, original: protected */
    public InputStream O000000o(String str, InputStream inputStream) throws IOException {
        if (str == null || "identity".equalsIgnoreCase(str)) {
            return inputStream;
        }
        if ("gzip".equalsIgnoreCase(str)) {
            return new GZIPInputStream(inputStream);
        }
        if ("deflate".equalsIgnoreCase(str)) {
            return new InflaterInputStream(inputStream, new Inflater(false), 512);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unsupported content-encoding: ");
        stringBuilder.append(str);
        throw new RuntimeException(stringBuilder.toString());
    }

    /* Access modifiers changed, original: protected */
    public String O000000o(InputStream inputStream) {
        Closeable inputStreamReader = new InputStreamReader(inputStream);
        Closeable bufferedReader = new BufferedReader(inputStreamReader, 512);
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(readLine);
                    stringBuilder2.append("\n");
                    stringBuilder.append(stringBuilder2.toString());
                } else {
                    O000000o(inputStreamReader);
                    O000000o(bufferedReader);
                    return stringBuilder.toString();
                }
            } catch (Throwable th) {
                O000000o(inputStreamReader);
                O000000o(bufferedReader);
                throw th;
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public JSONObject O000000o(dd ddVar, String str, String str2, InputStream inputStream) {
        Throwable th;
        Closeable O000000o;
        try {
            O000000o = O000000o(str2, inputStream);
            String O000000o2;
            JSONObject O000000o3;
            try {
                O000000o2 = O000000o((InputStream) O000000o);
                if ("POST".equals(str)) {
                    JSONObject jSONObject = new JSONObject(O000000o2);
                    O000000o(O000000o);
                    return jSONObject;
                }
                if ("GET".equals(str)) {
                    if (TextUtils.isEmpty(O000000o2)) {
                        O000000o(O000000o);
                        return null;
                    }
                    O000000o3 = O000000o(ddVar, O000000o2);
                    O000000o(O000000o);
                    return O000000o3;
                }
                O000000o(O000000o);
                return null;
            } catch (Throwable th2) {
                th = th2;
                try {
                    O0000O0o.O000000o(O0000Oo.O000000o, th);
                    O000000o(O000000o);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    O000000o(O000000o);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            O000000o = null;
            O000000o(O000000o);
            throw th;
        }
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                O0000O0o.O000000o(O0000Oo.O00000o, th);
            }
        }
    }
}
