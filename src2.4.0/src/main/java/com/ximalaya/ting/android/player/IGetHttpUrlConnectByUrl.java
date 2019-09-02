package com.ximalaya.ting.android.player;

import com.ximalaya.ting.android.player.model.HttpConfig;
import java.net.HttpURLConnection;

public interface IGetHttpUrlConnectByUrl {
    HttpURLConnection getHttpUrlConnect(String str, String str2, HttpConfig httpConfig);
}
