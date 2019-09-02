package cn.jiguang.d.e.a.a;

import cn.jiguang.api.utils.OutputDataUtil;
import cn.jiguang.d.h.a.a;
import cn.jiguang.e.c;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {
    public static byte[] a(int i, long j, byte[] bArr) {
        OutputDataUtil outputDataUtil = new OutputDataUtil(20480);
        outputDataUtil.writeByteArray(bArr);
        outputDataUtil.writeU32At((long) i, 12);
        if (j != 0) {
            outputDataUtil.writeU64At(j, 16);
        }
        return outputDataUtil.toByteArray();
    }

    public static byte[] a(long j, int i, long j2, String str, long[] jArr) {
        OutputDataUtil outputDataUtil = new OutputDataUtil(20480);
        outputDataUtil.writeU16(0);
        outputDataUtil.writeU8(0);
        outputDataUtil.writeU8(30);
        outputDataUtil.writeU64(j);
        outputDataUtil.writeU32((long) i);
        outputDataUtil.writeU64(j2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_id", str);
            JSONArray jSONArray = new JSONArray();
            if (jArr != null) {
                jSONArray.put(j2);
                for (long put : jArr) {
                    jSONArray.put(put);
                }
            }
            jSONObject.put("uids", jSONArray);
            outputDataUtil.writeByteArrayincludeLength(jSONObject.toString().getBytes());
            outputDataUtil.writeU16At(outputDataUtil.current(), 0);
            return outputDataUtil.toByteArray();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] a(byte[] bArr, int i) {
        bArr = a.a(bArr, i);
        if (bArr != null && bArr.length > 0) {
            return bArr;
        }
        c.c("CorePackage", "totalRegBuf length :0");
        return null;
    }

    public static byte[] b(long j, int i, long j2, String str, long[] jArr) {
        OutputDataUtil outputDataUtil = new OutputDataUtil(20480);
        outputDataUtil.writeU16(0);
        outputDataUtil.writeU8(0);
        outputDataUtil.writeU8(32);
        outputDataUtil.writeU64(j);
        outputDataUtil.writeU32((long) i);
        outputDataUtil.writeU64(j2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_id", str);
            JSONArray jSONArray = new JSONArray();
            for (i = 0; i <= 0; i++) {
                jSONArray.put(jArr[0]);
            }
            jSONObject.put("uids", jSONArray);
            outputDataUtil.writeByteArrayincludeLength(jSONObject.toString().getBytes());
            outputDataUtil.writeU16At(outputDataUtil.current(), 0);
            return outputDataUtil.toByteArray();
        } catch (Throwable unused) {
            return null;
        }
    }
}
