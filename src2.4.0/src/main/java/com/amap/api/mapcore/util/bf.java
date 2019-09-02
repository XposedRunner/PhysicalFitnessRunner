package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.amap.api.mapcore.util.O00OoOO0.O000000o;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import java.io.File;

/* compiled from: CityObject */
public class bf extends OfflineMapCity implements O00OOo0, O0O00oO {
    public static final Creator<bf> O0000o0O = new Creator<bf>() {
        /* renamed from: O000000o */
        public bf createFromParcel(Parcel parcel) {
            return new bf(parcel);
        }

        /* renamed from: O000000o */
        public bf[] newArray(int i) {
            return new bf[i];
        }
    };
    public final O0O0O0o O000000o;
    public final O0O0O0o O00000Oo;
    public final O0O0O0o O00000o;
    public final O0O0O0o O00000o0;
    public final O0O0O0o O00000oO;
    public final O0O0O0o O00000oo;
    public final O0O0O0o O0000O0o;
    public final O0O0O0o O0000OOo;
    public final O0O0O0o O0000Oo;
    public final O0O0O0o O0000Oo0;
    public final O0O0O0o O0000OoO;
    O0O0O0o O0000Ooo;
    private String O0000o;
    boolean O0000o0;
    Context O0000o00;
    private String O0000o0o;
    private long O0000oO0;

    public bf(Context context, int i) {
        this.O000000o = new O0O0OO0(6, this);
        this.O00000Oo = new O0OO0O(2, this);
        this.O00000o0 = new O0O0o00(0, this);
        this.O00000o = new O0OoOo(3, this);
        this.O00000oO = new O0OO00O(1, this);
        this.O00000oo = new O0O0O(4, this);
        this.O0000O0o = new O0O0o0(7, this);
        this.O0000OOo = new O0O0OO(-1, this);
        this.O0000Oo0 = new O0O0OO(101, this);
        this.O0000Oo = new O0O0OO(102, this);
        this.O0000OoO = new O0O0OO(103, this);
        this.O0000o0o = null;
        this.O0000o = "";
        this.O0000o0 = false;
        this.O0000oO0 = 0;
        this.O0000o00 = context;
        O000000o(i);
    }

    public bf(Context context, OfflineMapCity offlineMapCity) {
        this(context, offlineMapCity.getState());
        setCity(offlineMapCity.getCity());
        setUrl(offlineMapCity.getUrl());
        setState(offlineMapCity.getState());
        setCompleteCode(offlineMapCity.getcompleteCode());
        setAdcode(offlineMapCity.getAdcode());
        setVersion(offlineMapCity.getVersion());
        setSize(offlineMapCity.getSize());
        setCode(offlineMapCity.getCode());
        setJianpin(offlineMapCity.getJianpin());
        setPinyin(offlineMapCity.getPinyin());
        O0000oOO();
    }

    public bf(Parcel parcel) {
        super(parcel);
        this.O000000o = new O0O0OO0(6, this);
        this.O00000Oo = new O0OO0O(2, this);
        this.O00000o0 = new O0O0o00(0, this);
        this.O00000o = new O0OoOo(3, this);
        this.O00000oO = new O0OO00O(1, this);
        this.O00000oo = new O0O0O(4, this);
        this.O0000O0o = new O0O0o0(7, this);
        this.O0000OOo = new O0O0OO(-1, this);
        this.O0000Oo0 = new O0O0OO(101, this);
        this.O0000Oo = new O0O0OO(102, this);
        this.O0000OoO = new O0O0OO(103, this);
        this.O0000o0o = null;
        this.O0000o = "";
        this.O0000o0 = false;
        this.O0000oO0 = 0;
        this.O0000o = parcel.readString();
    }

    private void O000000o(final File file, File file2, final String str) {
        new O00OoOO0().O000000o(file, file2, -1, O00o.O000000o(file), new O000000o() {
            public void O000000o(String str, String str2) {
            }

            public void O000000o(String str, String str2, float f) {
                int i = (int) (60.0d + (((double) f) * 0.39d));
                if (i - bf.this.getcompleteCode() > 0 && System.currentTimeMillis() - bf.this.O0000oO0 > 1000) {
                    bf.this.setCompleteCode(i);
                    bf.this.O0000oO0 = System.currentTimeMillis();
                }
            }

            public void O000000o(String str, String str2, int i) {
                bf.this.O0000Ooo.O000000o(bf.this.O0000OoO.O00000Oo());
            }

            public void O00000Oo(String str, String str2) {
                try {
                    if (new File(str).delete()) {
                        O00o.O00000Oo(file);
                        bf.this.setCompleteCode(100);
                        bf.this.O0000Ooo.O0000O0o();
                    }
                } catch (Exception unused) {
                    bf.this.O0000Ooo.O000000o(bf.this.O0000OoO.O00000Oo());
                }
            }
        });
    }

    public String O000000o() {
        return this.O0000o;
    }

    public void O000000o(int i) {
        switch (i) {
            case -1:
                this.O0000Ooo = this.O0000OOo;
                break;
            case 0:
                this.O0000Ooo = this.O00000o0;
                break;
            case 1:
                this.O0000Ooo = this.O00000oO;
                break;
            case 2:
                this.O0000Ooo = this.O00000Oo;
                break;
            case 3:
                this.O0000Ooo = this.O00000o;
                break;
            case 4:
                this.O0000Ooo = this.O00000oo;
                break;
            default:
                switch (i) {
                    case 6:
                        this.O0000Ooo = this.O000000o;
                        break;
                    case 7:
                        this.O0000Ooo = this.O0000O0o;
                        break;
                    default:
                        switch (i) {
                            case 101:
                                this.O0000Ooo = this.O0000Oo0;
                                break;
                            case 102:
                                this.O0000Ooo = this.O0000Oo;
                                break;
                            case 103:
                                this.O0000Ooo = this.O0000OoO;
                                break;
                            default:
                                if (i < 0) {
                                    this.O0000Ooo = this.O0000OOo;
                                    break;
                                }
                                break;
                        }
                }
        }
        setState(i);
    }

    public void O000000o(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.O0000oO0 > 500) {
            int i = (int) j;
            if (i > getcompleteCode()) {
                setCompleteCode(i);
                O00000o();
            }
            this.O0000oO0 = currentTimeMillis;
        }
    }

    public void O000000o(long j, long j2) {
        int i = (int) ((j2 * 100) / j);
        if (i != getcompleteCode()) {
            setCompleteCode(i);
            O00000o();
        }
    }

    public void O000000o(O0O000o.O000000o o000000o) {
        int O00000Oo;
        switch (o000000o) {
            case amap_exception:
                O00000Oo = this.O0000Oo.O00000Oo();
                break;
            case file_io_exception:
                O00000Oo = this.O0000OoO.O00000Oo();
                break;
            case network_exception:
                O00000Oo = this.O0000Oo0.O00000Oo();
                break;
            default:
                O00000Oo = 6;
                break;
        }
        if (this.O0000Ooo.equals(this.O00000o0) || this.O0000Ooo.equals(this.O00000Oo)) {
            this.O0000Ooo.O000000o(O00000Oo);
        }
    }

    public void O000000o(O0O0O0o o0O0O0o) {
        this.O0000Ooo = o0O0O0o;
        setState(o0O0O0o.O00000Oo());
    }

    public void O000000o(String str) {
        this.O0000o = str;
    }

    public O0O0O0o O00000Oo(int i) {
        switch (i) {
            case 101:
                return this.O0000Oo0;
            case 102:
                return this.O0000Oo;
            case 103:
                return this.O0000OoO;
            default:
                return this.O0000OOo;
        }
    }

    public String O00000Oo() {
        return getUrl();
    }

    public void O00000Oo(String str) {
        this.O0000Ooo.equals(this.O00000oO);
        this.O0000o = str;
        str = O0000oOo();
        String O0000oo0 = O0000oo0();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(O0000oo0)) {
            O0000oO0();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(O0000oo0);
        stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
        File file = new File(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(OOo000.O000000o(this.O0000o00));
        stringBuilder.append(File.separator);
        stringBuilder.append("map/");
        File file2 = new File(stringBuilder.toString());
        File file3 = new File(OOo000.O000000o(this.O0000o00));
        if (!file3.exists() && !file3.mkdir()) {
            return;
        }
        if (file2.exists() || file2.mkdir()) {
            O000000o(file, file2, str);
        }
    }

    public void O00000o() {
        O00O0O0o O000000o = O00O0O0o.O000000o(this.O0000o00);
        if (O000000o != null) {
            O000000o.O00000o0(this);
        }
    }

    public O0O0O0o O00000o0() {
        return this.O0000Ooo;
    }

    public void O00000oO() {
        O00O0O0o O000000o = O00O0O0o.O000000o(this.O0000o00);
        if (O000000o != null) {
            O000000o.O00000oO(this);
            O00000o();
        }
    }

    public void O00000oo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CityOperation current State==>");
        stringBuilder.append(O00000o0().O00000Oo());
        O00o.O000000o(stringBuilder.toString());
        if (this.O0000Ooo.equals(this.O00000o)) {
            this.O0000Ooo.O00000o();
        } else if (this.O0000Ooo.equals(this.O00000o0)) {
            this.O0000Ooo.O00000oO();
        } else if (this.O0000Ooo.equals(this.O0000O0o) || this.O0000Ooo.equals(this.O0000OOo)) {
            O0000OoO();
            this.O0000o0 = true;
        } else if (this.O0000Ooo.equals(this.O0000Oo) || this.O0000Ooo.equals(this.O0000Oo0) || this.O0000Ooo.O000000o(this.O0000OoO)) {
            this.O0000Ooo.O00000o0();
        } else {
            O00000o0().O0000OOo();
        }
    }

    public void O0000O0o() {
        this.O0000Ooo.O00000oO();
    }

    public void O0000OOo() {
        this.O0000Ooo.O000000o(this.O0000OoO.O00000Oo());
    }

    public void O0000Oo() {
        this.O0000Ooo.equals(this.O00000oo);
        this.O0000Ooo.O00000oo();
    }

    public void O0000Oo0() {
        this.O0000Ooo.O000000o();
        if (this.O0000o0) {
            this.O0000Ooo.O0000OOo();
        }
        this.O0000o0 = false;
    }

    public void O0000OoO() {
        O00O0O0o O000000o = O00O0O0o.O000000o(this.O0000o00);
        if (O000000o != null) {
            O000000o.O000000o(this);
        }
    }

    public void O0000Ooo() {
        O00O0O0o O000000o = O00O0O0o.O000000o(this.O0000o00);
        if (O000000o != null) {
            O000000o.O00000Oo(this);
        }
    }

    public void O0000o() {
        this.O0000oO0 = 0;
        setCompleteCode(0);
        this.O0000Ooo.equals(this.O00000oO);
        this.O0000Ooo.O00000o0();
    }

    public void O0000o0() {
        this.O0000oO0 = 0;
        if (!this.O0000Ooo.equals(this.O00000Oo)) {
            O00o.O000000o("state must be waiting when download onStart");
        }
        this.O0000Ooo.O00000o0();
    }

    public void O0000o00() {
        O00O0O0o O000000o = O00O0O0o.O000000o(this.O0000o00);
        if (O000000o != null) {
            O000000o.O00000o(this);
        }
    }

    public void O0000o0O() {
        if (!this.O0000Ooo.equals(this.O00000o0)) {
            O00o.O000000o("state must be Loading when download onFinish");
        }
        this.O0000Ooo.O0000O0o();
    }

    public void O0000o0o() {
        O00000oO();
    }

    public void O0000oO() {
        O00000oO();
    }

    public void O0000oO0() {
        this.O0000Ooo.equals(this.O00000oO);
        this.O0000Ooo.O000000o(this.O0000OOo.O00000Oo());
    }

    /* Access modifiers changed, original: protected */
    public void O0000oOO() {
        String str = O00O0O0o.O000000o;
        String O00000o0 = O00o.O00000o0(getUrl());
        if (O00000o0 != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(O00000o0);
            stringBuilder.append(".zip");
            stringBuilder.append(".tmp");
            this.O0000o0o = stringBuilder.toString();
            return;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(getPinyin());
        stringBuilder2.append(".zip");
        stringBuilder2.append(".tmp");
        this.O0000o0o = stringBuilder2.toString();
    }

    public String O0000oOo() {
        return TextUtils.isEmpty(this.O0000o0o) ? null : this.O0000o0o.substring(0, this.O0000o0o.lastIndexOf("."));
    }

    public boolean O0000oo() {
        return ((double) O00o.O000000o()) < (((double) getSize()) * 2.5d) - ((double) (((long) getcompleteCode()) * getSize())) ? false : false;
    }

    public String O0000oo0() {
        if (TextUtils.isEmpty(this.O0000o0o)) {
            return null;
        }
        String O0000oOo = O0000oOo();
        return O0000oOo.substring(0, O0000oOo.lastIndexOf(46));
    }

    public O00Oo00 O0000ooO() {
        setState(this.O0000Ooo.O00000Oo());
        O00Oo00 o00Oo00 = new O00Oo00((OfflineMapCity) this, this.O0000o00);
        o00Oo00.O000000o(O000000o());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("vMapFileNames: ");
        stringBuilder.append(O000000o());
        O00o.O000000o(stringBuilder.toString());
        return o00Oo00;
    }

    public boolean O0000ooo() {
        return O0000oo();
    }

    public String O000O00o() {
        return O0000oOo();
    }

    public String O000O0OO() {
        return O0000oo0();
    }

    public String O00oOooO() {
        StringBuffer stringBuffer = new StringBuffer();
        String O00000o0 = O00o.O00000o0(getUrl());
        if (O00000o0 != null) {
            stringBuffer.append(O00000o0);
        } else {
            stringBuffer.append(getPinyin());
        }
        stringBuffer.append(".zip");
        return stringBuffer.toString();
    }

    public String O00oOooo() {
        return getAdcode();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.O0000o);
    }
}
