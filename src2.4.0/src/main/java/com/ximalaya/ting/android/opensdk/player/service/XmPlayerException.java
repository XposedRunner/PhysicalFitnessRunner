package com.ximalaya.ting.android.opensdk.player.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public class XmPlayerException extends Exception implements Parcelable {
    public static final Creator<XmPlayerException> CREATOR = new Creator<XmPlayerException>() {
        public XmPlayerException createFromParcel(Parcel parcel) {
            return new XmPlayerException(parcel);
        }

        public XmPlayerException[] newArray(int i) {
            return new XmPlayerException[i];
        }
    };
    private static final long serialVersionUID = 8102305468025663148L;
    private String mCause;
    private int mExtra;
    private int mWhat;

    public XmPlayerException() {
        this("");
    }

    public XmPlayerException(int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Player Status Exception, what = ");
        stringBuilder.append(i);
        stringBuilder.append(", extra = ");
        stringBuilder.append(i2);
        this(stringBuilder.toString());
        this.mWhat = i;
        this.mExtra = i2;
    }

    public XmPlayerException(Parcel parcel) {
        this(parcel.readString());
        this.mWhat = parcel.readInt();
        this.mExtra = parcel.readInt();
    }

    public XmPlayerException(String str) {
        super(str);
        this.mCause = str;
    }

    public int describeContents() {
        return 0;
    }

    public String getMessage() {
        return !TextUtils.isEmpty(this.mCause) ? this.mCause : super.getMessage();
    }

    public void readFromParcel(Parcel parcel) {
        this.mCause = parcel.readString();
        this.mWhat = parcel.readInt();
        this.mExtra = parcel.readInt();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("XmPlayerException{mWhat=");
        stringBuilder.append(this.mWhat);
        stringBuilder.append(", mExtra=");
        stringBuilder.append(this.mExtra);
        stringBuilder.append(", mCause='");
        stringBuilder.append(this.mCause);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mCause);
        parcel.writeInt(this.mWhat);
        parcel.writeInt(this.mExtra);
    }
}
