package com.zjwh.map.gaode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMap.ImageInfoWindowAdapter;
import com.amap.api.maps.AMap.OnMapScreenShotListener;
import com.amap.api.maps.AMap.OnMapTouchListener;
import com.amap.api.maps.AMap.OnMarkerClickListener;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.PolylineOptions;
import com.yalantis.ucrop.view.CropImageView;
import com.zjwh.sw.map.O00000Oo;
import com.zjwh.sw.map.O00000o;
import com.zjwh.sw.map.entity.SWLatLng;
import defpackage.gf;
import defpackage.ln;
import defpackage.lx;
import defpackage.ly;
import defpackage.lz;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GaoDeMapControl */
public class O0000o00 implements ln {
    public static final int O000000o = 0;
    public static final int O00000Oo = 1;
    public static final int O00000o = 3;
    public static final int O00000o0 = 2;
    static final int O00000oO = -1;
    private MapView O00000oo;
    private AMap O0000O0o;
    private lz O0000OOo;
    private ly O0000Oo;
    private lx O0000Oo0;

    public O0000o00(MapView mapView) {
        this.O00000oo = mapView;
    }

    private float O000000o(double d, double d2, double d3, double d4) {
        int[] iArr = new int[]{50, 100, 200, 500, 1000, 2000, 5000, 10000, 20000, 25000, 50000, gf.O000OOo0, 200000, 500000, 1000000};
        d = (double) AMapUtils.calculateLineDistance(new LatLng(d, d2), new LatLng(d3, d4));
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            if (((double) iArr[i]) - d > 0.0d) {
                return (float) ((17 - i) + 3);
            }
        }
        return 17.0f;
    }

    private int O000000o(float f) {
        return (int) ((f * this.O00000oo.getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    private Bitmap O000000o(Bitmap bitmap, Bitmap bitmap2) {
        Bitmap bitmap3 = bitmap;
        Bitmap bitmap4 = bitmap2;
        if (bitmap3 == null || bitmap.isRecycled() || bitmap4 == null || bitmap2.isRecycled()) {
            return null;
        }
        int width = bitmap2.getWidth();
        float f = (float) width;
        int i = (int) (f / 0.6522f);
        Bitmap createBitmap = Bitmap.createBitmap(width, i, bitmap2.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        int height = i > bitmap2.getHeight() ? i - bitmap2.getHeight() : bitmap2.getHeight() - i;
        int O000000o = O000000o(20.0f);
        Rect rect = new Rect(0, height, bitmap2.getWidth(), bitmap2.getHeight());
        Rect rect2 = new Rect(0, 0, bitmap2.getWidth(), i);
        Rect rect3 = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        Rect rect4 = new Rect((createBitmap.getWidth() - bitmap.getWidth()) / 2, (createBitmap.getHeight() - bitmap.getHeight()) - O000000o, createBitmap.getWidth() - ((createBitmap.getWidth() - bitmap.getWidth()) / 2), createBitmap.getHeight() - O000000o);
        canvas.drawBitmap(bitmap4, rect, rect2, null);
        canvas.drawBitmap(bitmap3, rect3, rect4, null);
        bitmap3 = Bitmap.createBitmap(width, i, bitmap2.getConfig());
        Canvas canvas2 = new Canvas(bitmap3);
        BitmapShader bitmapShader = new BitmapShader(createBitmap, TileMode.CLAMP, TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        float O000000o2 = (float) O000000o(5.0f);
        canvas2.drawRoundRect(new RectF(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, f, (float) i), O000000o2, O000000o2, paint);
        createBitmap.recycle();
        return bitmap3;
    }

    private Bitmap O000000o(Bitmap bitmap, Bitmap bitmap2, boolean z) {
        if (bitmap == null || bitmap.isRecycled() || bitmap2 == null || bitmap2.isRecycled()) {
            return null;
        }
        int width = z ? bitmap.getWidth() > bitmap2.getWidth() ? bitmap.getWidth() : bitmap2.getWidth() : bitmap.getWidth() < bitmap2.getWidth() ? bitmap.getWidth() : bitmap2.getWidth();
        Bitmap createBitmap = Bitmap.createBitmap(width, bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        Rect rect2 = new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight());
        Rect rect3 = new Rect(O000000o(20.0f), O000000o(35.0f), bitmap2.getWidth() + O000000o(20.0f), bitmap2.getHeight() + O000000o(35.0f));
        canvas.drawBitmap(bitmap, rect, rect, null);
        canvas.drawBitmap(bitmap2, rect2, rect3, null);
        return createBitmap;
    }

    private CameraUpdate O00000o0(List<SWLatLng> list) {
        Object obj = 1;
        double d = 0.0d;
        double d2 = d;
        double d3 = d2;
        double d4 = d3;
        for (SWLatLng sWLatLng : list) {
            O000O0OO.O000000o(sWLatLng, this.O00000oo.getContext());
            double gLat = sWLatLng.getGLat();
            double gLon = sWLatLng.getGLon();
            if (gLat > 0.0d) {
                if (obj != null) {
                    obj = null;
                    d3 = gLat;
                    d4 = gLon;
                }
                if (gLat > d) {
                    d = gLat;
                }
                if (gLon > d2) {
                    d2 = gLon;
                }
                if (gLat < d3) {
                    d3 = gLat;
                }
                if (gLon < d4) {
                    d4 = gLon;
                }
            }
        }
        return CameraUpdateFactory.newLatLngZoom(new LatLng((d + d3) / 2.0d, (d2 + d4) / 2.0d), O000000o(d, d2, d3, d4));
    }

    public Object O000000o(Object obj) throws O00000o {
        if (obj instanceof MarkerOptions) {
            return this.O0000O0o.addMarker((MarkerOptions) obj);
        }
        if (obj instanceof PolylineOptions) {
            return this.O0000O0o.addPolyline((PolylineOptions) obj);
        }
        if (obj instanceof CircleOptions) {
            return this.O0000O0o.addCircle((CircleOptions) obj);
        }
        throw new O00000o("请使用高德覆盖物类型数据！");
    }

    public void O000000o() {
        if (this.O00000oo != null) {
            this.O00000oo.onResume();
        }
    }

    public void O000000o(double d, double d2, float f) {
        if (f == -1.0f) {
            f = this.O0000O0o.getCameraPosition().zoom;
        }
        this.O0000O0o.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(d, d2), f));
    }

    public void O000000o(int i, Bundle bundle) {
        this.O00000oo.onCreate(bundle);
        this.O0000O0o = this.O00000oo.getMap();
        this.O0000O0o.getUiSettings().setZoomControlsEnabled(false);
        SWLatLng O000000o = O00000Oo.O000000o(this.O00000oo.getContext());
        if (O000000o == null || O000000o.getGLat() <= 1.0d || O000000o.getGLat() <= 1.0d) {
            this.O0000O0o.moveCamera(CameraUpdateFactory.zoomTo(17.0f));
        } else {
            this.O0000O0o.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(O000000o.getGLat(), O000000o.getGLon()), 17.0f));
        }
        this.O0000O0o.setOnMarkerClickListener(new OnMarkerClickListener() {
            public boolean onMarkerClick(Marker marker) {
                if (!(marker == null || ((marker.getPeriod() == 0 && TextUtils.isEmpty(marker.getTitle())) || O0000o00.this.O0000OOo == null))) {
                    final View O000000o = O0000o00.this.O0000OOo.O000000o(marker.getPeriod(), marker.getTitle());
                    if (O000000o == null) {
                        return false;
                    }
                    O0000o00.this.O0000O0o.setInfoWindowAdapter(new ImageInfoWindowAdapter() {
                        public View getInfoContents(Marker marker) {
                            return null;
                        }

                        public View getInfoWindow(Marker marker) {
                            return O000000o;
                        }

                        public long getInfoWindowUpdateTime() {
                            return 0;
                        }
                    });
                    marker.showInfoWindow();
                }
                if (O0000o00.this.O0000Oo0 != null) {
                    O0000o00.this.O0000Oo0.O000000o(marker);
                }
                return false;
            }
        });
        switch (i) {
            case 1:
                this.O0000O0o.setMyLocationEnabled(true);
                this.O0000O0o.setMaxZoomLevel(this.O0000O0o.getMaxZoomLevel() - 1.0f);
                this.O0000O0o.setMinZoomLevel(16.0f);
                BitmapDescriptor fromResource = BitmapDescriptorFactory.fromResource(R.drawable.cheat_report_self_icon);
                UiSettings uiSettings = this.O0000O0o.getUiSettings();
                uiSettings.setScaleControlsEnabled(false);
                uiSettings.setScrollGesturesEnabled(false);
                uiSettings.setRotateGesturesEnabled(false);
                uiSettings.setAllGesturesEnabled(false);
                this.O0000O0o.setMyLocationStyle(new MyLocationStyle().myLocationIcon(fromResource).strokeColor(Color.argb(0, 0, 0, 0)).radiusFillColor(Color.argb(0, 0, 0, 0)));
                return;
            case 2:
                break;
            case 3:
                this.O0000O0o.setOnMapTouchListener(new OnMapTouchListener() {
                    public void onTouch(MotionEvent motionEvent) {
                        if (motionEvent.getActionMasked() == 0 && O0000o00.this.O0000Oo0 != null) {
                            O0000o00.this.O0000Oo0.O000000o();
                        }
                    }
                });
                break;
            default:
                this.O0000O0o.setMaxZoomLevel(this.O0000O0o.getMaxZoomLevel() - 1.0f);
                this.O0000O0o.setMinZoomLevel(this.O0000O0o.getMinZoomLevel());
                return;
        }
        this.O0000O0o.setMyLocationEnabled(true);
        this.O0000O0o.setMaxZoomLevel(this.O0000O0o.getMaxZoomLevel() - 1.0f);
        this.O0000O0o.setMinZoomLevel(this.O0000O0o.getMinZoomLevel());
        this.O0000O0o.setMyLocationStyle(new MyLocationStyle().myLocationIcon(BitmapDescriptorFactory.fromResource(R.drawable.navi_arrow)).strokeColor(Color.argb(0, 0, 0, 0)).radiusFillColor(Color.argb(0, 0, 0, 0)));
    }

    public void O000000o(final Bitmap bitmap) {
        this.O0000O0o.getMapScreenShot(new OnMapScreenShotListener() {
            public void onMapScreenShot(Bitmap bitmap) {
                Bitmap O000000o = O0000o00.this.O000000o(bitmap, bitmap);
                Bitmap decodeResource = BitmapFactory.decodeResource(O0000o00.this.O00000oo.getResources(), R.drawable.run_history_share_icon);
                Bitmap O000000o2 = O0000o00.this.O000000o(O000000o, decodeResource, true);
                if (bitmap != null) {
                    bitmap.recycle();
                }
                if (bitmap != null) {
                    bitmap.recycle();
                }
                if (O000000o != null) {
                    O000000o.recycle();
                }
                if (decodeResource != null) {
                    decodeResource.recycle();
                }
                if (O0000o00.this.O0000Oo != null) {
                    O0000o00.this.O0000Oo.O000000o(O000000o2);
                }
            }

            public void onMapScreenShot(Bitmap bitmap, int i) {
            }
        });
    }

    public void O000000o(Bundle bundle) {
        if (this.O00000oo != null) {
            this.O00000oo.onSaveInstanceState(bundle);
        }
    }

    public void O000000o(List<?> list) throws O00000o {
        if (MarkerOptions.class.isInstance(list.iterator().next())) {
            this.O0000O0o.addMarkers((ArrayList) list, true);
            return;
        }
        throw new O00000o("请使用高德覆盖物类型数据！");
    }

    public void O000000o(lx lxVar) {
        this.O0000Oo0 = lxVar;
    }

    public void O000000o(ly lyVar) {
        this.O0000Oo = lyVar;
    }

    public void O000000o(lz lzVar) {
        this.O0000OOo = lzVar;
    }

    public void O00000Oo() {
        if (this.O00000oo != null) {
            this.O00000oo.onPause();
        }
    }

    public void O00000Oo(double d, double d2, float f) {
    }

    public void O00000Oo(Object obj) {
        if (obj instanceof Marker) {
            Marker marker = (Marker) obj;
            int period = marker.getPeriod();
            String title = marker.getTitle();
            if (!(period == 0 && (TextUtils.isEmpty(title) || this.O0000OOo == null))) {
                final View O000000o = this.O0000OOo.O000000o(period, title);
                if (O000000o != null) {
                    this.O0000O0o.setInfoWindowAdapter(new ImageInfoWindowAdapter() {
                        public View getInfoContents(Marker marker) {
                            return null;
                        }

                        public View getInfoWindow(Marker marker) {
                            return O000000o;
                        }

                        public long getInfoWindowUpdateTime() {
                            return 0;
                        }
                    });
                    marker.showInfoWindow();
                }
            }
        }
    }

    public void O00000Oo(List<SWLatLng> list) {
        this.O0000O0o.moveCamera(O00000o0((List) list));
    }

    public void O00000o() {
        this.O0000O0o.clear();
    }

    public void O00000o0() {
        if (this.O00000oo != null) {
            this.O00000oo.onDestroy();
            this.O00000oo = null;
        }
        this.O0000O0o.setOnMapClickListener(null);
        this.O0000O0o.setMyLocationEnabled(false);
        this.O0000OOo = null;
        this.O0000Oo0 = null;
    }
}
