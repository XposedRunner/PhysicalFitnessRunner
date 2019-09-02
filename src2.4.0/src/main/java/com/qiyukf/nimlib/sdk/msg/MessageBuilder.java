package com.qiyukf.nimlib.sdk.msg;

import android.text.TextUtils;
import com.qiyukf.basesdk.c.c.d;
import com.qiyukf.nimlib.b;
import com.qiyukf.nimlib.i.a;
import com.qiyukf.nimlib.sdk.msg.attachment.LocationAttachment;
import com.qiyukf.nimlib.sdk.msg.attachment.VideoAttachment;
import com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum;
import com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.CustomMessageConfig;
import com.qiyukf.nimlib.sdk.msg.model.CustomNotification;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import com.qiyukf.unicorn.api.msg.attachment.AudioAttachment;
import com.qiyukf.unicorn.api.msg.attachment.FileAttachment;
import com.qiyukf.unicorn.api.msg.attachment.ImageAttachment;
import com.qiyukf.unicorn.api.msg.attachment.MsgAttachment;
import com.qiyukf.unicorn.f.a.e;
import java.io.File;

public class MessageBuilder {
    public static IMMessage createAudioMessage(String str, SessionTypeEnum sessionTypeEnum, File file, long j, boolean z) {
        a initSendMessage = initSendMessage(str, sessionTypeEnum);
        initSendMessage.a(MsgTypeEnum.audio.getValue());
        AudioAttachment audioAttachment = new AudioAttachment();
        audioAttachment.setPath(file.getPath());
        audioAttachment.setSize(file.length());
        if (j > 0 && j < 1000) {
            j = 1000;
        }
        audioAttachment.setDuration(j);
        audioAttachment.setAutoTransform(z);
        audioAttachment.setExtension(d.a(file.getName()));
        initSendMessage.setAttachment(audioAttachment);
        return initSendMessage;
    }

    public static IMMessage createCustomMessage(String str, SessionTypeEnum sessionTypeEnum, MsgAttachment msgAttachment) {
        return createCustomMessage(str, sessionTypeEnum, null, msgAttachment, null);
    }

    public static IMMessage createCustomMessage(String str, SessionTypeEnum sessionTypeEnum, String str2, MsgAttachment msgAttachment) {
        return createCustomMessage(str, sessionTypeEnum, str2, msgAttachment, null);
    }

    public static IMMessage createCustomMessage(String str, SessionTypeEnum sessionTypeEnum, String str2, MsgAttachment msgAttachment, CustomMessageConfig customMessageConfig) {
        a initSendMessage = initSendMessage(str, sessionTypeEnum);
        initSendMessage.a(MsgTypeEnum.custom.getValue());
        initSendMessage.setContent(str2);
        initSendMessage.setAttachment(msgAttachment);
        initSendMessage.a(customMessageConfig);
        return initSendMessage;
    }

    public static CustomNotification createCustomNotification(e eVar, String str) {
        CustomNotification customNotification = new CustomNotification();
        customNotification.setSessionId(str);
        customNotification.setSessionType(SessionTypeEnum.Ysf);
        customNotification.setFromAccount(b.b());
        customNotification.setAttachment(eVar);
        customNotification.setTime(System.currentTimeMillis());
        return customNotification;
    }

    public static a createCustomReceivedMessage(String str, SessionTypeEnum sessionTypeEnum, MsgAttachment msgAttachment) {
        return createCustomReceivedMessage(str, sessionTypeEnum, null, msgAttachment, 0);
    }

    public static a createCustomReceivedMessage(String str, SessionTypeEnum sessionTypeEnum, String str2, MsgAttachment msgAttachment, long j) {
        a aVar = new a();
        aVar.a(sessionTypeEnum);
        aVar.b(str);
        aVar.setFromAccount(str);
        aVar.setDirect(MsgDirectionEnum.In);
        aVar.setStatus(MsgStatusEnum.success);
        if (TextUtils.isEmpty(str2)) {
            str2 = d.b();
        }
        aVar.a(str2);
        if (j <= 0) {
            j = System.currentTimeMillis();
        }
        aVar.setTime(j);
        aVar.a(MsgTypeEnum.custom.getValue());
        aVar.setAttachment(msgAttachment);
        return aVar;
    }

    public static CustomNotification createCustomReceivedNotification(String str, e eVar, long j) {
        CustomNotification customNotification = new CustomNotification();
        customNotification.setSessionType(SessionTypeEnum.Ysf);
        customNotification.setSessionId(str);
        customNotification.setFromAccount(str);
        customNotification.setAttachment(eVar);
        if (j <= 0) {
            j = System.currentTimeMillis();
        }
        customNotification.setTime(j);
        return customNotification;
    }

    public static IMMessage createEmptyMessage(String str, SessionTypeEnum sessionTypeEnum, long j) {
        a aVar = new a();
        aVar.b(str);
        aVar.a(sessionTypeEnum);
        aVar.setTime(j);
        return aVar;
    }

    public static IMMessage createFileMessage(String str, SessionTypeEnum sessionTypeEnum, File file, String str2) {
        a initSendMessage = initSendMessage(str, sessionTypeEnum);
        initSendMessage.a(MsgTypeEnum.file.getValue());
        FileAttachment fileAttachment = new FileAttachment();
        fileAttachment.setPath(file.getPath());
        fileAttachment.setSize(file.length());
        fileAttachment.setDisplayName(str2);
        fileAttachment.setExtension(d.a(file.getName()));
        initSendMessage.setAttachment(fileAttachment);
        return initSendMessage;
    }

    public static IMMessage createImageMessage(String str, SessionTypeEnum sessionTypeEnum, File file) {
        return createImageMessage(str, sessionTypeEnum, file, null);
    }

    public static IMMessage createImageMessage(String str, SessionTypeEnum sessionTypeEnum, File file, String str2) {
        a initSendMessage = initSendMessage(str, sessionTypeEnum);
        initSendMessage.a(MsgTypeEnum.image.getValue());
        ImageAttachment imageAttachment = new ImageAttachment();
        imageAttachment.setPath(file.getPath());
        imageAttachment.setSize(file.length());
        int[] a = com.qiyukf.nimlib.k.b.a.a(file.getPath());
        imageAttachment.setWidth(a[0]);
        imageAttachment.setHeight(a[1]);
        imageAttachment.setDisplayName(str2);
        imageAttachment.setExtension(d.a(file.getName()));
        initSendMessage.setAttachment(imageAttachment);
        return initSendMessage;
    }

    public static IMMessage createLocationMessage(String str, SessionTypeEnum sessionTypeEnum, double d, double d2, String str2) {
        a initSendMessage = initSendMessage(str, sessionTypeEnum);
        initSendMessage.a(MsgTypeEnum.location.getValue());
        LocationAttachment locationAttachment = new LocationAttachment();
        locationAttachment.setLatitude(d);
        locationAttachment.setLongitude(d2);
        locationAttachment.setAddress(str2);
        initSendMessage.setAttachStatus(AttachStatusEnum.transferred);
        initSendMessage.setAttachment(locationAttachment);
        return initSendMessage;
    }

    public static IMMessage createTextMessage(String str, SessionTypeEnum sessionTypeEnum, String str2) {
        a initSendMessage = initSendMessage(str, sessionTypeEnum);
        initSendMessage.a(MsgTypeEnum.text.getValue());
        initSendMessage.setContent(str2);
        return initSendMessage;
    }

    public static IMMessage createVideoMessage(String str, SessionTypeEnum sessionTypeEnum, File file, long j, int i, int i2, String str2) {
        a initSendMessage = initSendMessage(str, sessionTypeEnum);
        initSendMessage.a(MsgTypeEnum.video.getValue());
        VideoAttachment videoAttachment = new VideoAttachment();
        videoAttachment.setPath(file.getPath());
        videoAttachment.setSize(file.length());
        videoAttachment.setDuration(j);
        videoAttachment.setWidth(i);
        videoAttachment.setHeight(i2);
        videoAttachment.setDisplayName(str2);
        videoAttachment.setExtension(d.a(file.getName()));
        initSendMessage.setAttachment(videoAttachment);
        com.qiyukf.nimlib.k.b.a.a(file.getPath(), videoAttachment.getThumbPathForSave(), i, i2);
        return initSendMessage;
    }

    private static a initSendMessage(String str, SessionTypeEnum sessionTypeEnum) {
        a aVar = new a();
        aVar.a(d.b());
        aVar.b(str);
        aVar.setFromAccount(b.b());
        aVar.setDirect(MsgDirectionEnum.Out);
        aVar.setStatus(MsgStatusEnum.sending);
        aVar.a(sessionTypeEnum);
        aVar.setTime(System.currentTimeMillis());
        return aVar;
    }
}
