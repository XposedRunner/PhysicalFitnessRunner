package okhttp3;

import com.umeng.commonsdk.proguard.ap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

public final class MultipartBody extends RequestBody {
    public static final MediaType ALTERNATIVE = MediaType.parse("multipart/alternative");
    private static final byte[] COLONSPACE = new byte[]{(byte) 58, (byte) 32};
    private static final byte[] CRLF = new byte[]{ap.k, (byte) 10};
    private static final byte[] DASHDASH = new byte[]{(byte) 45, (byte) 45};
    public static final MediaType DIGEST = MediaType.parse("multipart/digest");
    public static final MediaType FORM = MediaType.parse("multipart/form-data");
    public static final MediaType MIXED = MediaType.parse("multipart/mixed");
    public static final MediaType PARALLEL = MediaType.parse("multipart/parallel");
    private final ByteString boundary;
    private long contentLength = -1;
    private final MediaType contentType;
    private final MediaType originalType;
    private final List<Part> parts;

    public static final class Builder {
        private final ByteString boundary;
        private final List<Part> parts;
        private MediaType type;

        public Builder() {
            this(UUID.randomUUID().toString());
        }

        public Builder(String str) {
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
            this.boundary = ByteString.encodeUtf8(str);
        }

        public Builder addFormDataPart(String str, String str2) {
            return addPart(Part.createFormData(str, str2));
        }

        public Builder addFormDataPart(String str, String str2, RequestBody requestBody) {
            return addPart(Part.createFormData(str, str2, requestBody));
        }

        public Builder addPart(Headers headers, RequestBody requestBody) {
            return addPart(Part.create(headers, requestBody));
        }

        public Builder addPart(Part part) {
            if (part == null) {
                throw new NullPointerException("part == null");
            }
            this.parts.add(part);
            return this;
        }

        public Builder addPart(RequestBody requestBody) {
            return addPart(Part.create(requestBody));
        }

        public MultipartBody build() {
            if (!this.parts.isEmpty()) {
                return new MultipartBody(this.boundary, this.type, this.parts);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }

        public Builder setType(MediaType mediaType) {
            if (mediaType == null) {
                throw new NullPointerException("type == null");
            } else if (mediaType.type().equals("multipart")) {
                this.type = mediaType;
                return this;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("multipart != ");
                stringBuilder.append(mediaType);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    public static final class Part {
        private final RequestBody body;
        private final Headers headers;

        private Part(Headers headers, RequestBody requestBody) {
        }

        public static Part create(Headers headers, RequestBody requestBody) {
            return null;
        }

        public static Part create(RequestBody requestBody) {
            return null;
        }

        public static Part createFormData(String str, String str2) {
            return null;
        }

        public static Part createFormData(String str, String str2, RequestBody requestBody) {
            return null;
        }
    }

    MultipartBody(ByteString byteString, MediaType mediaType, List<Part> list) {
        this.boundary = byteString;
        this.originalType = mediaType;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(mediaType);
        stringBuilder.append("; boundary=");
        stringBuilder.append(byteString.utf8());
        this.contentType = MediaType.parse(stringBuilder.toString());
        this.parts = Util.immutableList((List) list);
    }

    static StringBuilder appendQuotedString(StringBuilder stringBuilder, String str) {
        stringBuilder.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == 10) {
                stringBuilder.append("%0A");
            } else if (charAt == 13) {
                stringBuilder.append("%0D");
            } else if (charAt != '\"') {
                stringBuilder.append(charAt);
            } else {
                stringBuilder.append("%22");
            }
        }
        stringBuilder.append('\"');
        return stringBuilder;
    }

    private long writeOrCountBytes(BufferedSink bufferedSink, boolean z) throws IOException {
        Buffer buffer;
        long size;
        if (z) {
            bufferedSink = new Buffer();
            buffer = bufferedSink;
        } else {
            buffer = null;
        }
        int size2 = this.parts.size();
        long j = 0;
        for (int i = 0; i < size2; i++) {
            Part part = (Part) this.parts.get(i);
            Headers access$000 = null;
            RequestBody access$100 = null;
            bufferedSink.write(DASHDASH);
            bufferedSink.write(this.boundary);
            bufferedSink.write(CRLF);
            if (access$000 != null) {
                int size3 = access$000.size();
                for (int i2 = 0; i2 < size3; i2++) {
                    bufferedSink.writeUtf8(access$000.name(i2)).write(COLONSPACE).writeUtf8(access$000.value(i2)).write(CRLF);
                }
            }
            MediaType contentType = access$100.contentType();
            if (contentType != null) {
                bufferedSink.writeUtf8("Content-Type: ").writeUtf8(contentType.toString()).write(CRLF);
            }
            long contentLength = access$100.contentLength();
            if (contentLength != -1) {
                bufferedSink.writeUtf8("Content-Length: ").writeDecimalLong(contentLength).write(CRLF);
            } else if (z) {
                buffer.clear();
                return -1;
            }
            bufferedSink.write(CRLF);
            if (z) {
                j += contentLength;
            } else {
                access$100.writeTo(bufferedSink);
            }
            bufferedSink.write(CRLF);
        }
        bufferedSink.write(DASHDASH);
        bufferedSink.write(this.boundary);
        bufferedSink.write(DASHDASH);
        bufferedSink.write(CRLF);
        if (z) {
            size = j + buffer.size();
            buffer.clear();
        } else {
            size = j;
        }
        return size;
    }

    public String boundary() {
        return this.boundary.utf8();
    }

    public long contentLength() throws IOException {
        long j = this.contentLength;
        if (j != -1) {
            return j;
        }
        j = writeOrCountBytes(null, true);
        this.contentLength = j;
        return j;
    }

    public MediaType contentType() {
        return this.contentType;
    }

    public Part part(int i) {
        return (Part) this.parts.get(i);
    }

    public List<Part> parts() {
        return this.parts;
    }

    public int size() {
        return this.parts.size();
    }

    public MediaType type() {
        return this.originalType;
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        writeOrCountBytes(bufferedSink, false);
    }
}
