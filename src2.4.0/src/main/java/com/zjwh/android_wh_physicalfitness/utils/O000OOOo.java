package com.zjwh.android_wh_physicalfitness.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Environment;
import android.text.TextUtils;
import com.ximalaya.ting.android.player.XMediaPlayerConstants;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import defpackage.gj;
import defpackage.gk;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.xutils.common.Callback.Cancelable;

/* compiled from: FileUtils */
public class O000OOOo {
    private static final String O000000o = "IMG_";
    private static final String O00000Oo = ".jpg";
    private static final String O00000o0 = "android.permission.WRITE_EXTERNAL_STORAGE";

    public static File O000000o(Context context) throws IOException {
        File externalStoragePublicDirectory;
        if (TextUtils.equals(Environment.getExternalStorageState(), "mounted")) {
            externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
            if (!externalStoragePublicDirectory.exists()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(Environment.DIRECTORY_DCIM);
                stringBuilder.append("/Camera");
                externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(stringBuilder.toString());
                if (!externalStoragePublicDirectory.exists()) {
                    externalStoragePublicDirectory = O000000o(context, true);
                }
            }
        } else {
            externalStoragePublicDirectory = O000000o(context, true);
        }
        return File.createTempFile(O000000o, O00000Oo, externalStoragePublicDirectory);
    }

    public static File O000000o(Context context, String str) {
        File O00000Oo = O00000Oo(context);
        File file = new File(O00000Oo, str);
        return (file.exists() || file.mkdir()) ? file : O00000Oo;
    }

    public static File O000000o(Context context, boolean z) {
        Object externalStorageState;
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (NullPointerException unused) {
            externalStorageState = "";
        } catch (IncompatibleClassChangeError unused2) {
            externalStorageState = "";
        }
        File O00000o0 = (z && "mounted".equals(externalStorageState) && O00000o(context)) ? O00000o0(context) : null;
        if (O00000o0 == null) {
            O00000o0 = context.getCacheDir();
        }
        if (O00000o0 != null) {
            return O00000o0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getFilesDir().getPath());
        stringBuilder.append(context.getPackageName());
        stringBuilder.append("/cache/");
        return new File(stringBuilder.toString());
    }

    public static String O000000o(Bitmap bitmap) {
        if (bitmap == null) {
            return "";
        }
        if (bitmap.isRecycled()) {
            return "";
        }
        String O000000o = O000O0o0.O000000o("yyyyMMddHHmmss", new Date());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Environment.getExternalStorageDirectory());
        stringBuilder.append("/com/zjwh/images/");
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(O000000o);
        stringBuilder3.append(".jpeg");
        O000000o = stringBuilder3.toString();
        File file = new File(stringBuilder2);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(stringBuilder2, O000000o);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(CompressFormat.JPEG, 100, fileOutputStream);
            try {
                fileOutputStream.flush();
                fileOutputStream.close();
                return file.getAbsolutePath();
            } catch (IOException unused) {
                return "";
            }
        } catch (FileNotFoundException unused2) {
            return "";
        }
    }

    public static Cancelable O000000o(Context context, List<File> list, int i, int i2, MyCallback<String> myCallback) {
        gj gjVar = new gj(gk.O00O0Oo0);
        gjVar.addBodyParameter("uploadBusinessType", String.valueOf(i));
        gjVar.addBodyParameter("uploadFileType", String.valueOf(i2));
        for (File addBodyParameter : list) {
            gjVar.addBodyParameter("uploadFiles", addBodyParameter);
        }
        gjVar.setMultipart(true);
        return HttpUtil.postOp(context, gjVar, myCallback);
    }

    public static void O000000o(File file) {
        if (file.isFile()) {
            file.delete();
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                file.delete();
                return;
            }
            for (File O000000o : listFiles) {
                O000000o(O000000o);
            }
            file.delete();
        }
    }

    public static void O000000o(String str, String str2) throws Exception {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry != null) {
                String name = nextEntry.getName();
                if (nextEntry.isDirectory()) {
                    str = name.substring(0, name.length() - 1);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str2);
                    stringBuilder.append(File.separator);
                    stringBuilder.append(str);
                    new File(stringBuilder.toString()).mkdirs();
                } else {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str2);
                    stringBuilder2.append(File.separator);
                    stringBuilder2.append(name);
                    File file = new File(stringBuilder2.toString());
                    if (!file.exists()) {
                        file.getParentFile().mkdirs();
                        file.createNewFile();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[XMediaPlayerConstants.SEND_BUFFER_QUEUE_SIZE_FOR_LIVE];
                    while (true) {
                        int read = zipInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        fileOutputStream.flush();
                    }
                    fileOutputStream.close();
                }
            } else {
                zipInputStream.close();
                return;
            }
        }
    }

    public static boolean O000000o() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static File O00000Oo(Context context) {
        return O000000o(context, true);
    }

    private static boolean O00000o(Context context) {
        return context.checkCallingOrSelfPermission(O00000o0) == 0;
    }

    private static File O00000o0(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
        if (!file.exists()) {
            if (!file.mkdirs()) {
                return null;
            }
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }
}
