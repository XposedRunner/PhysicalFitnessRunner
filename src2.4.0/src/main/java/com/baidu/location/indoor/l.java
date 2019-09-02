package com.baidu.location.indoor;

import com.baidu.location.indoor.d.b;

class l implements b {
    final /* synthetic */ i a;

    l(i iVar) {
        this.a = iVar;
    }

    public void a(boolean z, String str, String str2, String str3) {
        if (z) {
            g gVar = g.this;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("&ibuuid=");
            stringBuilder.append(str);
            stringBuilder.append("&ibname=");
            stringBuilder.append(str2);
            stringBuilder.append("&ibfls=");
            stringBuilder.append(str3);
            gVar.R = stringBuilder.toString();
        }
    }
}
