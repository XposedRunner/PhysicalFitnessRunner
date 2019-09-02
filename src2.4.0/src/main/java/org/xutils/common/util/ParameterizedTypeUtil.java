package org.xutils.common.util;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class ParameterizedTypeUtil {
    private ParameterizedTypeUtil() {
    }

    public static Type getParameterizedType(Type type, Class<?> cls, int i) {
        TypeVariable[] typeParameters;
        Class<?> cls2;
        Type[] typeArr = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class<?> cls3 = (Class) parameterizedType.getRawType();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            typeParameters = cls3.getTypeParameters();
            Class<?> cls4 = cls3;
            typeArr = actualTypeArguments;
            cls2 = cls4;
        } else {
            cls2 = (Class) type;
            typeParameters = null;
        }
        if (cls == cls2) {
            return typeArr != null ? typeArr[i] : Object.class;
        } else {
            Type[] genericInterfaces = cls2.getGenericInterfaces();
            if (genericInterfaces != null) {
                for (Type type2 : genericInterfaces) {
                    if ((type2 instanceof ParameterizedType) && cls.isAssignableFrom((Class) ((ParameterizedType) type2).getRawType())) {
                        try {
                            return getTrueType(getParameterizedType(type2, cls, i), typeParameters, typeArr);
                        } catch (Throwable unused) {
                            continue;
                        }
                    }
                }
            }
            Class superclass = cls2.getSuperclass();
            if (superclass != null && cls.isAssignableFrom(superclass)) {
                return getTrueType(getParameterizedType(cls2.getGenericSuperclass(), cls, i), typeParameters, typeArr);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("FindGenericType:");
            stringBuilder.append(type);
            stringBuilder.append(", declaredClass: ");
            stringBuilder.append(cls);
            stringBuilder.append(", index: ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    private static Type getTrueType(Type type, TypeVariable<?>[] typeVariableArr, Type[] typeArr) {
        int i = 0;
        if (type instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type;
            String name = typeVariable.getName();
            if (typeArr != null) {
                while (i < typeVariableArr.length) {
                    if (name.equals(typeVariableArr[i].getName())) {
                        return typeArr[i];
                    }
                    i++;
                }
            }
            return typeVariable;
        }
        if (type instanceof GenericArrayType) {
            Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
            if (genericComponentType instanceof Class) {
                return Array.newInstance((Class) genericComponentType, 0).getClass();
            }
        }
        return type;
    }
}
