package com.ximalaya.ting.android.opensdk.httputil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.ximalaya.ting.android.player.XMediaPlayerConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Config implements Parcelable {
    public static final Creator<Config> CREATOR = new Creator<Config>() {
        public Config createFromParcel(Parcel parcel) {
            return new Config(parcel);
        }

        public Config[] newArray(int i) {
            return new Config[i];
        }
    };
    public static final String METHOD_GET = "GET";
    public static final String METHOD_HEAD = "HEAD";
    public static final String METHOD_POST = "POST";
    public String authorization;
    public int connectionTimeOut = XMediaPlayerConstants.TIME_OUT;
    public int httpsProxyPort;
    public String method = "GET";
    public Map<String, String> property = new HashMap();
    public String proxyHost;
    public int proxyPort;
    public int proxyType = -1;
    public int readTimeOut = XMediaPlayerConstants.TIME_OUT;
    public boolean useCache = true;
    public boolean useProxy = false;
    public int writeTimeOut = XMediaPlayerConstants.TIME_OUT;

    protected Config(Parcel parcel) {
        readFromParcel(parcel);
    }

    public static Config getDownloadConfig(Config config) {
        if (config == null) {
            config = new Config();
        }
        config.connectionTimeOut = XMediaPlayerConstants.TIME_OUT;
        config.readTimeOut = XMediaPlayerConstants.TIME_OUT;
        return config;
    }

    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        int i = 0;
        boolean z = true;
        this.useProxy = parcel.readByte() != (byte) 0;
        if (parcel.readByte() == (byte) 0) {
            z = false;
        }
        this.useCache = z;
        this.proxyHost = parcel.readString();
        this.proxyPort = parcel.readInt();
        this.httpsProxyPort = parcel.readInt();
        this.authorization = parcel.readString();
        this.connectionTimeOut = parcel.readInt();
        this.readTimeOut = parcel.readInt();
        this.writeTimeOut = parcel.readInt();
        this.method = parcel.readString();
        int readInt = parcel.readInt();
        this.property = new HashMap(readInt);
        while (i < readInt) {
            this.property.put(parcel.readString(), parcel.readString());
            i++;
        }
        this.proxyType = parcel.readInt();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Config{useProxy=");
        stringBuilder.append(this.useProxy);
        stringBuilder.append(", useCache=");
        stringBuilder.append(this.useCache);
        stringBuilder.append(", proxyHost='");
        stringBuilder.append(this.proxyHost);
        stringBuilder.append('\'');
        stringBuilder.append(", proxyPort=");
        stringBuilder.append(this.proxyPort);
        stringBuilder.append(", httpsProxyPort=");
        stringBuilder.append(this.httpsProxyPort);
        stringBuilder.append(", authorization='");
        stringBuilder.append(this.authorization);
        stringBuilder.append('\'');
        stringBuilder.append(", connectionTimeOut=");
        stringBuilder.append(this.connectionTimeOut);
        stringBuilder.append(", readTimeOut=");
        stringBuilder.append(this.readTimeOut);
        stringBuilder.append(", writeTimeOut=");
        stringBuilder.append(this.writeTimeOut);
        stringBuilder.append(", method='");
        stringBuilder.append(this.method);
        stringBuilder.append('\'');
        stringBuilder.append(", property=");
        stringBuilder.append(this.property);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.useProxy);
        parcel.writeByte(this.useCache);
        parcel.writeString(this.proxyHost);
        parcel.writeInt(this.proxyPort);
        parcel.writeInt(this.httpsProxyPort);
        parcel.writeString(this.authorization);
        parcel.writeInt(this.connectionTimeOut);
        parcel.writeInt(this.readTimeOut);
        parcel.writeInt(this.writeTimeOut);
        parcel.writeString(this.method);
        parcel.writeInt(this.property.size());
        for (Entry entry : this.property.entrySet()) {
            parcel.writeString((String) entry.getKey());
            parcel.writeString((String) entry.getValue());
        }
        parcel.writeInt(this.proxyType);
    }
}
