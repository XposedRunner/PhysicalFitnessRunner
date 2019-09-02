package com.qiyukf.nimlib.a.e;

import android.database.Cursor;
import com.qiyukf.nimlib.a.d;
import com.qiyukf.nimlib.e.a;
import com.qiyukf.nimlib.e.b;
import com.qiyukf.nimlib.e.h;
import com.qiyukf.nimlib.e.i;
import com.qiyukf.nimlib.sdk.InvocationFuture;
import com.qiyukf.nimlib.sdk.msg.SystemMessageService;
import com.qiyukf.nimlib.sdk.msg.constant.SystemMessageStatus;
import com.qiyukf.nimlib.sdk.msg.model.SystemMessage;
import java.util.ArrayList;
import java.util.List;

public class c extends h implements SystemMessageService {
    public void clearSystemMessages() {
        com.qiyukf.nimlib.c.c.a().d().a("DELETE FROM system_msg");
    }

    public void deleteSystemMessage(long j) {
        StringBuilder stringBuilder = new StringBuilder("DELETE FROM system_msg WHERE messageid='");
        stringBuilder.append(j);
        stringBuilder.append("'");
        com.qiyukf.nimlib.c.c.a().d().a(stringBuilder.toString());
    }

    public InvocationFuture<Integer> querySystemMessageUnreadCount() {
        int a = d.a();
        i b = h.b();
        b.b(Integer.valueOf(a));
        a.c(b);
        return null;
    }

    public int querySystemMessageUnreadCountBlock() {
        return d.a();
    }

    public InvocationFuture<List<SystemMessage>> querySystemMessages(int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder("SELECT messageid, id, fromid, type, time, status, content, attach FROM system_msg ORDER BY time desc LIMIT ");
        stringBuilder.append(i2);
        stringBuilder.append(" OFFSET ");
        stringBuilder.append(i);
        Cursor b = com.qiyukf.nimlib.c.c.a().d().b(stringBuilder.toString());
        Object arrayList = new ArrayList();
        if (b != null) {
            while (b.moveToNext()) {
                SystemMessage systemMessage = new SystemMessage();
                systemMessage.setMessageId(b.getLong(0));
                systemMessage.setTargetId(b.getString(1));
                systemMessage.setFromAccount(b.getString(2));
                systemMessage.setType(b.getInt(3));
                systemMessage.setTime(b.getLong(4));
                systemMessage.setStatus(SystemMessageStatus.statusOfValue(b.getInt(5)));
                systemMessage.setContent(b.getString(6));
                systemMessage.setAttach(b.getString(7));
                arrayList.add(systemMessage);
            }
            if (!b.isClosed()) {
                b.close();
            }
        }
        i b2 = h.b();
        b2.b(arrayList);
        a.c(b2);
        return null;
    }

    public void resetSystemMessageUnreadCount() {
        d.a(0);
        b.a(0);
    }

    public void setSystemMessageStatus(long j, SystemMessageStatus systemMessageStatus) {
        StringBuilder stringBuilder = new StringBuilder("UPDATE system_msg SET status='");
        stringBuilder.append(systemMessageStatus.getValue());
        stringBuilder.append("' WHERE messageid='");
        stringBuilder.append(j);
        stringBuilder.append("'");
        com.qiyukf.nimlib.c.c.a().d().a(stringBuilder.toString());
    }
}
