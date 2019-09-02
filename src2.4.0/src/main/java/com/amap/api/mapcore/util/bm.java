package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.Map;

/* compiled from: LocationRequest */
public final class bm extends ooooO000 {
    String O00000o = "";
    Map<String, String> O00000o0 = null;
    byte[] O00000oO = null;
    byte[] O00000oo = null;
    boolean O0000O0o = false;
    String O0000OOo = null;
    boolean O0000Oo = false;
    Map<String, String> O0000Oo0 = null;
    private String O0000OoO = "";

    public bm(Context context, o0OO0o00 o0oo0o00) {
        super(context, o0oo0o00);
    }

    public final void O000000o() {
        this.O0000O0o = true;
    }

    public final void O000000o(String str) {
        this.O0000OOo = str;
    }

    public final void O000000o(Map<String, String> map) {
        this.O0000Oo0 = map;
    }

    public final void O00000Oo(String str) {
        this.O00000o = str;
    }

    public final void O00000Oo(Map<String, String> map) {
        this.O00000o0 = map;
    }

    public final void O00000Oo(byte[] bArr) {
        this.O00000oO = bArr;
    }

    public final byte[] O00000Oo() {
        return this.O00000oO;
    }

    public final byte[] O00000o0() {
        return this.O00000oo;
    }

    public final boolean O00000oO() {
        return this.O0000O0o;
    }

    public final String O0000O0o() {
        return this.O0000OOo;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean O0000OOo() {
        return this.O0000Oo;
    }

    public final void O0000Oo0() {
        this.O0000Oo = true;
    }

    /* Access modifiers changed, original: protected|final */
    public final String getIPDNSName() {
        return this.O0000OoO;
    }

    public final Map<String, String> getParams() {
        return this.O0000Oo0;
    }

    public final Map<String, String> getRequestHead() {
        return this.O00000o0;
    }

    public final String getURL() {
        return this.O00000o;
    }
}
