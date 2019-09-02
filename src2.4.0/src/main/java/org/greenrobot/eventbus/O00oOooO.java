package org.greenrobot.eventbus;

import defpackage.mr;
import defpackage.ms;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: SubscriberMethodFinder */
class O00oOooO {
    private static final int O000000o = 64;
    private static final int O00000Oo = 4096;
    private static final Map<Class<?>, List<O0000o>> O00000o = new ConcurrentHashMap();
    private static final int O00000o0 = 5192;
    private static final int O0000OOo = 4;
    private static final O000000o[] O0000Oo0 = new O000000o[4];
    private List<ms> O00000oO;
    private final boolean O00000oo;
    private final boolean O0000O0o;

    /* compiled from: SubscriberMethodFinder */
    static class O000000o {
        final List<O0000o> O000000o = new ArrayList();
        final Map<Class, Object> O00000Oo = new HashMap();
        final StringBuilder O00000o = new StringBuilder(128);
        final Map<String, Class> O00000o0 = new HashMap();
        Class<?> O00000oO;
        Class<?> O00000oo;
        boolean O0000O0o;
        mr O0000OOo;

        O000000o() {
        }

        private boolean O00000Oo(Method method, Class<?> cls) {
            this.O00000o.setLength(0);
            this.O00000o.append(method.getName());
            StringBuilder stringBuilder = this.O00000o;
            stringBuilder.append('>');
            stringBuilder.append(cls.getName());
            String stringBuilder2 = this.O00000o.toString();
            Class declaringClass = method.getDeclaringClass();
            Class cls2 = (Class) this.O00000o0.put(stringBuilder2, declaringClass);
            if (cls2 == null || cls2.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.O00000o0.put(stringBuilder2, cls2);
            return false;
        }

        /* Access modifiers changed, original: 0000 */
        public void O000000o() {
            this.O000000o.clear();
            this.O00000Oo.clear();
            this.O00000o0.clear();
            this.O00000o.setLength(0);
            this.O00000oO = null;
            this.O00000oo = null;
            this.O0000O0o = false;
            this.O0000OOo = null;
        }

        /* Access modifiers changed, original: 0000 */
        public void O000000o(Class<?> cls) {
            this.O00000oo = cls;
            this.O00000oO = cls;
            this.O0000O0o = false;
            this.O0000OOo = null;
        }

        /* Access modifiers changed, original: 0000 */
        public boolean O000000o(Method method, Class<?> cls) {
            Object put = this.O00000Oo.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (O00000Oo((Method) put, cls)) {
                    this.O00000Oo.put(cls, this);
                } else {
                    throw new IllegalStateException();
                }
            }
            return O00000Oo(method, cls);
        }

        /* Access modifiers changed, original: 0000 */
        public void O00000Oo() {
            if (this.O0000O0o) {
                this.O00000oo = null;
                return;
            }
            this.O00000oo = this.O00000oo.getSuperclass();
            String name = this.O00000oo.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                this.O00000oo = null;
            }
        }
    }

    O00oOooO(List<ms> list, boolean z, boolean z2) {
        this.O00000oO = list;
        this.O00000oo = z;
        this.O0000O0o = z2;
    }

    private List<O0000o> O000000o(O000000o o000000o) {
        ArrayList arrayList = new ArrayList(o000000o.O000000o);
        o000000o.O000000o();
        synchronized (O0000Oo0) {
            int i = 0;
            while (i < 4) {
                try {
                    if (O0000Oo0[i] == null) {
                        O0000Oo0[i] = o000000o;
                        break;
                    }
                    i++;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return arrayList;
    }

    static void O000000o() {
        O00000o.clear();
    }

    private List<O0000o> O00000Oo(Class<?> cls) {
        O000000o O00000Oo = O00000Oo();
        O00000Oo.O000000o(cls);
        while (O00000Oo.O00000oo != null) {
            O00000Oo.O0000OOo = O00000Oo(O00000Oo);
            if (O00000Oo.O0000OOo != null) {
                for (O0000o o0000o : O00000Oo.O0000OOo.O00000o()) {
                    if (O00000Oo.O000000o(o0000o.O000000o, o0000o.O00000o0)) {
                        O00000Oo.O000000o.add(o0000o);
                    }
                }
            } else {
                O00000o0(O00000Oo);
            }
            O00000Oo.O00000Oo();
        }
        return O000000o(O00000Oo);
    }

    private mr O00000Oo(O000000o o000000o) {
        if (!(o000000o.O0000OOo == null || o000000o.O0000OOo.O00000Oo() == null)) {
            mr O00000Oo = o000000o.O0000OOo.O00000Oo();
            if (o000000o.O00000oo == O00000Oo.O000000o()) {
                return O00000Oo;
            }
        }
        if (this.O00000oO != null) {
            for (ms O000000o : this.O00000oO) {
                mr O000000o2 = O000000o.O000000o(o000000o.O00000oo);
                if (O000000o2 != null) {
                    return O000000o2;
                }
            }
        }
        return null;
    }

    private O000000o O00000Oo() {
        synchronized (O0000Oo0) {
            int i = 0;
            while (i < 4) {
                try {
                    O000000o o000000o = O0000Oo0[i];
                    if (o000000o != null) {
                        O0000Oo0[i] = null;
                        return o000000o;
                    }
                    i++;
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            return new O000000o();
        }
    }

    private List<O0000o> O00000o0(Class<?> cls) {
        O000000o O00000Oo = O00000Oo();
        O00000Oo.O000000o(cls);
        while (O00000Oo.O00000oo != null) {
            O00000o0(O00000Oo);
            O00000Oo.O00000Oo();
        }
        return O000000o(O00000Oo);
    }

    private void O00000o0(O000000o o000000o) {
        Method[] declaredMethods;
        try {
            declaredMethods = o000000o.O00000oo.getDeclaredMethods();
        } catch (Throwable unused) {
            declaredMethods = o000000o.O00000oo.getMethods();
            o000000o.O0000O0o = true;
        }
        for (Method method : declaredMethods) {
            int modifiers = method.getModifiers();
            StringBuilder stringBuilder;
            String stringBuilder2;
            StringBuilder stringBuilder3;
            if ((modifiers & 1) != 0 && (modifiers & O00000o0) == 0) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    Subscribe subscribe = (Subscribe) method.getAnnotation(Subscribe.class);
                    if (subscribe != null) {
                        Class cls = parameterTypes[0];
                        if (o000000o.O000000o(method, cls)) {
                            o000000o.O000000o.add(new O0000o(method, cls, subscribe.threadMode(), subscribe.priority(), subscribe.sticky()));
                        }
                    }
                } else if (this.O00000oo && method.isAnnotationPresent(Subscribe.class)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(method.getDeclaringClass().getName());
                    stringBuilder.append(".");
                    stringBuilder.append(method.getName());
                    stringBuilder2 = stringBuilder.toString();
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("@Subscribe method ");
                    stringBuilder3.append(stringBuilder2);
                    stringBuilder3.append("must have exactly 1 parameter but has ");
                    stringBuilder3.append(parameterTypes.length);
                    throw new O0000O0o(stringBuilder3.toString());
                }
            } else if (this.O00000oo && method.isAnnotationPresent(Subscribe.class)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(method.getDeclaringClass().getName());
                stringBuilder.append(".");
                stringBuilder.append(method.getName());
                stringBuilder2 = stringBuilder.toString();
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(stringBuilder2);
                stringBuilder3.append(" is a illegal @Subscribe method: must be public, non-static, and non-abstract");
                throw new O0000O0o(stringBuilder3.toString());
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public List<O0000o> O000000o(Class<?> cls) {
        List list = (List) O00000o.get(cls);
        if (list != null) {
            return list;
        }
        list = this.O0000O0o ? O00000o0((Class) cls) : O00000Oo((Class) cls);
        if (list.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Subscriber ");
            stringBuilder.append(cls);
            stringBuilder.append(" and its super classes have no public methods with the @Subscribe annotation");
            throw new O0000O0o(stringBuilder.toString());
        }
        O00000o.put(cls, list);
        return list;
    }
}
