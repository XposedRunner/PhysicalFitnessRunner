package org.xutils.http.app;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.HashSet;
import org.json.JSONException;
import org.xutils.common.Callback.CancelledException;
import org.xutils.common.util.LogUtil;
import org.xutils.ex.HttpException;
import org.xutils.http.HttpMethod;
import org.xutils.http.request.UriRequest;

public class HttpRetryHandler {
    protected static HashSet<Class<?>> blackList = new HashSet();
    protected int maxRetryCount = 2;

    static {
        blackList.add(HttpException.class);
        blackList.add(CancelledException.class);
        blackList.add(MalformedURLException.class);
        blackList.add(URISyntaxException.class);
        blackList.add(NoRouteToHostException.class);
        blackList.add(PortUnreachableException.class);
        blackList.add(ProtocolException.class);
        blackList.add(NullPointerException.class);
        blackList.add(FileNotFoundException.class);
        blackList.add(JSONException.class);
        blackList.add(UnknownHostException.class);
        blackList.add(IllegalArgumentException.class);
    }

    public boolean canRetry(UriRequest uriRequest, Throwable th, int i) {
        LogUtil.w(th.getMessage(), th);
        if (i > this.maxRetryCount) {
            LogUtil.w(uriRequest.toString());
            LogUtil.w("The Max Retry times has been reached!");
            return false;
        } else if (!HttpMethod.permitsRetry(uriRequest.getParams().getMethod())) {
            LogUtil.w(uriRequest.toString());
            LogUtil.w("The Request Method can not be retried.");
            return false;
        } else if (!blackList.contains(th.getClass())) {
            return true;
        } else {
            LogUtil.w(uriRequest.toString());
            LogUtil.w("The Exception can not be retried.");
            return false;
        }
    }

    public void setMaxRetryCount(int i) {
        this.maxRetryCount = i;
    }
}
