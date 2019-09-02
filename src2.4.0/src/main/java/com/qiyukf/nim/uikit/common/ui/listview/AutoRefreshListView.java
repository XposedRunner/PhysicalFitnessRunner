package com.qiyukf.nim.uikit.common.ui.listview;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.qiyukf.unicorn.R;
import java.util.ArrayList;
import java.util.List;

public class AutoRefreshListView extends ListView {
    private b a;
    private List<OnScrollListener> b = new ArrayList();
    private int c = c.b;
    private int d = a.a;
    private int e = a.a;
    private boolean f = true;
    private boolean g = true;
    private ViewGroup h;
    private ViewGroup i;
    private int j;
    private boolean k = false;
    private int l = 0;

    /* renamed from: com.qiyukf.nim.uikit.common.ui.listview.AutoRefreshListView$3 */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] a = new int[c.a().length];
        static final /* synthetic */ int[] b = new int[a.a().length];

        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0029 */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|5|6|7|9|10|11|12|14) */
        /* JADX WARNING: Missing block: B:15:?, code skipped:
            return;
     */
        static {
            /*
            r0 = com.qiyukf.nim.uikit.common.ui.listview.AutoRefreshListView.a.a();
            r0 = r0.length;
            r0 = new int[r0];
            b = r0;
            r0 = 1;
            r1 = b;	 Catch:{ NoSuchFieldError -> 0x0011 }
            r2 = com.qiyukf.nim.uikit.common.ui.listview.AutoRefreshListView.a.b;	 Catch:{ NoSuchFieldError -> 0x0011 }
            r2 = r2 - r0;
            r1[r2] = r0;	 Catch:{ NoSuchFieldError -> 0x0011 }
        L_0x0011:
            r1 = 2;
            r2 = b;	 Catch:{ NoSuchFieldError -> 0x0019 }
            r3 = com.qiyukf.nim.uikit.common.ui.listview.AutoRefreshListView.a.a;	 Catch:{ NoSuchFieldError -> 0x0019 }
            r3 = r3 - r0;
            r2[r3] = r1;	 Catch:{ NoSuchFieldError -> 0x0019 }
        L_0x0019:
            r2 = com.qiyukf.nim.uikit.common.ui.listview.AutoRefreshListView.c.a();
            r2 = r2.length;
            r2 = new int[r2];
            a = r2;
            r2 = a;	 Catch:{ NoSuchFieldError -> 0x0029 }
            r3 = com.qiyukf.nim.uikit.common.ui.listview.AutoRefreshListView.c.a;	 Catch:{ NoSuchFieldError -> 0x0029 }
            r3 = r3 - r0;
            r2[r3] = r0;	 Catch:{ NoSuchFieldError -> 0x0029 }
        L_0x0029:
            r2 = a;	 Catch:{ NoSuchFieldError -> 0x0030 }
            r3 = com.qiyukf.nim.uikit.common.ui.listview.AutoRefreshListView.c.b;	 Catch:{ NoSuchFieldError -> 0x0030 }
            r3 = r3 - r0;
            r2[r3] = r1;	 Catch:{ NoSuchFieldError -> 0x0030 }
        L_0x0030:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nim.uikit.common.ui.listview.AutoRefreshListView$AnonymousClass3.<clinit>():void");
        }
    }

    public enum a {
        ;
        
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;

        static {
            d = new int[]{a, b, c};
        }

        public static int[] a() {
            return (int[]) d.clone();
        }
    }

    public interface b {
        void a();

        void b();
    }

    public enum c {
        ;
        
        public static final int a = 1;
        public static final int b = 2;

        static {
            c = new int[]{a, b};
        }

        public static int[] a() {
            return (int[]) c.clone();
        }
    }

    public AutoRefreshListView(Context context) {
        super(context);
        a(context);
    }

    public AutoRefreshListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public AutoRefreshListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    @TargetApi(21)
    public AutoRefreshListView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context);
    }

    private void a() {
        switch (AnonymousClass3.a[this.c - 1]) {
            case 1:
                (AnonymousClass3.b[this.e - 1] != 1 ? this.h : this.i).getChildAt(0).setVisibility(0);
                return;
            case 2:
                int i = 8;
                if (this.e == a.a) {
                    View childAt = this.h.getChildAt(0);
                    if (this.f) {
                        i = 4;
                    }
                    childAt.setVisibility(i);
                    return;
                }
                this.i.getChildAt(0).setVisibility(8);
                return;
            default:
                return;
        }
    }

    private void a(Context context) {
        this.h = (ViewGroup) View.inflate(context, R.layout.ysf_listview_refresh, null);
        addHeaderView(this.h, null, false);
        this.i = (ViewGroup) View.inflate(context, R.layout.ysf_listview_refresh, null);
        addFooterView(this.i, null, false);
        super.setOnScrollListener(new OnScrollListener() {
            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                for (OnScrollListener onScroll : AutoRefreshListView.this.b) {
                    onScroll.onScroll(absListView, i, i2, i3);
                }
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                for (OnScrollListener onScrollStateChanged : AutoRefreshListView.this.b) {
                    onScrollStateChanged.onScrollStateChanged(absListView, i);
                }
            }
        });
        this.b.add(new OnScrollListener() {
            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0 && AutoRefreshListView.this.c == c.b) {
                    boolean z = true;
                    boolean z2 = AutoRefreshListView.this.getFirstVisiblePosition() < AutoRefreshListView.this.getHeaderViewsCount() && AutoRefreshListView.this.getCount() > AutoRefreshListView.this.getHeaderViewsCount();
                    if (z2) {
                        AutoRefreshListView.a(AutoRefreshListView.this, true);
                        return;
                    }
                    if (AutoRefreshListView.this.getLastVisiblePosition() < AutoRefreshListView.this.getCount() - 1) {
                        z = false;
                    }
                    if (z) {
                        AutoRefreshListView.a(AutoRefreshListView.this, false);
                    }
                }
            }
        });
        this.c = c.b;
    }

    static /* synthetic */ void a(AutoRefreshListView autoRefreshListView, boolean z) {
        if (autoRefreshListView.a != null) {
            int i;
            View childAt = autoRefreshListView.getChildAt(autoRefreshListView.getHeaderViewsCount());
            if (childAt != null) {
                autoRefreshListView.j = childAt.getTop();
            }
            if (z && autoRefreshListView.f && autoRefreshListView.d != a.b) {
                autoRefreshListView.a.a();
                i = a.a;
            } else {
                if (autoRefreshListView.g && autoRefreshListView.d != a.a) {
                    autoRefreshListView.a.b();
                    i = a.b;
                }
                autoRefreshListView.a();
            }
            autoRefreshListView.e = i;
            autoRefreshListView.c = c.a;
            autoRefreshListView.a();
        }
    }

    private boolean a(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                b(motionEvent);
                break;
            case 1:
            case 3:
                if (this.k) {
                    this.h.setPadding(0, 0, 0, 0);
                }
                this.k = false;
                break;
            case 2:
                b(motionEvent);
                if (this.k) {
                    this.h.setPadding(0, Math.max((int) (motionEvent.getY() - ((float) this.l)), 0) / 2, 0, 0);
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void b(MotionEvent motionEvent) {
        int firstVisiblePosition = getFirstVisiblePosition();
        if (!this.f && firstVisiblePosition <= getHeaderViewsCount() && !this.k) {
            this.k = true;
            this.l = (int) motionEvent.getY();
        }
    }

    public final void a(int i) {
        this.d = i;
    }

    public final void a(b bVar) {
        this.a = bVar;
    }

    public final void b(int i) {
        this.c = c.a;
        this.e = i;
    }

    public final void c(int i) {
        this.c = c.b;
        boolean z = true;
        int i2 = 0;
        if (this.e == a.a) {
            if (getCount() == (getHeaderViewsCount() + i) + getFooterViewsCount()) {
            }
            z = false;
            this.f = z;
        } else {
            if (i <= 0) {
                z = false;
            }
            this.g = z;
        }
        a();
        if (this.e == a.a) {
            i += getHeaderViewsCount();
            if (this.f) {
                i2 = this.j;
            }
            setSelectionFromTop(i, i2);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (VERSION.SDK_INT >= 11) {
            return a(motionEvent);
        }
        try {
            return a(motionEvent);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        throw new UnsupportedOperationException("Use addOnScrollListener instead!");
    }
}
