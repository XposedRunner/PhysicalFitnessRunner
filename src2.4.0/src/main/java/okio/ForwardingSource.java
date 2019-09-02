package okio;

import java.io.IOException;

public abstract class ForwardingSource implements Source {
    private final Source delegate;

    public ForwardingSource(Source source) {
    }

    public void close() throws IOException {
    }

    public final Source delegate() {
        return null;
    }

    public long read(Buffer buffer, long j) throws IOException {
        return 0;
    }

    public Timeout timeout() {
        return null;
    }

    public String toString() {
        return null;
    }
}
