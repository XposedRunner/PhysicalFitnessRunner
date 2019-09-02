package com.amap.api.mapcore.util;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
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
import java.util.ArrayList;
import java.util.List;

/* compiled from: OfflineDownloadedAdapter */
public class o000000 extends BaseExpandableListAdapter implements OnGroupCollapseListener, OnGroupExpandListener {
    List<OfflineMapProvince> O000000o = new ArrayList();
    private boolean[] O00000Oo;
    private o0 O00000o;
    private Context O00000o0;
    private List<OfflineMapProvince> O00000oO = new ArrayList();
    private o0O0000O O00000oo;
    private OfflineMapManager O0000O0o;

    /* compiled from: OfflineDownloadedAdapter */
    public final class O000000o {
        public o0 O000000o;
    }

    public o000000(Context context, o0O0000O o0o0000o, OfflineMapManager offlineMapManager, List<OfflineMapProvince> list) {
        this.O00000o0 = context;
        this.O00000oo = o0o0000o;
        this.O0000O0o = offlineMapManager;
        if (list != null && list.size() > 0) {
            this.O00000oO.clear();
            this.O00000oO.addAll(list);
            for (OfflineMapProvince offlineMapProvince : this.O00000oO) {
                if (offlineMapProvince != null && offlineMapProvince.getDownloadedCityList().size() > 0) {
                    this.O000000o.add(offlineMapProvince);
                }
            }
        }
        this.O00000Oo = new boolean[this.O000000o.size()];
    }

    public void O000000o() {
        for (OfflineMapProvince offlineMapProvince : this.O00000oO) {
            if (offlineMapProvince.getDownloadedCityList().size() > 0 && !this.O000000o.contains(offlineMapProvince)) {
                this.O000000o.add(offlineMapProvince);
            }
        }
        this.O00000Oo = new boolean[this.O000000o.size()];
        notifyDataSetChanged();
    }

    public void O00000Oo() {
        try {
            for (int size = this.O000000o.size(); size > 0; size--) {
                OfflineMapProvince offlineMapProvince = (OfflineMapProvince) this.O000000o.get(size - 1);
                if (offlineMapProvince.getDownloadedCityList().size() == 0) {
                    this.O000000o.remove(offlineMapProvince);
                }
            }
            this.O00000Oo = new boolean[this.O000000o.size()];
            notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object getChild(int i, int i2) {
        return ((OfflineMapProvince) this.O000000o.get(i)).getDownloadedCityList().get(i2);
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
            this.O00000o = new o0(this.O00000o0, this.O0000O0o);
            this.O00000o.O000000o(2);
            view = this.O00000o.O000000o();
            o000000o.O000000o = this.O00000o;
            view.setTag(o000000o);
        }
        OfflineMapProvince offlineMapProvince = (OfflineMapProvince) this.O000000o.get(i);
        if (i2 < offlineMapProvince.getDownloadedCityList().size()) {
            final OfflineMapCity offlineMapCity = (OfflineMapCity) offlineMapProvince.getDownloadedCityList().get(i2);
            o000000o.O000000o.O000000o(offlineMapCity);
            view.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    o000000.this.O00000oo.O000000o(offlineMapCity);
                }
            });
        }
        return view;
    }

    public int getChildrenCount(int i) {
        return ((OfflineMapProvince) this.O000000o.get(i)).getDownloadedCityList().size();
    }

    public Object getGroup(int i) {
        return ((OfflineMapProvince) this.O000000o.get(i)).getProvinceName();
    }

    public int getGroupCount() {
        return this.O000000o.size();
    }

    public long getGroupId(int i) {
        return (long) i;
    }

    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = (RelativeLayout) o0O000o0.O000000o(this.O00000o0, 2130903043, null);
        }
        ImageView imageView = (ImageView) view.findViewById(2131165202);
        ((TextView) view.findViewById(2131165201)).setText(((OfflineMapProvince) this.O000000o.get(i)).getProvinceName());
        if (this.O00000Oo[i]) {
            imageView.setImageDrawable(o0O000o0.O000000o().getDrawable(2130837509));
        } else {
            imageView.setImageDrawable(o0O000o0.O000000o().getDrawable(2130837510));
        }
        return view;
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    public void onGroupCollapse(int i) {
        this.O00000Oo[i] = false;
    }

    public void onGroupExpand(int i) {
        this.O00000Oo[i] = true;
    }
}
