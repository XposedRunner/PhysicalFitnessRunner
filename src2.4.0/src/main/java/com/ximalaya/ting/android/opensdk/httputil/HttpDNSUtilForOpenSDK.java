package com.ximalaya.ting.android.opensdk.httputil;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerConfig;
import com.ximalaya.ting.android.player.IDomainServerIpCallback;
import com.ximalaya.ting.android.xmpayordersdk.O000000o;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

public class HttpDNSUtilForOpenSDK {

    private static class DNSHostIP {
        private static List<DNSHostIP> dnsHostIPs;
        private int curUseIndexHost;
        private String[] hosts;

        private DNSHostIP(String[] strArr) {
            this.curUseIndexHost = 0;
            if (strArr != null && strArr.length > 1) {
                this.hosts = strArr;
            }
        }

        /* synthetic */ DNSHostIP(String[] strArr, AnonymousClass1 anonymousClass1) {
            this(strArr);
        }

        public static String getCurrReplaceHost(String str) {
            for (DNSHostIP dNSHostIP : getDNSIps()) {
                if (dNSHostIP.hosts != null) {
                    if (Arrays.binarySearch(dNSHostIP.hosts, str) >= 0) {
                        return dNSHostIP.hosts[dNSHostIP.curUseIndexHost];
                    }
                }
            }
            return null;
        }

        public static List<DNSHostIP> getDNSIps() {
            if (dnsHostIPs == null) {
                dnsHostIPs = new CopyOnWriteArrayList<DNSHostIP>() {
                    {
                        add(new DNSHostIP(new String[]{"fdfs.xmcdn.com", "adudio1.ws.xmcdn.com"}, null));
                        add(new DNSHostIP(new String[]{"audio.xmcdn.com", "audio2.xmcdn.com"}, null));
                        add(new DNSHostIP(new String[]{"download.xmcdn.com", "download2.xmcdn.com"}, null));
                        add(new DNSHostIP(new String[]{"api.ximalaya.com", "114.80.138.114"}, null));
                        add(new DNSHostIP(new String[]{"activity.ximalaya.com", "180.153.255.9"}, null));
                        add(new DNSHostIP(new String[]{"live.xmcdn.com", "112.65.220.26", "112.65.220.28"}, null));
                    }
                };
            }
            return dnsHostIPs;
        }

        public static String getNextReplaceHost(String str) {
            for (DNSHostIP dNSHostIP : getDNSIps()) {
                if (dNSHostIP.hosts != null) {
                    if (Arrays.binarySearch(dNSHostIP.hosts, str) >= 0) {
                        int i = dNSHostIP.curUseIndexHost == dNSHostIP.hosts.length + -1 ? 0 : dNSHostIP.curUseIndexHost + 1;
                        dNSHostIP.curUseIndexHost = i;
                        return dNSHostIP.hosts[i];
                    }
                }
            }
            return null;
        }

        public static String[] getOtherIpsByHost(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (DNSHostIP dNSHostIP : getDNSIps()) {
                if (dNSHostIP.hosts != null) {
                    if (dNSHostIP.hosts[0].equals(str)) {
                        return (String[]) Arrays.copyOfRange(dNSHostIP.hosts, 1, dNSHostIP.hosts.length);
                    }
                }
            }
            return null;
        }

        public static boolean haveReplaceHost(String str) {
            Iterator it = getDNSIps().iterator();
            while (true) {
                int i = 0;
                if (!it.hasNext()) {
                    return false;
                }
                DNSHostIP dNSHostIP = (DNSHostIP) it.next();
                if (dNSHostIP.hosts != null) {
                    String[] strArr = dNSHostIP.hosts;
                    int length = strArr.length;
                    while (i < length) {
                        if (strArr[i].equals(str)) {
                            return true;
                        }
                        i++;
                    }
                    continue;
                }
            }
        }
    }

    public static IDomainServerIpCallback getDomainServerIpCallBack(Context context) {
        return !XmPlayerConfig.getInstance(context).isUsePreventHijack() ? null : new IDomainServerIpCallback() {
            public String getNewDownloadUrlIfExpire(String str) {
                return null;
            }

            public String[][] getStaticDomainServerIp(String str) {
                if (TextUtils.isEmpty(str)) {
                    return (String[][]) null;
                }
                String host = Uri.parse(str).getHost();
                if (!DNSHostIP.haveReplaceHost(host)) {
                    return (String[][]) null;
                }
                String[] otherIpsByHost = DNSHostIP.getOtherIpsByHost(host);
                if (otherIpsByHost == null) {
                    return (String[][]) null;
                }
                String[][] strArr = (String[][]) Array.newInstance(String.class, new int[]{otherIpsByHost.length + 1, 2});
                strArr[0] = new String[]{str, host};
                for (int i = 1; i < strArr.length; i++) {
                    r7 = new String[2];
                    int i2 = i - 1;
                    r7[0] = str.replaceFirst(host, otherIpsByHost[i2]);
                    r7[1] = otherIpsByHost[i2];
                    strArr[i] = r7;
                }
                return strArr;
            }

            public void setBadIp(String str, String str2, String str3) {
            }
        };
    }

    public static Interceptor getHttpDNSInterceptor() {
        return new Interceptor() {
            public Response intercept(Chain chain) throws IOException {
                String currReplaceHost;
                Response proceed;
                Throwable th;
                Request request = chain.request();
                HttpUrl url = request.url();
                String httpUrl = url.toString();
                String host = url.host();
                try {
                    Builder newBuilder = request.newBuilder();
                    currReplaceHost = DNSHostIP.getCurrReplaceHost(host);
                    if (TextUtils.isEmpty(currReplaceHost)) {
                        newBuilder.url(url);
                    } else {
                        newBuilder.url(httpUrl.replaceFirst(host, currReplaceHost));
                    }
                    proceed = chain.proceed(newBuilder.build());
                    th = null;
                } catch (Throwable th2) {
                    th = th2;
                    proceed = null;
                }
                if ((proceed == null || !(proceed.isSuccessful() || proceed.code() == O000000o.O0000ooO)) && DNSHostIP.haveReplaceHost(host)) {
                    try {
                        Builder newBuilder2 = request.newBuilder();
                        currReplaceHost = DNSHostIP.getNextReplaceHost(host);
                        if (TextUtils.isEmpty(currReplaceHost)) {
                            newBuilder2.url(httpUrl);
                        } else {
                            newBuilder2.url(httpUrl.replaceFirst(host, currReplaceHost));
                        }
                        Response proceed2 = chain.proceed(newBuilder2.header("Host", host).build());
                        if (proceed2 != null) {
                            return proceed2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (proceed != null) {
                            proceed.close();
                        }
                        proceed = null;
                    }
                }
                if (proceed != null) {
                    return proceed;
                }
                StringBuilder stringBuilder;
                if (th != null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(th.toString());
                    stringBuilder.append("  URL:");
                    stringBuilder.append(httpUrl);
                    throw new IOException(stringBuilder.toString());
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("application interceptor returned null  URL:");
                stringBuilder.append(httpUrl);
                throw new IOException(stringBuilder.toString());
            }
        };
    }
}
