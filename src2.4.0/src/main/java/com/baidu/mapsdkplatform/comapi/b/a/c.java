package com.baidu.mapsdkplatform.comapi.b.a;

import java.io.File;
import java.util.Comparator;

public class c implements Comparator {
    public int compare(Object obj, Object obj2) {
        return ((File) obj2).getName().split("_")[2].compareTo(((File) obj).getName().split("_")[2]);
    }
}
