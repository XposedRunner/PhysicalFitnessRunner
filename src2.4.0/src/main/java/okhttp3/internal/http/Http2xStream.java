package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.framed.ErrorCode;
import okhttp3.internal.framed.FramedConnection;
import okhttp3.internal.framed.FramedStream;
import okhttp3.internal.framed.Header;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class Http2xStream implements HttpStream {
    private static final ByteString CONNECTION = ByteString.encodeUtf8("connection");
    private static final ByteString ENCODING = ByteString.encodeUtf8("encoding");
    private static final ByteString HOST = ByteString.encodeUtf8("host");
    private static final List<ByteString> HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableList(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE, Header.TARGET_METHOD, Header.TARGET_PATH, Header.TARGET_SCHEME, Header.TARGET_AUTHORITY, Header.TARGET_HOST, Header.VERSION);
    private static final List<ByteString> HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableList(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE);
    private static final ByteString KEEP_ALIVE = ByteString.encodeUtf8("keep-alive");
    private static final ByteString PROXY_CONNECTION = ByteString.encodeUtf8("proxy-connection");
    private static final List<ByteString> SPDY_3_SKIPPED_REQUEST_HEADERS = Util.immutableList(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TRANSFER_ENCODING, Header.TARGET_METHOD, Header.TARGET_PATH, Header.TARGET_SCHEME, Header.TARGET_AUTHORITY, Header.TARGET_HOST, Header.VERSION);
    private static final List<ByteString> SPDY_3_SKIPPED_RESPONSE_HEADERS = Util.immutableList(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TRANSFER_ENCODING);
    private static final ByteString TE = ByteString.encodeUtf8("te");
    private static final ByteString TRANSFER_ENCODING = ByteString.encodeUtf8("transfer-encoding");
    private static final ByteString UPGRADE = ByteString.encodeUtf8("upgrade");
    private final OkHttpClient client;
    private final FramedConnection framedConnection;
    private FramedStream stream;
    private final StreamAllocation streamAllocation;

    class StreamFinishingSource extends ForwardingSource {
        final /* synthetic */ Http2xStream this$0;

        public StreamFinishingSource(Http2xStream http2xStream, Source source) {
        }

        public void close() throws IOException {
        }
    }

    public Http2xStream(OkHttpClient okHttpClient, StreamAllocation streamAllocation, FramedConnection framedConnection) {
        this.client = okHttpClient;
        this.streamAllocation = streamAllocation;
        this.framedConnection = framedConnection;
    }

    public static List<Header> http2HeadersList(Request request) {
        Headers headers = request.headers();
        ArrayList arrayList = new ArrayList(headers.size() + 4);
        arrayList.add(new Header(Header.TARGET_METHOD, request.method()));
        arrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(request.url())));
        int i = 0;
        arrayList.add(new Header(Header.TARGET_AUTHORITY, Util.hostHeader(request.url(), false)));
        arrayList.add(new Header(Header.TARGET_SCHEME, request.url().scheme()));
        int size = headers.size();
        while (i < size) {
            ByteString encodeUtf8 = ByteString.encodeUtf8(headers.name(i).toLowerCase(Locale.US));
            if (!HTTP_2_SKIPPED_REQUEST_HEADERS.contains(encodeUtf8)) {
                arrayList.add(new Header(encodeUtf8, headers.value(i)));
            }
            i++;
        }
        return arrayList;
    }

    private static String joinOnNull(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.append(0);
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    public static Builder readHttp2HeadersList(List<Header> list) throws IOException {
        Headers.Builder builder = new Headers.Builder();
        int size = list.size();
        String str = null;
        for (int i = 0; i < size; i++) {
            ByteString byteString = ((Header) list.get(i)).name;
            String utf8 = ((Header) list.get(i)).value.utf8();
            if (byteString.equals(Header.RESPONSE_STATUS)) {
                str = utf8;
            } else if (!HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(byteString)) {
                Internal.instance.addLenient(builder, byteString.utf8(), utf8);
            }
        }
        if (str == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HTTP/1.1 ");
        stringBuilder.append(str);
        StatusLine parse = StatusLine.parse(stringBuilder.toString());
        return new Builder().protocol(Protocol.HTTP_2).code(parse.code).message(parse.message).headers(builder.build());
    }

    public static Builder readSpdy3HeadersList(List<Header> list) throws IOException {
        Headers.Builder builder = new Headers.Builder();
        int size = list.size();
        String str = null;
        String str2 = "HTTP/1.1";
        int i = 0;
        while (i < size) {
            ByteString byteString = ((Header) list.get(i)).name;
            String utf8 = ((Header) list.get(i)).value.utf8();
            String str3 = str2;
            str2 = str;
            int i2 = 0;
            while (i2 < utf8.length()) {
                int indexOf = utf8.indexOf(0, i2);
                if (indexOf == -1) {
                    indexOf = utf8.length();
                }
                str = utf8.substring(i2, indexOf);
                if (byteString.equals(Header.RESPONSE_STATUS)) {
                    str2 = str;
                } else if (byteString.equals(Header.VERSION)) {
                    str3 = str;
                } else if (!SPDY_3_SKIPPED_RESPONSE_HEADERS.contains(byteString)) {
                    Internal.instance.addLenient(builder, byteString.utf8(), str);
                }
                i2 = indexOf + 1;
            }
            i++;
            str = str2;
            str2 = str3;
        }
        if (str == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(" ");
        stringBuilder.append(str);
        StatusLine parse = StatusLine.parse(stringBuilder.toString());
        return new Builder().protocol(Protocol.SPDY_3).code(parse.code).message(parse.message).headers(builder.build());
    }

    public static List<Header> spdy3HeadersList(Request request) {
        Headers headers = request.headers();
        ArrayList arrayList = new ArrayList(headers.size() + 5);
        arrayList.add(new Header(Header.TARGET_METHOD, request.method()));
        arrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(request.url())));
        arrayList.add(new Header(Header.VERSION, "HTTP/1.1"));
        arrayList.add(new Header(Header.TARGET_HOST, Util.hostHeader(request.url(), false)));
        arrayList.add(new Header(Header.TARGET_SCHEME, request.url().scheme()));
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            ByteString encodeUtf8 = ByteString.encodeUtf8(headers.name(i).toLowerCase(Locale.US));
            if (!SPDY_3_SKIPPED_REQUEST_HEADERS.contains(encodeUtf8)) {
                String value = headers.value(i);
                if (linkedHashSet.add(encodeUtf8)) {
                    arrayList.add(new Header(encodeUtf8, value));
                } else {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        if (((Header) arrayList.get(i2)).name.equals(encodeUtf8)) {
                            arrayList.set(i2, new Header(encodeUtf8, joinOnNull(((Header) arrayList.get(i2)).value.utf8(), value)));
                            break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public void cancel() {
        if (this.stream != null) {
            this.stream.closeLater(ErrorCode.CANCEL);
        }
    }

    public Sink createRequestBody(Request request, long j) {
        return this.stream.getSink();
    }

    public void finishRequest() throws IOException {
        this.stream.getSink().close();
    }

    public ResponseBody openResponseBody(Response response) throws IOException {
        return new RealResponseBody(response.headers(), Okio.buffer(new StreamFinishingSource(this, this.stream.getSource())));
    }

    public Builder readResponseHeaders() throws IOException {
        return this.framedConnection.getProtocol() == Protocol.HTTP_2 ? readHttp2HeadersList(this.stream.getResponseHeaders()) : readSpdy3HeadersList(this.stream.getResponseHeaders());
    }

    public void writeRequestHeaders(Request request) throws IOException {
        if (this.stream == null) {
            this.stream = this.framedConnection.newStream(this.framedConnection.getProtocol() == Protocol.HTTP_2 ? http2HeadersList(request) : spdy3HeadersList(request), HttpMethod.permitsRequestBody(request.method()), true);
            this.stream.readTimeout().timeout((long) this.client.readTimeoutMillis(), TimeUnit.MILLISECONDS);
            this.stream.writeTimeout().timeout((long) this.client.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        }
    }
}
