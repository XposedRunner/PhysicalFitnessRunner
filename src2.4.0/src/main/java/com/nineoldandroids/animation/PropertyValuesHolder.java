package com.nineoldandroids.animation;

import android.util.Log;
import com.nineoldandroids.util.FloatProperty;
import com.nineoldandroids.util.IntProperty;
import com.nineoldandroids.util.Property;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PropertyValuesHolder implements Cloneable {
    private static Class[] DOUBLE_VARIANTS = new Class[]{Double.TYPE, Double.class, Float.TYPE, Integer.TYPE, Float.class, Integer.class};
    private static Class[] FLOAT_VARIANTS = new Class[]{Float.TYPE, Float.class, Double.TYPE, Integer.TYPE, Double.class, Integer.class};
    private static Class[] INTEGER_VARIANTS = new Class[]{Integer.TYPE, Integer.class, Float.TYPE, Double.TYPE, Float.class, Double.class};
    private static final TypeEvaluator sFloatEvaluator = new FloatEvaluator();
    private static final HashMap<Class, HashMap<String, Method>> sGetterPropertyMap = new HashMap();
    private static final TypeEvaluator sIntEvaluator = new IntEvaluator();
    private static final HashMap<Class, HashMap<String, Method>> sSetterPropertyMap = new HashMap();
    private Object mAnimatedValue;
    private TypeEvaluator mEvaluator;
    private Method mGetter;
    KeyframeSet mKeyframeSet;
    protected Property mProperty;
    final ReentrantReadWriteLock mPropertyMapLock;
    String mPropertyName;
    Method mSetter;
    final Object[] mTmpValueArray;
    Class mValueType;

    static class FloatPropertyValuesHolder extends PropertyValuesHolder {
        float mFloatAnimatedValue;
        FloatKeyframeSet mFloatKeyframeSet;
        private FloatProperty mFloatProperty;

        public FloatPropertyValuesHolder(Property property, FloatKeyframeSet floatKeyframeSet) {
            super(property, null);
            this.mValueType = Float.TYPE;
            this.mKeyframeSet = floatKeyframeSet;
            this.mFloatKeyframeSet = (FloatKeyframeSet) this.mKeyframeSet;
            if (property instanceof FloatProperty) {
                this.mFloatProperty = (FloatProperty) this.mProperty;
            }
        }

        public FloatPropertyValuesHolder(Property property, float... fArr) {
            super(property, null);
            setFloatValues(fArr);
            if (property instanceof FloatProperty) {
                this.mFloatProperty = (FloatProperty) this.mProperty;
            }
        }

        public FloatPropertyValuesHolder(String str, FloatKeyframeSet floatKeyframeSet) {
            super(str, null);
            this.mValueType = Float.TYPE;
            this.mKeyframeSet = floatKeyframeSet;
            this.mFloatKeyframeSet = (FloatKeyframeSet) this.mKeyframeSet;
        }

        public FloatPropertyValuesHolder(String str, float... fArr) {
            super(str, null);
            setFloatValues(fArr);
        }

        /* Access modifiers changed, original: 0000 */
        public void calculateValue(float f) {
            this.mFloatAnimatedValue = this.mFloatKeyframeSet.getFloatValue(f);
        }

        public FloatPropertyValuesHolder clone() {
            FloatPropertyValuesHolder floatPropertyValuesHolder = (FloatPropertyValuesHolder) super.clone();
            floatPropertyValuesHolder.mFloatKeyframeSet = (FloatKeyframeSet) floatPropertyValuesHolder.mKeyframeSet;
            return floatPropertyValuesHolder;
        }

        /* Access modifiers changed, original: 0000 */
        public Object getAnimatedValue() {
            return Float.valueOf(this.mFloatAnimatedValue);
        }

        /* Access modifiers changed, original: 0000 */
        public void setAnimatedValue(Object obj) {
            if (this.mFloatProperty != null) {
                this.mFloatProperty.setValue(obj, this.mFloatAnimatedValue);
            } else if (this.mProperty != null) {
                this.mProperty.set(obj, Float.valueOf(this.mFloatAnimatedValue));
            } else {
                if (this.mSetter != null) {
                    try {
                        this.mTmpValueArray[0] = Float.valueOf(this.mFloatAnimatedValue);
                        this.mSetter.invoke(obj, this.mTmpValueArray);
                    } catch (InvocationTargetException e) {
                        Log.e("PropertyValuesHolder", e.toString());
                    } catch (IllegalAccessException e2) {
                        Log.e("PropertyValuesHolder", e2.toString());
                    }
                }
            }
        }

        public void setFloatValues(float... fArr) {
            super.setFloatValues(fArr);
            this.mFloatKeyframeSet = (FloatKeyframeSet) this.mKeyframeSet;
        }

        /* Access modifiers changed, original: 0000 */
        public void setupSetter(Class cls) {
            if (this.mProperty == null) {
                super.setupSetter(cls);
            }
        }
    }

    static class IntPropertyValuesHolder extends PropertyValuesHolder {
        int mIntAnimatedValue;
        IntKeyframeSet mIntKeyframeSet;
        private IntProperty mIntProperty;

        public IntPropertyValuesHolder(Property property, IntKeyframeSet intKeyframeSet) {
            super(property, null);
            this.mValueType = Integer.TYPE;
            this.mKeyframeSet = intKeyframeSet;
            this.mIntKeyframeSet = (IntKeyframeSet) this.mKeyframeSet;
            if (property instanceof IntProperty) {
                this.mIntProperty = (IntProperty) this.mProperty;
            }
        }

        public IntPropertyValuesHolder(Property property, int... iArr) {
            super(property, null);
            setIntValues(iArr);
            if (property instanceof IntProperty) {
                this.mIntProperty = (IntProperty) this.mProperty;
            }
        }

        public IntPropertyValuesHolder(String str, IntKeyframeSet intKeyframeSet) {
            super(str, null);
            this.mValueType = Integer.TYPE;
            this.mKeyframeSet = intKeyframeSet;
            this.mIntKeyframeSet = (IntKeyframeSet) this.mKeyframeSet;
        }

        public IntPropertyValuesHolder(String str, int... iArr) {
            super(str, null);
            setIntValues(iArr);
        }

        /* Access modifiers changed, original: 0000 */
        public void calculateValue(float f) {
            this.mIntAnimatedValue = this.mIntKeyframeSet.getIntValue(f);
        }

        public IntPropertyValuesHolder clone() {
            IntPropertyValuesHolder intPropertyValuesHolder = (IntPropertyValuesHolder) super.clone();
            intPropertyValuesHolder.mIntKeyframeSet = (IntKeyframeSet) intPropertyValuesHolder.mKeyframeSet;
            return intPropertyValuesHolder;
        }

        /* Access modifiers changed, original: 0000 */
        public Object getAnimatedValue() {
            return Integer.valueOf(this.mIntAnimatedValue);
        }

        /* Access modifiers changed, original: 0000 */
        public void setAnimatedValue(Object obj) {
            if (this.mIntProperty != null) {
                this.mIntProperty.setValue(obj, this.mIntAnimatedValue);
            } else if (this.mProperty != null) {
                this.mProperty.set(obj, Integer.valueOf(this.mIntAnimatedValue));
            } else {
                if (this.mSetter != null) {
                    try {
                        this.mTmpValueArray[0] = Integer.valueOf(this.mIntAnimatedValue);
                        this.mSetter.invoke(obj, this.mTmpValueArray);
                    } catch (InvocationTargetException e) {
                        Log.e("PropertyValuesHolder", e.toString());
                    } catch (IllegalAccessException e2) {
                        Log.e("PropertyValuesHolder", e2.toString());
                    }
                }
            }
        }

        public void setIntValues(int... iArr) {
            super.setIntValues(iArr);
            this.mIntKeyframeSet = (IntKeyframeSet) this.mKeyframeSet;
        }

        /* Access modifiers changed, original: 0000 */
        public void setupSetter(Class cls) {
            if (this.mProperty == null) {
                super.setupSetter(cls);
            }
        }
    }

    private PropertyValuesHolder(Property property) {
        this.mSetter = null;
        this.mGetter = null;
        this.mKeyframeSet = null;
        this.mPropertyMapLock = new ReentrantReadWriteLock();
        this.mTmpValueArray = new Object[1];
        this.mProperty = property;
        if (property != null) {
            this.mPropertyName = property.getName();
        }
    }

    private PropertyValuesHolder(String str) {
        this.mSetter = null;
        this.mGetter = null;
        this.mKeyframeSet = null;
        this.mPropertyMapLock = new ReentrantReadWriteLock();
        this.mTmpValueArray = new Object[1];
        this.mPropertyName = str;
    }

    static String getMethodName(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        char toUpperCase = Character.toUpperCase(str2.charAt(0));
        str2 = str2.substring(1);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(toUpperCase);
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x007e */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:35:?, code skipped:
            r7 = r9.getDeclaredMethod(r10, r11);
     */
    /* JADX WARNING: Missing block: B:37:?, code skipped:
            r7.setAccessible(true);
            r8.mValueType = r6;
     */
    /* JADX WARNING: Missing block: B:38:0x0087, code skipped:
            return r7;
     */
    /* JADX WARNING: Missing block: B:39:0x0088, code skipped:
            r5 = r7;
     */
    /* JADX WARNING: Missing block: B:41:0x0089, code skipped:
            r0 = r0 + 1;
     */
    private java.lang.reflect.Method getPropertyFunction(java.lang.Class r9, java.lang.String r10, java.lang.Class r11) {
        /*
        r8 = this;
        r0 = r8.mPropertyName;
        r10 = getMethodName(r10, r0);
        r0 = 0;
        r1 = 1;
        if (r11 != 0) goto L_0x003d;
    L_0x000a:
        r11 = r9.getMethod(r10, r0);	 Catch:{ NoSuchMethodException -> 0x0010 }
        goto L_0x00af;
    L_0x0010:
        r11 = move-exception;
        r9 = r9.getDeclaredMethod(r10, r0);	 Catch:{ NoSuchMethodException -> 0x0019 }
        r9.setAccessible(r1);	 Catch:{ NoSuchMethodException -> 0x001a }
        goto L_0x003a;
    L_0x0019:
        r9 = r0;
    L_0x001a:
        r10 = "PropertyValuesHolder";
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Couldn't find no-arg method for property ";
        r0.append(r1);
        r1 = r8.mPropertyName;
        r0.append(r1);
        r1 = ": ";
        r0.append(r1);
        r0.append(r11);
        r11 = r0.toString();
        android.util.Log.e(r10, r11);
    L_0x003a:
        r11 = r9;
        goto L_0x00af;
    L_0x003d:
        r11 = new java.lang.Class[r1];
        r2 = r8.mValueType;
        r3 = java.lang.Float.class;
        r2 = r2.equals(r3);
        r3 = 0;
        if (r2 == 0) goto L_0x004d;
    L_0x004a:
        r2 = FLOAT_VARIANTS;
        goto L_0x006d;
    L_0x004d:
        r2 = r8.mValueType;
        r4 = java.lang.Integer.class;
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x005a;
    L_0x0057:
        r2 = INTEGER_VARIANTS;
        goto L_0x006d;
    L_0x005a:
        r2 = r8.mValueType;
        r4 = java.lang.Double.class;
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x0067;
    L_0x0064:
        r2 = DOUBLE_VARIANTS;
        goto L_0x006d;
    L_0x0067:
        r2 = new java.lang.Class[r1];
        r4 = r8.mValueType;
        r2[r3] = r4;
    L_0x006d:
        r4 = r2.length;
        r5 = r0;
        r0 = r3;
    L_0x0070:
        if (r0 >= r4) goto L_0x008c;
    L_0x0072:
        r6 = r2[r0];
        r11[r3] = r6;
        r7 = r9.getMethod(r10, r11);	 Catch:{ NoSuchMethodException -> 0x007e }
        r8.mValueType = r6;	 Catch:{ NoSuchMethodException -> 0x007d }
        return r7;
    L_0x007d:
        r5 = r7;
    L_0x007e:
        r7 = r9.getDeclaredMethod(r10, r11);	 Catch:{ NoSuchMethodException -> 0x0089 }
        r7.setAccessible(r1);	 Catch:{ NoSuchMethodException -> 0x0088 }
        r8.mValueType = r6;	 Catch:{ NoSuchMethodException -> 0x0088 }
        return r7;
    L_0x0088:
        r5 = r7;
    L_0x0089:
        r0 = r0 + 1;
        goto L_0x0070;
    L_0x008c:
        r9 = "PropertyValuesHolder";
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r11 = "Couldn't find setter/getter for property ";
        r10.append(r11);
        r11 = r8.mPropertyName;
        r10.append(r11);
        r11 = " with value type ";
        r10.append(r11);
        r11 = r8.mValueType;
        r10.append(r11);
        r10 = r10.toString();
        android.util.Log.e(r9, r10);
        r11 = r5;
    L_0x00af:
        return r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nineoldandroids.animation.PropertyValuesHolder.getPropertyFunction(java.lang.Class, java.lang.String, java.lang.Class):java.lang.reflect.Method");
    }

    public static PropertyValuesHolder ofFloat(Property<?, Float> property, float... fArr) {
        return new FloatPropertyValuesHolder((Property) property, fArr);
    }

    public static PropertyValuesHolder ofFloat(String str, float... fArr) {
        return new FloatPropertyValuesHolder(str, fArr);
    }

    public static PropertyValuesHolder ofInt(Property<?, Integer> property, int... iArr) {
        return new IntPropertyValuesHolder((Property) property, iArr);
    }

    public static PropertyValuesHolder ofInt(String str, int... iArr) {
        return new IntPropertyValuesHolder(str, iArr);
    }

    public static PropertyValuesHolder ofKeyframe(Property property, Keyframe... keyframeArr) {
        KeyframeSet ofKeyframe = KeyframeSet.ofKeyframe(keyframeArr);
        if (ofKeyframe instanceof IntKeyframeSet) {
            return new IntPropertyValuesHolder(property, (IntKeyframeSet) ofKeyframe);
        }
        if (ofKeyframe instanceof FloatKeyframeSet) {
            return new FloatPropertyValuesHolder(property, (FloatKeyframeSet) ofKeyframe);
        }
        PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(property);
        propertyValuesHolder.mKeyframeSet = ofKeyframe;
        propertyValuesHolder.mValueType = keyframeArr[0].getType();
        return propertyValuesHolder;
    }

    public static PropertyValuesHolder ofKeyframe(String str, Keyframe... keyframeArr) {
        KeyframeSet ofKeyframe = KeyframeSet.ofKeyframe(keyframeArr);
        if (ofKeyframe instanceof IntKeyframeSet) {
            return new IntPropertyValuesHolder(str, (IntKeyframeSet) ofKeyframe);
        }
        if (ofKeyframe instanceof FloatKeyframeSet) {
            return new FloatPropertyValuesHolder(str, (FloatKeyframeSet) ofKeyframe);
        }
        PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(str);
        propertyValuesHolder.mKeyframeSet = ofKeyframe;
        propertyValuesHolder.mValueType = keyframeArr[0].getType();
        return propertyValuesHolder;
    }

    public static <V> PropertyValuesHolder ofObject(Property property, TypeEvaluator<V> typeEvaluator, V... vArr) {
        PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(property);
        propertyValuesHolder.setObjectValues(vArr);
        propertyValuesHolder.setEvaluator(typeEvaluator);
        return propertyValuesHolder;
    }

    public static PropertyValuesHolder ofObject(String str, TypeEvaluator typeEvaluator, Object... objArr) {
        PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(str);
        propertyValuesHolder.setObjectValues(objArr);
        propertyValuesHolder.setEvaluator(typeEvaluator);
        return propertyValuesHolder;
    }

    private void setupGetter(Class cls) {
        this.mGetter = setupSetterOrGetter(cls, sGetterPropertyMap, "get", null);
    }

    private Method setupSetterOrGetter(Class cls, HashMap<Class, HashMap<String, Method>> hashMap, String str, Class cls2) {
        try {
            this.mPropertyMapLock.writeLock().lock();
            HashMap hashMap2 = (HashMap) hashMap.get(cls);
            Method method = hashMap2 != null ? (Method) hashMap2.get(this.mPropertyName) : null;
            if (method == null) {
                method = getPropertyFunction(cls, str, cls2);
                if (hashMap2 == null) {
                    hashMap2 = new HashMap();
                    hashMap.put(cls, hashMap2);
                }
                hashMap2.put(this.mPropertyName, method);
            }
            this.mPropertyMapLock.writeLock().unlock();
            return method;
        } catch (Throwable th) {
            this.mPropertyMapLock.writeLock().unlock();
        }
    }

    private void setupValue(Object obj, Keyframe keyframe) {
        if (this.mProperty != null) {
            keyframe.setValue(this.mProperty.get(obj));
        }
        try {
            if (this.mGetter == null) {
                setupGetter(obj.getClass());
            }
            keyframe.setValue(this.mGetter.invoke(obj, new Object[0]));
        } catch (InvocationTargetException e) {
            Log.e("PropertyValuesHolder", e.toString());
        } catch (IllegalAccessException e2) {
            Log.e("PropertyValuesHolder", e2.toString());
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void calculateValue(float f) {
        this.mAnimatedValue = this.mKeyframeSet.getValue(f);
    }

    public PropertyValuesHolder clone() {
        try {
            PropertyValuesHolder propertyValuesHolder = (PropertyValuesHolder) super.clone();
            propertyValuesHolder.mPropertyName = this.mPropertyName;
            propertyValuesHolder.mProperty = this.mProperty;
            propertyValuesHolder.mKeyframeSet = this.mKeyframeSet.clone();
            propertyValuesHolder.mEvaluator = this.mEvaluator;
            return propertyValuesHolder;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public Object getAnimatedValue() {
        return this.mAnimatedValue;
    }

    public String getPropertyName() {
        return this.mPropertyName;
    }

    /* Access modifiers changed, original: 0000 */
    public void init() {
        if (this.mEvaluator == null) {
            TypeEvaluator typeEvaluator = this.mValueType == Integer.class ? sIntEvaluator : this.mValueType == Float.class ? sFloatEvaluator : null;
            this.mEvaluator = typeEvaluator;
        }
        if (this.mEvaluator != null) {
            this.mKeyframeSet.setEvaluator(this.mEvaluator);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void setAnimatedValue(Object obj) {
        if (this.mProperty != null) {
            this.mProperty.set(obj, getAnimatedValue());
        }
        if (this.mSetter != null) {
            try {
                this.mTmpValueArray[0] = getAnimatedValue();
                this.mSetter.invoke(obj, this.mTmpValueArray);
            } catch (InvocationTargetException e) {
                Log.e("PropertyValuesHolder", e.toString());
            } catch (IllegalAccessException e2) {
                Log.e("PropertyValuesHolder", e2.toString());
            }
        }
    }

    public void setEvaluator(TypeEvaluator typeEvaluator) {
        this.mEvaluator = typeEvaluator;
        this.mKeyframeSet.setEvaluator(typeEvaluator);
    }

    public void setFloatValues(float... fArr) {
        this.mValueType = Float.TYPE;
        this.mKeyframeSet = KeyframeSet.ofFloat(fArr);
    }

    public void setIntValues(int... iArr) {
        this.mValueType = Integer.TYPE;
        this.mKeyframeSet = KeyframeSet.ofInt(iArr);
    }

    public void setKeyframes(Keyframe... keyframeArr) {
        int i = 0;
        int length = keyframeArr.length;
        Keyframe[] keyframeArr2 = new Keyframe[Math.max(length, 2)];
        this.mValueType = keyframeArr[0].getType();
        while (i < length) {
            keyframeArr2[i] = keyframeArr[i];
            i++;
        }
        this.mKeyframeSet = new KeyframeSet(keyframeArr2);
    }

    public void setObjectValues(Object... objArr) {
        this.mValueType = objArr[0].getClass();
        this.mKeyframeSet = KeyframeSet.ofObject(objArr);
    }

    public void setProperty(Property property) {
        this.mProperty = property;
    }

    public void setPropertyName(String str) {
        this.mPropertyName = str;
    }

    /* Access modifiers changed, original: 0000 */
    public void setupEndValue(Object obj) {
        setupValue(obj, (Keyframe) this.mKeyframeSet.mKeyframes.get(this.mKeyframeSet.mKeyframes.size() - 1));
    }

    /* Access modifiers changed, original: 0000 */
    public void setupSetter(Class cls) {
        this.mSetter = setupSetterOrGetter(cls, sSetterPropertyMap, "set", this.mValueType);
    }

    /* Access modifiers changed, original: 0000 */
    public void setupSetterAndGetter(Object obj) {
        if (this.mProperty != null) {
            try {
                this.mProperty.get(obj);
                Iterator it = this.mKeyframeSet.mKeyframes.iterator();
                while (it.hasNext()) {
                    Keyframe keyframe = (Keyframe) it.next();
                    if (!keyframe.hasValue()) {
                        keyframe.setValue(this.mProperty.get(obj));
                    }
                }
                return;
            } catch (ClassCastException unused) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("No such property (");
                stringBuilder.append(this.mProperty.getName());
                stringBuilder.append(") on target object ");
                stringBuilder.append(obj);
                stringBuilder.append(". Trying reflection instead");
                Log.e("PropertyValuesHolder", stringBuilder.toString());
                this.mProperty = null;
            }
        }
        Class cls = obj.getClass();
        if (this.mSetter == null) {
            setupSetter(cls);
        }
        Iterator it2 = this.mKeyframeSet.mKeyframes.iterator();
        while (it2.hasNext()) {
            Keyframe keyframe2 = (Keyframe) it2.next();
            if (!keyframe2.hasValue()) {
                if (this.mGetter == null) {
                    setupGetter(cls);
                }
                try {
                    keyframe2.setValue(this.mGetter.invoke(obj, new Object[0]));
                } catch (InvocationTargetException e) {
                    Log.e("PropertyValuesHolder", e.toString());
                } catch (IllegalAccessException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                }
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void setupStartValue(Object obj) {
        setupValue(obj, (Keyframe) this.mKeyframeSet.mKeyframes.get(0));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mPropertyName);
        stringBuilder.append(": ");
        stringBuilder.append(this.mKeyframeSet.toString());
        return stringBuilder.toString();
    }
}
