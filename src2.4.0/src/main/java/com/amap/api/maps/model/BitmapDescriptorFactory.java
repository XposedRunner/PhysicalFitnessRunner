package com.amap.api.maps.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.FrameLayout;
import com.amap.api.mapcore.util.OOO00o.O000000o;
import com.amap.api.mapcore.util.OOo000;
import com.amap.api.mapcore.util.cf;
import java.io.FileInputStream;
import java.io.InputStream;

public final class BitmapDescriptorFactory {
    public static final float HUE_AZURE = 210.0f;
    public static final float HUE_BLUE = 240.0f;
    public static final float HUE_CYAN = 180.0f;
    public static final float HUE_GREEN = 120.0f;
    public static final float HUE_MAGENTA = 300.0f;
    public static final float HUE_ORANGE = 30.0f;
    public static final float HUE_RED = 0.0f;
    public static final float HUE_ROSE = 330.0f;
    public static final float HUE_VIOLET = 270.0f;
    public static final float HUE_YELLOW = 60.0f;
    private static final String ICON_ID_PREFIX = "com.amap.api.icon_";
    private static int nextId;

    public static BitmapDescriptor defaultMarker() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(O000000o.marker_default.name());
            stringBuilder.append(".png");
            return fromAsset(stringBuilder.toString());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static BitmapDescriptor defaultMarker(float f) {
        try {
            f = (float) ((((int) (f + 15.0f)) / 30) * 30);
            float f2 = (float) 330;
            if (f > f2) {
                f = f2;
            } else if (f < 0.0f) {
                f = 0.0f;
            }
            String str = "";
            if (f == 0.0f) {
                str = "RED";
            } else if (f == 30.0f) {
                str = "ORANGE";
            } else if (f == 60.0f) {
                str = "YELLOW";
            } else if (f == 120.0f) {
                str = "GREEN";
            } else if (f == 180.0f) {
                str = "CYAN";
            } else if (f == 210.0f) {
                str = "AZURE";
            } else if (f == 240.0f) {
                str = "BLUE";
            } else if (f == 270.0f) {
                str = "VIOLET";
            } else if (f == 300.0f) {
                str = "MAGENTA";
            } else if (f == 330.0f) {
                str = "ROSE";
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(".png");
            return fromAsset(stringBuilder.toString());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static BitmapDescriptor fromAsset(String str) {
        try {
            Context context = cf.O000000o;
            if (context != null) {
                return fromBitmap(OOo000.O000000o(context, str));
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("/assets/");
            stringBuilder.append(str);
            InputStream resourceAsStream = BitmapDescriptorFactory.class.getResourceAsStream(stringBuilder.toString());
            Bitmap decodeStream = BitmapFactory.decodeStream(resourceAsStream);
            resourceAsStream.close();
            return fromBitmap(decodeStream);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static BitmapDescriptor fromBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            return new BitmapDescriptor(bitmap);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static BitmapDescriptor fromFile(String str) {
        try {
            Context context = cf.O000000o;
            if (context == null) {
                return null;
            }
            FileInputStream openFileInput = context.openFileInput(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(openFileInput);
            openFileInput.close();
            BitmapDescriptor fromBitmap = fromBitmap(decodeStream);
            decodeStream.recycle();
            return fromBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static BitmapDescriptor fromPath(String str) {
        try {
            return fromBitmap(BitmapFactory.decodeFile(str));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static BitmapDescriptor fromResource(int i) {
        try {
            Context context = cf.O000000o;
            if (context == null) {
                return null;
            }
            Bitmap decodeStream = BitmapFactory.decodeStream(context.getResources().openRawResource(i));
            BitmapDescriptor fromBitmap = fromBitmap(decodeStream);
            if (!(decodeStream == null || decodeStream.isRecycled())) {
                decodeStream.recycle();
            }
            return fromBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static BitmapDescriptor fromView(View view) {
        try {
            Context context = cf.O000000o;
            if (context == null) {
                return null;
            }
            View frameLayout = new FrameLayout(context);
            frameLayout.addView(view);
            frameLayout.setDrawingCacheEnabled(true);
            return fromBitmap(OOo000.O000000o(frameLayout));
        } catch (Throwable unused) {
            return null;
        }
    }
}
