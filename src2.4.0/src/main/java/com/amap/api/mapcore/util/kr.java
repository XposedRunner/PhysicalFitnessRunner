package com.amap.api.mapcore.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SoInfoEntity */
public final class kr implements Parcelable {
    List<y> O000000o = new ArrayList();
    private String O00000Oo;
    private String O00000o;
    private String O00000o0;

    static {
        AnonymousClass1 anonymousClass1 = new Creator() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return kr.O00000Oo(parcel.readString());
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new kr[i];
            }
        };
    }

    public kr(String str, String str2, String str3, String str4) {
        this.O00000Oo = str;
        this.O00000o0 = str2;
        this.O00000o = str3;
        this.O000000o = O000000o(str, str4);
    }

    private kr(String str, String str2, String str3, List<y> list) {
        this.O00000Oo = str;
        this.O00000o0 = str2;
        this.O00000o = str3;
        this.O000000o = list;
    }

    private List<y> O000000o(String str, String str2) {
        try {
            JSONArray jSONArray = new JSONArray(str2);
            str2 = UUID.randomUUID().toString();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    y O00000o0 = y.O00000o0(jSONArray.getString(i));
                    O00000o0.O000000o(str2);
                    O00000o0.O00000Oo(str);
                    arrayList.add(O00000o0);
                } catch (JSONException unused) {
                }
            }
            return arrayList;
        } catch (JSONException unused2) {
            return new ArrayList();
        }
    }

    public static boolean O000000o(kr krVar) {
        return (krVar == null || TextUtils.isEmpty(krVar.O00000Oo) || !ar.O000000o(krVar.O00000o) || !ar.O000000o(krVar.O00000o0) || krVar.O00000Oo() == null || krVar.O00000Oo().size() == 0) ? false : true;
    }

    public static kr O00000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return new kr();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new kr(jSONObject.optString("ak", ""), jSONObject.optString("bk", ""), jSONObject.optString("ik", ""), y.O00000o(jSONObject.optString("jk", "")));
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("SoFile#fromJson json ex ");
            stringBuilder.append(th);
            t.O000000o(stringBuilder.toString());
            return new kr();
        }
    }

    public final y O000000o(String str) {
        if (this.O000000o == null || TextUtils.isEmpty(str)) {
            return null;
        }
        for (y yVar : this.O000000o) {
            if (yVar.O000000o().equals(str)) {
                return yVar;
            }
        }
        return null;
    }

    public final String O000000o() {
        return this.O00000o0;
    }

    public final boolean O000000o(x xVar) {
        if (xVar == null || this.O000000o == null) {
            return false;
        }
        for (y yVar : this.O000000o) {
            String O000000o = yVar.O000000o();
            String str = yVar.O000000o;
            if (TextUtils.isEmpty(O000000o) || TextUtils.isEmpty(str)) {
                return false;
            }
            if (!t.O00000o(str, xVar.O00000o0(O000000o))) {
                return false;
            }
        }
        return true;
    }

    public final List<y> O00000Oo() {
        if (this.O000000o == null) {
            this.O000000o = new ArrayList();
        }
        return this.O000000o;
    }

    public final boolean O00000Oo(x xVar) {
        if (xVar == null) {
            return false;
        }
        if (this.O000000o == null || this.O000000o.size() == 0) {
            return true;
        }
        int i = 0;
        while (i < this.O000000o.size() && i < 20) {
            y yVar = (y) this.O000000o.get(i);
            try {
                String O00000Oo = xVar.O00000Oo(yVar.O000000o());
                if (!t.O0000O0o(O00000Oo) || !t.O00000o(yVar.O000000o, O00000Oo)) {
                    return false;
                }
                i++;
            } catch (Throwable unused) {
                return false;
            }
        }
        return true;
    }

    public final String O00000o0() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ak", this.O00000Oo);
            jSONObject.put("bk", this.O00000o0);
            jSONObject.put("ik", this.O00000o);
            jSONObject.put("jk", y.O000000o(this.O000000o));
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(O00000o0());
    }
}
