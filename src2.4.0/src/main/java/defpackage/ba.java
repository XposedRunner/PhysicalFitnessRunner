package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.proguard.e;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SessionIdManager */
/* renamed from: ba */
public class ba {
    private static volatile ba O00000o0;
    private ay O000000o = new az();
    private String O00000Oo;
    private List<O000000o> O00000o;
    private String O00000oO;

    /* compiled from: SessionIdManager */
    /* renamed from: ba$O000000o */
    public interface O000000o {
        void O000000o(String str, long j, long j2);

        void O000000o(String str, String str2, long j, long j2);
    }

    private ba() {
    }

    private long O000000o(Context context, String str) {
        long j;
        try {
            j = PreferenceWrapper.getDefault(context).getLong(str, 0);
        } catch (Exception unused) {
            j = 0;
        }
        return j <= 0 ? System.currentTimeMillis() : j;
    }

    public static ba O000000o() {
        if (O00000o0 == null) {
            synchronized (ba.class) {
                if (O00000o0 == null) {
                    O00000o0 = new ba();
                }
            }
        }
        return O00000o0;
    }

    private void O000000o(long j, long j2, String str, boolean z) {
        if (this.O00000o != null) {
            for (O000000o o000000o : this.O00000o) {
                if (z) {
                    try {
                        o000000o.O000000o(str, this.O00000Oo, j, j2);
                    } catch (Exception unused) {
                    }
                } else {
                    o000000o.O000000o(this.O00000Oo, j, j2);
                }
            }
        }
    }

    private String O00000oo(Context context) {
        try {
            Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putString(aw.O00000o, O00000o(context));
            edit.commit();
        } catch (Exception unused) {
        }
        long O0000OOo = O0000OOo(context);
        long O0000Oo0 = O0000Oo0(context);
        long j = O0000OOo;
        String str = this.O00000Oo;
        O000000o(O0000Oo0, j, str, false);
        this.O00000Oo = this.O000000o.O000000o(context);
        O000000o(O0000Oo0, j, str, true);
        this.O000000o.O000000o(context, this.O00000Oo);
        return this.O00000Oo;
    }

    private boolean O0000O0o(Context context) {
        return !TextUtils.isEmpty(this.O00000Oo) && am.O000000o(context).O000000o(this.O00000Oo) > 0;
    }

    private long O0000OOo(Context context) {
        return O000000o(context, aw.O00000oo);
    }

    private boolean O0000Oo(Context context) {
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(UMGlobalContext.getAppContext(context));
            long j = sharedPreferences.getLong(aw.O00000oO, 0);
            long j2 = sharedPreferences.getLong(aw.O00000oo, 0);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("--->>> interval of last session is: ");
            stringBuilder.append(j2 - j);
            UMRTLog.i("MobclickRT", stringBuilder.toString());
            return this.O000000o.O000000o(j, j2);
        } catch (Exception unused) {
            return false;
        }
    }

    private long O0000Oo0(Context context) {
        return O000000o(context, aw.O000000o);
    }

    public String O000000o(Context context) {
        String string;
        Throwable th;
        context = UMGlobalContext.getAppContext(context);
        if (context == null) {
            return "";
        }
        String str = "";
        try {
            synchronized (ba.class) {
                try {
                    string = PreferenceWrapper.getDefault(context).getString(aw.O00000o, "");
                    try {
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        str = string;
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    throw th;
                }
            }
        } catch (Exception unused) {
            string = str;
        }
        return string;
    }

    public String O000000o(Context context, long j) {
        if (TextUtils.isEmpty(this.O00000oO)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SUB");
            stringBuilder.append(j);
            String stringBuilder2 = stringBuilder.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(stringBuilder2);
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("%0");
            stringBuilder4.append(32 - stringBuilder2.length());
            stringBuilder4.append(e.am);
            stringBuilder3.append(String.format(stringBuilder4.toString(), new Object[]{Integer.valueOf(0)}));
            this.O00000oO = stringBuilder3.toString();
        }
        return this.O00000oO;
    }

    public void O000000o(long j) {
        this.O000000o.O000000o(j);
    }

    public void O000000o(O000000o o000000o) {
        if (o000000o != null) {
            if (this.O00000o == null) {
                this.O00000o = new ArrayList();
            }
            if (!this.O00000o.contains(o000000o)) {
                this.O00000o.add(o000000o);
            }
        }
    }

    public long O00000Oo() {
        return this.O000000o.O000000o();
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x001d */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:7|8|(2:10|11)|12|13|14|15) */
    public synchronized java.lang.String O00000Oo(android.content.Context r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        r2 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext(r2);	 Catch:{ all -> 0x0021 }
        if (r2 != 0) goto L_0x000b;
    L_0x0007:
        r2 = "";
        monitor-exit(r1);
        return r2;
    L_0x000b:
        r0 = r1.O00000o(r2);	 Catch:{ all -> 0x0021 }
        r1.O00000Oo = r0;	 Catch:{ all -> 0x0021 }
        r0 = r1.O00000oO(r2);	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x001d;
    L_0x0017:
        r2 = r1.O00000oo(r2);	 Catch:{ Exception -> 0x001d }
        r1.O00000Oo = r2;	 Catch:{ Exception -> 0x001d }
    L_0x001d:
        r2 = r1.O00000Oo;	 Catch:{ all -> 0x0021 }
        monitor-exit(r1);
        return r2;
    L_0x0021:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ba.O00000Oo(android.content.Context):java.lang.String");
    }

    public void O00000Oo(O000000o o000000o) {
        if (o000000o != null && this.O00000o != null && this.O00000o.size() != 0) {
            this.O00000o.remove(o000000o);
        }
    }

    public String O00000o(Context context) {
        if (TextUtils.isEmpty(this.O00000Oo)) {
            try {
                this.O00000Oo = PreferenceWrapper.getDefault(context).getString(aw.O00000o0, null);
            } catch (Exception unused) {
            }
        }
        return this.O00000Oo;
    }

    public String O00000o0(Context context) {
        context = UMGlobalContext.getAppContext(context);
        if (context == null) {
            return "";
        }
        try {
            this.O00000Oo = O00000oo(context);
        } catch (Exception unused) {
        }
        return this.O00000Oo;
    }

    public boolean O00000oO(Context context) {
        if (TextUtils.isEmpty(this.O00000Oo)) {
            this.O00000Oo = O00000o(context);
        }
        return TextUtils.isEmpty(this.O00000Oo) || O0000Oo(context) || O0000O0o(context);
    }
}
