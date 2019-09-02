package defpackage;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import defpackage.ai.O00000o.O000000o;
import defpackage.ai.O00000o0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: UMStoreManager */
/* renamed from: am */
public class am {
    public static final int O000000o = 2049;
    public static final int O00000Oo = 2050;
    private static Context O00000o = null;
    private static final int O00000o0 = 1000;
    private static String O00000oO = null;
    private static final String O00000oo = "umeng+";
    private static final String O0000O0o = "ek__id";
    private static final String O0000OOo = "ek_key";
    private List<Integer> O0000Oo;
    private List<String> O0000Oo0;
    private String O0000OoO;
    private List<String> O0000Ooo;

    /* compiled from: UMStoreManager */
    /* renamed from: am$O000000o */
    public enum O000000o {
        AUTOPAGE,
        PAGE,
        BEGIN,
        END,
        NEWSESSION,
        INSTANTSESSIONBEGIN
    }

    /* compiled from: UMStoreManager */
    /* renamed from: am$O00000Oo */
    private static class O00000Oo {
        private static final am O000000o = new am();

        private O00000Oo() {
        }
    }

    private am() {
        this.O0000Oo0 = new ArrayList();
        this.O0000Oo = new ArrayList();
        this.O0000OoO = null;
        this.O0000Ooo = new ArrayList();
    }

    public static am O000000o(Context context) {
        am O000000o = O00000Oo.O000000o;
        if (O00000o == null && context != null) {
            O00000o = context.getApplicationContext();
            O000000o.O0000OoO();
        }
        return O000000o;
    }

    /* JADX WARNING: Removed duplicated region for block: B:129:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0229 A:{SYNTHETIC, Splitter:B:131:0x0229} */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0241 A:{SYNTHETIC, Splitter:B:141:0x0241} */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0241 A:{SYNTHETIC, Splitter:B:141:0x0241} */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0229 A:{SYNTHETIC, Splitter:B:131:0x0229} */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0241 A:{SYNTHETIC, Splitter:B:141:0x0241} */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0229 A:{SYNTHETIC, Splitter:B:131:0x0229} */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0241 A:{SYNTHETIC, Splitter:B:141:0x0241} */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0229 A:{SYNTHETIC, Splitter:B:131:0x0229} */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0241 A:{SYNTHETIC, Splitter:B:141:0x0241} */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0229 A:{SYNTHETIC, Splitter:B:131:0x0229} */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0241 A:{SYNTHETIC, Splitter:B:141:0x0241} */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0229 A:{SYNTHETIC, Splitter:B:131:0x0229} */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0241 A:{SYNTHETIC, Splitter:B:141:0x0241} */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0229 A:{SYNTHETIC, Splitter:B:131:0x0229} */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x016d A:{Splitter:B:10:0x0023, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:51:0x0162, code skipped:
            r18 = r3;
            r19 = r4;
     */
    /* JADX WARNING: Missing block: B:55:0x0168, code skipped:
            r18 = r3;
            r19 = r4;
     */
    /* JADX WARNING: Missing block: B:57:0x016d, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:58:0x016e, code skipped:
            r18 = r3;
            r19 = r4;
     */
    /* JADX WARNING: Missing block: B:103:0x01f2, code skipped:
            if (r4 != null) goto L_0x020e;
     */
    /* JADX WARNING: Missing block: B:119:0x020c, code skipped:
            if (r4 == null) goto L_0x0211;
     */
    /* JADX WARNING: Missing block: B:121:?, code skipped:
            r4.endTransaction();
     */
    private java.lang.String O000000o(org.json.JSONObject r22, boolean r23) {
        /*
        r21 = this;
        r1 = r21;
        r2 = 0;
        r3 = O00000o;	 Catch:{ SQLiteDatabaseCorruptException -> 0x021b, Throwable -> 0x0205, all -> 0x0200 }
        r3 = defpackage.ak.O000000o(r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x021b, Throwable -> 0x0205, all -> 0x0200 }
        r3 = r3.O000000o();	 Catch:{ SQLiteDatabaseCorruptException -> 0x021b, Throwable -> 0x0205, all -> 0x0200 }
        r3.beginTransaction();	 Catch:{ SQLiteDatabaseCorruptException -> 0x01fd, Throwable -> 0x01fa, all -> 0x01f7 }
        r4 = "select *  from __sd";
        r4 = r3.rawQuery(r4, r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x01fd, Throwable -> 0x01fa, all -> 0x01f7 }
        if (r4 == 0) goto L_0x01e5;
    L_0x0018:
        r5 = new org.json.JSONArray;	 Catch:{ SQLiteDatabaseCorruptException -> 0x01dd, Throwable -> 0x01d7, all -> 0x01d0 }
        r5.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x01dd, Throwable -> 0x01d7, all -> 0x01d0 }
    L_0x001d:
        r6 = r4.moveToNext();	 Catch:{ SQLiteDatabaseCorruptException -> 0x01dd, Throwable -> 0x01d7, all -> 0x01d0 }
        if (r6 == 0) goto L_0x018e;
    L_0x0023:
        r6 = new org.json.JSONObject;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0183, Throwable -> 0x0179, all -> 0x016d }
        r6.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0183, Throwable -> 0x0179, all -> 0x016d }
        r7 = "__f";
        r7 = r4.getColumnIndex(r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0183, Throwable -> 0x0179, all -> 0x016d }
        r7 = r4.getString(r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0183, Throwable -> 0x0179, all -> 0x016d }
        r8 = "__e";
        r8 = r4.getColumnIndex(r8);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0183, Throwable -> 0x0179, all -> 0x016d }
        r8 = r4.getString(r8);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0183, Throwable -> 0x0179, all -> 0x016d }
        r9 = "__ii";
        r9 = r4.getColumnIndex(r9);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0183, Throwable -> 0x0179, all -> 0x016d }
        r9 = r4.getString(r9);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0183, Throwable -> 0x0179, all -> 0x016d }
        r2 = android.text.TextUtils.isEmpty(r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0168, Throwable -> 0x0162, all -> 0x016d }
        if (r2 != 0) goto L_0x0157;
    L_0x004c:
        r2 = android.text.TextUtils.isEmpty(r8);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0168, Throwable -> 0x0162, all -> 0x016d }
        if (r2 != 0) goto L_0x0157;
    L_0x0052:
        r10 = java.lang.Long.parseLong(r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0168, Throwable -> 0x0162, all -> 0x016d }
        r12 = java.lang.Long.parseLong(r8);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0168, Throwable -> 0x0162, all -> 0x016d }
        r14 = r10 - r12;
        r10 = 0;
        r2 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1));
        if (r2 <= 0) goto L_0x014f;
    L_0x0062:
        r2 = "__a";
        r2 = r4.getColumnIndex(r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0168, Throwable -> 0x0162, all -> 0x016d }
        r2 = r4.getString(r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0168, Throwable -> 0x0162, all -> 0x016d }
        r10 = "__b";
        r10 = r4.getColumnIndex(r10);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0168, Throwable -> 0x0162, all -> 0x016d }
        r10 = r4.getString(r10);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0168, Throwable -> 0x0162, all -> 0x016d }
        r11 = "__c";
        r11 = r4.getColumnIndex(r11);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0168, Throwable -> 0x0162, all -> 0x016d }
        r11 = r4.getString(r11);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0168, Throwable -> 0x0162, all -> 0x016d }
        r12 = "__d";
        r12 = r4.getColumnIndex(r12);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0168, Throwable -> 0x0162, all -> 0x016d }
        r12 = r4.getString(r12);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0168, Throwable -> 0x0162, all -> 0x016d }
        r13 = r1.O0000Oo0;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0168, Throwable -> 0x0162, all -> 0x016d }
        r13.add(r9);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0168, Throwable -> 0x0162, all -> 0x016d }
        r13 = "__sp";
        r13 = r4.getColumnIndex(r13);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0168, Throwable -> 0x0162, all -> 0x016d }
        r13 = r4.getString(r13);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0168, Throwable -> 0x0162, all -> 0x016d }
        r14 = "__pp";
        r14 = r4.getColumnIndex(r14);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0168, Throwable -> 0x0162, all -> 0x016d }
        r14 = r4.getString(r14);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0168, Throwable -> 0x0162, all -> 0x016d }
        r15 = "id";
        r6.put(r15, r9);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0168, Throwable -> 0x0162, all -> 0x016d }
        r15 = "start_time";
        r6.put(r15, r8);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0168, Throwable -> 0x0162, all -> 0x016d }
        r15 = "end_time";
        r6.put(r15, r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0168, Throwable -> 0x0162, all -> 0x016d }
        r15 = "duration";
        r16 = java.lang.Long.parseLong(r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0168, Throwable -> 0x0162, all -> 0x016d }
        r7 = java.lang.Long.parseLong(r8);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0168, Throwable -> 0x0162, all -> 0x016d }
        r18 = r3;
        r19 = r4;
        r3 = r16 - r7;
        r6.put(r15, r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
        r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
        if (r3 != 0) goto L_0x00d9;
    L_0x00cb:
        r3 = new org.json.JSONArray;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
        r2 = r1.O00000o(r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
        r3.<init>(r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
        r2 = "pages";
        r6.put(r2, r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
    L_0x00d9:
        r2 = android.text.TextUtils.isEmpty(r10);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
        if (r2 != 0) goto L_0x00f3;
    L_0x00df:
        r2 = defpackage.u.O00000oO;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
        r3 = x.O00000Oo.O000000o;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
        if (r2 != r3) goto L_0x00f3;
    L_0x00e5:
        r2 = new org.json.JSONArray;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
        r3 = r1.O00000o(r10);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
        r2.<init>(r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
        r3 = "autopages";
        r6.put(r3, r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
    L_0x00f3:
        r2 = android.text.TextUtils.isEmpty(r11);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
        if (r2 != 0) goto L_0x0107;
    L_0x00f9:
        r2 = "traffic";
        r3 = new org.json.JSONObject;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
        r4 = r1.O00000o(r11);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
        r3.<init>(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
        r6.put(r2, r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
    L_0x0107:
        r2 = android.text.TextUtils.isEmpty(r12);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
        if (r2 != 0) goto L_0x011b;
    L_0x010d:
        r2 = "locations";
        r3 = new org.json.JSONArray;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
        r4 = r1.O00000o(r12);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
        r3.<init>(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
        r6.put(r2, r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
    L_0x011b:
        r2 = android.text.TextUtils.isEmpty(r13);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
        if (r2 != 0) goto L_0x012f;
    L_0x0121:
        r2 = "_$sp";
        r3 = new org.json.JSONObject;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
        r4 = r1.O00000o(r13);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
        r3.<init>(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
        r6.put(r2, r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
    L_0x012f:
        r2 = android.text.TextUtils.isEmpty(r14);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
        if (r2 != 0) goto L_0x0143;
    L_0x0135:
        r2 = "_$pp";
        r3 = new org.json.JSONObject;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
        r4 = r1.O00000o(r14);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
        r3.<init>(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
        r6.put(r2, r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
    L_0x0143:
        r2 = r6.length();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
        if (r2 <= 0) goto L_0x0153;
    L_0x0149:
        r5.put(r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0188, Throwable -> 0x0166, all -> 0x014d }
        goto L_0x0153;
    L_0x014d:
        r0 = move-exception;
        goto L_0x0172;
    L_0x014f:
        r18 = r3;
        r19 = r4;
    L_0x0153:
        if (r23 == 0) goto L_0x015b;
    L_0x0155:
        r2 = r9;
        goto L_0x0192;
    L_0x0157:
        r18 = r3;
        r19 = r4;
    L_0x015b:
        r2 = r9;
        r3 = r18;
        r4 = r19;
        goto L_0x001d;
    L_0x0162:
        r18 = r3;
        r19 = r4;
    L_0x0166:
        r2 = r9;
        goto L_0x017d;
    L_0x0168:
        r18 = r3;
        r19 = r4;
        goto L_0x0188;
    L_0x016d:
        r0 = move-exception;
        r18 = r3;
        r19 = r4;
    L_0x0172:
        r2 = r0;
        r4 = r18;
        r3 = r19;
        goto L_0x023a;
    L_0x0179:
        r18 = r3;
        r19 = r4;
    L_0x017d:
        r4 = r18;
        r3 = r19;
        goto L_0x0207;
    L_0x0183:
        r18 = r3;
        r19 = r4;
        r9 = r2;
    L_0x0188:
        r4 = r18;
        r2 = r19;
        goto L_0x021d;
    L_0x018e:
        r18 = r3;
        r19 = r4;
    L_0x0192:
        r3 = r1.O0000Oo0;	 Catch:{ SQLiteDatabaseCorruptException -> 0x01cb, Throwable -> 0x017d, all -> 0x01c5 }
        r3 = r3.size();	 Catch:{ SQLiteDatabaseCorruptException -> 0x01cb, Throwable -> 0x017d, all -> 0x01c5 }
        r4 = 1;
        if (r3 >= r4) goto L_0x01b3;
    L_0x019b:
        if (r19 == 0) goto L_0x01a2;
    L_0x019d:
        r3 = r19;
        r3.close();
    L_0x01a2:
        if (r18 == 0) goto L_0x01a9;
    L_0x01a4:
        r4 = r18;
        r4.endTransaction();	 Catch:{ Throwable -> 0x01a9 }
    L_0x01a9:
        r3 = O00000o;
        r3 = defpackage.ak.O000000o(r3);
        r3.O00000Oo();
        return r2;
    L_0x01b3:
        r4 = r18;
        r3 = r19;
        r6 = r5.length();	 Catch:{ SQLiteDatabaseCorruptException -> 0x01e2, Throwable -> 0x0207, all -> 0x01f5 }
        if (r6 <= 0) goto L_0x01ea;
    L_0x01bd:
        r6 = "sessions";
        r7 = r22;
        r7.put(r6, r5);	 Catch:{ SQLiteDatabaseCorruptException -> 0x01e2, Throwable -> 0x0207, all -> 0x01f5 }
        goto L_0x01ea;
    L_0x01c5:
        r0 = move-exception;
        r4 = r18;
        r3 = r19;
        goto L_0x0203;
    L_0x01cb:
        r4 = r18;
        r3 = r19;
        goto L_0x01e2;
    L_0x01d0:
        r0 = move-exception;
        r20 = r4;
        r4 = r3;
        r3 = r20;
        goto L_0x0203;
    L_0x01d7:
        r20 = r4;
        r4 = r3;
        r3 = r20;
        goto L_0x0207;
    L_0x01dd:
        r20 = r4;
        r4 = r3;
        r3 = r20;
    L_0x01e2:
        r9 = r2;
        r2 = r3;
        goto L_0x021d;
    L_0x01e5:
        r20 = r4;
        r4 = r3;
        r3 = r20;
    L_0x01ea:
        r4.setTransactionSuccessful();	 Catch:{ SQLiteDatabaseCorruptException -> 0x01e2, Throwable -> 0x0207, all -> 0x01f5 }
        if (r3 == 0) goto L_0x01f2;
    L_0x01ef:
        r3.close();
    L_0x01f2:
        if (r4 == 0) goto L_0x0211;
    L_0x01f4:
        goto L_0x020e;
    L_0x01f5:
        r0 = move-exception;
        goto L_0x0203;
    L_0x01f7:
        r0 = move-exception;
        r4 = r3;
        goto L_0x0238;
    L_0x01fa:
        r4 = r3;
        r3 = r2;
        goto L_0x0207;
    L_0x01fd:
        r4 = r3;
        r9 = r2;
        goto L_0x021d;
    L_0x0200:
        r0 = move-exception;
        r3 = r2;
        r4 = r3;
    L_0x0203:
        r2 = r0;
        goto L_0x023a;
    L_0x0205:
        r3 = r2;
        r4 = r3;
    L_0x0207:
        if (r3 == 0) goto L_0x020c;
    L_0x0209:
        r3.close();
    L_0x020c:
        if (r4 == 0) goto L_0x0211;
    L_0x020e:
        r4.endTransaction();	 Catch:{ Throwable -> 0x0211 }
    L_0x0211:
        r3 = O00000o;
        r3 = defpackage.ak.O000000o(r3);
        r3.O00000Oo();
        goto L_0x0236;
    L_0x021b:
        r4 = r2;
        r9 = r4;
    L_0x021d:
        r3 = O00000o;	 Catch:{ all -> 0x0237 }
        defpackage.al.O000000o(r3);	 Catch:{ all -> 0x0237 }
        if (r2 == 0) goto L_0x0227;
    L_0x0224:
        r2.close();
    L_0x0227:
        if (r4 == 0) goto L_0x022c;
    L_0x0229:
        r4.endTransaction();	 Catch:{ Throwable -> 0x022c }
    L_0x022c:
        r2 = O00000o;
        r2 = defpackage.ak.O000000o(r2);
        r2.O00000Oo();
        r2 = r9;
    L_0x0236:
        return r2;
    L_0x0237:
        r0 = move-exception;
    L_0x0238:
        r3 = r2;
        goto L_0x0203;
    L_0x023a:
        if (r3 == 0) goto L_0x023f;
    L_0x023c:
        r3.close();
    L_0x023f:
        if (r4 == 0) goto L_0x0244;
    L_0x0241:
        r4.endTransaction();	 Catch:{ Throwable -> 0x0244 }
    L_0x0244:
        r3 = O00000o;
        r3 = defpackage.ak.O000000o(r3);
        r3.O00000Oo();
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.am.O000000o(org.json.JSONObject, boolean):java.lang.String");
    }

    private void O000000o(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long longValue = ((Long) jSONObject.opt(O000000o.O0000O0o)).longValue();
            JSONObject optJSONObject = jSONObject.optJSONObject("__sp");
            jSONObject = jSONObject.optJSONObject("__pp");
            String str2 = "";
            String str3 = "";
            if (optJSONObject != null && optJSONObject.length() > 0) {
                str2 = O00000o0(optJSONObject.toString());
            }
            if (jSONObject != null && jSONObject.length() > 0) {
                str3 = O00000o0(jSONObject.toString());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("update __sd set __f=\"");
            stringBuilder.append(longValue);
            stringBuilder.append("\", ");
            stringBuilder.append("__sp");
            stringBuilder.append("=\"");
            stringBuilder.append(str2);
            stringBuilder.append("\", ");
            stringBuilder.append("__pp");
            stringBuilder.append("=\"");
            stringBuilder.append(str3);
            stringBuilder.append("\" where ");
            stringBuilder.append("__ii");
            stringBuilder.append("=\"");
            stringBuilder.append(str);
            stringBuilder.append("\"");
            sQLiteDatabase.execSQL(stringBuilder.toString());
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00f7  */
    /* JADX WARNING: Missing block: B:48:0x00f0, code skipped:
            if (r1 != null) goto L_0x00fe;
     */
    /* JADX WARNING: Missing block: B:56:0x00fc, code skipped:
            if (r1 != null) goto L_0x00fe;
     */
    /* JADX WARNING: Missing block: B:58:0x00fe, code skipped:
            r1.close();
     */
    /* JADX WARNING: Missing block: B:59:0x0101, code skipped:
            return;
     */
    private void O000000o(java.lang.String r5, org.json.JSONObject r6, android.database.sqlite.SQLiteDatabase r7, java.lang.String r8) throws org.json.JSONException {
        /*
        r4 = this;
        r0 = 0;
        r1 = "__a";
        r1 = r1.equals(r8);	 Catch:{ Throwable -> 0x00fb, all -> 0x00f3 }
        if (r1 == 0) goto L_0x0018;
    L_0x0009:
        r1 = "__a";
        r6 = r6.optJSONArray(r1);	 Catch:{ Throwable -> 0x00fb, all -> 0x00f3 }
        if (r6 == 0) goto L_0x0017;
    L_0x0011:
        r1 = r6.length();	 Catch:{ Throwable -> 0x00fb, all -> 0x00f3 }
        if (r1 > 0) goto L_0x0030;
    L_0x0017:
        return;
    L_0x0018:
        r1 = "__b";
        r1 = r1.equals(r8);	 Catch:{ Throwable -> 0x00fb, all -> 0x00f3 }
        if (r1 == 0) goto L_0x002f;
    L_0x0020:
        r1 = "__b";
        r6 = r6.optJSONArray(r1);	 Catch:{ Throwable -> 0x00fb, all -> 0x00f3 }
        if (r6 == 0) goto L_0x002e;
    L_0x0028:
        r1 = r6.length();	 Catch:{ Throwable -> 0x00fb, all -> 0x00f3 }
        if (r1 > 0) goto L_0x0030;
    L_0x002e:
        return;
    L_0x002f:
        r6 = r0;
    L_0x0030:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00fb, all -> 0x00f3 }
        r1.<init>();	 Catch:{ Throwable -> 0x00fb, all -> 0x00f3 }
        r2 = "select ";
        r1.append(r2);	 Catch:{ Throwable -> 0x00fb, all -> 0x00f3 }
        r1.append(r8);	 Catch:{ Throwable -> 0x00fb, all -> 0x00f3 }
        r2 = " from ";
        r1.append(r2);	 Catch:{ Throwable -> 0x00fb, all -> 0x00f3 }
        r2 = "__sd";
        r1.append(r2);	 Catch:{ Throwable -> 0x00fb, all -> 0x00f3 }
        r2 = " where ";
        r1.append(r2);	 Catch:{ Throwable -> 0x00fb, all -> 0x00f3 }
        r2 = "__ii";
        r1.append(r2);	 Catch:{ Throwable -> 0x00fb, all -> 0x00f3 }
        r2 = "=\"";
        r1.append(r2);	 Catch:{ Throwable -> 0x00fb, all -> 0x00f3 }
        r1.append(r5);	 Catch:{ Throwable -> 0x00fb, all -> 0x00f3 }
        r2 = "\"";
        r1.append(r2);	 Catch:{ Throwable -> 0x00fb, all -> 0x00f3 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x00fb, all -> 0x00f3 }
        r1 = r7.rawQuery(r1, r0);	 Catch:{ Throwable -> 0x00fb, all -> 0x00f3 }
        if (r1 == 0) goto L_0x007e;
    L_0x0068:
        r2 = r1.moveToNext();	 Catch:{ Throwable -> 0x00fc, all -> 0x007b }
        if (r2 == 0) goto L_0x007e;
    L_0x006e:
        r0 = r1.getColumnIndex(r8);	 Catch:{ Throwable -> 0x00fc, all -> 0x007b }
        r0 = r1.getString(r0);	 Catch:{ Throwable -> 0x00fc, all -> 0x007b }
        r0 = r4.O00000o(r0);	 Catch:{ Throwable -> 0x00fc, all -> 0x007b }
        goto L_0x0068;
    L_0x007b:
        r5 = move-exception;
        goto L_0x00f5;
    L_0x007e:
        r2 = new org.json.JSONArray;	 Catch:{ Throwable -> 0x00fc, all -> 0x007b }
        r2.<init>();	 Catch:{ Throwable -> 0x00fc, all -> 0x007b }
        r3 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x00fc, all -> 0x007b }
        if (r3 != 0) goto L_0x008e;
    L_0x0089:
        r2 = new org.json.JSONArray;	 Catch:{ Throwable -> 0x00fc, all -> 0x007b }
        r2.<init>(r0);	 Catch:{ Throwable -> 0x00fc, all -> 0x007b }
    L_0x008e:
        r0 = r2.length();	 Catch:{ Throwable -> 0x00fc, all -> 0x007b }
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        if (r0 <= r3) goto L_0x009c;
    L_0x0096:
        if (r1 == 0) goto L_0x009b;
    L_0x0098:
        r1.close();
    L_0x009b:
        return;
    L_0x009c:
        r0 = 0;
    L_0x009d:
        r3 = r6.length();	 Catch:{ Throwable -> 0x00fc, all -> 0x007b }
        if (r0 >= r3) goto L_0x00af;
    L_0x00a3:
        r3 = r6.getJSONObject(r0);	 Catch:{ JSONException -> 0x00ac }
        if (r3 == 0) goto L_0x00ac;
    L_0x00a9:
        r2.put(r3);	 Catch:{ Throwable -> 0x00fc, all -> 0x007b }
    L_0x00ac:
        r0 = r0 + 1;
        goto L_0x009d;
    L_0x00af:
        r6 = r2.toString();	 Catch:{ Throwable -> 0x00fc, all -> 0x007b }
        r6 = r4.O00000o0(r6);	 Catch:{ Throwable -> 0x00fc, all -> 0x007b }
        r0 = android.text.TextUtils.isEmpty(r6);	 Catch:{ Throwable -> 0x00fc, all -> 0x007b }
        if (r0 != 0) goto L_0x00f0;
    L_0x00bd:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00fc, all -> 0x007b }
        r0.<init>();	 Catch:{ Throwable -> 0x00fc, all -> 0x007b }
        r2 = "update __sd set ";
        r0.append(r2);	 Catch:{ Throwable -> 0x00fc, all -> 0x007b }
        r0.append(r8);	 Catch:{ Throwable -> 0x00fc, all -> 0x007b }
        r8 = "=\"";
        r0.append(r8);	 Catch:{ Throwable -> 0x00fc, all -> 0x007b }
        r0.append(r6);	 Catch:{ Throwable -> 0x00fc, all -> 0x007b }
        r6 = "\" where ";
        r0.append(r6);	 Catch:{ Throwable -> 0x00fc, all -> 0x007b }
        r6 = "__ii";
        r0.append(r6);	 Catch:{ Throwable -> 0x00fc, all -> 0x007b }
        r6 = "=\"";
        r0.append(r6);	 Catch:{ Throwable -> 0x00fc, all -> 0x007b }
        r0.append(r5);	 Catch:{ Throwable -> 0x00fc, all -> 0x007b }
        r5 = "\"";
        r0.append(r5);	 Catch:{ Throwable -> 0x00fc, all -> 0x007b }
        r5 = r0.toString();	 Catch:{ Throwable -> 0x00fc, all -> 0x007b }
        r7.execSQL(r5);	 Catch:{ Throwable -> 0x00fc, all -> 0x007b }
    L_0x00f0:
        if (r1 == 0) goto L_0x0101;
    L_0x00f2:
        goto L_0x00fe;
    L_0x00f3:
        r5 = move-exception;
        r1 = r0;
    L_0x00f5:
        if (r1 == 0) goto L_0x00fa;
    L_0x00f7:
        r1.close();
    L_0x00fa:
        throw r5;
    L_0x00fb:
        r1 = r0;
    L_0x00fc:
        if (r1 == 0) goto L_0x0101;
    L_0x00fe:
        r1.close();
    L_0x0101:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.am.O000000o(java.lang.String, org.json.JSONObject, android.database.sqlite.SQLiteDatabase, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:92:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01a2 A:{SYNTHETIC, Splitter:B:94:0x01a2} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:83:0x018b */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01a2 A:{SYNTHETIC, Splitter:B:94:0x01a2} */
    /* JADX WARNING: Missing block: B:66:0x016b, code skipped:
            if (r1 != null) goto L_0x017d;
     */
    /* JADX WARNING: Missing block: B:76:0x017b, code skipped:
            if (r1 != null) goto L_0x017d;
     */
    /* JADX WARNING: Missing block: B:78:?, code skipped:
            r1.endTransaction();
     */
    /* JADX WARNING: Missing block: B:87:0x0195, code skipped:
            if (r1 == null) goto L_0x0180;
     */
    private void O000000o(org.json.JSONObject r10, java.lang.String r11) {
        /*
        r9 = this;
        r0 = 0;
        r1 = O00000o;	 Catch:{ SQLiteDatabaseCorruptException -> 0x018a, Throwable -> 0x0174, all -> 0x0170 }
        r1 = defpackage.ak.O000000o(r1);	 Catch:{ SQLiteDatabaseCorruptException -> 0x018a, Throwable -> 0x0174, all -> 0x0170 }
        r1 = r1.O000000o();	 Catch:{ SQLiteDatabaseCorruptException -> 0x018a, Throwable -> 0x0174, all -> 0x0170 }
        r1.beginTransaction();	 Catch:{ SQLiteDatabaseCorruptException -> 0x018b, Throwable -> 0x016e }
        r2 = "select *  from __et";
        r3 = android.text.TextUtils.isEmpty(r11);	 Catch:{ SQLiteDatabaseCorruptException -> 0x018b, Throwable -> 0x016e }
        if (r3 != 0) goto L_0x002c;
    L_0x0016:
        r2 = new java.lang.StringBuilder;	 Catch:{ SQLiteDatabaseCorruptException -> 0x018b, Throwable -> 0x016e }
        r2.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x018b, Throwable -> 0x016e }
        r3 = "select *  from __et where __i=\"";
        r2.append(r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x018b, Throwable -> 0x016e }
        r2.append(r11);	 Catch:{ SQLiteDatabaseCorruptException -> 0x018b, Throwable -> 0x016e }
        r11 = "\"";
        r2.append(r11);	 Catch:{ SQLiteDatabaseCorruptException -> 0x018b, Throwable -> 0x016e }
        r2 = r2.toString();	 Catch:{ SQLiteDatabaseCorruptException -> 0x018b, Throwable -> 0x016e }
    L_0x002c:
        r11 = r1.rawQuery(r2, r0);	 Catch:{ SQLiteDatabaseCorruptException -> 0x018b, Throwable -> 0x016e }
        if (r11 == 0) goto L_0x0163;
    L_0x0032:
        r0 = new org.json.JSONObject;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r0.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r2 = new org.json.JSONObject;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r2.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r3 = defpackage.aw.O000000o();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r3 = r3.O00000Oo();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
    L_0x0044:
        r4 = r11.moveToNext();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        if (r4 == 0) goto L_0x00dc;
    L_0x004a:
        r4 = "__t";
        r4 = r11.getColumnIndex(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r4 = r11.getInt(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r5 = "__i";
        r5 = r11.getColumnIndex(r5);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r5 = r11.getString(r5);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r6 = "__s";
        r6 = r11.getColumnIndex(r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r6 = r11.getString(r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r7 = android.text.TextUtils.isEmpty(r5);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        if (r7 != 0) goto L_0x0076;
    L_0x006e:
        r7 = "-1";
        r7 = r7.equals(r5);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        if (r7 == 0) goto L_0x007d;
    L_0x0076:
        r5 = android.text.TextUtils.isEmpty(r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        if (r5 != 0) goto L_0x0044;
    L_0x007c:
        r5 = r3;
    L_0x007d:
        r7 = 0;
        r7 = r11.getInt(r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r8 = r9.O0000Oo;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r8.add(r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        switch(r4) {
            case 2049: goto L_0x00b5;
            case 2050: goto L_0x008f;
            default: goto L_0x008e;
        };	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
    L_0x008e:
        goto L_0x0044;
    L_0x008f:
        r4 = android.text.TextUtils.isEmpty(r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        if (r4 != 0) goto L_0x0044;
    L_0x0095:
        r4 = new org.json.JSONObject;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r6 = r9.O00000o(r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r4.<init>(r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r6 = r2.has(r5);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        if (r6 == 0) goto L_0x00a9;
    L_0x00a4:
        r6 = r2.optJSONArray(r5);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        goto L_0x00ae;
    L_0x00a9:
        r6 = new org.json.JSONArray;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r6.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
    L_0x00ae:
        r6.put(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r2.put(r5, r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        goto L_0x0044;
    L_0x00b5:
        r4 = android.text.TextUtils.isEmpty(r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        if (r4 != 0) goto L_0x0044;
    L_0x00bb:
        r4 = new org.json.JSONObject;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r6 = r9.O00000o(r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r4.<init>(r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r6 = r0.has(r5);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        if (r6 == 0) goto L_0x00cf;
    L_0x00ca:
        r6 = r0.optJSONArray(r5);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        goto L_0x00d4;
    L_0x00cf:
        r6 = new org.json.JSONArray;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r6.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
    L_0x00d4:
        r6.put(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r0.put(r5, r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        goto L_0x0044;
    L_0x00dc:
        r3 = r0.length();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        if (r3 <= 0) goto L_0x011d;
    L_0x00e2:
        r3 = new org.json.JSONArray;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r3.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r4 = r0.keys();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
    L_0x00eb:
        r5 = r4.hasNext();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        if (r5 == 0) goto L_0x0112;
    L_0x00f1:
        r5 = new org.json.JSONObject;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r5.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r6 = r4.next();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r6 = (java.lang.String) r6;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r7 = r0.optString(r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r8 = new org.json.JSONArray;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r8.<init>(r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r5.put(r6, r8);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r6 = r5.length();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        if (r6 <= 0) goto L_0x00eb;
    L_0x010e:
        r3.put(r5);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        goto L_0x00eb;
    L_0x0112:
        r0 = r3.length();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        if (r0 <= 0) goto L_0x011d;
    L_0x0118:
        r0 = "ekv";
        r10.put(r0, r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
    L_0x011d:
        r0 = r2.length();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        if (r0 <= 0) goto L_0x0163;
    L_0x0123:
        r0 = new org.json.JSONArray;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r0.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r3 = r2.keys();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
    L_0x012c:
        r4 = r3.hasNext();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        if (r4 == 0) goto L_0x0153;
    L_0x0132:
        r4 = new org.json.JSONObject;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r4.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r5 = r3.next();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r5 = (java.lang.String) r5;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r6 = r2.optString(r5);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r7 = new org.json.JSONArray;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r7.<init>(r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r4.put(r5, r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        r5 = r4.length();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        if (r5 <= 0) goto L_0x012c;
    L_0x014f:
        r0.put(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        goto L_0x012c;
    L_0x0153:
        r2 = r0.length();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        if (r2 <= 0) goto L_0x0163;
    L_0x0159:
        r2 = "gkv";
        r10.put(r2, r0);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        goto L_0x0163;
    L_0x015f:
        r10 = move-exception;
        goto L_0x019b;
    L_0x0161:
        r0 = r11;
        goto L_0x018b;
    L_0x0163:
        r1.setTransactionSuccessful();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0161, Throwable -> 0x0176, all -> 0x015f }
        if (r11 == 0) goto L_0x016b;
    L_0x0168:
        r11.close();
    L_0x016b:
        if (r1 == 0) goto L_0x0180;
    L_0x016d:
        goto L_0x017d;
    L_0x016e:
        r11 = r0;
        goto L_0x0176;
    L_0x0170:
        r10 = move-exception;
        r11 = r0;
        r1 = r11;
        goto L_0x019b;
    L_0x0174:
        r11 = r0;
        r1 = r11;
    L_0x0176:
        if (r11 == 0) goto L_0x017b;
    L_0x0178:
        r11.close();
    L_0x017b:
        if (r1 == 0) goto L_0x0180;
    L_0x017d:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0180 }
    L_0x0180:
        r10 = O00000o;
        r10 = defpackage.ak.O000000o(r10);
        r10.O00000Oo();
        goto L_0x0198;
    L_0x018a:
        r1 = r0;
    L_0x018b:
        r10 = O00000o;	 Catch:{ all -> 0x0199 }
        defpackage.al.O000000o(r10);	 Catch:{ all -> 0x0199 }
        if (r0 == 0) goto L_0x0195;
    L_0x0192:
        r0.close();
    L_0x0195:
        if (r1 == 0) goto L_0x0180;
    L_0x0197:
        goto L_0x017d;
    L_0x0198:
        return;
    L_0x0199:
        r10 = move-exception;
        r11 = r0;
    L_0x019b:
        if (r11 == 0) goto L_0x01a0;
    L_0x019d:
        r11.close();
    L_0x01a0:
        if (r1 == 0) goto L_0x01a5;
    L_0x01a2:
        r1.endTransaction();	 Catch:{ Throwable -> 0x01a5 }
    L_0x01a5:
        r11 = O00000o;
        r11 = defpackage.ak.O000000o(r11);
        r11.O00000Oo();
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.am.O000000o(org.json.JSONObject, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:72:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00fb A:{SYNTHETIC, Splitter:B:74:0x00fb} */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00e4 A:{SYNTHETIC, Splitter:B:65:0x00e4} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00fb A:{SYNTHETIC, Splitter:B:74:0x00fb} */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00e4 A:{SYNTHETIC, Splitter:B:65:0x00e4} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00e4 A:{SYNTHETIC, Splitter:B:65:0x00e4} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a8 A:{Splitter:B:6:0x0016, ExcHandler: all (th java.lang.Throwable), Catch:{ SQLiteDatabaseCorruptException -> 0x00aa, Throwable -> 0x00c2, all -> 0x00a8 }} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:26:0x009a, code skipped:
            r0 = r6;
     */
    /* JADX WARNING: Missing block: B:32:0x00a8, code skipped:
            r11 = th;
     */
    /* JADX WARNING: Missing block: B:41:0x00b5, code skipped:
            if (r1 != null) goto L_0x00c9;
     */
    /* JADX WARNING: Missing block: B:52:0x00c4, code skipped:
            r2.close();
     */
    /* JADX WARNING: Missing block: B:53:0x00c7, code skipped:
            if (r1 == null) goto L_0x00cc;
     */
    /* JADX WARNING: Missing block: B:55:?, code skipped:
            r1.endTransaction();
     */
    /* JADX WARNING: Missing block: B:63:0x00df, code skipped:
            r0.close();
     */
    /* JADX WARNING: Missing block: B:66:?, code skipped:
            r1.endTransaction();
     */
    /* JADX WARNING: Missing block: B:72:0x00f6, code skipped:
            r2.close();
     */
    /* JADX WARNING: Missing block: B:75:?, code skipped:
            r1.endTransaction();
     */
    private java.lang.String O00000Oo(org.json.JSONObject r11, boolean r12) {
        /*
        r10 = this;
        r0 = 0;
        r1 = O00000o;	 Catch:{ SQLiteDatabaseCorruptException -> 0x00d6, Throwable -> 0x00c0, all -> 0x00bc }
        r1 = defpackage.ak.O000000o(r1);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00d6, Throwable -> 0x00c0, all -> 0x00bc }
        r1 = r1.O000000o();	 Catch:{ SQLiteDatabaseCorruptException -> 0x00d6, Throwable -> 0x00c0, all -> 0x00bc }
        r1.beginTransaction();	 Catch:{ SQLiteDatabaseCorruptException -> 0x00ba, Throwable -> 0x00b8 }
        r2 = "select *  from __is";
        r2 = r1.rawQuery(r2, r0);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00ba, Throwable -> 0x00b8 }
        if (r2 == 0) goto L_0x00ad;
    L_0x0016:
        r3 = new org.json.JSONArray;	 Catch:{ SQLiteDatabaseCorruptException -> 0x00aa, Throwable -> 0x00c2, all -> 0x00a8 }
        r3.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x00aa, Throwable -> 0x00c2, all -> 0x00a8 }
    L_0x001b:
        r4 = r2.moveToNext();	 Catch:{ SQLiteDatabaseCorruptException -> 0x00aa, Throwable -> 0x00c2, all -> 0x00a8 }
        if (r4 == 0) goto L_0x009c;
    L_0x0021:
        r4 = new org.json.JSONObject;	 Catch:{ SQLiteDatabaseCorruptException -> 0x00aa, Throwable -> 0x00c2, all -> 0x00a8 }
        r4.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x00aa, Throwable -> 0x00c2, all -> 0x00a8 }
        r5 = "__e";
        r5 = r2.getColumnIndex(r5);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00aa, Throwable -> 0x00c2, all -> 0x00a8 }
        r5 = r2.getString(r5);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00aa, Throwable -> 0x00c2, all -> 0x00a8 }
        r6 = "__ii";
        r6 = r2.getColumnIndex(r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00aa, Throwable -> 0x00c2, all -> 0x00a8 }
        r6 = r2.getString(r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00aa, Throwable -> 0x00c2, all -> 0x00a8 }
        r0 = r10.O0000Ooo;	 Catch:{ SQLiteDatabaseCorruptException -> 0x00ab, Throwable -> 0x009a, all -> 0x00a8 }
        r0.add(r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00ab, Throwable -> 0x009a, all -> 0x00a8 }
        r0 = "__sp";
        r0 = r2.getColumnIndex(r0);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00ab, Throwable -> 0x009a, all -> 0x00a8 }
        r0 = r2.getString(r0);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00ab, Throwable -> 0x009a, all -> 0x00a8 }
        r7 = "__pp";
        r7 = r2.getColumnIndex(r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00ab, Throwable -> 0x009a, all -> 0x00a8 }
        r7 = r2.getString(r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00ab, Throwable -> 0x009a, all -> 0x00a8 }
        r8 = android.text.TextUtils.isEmpty(r0);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00ab, Throwable -> 0x009a, all -> 0x00a8 }
        if (r8 != 0) goto L_0x0067;
    L_0x0059:
        r8 = "_$sp";
        r9 = new org.json.JSONObject;	 Catch:{ SQLiteDatabaseCorruptException -> 0x00ab, Throwable -> 0x009a, all -> 0x00a8 }
        r0 = r10.O00000o(r0);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00ab, Throwable -> 0x009a, all -> 0x00a8 }
        r9.<init>(r0);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00ab, Throwable -> 0x009a, all -> 0x00a8 }
        r4.put(r8, r9);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00ab, Throwable -> 0x009a, all -> 0x00a8 }
    L_0x0067:
        r0 = android.text.TextUtils.isEmpty(r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00ab, Throwable -> 0x009a, all -> 0x00a8 }
        if (r0 != 0) goto L_0x007b;
    L_0x006d:
        r0 = "_$pp";
        r8 = new org.json.JSONObject;	 Catch:{ SQLiteDatabaseCorruptException -> 0x00ab, Throwable -> 0x009a, all -> 0x00a8 }
        r7 = r10.O00000o(r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00ab, Throwable -> 0x009a, all -> 0x00a8 }
        r8.<init>(r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00ab, Throwable -> 0x009a, all -> 0x00a8 }
        r4.put(r0, r8);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00ab, Throwable -> 0x009a, all -> 0x00a8 }
    L_0x007b:
        r0 = android.text.TextUtils.isEmpty(r5);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00ab, Throwable -> 0x009a, all -> 0x00a8 }
        if (r0 != 0) goto L_0x0098;
    L_0x0081:
        r0 = "id";
        r4.put(r0, r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00ab, Throwable -> 0x009a, all -> 0x00a8 }
        r0 = "start_time";
        r4.put(r0, r5);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00ab, Throwable -> 0x009a, all -> 0x00a8 }
        r0 = r4.length();	 Catch:{ SQLiteDatabaseCorruptException -> 0x00ab, Throwable -> 0x009a, all -> 0x00a8 }
        if (r0 <= 0) goto L_0x0094;
    L_0x0091:
        r3.put(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00ab, Throwable -> 0x009a, all -> 0x00a8 }
    L_0x0094:
        if (r12 == 0) goto L_0x0098;
    L_0x0096:
        r0 = r6;
        goto L_0x009c;
    L_0x0098:
        r0 = r6;
        goto L_0x001b;
    L_0x009a:
        r0 = r6;
        goto L_0x00c2;
    L_0x009c:
        r12 = r3.length();	 Catch:{ SQLiteDatabaseCorruptException -> 0x00aa, Throwable -> 0x00c2, all -> 0x00a8 }
        if (r12 <= 0) goto L_0x00ad;
    L_0x00a2:
        r12 = "sessions";
        r11.put(r12, r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00aa, Throwable -> 0x00c2, all -> 0x00a8 }
        goto L_0x00ad;
    L_0x00a8:
        r11 = move-exception;
        goto L_0x00f4;
    L_0x00aa:
        r6 = r0;
    L_0x00ab:
        r0 = r2;
        goto L_0x00d8;
    L_0x00ad:
        r1.setTransactionSuccessful();	 Catch:{ SQLiteDatabaseCorruptException -> 0x00aa, Throwable -> 0x00c2, all -> 0x00a8 }
        if (r2 == 0) goto L_0x00b5;
    L_0x00b2:
        r2.close();
    L_0x00b5:
        if (r1 == 0) goto L_0x00cc;
    L_0x00b7:
        goto L_0x00c9;
    L_0x00b8:
        r2 = r0;
        goto L_0x00c2;
    L_0x00ba:
        r6 = r0;
        goto L_0x00d8;
    L_0x00bc:
        r11 = move-exception;
        r1 = r0;
        r2 = r1;
        goto L_0x00f4;
    L_0x00c0:
        r1 = r0;
        r2 = r1;
    L_0x00c2:
        if (r2 == 0) goto L_0x00c7;
    L_0x00c4:
        r2.close();
    L_0x00c7:
        if (r1 == 0) goto L_0x00cc;
    L_0x00c9:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00cc }
    L_0x00cc:
        r11 = O00000o;
        r11 = defpackage.ak.O000000o(r11);
        r11.O00000Oo();
        goto L_0x00f1;
    L_0x00d6:
        r1 = r0;
        r6 = r1;
    L_0x00d8:
        r11 = O00000o;	 Catch:{ all -> 0x00f2 }
        defpackage.al.O000000o(r11);	 Catch:{ all -> 0x00f2 }
        if (r0 == 0) goto L_0x00e2;
    L_0x00df:
        r0.close();
    L_0x00e2:
        if (r1 == 0) goto L_0x00e7;
    L_0x00e4:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00e7 }
    L_0x00e7:
        r11 = O00000o;
        r11 = defpackage.ak.O000000o(r11);
        r11.O00000Oo();
        r0 = r6;
    L_0x00f1:
        return r0;
    L_0x00f2:
        r11 = move-exception;
        r2 = r0;
    L_0x00f4:
        if (r2 == 0) goto L_0x00f9;
    L_0x00f6:
        r2.close();
    L_0x00f9:
        if (r1 == 0) goto L_0x00fe;
    L_0x00fb:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00fe }
    L_0x00fe:
        r12 = O00000o;
        r12 = defpackage.ak.O000000o(r12);
        r12.O00000Oo();
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.am.O00000Oo(org.json.JSONObject, boolean):java.lang.String");
    }

    private void O00000Oo(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long longValue = ((Long) jSONObject.get("__e")).longValue();
            JSONObject optJSONObject = jSONObject.optJSONObject("__sp");
            jSONObject = jSONObject.optJSONObject("__pp");
            String str2 = "";
            String str3 = "";
            if (optJSONObject != null && optJSONObject.length() > 0) {
                str2 = O00000o0(optJSONObject.toString());
            }
            if (jSONObject != null && jSONObject.length() > 0) {
                str3 = O00000o0(jSONObject.toString());
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("__ii", str);
            contentValues.put("__e", String.valueOf(longValue));
            contentValues.put("__sp", str2);
            contentValues.put("__pp", str3);
            contentValues.put("__av", UMGlobalContext.getInstance().getAppVersion());
            contentValues.put("__vc", UMUtils.getAppVersionCode(O00000o));
            sQLiteDatabase.insert(O00000o0.O000000o, null, contentValues);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0092 */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a8 A:{SYNTHETIC, Splitter:B:53:0x00a8} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a8 A:{SYNTHETIC, Splitter:B:53:0x00a8} */
    /* JADX WARNING: Missing block: B:26:0x0073, code skipped:
            if (r1 != null) goto L_0x0084;
     */
    /* JADX WARNING: Missing block: B:36:0x0082, code skipped:
            if (r1 != null) goto L_0x0084;
     */
    /* JADX WARNING: Missing block: B:38:?, code skipped:
            r1.endTransaction();
     */
    /* JADX WARNING: Missing block: B:47:0x009c, code skipped:
            if (r1 == null) goto L_0x0087;
     */
    private void O00000Oo(org.json.JSONObject r5, java.lang.String r6) {
        /*
        r4 = this;
        r0 = 0;
        r1 = O00000o;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0091, Throwable -> 0x007b, all -> 0x0078 }
        r1 = defpackage.ak.O000000o(r1);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0091, Throwable -> 0x007b, all -> 0x0078 }
        r1 = r1.O000000o();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0091, Throwable -> 0x007b, all -> 0x0078 }
        r1.beginTransaction();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0092, Throwable -> 0x0076 }
        r2 = "select *  from __er";
        r3 = android.text.TextUtils.isEmpty(r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0092, Throwable -> 0x0076 }
        if (r3 != 0) goto L_0x002c;
    L_0x0016:
        r2 = new java.lang.StringBuilder;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0092, Throwable -> 0x0076 }
        r2.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0092, Throwable -> 0x0076 }
        r3 = "select *  from __er where __i=\"";
        r2.append(r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0092, Throwable -> 0x0076 }
        r2.append(r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0092, Throwable -> 0x0076 }
        r6 = "\"";
        r2.append(r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0092, Throwable -> 0x0076 }
        r2 = r2.toString();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0092, Throwable -> 0x0076 }
    L_0x002c:
        r6 = r1.rawQuery(r2, r0);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0092, Throwable -> 0x0076 }
        if (r6 == 0) goto L_0x006b;
    L_0x0032:
        r0 = new org.json.JSONArray;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0069, Throwable -> 0x007d, all -> 0x0066 }
        r0.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0069, Throwable -> 0x007d, all -> 0x0066 }
    L_0x0037:
        r2 = r6.moveToNext();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0069, Throwable -> 0x007d, all -> 0x0066 }
        if (r2 == 0) goto L_0x005a;
    L_0x003d:
        r2 = "__a";
        r2 = r6.getColumnIndex(r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0069, Throwable -> 0x007d, all -> 0x0066 }
        r2 = r6.getString(r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0069, Throwable -> 0x007d, all -> 0x0066 }
        r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0069, Throwable -> 0x007d, all -> 0x0066 }
        if (r3 != 0) goto L_0x0037;
    L_0x004d:
        r3 = new org.json.JSONObject;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0069, Throwable -> 0x007d, all -> 0x0066 }
        r2 = r4.O00000o(r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0069, Throwable -> 0x007d, all -> 0x0066 }
        r3.<init>(r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0069, Throwable -> 0x007d, all -> 0x0066 }
        r0.put(r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0069, Throwable -> 0x007d, all -> 0x0066 }
        goto L_0x0037;
    L_0x005a:
        r2 = r0.length();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0069, Throwable -> 0x007d, all -> 0x0066 }
        if (r2 <= 0) goto L_0x006b;
    L_0x0060:
        r2 = "error";
        r5.put(r2, r0);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0069, Throwable -> 0x007d, all -> 0x0066 }
        goto L_0x006b;
    L_0x0066:
        r5 = move-exception;
        r0 = r6;
        goto L_0x00a1;
    L_0x0069:
        r0 = r6;
        goto L_0x0092;
    L_0x006b:
        r1.setTransactionSuccessful();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0069, Throwable -> 0x007d, all -> 0x0066 }
        if (r6 == 0) goto L_0x0073;
    L_0x0070:
        r6.close();
    L_0x0073:
        if (r1 == 0) goto L_0x0087;
    L_0x0075:
        goto L_0x0084;
    L_0x0076:
        r6 = r0;
        goto L_0x007d;
    L_0x0078:
        r5 = move-exception;
        r1 = r0;
        goto L_0x00a1;
    L_0x007b:
        r6 = r0;
        r1 = r6;
    L_0x007d:
        if (r6 == 0) goto L_0x0082;
    L_0x007f:
        r6.close();
    L_0x0082:
        if (r1 == 0) goto L_0x0087;
    L_0x0084:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0087 }
    L_0x0087:
        r5 = O00000o;
        r5 = defpackage.ak.O000000o(r5);
        r5.O00000Oo();
        goto L_0x009f;
    L_0x0091:
        r1 = r0;
    L_0x0092:
        r5 = O00000o;	 Catch:{ all -> 0x00a0 }
        defpackage.al.O000000o(r5);	 Catch:{ all -> 0x00a0 }
        if (r0 == 0) goto L_0x009c;
    L_0x0099:
        r0.close();
    L_0x009c:
        if (r1 == 0) goto L_0x0087;
    L_0x009e:
        goto L_0x0084;
    L_0x009f:
        return;
    L_0x00a0:
        r5 = move-exception;
    L_0x00a1:
        if (r0 == 0) goto L_0x00a6;
    L_0x00a3:
        r0.close();
    L_0x00a6:
        if (r1 == 0) goto L_0x00ab;
    L_0x00a8:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00ab }
    L_0x00ab:
        r6 = O00000o;
        r6 = defpackage.ak.O000000o(r6);
        r6.O00000Oo();
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.am.O00000Oo(org.json.JSONObject, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x010a  */
    private void O00000o0(java.lang.String r6, org.json.JSONObject r7, android.database.sqlite.SQLiteDatabase r8) {
        /*
        r5 = this;
        r0 = 0;
        r1 = "__d";
        r1 = r7.optJSONObject(r1);	 Catch:{ Throwable -> 0x010e, all -> 0x0106 }
        if (r1 == 0) goto L_0x003a;
    L_0x0009:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x010e, all -> 0x0106 }
        r2.<init>();	 Catch:{ Throwable -> 0x010e, all -> 0x0106 }
        r3 = "select __d from __sd where __ii=\"";
        r2.append(r3);	 Catch:{ Throwable -> 0x010e, all -> 0x0106 }
        r2.append(r6);	 Catch:{ Throwable -> 0x010e, all -> 0x0106 }
        r3 = "\"";
        r2.append(r3);	 Catch:{ Throwable -> 0x010e, all -> 0x0106 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x010e, all -> 0x0106 }
        r2 = r8.rawQuery(r2, r0);	 Catch:{ Throwable -> 0x010e, all -> 0x0106 }
        if (r2 == 0) goto L_0x003b;
    L_0x0025:
        r3 = r2.moveToNext();	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        if (r3 == 0) goto L_0x003b;
    L_0x002b:
        r0 = "__d";
        r0 = r2.getColumnIndex(r0);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r0 = r2.getString(r0);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r0 = r5.O00000o(r0);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        goto L_0x0025;
    L_0x003a:
        r2 = r0;
    L_0x003b:
        if (r1 == 0) goto L_0x008d;
    L_0x003d:
        r3 = new org.json.JSONArray;	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r3.<init>();	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r4 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        if (r4 != 0) goto L_0x004d;
    L_0x0048:
        r3 = new org.json.JSONArray;	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r3.<init>(r0);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
    L_0x004d:
        r3.put(r1);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r0 = r3.toString();	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r0 = r5.O00000o0(r0);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        if (r1 != 0) goto L_0x008d;
    L_0x005e:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r1.<init>();	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r3 = "update  __sd set __d=\"";
        r1.append(r3);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r1.append(r0);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r0 = "\" where ";
        r1.append(r0);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r0 = "__ii";
        r1.append(r0);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r0 = "=\"";
        r1.append(r0);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r1.append(r6);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r0 = "\"";
        r1.append(r0);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r0 = r1.toString();	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r8.execSQL(r0);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        goto L_0x008d;
    L_0x008a:
        r6 = move-exception;
        goto L_0x0108;
    L_0x008d:
        r0 = "__c";
        r0 = r7.optJSONObject(r0);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        if (r0 == 0) goto L_0x00ce;
    L_0x0095:
        r0 = r0.toString();	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r0 = r5.O00000o0(r0);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        if (r1 != 0) goto L_0x00ce;
    L_0x00a3:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r1.<init>();	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r3 = "update  __sd set __c=\"";
        r1.append(r3);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r1.append(r0);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r0 = "\" where ";
        r1.append(r0);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r0 = "__ii";
        r1.append(r0);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r0 = "=\"";
        r1.append(r0);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r1.append(r6);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r0 = "\"";
        r1.append(r0);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r0 = r1.toString();	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r8.execSQL(r0);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
    L_0x00ce:
        r0 = "__f";
        r0 = r7.optLong(r0);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r7.<init>();	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r3 = "update  __sd set __f=\"";
        r7.append(r3);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r0 = java.lang.String.valueOf(r0);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r7.append(r0);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r0 = "\" where ";
        r7.append(r0);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r0 = "__ii";
        r7.append(r0);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r0 = "=\"";
        r7.append(r0);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r7.append(r6);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r6 = "\"";
        r7.append(r6);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r6 = r7.toString();	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        r8.execSQL(r6);	 Catch:{ Throwable -> 0x010f, all -> 0x008a }
        if (r2 == 0) goto L_0x0114;
    L_0x0105:
        goto L_0x0111;
    L_0x0106:
        r6 = move-exception;
        r2 = r0;
    L_0x0108:
        if (r2 == 0) goto L_0x010d;
    L_0x010a:
        r2.close();
    L_0x010d:
        throw r6;
    L_0x010e:
        r2 = r0;
    L_0x010f:
        if (r2 == 0) goto L_0x0114;
    L_0x0111:
        r2.close();
    L_0x0114:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.am.O00000o0(java.lang.String, org.json.JSONObject, android.database.sqlite.SQLiteDatabase):void");
    }

    private void O0000OoO() {
        synchronized (this) {
            O0000Ooo();
            this.O0000Oo0.clear();
            this.O0000Ooo.clear();
            this.O0000Oo.clear();
        }
    }

    private void O0000Ooo() {
        try {
            if (TextUtils.isEmpty(O00000oO)) {
                String substring;
                CharSequence multiProcessSP = UMUtils.getMultiProcessSP(O00000o, O0000O0o);
                if (TextUtils.isEmpty(multiProcessSP)) {
                    multiProcessSP = DeviceConfig.getDBencryptID(O00000o);
                    if (!TextUtils.isEmpty(multiProcessSP)) {
                        UMUtils.setMultiProcessSP(O00000o, O0000O0o, multiProcessSP);
                    }
                }
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    substring = multiProcessSP.substring(1, 9);
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < substring.length(); i++) {
                        char charAt = substring.charAt(i);
                        if (!Character.isDigit(charAt)) {
                            stringBuilder.append(charAt);
                        } else if (Integer.parseInt(Character.toString(charAt)) == 0) {
                            stringBuilder.append(0);
                        } else {
                            stringBuilder.append(10 - Integer.parseInt(Character.toString(charAt)));
                        }
                    }
                    O00000oO = stringBuilder.toString();
                }
                if (!TextUtils.isEmpty(O00000oO)) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(O00000oO);
                    stringBuilder2.append(new StringBuilder(O00000oO).reverse().toString());
                    O00000oO = stringBuilder2.toString();
                    substring = UMUtils.getMultiProcessSP(O00000o, O0000OOo);
                    if (TextUtils.isEmpty(substring)) {
                        UMUtils.setMultiProcessSP(O00000o, O0000OOo, O00000o0(O00000oo));
                    } else if (!O00000oo.equals(O00000o(substring))) {
                        O00000Oo(true, false);
                        O000000o(true, false);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0065 A:{SYNTHETIC, Splitter:B:32:0x0065} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0050 A:{SYNTHETIC, Splitter:B:21:0x0050} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0055 A:{Catch:{ Exception -> 0x0058 }} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0065 A:{SYNTHETIC, Splitter:B:32:0x0065} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0050 A:{SYNTHETIC, Splitter:B:21:0x0050} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0055 A:{Catch:{ Exception -> 0x0058 }} */
    /* JADX WARNING: Missing block: B:16:0x0047, code skipped:
            if (r3 != null) goto L_0x006a;
     */
    /* JADX WARNING: Missing block: B:34:0x0068, code skipped:
            if (r3 != null) goto L_0x006a;
     */
    /* JADX WARNING: Missing block: B:35:0x006a, code skipped:
            r3.endTransaction();
     */
    public long O000000o(java.lang.String r8) {
        /*
        r7 = this;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "select __f from __sd where __ii=\"";
        r0.append(r1);
        r0.append(r8);
        r8 = "\"";
        r0.append(r8);
        r8 = r0.toString();
        r0 = 0;
        r1 = 0;
        r3 = O00000o;	 Catch:{ Exception -> 0x0062, all -> 0x004c }
        r3 = defpackage.ak.O000000o(r3);	 Catch:{ Exception -> 0x0062, all -> 0x004c }
        r3 = r3.O000000o();	 Catch:{ Exception -> 0x0062, all -> 0x004c }
        r3.beginTransaction();	 Catch:{ Exception -> 0x0063, all -> 0x004a }
        r8 = r3.rawQuery(r8, r0);	 Catch:{ Exception -> 0x0063, all -> 0x004a }
        if (r8 == 0) goto L_0x0042;
    L_0x002c:
        r8.moveToFirst();	 Catch:{ Exception -> 0x0040, all -> 0x003b }
        r0 = "__f";
        r0 = r8.getColumnIndex(r0);	 Catch:{ Exception -> 0x0040, all -> 0x003b }
        r4 = r8.getLong(r0);	 Catch:{ Exception -> 0x0040, all -> 0x003b }
        r1 = r4;
        goto L_0x0042;
    L_0x003b:
        r0 = move-exception;
        r6 = r0;
        r0 = r8;
        r8 = r6;
        goto L_0x004e;
    L_0x0040:
        r0 = r8;
        goto L_0x0063;
    L_0x0042:
        if (r8 == 0) goto L_0x0047;
    L_0x0044:
        r8.close();	 Catch:{ Exception -> 0x006d }
    L_0x0047:
        if (r3 == 0) goto L_0x006d;
    L_0x0049:
        goto L_0x006a;
    L_0x004a:
        r8 = move-exception;
        goto L_0x004e;
    L_0x004c:
        r8 = move-exception;
        r3 = r0;
    L_0x004e:
        if (r0 == 0) goto L_0x0053;
    L_0x0050:
        r0.close();	 Catch:{ Exception -> 0x0058 }
    L_0x0053:
        if (r3 == 0) goto L_0x0058;
    L_0x0055:
        r3.endTransaction();	 Catch:{ Exception -> 0x0058 }
    L_0x0058:
        r0 = O00000o;
        r0 = defpackage.ak.O000000o(r0);
        r0.O00000Oo();
        throw r8;
    L_0x0062:
        r3 = r0;
    L_0x0063:
        if (r0 == 0) goto L_0x0068;
    L_0x0065:
        r0.close();	 Catch:{ Exception -> 0x006d }
    L_0x0068:
        if (r3 == 0) goto L_0x006d;
    L_0x006a:
        r3.endTransaction();	 Catch:{ Exception -> 0x006d }
    L_0x006d:
        r8 = O00000o;
        r8 = defpackage.ak.O000000o(r8);
        r8.O00000Oo();
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.am.O000000o(java.lang.String):long");
    }

    public JSONObject O000000o(boolean z) {
        O000000o();
        this.O0000Oo.clear();
        JSONObject jSONObject = new JSONObject();
        if (z) {
            String O000000o = O000000o(jSONObject, z);
            if (!TextUtils.isEmpty(O000000o)) {
                O00000Oo(jSONObject, O000000o);
                O000000o(jSONObject, O000000o);
            }
        } else {
            O000000o(jSONObject, z);
            O00000Oo(jSONObject, null);
            O000000o(jSONObject, null);
        }
        return jSONObject;
    }

    public void O000000o() {
        this.O0000Oo0.clear();
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c2 A:{SYNTHETIC, Splitter:B:41:0x00c2} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bb A:{SYNTHETIC, Splitter:B:37:0x00bb} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x00b4 */
    /* JADX WARNING: Missing block: B:20:0x009a, code skipped:
            if (r1 != null) goto L_0x00a7;
     */
    /* JADX WARNING: Missing block: B:28:0x00a5, code skipped:
            if (r1 != null) goto L_0x00a7;
     */
    /* JADX WARNING: Missing block: B:31:?, code skipped:
            r1.endTransaction();
     */
    public void O000000o(org.json.JSONArray r8) {
        /*
        r7 = this;
        r0 = 0;
        r1 = O00000o;	 Catch:{ SQLiteDatabaseCorruptException -> 0x00b4, Throwable -> 0x00a4 }
        r1 = defpackage.ak.O000000o(r1);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00b4, Throwable -> 0x00a4 }
        r1 = r1.O000000o();	 Catch:{ SQLiteDatabaseCorruptException -> 0x00b4, Throwable -> 0x00a4 }
        r1.beginTransaction();	 Catch:{ SQLiteDatabaseCorruptException -> 0x009f, Throwable -> 0x00a5, all -> 0x009d }
        r2 = 0;
    L_0x000f:
        r3 = r8.length();	 Catch:{ SQLiteDatabaseCorruptException -> 0x009f, Throwable -> 0x00a5, all -> 0x009d }
        if (r2 >= r3) goto L_0x0097;
    L_0x0015:
        r3 = r8.getJSONObject(r2);	 Catch:{ Exception -> 0x0093 }
        r4 = new android.content.ContentValues;	 Catch:{ Exception -> 0x0093 }
        r4.<init>();	 Catch:{ Exception -> 0x0093 }
        r5 = "__i";
        r5 = r3.optString(r5);	 Catch:{ Exception -> 0x0093 }
        r6 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Exception -> 0x0093 }
        if (r6 != 0) goto L_0x0032;
    L_0x002a:
        r6 = "-1";
        r6 = r6.equals(r5);	 Catch:{ Exception -> 0x0093 }
        if (r6 == 0) goto L_0x0042;
    L_0x0032:
        r5 = defpackage.aw.O000000o();	 Catch:{ Exception -> 0x0093 }
        r5 = r5.O00000Oo();	 Catch:{ Exception -> 0x0093 }
        r6 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Exception -> 0x0093 }
        if (r6 == 0) goto L_0x0042;
    L_0x0040:
        r5 = "-1";
    L_0x0042:
        r6 = "__i";
        r4.put(r6, r5);	 Catch:{ Exception -> 0x0093 }
        r5 = "__e";
        r6 = "id";
        r6 = r3.optString(r6);	 Catch:{ Exception -> 0x0093 }
        r4.put(r5, r6);	 Catch:{ Exception -> 0x0093 }
        r5 = "__t";
        r6 = "__t";
        r6 = r3.optInt(r6);	 Catch:{ Exception -> 0x0093 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x0093 }
        r4.put(r5, r6);	 Catch:{ Exception -> 0x0093 }
        r5 = "__av";
        r6 = O00000o;	 Catch:{ Exception -> 0x0093 }
        r6 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r6);	 Catch:{ Exception -> 0x0093 }
        r4.put(r5, r6);	 Catch:{ Exception -> 0x0093 }
        r5 = "__vc";
        r6 = O00000o;	 Catch:{ Exception -> 0x0093 }
        r6 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r6);	 Catch:{ Exception -> 0x0093 }
        r4.put(r5, r6);	 Catch:{ Exception -> 0x0093 }
        r5 = "__i";
        r3.remove(r5);	 Catch:{ Exception -> 0x0093 }
        r5 = "__t";
        r3.remove(r5);	 Catch:{ Exception -> 0x0093 }
        r5 = "__s";
        r3 = r3.toString();	 Catch:{ Exception -> 0x0093 }
        r3 = r7.O00000o0(r3);	 Catch:{ Exception -> 0x0093 }
        r4.put(r5, r3);	 Catch:{ Exception -> 0x0093 }
        r3 = "__et";
        r1.insert(r3, r0, r4);	 Catch:{ Exception -> 0x0093 }
    L_0x0093:
        r2 = r2 + 1;
        goto L_0x000f;
    L_0x0097:
        r1.setTransactionSuccessful();	 Catch:{ SQLiteDatabaseCorruptException -> 0x009f, Throwable -> 0x00a5, all -> 0x009d }
        if (r1 == 0) goto L_0x00aa;
    L_0x009c:
        goto L_0x00a7;
    L_0x009d:
        r8 = move-exception;
        goto L_0x00c0;
    L_0x009f:
        r0 = r1;
        goto L_0x00b4;
    L_0x00a1:
        r8 = move-exception;
        r1 = r0;
        goto L_0x00c0;
    L_0x00a4:
        r1 = r0;
    L_0x00a5:
        if (r1 == 0) goto L_0x00aa;
    L_0x00a7:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00aa }
    L_0x00aa:
        r8 = O00000o;
        r8 = defpackage.ak.O000000o(r8);
        r8.O00000Oo();
        goto L_0x00bf;
    L_0x00b4:
        r8 = O00000o;	 Catch:{ all -> 0x00a1 }
        defpackage.al.O000000o(r8);	 Catch:{ all -> 0x00a1 }
        if (r0 == 0) goto L_0x00aa;
    L_0x00bb:
        r0.endTransaction();	 Catch:{ Throwable -> 0x00aa }
        goto L_0x00aa;
    L_0x00bf:
        return;
    L_0x00c0:
        if (r1 == 0) goto L_0x00c5;
    L_0x00c2:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00c5 }
    L_0x00c5:
        r0 = O00000o;
        r0 = defpackage.ak.O000000o(r0);
        r0.O00000Oo();
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.am.O000000o(org.json.JSONArray):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0089 A:{SYNTHETIC, Splitter:B:25:0x0089} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0082 */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0090 A:{SYNTHETIC, Splitter:B:29:0x0090} */
    /* JADX WARNING: Missing block: B:8:0x0067, code skipped:
            if (r0 != null) goto L_0x0075;
     */
    /* JADX WARNING: Missing block: B:16:0x0073, code skipped:
            if (r0 != null) goto L_0x0075;
     */
    /* JADX WARNING: Missing block: B:19:?, code skipped:
            r0.endTransaction();
     */
    public void O000000o(boolean r3, java.lang.String r4) {
        /*
        r2 = this;
        r3 = 0;
        r0 = O00000o;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0082, Throwable -> 0x0072 }
        r0 = defpackage.ak.O000000o(r0);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0082, Throwable -> 0x0072 }
        r0 = r0.O000000o();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0082, Throwable -> 0x0072 }
        r0.beginTransaction();	 Catch:{ SQLiteDatabaseCorruptException -> 0x006c, Throwable -> 0x0073, all -> 0x006a }
        r3 = android.text.TextUtils.isEmpty(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x006c, Throwable -> 0x0073, all -> 0x006a }
        if (r3 != 0) goto L_0x0064;
    L_0x0014:
        r3 = new java.lang.StringBuilder;	 Catch:{ SQLiteDatabaseCorruptException -> 0x006c, Throwable -> 0x0073, all -> 0x006a }
        r3.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x006c, Throwable -> 0x0073, all -> 0x006a }
        r1 = "delete from __er where __i=\"";
        r3.append(r1);	 Catch:{ SQLiteDatabaseCorruptException -> 0x006c, Throwable -> 0x0073, all -> 0x006a }
        r3.append(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x006c, Throwable -> 0x0073, all -> 0x006a }
        r1 = "\"";
        r3.append(r1);	 Catch:{ SQLiteDatabaseCorruptException -> 0x006c, Throwable -> 0x0073, all -> 0x006a }
        r3 = r3.toString();	 Catch:{ SQLiteDatabaseCorruptException -> 0x006c, Throwable -> 0x0073, all -> 0x006a }
        r0.execSQL(r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x006c, Throwable -> 0x0073, all -> 0x006a }
        r3 = new java.lang.StringBuilder;	 Catch:{ SQLiteDatabaseCorruptException -> 0x006c, Throwable -> 0x0073, all -> 0x006a }
        r3.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x006c, Throwable -> 0x0073, all -> 0x006a }
        r1 = "delete from __et where __i=\"";
        r3.append(r1);	 Catch:{ SQLiteDatabaseCorruptException -> 0x006c, Throwable -> 0x0073, all -> 0x006a }
        r3.append(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x006c, Throwable -> 0x0073, all -> 0x006a }
        r1 = "\"";
        r3.append(r1);	 Catch:{ SQLiteDatabaseCorruptException -> 0x006c, Throwable -> 0x0073, all -> 0x006a }
        r3 = r3.toString();	 Catch:{ SQLiteDatabaseCorruptException -> 0x006c, Throwable -> 0x0073, all -> 0x006a }
        r0.execSQL(r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x006c, Throwable -> 0x0073, all -> 0x006a }
        r3 = r2.O0000Oo;	 Catch:{ SQLiteDatabaseCorruptException -> 0x006c, Throwable -> 0x0073, all -> 0x006a }
        r3.clear();	 Catch:{ SQLiteDatabaseCorruptException -> 0x006c, Throwable -> 0x0073, all -> 0x006a }
        r3 = new java.lang.StringBuilder;	 Catch:{ SQLiteDatabaseCorruptException -> 0x006c, Throwable -> 0x0073, all -> 0x006a }
        r3.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x006c, Throwable -> 0x0073, all -> 0x006a }
        r1 = "delete from __sd where __ii=\"";
        r3.append(r1);	 Catch:{ SQLiteDatabaseCorruptException -> 0x006c, Throwable -> 0x0073, all -> 0x006a }
        r3.append(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x006c, Throwable -> 0x0073, all -> 0x006a }
        r4 = "\"";
        r3.append(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x006c, Throwable -> 0x0073, all -> 0x006a }
        r3 = r3.toString();	 Catch:{ SQLiteDatabaseCorruptException -> 0x006c, Throwable -> 0x0073, all -> 0x006a }
        r0.execSQL(r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x006c, Throwable -> 0x0073, all -> 0x006a }
    L_0x0064:
        r0.setTransactionSuccessful();	 Catch:{ SQLiteDatabaseCorruptException -> 0x006c, Throwable -> 0x0073, all -> 0x006a }
        if (r0 == 0) goto L_0x0078;
    L_0x0069:
        goto L_0x0075;
    L_0x006a:
        r3 = move-exception;
        goto L_0x008e;
    L_0x006c:
        r3 = r0;
        goto L_0x0082;
    L_0x006e:
        r4 = move-exception;
        r0 = r3;
        r3 = r4;
        goto L_0x008e;
    L_0x0072:
        r0 = r3;
    L_0x0073:
        if (r0 == 0) goto L_0x0078;
    L_0x0075:
        r0.endTransaction();	 Catch:{ Throwable -> 0x0078 }
    L_0x0078:
        r3 = O00000o;
        r3 = defpackage.ak.O000000o(r3);
        r3.O00000Oo();
        goto L_0x008d;
    L_0x0082:
        r4 = O00000o;	 Catch:{ all -> 0x006e }
        defpackage.al.O000000o(r4);	 Catch:{ all -> 0x006e }
        if (r3 == 0) goto L_0x0078;
    L_0x0089:
        r3.endTransaction();	 Catch:{ Throwable -> 0x0078 }
        goto L_0x0078;
    L_0x008d:
        return;
    L_0x008e:
        if (r0 == 0) goto L_0x0093;
    L_0x0090:
        r0.endTransaction();	 Catch:{ Throwable -> 0x0093 }
    L_0x0093:
        r4 = O00000o;
        r4 = defpackage.ak.O000000o(r4);
        r4.O00000Oo();
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.am.O000000o(boolean, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0072 A:{SYNTHETIC, Splitter:B:35:0x0072} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b A:{SYNTHETIC, Splitter:B:31:0x006b} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0064 */
    /* JADX WARNING: Missing block: B:14:0x004a, code skipped:
            if (r1 != null) goto L_0x0057;
     */
    /* JADX WARNING: Missing block: B:22:0x0055, code skipped:
            if (r1 != null) goto L_0x0057;
     */
    /* JADX WARNING: Missing block: B:25:?, code skipped:
            r1.endTransaction();
     */
    public void O000000o(boolean r4, boolean r5) {
        /*
        r3 = this;
        r0 = 0;
        r1 = O00000o;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0064, Throwable -> 0x0054 }
        r1 = defpackage.ak.O000000o(r1);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0064, Throwable -> 0x0054 }
        r1 = r1.O000000o();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0064, Throwable -> 0x0054 }
        r1.beginTransaction();	 Catch:{ SQLiteDatabaseCorruptException -> 0x004f, Throwable -> 0x0055, all -> 0x004d }
        if (r5 == 0) goto L_0x0018;
    L_0x0010:
        if (r4 == 0) goto L_0x0047;
    L_0x0012:
        r4 = "delete from __is";
        r1.execSQL(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x004f, Throwable -> 0x0055, all -> 0x004d }
        goto L_0x0047;
    L_0x0018:
        r4 = r3.O0000Ooo;	 Catch:{ SQLiteDatabaseCorruptException -> 0x004f, Throwable -> 0x0055, all -> 0x004d }
        r4 = r4.size();	 Catch:{ SQLiteDatabaseCorruptException -> 0x004f, Throwable -> 0x0055, all -> 0x004d }
        if (r4 <= 0) goto L_0x0047;
    L_0x0020:
        r5 = 0;
    L_0x0021:
        if (r5 >= r4) goto L_0x0047;
    L_0x0023:
        r0 = new java.lang.StringBuilder;	 Catch:{ SQLiteDatabaseCorruptException -> 0x004f, Throwable -> 0x0055, all -> 0x004d }
        r0.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x004f, Throwable -> 0x0055, all -> 0x004d }
        r2 = "delete from __is where __ii=\"";
        r0.append(r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x004f, Throwable -> 0x0055, all -> 0x004d }
        r2 = r3.O0000Ooo;	 Catch:{ SQLiteDatabaseCorruptException -> 0x004f, Throwable -> 0x0055, all -> 0x004d }
        r2 = r2.get(r5);	 Catch:{ SQLiteDatabaseCorruptException -> 0x004f, Throwable -> 0x0055, all -> 0x004d }
        r2 = (java.lang.String) r2;	 Catch:{ SQLiteDatabaseCorruptException -> 0x004f, Throwable -> 0x0055, all -> 0x004d }
        r0.append(r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x004f, Throwable -> 0x0055, all -> 0x004d }
        r2 = "\"";
        r0.append(r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x004f, Throwable -> 0x0055, all -> 0x004d }
        r0 = r0.toString();	 Catch:{ SQLiteDatabaseCorruptException -> 0x004f, Throwable -> 0x0055, all -> 0x004d }
        r1.execSQL(r0);	 Catch:{ SQLiteDatabaseCorruptException -> 0x004f, Throwable -> 0x0055, all -> 0x004d }
        r5 = r5 + 1;
        goto L_0x0021;
    L_0x0047:
        r1.setTransactionSuccessful();	 Catch:{ SQLiteDatabaseCorruptException -> 0x004f, Throwable -> 0x0055, all -> 0x004d }
        if (r1 == 0) goto L_0x005a;
    L_0x004c:
        goto L_0x0057;
    L_0x004d:
        r4 = move-exception;
        goto L_0x0070;
    L_0x004f:
        r0 = r1;
        goto L_0x0064;
    L_0x0051:
        r4 = move-exception;
        r1 = r0;
        goto L_0x0070;
    L_0x0054:
        r1 = r0;
    L_0x0055:
        if (r1 == 0) goto L_0x005a;
    L_0x0057:
        r1.endTransaction();	 Catch:{ Throwable -> 0x005a }
    L_0x005a:
        r4 = O00000o;
        r4 = defpackage.ak.O000000o(r4);
        r4.O00000Oo();
        goto L_0x006f;
    L_0x0064:
        r4 = O00000o;	 Catch:{ all -> 0x0051 }
        defpackage.al.O000000o(r4);	 Catch:{ all -> 0x0051 }
        if (r0 == 0) goto L_0x005a;
    L_0x006b:
        r0.endTransaction();	 Catch:{ Throwable -> 0x005a }
        goto L_0x005a;
    L_0x006f:
        return;
    L_0x0070:
        if (r1 == 0) goto L_0x0075;
    L_0x0072:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0075 }
    L_0x0075:
        r5 = O00000o;
        r5 = defpackage.ak.O000000o(r5);
        r5.O00000Oo();
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.am.O000000o(boolean, boolean):void");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0068 */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006f A:{SYNTHETIC, Splitter:B:25:0x006f} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0077 A:{SYNTHETIC, Splitter:B:30:0x0077} */
    /* JADX WARNING: Missing block: B:8:0x004e, code skipped:
            if (r1 != null) goto L_0x005b;
     */
    /* JADX WARNING: Missing block: B:16:0x0059, code skipped:
            if (r1 != null) goto L_0x005b;
     */
    /* JADX WARNING: Missing block: B:19:?, code skipped:
            r1.endTransaction();
     */
    public boolean O000000o(java.lang.String r5, java.lang.String r6, int r7) {
        /*
        r4 = this;
        r0 = 0;
        r1 = O00000o;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0068, Throwable -> 0x0058 }
        r1 = defpackage.ak.O000000o(r1);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0068, Throwable -> 0x0058 }
        r1 = r1.O000000o();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0068, Throwable -> 0x0058 }
        r1.beginTransaction();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0053, Throwable -> 0x0059, all -> 0x0051 }
        r2 = new android.content.ContentValues;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0053, Throwable -> 0x0059, all -> 0x0051 }
        r2.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0053, Throwable -> 0x0059, all -> 0x0051 }
        r3 = "__i";
        r2.put(r3, r5);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0053, Throwable -> 0x0059, all -> 0x0051 }
        r5 = r4.O00000o0(r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0053, Throwable -> 0x0059, all -> 0x0051 }
        r6 = android.text.TextUtils.isEmpty(r5);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0053, Throwable -> 0x0059, all -> 0x0051 }
        if (r6 != 0) goto L_0x004b;
    L_0x0022:
        r6 = "__a";
        r2.put(r6, r5);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0053, Throwable -> 0x0059, all -> 0x0051 }
        r5 = "__t";
        r6 = java.lang.Integer.valueOf(r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0053, Throwable -> 0x0059, all -> 0x0051 }
        r2.put(r5, r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0053, Throwable -> 0x0059, all -> 0x0051 }
        r5 = "__av";
        r6 = O00000o;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0053, Throwable -> 0x0059, all -> 0x0051 }
        r6 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0053, Throwable -> 0x0059, all -> 0x0051 }
        r2.put(r5, r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0053, Throwable -> 0x0059, all -> 0x0051 }
        r5 = "__vc";
        r6 = O00000o;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0053, Throwable -> 0x0059, all -> 0x0051 }
        r6 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0053, Throwable -> 0x0059, all -> 0x0051 }
        r2.put(r5, r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0053, Throwable -> 0x0059, all -> 0x0051 }
        r5 = "__er";
        r1.insert(r5, r0, r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0053, Throwable -> 0x0059, all -> 0x0051 }
    L_0x004b:
        r1.setTransactionSuccessful();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0053, Throwable -> 0x0059, all -> 0x0051 }
        if (r1 == 0) goto L_0x005e;
    L_0x0050:
        goto L_0x005b;
    L_0x0051:
        r5 = move-exception;
        goto L_0x0075;
    L_0x0053:
        r0 = r1;
        goto L_0x0068;
    L_0x0055:
        r5 = move-exception;
        r1 = r0;
        goto L_0x0075;
    L_0x0058:
        r1 = r0;
    L_0x0059:
        if (r1 == 0) goto L_0x005e;
    L_0x005b:
        r1.endTransaction();	 Catch:{ Throwable -> 0x005e }
    L_0x005e:
        r5 = O00000o;
        r5 = defpackage.ak.O000000o(r5);
        r5.O00000Oo();
        goto L_0x0073;
    L_0x0068:
        r5 = O00000o;	 Catch:{ all -> 0x0055 }
        defpackage.al.O000000o(r5);	 Catch:{ all -> 0x0055 }
        if (r0 == 0) goto L_0x005e;
    L_0x006f:
        r0.endTransaction();	 Catch:{ Throwable -> 0x005e }
        goto L_0x005e;
    L_0x0073:
        r5 = 0;
        return r5;
    L_0x0075:
        if (r1 == 0) goto L_0x007a;
    L_0x0077:
        r1.endTransaction();	 Catch:{ Throwable -> 0x007a }
    L_0x007a:
        r6 = O00000o;
        r6 = defpackage.ak.O000000o(r6);
        r6.O00000Oo();
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.am.O000000o(java.lang.String, java.lang.String, int):boolean");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x0099 */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a0 A:{SYNTHETIC, Splitter:B:43:0x00a0} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a7 A:{SYNTHETIC, Splitter:B:47:0x00a7} */
    /* JADX WARNING: Missing block: B:26:0x007f, code skipped:
            if (r2 != null) goto L_0x008c;
     */
    /* JADX WARNING: Missing block: B:34:0x008a, code skipped:
            if (r2 != null) goto L_0x008c;
     */
    /* JADX WARNING: Missing block: B:37:?, code skipped:
            r2.endTransaction();
     */
    public boolean O000000o(java.lang.String r6, org.json.JSONObject r7, defpackage.am.O000000o r8) {
        /*
        r5 = this;
        r0 = 0;
        if (r7 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = 0;
        r2 = O00000o;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0099, Throwable -> 0x0089 }
        r2 = defpackage.ak.O000000o(r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0099, Throwable -> 0x0089 }
        r2 = r2.O000000o();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0099, Throwable -> 0x0089 }
        r2.beginTransaction();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0084, Throwable -> 0x008a, all -> 0x0082 }
        r3 = defpackage.am.O000000o.BEGIN;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0084, Throwable -> 0x008a, all -> 0x0082 }
        if (r8 != r3) goto L_0x0051;
    L_0x0016:
        r8 = "__e";
        r7 = r7.opt(r8);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0084, Throwable -> 0x008a, all -> 0x0082 }
        r7 = (java.lang.Long) r7;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0084, Throwable -> 0x008a, all -> 0x0082 }
        r7 = r7.longValue();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0084, Throwable -> 0x008a, all -> 0x0082 }
        r3 = new android.content.ContentValues;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0084, Throwable -> 0x008a, all -> 0x0082 }
        r3.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0084, Throwable -> 0x008a, all -> 0x0082 }
        r4 = "__ii";
        r3.put(r4, r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0084, Throwable -> 0x008a, all -> 0x0082 }
        r6 = "__e";
        r7 = java.lang.String.valueOf(r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0084, Throwable -> 0x008a, all -> 0x0082 }
        r3.put(r6, r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0084, Throwable -> 0x008a, all -> 0x0082 }
        r6 = "__av";
        r7 = O00000o;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0084, Throwable -> 0x008a, all -> 0x0082 }
        r7 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0084, Throwable -> 0x008a, all -> 0x0082 }
        r3.put(r6, r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0084, Throwable -> 0x008a, all -> 0x0082 }
        r6 = "__vc";
        r7 = O00000o;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0084, Throwable -> 0x008a, all -> 0x0082 }
        r7 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0084, Throwable -> 0x008a, all -> 0x0082 }
        r3.put(r6, r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0084, Throwable -> 0x008a, all -> 0x0082 }
        r6 = "__sd";
        r2.insert(r6, r1, r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0084, Throwable -> 0x008a, all -> 0x0082 }
        goto L_0x007c;
    L_0x0051:
        r1 = defpackage.am.O000000o.INSTANTSESSIONBEGIN;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0084, Throwable -> 0x008a, all -> 0x0082 }
        if (r8 != r1) goto L_0x0059;
    L_0x0055:
        r5.O00000Oo(r6, r7, r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0084, Throwable -> 0x008a, all -> 0x0082 }
        goto L_0x007c;
    L_0x0059:
        r1 = defpackage.am.O000000o.END;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0084, Throwable -> 0x008a, all -> 0x0082 }
        if (r8 != r1) goto L_0x0061;
    L_0x005d:
        r5.O000000o(r6, r7, r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0084, Throwable -> 0x008a, all -> 0x0082 }
        goto L_0x007c;
    L_0x0061:
        r1 = defpackage.am.O000000o.PAGE;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0084, Throwable -> 0x008a, all -> 0x0082 }
        if (r8 != r1) goto L_0x006b;
    L_0x0065:
        r8 = "__a";
        r5.O000000o(r6, r7, r2, r8);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0084, Throwable -> 0x008a, all -> 0x0082 }
        goto L_0x007c;
    L_0x006b:
        r1 = defpackage.am.O000000o.AUTOPAGE;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0084, Throwable -> 0x008a, all -> 0x0082 }
        if (r8 != r1) goto L_0x0075;
    L_0x006f:
        r8 = "__b";
        r5.O000000o(r6, r7, r2, r8);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0084, Throwable -> 0x008a, all -> 0x0082 }
        goto L_0x007c;
    L_0x0075:
        r1 = defpackage.am.O000000o.NEWSESSION;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0084, Throwable -> 0x008a, all -> 0x0082 }
        if (r8 != r1) goto L_0x007c;
    L_0x0079:
        r5.O00000o0(r6, r7, r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0084, Throwable -> 0x008a, all -> 0x0082 }
    L_0x007c:
        r2.setTransactionSuccessful();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0084, Throwable -> 0x008a, all -> 0x0082 }
        if (r2 == 0) goto L_0x008f;
    L_0x0081:
        goto L_0x008c;
    L_0x0082:
        r6 = move-exception;
        goto L_0x00a5;
    L_0x0084:
        r1 = r2;
        goto L_0x0099;
    L_0x0086:
        r6 = move-exception;
        r2 = r1;
        goto L_0x00a5;
    L_0x0089:
        r2 = r1;
    L_0x008a:
        if (r2 == 0) goto L_0x008f;
    L_0x008c:
        r2.endTransaction();	 Catch:{ Throwable -> 0x008f }
    L_0x008f:
        r6 = O00000o;
        r6 = defpackage.ak.O000000o(r6);
        r6.O00000Oo();
        goto L_0x00a4;
    L_0x0099:
        r6 = O00000o;	 Catch:{ all -> 0x0086 }
        defpackage.al.O000000o(r6);	 Catch:{ all -> 0x0086 }
        if (r1 == 0) goto L_0x008f;
    L_0x00a0:
        r1.endTransaction();	 Catch:{ Throwable -> 0x008f }
        goto L_0x008f;
    L_0x00a4:
        return r0;
    L_0x00a5:
        if (r2 == 0) goto L_0x00aa;
    L_0x00a7:
        r2.endTransaction();	 Catch:{ Throwable -> 0x00aa }
    L_0x00aa:
        r7 = O00000o;
        r7 = defpackage.ak.O000000o(r7);
        r7.O00000Oo();
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.am.O000000o(java.lang.String, org.json.JSONObject, am$O000000o):boolean");
    }

    public JSONObject O00000Oo(boolean z) {
        JSONObject jSONObject = new JSONObject();
        O00000Oo(jSONObject, z);
        return jSONObject;
    }

    public void O00000Oo() {
        this.O0000Ooo.clear();
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x004a */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051 A:{SYNTHETIC, Splitter:B:25:0x0051} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0058 A:{SYNTHETIC, Splitter:B:29:0x0058} */
    /* JADX WARNING: Missing block: B:8:0x0030, code skipped:
            if (r1 != null) goto L_0x003d;
     */
    /* JADX WARNING: Missing block: B:16:0x003b, code skipped:
            if (r1 != null) goto L_0x003d;
     */
    /* JADX WARNING: Missing block: B:19:?, code skipped:
            r1.endTransaction();
     */
    public void O00000Oo(java.lang.String r4) {
        /*
        r3 = this;
        r0 = 0;
        r1 = O00000o;	 Catch:{ SQLiteDatabaseCorruptException -> 0x004a, Throwable -> 0x003a }
        r1 = defpackage.ak.O000000o(r1);	 Catch:{ SQLiteDatabaseCorruptException -> 0x004a, Throwable -> 0x003a }
        r1 = r1.O000000o();	 Catch:{ SQLiteDatabaseCorruptException -> 0x004a, Throwable -> 0x003a }
        r1.beginTransaction();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0035, Throwable -> 0x003b, all -> 0x0033 }
        r0 = android.text.TextUtils.isEmpty(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0035, Throwable -> 0x003b, all -> 0x0033 }
        if (r0 != 0) goto L_0x002d;
    L_0x0014:
        r0 = new java.lang.StringBuilder;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0035, Throwable -> 0x003b, all -> 0x0033 }
        r0.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0035, Throwable -> 0x003b, all -> 0x0033 }
        r2 = "delete from __is where __ii=\"";
        r0.append(r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0035, Throwable -> 0x003b, all -> 0x0033 }
        r0.append(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0035, Throwable -> 0x003b, all -> 0x0033 }
        r4 = "\"";
        r0.append(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0035, Throwable -> 0x003b, all -> 0x0033 }
        r4 = r0.toString();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0035, Throwable -> 0x003b, all -> 0x0033 }
        r1.execSQL(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0035, Throwable -> 0x003b, all -> 0x0033 }
    L_0x002d:
        r1.setTransactionSuccessful();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0035, Throwable -> 0x003b, all -> 0x0033 }
        if (r1 == 0) goto L_0x0040;
    L_0x0032:
        goto L_0x003d;
    L_0x0033:
        r4 = move-exception;
        goto L_0x0056;
    L_0x0035:
        r0 = r1;
        goto L_0x004a;
    L_0x0037:
        r4 = move-exception;
        r1 = r0;
        goto L_0x0056;
    L_0x003a:
        r1 = r0;
    L_0x003b:
        if (r1 == 0) goto L_0x0040;
    L_0x003d:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0040 }
    L_0x0040:
        r4 = O00000o;
        r4 = defpackage.ak.O000000o(r4);
        r4.O00000Oo();
        goto L_0x0055;
    L_0x004a:
        r4 = O00000o;	 Catch:{ all -> 0x0037 }
        defpackage.al.O000000o(r4);	 Catch:{ all -> 0x0037 }
        if (r0 == 0) goto L_0x0040;
    L_0x0051:
        r0.endTransaction();	 Catch:{ Throwable -> 0x0040 }
        goto L_0x0040;
    L_0x0055:
        return;
    L_0x0056:
        if (r1 == 0) goto L_0x005b;
    L_0x0058:
        r1.endTransaction();	 Catch:{ Throwable -> 0x005b }
    L_0x005b:
        r0 = O00000o;
        r0 = defpackage.ak.O000000o(r0);
        r0.O00000Oo();
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.am.O00000Oo(java.lang.String):void");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x006a */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0071 A:{SYNTHETIC, Splitter:B:32:0x0071} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0078 A:{SYNTHETIC, Splitter:B:36:0x0078} */
    /* JADX WARNING: Missing block: B:15:0x0050, code skipped:
            if (r1 != null) goto L_0x005d;
     */
    /* JADX WARNING: Missing block: B:23:0x005b, code skipped:
            if (r1 != null) goto L_0x005d;
     */
    /* JADX WARNING: Missing block: B:26:?, code skipped:
            r1.endTransaction();
     */
    public void O00000Oo(boolean r3, boolean r4) {
        /*
        r2 = this;
        r0 = 0;
        r1 = O00000o;	 Catch:{ SQLiteDatabaseCorruptException -> 0x006a, Throwable -> 0x005a }
        r1 = defpackage.ak.O000000o(r1);	 Catch:{ SQLiteDatabaseCorruptException -> 0x006a, Throwable -> 0x005a }
        r1 = r1.O000000o();	 Catch:{ SQLiteDatabaseCorruptException -> 0x006a, Throwable -> 0x005a }
        r1.beginTransaction();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0055, Throwable -> 0x005b, all -> 0x0053 }
        if (r4 == 0) goto L_0x0018;
    L_0x0010:
        if (r3 == 0) goto L_0x004d;
    L_0x0012:
        r3 = "delete from __sd";
        r1.execSQL(r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0055, Throwable -> 0x005b, all -> 0x0053 }
        goto L_0x004d;
    L_0x0018:
        r3 = r2.O0000Oo0;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0055, Throwable -> 0x005b, all -> 0x0053 }
        r3 = r3.size();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0055, Throwable -> 0x005b, all -> 0x0053 }
        if (r3 <= 0) goto L_0x004d;
    L_0x0020:
        r3 = 0;
    L_0x0021:
        r4 = r2.O0000Oo0;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0055, Throwable -> 0x005b, all -> 0x0053 }
        r4 = r4.size();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0055, Throwable -> 0x005b, all -> 0x0053 }
        if (r3 >= r4) goto L_0x004d;
    L_0x0029:
        r4 = new java.lang.StringBuilder;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0055, Throwable -> 0x005b, all -> 0x0053 }
        r4.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0055, Throwable -> 0x005b, all -> 0x0053 }
        r0 = "delete from __sd where __ii=\"";
        r4.append(r0);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0055, Throwable -> 0x005b, all -> 0x0053 }
        r0 = r2.O0000Oo0;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0055, Throwable -> 0x005b, all -> 0x0053 }
        r0 = r0.get(r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0055, Throwable -> 0x005b, all -> 0x0053 }
        r0 = (java.lang.String) r0;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0055, Throwable -> 0x005b, all -> 0x0053 }
        r4.append(r0);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0055, Throwable -> 0x005b, all -> 0x0053 }
        r0 = "\"";
        r4.append(r0);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0055, Throwable -> 0x005b, all -> 0x0053 }
        r4 = r4.toString();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0055, Throwable -> 0x005b, all -> 0x0053 }
        r1.execSQL(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0055, Throwable -> 0x005b, all -> 0x0053 }
        r3 = r3 + 1;
        goto L_0x0021;
    L_0x004d:
        r1.setTransactionSuccessful();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0055, Throwable -> 0x005b, all -> 0x0053 }
        if (r1 == 0) goto L_0x0060;
    L_0x0052:
        goto L_0x005d;
    L_0x0053:
        r3 = move-exception;
        goto L_0x0076;
    L_0x0055:
        r0 = r1;
        goto L_0x006a;
    L_0x0057:
        r3 = move-exception;
        r1 = r0;
        goto L_0x0076;
    L_0x005a:
        r1 = r0;
    L_0x005b:
        if (r1 == 0) goto L_0x0060;
    L_0x005d:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0060 }
    L_0x0060:
        r3 = O00000o;
        r3 = defpackage.ak.O000000o(r3);
        r3.O00000Oo();
        goto L_0x0075;
    L_0x006a:
        r3 = O00000o;	 Catch:{ all -> 0x0057 }
        defpackage.al.O000000o(r3);	 Catch:{ all -> 0x0057 }
        if (r0 == 0) goto L_0x0060;
    L_0x0071:
        r0.endTransaction();	 Catch:{ Throwable -> 0x0060 }
        goto L_0x0060;
    L_0x0075:
        return;
    L_0x0076:
        if (r1 == 0) goto L_0x007b;
    L_0x0078:
        r1.endTransaction();	 Catch:{ Throwable -> 0x007b }
    L_0x007b:
        r4 = O00000o;
        r4 = defpackage.ak.O000000o(r4);
        r4.O00000Oo();
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.am.O00000Oo(boolean, boolean):void");
    }

    public String O00000o(String str) {
        try {
            return TextUtils.isEmpty(O00000oO) ? str : new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), O00000oO.getBytes()));
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0098 A:{SYNTHETIC, Splitter:B:40:0x0098} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0091 A:{SYNTHETIC, Splitter:B:36:0x0091} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x008a */
    /* JADX WARNING: Missing block: B:19:0x006e, code skipped:
            if (r1 != null) goto L_0x007d;
     */
    /* JADX WARNING: Missing block: B:27:0x007b, code skipped:
            if (r1 != null) goto L_0x007d;
     */
    /* JADX WARNING: Missing block: B:30:?, code skipped:
            r1.endTransaction();
     */
    public void O00000o() {
        /*
        r7 = this;
        r0 = 0;
        r1 = O00000o;	 Catch:{ SQLiteDatabaseCorruptException -> 0x008a, Throwable -> 0x007a }
        r1 = defpackage.ak.O000000o(r1);	 Catch:{ SQLiteDatabaseCorruptException -> 0x008a, Throwable -> 0x007a }
        r1 = r1.O000000o();	 Catch:{ SQLiteDatabaseCorruptException -> 0x008a, Throwable -> 0x007a }
        r1.beginTransaction();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0073, Throwable -> 0x007b, all -> 0x0071 }
        r0 = defpackage.aw.O000000o();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0073, Throwable -> 0x007b, all -> 0x0071 }
        r0 = r0.O00000o0();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0073, Throwable -> 0x007b, all -> 0x0071 }
        r2 = android.text.TextUtils.isEmpty(r0);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0073, Throwable -> 0x007b, all -> 0x0071 }
        if (r2 == 0) goto L_0x002b;
    L_0x001c:
        if (r1 == 0) goto L_0x0021;
    L_0x001e:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0021 }
    L_0x0021:
        r0 = O00000o;
        r0 = defpackage.ak.O000000o(r0);
        r0.O00000Oo();
        return;
    L_0x002b:
        r2 = 2;
        r2 = new java.lang.String[r2];	 Catch:{ SQLiteDatabaseCorruptException -> 0x0073, Throwable -> 0x007b, all -> 0x0071 }
        r3 = "";
        r4 = 0;
        r2[r4] = r3;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0073, Throwable -> 0x007b, all -> 0x0071 }
        r3 = "-1";
        r5 = 1;
        r2[r5] = r3;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0073, Throwable -> 0x007b, all -> 0x0071 }
    L_0x0038:
        r3 = r2.length;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0073, Throwable -> 0x007b, all -> 0x0071 }
        if (r4 >= r3) goto L_0x006b;
    L_0x003b:
        r3 = new java.lang.StringBuilder;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0073, Throwable -> 0x007b, all -> 0x0071 }
        r3.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0073, Throwable -> 0x007b, all -> 0x0071 }
        r5 = "update __et set __i=\"";
        r3.append(r5);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0073, Throwable -> 0x007b, all -> 0x0071 }
        r3.append(r0);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0073, Throwable -> 0x007b, all -> 0x0071 }
        r5 = "\" where ";
        r3.append(r5);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0073, Throwable -> 0x007b, all -> 0x0071 }
        r5 = "__i";
        r3.append(r5);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0073, Throwable -> 0x007b, all -> 0x0071 }
        r5 = "=\"";
        r3.append(r5);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0073, Throwable -> 0x007b, all -> 0x0071 }
        r5 = r2[r4];	 Catch:{ SQLiteDatabaseCorruptException -> 0x0073, Throwable -> 0x007b, all -> 0x0071 }
        r3.append(r5);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0073, Throwable -> 0x007b, all -> 0x0071 }
        r5 = "\"";
        r3.append(r5);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0073, Throwable -> 0x007b, all -> 0x0071 }
        r3 = r3.toString();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0073, Throwable -> 0x007b, all -> 0x0071 }
        r1.execSQL(r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0073, Throwable -> 0x007b, all -> 0x0071 }
        r4 = r4 + 1;
        goto L_0x0038;
    L_0x006b:
        r1.setTransactionSuccessful();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0073, Throwable -> 0x007b, all -> 0x0071 }
        if (r1 == 0) goto L_0x0080;
    L_0x0070:
        goto L_0x007d;
    L_0x0071:
        r0 = move-exception;
        goto L_0x0096;
    L_0x0073:
        r0 = r1;
        goto L_0x008a;
    L_0x0075:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
        goto L_0x0096;
    L_0x007a:
        r1 = r0;
    L_0x007b:
        if (r1 == 0) goto L_0x0080;
    L_0x007d:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0080 }
    L_0x0080:
        r0 = O00000o;
        r0 = defpackage.ak.O000000o(r0);
        r0.O00000Oo();
        goto L_0x0095;
    L_0x008a:
        r1 = O00000o;	 Catch:{ all -> 0x0075 }
        defpackage.al.O000000o(r1);	 Catch:{ all -> 0x0075 }
        if (r0 == 0) goto L_0x0080;
    L_0x0091:
        r0.endTransaction();	 Catch:{ Throwable -> 0x0080 }
        goto L_0x0080;
    L_0x0095:
        return;
    L_0x0096:
        if (r1 == 0) goto L_0x009b;
    L_0x0098:
        r1.endTransaction();	 Catch:{ Throwable -> 0x009b }
    L_0x009b:
        r1 = O00000o;
        r1 = defpackage.ak.O000000o(r1);
        r1.O00000Oo();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.am.O00000o():void");
    }

    public String O00000o0(String str) {
        try {
            return TextUtils.isEmpty(O00000oO) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), O00000oO.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean O00000o0() {
        return this.O0000Ooo.isEmpty();
    }

    public boolean O00000oO() {
        return this.O0000Oo0.isEmpty();
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0067 A:{Splitter:B:8:0x003c, ExcHandler: all (r1_6 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00c1 A:{SYNTHETIC, Splitter:B:61:0x00c1} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00c1 A:{SYNTHETIC, Splitter:B:61:0x00c1} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0097  */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:15:0x0067, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:16:0x0068, code skipped:
            r6 = r2;
            r2 = r1;
            r1 = r6;
     */
    /* JADX WARNING: Missing block: B:17:0x006d, code skipped:
            r3 = r1;
     */
    /* JADX WARNING: Missing block: B:21:0x0070, code skipped:
            r3 = r1;
     */
    /* JADX WARNING: Missing block: B:43:0x0097, code skipped:
            r1.close();
     */
    /* JADX WARNING: Missing block: B:44:0x009a, code skipped:
            if (r0 == null) goto L_0x009f;
     */
    /* JADX WARNING: Missing block: B:46:?, code skipped:
            r0.endTransaction();
     */
    /* JADX WARNING: Missing block: B:54:0x00b2, code skipped:
            r1.close();
     */
    /* JADX WARNING: Missing block: B:55:0x00b5, code skipped:
            if (r0 == null) goto L_0x009f;
     */
    /* JADX WARNING: Missing block: B:59:0x00bc, code skipped:
            r1.close();
     */
    /* JADX WARNING: Missing block: B:62:?, code skipped:
            r0.endTransaction();
     */
    public org.json.JSONObject O00000oo() {
        /*
        r7 = this;
        r0 = r7.O0000Ooo;
        r0 = r0.isEmpty();
        r1 = 0;
        if (r0 == 0) goto L_0x000a;
    L_0x0009:
        return r1;
    L_0x000a:
        r0 = O00000o;	 Catch:{ SQLiteDatabaseCorruptException -> 0x00a9, Throwable -> 0x0093, all -> 0x008f }
        r0 = defpackage.ak.O000000o(r0);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00a9, Throwable -> 0x0093, all -> 0x008f }
        r0 = r0.O000000o();	 Catch:{ SQLiteDatabaseCorruptException -> 0x00a9, Throwable -> 0x0093, all -> 0x008f }
        r0.beginTransaction();	 Catch:{ SQLiteDatabaseCorruptException -> 0x008d, Throwable -> 0x008b }
        r2 = new java.lang.StringBuilder;	 Catch:{ SQLiteDatabaseCorruptException -> 0x008d, Throwable -> 0x008b }
        r2.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x008d, Throwable -> 0x008b }
        r3 = "select *  from __is where __ii=\"";
        r2.append(r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x008d, Throwable -> 0x008b }
        r3 = r7.O0000Ooo;	 Catch:{ SQLiteDatabaseCorruptException -> 0x008d, Throwable -> 0x008b }
        r4 = 0;
        r3 = r3.get(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x008d, Throwable -> 0x008b }
        r3 = (java.lang.String) r3;	 Catch:{ SQLiteDatabaseCorruptException -> 0x008d, Throwable -> 0x008b }
        r2.append(r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x008d, Throwable -> 0x008b }
        r3 = "\"";
        r2.append(r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x008d, Throwable -> 0x008b }
        r2 = r2.toString();	 Catch:{ SQLiteDatabaseCorruptException -> 0x008d, Throwable -> 0x008b }
        r2 = r0.rawQuery(r2, r1);	 Catch:{ SQLiteDatabaseCorruptException -> 0x008d, Throwable -> 0x008b }
        if (r2 == 0) goto L_0x0073;
    L_0x003c:
        r3 = r2.moveToNext();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0070, Throwable -> 0x006d, all -> 0x0067 }
        if (r3 == 0) goto L_0x0073;
    L_0x0042:
        r3 = new org.json.JSONObject;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0070, Throwable -> 0x006d, all -> 0x0067 }
        r3.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0070, Throwable -> 0x006d, all -> 0x0067 }
        r1 = "__av";
        r1 = r2.getColumnIndex(r1);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0071, Throwable -> 0x006e, all -> 0x0067 }
        r1 = r2.getString(r1);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0071, Throwable -> 0x006e, all -> 0x0067 }
        r4 = "__vc";
        r4 = r2.getColumnIndex(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0071, Throwable -> 0x006e, all -> 0x0067 }
        r4 = r2.getString(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0071, Throwable -> 0x006e, all -> 0x0067 }
        r5 = "__av";
        r3.put(r5, r1);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0071, Throwable -> 0x006e, all -> 0x0067 }
        r1 = "__vc";
        r3.put(r1, r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0071, Throwable -> 0x006e, all -> 0x0067 }
        r1 = r3;
        goto L_0x0073;
    L_0x0067:
        r1 = move-exception;
        r6 = r2;
        r2 = r1;
        r1 = r6;
        goto L_0x00ba;
    L_0x006d:
        r3 = r1;
    L_0x006e:
        r1 = r2;
        goto L_0x0095;
    L_0x0070:
        r3 = r1;
    L_0x0071:
        r1 = r2;
        goto L_0x00ab;
    L_0x0073:
        r0.setTransactionSuccessful();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0070, Throwable -> 0x006d, all -> 0x0067 }
        if (r2 == 0) goto L_0x007b;
    L_0x0078:
        r2.close();
    L_0x007b:
        if (r0 == 0) goto L_0x0080;
    L_0x007d:
        r0.endTransaction();	 Catch:{ Throwable -> 0x0080 }
    L_0x0080:
        r0 = O00000o;
        r0 = defpackage.ak.O000000o(r0);
        r0.O00000Oo();
        r3 = r1;
        goto L_0x00b8;
    L_0x008b:
        r3 = r1;
        goto L_0x0095;
    L_0x008d:
        r3 = r1;
        goto L_0x00ab;
    L_0x008f:
        r0 = move-exception;
        r2 = r0;
        r0 = r1;
        goto L_0x00ba;
    L_0x0093:
        r0 = r1;
        r3 = r0;
    L_0x0095:
        if (r1 == 0) goto L_0x009a;
    L_0x0097:
        r1.close();
    L_0x009a:
        if (r0 == 0) goto L_0x009f;
    L_0x009c:
        r0.endTransaction();	 Catch:{ Throwable -> 0x009f }
    L_0x009f:
        r0 = O00000o;
        r0 = defpackage.ak.O000000o(r0);
        r0.O00000Oo();
        goto L_0x00b8;
    L_0x00a9:
        r0 = r1;
        r3 = r0;
    L_0x00ab:
        r2 = O00000o;	 Catch:{ all -> 0x00b9 }
        defpackage.al.O000000o(r2);	 Catch:{ all -> 0x00b9 }
        if (r1 == 0) goto L_0x00b5;
    L_0x00b2:
        r1.close();
    L_0x00b5:
        if (r0 == 0) goto L_0x009f;
    L_0x00b7:
        goto L_0x009c;
    L_0x00b8:
        return r3;
    L_0x00b9:
        r2 = move-exception;
    L_0x00ba:
        if (r1 == 0) goto L_0x00bf;
    L_0x00bc:
        r1.close();
    L_0x00bf:
        if (r0 == 0) goto L_0x00c4;
    L_0x00c1:
        r0.endTransaction();	 Catch:{ Throwable -> 0x00c4 }
    L_0x00c4:
        r0 = O00000o;
        r0 = defpackage.ak.O000000o(r0);
        r0.O00000Oo();
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.am.O00000oo():org.json.JSONObject");
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0067 A:{Splitter:B:8:0x003c, ExcHandler: all (r1_6 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00c1 A:{SYNTHETIC, Splitter:B:61:0x00c1} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00c1 A:{SYNTHETIC, Splitter:B:61:0x00c1} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0097  */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:15:0x0067, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:16:0x0068, code skipped:
            r6 = r2;
            r2 = r1;
            r1 = r6;
     */
    /* JADX WARNING: Missing block: B:17:0x006d, code skipped:
            r3 = r1;
     */
    /* JADX WARNING: Missing block: B:21:0x0070, code skipped:
            r3 = r1;
     */
    /* JADX WARNING: Missing block: B:43:0x0097, code skipped:
            r1.close();
     */
    /* JADX WARNING: Missing block: B:44:0x009a, code skipped:
            if (r0 == null) goto L_0x009f;
     */
    /* JADX WARNING: Missing block: B:46:?, code skipped:
            r0.endTransaction();
     */
    /* JADX WARNING: Missing block: B:54:0x00b2, code skipped:
            r1.close();
     */
    /* JADX WARNING: Missing block: B:55:0x00b5, code skipped:
            if (r0 == null) goto L_0x009f;
     */
    /* JADX WARNING: Missing block: B:59:0x00bc, code skipped:
            r1.close();
     */
    /* JADX WARNING: Missing block: B:62:?, code skipped:
            r0.endTransaction();
     */
    public org.json.JSONObject O0000O0o() {
        /*
        r7 = this;
        r0 = r7.O0000Oo0;
        r0 = r0.isEmpty();
        r1 = 0;
        if (r0 == 0) goto L_0x000a;
    L_0x0009:
        return r1;
    L_0x000a:
        r0 = O00000o;	 Catch:{ SQLiteDatabaseCorruptException -> 0x00a9, Throwable -> 0x0093, all -> 0x008f }
        r0 = defpackage.ak.O000000o(r0);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00a9, Throwable -> 0x0093, all -> 0x008f }
        r0 = r0.O000000o();	 Catch:{ SQLiteDatabaseCorruptException -> 0x00a9, Throwable -> 0x0093, all -> 0x008f }
        r0.beginTransaction();	 Catch:{ SQLiteDatabaseCorruptException -> 0x008d, Throwable -> 0x008b }
        r2 = new java.lang.StringBuilder;	 Catch:{ SQLiteDatabaseCorruptException -> 0x008d, Throwable -> 0x008b }
        r2.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x008d, Throwable -> 0x008b }
        r3 = "select *  from __sd where __ii=\"";
        r2.append(r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x008d, Throwable -> 0x008b }
        r3 = r7.O0000Oo0;	 Catch:{ SQLiteDatabaseCorruptException -> 0x008d, Throwable -> 0x008b }
        r4 = 0;
        r3 = r3.get(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x008d, Throwable -> 0x008b }
        r3 = (java.lang.String) r3;	 Catch:{ SQLiteDatabaseCorruptException -> 0x008d, Throwable -> 0x008b }
        r2.append(r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x008d, Throwable -> 0x008b }
        r3 = "\"";
        r2.append(r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x008d, Throwable -> 0x008b }
        r2 = r2.toString();	 Catch:{ SQLiteDatabaseCorruptException -> 0x008d, Throwable -> 0x008b }
        r2 = r0.rawQuery(r2, r1);	 Catch:{ SQLiteDatabaseCorruptException -> 0x008d, Throwable -> 0x008b }
        if (r2 == 0) goto L_0x0073;
    L_0x003c:
        r3 = r2.moveToNext();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0070, Throwable -> 0x006d, all -> 0x0067 }
        if (r3 == 0) goto L_0x0073;
    L_0x0042:
        r3 = new org.json.JSONObject;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0070, Throwable -> 0x006d, all -> 0x0067 }
        r3.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0070, Throwable -> 0x006d, all -> 0x0067 }
        r1 = "__av";
        r1 = r2.getColumnIndex(r1);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0071, Throwable -> 0x006e, all -> 0x0067 }
        r1 = r2.getString(r1);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0071, Throwable -> 0x006e, all -> 0x0067 }
        r4 = "__vc";
        r4 = r2.getColumnIndex(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0071, Throwable -> 0x006e, all -> 0x0067 }
        r4 = r2.getString(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0071, Throwable -> 0x006e, all -> 0x0067 }
        r5 = "__av";
        r3.put(r5, r1);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0071, Throwable -> 0x006e, all -> 0x0067 }
        r1 = "__vc";
        r3.put(r1, r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0071, Throwable -> 0x006e, all -> 0x0067 }
        r1 = r3;
        goto L_0x0073;
    L_0x0067:
        r1 = move-exception;
        r6 = r2;
        r2 = r1;
        r1 = r6;
        goto L_0x00ba;
    L_0x006d:
        r3 = r1;
    L_0x006e:
        r1 = r2;
        goto L_0x0095;
    L_0x0070:
        r3 = r1;
    L_0x0071:
        r1 = r2;
        goto L_0x00ab;
    L_0x0073:
        r0.setTransactionSuccessful();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0070, Throwable -> 0x006d, all -> 0x0067 }
        if (r2 == 0) goto L_0x007b;
    L_0x0078:
        r2.close();
    L_0x007b:
        if (r0 == 0) goto L_0x0080;
    L_0x007d:
        r0.endTransaction();	 Catch:{ Throwable -> 0x0080 }
    L_0x0080:
        r0 = O00000o;
        r0 = defpackage.ak.O000000o(r0);
        r0.O00000Oo();
        r3 = r1;
        goto L_0x00b8;
    L_0x008b:
        r3 = r1;
        goto L_0x0095;
    L_0x008d:
        r3 = r1;
        goto L_0x00ab;
    L_0x008f:
        r0 = move-exception;
        r2 = r0;
        r0 = r1;
        goto L_0x00ba;
    L_0x0093:
        r0 = r1;
        r3 = r0;
    L_0x0095:
        if (r1 == 0) goto L_0x009a;
    L_0x0097:
        r1.close();
    L_0x009a:
        if (r0 == 0) goto L_0x009f;
    L_0x009c:
        r0.endTransaction();	 Catch:{ Throwable -> 0x009f }
    L_0x009f:
        r0 = O00000o;
        r0 = defpackage.ak.O000000o(r0);
        r0.O00000Oo();
        goto L_0x00b8;
    L_0x00a9:
        r0 = r1;
        r3 = r0;
    L_0x00ab:
        r2 = O00000o;	 Catch:{ all -> 0x00b9 }
        defpackage.al.O000000o(r2);	 Catch:{ all -> 0x00b9 }
        if (r1 == 0) goto L_0x00b5;
    L_0x00b2:
        r1.close();
    L_0x00b5:
        if (r0 == 0) goto L_0x009f;
    L_0x00b7:
        goto L_0x009c;
    L_0x00b8:
        return r3;
    L_0x00b9:
        r2 = move-exception;
    L_0x00ba:
        if (r1 == 0) goto L_0x00bf;
    L_0x00bc:
        r1.close();
    L_0x00bf:
        if (r0 == 0) goto L_0x00c4;
    L_0x00c1:
        r0.endTransaction();	 Catch:{ Throwable -> 0x00c4 }
    L_0x00c4:
        r0 = O00000o;
        r0 = defpackage.ak.O000000o(r0);
        r0.O00000Oo();
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.am.O0000O0o():org.json.JSONObject");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x006e A:{SYNTHETIC, Splitter:B:32:0x006e} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0067 A:{SYNTHETIC, Splitter:B:28:0x0067} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0060 */
    /* JADX WARNING: Missing block: B:11:0x0044, code skipped:
            if (r1 != null) goto L_0x0053;
     */
    /* JADX WARNING: Missing block: B:19:0x0051, code skipped:
            if (r1 != null) goto L_0x0053;
     */
    /* JADX WARNING: Missing block: B:22:?, code skipped:
            r1.endTransaction();
     */
    public void O0000OOo() {
        /*
        r5 = this;
        r0 = 0;
        r1 = O00000o;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0060, Throwable -> 0x0050 }
        r1 = defpackage.ak.O000000o(r1);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0060, Throwable -> 0x0050 }
        r1 = r1.O000000o();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0060, Throwable -> 0x0050 }
        r1.beginTransaction();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0049, Throwable -> 0x0051, all -> 0x0047 }
        r0 = r5.O0000Oo;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0049, Throwable -> 0x0051, all -> 0x0047 }
        r0 = r0.size();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0049, Throwable -> 0x0051, all -> 0x0047 }
        if (r0 <= 0) goto L_0x003c;
    L_0x0016:
        r0 = 0;
    L_0x0017:
        r2 = r5.O0000Oo;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0049, Throwable -> 0x0051, all -> 0x0047 }
        r2 = r2.size();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0049, Throwable -> 0x0051, all -> 0x0047 }
        if (r0 >= r2) goto L_0x003c;
    L_0x001f:
        r2 = new java.lang.StringBuilder;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0049, Throwable -> 0x0051, all -> 0x0047 }
        r2.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0049, Throwable -> 0x0051, all -> 0x0047 }
        r3 = "delete from __et where rowid=";
        r2.append(r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0049, Throwable -> 0x0051, all -> 0x0047 }
        r3 = r5.O0000Oo;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0049, Throwable -> 0x0051, all -> 0x0047 }
        r3 = r3.get(r0);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0049, Throwable -> 0x0051, all -> 0x0047 }
        r2.append(r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0049, Throwable -> 0x0051, all -> 0x0047 }
        r2 = r2.toString();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0049, Throwable -> 0x0051, all -> 0x0047 }
        r1.execSQL(r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0049, Throwable -> 0x0051, all -> 0x0047 }
        r0 = r0 + 1;
        goto L_0x0017;
    L_0x003c:
        r0 = r5.O0000Oo;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0049, Throwable -> 0x0051, all -> 0x0047 }
        r0.clear();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0049, Throwable -> 0x0051, all -> 0x0047 }
        r1.setTransactionSuccessful();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0049, Throwable -> 0x0051, all -> 0x0047 }
        if (r1 == 0) goto L_0x0056;
    L_0x0046:
        goto L_0x0053;
    L_0x0047:
        r0 = move-exception;
        goto L_0x006c;
    L_0x0049:
        r0 = r1;
        goto L_0x0060;
    L_0x004b:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x006c;
    L_0x0050:
        r1 = r0;
    L_0x0051:
        if (r1 == 0) goto L_0x0056;
    L_0x0053:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0056 }
    L_0x0056:
        r0 = O00000o;
        r0 = defpackage.ak.O000000o(r0);
        r0.O00000Oo();
        goto L_0x006b;
    L_0x0060:
        r1 = O00000o;	 Catch:{ all -> 0x004b }
        defpackage.al.O000000o(r1);	 Catch:{ all -> 0x004b }
        if (r0 == 0) goto L_0x0056;
    L_0x0067:
        r0.endTransaction();	 Catch:{ Throwable -> 0x0056 }
        goto L_0x0056;
    L_0x006b:
        return;
    L_0x006c:
        if (r1 == 0) goto L_0x0071;
    L_0x006e:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0071 }
    L_0x0071:
        r1 = O00000o;
        r1 = defpackage.ak.O000000o(r1);
        r1.O00000Oo();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.am.O0000OOo():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0073 A:{SYNTHETIC, Splitter:B:24:0x0073} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0068 */
    /* JADX WARNING: Missing block: B:6:0x004f, code skipped:
            if (r0 != null) goto L_0x005a;
     */
    /* JADX WARNING: Missing block: B:11:0x0058, code skipped:
            if (r0 != null) goto L_0x005a;
     */
    /* JADX WARNING: Missing block: B:14:?, code skipped:
            r0.endTransaction();
     */
    /* JADX WARNING: Missing block: B:21:0x006d, code skipped:
            if (r0 == null) goto L_0x005d;
     */
    public void O0000Oo() {
        /*
        r5 = this;
        r0 = r5.O0000OoO;
        r0 = android.text.TextUtils.isEmpty(r0);
        r1 = 0;
        if (r0 != 0) goto L_0x0080;
    L_0x0009:
        r0 = O00000o;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0067, Throwable -> 0x0057, all -> 0x0052 }
        r0 = defpackage.ak.O000000o(r0);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0067, Throwable -> 0x0057, all -> 0x0052 }
        r0 = r0.O000000o();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0067, Throwable -> 0x0057, all -> 0x0052 }
        r0.beginTransaction();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0068, Throwable -> 0x0058 }
        r2 = new java.lang.StringBuilder;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0068, Throwable -> 0x0058 }
        r2.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0068, Throwable -> 0x0058 }
        r3 = "delete from __er where __i=\"";
        r2.append(r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0068, Throwable -> 0x0058 }
        r3 = r5.O0000OoO;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0068, Throwable -> 0x0058 }
        r2.append(r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0068, Throwable -> 0x0058 }
        r3 = "\"";
        r2.append(r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0068, Throwable -> 0x0058 }
        r2 = r2.toString();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0068, Throwable -> 0x0058 }
        r0.execSQL(r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0068, Throwable -> 0x0058 }
        r2 = new java.lang.StringBuilder;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0068, Throwable -> 0x0058 }
        r2.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0068, Throwable -> 0x0058 }
        r3 = "delete from __et where __i=\"";
        r2.append(r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0068, Throwable -> 0x0058 }
        r3 = r5.O0000OoO;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0068, Throwable -> 0x0058 }
        r2.append(r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0068, Throwable -> 0x0058 }
        r3 = "\"";
        r2.append(r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0068, Throwable -> 0x0058 }
        r2 = r2.toString();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0068, Throwable -> 0x0058 }
        r0.execSQL(r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0068, Throwable -> 0x0058 }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0068, Throwable -> 0x0058 }
        if (r0 == 0) goto L_0x005d;
    L_0x0051:
        goto L_0x005a;
    L_0x0052:
        r0 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x0071;
    L_0x0057:
        r0 = r1;
    L_0x0058:
        if (r0 == 0) goto L_0x005d;
    L_0x005a:
        r0.endTransaction();	 Catch:{ Throwable -> 0x005d }
    L_0x005d:
        r0 = O00000o;
        r0 = defpackage.ak.O000000o(r0);
        r0.O00000Oo();
        goto L_0x0080;
    L_0x0067:
        r0 = r1;
    L_0x0068:
        r2 = O00000o;	 Catch:{ all -> 0x0070 }
        defpackage.al.O000000o(r2);	 Catch:{ all -> 0x0070 }
        if (r0 == 0) goto L_0x005d;
    L_0x006f:
        goto L_0x005a;
    L_0x0070:
        r1 = move-exception;
    L_0x0071:
        if (r0 == 0) goto L_0x0076;
    L_0x0073:
        r0.endTransaction();	 Catch:{ Throwable -> 0x0076 }
    L_0x0076:
        r0 = O00000o;
        r0 = defpackage.ak.O000000o(r0);
        r0.O00000Oo();
        throw r1;
    L_0x0080:
        r5.O0000OoO = r1;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.am.O0000Oo():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0040 A:{SYNTHETIC, Splitter:B:26:0x0040} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0039 A:{SYNTHETIC, Splitter:B:22:0x0039} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0032 */
    /* JADX WARNING: Missing block: B:5:0x0016, code skipped:
            if (r1 != null) goto L_0x0025;
     */
    /* JADX WARNING: Missing block: B:13:0x0023, code skipped:
            if (r1 != null) goto L_0x0025;
     */
    /* JADX WARNING: Missing block: B:16:?, code skipped:
            r1.endTransaction();
     */
    public void O0000Oo0() {
        /*
        r3 = this;
        r0 = 0;
        r1 = O00000o;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0032, Throwable -> 0x0022 }
        r1 = defpackage.ak.O000000o(r1);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0032, Throwable -> 0x0022 }
        r1 = r1.O000000o();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0032, Throwable -> 0x0022 }
        r1.beginTransaction();	 Catch:{ SQLiteDatabaseCorruptException -> 0x001e, Throwable -> 0x0023, all -> 0x0019 }
        r0 = "delete from __er";
        r1.execSQL(r0);	 Catch:{ SQLiteDatabaseCorruptException -> 0x001e, Throwable -> 0x0023, all -> 0x0019 }
        r1.setTransactionSuccessful();	 Catch:{ SQLiteDatabaseCorruptException -> 0x001e, Throwable -> 0x0023, all -> 0x0019 }
        if (r1 == 0) goto L_0x0028;
    L_0x0018:
        goto L_0x0025;
    L_0x0019:
        r0 = move-exception;
        r2 = r1;
        r1 = r0;
        r0 = r2;
        goto L_0x003e;
    L_0x001e:
        r0 = r1;
        goto L_0x0032;
    L_0x0020:
        r1 = move-exception;
        goto L_0x003e;
    L_0x0022:
        r1 = r0;
    L_0x0023:
        if (r1 == 0) goto L_0x0028;
    L_0x0025:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0028 }
    L_0x0028:
        r0 = O00000o;
        r0 = defpackage.ak.O000000o(r0);
        r0.O00000Oo();
        goto L_0x003d;
    L_0x0032:
        r1 = O00000o;	 Catch:{ all -> 0x0020 }
        defpackage.al.O000000o(r1);	 Catch:{ all -> 0x0020 }
        if (r0 == 0) goto L_0x0028;
    L_0x0039:
        r0.endTransaction();	 Catch:{ Throwable -> 0x0028 }
        goto L_0x0028;
    L_0x003d:
        return;
    L_0x003e:
        if (r0 == 0) goto L_0x0043;
    L_0x0040:
        r0.endTransaction();	 Catch:{ Throwable -> 0x0043 }
    L_0x0043:
        r0 = O00000o;
        r0 = defpackage.ak.O000000o(r0);
        r0.O00000Oo();
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.am.O0000Oo0():void");
    }
}
