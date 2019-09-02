package org.xutils.http.loader;

import java.io.File;
import java.lang.reflect.Type;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xutils.http.RequestParams;

public final class LoaderFactory {
    private static final HashMap<Type, Loader> converterHashMap = new HashMap();

    static {
        converterHashMap.put(JSONObject.class, new JSONObjectLoader());
        converterHashMap.put(JSONArray.class, new JSONArrayLoader());
        converterHashMap.put(String.class, new StringLoader());
        converterHashMap.put(File.class, new FileLoader());
        converterHashMap.put(byte[].class, new ByteArrayLoader());
        BooleanLoader booleanLoader = new BooleanLoader();
        converterHashMap.put(Boolean.TYPE, booleanLoader);
        converterHashMap.put(Boolean.class, booleanLoader);
        IntegerLoader integerLoader = new IntegerLoader();
        converterHashMap.put(Integer.TYPE, integerLoader);
        converterHashMap.put(Integer.class, integerLoader);
    }

    private LoaderFactory() {
    }

    public static Loader<?> getLoader(Type type, RequestParams requestParams) {
        Loader loader = (Loader) converterHashMap.get(type);
        loader = loader == null ? new ObjectLoader(type) : loader.newInstance();
        loader.setParams(requestParams);
        return loader;
    }

    public static <T> void registerLoader(Type type, Loader<T> loader) {
        converterHashMap.put(type, loader);
    }
}
