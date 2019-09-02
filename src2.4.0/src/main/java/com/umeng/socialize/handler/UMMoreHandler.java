package com.umeng.socialize.handler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig$Platform;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.media.O0000Oo;
import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000Oo0;
import com.umeng.socialize.utils.O0000o00;
import defpackage.by;

public class UMMoreHandler extends UMSSOHandler {
    private Activity O000000o;

    public void O000000o(Context context, PlatformConfig$Platform platformConfig$Platform) {
        super.O000000o(context, platformConfig$Platform);
        this.O000000o = (Activity) context;
    }

    public boolean O000000o(ShareContent shareContent, UMShareListener uMShareListener) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        if (shareContent.mMedia == null || !(shareContent.mMedia instanceof O0000Oo)) {
            intent.setType("text/plain");
        } else {
            intent.setType("image/*");
            O0000Oo o0000Oo = (O0000Oo) shareContent.mMedia;
            if (o0000Oo.O0000OoO().getPath() != null) {
                intent.putExtra("android.intent.extra.STREAM", O0000Oo0.O00000Oo(O0000o00(), o0000Oo.O0000OoO().getPath()));
            }
        }
        intent.putExtra("android.intent.extra.SUBJECT", shareContent.subject);
        intent.putExtra("android.intent.extra.TEXT", shareContent.mText);
        Intent createChooser = Intent.createChooser(intent, Config.MORE_TITLE);
        createChooser.addFlags(268435456);
        try {
            if (!(this.O000000o == null || this.O000000o.isFinishing())) {
                this.O000000o.startActivity(createChooser);
            }
            uMShareListener.onResult(by.MORE);
        } catch (Exception e) {
            O0000O0o.O000000o(O0000o00.O0000Oo0.O00000Oo, e);
            uMShareListener.onError(by.MORE, e);
        }
        return true;
    }

    public String O00000o0() {
        return this.O00000Oo;
    }

    public void O0000Ooo() {
        super.O0000Ooo();
        this.O000000o = null;
    }
}
