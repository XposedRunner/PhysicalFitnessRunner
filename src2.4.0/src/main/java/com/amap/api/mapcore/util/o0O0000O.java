package com.amap.api.mapcore.util;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AutoCompleteTextView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.amap.api.maps.offlinemap.DownLoadExpandListView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapManager.OfflineLoadedListener;
import com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.amap.api.offlineservice.O000000o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: OfflineMapPage */
public class o0O0000O extends O000000o implements TextWatcher, OnTouchListener, OnScrollListener, OfflineLoadedListener, OfflineMapDownloadListener {
    private ImageView O00000Oo;
    private DownLoadExpandListView O00000o;
    private RelativeLayout O00000o0;
    private ListView O00000oO;
    private ExpandableListView O00000oo;
    private ImageView O0000O0o;
    private ImageView O0000OOo;
    private RelativeLayout O0000Oo;
    private AutoCompleteTextView O0000Oo0;
    private RelativeLayout O0000OoO;
    private ImageView O0000Ooo;
    private OfflineMapManager O0000o = null;
    private RelativeLayout O0000o0;
    private ImageView O0000o00;
    private List<OfflineMapProvince> O0000o0O = new ArrayList();
    private o00000 O0000o0o;
    private o0000 O0000oO;
    private o000000 O0000oO0;
    private boolean O0000oOO = true;
    private boolean O0000oOo = true;
    private long O0000oo = 0;
    private int O0000oo0 = -1;
    private o000 O0000ooO;
    private boolean O0000ooo = true;

    private void O0000Oo() {
        try {
            LayoutParams layoutParams = (LayoutParams) this.O0000o00.getLayoutParams();
            layoutParams.leftMargin = O000000o(18.0f);
            this.O0000o00.setLayoutParams(layoutParams);
            this.O0000Oo0.setPadding(O000000o(30.0f), 0, 0, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void O0000OoO() {
        O0000Ooo();
        this.O0000oO = new o0000(this.O0000o0O, this.O0000o, this.O000000o);
        this.O00000oO.setAdapter(this.O0000oO);
    }

    private void O0000Ooo() {
        ArrayList offlineMapProvinceList = this.O0000o.getOfflineMapProvinceList();
        this.O0000o0O.clear();
        this.O0000o0O.add(null);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i = 0; i < offlineMapProvinceList.size(); i++) {
            OfflineMapProvince offlineMapProvince = (OfflineMapProvince) offlineMapProvinceList.get(i);
            if (offlineMapProvince.getCityList().size() != 1) {
                this.O0000o0O.add(i + 1, offlineMapProvince);
            } else {
                String provinceName = offlineMapProvince.getProvinceName();
                if (provinceName.contains("香港")) {
                    arrayList2.addAll(offlineMapProvince.getCityList());
                } else if (provinceName.contains("澳门")) {
                    arrayList2.addAll(offlineMapProvince.getCityList());
                } else if (provinceName.contains("全国概要图")) {
                    arrayList3.addAll(0, offlineMapProvince.getCityList());
                } else {
                    arrayList3.addAll(offlineMapProvince.getCityList());
                }
            }
        }
        OfflineMapProvince offlineMapProvince2 = new OfflineMapProvince();
        offlineMapProvince2.setProvinceName("基本功能包+直辖市");
        offlineMapProvince2.setCityList(arrayList3);
        this.O0000o0O.set(0, offlineMapProvince2);
        offlineMapProvince2 = new OfflineMapProvince();
        offlineMapProvince2.setProvinceName("直辖市");
        offlineMapProvince2.setCityList(arrayList);
        offlineMapProvince2 = new OfflineMapProvince();
        offlineMapProvince2.setProvinceName("港澳");
        offlineMapProvince2.setCityList(arrayList2);
        this.O0000o0O.add(offlineMapProvince2);
    }

    private void O0000o00() {
        if (this.O0000Oo0 != null && this.O0000Oo0.isFocused()) {
            this.O0000Oo0.clearFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) this.O000000o.getSystemService("input_method");
            boolean z = false;
            if (inputMethodManager != null) {
                z = inputMethodManager.isActive();
            }
            if (z) {
                inputMethodManager.hideSoftInputFromWindow(this.O0000Oo0.getWindowToken(), 2);
            }
        }
    }

    public void O000000o() {
        View O000000o = o0O000o0.O000000o(this.O000000o, 2130903040, null);
        this.O00000o = (DownLoadExpandListView) O000000o.findViewById(2131165187);
        this.O00000o.setOnTouchListener(this);
        this.O0000Oo = (RelativeLayout) O000000o.findViewById(2131165184);
        this.O0000O0o = (ImageView) O000000o.findViewById(2131165186);
        this.O0000Oo.setOnClickListener(this.O000000o);
        this.O0000OoO = (RelativeLayout) O000000o.findViewById(2131165189);
        this.O0000OOo = (ImageView) O000000o.findViewById(2131165190);
        this.O0000OoO.setOnClickListener(this.O000000o);
        this.O0000o0 = (RelativeLayout) O000000o.findViewById(2131165188);
        this.O00000Oo = (ImageView) this.O00000o0.findViewById(2131165205);
        this.O00000Oo.setOnClickListener(this.O000000o);
        this.O0000o00 = (ImageView) this.O00000o0.findViewById(2131165207);
        this.O0000Ooo = (ImageView) this.O00000o0.findViewById(2131165209);
        this.O0000Ooo.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                try {
                    o0O0000O.this.O0000Oo0.setText("");
                    o0O0000O.this.O0000Ooo.setVisibility(8);
                    o0O0000O.this.O000000o(false);
                    LayoutParams layoutParams = (LayoutParams) o0O0000O.this.O0000o00.getLayoutParams();
                    layoutParams.leftMargin = o0O0000O.this.O000000o(95.0f);
                    o0O0000O.this.O0000o00.setLayoutParams(layoutParams);
                    o0O0000O.this.O0000Oo0.setPadding(o0O0000O.this.O000000o(105.0f), 0, 0, 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.O00000o0.findViewById(2131165210).setOnTouchListener(this);
        this.O0000Oo0 = (AutoCompleteTextView) this.O00000o0.findViewById(2131165208);
        this.O0000Oo0.addTextChangedListener(this);
        this.O0000Oo0.setOnTouchListener(this);
        this.O00000oO = (ListView) this.O00000o0.findViewById(2131165212);
        this.O00000oo = (ExpandableListView) this.O00000o0.findViewById(2131165211);
        this.O00000oo.addHeaderView(O000000o);
        this.O00000oo.setOnTouchListener(this);
        this.O00000oo.setOnScrollListener(this);
        this.O0000o = new OfflineMapManager(this.O000000o, this);
        this.O0000o.setOnOfflineLoadedListener(this);
        O0000Ooo();
        this.O0000o0o = new o00000(this.O0000o0O, this.O0000o, this.O000000o);
        this.O00000oo.setAdapter(this.O0000o0o);
        this.O00000oo.setOnGroupCollapseListener(this.O0000o0o);
        this.O00000oo.setOnGroupExpandListener(this.O0000o0o);
        this.O00000oo.setGroupIndicator(null);
        if (this.O0000oOO) {
            this.O0000OOo.setBackgroundResource(2130837504);
            this.O00000oo.setVisibility(0);
        } else {
            this.O0000OOo.setBackgroundResource(2130837508);
            this.O00000oo.setVisibility(8);
        }
        if (this.O0000oOo) {
            this.O0000O0o.setBackgroundResource(2130837504);
            this.O00000o.setVisibility(0);
            return;
        }
        this.O0000O0o.setBackgroundResource(2130837508);
        this.O00000o.setVisibility(8);
    }

    public void O000000o(View view) {
        try {
            int id = view.getId();
            if (id == 2131165205) {
                this.O000000o.closeScr();
            } else if (id == 2131165184) {
                if (this.O0000oOo) {
                    this.O00000o.setVisibility(8);
                    this.O0000O0o.setBackgroundResource(2130837508);
                    this.O0000oOo = false;
                    return;
                }
                this.O00000o.setVisibility(0);
                this.O0000O0o.setBackgroundResource(2130837504);
                this.O0000oOo = true;
            } else if (id != 2131165189) {
            } else {
                if (this.O0000oOO) {
                    this.O0000o0o.O00000Oo();
                    this.O0000OOo.setBackgroundResource(2130837508);
                    this.O0000oOO = false;
                    return;
                }
                this.O0000o0o.O000000o();
                this.O0000OOo.setBackgroundResource(2130837504);
                this.O0000oOO = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void O000000o(OfflineMapCity offlineMapCity) {
        try {
            if (this.O0000ooO == null) {
                this.O0000ooO = new o000(this.O000000o, this.O0000o);
            }
            this.O0000ooO.O000000o(offlineMapCity.getState(), offlineMapCity.getCity());
            this.O0000ooO.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void O000000o(boolean z) {
        int i = 0;
        if (z) {
            this.O0000Oo.setVisibility(8);
            this.O0000OoO.setVisibility(8);
            this.O00000o.setVisibility(8);
            this.O00000oo.setVisibility(8);
            this.O0000o0.setVisibility(8);
            this.O00000oO.setVisibility(0);
            return;
        }
        this.O0000Oo.setVisibility(0);
        this.O0000OoO.setVisibility(0);
        this.O0000o0.setVisibility(0);
        this.O00000o.setVisibility(this.O0000oOo ? 0 : 8);
        ExpandableListView expandableListView = this.O00000oo;
        if (!this.O0000oOO) {
            i = 8;
        }
        expandableListView.setVisibility(i);
        this.O00000oO.setVisibility(8);
    }

    public RelativeLayout O00000Oo() {
        if (this.O00000o0 == null) {
            this.O00000o0 = (RelativeLayout) o0O000o0.O000000o(this.O000000o, 2130903044, null);
        }
        return this.O00000o0;
    }

    public void O00000o() {
        this.O0000oO0 = new o000000(this.O000000o, this, this.O0000o, this.O0000o0O);
        this.O00000o.setAdapter(this.O0000oO0);
        this.O0000oO0.notifyDataSetChanged();
    }

    public void O00000o0() {
        this.O0000o.destroy();
    }

    public boolean O00000oO() {
        try {
            if (this.O00000oO.getVisibility() == 0) {
                this.O0000Oo0.setText("");
                this.O0000Ooo.setVisibility(8);
                O000000o(false);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.O00000oO();
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onCheckUpdate(boolean z, String str) {
    }

    public void onDownload(int i, int i2, String str) {
        switch (i) {
            case -1:
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                break;
            default:
                switch (i) {
                    case 101:
                        try {
                            Toast.makeText(this.O000000o, "网络异常", 0).show();
                            this.O0000o.pause();
                            break;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                }
                break;
        }
        if (i == 2) {
            this.O0000oO0.O000000o();
        }
        if (this.O0000oo0 != i) {
            if (this.O0000o0o != null) {
                this.O0000o0o.notifyDataSetChanged();
            }
            if (this.O0000oO0 != null) {
                this.O0000oO0.notifyDataSetChanged();
            }
            if (this.O0000oO != null) {
                this.O0000oO.notifyDataSetChanged();
            }
            this.O0000oo0 = i;
        } else if (System.currentTimeMillis() - this.O0000oo > ((long) 1200)) {
            Log.i("SHIXIN", "UPDATE_DOWNLOAD_LIST");
            if (this.O0000ooo) {
                this.O0000oO0.notifyDataSetChanged();
            }
            this.O0000oo = System.currentTimeMillis();
        }
    }

    public void onRemove(boolean z, String str, String str2) {
        if (this.O0000oO0 != null) {
            this.O0000oO0.O00000Oo();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            this.O0000ooo = false;
        } else {
            this.O0000ooo = true;
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (TextUtils.isEmpty(charSequence)) {
            O000000o(false);
            this.O0000Ooo.setVisibility(8);
            return;
        }
        this.O0000Ooo.setVisibility(0);
        List arrayList = new ArrayList();
        if (this.O0000o0O != null && this.O0000o0O.size() > 0) {
            ArrayList<OfflineMapCity> arrayList2 = new ArrayList();
            for (OfflineMapProvince cityList : this.O0000o0O) {
                arrayList2.addAll(cityList.getCityList());
            }
            for (OfflineMapCity offlineMapCity : arrayList2) {
                String city = offlineMapCity.getCity();
                String pinyin = offlineMapCity.getPinyin();
                String jianpin = offlineMapCity.getJianpin();
                if (charSequence.length() == 1) {
                    if (jianpin.startsWith(String.valueOf(charSequence))) {
                        arrayList.add(offlineMapCity);
                    }
                } else if (jianpin.startsWith(String.valueOf(charSequence)) || pinyin.startsWith(String.valueOf(charSequence)) || city.startsWith(String.valueOf(charSequence))) {
                    arrayList.add(offlineMapCity);
                }
            }
        }
        if (arrayList.size() > 0) {
            O000000o(true);
            Collections.sort(arrayList, new Comparator<OfflineMapCity>() {
                /* renamed from: O000000o */
                public int compare(OfflineMapCity offlineMapCity, OfflineMapCity offlineMapCity2) {
                    char[] toCharArray = offlineMapCity.getJianpin().toCharArray();
                    char[] toCharArray2 = offlineMapCity2.getJianpin().toCharArray();
                    return (toCharArray[0] >= toCharArray2[0] && toCharArray[1] >= toCharArray2[1]) ? 0 : 1;
                }
            });
            this.O0000oO.O000000o(arrayList);
            this.O0000oO.notifyDataSetChanged();
        } else {
            Toast.makeText(this.O000000o, "未找到相关城市", 0).show();
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        O0000o00();
        if (view.getId() == 2131165208) {
            O0000Oo();
        }
        return false;
    }

    public void onVerifyComplete() {
        O0000OoO();
        O00000o();
    }
}
