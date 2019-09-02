package com.qiyukf.nimlib.d.a.d;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static Object a(JSONObject jSONObject, Class<?> cls) {
        IllegalArgumentException e;
        IllegalAccessException e2;
        JSONException e3;
        InstantiationException e4;
        Exception e5;
        Object newInstance;
        try {
            newInstance = cls.newInstance();
            try {
                a(newInstance, jSONObject, cls);
                return newInstance;
            } catch (IllegalArgumentException e6) {
                e = e6;
                e.printStackTrace();
                return newInstance;
            } catch (IllegalAccessException e7) {
                e2 = e7;
                e2.printStackTrace();
                return newInstance;
            } catch (JSONException e8) {
                e3 = e8;
                e3.printStackTrace();
                return newInstance;
            } catch (InstantiationException e9) {
                e4 = e9;
                e4.printStackTrace();
                return newInstance;
            } catch (Exception e10) {
                e5 = e10;
                e5.printStackTrace();
                return newInstance;
            }
        } catch (IllegalArgumentException e11) {
            e = e11;
            newInstance = null;
            e.printStackTrace();
            return newInstance;
        } catch (IllegalAccessException e12) {
            e2 = e12;
            newInstance = null;
            e2.printStackTrace();
            return newInstance;
        } catch (JSONException e13) {
            e3 = e13;
            newInstance = null;
            e3.printStackTrace();
            return newInstance;
        } catch (InstantiationException e14) {
            e4 = e14;
            newInstance = null;
            e4.printStackTrace();
            return newInstance;
        } catch (Exception e15) {
            e5 = e15;
            newInstance = null;
            e5.printStackTrace();
            return newInstance;
        }
    }

    private static void a(Object obj, JSONObject jSONObject, Class<?> cls) {
        if (cls.getSuperclass() != null) {
            a(obj, jSONObject, cls.getSuperclass());
        }
        for (Field field : cls.getDeclaredFields()) {
            boolean z = true;
            field.setAccessible(true);
            Class type = field.getType();
            String name = field.getName();
            if (jSONObject.has(name)) {
                Object valueOf;
                if (!type.isPrimitive()) {
                    if (!(type.getName().equals(Boolean.class.getName()) || type.getName().equals(Byte.class.getName()) || type.getName().equals(Character.class.getName()) || type.getName().equals(Short.class.getName()) || type.getName().equals(Integer.class.getName()) || type.getName().equals(Long.class.getName()) || type.getName().equals(Float.class.getName()) || type.getName().equals(Double.class.getName()))) {
                        z = false;
                    }
                    if (!z) {
                        if (type.isAssignableFrom(String.class)) {
                            valueOf = String.valueOf(jSONObject.get(name));
                        } else if (type.isAssignableFrom(ArrayList.class)) {
                            valueOf = new ArrayList();
                            Type genericType = field.getGenericType();
                            if (genericType instanceof ParameterizedType) {
                                ParameterizedType parameterizedType = (ParameterizedType) genericType;
                                if (parameterizedType.getActualTypeArguments()[0] instanceof Class) {
                                    type = (Class) parameterizedType.getActualTypeArguments()[0];
                                    if (jSONObject.get(name) instanceof JSONArray) {
                                        JSONArray jSONArray = jSONObject.getJSONArray(name);
                                        for (int i = 0; i < jSONArray.length(); i++) {
                                            Object a;
                                            if (jSONArray.get(i) instanceof JSONObject) {
                                                a = a(jSONArray.getJSONObject(i), type);
                                            } else if (type.isAssignableFrom(jSONArray.get(i).getClass())) {
                                                a = jSONArray.get(i);
                                            } else {
                                            }
                                            valueOf.add(a);
                                        }
                                    }
                                }
                            }
                        } else {
                            valueOf = a(jSONObject.getJSONObject(name), type.newInstance().getClass());
                        }
                        field.set(obj, valueOf);
                    }
                }
                valueOf = jSONObject.get(name);
                if (!field.getType().isAssignableFrom(valueOf.getClass())) {
                    type = field.getType();
                    valueOf = valueOf.toString();
                    if (Integer.TYPE == type || Integer.class == type) {
                        valueOf = Integer.valueOf(Integer.parseInt(valueOf));
                    } else if (Long.TYPE == type || Long.class == type) {
                        valueOf = Long.valueOf(Long.parseLong(valueOf));
                    } else if (Short.TYPE == type || Short.class == type) {
                        valueOf = Short.valueOf(Short.parseShort(valueOf));
                    } else if (Character.TYPE == type || Character.class == type) {
                        valueOf = Character.valueOf(valueOf.charAt(0));
                    } else if (Byte.TYPE == type || Byte.class == type) {
                        valueOf = Byte.valueOf(valueOf);
                    } else if (Float.TYPE == type || Float.class == type) {
                        valueOf = Float.valueOf(Float.parseFloat(valueOf));
                    } else if (Double.TYPE == type || Double.class == type) {
                        valueOf = Double.valueOf(Double.parseDouble(valueOf));
                    } else if (Boolean.TYPE == type || Boolean.class == type) {
                        valueOf = Boolean.valueOf(valueOf);
                    }
                }
                field.set(obj, valueOf);
            }
        }
    }
}
