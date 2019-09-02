package com.alibaba.wireless.security.mainplugin;

import android.content.Context;
import com.alibaba.wireless.security.framework.IRouterComponent;
import com.alibaba.wireless.security.framework.ISGPluginInfo;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import com.alibaba.wireless.security.open.umid.IUMIDComponent;
import com.alibaba.wireless.security.open.umid.a;
import com.taobao.wireless.security.adapter.common.SPUtility2;
import com.taobao.wireless.security.adapter.common.c;
import java.util.HashMap;

public class SecurityGuardMainPlugin implements ISecurityGuardPlugin {
    private HashMap<Class, Object> a = null;
    private boolean b = true;
    private boolean c = false;
    private Context d = null;
    private ISGPluginInfo e = null;
    private IRouterComponent f = null;
    private b g = new b();

    private void a() {
        this.a = new HashMap();
        this.g.a(this.a, this);
    }

    private void a(String str) {
        if (str != null) {
            this.g.a(this.a, str, this);
        }
    }

    public Context getContext() {
        return this.d;
    }

    public <T> T getInterface(Class<T> cls) {
        if (cls == null) {
            return null;
        }
        T t = this.a.get(cls);
        if (t != null && cls.isAssignableFrom(t.getClass())) {
            return t;
        }
        try {
            a(cls.getName());
            return this.a.get(cls);
        } catch (Exception unused) {
            return null;
        }
    }

    public IRouterComponent getRouter() {
        return this.f;
    }

    public ISGPluginInfo getSGPluginInfo() {
        return this.e;
    }

    public IRouterComponent onPluginLoaded(Context context, IRouterComponent iRouterComponent, ISGPluginInfo iSGPluginInfo, String str, Object... objArr) throws SecException {
        if (this.b) {
            this.d = context;
            this.e = iSGPluginInfo;
            SPUtility2.init(context);
            c.a(context);
            a();
            a.a(this);
            this.f = new a();
            try {
                int intValue;
                String str2;
                System.loadLibrary(str);
                String str3 = "";
                String str4 = "";
                str = "";
                if (objArr.length >= 4 && (objArr[0] instanceof Integer) && (objArr[1] instanceof String) && (objArr[2] instanceof String)) {
                    intValue = ((Integer) objArr[0]).intValue();
                    str4 = (String) objArr[1];
                    str2 = (String) objArr[2];
                    if (objArr[3] instanceof String) {
                        str = (String) objArr[3];
                    }
                } else {
                    str2 = str4;
                    str4 = str3;
                    intValue = 0;
                }
                if ((intValue & 1) != 0) {
                    ((a) this.a.get(IUMIDComponent.class)).b();
                }
                int intValue2 = ((Integer) getRouter().doCommand(10101, new Object[]{context, Integer.valueOf(intValue), str4, str2, str})).intValue();
                if (intValue2 != 0) {
                    throw new SecException(intValue2);
                }
                this.b = false;
            } catch (Throwable th) {
                SecException secException = new SecException(th.toString(), 103);
            }
        }
        return this.f;
    }
}
