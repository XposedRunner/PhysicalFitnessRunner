package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.amap.api.mapcore.util.OO00O0.O000000o;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;

/* compiled from: AbstractImageFetcher */
public class OOOo00 extends OOOo {
    private TileProvider O00000oO = null;

    public OOOo00(Context context, int i, int i2) {
        super(context, i, i2);
        O000000o(context);
    }

    private void O000000o(Context context) {
        O00000Oo(context);
    }

    private void O00000Oo(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                activeNetworkInfo.isConnectedOrConnecting();
            }
        }
    }

    private Bitmap O00000o0(O000000o o000000o) {
        try {
            Tile tile = this.O00000oO.getTile(o000000o.O000000o, o000000o.O00000Oo, o000000o.O00000o0);
            return (tile == null || tile == TileProvider.NO_TILE) ? null : BitmapFactory.decodeByteArray(tile.data, 0, tile.data.length);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* Access modifiers changed, original: protected */
    public Bitmap O000000o(Object obj) {
        return O00000o0((O000000o) obj);
    }

    public void O000000o(TileProvider tileProvider) {
        this.O00000oO = tileProvider;
    }
}
