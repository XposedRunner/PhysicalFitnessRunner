package com.loc;

import cn.jiguang.net.HttpUtils;

/* compiled from: DexDownloadItem */
public final class O000OOo0 {
    String O000000o;
    String O00000Oo;
    String O00000o;
    String O00000o0;
    int O00000oO;
    int O00000oo;
    private String O0000O0o;
    private String O0000OOo;
    private boolean O0000Oo;
    private boolean O0000Oo0;

    public O000OOo0(String str, String str2) {
        this(str, str2, (byte) 0);
    }

    private O000OOo0(String str, String str2, byte b) {
        this.O0000Oo0 = false;
        this.O0000Oo = false;
        this.O0000O0o = str;
        this.O0000OOo = str2;
        this.O0000Oo0 = false;
        try {
            String[] split = str.split(HttpUtils.PATHS_SEPARATOR);
            int length = split.length;
            if (length > 1) {
                this.O000000o = split[length - 1];
                split = this.O000000o.split("_");
                this.O00000Oo = split[0];
                this.O00000o0 = split[2];
                this.O00000o = split[1];
                this.O00000oO = Integer.parseInt(split[3]);
                this.O00000oo = Integer.parseInt(split[4].split("\\.")[0]);
            }
        } catch (Throwable th) {
            O0000Oo.O000000o(th, "DexDownloadItem", "DexDownloadItem");
        }
    }

    /* Access modifiers changed, original: final */
    public final String O000000o() {
        return this.O0000O0o;
    }

    public final void O000000o(boolean z) {
        this.O0000Oo = z;
    }

    /* Access modifiers changed, original: final */
    public final String O00000Oo() {
        return this.O0000OOo;
    }

    public final boolean O00000o() {
        return this.O0000Oo;
    }

    public final boolean O00000o0() {
        return this.O0000Oo0;
    }
}
