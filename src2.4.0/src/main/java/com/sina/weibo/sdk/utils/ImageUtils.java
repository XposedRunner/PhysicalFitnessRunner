package com.sina.weibo.sdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.MediaMetadataRetriever;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageUtils {
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c1 A:{Catch:{ Exception -> 0x0155, all -> 0x0152 }} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x011c A:{Catch:{ Exception -> 0x0147, all -> 0x0144 }} */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0133 A:{SYNTHETIC, EDGE_INSN: B:94:0x0133->B:53:0x0133 ?: BREAK  , EDGE_INSN: B:94:0x0133->B:53:0x0133 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x012f A:{LOOP_END, LOOP:0: B:50:0x0128->B:52:0x012f, Catch:{ Exception -> 0x0142 }} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0139 A:{SYNTHETIC, Splitter:B:55:0x0139} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x013e A:{Catch:{ Exception -> 0x0141 }} */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0163 A:{SYNTHETIC, Splitter:B:79:0x0163} */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0168 A:{Catch:{ Exception -> 0x016b }} */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0170 A:{SYNTHETIC, Splitter:B:88:0x0170} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0175 A:{Catch:{ Exception -> 0x0178 }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b7 A:{SYNTHETIC, Splitter:B:31:0x00b7} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c1 A:{Catch:{ Exception -> 0x0155, all -> 0x0152 }} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x011c A:{Catch:{ Exception -> 0x0147, all -> 0x0144 }} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x012f A:{LOOP_END, LOOP:0: B:50:0x0128->B:52:0x012f, Catch:{ Exception -> 0x0142 }} */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0133 A:{SYNTHETIC, EDGE_INSN: B:94:0x0133->B:53:0x0133 ?: BREAK  , EDGE_INSN: B:94:0x0133->B:53:0x0133 ?: BREAK  , EDGE_INSN: B:94:0x0133->B:53:0x0133 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0139 A:{SYNTHETIC, Splitter:B:55:0x0139} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x013e A:{Catch:{ Exception -> 0x0141 }} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x014e A:{SYNTHETIC, Splitter:B:69:0x014e} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x014e A:{SYNTHETIC, Splitter:B:69:0x014e} */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0170 A:{SYNTHETIC, Splitter:B:88:0x0170} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0175 A:{Catch:{ Exception -> 0x0178 }} */
    public static java.lang.String copyFileToWeiboTem(android.content.Context r11, android.net.Uri r12, int r13) {
        /*
        r0 = 0;
        r1 = com.sina.weibo.sdk.WeiboAppManager.queryWbInfoInternal(r11);	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        r1 = r1.getPackageName();	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        if (r2 == 0) goto L_0x0011;
    L_0x000f:
        r1 = "com.sina.weibo";
    L_0x0011:
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        r2.<init>();	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        r3 = "/Android/data/";
        r2.append(r3);	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        r2.append(r1);	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        r1 = "/files/.composerTem/";
        r2.append(r1);	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        r1 = r2.toString();	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        r2 = new java.io.File;	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        r3.<init>();	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        r4 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        r4 = r4.getAbsolutePath();	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        r3.append(r4);	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        r3.append(r1);	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        r2.mkdirs();	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        r2 = java.util.Calendar.getInstance();	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        r3 = 0;
        r4 = r12.getScheme();	 Catch:{ Exception -> 0x00aa, all -> 0x00a6 }
        r5 = "file";
        r4 = r4.equals(r5);	 Catch:{ Exception -> 0x00aa, all -> 0x00a6 }
        if (r4 == 0) goto L_0x0071;
    L_0x0057:
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00aa, all -> 0x00a6 }
        r4.<init>();	 Catch:{ Exception -> 0x00aa, all -> 0x00a6 }
        r5 = r2.getTimeInMillis();	 Catch:{ Exception -> 0x00aa, all -> 0x00a6 }
        r4.append(r5);	 Catch:{ Exception -> 0x00aa, all -> 0x00a6 }
        r2 = r12.getLastPathSegment();	 Catch:{ Exception -> 0x00aa, all -> 0x00a6 }
        r4.append(r2);	 Catch:{ Exception -> 0x00aa, all -> 0x00a6 }
        r2 = r4.toString();	 Catch:{ Exception -> 0x00aa, all -> 0x00a6 }
        r4 = r2;
        r2 = r0;
        goto L_0x00a0;
    L_0x0071:
        r4 = r11.getContentResolver();	 Catch:{ Exception -> 0x00aa, all -> 0x00a6 }
        r2 = 1;
        r6 = new java.lang.String[r2];	 Catch:{ Exception -> 0x00aa, all -> 0x00a6 }
        r2 = "_display_name";
        r6[r3] = r2;	 Catch:{ Exception -> 0x00aa, all -> 0x00a6 }
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r5 = r12;
        r2 = r4.query(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x00aa, all -> 0x00a6 }
        if (r2 == 0) goto L_0x009f;
    L_0x0086:
        r4 = r2.moveToFirst();	 Catch:{ Exception -> 0x009a, all -> 0x0097 }
        if (r4 == 0) goto L_0x009f;
    L_0x008c:
        r4 = "_display_name";
        r4 = r2.getColumnIndex(r4);	 Catch:{ Exception -> 0x009a, all -> 0x0097 }
        r4 = r2.getString(r4);	 Catch:{ Exception -> 0x009a, all -> 0x0097 }
        goto L_0x00a0;
    L_0x0097:
        r11 = move-exception;
        goto L_0x014c;
    L_0x009a:
        r4 = move-exception;
        r10 = r4;
        r4 = r2;
        r2 = r10;
        goto L_0x00ac;
    L_0x009f:
        r4 = r0;
    L_0x00a0:
        if (r2 == 0) goto L_0x00bb;
    L_0x00a2:
        r2.close();	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        goto L_0x00bb;
    L_0x00a6:
        r11 = move-exception;
        r2 = r0;
        goto L_0x014c;
    L_0x00aa:
        r2 = move-exception;
        r4 = r0;
    L_0x00ac:
        r5 = "weibo sdk rename";
        r2 = r2.toString();	 Catch:{ all -> 0x014a }
        android.util.Log.v(r5, r2);	 Catch:{ all -> 0x014a }
        if (r4 == 0) goto L_0x00ba;
    L_0x00b7:
        r4.close();	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
    L_0x00ba:
        r4 = r0;
    L_0x00bb:
        r2 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        if (r2 == 0) goto L_0x00df;
    L_0x00c1:
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        r2.<init>();	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        r4 = java.util.Calendar.getInstance();	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        r4 = r4.getTimeInMillis();	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        r2.append(r4);	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        if (r13 != 0) goto L_0x00d6;
    L_0x00d3:
        r13 = "_sdk_temp.mp4";
        goto L_0x00d8;
    L_0x00d6:
        r13 = "_sdk_temp.jpg";
    L_0x00d8:
        r2.append(r13);	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        r4 = r2.toString();	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
    L_0x00df:
        r11 = r11.getContentResolver();	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        r13 = "r";
        r11 = r11.openFileDescriptor(r12, r13);	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        r11 = r11.getFileDescriptor();	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        r12 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        r13 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        r13.<init>(r11);	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        r12.<init>(r13);	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
        r11 = new java.io.File;	 Catch:{ Exception -> 0x0147, all -> 0x0144 }
        r13 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0147, all -> 0x0144 }
        r13.<init>();	 Catch:{ Exception -> 0x0147, all -> 0x0144 }
        r2 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ Exception -> 0x0147, all -> 0x0144 }
        r2 = r2.getAbsolutePath();	 Catch:{ Exception -> 0x0147, all -> 0x0144 }
        r13.append(r2);	 Catch:{ Exception -> 0x0147, all -> 0x0144 }
        r13.append(r1);	 Catch:{ Exception -> 0x0147, all -> 0x0144 }
        r13.append(r4);	 Catch:{ Exception -> 0x0147, all -> 0x0144 }
        r13 = r13.toString();	 Catch:{ Exception -> 0x0147, all -> 0x0144 }
        r11.<init>(r13);	 Catch:{ Exception -> 0x0147, all -> 0x0144 }
        r13 = r11.exists();	 Catch:{ Exception -> 0x0147, all -> 0x0144 }
        if (r13 == 0) goto L_0x011f;
    L_0x011c:
        r11.delete();	 Catch:{ Exception -> 0x0147, all -> 0x0144 }
    L_0x011f:
        r13 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0147, all -> 0x0144 }
        r13.<init>(r11);	 Catch:{ Exception -> 0x0147, all -> 0x0144 }
        r1 = 1444; // 0x5a4 float:2.023E-42 double:7.134E-321;
        r1 = new byte[r1];	 Catch:{ Exception -> 0x0142 }
    L_0x0128:
        r2 = r12.read(r1);	 Catch:{ Exception -> 0x0142 }
        r4 = -1;
        if (r2 == r4) goto L_0x0133;
    L_0x012f:
        r13.write(r1, r3, r2);	 Catch:{ Exception -> 0x0142 }
        goto L_0x0128;
    L_0x0133:
        r11 = r11.getPath();	 Catch:{ Exception -> 0x0142 }
        if (r12 == 0) goto L_0x013c;
    L_0x0139:
        r12.close();	 Catch:{ Exception -> 0x0141 }
    L_0x013c:
        if (r13 == 0) goto L_0x0141;
    L_0x013e:
        r13.close();	 Catch:{ Exception -> 0x0141 }
    L_0x0141:
        return r11;
    L_0x0142:
        r11 = move-exception;
        goto L_0x0158;
    L_0x0144:
        r11 = move-exception;
        r13 = r0;
        goto L_0x016d;
    L_0x0147:
        r11 = move-exception;
        r13 = r0;
        goto L_0x0158;
    L_0x014a:
        r11 = move-exception;
        r2 = r4;
    L_0x014c:
        if (r2 == 0) goto L_0x0151;
    L_0x014e:
        r2.close();	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
    L_0x0151:
        throw r11;	 Catch:{ Exception -> 0x0155, all -> 0x0152 }
    L_0x0152:
        r11 = move-exception;
        r13 = r0;
        goto L_0x016e;
    L_0x0155:
        r11 = move-exception;
        r12 = r0;
        r13 = r12;
    L_0x0158:
        r1 = "weibo sdk copy";
        r11 = r11.toString();	 Catch:{ all -> 0x016c }
        android.util.Log.v(r1, r11);	 Catch:{ all -> 0x016c }
        if (r12 == 0) goto L_0x0166;
    L_0x0163:
        r12.close();	 Catch:{ Exception -> 0x016b }
    L_0x0166:
        if (r13 == 0) goto L_0x016b;
    L_0x0168:
        r13.close();	 Catch:{ Exception -> 0x016b }
    L_0x016b:
        return r0;
    L_0x016c:
        r11 = move-exception;
    L_0x016d:
        r0 = r12;
    L_0x016e:
        if (r0 == 0) goto L_0x0173;
    L_0x0170:
        r0.close();	 Catch:{ Exception -> 0x0178 }
    L_0x0173:
        if (r13 == 0) goto L_0x0178;
    L_0x0175:
        r13.close();	 Catch:{ Exception -> 0x0178 }
    L_0x0178:
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.ImageUtils.copyFileToWeiboTem(android.content.Context, android.net.Uri, int):java.lang.String");
    }

    private static void delete(File file) {
        if (file != null && file.exists() && !file.delete()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(file.getAbsolutePath());
            stringBuilder.append(" doesn't be deleted!");
            throw new RuntimeException(stringBuilder.toString());
        }
    }

    private static boolean deleteDependon(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file != null) {
            int i = 1;
            while (!z && i <= 5 && file.isFile() && file.exists()) {
                z = file.delete();
                if (!z) {
                    i++;
                }
            }
        }
        return z;
    }

    @TargetApi(10)
    public static long getVideoDuring(String str) {
        if (!new File(str).exists()) {
            return 0;
        }
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            return Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
        } catch (Exception unused) {
            return 0;
        }
    }

    private static boolean isFileExisted(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file != null && file.exists();
    }

    private static boolean isParentExist(File file) {
        if (file == null) {
            return false;
        }
        File parentFile = file.getParentFile();
        return (parentFile == null || parentFile.exists()) ? false : file.exists() || file.mkdirs();
    }

    public static boolean isWifi(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    private static void makesureFileExist(String str) {
        if (str != null) {
            File file = new File(str);
            if (!(file == null || file.exists() || !isParentExist(file))) {
                if (file.exists()) {
                    delete(file);
                }
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void revitionImageSize(String str, int i, int i2) throws IOException {
        if (i <= 0) {
            throw new IllegalArgumentException("size must be greater than 0!");
        } else if (!isFileExisted(str)) {
            if (str == null) {
                str = "null";
            }
            throw new FileNotFoundException(str);
        } else if (BitmapHelper.verifyBitmap(str)) {
            FileInputStream fileInputStream = new FileInputStream(str);
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(fileInputStream, null, options);
            try {
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int i3 = 0;
            while (true) {
                if ((options.outWidth >> i3) <= i && (options.outHeight >> i3) <= i) {
                    break;
                }
                i3++;
            }
            options.inSampleSize = (int) Math.pow(2.0d, (double) i3);
            options.inJustDecodeBounds = false;
            Bitmap safeDecodeBimtapFile = safeDecodeBimtapFile(str, options);
            if (safeDecodeBimtapFile == null) {
                throw new IOException("Bitmap decode error!");
            }
            deleteDependon(str);
            makesureFileExist(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            if (options == null || options.outMimeType == null || !options.outMimeType.contains("png")) {
                safeDecodeBimtapFile.compress(CompressFormat.JPEG, i2, fileOutputStream);
            } else {
                safeDecodeBimtapFile.compress(CompressFormat.PNG, i2, fileOutputStream);
            }
            try {
                fileOutputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            safeDecodeBimtapFile.recycle();
        } else {
            throw new IOException("");
        }
    }

    private static void revitionImageSizeHD(String str, int i, int i2) throws IOException {
        if (i <= 0) {
            throw new IllegalArgumentException("size must be greater than 0!");
        } else if (!isFileExisted(str)) {
            if (str == null) {
                str = "null";
            }
            throw new FileNotFoundException(str);
        } else if (BitmapHelper.verifyBitmap(str)) {
            int i3 = 2 * i;
            FileInputStream fileInputStream = new FileInputStream(str);
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(fileInputStream, null, options);
            try {
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int i4 = 0;
            while (true) {
                if ((options.outWidth >> i4) <= i3 && (options.outHeight >> i4) <= i3) {
                    break;
                }
                i4++;
            }
            options.inSampleSize = (int) Math.pow(2.0d, (double) i4);
            options.inJustDecodeBounds = false;
            Bitmap safeDecodeBimtapFile = safeDecodeBimtapFile(str, options);
            if (safeDecodeBimtapFile == null) {
                throw new IOException("Bitmap decode error!");
            }
            deleteDependon(str);
            makesureFileExist(str);
            float width = ((float) i) / ((float) (safeDecodeBimtapFile.getWidth() > safeDecodeBimtapFile.getHeight() ? safeDecodeBimtapFile.getWidth() : safeDecodeBimtapFile.getHeight()));
            if (width < 1.0f) {
                Bitmap createBitmap;
                while (true) {
                    try {
                        createBitmap = Bitmap.createBitmap((int) (((float) safeDecodeBimtapFile.getWidth()) * width), (int) (((float) safeDecodeBimtapFile.getHeight()) * width), Config.ARGB_8888);
                        break;
                    } catch (OutOfMemoryError unused) {
                        System.gc();
                        width = (float) (((double) width) * 0.8d);
                    }
                }
                if (createBitmap == null) {
                    safeDecodeBimtapFile.recycle();
                }
                Canvas canvas = new Canvas(createBitmap);
                Matrix matrix = new Matrix();
                matrix.setScale(width, width);
                canvas.drawBitmap(safeDecodeBimtapFile, matrix, new Paint());
                safeDecodeBimtapFile.recycle();
                safeDecodeBimtapFile = createBitmap;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            if (options == null || options.outMimeType == null || !options.outMimeType.contains("png")) {
                safeDecodeBimtapFile.compress(CompressFormat.JPEG, i2, fileOutputStream);
            } else {
                safeDecodeBimtapFile.compress(CompressFormat.PNG, i2, fileOutputStream);
            }
            try {
                fileOutputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            safeDecodeBimtapFile.recycle();
        } else {
            throw new IOException("");
        }
    }

    public static boolean revitionPostImageSize(Context context, String str) {
        try {
            if (NetworkHelper.isWifiValid(context)) {
                revitionImageSizeHD(str, SecExceptionCode.SEC_ERROR_SAFETOKEN, 75);
            } else {
                revitionImageSize(str, 1024, 75);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:? A:{SYNTHETIC, Splitter:B:6:0x0013, ExcHandler: FileNotFoundException (unused java.io.FileNotFoundException)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:22:0x0030, code skipped:
            r5 = move-exception;
     */
    /* JADX WARNING: Missing block: B:23:0x0031, code skipped:
            r6 = r5;
            r5 = r3;
            r3 = r6;
     */
    /* JADX WARNING: Missing block: B:36:?, code skipped:
            return r3;
     */
    private static android.graphics.Bitmap safeDecodeBimtapFile(java.lang.String r7, android.graphics.BitmapFactory.Options r8) {
        /*
        if (r8 != 0) goto L_0x000b;
    L_0x0002:
        r0 = new android.graphics.BitmapFactory$Options;
        r0.<init>();
        r1 = 1;
        r0.inSampleSize = r1;
        goto L_0x000c;
    L_0x000b:
        r0 = r8;
    L_0x000c:
        r1 = 0;
        r2 = 0;
        r3 = r2;
        r4 = r3;
    L_0x0010:
        r5 = 5;
        if (r1 >= r5) goto L_0x0049;
    L_0x0013:
        r5 = new java.io.FileInputStream;	 Catch:{ OutOfMemoryError -> 0x0030, FileNotFoundException -> 0x0049 }
        r5.<init>(r7);	 Catch:{ OutOfMemoryError -> 0x0030, FileNotFoundException -> 0x0049 }
        r4 = android.graphics.BitmapFactory.decodeStream(r5, r2, r8);	 Catch:{ OutOfMemoryError -> 0x002a, FileNotFoundException -> 0x0049 }
        r5.close();	 Catch:{ IOException -> 0x0024 }
        goto L_0x0028;
    L_0x0020:
        r3 = move-exception;
        r6 = r5;
        r5 = r4;
        goto L_0x002e;
    L_0x0024:
        r3 = move-exception;
        r3.printStackTrace();	 Catch:{ OutOfMemoryError -> 0x0020, FileNotFoundException -> 0x0028 }
    L_0x0028:
        r3 = r4;
        goto L_0x0049;
    L_0x002a:
        r4 = move-exception;
        r6 = r5;
        r5 = r3;
        r3 = r4;
    L_0x002e:
        r4 = r6;
        goto L_0x0034;
    L_0x0030:
        r5 = move-exception;
        r6 = r5;
        r5 = r3;
        r3 = r6;
    L_0x0034:
        r3.printStackTrace();
        r3 = r0.inSampleSize;
        r3 = r3 * 2;
        r0.inSampleSize = r3;
        r4.close();	 Catch:{ IOException -> 0x0041 }
        goto L_0x0045;
    L_0x0041:
        r3 = move-exception;
        r3.printStackTrace();
    L_0x0045:
        r1 = r1 + 1;
        r3 = r5;
        goto L_0x0010;
    L_0x0049:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.ImageUtils.safeDecodeBimtapFile(java.lang.String, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }
}
