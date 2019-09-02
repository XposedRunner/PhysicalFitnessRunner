package com.baidu.location.indoor;

import android.location.Location;
import java.util.ArrayList;
import java.util.List;

public class m {
    private List<Location> a;
    private String b;
    private Location c = null;

    m(String str, Location[] locationArr) {
        if (locationArr != null && locationArr.length > 0) {
            a(locationArr);
            this.b = str;
        }
    }

    private void a(Location[] locationArr) {
        if (locationArr != null && locationArr.length > 0) {
            if (this.a == null) {
                this.a = new ArrayList();
            }
            double d = 0.0d;
            double d2 = 0.0d;
            for (int i = 0; i < locationArr.length; i++) {
                d += locationArr[i].getLatitude();
                d2 += locationArr[i].getLongitude();
                this.a.add(locationArr[i]);
            }
            if (this.c == null) {
                this.c = new Location("gps");
                this.c.setLatitude(d / ((double) locationArr.length));
                this.c.setLongitude(d2 / ((double) locationArr.length));
            }
        }
    }

    public String a() {
        return this.b;
    }
}
