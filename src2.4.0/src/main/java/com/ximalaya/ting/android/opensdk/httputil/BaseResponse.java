package com.ximalaya.ting.android.opensdk.httputil;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;
import okhttp3.Response;

public class BaseResponse {
    private Response mResponse;

    public BaseResponse(Response response) {
        this.mResponse = response;
    }

    public static Object getResponseBodyStringToObject(Type type, String str) throws Exception {
        try {
            return new Gson().fromJson(str, type);
        } catch (Throwable th) {
            th.printStackTrace();
            RuntimeException runtimeException = new RuntimeException(th);
        }
    }

    public void filterResponse() {
    }

    public List<String> getHeader(String str) {
        return this.mResponse.headers(str);
    }

    public Object getResponseBodyReaderToObject(Type type) throws Exception {
        return new Gson().fromJson(this.mResponse.body().charStream(), type);
    }

    public Reader getResponseBodyToReader() throws IOException {
        try {
            return this.mResponse.body().charStream();
        } catch (Exception e) {
            if (e instanceof IOException) {
                throw e;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("cause:");
            stringBuilder.append(e.getMessage());
            throw new IOException(stringBuilder.toString());
        }
    }

    public String getResponseBodyToString() throws IOException {
        try {
            return this.mResponse.body().string();
        } catch (Exception e) {
            if (e instanceof IOException) {
                throw e;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("cause:");
            stringBuilder.append(e.getMessage());
            throw new IOException(stringBuilder.toString());
        }
    }

    public int getStatusCode() {
        return this.mResponse.code();
    }

    public String getStatusMessage() {
        return this.mResponse.message();
    }
}
