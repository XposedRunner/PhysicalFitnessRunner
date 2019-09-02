package com.umeng.socialize.media;

import android.net.Uri;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.MultiImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.utils.Utility;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.utils.O00000Oo;
import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000o00.O00oOooO;
import defpackage.cj;
import defpackage.ck;
import defpackage.cl;
import java.io.File;
import java.util.ArrayList;

/* compiled from: SinaShareContent */
public class O0000OOo extends O00000o {
    private boolean O000000o = false;

    public O0000OOo(ShareContent shareContent) {
        super(shareContent);
    }

    private WeiboMultiMessage O000000o(WeiboMultiMessage weiboMultiMessage) {
        if (TextUtils.isEmpty(O0000o00())) {
            TextObject textObject = new TextObject();
            if (!(O00000oo() == null || TextUtils.isEmpty(O00000oo().O000000o()))) {
                textObject.text = O00000oo().O000000o();
            }
            weiboMultiMessage.textObject = textObject;
        } else {
            weiboMultiMessage.textObject = O00000Oo();
        }
        return weiboMultiMessage;
    }

    private TextObject O00000Oo() {
        TextObject textObject = new TextObject();
        textObject.text = O0000o00();
        return textObject;
    }

    private WeiboMultiMessage O00000Oo(WeiboMultiMessage weiboMultiMessage) {
        if (!(O00000oo() == null || O00000oo().O00000o() == null)) {
            ImageObject imageObject = new ImageObject();
            if (O00000oo(O00000oo().O00000o())) {
                imageObject.imagePath = O00000oo().O00000o().O0000OoO().toString();
            } else {
                imageObject.imageData = O00000o0(O00000oo().O00000o());
            }
            weiboMultiMessage.imageObject = imageObject;
        }
        return weiboMultiMessage;
    }

    private TextObject O00000o0() {
        TextObject textObject = new TextObject();
        textObject.text = "default text";
        O0000O0o.O000000o(O00oOooO.O00000o);
        return textObject;
    }

    private MultiImageObject O0000oO() {
        MultiImageObject multiImageObject = new MultiImageObject();
        O0000Oo[] O0000o0O = O0000o0O();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < O0000o0O.length; i++) {
            if (O0000o0O[i] != null) {
                File O0000OoO = O0000o0O[i].O0000OoO();
                if (O0000OoO != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(i);
                    stringBuilder.append(":");
                    stringBuilder.append(Uri.fromFile(O0000OoO));
                    O0000O0o.O000000o(stringBuilder.toString());
                    arrayList.add(Uri.fromFile(O0000OoO));
                }
            }
        }
        multiImageObject.setImageList(arrayList);
        return multiImageObject;
    }

    private ImageObject O0000oO0() {
        ImageObject imageObject = new ImageObject();
        if (O00000oo(O0000o0())) {
            imageObject.imagePath = O0000o0().O0000OoO().toString();
        } else {
            imageObject.imageData = O00000o0(O0000o0());
        }
        imageObject.thumbData = O00000o0((O000000o) O0000o0());
        imageObject.description = O0000o00();
        return imageObject;
    }

    private WebpageObject O0000oOO() {
        ck ckVar = new ck(O00000Oo.O000000o());
        ckVar.O000000o(O0000OoO());
        cj O000000o = cl.O000000o(ckVar);
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = O000000o((O000000o) O0000OoO());
        webpageObject.description = O00000Oo((O000000o) O0000OoO());
        if (O0000OoO().O00000o() != null) {
            webpageObject.thumbData = O00000o0((O000000o) O0000OoO());
        } else {
            O0000O0o.O000000o(O00oOooO.O000000o);
        }
        if (O000000o == null || TextUtils.isEmpty(O000000o.O000000o)) {
            webpageObject.actionUrl = O0000OoO().O00000o0();
        } else {
            webpageObject.actionUrl = O000000o.O000000o;
        }
        webpageObject.defaultText = O0000o00();
        return webpageObject;
    }

    private WebpageObject O0000oOo() {
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = O000000o((O000000o) O0000o0o());
        webpageObject.description = O00000Oo((O000000o) O0000o0o());
        if (O0000o0o().O00000o() != null) {
            webpageObject.thumbData = O00000o0((O000000o) O0000o0o());
        } else {
            O0000O0o.O000000o(O00oOooO.O000000o);
        }
        webpageObject.actionUrl = O0000o0o().O0000Oo();
        if (!TextUtils.isEmpty(O0000o00())) {
            webpageObject.defaultText = O0000o00();
        }
        return webpageObject;
    }

    private WebpageObject O0000oo0() {
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = O000000o((O000000o) O0000o());
        webpageObject.description = O00000Oo((O000000o) O0000o());
        if (O0000o().O00000o() != null) {
            webpageObject.thumbData = O00000o0((O000000o) O0000o());
        } else {
            O0000O0o.O000000o(O00oOooO.O000000o);
        }
        webpageObject.actionUrl = O0000o().O00000o0();
        if (!TextUtils.isEmpty(O0000o().O000000o())) {
            webpageObject.description = O0000o().O000000o();
        }
        webpageObject.defaultText = O0000o00();
        return webpageObject;
    }

    public WeiboMultiMessage O000000o() {
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (O0000Oo() == 2 || O0000Oo() == 3) {
            if (O0000o0O() == null || O0000o0O().length <= 0 || !this.O000000o) {
                weiboMultiMessage.imageObject = O0000oO0();
                if (!TextUtils.isEmpty(O0000o00())) {
                    weiboMultiMessage.textObject = O00000Oo();
                }
            } else {
                weiboMultiMessage.multiImageObject = O0000oO();
                if (TextUtils.isEmpty(O0000o00())) {
                    weiboMultiMessage.textObject = O00000o0();
                } else {
                    weiboMultiMessage.textObject = O00000Oo();
                }
            }
        } else if (O0000Oo() == 16) {
            weiboMultiMessage.mediaObject = O0000oOO();
            O000000o(weiboMultiMessage);
        } else if (O0000Oo() == 4) {
            weiboMultiMessage.mediaObject = O0000oOo();
            O000000o(weiboMultiMessage);
        } else if (O0000Oo() == 8) {
            weiboMultiMessage.mediaObject = O0000oo0();
            O000000o(weiboMultiMessage);
        } else {
            weiboMultiMessage.textObject = O00000Oo();
        }
        return weiboMultiMessage;
    }

    public void O000000o(boolean z) {
        this.O000000o = z;
    }
}
