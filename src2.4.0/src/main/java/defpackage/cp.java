package defpackage;

import java.util.Map;
import org.json.JSONObject;

/* compiled from: AnalyticsResponse */
/* renamed from: cp */
public class cp extends ct {
    public Map<by, Integer> O000000o;
    public String O00000Oo;
    public by O00000o0;

    public cp(Integer num, JSONObject jSONObject) {
        super(jSONObject);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ShareMultiResponse [mInfoMap=");
        stringBuilder.append(this.O000000o);
        stringBuilder.append(", mWeiboId=");
        stringBuilder.append(this.O00000Oo);
        stringBuilder.append(", mMsg=");
        stringBuilder.append(this.O0000o00);
        stringBuilder.append(", mStCode=");
        stringBuilder.append(this.O0000o0);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
