package com.baidu.mapapi.map;

import android.util.Log;
import com.baidu.mapapi.common.Logger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

public final class TileOverlay {
    private static final String b = "TileOverlay";
    private static int f;
    BaiduMap a;
    private ExecutorService c = Executors.newFixedThreadPool(1);
    private HashMap<String, Tile> d = new HashMap();
    private HashSet<String> e = new HashSet();
    private TileProvider g;

    public TileOverlay(BaiduMap baiduMap, TileProvider tileProvider) {
        this.a = baiduMap;
        this.g = tileProvider;
    }

    private synchronized Tile a(String str) {
        if (!this.d.containsKey(str)) {
            return null;
        }
        Tile tile = (Tile) this.d.get(str);
        this.d.remove(str);
        return tile;
    }

    private synchronized void a(String str, Tile tile) {
        this.d.put(str, tile);
    }

    private synchronized boolean b(String str) {
        return this.e.contains(str);
    }

    private synchronized void c(String str) {
        this.e.add(str);
    }

    /* Access modifiers changed, original: 0000 */
    public Tile a(int i, int i2, int i3) {
        String str;
        String str2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("_");
        stringBuilder.append(i2);
        stringBuilder.append("_");
        stringBuilder.append(i3);
        String stringBuilder2 = stringBuilder.toString();
        Tile a = a(stringBuilder2);
        if (a != null) {
            return a;
        }
        if (this.a != null && f == 0) {
            MapStatus mapStatus = this.a.getMapStatus();
            f = (((mapStatus.a.j.right - mapStatus.a.j.left) / 256) + 2) * (((mapStatus.a.j.bottom - mapStatus.a.j.top) / 256) + 2);
        }
        if (this.d.size() > f) {
            a();
        }
        if (!(b(stringBuilder2) || this.c.isShutdown())) {
            try {
                c(stringBuilder2);
                this.c.execute(new v(this, i, i2, i3, stringBuilder2));
            } catch (RejectedExecutionException unused) {
                str = b;
                str2 = "ThreadPool excepiton";
            } catch (Exception unused2) {
                str = b;
                str2 = "fileDir is not legal";
            }
        }
        return null;
        Log.e(str, str2);
        return null;
    }

    /* Access modifiers changed, original: declared_synchronized */
    public synchronized void a() {
        Logger.logE(b, "clearTaskSet");
        this.e.clear();
        this.d.clear();
    }

    /* Access modifiers changed, original: 0000 */
    public void b() {
        this.c.shutdownNow();
    }

    public boolean clearTileCache() {
        return this.a == null ? false : this.a.b();
    }

    public void removeTileOverlay() {
        if (this.a != null) {
            this.a.a(this);
        }
    }
}
