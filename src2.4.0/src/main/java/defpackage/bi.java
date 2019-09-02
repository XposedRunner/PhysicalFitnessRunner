package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import com.umeng.commonsdk.utils.UMUtils;
import defpackage.bg.O000000o;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: UMProcessDBHelper */
/* renamed from: bi */
public class bi {
    private static bi O000000o;
    private Context O00000Oo;
    private O000000o O00000o = new O000000o(this, null);
    private FileLockUtil O00000o0 = new FileLockUtil();

    /* compiled from: UMProcessDBHelper */
    /* renamed from: bi$1 */
    class 1 implements O000000o {
        1() {
        }

        public void O000000o() {
            if (AnalyticsConstants.SUB_PROCESS_EVENT) {
                UMWorkDispatch.sendEvent(bi.this.O00000Oo, bh.O00000Oo, bh.O000000o(bi.this.O00000Oo), null);
            }
        }
    }

    /* compiled from: UMProcessDBHelper */
    /* renamed from: bi$O000000o */
    private class O000000o implements FileLockCallback {
        private O000000o() {
        }

        /* synthetic */ O000000o(bi biVar, 1 1) {
            this();
        }

        public boolean onFileLock(File file, int i) {
            return false;
        }

        public boolean onFileLock(String str) {
            return false;
        }

        public boolean onFileLock(String str, Object obj) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (str.startsWith(bj.O00000o0)) {
                str = str.replaceFirst(bj.O00000o0, "");
            }
            bi.this.O00000Oo(str.replace(bj.O00000o, ""), (JSONArray) obj);
            return true;
        }
    }

    /* compiled from: UMProcessDBHelper */
    /* renamed from: bi$O00000Oo */
    private class O00000Oo implements FileLockCallback {
        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(bi biVar, 1 1) {
            this();
        }

        public boolean onFileLock(File file, int i) {
            return false;
        }

        public boolean onFileLock(String str) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (str.startsWith(bj.O00000o0)) {
                str = str.replaceFirst(bj.O00000o0, "");
            }
            bi.this.O00000Oo(str.replace(bj.O00000o, ""));
            return true;
        }

        public boolean onFileLock(String str, Object obj) {
            return false;
        }
    }

    /* compiled from: UMProcessDBHelper */
    /* renamed from: bi$O00000o0 */
    private class O00000o0 implements Serializable {
        int O000000o;
        String O00000Oo;
        String O00000o;
        String O00000o0;
        int O00000oO;
        String O00000oo;
        String O0000O0o;
        String O0000OOo;

        private O00000o0() {
        }

        /* synthetic */ O00000o0(bi biVar, 1 1) {
            this();
        }
    }

    private bi() {
    }

    private bi(Context context) {
        bc.O000000o().O000000o(context);
    }

    public static bi O000000o(Context context) {
        if (O000000o == null) {
            synchronized (bi.class) {
                if (O000000o == null) {
                    O000000o = new bi(context);
                }
            }
        }
        O000000o.O00000Oo = context;
        return O000000o;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0098 A:{SYNTHETIC, Splitter:B:39:0x0098} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0087 A:{SYNTHETIC, Splitter:B:29:0x0087} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0081 A:{Splitter:B:8:0x001c, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:25:0x0081, code skipped:
            r9 = th;
     */
    /* JADX WARNING: Missing block: B:30:?, code skipped:
            r2.endTransaction();
     */
    /* JADX WARNING: Missing block: B:40:?, code skipped:
            r2.endTransaction();
     */
    private boolean O000000o(java.lang.String r8, java.util.List<defpackage.bi.O00000o0> r9) {
        /*
        r7 = this;
        r0 = android.text.TextUtils.isEmpty(r8);
        r1 = 1;
        if (r0 != 0) goto L_0x00a5;
    L_0x0007:
        if (r9 == 0) goto L_0x00a5;
    L_0x0009:
        r0 = r9.isEmpty();
        if (r0 == 0) goto L_0x0011;
    L_0x000f:
        goto L_0x00a5;
    L_0x0011:
        r0 = 0;
        r2 = r7.O00000Oo;	 Catch:{ Exception -> 0x0094, all -> 0x0083 }
        r2 = defpackage.bl.O000000o(r2);	 Catch:{ Exception -> 0x0094, all -> 0x0083 }
        r2 = r2.O000000o(r8);	 Catch:{ Exception -> 0x0094, all -> 0x0083 }
        r2.beginTransaction();	 Catch:{ Exception -> 0x0095, all -> 0x0081 }
        r9 = r9.iterator();	 Catch:{ Exception -> 0x0095, all -> 0x0081 }
    L_0x0023:
        r3 = r9.hasNext();	 Catch:{ Exception -> 0x0095, all -> 0x0081 }
        if (r3 == 0) goto L_0x006f;
    L_0x0029:
        r3 = r9.next();	 Catch:{ Exception -> 0x0095, all -> 0x0081 }
        r3 = (defpackage.bi.O00000o0) r3;	 Catch:{ Exception -> 0x0095, all -> 0x0081 }
        r4 = new android.content.ContentValues;	 Catch:{ Exception -> 0x0023, all -> 0x0081 }
        r4.<init>();	 Catch:{ Exception -> 0x0023, all -> 0x0081 }
        r5 = "__i";
        r6 = r3.O00000Oo;	 Catch:{ Exception -> 0x0023, all -> 0x0081 }
        r4.put(r5, r6);	 Catch:{ Exception -> 0x0023, all -> 0x0081 }
        r5 = "__e";
        r6 = r3.O00000o0;	 Catch:{ Exception -> 0x0023, all -> 0x0081 }
        r4.put(r5, r6);	 Catch:{ Exception -> 0x0023, all -> 0x0081 }
        r5 = "__t";
        r6 = r3.O00000oO;	 Catch:{ Exception -> 0x0023, all -> 0x0081 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x0023, all -> 0x0081 }
        r4.put(r5, r6);	 Catch:{ Exception -> 0x0023, all -> 0x0081 }
        r5 = "__pn";
        r6 = r3.O00000oo;	 Catch:{ Exception -> 0x0023, all -> 0x0081 }
        r4.put(r5, r6);	 Catch:{ Exception -> 0x0023, all -> 0x0081 }
        r5 = "__av";
        r6 = r3.O0000O0o;	 Catch:{ Exception -> 0x0023, all -> 0x0081 }
        r4.put(r5, r6);	 Catch:{ Exception -> 0x0023, all -> 0x0081 }
        r5 = "__vc";
        r6 = r3.O0000OOo;	 Catch:{ Exception -> 0x0023, all -> 0x0081 }
        r4.put(r5, r6);	 Catch:{ Exception -> 0x0023, all -> 0x0081 }
        r5 = "__s";
        r3 = r3.O00000o;	 Catch:{ Exception -> 0x0023, all -> 0x0081 }
        r4.put(r5, r3);	 Catch:{ Exception -> 0x0023, all -> 0x0081 }
        r3 = "__et_p";
        r2.insert(r3, r0, r4);	 Catch:{ Exception -> 0x0023, all -> 0x0081 }
        goto L_0x0023;
    L_0x006f:
        r2.setTransactionSuccessful();	 Catch:{ Exception -> 0x0095, all -> 0x0081 }
        if (r2 == 0) goto L_0x0077;
    L_0x0074:
        r2.endTransaction();	 Catch:{ Throwable -> 0x0077 }
    L_0x0077:
        r9 = r7.O00000Oo;
        r9 = defpackage.bl.O000000o(r9);
        r9.O00000Oo(r8);
        return r1;
    L_0x0081:
        r9 = move-exception;
        goto L_0x0085;
    L_0x0083:
        r9 = move-exception;
        r2 = r0;
    L_0x0085:
        if (r2 == 0) goto L_0x008a;
    L_0x0087:
        r2.endTransaction();	 Catch:{ Throwable -> 0x008a }
    L_0x008a:
        r0 = r7.O00000Oo;
        r0 = defpackage.bl.O000000o(r0);
        r0.O00000Oo(r8);
        throw r9;
    L_0x0094:
        r2 = r0;
    L_0x0095:
        r9 = 0;
        if (r2 == 0) goto L_0x009b;
    L_0x0098:
        r2.endTransaction();	 Catch:{ Throwable -> 0x009b }
    L_0x009b:
        r0 = r7.O00000Oo;
        r0 = defpackage.bl.O000000o(r0);
        r0.O00000Oo(r8);
        return r9;
    L_0x00a5:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bi.O000000o(java.lang.String, java.util.List):boolean");
    }

    private int O00000Oo() {
        return 0;
    }

    private void O00000Oo(String str) {
        if (O00000o(str)) {
            List O00000o0 = O00000o0(str);
            if (!O00000o0.isEmpty() && O000000o(bj.O0000OOo, O00000o0)) {
                O000000o(str, null, O00000o0);
            }
        }
    }

    private boolean O00000Oo(Context context) {
        try {
            if (context.getPackageManager().getServiceInfo(new ComponentName(context, this.O00000Oo.getClass()), 0) != null) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private boolean O00000o(String str) {
        try {
            if (new File(bk.O00000Oo(this.O00000Oo, str)).exists()) {
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b9 A:{SYNTHETIC, Splitter:B:36:0x00b9} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00be A:{Catch:{ Exception -> 0x00c1 }} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a4 A:{SYNTHETIC, Splitter:B:27:0x00a4} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b9 A:{SYNTHETIC, Splitter:B:36:0x00b9} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00be A:{Catch:{ Exception -> 0x00c1 }} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a4 A:{SYNTHETIC, Splitter:B:27:0x00a4} */
    /* JADX WARNING: Missing block: B:15:0x008c, code skipped:
            if (r3 != null) goto L_0x00a9;
     */
    /* JADX WARNING: Missing block: B:29:0x00a7, code skipped:
            if (r3 != null) goto L_0x00a9;
     */
    /* JADX WARNING: Missing block: B:30:0x00a9, code skipped:
            r3.endTransaction();
     */
    private java.util.List<defpackage.bi.O00000o0> O00000o0(java.lang.String r8) {
        /*
        r7 = this;
        r0 = "select *  from __et_p";
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = 0;
        r3 = r7.O00000Oo;	 Catch:{ Exception -> 0x009b, all -> 0x0097 }
        r3 = defpackage.bl.O000000o(r3);	 Catch:{ Exception -> 0x009b, all -> 0x0097 }
        r3 = r3.O000000o(r8);	 Catch:{ Exception -> 0x009b, all -> 0x0097 }
        r3.beginTransaction();	 Catch:{ Exception -> 0x0092, all -> 0x008f }
        r0 = r3.rawQuery(r0, r2);	 Catch:{ Exception -> 0x0092, all -> 0x008f }
        if (r0 == 0) goto L_0x0087;
    L_0x001b:
        r4 = r0.moveToNext();	 Catch:{ Exception -> 0x0085 }
        if (r4 == 0) goto L_0x0087;
    L_0x0021:
        r4 = new bi$O00000o0;	 Catch:{ Exception -> 0x0085 }
        r4.<init>(r7, r2);	 Catch:{ Exception -> 0x0085 }
        r5 = 0;
        r5 = r0.getInt(r5);	 Catch:{ Exception -> 0x0085 }
        r4.O000000o = r5;	 Catch:{ Exception -> 0x0085 }
        r5 = "__i";
        r5 = r0.getColumnIndex(r5);	 Catch:{ Exception -> 0x0085 }
        r5 = r0.getString(r5);	 Catch:{ Exception -> 0x0085 }
        r4.O00000Oo = r5;	 Catch:{ Exception -> 0x0085 }
        r5 = "__e";
        r5 = r0.getColumnIndex(r5);	 Catch:{ Exception -> 0x0085 }
        r5 = r0.getString(r5);	 Catch:{ Exception -> 0x0085 }
        r4.O00000o0 = r5;	 Catch:{ Exception -> 0x0085 }
        r5 = "__s";
        r5 = r0.getColumnIndex(r5);	 Catch:{ Exception -> 0x0085 }
        r5 = r0.getString(r5);	 Catch:{ Exception -> 0x0085 }
        r4.O00000o = r5;	 Catch:{ Exception -> 0x0085 }
        r5 = "__t";
        r5 = r0.getColumnIndex(r5);	 Catch:{ Exception -> 0x0085 }
        r5 = r0.getInt(r5);	 Catch:{ Exception -> 0x0085 }
        r4.O00000oO = r5;	 Catch:{ Exception -> 0x0085 }
        r5 = "__pn";
        r5 = r0.getColumnIndex(r5);	 Catch:{ Exception -> 0x0085 }
        r5 = r0.getString(r5);	 Catch:{ Exception -> 0x0085 }
        r4.O00000oo = r5;	 Catch:{ Exception -> 0x0085 }
        r5 = "__av";
        r5 = r0.getColumnIndex(r5);	 Catch:{ Exception -> 0x0085 }
        r5 = r0.getString(r5);	 Catch:{ Exception -> 0x0085 }
        r4.O0000O0o = r5;	 Catch:{ Exception -> 0x0085 }
        r5 = "__vc";
        r5 = r0.getColumnIndex(r5);	 Catch:{ Exception -> 0x0085 }
        r5 = r0.getString(r5);	 Catch:{ Exception -> 0x0085 }
        r4.O0000OOo = r5;	 Catch:{ Exception -> 0x0085 }
        r1.add(r4);	 Catch:{ Exception -> 0x0085 }
        goto L_0x001b;
    L_0x0085:
        r2 = move-exception;
        goto L_0x009f;
    L_0x0087:
        if (r0 == 0) goto L_0x008c;
    L_0x0089:
        r0.close();	 Catch:{ Exception -> 0x00ac }
    L_0x008c:
        if (r3 == 0) goto L_0x00ac;
    L_0x008e:
        goto L_0x00a9;
    L_0x008f:
        r1 = move-exception;
        r0 = r2;
        goto L_0x00b7;
    L_0x0092:
        r0 = move-exception;
        r6 = r2;
        r2 = r0;
        r0 = r6;
        goto L_0x009f;
    L_0x0097:
        r1 = move-exception;
        r0 = r2;
        r3 = r0;
        goto L_0x00b7;
    L_0x009b:
        r0 = move-exception;
        r3 = r2;
        r2 = r0;
        r0 = r3;
    L_0x009f:
        r2.printStackTrace();	 Catch:{ all -> 0x00b6 }
        if (r0 == 0) goto L_0x00a7;
    L_0x00a4:
        r0.close();	 Catch:{ Exception -> 0x00ac }
    L_0x00a7:
        if (r3 == 0) goto L_0x00ac;
    L_0x00a9:
        r3.endTransaction();	 Catch:{ Exception -> 0x00ac }
    L_0x00ac:
        r0 = r7.O00000Oo;
        r0 = defpackage.bl.O000000o(r0);
        r0.O00000Oo(r8);
        return r1;
    L_0x00b6:
        r1 = move-exception;
    L_0x00b7:
        if (r0 == 0) goto L_0x00bc;
    L_0x00b9:
        r0.close();	 Catch:{ Exception -> 0x00c1 }
    L_0x00bc:
        if (r3 == 0) goto L_0x00c1;
    L_0x00be:
        r3.endTransaction();	 Catch:{ Exception -> 0x00c1 }
    L_0x00c1:
        r0 = r7.O00000Oo;
        r0 = defpackage.bl.O000000o(r0);
        r0.O00000Oo(r8);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bi.O00000o0(java.lang.String):java.util.List");
    }

    private List<O00000o0> O00000o0(String str, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                O00000o0 o00000o0 = new O00000o0(this, null);
                o00000o0.O00000o0 = jSONObject.optString("id");
                o00000o0.O0000O0o = UMUtils.getAppVersionName(this.O00000Oo);
                o00000o0.O0000OOo = UMUtils.getAppVersionCode(this.O00000Oo);
                o00000o0.O00000Oo = jSONObject.optString("__i");
                o00000o0.O00000oO = jSONObject.optInt("__t");
                o00000o0.O00000oo = str;
                if (jSONObject.has(ah.O000OooO)) {
                    jSONObject.remove(ah.O000OooO);
                }
                jSONObject.put(ah.O000OooO, O00000Oo());
                jSONObject.remove("__i");
                jSONObject.remove("__t");
                o00000o0.O00000o = bc.O000000o().O000000o(jSONObject.toString());
                jSONObject.remove(ah.O000OooO);
                arrayList.add(o00000o0);
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x017d A:{SYNTHETIC, Splitter:B:77:0x017d} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x017d A:{SYNTHETIC, Splitter:B:77:0x017d} */
    /* JADX WARNING: Missing block: B:55:0x014c, code skipped:
            if (r5 != null) goto L_0x0164;
     */
    /* JADX WARNING: Missing block: B:66:0x0162, code skipped:
            if (r5 != null) goto L_0x0164;
     */
    /* JADX WARNING: Missing block: B:68:?, code skipped:
            r5.endTransaction();
     */
    public org.json.JSONObject O000000o(long r20, java.util.List<java.lang.Integer> r22) {
        /*
        r19 = this;
        r1 = r19;
        r2 = new org.json.JSONObject;
        r2.<init>();
        r3 = "";
        r4 = 0;
        r5 = r1.O00000Oo;	 Catch:{ Exception -> 0x0157, all -> 0x0152 }
        r5 = defpackage.bl.O000000o(r5);	 Catch:{ Exception -> 0x0157, all -> 0x0152 }
        r6 = "_main_";
        r5 = r5.O000000o(r6);	 Catch:{ Exception -> 0x0157, all -> 0x0152 }
        r5.beginTransaction();	 Catch:{ Exception -> 0x014f }
        r6 = "select *  from __et_p";
        r6 = r5.rawQuery(r6, r4);	 Catch:{ Exception -> 0x014f }
        if (r6 == 0) goto L_0x0144;
    L_0x0021:
        r4 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r4.<init>();	 Catch:{ Exception -> 0x0140, all -> 0x013d }
    L_0x0026:
        r7 = r6.moveToNext();	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        if (r7 == 0) goto L_0x00fb;
    L_0x002c:
        r7 = "id";
        r7 = r6.getColumnIndex(r7);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r7 = r6.getInt(r7);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r8 = "__t";
        r8 = r6.getColumnIndex(r8);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r8 = r6.getInt(r8);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r9 = "__i";
        r9 = r6.getColumnIndex(r9);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r9 = r6.getString(r9);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r10 = "__s";
        r10 = r6.getColumnIndex(r10);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r10 = r6.getString(r10);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r11 = "__pn";
        r11 = r6.getColumnIndex(r11);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r11 = r6.getString(r11);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r12 = "__av";
        r12 = r6.getColumnIndex(r12);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r12 = r6.getString(r12);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r13 = android.text.TextUtils.isEmpty(r9);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        if (r13 == 0) goto L_0x006f;
    L_0x006e:
        goto L_0x0026;
    L_0x006f:
        r13 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        if (r13 == 0) goto L_0x0076;
    L_0x0075:
        r3 = r12;
    L_0x0076:
        r13 = android.text.TextUtils.isEmpty(r10);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        if (r13 != 0) goto L_0x00f7;
    L_0x007c:
        r13 = 2049; // 0x801 float:2.871E-42 double:1.0123E-320;
        if (r8 != r13) goto L_0x00f7;
    L_0x0080:
        r8 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r13 = defpackage.bc.O000000o();	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r10 = r13.O00000Oo(r10);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r8.<init>(r10);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r10 = "pn";
        r10 = r8.optString(r10);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r13 = android.text.TextUtils.isEmpty(r10);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        if (r13 != 0) goto L_0x00a1;
    L_0x0099:
        r13 = "unknown";
        r10 = r13.equals(r10);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        if (r10 == 0) goto L_0x00c0;
    L_0x00a1:
        r10 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r10.<init>();	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r13 = r1.O00000Oo;	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r13 = r13.getPackageName();	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r10.append(r13);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r13 = ":";
        r10.append(r13);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r10.append(r11);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r10 = r10.toString();	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r11 = "pn";
        r8.put(r11, r10);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
    L_0x00c0:
        r10 = r4.has(r9);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        if (r10 == 0) goto L_0x00cb;
    L_0x00c6:
        r10 = r4.optJSONArray(r9);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        goto L_0x00d0;
    L_0x00cb:
        r10 = new org.json.JSONArray;	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r10.<init>();	 Catch:{ Exception -> 0x0140, all -> 0x013d }
    L_0x00d0:
        r13 = defpackage.as.O000000o(r10);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r15 = defpackage.as.O000000o(r8);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r17 = r15 + r13;
        r11 = (r17 > r20 ? 1 : (r17 == r20 ? 0 : -1));
        if (r11 <= 0) goto L_0x00df;
    L_0x00de:
        goto L_0x00fb;
    L_0x00df:
        r11 = r3.equalsIgnoreCase(r12);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        if (r11 != 0) goto L_0x00e6;
    L_0x00e5:
        goto L_0x00fb;
    L_0x00e6:
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r11 = r22;
        r11.add(r7);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r10.put(r8);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r4.put(r9, r10);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        goto L_0x0026;
    L_0x00f7:
        r11 = r22;
        goto L_0x0026;
    L_0x00fb:
        r3 = r4.length();	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        if (r3 <= 0) goto L_0x0144;
    L_0x0101:
        r3 = new org.json.JSONArray;	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r3.<init>();	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r7 = r4.keys();	 Catch:{ Exception -> 0x0140, all -> 0x013d }
    L_0x010a:
        r8 = r7.hasNext();	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        if (r8 == 0) goto L_0x0131;
    L_0x0110:
        r8 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r8.<init>();	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r9 = r7.next();	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r9 = (java.lang.String) r9;	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r10 = r4.optString(r9);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r11 = new org.json.JSONArray;	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r11.<init>(r10);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r8.put(r9, r11);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        r9 = r8.length();	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        if (r9 <= 0) goto L_0x010a;
    L_0x012d:
        r3.put(r8);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        goto L_0x010a;
    L_0x0131:
        r4 = r3.length();	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        if (r4 <= 0) goto L_0x0144;
    L_0x0137:
        r4 = "ekv";
        r2.put(r4, r3);	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        goto L_0x0144;
    L_0x013d:
        r0 = move-exception;
        r2 = r0;
        goto L_0x0176;
    L_0x0140:
        r0 = move-exception;
        r3 = r0;
        r4 = r6;
        goto L_0x015a;
    L_0x0144:
        r5.setTransactionSuccessful();	 Catch:{ Exception -> 0x0140, all -> 0x013d }
        if (r6 == 0) goto L_0x014c;
    L_0x0149:
        r6.close();
    L_0x014c:
        if (r5 == 0) goto L_0x0167;
    L_0x014e:
        goto L_0x0164;
    L_0x014f:
        r0 = move-exception;
        r3 = r0;
        goto L_0x015a;
    L_0x0152:
        r0 = move-exception;
        r2 = r0;
        r5 = r4;
        r6 = r5;
        goto L_0x0176;
    L_0x0157:
        r0 = move-exception;
        r3 = r0;
        r5 = r4;
    L_0x015a:
        r3.printStackTrace();	 Catch:{ all -> 0x0173 }
        if (r4 == 0) goto L_0x0162;
    L_0x015f:
        r4.close();
    L_0x0162:
        if (r5 == 0) goto L_0x0167;
    L_0x0164:
        r5.endTransaction();	 Catch:{ Throwable -> 0x0167 }
    L_0x0167:
        r3 = r1.O00000Oo;
        r3 = defpackage.bl.O000000o(r3);
        r4 = "_main_";
        r3.O00000Oo(r4);
        return r2;
    L_0x0173:
        r0 = move-exception;
        r2 = r0;
        r6 = r4;
    L_0x0176:
        if (r6 == 0) goto L_0x017b;
    L_0x0178:
        r6.close();
    L_0x017b:
        if (r5 == 0) goto L_0x0180;
    L_0x017d:
        r5.endTransaction();	 Catch:{ Throwable -> 0x0180 }
    L_0x0180:
        r3 = r1.O00000Oo;
        r3 = defpackage.bl.O000000o(r3);
        r4 = "_main_";
        r3.O00000Oo(r4);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bi.O000000o(long, java.util.List):org.json.JSONObject");
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0092 A:{SYNTHETIC, Splitter:B:40:0x0092} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0097 A:{Catch:{ Exception -> 0x009a }} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0092 A:{SYNTHETIC, Splitter:B:40:0x0092} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0097 A:{Catch:{ Exception -> 0x009a }} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0092 A:{SYNTHETIC, Splitter:B:40:0x0092} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0097 A:{Catch:{ Exception -> 0x009a }} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00aa A:{SYNTHETIC, Splitter:B:48:0x00aa} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00af A:{Catch:{ Exception -> 0x00b2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00aa A:{SYNTHETIC, Splitter:B:48:0x00aa} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00af A:{Catch:{ Exception -> 0x00b2 }} */
    public org.json.JSONObject O000000o(java.lang.Integer r7) {
        /*
        r6 = this;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "select *  from __et_p where rowid=";
        r0.append(r1);
        r0.append(r7);
        r7 = r0.toString();
        r0 = 0;
        r1 = r6.O00000Oo;	 Catch:{ Exception -> 0x0088, all -> 0x0083 }
        r1 = defpackage.bl.O000000o(r1);	 Catch:{ Exception -> 0x0088, all -> 0x0083 }
        r2 = "_main_";
        r1 = r1.O000000o(r2);	 Catch:{ Exception -> 0x0088, all -> 0x0083 }
        r1.beginTransaction();	 Catch:{ Exception -> 0x0080, all -> 0x007b }
        r7 = r1.rawQuery(r7, r0);	 Catch:{ Exception -> 0x0080, all -> 0x007b }
        if (r7 == 0) goto L_0x0065;
    L_0x0027:
        r2 = r7.moveToNext();	 Catch:{ Exception -> 0x0060 }
        if (r2 == 0) goto L_0x0065;
    L_0x002d:
        r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0060 }
        r2.<init>();	 Catch:{ Exception -> 0x0060 }
        r0 = "__av";
        r0 = r7.getColumnIndex(r0);	 Catch:{ Exception -> 0x005e }
        r0 = r7.getString(r0);	 Catch:{ Exception -> 0x005e }
        r3 = "__vc";
        r3 = r7.getColumnIndex(r3);	 Catch:{ Exception -> 0x005e }
        r3 = r7.getString(r3);	 Catch:{ Exception -> 0x005e }
        r4 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x005e }
        if (r4 != 0) goto L_0x0051;
    L_0x004c:
        r4 = "__av";
        r2.put(r4, r0);	 Catch:{ Exception -> 0x005e }
    L_0x0051:
        r0 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Exception -> 0x005e }
        if (r0 != 0) goto L_0x005c;
    L_0x0057:
        r0 = "__vc";
        r2.put(r0, r3);	 Catch:{ Exception -> 0x005e }
    L_0x005c:
        r0 = r2;
        goto L_0x0065;
    L_0x005e:
        r0 = move-exception;
        goto L_0x008d;
    L_0x0060:
        r2 = move-exception;
        r5 = r2;
        r2 = r0;
        r0 = r5;
        goto L_0x008d;
    L_0x0065:
        if (r7 == 0) goto L_0x006a;
    L_0x0067:
        r7.close();	 Catch:{ Exception -> 0x006f }
    L_0x006a:
        if (r1 == 0) goto L_0x006f;
    L_0x006c:
        r1.endTransaction();	 Catch:{ Exception -> 0x006f }
    L_0x006f:
        r7 = r6.O00000Oo;
        r7 = defpackage.bl.O000000o(r7);
        r1 = "_main_";
        r7.O00000Oo(r1);
        goto L_0x00a6;
    L_0x007b:
        r7 = move-exception;
        r5 = r0;
        r0 = r7;
        r7 = r5;
        goto L_0x00a8;
    L_0x0080:
        r7 = move-exception;
        r2 = r0;
        goto L_0x008b;
    L_0x0083:
        r7 = move-exception;
        r1 = r0;
        r0 = r7;
        r7 = r1;
        goto L_0x00a8;
    L_0x0088:
        r7 = move-exception;
        r1 = r0;
        r2 = r1;
    L_0x008b:
        r0 = r7;
        r7 = r2;
    L_0x008d:
        r0.printStackTrace();	 Catch:{ all -> 0x00a7 }
        if (r7 == 0) goto L_0x0095;
    L_0x0092:
        r7.close();	 Catch:{ Exception -> 0x009a }
    L_0x0095:
        if (r1 == 0) goto L_0x009a;
    L_0x0097:
        r1.endTransaction();	 Catch:{ Exception -> 0x009a }
    L_0x009a:
        r7 = r6.O00000Oo;
        r7 = defpackage.bl.O000000o(r7);
        r0 = "_main_";
        r7.O00000Oo(r0);
        r0 = r2;
    L_0x00a6:
        return r0;
    L_0x00a7:
        r0 = move-exception;
    L_0x00a8:
        if (r7 == 0) goto L_0x00ad;
    L_0x00aa:
        r7.close();	 Catch:{ Exception -> 0x00b2 }
    L_0x00ad:
        if (r1 == 0) goto L_0x00b2;
    L_0x00af:
        r1.endTransaction();	 Catch:{ Exception -> 0x00b2 }
    L_0x00b2:
        r7 = r6.O00000Oo;
        r7 = defpackage.bl.O000000o(r7);
        r1 = "_main_";
        r7.O00000Oo(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bi.O000000o(java.lang.Integer):org.json.JSONObject");
    }

    public void O000000o() {
        try {
            bg.O000000o(bk.O000000o(this.O00000Oo), new O00000Oo(this, null), new 1());
        } catch (Exception unused) {
        }
    }

    public void O000000o(String str) {
        try {
            bl.O000000o(this.O00000Oo).O000000o(str);
            bl.O000000o(this.O00000Oo).O00000Oo(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARNING: Missing block: B:15:0x0047, code skipped:
            if (r0 != null) goto L_0x0061;
     */
    /* JADX WARNING: Missing block: B:25:0x005f, code skipped:
            if (r0 != null) goto L_0x0061;
     */
    /* JADX WARNING: Missing block: B:27:0x0061, code skipped:
            r0.endTransaction();
     */
    /* JADX WARNING: Missing block: B:28:0x0064, code skipped:
            defpackage.bl.O000000o(r4.O00000Oo).O00000Oo(r5);
     */
    /* JADX WARNING: Missing block: B:29:0x006d, code skipped:
            return;
     */
    public void O000000o(java.lang.String r5, java.lang.String r6, java.util.List<defpackage.bi.O00000o0> r7) {
        /*
        r4 = this;
        r6 = android.text.TextUtils.isEmpty(r5);
        if (r6 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r6 = 0;
        r0 = r4.O00000Oo;	 Catch:{ Exception -> 0x005e, all -> 0x004c }
        r0 = defpackage.bl.O000000o(r0);	 Catch:{ Exception -> 0x005e, all -> 0x004c }
        r0 = r0.O000000o(r5);	 Catch:{ Exception -> 0x005e, all -> 0x004c }
        r0.beginTransaction();	 Catch:{ Exception -> 0x005f, all -> 0x004a }
        r1 = r7.size();	 Catch:{ Exception -> 0x005f, all -> 0x004a }
        if (r7 == 0) goto L_0x003f;
    L_0x001b:
        if (r1 <= 0) goto L_0x003f;
    L_0x001d:
        r6 = 0;
    L_0x001e:
        if (r6 >= r1) goto L_0x0044;
    L_0x0020:
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x005f, all -> 0x004a }
        r2.<init>();	 Catch:{ Exception -> 0x005f, all -> 0x004a }
        r3 = "delete from __et_p where rowid=";
        r2.append(r3);	 Catch:{ Exception -> 0x005f, all -> 0x004a }
        r3 = r7.get(r6);	 Catch:{ Exception -> 0x005f, all -> 0x004a }
        r3 = (defpackage.bi.O00000o0) r3;	 Catch:{ Exception -> 0x005f, all -> 0x004a }
        r3 = r3.O000000o;	 Catch:{ Exception -> 0x005f, all -> 0x004a }
        r2.append(r3);	 Catch:{ Exception -> 0x005f, all -> 0x004a }
        r2 = r2.toString();	 Catch:{ Exception -> 0x005f, all -> 0x004a }
        r0.execSQL(r2);	 Catch:{ Exception -> 0x005f, all -> 0x004a }
        r6 = r6 + 1;
        goto L_0x001e;
    L_0x003f:
        r7 = "__et_p";
        r0.delete(r7, r6, r6);	 Catch:{ Exception -> 0x005f, all -> 0x004a }
    L_0x0044:
        r0.setTransactionSuccessful();	 Catch:{ Exception -> 0x005f, all -> 0x004a }
        if (r0 == 0) goto L_0x0064;
    L_0x0049:
        goto L_0x0061;
    L_0x004a:
        r6 = move-exception;
        goto L_0x004f;
    L_0x004c:
        r7 = move-exception;
        r0 = r6;
        r6 = r7;
    L_0x004f:
        if (r0 == 0) goto L_0x0054;
    L_0x0051:
        r0.endTransaction();
    L_0x0054:
        r7 = r4.O00000Oo;
        r7 = defpackage.bl.O000000o(r7);
        r7.O00000Oo(r5);
        throw r6;
    L_0x005e:
        r0 = r6;
    L_0x005f:
        if (r0 == 0) goto L_0x0064;
    L_0x0061:
        r0.endTransaction();
    L_0x0064:
        r6 = r4.O00000Oo;
        r6 = defpackage.bl.O000000o(r6);
        r6.O00000Oo(r5);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bi.O000000o(java.lang.String, java.lang.String, java.util.List):void");
    }

    public void O000000o(String str, JSONArray jSONArray) {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            File file = new File(bk.O00000Oo(this.O00000Oo, str));
            if (file.exists()) {
                this.O00000o0.doFileOperateion(file, this.O00000o, (Object) jSONArray);
            } else {
                O00000Oo(str, jSONArray);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Missing block: B:9:0x0035, code skipped:
            if (r1 != null) goto L_0x0050;
     */
    /* JADX WARNING: Missing block: B:19:0x004e, code skipped:
            if (r1 != null) goto L_0x0050;
     */
    /* JADX WARNING: Missing block: B:21:0x0050, code skipped:
            r1.endTransaction();
     */
    /* JADX WARNING: Missing block: B:22:0x0053, code skipped:
            defpackage.bl.O000000o(r6.O00000Oo).O00000Oo(defpackage.bj.O0000OOo);
     */
    /* JADX WARNING: Missing block: B:23:0x005e, code skipped:
            return;
     */
    public void O000000o(java.util.List<java.lang.Integer> r7) {
        /*
        r6 = this;
        r0 = 0;
        r1 = r6.O00000Oo;	 Catch:{ Exception -> 0x004d, all -> 0x003a }
        r1 = defpackage.bl.O000000o(r1);	 Catch:{ Exception -> 0x004d, all -> 0x003a }
        r2 = "_main_";
        r1 = r1.O000000o(r2);	 Catch:{ Exception -> 0x004d, all -> 0x003a }
        r1.beginTransaction();	 Catch:{ Exception -> 0x004e, all -> 0x0038 }
        r7 = r7.iterator();	 Catch:{ Exception -> 0x004e, all -> 0x0038 }
    L_0x0014:
        r0 = r7.hasNext();	 Catch:{ Exception -> 0x004e, all -> 0x0038 }
        if (r0 == 0) goto L_0x0032;
    L_0x001a:
        r0 = r7.next();	 Catch:{ Exception -> 0x004e, all -> 0x0038 }
        r0 = (java.lang.Integer) r0;	 Catch:{ Exception -> 0x004e, all -> 0x0038 }
        r2 = "__et_p";
        r3 = "id=?";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x004e, all -> 0x0038 }
        r5 = 0;
        r0 = java.lang.String.valueOf(r0);	 Catch:{ Exception -> 0x004e, all -> 0x0038 }
        r4[r5] = r0;	 Catch:{ Exception -> 0x004e, all -> 0x0038 }
        r1.delete(r2, r3, r4);	 Catch:{ Exception -> 0x004e, all -> 0x0038 }
        goto L_0x0014;
    L_0x0032:
        r1.setTransactionSuccessful();	 Catch:{ Exception -> 0x004e, all -> 0x0038 }
        if (r1 == 0) goto L_0x0053;
    L_0x0037:
        goto L_0x0050;
    L_0x0038:
        r7 = move-exception;
        goto L_0x003c;
    L_0x003a:
        r7 = move-exception;
        r1 = r0;
    L_0x003c:
        if (r1 == 0) goto L_0x0041;
    L_0x003e:
        r1.endTransaction();
    L_0x0041:
        r0 = r6.O00000Oo;
        r0 = defpackage.bl.O000000o(r0);
        r1 = "_main_";
        r0.O00000Oo(r1);
        throw r7;
    L_0x004d:
        r1 = r0;
    L_0x004e:
        if (r1 == 0) goto L_0x0053;
    L_0x0050:
        r1.endTransaction();
    L_0x0053:
        r7 = r6.O00000Oo;
        r7 = defpackage.bl.O000000o(r7);
        r0 = "_main_";
        r7.O00000Oo(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bi.O000000o(java.util.List):void");
    }

    public void O00000Oo(String str, JSONArray jSONArray) {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            O000000o(str, O00000o0(str, jSONArray));
        }
    }
}
