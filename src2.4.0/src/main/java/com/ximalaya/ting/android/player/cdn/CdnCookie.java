package com.ximalaya.ting.android.player.cdn;

import java.util.HashMap;

public class CdnCookie {
    public String doMain;
    public HashMap<String, String> map;
    public String path;

    public String getDoMain() {
        return this.doMain;
    }

    public HashMap<String, String> getMap() {
        return this.map;
    }

    public String getPath() {
        return this.path;
    }

    public void setDoMain(String str) {
        this.doMain = str;
    }

    public void setMap(HashMap<String, String> hashMap) {
        this.map = hashMap;
    }

    public void setPath(String str) {
        this.path = str;
    }
}
