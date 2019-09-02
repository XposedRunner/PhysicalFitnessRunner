package com.taobao.wireless.security.adapter.common;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/*  JADX ERROR: NullPointerException in pass: ReSugarCode
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.ReSugarCode.initClsEnumMap(ReSugarCode.java:159)
    	at jadx.core.dex.visitors.ReSugarCode.visit(ReSugarCode.java:44)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:12)
    	at jadx.core.ProcessClass.process(ProcessClass.java:32)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
    	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
    	at jadx.core.ProcessClass.process(ProcessClass.java:37)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
    */
/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.ExtractFieldInit.checkStaticFieldsInit(ExtractFieldInit.java:58)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:44)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:12)
    	at jadx.core.ProcessClass.process(ProcessClass.java:32)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
    	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
    	at jadx.core.ProcessClass.process(ProcessClass.java:37)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
    */
public class d {
    private static String h = "SGLib";
    private FileChannel a;
    private FileLock b;
    private RandomAccessFile c;
    private File d;
    private boolean e;
    private String f;
    private Context g;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: com.taobao.wireless.security.adapter.common.d.<clinit>():void, dex: 
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:118)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:248)
        	at jadx.core.ProcessClass.process(ProcessClass.java:29)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:581)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:74)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:104)
        	... 9 more
        */
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: com.taobao.wireless.security.adapter.common.d.<clinit>():void, dex: 
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.wireless.security.adapter.common.d.<clinit>():void");
    }

    public d(Context context, String str) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = true;
        this.f = null;
        this.g = null;
        this.g = context;
        this.f = str;
        this.e = c();
    }

    private boolean c() {
        try {
            File filesDir = this.g.getFilesDir();
            if (filesDir == null || !filesDir.exists()) {
                filesDir = this.g.getFilesDir();
                if (filesDir != null) {
                    if (!filesDir.exists()) {
                    }
                }
                return this.d == null && this.d.exists();
            }
            String absolutePath = filesDir.getAbsolutePath();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(absolutePath);
            stringBuilder.append("/");
            stringBuilder.append(this.f);
            this.d = new File(stringBuilder.toString());
            if (!this.d.exists()) {
                this.d.createNewFile();
            }
        } catch (Exception unused) {
            if (!(this.d == null || this.d.exists())) {
                try {
                    this.d.createNewFile();
                } catch (Exception unused2) {
                }
            }
        }
        if (this.d == null) {
        }
    }

    public boolean a() {
        if (!this.e) {
            this.e = c();
            if (!this.e) {
                return true;
            }
        }
        try {
            if (this.d != null) {
                this.c = new RandomAccessFile(this.d, "rw");
                this.a = this.c.getChannel();
                this.b = this.a.lock();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean b() {
        boolean z = true;
        if (!this.e) {
            return true;
        }
        boolean z2 = false;
        try {
            if (this.b != null) {
                this.b.release();
                this.b = null;
            }
        } catch (IOException unused) {
            z = false;
        }
        try {
            if (this.a != null) {
                this.a.close();
                this.a = null;
            }
        } catch (IOException unused2) {
            z = false;
        }
        try {
            if (this.c != null) {
                this.c.close();
                this.c = null;
            }
            z2 = z;
        } catch (IOException unused3) {
        }
        return z2;
    }
}
