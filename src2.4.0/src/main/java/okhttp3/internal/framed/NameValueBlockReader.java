package okhttp3.internal.framed;

import java.io.IOException;
import java.util.List;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSource;
import okio.InflaterSource;
import okio.Source;

class NameValueBlockReader {
    private int compressedLimit;
    private final InflaterSource inflaterSource;
    private final BufferedSource source;

    /* renamed from: okhttp3.internal.framed.NameValueBlockReader$1 */
    class AnonymousClass1 extends ForwardingSource {
        final /* synthetic */ NameValueBlockReader this$0;

        AnonymousClass1(NameValueBlockReader nameValueBlockReader, Source source) {
        }

        public long read(Buffer buffer, long j) throws IOException {
            return 0;
        }
    }

    public NameValueBlockReader(BufferedSource bufferedSource) {
    }

    private void doneReading() throws IOException {
    }

    private ByteString readByteString() throws IOException {
        return null;
    }

    public void close() throws IOException {
    }

    public List<Header> readNameValueBlock(int i) throws IOException {
        return null;
    }
}
