package com.ximalaya.ting.android.opensdk.model.xdcs;

import java.util.ArrayList;
import java.util.List;

public class XdcsRecord {
    public List<XdcsEvent> events = new ArrayList();
    public String nonce;
    public long sendTime;
    public String signature;

    public static XdcsRecord createXdcsRecord(List<XdcsEvent> list) {
        XdcsRecord xdcsRecord = new XdcsRecord();
        if (list != null) {
            xdcsRecord.events = new ArrayList(list);
        }
        xdcsRecord.sendTime = System.currentTimeMillis();
        return xdcsRecord;
    }
}
