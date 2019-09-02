package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.mm.opensdk.utils.Log;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

public final class e {
    public static byte[] a(String str, int i) {
        StringBuilder stringBuilder;
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.SDK.NetUtil", "httpGet, url is null");
            return null;
        }
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(str);
        if (i >= 0) {
            try {
                HttpConnectionParams.setSoTimeout(defaultHttpClient.getParams(), i);
            } catch (Exception e) {
                stringBuilder = new StringBuilder("httpGet, Exception ex = ");
                stringBuilder.append(e.getMessage());
                Log.e("MicroMsg.SDK.NetUtil", stringBuilder.toString());
                return null;
            } catch (IncompatibleClassChangeError e2) {
                stringBuilder = new StringBuilder("httpGet, IncompatibleClassChangeError ex = ");
                stringBuilder.append(e2.getMessage());
                Log.e("MicroMsg.SDK.NetUtil", stringBuilder.toString());
                return null;
            } catch (Throwable th) {
                stringBuilder = new StringBuilder("httpGet, Throwable ex = ");
                stringBuilder.append(th.getMessage());
                Log.e("MicroMsg.SDK.NetUtil", stringBuilder.toString());
                return null;
            }
        }
        HttpResponse execute = defaultHttpClient.execute(httpGet);
        if (execute.getStatusLine().getStatusCode() == 200) {
            return EntityUtils.toByteArray(execute.getEntity());
        }
        stringBuilder = new StringBuilder("httpGet fail, status code = ");
        stringBuilder.append(execute.getStatusLine().getStatusCode());
        Log.e("MicroMsg.SDK.NetUtil", stringBuilder.toString());
        return null;
    }
}
