package okhttp3;

import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.platform.Platform;

public final class ConnectionPool {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Executor executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
    private final Runnable cleanupRunnable;
    boolean cleanupRunning;
    private final Deque<RealConnection> connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;
    final RouteDatabase routeDatabase;

    public ConnectionPool() {
        this(5, 5, TimeUnit.MINUTES);
    }

    public ConnectionPool(int i, long j, TimeUnit timeUnit) {
        this.cleanupRunnable = new Runnable() {
            /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002b */
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            public void run() {
                /*
                r8 = this;
            L_0x0000:
                r0 = okhttp3.ConnectionPool.this;
                r1 = java.lang.System.nanoTime();
                r0 = r0.cleanup(r1);
                r2 = -1;
                r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
                if (r4 != 0) goto L_0x0011;
            L_0x0010:
                return;
            L_0x0011:
                r2 = 0;
                r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
                if (r4 <= 0) goto L_0x0000;
            L_0x0017:
                r2 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
                r4 = r0 / r2;
                r2 = r2 * r4;
                r6 = r0 - r2;
                r0 = okhttp3.ConnectionPool.this;
                monitor-enter(r0);
                r1 = okhttp3.ConnectionPool.this;	 Catch:{ InterruptedException -> 0x002b }
                r2 = (int) r6;	 Catch:{ InterruptedException -> 0x002b }
                r1.wait(r4, r2);	 Catch:{ InterruptedException -> 0x002b }
                goto L_0x002b;
            L_0x0029:
                r1 = move-exception;
                goto L_0x002d;
            L_0x002b:
                monitor-exit(r0);	 Catch:{ all -> 0x0029 }
                goto L_0x0000;
            L_0x002d:
                monitor-exit(r0);	 Catch:{ all -> 0x0029 }
                throw r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: okhttp3.ConnectionPool$AnonymousClass1.run():void");
            }
        };
        this.connections = new ArrayDeque();
        this.routeDatabase = new RouteDatabase();
        this.maxIdleConnections = i;
        this.keepAliveDurationNs = timeUnit.toNanos(j);
        if (j <= 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("keepAliveDuration <= 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    private int pruneAndGetAllocationCount(RealConnection realConnection, long j) {
        List list = realConnection.allocations;
        int i = 0;
        while (i < list.size()) {
            if (((Reference) list.get(i)).get() != null) {
                i++;
            } else {
                Platform platform = Platform.get();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("A connection to ");
                stringBuilder.append(realConnection.route().address().url());
                stringBuilder.append(" was leaked. Did you forget to close a response body?");
                platform.log(5, stringBuilder.toString(), null);
                list.remove(i);
                realConnection.noNewStreams = true;
                if (list.isEmpty()) {
                    realConnection.idleAtNanos = j - this.keepAliveDurationNs;
                    return 0;
                }
            }
        }
        return list.size();
    }

    /* Access modifiers changed, original: 0000 */
    public long cleanup(long j) {
        synchronized (this) {
            long j2 = Long.MIN_VALUE;
            int i = 0;
            Object obj = null;
            int i2 = i;
            for (RealConnection realConnection : this.connections) {
                if (pruneAndGetAllocationCount(realConnection, j) > 0) {
                    i++;
                } else {
                    i2++;
                    long j3 = j - realConnection.idleAtNanos;
                    if (j3 > j2) {
                        obj = realConnection;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.keepAliveDurationNs) {
                if (i2 <= this.maxIdleConnections) {
                    if (i2 > 0) {
                        long j4 = this.keepAliveDurationNs - j2;
                        return j4;
                    } else if (i > 0) {
                        j = this.keepAliveDurationNs;
                        return j;
                    } else {
                        this.cleanupRunning = false;
                        return -1;
                    }
                }
            }
            this.connections.remove(obj);
            Util.closeQuietly(obj.socket());
            return 0;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public boolean connectionBecameIdle(RealConnection realConnection) {
        if (realConnection.noNewStreams || this.maxIdleConnections == 0) {
            this.connections.remove(realConnection);
            return true;
        }
        notifyAll();
        return false;
    }

    public synchronized int connectionCount() {
        return this.connections.size();
    }

    public void evictAll() {
        ArrayList<RealConnection> arrayList = new ArrayList();
        synchronized (this) {
            Iterator it = this.connections.iterator();
            while (it.hasNext()) {
                RealConnection realConnection = (RealConnection) it.next();
                if (realConnection.allocations.isEmpty()) {
                    realConnection.noNewStreams = true;
                    arrayList.add(realConnection);
                    it.remove();
                }
            }
        }
        for (RealConnection socket : arrayList) {
            Util.closeQuietly(socket.socket());
        }
    }

    /* Access modifiers changed, original: 0000 */
    public RealConnection get(Address address, StreamAllocation streamAllocation) {
        for (RealConnection realConnection : this.connections) {
            if (realConnection.allocations.size() < realConnection.allocationLimit && address.equals(realConnection.route().address) && !realConnection.noNewStreams) {
                streamAllocation.acquire(realConnection);
                return realConnection;
            }
        }
        return null;
    }

    public synchronized int idleConnectionCount() {
        int i;
        i = 0;
        for (RealConnection realConnection : this.connections) {
            if (realConnection.allocations.isEmpty()) {
                i++;
            }
        }
        return i;
    }

    /* Access modifiers changed, original: 0000 */
    public void put(RealConnection realConnection) {
        if (!this.cleanupRunning) {
            this.cleanupRunning = true;
            executor.execute(this.cleanupRunnable);
        }
        this.connections.add(realConnection);
    }
}
