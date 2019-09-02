package defpackage;

import android.os.Bundle;
import com.umeng.socialize.utils.O00000Oo;
import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000o00.O0000Oo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;

/* compiled from: SocializeNetUtils */
/* renamed from: da */
public class da {
    private static final String O000000o = "SocializeNetUtils";

    public static String O000000o(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(readLine);
                    stringBuilder2.append("/n");
                    stringBuilder.append(stringBuilder2.toString());
                } else {
                    try {
                        break;
                    } catch (IOException e) {
                        O0000O0o.O000000o(O0000Oo.O00000Oo, e);
                    }
                }
            } catch (IOException e2) {
                O0000O0o.O000000o(O0000Oo.O00000Oo, e2);
                inputStream.close();
            } catch (Throwable e22) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    O0000O0o.O000000o(O0000Oo.O00000Oo, e3);
                }
                throw e22;
            }
        }
        inputStream.close();
        return stringBuilder.toString();
    }

    public static boolean O000000o(String str) {
        return str.replaceAll("[一-龥]*[a-z]*[A-Z]*\\d*-*_*\\s*", "").length() != 0;
    }

    public static boolean O00000Oo(String str) {
        return str.equals("5126ff896c738f2bfa000438") && !O00000Oo.O00000Oo().equals("com.umeng.soexample");
    }

    public static boolean O00000o(String str) {
        return str.startsWith("http://") || str.startsWith("https://");
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b3 A:{SYNTHETIC, Splitter:B:54:0x00b3} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b3 A:{SYNTHETIC, Splitter:B:54:0x00b3} */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e3 A:{SYNTHETIC, Splitter:B:78:0x00e3} */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e3 A:{SYNTHETIC, Splitter:B:78:0x00e3} */
    public static byte[] O00000o0(java.lang.String r5) {
        /*
        r0 = android.text.TextUtils.isEmpty(r5);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x00a9, all -> 0x00a6 }
        r0.<init>();	 Catch:{ Exception -> 0x00a9, all -> 0x00a6 }
        r2 = new java.net.URL;	 Catch:{ Exception -> 0x00a3, all -> 0x00a1 }
        r2.<init>(r5);	 Catch:{ Exception -> 0x00a3, all -> 0x00a1 }
        r2 = r2.openConnection();	 Catch:{ Exception -> 0x00a3, all -> 0x00a1 }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ Exception -> 0x00a3, all -> 0x00a1 }
        r3 = 1;
        r2.setInstanceFollowRedirects(r3);	 Catch:{ Exception -> 0x00a3, all -> 0x00a1 }
        r3 = com.umeng.socialize.Config.connectionTimeOut;	 Catch:{ Exception -> 0x00a3, all -> 0x00a1 }
        r2.setConnectTimeout(r3);	 Catch:{ Exception -> 0x00a3, all -> 0x00a1 }
        r3 = com.umeng.socialize.Config.readSocketTimeOut;	 Catch:{ Exception -> 0x00a3, all -> 0x00a1 }
        r2.setReadTimeout(r3);	 Catch:{ Exception -> 0x00a3, all -> 0x00a1 }
        r3 = r2.getResponseCode();	 Catch:{ Exception -> 0x00a3, all -> 0x00a1 }
        r4 = 301; // 0x12d float:4.22E-43 double:1.487E-321;
        if (r3 != r4) goto L_0x0045;
    L_0x002e:
        r3 = "Location";
        r2 = r2.getHeaderField(r3);	 Catch:{ Exception -> 0x00a3, all -> 0x00a1 }
        r5 = r2.equals(r5);	 Catch:{ Exception -> 0x00a3, all -> 0x00a1 }
        if (r5 == 0) goto L_0x0040;
    L_0x003a:
        r5 = com.umeng.socialize.utils.O0000o00.O0000Oo.O00000oo;	 Catch:{ Exception -> 0x00a3, all -> 0x00a1 }
        com.umeng.socialize.utils.O0000O0o.O000000o(r5);	 Catch:{ Exception -> 0x00a3, all -> 0x00a1 }
        return r1;
    L_0x0040:
        r5 = defpackage.da.O00000o0(r2);	 Catch:{ Exception -> 0x00a3, all -> 0x00a1 }
        return r5;
    L_0x0045:
        r2 = r2.getInputStream();	 Catch:{ Exception -> 0x00a3, all -> 0x00a1 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x009f }
        r3.<init>();	 Catch:{ Exception -> 0x009f }
        r4 = com.umeng.socialize.utils.O0000o00.O0000OOo.O0000o00;	 Catch:{ Exception -> 0x009f }
        r3.append(r4);	 Catch:{ Exception -> 0x009f }
        r3.append(r5);	 Catch:{ Exception -> 0x009f }
        r5 = r3.toString();	 Catch:{ Exception -> 0x009f }
        com.umeng.socialize.utils.O0000O0o.O00000Oo(r5);	 Catch:{ Exception -> 0x009f }
        r5 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r5 = new byte[r5];	 Catch:{ Exception -> 0x009f }
    L_0x0061:
        r3 = r2.read(r5);	 Catch:{ Exception -> 0x009f }
        r4 = -1;
        if (r3 == r4) goto L_0x006d;
    L_0x0068:
        r4 = 0;
        r0.write(r5, r4, r3);	 Catch:{ Exception -> 0x009f }
        goto L_0x0061;
    L_0x006d:
        r5 = r0.toByteArray();	 Catch:{ Exception -> 0x009f }
        if (r2 == 0) goto L_0x009e;
    L_0x0073:
        r2.close();	 Catch:{ IOException -> 0x0085 }
        if (r0 == 0) goto L_0x009e;
    L_0x0078:
        r0.close();	 Catch:{ IOException -> 0x007c }
        goto L_0x009e;
    L_0x007c:
        r0 = move-exception;
        r1 = com.umeng.socialize.utils.O0000o00.O0000Oo.O00000o;
        com.umeng.socialize.utils.O0000O0o.O000000o(r1, r0);
        goto L_0x009e;
    L_0x0083:
        r5 = move-exception;
        goto L_0x0091;
    L_0x0085:
        r1 = move-exception;
        r2 = com.umeng.socialize.utils.O0000o00.O0000Oo.O00000Oo;	 Catch:{ all -> 0x0083 }
        com.umeng.socialize.utils.O0000O0o.O000000o(r2, r1);	 Catch:{ all -> 0x0083 }
        if (r0 == 0) goto L_0x009e;
    L_0x008d:
        r0.close();	 Catch:{ IOException -> 0x007c }
        goto L_0x009e;
    L_0x0091:
        if (r0 == 0) goto L_0x009d;
    L_0x0093:
        r0.close();	 Catch:{ IOException -> 0x0097 }
        goto L_0x009d;
    L_0x0097:
        r0 = move-exception;
        r1 = com.umeng.socialize.utils.O0000o00.O0000Oo.O00000o;
        com.umeng.socialize.utils.O0000O0o.O000000o(r1, r0);
    L_0x009d:
        throw r5;
    L_0x009e:
        return r5;
    L_0x009f:
        r5 = move-exception;
        goto L_0x00ac;
    L_0x00a1:
        r5 = move-exception;
        goto L_0x00e1;
    L_0x00a3:
        r5 = move-exception;
        r2 = r1;
        goto L_0x00ac;
    L_0x00a6:
        r5 = move-exception;
        r0 = r1;
        goto L_0x00e1;
    L_0x00a9:
        r5 = move-exception;
        r0 = r1;
        r2 = r0;
    L_0x00ac:
        r3 = com.umeng.socialize.utils.O0000o00.O0000Oo.O00000o0;	 Catch:{ all -> 0x00df }
        com.umeng.socialize.utils.O0000O0o.O000000o(r3, r5);	 Catch:{ all -> 0x00df }
        if (r2 == 0) goto L_0x00de;
    L_0x00b3:
        r2.close();	 Catch:{ IOException -> 0x00c5 }
        if (r0 == 0) goto L_0x00de;
    L_0x00b8:
        r0.close();	 Catch:{ IOException -> 0x00bc }
        goto L_0x00de;
    L_0x00bc:
        r5 = move-exception;
        r0 = com.umeng.socialize.utils.O0000o00.O0000Oo.O00000o;
        com.umeng.socialize.utils.O0000O0o.O000000o(r0, r5);
        goto L_0x00de;
    L_0x00c3:
        r5 = move-exception;
        goto L_0x00d1;
    L_0x00c5:
        r5 = move-exception;
        r2 = com.umeng.socialize.utils.O0000o00.O0000Oo.O00000Oo;	 Catch:{ all -> 0x00c3 }
        com.umeng.socialize.utils.O0000O0o.O000000o(r2, r5);	 Catch:{ all -> 0x00c3 }
        if (r0 == 0) goto L_0x00de;
    L_0x00cd:
        r0.close();	 Catch:{ IOException -> 0x00bc }
        goto L_0x00de;
    L_0x00d1:
        if (r0 == 0) goto L_0x00dd;
    L_0x00d3:
        r0.close();	 Catch:{ IOException -> 0x00d7 }
        goto L_0x00dd;
    L_0x00d7:
        r0 = move-exception;
        r1 = com.umeng.socialize.utils.O0000o00.O0000Oo.O00000o;
        com.umeng.socialize.utils.O0000O0o.O000000o(r1, r0);
    L_0x00dd:
        throw r5;
    L_0x00de:
        return r1;
    L_0x00df:
        r5 = move-exception;
        r1 = r2;
    L_0x00e1:
        if (r1 == 0) goto L_0x010e;
    L_0x00e3:
        r1.close();	 Catch:{ IOException -> 0x00f5 }
        if (r0 == 0) goto L_0x010e;
    L_0x00e8:
        r0.close();	 Catch:{ IOException -> 0x00ec }
        goto L_0x010e;
    L_0x00ec:
        r0 = move-exception;
        r1 = com.umeng.socialize.utils.O0000o00.O0000Oo.O00000o;
        com.umeng.socialize.utils.O0000O0o.O000000o(r1, r0);
        goto L_0x010e;
    L_0x00f3:
        r5 = move-exception;
        goto L_0x0101;
    L_0x00f5:
        r1 = move-exception;
        r2 = com.umeng.socialize.utils.O0000o00.O0000Oo.O00000Oo;	 Catch:{ all -> 0x00f3 }
        com.umeng.socialize.utils.O0000O0o.O000000o(r2, r1);	 Catch:{ all -> 0x00f3 }
        if (r0 == 0) goto L_0x010e;
    L_0x00fd:
        r0.close();	 Catch:{ IOException -> 0x00ec }
        goto L_0x010e;
    L_0x0101:
        if (r0 == 0) goto L_0x010d;
    L_0x0103:
        r0.close();	 Catch:{ IOException -> 0x0107 }
        goto L_0x010d;
    L_0x0107:
        r0 = move-exception;
        r1 = com.umeng.socialize.utils.O0000o00.O0000Oo.O00000o;
        com.umeng.socialize.utils.O0000O0o.O000000o(r1, r0);
    L_0x010d:
        throw r5;
    L_0x010e:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.da.O00000o0(java.lang.String):byte[]");
    }

    public static Bundle O00000oO(String str) {
        try {
            URL url = new URL(str);
            Bundle O0000O0o = da.O0000O0o(url.getQuery());
            O0000O0o.putAll(da.O0000O0o(url.getRef()));
            return O0000O0o;
        } catch (MalformedURLException e) {
            O0000O0o.O000000o(O0000Oo.O00000Oo, e);
            return new Bundle();
        }
    }

    public static Bundle O00000oo(String str) {
        try {
            return da.O0000O0o(new URI(str).getQuery());
        } catch (Exception e) {
            O0000O0o.O000000o(O0000Oo.O00000Oo, e);
            return new Bundle();
        }
    }

    public static Bundle O0000O0o(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                try {
                    bundle.putString(URLDecoder.decode(split2[0], "UTF-8"), URLDecoder.decode(split2[1], "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    O0000O0o.O000000o(O0000Oo.O00000Oo, e);
                }
            }
        }
        return bundle;
    }

    public static String O0000OOo(String str) {
        String str2 = "";
        try {
            URLConnection openConnection = new URL(str).openConnection();
            if (openConnection == null) {
                return str2;
            }
            openConnection.connect();
            InputStream inputStream = openConnection.getInputStream();
            return inputStream == null ? str2 : da.O000000o(inputStream);
        } catch (Exception e) {
            O0000O0o.O000000o(O0000Oo.O00000Oo, e);
            return str2;
        }
    }
}
