package okhttp3.internal.framed;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okhttp3.internal.framed.FrameReader.Handler;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

public final class FramedConnection implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private static final ExecutorService executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp FramedConnection", true));
    long bytesLeftInWriteWindow;
    final boolean client;
    private final Set<Integer> currentPushRequests;
    final FrameWriter frameWriter;
    private final String hostname;
    private int lastGoodStreamId;
    private final Listener listener;
    private int nextPingId;
    private int nextStreamId;
    Settings okHttpSettings;
    final Settings peerSettings;
    private Map<Integer, Ping> pings;
    final Protocol protocol;
    private final ExecutorService pushExecutor;
    private final PushObserver pushObserver;
    final Reader readerRunnable;
    private boolean receivedInitialPeerSettings;
    private boolean shutdown;
    final Socket socket;
    private final Map<Integer, FramedStream> streams;
    long unacknowledgedBytesRead;
    final Variant variant;

    public static abstract class Listener {
        public static final Listener REFUSE_INCOMING_STREAMS = new Listener() {
            public void onStream(FramedStream framedStream) throws IOException {
                framedStream.close(ErrorCode.REFUSED_STREAM);
            }
        };

        public void onSettings(FramedConnection framedConnection) {
        }

        public abstract void onStream(FramedStream framedStream) throws IOException;
    }

    /* renamed from: okhttp3.internal.framed.FramedConnection$1 */
    class AnonymousClass1 extends NamedRunnable {
        final /* synthetic */ FramedConnection this$0;
        final /* synthetic */ ErrorCode val$errorCode;
        final /* synthetic */ int val$streamId;

        AnonymousClass1(FramedConnection framedConnection, String str, Object[] objArr, int i, ErrorCode errorCode) {
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:2:0x0001 in {1, 3} preds:[]
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:242)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
            	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
            	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
            	at jadx.core.ProcessClass.process(ProcessClass.java:37)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            */
        public void execute() {
            /*
            r3 = this;
            return;	 Catch:{ IOException -> 0x0009 }
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.framed.FramedConnection$AnonymousClass1.execute():void");
        }
    }

    /* renamed from: okhttp3.internal.framed.FramedConnection$2 */
    class AnonymousClass2 extends NamedRunnable {
        final /* synthetic */ FramedConnection this$0;
        final /* synthetic */ int val$streamId;
        final /* synthetic */ long val$unacknowledgedBytesRead;

        AnonymousClass2(FramedConnection framedConnection, String str, Object[] objArr, int i, long j) {
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:2:0x0001 in {1, 3} preds:[]
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:242)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
            	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
            	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
            	at jadx.core.ProcessClass.process(ProcessClass.java:37)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            */
        public void execute() {
            /*
            r4 = this;
            return;	 Catch:{ IOException -> 0x000b }
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.framed.FramedConnection$AnonymousClass2.execute():void");
        }
    }

    /* renamed from: okhttp3.internal.framed.FramedConnection$3 */
    class AnonymousClass3 extends NamedRunnable {
        final /* synthetic */ FramedConnection this$0;
        final /* synthetic */ int val$payload1;
        final /* synthetic */ int val$payload2;
        final /* synthetic */ Ping val$ping;
        final /* synthetic */ boolean val$reply;

        AnonymousClass3(FramedConnection framedConnection, String str, Object[] objArr, boolean z, int i, int i2, Ping ping) {
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:2:0x0001 in {1, 3} preds:[]
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:242)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
            	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
            	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
            	at jadx.core.ProcessClass.process(ProcessClass.java:37)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            */
        public void execute() {
            /*
            r5 = this;
            return;	 Catch:{ IOException -> 0x000d }
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.framed.FramedConnection$AnonymousClass3.execute():void");
        }
    }

    /* renamed from: okhttp3.internal.framed.FramedConnection$4 */
    class AnonymousClass4 extends NamedRunnable {
        final /* synthetic */ FramedConnection this$0;
        final /* synthetic */ List val$requestHeaders;
        final /* synthetic */ int val$streamId;

        AnonymousClass4(FramedConnection framedConnection, String str, Object[] objArr, int i, List list) {
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:1:0x0001
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:364)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:60)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
            	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
            	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
            	at jadx.core.ProcessClass.process(ProcessClass.java:37)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            */
        public void execute() {
            /*
            r3 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.framed.FramedConnection$AnonymousClass4.execute():void");
        }
    }

    /* renamed from: okhttp3.internal.framed.FramedConnection$5 */
    class AnonymousClass5 extends NamedRunnable {
        final /* synthetic */ FramedConnection this$0;
        final /* synthetic */ boolean val$inFinished;
        final /* synthetic */ List val$requestHeaders;
        final /* synthetic */ int val$streamId;

        AnonymousClass5(FramedConnection framedConnection, String str, Object[] objArr, int i, List list, boolean z) {
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:1:0x0001
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:364)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:60)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
            	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
            	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
            	at jadx.core.ProcessClass.process(ProcessClass.java:37)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            */
        public void execute() {
            /*
            r4 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.framed.FramedConnection$AnonymousClass5.execute():void");
        }
    }

    /* renamed from: okhttp3.internal.framed.FramedConnection$6 */
    class AnonymousClass6 extends NamedRunnable {
        final /* synthetic */ FramedConnection this$0;
        final /* synthetic */ Buffer val$buffer;
        final /* synthetic */ int val$byteCount;
        final /* synthetic */ boolean val$inFinished;
        final /* synthetic */ int val$streamId;

        AnonymousClass6(FramedConnection framedConnection, String str, Object[] objArr, int i, Buffer buffer, int i2, boolean z) {
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:2:0x0001
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:364)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:60)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
            	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
            	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
            	at jadx.core.ProcessClass.process(ProcessClass.java:37)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            */
        public void execute() {
            /*
            r5 = this;
            return;	 Catch:{ IOException -> 0x003c }
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.framed.FramedConnection$AnonymousClass6.execute():void");
        }
    }

    /* renamed from: okhttp3.internal.framed.FramedConnection$7 */
    class AnonymousClass7 extends NamedRunnable {
        final /* synthetic */ FramedConnection this$0;
        final /* synthetic */ ErrorCode val$errorCode;
        final /* synthetic */ int val$streamId;

        AnonymousClass7(FramedConnection framedConnection, String str, Object[] objArr, int i, ErrorCode errorCode) {
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:1:0x0001
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:364)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:60)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
            	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
            	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
            	at jadx.core.ProcessClass.process(ProcessClass.java:37)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            */
        public void execute() {
            /*
            r3 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.framed.FramedConnection$AnonymousClass7.execute():void");
        }
    }

    public static class Builder {
        private boolean client;
        private String hostname;
        private Listener listener = Listener.REFUSE_INCOMING_STREAMS;
        private Protocol protocol = Protocol.SPDY_3;
        private PushObserver pushObserver = PushObserver.CANCEL;
        private BufferedSink sink;
        private Socket socket;
        private BufferedSource source;

        public Builder(boolean z) {
            this.client = z;
        }

        public FramedConnection build() throws IOException {
            return new FramedConnection(this, null);
        }

        public Builder listener(Listener listener) {
            this.listener = listener;
            return this;
        }

        public Builder protocol(Protocol protocol) {
            this.protocol = protocol;
            return this;
        }

        public Builder pushObserver(PushObserver pushObserver) {
            this.pushObserver = pushObserver;
            return this;
        }

        public Builder socket(Socket socket) throws IOException {
            return socket(socket, ((InetSocketAddress) socket.getRemoteSocketAddress()).getHostName(), Okio.buffer(Okio.source(socket)), Okio.buffer(Okio.sink(socket)));
        }

        public Builder socket(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.socket = socket;
            this.hostname = str;
            this.source = bufferedSource;
            this.sink = bufferedSink;
            return this;
        }
    }

    class Reader extends NamedRunnable implements Handler {
        final FrameReader frameReader;
        final /* synthetic */ FramedConnection this$0;

        /* renamed from: okhttp3.internal.framed.FramedConnection$Reader$1 */
        class AnonymousClass1 extends NamedRunnable {
            final /* synthetic */ Reader this$1;
            final /* synthetic */ FramedStream val$newStream;

            AnonymousClass1(Reader reader, String str, Object[] objArr, FramedStream framedStream) {
            }

            /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:2:0x0001
                	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:364)
                	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:60)
                	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
                	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
                	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
                	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
                	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
                	at jadx.core.ProcessClass.process(ProcessClass.java:32)
                	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
                	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
                	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
                	at jadx.core.ProcessClass.process(ProcessClass.java:37)
                	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
                	at jadx.api.JavaClass.decompile(JavaClass.java:62)
                	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
                */
            public void execute() {
                /*
                r5 = this;
                return;	 Catch:{ IOException -> 0x000e }
                */
                throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.framed.FramedConnection$Reader$AnonymousClass1.execute():void");
            }
        }

        /* renamed from: okhttp3.internal.framed.FramedConnection$Reader$2 */
        class AnonymousClass2 extends NamedRunnable {
            final /* synthetic */ Reader this$1;

            AnonymousClass2(Reader reader, String str, Object... objArr) {
            }

            public void execute() {
            }
        }

        /* renamed from: okhttp3.internal.framed.FramedConnection$Reader$3 */
        class AnonymousClass3 extends NamedRunnable {
            final /* synthetic */ Reader this$1;
            final /* synthetic */ Settings val$peerSettings;

            AnonymousClass3(Reader reader, String str, Object[] objArr, Settings settings) {
            }

            /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:2:0x0001 in {1, 3} preds:[]
                	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:242)
                	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
                	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
                	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
                	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
                	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
                	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
                	at jadx.core.ProcessClass.process(ProcessClass.java:32)
                	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
                	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
                	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
                	at jadx.core.ProcessClass.process(ProcessClass.java:37)
                	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
                	at jadx.api.JavaClass.decompile(JavaClass.java:62)
                	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
                */
            public void execute() {
                /*
                r2 = this;
                return;	 Catch:{ IOException -> 0x000b }
                */
                throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.framed.FramedConnection$Reader$AnonymousClass3.execute():void");
            }
        }

        private Reader(FramedConnection framedConnection, FrameReader frameReader) {
        }

        /* synthetic */ Reader(FramedConnection framedConnection, FrameReader frameReader, AnonymousClass1 anonymousClass1) {
        }

        private void applyAndAckSettings(Settings settings) {
        }

        public void ackSettings() {
        }

        public void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j) {
        }

        public void data(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException {
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:1:0x0001
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:364)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:60)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
            	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
            	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
            	at jadx.core.ProcessClass.process(ProcessClass.java:37)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            */
        protected void execute() {
            /*
            r5 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.framed.FramedConnection$Reader.execute():void");
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:1:0x0001
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:364)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:60)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
            	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
            	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
            	at jadx.core.ProcessClass.process(ProcessClass.java:37)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            */
        public void goAway(int r4, okhttp3.internal.framed.ErrorCode r5, okio.ByteString r6) {
            /*
            r3 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.framed.FramedConnection$Reader.goAway(int, okhttp3.internal.framed.ErrorCode, okio.ByteString):void");
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:1:0x0001
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:364)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:60)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
            	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
            	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
            	at jadx.core.ProcessClass.process(ProcessClass.java:37)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            */
        public void headers(boolean r9, boolean r10, int r11, int r12, java.util.List<okhttp3.internal.framed.Header> r13, okhttp3.internal.framed.HeadersMode r14) {
            /*
            r8 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.framed.FramedConnection$Reader.headers(boolean, boolean, int, int, java.util.List, okhttp3.internal.framed.HeadersMode):void");
        }

        public void ping(boolean z, int i, int i2) {
        }

        public void priority(int i, int i2, int i3, boolean z) {
        }

        public void pushPromise(int i, int i2, List<Header> list) {
        }

        public void rstStream(int i, ErrorCode errorCode) {
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:1:0x0001
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:364)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:60)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
            	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
            	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
            	at jadx.core.ProcessClass.process(ProcessClass.java:37)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            */
        public void settings(boolean r11, okhttp3.internal.framed.Settings r12) {
            /*
            r10 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.framed.FramedConnection$Reader.settings(boolean, okhttp3.internal.framed.Settings):void");
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:1:0x0001
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:364)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:60)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
            	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
            	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
            	at jadx.core.ProcessClass.process(ProcessClass.java:37)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            */
        public void windowUpdate(int r6, long r7) {
            /*
            r5 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.framed.FramedConnection$Reader.windowUpdate(int, long):void");
        }
    }

    private FramedConnection(Builder builder) {
        this.streams = new HashMap();
        this.unacknowledgedBytesRead = 0;
        this.okHttpSettings = new Settings();
        this.peerSettings = new Settings();
        this.receivedInitialPeerSettings = false;
        this.currentPushRequests = new LinkedHashSet();
        this.protocol = builder.protocol;
        this.pushObserver = builder.pushObserver;
        this.client = builder.client;
        this.listener = builder.listener;
        int i = 2;
        this.nextStreamId = builder.client ? 1 : 2;
        if (builder.client && this.protocol == Protocol.HTTP_2) {
            this.nextStreamId += 2;
        }
        if (builder.client) {
            i = 1;
        }
        this.nextPingId = i;
        if (builder.client) {
            this.okHttpSettings.set(7, 0, 16777216);
        }
        this.hostname = builder.hostname;
        if (this.protocol == Protocol.HTTP_2) {
            this.variant = new Http2();
            this.pushExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(Util.format("OkHttp %s Push Observer", this.hostname), true));
            this.peerSettings.set(7, 0, 65535);
            this.peerSettings.set(5, 0, 16384);
        } else if (this.protocol == Protocol.SPDY_3) {
            this.variant = new Spdy3();
            this.pushExecutor = null;
        } else {
            throw new AssertionError(this.protocol);
        }
        this.bytesLeftInWriteWindow = (long) this.peerSettings.getInitialWindowSize(65536);
        this.socket = builder.socket;
        this.frameWriter = this.variant.newWriter(builder.sink, this.client);
        this.readerRunnable = new Reader(this, this.variant.newReader(builder.source, this.client), null);
    }

    /* synthetic */ FramedConnection(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private void close(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        IOException e;
        FramedStream[] framedStreamArr;
        Map map = null;
        try {
            shutdown(errorCode);
            e = null;
        } catch (IOException e2) {
            e = e2;
        }
        synchronized (this) {
            if (this.streams.isEmpty()) {
                framedStreamArr = null;
            } else {
                framedStreamArr = (FramedStream[]) this.streams.values().toArray(new FramedStream[this.streams.size()]);
                this.streams.clear();
            }
            if (this.pings != null) {
                Ping[] pingArr = (Ping[]) this.pings.values().toArray(new Ping[this.pings.size()]);
                this.pings = null;
                map = pingArr;
            }
        }
        int i = 0;
        if (framedStreamArr != null) {
            IOException iOException = e;
            for (FramedStream close : framedStreamArr) {
                try {
                    close.close(errorCode2);
                } catch (IOException e3) {
                    if (iOException != null) {
                        iOException = e3;
                    }
                }
            }
            e = iOException;
        }
        if (map != null) {
            int length = map.length;
            while (i < length) {
                map[i].cancel();
                i++;
            }
        }
        try {
            this.frameWriter.close();
        } catch (IOException e4) {
            if (e == null) {
                e = e4;
            }
        }
        try {
            this.socket.close();
        } catch (IOException e5) {
            e = e5;
        }
        if (e != null) {
            throw e;
        }
    }

    private FramedStream newStream(int i, List<Header> list, boolean z, boolean z2) throws IOException {
        FramedStream framedStream;
        boolean z3 = z ^ 1;
        int i2 = 1;
        z2 ^= 1;
        synchronized (this.frameWriter) {
            int i3;
            synchronized (this) {
                if (this.shutdown) {
                    throw new IOException("shutdown");
                }
                i3 = this.nextStreamId;
                this.nextStreamId += 2;
                framedStream = new FramedStream(i3, this, z3, z2, list);
                if (z && this.bytesLeftInWriteWindow != 0) {
                    if (framedStream.bytesLeftInWriteWindow != 0) {
                        i2 = 0;
                    }
                }
                if (framedStream.isOpen()) {
                    this.streams.put(Integer.valueOf(i3), framedStream);
                }
            }
            if (i == 0) {
                this.frameWriter.synStream(z3, z2, i3, i, list);
            } else if (this.client) {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            } else {
                this.frameWriter.pushPromise(i, i3, list);
            }
        }
        if (i2 != 0) {
            this.frameWriter.flush();
        }
        return framedStream;
    }

    private void pushDataLater(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException {
        Buffer buffer = new Buffer();
        long j = (long) i2;
        bufferedSource.require(j);
        bufferedSource.read(buffer, j);
        if (buffer.size() != j) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(buffer.size());
            stringBuilder.append(" != ");
            stringBuilder.append(i2);
            throw new IOException(stringBuilder.toString());
        }
        this.pushExecutor.execute(new AnonymousClass6(this, "OkHttp %s Push Data[%s]", new Object[]{this.hostname, Integer.valueOf(i)}, i, buffer, i2, z));
    }

    private void pushHeadersLater(int i, List<Header> list, boolean z) {
        this.pushExecutor.execute(new AnonymousClass5(this, "OkHttp %s Push Headers[%s]", new Object[]{this.hostname, Integer.valueOf(i)}, i, list, z));
    }

    private void pushRequestLater(int i, List<Header> list) {
        synchronized (this) {
            if (this.currentPushRequests.contains(Integer.valueOf(i))) {
                writeSynResetLater(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.currentPushRequests.add(Integer.valueOf(i));
            this.pushExecutor.execute(new AnonymousClass4(this, "OkHttp %s Push Request[%s]", new Object[]{this.hostname, Integer.valueOf(i)}, i, list));
        }
    }

    private void pushResetLater(int i, ErrorCode errorCode) {
        this.pushExecutor.execute(new AnonymousClass7(this, "OkHttp %s Push Reset[%s]", new Object[]{this.hostname, Integer.valueOf(i)}, i, errorCode));
    }

    private boolean pushedStream(int i) {
        return this.protocol == Protocol.HTTP_2 && i != 0 && (i & 1) == 0;
    }

    private synchronized Ping removePing(int i) {
        return this.pings != null ? (Ping) this.pings.remove(Integer.valueOf(i)) : null;
    }

    private void writePing(boolean z, int i, int i2, Ping ping) throws IOException {
        synchronized (this.frameWriter) {
            if (ping != null) {
                try {
                    ping.send();
                } catch (Throwable th) {
                }
            }
            this.frameWriter.ping(z, i, i2);
        }
    }

    private void writePingLater(boolean z, int i, int i2, Ping ping) {
        executor.execute(new AnonymousClass3(this, "OkHttp %s ping %08x%08x", new Object[]{this.hostname, Integer.valueOf(i), Integer.valueOf(i2)}, z, i, i2, ping));
    }

    /* Access modifiers changed, original: 0000 */
    public void addBytesToWriteWindow(long j) {
        this.bytesLeftInWriteWindow += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public void close() throws IOException {
        close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    public void flush() throws IOException {
        this.frameWriter.flush();
    }

    public Protocol getProtocol() {
        return this.protocol;
    }

    /* Access modifiers changed, original: declared_synchronized */
    public synchronized FramedStream getStream(int i) {
        return (FramedStream) this.streams.get(Integer.valueOf(i));
    }

    public synchronized int maxConcurrentStreams() {
        return this.peerSettings.getMaxConcurrentStreams(Integer.MAX_VALUE);
    }

    public FramedStream newStream(List<Header> list, boolean z, boolean z2) throws IOException {
        return newStream(0, list, z, z2);
    }

    public synchronized int openStreamCount() {
        return this.streams.size();
    }

    public Ping ping() throws IOException {
        int i;
        Ping ping = new Ping();
        synchronized (this) {
            if (this.shutdown) {
                throw new IOException("shutdown");
            }
            i = this.nextPingId;
            this.nextPingId += 2;
            if (this.pings == null) {
                this.pings = new HashMap();
            }
            this.pings.put(Integer.valueOf(i), ping);
        }
        writePing(false, i, 1330343787, ping);
        return ping;
    }

    public FramedStream pushStream(int i, List<Header> list, boolean z) throws IOException {
        if (this.client) {
            throw new IllegalStateException("Client cannot push requests.");
        } else if (this.protocol == Protocol.HTTP_2) {
            return newStream(i, list, z, false);
        } else {
            throw new IllegalStateException("protocol != HTTP_2");
        }
    }

    /* Access modifiers changed, original: declared_synchronized */
    public synchronized FramedStream removeStream(int i) {
        FramedStream framedStream;
        framedStream = (FramedStream) this.streams.remove(Integer.valueOf(i));
        notifyAll();
        return framedStream;
    }

    public void setSettings(Settings settings) throws IOException {
        synchronized (this.frameWriter) {
            synchronized (this) {
                if (this.shutdown) {
                    throw new IOException("shutdown");
                }
                this.okHttpSettings.merge(settings);
                this.frameWriter.settings(settings);
            }
        }
    }

    public void shutdown(ErrorCode errorCode) throws IOException {
        synchronized (this.frameWriter) {
            synchronized (this) {
                if (this.shutdown) {
                    return;
                }
                this.shutdown = true;
                int i = this.lastGoodStreamId;
                this.frameWriter.goAway(i, errorCode, Util.EMPTY_BYTE_ARRAY);
            }
        }
    }

    public void start() throws IOException {
        start(true);
    }

    /* Access modifiers changed, original: 0000 */
    public void start(boolean z) throws IOException {
        if (z) {
            this.frameWriter.connectionPreface();
            this.frameWriter.settings(this.okHttpSettings);
            int initialWindowSize = this.okHttpSettings.getInitialWindowSize(65536);
            if (initialWindowSize != 65536) {
                this.frameWriter.windowUpdate(0, (long) (initialWindowSize - 65536));
            }
        }
        new Thread(this.readerRunnable).start();
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x005d */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:27|28|29) */
    /* JADX WARNING: Missing block: B:17:?, code skipped:
            r2 = java.lang.Math.min((int) java.lang.Math.min(r14, r10.bytesLeftInWriteWindow), r10.frameWriter.maxDataLength());
            r6 = (long) r2;
            r10.bytesLeftInWriteWindow -= r6;
     */
    /* JADX WARNING: Missing block: B:29:0x0062, code skipped:
            throw new java.io.InterruptedIOException();
     */
    public void writeData(int r11, boolean r12, okio.Buffer r13, long r14) throws java.io.IOException {
        /*
        r10 = this;
        r0 = 0;
        r2 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1));
        r3 = 0;
        if (r2 != 0) goto L_0x000d;
    L_0x0007:
        r14 = r10.frameWriter;
        r14.data(r12, r11, r13, r3);
        return;
    L_0x000d:
        r2 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1));
        if (r2 <= 0) goto L_0x0065;
    L_0x0011:
        monitor-enter(r10);
    L_0x0012:
        r4 = r10.bytesLeftInWriteWindow;	 Catch:{ InterruptedException -> 0x005d }
        r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r2 > 0) goto L_0x0030;
    L_0x0018:
        r2 = r10.streams;	 Catch:{ InterruptedException -> 0x005d }
        r4 = java.lang.Integer.valueOf(r11);	 Catch:{ InterruptedException -> 0x005d }
        r2 = r2.containsKey(r4);	 Catch:{ InterruptedException -> 0x005d }
        if (r2 != 0) goto L_0x002c;
    L_0x0024:
        r11 = new java.io.IOException;	 Catch:{ InterruptedException -> 0x005d }
        r12 = "stream closed";
        r11.<init>(r12);	 Catch:{ InterruptedException -> 0x005d }
        throw r11;	 Catch:{ InterruptedException -> 0x005d }
    L_0x002c:
        r10.wait();	 Catch:{ InterruptedException -> 0x005d }
        goto L_0x0012;
    L_0x0030:
        r4 = r10.bytesLeftInWriteWindow;	 Catch:{ all -> 0x005b }
        r4 = java.lang.Math.min(r14, r4);	 Catch:{ all -> 0x005b }
        r2 = (int) r4;	 Catch:{ all -> 0x005b }
        r4 = r10.frameWriter;	 Catch:{ all -> 0x005b }
        r4 = r4.maxDataLength();	 Catch:{ all -> 0x005b }
        r2 = java.lang.Math.min(r2, r4);	 Catch:{ all -> 0x005b }
        r4 = r10.bytesLeftInWriteWindow;	 Catch:{ all -> 0x005b }
        r6 = (long) r2;	 Catch:{ all -> 0x005b }
        r8 = r4 - r6;
        r10.bytesLeftInWriteWindow = r8;	 Catch:{ all -> 0x005b }
        monitor-exit(r10);	 Catch:{ all -> 0x005b }
        r4 = r14 - r6;
        r14 = r10.frameWriter;
        if (r12 == 0) goto L_0x0055;
    L_0x004f:
        r15 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r15 != 0) goto L_0x0055;
    L_0x0053:
        r15 = 1;
        goto L_0x0056;
    L_0x0055:
        r15 = r3;
    L_0x0056:
        r14.data(r15, r11, r13, r2);
        r14 = r4;
        goto L_0x000d;
    L_0x005b:
        r11 = move-exception;
        goto L_0x0063;
    L_0x005d:
        r11 = new java.io.InterruptedIOException;	 Catch:{ all -> 0x005b }
        r11.<init>();	 Catch:{ all -> 0x005b }
        throw r11;	 Catch:{ all -> 0x005b }
    L_0x0063:
        monitor-exit(r10);	 Catch:{ all -> 0x005b }
        throw r11;
    L_0x0065:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.framed.FramedConnection.writeData(int, boolean, okio.Buffer, long):void");
    }

    /* Access modifiers changed, original: 0000 */
    public void writeSynReply(int i, boolean z, List<Header> list) throws IOException {
        this.frameWriter.synReply(z, i, list);
    }

    /* Access modifiers changed, original: 0000 */
    public void writeSynReset(int i, ErrorCode errorCode) throws IOException {
        this.frameWriter.rstStream(i, errorCode);
    }

    /* Access modifiers changed, original: 0000 */
    public void writeSynResetLater(int i, ErrorCode errorCode) {
        executor.submit(new AnonymousClass1(this, "OkHttp %s stream %d", new Object[]{this.hostname, Integer.valueOf(i)}, i, errorCode));
    }

    /* Access modifiers changed, original: 0000 */
    public void writeWindowUpdateLater(int i, long j) {
        executor.execute(new AnonymousClass2(this, "OkHttp Window Update %s stream %d", new Object[]{this.hostname, Integer.valueOf(i)}, i, j));
    }
}
