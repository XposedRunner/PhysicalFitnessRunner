package com.qiyukf.nimlib.e;

import android.os.Handler;
import com.qiyukf.nimlib.sdk.Observer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c {
    private final Map<String, List<Observer>> a = new ConcurrentHashMap();
    private final d b;

    c(Handler handler) {
        this.b = new d(handler);
    }

    public final boolean a(i iVar) {
        if (iVar.a().startsWith("observe")) {
            Object[] objArr = iVar.a.b;
            if (objArr == null || objArr.length != 2 || !(objArr[0] instanceof Observer) || !(objArr[1] instanceof Boolean)) {
                return false;
            }
            Observer observer = (Observer) objArr[0];
            if (((Boolean) objArr[1]).booleanValue()) {
                String str = iVar.a.a;
                List list = (List) this.a.get(str);
                if (list == null) {
                    list = new ArrayList();
                    this.a.put(str, list);
                }
                synchronized (list) {
                    list.add(observer);
                }
                this.b.a(iVar.a.a, observer);
                return true;
            }
            List list2 = (List) this.a.get(iVar.a.a);
            if (list2 == null) {
                return true;
            }
            synchronized (list2) {
                list2.remove(observer);
            }
            return true;
        }
        return false;
    }

    /* Access modifiers changed, original: final */
    public final boolean b(i iVar) {
        List list = (List) this.a.get(iVar.a.a);
        if (list == null) {
            return false;
        }
        synchronized (list) {
            ArrayList<Observer> arrayList = new ArrayList(list);
        }
        for (Observer onEvent : arrayList) {
            onEvent.onEvent(iVar.a.b[0]);
        }
        return true;
    }
}
