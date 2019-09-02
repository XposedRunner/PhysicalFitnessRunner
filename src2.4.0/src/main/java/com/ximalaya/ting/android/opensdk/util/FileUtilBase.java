package com.ximalaya.ting.android.opensdk.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.media.ThumbnailUtils;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.httputil.BaseBuilder;
import com.ximalaya.ting.android.opensdk.httputil.BaseCall;
import com.ximalaya.ting.android.opensdk.httputil.Config;
import com.ximalaya.ting.android.opensdk.httputil.XimalayaException;
import com.ximalaya.ting.android.opensdk.httputil.util.freeflow.FreeFlowServiceUtil;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.player.MD5;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.CacheControl.Builder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;

public class FileUtilBase {
    private static final int MAX_DISK_CACHE_SIZE = 52428800;
    private static final int MIN_DISK_CACHE_SIZE = 5242880;
    private static String PERPETUAL_CACHE_PATH = null;
    private static final String PICASSO_CACHE = "picasso-cache";
    private static String PICASSO_CACHE_PATH;
    private static Map<String, Set<RequestCallBackModel>> callBackMaps = new ConcurrentHashMap();
    private static Config config;
    private static ExecutorService executorService = Executors.newCachedThreadPool();
    private static String lastImageUrl;
    private static Cache mCache;
    private static OkHttpClient mOkHttpClient;
    private static Bitmap tempBitmap;

    public interface IBitmapDownOkCallBack {
        void onSuccess(Bitmap bitmap);
    }

    static class GetBitmapRunnable implements Runnable {
        IBitmapDownOkCallBack bitmapDownOkCallBack;
        private Context context;
        private String imgPath;
        int requestHeight;
        int requestWidth;
        private Track track;
        private long trackId;

        public GetBitmapRunnable(Context context, String str, int i, int i2, Track track) {
            this(context, str, i, i2, null, track);
        }

        public GetBitmapRunnable(Context context, String str, int i, int i2, IBitmapDownOkCallBack iBitmapDownOkCallBack, Track track) {
            this(context, str, track);
            this.requestWidth = i;
            this.requestHeight = i2;
            this.bitmapDownOkCallBack = iBitmapDownOkCallBack;
        }

        public GetBitmapRunnable(Context context, String str, Track track) {
            this.context = context;
            this.imgPath = str;
            this.track = track;
            if (track != null) {
                this.trackId = track.getDataId();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0068  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0062  */
        /* JADX WARNING: Missing block: B:23:0x0091, code skipped:
            if (r0.toString().equals(com.ximalaya.ting.android.opensdk.util.FileUtilBase.access$100()) != false) goto L_0x009e;
     */
        public void run() {
            /*
            r6 = this;
            r0 = r6.imgPath;
            if (r0 == 0) goto L_0x004a;
        L_0x0004:
            r0 = r6.imgPath;
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = r6.trackId;
            r1.append(r2);
            r2 = "";
            r1.append(r2);
            r1 = r1.toString();
            r0 = r0.equals(r1);
            if (r0 == 0) goto L_0x004a;
        L_0x001f:
            r0 = r6.trackId;
            r0 = com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequestForMain.getTrackInfo(r0);
            if (r0 == 0) goto L_0x0042;
        L_0x0027:
            r1 = r6.track;
            r2 = r0.getCoverUrlLarge();
            r1.setCoverUrlLarge(r2);
            r1 = r6.track;
            r2 = r0.getCoverUrlMiddle();
            r1.setCoverUrlMiddle(r2);
            r1 = r6.track;
            r2 = r0.getCoverUrlSmall();
            r1.setCoverUrlSmall(r2);
        L_0x0042:
            r0 = com.ximalaya.ting.android.opensdk.util.FileUtilBase.getNotifiAndRemoteImgUrl(r0);
            r6.imgPath = r0;
            r0 = 1;
            goto L_0x004b;
        L_0x004a:
            r0 = 0;
        L_0x004b:
            r1 = 0;
            r2 = r6.context;	 Catch:{ Exception -> 0x005a }
            r3 = r6.imgPath;	 Catch:{ Exception -> 0x005a }
            r4 = r6.requestWidth;	 Catch:{ Exception -> 0x005a }
            r5 = r6.requestHeight;	 Catch:{ Exception -> 0x005a }
            r2 = com.ximalaya.ting.android.opensdk.util.FileUtilBase.getBitmapThread(r2, r3, r4, r5);	 Catch:{ Exception -> 0x005a }
            r1 = r2;
            goto L_0x005e;
        L_0x005a:
            r2 = move-exception;
            r2.printStackTrace();
        L_0x005e:
            r2 = r6.bitmapDownOkCallBack;
            if (r2 == 0) goto L_0x0068;
        L_0x0062:
            r0 = r6.bitmapDownOkCallBack;
            com.ximalaya.ting.android.opensdk.util.FileUtilBase.handleBitmapCallBack(r0, r1);
            return;
        L_0x0068:
            r2 = r6.imgPath;
            r3 = com.ximalaya.ting.android.opensdk.util.FileUtilBase.lastImageUrl;
            r2 = r2.equals(r3);
            if (r2 != 0) goto L_0x009e;
        L_0x0074:
            if (r0 == 0) goto L_0x0094;
        L_0x0076:
            r0 = new java.lang.StringBuilder;
            r0.<init>();
            r2 = r6.trackId;
            r0.append(r2);
            r2 = "";
            r0.append(r2);
            r0 = r0.toString();
            r2 = com.ximalaya.ting.android.opensdk.util.FileUtilBase.lastImageUrl;
            r0 = r0.equals(r2);
            if (r0 == 0) goto L_0x0094;
        L_0x0093:
            goto L_0x009e;
        L_0x0094:
            r0 = com.ximalaya.ting.android.opensdk.util.FileUtilBase.callBackMaps;
            r1 = r6.imgPath;
            r0.remove(r1);
            goto L_0x00ac;
        L_0x009e:
            com.ximalaya.ting.android.opensdk.util.FileUtilBase.tempBitmap = r1;
            r0 = com.ximalaya.ting.android.opensdk.util.FileUtilBase.tempBitmap;
            r1 = com.ximalaya.ting.android.opensdk.util.FileUtilBase.lastImageUrl;
            com.ximalaya.ting.android.opensdk.util.FileUtilBase.callBackResult(r0, r1);
        L_0x00ac:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.opensdk.util.FileUtilBase$GetBitmapRunnable.run():void");
        }
    }

    static class RequestCallBackModel {
        public IBitmapDownOkCallBack bitmapDownOkCallBack;
        public int height;
        public int width;

        public RequestCallBackModel(IBitmapDownOkCallBack iBitmapDownOkCallBack, int i, int i2) {
            this.bitmapDownOkCallBack = iBitmapDownOkCallBack;
            this.width = i;
            this.height = i2;
        }
    }

    public static long calculateDiskCacheSize(File file) {
        long blockCount;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            blockCount = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 50;
        } catch (IllegalArgumentException unused) {
            blockCount = 5242880;
        }
        return Math.max(Math.min(blockCount, 52428800), 5242880);
    }

    public static int calculateInSampleSize(@NonNull Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            while (true) {
                if (i3 / i5 <= i2 && i4 / i5 <= i) {
                    break;
                }
                i5 *= 2;
            }
        }
        return i5;
    }

    private static void callBackResult(Bitmap bitmap, String str) {
        Set<RequestCallBackModel> set = (Set) callBackMaps.get(str);
        if (set != null) {
            for (RequestCallBackModel requestCallBackModel : set) {
                if (requestCallBackModel == null || requestCallBackModel.bitmapDownOkCallBack == null || (bitmap != null && (bitmap == null || bitmap.isRecycled()))) {
                    if (requestCallBackModel != null) {
                        handleBitmapCallBack(requestCallBackModel.bitmapDownOkCallBack, null);
                    }
                } else if (requestCallBackModel.width <= 0 || requestCallBackModel.height <= 0) {
                    handleBitmapCallBack(requestCallBackModel.bitmapDownOkCallBack, bitmap);
                } else {
                    handleBitmapCallBack(requestCallBackModel.bitmapDownOkCallBack, ThumbnailUtils.extractThumbnail(bitmap, requestCallBackModel.width, requestCallBackModel.height));
                }
            }
            callBackMaps.remove(str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0077 A:{SYNTHETIC, Splitter:B:57:0x0077} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0081 A:{SYNTHETIC, Splitter:B:62:0x0081} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0062 A:{SYNTHETIC, Splitter:B:46:0x0062} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x006c A:{SYNTHETIC, Splitter:B:51:0x006c} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0077 A:{SYNTHETIC, Splitter:B:57:0x0077} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0081 A:{SYNTHETIC, Splitter:B:62:0x0081} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0062 A:{SYNTHETIC, Splitter:B:46:0x0062} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x006c A:{SYNTHETIC, Splitter:B:51:0x006c} */
    public static int copyAssetsToFile(android.content.res.AssetManager r6, java.lang.String r7, java.lang.String r8) {
        /*
        r0 = 0;
        r1 = 0;
        r6 = r6.open(r7);	 Catch:{ Exception -> 0x005b, all -> 0x0058 }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x0056 }
        r7.<init>(r8);	 Catch:{ Exception -> 0x0056 }
        r8 = r7.exists();	 Catch:{ Exception -> 0x0056 }
        if (r8 == 0) goto L_0x0026;
    L_0x0011:
        r2 = r7.length();	 Catch:{ Exception -> 0x0056 }
        r4 = 0;
        r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r8 <= 0) goto L_0x0026;
    L_0x001b:
        if (r6 == 0) goto L_0x0025;
    L_0x001d:
        r6.close();	 Catch:{ IOException -> 0x0021 }
        goto L_0x0025;
    L_0x0021:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x0025:
        return r1;
    L_0x0026:
        r8 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0056 }
        r8.<init>(r7);	 Catch:{ Exception -> 0x0056 }
        r7 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r7 = new byte[r7];	 Catch:{ Exception -> 0x0051, all -> 0x004e }
    L_0x002f:
        r0 = r6.read(r7);	 Catch:{ Exception -> 0x0051, all -> 0x004e }
        if (r0 <= 0) goto L_0x003b;
    L_0x0035:
        if (r0 <= 0) goto L_0x002f;
    L_0x0037:
        r8.write(r7, r1, r0);	 Catch:{ Exception -> 0x0051, all -> 0x004e }
        goto L_0x002f;
    L_0x003b:
        r8.flush();	 Catch:{ Exception -> 0x0051, all -> 0x004e }
        if (r8 == 0) goto L_0x0048;
    L_0x0040:
        r8.close();	 Catch:{ IOException -> 0x0044 }
        goto L_0x0048;
    L_0x0044:
        r7 = move-exception;
        r7.printStackTrace();
    L_0x0048:
        if (r6 == 0) goto L_0x0074;
    L_0x004a:
        r6.close();	 Catch:{ IOException -> 0x0070 }
        goto L_0x0074;
    L_0x004e:
        r7 = move-exception;
        r0 = r8;
        goto L_0x0075;
    L_0x0051:
        r7 = move-exception;
        r0 = r8;
        goto L_0x005d;
    L_0x0054:
        r7 = move-exception;
        goto L_0x0075;
    L_0x0056:
        r7 = move-exception;
        goto L_0x005d;
    L_0x0058:
        r7 = move-exception;
        r6 = r0;
        goto L_0x0075;
    L_0x005b:
        r7 = move-exception;
        r6 = r0;
    L_0x005d:
        r7.printStackTrace();	 Catch:{ all -> 0x0054 }
        if (r0 == 0) goto L_0x006a;
    L_0x0062:
        r0.close();	 Catch:{ IOException -> 0x0066 }
        goto L_0x006a;
    L_0x0066:
        r7 = move-exception;
        r7.printStackTrace();
    L_0x006a:
        if (r6 == 0) goto L_0x0074;
    L_0x006c:
        r6.close();	 Catch:{ IOException -> 0x0070 }
        goto L_0x0074;
    L_0x0070:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x0074:
        return r1;
    L_0x0075:
        if (r0 == 0) goto L_0x007f;
    L_0x0077:
        r0.close();	 Catch:{ IOException -> 0x007b }
        goto L_0x007f;
    L_0x007b:
        r8 = move-exception;
        r8.printStackTrace();
    L_0x007f:
        if (r6 == 0) goto L_0x0089;
    L_0x0081:
        r6.close();	 Catch:{ IOException -> 0x0085 }
        goto L_0x0089;
    L_0x0085:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x0089:
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.opensdk.util.FileUtilBase.copyAssetsToFile(android.content.res.AssetManager, java.lang.String, java.lang.String):int");
    }

    public static File createDefaultCacheDir(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), PICASSO_CACHE);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    @Nullable
    @WorkerThread
    public static Bitmap decode(@Nullable String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Bitmap decodeFile;
        if (i > 0 || i2 > 0) {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = calculateInSampleSize(options, i, i2);
            options.inJustDecodeBounds = false;
            decodeFile = BitmapFactory.decodeFile(str, options);
        } else {
            try {
                decodeFile = BitmapFactory.decodeFile(str);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        ExifInterface exif = getExif(str);
        return exif != null ? rotateBitmap(decodeFile, exifToDegrees(exif.getAttributeInt("Orientation", 1))) : decodeFile;
    }

    public static void deleFileNoCheckDownloadFile(File file) {
        if (file != null) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File deleFileNoCheckDownloadFile : listFiles) {
                        deleFileNoCheckDownloadFile(deleFileNoCheckDownloadFile);
                    }
                }
                file.delete();
            } else {
                file.delete();
            }
        }
    }

    private static int exifToDegrees(int i) {
        return i == 6 ? 90 : i == 3 ? 180 : i == 8 ? 270 : 0;
    }

    public static String getAdsCacheDir(Context context, String str) {
        StringBuilder stringBuilder;
        String stringBuilder2;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(Environment.getExternalStorageDirectory().getPath());
            stringBuilder.append("/Android/data/");
            stringBuilder.append(context.getPackageName());
            stringBuilder.append("/files/soundtiepian");
            stringBuilder2 = stringBuilder.toString();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(context.getFilesDir().getPath());
            stringBuilder.append("/soundtiepian");
            stringBuilder2 = stringBuilder.toString();
        }
        File file = new File(stringBuilder2);
        if (!file.exists()) {
            file.mkdirs();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(stringBuilder2);
        stringBuilder.append(File.separator);
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static String getAssetsCacheDir(Context context, String str) {
        StringBuilder stringBuilder;
        String stringBuilder2;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(Environment.getExternalStorageDirectory().getPath());
            stringBuilder.append("/Android/data/");
            stringBuilder.append(context.getPackageName());
            stringBuilder.append("/files/assets");
            stringBuilder2 = stringBuilder.toString();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(context.getFilesDir().getPath());
            stringBuilder.append("/assets");
            stringBuilder2 = stringBuilder.toString();
        }
        File file = new File(stringBuilder2);
        if (!file.exists()) {
            file.mkdirs();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(stringBuilder2);
        stringBuilder.append(File.separator);
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static void getBitmapByUrl(Context context, Track track, int i, int i2, IBitmapDownOkCallBack iBitmapDownOkCallBack) {
        getBitmapByUrl(context, track, getLargeImgUrl(track), i, i2, iBitmapDownOkCallBack, false);
    }

    private static void getBitmapByUrl(Context context, Track track, String str, int i, int i2, IBitmapDownOkCallBack iBitmapDownOkCallBack, boolean z) {
        if (TextUtils.isEmpty(str) || "null".equals(str)) {
            if (iBitmapDownOkCallBack != null) {
                iBitmapDownOkCallBack.onSuccess(null);
            }
            return;
        } else if (context == null) {
            if (iBitmapDownOkCallBack != null) {
                iBitmapDownOkCallBack.onSuccess(null);
            }
            return;
        } else {
            synchronized (FileUtilBase.class) {
                if (z) {
                    try {
                        if (executorService == null || executorService.isShutdown()) {
                            executorService = Executors.newCachedThreadPool();
                        }
                        executorService.execute(new GetBitmapRunnable(context, str, i, i2, iBitmapDownOkCallBack, track));
                    } catch (Exception e) {
                        e.printStackTrace();
                    } catch (Throwable th) {
                    }
                } else {
                    Object obj = null;
                    if (!str.equals(lastImageUrl)) {
                        lastImageUrl = str;
                        callBackMaps.clear();
                        tempBitmap = null;
                    } else if (!(tempBitmap == null || iBitmapDownOkCallBack == null)) {
                        iBitmapDownOkCallBack.onSuccess(tempBitmap);
                        return;
                    }
                    Set set = (Set) callBackMaps.get(str);
                    if (set == null) {
                        set = new CopyOnWriteArraySet();
                        obj = 1;
                    }
                    set.add(new RequestCallBackModel(iBitmapDownOkCallBack, i, i2));
                    callBackMaps.put(str, set);
                    if (obj == null) {
                        return;
                    }
                    if (executorService == null || executorService.isShutdown()) {
                        executorService = Executors.newCachedThreadPool();
                    }
                    try {
                        executorService.execute(new GetBitmapRunnable(context, str, track));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return;
    }

    public static void getBitmapByUrlAndNotConcurrence(Context context, Track track, int i, int i2, IBitmapDownOkCallBack iBitmapDownOkCallBack) {
        getBitmapByUrl(context, track, getLargeImgUrl(track), i, i2, iBitmapDownOkCallBack, true);
    }

    @WorkerThread
    static Bitmap getBitmapThread(Context context, String str, int i, int i2) {
        StringBuilder stringBuilder;
        boolean z;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(context.getCacheDir().getAbsolutePath());
        stringBuilder2.append(File.separator);
        stringBuilder2.append(PICASSO_CACHE);
        PICASSO_CACHE_PATH = stringBuilder2.toString();
        File externalFilesDir = context.getExternalFilesDir("images");
        if (externalFilesDir == null || !externalFilesDir.exists()) {
            PERPETUAL_CACHE_PATH = PICASSO_CACHE_PATH;
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(externalFilesDir.getAbsolutePath());
            stringBuilder.append(File.separator);
            stringBuilder.append("images");
            PERPETUAL_CACHE_PATH = stringBuilder.toString();
        }
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(PICASSO_CACHE_PATH);
        stringBuilder2.append(File.separator);
        stringBuilder2.append(MD5.md5(str));
        stringBuilder2.append(".1");
        String stringBuilder3 = stringBuilder2.toString();
        boolean exists = new File(stringBuilder3).exists();
        if (exists) {
            z = exists;
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(PERPETUAL_CACHE_PATH);
            stringBuilder.append(File.separator);
            stringBuilder.append(urlToOldFileName(str));
            String stringBuilder4 = stringBuilder.toString();
            z = new File(stringBuilder4).exists();
            if (z) {
                stringBuilder3 = stringBuilder4;
            }
        }
        if (z) {
            return decode(stringBuilder3, i, i2);
        }
        CacheControl build = !NetworkType.isConnectTONetWork(context) ? CacheControl.FORCE_CACHE : new Builder().build();
        try {
            Request.Builder tag = BaseBuilder.urlGet(reduceHttpsToHttp(context, str)).tag(str);
            if (build != null) {
                tag.cacheControl(build);
            }
            try {
                Response execute = getOkHttpClient(context).newCall(tag.build()).execute();
                if (execute != null && execute.code() == 200) {
                    if (new File(stringBuilder3).exists()) {
                        execute.body().close();
                        return decode(stringBuilder3, i, i2);
                    }
                    Closeable byteStream = execute.body().byteStream();
                    Bitmap decodeStream = BitmapFactory.decodeStream(byteStream);
                    Util.closeQuietly(byteStream);
                    return decodeStream;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        } catch (XimalayaException unused) {
            return null;
        } catch (Exception unused2) {
            return null;
        }
    }

    public static Cache getCache(Context context) {
        if (mCache == null) {
            synchronized (FileUtilBase.class) {
                if (mCache == null) {
                    File createDefaultCacheDir = createDefaultCacheDir(context);
                    mCache = new Cache(createDefaultCacheDir, calculateDiskCacheSize(createDefaultCacheDir));
                }
            }
        }
        return mCache;
    }

    @Nullable
    private static ExifInterface getExif(@NonNull String str) {
        try {
            return new ExifInterface(str);
        } catch (IOException unused) {
            return null;
        }
    }

    private static String getLargeImgUrl(Track track) {
        if (!BaseUtil.isMainApp()) {
            return getNotifiAndRemoteImgUrl(track);
        }
        String str = "";
        if (track != null) {
            if (!TextUtils.isEmpty(track.getCoverUrlLarge())) {
                str = track.getCoverUrlLarge();
            }
            if (TextUtils.isEmpty(str)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(track.getDataId());
                stringBuilder.append("");
                str = stringBuilder.toString();
            }
        }
        return str;
    }

    private static String getNotifiAndRemoteImgUrl(Track track) {
        String str = "";
        return track != null ? !TextUtils.isEmpty(track.getCoverUrlLarge()) ? track.getCoverUrlLarge() : !TextUtils.isEmpty(track.getCoverUrlMiddle()) ? track.getCoverUrlMiddle() : !TextUtils.isEmpty(track.getCoverUrlSmall()) ? track.getCoverUrlSmall() : str : str;
    }

    private static OkHttpClient getOkHttpClient(Context context) {
        if (mOkHttpClient == null) {
            synchronized (FileUtilBase.class) {
                if (mOkHttpClient == null) {
                    mOkHttpClient = BaseCall.getInstanse().getOkHttpClient(null);
                    OkHttpClient.Builder newBuilder = mOkHttpClient.newBuilder();
                    newBuilder.cache(getCache(context));
                    mOkHttpClient = newBuilder.build();
                }
            }
        }
        return mOkHttpClient;
    }

    static void handleBitmapCallBack(final IBitmapDownOkCallBack iBitmapDownOkCallBack, final Bitmap bitmap) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                if (iBitmapDownOkCallBack == null) {
                    return;
                }
                if (bitmap == null || bitmap.isRecycled()) {
                    iBitmapDownOkCallBack.onSuccess(null);
                    return;
                }
                try {
                    iBitmapDownOkCallBack.onSuccess(bitmap);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public static String reduceHttpsToHttp(Context context, String str) {
        return (TextUtils.isEmpty(str) || str.startsWith("http://")) ? str : str;
    }

    public static void release() {
        lastImageUrl = null;
        PICASSO_CACHE_PATH = null;
        tempBitmap = null;
        callBackMaps.clear();
        mOkHttpClient = null;
        mCache = null;
    }

    public static Bitmap rotateBitmap(@Nullable Bitmap bitmap, int i) {
        if (bitmap == null || i == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate((float) i, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        return bitmap != createBitmap ? createBitmap : bitmap;
    }

    public static void setProxy(Context context, Config config) {
        if (mOkHttpClient != null) {
            OkHttpClient.Builder newBuilder = mOkHttpClient.newBuilder();
            FreeFlowServiceUtil.updateProxyToBuilder(context, config, newBuilder, false);
            mOkHttpClient = newBuilder.build();
        }
    }

    public static String urlToOldFileName(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MD5.md5(str));
        stringBuilder.append(str.substring(lastIndexOf + 1));
        return stringBuilder.toString();
    }
}
