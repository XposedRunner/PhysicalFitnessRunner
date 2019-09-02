package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: PluginContext */
public class o0O000Oo extends ContextThemeWrapper {
    private static final String[] O00000o = new String[]{"android.widget", "android.webkit", "android.app"};
    private Resources O000000o = o0O000o0.O000000o();
    private LayoutInflater O00000Oo;
    private ClassLoader O00000o0;
    private O000000o O00000oO = new O000000o();
    private Factory O00000oo = new Factory() {
        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return o0O000Oo.this.O000000o(str, context, attributeSet);
        }
    };

    /* compiled from: PluginContext */
    public class O000000o {
        public HashSet<String> O000000o = new HashSet();
        public HashMap<String, Constructor<?>> O00000Oo = new HashMap();
    }

    public o0O000Oo(Context context, int i, ClassLoader classLoader) {
        super(context, i);
        this.O00000o0 = classLoader;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0073 A:{SYNTHETIC, Splitter:B:33:0x0073} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b  */
    private final android.view.View O000000o(java.lang.String r12, android.content.Context r13, android.util.AttributeSet r14) {
        /*
        r11 = this;
        r0 = r11.O00000oO;
        r0 = r0.O000000o;
        r0 = r0.contains(r12);
        r1 = 0;
        if (r0 == 0) goto L_0x000c;
    L_0x000b:
        return r1;
    L_0x000c:
        r0 = r11.O00000oO;
        r0 = r0.O00000Oo;
        r0 = r0.get(r12);
        r0 = (java.lang.reflect.Constructor) r0;
        r2 = 2;
        r3 = 1;
        r4 = 0;
        if (r0 != 0) goto L_0x0089;
    L_0x001b:
        r5 = "api.navi";
        r5 = r12.contains(r5);	 Catch:{ Throwable -> 0x0066 }
        if (r5 == 0) goto L_0x002a;
    L_0x0023:
        r5 = r11.O00000o0;	 Catch:{ Throwable -> 0x0066 }
        r5 = r5.loadClass(r12);	 Catch:{ Throwable -> 0x0066 }
        goto L_0x0052;
    L_0x002a:
        r5 = O00000o;	 Catch:{ Throwable -> 0x0066 }
        r6 = r5.length;	 Catch:{ Throwable -> 0x0066 }
        r7 = r4;
    L_0x002e:
        if (r7 >= r6) goto L_0x0051;
    L_0x0030:
        r8 = r5[r7];	 Catch:{ Throwable -> 0x0066 }
        r9 = r11.O00000o0;	 Catch:{ Throwable -> 0x004e }
        r10 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x004e }
        r10.<init>();	 Catch:{ Throwable -> 0x004e }
        r10.append(r8);	 Catch:{ Throwable -> 0x004e }
        r8 = ".";
        r10.append(r8);	 Catch:{ Throwable -> 0x004e }
        r10.append(r12);	 Catch:{ Throwable -> 0x004e }
        r8 = r10.toString();	 Catch:{ Throwable -> 0x004e }
        r8 = r9.loadClass(r8);	 Catch:{ Throwable -> 0x004e }
        r5 = r8;
        goto L_0x0052;
    L_0x004e:
        r7 = r7 + 1;
        goto L_0x002e;
    L_0x0051:
        r5 = r1;
    L_0x0052:
        if (r5 != 0) goto L_0x0055;
    L_0x0054:
        goto L_0x0062;
    L_0x0055:
        r6 = android.view.ViewStub.class;
        if (r5 != r6) goto L_0x005a;
    L_0x0059:
        goto L_0x0062;
    L_0x005a:
        r6 = r5.getClassLoader();	 Catch:{ Throwable -> 0x0067 }
        r7 = r11.O00000o0;	 Catch:{ Throwable -> 0x0067 }
        if (r6 == r7) goto L_0x0063;
    L_0x0062:
        goto L_0x0067;
    L_0x0063:
        r6 = r5;
        r5 = r3;
        goto L_0x0069;
    L_0x0066:
        r5 = r1;
    L_0x0067:
        r6 = r5;
        r5 = r4;
    L_0x0069:
        if (r5 != 0) goto L_0x0073;
    L_0x006b:
        r13 = r11.O00000oO;
        r13 = r13.O000000o;
        r13.add(r12);
        return r1;
    L_0x0073:
        r5 = new java.lang.Class[r2];	 Catch:{ Throwable -> 0x0089 }
        r7 = android.content.Context.class;
        r5[r4] = r7;	 Catch:{ Throwable -> 0x0089 }
        r7 = android.util.AttributeSet.class;
        r5[r3] = r7;	 Catch:{ Throwable -> 0x0089 }
        r5 = r6.getConstructor(r5);	 Catch:{ Throwable -> 0x0089 }
        r0 = r11.O00000oO;	 Catch:{ Throwable -> 0x0088 }
        r0 = r0.O00000Oo;	 Catch:{ Throwable -> 0x0088 }
        r0.put(r12, r5);	 Catch:{ Throwable -> 0x0088 }
    L_0x0088:
        r0 = r5;
    L_0x0089:
        if (r0 == 0) goto L_0x0099;
    L_0x008b:
        r12 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0098 }
        r12[r4] = r13;	 Catch:{ Throwable -> 0x0098 }
        r12[r3] = r14;	 Catch:{ Throwable -> 0x0098 }
        r12 = r0.newInstance(r12);	 Catch:{ Throwable -> 0x0098 }
        r12 = (android.view.View) r12;	 Catch:{ Throwable -> 0x0098 }
        goto L_0x009a;
    L_0x0098:
        return r1;
    L_0x0099:
        r12 = r1;
    L_0x009a:
        return r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.o0O000Oo.O000000o(java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    public Resources getResources() {
        return this.O000000o != null ? this.O000000o : super.getResources();
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return super.getSystemService(str);
        }
        if (this.O00000Oo == null) {
            LayoutInflater layoutInflater = (LayoutInflater) super.getSystemService(str);
            if (layoutInflater != null) {
                this.O00000Oo = layoutInflater.cloneInContext(this);
            }
            this.O00000Oo.setFactory(this.O00000oo);
            this.O00000Oo = this.O00000Oo.cloneInContext(this);
        }
        return this.O00000Oo;
    }
}
