package com.qiyukf.nimlib.d.a.a;

import cn.jiguang.net.HttpUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Map;

public final class a {
    private static final Integer a = Integer.valueOf(30000);

    static class a<T> {
        int a = 0;
        Throwable b = null;
        T c = null;

        a() {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a9  */
    public static com.qiyukf.nimlib.d.a.a.a.a<java.lang.String> a(java.lang.String r4, java.util.Map<java.lang.String, java.lang.String> r5) {
        /*
        r0 = new java.lang.StringBuilder;
        r1 = "http get url=";
        r0.<init>(r1);
        r0.append(r4);
        r0 = r0.toString();
        com.qiyukf.nimlib.d.a.b.a.d(r0);
        r0 = new com.qiyukf.nimlib.d.a.a.a$a;
        r0.<init>();
        r1 = 0;
        r2 = new java.net.URL;	 Catch:{ IOException -> 0x0084 }
        r2.<init>(r4);	 Catch:{ IOException -> 0x0084 }
        r2 = r2.openConnection();	 Catch:{ IOException -> 0x0084 }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ IOException -> 0x0084 }
        a(r2);	 Catch:{ IOException -> 0x0084 }
        r3 = "GET";
        r2.setRequestMethod(r3);	 Catch:{ IOException -> 0x0084 }
        a(r2, r5);	 Catch:{ IOException -> 0x0084 }
        r5 = r2.getResponseCode();	 Catch:{ IOException -> 0x007e, all -> 0x007c }
        r0.a = r5;	 Catch:{ IOException -> 0x007e, all -> 0x007c }
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r5 != r1) goto L_0x005f;
    L_0x0037:
        r5 = r2.getInputStream();	 Catch:{ IOException -> 0x007e, all -> 0x007c }
        r5 = a(r5);	 Catch:{ IOException -> 0x007e, all -> 0x007c }
        r0.c = r5;	 Catch:{ IOException -> 0x007e, all -> 0x007c }
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x007e, all -> 0x007c }
        r1 = "http get success, result=";
        r5.<init>(r1);	 Catch:{ IOException -> 0x007e, all -> 0x007c }
        r1 = r0.c;	 Catch:{ IOException -> 0x007e, all -> 0x007c }
        r1 = (java.lang.String) r1;	 Catch:{ IOException -> 0x007e, all -> 0x007c }
        r5.append(r1);	 Catch:{ IOException -> 0x007e, all -> 0x007c }
        r1 = ", url=";
        r5.append(r1);	 Catch:{ IOException -> 0x007e, all -> 0x007c }
        r5.append(r4);	 Catch:{ IOException -> 0x007e, all -> 0x007c }
        r5 = r5.toString();	 Catch:{ IOException -> 0x007e, all -> 0x007c }
    L_0x005b:
        com.qiyukf.nimlib.d.a.b.a.d(r5);	 Catch:{ IOException -> 0x007e, all -> 0x007c }
        goto L_0x0076;
    L_0x005f:
        r1 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x007e, all -> 0x007c }
        r3 = "http get failed, code=";
        r1.<init>(r3);	 Catch:{ IOException -> 0x007e, all -> 0x007c }
        r1.append(r5);	 Catch:{ IOException -> 0x007e, all -> 0x007c }
        r5 = ", url=";
        r1.append(r5);	 Catch:{ IOException -> 0x007e, all -> 0x007c }
        r1.append(r4);	 Catch:{ IOException -> 0x007e, all -> 0x007c }
        r5 = r1.toString();	 Catch:{ IOException -> 0x007e, all -> 0x007c }
        goto L_0x005b;
    L_0x0076:
        if (r2 == 0) goto L_0x00ac;
    L_0x0078:
        r2.disconnect();
        return r0;
    L_0x007c:
        r4 = move-exception;
        goto L_0x00ad;
    L_0x007e:
        r5 = move-exception;
        r1 = r2;
        goto L_0x0085;
    L_0x0081:
        r4 = move-exception;
        r2 = r1;
        goto L_0x00ad;
    L_0x0084:
        r5 = move-exception;
    L_0x0085:
        r5.printStackTrace();	 Catch:{ all -> 0x0081 }
        r0.b = r5;	 Catch:{ all -> 0x0081 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0081 }
        r3 = "http get error, e=";
        r2.<init>(r3);	 Catch:{ all -> 0x0081 }
        r5 = r5.getMessage();	 Catch:{ all -> 0x0081 }
        r2.append(r5);	 Catch:{ all -> 0x0081 }
        r5 = ", url=";
        r2.append(r5);	 Catch:{ all -> 0x0081 }
        r2.append(r4);	 Catch:{ all -> 0x0081 }
        r4 = r2.toString();	 Catch:{ all -> 0x0081 }
        com.qiyukf.nimlib.d.a.b.a.d(r4);	 Catch:{ all -> 0x0081 }
        if (r1 == 0) goto L_0x00ac;
    L_0x00a9:
        r1.disconnect();
    L_0x00ac:
        return r0;
    L_0x00ad:
        if (r2 == 0) goto L_0x00b2;
    L_0x00af:
        r2.disconnect();
    L_0x00b2:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.d.a.a.a.a(java.lang.String, java.util.Map):com.qiyukf.nimlib.d.a.a.a$a");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0093  */
    public static <T> com.qiyukf.nimlib.d.a.a.a.a<java.lang.String> a(java.lang.String r3, java.util.Map<java.lang.String, java.lang.String> r4, T r5) {
        /*
        r0 = new java.lang.StringBuilder;
        r1 = "http post url=";
        r0.<init>(r1);
        r0.append(r3);
        r0 = r0.toString();
        com.qiyukf.nimlib.d.a.b.a.d(r0);
        r0 = new com.qiyukf.nimlib.d.a.a.a$a;
        r0.<init>();
        r1 = 0;
        r4 = b(r3, r4, r5);	 Catch:{ IOException -> 0x006e }
        r5 = r4.getResponseCode();	 Catch:{ IOException -> 0x0068, all -> 0x0066 }
        r0.a = r5;	 Catch:{ IOException -> 0x0068, all -> 0x0066 }
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r5 != r1) goto L_0x0049;
    L_0x0025:
        r5 = r4.getInputStream();	 Catch:{ IOException -> 0x0068, all -> 0x0066 }
        r5 = a(r5);	 Catch:{ IOException -> 0x0068, all -> 0x0066 }
        r0.c = r5;	 Catch:{ IOException -> 0x0068, all -> 0x0066 }
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0068, all -> 0x0066 }
        r1 = "http post success, result=";
        r5.<init>(r1);	 Catch:{ IOException -> 0x0068, all -> 0x0066 }
        r5.append(r0);	 Catch:{ IOException -> 0x0068, all -> 0x0066 }
        r1 = ", url=";
        r5.append(r1);	 Catch:{ IOException -> 0x0068, all -> 0x0066 }
        r5.append(r3);	 Catch:{ IOException -> 0x0068, all -> 0x0066 }
        r5 = r5.toString();	 Catch:{ IOException -> 0x0068, all -> 0x0066 }
    L_0x0045:
        com.qiyukf.nimlib.d.a.b.a.d(r5);	 Catch:{ IOException -> 0x0068, all -> 0x0066 }
        goto L_0x0060;
    L_0x0049:
        r1 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0068, all -> 0x0066 }
        r2 = "http post failed, code=";
        r1.<init>(r2);	 Catch:{ IOException -> 0x0068, all -> 0x0066 }
        r1.append(r5);	 Catch:{ IOException -> 0x0068, all -> 0x0066 }
        r5 = ", url=";
        r1.append(r5);	 Catch:{ IOException -> 0x0068, all -> 0x0066 }
        r1.append(r3);	 Catch:{ IOException -> 0x0068, all -> 0x0066 }
        r5 = r1.toString();	 Catch:{ IOException -> 0x0068, all -> 0x0066 }
        goto L_0x0045;
    L_0x0060:
        if (r4 == 0) goto L_0x0096;
    L_0x0062:
        r4.disconnect();
        return r0;
    L_0x0066:
        r3 = move-exception;
        goto L_0x0097;
    L_0x0068:
        r5 = move-exception;
        r1 = r4;
        goto L_0x006f;
    L_0x006b:
        r3 = move-exception;
        r4 = r1;
        goto L_0x0097;
    L_0x006e:
        r5 = move-exception;
    L_0x006f:
        r5.printStackTrace();	 Catch:{ all -> 0x006b }
        r0.b = r5;	 Catch:{ all -> 0x006b }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x006b }
        r2 = "http post error, e=";
        r4.<init>(r2);	 Catch:{ all -> 0x006b }
        r5 = r5.getMessage();	 Catch:{ all -> 0x006b }
        r4.append(r5);	 Catch:{ all -> 0x006b }
        r5 = ", url=";
        r4.append(r5);	 Catch:{ all -> 0x006b }
        r4.append(r3);	 Catch:{ all -> 0x006b }
        r3 = r4.toString();	 Catch:{ all -> 0x006b }
        com.qiyukf.nimlib.d.a.b.a.d(r3);	 Catch:{ all -> 0x006b }
        if (r1 == 0) goto L_0x0096;
    L_0x0093:
        r1.disconnect();
    L_0x0096:
        return r0;
    L_0x0097:
        if (r4 == 0) goto L_0x009c;
    L_0x0099:
        r4.disconnect();
    L_0x009c:
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.d.a.a.a.a(java.lang.String, java.util.Map, java.lang.Object):com.qiyukf.nimlib.d.a.a.a$a");
    }

    private static String a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    inputStream.close();
                    byteArrayOutputStream.close();
                    return new String(byteArrayOutputStream.toByteArray(), HttpUtils.ENCODING_UTF_8);
                }
            }
        } catch (IOException e) {
            throw e;
        } catch (Throwable th) {
            inputStream.close();
            byteArrayOutputStream.close();
        }
    }

    private static void a(HttpURLConnection httpURLConnection) {
        httpURLConnection.setReadTimeout(a.intValue());
        httpURLConnection.setConnectTimeout(a.intValue());
        httpURLConnection.setUseCaches(false);
    }

    private static void a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        httpURLConnection.setRequestProperty("charset", HttpUtils.ENCODING_UTF_8);
        if (map != null) {
            for (String str : map.keySet()) {
                httpURLConnection.setRequestProperty(str, (String) map.get(str));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0095 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0094  */
    private static <T> java.net.HttpURLConnection b(java.lang.String r3, java.util.Map<java.lang.String, java.lang.String> r4, T r5) {
        /*
        r0 = new java.net.URL;
        r0.<init>(r3);
        r3 = r0.openConnection();
        r3 = (java.net.HttpURLConnection) r3;
        a(r3);
        r0 = "POST";
        r3.setRequestMethod(r0);
        r0 = 1;
        r3.setDoOutput(r0);
        r3.setDoInput(r0);
        a(r3, r4);
        r1 = r5 instanceof org.json.JSONObject;
        if (r1 == 0) goto L_0x0028;
    L_0x0021:
        r1 = "Content-Type";
        r2 = "application/json";
        r3.setRequestProperty(r1, r2);
    L_0x0028:
        if (r4 == 0) goto L_0x0041;
    L_0x002a:
        r1 = "Content-Encoding";
        r1 = r4.containsKey(r1);
        if (r1 == 0) goto L_0x0041;
    L_0x0032:
        r1 = "gzip";
        r2 = "Content-Encoding";
        r4 = r4.get(r2);
        r4 = r1.equals(r4);
        if (r4 == 0) goto L_0x0041;
    L_0x0040:
        goto L_0x0042;
    L_0x0041:
        r0 = 0;
    L_0x0042:
        if (r0 == 0) goto L_0x004e;
    L_0x0044:
        r4 = new java.util.zip.GZIPOutputStream;
        r0 = r3.getOutputStream();
        r4.<init>(r0);
        goto L_0x0052;
    L_0x004e:
        r4 = r3.getOutputStream();
    L_0x0052:
        r0 = new java.io.DataOutputStream;
        r0.<init>(r4);
        r1 = 0;
        r2 = r5 instanceof java.lang.String;	 Catch:{ IOException -> 0x008a, all -> 0x0082 }
        if (r2 == 0) goto L_0x0068;
    L_0x005c:
        r5 = (java.lang.String) r5;	 Catch:{ IOException -> 0x008a, all -> 0x0082 }
        r2 = "UTF-8";
        r5 = r5.getBytes(r2);	 Catch:{ IOException -> 0x008a, all -> 0x0082 }
    L_0x0064:
        r0.write(r5);	 Catch:{ IOException -> 0x008a, all -> 0x0082 }
        goto L_0x007e;
    L_0x0068:
        r2 = r5 instanceof byte[];	 Catch:{ IOException -> 0x008a, all -> 0x0082 }
        if (r2 == 0) goto L_0x006f;
    L_0x006c:
        r5 = (byte[]) r5;	 Catch:{ IOException -> 0x008a, all -> 0x0082 }
        goto L_0x0064;
    L_0x006f:
        r2 = r5 instanceof org.json.JSONObject;	 Catch:{ IOException -> 0x008a, all -> 0x0082 }
        if (r2 == 0) goto L_0x007e;
    L_0x0073:
        r5 = r5.toString();	 Catch:{ IOException -> 0x008a, all -> 0x0082 }
        r2 = "UTF-8";
        r5 = r5.getBytes(r2);	 Catch:{ IOException -> 0x008a, all -> 0x0082 }
        goto L_0x0064;
    L_0x007e:
        r4.flush();	 Catch:{ IOException -> 0x008a, all -> 0x0082 }
        goto L_0x008c;
    L_0x0082:
        r3 = move-exception;
        r0.close();
        r4.close();
        throw r3;
    L_0x008a:
        r5 = move-exception;
        r1 = r5;
    L_0x008c:
        r0.close();
        r4.close();
        if (r1 == 0) goto L_0x0095;
    L_0x0094:
        throw r1;
    L_0x0095:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.d.a.a.a.b(java.lang.String, java.util.Map, java.lang.Object):java.net.HttpURLConnection");
    }
}
