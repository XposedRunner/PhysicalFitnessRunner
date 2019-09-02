package com.qiyukf.nim.uikit.session.module.a;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.qiyukf.nim.uikit.common.ui.listview.MessageListView;

public final class a {
    private View a;
    private Context b;
    private View c;
    private MessageListView d;
    private Handler e;
    private int f = 0;
    private Runnable g = new Runnable() {
        public final void run() {
            a.this.a.setVisibility(0);
        }
    };

    public a(Context context, View view, MessageListView messageListView) {
        this.b = context;
        this.c = view;
        this.d = messageListView;
        this.e = com.qiyukf.nimlib.d.a.c.a.b(messageListView.getContext());
    }
}
