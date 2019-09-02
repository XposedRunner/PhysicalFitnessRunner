package cn.jpush.android.a;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JCoreInterface;
import cn.jpush.android.a;
import cn.jpush.android.api.JThirdPlatFormInterface;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {
    public static void a(String str, int i, String str2, Context context) {
        if (JCoreInterface.isValidRegistered() && context != null) {
            StringBuffer stringBuffer = new StringBuffer();
            StringBuilder stringBuilder = new StringBuilder("action:reportActionResult - messageId: ");
            stringBuilder.append(str);
            stringBuilder.append(", code: ");
            stringBuilder.append(i);
            stringBuilder.append("-");
            stringBuilder.append(m.a(i));
            stringBuffer.append(stringBuilder.toString());
            if (!TextUtils.isEmpty(str2)) {
                stringBuilder = new StringBuilder(" report content: ");
                stringBuilder.append(str2);
                stringBuffer.append(stringBuilder.toString());
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(JThirdPlatFormInterface.KEY_MSG_ID, str);
                jSONObject.put("result", i);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("data", str2);
                }
                JCoreInterface.fillBaseReport(jSONObject, "msg_status");
                JCoreInterface.reportHttpData(context, jSONObject, a.a);
            } catch (JSONException unused) {
            }
        }
    }

    public static void a(String str, String str2, byte b, int i, Context context) {
        if (JCoreInterface.isValidRegistered() && context != null) {
            StringBuffer stringBuffer = new StringBuffer();
            StringBuilder stringBuilder = new StringBuilder("action:reportThirdSDKMsgActionResult - messageId: ");
            stringBuilder.append(str);
            stringBuilder.append(", code: ");
            stringBuilder.append(i);
            stringBuffer.append(stringBuilder.toString());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(JThirdPlatFormInterface.KEY_MSG_ID, str);
                jSONObject.put("tmsg_id", str2);
                jSONObject.put("result", i);
                jSONObject.put("sdk_type", b);
                JCoreInterface.fillBaseReport(jSONObject, "third_msg_status");
                JCoreInterface.reportHttpData(context, jSONObject, a.a);
            } catch (JSONException unused) {
            }
        }
    }
}
