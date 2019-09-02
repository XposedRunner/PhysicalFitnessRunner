package cn.jpush.android.data;

import android.text.TextUtils;
import java.io.Serializable;

public final class c implements Serializable {
    public String a;
    public String b;

    public c(b bVar) {
        this.a = bVar.c;
        this.b = bVar.d;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(cVar.a) || !TextUtils.equals(this.a, cVar.a)) ? false : (TextUtils.isEmpty(this.b) && TextUtils.isEmpty(cVar.b)) ? true : (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(cVar.b) || !TextUtils.equals(this.b, cVar.b)) ? false : true;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("msg_id = ");
        stringBuilder.append(this.a);
        stringBuilder.append(",  override_msg_id = ");
        stringBuilder.append(this.b);
        return stringBuilder.toString();
    }
}
