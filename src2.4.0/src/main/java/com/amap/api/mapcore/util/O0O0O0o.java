package com.amap.api.mapcore.util;

/* compiled from: AbstractCityStateImp */
public abstract class O0O0O0o implements O0O0OOO {
    protected int O000000o;
    protected bf O00000Oo;

    public O0O0O0o(int i, bf bfVar) {
        this.O000000o = i;
        this.O00000Oo = bfVar;
    }

    public void O000000o() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Wrong call delete()  State: ");
        stringBuilder.append(O00000Oo());
        stringBuilder.append("  ");
        stringBuilder.append(getClass());
        O00o.O000000o(stringBuilder.toString());
    }

    public void O000000o(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Wrong call fail()  State: ");
        stringBuilder.append(O00000Oo());
        stringBuilder.append("  ");
        stringBuilder.append(getClass());
        O00o.O000000o(stringBuilder.toString());
    }

    public boolean O000000o(O0O0O0o o0O0O0o) {
        return o0O0O0o.O00000Oo() == O00000Oo();
    }

    public int O00000Oo() {
        return this.O000000o;
    }

    public void O00000Oo(O0O0O0o o0O0O0o) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(O00000Oo());
        stringBuilder.append(" ==> ");
        stringBuilder.append(o0O0O0o.O00000Oo());
        stringBuilder.append("   ");
        stringBuilder.append(getClass());
        stringBuilder.append("==>");
        stringBuilder.append(o0O0O0o.getClass());
        O00o.O000000o(stringBuilder.toString());
    }

    public void O00000o() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Wrong call continueDownload()  State: ");
        stringBuilder.append(O00000Oo());
        stringBuilder.append("  ");
        stringBuilder.append(getClass());
        O00o.O000000o(stringBuilder.toString());
    }

    public void O00000o0() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Wrong call start()  State: ");
        stringBuilder.append(O00000Oo());
        stringBuilder.append("  ");
        stringBuilder.append(getClass());
        O00o.O000000o(stringBuilder.toString());
    }

    public void O00000oO() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Wrong call pause()  State: ");
        stringBuilder.append(O00000Oo());
        stringBuilder.append("  ");
        stringBuilder.append(getClass());
        O00o.O000000o(stringBuilder.toString());
    }

    public void O00000oo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Wrong call hasNew()  State: ");
        stringBuilder.append(O00000Oo());
        stringBuilder.append("  ");
        stringBuilder.append(getClass());
        O00o.O000000o(stringBuilder.toString());
    }

    public void O0000O0o() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Wrong call complete()  State: ");
        stringBuilder.append(O00000Oo());
        stringBuilder.append("  ");
        stringBuilder.append(getClass());
        O00o.O000000o(stringBuilder.toString());
    }
}
