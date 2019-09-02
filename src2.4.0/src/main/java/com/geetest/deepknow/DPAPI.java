package com.geetest.deepknow;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bangcle.andJni.JniLib1557756502;
import com.geetest.deepknow.bean.DPJudgementBean;
import com.geetest.deepknow.c.a;
import com.geetest.deepknow.listener.DPJudgementListener;
import com.geetest.deepknow.listener.DPListener;
import com.geetest.deepknow.utils.b;
import com.geetest.deepknow.utils.i;
import java.util.HashMap;
import java.util.Map;

public class DPAPI {
    private static final Map<Context, DPAPI> sInstanceMap = new HashMap();
    private a dpHelper;

    private DPAPI(Context context, String str) {
        this.dpHelper = new a(context, null);
    }

    public static DPAPI getInstance(Context context) {
        if (context == null) {
            return null;
        }
        DPAPI dpapi;
        synchronized (sInstanceMap) {
            dpapi = (DPAPI) sInstanceMap.get(context.getApplicationContext());
            if (dpapi == null) {
                i.b("getInstance should before set");
            }
        }
        return dpapi;
    }

    public static DPAPI getInstance(Context context, String str) {
        if (context == null) {
            return null;
        }
        DPAPI dpapi;
        synchronized (sInstanceMap) {
            context = context.getApplicationContext();
            dpapi = (DPAPI) sInstanceMap.get(context);
            if (dpapi == null && b.a(context)) {
                dpapi = new DPAPI(context, str);
                sInstanceMap.put(context, dpapi);
            }
        }
        return dpapi;
    }

    public DPAPI closeSQL() {
        this.dpHelper.j();
        return this;
    }

    public DPAPI emitSenseData(DPJudgementBean dPJudgementBean, DPJudgementListener dPJudgementListener) {
        return (DPAPI) JniLib1557756502.cL(this, dPJudgementBean, dPJudgementListener, Integer.valueOf(0));
    }

    public DPAPI endSensor() {
        this.dpHelper.k();
        return this;
    }

    public String getVersion() {
        return (String) JniLib1557756502.cL(this, Integer.valueOf(1));
    }

    public DPAPI ignoreDPActivity(String... strArr) {
        this.dpHelper.a(strArr);
        return this;
    }

    public DPAPI ignoreDPView(View view, String str) {
        return (DPAPI) JniLib1557756502.cL(this, view, str, Integer.valueOf(2));
    }

    public DPAPI ignoreView(View... viewArr) {
        this.dpHelper.a(viewArr);
        return this;
    }

    public DPAPI loginIn(String str) {
        return (DPAPI) JniLib1557756502.cL(this, str, Integer.valueOf(3));
    }

    public DPAPI loginOut() {
        this.dpHelper.h();
        return this;
    }

    public DPAPI openDebugTrack(boolean z, boolean z2) {
        return (DPAPI) JniLib1557756502.cL(this, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(4));
    }

    public DPAPI setDPListener(DPListener dPListener) {
        return (DPAPI) JniLib1557756502.cL(this, dPListener, Integer.valueOf(5));
    }

    public DPAPI setEmitSenseDataTimeOut(int i) {
        return (DPAPI) JniLib1557756502.cL(this, Integer.valueOf(i), Integer.valueOf(6));
    }

    public DPAPI setSendDataLength(int i) {
        return (DPAPI) JniLib1557756502.cL(this, Integer.valueOf(i), Integer.valueOf(7));
    }

    public DPAPI setSendDataMaxLength(int i) {
        return (DPAPI) JniLib1557756502.cL(this, Integer.valueOf(i), Integer.valueOf(8));
    }

    public DPAPI setSendDataTimeOut(int i) {
        return (DPAPI) JniLib1557756502.cL(this, Integer.valueOf(i), Integer.valueOf(9));
    }

    public DPAPI startSensor(Activity activity) {
        return (DPAPI) JniLib1557756502.cL(this, activity, Integer.valueOf(10));
    }

    public DPAPI unIgnoreDPActivity(String... strArr) {
        this.dpHelper.b(strArr);
        return this;
    }

    public DPAPI unIgnoreDPView(View view, String str) {
        return (DPAPI) JniLib1557756502.cL(this, view, str, Integer.valueOf(11));
    }

    public DPAPI unIgnoreView(View... viewArr) {
        this.dpHelper.b(viewArr);
        return this;
    }
}
