package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import com.umeng.commonsdk.utils.UMUtils;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o0;
import defpackage.aq.O00000o0;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: UMProcessDBDatasSender */
/* renamed from: bh */
public class bh implements UMLogDataProtocol {
    public static final int O000000o = 36945;
    public static final int O00000Oo = 36946;
    private static bh O00000oo;
    private static ScheduledThreadPoolExecutor O0000O0o = new ScheduledThreadPoolExecutor(1);
    private Context O00000o;
    private FileLockUtil O00000o0 = new FileLockUtil();
    private O00000o0 O00000oO;
    private List<Integer> O0000OOo;

    /* compiled from: UMProcessDBDatasSender */
    /* renamed from: bh$1 */
    class 1 implements Runnable {
        1() {
        }

        public void run() {
            UMRTLog.i("MobclickRT", "--->>> call processDBToMain start.");
            bi.O000000o(bh.this.O00000o).O000000o();
        }
    }

    /* compiled from: UMProcessDBDatasSender */
    /* renamed from: bh$O000000o */
    private class O000000o implements FileLockCallback {
        private O000000o() {
        }

        /* synthetic */ O000000o(bh bhVar, 1 1) {
            this();
        }

        public boolean onFileLock(File file, int i) {
            return false;
        }

        public boolean onFileLock(String str) {
            JSONObject jSONObject = bh.this.setupReportData(UMEnvelopeBuild.maxDataSpace(bh.this.O00000o));
            if (jSONObject == null || jSONObject.length() < 1) {
                return true;
            }
            JSONObject jSONObject2 = (JSONObject) jSONObject.opt("header");
            jSONObject = (JSONObject) jSONObject.opt("content");
            if (!(bh.this.O00000o == null || jSONObject2 == null || jSONObject == null)) {
                jSONObject = UMEnvelopeBuild.buildEnvelopeWithExtHeader(bh.this.O00000o, jSONObject2, jSONObject);
                if (jSONObject != null) {
                    bh.this.removeCacheData(jSONObject);
                }
            }
            return true;
        }

        public boolean onFileLock(String str, Object obj) {
            return false;
        }
    }

    /* compiled from: UMProcessDBDatasSender */
    /* renamed from: bh$O00000Oo */
    private class O00000Oo implements FileLockCallback {
        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(bh bhVar, 1 1) {
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
            bi.O000000o(bh.this.O00000o).O000000o(str.replace(bj.O00000o, ""), null, null);
            return true;
        }

        public boolean onFileLock(String str, Object obj) {
            return false;
        }
    }

    private bh() {
    }

    public static bh O000000o(Context context) {
        if (O00000oo == null) {
            synchronized (bh.class) {
                if (O00000oo == null) {
                    O00000oo = new bh();
                }
            }
        }
        O00000oo.O00000o = context;
        return O00000oo;
    }

    private JSONObject O000000o() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!(u.O000000o == null || u.O00000Oo == null)) {
                jSONObject.put("wrapper_version", u.O00000Oo);
                jSONObject.put("wrapper_type", u.O000000o);
            }
            jSONObject.put(ah.O0000Oo0, u.O00000o(this.O00000o));
            jSONObject.put("sdk_version", bb.O000000o);
            CharSequence charSequence = "";
            CharSequence charSequence2 = "";
            if (this.O0000OOo.size() > 0) {
                JSONObject O000000o = bi.O000000o(this.O00000o).O000000o((Integer) this.O0000OOo.get(0));
                if (O000000o != null) {
                    charSequence = O000000o.optString("__av");
                    charSequence2 = O000000o.optString("__vc");
                }
            }
            if (TextUtils.isEmpty(charSequence)) {
                jSONObject.put("app_version", UMUtils.getAppVersionName(this.O00000o));
            } else {
                jSONObject.put("app_version", charSequence);
            }
            if (TextUtils.isEmpty(charSequence2)) {
                jSONObject.put("version_code", UMUtils.getAppVersionCode(this.O00000o));
            } else {
                jSONObject.put("version_code", charSequence2);
            }
            String MD5 = HelperUtils.MD5(u.O00000o0(this.O00000o));
            if (!TextUtils.isEmpty(MD5)) {
                jSONObject.put("secret", MD5);
            }
            MD5 = UMEnvelopeBuild.imprintProperty(this.O00000o, "pr_ve", null);
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(this.O00000o);
            jSONObject.put(ah.O0000Ooo, UMEnvelopeBuild.imprintProperty(this.O00000o, "pr_ve", null));
            jSONObject.put(ah.O0000o00, UMEnvelopeBuild.imprintProperty(this.O00000o, "ud_da", null));
            jSONObject.put(ah.O000o000, "1.0.0");
            if (TextUtils.isEmpty(MD5)) {
                jSONObject.put(ah.O0000Ooo, sharedPreferences.getString("vers_pre_version", "0"));
                jSONObject.put(ah.O0000o00, sharedPreferences.getString("vers_date", new SimpleDateFormat(O000O0o0.O0000Ooo, Locale.getDefault()).format(new Date(System.currentTimeMillis()))));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject O00000Oo() {
        try {
            if (this.O0000OOo == null) {
                this.O0000OOo = new ArrayList();
            }
            JSONObject O000000o = bi.O000000o(this.O00000o).O000000o(UMEnvelopeBuild.maxDataSpace(this.O00000o) - 2000, this.O0000OOo);
            try {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(this.O00000o);
                if (sharedPreferences != null) {
                    String string = sharedPreferences.getString("userlevel", "");
                    if (!TextUtils.isEmpty(string)) {
                        O000000o.put("userlevel", string);
                    }
                }
                String[] O000000o2 = aa.O000000o(this.O00000o);
                if (!(O000000o2 == null || TextUtils.isEmpty(O000000o2[0]) || TextUtils.isEmpty(O000000o2[1]))) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(ah.O000OO, O000000o2[0]);
                    jSONObject.put(ah.O000OOOo, O000000o2[1]);
                    if (jSONObject.length() > 0) {
                        O000000o.put(ah.O000OO0o, jSONObject);
                    }
                }
                if (!ABTest.getService(this.O00000o).isInTest()) {
                    return O000000o;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(ABTest.getService(this.O00000o).getTestName(), ABTest.getService(this.O00000o).getGroupInfo());
                O000000o.put(ah.O000OO00, jSONObject2);
                return O000000o;
            } catch (Throwable unused) {
                return O000000o;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    private int O00000o() {
        int O000000o = at.O000000o().O000000o(this.O00000o);
        if (O000000o != 0) {
            try {
                bg.O000000o(bk.O000000o(this.O00000o), new O00000Oo(this, null), null);
            } catch (Exception unused) {
            }
            bi.O000000o(this.O00000o).O000000o(bj.O0000OOo, null, null);
        }
        return O000000o;
    }

    private void O00000o0() {
        if (O00000o() == 0) {
            this.O00000o0.doFileOperateion(bk.O00000Oo(this.O00000o, ""), new O000000o(this, null));
        }
    }

    public void removeCacheData(Object obj) {
        if (obj != null && this.O0000OOo != null && this.O0000OOo.size() != 0) {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject.has("analytics")) {
                jSONObject = jSONObject.optJSONObject("analytics");
                if (jSONObject != null && jSONObject.length() > 0 && jSONObject.has(ah.O000Oo00)) {
                    bi.O000000o(this.O00000o).O000000o(this.O0000OOo);
                    this.O0000OOo.clear();
                }
            }
        }
    }

    public JSONObject setupReportData(long j) {
        int O000000o = at.O000000o().O000000o(this.O00000o);
        JSONObject O00000Oo = O00000Oo();
        if (O00000Oo.length() <= 0) {
            return null;
        }
        JSONObject O000000o2 = O000000o();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (O000000o == 3) {
                jSONObject2.put("analytics", new JSONObject());
            } else if (O00000Oo != null && O00000Oo.length() > 0) {
                jSONObject2.put("analytics", O00000Oo);
            }
            if (O000000o2 != null && O000000o2.length() > 0) {
                jSONObject.put("header", O000000o2);
            }
            if (jSONObject2.length() > 0) {
                if (jSONObject2.has("analytics")) {
                    JSONObject optJSONObject = jSONObject2.optJSONObject("analytics");
                    if (optJSONObject.length() == 1 && (optJSONObject.optJSONObject(ah.O000OO0o) != null || !TextUtils.isEmpty(optJSONObject.optString("userlevel")))) {
                        return null;
                    }
                    if (!(optJSONObject.length() != 2 || optJSONObject.optJSONObject(ah.O000OO0o) == null || TextUtils.isEmpty(optJSONObject.optString("userlevel")))) {
                        return null;
                    }
                }
                jSONObject.put("content", jSONObject2);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public void workEvent(Object obj, int i) {
        if (UMGlobalContext.getInstance().isMainProcess(this.O00000o)) {
            switch (i) {
                case O000000o /*36945*/:
                    O0000O0o.schedule(new 1(), 5, TimeUnit.SECONDS);
                    break;
                case O00000Oo /*36946*/:
                    UMRTLog.i("MobclickRT", "--->>> recv UM_PROCESS_CONSTRUCTMESSAGE msg.");
                    O00000o0();
                    break;
            }
        }
    }
}
