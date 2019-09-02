package com.umeng.socialize.media;

import android.text.TextUtils;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.umeng.socialize.Config;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.utils.O0000Oo0;
import com.ximalaya.ting.android.player.XMediaPlayerConstants;

/* compiled from: WeiXinShareContent */
public class O000O00o extends O00000o {
    public O000O00o(ShareContent shareContent) {
        super(shareContent);
    }

    private WXMediaMessage O00000Oo() {
        O0000Oo0 O00000oO = O00000oO();
        String str = "";
        if (!(O00000oO == null || O00000oO.O0000OoO() == null)) {
            str = O00000oO.O0000OoO().toString();
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = str;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = O00000o0((O000000o) O00000oO);
        return wXMediaMessage;
    }

    private WXMediaMessage O00000o0() {
        O00oOooO O0000o0o = O0000o0o();
        WXMusicObject wXMusicObject = new WXMusicObject();
        wXMusicObject.musicUrl = O00000Oo(O0000o0o);
        wXMusicObject.musicDataUrl = O0000o0o.O00000o0();
        if (!TextUtils.isEmpty(O0000o0o.O0000o0O())) {
            wXMusicObject.musicLowBandDataUrl = O0000o0o.O0000o0O();
        }
        if (!TextUtils.isEmpty(O0000o0o.O0000Ooo())) {
            wXMusicObject.musicLowBandUrl = O0000o0o.O0000Ooo();
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXMusicObject;
        wXMediaMessage.title = O000000o((O000000o) O0000o0o);
        wXMediaMessage.description = O00000Oo((O000000o) O0000o0o);
        wXMediaMessage.mediaObject = wXMusicObject;
        wXMediaMessage.thumbData = O00000o0((O000000o) O0000o0o);
        return wXMediaMessage;
    }

    private WXMediaMessage O0000oO() {
        O0000o00 O0000Ooo = O0000Ooo();
        WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
        wXMiniProgramObject.webpageUrl = O0000Ooo.O00000o0();
        wXMiniProgramObject.userName = O0000Ooo.O0000Oo();
        wXMiniProgramObject.path = O0000Ooo.O0000OoO();
        wXMiniProgramObject.miniprogramType = Config.getMINITYPE();
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = O000000o((O000000o) O0000Ooo);
        wXMediaMessage.description = O00000Oo((O000000o) O0000Ooo);
        wXMediaMessage.thumbData = O00000o((O000000o) O0000Ooo);
        wXMediaMessage.mediaObject = wXMiniProgramObject;
        return wXMediaMessage;
    }

    private WXMediaMessage O0000oO0() {
        WXFileObject wXFileObject = new WXFileObject();
        wXFileObject.fileData = O0000Oo0.O000000o(O00000o());
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXFileObject;
        wXMediaMessage.description = O0000o00();
        wXMediaMessage.title = O0000O0o();
        return wXMediaMessage;
    }

    private WXMediaMessage O0000oOO() {
        WXTextObject wXTextObject = new WXTextObject();
        wXTextObject.text = O00000Oo(O0000o00());
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXTextObject;
        wXMediaMessage.description = O000000o(O0000o00(), XMediaPlayerConstants.SEND_BUFFER_QUEUE_SIZE_FOR_LIVE);
        return wXMediaMessage;
    }

    private WXMediaMessage O0000oOo() {
        O0000Oo O0000o0 = O0000o0();
        WXImageObject wXImageObject = new WXImageObject();
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXImageObject.imageData = O0000o0.O0000o00();
        if (O00000oo(O0000o0)) {
            wXImageObject.imagePath = O0000o0.O0000OoO().toString();
            wXImageObject.imageData = null;
        } else {
            wXImageObject.imageData = O00000o(O0000o0);
        }
        wXMediaMessage.thumbData = O00000Oo(O0000o0);
        wXMediaMessage.mediaObject = wXImageObject;
        return wXMediaMessage;
    }

    private WXMediaMessage O0000oo() {
        O0000o O0000OoO = O0000OoO();
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = O0000OoO.O00000o0();
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = O000000o((O000000o) O0000OoO);
        wXMediaMessage.description = O00000Oo((O000000o) O0000OoO);
        wXMediaMessage.mediaObject = wXWebpageObject;
        wXMediaMessage.thumbData = O00000o0((O000000o) O0000OoO);
        return wXMediaMessage;
    }

    private WXMediaMessage O0000oo0() {
        O0000o0 O0000o = O0000o();
        WXVideoObject wXVideoObject = new WXVideoObject();
        wXVideoObject.videoUrl = O0000o.O00000o0();
        if (!TextUtils.isEmpty(O0000o.O0000OoO())) {
            wXVideoObject.videoLowBandUrl = O0000o.O0000OoO();
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXVideoObject;
        wXMediaMessage.title = O000000o((O000000o) O0000o);
        wXMediaMessage.description = O00000Oo((O000000o) O0000o);
        wXMediaMessage.thumbData = O00000o0((O000000o) O0000o);
        return wXMediaMessage;
    }

    public WXMediaMessage O000000o() {
        return (O0000Oo() == 2 || O0000Oo() == 3) ? O0000oOo() : O0000Oo() == 4 ? O00000o0() : O0000Oo() == 16 ? O0000oo() : O0000Oo() == 8 ? O0000oo0() : O0000Oo() == 64 ? O00000Oo() : O0000Oo() == 32 ? O0000oO0() : O0000Oo() == 128 ? O0000oO() : O0000oOO();
    }
}
