package com.tencent.connect.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.tencent.open.a.f;
import com.tencent.open.utils.c;
import com.tencent.open.utils.j;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: ProGuard */
public class a {
    public static final int a(Options options, int i, int i2) {
        int b = b(options, i, i2);
        if (b > 8) {
            return 8 * ((b + 7) / 8);
        }
        i = 1;
        while (i < b) {
            i <<= 1;
        }
        return i;
    }

    private static Bitmap a(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            width = height;
        }
        float f = ((float) i) / ((float) width);
        matrix.postScale(f, f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static final Bitmap a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Options options = new Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        if (options.mCancel || options.outWidth == -1 || options.outHeight == -1) {
            return null;
        }
        Bitmap decodeFile;
        if (i2 <= i3) {
            i2 = i3;
        }
        options.inPreferredConfig = Config.RGB_565;
        if (i2 > i) {
            options.inSampleSize = a(options, -1, i * i);
        }
        options.inJustDecodeBounds = false;
        try {
            decodeFile = BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            decodeFile = null;
        }
        if (decodeFile == null) {
            return null;
        }
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        if (i4 > i5) {
            i5 = i4;
        }
        return i5 > i ? a(decodeFile, i) : decodeFile;
    }

    protected static final String a(Bitmap bitmap, String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.append(str2);
        str = stringBuffer.toString();
        File file2 = new File(str);
        if (file2.exists()) {
            file2.delete();
        }
        if (bitmap != null) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                bitmap.compress(CompressFormat.JPEG, 80, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                bitmap.recycle();
                return str;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static final void a(Context context, final String str, final c cVar) {
        f.b("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage");
        if (TextUtils.isEmpty(str)) {
            cVar.a(1, null);
        } else if (j.b()) {
            final AnonymousClass1 anonymousClass1 = new Handler(context.getMainLooper()) {
                public void handleMessage(Message message) {
                    switch (message.what) {
                        case 101:
                            cVar.a(0, (String) message.obj);
                            return;
                        case 102:
                            cVar.a(message.arg1, null);
                            return;
                        default:
                            super.handleMessage(message);
                            return;
                    }
                }
            };
            new Thread(new Runnable() {
                public void run() {
                    Bitmap a = a.a(str, 140);
                    if (a != null) {
                        String a2;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(Environment.getExternalStorageDirectory());
                        stringBuilder.append("/tmp/");
                        String stringBuilder2 = stringBuilder.toString();
                        String f = j.f(str);
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append("share2qq_temp");
                        stringBuilder3.append(f);
                        stringBuilder3.append(".jpg");
                        f = stringBuilder3.toString();
                        if (a.b(str, 140, 140)) {
                            f.b("openSDK_LOG.AsynScaleCompressImage", "out of bound,compress!");
                            a2 = a.a(a, stringBuilder2, f);
                        } else {
                            f.b("openSDK_LOG.AsynScaleCompressImage", "not out of bound,not compress!");
                            a2 = str;
                        }
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("-->destFilePath: ");
                        stringBuilder.append(a2);
                        f.b("openSDK_LOG.AsynScaleCompressImage", stringBuilder.toString());
                        if (a2 != null) {
                            Message obtainMessage = anonymousClass1.obtainMessage(101);
                            obtainMessage.obj = a2;
                            anonymousClass1.sendMessage(obtainMessage);
                            return;
                        }
                    }
                    Message obtainMessage2 = anonymousClass1.obtainMessage(102);
                    obtainMessage2.arg1 = 3;
                    anonymousClass1.sendMessage(obtainMessage2);
                }
            }).start();
        } else {
            cVar.a(2, null);
        }
    }

    public static final void a(Context context, final ArrayList<String> arrayList, final c cVar) {
        f.b("openSDK_LOG.AsynScaleCompressImage", "batchScaleCompressImage");
        if (arrayList == null) {
            cVar.a(1, null);
            return;
        }
        final AnonymousClass3 anonymousClass3 = new Handler(context.getMainLooper()) {
            public void handleMessage(Message message) {
                if (message.what != 101) {
                    super.handleMessage(message);
                    return;
                }
                cVar.a(0, message.getData().getStringArrayList("images"));
            }
        };
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < arrayList.size(); i++) {
                    Object obj = (String) arrayList.get(i);
                    if (!j.g(obj) && j.h(obj)) {
                        Bitmap a = a.a((String) obj, 10000);
                        if (a != null) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(Environment.getExternalStorageDirectory());
                            stringBuilder.append("/tmp/");
                            String stringBuilder2 = stringBuilder.toString();
                            String f = j.f((String) obj);
                            StringBuilder stringBuilder3 = new StringBuilder();
                            stringBuilder3.append("share2qzone_temp");
                            stringBuilder3.append(f);
                            stringBuilder3.append(".jpg");
                            f = stringBuilder3.toString();
                            if (a.b((String) obj, (int) GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH, 10000)) {
                                f.b("openSDK_LOG.AsynScaleCompressImage", "out of bound, compress!");
                                obj = a.a(a, stringBuilder2, f);
                            } else {
                                f.b("openSDK_LOG.AsynScaleCompressImage", "not out of bound,not compress!");
                            }
                            if (obj != null) {
                                arrayList.set(i, obj);
                            }
                        }
                    }
                }
                Message obtainMessage = anonymousClass3.obtainMessage(101);
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("images", arrayList);
                obtainMessage.setData(bundle);
                anonymousClass3.sendMessage(obtainMessage);
            }
        }).start();
    }

    private static int b(Options options, int i, int i2) {
        int i3;
        double d = (double) options.outWidth;
        double d2 = (double) options.outHeight;
        int ceil = i2 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d * d2) / ((double) i2)));
        if (i == -1) {
            i3 = 128;
        } else {
            double d3 = (double) i;
            i3 = (int) Math.min(Math.floor(d / d3), Math.floor(d2 / d3));
        }
        return i3 < ceil ? ceil : (i2 == -1 && i == -1) ? 1 : i == -1 ? ceil : i3;
    }

    private static final boolean b(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Options options = new Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (options.mCancel || options.outWidth == -1 || options.outHeight == -1) {
            return false;
        }
        int i5 = i3 > i4 ? i3 : i4;
        if (i3 >= i4) {
            i3 = i4;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("longSide=");
        stringBuilder.append(i5);
        stringBuilder.append("shortSide=");
        stringBuilder.append(i3);
        f.b("openSDK_LOG.AsynScaleCompressImage", stringBuilder.toString());
        options.inPreferredConfig = Config.RGB_565;
        return i5 > i2 || i3 > i;
    }
}
