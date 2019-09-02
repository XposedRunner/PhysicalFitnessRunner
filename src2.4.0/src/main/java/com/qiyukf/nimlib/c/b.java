package com.qiyukf.nimlib.c;

import com.qiyukf.nimlib.c.a.c;
import com.qiyukf.nimlib.c.a.c.a;

public final class b extends c {
    public static final b a = new b();

    public b() {
        super(new a[]{new a("msghistory").a(new com.qiyukf.nimlib.c.a.c.b() {
            /* Access modifiers changed, original: protected|final */
            public final String[] a() {
                return new String[]{"CREATE TABLE IF NOT EXISTS msghistory(messageid Integer PRIMARY KEY AUTOINCREMENT, uuid Varchar(32) NOT NULL, serverid Long, id Varchar(32) NOT NULL, fromid Varchar(32) NOT NULL, sessiontype Integer, time Long, status Integer, direct Integer, msgtype Integer, content Varchar(512), status2 Integer, attach TEXT)", "CREATE INDEX IF NOT EXISTS msghistory_uuid_index on msghistory(uuid)", "CREATE INDEX IF NOT EXISTS msghistory_id_sessiontype_time on msghistory(id, sessiontype, time)"};
            }

            /* Access modifiers changed, original: protected|final */
            public final String[] b() {
                return null;
            }
        }).a(new com.qiyukf.nimlib.c.a.c.b() {
            /* Access modifiers changed, original: protected|final */
            public final String[] a() {
                return new String[]{"CREATE TABLE IF NOT EXISTS msghistory(messageid Integer PRIMARY KEY AUTOINCREMENT, uuid Varchar(32) NOT NULL, serverid Long, sessionid, Long, id Varchar(32) NOT NULL, fromid Varchar(32) NOT NULL, sessiontype Integer, sessiontime Long, visitorid Long, foreignid Varchar(128), time Long, sort Long, status Integer, direct Integer, msgtype Integer, content Varchar(512), status2 Integer, attach TEXT,ext TEXT )", "CREATE INDEX IF NOT EXISTS msghistory_uuid_index on msghistory(uuid)", "CREATE INDEX IF NOT EXISTS msghistory_visitor_time on msghistory(foreignid, visitorid, sort)"};
            }

            /* Access modifiers changed, original: protected|final */
            public final String[] b() {
                return new String[]{"ALTER TABLE msghistory ADD ext TEXT"};
            }
        }), new a("lastMsg").a(new com.qiyukf.nimlib.c.a.c.b() {
            /* Access modifiers changed, original: protected|final */
            public final String[] a() {
                return new String[]{"CREATE TABLE IF NOT EXISTS lstmsg(uid Varchar(16) NOT NULL, messageId long, msgstatus INTEGER, sessiontype INTEGER, unreadnum integer, content Varchar(512), time long, tag INTEGER default 0, tag_time long default 0, fromuid Varchar(16))", "CREATE UNIQUE INDEX IF NOT EXISTS lstmsg_uid_sessiontype on lstmsg(uid, sessiontype)"};
            }

            /* Access modifiers changed, original: protected|final */
            public final String[] b() {
                return null;
            }
        }).a(new com.qiyukf.nimlib.c.a.c.b() {
            /* Access modifiers changed, original: protected|final */
            public final String[] a() {
                return new String[]{"CREATE TABLE IF NOT EXISTS lstmsg(uid Varchar(16) NOT NULL, messageId long, msgstatus INTEGER, sessiontype INTEGER, unreadnum INTEGER, content Varchar(512), time long, tag INTEGER default 0, tag_time long default 0, fromuid Varchar(16), msgtype INTEGER, attach TEXT)", "CREATE UNIQUE INDEX IF NOT EXISTS lstmsg_uid_sessiontype on lstmsg(uid, sessiontype)"};
            }

            /* Access modifiers changed, original: protected|final */
            public final String[] b() {
                return new String[]{"ALTER TABLE lstmsg ADD msgtype INTEGER", "ALTER TABLE lstmsg ADD attach TEXT"};
            }
        })});
    }
}
