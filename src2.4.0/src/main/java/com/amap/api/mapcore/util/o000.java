package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.amap.api.maps.offlinemap.OfflineMapManager;

/* compiled from: BottomDialog */
public class o000 extends o00 implements OnClickListener {
    private OfflineMapManager O000000o;
    private View O00000Oo;
    private TextView O00000o;
    private TextView O00000o0;
    private TextView O00000oO;
    private TextView O00000oo;
    private int O0000O0o;
    private String O0000OOo;

    public o000(Context context, OfflineMapManager offlineMapManager) {
        super(context);
        this.O000000o = offlineMapManager;
    }

    /* Access modifiers changed, original: protected */
    public void O000000o() {
        this.O00000Oo = o0O000o0.O000000o(getContext(), 2130903041, null);
        setContentView(this.O00000Oo);
        this.O00000Oo.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                o000.this.dismiss();
            }
        });
        this.O00000o0 = (TextView) this.O00000Oo.findViewById(2131165191);
        this.O00000o = (TextView) this.O00000Oo.findViewById(2131165192);
        this.O00000o.setText("暂停下载");
        this.O00000oO = (TextView) this.O00000Oo.findViewById(2131165193);
        this.O00000oo = (TextView) this.O00000Oo.findViewById(2131165194);
        this.O00000o.setOnClickListener(this);
        this.O00000oO.setOnClickListener(this);
        this.O00000oo.setOnClickListener(this);
    }

    public void O000000o(int i, String str) {
        this.O00000o0.setText(str);
        if (i == 0) {
            this.O00000o.setText("暂停下载");
            this.O00000o.setVisibility(0);
            this.O00000oO.setText("取消下载");
        }
        if (i == 2) {
            this.O00000o.setVisibility(8);
            this.O00000oO.setText("取消下载");
        } else if (i == -1 || i == 101 || i == 102 || i == 103) {
            this.O00000o.setText("继续下载");
            this.O00000o.setVisibility(0);
        } else if (i == 3) {
            this.O00000o.setVisibility(0);
            this.O00000o.setText("继续下载");
            this.O00000oO.setText("取消下载");
        } else if (i == 4) {
            this.O00000oO.setText("删除");
            this.O00000o.setVisibility(8);
        }
        this.O0000O0o = i;
        this.O0000OOo = str;
    }

    public void onClick(View view) {
        try {
            int id = view.getId();
            if (id == 2131165192) {
                if (this.O0000O0o == 0) {
                    this.O00000o.setText("继续下载");
                    this.O000000o.pause();
                } else if (this.O0000O0o == 3 || this.O0000O0o == -1 || this.O0000O0o == 101 || this.O0000O0o == 102 || this.O0000O0o == 103) {
                    this.O00000o.setText("暂停下载");
                    this.O000000o.downloadByCityName(this.O0000OOo);
                }
                dismiss();
            } else if (id == 2131165193) {
                if (!TextUtils.isEmpty(this.O0000OOo)) {
                    this.O000000o.remove(this.O0000OOo);
                    dismiss();
                }
            } else if (id == 2131165194) {
                dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
