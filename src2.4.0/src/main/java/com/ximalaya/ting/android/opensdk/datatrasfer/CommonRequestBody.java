package com.ximalaya.ting.android.opensdk.datatrasfer;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

public class CommonRequestBody extends RequestBody {
    private BufferedSink bufferedSink;
    private IUploadCallBack callBack;
    private final RequestBody requestBody;

    private CommonRequestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
    }

    public CommonRequestBody(RequestBody requestBody, IUploadCallBack iUploadCallBack) {
        this(requestBody);
        this.callBack = iUploadCallBack;
    }

    private Sink sink(BufferedSink bufferedSink) {
        return new ForwardingSink(bufferedSink) {
            long total = 0;
            long writed = 0;

            public void write(Buffer buffer, long j) throws IOException {
                super.write(buffer, j);
                if (this.total == 0) {
                    this.total = CommonRequestBody.this.contentLength();
                }
                this.writed += j;
                if (CommonRequestBody.this.callBack != null) {
                    CommonRequestBody.this.callBack.onProgress(this.writed, this.total);
                }
            }
        };
    }

    public long contentLength() throws IOException {
        return this.requestBody.contentLength();
    }

    public MediaType contentType() {
        return this.requestBody.contentType();
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        if (this.bufferedSink == null) {
            this.bufferedSink = Okio.buffer(sink(bufferedSink));
        }
        this.requestBody.writeTo(this.bufferedSink);
        this.bufferedSink.flush();
        if (this.callBack != null) {
            this.callBack.onSuccess();
        }
    }
}
