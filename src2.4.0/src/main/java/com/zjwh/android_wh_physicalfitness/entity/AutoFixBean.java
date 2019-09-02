package com.zjwh.android_wh_physicalfitness.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AutoFixBean implements Parcelable {
    public static final Creator<AutoFixBean> CREATOR = new Creator<AutoFixBean>() {
        public AutoFixBean createFromParcel(Parcel parcel) {
            return new AutoFixBean(parcel);
        }

        public AutoFixBean[] newArray(int i) {
            return new AutoFixBean[i];
        }
    };
    private State state;
    private String subTitle;
    private String text;
    private String title;
    private Type type;

    public enum State {
        Loading,
        Normal,
        Error,
        Jump
    }

    public enum Type {
        VIVO_BACKSTAGE_POWER,
        VIVO_AUTO_START,
        XIAOMI_AUTO_START,
        XIAOMI_BATTERY,
        OPPO_AUTO_START,
        OPPO_BACKGROUND_FREEZE,
        MEIZU_AUTO_START,
        MEIZU_BATTERY,
        HUAWEI_AUTO_START,
        HUAWEI_LOCK,
        GPS_PERMISSION,
        GPS_SWITCH,
        NETWORK
    }

    protected AutoFixBean(Parcel parcel) {
        this.title = parcel.readString();
        this.subTitle = parcel.readString();
        this.text = parcel.readString();
        int readInt = parcel.readInt();
        Type type = null;
        this.state = readInt == -1 ? null : State.values()[readInt];
        int readInt2 = parcel.readInt();
        if (readInt2 != -1) {
            type = Type.values()[readInt2];
        }
        this.type = type;
    }

    public AutoFixBean(String str, String str2, State state) {
        this.title = str;
        this.subTitle = str2;
        this.state = state;
    }

    public AutoFixBean(String str, String str2, String str3, State state, Type type) {
        this.title = str;
        this.subTitle = str2;
        this.text = str3;
        this.state = state;
        this.type = type;
    }

    public int describeContents() {
        return 0;
    }

    public State getState() {
        return this.state;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public String getText() {
        return this.text;
    }

    public String getTitle() {
        return this.title;
    }

    public Type getType() {
        return this.type;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setSubTitle(String str) {
        this.subTitle = str;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AutoFixBean{title='");
        stringBuilder.append(this.title);
        stringBuilder.append('\'');
        stringBuilder.append(", subTitle='");
        stringBuilder.append(this.subTitle);
        stringBuilder.append('\'');
        stringBuilder.append(", text='");
        stringBuilder.append(this.text);
        stringBuilder.append('\'');
        stringBuilder.append(", state=");
        stringBuilder.append(this.state);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.subTitle);
        parcel.writeString(this.text);
        int i2 = -1;
        parcel.writeInt(this.state == null ? -1 : this.state.ordinal());
        if (this.type != null) {
            i2 = this.type.ordinal();
        }
        parcel.writeInt(i2);
    }
}
