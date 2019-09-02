package com.umeng.commonsdk.proguard;

import java.io.Serializable;

/* compiled from: TBase */
public interface j<T extends j<?, ?>, F extends q> extends Serializable {
    void clear();

    j<T, F> deepCopy();

    F fieldForId(int i);

    void read(ai aiVar) throws p;

    void write(ai aiVar) throws p;
}
