package com.umeng.commonsdk.statistics.noise;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler.a;
import com.umeng.commonsdk.statistics.internal.d;
import com.yalantis.ucrop.view.CropImageView;

public class ABTest implements d {
    private static ABTest instance;
    private Context context = null;
    private boolean isInTest = false;
    private int mGroup = -1;
    private int mInterval = -1;
    private String mPoli = null;
    private int mPolicy = -1;
    private float mProb07 = CropImageView.DEFAULT_ASPECT_RATIO;
    private float mProb13 = CropImageView.DEFAULT_ASPECT_RATIO;

    private ABTest(Context context, String str, int i) {
        this.context = context;
        onExperimentChanged(str, i);
    }

    public static synchronized ABTest getService(Context context) {
        ABTest aBTest;
        synchronized (ABTest.class) {
            if (instance == null) {
                instance = new ABTest(context, UMEnvelopeBuild.imprintProperty(context, "client_test", null), Integer.valueOf(UMEnvelopeBuild.imprintProperty(context, "test_report_interval", "0")).intValue());
            }
            aBTest = instance;
        }
        return aBTest;
    }

    private void parseFIXED(String str) {
        if (str != null) {
            String[] split = str.split("\\|");
            float f = CropImageView.DEFAULT_ASPECT_RATIO;
            if (split[2].equals("SIG13")) {
                f = Float.valueOf(split[3]).floatValue();
            }
            if (this.mProb13 > f) {
                this.isInTest = false;
                return;
            }
            int intValue = split[0].equals("FIXED") ? Integer.valueOf(split[1]).intValue() : -1;
            int[] iArr = null;
            if (split[4].equals("RPT")) {
                this.mPoli = "RPT";
                split = split[5].split(",");
                iArr = new int[split.length];
                for (int i = 0; i < split.length; i++) {
                    iArr[i] = Integer.valueOf(split[i]).intValue();
                }
            } else if (split[4].equals("DOM")) {
                this.mPoli = "DOM";
                this.isInTest = true;
                try {
                    split = split[5].split(",");
                    int[] iArr2 = new int[split.length];
                    int i2 = 0;
                    while (i2 < split.length) {
                        try {
                            iArr2[i2] = Integer.valueOf(split[i2]).intValue();
                            i2++;
                        } catch (Exception unused) {
                        }
                    }
                    iArr = iArr2;
                } catch (Exception unused2) {
                }
            }
            if (intValue != -1) {
                this.isInTest = true;
                this.mGroup = intValue;
                if (iArr != null) {
                    this.mPolicy = iArr[intValue - 1];
                }
            } else {
                this.isInTest = false;
            }
        }
    }

    private void parseSig7(String str) {
        if (str != null) {
            String[] split = str.split("\\|");
            boolean equals = split[2].equals("SIG13");
            float f = CropImageView.DEFAULT_ASPECT_RATIO;
            if (this.mProb13 > (equals ? Float.valueOf(split[3]).floatValue() : CropImageView.DEFAULT_ASPECT_RATIO)) {
                this.isInTest = false;
                return;
            }
            float[] fArr;
            int[] iArr = null;
            if (split[0].equals("SIG7")) {
                String[] split2 = split[1].split(",");
                fArr = new float[split2.length];
                for (int i = 0; i < split2.length; i++) {
                    fArr[i] = Float.valueOf(split2[i]).floatValue();
                }
            } else {
                fArr = null;
            }
            if (split[4].equals("RPT")) {
                this.mPoli = "RPT";
                split = split[5].split(",");
                iArr = new int[split.length];
                for (int i2 = 0; i2 < split.length; i2++) {
                    iArr[i2] = Integer.valueOf(split[i2]).intValue();
                }
            } else if (split[4].equals("DOM")) {
                this.isInTest = true;
                this.mPoli = "DOM";
                try {
                    split = split[5].split(",");
                    int[] iArr2 = new int[split.length];
                    int i3 = 0;
                    while (i3 < split.length) {
                        try {
                            iArr2[i3] = Integer.valueOf(split[i3]).intValue();
                            i3++;
                        } catch (Exception unused) {
                        }
                    }
                    iArr = iArr2;
                } catch (Exception unused2) {
                }
            }
            int i4 = 0;
            while (i4 < fArr.length) {
                f += fArr[i4];
                if (this.mProb07 < f) {
                    break;
                }
                i4++;
            }
            i4 = -1;
            if (i4 != -1) {
                this.isInTest = true;
                this.mGroup = i4 + 1;
                if (iArr != null) {
                    this.mPolicy = iArr[i4];
                }
            } else {
                this.isInTest = false;
            }
        }
    }

    private float prob(String str, int i) {
        i *= 2;
        return str == null ? CropImageView.DEFAULT_ASPECT_RATIO : ((float) Integer.valueOf(str.substring(i, i + 5), 16).intValue()) / 1048576.0f;
    }

    public static boolean validate(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] split = str.split("\\|");
        if (split.length != 6) {
            return false;
        }
        if (split[0].startsWith("SIG7") && split[1].split(",").length == split[5].split(",").length) {
            return true;
        }
        if (split[0].startsWith("FIXED")) {
            int length = split[5].split(",").length;
            int parseInt = Integer.parseInt(split[1]);
            return length >= parseInt && parseInt >= 1;
        }
    }

    public int getGroup() {
        return this.mGroup;
    }

    public String getGroupInfo() {
        return !this.isInTest ? "error" : String.valueOf(this.mGroup);
    }

    public int getTestInterval() {
        return this.mInterval;
    }

    public String getTestName() {
        return this.mPoli;
    }

    public int getTestPolicy() {
        return this.mPolicy;
    }

    public boolean isInTest() {
        return this.isInTest;
    }

    public void onExperimentChanged(String str, int i) {
        this.mInterval = i;
        String signature = Envelope.getSignature(this.context);
        if (TextUtils.isEmpty(signature) || TextUtils.isEmpty(str)) {
            this.isInTest = false;
            return;
        }
        try {
            this.mProb13 = prob(signature, 12);
            this.mProb07 = prob(signature, 6);
            if (str.startsWith("SIG7")) {
                parseSig7(str);
            } else if (str.startsWith("FIXED")) {
                parseFIXED(str);
            }
        } catch (Exception e) {
            this.isInTest = false;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("v:");
            stringBuilder.append(str);
            MLog.e(stringBuilder.toString(), e);
        }
    }

    public void onImprintChanged(a aVar) {
        onExperimentChanged(aVar.a("client_test", null), Integer.valueOf(aVar.a("test_report_interval", "0")).intValue());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" p13:");
        stringBuilder.append(this.mProb13);
        stringBuilder.append(" p07:");
        stringBuilder.append(this.mProb07);
        stringBuilder.append(" policy:");
        stringBuilder.append(this.mPolicy);
        stringBuilder.append(" interval:");
        stringBuilder.append(this.mInterval);
        return stringBuilder.toString();
    }
}
