package com.qiyukf.nim.uikit.a;

import android.content.Context;
import android.os.Handler;
import java.util.ArrayList;
import java.util.List;

public final class b {
    private List<a> a = new ArrayList();
    private Handler b;

    public interface a {
    }

    public b(Context context) {
        this.b = new Handler(context.getMainLooper());
    }

    public final synchronized void a(a aVar) {
        if (aVar != null) {
            this.a.add(aVar);
        }
    }

    public final synchronized void b(a aVar) {
        if (aVar != null) {
            this.a.remove(aVar);
        }
    }
}
