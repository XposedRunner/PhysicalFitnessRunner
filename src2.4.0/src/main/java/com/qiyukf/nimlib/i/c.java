package com.qiyukf.nimlib.i;

import android.text.TextUtils;
import com.qiyukf.basesdk.b.a.a.d;
import com.qiyukf.basesdk.b.a.a.e;
import com.qiyukf.basesdk.b.a.a.f;
import com.qiyukf.nimlib.e.a;
import com.qiyukf.nimlib.e.b;
import com.qiyukf.nimlib.e.i;
import com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum;
import com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import com.qiyukf.unicorn.api.msg.attachment.FileAttachment;
import com.qiyukf.unicorn.api.msg.attachment.ImageAttachment;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c {
    public static d a(final a aVar, boolean z, final i iVar) {
        final FileAttachment fileAttachment = (FileAttachment) aVar.getAttachment();
        if (TextUtils.isEmpty(fileAttachment.getUrl())) {
            b(iVar, 414);
            return null;
        }
        String pathForSave = fileAttachment.getPathForSave();
        String a = com.qiyukf.basesdk.b.a.c.c.a(fileAttachment.getUrl());
        if (z) {
            if (aVar.getMsgType() == MsgTypeEnum.image) {
                pathForSave = fileAttachment.getThumbPathForSave();
                ImageAttachment imageAttachment = (ImageAttachment) fileAttachment;
                a = com.qiyukf.basesdk.b.a.c.c.a(a, imageAttachment.getWidth(), imageAttachment.getHeight());
            } else if (aVar.getMsgType() == MsgTypeEnum.video) {
                pathForSave = fileAttachment.getThumbPathForSave();
                a = com.qiyukf.basesdk.b.a.c.c.b(a);
            }
        }
        if (!new File(pathForSave).exists()) {
            b(aVar, AttachStatusEnum.transferring);
            d dVar = new d(a, pathForSave, new e() {
                private long d = fileAttachment.getSize();

                public final void a() {
                    c.b(aVar, AttachStatusEnum.transferred);
                    c.b(iVar, 200);
                }

                public final void a(long j) {
                    b.a(aVar.getUuid(), j, this.d);
                }

                public final void b() {
                    c.b(aVar, AttachStatusEnum.fail);
                    c.b(iVar, 500);
                }

                public final void b(long j) {
                    this.d = j;
                }

                public final void c() {
                    c.b(aVar, AttachStatusEnum.fail);
                }
            });
            f.a().a(dVar);
            return dVar;
        } else if (aVar.getAttachStatus() == AttachStatusEnum.transferred) {
            b(iVar, 414);
            return null;
        } else {
            b(aVar, AttachStatusEnum.transferred);
            b(iVar, 200);
            return null;
        }
    }

    public static a a(com.qiyukf.nimlib.h.c.b.b bVar, boolean z) {
        CharSequence a = bVar.a(11);
        if (bVar.b(13) == 1 && !TextUtils.isEmpty(a) && f.b((String) a) != 0) {
            a = null;
        } else if (TextUtils.isEmpty(a)) {
            a = com.qiyukf.basesdk.c.c.d.b();
        }
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        String a2 = bVar.a(2);
        int b = bVar.b(0);
        String a3 = a(bVar);
        int b2 = bVar.b(8);
        a aVar = new a();
        aVar.a(bVar.a(11));
        aVar.b(bVar.c(12));
        aVar.setFromAccount(a2);
        aVar.b(a3);
        aVar.setTime(bVar.c(7));
        aVar.a(SessionTypeEnum.typeOfValue(b));
        aVar.a(b2);
        aVar.setContent(bVar.a(9));
        aVar.c(bVar.a(10));
        aVar.setExt(bVar.a(15));
        aVar.setStatus(MsgStatusEnum.success);
        aVar.setAttachStatus(AttachStatusEnum.def);
        int b3 = bVar.b(4);
        boolean equals = com.qiyukf.nimlib.b.b().equals(aVar.getFromAccount());
        if (com.qiyukf.nimlib.b.b().equals(aVar.getFromAccount()) && com.qiyukf.nimlib.b.b().equals(aVar.getSessionId())) {
            equals = b3 == 1 || b3 == 2 || b3 == 8;
        }
        aVar.setDirect(equals ? MsgDirectionEnum.Out : MsgDirectionEnum.In);
        if (z) {
            f.a(aVar);
        }
        return aVar;
    }

    public static h a(ArrayList<a> arrayList, String str) {
        a aVar = (a) arrayList.get(arrayList.size() - 1);
        boolean equals = g.a(aVar.getSessionId(), aVar.getSessionType().getValue()).equals(com.qiyukf.nimlib.d.d());
        a((ArrayList) arrayList);
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            a aVar2 = (a) it.next();
            if (!equals && b(aVar2)) {
                i++;
            }
        }
        b.a((List) arrayList);
        if (i > 0) {
            a aVar3 = null;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (b((a) arrayList.get(size))) {
                    aVar3 = (a) arrayList.get(size);
                    break;
                }
            }
            if (aVar3 != null) {
                com.qiyukf.nimlib.g.b.a(aVar3, str, i);
            }
        }
        return g.a(aVar, i);
    }

    public static String a(com.qiyukf.nimlib.h.c.b.b bVar) {
        int b = bVar.b(0);
        String a = bVar.a(2);
        String a2 = bVar.a(1);
        return ((b == 0 || b == 2) && !a.equals(com.qiyukf.nimlib.b.b())) ? a : a2;
    }

    public static void a(a aVar) {
        f.a(aVar);
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        b.a(a(arrayList, ""));
    }

    public static void a(ArrayList<a> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (com.qiyukf.nimlib.b.d().preloadAttach && aVar.getMsgType() != MsgTypeEnum.custom && aVar.getAttachment() != null && aVar.getAttachment().getClass().getSuperclass().equals(FileAttachment.class)) {
                a(aVar, true, null);
            }
        }
    }

    private static void b(i iVar, int i) {
        if (iVar != null) {
            iVar.a(i);
            a.c(iVar);
        }
    }

    private static void b(a aVar, AttachStatusEnum attachStatusEnum) {
        aVar.setAttachStatus(attachStatusEnum);
        if (attachStatusEnum == AttachStatusEnum.transferring) {
            b.a().d(aVar.getUuid());
        } else {
            b.a().e(aVar.getUuid());
            long a = aVar.a();
            int value = attachStatusEnum.getValue();
            StringBuilder stringBuilder = new StringBuilder("UPDATE msghistory set status2='");
            stringBuilder.append(value);
            stringBuilder.append("' where messageid='");
            stringBuilder.append(a);
            stringBuilder.append("'");
            com.qiyukf.nimlib.c.c.a().d().a(stringBuilder.toString());
        }
        b.a((IMMessage) aVar);
    }

    private static boolean b(a aVar) {
        return aVar.getDirect() == MsgDirectionEnum.Out ? false : aVar.getAttachment() != null ? aVar.getAttachment().countToUnread() : aVar.getMsgType() != MsgTypeEnum.notification;
    }
}
