package com.baidu.mapapi.map;

import android.util.Log;

class v implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ String d;
    final /* synthetic */ TileOverlay e;

    v(TileOverlay tileOverlay, int i, int i2, int i3, String str) {
        this.e = tileOverlay;
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = str;
    }

    public void run() {
        String c;
        String str;
        Tile tile = ((FileTileProvider) this.e.g).getTile(this.a, this.b, this.c);
        if (tile == null) {
            c = TileOverlay.b;
            str = "FileTile pic is null";
        } else if (tile.width == 256 && tile.height == 256) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append("_");
            stringBuilder.append(this.b);
            stringBuilder.append("_");
            stringBuilder.append(this.c);
            this.e.a(stringBuilder.toString(), tile);
            this.e.e.remove(this.d);
        } else {
            c = TileOverlay.b;
            str = "FileTile pic must be 256 * 256";
        }
        Log.e(c, str);
        this.e.e.remove(this.d);
    }
}
