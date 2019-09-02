package com.loc;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import java.io.File;
import java.io.RandomAccessFile;

/* compiled from: DexDownLoad */
public final class O000OOOo implements com.loc.O00OOOo.O000000o {
    private O000OOo0 O000000o;
    private O00OOOo O00000Oo;
    private String O00000o;
    private OO0Oo0 O00000o0;
    private RandomAccessFile O00000oO;
    private Context O00000oo;

    /* compiled from: DexDownLoad */
    class O000000o implements Runnable {
        private int O00000Oo = 0;
        private String O00000o;
        private O000O0o O00000o0;

        O000000o() {
        }

        O000000o(O000O0o o000O0o) {
            this.O00000o0 = o000O0o;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:23:0x00b9 in {2, 5, 8, 11, 13, 15, 19, 20, 22} preds:[]
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
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            */
        public final void run() {
            /*
            r5 = this;
            r0 = r5.O00000Oo;
            switch(r0) {
                case 0: goto L_0x0070;
                case 1: goto L_0x0038;
                case 2: goto L_0x0038;
                case 3: goto L_0x0006;
                default: goto L_0x0005;
            };
            return;
            r0 = com.loc.O000OOOo.this;	 Catch:{ Throwable -> 0x002f }
            r0 = r0.O00000oo;	 Catch:{ Throwable -> 0x002f }
            r1 = r5.O00000o0;	 Catch:{ Throwable -> 0x002f }
            r2 = com.loc.O000OOOo.this;	 Catch:{ Throwable -> 0x002f }
            r2 = r2.O00000o0;	 Catch:{ Throwable -> 0x002f }
            r3 = com.loc.O000OOOo.this;	 Catch:{ Throwable -> 0x002f }
            r3 = r3.O00000o;	 Catch:{ Throwable -> 0x002f }
            r4 = r5.O00000o;	 Catch:{ Throwable -> 0x002f }
            com.loc.O000o000.O000000o(r0, r1, r2, r3, r4);	 Catch:{ Throwable -> 0x002f }
            r0 = com.loc.O000OOOo.this;	 Catch:{ Throwable -> 0x002f }
            r0 = r0.O00000oo;	 Catch:{ Throwable -> 0x002f }
            r1 = com.loc.O000OOOo.this;	 Catch:{ Throwable -> 0x002f }
            r1 = r1.O00000o0;	 Catch:{ Throwable -> 0x002f }
            com.loc.O000o000.O000000o(r0, r1);	 Catch:{ Throwable -> 0x002f }
            return;
            r0 = move-exception;
            r1 = "dDownLoad";
            r2 = "processDownloadedFile()";
            com.loc.O0000Oo.O000000o(r0, r1, r2);
            return;
            r0 = com.loc.O000OOOo.this;	 Catch:{ Throwable -> 0x0067 }
            r0 = r0.O00000oo;	 Catch:{ Throwable -> 0x0067 }
            r1 = r5.O00000o0;	 Catch:{ Throwable -> 0x0067 }
            r2 = com.loc.O000OOOo.this;	 Catch:{ Throwable -> 0x0067 }
            r2 = r2.O00000o0;	 Catch:{ Throwable -> 0x0067 }
            r3 = com.loc.O000OOOo.this;	 Catch:{ Throwable -> 0x0067 }
            r3 = r3.O00000o;	 Catch:{ Throwable -> 0x0067 }
            r4 = com.loc.O000OOOo.this;	 Catch:{ Throwable -> 0x0067 }
            r4 = r4.O000000o;	 Catch:{ Throwable -> 0x0067 }
            r4 = r4.O00000o;	 Catch:{ Throwable -> 0x0067 }
            com.loc.O000o000.O000000o(r0, r1, r2, r3, r4);	 Catch:{ Throwable -> 0x0067 }
            r0 = com.loc.O000OOOo.this;	 Catch:{ Throwable -> 0x0067 }
            r0 = r0.O00000oo;	 Catch:{ Throwable -> 0x0067 }
            r1 = com.loc.O000OOOo.this;	 Catch:{ Throwable -> 0x0067 }
            r1 = r1.O00000o0;	 Catch:{ Throwable -> 0x0067 }
            com.loc.O000o000.O000000o(r0, r1);	 Catch:{ Throwable -> 0x0067 }
            return;
            r0 = move-exception;
            r1 = "dDownLoad";
            r2 = "onFinish2";
            com.loc.O0000Oo.O000000o(r0, r1, r2);
            return;
            r0 = com.loc.O000OOOo.this;	 Catch:{ Throwable -> 0x00b3 }
            r0 = r0.O00000Oo();	 Catch:{ Throwable -> 0x00b3 }
            if (r0 == 0) goto L_0x00b2;	 Catch:{ Throwable -> 0x00b3 }
            r0 = new com.loc.O00OoO0o;	 Catch:{ Throwable -> 0x00b3 }
            r1 = com.loc.O000OOOo.this;	 Catch:{ Throwable -> 0x00b3 }
            r1 = r1.O00000oo;	 Catch:{ Throwable -> 0x00b3 }
            r2 = com.loc.O000OOOo.this;	 Catch:{ Throwable -> 0x00b3 }
            r2 = r2.O00000o0;	 Catch:{ Throwable -> 0x00b3 }
            r2 = r2.O000000o();	 Catch:{ Throwable -> 0x00b3 }
            r3 = com.loc.O000OOOo.this;	 Catch:{ Throwable -> 0x00b3 }
            r3 = r3.O00000o0;	 Catch:{ Throwable -> 0x00b3 }
            r3 = r3.O00000Oo();	 Catch:{ Throwable -> 0x00b3 }
            r4 = "O008";	 Catch:{ Throwable -> 0x00b3 }
            r0.<init>(r1, r2, r3, r4);	 Catch:{ Throwable -> 0x00b3 }
            r1 = "{\"param_int_first\":0}";	 Catch:{ Throwable -> 0x00b3 }
            r0.O000000o(r1);	 Catch:{ Throwable -> 0x00b3 }
            r1 = com.loc.O000OOOo.this;	 Catch:{ Throwable -> 0x00b3 }
            r1 = r1.O00000oo;	 Catch:{ Throwable -> 0x00b3 }
            com.loc.O00OoOO0.O000000o(r0, r1);	 Catch:{ Throwable -> 0x00b3 }
            r0 = com.loc.O000OOOo.this;	 Catch:{ Throwable -> 0x00b3 }
            r0 = r0.O00000Oo;	 Catch:{ Throwable -> 0x00b3 }
            r1 = com.loc.O000OOOo.this;	 Catch:{ Throwable -> 0x00b3 }
            r0.O000000o(r1);	 Catch:{ Throwable -> 0x00b3 }
            return;
            r0 = move-exception;
            r1 = "dDownLoad";
            r2 = "run()";
            goto L_0x006c;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.loc.O000OOOo$O000000o.run():void");
        }
    }

    public O000OOOo(Context context, O000OOo0 o000OOo0, OO0Oo0 oO0Oo0) {
        try {
            this.O00000oo = context.getApplicationContext();
            this.O00000o0 = oO0Oo0;
            if (o000OOo0 != null) {
                this.O000000o = o000OOo0;
                this.O00000Oo = new O00OOOo(new O00O0Oo(this.O000000o));
                this.O00000o = O000o000.O000000o(context, this.O000000o.O000000o);
            }
        } catch (Throwable th) {
            O0000Oo.O000000o(th, "dDownLoad", "DexDownLoad()");
        }
    }

    public final void O000000o() {
        try {
            O00O00Oo.O00000Oo().O000000o().submit(new O000000o());
        } catch (Throwable th) {
            O0000Oo.O000000o(th, "dDownLoad", "startDownload()");
        }
    }

    public final void O000000o(byte[] bArr, long j) {
        try {
            if (this.O00000oO == null) {
                File file = new File(this.O00000o);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.O00000oO = new RandomAccessFile(file, "rw");
            }
            this.O00000oO.seek(j);
            this.O00000oO.write(bArr);
        } catch (Throwable th) {
            O0000Oo.O000000o(th, "dDownLoad", "onDownload()");
        }
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004f A:{Catch:{ Throwable -> 0x005c }} */
    public final boolean O00000Oo() {
        /*
        r5 = this;
        r0 = r5.O000000o;
        r1 = 0;
        r2 = 1;
        if (r0 == 0) goto L_0x0010;
    L_0x0006:
        r0 = r5.O000000o;
        r0 = r0.O00000o0();
        if (r0 == 0) goto L_0x0010;
    L_0x000e:
        r0 = r2;
        goto L_0x0011;
    L_0x0010:
        r0 = r1;
    L_0x0011:
        r3 = r5.O00000o0;	 Catch:{ Throwable -> 0x005c }
        r4 = r5.O000000o;	 Catch:{ Throwable -> 0x005c }
        r3 = com.loc.O00O00o0.O000000o(r3, r4);	 Catch:{ Throwable -> 0x005c }
        if (r3 == 0) goto L_0x005b;
    L_0x001b:
        r3 = r5.O000000o;	 Catch:{ Throwable -> 0x005c }
        r3 = com.loc.O00O00o0.O000000o(r3);	 Catch:{ Throwable -> 0x005c }
        if (r3 == 0) goto L_0x005b;
    L_0x0023:
        r3 = r5.O00000oo;	 Catch:{ Throwable -> 0x005c }
        r0 = com.loc.O00O00o0.O000000o(r3, r0);	 Catch:{ Throwable -> 0x005c }
        if (r0 == 0) goto L_0x005b;
    L_0x002b:
        r0 = r5.O00000oo;	 Catch:{ Throwable -> 0x005c }
        r3 = r5.O000000o;	 Catch:{ Throwable -> 0x005c }
        r4 = r5.O00000o0;	 Catch:{ Throwable -> 0x005c }
        r0 = com.loc.O00O00o0.O000000o(r0, r3, r4);	 Catch:{ Throwable -> 0x005c }
        if (r0 != 0) goto L_0x005b;
    L_0x0037:
        r0 = r5.O00000oo;	 Catch:{ Throwable -> 0x005c }
        r3 = r5.O00000o0;	 Catch:{ Throwable -> 0x005c }
        r3 = r5.O000000o;	 Catch:{ Throwable -> 0x005c }
        r3 = r3.O00000o();	 Catch:{ Throwable -> 0x005c }
        if (r3 == 0) goto L_0x0045;
    L_0x0043:
        r0 = r2;
        goto L_0x004d;
    L_0x0045:
        r0 = com.loc.OO0o000.O00000Oo(r0);	 Catch:{ Throwable -> 0x005c }
        if (r0 != 0) goto L_0x004c;
    L_0x004b:
        goto L_0x0043;
    L_0x004c:
        r0 = r1;
    L_0x004d:
        if (r0 == 0) goto L_0x005b;
    L_0x004f:
        r0 = r5.O00000oo;	 Catch:{ Throwable -> 0x005c }
        r3 = r5.O00000o0;	 Catch:{ Throwable -> 0x005c }
        r3 = r3.O000000o();	 Catch:{ Throwable -> 0x005c }
        com.loc.O000o000.O00000Oo(r0, r3);	 Catch:{ Throwable -> 0x005c }
        return r2;
    L_0x005b:
        return r1;
    L_0x005c:
        r0 = move-exception;
        r2 = "dDownLoad";
        r3 = "isNeedDownload()";
        com.loc.O0000Oo.O000000o(r0, r2, r3);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O000OOOo.O00000Oo():boolean");
    }

    public final void O00000o() {
        try {
            if (this.O00000oO != null) {
                O00O00o0.O000000o(this.O00000oO);
                String O00000Oo = this.O000000o.O00000Oo();
                if (O00O00o0.O000000o(this.O00000o, O00000Oo)) {
                    String str = this.O000000o.O00000o0;
                    O000O0o o000O0o = new O000O0o(this.O00000oo, O000o.O00000Oo());
                    o000O0o.O000000o(new com.loc.O00O000o.O000000o(this.O000000o.O000000o, O00000Oo, this.O000000o.O00000Oo, str, this.O000000o.O00000o).O000000o("copy").O000000o(), O00O000o.O000000o(this.O000000o.O000000o, this.O000000o.O00000Oo, str, this.O000000o.O00000o));
                    Editor edit = this.O00000oo.getSharedPreferences(this.O000000o.O00000Oo, 0).edit();
                    edit.clear();
                    edit.commit();
                    try {
                        O00O00Oo.O00000Oo().O000000o().submit(new O000000o(o000O0o));
                    } catch (Throwable th) {
                        O0000Oo.O000000o(th, "dDownLoad", "onFinish1");
                    }
                    O00OoO0o o00OoO0o = new O00OoO0o(this.O00000oo, this.O00000o0.O000000o(), this.O00000o0.O00000Oo(), "O008");
                    o00OoO0o.O000000o("{\"param_int_first\":1}");
                    O00OoOO0.O000000o(o00OoO0o, this.O00000oo);
                    return;
                }
                try {
                    new File(this.O00000o).delete();
                } catch (Throwable th2) {
                    O0000Oo.O000000o(th2, "dDownLoad", "onFinish");
                }
            }
        } catch (Throwable th22) {
            O0000Oo.O000000o(th22, "dDownLoad", "onFinish()");
        }
    }

    public final void O00000o0() {
        try {
            O00O00o0.O000000o(this.O00000oO);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void O00000oO() {
    }
}
