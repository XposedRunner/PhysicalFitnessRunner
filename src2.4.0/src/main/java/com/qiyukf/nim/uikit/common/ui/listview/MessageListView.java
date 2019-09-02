package com.qiyukf.nim.uikit.common.ui.listview;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView.RecyclerListener;
import android.widget.BaseAdapter;

public class MessageListView extends AutoRefreshListView {
    private com.qiyukf.nim.uikit.common.a.b a;
    private GestureDetector b;
    private b c;
    private RecyclerListener d = new RecyclerListener() {
        public final void onMovedToScrapHeap(View view) {
            if (MessageListView.this.a != null) {
                MessageListView.this.a.a(view);
            }
        }
    };
    private boolean e = false;

    private class a extends SimpleOnGestureListener {
        private a() {
        }

        /* synthetic */ a(MessageListView messageListView, byte b) {
            this();
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!(MessageListView.this.e || MessageListView.this.c == null)) {
                MessageListView.this.c.a();
                MessageListView.this.e = true;
            }
            return true;
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            if (!(MessageListView.this.e || MessageListView.this.c == null)) {
                MessageListView.this.c.a();
                MessageListView.this.e = true;
            }
            return true;
        }
    }

    public interface b {
        void a();

        void a(int i, int i2);

        void b();
    }

    public MessageListView(Context context) {
        super(context);
        a(context);
    }

    public MessageListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public MessageListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    @TargetApi(21)
    public MessageListView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context);
    }

    private void a(Context context) {
        setRecyclerListener(this.d);
        this.b = new GestureDetector(context, new a(this, (byte) 0));
    }

    public final void a(BaseAdapter baseAdapter) {
        com.qiyukf.nim.uikit.common.a.b bVar = (baseAdapter == null || !(baseAdapter instanceof com.qiyukf.nim.uikit.common.a.b)) ? null : (com.qiyukf.nim.uikit.common.a.b) baseAdapter;
        this.a = bVar;
        super.setAdapter(baseAdapter);
    }

    public final void a(b bVar) {
        this.c = bVar;
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.c != null) {
            this.c.a(i2, i4);
        }
        super.onSizeChanged(i, i2, i3, i4);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.b.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            this.e = false;
        }
        if (this.c != null) {
            this.c.b();
        }
        return super.onTouchEvent(motionEvent);
    }
}
