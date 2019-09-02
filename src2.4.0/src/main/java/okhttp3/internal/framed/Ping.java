package okhttp3.internal.framed;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class Ping {
    private final CountDownLatch latch;
    private long received;
    private long sent;

    Ping() {
    }

    /* Access modifiers changed, original: 0000 */
    public void cancel() {
    }

    /* Access modifiers changed, original: 0000 */
    public void receive() {
    }

    public long roundTripTime() throws InterruptedException {
        return 0;
    }

    public long roundTripTime(long j, TimeUnit timeUnit) throws InterruptedException {
        return 0;
    }

    /* Access modifiers changed, original: 0000 */
    public void send() {
    }
}
