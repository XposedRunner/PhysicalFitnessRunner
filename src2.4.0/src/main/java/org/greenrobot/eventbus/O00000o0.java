package org.greenrobot.eventbus;

import android.os.Looper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

/* compiled from: EventBus */
public class O00000o0 {
    public static String O000000o = "EventBus";
    static volatile O00000o0 O00000Oo;
    private static final Map<Class<?>, List<Class<?>>> O00000o = new HashMap();
    private static final O00000o O00000o0 = new O00000o();
    private final Map<Class<?>, CopyOnWriteArrayList<O000O00o>> O00000oO;
    private final Map<Object, List<Class<?>>> O00000oo;
    private final Map<Class<?>, Object> O0000O0o;
    private final ThreadLocal<O00000Oo> O0000OOo;
    private final O00000Oo O0000Oo;
    private final O0000OOo O0000Oo0;
    private final O000000o O0000OoO;
    private final O00oOooO O0000Ooo;
    private final boolean O0000o;
    private final boolean O0000o0;
    private final ExecutorService O0000o00;
    private final boolean O0000o0O;
    private final boolean O0000o0o;
    private final boolean O0000oO;
    private final boolean O0000oO0;
    private final int O0000oOO;

    /* compiled from: EventBus */
    /* renamed from: org.greenrobot.eventbus.O00000o0$2 */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] O000000o = new int[ThreadMode.values().length];

        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        static {
            /*
            r0 = org.greenrobot.eventbus.ThreadMode.values();
            r0 = r0.length;
            r0 = new int[r0];
            O000000o = r0;
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = org.greenrobot.eventbus.ThreadMode.POSTING;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = org.greenrobot.eventbus.ThreadMode.MAIN;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = org.greenrobot.eventbus.ThreadMode.BACKGROUND;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = org.greenrobot.eventbus.ThreadMode.ASYNC;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.eventbus.O00000o0$AnonymousClass2.<clinit>():void");
        }
    }

    /* compiled from: EventBus */
    interface O000000o {
        void O000000o(List<O0000o0> list);
    }

    /* compiled from: EventBus */
    static final class O00000Oo {
        final List<Object> O000000o = new ArrayList();
        boolean O00000Oo;
        O000O00o O00000o;
        boolean O00000o0;
        Object O00000oO;
        boolean O00000oo;

        O00000Oo() {
        }
    }

    public O00000o0() {
        this(O00000o0);
    }

    O00000o0(O00000o o00000o) {
        this.O0000OOo = new ThreadLocal<O00000Oo>() {
            /* Access modifiers changed, original: protected */
            /* renamed from: O000000o */
            public O00000Oo initialValue() {
                return new O00000Oo();
            }
        };
        this.O00000oO = new HashMap();
        this.O00000oo = new HashMap();
        this.O0000O0o = new ConcurrentHashMap();
        this.O0000Oo0 = new O0000OOo(this, Looper.getMainLooper(), 10);
        this.O0000Oo = new O00000Oo(this);
        this.O0000OoO = new O000000o(this);
        this.O0000oOO = o00000o.O0000OoO != null ? o00000o.O0000OoO.size() : 0;
        this.O0000Ooo = new O00oOooO(o00000o.O0000OoO, o00000o.O0000OOo, o00000o.O0000O0o);
        this.O0000o0O = o00000o.O000000o;
        this.O0000o0o = o00000o.O00000Oo;
        this.O0000o = o00000o.O00000o0;
        this.O0000oO0 = o00000o.O00000o;
        this.O0000o0 = o00000o.O00000oO;
        this.O0000oO = o00000o.O00000oo;
        this.O0000o00 = o00000o.O0000Oo0;
    }

    public static O00000o0 O000000o() {
        if (O00000Oo == null) {
            synchronized (O00000o0.class) {
                if (O00000Oo == null) {
                    O00000Oo = new O00000o0();
                }
            }
        }
        return O00000Oo;
    }

    private void O000000o(Object obj, Class<?> cls) {
        List list = (List) this.O00000oO.get(cls);
        if (list != null) {
            int size = list.size();
            int i = 0;
            while (i < size) {
                O000O00o o000O00o = (O000O00o) list.get(i);
                if (o000O00o.O000000o == obj) {
                    o000O00o.O00000o0 = false;
                    list.remove(i);
                    i--;
                    size--;
                }
                i++;
            }
        }
    }

    private void O000000o(Object obj, O00000Oo o00000Oo) throws Error {
        int i;
        Class cls = obj.getClass();
        if (this.O0000oO) {
            List O00000o = O00000o(cls);
            int i2 = 0;
            i = 0;
            while (i2 < O00000o.size()) {
                i |= O000000o(obj, o00000Oo, (Class) O00000o.get(i2));
                i2++;
            }
        } else {
            i = O000000o(obj, o00000Oo, cls);
        }
        if (i == 0) {
            if (this.O0000o0o) {
                String str = O000000o;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("No subscribers registered for event ");
                stringBuilder.append(cls);
                Log.d(str, stringBuilder.toString());
            }
            if (this.O0000oO0 && cls != O0000Oo0.class && cls != O0000o0.class) {
                O00000o(new O0000Oo0(this, obj));
            }
        }
    }

    private void O000000o(Object obj, O0000o o0000o) {
        Class cls = o0000o.O00000o0;
        O000O00o o000O00o = new O000O00o(obj, o0000o);
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.O00000oO.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.O00000oO.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(o000O00o)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Subscriber ");
            stringBuilder.append(obj.getClass());
            stringBuilder.append(" already registered to event ");
            stringBuilder.append(cls);
            throw new O0000O0o(stringBuilder.toString());
        }
        int size = copyOnWriteArrayList.size();
        int i = 0;
        while (i <= size) {
            if (i == size || o0000o.O00000o > ((O000O00o) copyOnWriteArrayList.get(i)).O00000Oo.O00000o) {
                copyOnWriteArrayList.add(i, o000O00o);
                break;
            }
            i++;
        }
        List list = (List) this.O00000oo.get(obj);
        if (list == null) {
            list = new ArrayList();
            this.O00000oo.put(obj, list);
        }
        list.add(cls);
        if (!o0000o.O00000oO) {
            return;
        }
        if (this.O0000oO) {
            for (Entry entry : this.O0000O0o.entrySet()) {
                if (cls.isAssignableFrom((Class) entry.getKey())) {
                    O00000Oo(o000O00o, entry.getValue());
                }
            }
            return;
        }
        O00000Oo(o000O00o, this.O0000O0o.get(cls));
    }

    static void O000000o(List<Class<?>> list, Class<?>[] clsArr) {
        for (Object obj : clsArr) {
            if (!list.contains(obj)) {
                list.add(obj);
                O000000o((List) list, obj.getInterfaces());
            }
        }
    }

    private void O000000o(O000O00o o000O00o, Object obj, Throwable th) {
        String str;
        StringBuilder stringBuilder;
        if (obj instanceof O0000o0) {
            if (this.O0000o0O) {
                str = O000000o;
                stringBuilder = new StringBuilder();
                stringBuilder.append("SubscriberExceptionEvent subscriber ");
                stringBuilder.append(o000O00o.O000000o.getClass());
                stringBuilder.append(" threw an exception");
                Log.e(str, stringBuilder.toString(), th);
                O0000o0 o0000o0 = (O0000o0) obj;
                String str2 = O000000o;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Initial event ");
                stringBuilder2.append(o0000o0.O00000o0);
                stringBuilder2.append(" caused exception in ");
                stringBuilder2.append(o0000o0.O00000o);
                Log.e(str2, stringBuilder2.toString(), o0000o0.O00000Oo);
            }
        } else if (this.O0000o0) {
            throw new O0000O0o("Invoking subscriber failed", th);
        } else {
            if (this.O0000o0O) {
                str = O000000o;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Could not dispatch event: ");
                stringBuilder.append(obj.getClass());
                stringBuilder.append(" to subscribing class ");
                stringBuilder.append(o000O00o.O000000o.getClass());
                Log.e(str, stringBuilder.toString(), th);
            }
            if (this.O0000o) {
                O00000o(new O0000o0(this, th, obj, o000O00o.O000000o));
            }
        }
    }

    private void O000000o(O000O00o o000O00o, Object obj, boolean z) {
        switch (AnonymousClass2.O000000o[o000O00o.O00000Oo.O00000Oo.ordinal()]) {
            case 1:
                O000000o(o000O00o, obj);
                return;
            case 2:
                if (z) {
                    O000000o(o000O00o, obj);
                    return;
                } else {
                    this.O0000Oo0.O000000o(o000O00o, obj);
                    return;
                }
            case 3:
                if (z) {
                    this.O0000Oo.O000000o(o000O00o, obj);
                    return;
                } else {
                    O000000o(o000O00o, obj);
                    return;
                }
            case 4:
                this.O0000OoO.O000000o(o000O00o, obj);
                return;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown thread mode: ");
                stringBuilder.append(o000O00o.O00000Oo.O00000Oo);
                throw new IllegalStateException(stringBuilder.toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0040 A:{SYNTHETIC, EDGE_INSN: B:24:0x0040->B:17:0x0040 ?: BREAK  } */
    private boolean O000000o(java.lang.Object r5, org.greenrobot.eventbus.O00000o0.O00000Oo r6, java.lang.Class<?> r7) {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r4.O00000oO;	 Catch:{ all -> 0x0043 }
        r7 = r0.get(r7);	 Catch:{ all -> 0x0043 }
        r7 = (java.util.concurrent.CopyOnWriteArrayList) r7;	 Catch:{ all -> 0x0043 }
        monitor-exit(r4);	 Catch:{ all -> 0x0043 }
        r0 = 0;
        if (r7 == 0) goto L_0x0042;
    L_0x000d:
        r1 = r7.isEmpty();
        if (r1 != 0) goto L_0x0042;
    L_0x0013:
        r7 = r7.iterator();
    L_0x0017:
        r1 = r7.hasNext();
        if (r1 == 0) goto L_0x0040;
    L_0x001d:
        r1 = r7.next();
        r1 = (org.greenrobot.eventbus.O000O00o) r1;
        r6.O00000oO = r5;
        r6.O00000o = r1;
        r2 = 0;
        r3 = r6.O00000o0;	 Catch:{ all -> 0x0038 }
        r4.O000000o(r1, r5, r3);	 Catch:{ all -> 0x0038 }
        r1 = r6.O00000oo;	 Catch:{ all -> 0x0038 }
        r6.O00000oO = r2;
        r6.O00000o = r2;
        r6.O00000oo = r0;
        if (r1 == 0) goto L_0x0017;
    L_0x0037:
        goto L_0x0040;
    L_0x0038:
        r5 = move-exception;
        r6.O00000oO = r2;
        r6.O00000o = r2;
        r6.O00000oo = r0;
        throw r5;
    L_0x0040:
        r5 = 1;
        return r5;
    L_0x0042:
        return r0;
    L_0x0043:
        r5 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0043 }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.eventbus.O00000o0.O000000o(java.lang.Object, org.greenrobot.eventbus.O00000o0$O00000Oo, java.lang.Class):boolean");
    }

    public static O00000o O00000Oo() {
        return new O00000o();
    }

    private void O00000Oo(O000O00o o000O00o, Object obj) {
        if (obj != null) {
            O000000o(o000O00o, obj, Looper.getMainLooper() == Looper.myLooper());
        }
    }

    private static List<Class<?>> O00000o(Class<?> cls) {
        List<Class<?>> list;
        synchronized (O00000o) {
            list = (List) O00000o.get(cls);
            if (list == null) {
                list = new ArrayList();
                for (Object obj = cls; obj != null; obj = obj.getSuperclass()) {
                    list.add(obj);
                    O000000o((List) list, obj.getInterfaces());
                }
                O00000o.put(cls, list);
            }
        }
        return list;
    }

    public static void O00000o0() {
        O00oOooO.O000000o();
        O00000o.clear();
    }

    public <T> T O000000o(Class<T> cls) {
        Object cast;
        synchronized (this.O0000O0o) {
            cast = cls.cast(this.O0000O0o.get(cls));
        }
        return cast;
    }

    public void O000000o(Object obj) {
        List<O0000o> O000000o = this.O0000Ooo.O000000o(obj.getClass());
        synchronized (this) {
            for (O0000o O000000o2 : O000000o) {
                O000000o(obj, O000000o2);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(O0000Oo o0000Oo) {
        Object obj = o0000Oo.O000000o;
        O000O00o o000O00o = o0000Oo.O00000Oo;
        O0000Oo.O000000o(o0000Oo);
        if (o000O00o.O00000o0) {
            O000000o(o000O00o, obj);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(O000O00o o000O00o, Object obj) {
        try {
            o000O00o.O00000Oo.O000000o.invoke(o000O00o.O000000o, new Object[]{obj});
        } catch (InvocationTargetException e) {
            O000000o(o000O00o, obj, e.getCause());
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unexpected exception", e2);
        }
    }

    public <T> T O00000Oo(Class<T> cls) {
        Object cast;
        synchronized (this.O0000O0o) {
            cast = cls.cast(this.O0000O0o.remove(cls));
        }
        return cast;
    }

    public synchronized boolean O00000Oo(Object obj) {
        return this.O00000oo.containsKey(obj);
    }

    public void O00000o() {
        synchronized (this.O0000O0o) {
            this.O0000O0o.clear();
        }
    }

    public void O00000o(Object obj) {
        O00000Oo o00000Oo = (O00000Oo) this.O0000OOo.get();
        List list = o00000Oo.O000000o;
        list.add(obj);
        if (!o00000Oo.O00000Oo) {
            o00000Oo.O00000o0 = Looper.getMainLooper() == Looper.myLooper();
            o00000Oo.O00000Oo = true;
            if (o00000Oo.O00000oo) {
                throw new O0000O0o("Internal error. Abort state was not reset");
            }
            while (!list.isEmpty()) {
                try {
                    O000000o(list.remove(0), o00000Oo);
                } finally {
                    o00000Oo.O00000Oo = false;
                    o00000Oo.O00000o0 = false;
                }
            }
        }
    }

    public synchronized void O00000o0(Object obj) {
        List<Class> list = (List) this.O00000oo.get(obj);
        if (list != null) {
            for (Class O000000o : list) {
                O000000o(obj, O000000o);
            }
            this.O00000oo.remove(obj);
        } else {
            String str = O000000o;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Subscriber to unregister was not registered before: ");
            stringBuilder.append(obj.getClass());
            Log.w(str, stringBuilder.toString());
        }
    }

    public boolean O00000o0(Class<?> cls) {
        List O00000o = O00000o((Class) cls);
        if (O00000o != null) {
            int size = O00000o.size();
            for (int i = 0; i < size; i++) {
                CopyOnWriteArrayList copyOnWriteArrayList;
                Class cls2 = (Class) O00000o.get(i);
                synchronized (this) {
                    copyOnWriteArrayList = (CopyOnWriteArrayList) this.O00000oO.get(cls2);
                }
                if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    public ExecutorService O00000oO() {
        return this.O0000o00;
    }

    public void O00000oO(Object obj) {
        O00000Oo o00000Oo = (O00000Oo) this.O0000OOo.get();
        if (!o00000Oo.O00000Oo) {
            throw new O0000O0o("This method may only be called from inside event handling methods on the posting thread");
        } else if (obj == null) {
            throw new O0000O0o("Event may not be null");
        } else if (o00000Oo.O00000oO != obj) {
            throw new O0000O0o("Only the currently handled event may be aborted");
        } else if (o00000Oo.O00000o.O00000Oo.O00000Oo != ThreadMode.POSTING) {
            throw new O0000O0o(" event handlers may only abort the incoming event");
        } else {
            o00000Oo.O00000oo = true;
        }
    }

    public void O00000oo(Object obj) {
        synchronized (this.O0000O0o) {
            this.O0000O0o.put(obj.getClass(), obj);
        }
        O00000o(obj);
    }

    public boolean O0000O0o(Object obj) {
        synchronized (this.O0000O0o) {
            Class cls = obj.getClass();
            if (obj.equals(this.O0000O0o.get(cls))) {
                this.O0000O0o.remove(cls);
                return true;
            }
            return false;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EventBus[indexCount=");
        stringBuilder.append(this.O0000oOO);
        stringBuilder.append(", eventInheritance=");
        stringBuilder.append(this.O0000oO);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
