package com.sina.weibo.sdk.api;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class StoryMessage implements Parcelable {
    public static final Creator<StoryMessage> CREATOR = new Creator<StoryMessage>() {
        public StoryMessage createFromParcel(Parcel parcel) {
            return new StoryMessage(parcel);
        }

        public StoryMessage[] newArray(int i) {
            return new StoryMessage[i];
        }
    };
    private Uri imageUri;
    private Uri videoUri;

    protected StoryMessage(Parcel parcel) {
        this.imageUri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.videoUri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
    }

    public boolean checkSource() {
        return (this.imageUri == null || this.videoUri == null) ? (this.imageUri == null && this.videoUri == null) ? false : true : false;
    }

    public int describeContents() {
        return 0;
    }

    public Uri getImageUri() {
        return this.imageUri;
    }

    public Uri getVideoUri() {
        return this.videoUri;
    }

    public void setImageUri(Uri uri) {
        this.imageUri = uri;
    }

    public void setVideoUri(Uri uri) {
        this.videoUri = uri;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.imageUri, i);
        parcel.writeParcelable(this.videoUri, i);
    }
}
