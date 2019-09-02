package org.xutils.http.app;

import java.io.InputStream;
import java.lang.reflect.Type;

public abstract class InputStreamResponseParser implements ResponseParser {
    public abstract Object parse(Type type, Class<?> cls, InputStream inputStream);

    @Deprecated
    public final Object parse(Type type, Class<?> cls, String str) throws Throwable {
        return null;
    }
}
