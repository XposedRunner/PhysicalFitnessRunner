package com.baidu.mapsdkplatform.comjni.tools;

import android.os.Bundle;

public class BundleKeySet {
    public String[] getBundleKeys(Bundle bundle) {
        String[] strArr = null;
        if (bundle == null) {
            return null;
        }
        if (!bundle.isEmpty()) {
            strArr = new String[bundle.size()];
            int i = 0;
            for (Object obj : bundle.keySet()) {
                strArr[i] = obj.toString();
                i++;
            }
        }
        return strArr;
    }
}
