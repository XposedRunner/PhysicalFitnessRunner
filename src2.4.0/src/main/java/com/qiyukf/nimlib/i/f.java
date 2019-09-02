package com.qiyukf.nimlib.i;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.qiyukf.nimlib.c.a;
import com.qiyukf.nimlib.c.a.b;
import com.qiyukf.nimlib.c.c;
import com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum;
import com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.nimlib.sdk.msg.model.RecentContact;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f {
    public static a a(String str) {
        StringBuilder stringBuilder = new StringBuilder("SELECT messageid,uuid,serverid,time,content,msgtype,sessiontype,fromid,id,direct,status,status2,attach,ext FROM msghistory where uuid='");
        stringBuilder.append(str);
        stringBuilder.append("'");
        ArrayList a = a(c.a().d(), stringBuilder.toString());
        return a.size() == 1 ? (a) a.get(0) : null;
    }

    public static a a(String str, int i) {
        ArrayList a = a(str, i, 0, 1);
        return !a.isEmpty() ? (a) a.get(0) : null;
    }

    private static h a(Cursor cursor) {
        h hVar = new h();
        try {
            hVar.a(cursor.getString(0));
            hVar.b(cursor.getString(1));
            hVar.c(cursor.getString(2));
            hVar.setMsgStatus(MsgStatusEnum.statusOfValue(cursor.getInt(3)));
            hVar.a(cursor.getInt(4));
            hVar.d(cursor.getString(5));
            hVar.a(cursor.getLong(6));
            hVar.a(SessionTypeEnum.typeOfValue(cursor.getInt(7)));
            hVar.setTag(cursor.getLong(8));
            hVar.b(cursor.getInt(9));
            hVar.e(cursor.getString(10));
            return hVar;
        } catch (Exception e) {
            e.printStackTrace();
            return hVar;
        }
    }

    public static h a(String str, SessionTypeEnum sessionTypeEnum) {
        Cursor b = c.a().d().b(String.format("select uid,fromuid,messageId,msgstatus,unreadnum,content,time,sessiontype,tag,msgtype,attach from lstmsg where uid='%s' and sessiontype='%d'", new Object[]{b.a(str), Integer.valueOf(sessionTypeEnum.getValue())}));
        h a = (b == null || !b.moveToNext()) ? null : a(b);
        if (!(b == null || b.isClosed())) {
            b.close();
        }
        return a;
    }

    private static ArrayList<a> a(a aVar, String str) {
        Cursor b = aVar.b(str);
        if (b == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(b.getCount());
        while (b.moveToNext()) {
            a aVar2 = new a();
            aVar2.a(b.getLong(0));
            aVar2.a(b.getString(1));
            aVar2.b(b.getLong(2));
            aVar2.setTime(b.getLong(3));
            aVar2.setContent(b.getString(4));
            aVar2.a(b.getInt(5));
            aVar2.a(SessionTypeEnum.typeOfValue(b.getInt(6)));
            aVar2.setFromAccount(b.getString(7));
            aVar2.b(b.getString(8));
            aVar2.setDirect(MsgDirectionEnum.directionOfValue(b.getInt(9)));
            aVar2.setStatus(MsgStatusEnum.statusOfValue(b.getInt(10)));
            aVar2.setAttachStatus(AttachStatusEnum.statusOfValue(b.getInt(11)));
            aVar2.c(b.getString(12));
            aVar2.setExt(b.getString(13));
            arrayList.add(aVar2);
        }
        if (!b.isClosed()) {
            b.close();
        }
        return arrayList;
    }

    public static ArrayList<a> a(a aVar, long j, long j2) {
        String sessionId = aVar.getSessionId();
        int value = aVar.getSessionType().getValue();
        int i = 0;
        int i2 = aVar.a() > 0 ? 1 : 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT messageid,uuid,serverid,time,content,msgtype,sessiontype,fromid,id,direct,status,status2,attach,ext FROM msghistory where id='");
        stringBuilder.append(b.a(sessionId));
        stringBuilder.append("' and sessiontype='");
        stringBuilder.append(value);
        stringBuilder.append("'");
        stringBuilder.append(" and time>=");
        stringBuilder.append(j);
        stringBuilder.append(" and time<=");
        stringBuilder.append(j2);
        stringBuilder.append(" ORDER BY time ASC");
        ArrayList a = a(c.a().d(), stringBuilder.toString());
        if (i2 == 0) {
            return a;
        }
        Iterator it = a.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3++;
            if (((a) it.next()).a() == aVar.a()) {
                break;
            }
        }
        while (i <= i3 - 1) {
            a.remove(i);
            i++;
        }
        if (i3 <= 1) {
            return a;
        }
        stringBuilder.delete(stringBuilder.lastIndexOf(" "), stringBuilder.length());
        stringBuilder.append(" offset ");
        stringBuilder.append(i3);
        return a(c.a().d(), stringBuilder.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00de  */
    public static java.util.ArrayList<com.qiyukf.nimlib.i.a> a(com.qiyukf.nimlib.i.a r11, com.qiyukf.nimlib.sdk.msg.model.QueryDirectionEnum r12, int r13, boolean r14) {
        /*
        r0 = r11.getSessionId();
        r1 = r11.getSessionType();
        r1 = r1.getValue();
        r2 = r11.a();
        r4 = 0;
        r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        r2 = 0;
        r3 = 1;
        if (r6 <= 0) goto L_0x001a;
    L_0x0018:
        r6 = r3;
        goto L_0x001b;
    L_0x001a:
        r6 = r2;
    L_0x001b:
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = "SELECT messageid,uuid,serverid,time,content,msgtype,sessiontype,fromid,id,direct,status,status2,attach,ext FROM msghistory where id='";
        r7.append(r8);
        r0 = com.qiyukf.nimlib.c.a.b.a(r0);
        r7.append(r0);
        r0 = "' and sessiontype='";
        r7.append(r0);
        r7.append(r1);
        r0 = "'";
        r7.append(r0);
        r0 = com.qiyukf.nimlib.sdk.msg.model.QueryDirectionEnum.QUERY_NEW;
        if (r12 != r0) goto L_0x003f;
    L_0x003d:
        r12 = r3;
        goto L_0x0040;
    L_0x003f:
        r12 = r2;
    L_0x0040:
        if (r12 == 0) goto L_0x004f;
    L_0x0042:
        r0 = " and time>=";
    L_0x0044:
        r7.append(r0);
        r0 = r11.getTime();
        r7.append(r0);
        goto L_0x005a;
    L_0x004f:
        r0 = r11.getTime();
        r8 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r8 <= 0) goto L_0x005a;
    L_0x0057:
        r0 = " and time<=";
        goto L_0x0044;
    L_0x005a:
        r0 = " ORDER BY time ";
        r7.append(r0);
        if (r12 == 0) goto L_0x0064;
    L_0x0061:
        r0 = "ASC";
        goto L_0x0066;
    L_0x0064:
        r0 = "DESC";
    L_0x0066:
        r7.append(r0);
        r0 = " limit ";
        r7.append(r0);
        if (r6 == 0) goto L_0x0073;
    L_0x0070:
        r0 = r13 + 1;
        goto L_0x0074;
    L_0x0073:
        r0 = r13;
    L_0x0074:
        r7.append(r0);
        r0 = com.qiyukf.nimlib.c.c.a();
        r0 = r0.d();
        r1 = r7.toString();
        r0 = a(r0, r1);
        if (r6 == 0) goto L_0x00dc;
    L_0x0089:
        r1 = r0.iterator();
        r4 = r2;
    L_0x008e:
        r5 = r1.hasNext();
        if (r5 == 0) goto L_0x00a8;
    L_0x0094:
        r5 = r1.next();
        r5 = (com.qiyukf.nimlib.i.a) r5;
        r4 = r4 + 1;
        r5 = r5.a();
        r8 = r11.a();
        r10 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1));
        if (r10 != 0) goto L_0x008e;
    L_0x00a8:
        r11 = r4 + -1;
        if (r2 > r11) goto L_0x00b2;
    L_0x00ac:
        r0.remove(r2);
        r2 = r2 + 1;
        goto L_0x00a8;
    L_0x00b2:
        if (r4 <= r3) goto L_0x00dc;
    L_0x00b4:
        r11 = " ";
        r11 = r7.lastIndexOf(r11);
        r0 = r7.length();
        r7.delete(r11, r0);
        r7.append(r13);
        r11 = " offset ";
        r7.append(r11);
        r7.append(r4);
        r11 = com.qiyukf.nimlib.c.c.a();
        r11 = r11.d();
        r13 = r7.toString();
        r0 = a(r11, r13);
    L_0x00dc:
        if (r12 == r14) goto L_0x00e1;
    L_0x00de:
        java.util.Collections.reverse(r0);
    L_0x00e1:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.i.f.a(com.qiyukf.nimlib.i.a, com.qiyukf.nimlib.sdk.msg.model.QueryDirectionEnum, int, boolean):java.util.ArrayList");
    }

    public static ArrayList<a> a(String str, int i, long j, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT messageid,uuid,serverid,time,content,msgtype,sessiontype,fromid,id,direct,status,status2,attach,ext FROM msghistory where id='");
        stringBuilder.append(b.a(str));
        stringBuilder.append("' and sessiontype='");
        stringBuilder.append(i);
        stringBuilder.append("'");
        stringBuilder.append(" ORDER BY time desc limit ");
        stringBuilder.append(i2);
        stringBuilder.append(" offset ");
        stringBuilder.append(j);
        return a(c.a().d(), stringBuilder.toString());
    }

    public static List<RecentContact> a() {
        Cursor b = c.a().d().b("select uid,fromuid,messageId,msgstatus,unreadnum,content,time,sessiontype,tag,msgtype,attach from lstmsg order by time desc limit 100");
        ArrayList arrayList = new ArrayList();
        if (b != null) {
            while (b.moveToNext()) {
                arrayList.add(a(b));
            }
            if (!b.isClosed()) {
                b.close();
            }
        }
        return arrayList;
    }

    public static List<a> a(String str, List<String> list, IMMessage iMMessage, int i) {
        String sessionId = iMMessage.getSessionId();
        int value = iMMessage.getSessionType().getValue();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT messageid,uuid,serverid,time,content,msgtype,sessiontype,fromid,id,direct,status,status2,attach,ext FROM msghistory where id='");
        stringBuilder.append(b.a(sessionId));
        stringBuilder.append("' and sessiontype='");
        stringBuilder.append(value);
        stringBuilder.append("'");
        if (iMMessage.getTime() > 0) {
            stringBuilder.append(" and time<'");
            stringBuilder.append(iMMessage.getTime());
            stringBuilder.append("'");
        }
        stringBuilder.append(" and msgtype='");
        stringBuilder.append(MsgTypeEnum.text.getValue());
        stringBuilder.append("' and (");
        if (list != null && list.size() > 0) {
            stringBuilder.append("fromid in (");
            for (String str2 : list) {
                stringBuilder.append("'");
                stringBuilder.append(b.a(str2));
                stringBuilder.append("',");
            }
            stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), ") or");
        }
        stringBuilder.append(" content like ");
        if (TextUtils.isEmpty(str)) {
            str = "";
        } else {
            str = str.replace("'", "''").replace("\\", "\\\\").replace("%", "\\%").replace("_", "\\_");
            StringBuilder stringBuilder2 = new StringBuilder("'%");
            stringBuilder2.append(str);
            stringBuilder2.append("%' ESCAPE '\\'");
            str = stringBuilder2.toString();
        }
        stringBuilder.append(str);
        stringBuilder.append(") ORDER BY time desc limit ");
        stringBuilder.append(i);
        return a(c.a().d(), stringBuilder.toString());
    }

    public static void a(a aVar) {
        a(aVar, null);
    }

    public static void a(a aVar, MsgStatusEnum msgStatusEnum) {
        ContentValues c = c(aVar);
        if (msgStatusEnum != null) {
            c.put("status", Integer.valueOf(msgStatusEnum.getValue()));
        }
        aVar.a(c.a().d().a("msghistory", c));
    }

    public static void a(h hVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("insert or replace into lstmsg(uid,fromuid,messageId,msgstatus,unreadnum,content,time,sessiontype,tag,msgtype,attach) values ('");
        stringBuilder.append(b.a(hVar.getContactId()));
        stringBuilder.append("','");
        stringBuilder.append(b.a(hVar.getFromAccount()));
        stringBuilder.append("','");
        stringBuilder.append(hVar.getRecentMessageId());
        stringBuilder.append("','");
        stringBuilder.append(hVar.getMsgStatus().getValue());
        stringBuilder.append("','");
        stringBuilder.append(hVar.getUnreadCount());
        stringBuilder.append("','");
        stringBuilder.append(b.a(hVar.getContent()));
        stringBuilder.append("','");
        stringBuilder.append(hVar.getTime());
        stringBuilder.append("','");
        stringBuilder.append(hVar.getSessionType().getValue());
        stringBuilder.append("','");
        stringBuilder.append(hVar.getTag());
        stringBuilder.append("','");
        stringBuilder.append(hVar.b());
        stringBuilder.append("','");
        stringBuilder.append(b.a(hVar.a()));
        stringBuilder.append("')");
        c.a().d().a(stringBuilder.toString());
    }

    public static void a(List<a> list) {
        c.a().d().d().beginTransaction();
        try {
            for (a a : list) {
                a(a, null);
            }
            c.a().d().d().setTransactionSuccessful();
        } finally {
            c.a().d().d().endTransaction();
        }
    }

    public static long b(String str) {
        StringBuilder stringBuilder = new StringBuilder("SELECT messageid FROM msghistory where uuid='");
        stringBuilder.append(str);
        stringBuilder.append("'");
        Cursor b = c.a().d().b(stringBuilder.toString());
        long j = 0;
        if (b != null) {
            if (b.moveToNext()) {
                j = b.getLong(0);
            }
            if (!b.isClosed()) {
                b.close();
            }
        }
        return j;
    }

    public static void b(a aVar) {
        b(aVar, null);
    }

    public static void b(a aVar, MsgStatusEnum msgStatusEnum) {
        ContentValues c = c(aVar);
        c.put("messageid", Long.valueOf(aVar.a()));
        if (msgStatusEnum != null) {
            c.put("status", Integer.valueOf(msgStatusEnum.getValue()));
        }
        c.a().d().b("msghistory", c);
    }

    private static ContentValues c(a aVar) {
        ContentValues contentValues = new ContentValues(16);
        contentValues.put("uuid", aVar.getUuid());
        contentValues.put("serverid", Long.valueOf(aVar.c()));
        contentValues.put("time", Long.valueOf(aVar.getTime()));
        contentValues.put(com.umeng.commonsdk.framework.c.a, aVar.getContent());
        contentValues.put("msgtype", Integer.valueOf(aVar.b()));
        contentValues.put("sessiontype", Integer.valueOf(aVar.getSessionType().getValue()));
        contentValues.put("fromid", aVar.getFromAccount());
        contentValues.put("id", aVar.getSessionId());
        contentValues.put("direct", Integer.valueOf(aVar.getDirect().getValue()));
        contentValues.put("status", Integer.valueOf(aVar.getStatus().getValue()));
        contentValues.put("status2", Integer.valueOf(aVar.getAttachStatus().getValue()));
        contentValues.put("attach", aVar.a(false));
        contentValues.put("ext", aVar.getExt());
        return contentValues;
    }
}
