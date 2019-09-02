package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class WebpageObject extends BaseMediaObject {
    public static final Creator<WebpageObject> CREATOR = new Creator<WebpageObject>() {
        public WebpageObject createFromParcel(Parcel parcel) {
            return new WebpageObject(parcel);
        }

        public WebpageObject[] newArray(int i) {
            return new WebpageObject[i];
        }
    };
    public static final String EXTRA_KEY_DEFAULTTEXT = "extra_key_defaulttext";
    public String defaultText;

    public WebpageObject(Parcel parcel) {
        super(parcel);
    }

    public boolean checkArgs() {
        return super.checkArgs();
    }

    public int getObjType() {
        return 5;
    }

    /* Access modifiers changed, original: protected */
    public BaseMediaObject toExtraMediaObject(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.defaultText = new JSONObject(str).optString(EXTRA_KEY_DEFAULTTEXT);
            } catch (JSONException unused) {
            }
        }
        return this;
    }

    /* Access modifiers changed, original: protected */
    public String toExtraMediaString() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.defaultText)) {
                jSONObject.put(EXTRA_KEY_DEFAULTTEXT, this.defaultText);
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
