package okhttp3.internal.http;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

public final class RealResponseBody extends ResponseBody {
    private final Headers headers;
    private final BufferedSource source;

    public RealResponseBody(Headers headers, BufferedSource bufferedSource) {
        this.headers = headers;
        this.source = bufferedSource;
    }

    public long contentLength() {
        return HttpHeaders.contentLength(this.headers);
    }

    public MediaType contentType() {
        String str = this.headers.get("Content-Type");
        return str != null ? MediaType.parse(str) : null;
    }

    public BufferedSource source() {
        return this.source;
    }
}
