package com.umeng.commonsdk.statistics.noise;

import android.content.Context;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler.a;
import com.umeng.commonsdk.statistics.internal.d;

public class Defcon implements d {
    private static final int LEVEL_0 = 0;
    private static final int LEVEL_1 = 1;
    private static final int LEVEL_2 = 2;
    private static final int LEVEL_3 = 3;
    private static final long MILLIS_24_HOURS = 86400000;
    private static final long MILLIS_4_HOURS = 14400000;
    private static final long MILLIS_8_HOURS = 28800000;
    private static Defcon instanse;
    private int mLevel = 0;

    private Defcon() {
    }

    public static synchronized Defcon getService(Context context) {
        Defcon defcon;
        synchronized (Defcon.class) {
            if (instanse == null) {
                instanse = new Defcon();
                instanse.setLevel(Integer.valueOf(UMEnvelopeBuild.imprintProperty(context, "defcon", "0")).intValue());
            }
            defcon = instanse;
        }
        return defcon;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public long getReqInterval() {
        switch (this.mLevel) {
            case 1:
                return MILLIS_4_HOURS;
            case 2:
                return MILLIS_8_HOURS;
            case 3:
                return 86400000;
            default:
                return 0;
        }
    }

    public long getRetryInterval() {
        return this.mLevel == 0 ? 0 : 300000;
    }

    public boolean isOpen() {
        return this.mLevel != 0;
    }

    public void onImprintChanged(a aVar) {
        setLevel(Integer.valueOf(aVar.a("defcon", String.valueOf(0))).intValue());
    }

    public void setLevel(int i) {
        if (i >= 0 && i <= 3) {
            this.mLevel = i;
        }
    }
}
