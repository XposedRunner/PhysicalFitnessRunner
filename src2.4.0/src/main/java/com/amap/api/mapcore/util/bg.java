package com.amap.api.mapcore.util;

import android.support.v4.os.EnvironmentCompat;
import java.util.Locale;

/* compiled from: Cgi */
public final class bg {
    public int O000000o = 0;
    public int O00000Oo = 0;
    public int O00000o = 0;
    public int O00000o0 = 0;
    public int O00000oO = 0;
    public int O00000oo = 0;
    public int O0000O0o = 0;
    public int O0000OOo = 0;
    public int O0000Oo = -113;
    public int O0000Oo0 = 0;
    public int O0000OoO = 0;
    public short O0000Ooo = (short) 0;
    public boolean O0000o0 = false;
    public long O0000o00 = 0;
    public boolean O0000o0O = true;

    public bg(int i, boolean z) {
        this.O0000OoO = i;
        this.O0000o0 = z;
    }

    public final int O000000o() {
        return this.O00000o0;
    }

    public final int O00000Oo() {
        return this.O00000o;
    }

    public final int O00000o() {
        return this.O0000Oo0;
    }

    public final int O00000o0() {
        return this.O0000OOo;
    }

    public final int O00000oO() {
        return this.O0000Oo;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof bg)) {
            bg bgVar = (bg) obj;
            switch (bgVar.O0000OoO) {
                case 1:
                    if (this.O0000OoO == 1 && bgVar.O00000o0 == this.O00000o0 && bgVar.O00000o == this.O00000o && bgVar.O00000Oo == this.O00000Oo) {
                        return true;
                    }
                    break;
                case 2:
                    return this.O0000OoO == 2 && bgVar.O0000Oo0 == this.O0000Oo0 && bgVar.O0000OOo == this.O0000OOo && bgVar.O0000O0o == this.O0000O0o;
                case 3:
                    return this.O0000OoO == 3 && bgVar.O00000o0 == this.O00000o0 && bgVar.O00000o == this.O00000o && bgVar.O00000Oo == this.O00000Oo;
                case 4:
                    return this.O0000OoO == 4 && bgVar.O00000o0 == this.O00000o0 && bgVar.O00000o == this.O00000o && bgVar.O00000Oo == this.O00000Oo;
                default:
                    return false;
            }
        }
        return false;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:6:0x0049 in {2, 4, 5} preds:[]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:242)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    public final int hashCode() {
        /*
        r3 = this;
        r0 = r3.O0000OoO;
        r0 = java.lang.String.valueOf(r0);
        r0 = r0.hashCode();
        r1 = r3.O0000OoO;
        r2 = 2;
        if (r1 != r2) goto L_0x0031;
        r1 = r3.O0000Oo0;
        r1 = java.lang.String.valueOf(r1);
        r1 = r1.hashCode();
        r2 = r3.O0000OOo;
        r2 = java.lang.String.valueOf(r2);
        r2 = r2.hashCode();
        r1 = r1 + r2;
        r2 = r3.O0000O0o;
        r2 = java.lang.String.valueOf(r2);
        r2 = r2.hashCode();
        r1 = r1 + r2;
        r0 = r0 + r1;
        return r0;
        r1 = r3.O00000o0;
        r1 = java.lang.String.valueOf(r1);
        r1 = r1.hashCode();
        r2 = r3.O00000o;
        r2 = java.lang.String.valueOf(r2);
        r2 = r2.hashCode();
        r1 = r1 + r2;
        r2 = r3.O00000Oo;
        goto L_0x0026;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.bg.hashCode():int");
    }

    public final String toString() {
        Locale locale;
        String str;
        Object[] objArr;
        String str2 = EnvironmentCompat.MEDIA_UNKNOWN;
        switch (this.O0000OoO) {
            case 1:
                locale = Locale.CHINA;
                str = "GSM lac=%d, cid=%d, mnc=%s, valid=%b, sig=%d, age=%d, reg=%b";
                objArr = new Object[]{Integer.valueOf(this.O00000o0), Integer.valueOf(this.O00000o), Integer.valueOf(this.O00000Oo), Boolean.valueOf(this.O0000o0O), Integer.valueOf(this.O0000Oo), Short.valueOf(this.O0000Ooo), Boolean.valueOf(this.O0000o0)};
                break;
            case 2:
                locale = Locale.CHINA;
                str = "CDMA bid=%d, nid=%d, sid=%d, valid=%b, sig=%d, age=%d, reg=%b";
                objArr = new Object[]{Integer.valueOf(this.O0000Oo0), Integer.valueOf(this.O0000OOo), Integer.valueOf(this.O0000O0o), Boolean.valueOf(this.O0000o0O), Integer.valueOf(this.O0000Oo), Short.valueOf(this.O0000Ooo), Boolean.valueOf(this.O0000o0)};
                break;
            case 3:
                locale = Locale.CHINA;
                str = "LTE lac=%d, cid=%d, mnc=%s, valid=%b, sig=%d, age=%d, reg=%b";
                objArr = new Object[]{Integer.valueOf(this.O00000o0), Integer.valueOf(this.O00000o), Integer.valueOf(this.O00000Oo), Boolean.valueOf(this.O0000o0O), Integer.valueOf(this.O0000Oo), Short.valueOf(this.O0000Ooo), Boolean.valueOf(this.O0000o0)};
                break;
            case 4:
                locale = Locale.CHINA;
                str = "WCDMA lac=%d, cid=%d, mnc=%s, valid=%b, sig=%d, age=%d, reg=%b";
                objArr = new Object[]{Integer.valueOf(this.O00000o0), Integer.valueOf(this.O00000o), Integer.valueOf(this.O00000Oo), Boolean.valueOf(this.O0000o0O), Integer.valueOf(this.O0000Oo), Short.valueOf(this.O0000Ooo), Boolean.valueOf(this.O0000o0)};
                break;
            default:
                return str2;
        }
        return String.format(locale, str, objArr);
    }
}
