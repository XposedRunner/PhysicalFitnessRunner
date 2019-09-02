package com.zjwh.android_wh_physicalfitness.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import com.ximalaya.ting.android.player.XMediaPlayerConstants;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.UCrop.Options;
import com.zjwh.android_wh_physicalfitness.R;
import defpackage.O00Oo;
import defpackage.ce;
import defpackage.db;
import defpackage.gg;
import defpackage.la;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

/* compiled from: PictureUtils */
public class O00O0O0o {
    public static final String O000000o = "pl.aprilapps.easyphotopicker.photo_uri";
    public static final String O00000Oo = "pl.aprilapps.easyphotopicker.last_photo";
    private static final String O00000o = "pl.aprilapps.folder_name";
    private static final String O00000o0 = "pl.aprilapps.easyphotopicker.type";
    private static final String O00000oO = "pl.aprilapps.folder_location";
    private static final String O00000oo = "pl.aprilapps.public_temp";
    private static String O0000O0o = "EasyImage";
    private static String O0000OOo = "Temp";
    private static boolean O0000Oo0;

    public static float O000000o(String str) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        return decodeFile != null ? (((float) decodeFile.getHeight()) * 1.0f) / ((float) decodeFile.getWidth()) : -1.0f;
    }

    private static Intent O000000o(Context context, File file) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        try {
            Uri O00000Oo = O00000Oo(context, file);
            O000000o(context, intent, O00000Oo);
            intent.putExtra("output", O00000Oo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return intent;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
    public static android.graphics.Bitmap O000000o(android.app.Activity r8, android.net.Uri r9) throws java.io.FileNotFoundException, java.io.IOException {
        /*
        r0 = r8.getContentResolver();
        r0 = r0.openInputStream(r9);
        r1 = new android.graphics.BitmapFactory$Options;
        r1.<init>();
        r2 = 1;
        r1.inJustDecodeBounds = r2;
        r1.inDither = r2;
        r3 = android.graphics.Bitmap.Config.ARGB_8888;
        r1.inPreferredConfig = r3;
        r3 = 0;
        android.graphics.BitmapFactory.decodeStream(r0, r3, r1);
        r0.close();
        r0 = r1.outWidth;
        r1 = r1.outHeight;
        r4 = -1;
        if (r0 == r4) goto L_0x0064;
    L_0x0024:
        if (r1 != r4) goto L_0x0027;
    L_0x0026:
        goto L_0x0064;
    L_0x0027:
        r4 = 1145569280; // 0x44480000 float:800.0 double:5.65986426E-315;
        r5 = 1139802112; // 0x43f00000 float:480.0 double:5.631370666E-315;
        if (r0 <= r1) goto L_0x0035;
    L_0x002d:
        r6 = (float) r0;
        r7 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r7 <= 0) goto L_0x0035;
    L_0x0032:
        r6 = r6 / r5;
        r0 = (int) r6;
        goto L_0x0040;
    L_0x0035:
        if (r0 >= r1) goto L_0x003f;
    L_0x0037:
        r0 = (float) r1;
        r1 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r1 <= 0) goto L_0x003f;
    L_0x003c:
        r0 = r0 / r4;
        r0 = (int) r0;
        goto L_0x0040;
    L_0x003f:
        r0 = r2;
    L_0x0040:
        if (r0 > 0) goto L_0x0043;
    L_0x0042:
        r0 = r2;
    L_0x0043:
        r1 = new android.graphics.BitmapFactory$Options;
        r1.<init>();
        r1.inSampleSize = r0;
        r1.inDither = r2;
        r0 = android.graphics.Bitmap.Config.ARGB_8888;
        r1.inPreferredConfig = r0;
        r8 = r8.getContentResolver();
        r8 = r8.openInputStream(r9);
        r9 = android.graphics.BitmapFactory.decodeStream(r8, r3, r1);
        r8.close();
        r8 = O000000o(r9);
        return r8;
    L_0x0064:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zjwh.android_wh_physicalfitness.utils.O00O0O0o.O000000o(android.app.Activity, android.net.Uri):android.graphics.Bitmap");
    }

    public static Bitmap O000000o(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
        int i = 100;
        while (byteArrayOutputStream.toByteArray().length / XMediaPlayerConstants.SEND_BUFFER_QUEUE_SIZE_FOR_LIVE > 100) {
            byteArrayOutputStream.reset();
            bitmap.compress(CompressFormat.JPEG, i, byteArrayOutputStream);
            i -= 10;
        }
        return BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), null, null);
    }

    public static UCrop O000000o(@NonNull UCrop uCrop) {
        Options options = new Options();
        options.setCompressionFormat(CompressFormat.JPEG);
        options.setCropGridColumnCount(0);
        options.setCropGridRowCount(0);
        options.setToolbarColor(-16777216);
        options.setStatusBarColor(-16777216);
        options.setCompressionQuality(100);
        options.setHideBottomControls(true);
        options.setFreeStyleCropEnabled(false);
        options.setAllowedGestures(1, 1, 1);
        return uCrop.withOptions(options);
    }

    public static UCrop O000000o(@NonNull UCrop uCrop, int i, int i2) {
        return (i <= 0 || i2 <= 0) ? uCrop : uCrop.withAspectRatio((float) i, (float) i2);
    }

    static File O000000o(Context context, Uri uri) throws IOException {
        InputStream openInputStream = context.getContentResolver().openInputStream(uri);
        File O0000Oo = O0000Oo(context);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(UUID.randomUUID().toString());
        stringBuilder.append(".");
        stringBuilder.append(O00000oO(context, uri));
        File file = new File(O0000Oo, stringBuilder.toString());
        file.createNewFile();
        O000000o(openInputStream, file);
        return file;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0039  */
    public static java.lang.String O000000o(android.content.Context r7, android.net.Uri r8, java.lang.String r9, java.lang.String[] r10) {
        /*
        r0 = 1;
        r3 = new java.lang.String[r0];
        r0 = "_data";
        r1 = 0;
        r3[r1] = r0;
        r0 = 0;
        r1 = r7.getContentResolver();	 Catch:{ all -> 0x0035 }
        r6 = 0;
        r2 = r8;
        r4 = r9;
        r5 = r10;
        r7 = r1.query(r2, r3, r4, r5, r6);	 Catch:{ all -> 0x0035 }
        if (r7 == 0) goto L_0x002f;
    L_0x0017:
        r8 = r7.moveToFirst();	 Catch:{ all -> 0x002d }
        if (r8 == 0) goto L_0x002f;
    L_0x001d:
        r8 = "_data";
        r8 = r7.getColumnIndexOrThrow(r8);	 Catch:{ all -> 0x002d }
        r8 = r7.getString(r8);	 Catch:{ all -> 0x002d }
        if (r7 == 0) goto L_0x002c;
    L_0x0029:
        r7.close();
    L_0x002c:
        return r8;
    L_0x002d:
        r8 = move-exception;
        goto L_0x0037;
    L_0x002f:
        if (r7 == 0) goto L_0x0034;
    L_0x0031:
        r7.close();
    L_0x0034:
        return r0;
    L_0x0035:
        r8 = move-exception;
        r7 = r0;
    L_0x0037:
        if (r7 == 0) goto L_0x003c;
    L_0x0039:
        r7.close();
    L_0x003c:
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zjwh.android_wh_physicalfitness.utils.O00O0O0o.O000000o(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static void O000000o(Context context) {
        Intent intent = new Intent();
        try {
            if (VERSION.SDK_INT < 19) {
                intent.setAction("android.intent.action.GET_CONTENT");
            } else {
                intent.setAction("android.intent.action.OPEN_DOCUMENT");
            }
            intent.setDataAndType(Media.EXTERNAL_CONTENT_URI, "image/*");
            ((Activity) context).startActivityForResult(intent, 0);
        } catch (Exception e) {
            e.printStackTrace();
            O00Oo00.O000000o(context, (int) R.string.query_choose_picture_error);
        }
    }

    public static void O000000o(Context context, int i, int i2) {
        try {
            String string = PreferenceManager.getDefaultSharedPreferences(context).getString(O000000o, null);
            if (!TextUtils.isEmpty(string)) {
                O00000Oo(context, Uri.parse(string));
            }
            string = context.getApplicationContext().getPackageName();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(".fileprovider");
            Uri uriForFile = FileProvider.getUriForFile(context, stringBuilder.toString(), O00000oO(context));
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", uriForFile));
            O000000o(context, uriForFile, i, i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void O000000o(Context context, Intent intent) {
        try {
            Uri data = intent.getData();
            if (data != null) {
                String O00000oo = O00000oo(context, data);
                if (!TextUtils.isEmpty(O00000oo)) {
                    data = Uri.parse(Media.insertImage(context.getContentResolver(), new File(O00000oo).getAbsolutePath(), null, null));
                    if (data != null) {
                        O00000o0(context, data);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void O000000o(Context context, Intent intent, Uri uri) {
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 65536)) {
            context.grantUriPermission(resolveInfo.activityInfo.packageName, uri, 3);
        }
    }

    public static void O000000o(Context context, @NonNull Uri uri, int i, int i2) {
        O000000o(O000000o(UCrop.of(uri, Uri.fromFile(new File(context.getCacheDir(), "CropImage.jpg"))), i, i2)).start((Activity) context);
    }

    public static void O000000o(Context context, String str, ImageView imageView, int i) {
        int i2 = R.drawable.default_round_male;
        if (i == 0) {
            i2 = R.drawable.default_round_female;
        }
        try {
            O00Oo.O00000o0(context).O000000o(str).O0000O0o(i2).O00000oO(i2).O000000o(new la(context)).O000000o(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void O000000o(Context context, List<String> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    String str = (String) list.get(0);
                    if (!TextUtils.isEmpty(str)) {
                        Uri parse = Uri.parse(Media.insertImage(context.getContentResolver(), new File(str).getAbsolutePath(), null, null));
                        if (parse != null) {
                            O00000o0(context, parse);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void O000000o(Context context, List<String> list, int i, int i2) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    String str = (String) list.get(0);
                    if (!TextUtils.isEmpty(str)) {
                        File file = new File(str);
                        str = context.getApplicationContext().getPackageName();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append(".fileprovider");
                        Uri uriForFile = FileProvider.getUriForFile(context, stringBuilder.toString(), O000000o(context, Uri.fromFile(file)));
                        if (uriForFile != null) {
                            O000000o(context, uriForFile, i, i2);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void O000000o(Fragment fragment, Context context) {
        try {
            File O0000Ooo = O0000Ooo(context);
            Intent O000000o = O000000o(context, O0000Ooo);
            if (O000000o.resolveActivity(context.getPackageManager()) == null) {
                O00Oo00.O000000o(context, (int) R.string.query_camera_error);
            } else if (!O0000Ooo.exists()) {
                O00Oo00.O000000o(context, (int) R.string.msg_not_found_storage_card);
            } else if (context.getPackageManager().resolveActivity(O000000o, 65536) == null) {
                O00Oo00.O000000o(context, (int) R.string.query_camera_error);
            } else if (fragment != null) {
                fragment.startActivityForResult(O000000o, 1);
            } else {
                ((Activity) context).startActivityForResult(O000000o, 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void O000000o(InputStream inputStream, File file) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[XMediaPlayerConstants.SEND_BUFFER_QUEUE_SIZE_FOR_LIVE];
            while (true) {
                int read = inputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.close();
                    inputStream.close();
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void O000000o(boolean z) {
        O0000Oo0 = z;
    }

    private static boolean O000000o() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static boolean O000000o(Bitmap bitmap, String str) {
        if (bitmap == null) {
            return false;
        }
        File file = new File(gg.O00000o);
        try {
            if (!file.exists()) {
                file.mkdirs();
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
                if (bitmap != null) {
                    bitmap.compress(CompressFormat.JPEG, 100, fileOutputStream);
                }
                try {
                    fileOutputStream.flush();
                    try {
                        fileOutputStream.close();
                        if (bitmap != null) {
                            bitmap.recycle();
                        }
                        return true;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return false;
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return false;
                }
            } catch (FileNotFoundException e3) {
                e3.printStackTrace();
                return false;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static boolean O000000o(Uri uri) {
        return ce.O0000oO0.equals(uri.getAuthority());
    }

    private static int O00000Oo(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                attributeInt = 180;
            } else if (attributeInt == 6) {
                attributeInt = 90;
            } else if (attributeInt != 8) {
                return 0;
            } else {
                attributeInt = 270;
            }
            return attributeInt;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static Uri O00000Oo(Context context, File file) throws IOException {
        String packageName = context.getApplicationContext().getPackageName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(packageName);
        stringBuilder.append(".fileprovider");
        Uri uriForFile = FileProvider.getUriForFile(context, stringBuilder.toString(), file);
        Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(O000000o, uriForFile.toString());
        edit.putString(O00000Oo, file.toString());
        edit.commit();
        return uriForFile;
    }

    public static void O00000Oo(Context context) {
        O000000o(null, context);
    }

    public static void O00000Oo(Context context, Uri uri) {
        context.revokeUriPermission(uri, 3);
    }

    public static void O00000Oo(Context context, List<String> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    String str = (String) list.get(0);
                    if (!TextUtils.isEmpty(str)) {
                        Uri fromFile = Uri.fromFile(new File(str));
                        if (fromFile != null) {
                            O00000o(context, fromFile);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean O00000Oo(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    static File O00000o(Context context) {
        File file = new File(new File(O0000OOo(context), O0000Oo0(context)), O0000OOo);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static void O00000o(Context context, @NonNull Uri uri) {
        O000000o(O000000o(UCrop.of(uri, Uri.fromFile(new File(context.getCacheDir(), "CropImage.jpg"))), 1, 1)).start((Activity) context);
    }

    public static boolean O00000o(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    static File O00000o0(Context context) {
        return context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
    }

    public static void O00000o0(Context context, Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        if (O0000Oo0) {
            intent.putExtra("aspectX", 16);
            intent.putExtra("aspectY", 10);
            intent.putExtra("outputX", 960);
            intent.putExtra("outputY", 600);
        } else {
            intent.putExtra("aspectX", 1);
            intent.putExtra("aspectY", 1);
            intent.putExtra("outputX", 160);
            intent.putExtra("outputY", 160);
        }
        File file = new File(gg.O00000o);
        if (!file.exists()) {
            file.mkdirs();
        }
        intent.putExtra("output", Uri.fromFile(new File(file, gg.O00000oo)));
        intent.putExtra("outputFormat", CompressFormat.JPEG.toString());
        intent.putExtra("scale", true);
        intent.putExtra("scaleUpIfNeeded", true);
        ((Activity) context).startActivityForResult(intent, 2);
    }

    public static boolean O00000o0(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    @Nullable
    public static File O00000oO(Context context) throws IOException, URISyntaxException {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString(O00000Oo, null);
        return string != null ? new File(string) : null;
    }

    private static String O00000oO(Context context, Uri uri) {
        return uri.getScheme().equals("content") ? MimeTypeMap.getSingleton().getExtensionFromMimeType(context.getContentResolver().getType(uri)) : MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(uri.getPath())).toString());
    }

    private static boolean O00000oO(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    @SuppressLint({"NewApi"})
    private static String O00000oo(Context context, Uri uri) {
        Uri uri2 = null;
        if (VERSION.SDK_INT >= 19) {
            if (O00000oO(uri)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(split[0])) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(Environment.getExternalStorageDirectory());
                    stringBuilder.append("/");
                    stringBuilder.append(split[1]);
                    return stringBuilder.toString();
                }
            } else if (O00000o0(uri)) {
                return O000000o(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
            } else if (O00000o(uri)) {
                Object obj = DocumentsContract.getDocumentId(uri).split(":")[0];
                if (db.O000Ooo.equals(obj)) {
                    uri2 = Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(obj)) {
                    uri2 = Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(obj)) {
                    uri2 = Audio.Media.EXTERNAL_CONTENT_URI;
                }
                return O000000o(context, uri2, "_id=?", new String[]{r11[1]});
            } else if (O000000o(uri)) {
                Cursor managedQuery = ((Activity) context).managedQuery(uri, new String[]{"_data"}, null, null, null);
                int columnIndexOrThrow = managedQuery.getColumnIndexOrThrow("_data");
                managedQuery.moveToFirst();
                return managedQuery.getString(columnIndexOrThrow);
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            return O00000Oo(uri) ? uri.getLastPathSegment() : O000000o(context, uri, null, null);
        } else {
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    public static void O00000oo(Context context) {
        try {
            String string = PreferenceManager.getDefaultSharedPreferences(context).getString(O000000o, null);
            if (!TextUtils.isEmpty(string)) {
                O00000Oo(context, Uri.parse(string));
            }
            string = context.getApplicationContext().getPackageName();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(".fileprovider");
            Uri uriForFile = FileProvider.getUriForFile(context, stringBuilder.toString(), O00000oO(context));
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", uriForFile));
            O00000o(context, uriForFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String O0000O0o(Context context) {
        try {
            File file = new File(gg.O00000o);
            if (!file.exists()) {
                file.mkdirs();
            }
            Bitmap decodeStream = BitmapFactory.decodeStream(context.getContentResolver().openInputStream(Uri.fromFile(new File(file, gg.O00000oo))));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(gg.O00000o);
            stringBuilder.append(System.currentTimeMillis());
            stringBuilder.append(gg.O00000oo);
            String stringBuilder2 = stringBuilder.toString();
            return O000000o(decodeStream, stringBuilder2) ? stringBuilder2 : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String O0000OOo(Context context) {
        File O00000o0 = O00000o0(context);
        return PreferenceManager.getDefaultSharedPreferences(context).getString(O00000oO, O00000o0 != null ? O00000o0.getPath() : null);
    }

    private static File O0000Oo(Context context) {
        File O00000o = PreferenceManager.getDefaultSharedPreferences(context).getBoolean(O00000oo, false) ? O00000o(context) : O0000OoO(context);
        if (!O00000o.exists()) {
            O00000o.mkdirs();
        }
        return O00000o;
    }

    private static String O0000Oo0(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(O00000o, O0000O0o);
    }

    private static File O0000OoO(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), O0000Oo0(context));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File O0000Ooo(Context context) throws IOException {
        File cacheDir = context.getCacheDir();
        if (O000000o()) {
            cacheDir = context.getExternalCacheDir();
        }
        File file = new File(cacheDir, O0000O0o);
        if (!file.exists()) {
            file.mkdirs();
        }
        return File.createTempFile(UUID.randomUUID().toString(), ".jpg", file);
    }
}
