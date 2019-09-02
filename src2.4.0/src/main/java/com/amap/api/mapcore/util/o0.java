package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.design.R;
import android.support.v4.internal.view.SupportMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.DownloadProgressView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;

/* compiled from: OfflineChild */
public class o0 implements OnClickListener {
    private int O000000o = 0;
    private Context O00000Oo;
    private TextView O00000o;
    private TextView O00000o0;
    private ImageView O00000oO;
    private TextView O00000oo;
    private OfflineMapManager O0000O0o;
    private OfflineMapCity O0000OOo;
    private Handler O0000Oo = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                o0.this.O000000o(message.arg1, message.arg2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private boolean O0000Oo0 = false;
    private View O0000OoO;
    private DownloadProgressView O0000Ooo;

    public o0(Context context, OfflineMapManager offlineMapManager) {
        this.O00000Oo = context;
        O00000Oo();
        this.O0000O0o = offlineMapManager;
    }

    private void O000000o(int i, int i2) throws Exception {
        if (this.O000000o != 2 || i2 <= 3 || i2 >= 100) {
            this.O0000Ooo.setVisibility(8);
        } else {
            this.O0000Ooo.setVisibility(0);
            this.O0000Ooo.setProgress(i2);
        }
        switch (i) {
            case -1:
                O00000oO();
                return;
            case 0:
                if (this.O000000o == 1) {
                    this.O00000oO.setVisibility(8);
                    this.O00000oo.setText("下载中");
                    this.O00000oo.setTextColor(Color.parseColor("#4287ff"));
                    return;
                }
                O00000oO(i2);
                return;
            case 1:
                O00000o(i2);
                return;
            case 2:
                O00000Oo(i2);
                return;
            case 3:
                O00000o0(i2);
                return;
            case 4:
                O00000oo();
                return;
            case 5:
                return;
            case 6:
                O00000o0();
                return;
            case 7:
                O00000o();
                return;
            default:
                switch (i) {
                    case 101:
                    case 102:
                    case 103:
                        O00000oO();
                        return;
                    default:
                        return;
                }
        }
    }

    private void O000000o(int i, int i2, boolean z) {
        if (this.O0000OOo != null) {
            this.O0000OOo.setState(i);
            this.O0000OOo.setCompleteCode(i2);
        }
        Message message = new Message();
        message.arg1 = i;
        message.arg2 = i2;
        this.O0000Oo.sendMessage(message);
    }

    private void O00000Oo() {
        this.O0000OoO = o0O000o0.O000000o(this.O00000Oo, 2130903042, null);
        this.O0000Ooo = (DownloadProgressView) this.O0000OoO.findViewById(2131165200);
        this.O00000o0 = (TextView) this.O0000OoO.findViewById(2131165195);
        this.O00000o = (TextView) this.O0000OoO.findViewById(2131165199);
        this.O00000oO = (ImageView) this.O0000OoO.findViewById(2131165198);
        this.O00000oo = (TextView) this.O0000OoO.findViewById(2131165197);
        this.O00000oO.setOnClickListener(this);
    }

    private void O00000Oo(int i) {
        if (this.O000000o == 1) {
            this.O00000oO.setVisibility(8);
            this.O00000oo.setVisibility(0);
            this.O00000oo.setText("等待中");
            this.O00000oo.setTextColor(Color.parseColor("#4287ff"));
            return;
        }
        this.O00000oo.setVisibility(0);
        this.O00000oO.setVisibility(8);
        this.O00000oo.setTextColor(Color.parseColor("#4287ff"));
        this.O00000oo.setText("等待中");
    }

    private void O00000o() {
        this.O00000oo.setVisibility(0);
        this.O00000oO.setVisibility(0);
        this.O00000oO.setImageResource(R.animator.design_appbar_state_list_animator);
        this.O00000oo.setText("已下载-有更新");
    }

    private void O00000o(int i) {
        if (this.O000000o != 1) {
            this.O00000oo.setVisibility(0);
            this.O00000oO.setVisibility(8);
            this.O00000oo.setText("解压中");
            this.O00000oo.setTextColor(Color.parseColor("#898989"));
        }
    }

    private void O00000o0() {
        this.O00000oo.setVisibility(8);
        this.O00000oO.setVisibility(0);
        this.O00000oO.setImageResource(R.animator.design_appbar_state_list_animator);
    }

    private void O00000o0(int i) {
        this.O00000oo.setVisibility(0);
        this.O00000oO.setVisibility(8);
        this.O00000oo.setTextColor(-7829368);
        this.O00000oo.setText("暂停");
    }

    private void O00000oO() {
        this.O00000oo.setVisibility(0);
        this.O00000oO.setVisibility(8);
        this.O00000oo.setTextColor(SupportMenu.CATEGORY_MASK);
        this.O00000oo.setText("下载出现异常");
    }

    private void O00000oO(int i) {
        if (this.O0000OOo != null) {
            this.O00000oo.setVisibility(0);
            this.O00000oo.setText("下载中");
            this.O00000oO.setVisibility(8);
            this.O00000oo.setTextColor(Color.parseColor("#4287ff"));
        }
    }

    private void O00000oo() {
        this.O00000oo.setVisibility(0);
        this.O00000oO.setVisibility(8);
        this.O00000oo.setText("已下载");
        this.O00000oo.setTextColor(Color.parseColor("#898989"));
    }

    private synchronized void O0000O0o() {
        this.O0000O0o.pause();
        this.O0000O0o.restart();
    }

    private synchronized boolean O0000OOo() {
        try {
            this.O0000O0o.downloadByCityName(this.O0000OOo.getCity());
        } catch (AMapException e) {
            e.printStackTrace();
            Toast.makeText(this.O00000Oo, e.getErrorMessage(), 0).show();
            return false;
        }
        return true;
    }

    public View O000000o() {
        return this.O0000OoO;
    }

    public void O000000o(int i) {
        this.O000000o = i;
    }

    public void O000000o(OfflineMapCity offlineMapCity) {
        if (offlineMapCity != null) {
            this.O0000OOo = offlineMapCity;
            this.O00000o0.setText(offlineMapCity.getCity());
            double size = ((double) ((int) (((((double) offlineMapCity.getSize()) / 1024.0d) / 1024.0d) * 100.0d))) / 100.0d;
            TextView textView = this.O00000o;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.valueOf(size));
            stringBuilder.append(" M");
            textView.setText(stringBuilder.toString());
            O000000o(this.O0000OOo.getState(), this.O0000OOo.getcompleteCode(), this.O0000Oo0);
        }
    }

    public void onClick(View view) {
        try {
            if (OOo000.O00000o(this.O00000Oo)) {
                if (this.O0000OOo != null) {
                    int state = this.O0000OOo.getState();
                    int i = this.O0000OOo.getcompleteCode();
                    if (state != 4) {
                        switch (state) {
                            case 0:
                                O0000O0o();
                                O00000o0(i);
                                break;
                            case 1:
                                break;
                            default:
                                if (!O0000OOo()) {
                                    O00000oO();
                                    break;
                                } else {
                                    O00000Oo(i);
                                    break;
                                }
                        }
                    }
                }
                return;
            }
            Toast.makeText(this.O00000Oo, "无网络连接", 0).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
