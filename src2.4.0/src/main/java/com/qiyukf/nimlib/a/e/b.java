package com.qiyukf.nimlib.a.e;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import com.qiyukf.basesdk.b.a.a.d;
import com.qiyukf.nimlib.a.c;
import com.qiyukf.nimlib.e.h;
import com.qiyukf.nimlib.e.i;
import com.qiyukf.nimlib.i.a;
import com.qiyukf.nimlib.i.f;
import com.qiyukf.nimlib.i.g;
import com.qiyukf.nimlib.sdk.AbortableFuture;
import com.qiyukf.nimlib.sdk.InvocationFuture;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.attachment.MsgAttachmentParser;
import com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.CustomNotification;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.nimlib.sdk.msg.model.QueryDirectionEnum;
import com.qiyukf.nimlib.sdk.msg.model.RecentContact;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import com.qiyukf.unicorn.api.msg.attachment.FileAttachment;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class b extends h implements MsgService {
    private static InvocationFuture<List<IMMessage>> a(List<a> list) {
        i b = h.b();
        for (a aVar : list) {
            if (aVar.getStatus() == MsgStatusEnum.fail) {
                if (com.qiyukf.nimlib.i.b.a().c(aVar.getUuid())) {
                    aVar.setStatus(MsgStatusEnum.sending);
                }
            } else if (com.qiyukf.nimlib.i.b.a().f(aVar.getUuid())) {
                aVar.setAttachStatus(AttachStatusEnum.transferring);
            }
        }
        b.b((Object) list);
        com.qiyukf.nimlib.e.a.c(b);
        return null;
    }

    private static void a(com.qiyukf.nimlib.i.h hVar) {
        if (hVar.getMsgStatus() == MsgStatusEnum.fail && com.qiyukf.nimlib.i.b.a().c(hVar.getRecentMessageId())) {
            hVar.setMsgStatus(MsgStatusEnum.sending);
        }
    }

    private void a(CustomNotification customNotification, final i iVar, com.qiyukf.nimlib.a.f.a aVar) {
        if (TextUtils.isEmpty(customNotification.getSessionId()) || customNotification.getSessionType() == null) {
            throw new IllegalArgumentException("illegal receiver");
        }
        String toJson = customNotification.getAttachment().toJson(true);
        StringBuilder stringBuilder = new StringBuilder("send custom notification: sessionId: ");
        stringBuilder.append(customNotification.getSessionId());
        stringBuilder.append(", content: ");
        stringBuilder.append(toJson);
        com.qiyukf.basesdk.a.a.b("test", stringBuilder.toString());
        com.qiyukf.nimlib.h.c.b.b bVar = new com.qiyukf.nimlib.h.c.b.b();
        bVar.a(2, customNotification.getSessionId());
        bVar.a(1, g.a(customNotification.getSessionType()));
        bVar.a(5, toJson);
        if (!customNotification.isSendToOnlineUserOnly()) {
            bVar.a(7, 1);
        }
        if (!TextUtils.isEmpty(customNotification.getApnsText())) {
            bVar.a(8, customNotification.getApnsText());
        }
        com.qiyukf.nimlib.a.c.d.a aVar2 = customNotification.getSessionType() == SessionTypeEnum.Ysf ? new com.qiyukf.nimlib.a.c.e.a() : new com.qiyukf.nimlib.a.c.d.a();
        aVar2.a(bVar);
        c.a().a(new com.qiyukf.nimlib.a.f.b(aVar2, aVar) {
            public final void a(com.qiyukf.nimlib.a.d.a aVar) {
                iVar.a(aVar.e());
                com.qiyukf.nimlib.e.a.c(iVar);
            }
        });
    }

    private static void a(String str, SessionTypeEnum sessionTypeEnum) {
        StringBuilder stringBuilder = new StringBuilder("DELETE FROM lstmsg where uid = '");
        stringBuilder.append(com.qiyukf.nimlib.c.a.b.a(str));
        stringBuilder.append("' and sessiontype='");
        stringBuilder.append(sessionTypeEnum.getValue());
        stringBuilder.append("'");
        com.qiyukf.nimlib.c.c.a().d().a(stringBuilder.toString());
        com.qiyukf.nimlib.a.c.a bVar = new com.qiyukf.nimlib.a.c.d.b();
        bVar.a(str, sessionTypeEnum);
        c.a().a(bVar, com.qiyukf.nimlib.a.f.a.b);
    }

    private static void b(String str, long j, int i, i iVar) {
        com.qiyukf.nimlib.a.c.a cVar = new com.qiyukf.nimlib.a.c.a.c();
        com.qiyukf.nimlib.h.c.b.b bVar = new com.qiyukf.nimlib.h.c.b.b();
        bVar.a(0, "AAC");
        bVar.a(1, String.valueOf(i));
        bVar.a(2, str);
        bVar.a.put(3, String.valueOf(j));
        cVar.a(bVar);
        cVar.a(iVar);
        c.a().a(cVar);
    }

    private static void b(List<RecentContact> list) {
        for (RecentContact recentContact : list) {
            a((com.qiyukf.nimlib.i.h) recentContact);
        }
    }

    public void clearChattingHistory(String str, SessionTypeEnum sessionTypeEnum) {
        int value = sessionTypeEnum.getValue();
        StringBuilder stringBuilder = new StringBuilder("DELETE FROM msghistory where (id='");
        stringBuilder.append(com.qiyukf.nimlib.c.a.b.a(str));
        stringBuilder.append("' and sessiontype='");
        stringBuilder.append(value);
        stringBuilder.append("')");
        com.qiyukf.nimlib.c.c.a().d().a(stringBuilder.toString());
        if (f.a(str, sessionTypeEnum) != null) {
            com.qiyukf.nimlib.e.b.a(g.a(str, sessionTypeEnum));
        }
    }

    public void clearMsgDatabase(boolean z) {
        if (z) {
            List<RecentContact> a = f.a();
            if (a.size() != 0) {
                com.qiyukf.nimlib.a.c.a bVar = new com.qiyukf.nimlib.a.c.d.b();
                for (RecentContact recentContact : a) {
                    bVar.a(recentContact.getContactId(), recentContact.getSessionType());
                }
                c.a().a(bVar, com.qiyukf.nimlib.a.f.a.b);
            }
        }
        com.qiyukf.nimlib.c.c.a().d().a("DELETE FROM msghistory");
        if (z) {
            com.qiyukf.nimlib.c.c.a().d().a("DELETE FROM lstmsg");
        }
        if (z) {
            com.qiyukf.nimlib.e.b.b(null);
        }
    }

    public void clearUnreadCount(String str, SessionTypeEnum sessionTypeEnum) {
        if (!TextUtils.isEmpty(str)) {
            RecentContact a = f.a(str, sessionTypeEnum);
            if (a != null && a.getUnreadCount() > 0) {
                int value = sessionTypeEnum.getValue();
                StringBuilder stringBuilder = new StringBuilder("update lstmsg set unreadnum = 0 where uid='");
                stringBuilder.append(com.qiyukf.nimlib.c.a.b.a(str));
                stringBuilder.append("' and sessiontype='");
                stringBuilder.append(value);
                stringBuilder.append("'");
                com.qiyukf.nimlib.c.c.a().d().a(stringBuilder.toString());
                a.a(0);
                a((com.qiyukf.nimlib.i.h) a);
                com.qiyukf.nimlib.e.b.a(a);
            }
            com.qiyukf.nimlib.g.a.a(com.qiyukf.nimlib.g.c.MESSAGE);
        }
    }

    public void deleteChattingHistory(IMMessage iMMessage) {
        a aVar = (a) iMMessage;
        StringBuilder stringBuilder = new StringBuilder("DELETE FROM msghistory where uuid = '");
        stringBuilder.append(aVar.getUuid());
        stringBuilder.append("'");
        com.qiyukf.nimlib.c.c.a().d().a(stringBuilder.toString());
        String sessionId = iMMessage.getSessionId();
        SessionTypeEnum sessionType = iMMessage.getSessionType();
        com.qiyukf.nimlib.i.h a = f.a(sessionId, sessionType);
        if (a != null && TextUtils.equals(a.getRecentMessageId(), iMMessage.getUuid())) {
            RecentContact a2;
            a a3 = f.a(sessionId, sessionType.getValue());
            if (a3 == null) {
                a2 = g.a(sessionId, sessionType);
            } else {
                a2 = g.a(a3);
                a((com.qiyukf.nimlib.i.h) a2);
            }
            com.qiyukf.nimlib.e.b.a(a2);
        }
    }

    public void deleteRecentContact(RecentContact recentContact) {
        a(recentContact.getContactId(), recentContact.getSessionType());
    }

    public void deleteRecentContact2(String str, SessionTypeEnum sessionTypeEnum) {
        a(str, sessionTypeEnum);
        RecentContact hVar = new com.qiyukf.nimlib.i.h();
        hVar.a(str);
        hVar.a(sessionTypeEnum);
        com.qiyukf.nimlib.e.b.b(hVar);
    }

    public AbortableFuture downloadAttachment(IMMessage iMMessage, boolean z) {
        d a = com.qiyukf.nimlib.i.c.a((a) iMMessage, z, h.b());
        return a == null ? null : new com.qiyukf.nimlib.e.f<d>(a) {
            public final boolean abort() {
                com.qiyukf.basesdk.b.a.a.f.a().b((d) this.c);
                return false;
            }
        };
    }

    public void migrateMessages(String str, String str2, boolean z) {
        if (!TextUtils.equals(str, str2)) {
            Context a = com.qiyukf.nimlib.b.a();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(com.qiyukf.nimlib.b.g());
            stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
            stringBuilder.append(str2);
            com.qiyukf.nimlib.c.a aVar = new com.qiyukf.nimlib.c.a(a, stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder("ATTACH DATABASE '");
            stringBuilder = new StringBuilder();
            stringBuilder.append(com.qiyukf.nimlib.a.a);
            stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
            stringBuilder.append(str);
            stringBuilder.append("/msg.db");
            stringBuilder2.append(stringBuilder.toString());
            stringBuilder2.append("' AS src");
            aVar.a(stringBuilder2.toString());
            aVar.a("INSERT INTO msghistory(uuid,serverid,time,content,msgtype,sessiontype,fromid,id,direct,status,status2,attach) SELECT uuid,serverid,time,content,msgtype,sessiontype,fromid,id,direct,status,status2,attach FROM src.msghistory");
            aVar.a("INSERT OR IGNORE INTO lstmsg(uid,fromuid,messageId,msgstatus,unreadnum,content,time,sessiontype,tag,msgtype,attach) SELECT uid,fromuid,messageId,msgstatus,unreadnum,content,time,sessiontype,tag,msgtype,attach FROM src.lstmsg");
            aVar.a("DETACH DATABASE src");
            if (z) {
                StringBuilder stringBuilder3 = new StringBuilder("UPDATE msghistory SET fromid='");
                stringBuilder3.append(com.qiyukf.nimlib.c.a.b.a(str2));
                stringBuilder3.append("' WHERE fromid='");
                stringBuilder3.append(com.qiyukf.nimlib.c.a.b.a(str));
                stringBuilder3.append("'");
                aVar.a(stringBuilder3.toString());
                stringBuilder3 = new StringBuilder("UPDATE lstmsg SET fromuid='");
                stringBuilder3.append(com.qiyukf.nimlib.c.a.b.a(str2));
                stringBuilder3.append("' WHERE fromuid='");
                stringBuilder3.append(com.qiyukf.nimlib.c.a.b.a(str));
                stringBuilder3.append("'");
                aVar.a(stringBuilder3.toString());
            }
            aVar.c();
            com.qiyukf.nimlib.e.b.b(((MsgService) NIMClient.getService(MsgService.class)).queryRecentContactsBlock());
        }
    }

    public InvocationFuture<List<IMMessage>> pullMessageHistory(IMMessage iMMessage, int i, boolean z) {
        return pullMessageHistoryEx(iMMessage, 0, i, QueryDirectionEnum.QUERY_OLD, z);
    }

    public InvocationFuture<List<IMMessage>> pullMessageHistoryEx(IMMessage iMMessage, long j, int i, QueryDirectionEnum queryDirectionEnum, boolean z) {
        IMMessage iMMessage2 = iMMessage;
        if (iMMessage2 == null || !(iMMessage2 instanceof a)) {
            return null;
        }
        a aVar = (a) iMMessage2;
        boolean z2 = queryDirectionEnum != QueryDirectionEnum.QUERY_OLD;
        com.qiyukf.nimlib.a.c.a cVar = new com.qiyukf.nimlib.a.c.d.c(aVar.getSessionId(), aVar.getSessionType(), z2 ? iMMessage.getTime() : j, z2 ? j : iMMessage.getTime(), aVar.c(), i, z2, z);
        cVar.a(h.b());
        c.a().a(cVar);
        return null;
    }

    public IMMessage queryLastMessage(String str, SessionTypeEnum sessionTypeEnum) {
        return f.a(str, sessionTypeEnum.getValue());
    }

    public InvocationFuture queryMessageList(String str, SessionTypeEnum sessionTypeEnum, long j, int i) {
        return a(f.a(str, sessionTypeEnum.getValue(), j, i));
    }

    public InvocationFuture<List<IMMessage>> queryMessageListEx(IMMessage iMMessage, QueryDirectionEnum queryDirectionEnum, int i, boolean z) {
        return a(f.a((a) iMMessage, queryDirectionEnum, i, z));
    }

    public InvocationFuture queryRecentContacts() {
        i b = h.b();
        Object a = f.a();
        b(a);
        b.b(a);
        com.qiyukf.nimlib.e.a.c(b);
        return null;
    }

    public List<RecentContact> queryRecentContactsBlock() {
        List a = f.a();
        b(a);
        return a;
    }

    public void registerCustomAttachmentParser(MsgAttachmentParser msgAttachmentParser) {
        com.qiyukf.nimlib.i.b.a().c().a(MsgTypeEnum.custom.getValue(), msgAttachmentParser);
    }

    public InvocationFuture<Void> saveMessageToLocal(IMMessage iMMessage, boolean z) {
        a aVar = (a) iMMessage;
        f.a(aVar);
        com.qiyukf.nimlib.e.b.a(g.a(aVar));
        h.b().a(200);
        com.qiyukf.nimlib.e.a.c(h.b());
        if (z) {
            List arrayList = new ArrayList(1);
            arrayList.add(aVar);
            com.qiyukf.nimlib.e.b.a(arrayList);
        }
        return null;
    }

    public InvocationFuture<List<IMMessage>> searchMessageHistory(String str, List<String> list, IMMessage iMMessage, int i) {
        return a(f.a(str, (List) list, iMMessage, i));
    }

    public InvocationFuture<Void> sendCustomNotification(CustomNotification customNotification) {
        a(customNotification, h.b(), com.qiyukf.nimlib.a.f.a.a);
        return null;
    }

    public AbortableFuture<FileAttachment> sendFile(FileAttachment fileAttachment) {
        final com.qiyukf.basesdk.b.a.b.a.c a = com.qiyukf.nimlib.i.d.a(fileAttachment, h.b());
        return new com.qiyukf.nimlib.e.f<FileAttachment>() {
            public final boolean abort() {
                com.qiyukf.basesdk.b.a.b.a.a().a(a);
                return false;
            }
        };
    }

    public InvocationFuture<Void> sendImportantNotification(CustomNotification customNotification) {
        a(customNotification, h.b(), new com.qiyukf.nimlib.a.f.a(5, 30));
        return null;
    }

    public InvocationFuture<Void> sendMessage(IMMessage iMMessage, boolean z) {
        com.qiyukf.nimlib.i.d.a((a) iMMessage, z, h.b());
        return null;
    }

    public void setChattingAccount(String str, SessionTypeEnum sessionTypeEnum) {
        if (MsgService.MSG_CHATTING_ACCOUNT_ALL.equals(str)) {
            com.qiyukf.nimlib.d.a(str);
            com.qiyukf.nimlib.g.c[] cVarArr = com.qiyukf.nimlib.g.c.c;
            if (cVarArr != null) {
                for (com.qiyukf.nimlib.g.c a : cVarArr) {
                    com.qiyukf.nimlib.g.a.a(a);
                }
            }
            return;
        }
        if (str == null) {
            str = "";
        }
        com.qiyukf.nimlib.d.a(g.a(str, sessionTypeEnum.getValue()));
        clearUnreadCount(str, sessionTypeEnum);
    }

    public AbortableFuture<String> transVoiceToText(String str, String str2, final long j) {
        if (str2 == null || !new File(str2).exists()) {
            throw new IllegalArgumentException("Invalid audio path.");
        }
        final i b = h.b();
        if (TextUtils.isEmpty(str)) {
            com.qiyukf.basesdk.b.a.b.a.a().a(str2, com.qiyukf.basesdk.c.c.c.b(str2), b, new com.qiyukf.basesdk.b.a.b.c() {
                final /* synthetic */ int b = 16000;

                public final void a() {
                    a((int) SecExceptionCode.SEC_ERROR_DYN_ENC);
                }

                public final void a(int i) {
                    b.a(i);
                    b.a(null);
                    com.qiyukf.nimlib.e.a.c(b);
                }

                public final void a(long j, long j2) {
                }

                public final void a(String str) {
                    b.b(str, j, this.b, b);
                }
            });
        } else {
            b(str, j, 16000, b);
        }
        return null;
    }

    public void updateIMMessageStatus(IMMessage iMMessage, boolean z) {
        a aVar = (a) iMMessage;
        ContentValues contentValues = new ContentValues(3);
        if (aVar.getStatus() != null) {
            contentValues.put("status", Integer.valueOf(aVar.getStatus().getValue()));
        }
        if (aVar.getAttachStatus() != null) {
            contentValues.put("status2", Integer.valueOf(aVar.getAttachStatus().getValue()));
        }
        if (aVar.getAttachment() != null) {
            contentValues.put("attach", aVar.getAttachment().toJson(false));
        }
        if (contentValues.size() > 0) {
            com.qiyukf.nimlib.c.c.a().d().a("msghistory", contentValues, "uuid=?", new String[]{aVar.getUuid()});
        }
        if (z) {
            com.qiyukf.nimlib.e.b.a(iMMessage);
        }
        if (iMMessage.getAttachment() != null) {
            RecentContact a = f.a(iMMessage.getSessionId(), iMMessage.getSessionType());
            if (a != null && a.getRecentMessageId().equals(iMMessage.getUuid())) {
                a.a(iMMessage.getAttachment());
                if (a.getMsgType() == MsgTypeEnum.custom) {
                    a.d(a.getAttachment().getContent(com.qiyukf.nimlib.b.a()));
                }
                ContentValues contentValues2 = new ContentValues(2);
                contentValues2.put(com.umeng.commonsdk.framework.c.a, a.getContent());
                contentValues2.put("attach", a.getAttachment().toJson(false));
                com.qiyukf.nimlib.c.c.a().d().a("lstmsg", contentValues2, "messageId=?", new String[]{a.getRecentMessageId()});
                com.qiyukf.nimlib.e.b.a(a);
            }
        }
    }

    public void updateMessage(IMMessage iMMessage, boolean z) {
        f.b((a) iMMessage);
        if (z) {
            com.qiyukf.nimlib.e.b.a(iMMessage);
        }
    }

    public InvocationFuture<Void> updateRecent(RecentContact recentContact) {
        StringBuilder stringBuilder = new StringBuilder("UPDATE lstmsg set tag='");
        stringBuilder.append(recentContact.getTag());
        stringBuilder.append("' where messageId='");
        stringBuilder.append(recentContact.getRecentMessageId());
        stringBuilder.append("'");
        com.qiyukf.nimlib.c.c.a().d().a(stringBuilder.toString());
        return null;
    }
}
