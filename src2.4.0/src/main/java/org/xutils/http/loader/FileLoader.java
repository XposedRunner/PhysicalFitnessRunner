package org.xutils.http.loader;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import org.xutils.cache.DiskCacheEntity;
import org.xutils.cache.DiskCacheFile;
import org.xutils.cache.LruDiskCache;
import org.xutils.common.Callback.CancelledException;
import org.xutils.common.util.IOUtil;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.http.request.UriRequest;

public class FileLoader extends Loader<File> {
    private static final int CHECK_SIZE = 512;
    private long contentLength;
    private DiskCacheFile diskCacheFile;
    private boolean isAutoRename;
    private boolean isAutoResume;
    private String responseFileName;
    private String saveFilePath;
    private String tempSaveFilePath;

    private File autoRename(File file) {
        File file2;
        if (this.isAutoRename && file.exists() && !TextUtils.isEmpty(this.responseFileName)) {
            file2 = new File(file.getParent(), this.responseFileName);
            while (file2.exists()) {
                String parent = file.getParent();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(System.currentTimeMillis());
                stringBuilder.append(this.responseFileName);
                file2 = new File(parent, stringBuilder.toString());
            }
            if (file.renameTo(file2)) {
                file = file2;
            }
            return file;
        } else if (this.saveFilePath.equals(this.tempSaveFilePath)) {
            return file;
        } else {
            file2 = new File(this.saveFilePath);
            if (file.renameTo(file2)) {
                file = file2;
            }
            return file;
        }
    }

    private static String getResponseFileName(UriRequest uriRequest) {
        if (uriRequest == null) {
            return null;
        }
        String responseHeader = uriRequest.getResponseHeader("Content-Disposition");
        if (!TextUtils.isEmpty(responseHeader)) {
            int indexOf = responseHeader.indexOf("filename=");
            if (indexOf > 0) {
                indexOf += 9;
                int indexOf2 = responseHeader.indexOf(";", indexOf);
                if (indexOf2 < 0) {
                    indexOf2 = responseHeader.length();
                }
                if (indexOf2 > indexOf) {
                    try {
                        String decode = URLDecoder.decode(responseHeader.substring(indexOf, indexOf2), uriRequest.getParams().getCharset());
                        if (decode.startsWith("\"") && decode.endsWith("\"")) {
                            decode = decode.substring(1, decode.length() - 1);
                        }
                        return decode;
                    } catch (UnsupportedEncodingException e) {
                        LogUtil.e(e.getMessage(), e);
                    }
                }
            }
        }
        return null;
    }

    private void initDiskCacheFile(UriRequest uriRequest) throws Throwable {
        DiskCacheEntity diskCacheEntity = new DiskCacheEntity();
        diskCacheEntity.setKey(uriRequest.getCacheKey());
        this.diskCacheFile = LruDiskCache.getDiskCache(this.params.getCacheDirName()).createDiskCacheFile(diskCacheEntity);
        if (this.diskCacheFile != null) {
            this.saveFilePath = this.diskCacheFile.getAbsolutePath();
            this.tempSaveFilePath = this.saveFilePath;
            this.isAutoRename = false;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create cache file error:");
        stringBuilder.append(uriRequest.getCacheKey());
        throw new IOException(stringBuilder.toString());
    }

    private static boolean isSupportRange(UriRequest uriRequest) {
        boolean z = false;
        if (uriRequest == null) {
            return false;
        }
        String responseHeader = uriRequest.getResponseHeader("Accept-Ranges");
        if (responseHeader != null) {
            return responseHeader.contains("bytes");
        }
        String responseHeader2 = uriRequest.getResponseHeader("Content-Range");
        if (responseHeader2 != null && responseHeader2.contains("bytes")) {
            z = true;
        }
        return z;
    }

    public File load(InputStream inputStream) throws Throwable {
        Closeable fileInputStream;
        Throwable th;
        Throwable th2;
        InputStream inputStream2 = inputStream;
        Closeable closeable = null;
        Closeable bufferedInputStream;
        try {
            OutputStream fileOutputStream;
            File file = new File(this.tempSaveFilePath);
            if (file.isDirectory()) {
                IOUtil.deleteFileOrDir(file);
            }
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (parentFile.exists() || parentFile.mkdirs()) {
                    file.createNewFile();
                }
            }
            long length = file.length();
            if (this.isAutoResume && length > 0) {
                long j = length - 512;
                if (j > 0) {
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (Throwable th22) {
                        th = th22;
                        fileInputStream = null;
                        IOUtil.closeQuietly(fileInputStream);
                        throw th;
                    }
                    try {
                        if (Arrays.equals(IOUtil.readBytes(inputStream2, 0, CHECK_SIZE), IOUtil.readBytes(fileInputStream, j, CHECK_SIZE))) {
                            this.contentLength -= 512;
                            IOUtil.closeQuietly(fileInputStream);
                        } else {
                            IOUtil.closeQuietly(fileInputStream);
                            IOUtil.deleteFileOrDir(file);
                            throw new RuntimeException("need retry");
                        }
                    } catch (Throwable th222) {
                        th = th222;
                        IOUtil.closeQuietly(fileInputStream);
                        throw th;
                    }
                }
                IOUtil.deleteFileOrDir(file);
                throw new RuntimeException("need retry");
            }
            if (this.isAutoResume) {
                fileOutputStream = new FileOutputStream(file, true);
            } else {
                fileOutputStream = new FileOutputStream(file);
                length = 0;
            }
            long j2 = this.contentLength + length;
            bufferedInputStream = new BufferedInputStream(inputStream2);
            try {
                Closeable bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                try {
                    if (this.progressHandler == null || this.progressHandler.updateProgress(j2, length, true)) {
                        byte[] bArr = new byte[4096];
                        long j3 = length;
                        while (true) {
                            int read = bufferedInputStream.read(bArr);
                            if (read == -1) {
                                bufferedOutputStream.flush();
                                if (this.diskCacheFile != null) {
                                    file = this.diskCacheFile.commit();
                                }
                                if (this.progressHandler != null) {
                                    this.progressHandler.updateProgress(j2, j3, true);
                                }
                                IOUtil.closeQuietly(bufferedInputStream);
                                IOUtil.closeQuietly(bufferedOutputStream);
                                return autoRename(file);
                            } else if (file.getParentFile().exists()) {
                                bufferedOutputStream.write(bArr, 0, read);
                                long j4 = j3 + ((long) read);
                                if (this.progressHandler == null || this.progressHandler.updateProgress(j2, j4, false)) {
                                    j3 = j4;
                                } else {
                                    bufferedOutputStream.flush();
                                    throw new CancelledException("download stopped!");
                                }
                            } else {
                                file.getParentFile().mkdirs();
                                throw new IOException("parent be deleted!");
                            }
                        }
                    }
                    throw new CancelledException("download stopped!");
                } catch (Throwable th3) {
                    th222 = th3;
                    closeable = bufferedOutputStream;
                    th = th222;
                    IOUtil.closeQuietly(bufferedInputStream);
                    IOUtil.closeQuietly(closeable);
                    throw th;
                }
            } catch (Throwable th4) {
                th222 = th4;
                th = th222;
                IOUtil.closeQuietly(bufferedInputStream);
                IOUtil.closeQuietly(closeable);
                throw th;
            }
        } catch (Throwable th2222) {
            th = th2222;
            bufferedInputStream = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x01bc A:{Catch:{ all -> 0x01bd }} */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x016d A:{Catch:{ all -> 0x01bd }} */
    public java.io.File load(org.xutils.http.request.UriRequest r11) throws java.lang.Throwable {
        /*
        r10 = this;
        r0 = 0;
        r1 = r10.params;	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
        r1 = r1.getSaveFilePath();	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
        r10.saveFilePath = r1;	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
        r10.diskCacheFile = r0;	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
        r1 = r10.saveFilePath;	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
        if (r1 == 0) goto L_0x0030;
    L_0x0013:
        r1 = r10.progressHandler;	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
        if (r1 == 0) goto L_0x002c;
    L_0x0017:
        r2 = r10.progressHandler;	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
        r3 = 0;
        r5 = 0;
        r7 = 0;
        r1 = r2.updateProgress(r3, r5, r7);	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
        if (r1 != 0) goto L_0x002c;
    L_0x0024:
        r1 = new org.xutils.common.Callback$CancelledException;	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
        r2 = "download stopped!";
        r1.<init>(r2);	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
        throw r1;	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
    L_0x002c:
        r10.initDiskCacheFile(r11);	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
        goto L_0x0045;
    L_0x0030:
        r1 = new java.lang.StringBuilder;	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
        r1.<init>();	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
        r2 = r10.saveFilePath;	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
        r1.append(r2);	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
        r2 = ".tmp";
        r1.append(r2);	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
        r1 = r1.toString();	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
        r10.tempSaveFilePath = r1;	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
    L_0x0045:
        r1 = r10.progressHandler;	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
        if (r1 == 0) goto L_0x005e;
    L_0x0049:
        r2 = r10.progressHandler;	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
        r3 = 0;
        r5 = 0;
        r7 = 0;
        r1 = r2.updateProgress(r3, r5, r7);	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
        if (r1 != 0) goto L_0x005e;
    L_0x0056:
        r1 = new org.xutils.common.Callback$CancelledException;	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
        r2 = "download stopped!";
        r1.<init>(r2);	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
        throw r1;	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
    L_0x005e:
        r1 = new java.lang.StringBuilder;	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
        r1.<init>();	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
        r2 = r10.saveFilePath;	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
        r1.append(r2);	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
        r2 = "_lock";
        r1.append(r2);	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
        r1 = r1.toString();	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
        r2 = 1;
        r1 = org.xutils.common.util.ProcessLock.tryLock(r1, r2);	 Catch:{ HttpException -> 0x0161, all -> 0x015e }
        if (r1 == 0) goto L_0x0145;
    L_0x0078:
        r0 = r1.isValid();	 Catch:{ HttpException -> 0x0143 }
        if (r0 != 0) goto L_0x0080;
    L_0x007e:
        goto L_0x0145;
    L_0x0080:
        r0 = r11.getParams();	 Catch:{ HttpException -> 0x0143 }
        r10.params = r0;	 Catch:{ HttpException -> 0x0143 }
        r0 = r10.isAutoResume;	 Catch:{ HttpException -> 0x0143 }
        r2 = 0;
        if (r0 == 0) goto L_0x00a3;
    L_0x008c:
        r0 = new java.io.File;	 Catch:{ HttpException -> 0x0143 }
        r4 = r10.tempSaveFilePath;	 Catch:{ HttpException -> 0x0143 }
        r0.<init>(r4);	 Catch:{ HttpException -> 0x0143 }
        r4 = r0.length();	 Catch:{ HttpException -> 0x0143 }
        r6 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
        r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r8 > 0) goto L_0x00a1;
    L_0x009d:
        org.xutils.common.util.IOUtil.deleteFileOrDir(r0);	 Catch:{ HttpException -> 0x0143 }
        goto L_0x00a3;
    L_0x00a1:
        r2 = r4 - r6;
    L_0x00a3:
        r0 = r10.params;	 Catch:{ HttpException -> 0x0143 }
        r4 = "RANGE";
        r5 = new java.lang.StringBuilder;	 Catch:{ HttpException -> 0x0143 }
        r5.<init>();	 Catch:{ HttpException -> 0x0143 }
        r6 = "bytes=";
        r5.append(r6);	 Catch:{ HttpException -> 0x0143 }
        r5.append(r2);	 Catch:{ HttpException -> 0x0143 }
        r2 = "-";
        r5.append(r2);	 Catch:{ HttpException -> 0x0143 }
        r2 = r5.toString();	 Catch:{ HttpException -> 0x0143 }
        r0.setHeader(r4, r2);	 Catch:{ HttpException -> 0x0143 }
        r0 = r10.progressHandler;	 Catch:{ HttpException -> 0x0143 }
        if (r0 == 0) goto L_0x00d9;
    L_0x00c4:
        r2 = r10.progressHandler;	 Catch:{ HttpException -> 0x0143 }
        r3 = 0;
        r5 = 0;
        r7 = 0;
        r0 = r2.updateProgress(r3, r5, r7);	 Catch:{ HttpException -> 0x0143 }
        if (r0 != 0) goto L_0x00d9;
    L_0x00d1:
        r0 = new org.xutils.common.Callback$CancelledException;	 Catch:{ HttpException -> 0x0143 }
        r2 = "download stopped!";
        r0.<init>(r2);	 Catch:{ HttpException -> 0x0143 }
        throw r0;	 Catch:{ HttpException -> 0x0143 }
    L_0x00d9:
        r11.sendRequest();	 Catch:{ HttpException -> 0x0143 }
        r2 = r11.getContentLength();	 Catch:{ HttpException -> 0x0143 }
        r10.contentLength = r2;	 Catch:{ HttpException -> 0x0143 }
        r0 = r10.isAutoRename;	 Catch:{ HttpException -> 0x0143 }
        if (r0 == 0) goto L_0x00ec;
    L_0x00e6:
        r0 = getResponseFileName(r11);	 Catch:{ HttpException -> 0x0143 }
        r10.responseFileName = r0;	 Catch:{ HttpException -> 0x0143 }
    L_0x00ec:
        r0 = r10.isAutoResume;	 Catch:{ HttpException -> 0x0143 }
        if (r0 == 0) goto L_0x00f6;
    L_0x00f0:
        r0 = isSupportRange(r11);	 Catch:{ HttpException -> 0x0143 }
        r10.isAutoResume = r0;	 Catch:{ HttpException -> 0x0143 }
    L_0x00f6:
        r0 = r10.progressHandler;	 Catch:{ HttpException -> 0x0143 }
        if (r0 == 0) goto L_0x010f;
    L_0x00fa:
        r2 = r10.progressHandler;	 Catch:{ HttpException -> 0x0143 }
        r3 = 0;
        r5 = 0;
        r7 = 0;
        r0 = r2.updateProgress(r3, r5, r7);	 Catch:{ HttpException -> 0x0143 }
        if (r0 != 0) goto L_0x010f;
    L_0x0107:
        r0 = new org.xutils.common.Callback$CancelledException;	 Catch:{ HttpException -> 0x0143 }
        r2 = "download stopped!";
        r0.<init>(r2);	 Catch:{ HttpException -> 0x0143 }
        throw r0;	 Catch:{ HttpException -> 0x0143 }
    L_0x010f:
        r0 = r10.diskCacheFile;	 Catch:{ HttpException -> 0x0143 }
        if (r0 == 0) goto L_0x013a;
    L_0x0113:
        r0 = r10.diskCacheFile;	 Catch:{ HttpException -> 0x0143 }
        r0 = r0.getCacheEntity();	 Catch:{ HttpException -> 0x0143 }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ HttpException -> 0x0143 }
        r0.setLastAccess(r2);	 Catch:{ HttpException -> 0x0143 }
        r2 = r11.getETag();	 Catch:{ HttpException -> 0x0143 }
        r0.setEtag(r2);	 Catch:{ HttpException -> 0x0143 }
        r2 = r11.getExpiration();	 Catch:{ HttpException -> 0x0143 }
        r0.setExpires(r2);	 Catch:{ HttpException -> 0x0143 }
        r2 = new java.util.Date;	 Catch:{ HttpException -> 0x0143 }
        r3 = r11.getLastModified();	 Catch:{ HttpException -> 0x0143 }
        r2.<init>(r3);	 Catch:{ HttpException -> 0x0143 }
        r0.setLastModify(r2);	 Catch:{ HttpException -> 0x0143 }
    L_0x013a:
        r0 = r11.getInputStream();	 Catch:{ HttpException -> 0x0143 }
        r0 = r10.load(r0);	 Catch:{ HttpException -> 0x0143 }
        goto L_0x0195;
    L_0x0143:
        r0 = move-exception;
        goto L_0x0165;
    L_0x0145:
        r0 = new org.xutils.ex.FileLockedException;	 Catch:{ HttpException -> 0x0143 }
        r2 = new java.lang.StringBuilder;	 Catch:{ HttpException -> 0x0143 }
        r2.<init>();	 Catch:{ HttpException -> 0x0143 }
        r3 = "download exists: ";
        r2.append(r3);	 Catch:{ HttpException -> 0x0143 }
        r3 = r10.saveFilePath;	 Catch:{ HttpException -> 0x0143 }
        r2.append(r3);	 Catch:{ HttpException -> 0x0143 }
        r2 = r2.toString();	 Catch:{ HttpException -> 0x0143 }
        r0.<init>(r2);	 Catch:{ HttpException -> 0x0143 }
        throw r0;	 Catch:{ HttpException -> 0x0143 }
    L_0x015e:
        r11 = move-exception;
        r1 = r0;
        goto L_0x01be;
    L_0x0161:
        r1 = move-exception;
        r9 = r1;
        r1 = r0;
        r0 = r9;
    L_0x0165:
        r2 = r0.getCode();	 Catch:{ all -> 0x01bd }
        r3 = 416; // 0x1a0 float:5.83E-43 double:2.055E-321;
        if (r2 != r3) goto L_0x01bc;
    L_0x016d:
        r0 = r10.diskCacheFile;	 Catch:{ all -> 0x01bd }
        if (r0 == 0) goto L_0x0178;
    L_0x0171:
        r0 = r10.diskCacheFile;	 Catch:{ all -> 0x01bd }
        r0 = r0.commit();	 Catch:{ all -> 0x01bd }
        goto L_0x017f;
    L_0x0178:
        r0 = new java.io.File;	 Catch:{ all -> 0x01bd }
        r2 = r10.tempSaveFilePath;	 Catch:{ all -> 0x01bd }
        r0.<init>(r2);	 Catch:{ all -> 0x01bd }
    L_0x017f:
        if (r0 == 0) goto L_0x019e;
    L_0x0181:
        r2 = r0.exists();	 Catch:{ all -> 0x01bd }
        if (r2 == 0) goto L_0x019e;
    L_0x0187:
        r2 = r10.isAutoRename;	 Catch:{ all -> 0x01bd }
        if (r2 == 0) goto L_0x0191;
    L_0x018b:
        r11 = getResponseFileName(r11);	 Catch:{ all -> 0x01bd }
        r10.responseFileName = r11;	 Catch:{ all -> 0x01bd }
    L_0x0191:
        r0 = r10.autoRename(r0);	 Catch:{ all -> 0x01bd }
    L_0x0195:
        org.xutils.common.util.IOUtil.closeQuietly(r1);
        r11 = r10.diskCacheFile;
        org.xutils.common.util.IOUtil.closeQuietly(r11);
        return r0;
    L_0x019e:
        org.xutils.common.util.IOUtil.deleteFileOrDir(r0);	 Catch:{ all -> 0x01bd }
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x01bd }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01bd }
        r2.<init>();	 Catch:{ all -> 0x01bd }
        r3 = "cache file not found";
        r2.append(r3);	 Catch:{ all -> 0x01bd }
        r11 = r11.getCacheKey();	 Catch:{ all -> 0x01bd }
        r2.append(r11);	 Catch:{ all -> 0x01bd }
        r11 = r2.toString();	 Catch:{ all -> 0x01bd }
        r0.<init>(r11);	 Catch:{ all -> 0x01bd }
        throw r0;	 Catch:{ all -> 0x01bd }
    L_0x01bc:
        throw r0;	 Catch:{ all -> 0x01bd }
    L_0x01bd:
        r11 = move-exception;
    L_0x01be:
        org.xutils.common.util.IOUtil.closeQuietly(r1);
        r0 = r10.diskCacheFile;
        org.xutils.common.util.IOUtil.closeQuietly(r0);
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xutils.http.loader.FileLoader.load(org.xutils.http.request.UriRequest):java.io.File");
    }

    public File loadFromCache(DiskCacheEntity diskCacheEntity) throws Throwable {
        return LruDiskCache.getDiskCache(this.params.getCacheDirName()).getDiskCacheFile(diskCacheEntity.getKey());
    }

    public Loader<File> newInstance() {
        return new FileLoader();
    }

    public void save2Cache(UriRequest uriRequest) {
    }

    public void setParams(RequestParams requestParams) {
        if (requestParams != null) {
            this.params = requestParams;
            this.isAutoResume = requestParams.isAutoResume();
            this.isAutoRename = requestParams.isAutoRename();
        }
    }
}
