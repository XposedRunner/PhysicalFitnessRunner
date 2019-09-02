package defpackage;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/* compiled from: HeaderViewRecyclerAdapter */
/* renamed from: fs */
public class fs extends Adapter {
    private static final int O000000o = -1024;
    private static final int O00000Oo = -2048;
    private final List<O000000o> O00000o;
    private final List<O000000o> O00000o0;
    private final List<O000000o> O00000oO;
    private final List<O000000o> O00000oo;
    private final Adapter O0000O0o;
    private boolean O0000OOo;

    /* compiled from: HeaderViewRecyclerAdapter */
    /* renamed from: fs$1 */
    class 1 extends ViewHolder {
        final /* synthetic */ fs O000000o;

        1(fs fsVar, View view) {
        }
    }

    /* compiled from: HeaderViewRecyclerAdapter */
    /* renamed from: fs$2 */
    class 2 extends SpanSizeLookup {
        final /* synthetic */ GridLayoutManager O000000o;
        final /* synthetic */ fs O00000Oo;

        2(fs fsVar, GridLayoutManager gridLayoutManager) {
        }

        public int getSpanSize(int i) {
            return 0;
        }
    }

    /* compiled from: HeaderViewRecyclerAdapter */
    /* renamed from: fs$O000000o */
    public static class O000000o {
        public int O000000o;
        public View O00000Oo;
    }

    public fs(Adapter adapter) {
    }

    public fs(Adapter adapter, List<O000000o> list, List<O000000o> list2) {
    }

    private boolean O000000o(int i) {
        return false;
    }

    private boolean O00000Oo(int i) {
        return false;
    }

    private boolean O00000o(int i) {
        return false;
    }

    private boolean O00000o0(int i) {
        return false;
    }

    private ViewHolder O0000O0o(View view) {
        return null;
    }

    public int O000000o() {
        return 0;
    }

    public void O000000o(RecyclerView recyclerView) {
    }

    public void O000000o(boolean z) {
    }

    public boolean O000000o(View view) {
        return false;
    }

    public int O00000Oo() {
        return 0;
    }

    public void O00000Oo(boolean z) {
    }

    public boolean O00000Oo(View view) {
        return false;
    }

    public void O00000o() {
    }

    public void O00000o(View view) {
    }

    public void O00000o0(View view) {
    }

    public boolean O00000o0() {
        return false;
    }

    public void O00000oO() {
    }

    public boolean O00000oO(View view) {
        return false;
    }

    public Adapter O00000oo() {
        return null;
    }

    public boolean O00000oo(View view) {
        return false;
    }

    public int getItemCount() {
        return 0;
    }

    public int getItemViewType(int i) {
        return 0;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
    }

    public void registerAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
    }

    public void unregisterAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
    }
}
