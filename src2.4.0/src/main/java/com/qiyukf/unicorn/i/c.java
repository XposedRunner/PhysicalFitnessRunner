package com.qiyukf.unicorn.i;

import android.text.TextUtils;
import android.util.Base64;
import com.qiyukf.basesdk.a.a;
import com.qiyukf.unicorn.b.b;
import com.qiyukf.unicorn.d;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import org.json.JSONObject;

final class c {
    static String a(String str, CharSequence charSequence, String str2, int i, long j, String str3, JSONObject jSONObject) {
        String format;
        String d = d.d();
        String g = b.g();
        if (TextUtils.isEmpty(g)) {
            g = b.d();
        }
        String valueOf = String.valueOf(j);
        String charSequence2 = charSequence.toString();
        String str4 = i == 0 ? "0" : "1";
        if (jSONObject != null) {
            String jSONObject2 = jSONObject.toString();
            format = String.format(Locale.getDefault(), "ak=%s&dv=%s&cup=%s&tm=%s&ct=%s&lt=%s&tp=%s&desc=%s&u=%s", new Object[]{d, g, str, valueOf, charSequence2, str4, str3, jSONObject2, str2});
        } else {
            format = String.format(Locale.getDefault(), "ak=%s&dv=%s&cup=%s&tm=%s&ct=%s&lt=%s&tp=%s&u=%s", new Object[]{d, g, str, valueOf, charSequence2, str4, str3, str2});
        }
        StringBuilder stringBuilder = new StringBuilder("track record: ");
        stringBuilder.append(format);
        a.a("StatisticsManager", stringBuilder.toString());
        return Base64.encodeToString(format.getBytes(), 2);
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static void a(String str, String str2) {
        if (a(str)) {
            if (com.qiyukf.unicorn.f.c.a(str2) != 200) {
                b(str, str2);
            }
            return;
        }
        b(str, str2);
    }

    /* JADX WARNING: Missing block: B:24:0x0067, code skipped:
            if (r7.length() <= 0) goto L_0x0086;
     */
    /* JADX WARNING: Missing block: B:25:0x0069, code skipped:
            r7.deleteCharAt(r7.length() - 1);
     */
    /* JADX WARNING: Missing block: B:26:0x0079, code skipped:
            if (com.qiyukf.unicorn.f.c.a(r7.toString()) != 200) goto L_0x0082;
     */
    /* JADX WARNING: Missing block: B:27:0x007b, code skipped:
            r0.delete();
     */
    /* JADX WARNING: Missing block: B:28:0x007e, code skipped:
            a(r4);
     */
    /* JADX WARNING: Missing block: B:29:0x0081, code skipped:
            return true;
     */
    /* JADX WARNING: Missing block: B:30:0x0082, code skipped:
            a(r4);
     */
    /* JADX WARNING: Missing block: B:31:0x0085, code skipped:
            return false;
     */
    /* JADX WARNING: Missing block: B:32:0x0086, code skipped:
            a(r4);
     */
    /* JADX WARNING: Missing block: B:33:0x0089, code skipped:
            return true;
     */
    static boolean a(java.lang.String r7) {
        /*
        r0 = android.text.TextUtils.isEmpty(r7);
        r1 = 1;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = new java.io.File;
        r0.<init>(r7);
        r7 = r0.exists();
        if (r7 == 0) goto L_0x009e;
    L_0x0013:
        r2 = r0.length();
        r4 = 0;
        r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r7 != 0) goto L_0x001e;
    L_0x001d:
        return r1;
    L_0x001e:
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r2 = 0;
        r3 = 0;
        r4 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x0092 }
        r5 = new java.io.FileReader;	 Catch:{ IOException -> 0x0092 }
        r5.<init>(r0);	 Catch:{ IOException -> 0x0092 }
        r4.<init>(r5);	 Catch:{ IOException -> 0x0092 }
    L_0x002f:
        r2 = r4.readLine();	 Catch:{ IOException -> 0x008c, all -> 0x008a }
        r5 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r2 == 0) goto L_0x0063;
    L_0x0037:
        r7.append(r2);	 Catch:{ IOException -> 0x008c, all -> 0x008a }
        r2 = ",";
        r7.append(r2);	 Catch:{ IOException -> 0x008c, all -> 0x008a }
        r2 = r7.length();	 Catch:{ IOException -> 0x008c, all -> 0x008a }
        r6 = 6000; // 0x1770 float:8.408E-42 double:2.9644E-320;
        if (r2 < r6) goto L_0x002f;
    L_0x0047:
        r2 = r7.length();	 Catch:{ IOException -> 0x008c, all -> 0x008a }
        r2 = r2 - r1;
        r7.deleteCharAt(r2);	 Catch:{ IOException -> 0x008c, all -> 0x008a }
        r7 = r7.toString();	 Catch:{ IOException -> 0x008c, all -> 0x008a }
        r7 = com.qiyukf.unicorn.f.c.a(r7);	 Catch:{ IOException -> 0x008c, all -> 0x008a }
        if (r7 != r5) goto L_0x005f;
    L_0x0059:
        r7 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x008c, all -> 0x008a }
        r7.<init>();	 Catch:{ IOException -> 0x008c, all -> 0x008a }
        goto L_0x002f;
    L_0x005f:
        a(r4);
        return r3;
    L_0x0063:
        r2 = r7.length();	 Catch:{ IOException -> 0x008c, all -> 0x008a }
        if (r2 <= 0) goto L_0x0086;
    L_0x0069:
        r2 = r7.length();	 Catch:{ IOException -> 0x008c, all -> 0x008a }
        r2 = r2 - r1;
        r7.deleteCharAt(r2);	 Catch:{ IOException -> 0x008c, all -> 0x008a }
        r7 = r7.toString();	 Catch:{ IOException -> 0x008c, all -> 0x008a }
        r7 = com.qiyukf.unicorn.f.c.a(r7);	 Catch:{ IOException -> 0x008c, all -> 0x008a }
        if (r7 != r5) goto L_0x0082;
    L_0x007b:
        r0.delete();	 Catch:{ IOException -> 0x008c, all -> 0x008a }
        a(r4);
        return r1;
    L_0x0082:
        a(r4);
        return r3;
    L_0x0086:
        a(r4);
        return r1;
    L_0x008a:
        r7 = move-exception;
        goto L_0x009a;
    L_0x008c:
        r7 = move-exception;
        r2 = r4;
        goto L_0x0093;
    L_0x008f:
        r7 = move-exception;
        r4 = r2;
        goto L_0x009a;
    L_0x0092:
        r7 = move-exception;
    L_0x0093:
        r7.printStackTrace();	 Catch:{ all -> 0x008f }
        a(r2);
        return r3;
    L_0x009a:
        a(r4);
        throw r7;
    L_0x009e:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.i.c.a(java.lang.String):boolean");
    }

    static void b(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
            } else if (!file.isFile()) {
                com.qiyukf.nimlib.k.c.c.a(file);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            if (file.length() > 0) {
                bufferedWriter.append("\n");
            }
            bufferedWriter.append(str2);
            bufferedWriter.flush();
            bufferedWriter.close();
            if (file.length() >= 6000) {
                a(str);
            }
        }
    }
}
