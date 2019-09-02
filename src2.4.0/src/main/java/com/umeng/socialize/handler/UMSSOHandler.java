package com.umeng.socialize.handler;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import com.umeng.socialize.PlatformConfig$Platform;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareConfig;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.utils.O00000Oo;
import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000o00.O00000o0;
import com.umeng.socialize.utils.O0000o00.O0000Oo0;
import com.ximalaya.ting.android.opensdk.auth.constants.XmlyConstants.ClientOSType;
import defpackage.by;
import defpackage.ca;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;

public abstract class UMSSOHandler {
    protected static final String O00000o = "usid";
    protected static final String O00000o0 = "uid";
    protected static final String O00000oO = "unionid";
    protected static final String O00000oo = "openid";
    protected static final String O0000O0o = "accessToken";
    protected static final String O0000OOo = "access_token";
    protected static final String O0000Oo = "refresh_token";
    protected static final String O0000Oo0 = "refreshToken";
    protected static final String O0000OoO = "expiration";
    protected static final String O0000Ooo = "expires_in";
    @Deprecated
    protected static final String O0000o = "screen_name";
    protected static final String O0000o0 = "iconurl";
    protected static final String O0000o00 = "name";
    protected static final String O0000o0O = "gender";
    protected static final String O0000o0o = "region";
    protected static final String O0000oO = "city";
    @Deprecated
    protected static final String O0000oO0 = "profile_image_url";
    protected static final String O0000oOO = "province";
    protected static final String O0000oOo = "country";
    protected static final String O0000oo = "email";
    protected static final String O0000oo0 = "access_secret";
    protected static final String O0000ooO = "id";
    protected static final String O0000ooo = "first_name";
    protected static final String O000O00o = "json";
    private static final UMShareConfig O000O0oO = new UMShareConfig();
    protected static final String O00oOooO = "last_name";
    protected static final String O00oOooo = "middle_name";
    private Context O000000o = null;
    protected String O00000Oo = "";
    protected int O000O0OO = 32768;
    protected WeakReference<Activity> O000O0Oo;
    private boolean O000O0o = false;
    private PlatformConfig$Platform O000O0o0 = null;
    protected UMShareConfig O00oOoOo;

    public Uri O000000o(File file) {
        String absolutePath = file.getAbsolutePath();
        Context applicationContext = this.O000000o.getApplicationContext();
        Cursor query = applicationContext.getContentResolver().query(Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{absolutePath}, null);
        if (query != null && query.moveToFirst()) {
            int i = query.getInt(query.getColumnIndex("_id"));
            Uri parse = Uri.parse("content://media/external/images/media");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(i);
            return Uri.withAppendedPath(parse, stringBuilder.toString());
        } else if (!file.exists()) {
            return null;
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_data", absolutePath);
            return applicationContext.getContentResolver().insert(Media.EXTERNAL_CONTENT_URI, contentValues);
        }
    }

    public UMShareListener O000000o(UMShareListener uMShareListener) {
        return uMShareListener != null ? uMShareListener : new UMShareListener() {
            public void onCancel(by byVar) {
                O0000O0o.O000000o(O00000o0.O0000Oo0);
            }

            public void onError(by byVar, Throwable th) {
                O0000O0o.O000000o(O00000o0.O0000Oo0);
            }

            public void onResult(by byVar) {
                O0000O0o.O000000o(O00000o0.O0000Oo0);
            }

            public void onStart(by byVar) {
            }
        };
    }

    public String O000000o(Object obj) {
        String str = ca.O00000Oo;
        String str2 = ca.O000000o;
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return (obj.equals("m") || obj.equals(ClientOSType.IOS) || obj.equals("男")) ? str : (obj.equals("f") || obj.equals("0") || obj.equals("女")) ? str2 : obj.toString();
        } else {
            if (!(obj instanceof Integer)) {
                return obj.toString();
            }
            Integer num = (Integer) obj;
            return num.intValue() == 1 ? str : num.intValue() == 0 ? str2 : obj.toString();
        }
    }

    public void O000000o(int i, int i2, Intent intent) {
    }

    public void O000000o(Context context, PlatformConfig$Platform platformConfig$Platform) {
        O0000O0o.O000000o("xxxxxx UMSSOHandler 6.9.4");
        this.O000000o = O00000Oo.O000000o();
        this.O000O0o0 = platformConfig$Platform;
        if (context instanceof Activity) {
            this.O000O0Oo = new WeakReference((Activity) context);
        }
        if (!this.O000O0o) {
            String[] strArr = new String[3];
            strArr[0] = O0000Oo0.O00000oO;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(O0000Oo0.O000000o(platformConfig$Platform.getName().O00000Oo()));
            stringBuilder.append(O00000o0());
            strArr[1] = stringBuilder.toString();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(O0000Oo0.O00000o);
            stringBuilder2.append(toString());
            strArr[2] = stringBuilder2.toString();
            O0000O0o.O00000Oo(strArr);
            this.O000O0o = true;
        }
    }

    public void O000000o(UMAuthListener uMAuthListener) {
    }

    public final void O000000o(UMShareConfig uMShareConfig) {
        this.O00oOoOo = uMShareConfig;
    }

    public boolean O000000o() {
        return false;
    }

    public abstract boolean O000000o(ShareContent shareContent, UMShareListener uMShareListener);

    public int O00000Oo() {
        return 0;
    }

    public void O00000Oo(UMAuthListener uMAuthListener) {
    }

    public void O00000o(UMAuthListener uMAuthListener) {
    }

    public abstract String O00000o0();

    public void O00000o0(UMAuthListener uMAuthListener) {
    }

    public UMAuthListener O00000oo(UMAuthListener uMAuthListener) {
        return uMAuthListener != null ? uMAuthListener : new UMAuthListener() {
            public void onCancel(by byVar, int i) {
                O0000O0o.O000000o(O00000o0.O0000Oo0);
            }

            public void onComplete(by byVar, int i, Map<String, String> map) {
                O0000O0o.O000000o(O00000o0.O0000Oo0);
            }

            public void onError(by byVar, int i, Throwable th) {
                O0000O0o.O000000o(O00000o0.O0000Oo0);
            }

            public void onStart(by byVar) {
            }
        };
    }

    public boolean O00000oo() {
        O0000O0o.O000000o(O00000o0.O00000oo);
        return true;
    }

    public boolean O0000O0o() {
        O0000O0o.O000000o(O00000o0.O0000OOo);
        return true;
    }

    public boolean O0000OOo() {
        O0000O0o.O000000o(O00000o0.O0000O0o);
        return true;
    }

    public String O0000Oo0() {
        return "";
    }

    public void O0000Ooo() {
    }

    public PlatformConfig$Platform O0000o0() {
        return this.O000O0o0;
    }

    public Context O0000o00() {
        return this.O000000o;
    }

    /* Access modifiers changed, original: protected|final */
    public final UMShareConfig O0000o0O() {
        return this.O00oOoOo == null ? O000O0oO : this.O00oOoOo;
    }

    public void O0000o0o() {
    }

    public boolean d_() {
        return true;
    }
}
