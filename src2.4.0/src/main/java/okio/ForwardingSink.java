package okio;

import java.io.IOException;

public abstract class ForwardingSink implements Sink {
    private final Sink delegate;

    public ForwardingSink(Sink sink) {
    }

    public void close() throws IOException {
    }

    public final Sink delegate() {
        return null;
    }

    public void flush() throws IOException {
    }

    public Timeout timeout() {
        return null;
    }

    public String toString() {
        return null;
    }

    public void write(Buffer buffer, long j) throws IOException {
    }
}
