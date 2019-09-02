package com.autonavi.amap.mapcore.maploader;

import android.content.Context;
import cn.jiguang.net.HttpUtils;
import com.amap.api.mapcore.util.OO0OOo0;
import com.amap.api.mapcore.util.OOo000;
import com.amap.api.mapcore.util.o0O0O0Oo;
import com.amap.api.mapcore.util.o0O0OOOo;
import com.amap.api.mapcore.util.o0OO0o00;
import com.amap.api.mapcore.util.oOO0O000;
import com.amap.api.mapcore.util.oOO0O000.O000000o;
import com.amap.api.mapcore.util.ooOOOOoo;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.ae.gmap.GLMapEngine;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import s.h.e.l.l.C;

public class AMapLoader implements O000000o {
    private static final int GET_METHOD = 0;
    private static String mDiu;
    private oOO0O000 downloadManager;
    private volatile boolean isCanceled = false;
    public boolean isFinish = false;
    ADataRequestParam mDataRequestParam;
    private int mEngineID = 0;
    GLMapEngine mGLMapEngine;
    private boolean mRequestCancel = false;

    public static class ADataRequestParam {
        public byte[] enCodeString;
        public long handler;
        public int nCompress;
        public int nRequestType;
        public String requestBaseUrl;
        public String requestUrl;
    }

    public static class AMapGridDownloadRequest extends OO0OOo0 {
        private final Context mContext;
        private byte[] postEntityBytes;
        private String sUrl;
        private String userAgent;

        public AMapGridDownloadRequest(Context context, String str, String str2) {
            this.mContext = context;
            this.sUrl = str;
            this.userAgent = str2;
        }

        public byte[] getEntityBytes() {
            return this.postEntityBytes;
        }

        public Map<String, String> getParams() {
            return null;
        }

        public Map<String, String> getRequestHead() {
            o0OO0o00 O00000oO = OOo000.O00000oO();
            String O00000Oo = O00000oO != null ? O00000oO.O00000Oo() : null;
            Object O00000oo = o0O0O0Oo.O00000oo(this.mContext);
            try {
                O00000oo = URLEncoder.encode(O00000oo, HttpUtils.ENCODING_UTF_8);
            } catch (Throwable unused) {
            }
            Hashtable hashtable = new Hashtable(16);
            hashtable.put("User-Agent", this.userAgent);
            hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", new Object[]{O00000Oo, "3dmap"}));
            hashtable.put("x-INFO", o0O0OOOo.O000000o(this.mContext));
            hashtable.put("key", O00000oo);
            hashtable.put("logversion", "2.1");
            return hashtable;
        }

        public String getURL() {
            return this.sUrl;
        }

        public void setPostEntityBytes(byte[] bArr) {
            this.postEntityBytes = bArr;
        }
    }

    static {
        C.i(15);
    }

    public AMapLoader(int i, GLMapEngine gLMapEngine, ADataRequestParam aDataRequestParam) {
        this.mDataRequestParam = aDataRequestParam;
        this.mEngineID = i;
        this.mGLMapEngine = gLMapEngine;
        this.mRequestCancel = false;
    }

    private String generateQueryString(Context context, String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        str = o0O0O0Oo.O00000oo(this.mGLMapEngine.getContext());
        try {
            str = URLEncoder.encode(str, HttpUtils.ENCODING_UTF_8);
        } catch (Throwable unused) {
        }
        stringBuffer.append("&key=");
        stringBuffer.append(str);
        str = sortReEncoderParams(stringBuffer.toString());
        String O000000o = o0O0OOOo.O000000o();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("&ts=");
        stringBuilder.append(O000000o);
        stringBuffer.append(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("&scode=");
        stringBuilder.append(o0O0OOOo.O000000o(context, O000000o, str));
        stringBuffer.append(stringBuilder.toString());
        return stringBuffer.toString();
    }

    private String getEncodeRequestParams(String str) {
        try {
            return URLEncoder.encode(str, HttpUtils.ENCODING_UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    private native String sortReEncoderParams(String str);

    private String strReEncoder(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            ooOOOOoo.O00000o0(e, "AbstractProtocalHandler", "strReEncoder");
            return "";
        } catch (Exception e2) {
            ooOOOOoo.O00000o0(e2, "AbstractProtocalHandler", "strReEncoderException");
            return "";
        }
    }

    public void doCancel() {
        this.mRequestCancel = true;
        if (this.downloadManager != null && !this.isCanceled) {
            synchronized (this.downloadManager) {
                try {
                    this.isCanceled = true;
                    this.downloadManager.O000000o();
                    this.mGLMapEngine.setMapLoaderToTask(this.mEngineID, this.mDataRequestParam.handler, null);
                } catch (Throwable th) {
                    ooOOOOoo.O00000o0(th, "AMapLoader", "doCancel");
                }
            }
        }
    }

    public void doRequest() {
        if (!this.mRequestCancel) {
            StringBuilder stringBuilder;
            String str = this.mDataRequestParam.requestBaseUrl;
            String str2 = this.mDataRequestParam.requestUrl;
            if (!str.endsWith(HttpUtils.URL_AND_PARA_SEPARATOR)) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str);
                stringBuilder2.append(HttpUtils.URL_AND_PARA_SEPARATOR);
                str = stringBuilder2.toString();
            }
            str2 = str2.replaceAll(";", getEncodeRequestParams(";").toString());
            boolean z = str != null && str.contains("http://m5.amap.com/");
            str2 = getRequestParams(str2, z, this.mDataRequestParam.nRequestType);
            StringBuffer stringBuffer = new StringBuffer();
            if (this.mDataRequestParam.nRequestType == 0) {
                stringBuffer.append(str2);
                stringBuilder = new StringBuilder();
                stringBuilder.append("&csid=");
                stringBuilder.append(UUID.randomUUID().toString());
                stringBuffer.append(stringBuilder.toString());
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("csid=");
                stringBuilder.append(UUID.randomUUID().toString());
                stringBuffer.append(stringBuilder.toString());
            }
            try {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(generateQueryString(this.mGLMapEngine.getContext(), stringBuffer.toString()));
                AMapGridDownloadRequest aMapGridDownloadRequest = new AMapGridDownloadRequest(this.mGLMapEngine.getContext(), stringBuilder.toString(), this.mGLMapEngine.getUserAgent());
                aMapGridDownloadRequest.setConnectionTimeout(1800000);
                aMapGridDownloadRequest.setSoTimeout(1800000);
                if (this.mDataRequestParam.nRequestType != 0) {
                    aMapGridDownloadRequest.setPostEntityBytes(str2.getBytes(HttpUtils.ENCODING_UTF_8));
                }
                this.downloadManager = new oOO0O000(aMapGridDownloadRequest, 0, -1, MapsInitializer.getProtocol() == 2);
                this.downloadManager.O000000o(this);
            } catch (Throwable th) {
                doCancel();
            }
            doCancel();
        }
    }

    public native String getDeviceId(Context context);

    public native String getRequestParams(String str, boolean z, int i);

    public void onDownload(byte[] bArr, long j) {
        if (bArr != null && this.mGLMapEngine != null && this.mDataRequestParam != null) {
            this.mGLMapEngine.receiveNetData(this.mEngineID, this.mDataRequestParam.handler, bArr, bArr.length);
        }
    }

    public void onException(Throwable th) {
        if (!(this.mGLMapEngine == null || this.mDataRequestParam == null)) {
            this.mGLMapEngine.netError(this.mEngineID, this.mDataRequestParam.handler, -1);
        }
        ooOOOOoo.O00000o0(th, "AMapLoader", "download onException");
    }

    public void onFinish() {
        if (this.mGLMapEngine != null && this.mDataRequestParam != null) {
            this.mGLMapEngine.finishDownLoad(this.mEngineID, this.mDataRequestParam.handler);
        }
    }

    public void onStop() {
        if (this.mGLMapEngine != null && this.mDataRequestParam != null) {
            this.mGLMapEngine.netError(this.mEngineID, this.mDataRequestParam.handler, -1);
        }
    }
}
