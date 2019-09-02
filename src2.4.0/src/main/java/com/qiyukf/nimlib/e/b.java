package com.qiyukf.nimlib.e;

import com.qiyukf.nimlib.i.a;
import com.qiyukf.nimlib.i.h;
import com.qiyukf.nimlib.sdk.msg.MsgServiceObserve;
import com.qiyukf.nimlib.sdk.msg.SystemMessageObserver;
import com.qiyukf.nimlib.sdk.msg.model.AttachmentProgress;
import com.qiyukf.nimlib.sdk.msg.model.CustomNotification;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.nimlib.sdk.msg.model.RecentContact;
import java.util.ArrayList;
import java.util.List;

public final class b {
    public static void a(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(SystemMessageObserver.class.getSimpleName());
        stringBuilder.append("/observeUnreadCountChange");
        a.a(stringBuilder.toString(), Integer.valueOf(i));
    }

    public static void a(CustomNotification customNotification) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MsgServiceObserve.class.getSimpleName());
        stringBuilder.append("/observeCustomNotification");
        a.a(stringBuilder.toString(), customNotification);
    }

    public static void a(IMMessage iMMessage) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MsgServiceObserve.class.getSimpleName());
        stringBuilder.append("/observeMsgStatus");
        a.a(stringBuilder.toString(), iMMessage);
    }

    public static void a(RecentContact recentContact) {
        if (recentContact != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(recentContact);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(MsgServiceObserve.class.getSimpleName());
            stringBuilder.append("/observeRecentContact");
            a.a(stringBuilder.toString(), arrayList);
        }
    }

    public static void a(String str, long j, long j2) {
        AttachmentProgress attachmentProgress = new AttachmentProgress(str, j, j2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MsgServiceObserve.class.getSimpleName());
        stringBuilder.append("/observeAttachmentProgress");
        a.a(stringBuilder.toString(), attachmentProgress);
    }

    public static void a(List<a> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MsgServiceObserve.class.getSimpleName());
        stringBuilder.append("/observeReceiveMessage");
        a.a(stringBuilder.toString(), list);
    }

    public static void b(RecentContact recentContact) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MsgServiceObserve.class.getSimpleName());
        stringBuilder.append("/observeRecentContactDeleted");
        a.a(stringBuilder.toString(), recentContact);
    }

    public static void b(List<h> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MsgServiceObserve.class.getSimpleName());
        stringBuilder.append("/observeRecentContact");
        a.a(stringBuilder.toString(), list);
    }
}
