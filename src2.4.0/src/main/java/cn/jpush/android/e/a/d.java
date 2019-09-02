package cn.jpush.android.e.a;

import android.text.TextUtils;
import android.webkit.WebView;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d {
    private HashMap<String, Method> a;
    private String b;
    private String c;

    public d(String str, Class cls) {
        try {
            if (TextUtils.isEmpty(str)) {
                throw new Exception("injected name can not be null");
            }
            this.b = str;
            this.a = new HashMap();
            Method[] declaredMethods = cls.getDeclaredMethods();
            StringBuilder stringBuilder = new StringBuilder("javascript:(function(b){console.log(\"");
            stringBuilder.append(this.b);
            stringBuilder.append(" initialization begin\");var a={queue:[],callback:function(){var d=Array.prototype.slice.call(arguments,0);var c=d.shift();var e=d.shift();this.queue[c].apply(this,d);if(!e){delete this.queue[c]}}};");
            for (Method method : declaredMethods) {
                if (method.getModifiers() == 9) {
                    String a = a(method);
                    if (a != null) {
                        this.a.put(a, method);
                        stringBuilder.append(String.format(Locale.ENGLISH, "a.%s=", new Object[]{method.getName()}));
                    }
                }
            }
            stringBuilder.append("function(){var f=Array.prototype.slice.call(arguments,0);if(f.length<1){throw\"");
            stringBuilder.append(this.b);
            stringBuilder.append(" call error, message:miss method name\"}var e=[];for(var h=1;h<f.length;h++){var c=f[h];var j=typeof c;e[e.length]=j;if(j==\"function\"){var d=a.queue.length;a.queue[d]=c;f[h]=d}}var g=JSON.parse(prompt(JSON.stringify({method:f.shift(),types:e,args:f})));if(g.code!=200){throw\"");
            stringBuilder.append(this.b);
            stringBuilder.append(" call error, code:\"+g.code+\", message:\"+g.result}return g.result};Object.getOwnPropertyNames(a).forEach(function(d){var c=a[d];if(typeof c===\"function\"&&d!==\"callback\"){a[d]=function(){return c.apply(a,[d].concat(Array.prototype.slice.call(arguments,0)))}}});b.");
            stringBuilder.append(this.b);
            stringBuilder.append("=a;console.log(\"");
            stringBuilder.append(this.b);
            stringBuilder.append(" initialization end\")})(window);");
            this.c = stringBuilder.toString();
        } catch (Exception unused) {
        }
    }

    private static String a(int i, Object obj) {
        String str = "";
        if (obj == null) {
            str = "null";
        } else if (obj instanceof String) {
            String replace = ((String) obj).replace("\"", "\\\"");
            StringBuilder stringBuilder = new StringBuilder("\"");
            stringBuilder.append(replace);
            stringBuilder.append("\"");
            str = stringBuilder.toString();
        } else if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof JSONObject)) {
            str = String.valueOf(obj);
        }
        return String.format(Locale.ENGLISH, "{\"code\": %d, \"result\": %s}", new Object[]{Integer.valueOf(i), str});
    }

    private static String a(Method method) {
        String name = method.getName();
        Class[] parameterTypes = method.getParameterTypes();
        int length = parameterTypes.length;
        if (length <= 0 || parameterTypes[0] != WebView.class) {
            return null;
        }
        for (int i = 1; i < length; i++) {
            StringBuilder stringBuilder;
            Class cls = parameterTypes[i];
            if (cls == String.class) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(name);
                name = "_S";
            } else if (cls == Integer.TYPE || cls == Long.TYPE || cls == Float.TYPE || cls == Double.TYPE) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(name);
                name = "_N";
            } else if (cls == Boolean.TYPE) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(name);
                name = "_B";
            } else if (cls == JSONObject.class) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(name);
                name = "_O";
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(name);
                name = "_P";
            }
            stringBuilder.append(name);
            name = stringBuilder.toString();
        }
        return name;
    }

    public final String a() {
        return this.c;
    }

    public final String a(WebView webView, String str) {
        Object obj;
        if (TextUtils.isEmpty(str)) {
            obj = "call data empty";
            return a(500, obj);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            str = jSONObject.getString("method");
            JSONArray jSONArray = jSONObject.getJSONArray("types");
            JSONArray jSONArray2 = jSONObject.getJSONArray("args");
            int length = jSONArray.length();
            Object[] objArr = new Object[(length + 1)];
            int i = 0;
            objArr[0] = webView;
            int i2 = 0;
            while (true) {
                Object obj2 = null;
                if (i >= length) {
                    break;
                }
                String optString = jSONArray.optString(i);
                StringBuilder stringBuilder;
                int i3;
                StringBuilder stringBuilder2;
                if ("string".equals(optString)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append("_S");
                    str = stringBuilder.toString();
                    i3 = i + 1;
                    if (!jSONArray2.isNull(i)) {
                        obj2 = jSONArray2.getString(i);
                    }
                    objArr[i3] = obj2;
                } else if ("number".equals(optString)) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str);
                    stringBuilder2.append("_N");
                    str = stringBuilder2.toString();
                    i2 = ((i2 * 10) + i) + 1;
                } else if ("boolean".equals(optString)) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str);
                    stringBuilder2.append("_B");
                    str = stringBuilder2.toString();
                    objArr[i + 1] = Boolean.valueOf(jSONArray2.getBoolean(i));
                } else if ("object".equals(optString)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append("_O");
                    str = stringBuilder.toString();
                    i3 = i + 1;
                    if (!jSONArray2.isNull(i)) {
                        obj2 = jSONArray2.getJSONObject(i);
                    }
                    objArr[i3] = obj2;
                } else {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str);
                    stringBuilder2.append("_P");
                    str = stringBuilder2.toString();
                }
                i++;
            }
            Method method = (Method) this.a.get(str);
            if (method == null) {
                StringBuilder stringBuilder3 = new StringBuilder("not found method(");
                stringBuilder3.append(str);
                stringBuilder3.append(") with valid parameters");
                return a(500, stringBuilder3.toString());
            }
            if (i2 > 0) {
                Class[] parameterTypes = method.getParameterTypes();
                while (i2 > 0) {
                    length = i2 - ((i2 / 10) * 10);
                    Class cls = parameterTypes[length];
                    if (cls == Integer.TYPE) {
                        objArr[length] = Integer.valueOf(jSONArray2.getInt(length - 1));
                    } else if (cls == Long.TYPE) {
                        objArr[length] = Long.valueOf(Long.parseLong(jSONArray2.getString(length - 1)));
                    } else {
                        objArr[length] = Double.valueOf(jSONArray2.getDouble(length - 1));
                    }
                    i2 /= 10;
                }
            }
            return a(200, method.invoke(null, objArr));
        } catch (Exception e) {
            StringBuilder stringBuilder4;
            String message;
            if (e.getCause() != null) {
                stringBuilder4 = new StringBuilder("method execute error:");
                message = e.getCause().getMessage();
            } else {
                stringBuilder4 = new StringBuilder("method execute error:");
                message = e.getMessage();
            }
            stringBuilder4.append(message);
            obj = stringBuilder4.toString();
        }
    }
}
