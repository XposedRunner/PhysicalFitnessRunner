package com.amap.api.mapcore.util;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapActivity;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SearchListAdapter */
public class o0000 extends BaseAdapter {
    private List<OfflineMapCity> O000000o = new ArrayList();
    private OfflineMapManager O00000Oo;
    private Activity O00000o0;

    /* compiled from: SearchListAdapter */
    public final class O000000o {
        public TextView O000000o;
        public TextView O00000Oo;
        public ImageView O00000o;
        public TextView O00000o0;
    }

    public o0000(List<OfflineMapProvince> list, OfflineMapManager offlineMapManager, OfflineMapActivity offlineMapActivity) {
        this.O00000Oo = offlineMapManager;
        this.O00000o0 = offlineMapActivity;
    }

    public void O000000o(List<OfflineMapCity> list) {
        this.O000000o = list;
    }

    public int getCount() {
        return this.O000000o.size();
    }

    public Object getItem(int i) {
        return this.O000000o.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception e;
        try {
            O000000o o000000o;
            final OfflineMapCity offlineMapCity = (OfflineMapCity) this.O000000o.get(i);
            if (view == null) {
                o000000o = new O000000o();
                View O000000o = o0O000o0.O000000o(this.O00000o0, 2130903042, null);
                try {
                    o000000o.O000000o = (TextView) O000000o.findViewById(2131165195);
                    o000000o.O00000Oo = (TextView) O000000o.findViewById(2131165199);
                    o000000o.O00000o0 = (TextView) O000000o.findViewById(2131165197);
                    o000000o.O00000o = (ImageView) O000000o.findViewById(2131165198);
                    O000000o.setTag(o000000o);
                    view = O000000o;
                } catch (Exception e2) {
                    e = e2;
                    view = O000000o;
                    e.printStackTrace();
                    return view;
                }
            }
            o000000o = (O000000o) view.getTag();
            o000000o.O00000o.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    o000000o.O00000o.setVisibility(8);
                    o000000o.O00000o0.setVisibility(0);
                    o000000o.O00000o0.setText("下载中");
                    try {
                        o0000.this.O00000Oo.downloadByCityName(offlineMapCity.getCity());
                    } catch (AMapException e) {
                        e.printStackTrace();
                    }
                }
            });
            o000000o.O00000o0.setVisibility(0);
            o000000o.O000000o.setText(offlineMapCity.getCity());
            double size = ((double) ((int) (((((double) offlineMapCity.getSize()) / 1024.0d) / 1024.0d) * 100.0d))) / 100.0d;
            TextView textView = o000000o.O00000Oo;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.valueOf(size));
            stringBuilder.append(" M");
            textView.setText(stringBuilder.toString());
            i = offlineMapCity.getState();
            if (i != 6) {
                switch (i) {
                    case -1:
                        o000000o.O00000o.setVisibility(8);
                        o000000o.O00000o0.setText("下载失败");
                        break;
                    case 0:
                    case 1:
                        o000000o.O00000o.setVisibility(8);
                        o000000o.O00000o0.setText("下载中");
                        break;
                    case 2:
                        o000000o.O00000o.setVisibility(8);
                        o000000o.O00000o0.setText("等待下载");
                        break;
                    case 3:
                        o000000o.O00000o.setVisibility(8);
                        o000000o.O00000o0.setText("暂停中");
                        break;
                    case 4:
                        o000000o.O00000o.setVisibility(8);
                        o000000o.O00000o0.setText("已下载");
                        break;
                    default:
                        switch (i) {
                            case 101:
                            case 102:
                            case 103:
                                break;
                            default:
                                break;
                        }
                        o000000o.O00000o.setVisibility(8);
                        o000000o.O00000o0.setText("下载失败");
                        break;
                }
            }
            o000000o.O00000o.setVisibility(0);
            o000000o.O00000o0.setVisibility(8);
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return view;
        }
        return view;
    }
}
