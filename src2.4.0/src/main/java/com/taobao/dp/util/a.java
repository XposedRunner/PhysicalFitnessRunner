package com.taobao.dp.util;

import com.alibaba.wireless.security.open.umid.IUMIDInitListenerEx;
import java.util.ArrayList;

public class a {
    private Object a = new Object();
    private ArrayList<IUMIDInitListenerEx> b = new ArrayList();
    private ArrayList<IUMIDInitListenerEx> c = new ArrayList();
    private ArrayList<IUMIDInitListenerEx> d = new ArrayList();

    public ArrayList<IUMIDInitListenerEx> a(int i) {
        ArrayList<IUMIDInitListenerEx> arrayList;
        synchronized (this.a) {
            switch (i) {
                case 0:
                    arrayList = this.b;
                    this.b = new ArrayList();
                    break;
                case 1:
                    arrayList = this.c;
                    this.c = new ArrayList();
                    break;
                case 2:
                    arrayList = this.d;
                    this.d = new ArrayList();
                    break;
                default:
                    arrayList = null;
                    break;
            }
        }
        return arrayList;
    }

    public void a(int i, IUMIDInitListenerEx iUMIDInitListenerEx) {
        synchronized (this.a) {
            ArrayList arrayList;
            switch (i) {
                case 0:
                    arrayList = this.b;
                    break;
                case 1:
                    arrayList = this.c;
                    break;
                case 2:
                    try {
                        arrayList = this.d;
                        break;
                    } catch (Throwable th) {
                    }
                default:
                    arrayList = null;
                    break;
            }
            if (!(arrayList == null || iUMIDInitListenerEx == null)) {
                arrayList.add(iUMIDInitListenerEx);
            }
        }
    }
}
