package com.qiyukf.unicorn.widget.pulltorefresh;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ListView;

public class PullableListView extends ListView implements a {
    private boolean a = false;
    private boolean b = false;

    public PullableListView(Context context) {
        super(context);
    }

    public PullableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PullableListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private boolean b(int i) {
        if (VERSION.SDK_INT >= 14) {
            return canScrollVertically(i);
        }
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        int computeVerticalScrollRange = computeVerticalScrollRange() - computeVerticalScrollExtent();
        return computeVerticalScrollRange == 0 ? false : i < 0 ? computeVerticalScrollOffset > 0 : computeVerticalScrollOffset < computeVerticalScrollRange - 1;
    }

    public final void a(int i) {
        smoothScrollBy(i, 0);
    }

    public final void a(boolean z) {
        this.a = false;
        this.b = z;
    }

    public final boolean a() {
        return this.a && !b(-1);
    }

    public final boolean b() {
        return this.b && !b(1);
    }
}
