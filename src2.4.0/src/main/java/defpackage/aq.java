package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ReportPolicy;
import com.umeng.commonsdk.statistics.common.ReportPolicy.DebugPolicy;
import com.umeng.commonsdk.statistics.common.ReportPolicy.DefconPolicy;
import com.umeng.commonsdk.statistics.common.ReportPolicy.ReportAtLaunch;
import com.umeng.commonsdk.statistics.common.ReportPolicy.ReportByInterval;
import com.umeng.commonsdk.statistics.common.ReportPolicy.ReportDaily;
import com.umeng.commonsdk.statistics.common.ReportPolicy.ReportQuasiRealtime;
import com.umeng.commonsdk.statistics.common.ReportPolicy.ReportRealtime;
import com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy;
import com.umeng.commonsdk.statistics.common.ReportPolicy.ReportWifiOnly;
import com.umeng.commonsdk.statistics.common.ReportPolicy.SmartPolicy;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.utils.UMUtils;
import com.ximalaya.ting.android.opensdk.auth.constants.XmlyConstants.ClientOSType;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o0;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: CoreProtocolImpl */
/* renamed from: aq */
public class aq {
    private static Context O000000o = null;
    private static final String O0000Ooo = "first_activate_time";
    private static final String O0000o = "gkvc";
    private static final String O0000o0 = "thtstart";
    private static final String O0000o00 = "ana_is_f";
    private static final String O0000o0O = "dstk_last_time";
    private static final String O0000o0o = "dstk_cnt";
    private static final String O0000oO0 = "ekvc";
    private static final String O0000oOO = "-1";
    private O00000o0 O00000Oo;
    private String O00000o;
    private SharedPreferences O00000o0;
    private String O00000oO;
    private int O00000oo;
    private JSONArray O0000O0o;
    private final int O0000OOo;
    private int O0000Oo;
    private int O0000Oo0;
    private long O0000OoO;
    private final long O0000oO;
    private boolean O0000oOo;
    private Object O0000oo;
    private boolean O0000oo0;

    /* compiled from: CoreProtocolImpl */
    /* renamed from: aq$O000000o */
    public static class O000000o {
        public static final int O000000o = 4097;
        public static final int O00000Oo = 4098;
        public static final int O00000o = 4100;
        public static final int O00000o0 = 4099;
        public static final int O00000oO = 4101;
        public static final int O00000oo = 4102;
        public static final int O0000O0o = 4103;
        public static final int O0000OOo = 4104;
        public static final int O0000Oo = 4106;
        public static final int O0000Oo0 = 4105;
        public static final int O0000OoO = 4352;
        public static final int O0000Ooo = 4353;
        public static final int O0000o = 8196;
        public static final int O0000o0 = 8193;
        public static final int O0000o00 = 4354;
        public static final int O0000o0O = 8194;
        public static final int O0000o0o = 8195;
        public static final int O0000oO = 8198;
        public static final int O0000oO0 = 8197;
        public static final int O0000oOO = 8199;
        public static final int O0000oOo = 8200;
        public static final int O0000oo = 8202;
        public static final int O0000oo0 = 8201;
    }

    /* compiled from: CoreProtocolImpl */
    /* renamed from: aq$O00000Oo */
    private static class O00000Oo {
        private static final aq O000000o = new aq();

        private O00000Oo() {
        }
    }

    /* compiled from: CoreProtocolImpl */
    /* renamed from: aq$O00000o0 */
    public static class O00000o0 {
        private ReportStrategy O000000o;
        private int O00000Oo;
        private int O00000o;
        private int O00000o0;
        private int O00000oO;
        private ABTest O00000oo;

        public O00000o0() {
            this.O000000o = null;
            this.O00000Oo = -1;
            this.O00000o0 = -1;
            this.O00000o = -1;
            this.O00000oO = -1;
            this.O00000oo = null;
            this.O00000oo = ABTest.getService(aq.O000000o);
        }

        private ReportStrategy O00000Oo(int i, int i2) {
            ReportStrategy reportStrategy;
            switch (i) {
                case 0:
                    return this.O000000o instanceof ReportRealtime ? this.O000000o : new ReportRealtime();
                case 1:
                    return this.O000000o instanceof ReportAtLaunch ? this.O000000o : new ReportAtLaunch();
                case 4:
                    return this.O000000o instanceof ReportDaily ? this.O000000o : new ReportDaily(StatTracer.getInstance(aq.O000000o));
                case 5:
                    return this.O000000o instanceof ReportWifiOnly ? this.O000000o : new ReportWifiOnly(aq.O000000o);
                case 6:
                    if (!(this.O000000o instanceof ReportByInterval)) {
                        return new ReportByInterval(StatTracer.getInstance(aq.O000000o), (long) i2);
                    }
                    reportStrategy = this.O000000o;
                    ((ReportByInterval) reportStrategy).setReportInterval((long) i2);
                    return reportStrategy;
                case 8:
                    return this.O000000o instanceof SmartPolicy ? this.O000000o : new SmartPolicy(StatTracer.getInstance(aq.O000000o));
                case 11:
                    if (this.O000000o instanceof ReportQuasiRealtime) {
                        reportStrategy = this.O000000o;
                        ((ReportQuasiRealtime) reportStrategy).setReportInterval((long) i2);
                        return reportStrategy;
                    }
                    ReportQuasiRealtime reportQuasiRealtime = new ReportQuasiRealtime();
                    reportQuasiRealtime.setReportInterval((long) i2);
                    return reportQuasiRealtime;
                default:
                    return this.O000000o instanceof ReportAtLaunch ? this.O000000o : new ReportAtLaunch();
            }
        }

        public int O000000o(int i) {
            int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(aq.O000000o, "test_report_interval", aq.O0000oOO)).intValue();
            return (intValue == -1 || intValue < 90 || intValue > 86400) ? i : intValue * 1000;
        }

        public void O000000o() {
            try {
                int[] O000000o = O000000o(-1, -1);
                this.O00000Oo = O000000o[0];
                this.O00000o0 = O000000o[1];
            } catch (Throwable unused) {
            }
        }

        public int[] O000000o(int i, int i2) {
            int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(aq.O000000o, "report_policy", aq.O0000oOO)).intValue();
            int intValue2 = Integer.valueOf(UMEnvelopeBuild.imprintProperty(aq.O000000o, "report_interval", aq.O0000oOO)).intValue();
            if (intValue == -1 || !ReportPolicy.isValid(intValue)) {
                return new int[]{i, i2};
            } else if (6 == intValue) {
                i = 90;
                if (intValue2 != -1 && intValue2 >= 90 && intValue2 <= 86400) {
                    i = intValue2;
                }
                return new int[]{intValue, i * 1000};
            } else if (11 == intValue) {
                i = 15;
                if (intValue2 != -1 && intValue2 >= 15 && intValue2 <= 3600) {
                    i = intValue2;
                }
                return new int[]{intValue, i * 1000};
            } else {
                return new int[]{i, i2};
            }
        }

        /* Access modifiers changed, original: protected */
        public void O00000Oo() {
            Defcon service = Defcon.getService(aq.O000000o);
            if (service.isOpen()) {
                int i = ((this.O000000o instanceof DefconPolicy) && this.O000000o.isValid()) ? 1 : 0;
                this.O000000o = i != 0 ? this.O000000o : new DefconPolicy(StatTracer.getInstance(aq.O000000o), service);
            } else {
                int i2 = Integer.valueOf(UMEnvelopeBuild.imprintProperty(aq.O000000o, "integrated_test", aq.O0000oOO)).intValue() == 1 ? 1 : 0;
                if (!(!UMConfigure.isDebugLog() || i2 == 0 || MLog.DEBUG)) {
                    UMLog.mutlInfo(an.O000OO00, 3, "\\|", null, null);
                }
                if (MLog.DEBUG && i2 != 0) {
                    this.O000000o = new DebugPolicy(StatTracer.getInstance(aq.O000000o));
                } else if (this.O00000oo.isInTest() && "RPT".equals(this.O00000oo.getTestName())) {
                    if (this.O00000oo.getTestPolicy() == 6) {
                        i2 = (Integer.valueOf(UMEnvelopeBuild.imprintProperty(aq.O000000o, "test_report_interval", aq.O0000oOO)).intValue() != -1 ? 1 : 0) != 0 ? O000000o(gf.O000OOOo) : this.O00000o0 > 0 ? this.O00000o0 : this.O00000oO;
                    } else {
                        i2 = 0;
                    }
                    this.O000000o = O00000Oo(this.O00000oo.getTestPolicy(), i2);
                } else {
                    i2 = this.O00000o;
                    int i3 = this.O00000oO;
                    if (this.O00000Oo != -1) {
                        i2 = this.O00000Oo;
                        i3 = this.O00000o0;
                    }
                    this.O000000o = O00000Oo(i2, i3);
                }
            }
            if (UMConfigure.isDebugLog()) {
                try {
                    String valueOf;
                    if (this.O000000o instanceof ReportAtLaunch) {
                        UMLog.mutlInfo(an.O000O0oO, 3, "", null, null);
                    } else if (this.O000000o instanceof ReportByInterval) {
                        valueOf = String.valueOf(((ReportByInterval) this.O000000o).getReportInterval() / 1000);
                        UMLog.mutlInfo(an.O000O0oo, 3, "", new String[]{"@"}, new String[]{valueOf});
                    } else if (this.O000000o instanceof DebugPolicy) {
                        UMLog.mutlInfo(an.O000OO0o, 3, "", null, null);
                    } else if (this.O000000o instanceof ReportQuasiRealtime) {
                        valueOf = String.valueOf(((ReportQuasiRealtime) this.O000000o).getReportInterval() / 1000);
                        String[] strArr = new String[]{"@"};
                        String[] strArr2 = new String[]{valueOf};
                        UMLog uMLog = UMConfigure.umDebugLog;
                        UMLog.mutlInfo(an.O000OO, 3, "", strArr, strArr2);
                    } else {
                        boolean z = this.O000000o instanceof DefconPolicy;
                    }
                } catch (Throwable unused) {
                }
            }
        }

        public ReportStrategy O00000o0() {
            O00000Oo();
            return this.O000000o;
        }
    }

    /* compiled from: CoreProtocolImpl */
    /* renamed from: aq$O00000o */
    public static class O00000o {
        private Map<String, Object> O000000o = null;
        private String O00000Oo = null;
        private long O00000o = 0;
        private String O00000o0 = null;

        private O00000o() {
        }

        public O00000o(String str, Map<String, Object> map, String str2, long j) {
            this.O000000o = map;
            this.O00000Oo = str;
            this.O00000o = j;
            this.O00000o0 = str2;
        }

        public Map<String, Object> O000000o() {
            return this.O000000o;
        }

        public String O00000Oo() {
            return this.O00000o0;
        }

        public long O00000o() {
            return this.O00000o;
        }

        public String O00000o0() {
            return this.O00000Oo;
        }
    }

    private aq() {
        this.O00000Oo = null;
        this.O00000o0 = null;
        this.O00000o = null;
        this.O00000oO = null;
        this.O00000oo = 10;
        this.O0000O0o = new JSONArray();
        this.O0000OOo = 5000;
        this.O0000Oo0 = 0;
        this.O0000Oo = 0;
        this.O0000OoO = 0;
        this.O0000oO = 28800000;
        this.O0000oOo = false;
        this.O0000oo0 = false;
        this.O0000oo = new Object();
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(O000000o);
            this.O0000OoO = sharedPreferences.getLong(O0000o0, 0);
            this.O0000Oo0 = sharedPreferences.getInt(O0000o, 0);
            this.O0000Oo = sharedPreferences.getInt(O0000oO0, 0);
            this.O00000Oo = new O00000o0();
        } catch (Throwable unused) {
        }
    }

    public static aq O000000o(Context context) {
        if (O000000o == null && context != null) {
            O000000o = context.getApplicationContext();
        }
        return O00000Oo.O000000o;
    }

    private JSONObject O000000o(JSONObject jSONObject, long j) {
        try {
            if (as.O000000o(jSONObject) <= j) {
                return jSONObject;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("header");
            jSONObject2.put(ah.O000oOOO, as.O000000o(jSONObject));
            jSONObject.put("header", jSONObject2);
            return as.O000000o(O000000o, j, jSONObject);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    private void O000000o(JSONObject jSONObject) {
        if (!am.O000000o(UMGlobalContext.getAppContext(O000000o)).O00000o0()) {
            JSONObject O00000oo = am.O000000o(UMGlobalContext.getAppContext(O000000o)).O00000oo();
            if (O00000oo != null) {
                String optString = O00000oo.optString("__av");
                String optString2 = O00000oo.optString("__vc");
                try {
                    if (TextUtils.isEmpty(optString)) {
                        jSONObject.put("app_version", UMUtils.getAppVersionName(O000000o));
                    } else {
                        jSONObject.put("app_version", optString);
                    }
                    if (TextUtils.isEmpty(optString2)) {
                        jSONObject.put("version_code", UMUtils.getAppVersionCode(O000000o));
                    } else {
                        jSONObject.put("version_code", optString2);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    private boolean O000000o(long j, int i) {
        if (j == 0) {
            return true;
        }
        if (System.currentTimeMillis() - j <= 28800000) {
            return i < 5000;
        } else {
            O0000o0o();
            return true;
        }
    }

    private JSONObject O00000Oo(JSONObject jSONObject, long j) {
        try {
            if (as.O000000o(jSONObject) <= j) {
                return jSONObject;
            }
            am.O000000o(O000000o).O000000o(true, false);
            am.O000000o(O000000o).O00000Oo();
            UMRTLog.i("MobclickRT", "--->>> Instant session packet overload !!! ");
            return null;
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    private void O00000Oo(JSONObject jSONObject) {
        if (am.O000000o(O000000o).O00000oO()) {
            jSONObject.put("app_version", UMUtils.getAppVersionName(O000000o));
            jSONObject.put("version_code", UMUtils.getAppVersionCode(O000000o));
            return;
        }
        JSONObject O0000O0o = am.O000000o(O000000o).O0000O0o();
        if (O0000O0o != null) {
            String optString = O0000O0o.optString("__av");
            String optString2 = O0000O0o.optString("__vc");
            try {
                if (TextUtils.isEmpty(optString)) {
                    jSONObject.put("app_version", UMUtils.getAppVersionName(O000000o));
                } else {
                    jSONObject.put("app_version", optString);
                }
                if (TextUtils.isEmpty(optString2)) {
                    jSONObject.put("version_code", UMUtils.getAppVersionCode(O000000o));
                } else {
                    jSONObject.put("version_code", optString2);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void O00000o(JSONObject jSONObject) {
        try {
            if (jSONObject.getJSONObject("header").has(ah.O000oOOO)) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has("analytics")) {
                    jSONObject = jSONObject.getJSONObject("analytics");
                    if (jSONObject.has(ah.O0000o0)) {
                        jSONObject = jSONObject.getJSONArray(ah.O0000o0).optJSONObject(0);
                        if (jSONObject != null) {
                            String optString = jSONObject.optString("id");
                            if (!TextUtils.isEmpty(optString)) {
                                UMRTLog.i("MobclickRT", "--->>> removeAllInstantData: really delete instant session data");
                                am.O000000o(O000000o).O00000Oo(optString);
                            }
                        }
                    }
                }
                am.O000000o(O000000o).O00000Oo();
                UMRTLog.i("MobclickRT", "--->>> removeAllInstantData: send INSTANT_SESSION_START_CONTINUE event because OVERSIZE.");
                UMWorkDispatch.sendEvent(O000000o, O000000o.O0000Ooo, v.O000000o(O000000o), null);
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has("analytics")) {
                jSONObject = jSONObject.optJSONObject("analytics");
                if (jSONObject != null && jSONObject.length() > 0 && jSONObject.has(ah.O0000o0)) {
                    am.O000000o(O000000o).O000000o(true, false);
                }
            }
            am.O000000o(O000000o).O00000Oo();
        } catch (Exception unused) {
        }
    }

    private boolean O00000o(boolean z) {
        if (this.O00000Oo == null) {
            this.O00000Oo = new O00000o0();
        }
        ReportStrategy O00000o0 = this.O00000Oo.O00000o0();
        return O00000o0 instanceof DefconPolicy ? z ? ((DefconPolicy) O00000o0).shouldSendMessageByInstant() : O00000o0.shouldSendMessage(false) : true;
    }

    private void O00000o0(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() > 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    if (jSONObject.has("analytics")) {
                        JSONObject jSONObject3 = jSONObject.getJSONObject("analytics");
                        if (jSONObject3.has(ah.O000Oo00)) {
                            jSONObject2.put(ah.O000Oo00, jSONObject3.getJSONArray(ah.O000Oo00));
                        }
                        if (jSONObject3.has(ah.O000Oo0)) {
                            jSONObject2.put(ah.O000Oo0, jSONObject3.getJSONArray(ah.O000Oo0));
                        }
                        if (jSONObject3.has("error")) {
                            jSONObject2.put("error", jSONObject3.getJSONArray("error"));
                        }
                        if (jSONObject3.has(ah.O0000o0)) {
                            JSONArray jSONArray = jSONObject3.getJSONArray(ah.O0000o0);
                            JSONArray jSONArray2 = new JSONArray();
                            for (int i = 0; i < jSONArray.length(); i++) {
                                JSONObject jSONObject4 = jSONArray.getJSONObject(i);
                                if (jSONObject4 != null && jSONObject4.length() > 0) {
                                    if (jSONObject4.has(ah.O0000oOO)) {
                                        jSONObject4.remove(ah.O0000oOO);
                                    }
                                    jSONArray2.put(jSONObject4);
                                }
                            }
                            jSONObject2.put(ah.O0000o0, jSONArray2);
                        }
                        if (jSONObject3.has(ah.O000O0oO)) {
                            jSONObject2.put(ah.O000O0oO, jSONObject3.getJSONObject(ah.O000O0oO));
                        }
                        if (jSONObject3.has(ah.O000OO0o)) {
                            jSONObject2.put(ah.O000OO0o, jSONObject3.getJSONObject(ah.O000OO0o));
                        }
                    }
                    if (jSONObject.has("dplus")) {
                        jSONObject2.put("dplus", jSONObject.getJSONObject("dplus"));
                    }
                    if (jSONObject.has("header") && jSONObject.has("header")) {
                        jSONObject = jSONObject.getJSONObject("header");
                        if (jSONObject != null && jSONObject.length() > 0) {
                            if (jSONObject.has("sdk_version")) {
                                jSONObject2.put("sdk_version", jSONObject.getString("sdk_version"));
                            }
                            if (jSONObject.has("device_id")) {
                                jSONObject2.put("device_id", jSONObject.getString("device_id"));
                            }
                            if (jSONObject.has("device_model")) {
                                jSONObject2.put("device_model", jSONObject.getString("device_model"));
                            }
                            if (jSONObject.has("version_code")) {
                                jSONObject2.put("version", jSONObject.getInt("version_code"));
                            }
                            if (jSONObject.has("appkey")) {
                                jSONObject2.put("appkey", jSONObject.getString("appkey"));
                            }
                            if (jSONObject.has("channel")) {
                                jSONObject2.put("channel", jSONObject.getString("channel"));
                            }
                        }
                    }
                    if (jSONObject2.length() > 0) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("constructMessage:");
                        stringBuilder.append(jSONObject2.toString());
                        MLog.d(stringBuilder.toString());
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("constructMessage: ");
                        stringBuilder2.append(jSONObject2.toString());
                        UMRTLog.i("MobclickRT", stringBuilder2.toString());
                    }
                }
            } catch (Throwable th) {
                MLog.e(th);
            }
        }
    }

    private boolean O00000o0(boolean z) {
        if (O0000oOO()) {
            return true;
        }
        if (this.O00000Oo == null) {
            this.O00000Oo = new O00000o0();
        }
        this.O00000Oo.O000000o();
        ReportStrategy O00000o0 = this.O00000Oo.O00000o0();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Report policy : ");
        stringBuilder.append(O00000o0.getClass().getSimpleName());
        MLog.d(stringBuilder.toString());
        z = O00000o0.shouldSendMessage(z);
        if (z) {
            if (((O00000o0 instanceof ReportByInterval) || (O00000o0 instanceof DebugPolicy) || (O00000o0 instanceof ReportQuasiRealtime)) && O0000o()) {
                O00000o();
            }
            if ((O00000o0 instanceof DefconPolicy) && O0000o()) {
                O00000o();
            }
        }
        return z;
    }

    private void O00000oO(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (am.O00000Oo == jSONObject.getInt("__t")) {
                if (O000000o(this.O0000OoO, this.O0000Oo0)) {
                    this.O0000Oo0++;
                } else {
                    return;
                }
            } else if (am.O000000o == jSONObject.getInt("__t")) {
                if (O000000o(this.O0000OoO, this.O0000Oo)) {
                    this.O0000Oo++;
                } else {
                    return;
                }
            }
            if (this.O0000O0o.length() >= this.O00000oo) {
                am.O000000o(O000000o).O000000o(this.O0000O0o);
                this.O0000O0o = new JSONArray();
            }
            if (this.O0000OoO == 0) {
                this.O0000OoO = System.currentTimeMillis();
            }
            this.O0000O0o.put(jSONObject);
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    private void O00000oO(JSONObject jSONObject) {
        try {
            if (jSONObject.getJSONObject("header").has(ah.O000oOOO)) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (!jSONObject.has("analytics")) {
                    return;
                }
                if (jSONObject.getJSONObject("analytics").has(ah.O0000o0)) {
                    am.O000000o(O000000o).O0000Oo0();
                    am.O000000o(O000000o).O0000OOo();
                    am.O000000o(O000000o).O00000Oo(true, false);
                    am.O000000o(O000000o).O000000o();
                    return;
                }
                UMRTLog.i("MobclickRT", "--->>> Error, Should not go to this branch.");
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has("analytics")) {
                jSONObject = jSONObject.optJSONObject("analytics");
                if (jSONObject != null && jSONObject.length() > 0) {
                    if (jSONObject.has(ah.O0000o0)) {
                        am.O000000o(O000000o).O00000Oo(true, false);
                    }
                    if (jSONObject.has(ah.O000Oo00) || jSONObject.has(ah.O000Oo0)) {
                        am.O000000o(O000000o).O0000OOo();
                    }
                    if (jSONObject.has("error")) {
                        am.O000000o(O000000o).O0000Oo0();
                    }
                }
            }
            am.O000000o(O000000o).O000000o();
        } catch (Exception unused) {
        }
    }

    private void O00000oo(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null) {
                if (jSONObject.length() > 0) {
                    long j = jSONObject.getLong("ts");
                    O00000Oo(O000000o);
                    O00000o();
                    String[] O000000o = aa.O000000o(O000000o);
                    if (!(O000000o == null || TextUtils.isEmpty(O000000o[0]) || TextUtils.isEmpty(O000000o[1]))) {
                        aw.O000000o().O000000o(O000000o, j);
                        String O00000o0 = ba.O000000o().O00000o0(O000000o);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("--->>> onProfileSignIn: force generate new session: session id = ");
                        stringBuilder.append(O00000o0);
                        UMRTLog.i("MobclickRT", stringBuilder.toString());
                        boolean O00000Oo = aw.O000000o().O00000Oo(O000000o, j);
                        aa.O00000Oo(O000000o);
                        aw.O000000o().O000000o(O000000o, j, true);
                        if (O00000Oo) {
                            aw.O000000o().O00000o0(O000000o, j);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignOff", th);
            }
        }
    }

    private void O0000O0o(Object obj) {
        try {
            O00000Oo(O000000o);
            O00000o();
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null) {
                if (jSONObject.length() > 0) {
                    String string = jSONObject.getString(ah.O000OO);
                    String string2 = jSONObject.getString("uid");
                    long j = jSONObject.getLong("ts");
                    String[] O000000o = aa.O000000o(O000000o);
                    if (!(O000000o != null && string.equals(O000000o[0]) && string2.equals(O000000o[1]))) {
                        aw.O000000o().O000000o(O000000o, j);
                        String O00000o0 = ba.O000000o().O00000o0(O000000o);
                        boolean O00000Oo = aw.O000000o().O00000Oo(O000000o, j);
                        aa.O000000o(O000000o, string, string2);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("--->>> onProfileSignIn: force generate new session: session id = ");
                        stringBuilder.append(O00000o0);
                        UMRTLog.i("MobclickRT", stringBuilder.toString());
                        aw.O000000o().O000000o(O000000o, j, true);
                        if (O00000Oo) {
                            aw.O000000o().O00000o0(O000000o, j);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void O0000OOo() {
        try {
            Class.forName("com.umeng.analytics.vismode.event.VisualHelper").getMethod("loadNativeData", new Class[]{Context.class}).invoke(null, new Object[]{O000000o});
        } catch (Exception unused) {
        }
    }

    private void O0000OOo(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0 && jSONObject.has("__ii")) {
                String optString = jSONObject.optString("__ii");
                jSONObject.remove("__ii");
                if (!TextUtils.isEmpty(optString)) {
                    am.O000000o(O000000o).O000000o(optString, obj.toString(), 2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void O0000Oo() {
        JSONObject O00000Oo = O00000Oo(UMEnvelopeBuild.maxDataSpace(O000000o));
        if (O00000Oo != null && O00000Oo.length() >= 1) {
            JSONObject jSONObject = (JSONObject) O00000Oo.opt("header");
            O00000Oo = (JSONObject) O00000Oo.opt("content");
            if (!(O000000o == null || jSONObject == null || O00000Oo == null)) {
                UMRTLog.i("MobclickRT", "--->>> constructInstantMessage: request build envelope.");
                Object buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(O000000o, jSONObject, O00000Oo);
                if (buildEnvelopeWithExtHeader != null) {
                    try {
                        if (buildEnvelopeWithExtHeader.has(ah.O000oOOo)) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Build envelope error code: ");
                            stringBuilder.append(buildEnvelopeWithExtHeader.getInt(ah.O000oOOo));
                            UMRTLog.i("MobclickRT", stringBuilder.toString());
                        }
                    } catch (Throwable unused) {
                    }
                    O00000Oo(buildEnvelopeWithExtHeader);
                }
            }
        }
    }

    private void O0000Oo0() {
        try {
            Class.forName("com.umeng.analytics.vismode.event.VisualHelper").getMethod("processCommond", new Class[]{Context.class, String.class}).invoke(null, new Object[]{O000000o, u.O000000o(O000000o)});
        } catch (Exception unused) {
        }
    }

    private void O0000OoO() {
        JSONObject O000000o = O000000o(UMEnvelopeBuild.maxDataSpace(O000000o));
        if (O000000o != null && O000000o.length() >= 1) {
            JSONObject jSONObject = (JSONObject) O000000o.opt("header");
            O000000o = (JSONObject) O000000o.opt("content");
            if (!(O000000o == null || jSONObject == null || O000000o == null)) {
                Object buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(O000000o, jSONObject, O000000o);
                if (buildEnvelopeWithExtHeader != null) {
                    try {
                        if (buildEnvelopeWithExtHeader.has(ah.O000oOOo)) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Build envelope error code: ");
                            stringBuilder.append(buildEnvelopeWithExtHeader.getInt(ah.O000oOOo));
                            UMRTLog.i("MobclickRT", stringBuilder.toString());
                        }
                    } catch (Throwable unused) {
                    }
                    O00000o0((JSONObject) buildEnvelopeWithExtHeader);
                    O000000o(buildEnvelopeWithExtHeader);
                }
            }
        }
    }

    private JSONObject O0000Ooo() {
        JSONObject O0000o00 = O0000o00();
        if (O0000o00 != null) {
            try {
                O0000o00.put("st", ClientOSType.IOS);
            } catch (Throwable unused) {
            }
        }
        return O0000o00;
    }

    private boolean O0000o() {
        try {
            if (!TextUtils.isEmpty(aw.O000000o().O00000Oo())) {
                O00000Oo(O000000o);
            }
            if (this.O0000O0o.length() <= 0) {
                return false;
            }
            for (int i = 0; i < this.O0000O0o.length(); i++) {
                JSONObject optJSONObject = this.O0000O0o.optJSONObject(i);
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    String optString = optJSONObject.optString("__i");
                    if (TextUtils.isEmpty(optString) || O0000oOO.equals(optString)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable unused) {
        }
    }

    private String O0000o0() {
        String str = null;
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(O000000o, "pr_ve", null);
            try {
                if (TextUtils.isEmpty(imprintProperty)) {
                    if (!TextUtils.isEmpty(this.O00000o)) {
                        return this.O00000o;
                    }
                    if (this.O00000o0 == null) {
                        this.O00000o0 = PreferenceWrapper.getDefault(O000000o);
                    }
                    str = this.O00000o0.getString("pre_version", "");
                    String appVersionName = DeviceConfig.getAppVersionName(O000000o);
                    if (TextUtils.isEmpty(str)) {
                        this.O00000o0.edit().putString("pre_version", "0").putString("cur_version", appVersionName).commit();
                        str = "0";
                    } else {
                        String string = this.O00000o0.getString("cur_version", "");
                        if (!appVersionName.equals(string)) {
                            this.O00000o0.edit().putString("pre_version", string).putString("cur_version", appVersionName).commit();
                            str = string;
                        }
                    }
                    this.O00000o = str;
                    return str;
                }
            } catch (Throwable unused) {
            }
            str = imprintProperty;
        } catch (Throwable unused2) {
        }
        this.O00000o = str;
        return str;
    }

    private JSONObject O0000o00() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!(u.O000000o == null || u.O00000Oo == null)) {
                jSONObject.put("wrapper_version", u.O00000Oo);
                jSONObject.put("wrapper_type", u.O000000o);
            }
            jSONObject.put(ah.O0000Oo0, u.O00000o(O000000o));
            jSONObject.put("sdk_version", bb.O000000o);
            String MD5 = HelperUtils.MD5(u.O00000o0(O000000o));
            if (!TextUtils.isEmpty(MD5)) {
                jSONObject.put("secret", MD5);
            }
            MD5 = UMEnvelopeBuild.imprintProperty(O000000o, "pr_ve", null);
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(O000000o);
            String imprintProperty = UMEnvelopeBuild.imprintProperty(O000000o, ah.O000o0O, "");
            if (!TextUtils.isEmpty(imprintProperty)) {
                if (u.O0000Oo0) {
                    jSONObject.put(ah.O000o0Oo, "");
                } else {
                    jSONObject.put(ah.O000o0Oo, imprintProperty);
                }
            }
            imprintProperty = UMEnvelopeBuild.imprintProperty(O000000o, ah.O000o0OO, "");
            if (!TextUtils.isEmpty(imprintProperty)) {
                if (u.O0000Oo) {
                    jSONObject.put(ah.O000o0o0, "");
                } else {
                    jSONObject.put(ah.O000o0o0, imprintProperty);
                }
            }
            jSONObject.put(ah.O000o000, "1.0.0");
            if (O0000oOO()) {
                jSONObject.put(ah.O000o00O, ClientOSType.IOS);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putLong(O0000o00, 0).commit();
                }
            }
            jSONObject.put(ah.O0000Ooo, O0000o0());
            jSONObject.put(ah.O0000o00, O0000o0O());
            if (sharedPreferences != null) {
                imprintProperty = sharedPreferences.getString("vers_name", "");
                if (!TextUtils.isEmpty(imprintProperty)) {
                    String format = new SimpleDateFormat(O000O0o0.O0000Ooo, Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    if (TextUtils.isEmpty(MD5)) {
                        jSONObject.put(ah.O0000Ooo, sharedPreferences.getString("vers_pre_version", "0"));
                        jSONObject.put(ah.O0000o00, sharedPreferences.getString("vers_date", format));
                    }
                    sharedPreferences.edit().putString("pre_version", imprintProperty).putString("cur_version", DeviceConfig.getAppVersionName(O000000o)).putString("pre_date", format).remove("vers_name").remove("vers_code").remove("vers_date").remove("vers_pre_version").commit();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    private String O0000o0O() {
        String str = null;
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(O000000o, "ud_da", null);
            try {
                if (TextUtils.isEmpty(imprintProperty)) {
                    if (!TextUtils.isEmpty(this.O00000oO)) {
                        return this.O00000oO;
                    }
                    if (this.O00000o0 == null) {
                        this.O00000o0 = PreferenceWrapper.getDefault(O000000o);
                    }
                    str = this.O00000o0.getString("pre_date", "");
                    if (TextUtils.isEmpty(str)) {
                        str = new SimpleDateFormat(O000O0o0.O0000Ooo, Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                        this.O00000o0.edit().putString("pre_date", str).commit();
                    } else {
                        String format = new SimpleDateFormat(O000O0o0.O0000Ooo, Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                        if (!str.equals(format)) {
                            this.O00000o0.edit().putString("pre_date", format).commit();
                            str = format;
                        }
                    }
                    this.O00000oO = str;
                    return str;
                }
            } catch (Throwable unused) {
            }
            str = imprintProperty;
        } catch (Throwable unused2) {
        }
        this.O00000oO = str;
        return str;
    }

    private void O0000o0o() {
        try {
            this.O0000Oo0 = 0;
            this.O0000Oo = 0;
            this.O0000OoO = System.currentTimeMillis();
            PreferenceWrapper.getDefault(O000000o).edit().putLong(O0000o0O, System.currentTimeMillis()).putInt(O0000o0o, 0).commit();
        } catch (Throwable unused) {
        }
    }

    private void O0000oO() {
        try {
            if (O0000oOO() && O000000o != null) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(O000000o);
                if (sharedPreferences != null && sharedPreferences.getLong(O0000Ooo, 0) == 0) {
                    sharedPreferences.edit().putLong(O0000Ooo, System.currentTimeMillis()).commit();
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void O0000oO0() {
        if (this.O0000O0o.length() > 0) {
            JSONArray jSONArray = new JSONArray();
            int i = 0;
            while (i < this.O0000O0o.length()) {
                try {
                    JSONObject jSONObject = this.O0000O0o.getJSONObject(i);
                    if (jSONObject == null || jSONObject.length() <= 0) {
                        jSONArray.put(jSONObject);
                        i++;
                    } else {
                        String optString = jSONObject.optString("__i");
                        if (TextUtils.isEmpty(optString) || O0000oOO.equals(optString)) {
                            Object O00000Oo = aw.O000000o().O00000Oo();
                            if (TextUtils.isEmpty(O00000Oo)) {
                                O00000Oo = O0000oOO;
                            }
                            jSONObject.put("__i", O00000Oo);
                        }
                        jSONArray.put(jSONObject);
                        i++;
                    }
                } catch (Throwable unused) {
                }
            }
            this.O0000O0o = jSONArray;
        }
    }

    private boolean O0000oOO() {
        try {
            if (O000000o != null) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(O000000o);
                if (!(sharedPreferences == null || sharedPreferences.getLong(O0000o00, -1) == 0)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public JSONObject O000000o(long j) {
        if (TextUtils.isEmpty(ba.O000000o().O00000o(O000000o))) {
            return null;
        }
        JSONObject O000000o;
        JSONObject O00000Oo = O00000Oo(false);
        int O000000o2 = at.O000000o().O000000o(O000000o);
        if (O00000Oo.length() <= 0) {
            if (O000000o2 != 3) {
                return null;
            }
        } else if (O00000Oo.length() == 1) {
            if (O00000Oo.optJSONObject(ah.O000OO0o) != null && O000000o2 != 3) {
                return null;
            }
            if (!(TextUtils.isEmpty(O00000Oo.optString("userlevel")) || O000000o2 == 3)) {
                return null;
            }
        } else if (!(O00000Oo.length() != 2 || O00000Oo.optJSONObject(ah.O000OO0o) == null || TextUtils.isEmpty(O00000Oo.optString("userlevel")) || O000000o2 == 3)) {
            return null;
        }
        JSONObject O0000o00 = O0000o00();
        if (O0000o00 != null) {
            O00000Oo(O0000o00);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (O000000o2 == 3) {
                jSONObject2.put("analytics", new JSONObject());
            } else if (O00000Oo != null && O00000Oo.length() > 0) {
                jSONObject2.put("analytics", O00000Oo);
            }
            if (O0000o00 != null && O0000o00.length() > 0) {
                jSONObject.put("header", O0000o00);
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put("content", jSONObject2);
            }
            O000000o = O000000o(jSONObject, j);
        } catch (Throwable unused) {
            O000000o = jSONObject;
        }
        return O000000o;
    }

    public void O000000o() {
        if (O000000o != null) {
            synchronized (this.O0000oo) {
                if (this.O0000oOo) {
                    UMRTLog.i("MobclickRT", "--->>> network is now available, rebuild instant session data packet.");
                    UMWorkDispatch.sendEvent(O000000o, O000000o.O0000Ooo, v.O000000o(O000000o), null);
                }
            }
            synchronized (this.O0000oo) {
                if (this.O0000oo0) {
                    UMWorkDispatch.sendEvent(O000000o, O000000o.O0000o00, v.O000000o(O000000o), null);
                }
            }
        }
    }

    public void O000000o(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() <= 0) {
                    return;
                }
                if (!jSONObject.has(ah.O000oOOo)) {
                    O00000oO(jSONObject);
                } else if (101 != jSONObject.getInt(ah.O000oOOo)) {
                    O00000oO(jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void O000000o(Object obj, int i) {
        switch (i) {
            case O000000o.O000000o /*4097*/:
                if (UMGlobalContext.getInstance().isMainProcess(O000000o)) {
                    if (obj != null) {
                        O00000oO(obj);
                    }
                    if (!O0000oOO.equals(((JSONObject) obj).optString("__i"))) {
                        O000000o(false);
                        return;
                    }
                    return;
                }
                bi.O000000o(O000000o).O000000o(UMFrUtils.getSubProcessName(O000000o), new JSONArray().put(obj));
                return;
            case O000000o.O00000Oo /*4098*/:
                if (obj != null) {
                    try {
                        O00000oO(obj);
                    } catch (Throwable unused) {
                        return;
                    }
                }
                if (!O0000oOO.equals(((JSONObject) obj).optString("__i"))) {
                    O000000o(false);
                    return;
                }
                return;
            case O000000o.O00000o0 /*4099*/:
                ax.O000000o(O000000o);
                return;
            case O000000o.O00000o /*4100*/:
                ap.O000000o(O000000o);
                return;
            case O000000o.O00000oO /*4101*/:
                UMRTLog.i("MobclickRT", "--->>> PROFILE_SIGNIN");
                O0000O0o(obj);
                return;
            case O000000o.O00000oo /*4102*/:
                UMRTLog.i("MobclickRT", "--->>> PROFILE_SIGNOFF");
                O00000oo(obj);
                return;
            case O000000o.O0000O0o /*4103*/:
                UMRTLog.i("MobclickRT", "--->>> START_SESSION");
                aw.O000000o().O000000o(O000000o, obj);
                synchronized (this.O0000oo) {
                    this.O0000oo0 = true;
                }
                return;
            case O000000o.O0000OOo /*4104*/:
                aw.O000000o().O00000o0(O000000o, obj);
                return;
            case O000000o.O0000Oo0 /*4105*/:
                O00000o();
                return;
            case O000000o.O0000Oo /*4106*/:
                O0000OOo(obj);
                return;
            default:
                switch (i) {
                    case O000000o.O0000OoO /*4352*/:
                        UMRTLog.i("MobclickRT", "--->>> INSTANT_SESSION_START");
                        aw.O000000o().O00000Oo(O000000o, obj);
                        synchronized (this.O0000oo) {
                            this.O0000oOo = true;
                        }
                        return;
                    case O000000o.O0000Ooo /*4353*/:
                        O000000o(obj, true);
                        return;
                    case O000000o.O0000o00 /*4354*/:
                        O00000o0();
                        return;
                    default:
                        switch (i) {
                            case O000000o.O0000o0o /*8195*/:
                                z.O000000o().O000000o(obj);
                                return;
                            case O000000o.O0000o /*8196*/:
                                z.O000000o().O0000o00();
                                return;
                            case O000000o.O0000oO0 /*8197*/:
                                z.O000000o().O0000OoO();
                                return;
                            case O000000o.O0000oO /*8198*/:
                                if (!TextUtils.isEmpty(aw.O000000o().O00000Oo())) {
                                    O0000Oo0();
                                    return;
                                }
                                return;
                            case O000000o.O0000oOO /*8199*/:
                            case O000000o.O0000oOo /*8200*/:
                                z.O000000o().O00000Oo(obj);
                                return;
                            case O000000o.O0000oo0 /*8201*/:
                                z.O000000o().O00000Oo(null);
                                return;
                            case O000000o.O0000oo /*8202*/:
                                O0000OOo();
                                return;
                            default:
                                return;
                        }
                }
        }
    }

    public void O000000o(Object obj, boolean z) {
        if (z) {
            if (O00000o(true)) {
                O0000Oo();
            }
        } else if (UMEnvelopeBuild.isOnline(O000000o) && O00000o(true)) {
            O0000Oo();
        }
    }

    public void O000000o(boolean z) {
        if (!O00000o0(z)) {
            return;
        }
        if (this.O00000Oo.O00000o0() instanceof ReportQuasiRealtime) {
            if (z) {
                if (UMEnvelopeBuild.isOnline(O000000o)) {
                    UMRTLog.i("MobclickRT", "--->>> send session start in policy ReportQuasiRealtime.");
                    O0000OoO();
                }
            } else if (UMEnvelopeBuild.isReadyBuild(O000000o, UMBusinessType.U_APP)) {
                UMRTLog.i("MobclickRT", "--->>> send normal data in policy ReportQuasiRealtime.");
                O0000OoO();
            }
        } else if (UMEnvelopeBuild.isReadyBuild(O000000o, UMBusinessType.U_APP)) {
            O0000OoO();
        }
    }

    public JSONObject O00000Oo(long j) {
        if (TextUtils.isEmpty(ba.O000000o().O00000o(UMGlobalContext.getAppContext(O000000o)))) {
            return null;
        }
        JSONObject O00000Oo = am.O000000o(UMGlobalContext.getAppContext(O000000o)).O00000Oo(false);
        String[] O000000o = aa.O000000o(O000000o);
        if (!(O000000o == null || TextUtils.isEmpty(O000000o[0]) || TextUtils.isEmpty(O000000o[1]))) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ah.O000OO, O000000o[0]);
                jSONObject.put(ah.O000OOOo, O000000o[1]);
                if (jSONObject.length() > 0) {
                    O00000Oo.put(ah.O000OO0o, jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
        int O000000o2 = at.O000000o().O000000o(O000000o);
        if (O00000Oo.length() == 1 && O00000Oo.optJSONObject(ah.O000OO0o) != null && O000000o2 != 3) {
            return null;
        }
        at.O000000o().O00000Oo(O00000Oo, O000000o);
        if (O00000Oo.length() <= 0 && O000000o2 != 3) {
            return null;
        }
        JSONObject jSONObject2;
        JSONObject O0000Ooo = O0000Ooo();
        if (O0000Ooo != null) {
            O000000o(O0000Ooo);
        }
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        if (O000000o2 == 3) {
            try {
                jSONObject4.put("analytics", new JSONObject());
            } catch (Throwable unused2) {
                jSONObject2 = jSONObject3;
            }
        } else if (O00000Oo != null && O00000Oo.length() > 0) {
            jSONObject4.put("analytics", O00000Oo);
        }
        if (O0000Ooo != null && O0000Ooo.length() > 0) {
            jSONObject3.put("header", O0000Ooo);
        }
        if (jSONObject4.length() > 0) {
            jSONObject3.put("content", jSONObject4);
        }
        jSONObject2 = O00000Oo(jSONObject3, j);
        return jSONObject2;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:5:0x000e, B:8:0x0016] */
    /* JADX WARNING: Missing block: B:46:0x0104, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:48:?, code skipped:
            com.umeng.commonsdk.statistics.common.MLog.e("merge pages error");
            r1.printStackTrace();
     */
    /* JADX WARNING: Missing block: B:80:?, code skipped:
            return r12;
     */
    public org.json.JSONObject O00000Oo(boolean r12) {
        /*
        r11 = this;
        r0 = 0;
        r1 = O000000o;	 Catch:{ Throwable -> 0x0196 }
        r1 = defpackage.am.O000000o(r1);	 Catch:{ Throwable -> 0x0196 }
        r12 = r1.O000000o(r12);	 Catch:{ Throwable -> 0x0196 }
        r0 = 0;
        if (r12 != 0) goto L_0x0016;
    L_0x000e:
        r1 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0197 }
        r1.<init>();	 Catch:{ Throwable -> 0x0197 }
        r12 = r1;
        goto L_0x010d;
    L_0x0016:
        r1 = "sessions";
        r1 = r12.has(r1);	 Catch:{ Exception -> 0x0104 }
        if (r1 == 0) goto L_0x010d;
    L_0x001e:
        r1 = "sessions";
        r1 = r12.getJSONArray(r1);	 Catch:{ Exception -> 0x0104 }
        r2 = new org.json.JSONArray;	 Catch:{ Exception -> 0x0104 }
        r2.<init>();	 Catch:{ Exception -> 0x0104 }
        r3 = r0;
    L_0x002a:
        r4 = r1.length();	 Catch:{ Exception -> 0x0104 }
        if (r3 >= r4) goto L_0x00fe;
    L_0x0030:
        r4 = r1.get(r3);	 Catch:{ Exception -> 0x0104 }
        r4 = (org.json.JSONObject) r4;	 Catch:{ Exception -> 0x0104 }
        r5 = "pages";
        r5 = r4.optJSONArray(r5);	 Catch:{ Exception -> 0x0104 }
        r6 = "autopages";
        r6 = r4.optJSONArray(r6);	 Catch:{ Exception -> 0x0104 }
        if (r5 != 0) goto L_0x0050;
    L_0x0044:
        if (r6 == 0) goto L_0x0050;
    L_0x0046:
        r7 = "pages";
        r4.put(r7, r6);	 Catch:{ Exception -> 0x0104 }
        r7 = "autopages";
        r4.remove(r7);	 Catch:{ Exception -> 0x0104 }
    L_0x0050:
        if (r5 == 0) goto L_0x00af;
    L_0x0052:
        if (r6 == 0) goto L_0x00af;
    L_0x0054:
        r7 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0104 }
        r7.<init>();	 Catch:{ Exception -> 0x0104 }
        r8 = r0;
    L_0x005a:
        r9 = r5.length();	 Catch:{ Exception -> 0x0104 }
        if (r8 >= r9) goto L_0x006c;
    L_0x0060:
        r9 = r5.get(r8);	 Catch:{ Exception -> 0x0104 }
        r9 = (org.json.JSONObject) r9;	 Catch:{ Exception -> 0x0104 }
        r7.add(r9);	 Catch:{ Exception -> 0x0104 }
        r8 = r8 + 1;
        goto L_0x005a;
    L_0x006c:
        r5 = r0;
    L_0x006d:
        r8 = r6.length();	 Catch:{ Exception -> 0x0104 }
        if (r5 >= r8) goto L_0x007f;
    L_0x0073:
        r8 = r6.get(r5);	 Catch:{ Exception -> 0x0104 }
        r8 = (org.json.JSONObject) r8;	 Catch:{ Exception -> 0x0104 }
        r7.add(r8);	 Catch:{ Exception -> 0x0104 }
        r5 = r5 + 1;
        goto L_0x006d;
    L_0x007f:
        r5 = new com.umeng.commonsdk.utils.JSONArraySortUtil;	 Catch:{ Exception -> 0x0104 }
        r5.<init>();	 Catch:{ Exception -> 0x0104 }
        r6 = "page_start";
        r5.setCompareKey(r6);	 Catch:{ Exception -> 0x0104 }
        java.util.Collections.sort(r7, r5);	 Catch:{ Exception -> 0x0104 }
        r5 = new org.json.JSONArray;	 Catch:{ Exception -> 0x0104 }
        r5.<init>();	 Catch:{ Exception -> 0x0104 }
        r6 = r7.iterator();	 Catch:{ Exception -> 0x0104 }
    L_0x0095:
        r7 = r6.hasNext();	 Catch:{ Exception -> 0x0104 }
        if (r7 == 0) goto L_0x00a5;
    L_0x009b:
        r7 = r6.next();	 Catch:{ Exception -> 0x0104 }
        r7 = (org.json.JSONObject) r7;	 Catch:{ Exception -> 0x0104 }
        r5.put(r7);	 Catch:{ Exception -> 0x0104 }
        goto L_0x0095;
    L_0x00a5:
        r6 = "pages";
        r4.put(r6, r5);	 Catch:{ Exception -> 0x0104 }
        r5 = "autopages";
        r4.remove(r5);	 Catch:{ Exception -> 0x0104 }
    L_0x00af:
        r5 = "pages";
        r5 = r4.has(r5);	 Catch:{ Exception -> 0x0104 }
        if (r5 == 0) goto L_0x00f2;
    L_0x00b7:
        r5 = "pages";
        r5 = r4.optJSONArray(r5);	 Catch:{ Exception -> 0x0104 }
        r6 = r0;
    L_0x00be:
        r7 = r5.length();	 Catch:{ Exception -> 0x0104 }
        if (r6 >= r7) goto L_0x00e3;
    L_0x00c4:
        r7 = r5.getJSONObject(r6);	 Catch:{ Exception -> 0x0104 }
        r8 = "page_start";
        r8 = r7.has(r8);	 Catch:{ Exception -> 0x0104 }
        if (r8 == 0) goto L_0x00e0;
    L_0x00d0:
        r8 = "ts";
        r9 = "page_start";
        r9 = r7.getLong(r9);	 Catch:{ Exception -> 0x0104 }
        r7.put(r8, r9);	 Catch:{ Exception -> 0x0104 }
        r8 = "page_start";
        r7.remove(r8);	 Catch:{ Exception -> 0x0104 }
    L_0x00e0:
        r6 = r6 + 1;
        goto L_0x00be;
    L_0x00e3:
        r6 = "pages";
        r4.put(r6, r5);	 Catch:{ Exception -> 0x0104 }
        r6 = "$page_num";
        r5 = r5.length();	 Catch:{ Exception -> 0x0104 }
        r4.put(r6, r5);	 Catch:{ Exception -> 0x0104 }
        goto L_0x00f7;
    L_0x00f2:
        r5 = "$page_num";
        r4.put(r5, r0);	 Catch:{ Exception -> 0x0104 }
    L_0x00f7:
        r2.put(r4);	 Catch:{ Exception -> 0x0104 }
        r3 = r3 + 1;
        goto L_0x002a;
    L_0x00fe:
        r1 = "sessions";
        r12.put(r1, r2);	 Catch:{ Exception -> 0x0104 }
        goto L_0x010d;
    L_0x0104:
        r1 = move-exception;
        r2 = "merge pages error";
        com.umeng.commonsdk.statistics.common.MLog.e(r2);	 Catch:{ Throwable -> 0x0197 }
        r1.printStackTrace();	 Catch:{ Throwable -> 0x0197 }
    L_0x010d:
        r1 = O000000o;	 Catch:{ Throwable -> 0x0197 }
        r1 = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(r1);	 Catch:{ Throwable -> 0x0197 }
        if (r1 == 0) goto L_0x0128;
    L_0x0115:
        r2 = "userlevel";
        r3 = "";
        r1 = r1.getString(r2, r3);	 Catch:{ Throwable -> 0x0197 }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Throwable -> 0x0197 }
        if (r2 != 0) goto L_0x0128;
    L_0x0123:
        r2 = "userlevel";
        r12.put(r2, r1);	 Catch:{ Throwable -> 0x0197 }
    L_0x0128:
        r1 = O000000o;	 Catch:{ Throwable -> 0x0197 }
        r1 = defpackage.aa.O000000o(r1);	 Catch:{ Throwable -> 0x0197 }
        if (r1 == 0) goto L_0x015f;
    L_0x0130:
        r2 = r1[r0];	 Catch:{ Throwable -> 0x0197 }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x0197 }
        if (r2 != 0) goto L_0x015f;
    L_0x0138:
        r2 = 1;
        r3 = r1[r2];	 Catch:{ Throwable -> 0x0197 }
        r3 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Throwable -> 0x0197 }
        if (r3 != 0) goto L_0x015f;
    L_0x0141:
        r3 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0197 }
        r3.<init>();	 Catch:{ Throwable -> 0x0197 }
        r4 = "provider";
        r0 = r1[r0];	 Catch:{ Throwable -> 0x0197 }
        r3.put(r4, r0);	 Catch:{ Throwable -> 0x0197 }
        r0 = "puid";
        r1 = r1[r2];	 Catch:{ Throwable -> 0x0197 }
        r3.put(r0, r1);	 Catch:{ Throwable -> 0x0197 }
        r0 = r3.length();	 Catch:{ Throwable -> 0x0197 }
        if (r0 <= 0) goto L_0x015f;
    L_0x015a:
        r0 = "active_user";
        r12.put(r0, r3);	 Catch:{ Throwable -> 0x0197 }
    L_0x015f:
        r0 = O000000o;	 Catch:{ Throwable -> 0x0197 }
        r0 = com.umeng.commonsdk.statistics.noise.ABTest.getService(r0);	 Catch:{ Throwable -> 0x0197 }
        r0 = r0.isInTest();	 Catch:{ Throwable -> 0x0197 }
        if (r0 == 0) goto L_0x018c;
    L_0x016b:
        r0 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0197 }
        r0.<init>();	 Catch:{ Throwable -> 0x0197 }
        r1 = O000000o;	 Catch:{ Throwable -> 0x0197 }
        r1 = com.umeng.commonsdk.statistics.noise.ABTest.getService(r1);	 Catch:{ Throwable -> 0x0197 }
        r1 = r1.getTestName();	 Catch:{ Throwable -> 0x0197 }
        r2 = O000000o;	 Catch:{ Throwable -> 0x0197 }
        r2 = com.umeng.commonsdk.statistics.noise.ABTest.getService(r2);	 Catch:{ Throwable -> 0x0197 }
        r2 = r2.getGroupInfo();	 Catch:{ Throwable -> 0x0197 }
        r0.put(r1, r2);	 Catch:{ Throwable -> 0x0197 }
        r1 = "group_info";
        r12.put(r1, r0);	 Catch:{ Throwable -> 0x0197 }
    L_0x018c:
        r0 = defpackage.at.O000000o();	 Catch:{ Throwable -> 0x0197 }
        r1 = O000000o;	 Catch:{ Throwable -> 0x0197 }
        r0.O000000o(r12, r1);	 Catch:{ Throwable -> 0x0197 }
        goto L_0x0197;
    L_0x0196:
        r12 = r0;
    L_0x0197:
        return r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.aq.O00000Oo(boolean):org.json.JSONObject");
    }

    public void O00000Oo() {
    }

    public void O00000Oo(Context context) {
        try {
            am.O000000o(context).O00000o();
            O0000oO0();
        } catch (Throwable unused) {
        }
    }

    public void O00000Oo(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() <= 0) {
                    return;
                }
                if (!jSONObject.has(ah.O000oOOo)) {
                    O00000o(jSONObject);
                } else if (101 != jSONObject.getInt(ah.O000oOOo)) {
                    O00000o(jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void O00000o() {
        try {
            if (this.O0000O0o.length() > 0) {
                am.O000000o(O000000o).O000000o(this.O0000O0o);
                this.O0000O0o = new JSONArray();
            }
            PreferenceWrapper.getDefault(O000000o).edit().putLong(O0000o0, this.O0000OoO).putInt(O0000o, this.O0000Oo0).putInt(O0000oO0, this.O0000Oo).commit();
        } catch (Throwable unused) {
        }
    }

    public void O00000o(Object obj) {
        O0000oO();
        O0000o0();
        O0000o0O();
        O000000o(true);
    }

    public void O00000o0() {
        O00000Oo(O000000o);
        O00000o();
        O000000o(true);
    }

    public void O00000o0(Object obj) {
        O00000Oo(O000000o);
        O00000o();
        if (O00000o(false)) {
            O0000OoO();
        }
    }

    public void O00000oO() {
        if (O00000o(false)) {
            O0000OoO();
        }
    }

    public long O00000oo() {
        long j = 0;
        try {
            if (O000000o == null) {
                return 0;
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(O000000o);
            if (sharedPreferences == null) {
                return 0;
            }
            long j2 = sharedPreferences.getLong(O0000Ooo, 0);
            if (j2 == 0) {
                try {
                    j = System.currentTimeMillis();
                    sharedPreferences.edit().putLong(O0000Ooo, j).commit();
                    return j;
                } catch (Throwable unused) {
                }
            }
            return j2;
        } catch (Throwable unused2) {
            return j;
        }
    }
}
