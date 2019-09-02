package com.qiyukf.nim.uikit.common.media.picker.model;

import java.io.Serializable;
import java.util.List;

public final class a implements Serializable {
    private static final long serialVersionUID = 1;
    private int a;
    private String b;
    private String c;
    private String d;
    private List<PhotoInfo> e;

    public final int a() {
        return this.a;
    }

    public final void a(int i) {
        this.a = i;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final void a(List<PhotoInfo> list) {
        this.e = list;
    }

    public final String b() {
        return this.b;
    }

    public final void b(String str) {
        this.c = str;
    }

    public final String c() {
        return this.c;
    }

    public final void c(String str) {
        this.d = str;
    }

    public final String d() {
        return this.d;
    }

    public final List<PhotoInfo> e() {
        return this.e;
    }
}
