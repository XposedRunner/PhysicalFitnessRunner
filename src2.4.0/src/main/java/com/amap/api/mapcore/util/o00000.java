package com.amap.api.mapcore.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.util.List;

/* compiled from: OfflineListAdapter */
public class o00000 extends BaseExpandableListAdapter implements OnGroupCollapseListener, OnGroupExpandListener {
    private boolean[] O000000o;
    private int O00000Oo = -1;
    private OfflineMapManager O00000o;
    private List<OfflineMapProvince> O00000o0 = null;
    private Context O00000oO;

    /* compiled from: OfflineListAdapter */
    public final class O000000o {
        public o0 O000000o;
    }

    public o00000(List<OfflineMapProvince> list, OfflineMapManager offlineMapManager, Context context) {
        this.O00000o0 = list;
        this.O00000o = offlineMapManager;
        this.O00000oO = context;
        this.O000000o = new boolean[list.size()];
    }

    private boolean O000000o(int i) {
        return (i == 0 || i == getGroupCount() - 1) ? false : true;
    }

    public void O000000o() {
        this.O00000Oo = -1;
        notifyDataSetChanged();
    }

    public void O00000Oo() {
        this.O00000Oo = 0;
        notifyDataSetChanged();
    }

    public Object getChild(int i, int i2) {
        return null;
    }

    public long getChildId(int i, int i2) {
        return (long) i2;
    }

    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        O000000o o000000o;
        if (view != null) {
            o000000o = (O000000o) view.getTag();
        } else {
            o000000o = new O000000o();
            o0 o0Var = new o0(this.O00000oO, this.O00000o);
            o0Var.O000000o(1);
            View O000000o = o0Var.O000000o();
            o000000o.O000000o = o0Var;
            O000000o.setTag(o000000o);
            view = O000000o;
        }
        o000000o.O000000o.O000000o((OfflineMapCity) ((OfflineMapProvince) this.O00000o0.get(i)).getCityList().get(i2));
        return view;
    }

    public int getChildrenCount(int i) {
        return O000000o(i) ? ((OfflineMapProvince) this.O00000o0.get(i)).getCityList().size() : ((OfflineMapProvince) this.O00000o0.get(i)).getCityList().size();
    }

    public Object getGroup(int i) {
        return ((OfflineMapProvince) this.O00000o0.get(i)).getProvinceName();
    }

    public int getGroupCount() {
        return this.O00000Oo == -1 ? this.O00000o0.size() : this.O00000Oo;
    }

    public long getGroupId(int i) {
        return (long) i;
    }

    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = (RelativeLayout) o0O000o0.O000000o(this.O00000oO, 2130903043, null);
        }
        ImageView imageView = (ImageView) view.findViewById(2131165202);
        ((TextView) view.findViewById(2131165201)).setText(((OfflineMapProvince) this.O00000o0.get(i)).getProvinceName());
        if (this.O000000o[i]) {
            imageView.setImageDrawable(o0O000o0.O000000o().getDrawable(2130837509));
        } else {
            imageView.setImageDrawable(o0O000o0.O000000o().getDrawable(2130837510));
        }
        return view;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    public void onGroupCollapse(int i) {
        this.O000000o[i] = false;
    }

    public void onGroupExpand(int i) {
        this.O000000o[i] = true;
    }
}
