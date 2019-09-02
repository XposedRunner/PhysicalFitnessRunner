package com.qiyukf.nimlib.i;

import android.util.SparseArray;
import com.qiyukf.nimlib.sdk.msg.attachment.LocationAttachment;
import com.qiyukf.nimlib.sdk.msg.attachment.MsgAttachmentParser;
import com.qiyukf.nimlib.sdk.msg.attachment.VideoAttachment;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import com.qiyukf.unicorn.api.msg.attachment.AudioAttachment;
import com.qiyukf.unicorn.api.msg.attachment.FileAttachment;
import com.qiyukf.unicorn.api.msg.attachment.ImageAttachment;
import com.qiyukf.unicorn.api.msg.attachment.MsgAttachment;

public final class e {
    private SparseArray<MsgAttachmentParser> a = new SparseArray();

    private static class a implements MsgAttachmentParser {
        private int a;

        a(int i) {
            this.a = i;
        }

        public final MsgAttachment parse(String str) {
            int i = this.a;
            if (i == 6) {
                return new FileAttachment(str);
            }
            switch (i) {
                case 1:
                    return new ImageAttachment(str);
                case 2:
                    return new AudioAttachment(str);
                case 3:
                    return new VideoAttachment(str);
                case 4:
                    return new LocationAttachment(str);
                default:
                    return null;
            }
        }
    }

    public e() {
        a(MsgTypeEnum.image.getValue());
        a(MsgTypeEnum.audio.getValue());
        a(MsgTypeEnum.video.getValue());
        a(MsgTypeEnum.location.getValue());
        a(MsgTypeEnum.file.getValue());
    }

    private void a(int i) {
        a(i, new a(i));
    }

    public final MsgAttachment a(int i, String str) {
        MsgAttachmentParser msgAttachmentParser;
        synchronized (this.a) {
            msgAttachmentParser = (MsgAttachmentParser) this.a.get(i);
        }
        if (msgAttachmentParser != null) {
            try {
                return msgAttachmentParser.parse(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public final void a(int i, MsgAttachmentParser msgAttachmentParser) {
        synchronized (this.a) {
            this.a.put(i, msgAttachmentParser);
        }
    }
}
