package com.nineoldandroids.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ReflectiveProperty<T, V> extends Property<T, V> {
    private static final String PREFIX_GET = "get";
    private static final String PREFIX_IS = "is";
    private static final String PREFIX_SET = "set";
    private Field mField;
    private Method mGetter;
    private Method mSetter;

    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x003c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0066 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x00c9 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:6|5|7|8|9|10) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:20|21|(2:23|24)(1:25)) */
    /* JADX WARNING: Missing block: B:21:?, code skipped:
            r6.mField = r7.getField(r9);
            r7 = r6.mField.getType();
     */
    /* JADX WARNING: Missing block: B:22:0x00d9, code skipped:
            if (typesMatch(r8, r7) == false) goto L_0x00db;
     */
    /* JADX WARNING: Missing block: B:23:0x00db, code skipped:
            r1 = new java.lang.StringBuilder();
            r1.append("Underlying type (");
            r1.append(r7);
            r1.append(") ");
            r1.append("does not match Property type (");
            r1.append(r8);
            r1.append(")");
     */
    /* JADX WARNING: Missing block: B:24:0x0103, code skipped:
            throw new com.nineoldandroids.util.NoSuchPropertyException(r1.toString());
     */
    /* JADX WARNING: Missing block: B:25:0x0104, code skipped:
            return;
     */
    public ReflectiveProperty(java.lang.Class<T> r7, java.lang.Class<V> r8, java.lang.String r9) {
        /*
        r6 = this;
        r6.<init>(r8, r9);
        r0 = 0;
        r1 = r9.charAt(r0);
        r1 = java.lang.Character.toUpperCase(r1);
        r2 = 1;
        r3 = r9.substring(r2);
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r1);
        r4.append(r3);
        r1 = r4.toString();
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "get";
        r3.append(r4);
        r3.append(r1);
        r3 = r3.toString();
        r4 = 0;
        r5 = r4;
        r5 = (java.lang.Class[]) r5;	 Catch:{ NoSuchMethodException -> 0x003c }
        r5 = r7.getMethod(r3, r5);	 Catch:{ NoSuchMethodException -> 0x003c }
        r6.mGetter = r5;	 Catch:{ NoSuchMethodException -> 0x003c }
        goto L_0x0073;
    L_0x003c:
        r5 = r4;
        r5 = (java.lang.Class[]) r5;	 Catch:{ NoSuchMethodException -> 0x004b }
        r3 = r7.getDeclaredMethod(r3, r5);	 Catch:{ NoSuchMethodException -> 0x004b }
        r6.mGetter = r3;	 Catch:{ NoSuchMethodException -> 0x004b }
        r3 = r6.mGetter;	 Catch:{ NoSuchMethodException -> 0x004b }
        r3.setAccessible(r2);	 Catch:{ NoSuchMethodException -> 0x004b }
        goto L_0x0073;
    L_0x004b:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r5 = "is";
        r3.append(r5);
        r3.append(r1);
        r3 = r3.toString();
        r5 = r4;
        r5 = (java.lang.Class[]) r5;	 Catch:{ NoSuchMethodException -> 0x0066 }
        r5 = r7.getMethod(r3, r5);	 Catch:{ NoSuchMethodException -> 0x0066 }
        r6.mGetter = r5;	 Catch:{ NoSuchMethodException -> 0x0066 }
        goto L_0x0073;
    L_0x0066:
        r4 = (java.lang.Class[]) r4;	 Catch:{ NoSuchMethodException -> 0x00c9 }
        r3 = r7.getDeclaredMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x00c9 }
        r6.mGetter = r3;	 Catch:{ NoSuchMethodException -> 0x00c9 }
        r3 = r6.mGetter;	 Catch:{ NoSuchMethodException -> 0x00c9 }
        r3.setAccessible(r2);	 Catch:{ NoSuchMethodException -> 0x00c9 }
    L_0x0073:
        r9 = r6.mGetter;
        r9 = r9.getReturnType();
        r3 = r6.typesMatch(r8, r9);
        if (r3 != 0) goto L_0x00a8;
    L_0x007f:
        r7 = new com.nineoldandroids.util.NoSuchPropertyException;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Underlying type (";
        r0.append(r1);
        r0.append(r9);
        r9 = ") ";
        r0.append(r9);
        r9 = "does not match Property type (";
        r0.append(r9);
        r0.append(r8);
        r8 = ")";
        r0.append(r8);
        r8 = r0.toString();
        r7.<init>(r8);
        throw r7;
    L_0x00a8:
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r3 = "set";
        r8.append(r3);
        r8.append(r1);
        r8 = r8.toString();
        r1 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x00c8 }
        r1[r0] = r9;	 Catch:{ NoSuchMethodException -> 0x00c8 }
        r7 = r7.getDeclaredMethod(r8, r1);	 Catch:{ NoSuchMethodException -> 0x00c8 }
        r6.mSetter = r7;	 Catch:{ NoSuchMethodException -> 0x00c8 }
        r7 = r6.mSetter;	 Catch:{ NoSuchMethodException -> 0x00c8 }
        r7.setAccessible(r2);	 Catch:{ NoSuchMethodException -> 0x00c8 }
    L_0x00c8:
        return;
    L_0x00c9:
        r7 = r7.getField(r9);	 Catch:{ NoSuchFieldException -> 0x0105 }
        r6.mField = r7;	 Catch:{ NoSuchFieldException -> 0x0105 }
        r7 = r6.mField;	 Catch:{ NoSuchFieldException -> 0x0105 }
        r7 = r7.getType();	 Catch:{ NoSuchFieldException -> 0x0105 }
        r0 = r6.typesMatch(r8, r7);	 Catch:{ NoSuchFieldException -> 0x0105 }
        if (r0 != 0) goto L_0x0104;
    L_0x00db:
        r0 = new com.nineoldandroids.util.NoSuchPropertyException;	 Catch:{ NoSuchFieldException -> 0x0105 }
        r1 = new java.lang.StringBuilder;	 Catch:{ NoSuchFieldException -> 0x0105 }
        r1.<init>();	 Catch:{ NoSuchFieldException -> 0x0105 }
        r2 = "Underlying type (";
        r1.append(r2);	 Catch:{ NoSuchFieldException -> 0x0105 }
        r1.append(r7);	 Catch:{ NoSuchFieldException -> 0x0105 }
        r7 = ") ";
        r1.append(r7);	 Catch:{ NoSuchFieldException -> 0x0105 }
        r7 = "does not match Property type (";
        r1.append(r7);	 Catch:{ NoSuchFieldException -> 0x0105 }
        r1.append(r8);	 Catch:{ NoSuchFieldException -> 0x0105 }
        r7 = ")";
        r1.append(r7);	 Catch:{ NoSuchFieldException -> 0x0105 }
        r7 = r1.toString();	 Catch:{ NoSuchFieldException -> 0x0105 }
        r0.<init>(r7);	 Catch:{ NoSuchFieldException -> 0x0105 }
        throw r0;	 Catch:{ NoSuchFieldException -> 0x0105 }
    L_0x0104:
        return;
    L_0x0105:
        r7 = new com.nineoldandroids.util.NoSuchPropertyException;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r0 = "No accessor method or field found for property with name ";
        r8.append(r0);
        r8.append(r9);
        r8 = r8.toString();
        r7.<init>(r8);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nineoldandroids.util.ReflectiveProperty.<init>(java.lang.Class, java.lang.Class, java.lang.String):void");
    }

    private boolean typesMatch(Class<V> cls, Class cls2) {
        boolean z = true;
        if (cls2 == cls) {
            return true;
        }
        if (!cls2.isPrimitive()) {
            return false;
        }
        if (!((cls2 == Float.TYPE && cls == Float.class) || ((cls2 == Integer.TYPE && cls == Integer.class) || ((cls2 == Boolean.TYPE && cls == Boolean.class) || ((cls2 == Long.TYPE && cls == Long.class) || ((cls2 == Double.TYPE && cls == Double.class) || ((cls2 == Short.TYPE && cls == Short.class) || ((cls2 == Byte.TYPE && cls == Byte.class) || (cls2 == Character.TYPE && cls == Character.class))))))))) {
            z = false;
        }
        return z;
    }

    public V get(T t) {
        if (this.mGetter != null) {
            try {
                return this.mGetter.invoke(t, (Object[]) null);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        } else if (this.mField != null) {
            try {
                return this.mField.get(t);
            } catch (IllegalAccessException unused2) {
                throw new AssertionError();
            }
        } else {
            throw new AssertionError();
        }
    }

    public boolean isReadOnly() {
        return this.mSetter == null && this.mField == null;
    }

    public void set(T t, V v) {
        if (this.mSetter != null) {
            try {
                this.mSetter.invoke(t, new Object[]{v});
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        } else if (this.mField != null) {
            try {
                this.mField.set(t, v);
            } catch (IllegalAccessException unused2) {
                throw new AssertionError();
            }
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Property ");
            stringBuilder.append(getName());
            stringBuilder.append(" is read-only");
            throw new UnsupportedOperationException(stringBuilder.toString());
        }
    }
}
