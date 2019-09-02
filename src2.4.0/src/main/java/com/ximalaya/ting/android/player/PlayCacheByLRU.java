package com.ximalaya.ting.android.player;

import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import org.json.JSONObject;

public class PlayCacheByLRU {
    public static int PLAY_CACHE_NUM = 5;
    private static PlayCacheByLRU mInstance;
    private volatile LinkedHashMap<String, String> playUrlLruCache;

    private PlayCacheByLRU() {
    }

    public static synchronized PlayCacheByLRU getInstance() {
        PlayCacheByLRU playCacheByLRU;
        synchronized (PlayCacheByLRU.class) {
            if (mInstance == null) {
                mInstance = new PlayCacheByLRU();
            }
            playCacheByLRU = mInstance;
        }
        return playCacheByLRU;
    }

    public static void release() {
        if (mInstance != null) {
            mInstance.removeAllNoAtLRU();
            mInstance = null;
        }
    }

    public synchronized void init() {
        if (this.playUrlLruCache == null) {
            this.playUrlLruCache = new LinkedHashMap<String, String>(PLAY_CACHE_NUM, 0.75f, true) {
                /* Access modifiers changed, original: protected */
                public boolean removeEldestEntry(Entry<String, String> entry) {
                    if (size() <= PlayCacheByLRU.PLAY_CACHE_NUM) {
                        return false;
                    }
                    PlayerUtil.cleanCacheByMD5SoundPlay((String) entry.getKey());
                    return true;
                }
            };
            try {
                JSONObject jSONObject = new JSONObject(PlayerUtil.readStrFromFile(XMediaPlayerConstants.INCOM_AUDIO_FILE_PLAY_CACHE_INFO));
                if (jSONObject != null) {
                    Iterator keys = jSONObject.keys();
                    if (keys != null) {
                        while (keys.hasNext()) {
                            this.playUrlLruCache.put(keys.next(), "");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return;
    }

    public synchronized void putPlayUrl(String str) {
        if (str != null) {
            if (str.startsWith("http")) {
                this.playUrlLruCache.put(MD5.getFileNameMd5(str), "");
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Entry entry : this.playUrlLruCache.entrySet()) {
                        jSONObject.put((String) entry.getKey(), entry.getValue());
                    }
                    PlayerUtil.writeStr2File(jSONObject.toString(), XMediaPlayerConstants.INCOM_AUDIO_FILE_PLAY_CACHE_INFO);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return;
    }

    public synchronized void removeAllExcludeCurPlay(String str) {
        if (this.playUrlLruCache == null) {
            init();
        }
        this.playUrlLruCache.clear();
        putPlayUrl(str);
    }

    public synchronized void removeAllNoAtLRU() {
        try {
            File file = new File(XMediaPlayerConstants.INCOM_AUDIO_FILE_DIRECTORY);
            if (file.exists()) {
                File[] listFiles = file.listFiles(new FilenameFilter() {
                    public boolean accept(File file, String str) {
                        if (XMediaPlayerConstants.FILE_PLAY_CACHE_INFO.equals(str)) {
                            return false;
                        }
                        if (!(PlayCacheByLRU.this.playUrlLruCache == null || TextUtils.isEmpty(str))) {
                            int lastIndexOf = str.lastIndexOf(46);
                            if (lastIndexOf != -1) {
                                return PlayCacheByLRU.this.playUrlLruCache.containsKey(str.substring(0, lastIndexOf)) ^ 1;
                            }
                        }
                        return true;
                    }
                });
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        if (file2 != null) {
                            file2.delete();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }
}
