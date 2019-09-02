package com.baidu.location.d;

import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.SemesterTipDialog;
import com.sina.weibo.sdk.statistic.LogBuilder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

final class k {
    private static final double[] b = new double[]{45.0d, 135.0d, 225.0d, 315.0d};
    private final g a;
    private final int c;
    private final SQLiteDatabase d;
    private int e = -1;
    private int f = -1;

    private static final class a {
        private double a;
        private double b;

        private a(double d, double d2) {
            this.a = d;
            this.b = d2;
        }
    }

    private enum b {
        AREA("RGCAREA", "area", "addrv", 0, 1000),
        ROAD("RGCROAD", "road", "addrv", 1000, 10000),
        SITE("RGCSITE", "site", "addrv", 100, 50000),
        POI("RGCPOI", "poi", "poiv", 1000, 5000);
        
        private final int e;
        private final String f;
        private final String g;
        private final String h;
        private final int i;

        private b(String str, String str2, String str3, int i, int i2) {
            this.f = str;
            this.g = str2;
            this.h = str3;
            this.e = i;
            this.i = i2;
        }

        private String a(int i, double d, double d2) {
            HashSet hashSet = new HashSet();
            hashSet.add(k.b(i, d, d2));
            double d3 = ((double) this.e) * 1.414d;
            if (this.e > 0) {
                for (double a : k.b) {
                    double[] a2 = k.b(d2, d, d3, a);
                    hashSet.add(k.b(i, a2[1], a2[0]));
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            Iterator it = hashSet.iterator();
            int i2 = 1;
            while (it.hasNext()) {
                String str = (String) it.next();
                if (i2 != 0) {
                    i2 = 0;
                } else {
                    stringBuffer.append(',');
                }
                stringBuffer.append("\"");
                stringBuffer.append(str);
                stringBuffer.append("\"");
            }
            return String.format("SELECT * FROM %s WHERE gridkey IN (%s);", new Object[]{this.f, stringBuffer.toString()});
        }

        private String a(JSONObject jSONObject) {
            Iterator keys = jSONObject.keys();
            StringBuffer stringBuffer = new StringBuffer();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (stringBuffer.length() != 0) {
                    stringBuffer.append(",");
                }
                stringBuffer.append("\"");
                stringBuffer.append(str);
                stringBuffer.append("\"");
            }
            return String.format(Locale.US, "DELETE FROM %s WHERE gridkey IN (%s)", new Object[]{this.f, stringBuffer});
        }

        private static void b(StringBuffer stringBuffer, String str, String str2, int i) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append("(\"");
            stringBuffer.append(str);
            stringBuffer.append("\",\"");
            stringBuffer.append(str2);
            stringBuffer.append("\",");
            stringBuffer.append(i);
            stringBuffer.append(",");
            stringBuffer.append(System.currentTimeMillis() / LogBuilder.MAX_INTERVAL);
            stringBuffer.append(")");
        }

        public abstract List<String> a(JSONObject jSONObject, String str, int i);
    }

    k(g gVar, SQLiteDatabase sQLiteDatabase, int i) {
        this.a = gVar;
        this.d = sQLiteDatabase;
        this.c = i;
        if (this.d != null && this.d.isOpen()) {
            try {
                this.d.execSQL("CREATE TABLE IF NOT EXISTS RGCAREA(gridkey VARCHAR(10) PRIMARY KEY, country VARCHAR(100),countrycode VARCHAR(100), province VARCHAR(100), city VARCHAR(100), citycode VARCHAR(100), district VARCHAR(100), timestamp INTEGER, version VARCHAR(50))");
                this.d.execSQL("CREATE TABLE IF NOT EXISTS RGCROAD(_id INTEGER PRIMARY KEY AUTOINCREMENT, gridkey VARCHAR(10), street VARCHAR(100), x1 DOUBLE, y1 DOUBLE, x2 DOUBLE, y2 DOUBLE)");
                this.d.execSQL("CREATE TABLE IF NOT EXISTS RGCSITE(_id INTEGER PRIMARY KEY AUTOINCREMENT, gridkey VARCHAR(10), street VARCHAR(100), streetnumber VARCHAR(100), x DOUBLE, y DOUBLE)");
                this.d.execSQL("CREATE TABLE IF NOT EXISTS RGCPOI(pid VARCHAR(50) PRIMARY KEY , gridkey VARCHAR(10), name VARCHAR(100), type VARCHAR(50), x DOUBLE, y DOUBLE, rank INTEGER)");
                this.d.execSQL("CREATE TABLE IF NOT EXISTS RGCUPDATE(gridkey VARCHAR(10), version VARCHAR(50), type INTEGER, timestamp INTEGER, PRIMARY KEY(gridkey, type))");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private double a(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d5 - d3;
        double d8 = d - d3;
        double d9 = d6 - d4;
        double d10 = d2 - d4;
        double d11 = (d7 * d8) + (d9 * d10);
        if (d11 <= 0.0d) {
            return Math.sqrt((d8 * d8) + (d10 * d10));
        }
        d8 = (d7 * d7) + (d9 * d9);
        double d12;
        if (d11 >= d8) {
            d12 = d - d5;
            double d13 = d2 - d6;
            return Math.sqrt((d12 * d12) + (d13 * d13));
        }
        d11 /= d8;
        d12 = d - (d3 + (d7 * d11));
        double d14 = (d4 + (d9 * d11)) - d2;
        return Math.sqrt((d12 * d12) + (d14 * d14));
    }

    private static int a(int i, int i2) {
        double d;
        int i3;
        if (100 > i2) {
            d = -0.1d;
            i3 = SemesterTipDialog.REQUEST_CODE_SEMESTER_DIALOG;
        } else if (500 > i2) {
            d = -0.75d;
            i3 = 55500;
        } else {
            d = -0.5d;
            i3 = 0;
        }
        return ((int) ((d * ((double) i2)) + ((double) i3))) + i;
    }

    private static String b(int i, double d, double d2) {
        int i2 = i;
        int i3 = i2 * 5;
        char[] cArr = new char[(i2 + 1)];
        a aVar = new a(90.0d, -90.0d);
        a aVar2 = new a(180.0d, -180.0d);
        int i4 = 1;
        int i5 = 1;
        int i6 = i5;
        int i7 = 0;
        while (i5 <= i3) {
            double d3;
            if (i6 != 0) {
                d3 = d;
                aVar2 = aVar2;
            } else {
                d3 = d2;
                aVar2 = aVar;
            }
            double a = (aVar2.b + aVar2.a) / 2.0d;
            i7 <<= i4;
            if (((int) (d3 * 1000000.0d)) > ((int) (1000000.0d * a))) {
                aVar2.b = a;
                i7 |= 1;
            } else {
                aVar2.a = a;
            }
            if (i5 % 5 == 0) {
                i4 = 1;
                cArr[(i5 / 5) - 1] = "0123456789bcdefghjkmnpqrstuvwxyz".charAt(i7);
                i7 = 0;
            } else {
                i4 = 1;
            }
            i6 ^= 1;
            i5++;
        }
        int i8 = 0;
        cArr[i2] = 0;
        StringBuffer stringBuffer = new StringBuffer();
        while (i8 < i2) {
            stringBuffer.append(cArr[i8]);
            i8++;
        }
        return stringBuffer.toString();
    }

    private static double[] b(double d, double d2, double d3, double d4) {
        double[] dArr = new double[2];
        d = Math.toRadians(d);
        d2 = Math.toRadians(d2);
        d4 = Math.toRadians(d4);
        d3 /= 6378137.0d;
        double asin = Math.asin((Math.sin(d) * Math.cos(d3)) + ((Math.cos(d) * Math.sin(d3)) * Math.cos(d4)));
        d2 += Math.atan2((Math.sin(d4) * Math.sin(d3)) * Math.cos(d), Math.cos(d3) - (Math.sin(d) * Math.sin(asin)));
        dArr[0] = Math.toDegrees(asin);
        dArr[1] = Math.toDegrees(d2);
        return dArr;
    }

    private double c(double d, double d2, double d3, double d4) {
        double d5 = d4 - d2;
        double d6 = d3 - d;
        d = Math.toRadians(d);
        Math.toRadians(d2);
        d2 = Math.toRadians(d3);
        Math.toRadians(d4);
        d4 = Math.toRadians(d6) / 2.0d;
        d3 = Math.toRadians(d5) / 2.0d;
        d6 = (Math.sin(d4) * Math.sin(d4)) + (((Math.cos(d) * Math.cos(d2)) * Math.sin(d3)) * Math.sin(d3));
        return (2.0d * Math.atan2(Math.sqrt(d6), Math.sqrt(1.0d - d6))) * 6378137.0d;
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x01e0 A:{SYNTHETIC, Splitter:B:146:0x01e0} */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x024a  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01c2 A:{Splitter:B:95:0x0165, ExcHandler: all (r0_8 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x01e0 A:{SYNTHETIC, Splitter:B:146:0x01e0} */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x024a  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01c2 A:{Splitter:B:95:0x0165, ExcHandler: all (r0_8 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x01e0 A:{SYNTHETIC, Splitter:B:146:0x01e0} */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x024a  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01c2 A:{Splitter:B:95:0x0165, ExcHandler: all (r0_8 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x01e0 A:{SYNTHETIC, Splitter:B:146:0x01e0} */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x024a  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01d3 A:{SYNTHETIC, Splitter:B:136:0x01d3} */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x01e0 A:{SYNTHETIC, Splitter:B:146:0x01e0} */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x024a  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01c2 A:{Splitter:B:95:0x0165, ExcHandler: all (r0_8 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0082 A:{SYNTHETIC, Splitter:B:34:0x0082} */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x01e0 A:{SYNTHETIC, Splitter:B:146:0x01e0} */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x024a  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01d3 A:{SYNTHETIC, Splitter:B:136:0x01d3} */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x01e0 A:{SYNTHETIC, Splitter:B:146:0x01e0} */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x024a  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01c2 A:{Splitter:B:95:0x0165, ExcHandler: all (r0_8 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0075 A:{PHI: r8 , Splitter:B:3:0x001e, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0082 A:{SYNTHETIC, Splitter:B:34:0x0082} */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0144 A:{SYNTHETIC, Splitter:B:79:0x0144} */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0144 A:{SYNTHETIC, Splitter:B:79:0x0144} */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x024a  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01be A:{SYNTHETIC, Splitter:B:122:0x01be} */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x024a  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x025d  */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:22:0x006b, code skipped:
            r12 = r8;
     */
    /* JADX WARNING: Missing block: B:25:0x0072, code skipped:
            if (r12 != null) goto L_0x008d;
     */
    /* JADX WARNING: Missing block: B:26:0x0075, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:27:0x0076, code skipped:
            r12 = r8;
     */
    /* JADX WARNING: Missing block: B:35:?, code skipped:
            r12.close();
     */
    /* JADX WARNING: Missing block: B:41:0x008b, code skipped:
            if (r12 != null) goto L_0x008d;
     */
    /* JADX WARNING: Missing block: B:44:?, code skipped:
            r12.close();
     */
    /* JADX WARNING: Missing block: B:68:0x0131, code skipped:
            if (r15 != null) goto L_0x0133;
     */
    /* JADX WARNING: Missing block: B:70:?, code skipped:
            r15.close();
     */
    /* JADX WARNING: Missing block: B:85:0x014b, code skipped:
            if (r15 == null) goto L_0x0150;
     */
    /* JADX WARNING: Missing block: B:112:0x01af, code skipped:
            r7 = null;
     */
    /* JADX WARNING: Missing block: B:114:0x01b1, code skipped:
            r6 = null;
     */
    /* JADX WARNING: Missing block: B:116:0x01b3, code skipped:
            r5 = null;
     */
    /* JADX WARNING: Missing block: B:118:0x01b5, code skipped:
            r3 = null;
     */
    /* JADX WARNING: Missing block: B:124:0x01c2, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:125:0x01c3, code skipped:
            r1 = r0;
     */
    /* JADX WARNING: Missing block: B:137:?, code skipped:
            r11.close();
     */
    /* JADX WARNING: Missing block: B:147:?, code skipped:
            r11.close();
     */
    /* JADX WARNING: Missing block: B:152:0x01e7, code skipped:
            r2 = new java.lang.String(com.baidu.android.bbalbs.common.a.b.a(r2.getBytes()));
     */
    /* JADX WARNING: Missing block: B:154:0x01f7, code skipped:
            r3 = new java.lang.String(com.baidu.android.bbalbs.common.a.b.a(r3.getBytes()));
     */
    /* JADX WARNING: Missing block: B:156:0x0207, code skipped:
            r4 = new java.lang.String(com.baidu.android.bbalbs.common.a.b.a(r4.getBytes()));
     */
    /* JADX WARNING: Missing block: B:158:0x0217, code skipped:
            r5 = new java.lang.String(com.baidu.android.bbalbs.common.a.b.a(r6.getBytes()));
     */
    /* JADX WARNING: Missing block: B:159:0x0225, code skipped:
            r5 = r6;
     */
    /* JADX WARNING: Missing block: B:161:0x0228, code skipped:
            r6 = new java.lang.String(com.baidu.android.bbalbs.common.a.b.a(r7.getBytes()));
     */
    /* JADX WARNING: Missing block: B:162:0x0236, code skipped:
            r6 = r7;
     */
    /* JADX WARNING: Missing block: B:164:0x0239, code skipped:
            r7 = new java.lang.String(com.baidu.android.bbalbs.common.a.b.a(r8.getBytes()));
     */
    /* JADX WARNING: Missing block: B:165:0x0247, code skipped:
            r7 = r8;
     */
    /* JADX WARNING: Missing block: B:167:0x024a, code skipped:
            r8 = new java.lang.String(com.baidu.android.bbalbs.common.a.b.a(r1.getBytes()));
     */
    /* JADX WARNING: Missing block: B:168:0x0258, code skipped:
            r8 = r1;
     */
    /* JADX WARNING: Missing block: B:171:0x025d, code skipped:
            r12 = new java.lang.String(com.baidu.android.bbalbs.common.a.b.a(r1.getBytes()));
     */
    /* JADX WARNING: Missing block: B:172:0x026b, code skipped:
            r12 = r1;
     */
    public com.baidu.location.Address a(double r34, double r36) {
        /*
        r33 = this;
        r14 = r33;
        r15 = 4;
        r12 = 5;
        r13 = 3;
        r10 = 2;
        r16 = 9218868437227405311; // 0x7fefffffffffffff float:NaN double:1.7976931348623157E308;
        r11 = 0;
        r1 = com.baidu.location.d.k.b.SITE;	 Catch:{ Exception -> 0x0086, all -> 0x007d }
        r2 = r14.c;	 Catch:{ Exception -> 0x0086, all -> 0x007d }
        r3 = r34;
        r5 = r36;
        r1 = r1.a(r2, r3, r5);	 Catch:{ Exception -> 0x0086, all -> 0x007d }
        r2 = r14.d;	 Catch:{ Exception -> 0x0086, all -> 0x007d }
        r8 = r2.rawQuery(r1, r11);	 Catch:{ Exception -> 0x0086, all -> 0x007d }
        r1 = r8.moveToFirst();	 Catch:{ Exception -> 0x0079, all -> 0x0075 }
        if (r1 == 0) goto L_0x006d;
    L_0x0024:
        r18 = r11;
        r21 = r18;
        r19 = r16;
    L_0x002a:
        r1 = r8.isAfterLast();	 Catch:{ Exception -> 0x006b, all -> 0x0075 }
        if (r1 != 0) goto L_0x0069;
    L_0x0030:
        r22 = r8.getString(r10);	 Catch:{ Exception -> 0x006b, all -> 0x0075 }
        r23 = r8.getString(r13);	 Catch:{ Exception -> 0x006b, all -> 0x0075 }
        r6 = r8.getDouble(r12);	 Catch:{ Exception -> 0x006b, all -> 0x0075 }
        r24 = r8.getDouble(r15);	 Catch:{ Exception -> 0x006b, all -> 0x0075 }
        r1 = r14;
        r2 = r36;
        r4 = r34;
        r12 = r8;
        r8 = r24;
        r1 = r1.c(r2, r4, r6, r8);	 Catch:{ Exception -> 0x008b, all -> 0x0067 }
        r3 = (r1 > r19 ? 1 : (r1 == r19 ? 0 : -1));
        if (r3 >= 0) goto L_0x0061;
    L_0x0050:
        r3 = com.baidu.location.d.k.b.SITE;	 Catch:{ Exception -> 0x008b, all -> 0x0067 }
        r3 = r3.e;	 Catch:{ Exception -> 0x008b, all -> 0x0067 }
        r3 = (double) r3;	 Catch:{ Exception -> 0x008b, all -> 0x0067 }
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 > 0) goto L_0x0061;
    L_0x005b:
        r19 = r1;
        r21 = r22;
        r18 = r23;
    L_0x0061:
        r12.moveToNext();	 Catch:{ Exception -> 0x008b, all -> 0x0067 }
        r8 = r12;
        r12 = 5;
        goto L_0x002a;
    L_0x0067:
        r0 = move-exception;
        goto L_0x0077;
    L_0x0069:
        r12 = r8;
        goto L_0x0072;
    L_0x006b:
        r12 = r8;
        goto L_0x008b;
    L_0x006d:
        r12 = r8;
        r18 = r11;
        r21 = r18;
    L_0x0072:
        if (r12 == 0) goto L_0x0090;
    L_0x0074:
        goto L_0x008d;
    L_0x0075:
        r0 = move-exception;
        r12 = r8;
    L_0x0077:
        r1 = r0;
        goto L_0x0080;
    L_0x0079:
        r12 = r8;
        r18 = r11;
        goto L_0x0089;
    L_0x007d:
        r0 = move-exception;
        r1 = r0;
        r12 = r11;
    L_0x0080:
        if (r12 == 0) goto L_0x0085;
    L_0x0082:
        r12.close();	 Catch:{ Exception -> 0x0085 }
    L_0x0085:
        throw r1;
    L_0x0086:
        r12 = r11;
        r18 = r12;
    L_0x0089:
        r21 = r18;
    L_0x008b:
        if (r12 == 0) goto L_0x0090;
    L_0x008d:
        r12.close();	 Catch:{ Exception -> 0x0090 }
    L_0x0090:
        r12 = r18;
        if (r12 != 0) goto L_0x014e;
    L_0x0094:
        r1 = com.baidu.location.d.k.b.ROAD;	 Catch:{ Exception -> 0x0148, all -> 0x013f }
        r2 = r14.c;	 Catch:{ Exception -> 0x0148, all -> 0x013f }
        r3 = r34;
        r5 = r36;
        r1 = r1.a(r2, r3, r5);	 Catch:{ Exception -> 0x0148, all -> 0x013f }
        r2 = r14.d;	 Catch:{ Exception -> 0x0148, all -> 0x013f }
        r8 = r2.rawQuery(r1, r11);	 Catch:{ Exception -> 0x0148, all -> 0x013f }
        r1 = r8.moveToFirst();	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        if (r1 == 0) goto L_0x012e;
    L_0x00ac:
        r1 = "wgs842mc";
        r6 = r34;
        r4 = r36;
        r18 = com.baidu.location.Jni.coorEncrypt(r6, r4, r1);	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
    L_0x00b6:
        r1 = r8.isAfterLast();	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        if (r1 != 0) goto L_0x012e;
    L_0x00bc:
        r19 = r8.getString(r10);	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r1 = r8.getDouble(r13);	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r10 = r8.getDouble(r15);	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r3 = "wgs842mc";
        r1 = com.baidu.location.Jni.coorEncrypt(r1, r10, r3);	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r10 = 5;
        r2 = r8.getDouble(r10);	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r9 = 6;
        r10 = r8.getDouble(r9);	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r9 = "wgs842mc";
        r2 = com.baidu.location.Jni.coorEncrypt(r2, r10, r9);	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r3 = 0;
        r9 = r18[r3];	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r11 = 1;
        r22 = r18[r11];	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r24 = r1[r3];	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r26 = r1[r11];	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r28 = r2[r3];	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r30 = r2[r11];	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r1 = r14;
        r2 = r9;
        r4 = r22;
        r6 = r24;
        r10 = r8;
        r8 = r26;
        r15 = r10;
        r20 = 2;
        r22 = 5;
        r10 = r28;
        r32 = r12;
        r23 = r22;
        r22 = r13;
        r12 = r30;
        r1 = r1.a(r2, r4, r6, r8, r10, r12);	 Catch:{ Exception -> 0x014b, all -> 0x012c }
        r3 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1));
        if (r3 >= 0) goto L_0x011b;
    L_0x010c:
        r3 = com.baidu.location.d.k.b.ROAD;	 Catch:{ Exception -> 0x014b, all -> 0x012c }
        r3 = r3.e;	 Catch:{ Exception -> 0x014b, all -> 0x012c }
        r3 = (double) r3;	 Catch:{ Exception -> 0x014b, all -> 0x012c }
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 > 0) goto L_0x011b;
    L_0x0117:
        r16 = r1;
        r21 = r19;
    L_0x011b:
        r15.moveToNext();	 Catch:{ Exception -> 0x014b, all -> 0x012c }
        r6 = r34;
        r4 = r36;
        r8 = r15;
        r10 = r20;
        r13 = r22;
        r12 = r32;
        r11 = 0;
        r15 = 4;
        goto L_0x00b6;
    L_0x012c:
        r0 = move-exception;
        goto L_0x0139;
    L_0x012e:
        r15 = r8;
        r32 = r12;
        if (r15 == 0) goto L_0x0150;
    L_0x0133:
        r15.close();	 Catch:{ Exception -> 0x0150 }
        goto L_0x0150;
    L_0x0137:
        r0 = move-exception;
        r15 = r8;
    L_0x0139:
        r1 = r0;
        goto L_0x0142;
    L_0x013b:
        r15 = r8;
        r32 = r12;
        goto L_0x014b;
    L_0x013f:
        r0 = move-exception;
        r1 = r0;
        r15 = 0;
    L_0x0142:
        if (r15 == 0) goto L_0x0147;
    L_0x0144:
        r15.close();	 Catch:{ Exception -> 0x0147 }
    L_0x0147:
        throw r1;
    L_0x0148:
        r32 = r12;
        r15 = 0;
    L_0x014b:
        if (r15 == 0) goto L_0x0150;
    L_0x014d:
        goto L_0x0133;
    L_0x014e:
        r32 = r12;
    L_0x0150:
        r1 = r21;
        r2 = com.baidu.location.d.k.b.AREA;
        r3 = r14.c;
        r4 = r34;
        r6 = r36;
        r2 = r2.a(r3, r4, r6);
        r3 = r14.d;	 Catch:{ Exception -> 0x01d7, all -> 0x01cd }
        r4 = 0;
        r11 = r3.rawQuery(r2, r4);	 Catch:{ Exception -> 0x01d8, all -> 0x01cb }
        r2 = r11.moveToFirst();	 Catch:{ Exception -> 0x01c5, all -> 0x01c2 }
        if (r2 == 0) goto L_0x01b7;
    L_0x016b:
        r2 = r11.isAfterLast();	 Catch:{ Exception -> 0x01c5, all -> 0x01c2 }
        if (r2 != 0) goto L_0x01b7;
    L_0x0171:
        r2 = "country";
        r2 = r11.getColumnIndex(r2);	 Catch:{ Exception -> 0x01c5, all -> 0x01c2 }
        r2 = r11.getString(r2);	 Catch:{ Exception -> 0x01c5, all -> 0x01c2 }
        r3 = "countrycode";
        r3 = r11.getColumnIndex(r3);	 Catch:{ Exception -> 0x01b5, all -> 0x01c2 }
        r3 = r11.getString(r3);	 Catch:{ Exception -> 0x01b5, all -> 0x01c2 }
        r5 = "province";
        r5 = r11.getColumnIndex(r5);	 Catch:{ Exception -> 0x01b3, all -> 0x01c2 }
        r5 = r11.getString(r5);	 Catch:{ Exception -> 0x01b3, all -> 0x01c2 }
        r6 = "city";
        r6 = r11.getColumnIndex(r6);	 Catch:{ Exception -> 0x01b1, all -> 0x01c2 }
        r6 = r11.getString(r6);	 Catch:{ Exception -> 0x01b1, all -> 0x01c2 }
        r7 = "citycode";
        r7 = r11.getColumnIndex(r7);	 Catch:{ Exception -> 0x01af, all -> 0x01c2 }
        r7 = r11.getString(r7);	 Catch:{ Exception -> 0x01af, all -> 0x01c2 }
        r8 = "district";
        r8 = r11.getColumnIndex(r8);	 Catch:{ Exception -> 0x01de, all -> 0x01c2 }
        r8 = r11.getString(r8);	 Catch:{ Exception -> 0x01de, all -> 0x01c2 }
        r4 = r5;
        goto L_0x01bc;
    L_0x01af:
        r7 = r4;
        goto L_0x01de;
    L_0x01b1:
        r6 = r4;
        goto L_0x01c9;
    L_0x01b3:
        r5 = r4;
        goto L_0x01c8;
    L_0x01b5:
        r3 = r4;
        goto L_0x01c7;
    L_0x01b7:
        r2 = r4;
        r3 = r2;
        r6 = r3;
        r7 = r6;
        r8 = r7;
    L_0x01bc:
        if (r11 == 0) goto L_0x01e5;
    L_0x01be:
        r11.close();	 Catch:{ Exception -> 0x01e5 }
        goto L_0x01e5;
    L_0x01c2:
        r0 = move-exception;
        r1 = r0;
        goto L_0x01d1;
    L_0x01c5:
        r2 = r4;
        r3 = r2;
    L_0x01c7:
        r5 = r3;
    L_0x01c8:
        r6 = r5;
    L_0x01c9:
        r7 = r6;
        goto L_0x01de;
    L_0x01cb:
        r0 = move-exception;
        goto L_0x01cf;
    L_0x01cd:
        r0 = move-exception;
        r4 = 0;
    L_0x01cf:
        r1 = r0;
        r11 = r4;
    L_0x01d1:
        if (r11 == 0) goto L_0x01d6;
    L_0x01d3:
        r11.close();	 Catch:{ Exception -> 0x01d6 }
    L_0x01d6:
        throw r1;
    L_0x01d7:
        r4 = 0;
    L_0x01d8:
        r2 = r4;
        r3 = r2;
        r5 = r3;
        r6 = r5;
        r7 = r6;
        r11 = r7;
    L_0x01de:
        if (r11 == 0) goto L_0x01e3;
    L_0x01e0:
        r11.close();	 Catch:{ Exception -> 0x01e3 }
    L_0x01e3:
        r8 = r4;
        r4 = r5;
    L_0x01e5:
        if (r2 == 0) goto L_0x01f5;
    L_0x01e7:
        r5 = new java.lang.String;
        r2 = r2.getBytes();
        r2 = com.baidu.android.bbalbs.common.a.b.a(r2);
        r5.<init>(r2);
        r2 = r5;
    L_0x01f5:
        if (r3 == 0) goto L_0x0205;
    L_0x01f7:
        r5 = new java.lang.String;
        r3 = r3.getBytes();
        r3 = com.baidu.android.bbalbs.common.a.b.a(r3);
        r5.<init>(r3);
        r3 = r5;
    L_0x0205:
        if (r4 == 0) goto L_0x0215;
    L_0x0207:
        r5 = new java.lang.String;
        r4 = r4.getBytes();
        r4 = com.baidu.android.bbalbs.common.a.b.a(r4);
        r5.<init>(r4);
        r4 = r5;
    L_0x0215:
        if (r6 == 0) goto L_0x0225;
    L_0x0217:
        r5 = new java.lang.String;
        r6 = r6.getBytes();
        r6 = com.baidu.android.bbalbs.common.a.b.a(r6);
        r5.<init>(r6);
        goto L_0x0226;
    L_0x0225:
        r5 = r6;
    L_0x0226:
        if (r7 == 0) goto L_0x0236;
    L_0x0228:
        r6 = new java.lang.String;
        r7 = r7.getBytes();
        r7 = com.baidu.android.bbalbs.common.a.b.a(r7);
        r6.<init>(r7);
        goto L_0x0237;
    L_0x0236:
        r6 = r7;
    L_0x0237:
        if (r8 == 0) goto L_0x0247;
    L_0x0239:
        r7 = new java.lang.String;
        r8 = r8.getBytes();
        r8 = com.baidu.android.bbalbs.common.a.b.a(r8);
        r7.<init>(r8);
        goto L_0x0248;
    L_0x0247:
        r7 = r8;
    L_0x0248:
        if (r1 == 0) goto L_0x0258;
    L_0x024a:
        r8 = new java.lang.String;
        r1 = r1.getBytes();
        r1 = com.baidu.android.bbalbs.common.a.b.a(r1);
        r8.<init>(r1);
        goto L_0x0259;
    L_0x0258:
        r8 = r1;
    L_0x0259:
        r1 = r32;
        if (r1 == 0) goto L_0x026b;
    L_0x025d:
        r12 = new java.lang.String;
        r1 = r1.getBytes();
        r1 = com.baidu.android.bbalbs.common.a.b.a(r1);
        r12.<init>(r1);
        goto L_0x026c;
    L_0x026b:
        r12 = r1;
    L_0x026c:
        r1 = new com.baidu.location.Address$Builder;
        r1.<init>();
        r1 = r1.country(r2);
        r1 = r1.countryCode(r3);
        r1 = r1.province(r4);
        r1 = r1.city(r5);
        r1 = r1.cityCode(r6);
        r1 = r1.district(r7);
        r1 = r1.street(r8);
        r1 = r1.streetNumber(r12);
        r1 = r1.build();
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.d.k.a(double, double):com.baidu.location.Address");
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x007b */
    public void a(org.json.JSONObject r9) {
        /*
        r8 = this;
        r0 = r8.d;
        if (r0 == 0) goto L_0x0088;
    L_0x0004:
        r0 = r8.d;
        r0 = r0.isOpen();
        if (r0 == 0) goto L_0x0088;
    L_0x000c:
        r0 = r8.d;	 Catch:{ Exception -> 0x007b, all -> 0x0081 }
        r0.beginTransaction();	 Catch:{ Exception -> 0x007b, all -> 0x0081 }
        r0 = com.baidu.location.d.k.b.values();	 Catch:{ Exception -> 0x007b, all -> 0x0081 }
        r1 = r0.length;	 Catch:{ Exception -> 0x007b, all -> 0x0081 }
        r2 = 0;
    L_0x0017:
        if (r2 >= r1) goto L_0x0071;
    L_0x0019:
        r3 = r0[r2];	 Catch:{ Exception -> 0x007b, all -> 0x0081 }
        r4 = r3.g;	 Catch:{ Exception -> 0x007b, all -> 0x0081 }
        r4 = r9.has(r4);	 Catch:{ Exception -> 0x007b, all -> 0x0081 }
        if (r4 == 0) goto L_0x006e;
    L_0x0025:
        r4 = "";
        r5 = r3.h;	 Catch:{ Exception -> 0x007b, all -> 0x0081 }
        r5 = r9.has(r5);	 Catch:{ Exception -> 0x007b, all -> 0x0081 }
        if (r5 == 0) goto L_0x0039;
    L_0x0031:
        r4 = r3.h;	 Catch:{ Exception -> 0x007b, all -> 0x0081 }
        r4 = r9.getString(r4);	 Catch:{ Exception -> 0x007b, all -> 0x0081 }
    L_0x0039:
        r5 = new java.util.ArrayList;	 Catch:{ Exception -> 0x007b, all -> 0x0081 }
        r5.<init>();	 Catch:{ Exception -> 0x007b, all -> 0x0081 }
        r6 = r3.g;	 Catch:{ Exception -> 0x007b, all -> 0x0081 }
        r6 = r9.getJSONObject(r6);	 Catch:{ Exception -> 0x007b, all -> 0x0081 }
        r7 = r3.a(r6);	 Catch:{ Exception -> 0x007b, all -> 0x0081 }
        r5.add(r7);	 Catch:{ Exception -> 0x007b, all -> 0x0081 }
        r7 = r3.i;	 Catch:{ Exception -> 0x007b, all -> 0x0081 }
        r3 = r3.a(r6, r4, r7);	 Catch:{ Exception -> 0x007b, all -> 0x0081 }
        r5.addAll(r3);	 Catch:{ Exception -> 0x007b, all -> 0x0081 }
        r3 = r5.iterator();	 Catch:{ Exception -> 0x007b, all -> 0x0081 }
    L_0x005c:
        r4 = r3.hasNext();	 Catch:{ Exception -> 0x007b, all -> 0x0081 }
        if (r4 == 0) goto L_0x006e;
    L_0x0062:
        r4 = r3.next();	 Catch:{ Exception -> 0x007b, all -> 0x0081 }
        r4 = (java.lang.String) r4;	 Catch:{ Exception -> 0x007b, all -> 0x0081 }
        r5 = r8.d;	 Catch:{ Exception -> 0x007b, all -> 0x0081 }
        r5.execSQL(r4);	 Catch:{ Exception -> 0x007b, all -> 0x0081 }
        goto L_0x005c;
    L_0x006e:
        r2 = r2 + 1;
        goto L_0x0017;
    L_0x0071:
        r9 = r8.d;	 Catch:{ Exception -> 0x007b, all -> 0x0081 }
        r9.setTransactionSuccessful();	 Catch:{ Exception -> 0x007b, all -> 0x0081 }
        r9 = -1;
        r8.e = r9;	 Catch:{ Exception -> 0x007b, all -> 0x0081 }
        r8.f = r9;	 Catch:{ Exception -> 0x007b, all -> 0x0081 }
    L_0x007b:
        r9 = r8.d;	 Catch:{ Exception -> 0x0088 }
        r9.endTransaction();	 Catch:{ Exception -> 0x0088 }
        return;
    L_0x0081:
        r9 = move-exception;
        r0 = r8.d;	 Catch:{ Exception -> 0x0087 }
        r0.endTransaction();	 Catch:{ Exception -> 0x0087 }
    L_0x0087:
        throw r9;
    L_0x0088:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.d.k.a(org.json.JSONObject):void");
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0068 A:{SYNTHETIC, Splitter:B:44:0x0068} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x006d A:{SYNTHETIC, Splitter:B:48:0x006d} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005c A:{SYNTHETIC, Splitter:B:32:0x005c} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0061 A:{SYNTHETIC, Splitter:B:36:0x0061} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0068 A:{SYNTHETIC, Splitter:B:44:0x0068} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x006d A:{SYNTHETIC, Splitter:B:48:0x006d} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005c A:{SYNTHETIC, Splitter:B:32:0x005c} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0061 A:{SYNTHETIC, Splitter:B:36:0x0061} */
    public boolean a() {
        /*
        r5 = this;
        r0 = r5.a;
        r0 = r0.l();
        r0 = r0.l();
        r1 = 0;
        if (r0 == 0) goto L_0x0070;
    L_0x000d:
        r0 = r5.f;
        r2 = -1;
        if (r0 != r2) goto L_0x0070;
    L_0x0012:
        r0 = r5.e;
        if (r0 != r2) goto L_0x0070;
    L_0x0016:
        r0 = r5.d;
        if (r0 == 0) goto L_0x0070;
    L_0x001a:
        r0 = r5.d;
        r0 = r0.isOpen();
        if (r0 == 0) goto L_0x0070;
    L_0x0022:
        r0 = 0;
        r2 = r5.d;	 Catch:{ Exception -> 0x0065, all -> 0x0058 }
        r3 = "SELECT COUNT(*) FROM RGCSITE;";
        r2 = r2.rawQuery(r3, r0);	 Catch:{ Exception -> 0x0065, all -> 0x0058 }
        r2.moveToFirst();	 Catch:{ Exception -> 0x0066, all -> 0x0056 }
        r3 = r2.getInt(r1);	 Catch:{ Exception -> 0x0066, all -> 0x0056 }
        r5.f = r3;	 Catch:{ Exception -> 0x0066, all -> 0x0056 }
        r3 = r5.d;	 Catch:{ Exception -> 0x0066, all -> 0x0056 }
        r4 = "SELECT COUNT(*) FROM RGCAREA;";
        r3 = r3.rawQuery(r4, r0);	 Catch:{ Exception -> 0x0066, all -> 0x0056 }
        r3.moveToFirst();	 Catch:{ Exception -> 0x0054, all -> 0x0050 }
        r0 = r3.getInt(r1);	 Catch:{ Exception -> 0x0054, all -> 0x0050 }
        r5.e = r0;	 Catch:{ Exception -> 0x0054, all -> 0x0050 }
        if (r2 == 0) goto L_0x004a;
    L_0x0047:
        r2.close();	 Catch:{ Exception -> 0x004a }
    L_0x004a:
        if (r3 == 0) goto L_0x0070;
    L_0x004c:
        r3.close();	 Catch:{ Exception -> 0x0070 }
        goto L_0x0070;
    L_0x0050:
        r0 = move-exception;
        r1 = r0;
        r0 = r3;
        goto L_0x005a;
    L_0x0054:
        r0 = r3;
        goto L_0x0066;
    L_0x0056:
        r1 = move-exception;
        goto L_0x005a;
    L_0x0058:
        r1 = move-exception;
        r2 = r0;
    L_0x005a:
        if (r2 == 0) goto L_0x005f;
    L_0x005c:
        r2.close();	 Catch:{ Exception -> 0x005f }
    L_0x005f:
        if (r0 == 0) goto L_0x0064;
    L_0x0061:
        r0.close();	 Catch:{ Exception -> 0x0064 }
    L_0x0064:
        throw r1;
    L_0x0065:
        r2 = r0;
    L_0x0066:
        if (r2 == 0) goto L_0x006b;
    L_0x0068:
        r2.close();	 Catch:{ Exception -> 0x006b }
    L_0x006b:
        if (r0 == 0) goto L_0x0070;
    L_0x006d:
        r0.close();	 Catch:{ Exception -> 0x0070 }
    L_0x0070:
        r0 = r5.f;
        if (r0 != 0) goto L_0x007a;
    L_0x0074:
        r0 = r5.e;
        if (r0 != 0) goto L_0x007a;
    L_0x0078:
        r0 = 1;
        return r0;
    L_0x007a:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.d.k.a():boolean");
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ae A:{SYNTHETIC, Splitter:B:37:0x00ae} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a6 A:{Splitter:B:7:0x0023, ExcHandler: all (r0_0 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a6 A:{Splitter:B:7:0x0023, ExcHandler: all (r0_0 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a6 A:{Splitter:B:7:0x0023, ExcHandler: all (r0_0 'th' java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:25:0x009b, code skipped:
            r18 = r14;
     */
    /* JADX WARNING: Missing block: B:27:0x009d, code skipped:
            r2 = r18;
     */
    /* JADX WARNING: Missing block: B:29:0x00a0, code skipped:
            if (r12 != null) goto L_0x00a2;
     */
    /* JADX WARNING: Missing block: B:31:?, code skipped:
            r12.close();
     */
    /* JADX WARNING: Missing block: B:32:0x00a6, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:33:0x00a7, code skipped:
            r1 = r0;
     */
    /* JADX WARNING: Missing block: B:43:0x00b3, code skipped:
            if (r12 == null) goto L_0x00b6;
     */
    public java.util.List<com.baidu.location.Poi> b(double r20, double r22) {
        /*
        r19 = this;
        r10 = r19;
        r11 = new java.util.ArrayList;
        r11.<init>();
        r1 = com.baidu.location.d.k.b.POI;
        r2 = r10.c;
        r3 = r20;
        r5 = r22;
        r1 = r1.a(r2, r3, r5);
        r2 = 0;
        r3 = r10.d;	 Catch:{ Exception -> 0x00b2, all -> 0x00a9 }
        r12 = r3.rawQuery(r1, r2);	 Catch:{ Exception -> 0x00b2, all -> 0x00a9 }
        r1 = r12.moveToFirst();	 Catch:{ Exception -> 0x00b3, all -> 0x00a6 }
        if (r1 == 0) goto L_0x00a0;
    L_0x0020:
        r13 = 0;
        r14 = r2;
        r15 = r13;
    L_0x0023:
        r1 = r12.isAfterLast();	 Catch:{ Exception -> 0x009b, all -> 0x00a6 }
        if (r1 != 0) goto L_0x0096;
    L_0x0029:
        r8 = r12.getString(r13);	 Catch:{ Exception -> 0x009b, all -> 0x00a6 }
        r1 = 2;
        r9 = r12.getString(r1);	 Catch:{ Exception -> 0x009b, all -> 0x00a6 }
        r1 = 4;
        r16 = r12.getDouble(r1);	 Catch:{ Exception -> 0x009b, all -> 0x00a6 }
        r1 = 5;
        r6 = r12.getDouble(r1);	 Catch:{ Exception -> 0x009b, all -> 0x00a6 }
        r1 = 6;
        r4 = r12.getInt(r1);	 Catch:{ Exception -> 0x009b, all -> 0x00a6 }
        r1 = r10;
        r2 = r22;
        r13 = r4;
        r4 = r20;
        r10 = r8;
        r18 = r14;
        r14 = r9;
        r8 = r16;
        r1 = r1.c(r2, r4, r6, r8);	 Catch:{ Exception -> 0x009d, all -> 0x00a6 }
        r3 = com.baidu.location.d.k.b.POI;	 Catch:{ Exception -> 0x009d, all -> 0x00a6 }
        r3 = r3.e;	 Catch:{ Exception -> 0x009d, all -> 0x00a6 }
        r3 = (double) r3;	 Catch:{ Exception -> 0x009d, all -> 0x00a6 }
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 >= 0) goto L_0x008b;
    L_0x005c:
        r3 = new com.baidu.location.Poi;	 Catch:{ Exception -> 0x009d, all -> 0x00a6 }
        r4 = new java.lang.String;	 Catch:{ Exception -> 0x009d, all -> 0x00a6 }
        r5 = r10.getBytes();	 Catch:{ Exception -> 0x009d, all -> 0x00a6 }
        r5 = com.baidu.android.bbalbs.common.a.b.a(r5);	 Catch:{ Exception -> 0x009d, all -> 0x00a6 }
        r4.<init>(r5);	 Catch:{ Exception -> 0x009d, all -> 0x00a6 }
        r5 = new java.lang.String;	 Catch:{ Exception -> 0x009d, all -> 0x00a6 }
        r6 = r14.getBytes();	 Catch:{ Exception -> 0x009d, all -> 0x00a6 }
        r6 = com.baidu.android.bbalbs.common.a.b.a(r6);	 Catch:{ Exception -> 0x009d, all -> 0x00a6 }
        r5.<init>(r6);	 Catch:{ Exception -> 0x009d, all -> 0x00a6 }
        r6 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r3.<init>(r4, r5, r6);	 Catch:{ Exception -> 0x009d, all -> 0x00a6 }
        r1 = (float) r1;	 Catch:{ Exception -> 0x009d, all -> 0x00a6 }
        r1 = java.lang.Math.round(r1);	 Catch:{ Exception -> 0x009d, all -> 0x00a6 }
        r1 = a(r13, r1);	 Catch:{ Exception -> 0x009d, all -> 0x00a6 }
        if (r1 <= r15) goto L_0x008b;
    L_0x0088:
        r15 = r1;
        r14 = r3;
        goto L_0x008d;
    L_0x008b:
        r14 = r18;
    L_0x008d:
        r12.moveToNext();	 Catch:{ Exception -> 0x0094, all -> 0x00a6 }
        r10 = r19;
        r13 = 0;
        goto L_0x0023;
    L_0x0094:
        r2 = r14;
        goto L_0x00b3;
    L_0x0096:
        r18 = r14;
        r2 = r18;
        goto L_0x00a0;
    L_0x009b:
        r18 = r14;
    L_0x009d:
        r2 = r18;
        goto L_0x00b3;
    L_0x00a0:
        if (r12 == 0) goto L_0x00b6;
    L_0x00a2:
        r12.close();	 Catch:{ Exception -> 0x00b6 }
        goto L_0x00b6;
    L_0x00a6:
        r0 = move-exception;
        r1 = r0;
        goto L_0x00ac;
    L_0x00a9:
        r0 = move-exception;
        r1 = r0;
        r12 = r2;
    L_0x00ac:
        if (r12 == 0) goto L_0x00b1;
    L_0x00ae:
        r12.close();	 Catch:{ Exception -> 0x00b1 }
    L_0x00b1:
        throw r1;
    L_0x00b2:
        r12 = r2;
    L_0x00b3:
        if (r12 == 0) goto L_0x00b6;
    L_0x00b5:
        goto L_0x00a2;
    L_0x00b6:
        if (r2 == 0) goto L_0x00bb;
    L_0x00b8:
        r11.add(r2);
    L_0x00bb:
        return r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.d.k.b(double, double):java.util.List");
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01ff A:{SYNTHETIC, Splitter:B:87:0x01ff} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0204 A:{SYNTHETIC, Splitter:B:91:0x0204} */
    /* JADX WARNING: Removed duplicated region for block: B:108:? A:{SYNTHETIC, RETURN, SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01f2 A:{SYNTHETIC, Splitter:B:75:0x01f2} */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01f7 A:{SYNTHETIC, Splitter:B:79:0x01f7} */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01ff A:{SYNTHETIC, Splitter:B:87:0x01ff} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0204 A:{SYNTHETIC, Splitter:B:91:0x0204} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:108:? A:{SYNTHETIC, RETURN, SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01f2 A:{SYNTHETIC, Splitter:B:75:0x01f2} */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01f7 A:{SYNTHETIC, Splitter:B:79:0x01f7} */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01ff A:{SYNTHETIC, Splitter:B:87:0x01ff} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0204 A:{SYNTHETIC, Splitter:B:91:0x0204} */
    /* JADX WARNING: Removed duplicated region for block: B:108:? A:{SYNTHETIC, RETURN, SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01f2 A:{SYNTHETIC, Splitter:B:75:0x01f2} */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01f7 A:{SYNTHETIC, Splitter:B:79:0x01f7} */
    public org.json.JSONObject b() {
        /*
        r20 = this;
        r1 = r20;
        r2 = new org.json.JSONObject;
        r2.<init>();
        r3 = new java.lang.StringBuffer;
        r3.<init>();
        r4 = new java.lang.StringBuffer;
        r4.<init>();
        r5 = java.lang.System.currentTimeMillis();
        r7 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r5 = r5 / r7;
        r5 = (int) r5;
        r6 = "SELECT * FROM RGCUPDATE WHERE type=%d AND %d > timestamp+%d ORDER BY gridkey";
        r7 = "UPDATE RGCUPDATE SET timestamp=timestamp+1 WHERE type = %d AND gridkey IN (%s)";
        r9 = r1.d;	 Catch:{ Exception -> 0x01fb, all -> 0x01ec }
        r12 = 0;
        if (r9 == 0) goto L_0x0185;
    L_0x0023:
        r9 = r1.d;	 Catch:{ Exception -> 0x01fb, all -> 0x01ec }
        r9 = r9.isOpen();	 Catch:{ Exception -> 0x01fb, all -> 0x01ec }
        if (r9 == 0) goto L_0x0185;
    L_0x002b:
        r9 = new org.json.JSONArray;	 Catch:{ Exception -> 0x01fb, all -> 0x01ec }
        r9.<init>();	 Catch:{ Exception -> 0x01fb, all -> 0x01ec }
        r13 = new org.json.JSONArray;	 Catch:{ Exception -> 0x01fb, all -> 0x01ec }
        r13.<init>();	 Catch:{ Exception -> 0x01fb, all -> 0x01ec }
        r14 = new org.json.JSONArray;	 Catch:{ Exception -> 0x01fb, all -> 0x01ec }
        r14.<init>();	 Catch:{ Exception -> 0x01fb, all -> 0x01ec }
        r15 = new org.json.JSONArray;	 Catch:{ Exception -> 0x01fb, all -> 0x01ec }
        r15.<init>();	 Catch:{ Exception -> 0x01fb, all -> 0x01ec }
        r8 = r1.d;	 Catch:{ Exception -> 0x01fb, all -> 0x01ec }
        r10 = 3;
        r11 = new java.lang.Object[r10];	 Catch:{ Exception -> 0x01fb, all -> 0x01ec }
        r18 = java.lang.Integer.valueOf(r12);	 Catch:{ Exception -> 0x01fb, all -> 0x01ec }
        r11[r12] = r18;	 Catch:{ Exception -> 0x01fb, all -> 0x01ec }
        r18 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x01fb, all -> 0x01ec }
        r17 = 1;
        r11[r17] = r18;	 Catch:{ Exception -> 0x01fb, all -> 0x01ec }
        r12 = r1.a;	 Catch:{ Exception -> 0x01fb, all -> 0x01ec }
        r12 = r12.l();	 Catch:{ Exception -> 0x01fb, all -> 0x01ec }
        r12 = r12.p();	 Catch:{ Exception -> 0x01fb, all -> 0x01ec }
        r12 = java.lang.Integer.valueOf(r12);	 Catch:{ Exception -> 0x01fb, all -> 0x01ec }
        r16 = 2;
        r11[r16] = r12;	 Catch:{ Exception -> 0x01fb, all -> 0x01ec }
        r11 = java.lang.String.format(r6, r11);	 Catch:{ Exception -> 0x01fb, all -> 0x01ec }
        r12 = 0;
        r8 = r8.rawQuery(r11, r12);	 Catch:{ Exception -> 0x01fb, all -> 0x01ec }
        r11 = r1.d;	 Catch:{ Exception -> 0x0182, all -> 0x017d }
        r10 = new java.lang.Object[r10];	 Catch:{ Exception -> 0x0182, all -> 0x017d }
        r12 = 1;
        r17 = java.lang.Integer.valueOf(r12);	 Catch:{ Exception -> 0x0182, all -> 0x017d }
        r18 = 0;
        r10[r18] = r17;	 Catch:{ Exception -> 0x0182, all -> 0x017d }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0182, all -> 0x017d }
        r10[r12] = r5;	 Catch:{ Exception -> 0x0182, all -> 0x017d }
        r5 = r1.a;	 Catch:{ Exception -> 0x0182, all -> 0x017d }
        r5 = r5.l();	 Catch:{ Exception -> 0x0182, all -> 0x017d }
        r5 = r5.q();	 Catch:{ Exception -> 0x0182, all -> 0x017d }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0182, all -> 0x017d }
        r12 = 2;
        r10[r12] = r5;	 Catch:{ Exception -> 0x0182, all -> 0x017d }
        r5 = java.lang.String.format(r6, r10);	 Catch:{ Exception -> 0x0182, all -> 0x017d }
        r12 = 0;
        r5 = r11.rawQuery(r5, r12);	 Catch:{ Exception -> 0x0182, all -> 0x017d }
        r6 = r8.moveToFirst();	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        if (r6 == 0) goto L_0x00ed;
    L_0x00a0:
        r6 = new java.util.HashSet;	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r6.<init>();	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
    L_0x00a5:
        r10 = r8.isAfterLast();	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        if (r10 != 0) goto L_0x00d8;
    L_0x00ab:
        r10 = 0;
        r11 = r8.getString(r10);	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r10 = 1;
        r12 = r8.getString(r10);	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r14.put(r11);	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r6.add(r12);	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r10 = r4.length();	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        if (r10 <= 0) goto L_0x00c6;
    L_0x00c1:
        r10 = ",";
        r4.append(r10);	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
    L_0x00c6:
        r10 = "\"";
        r4.append(r10);	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r4.append(r11);	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r10 = "\"";
        r4.append(r10);	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r8.moveToNext();	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r12 = 0;
        goto L_0x00a5;
    L_0x00d8:
        r10 = r6.size();	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r10 = new java.lang.String[r10];	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r6.toArray(r10);	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r6 = 0;
    L_0x00e2:
        r11 = r10.length;	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        if (r6 >= r11) goto L_0x00ed;
    L_0x00e5:
        r11 = r10[r6];	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r15.put(r11);	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r6 = r6 + 1;
        goto L_0x00e2;
    L_0x00ed:
        r6 = r5.moveToFirst();	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        if (r6 == 0) goto L_0x013f;
    L_0x00f3:
        r6 = new java.util.HashSet;	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r6.<init>();	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
    L_0x00f8:
        r10 = r5.isAfterLast();	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        if (r10 != 0) goto L_0x012a;
    L_0x00fe:
        r10 = 0;
        r11 = r5.getString(r10);	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r10 = 1;
        r12 = r5.getString(r10);	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r9.put(r11);	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r6.add(r12);	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r10 = r3.length();	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        if (r10 <= 0) goto L_0x0119;
    L_0x0114:
        r10 = ",";
        r3.append(r10);	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
    L_0x0119:
        r10 = "\"";
        r3.append(r10);	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r3.append(r11);	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r10 = "\"";
        r3.append(r10);	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r5.moveToNext();	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        goto L_0x00f8;
    L_0x012a:
        r10 = r6.size();	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r10 = new java.lang.String[r10];	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r6.toArray(r10);	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r6 = 0;
    L_0x0134:
        r11 = r10.length;	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        if (r6 >= r11) goto L_0x013f;
    L_0x0137:
        r11 = r10[r6];	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r13.put(r11);	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r6 = r6 + 1;
        goto L_0x0134;
    L_0x013f:
        r6 = r14.length();	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        if (r6 == 0) goto L_0x0159;
    L_0x0145:
        r6 = new org.json.JSONObject;	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r6.<init>();	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r10 = "gk";
        r6.put(r10, r14);	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r10 = "ver";
        r6.put(r10, r15);	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r10 = "addr";
        r2.put(r10, r6);	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
    L_0x0159:
        r6 = r9.length();	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        if (r6 == 0) goto L_0x0173;
    L_0x015f:
        r6 = new org.json.JSONObject;	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r6.<init>();	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r10 = "gk";
        r6.put(r10, r9);	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r9 = "ver";
        r6.put(r9, r13);	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
        r9 = "poi";
        r2.put(r9, r6);	 Catch:{ Exception -> 0x01fd, all -> 0x0179 }
    L_0x0173:
        r19 = r8;
        r8 = r5;
        r5 = r19;
        goto L_0x0187;
    L_0x0179:
        r0 = move-exception;
        r2 = r0;
        goto L_0x01f0;
    L_0x017d:
        r0 = move-exception;
        r2 = r0;
        r5 = 0;
        goto L_0x01f0;
    L_0x0182:
        r5 = 0;
        goto L_0x01fd;
    L_0x0185:
        r5 = 0;
        r8 = 0;
    L_0x0187:
        r6 = r4.length();	 Catch:{ Exception -> 0x01e6, all -> 0x01de }
        if (r6 <= 0) goto L_0x01ad;
    L_0x018d:
        r6 = java.util.Locale.US;	 Catch:{ Exception -> 0x01e6, all -> 0x01de }
        r9 = 2;
        r10 = new java.lang.Object[r9];	 Catch:{ Exception -> 0x01e6, all -> 0x01de }
        r9 = 0;
        r11 = java.lang.Integer.valueOf(r9);	 Catch:{ Exception -> 0x01e6, all -> 0x01de }
        r10[r9] = r11;	 Catch:{ Exception -> 0x01e6, all -> 0x01de }
        r4 = r4.toString();	 Catch:{ Exception -> 0x01e6, all -> 0x01de }
        r9 = 1;
        r10[r9] = r4;	 Catch:{ Exception -> 0x01e6, all -> 0x01de }
        r4 = java.lang.String.format(r6, r7, r10);	 Catch:{ Exception -> 0x01e6, all -> 0x01de }
        r6 = r1.d;	 Catch:{ Exception -> 0x01e6, all -> 0x01de }
        if (r6 == 0) goto L_0x01ad;
    L_0x01a8:
        r6 = r1.d;	 Catch:{ Exception -> 0x01e6, all -> 0x01de }
        r6.execSQL(r4);	 Catch:{ Exception -> 0x01e6, all -> 0x01de }
    L_0x01ad:
        r4 = r3.length();	 Catch:{ Exception -> 0x01e6, all -> 0x01de }
        if (r4 <= 0) goto L_0x01d3;
    L_0x01b3:
        r4 = java.util.Locale.US;	 Catch:{ Exception -> 0x01e6, all -> 0x01de }
        r6 = 2;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x01e6, all -> 0x01de }
        r9 = 1;
        r10 = java.lang.Integer.valueOf(r9);	 Catch:{ Exception -> 0x01e6, all -> 0x01de }
        r11 = 0;
        r6[r11] = r10;	 Catch:{ Exception -> 0x01e6, all -> 0x01de }
        r3 = r3.toString();	 Catch:{ Exception -> 0x01e6, all -> 0x01de }
        r6[r9] = r3;	 Catch:{ Exception -> 0x01e6, all -> 0x01de }
        r3 = java.lang.String.format(r4, r7, r6);	 Catch:{ Exception -> 0x01e6, all -> 0x01de }
        r4 = r1.d;	 Catch:{ Exception -> 0x01e6, all -> 0x01de }
        if (r4 == 0) goto L_0x01d3;
    L_0x01ce:
        r4 = r1.d;	 Catch:{ Exception -> 0x01e6, all -> 0x01de }
        r4.execSQL(r3);	 Catch:{ Exception -> 0x01e6, all -> 0x01de }
    L_0x01d3:
        if (r5 == 0) goto L_0x01d8;
    L_0x01d5:
        r5.close();	 Catch:{ Exception -> 0x01d8 }
    L_0x01d8:
        if (r8 == 0) goto L_0x0207;
    L_0x01da:
        r8.close();	 Catch:{ Exception -> 0x0207 }
        goto L_0x0207;
    L_0x01de:
        r0 = move-exception;
        r2 = r0;
        r19 = r8;
        r8 = r5;
        r5 = r19;
        goto L_0x01f0;
    L_0x01e6:
        r19 = r8;
        r8 = r5;
        r5 = r19;
        goto L_0x01fd;
    L_0x01ec:
        r0 = move-exception;
        r2 = r0;
        r5 = 0;
        r8 = 0;
    L_0x01f0:
        if (r8 == 0) goto L_0x01f5;
    L_0x01f2:
        r8.close();	 Catch:{ Exception -> 0x01f5 }
    L_0x01f5:
        if (r5 == 0) goto L_0x01fa;
    L_0x01f7:
        r5.close();	 Catch:{ Exception -> 0x01fa }
    L_0x01fa:
        throw r2;
    L_0x01fb:
        r5 = 0;
        r8 = 0;
    L_0x01fd:
        if (r8 == 0) goto L_0x0202;
    L_0x01ff:
        r8.close();	 Catch:{ Exception -> 0x0202 }
    L_0x0202:
        if (r5 == 0) goto L_0x0207;
    L_0x0204:
        r5.close();	 Catch:{ Exception -> 0x0207 }
    L_0x0207:
        r3 = "poi";
        r3 = r2.has(r3);
        if (r3 != 0) goto L_0x0218;
    L_0x020f:
        r3 = "addr";
        r3 = r2.has(r3);
        if (r3 != 0) goto L_0x0218;
    L_0x0217:
        r2 = 0;
    L_0x0218:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.d.k.b():org.json.JSONObject");
    }
}
