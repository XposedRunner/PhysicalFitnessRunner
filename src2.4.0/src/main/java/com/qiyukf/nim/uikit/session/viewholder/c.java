package com.qiyukf.nim.uikit.session.viewholder;

import com.qiyukf.nimlib.sdk.msg.attachment.NotificationAttachment;
import com.qiyukf.nimlib.sdk.msg.attachment.VideoAttachment;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.api.customization.msg_list.MessageHandlerFactory;
import com.qiyukf.unicorn.api.customization.msg_list.UnicornMessageHandler;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import com.qiyukf.unicorn.api.msg.attachment.AudioAttachment;
import com.qiyukf.unicorn.api.msg.attachment.FileAttachment;
import com.qiyukf.unicorn.api.msg.attachment.ImageAttachment;
import com.qiyukf.unicorn.api.msg.attachment.MsgAttachment;
import java.util.HashMap;

public final class c {
    private static HashMap<Class<? extends MsgAttachment>, Class<? extends b>> a = new HashMap();
    private static HashMap<Class<? extends MsgAttachment>, Class<? extends b>> b = new HashMap();
    private static HashMap<MsgTypeEnum, Class<? extends b>> c = new HashMap();
    private static MessageHandlerFactory d;

    static {
        a(ImageAttachment.class, g.class, false);
        a(AudioAttachment.class, a.class, false);
        a(NotificationAttachment.class, f.class, false);
        a(FileAttachment.class, d.class, false);
        a(VideoAttachment.class, l.class, false);
    }

    public static int a() {
        return a.size() + 3;
    }

    public static Class<? extends b> a(IMMessage iMMessage) {
        HashMap hashMap;
        Object obj;
        if (iMMessage.getMsgType() == MsgTypeEnum.text) {
            if (c.get(MsgTypeEnum.text) == null) {
                return h.class;
            }
            hashMap = c;
            obj = MsgTypeEnum.text;
        } else if (iMMessage.getMsgType() != MsgTypeEnum.tips) {
            Class<? extends b> cls;
            if (iMMessage.getAttachment() != null) {
                obj = iMMessage.getAttachment().getClass();
                cls = null;
                while (cls == null && obj != null) {
                    cls = (Class) b.get(obj);
                    if (cls == null) {
                        cls = (Class) a.get(obj);
                    }
                    if (cls == null) {
                        Class superclass = obj.getSuperclass();
                        if (superclass == null || !MsgAttachment.class.isAssignableFrom(superclass)) {
                            for (Class cls2 : obj.getInterfaces()) {
                                if (MsgAttachment.class.isAssignableFrom(cls2)) {
                                    obj = cls2;
                                    break;
                                }
                            }
                            obj = null;
                        } else {
                            obj = superclass;
                        }
                    }
                }
            } else {
                cls = null;
            }
            if (cls == null) {
                cls = k.class;
            }
            return cls;
        } else if (c.get(MsgTypeEnum.text) == null) {
            return j.class;
        } else {
            hashMap = c;
            obj = MsgTypeEnum.tips;
        }
        return (Class) hashMap.get(obj);
    }

    public static void a(MessageHandlerFactory messageHandlerFactory) {
        d = messageHandlerFactory;
    }

    public static void a(MsgTypeEnum msgTypeEnum, Class<? extends b> cls) {
        c.put(msgTypeEnum, cls);
    }

    @Deprecated
    public static void a(Class<? extends MsgAttachment> cls, Class<? extends b> cls2) {
        a(cls, cls2, false);
    }

    public static void a(Class<? extends MsgAttachment> cls, Class<? extends b> cls2, boolean z) {
        (z ? b : a).put(cls, cls2);
    }

    public static UnicornMessageHandler b(IMMessage iMMessage) {
        return (iMMessage.getAttachment() == null || d == null) ? null : d.handlerOf(iMMessage);
    }
}
