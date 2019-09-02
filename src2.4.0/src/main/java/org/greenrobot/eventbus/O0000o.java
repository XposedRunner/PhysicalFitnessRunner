package org.greenrobot.eventbus;

import java.lang.reflect.Method;

/* compiled from: SubscriberMethod */
public class O0000o {
    final Method O000000o;
    final ThreadMode O00000Oo;
    final int O00000o;
    final Class<?> O00000o0;
    final boolean O00000oO;
    String O00000oo;

    public O0000o(Method method, Class<?> cls, ThreadMode threadMode, int i, boolean z) {
        this.O000000o = method;
        this.O00000Oo = threadMode;
        this.O00000o0 = cls;
        this.O00000o = i;
        this.O00000oO = z;
    }

    private synchronized void O000000o() {
        if (this.O00000oo == null) {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append(this.O000000o.getDeclaringClass().getName());
            stringBuilder.append('#');
            stringBuilder.append(this.O000000o.getName());
            stringBuilder.append('(');
            stringBuilder.append(this.O00000o0.getName());
            this.O00000oo = stringBuilder.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof O0000o)) {
            return false;
        }
        O000000o();
        O0000o o0000o = (O0000o) obj;
        o0000o.O000000o();
        return this.O00000oo.equals(o0000o.O00000oo);
    }

    public int hashCode() {
        return this.O000000o.hashCode();
    }
}
