package com.amap.api.mapcore.util;

import android.content.Context;
import android.opengl.GLES20;
import com.amap.api.maps.model.GL3DModel;
import com.amap.api.maps.model.GL3DModelOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Gl3dModelManager */
public class bv {
    private long O000000o = 0;
    private Context O00000Oo;
    private List<O0OOO0O> O00000o = new ArrayList();
    private ca O00000o0;
    private List<Integer> O00000oO = new ArrayList();

    public bv(Context context, ca caVar) {
        this.O00000Oo = context;
        this.O00000o0 = caVar;
    }

    public GL3DModel O000000o(GL3DModelOptions gL3DModelOptions) {
        if (gL3DModelOptions == null) {
            return null;
        }
        GL3DModel gL3DModel;
        O0OOO0O o0ooo0o = new O0OOO0O(this, gL3DModelOptions, this.O00000o0);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("model_");
        long j = this.O000000o;
        this.O000000o = j + 1;
        stringBuilder.append(j);
        o0ooo0o.O000000o(stringBuilder.toString());
        synchronized (this.O00000o) {
            this.O00000o.add(o0ooo0o);
            gL3DModel = new GL3DModel(o0ooo0o);
        }
        return gL3DModel;
    }

    public void O000000o() {
        for (O0OOO0O o0ooo0o : this.O00000o) {
            if (o0ooo0o.isVisible()) {
                o0ooo0o.O000000o();
            }
        }
    }

    public void O000000o(int i) {
        this.O00000oO.add(Integer.valueOf(i));
    }

    public void O000000o(String str) {
        try {
            if (this.O00000o != null && this.O00000o.size() > 0) {
                Object obj = null;
                for (int i = 0; i < this.O00000o.size(); i++) {
                    obj = (O0OOO0O) this.O00000o.get(i);
                    if (str.equals(obj.getId())) {
                        break;
                    }
                }
                if (obj != null) {
                    this.O00000o.remove(obj);
                    obj.destroy();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void O00000Oo() {
        if (this.O00000o != null) {
            this.O00000o.clear();
        }
    }

    public void O00000o() {
        if (this.O00000oO != null) {
            Iterator it = this.O00000oO.iterator();
            while (it.hasNext()) {
                GLES20.glDeleteTextures(1, new int[]{((Integer) it.next()).intValue()}, 0);
            }
        }
    }

    public void O00000o0() {
        if (this.O00000o != null) {
            for (O0OOO0O destroy : this.O00000o) {
                destroy.destroy();
            }
            this.O00000o.clear();
        }
    }
}
