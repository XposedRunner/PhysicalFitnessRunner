package defpackage;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;

/* compiled from: WrapperUtils */
/* renamed from: gb */
public class gb {

    /* compiled from: WrapperUtils */
    /* renamed from: gb$1 */
    static class 1 extends SpanSizeLookup {
        final /* synthetic */ O000000o O000000o;
        final /* synthetic */ GridLayoutManager O00000Oo;
        final /* synthetic */ SpanSizeLookup O00000o0;

        1(O000000o o000000o, GridLayoutManager gridLayoutManager, SpanSizeLookup spanSizeLookup) {
        }

        public int getSpanSize(int i) {
            return 0;
        }
    }

    /* compiled from: WrapperUtils */
    /* renamed from: gb$O000000o */
    public interface O000000o {
        int O000000o(GridLayoutManager gridLayoutManager, SpanSizeLookup spanSizeLookup, int i);
    }

    public static void O000000o(Adapter adapter, RecyclerView recyclerView, O000000o o000000o) {
    }

    public static void O000000o(ViewHolder viewHolder) {
    }
}
