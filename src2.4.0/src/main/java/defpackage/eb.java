package defpackage;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.Locale;

/* compiled from: DoubleTypeAdapter */
/* renamed from: eb */
public class eb implements JsonSerializer<Double> {
    /* renamed from: O000000o */
    public JsonElement serialize(Double d, Type type, JsonSerializationContext jsonSerializationContext) {
        Locale locale = Locale.getDefault();
        Locale.setDefault(Locale.US);
        JsonPrimitive jsonPrimitive = new JsonPrimitive(new DecimalFormat("##0.000000").format(d));
        Locale.setDefault(locale);
        return jsonPrimitive;
    }
}
