package com.taobao.wireless.security.adapter.umid;

import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.umid.IUMIDComponent;
import com.alibaba.wireless.security.open.umid.a;

public class UmidAdapter {
    private static IUMIDComponent a;

    public static int umidInitAdapter(int i) {
        try {
            a = (IUMIDComponent) a.a().getInterface(IUMIDComponent.class);
            if (a != null) {
                a.initUMIDSync(i);
                return 1;
            }
        } catch (SecException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
