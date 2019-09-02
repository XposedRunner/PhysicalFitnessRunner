package com.baidu.location.a;

import com.baidu.location.g.j;
import java.io.File;

class f extends Thread {
    final /* synthetic */ d a;

    f(d dVar) {
        this.a = dVar;
    }

    public void run() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j.j());
        stringBuilder.append("/baidu/tempdata");
        this.a.a(new File(stringBuilder.toString(), "intime.dat"), "http://itsdata.map.baidu.com/long-conn-gps/sdk.php");
    }
}
