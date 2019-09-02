package com.ximalaya.ting.android.opensdk.httputil;

import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.constants.ConstantsOpenSdk;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.ximalaya.ting.android.opensdk.httputil.util.SignatureUtil;
import com.ximalaya.ting.android.opensdk.httputil.util.Util;
import com.ximalaya.ting.android.opensdk.util.Logger;
import java.io.File;
import java.util.Map;
import java.util.Map.Entry;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;

public class BaseBuilder {
    private static Builder addCommonCookie(Builder builder) {
        return builder;
    }

    public static Builder urlGet(String str) throws XimalayaException {
        return urlGet(str, null);
    }

    public static Builder urlGet(String str, Map<String, String> map) throws XimalayaException {
        if (ConstantsOpenSdk.isDebug || !TextUtils.isEmpty(str)) {
            if (!(map == null || map.isEmpty())) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("?");
                stringBuilder.append(Util.ConvertMap2HttpParams(Util.encoderName(map)));
                str = stringBuilder.toString();
            }
            Logger.i("url123", str);
            try {
                return addCommonCookie(new Builder().url(str));
            } catch (Exception e) {
                e.printStackTrace();
                throw new XimalayaException(XimalayaException.REQUEST_URL_PARSE_ERROR, e.getMessage());
            }
        }
        throw XimalayaException.getExceptionByCode(1001);
    }

    public static Builder urlGet(String str, Map<String, String> map, String str2) throws XimalayaException {
        if (ConstantsOpenSdk.isDebug || !TextUtils.isEmpty(str)) {
            str2 = SignatureUtil.generateSignature(str2, map);
            if (TextUtils.isEmpty(str2)) {
                throw XimalayaException.getExceptionByCode(XimalayaException.SIGNATURE_ERR_BY_EMPTY);
            }
            map.put(DTransferConstants.SIGNATURE, str2);
            return urlGet(str, map);
        }
        throw XimalayaException.getExceptionByCode(1001);
    }

    public static Builder urlGzipedPost(String str, byte[] bArr, String str2) throws XimalayaException {
        if (ConstantsOpenSdk.isDebug || !TextUtils.isEmpty(str)) {
            return addCommonCookie(new Builder().url(str).post(RequestBody.create(MediaType.parse(str2), bArr)));
        }
        throw XimalayaException.getExceptionByCode(1001);
    }

    public static Builder urlPost(String str, File file) throws XimalayaException {
        if (ConstantsOpenSdk.isDebug || !TextUtils.isEmpty(str)) {
            return addCommonCookie(new Builder().url(str).post(RequestBody.create(null, file)));
        }
        throw XimalayaException.getExceptionByCode(1001);
    }

    public static Builder urlPost(String str, String str2) throws XimalayaException {
        if (ConstantsOpenSdk.isDebug || !TextUtils.isEmpty(str)) {
            return addCommonCookie(new Builder().url(str).post(RequestBody.create(null, str2)));
        }
        throw XimalayaException.getExceptionByCode(1001);
    }

    public static Builder urlPost(String str, String str2, String str3) throws XimalayaException {
        if (ConstantsOpenSdk.isDebug || !TextUtils.isEmpty(str)) {
            return addCommonCookie(new Builder().url(str).post(RequestBody.create(MediaType.parse(str3), str2)));
        }
        throw XimalayaException.getExceptionByCode(1001);
    }

    public static Builder urlPost(String str, Map<String, String> map) throws XimalayaException {
        if (ConstantsOpenSdk.isDebug || !TextUtils.isEmpty(str)) {
            FormBody.Builder builder = new FormBody.Builder();
            if (map == null || map.size() <= 0) {
                throw XimalayaException.getExceptionByCode(XimalayaException.FORM_ENCODE_LAST_ONE);
            }
            for (Entry entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    builder.add((String) entry.getKey(), (String) entry.getValue());
                }
            }
            return addCommonCookie(new Builder().url(str).post(builder.build()));
        }
        throw XimalayaException.getExceptionByCode(1001);
    }

    public static Builder urlPost(String str, Map<String, String> map, String str2) throws XimalayaException {
        if (ConstantsOpenSdk.isDebug || !TextUtils.isEmpty(str)) {
            str2 = SignatureUtil.generateSignature(str2, map);
            if (TextUtils.isEmpty(str2)) {
                throw XimalayaException.getExceptionByCode(XimalayaException.SIGNATURE_ERR_BY_EMPTY);
            }
            map.put(DTransferConstants.SIGNATURE, str2);
            return urlPost(str, (Map) map);
        }
        throw XimalayaException.getExceptionByCode(1001);
    }

    public static Builder urlPost(String str, byte[] bArr) throws XimalayaException {
        if (ConstantsOpenSdk.isDebug || !TextUtils.isEmpty(str)) {
            return addCommonCookie(new Builder().url(str).post(RequestBody.create(null, bArr)));
        }
        throw XimalayaException.getExceptionByCode(1001);
    }

    public static RequestBody urlPost(String str, Map<String, File> map, Map<String, String> map2) throws XimalayaException {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        for (String str2 : map2.keySet()) {
            String[] strArr = new String[2];
            strArr[0] = "Content-Disposition";
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("form-data; name=\"");
            stringBuilder.append(str2);
            stringBuilder.append("\"");
            strArr[1] = stringBuilder.toString();
            builder.addPart(Headers.of(strArr), RequestBody.create(null, (String) map2.get(str2)));
        }
        for (String str3 : map.keySet()) {
            String[] strArr2 = new String[2];
            strArr2[0] = "Content-Disposition";
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("form-data; name=\"");
            stringBuilder2.append(str3);
            stringBuilder2.append("\"; filename=\"");
            stringBuilder2.append(((File) map.get(str3)).getName());
            stringBuilder2.append("\"");
            strArr2[1] = stringBuilder2.toString();
            builder.addPart(Headers.of(strArr2), RequestBody.create(MediaType.parse(str), (File) map.get(str3)));
        }
        return builder.build();
    }

    public static Builder urlPostByteAndParam(String str, String str2, byte[] bArr, Map<String, String> map) throws XimalayaException {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        for (String str3 : map.keySet()) {
            String[] strArr = new String[2];
            strArr[0] = "Content-Disposition";
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("form-data; name=\"");
            stringBuilder.append(str3);
            stringBuilder.append("\"");
            strArr[1] = stringBuilder.toString();
            builder.addPart(Headers.of(strArr), RequestBody.create(null, (String) map.get(str3)));
        }
        String[] strArr2 = new String[2];
        strArr2[0] = "Content-Disposition";
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("form-data; name=\"");
        stringBuilder2.append("data");
        stringBuilder2.append("\"; filename=\"\"");
        strArr2[1] = stringBuilder2.toString();
        builder.addPart(Headers.of(strArr2), RequestBody.create(MediaType.parse(str2), bArr));
        return addCommonCookie(new Builder().url(str).post(builder.build()));
    }

    public static Builder urlPut(String str, String str2, String str3) throws XimalayaException {
        if (ConstantsOpenSdk.isDebug || !TextUtils.isEmpty(str)) {
            return addCommonCookie(new Builder().url(str).put(RequestBody.create(MediaType.parse(str3), str2)));
        }
        throw XimalayaException.getExceptionByCode(1001);
    }

    public static Builder urlPut(String str, Map<String, String> map) throws XimalayaException {
        if (ConstantsOpenSdk.isDebug || !TextUtils.isEmpty(str)) {
            FormBody.Builder builder = new FormBody.Builder();
            if (map == null || map.size() <= 0) {
                throw XimalayaException.getExceptionByCode(XimalayaException.FORM_ENCODE_LAST_ONE);
            }
            for (Entry entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    builder.add((String) entry.getKey(), (String) entry.getValue());
                }
            }
            return addCommonCookie(new Builder().url(str).put(builder.build()));
        }
        throw XimalayaException.getExceptionByCode(1001);
    }
}
