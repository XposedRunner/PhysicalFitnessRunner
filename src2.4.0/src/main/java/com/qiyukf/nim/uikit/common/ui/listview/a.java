package com.qiyukf.nim.uikit.common.ui.listview;

import android.os.Build.VERSION;
import android.widget.ListView;

public final class a {

    public interface a {
    }

    public static void a(final ListView listView) {
        final int count = listView.getAdapter().getCount() - 1;
        listView.post(new Runnable() {
            final /* synthetic */ int c = 0;
            final /* synthetic */ a d = null;

            public final void run() {
                if (VERSION.SDK_INT >= 11) {
                    listView.setSelectionFromTop(count, this.c);
                } else {
                    listView.setSelection(count);
                }
            }
        });
    }
}
