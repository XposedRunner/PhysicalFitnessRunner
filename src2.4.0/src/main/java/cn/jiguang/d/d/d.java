package cn.jiguang.d.d;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import cn.jiguang.api.utils.OutputDataUtil;
import cn.jiguang.d.a;
import cn.jiguang.d.b.j;
import cn.jiguang.e.c;
import cn.jiguang.g.h;
import cn.jpush.android.api.JPushInterface;
import com.alibaba.wireless.security.SecExceptionCode;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public final class d {
    public static j a(String str) {
        try {
            j jVar = new j();
            jVar.a(str);
            jVar.b(str);
            if (!jVar.e()) {
                return jVar;
            }
        } catch (Exception e) {
            c.a("ConnectingHelper", "parseSisInfo crash:", e);
        }
        return null;
    }

    public static void a(Context context, int i, boolean z) {
        String a;
        if (z) {
            StringBuilder stringBuilder = new StringBuilder("Register Failed with server error - code:");
            stringBuilder.append(i);
            c.d("ConnectingHelper", stringBuilder.toString());
            a = h.a(i);
            if (!TextUtils.isEmpty(a)) {
                StringBuilder stringBuilder2 = new StringBuilder("Local error description: ");
                stringBuilder2.append(a);
                c.c("ConnectingHelper", stringBuilder2.toString());
            }
        }
        a = a.b(context);
        StringBuilder stringBuilder3;
        if (1006 == i) {
            stringBuilder3 = new StringBuilder("包名: ");
            stringBuilder3.append(a.c);
            stringBuilder3.append(" 不存在");
            cn.jiguang.g.a.a(context, stringBuilder3.toString(), -1);
            cn.jiguang.d.a.a.i();
            return;
        }
        if (1007 != i) {
            if (1005 == i) {
                stringBuilder3 = new StringBuilder("包名: ");
                stringBuilder3.append(a.c);
                stringBuilder3.append(" 与 AppKey:");
                stringBuilder3.append(a);
                stringBuilder3.append("不匹配");
                cn.jiguang.g.a.a(context, stringBuilder3.toString(), -1);
                cn.jiguang.d.a.a.i();
            } else if (1009 == i) {
                stringBuilder3 = new StringBuilder(" AppKey:");
                stringBuilder3.append(a);
                stringBuilder3.append(" 非android AppKey");
                cn.jiguang.g.a.a(context, stringBuilder3.toString(), -1);
                cn.jiguang.d.a.a.i();
            } else if (1008 == i) {
                stringBuilder3 = new StringBuilder(" AppKey:");
                stringBuilder3.append(a);
                stringBuilder3.append(" 是无效的AppKey,请确认与JIGUANG web端的AppKey一致");
                cn.jiguang.g.a.a(context, stringBuilder3.toString(), -1);
                cn.jiguang.d.a.a.i();
            } else if (10001 == i) {
                cn.jiguang.g.a.a(context, " 未在manifest中配置AppKey", -1);
            } else if (PointerIconCompat.TYPE_NO_DROP == i) {
                cn.jiguang.d.a.a.a();
            }
        }
    }

    public static void a(Context context, long j) {
        c.a("ConnectingHelper", "Action - sendServerTimer");
        try {
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("push_login_server_time", j);
            jSONObject.put("push_login_local_time", System.currentTimeMillis());
            bundle.putString("push_to_im_data", jSONObject.toString());
            cn.jiguang.g.a.a(context, "cn.jpush.im.android.action.IM_RESPONSE", bundle);
        } catch (JSONException unused) {
        }
    }

    public static void a(Context context, boolean z) {
        c.a("ConnectingHelper", "Action - sendConnectionChanged");
        Bundle bundle = new Bundle();
        bundle.putBoolean(JPushInterface.EXTRA_CONNECTION_CHANGE, z);
        cn.jiguang.g.a.a(context, JPushInterface.ACTION_CONNECTION_CHANGE, bundle);
    }

    public static void a(Message message, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("connection", j);
        message.setData(bundle);
        message.sendToTarget();
    }

    public static synchronized byte[] a(String str, int i, byte[] bArr, boolean z, int i2) {
        byte[] toByteArray;
        synchronized (d.class) {
            if (!(TextUtils.isEmpty(str) || str.length() != 2 || bArr == null)) {
                if (bArr.length != 0) {
                    OutputDataUtil outputDataUtil = new OutputDataUtil(SecExceptionCode.SEC_ERROR_STA_ENC);
                    outputDataUtil.writeU16(0);
                    outputDataUtil.writeByteArray(str.getBytes());
                    outputDataUtil.writeU32((long) i);
                    outputDataUtil.writeU16(i2);
                    outputDataUtil.writeByteArray(bArr);
                    outputDataUtil.writeU16At(outputDataUtil.current(), 0);
                    outputDataUtil.writeU8At(z, 4);
                    toByteArray = outputDataUtil.toByteArray();
                }
            }
            throw new IllegalArgumentException("flag or body length error");
        }
        return toByteArray;
    }

    public static byte[] a(DatagramSocket datagramSocket, DatagramPacket datagramPacket) {
        datagramSocket.setSoTimeout(6000);
        datagramSocket.send(datagramPacket);
        DatagramPacket datagramPacket2 = new DatagramPacket(new byte[1024], 1024);
        c.a("ConnectingHelper", "SIS Receiving...");
        datagramSocket.receive(datagramPacket2);
        byte[] bArr = new byte[datagramPacket2.getLength()];
        System.arraycopy(datagramPacket2.getData(), 0, bArr, 0, bArr.length);
        return bArr;
    }

    public static InetAddress b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (Pattern.compile("((2[0-4]\\d|25[0-5]|[01]?\\d{1,2})\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d{1,2})").matcher(str).matches()) {
            try {
                return InetAddress.getByName(str);
            } catch (UnknownHostException unused) {
                return null;
            }
        }
        e eVar = new e(str);
        try {
            eVar.start();
            eVar.join(3000);
            return eVar.a();
        } catch (Exception | InterruptedException unused2) {
            return null;
        }
    }
}
