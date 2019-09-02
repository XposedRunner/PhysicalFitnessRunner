package com.baidu.location.indoor.mapversion;

import android.os.Build.VERSION;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class a {
    private static Lock a = new ReentrantLock();

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:11:0x0015 in {2, 4, 10, 13} preds:[]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:242)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    public static void a() {
        /*
        r0 = a;
        r0.lock();
        com.baidu.location.indoor.mapversion.IndoorJni.stopPdr();	 Catch:{ Exception -> 0x0010 }
        r0 = a;
        r0.unlock();
        return;
        r0 = move-exception;
        goto L_0x0016;
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x000e }
        goto L_0x0008;
        return;
        r1 = a;
        r1.unlock();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.mapversion.a.a():void");
    }

    public static synchronized void a(int i, float[] fArr, long j) {
        synchronized (a.class) {
            Lock lock;
            a.lock();
            try {
                if (b() && fArr != null && fArr.length >= 3) {
                    IndoorJni.phs(i, fArr[0], fArr[1], fArr[2], j);
                }
                lock = a;
            } catch (Exception e) {
                try {
                    e.printStackTrace();
                    lock = a;
                } catch (Throwable th) {
                    a.unlock();
                }
            }
            lock.unlock();
        }
        return;
    }

    public static boolean b() {
        return VERSION.SDK_INT < 19 ? false : IndoorJni.a;
    }

    public static float[] c() {
        float[] pgo;
        a.lock();
        try {
            pgo = IndoorJni.pgo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            a.unlock();
            return null;
        }
        return pgo;
    }
}
