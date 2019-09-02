package com.ximalaya.ting.android.player;

import android.content.Context;
import android.os.Environment;
import java.io.File;

public class XMediaPlayerConstants {
    public static String APP_BASE_DIR = null;
    public static String CACHE_BASE_DIR = null;
    public static final int CON_TIME_OUT = 20000;
    public static final int DEFAULT_CHUNK_SIZE = 65536;
    public static int DOWNLOAD_QUEUE_SIZE = 30;
    public static String FILE_PLAY_CACHE_INFO = "playcache.info";
    public static final int HTTP_REQUEST_TYPE_DOWNLOAD = 0;
    public static final int HTTP_REQUEST_TYPE_HEAD = 1;
    public static final int HTTP_REQUEST_TYPE_HTTPFLV = 3;
    public static final int HTTP_REQUEST_TYPE_M3U8 = 2;
    public static final int HTTP_REQUEST_TYPE_M3U8_TS = 4;
    public static String INCOM_AUDIO_FILE_DIRECTORY = null;
    public static String INCOM_AUDIO_FILE_PLAY_CACHE_INFO = null;
    public static final String IS_CHARGE = "is_charge";
    public static final int SEND_BUFFER_QUEUE_SIZE = 3;
    public static final int SEND_BUFFER_QUEUE_SIZE_FOR_LIVE = 1024;
    public static final int TIME_OUT = 30000;
    public static final String X2M_SUFFIX = ".x2m";
    public static final String XM_SUFFIX = ".xm";
    public static boolean isDebug;
    public static final boolean isDebugPlayer = false;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Environment.getExternalStorageDirectory().getPath());
        stringBuilder.append("/ting");
        APP_BASE_DIR = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(APP_BASE_DIR);
        stringBuilder.append("/player_caching");
        CACHE_BASE_DIR = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(CACHE_BASE_DIR);
        stringBuilder.append("/audio");
        INCOM_AUDIO_FILE_DIRECTORY = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(INCOM_AUDIO_FILE_DIRECTORY);
        stringBuilder.append(File.separator);
        stringBuilder.append(FILE_PLAY_CACHE_INFO);
        INCOM_AUDIO_FILE_PLAY_CACHE_INFO = stringBuilder.toString();
    }

    public static void resetCacheDir(Context context) {
        if (context != null && context.getExternalFilesDir("") != null) {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(context.getExternalFilesDir(""));
                stringBuilder.append("");
                APP_BASE_DIR = stringBuilder.toString();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(APP_BASE_DIR);
                stringBuilder2.append("/player_caching");
                CACHE_BASE_DIR = stringBuilder2.toString();
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(CACHE_BASE_DIR);
                stringBuilder2.append("/audio");
                INCOM_AUDIO_FILE_DIRECTORY = stringBuilder2.toString();
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(INCOM_AUDIO_FILE_DIRECTORY);
                stringBuilder2.append(File.separator);
                stringBuilder2.append(FILE_PLAY_CACHE_INFO);
                INCOM_AUDIO_FILE_PLAY_CACHE_INFO = stringBuilder2.toString();
                new File(INCOM_AUDIO_FILE_DIRECTORY).mkdirs();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
