package com.qiyukf.nim.uikit.common.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public abstract class f<T> implements a {
    protected d adapter;
    protected Context context;
    protected int position;
    protected View view;

    public void destroy() {
    }

    /* Access modifiers changed, original: protected */
    public <T extends View> T findView(int i) {
        return this.view.findViewById(i);
    }

    /* Access modifiers changed, original: protected */
    public d getAdapter() {
        return this.adapter;
    }

    public abstract int getResId();

    public View getView(LayoutInflater layoutInflater) {
        this.view = layoutInflater.inflate(getResId(), null);
        inflate();
        return this.view;
    }

    public abstract void inflate();

    public boolean isFirstItem() {
        return this.position == 0;
    }

    public boolean isLastItem() {
        return this.position == this.adapter.getCount() - 1;
    }

    /* Access modifiers changed, original: protected */
    public boolean mutable() {
        return this.adapter.b();
    }

    public void onImmutable() {
    }

    public void reclaim() {
    }

    public abstract void refresh(T t);

    /* Access modifiers changed, original: protected */
    public void setAdapter(d dVar) {
        this.adapter = dVar;
    }

    /* Access modifiers changed, original: protected */
    public void setContext(Context context) {
        this.context = context;
    }

    /* Access modifiers changed, original: protected */
    public void setPosition(int i) {
        this.position = i;
    }
}
