package com.zjwh.android_wh_physicalfitness.entity.database;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import org.xutils.DbManager;
import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;
import org.xutils.db.sqlite.WhereBuilder;
import org.xutils.ex.DbException;

@Table(name = "chat_message")
public class ChatMessageBean {
    @Column(name = "chatGroup")
    private int chatGroup;
    @Column(name = "fromUid")
    private int fromUid;
    @Column(name = "isRead")
    private boolean isRead;
    @Column(name = "jumpUrl")
    private String jumpUrl;
    @Column(name = "message")
    private String message;
    @Column(isId = true, name = "messageId")
    private String messageId;
    @Column(name = "messageTimestamp")
    private long messageTimestamp;
    @Column(name = "picUrl")
    private String picUrl;
    @Column(name = "subTitle")
    private String subTitle;
    @Column(name = "title")
    private String title;
    @Column(name = "toUid")
    private int toUid;
    @Column(name = "type")
    private int type;
    @Column(name = "uid")
    private int uid;

    public static void deleteMessage(DbManager dbManager, int i, int i2) throws DbException {
        dbManager.delete(ChatMessageBean.class, WhereBuilder.b("uid", "=", Integer.valueOf(i)).and("chatGroup", "=", Integer.valueOf(i2)));
    }

    public static long getChatLastMessageTime(DbManager dbManager, int i) throws DbException {
        ChatMessageBean chatMessageBean = (ChatMessageBean) dbManager.selector(ChatMessageBean.class).where("uid", "=", Integer.valueOf(i)).orderBy("messageTimestamp", true).findFirst();
        return chatMessageBean == null ? 0 : chatMessageBean.getMessageTimestamp();
    }

    public static List<ChatMessageBean> getGroupMessage(DbManager dbManager, int i, int i2, long j) throws DbException {
        return j == 0 ? dbManager.selector(ChatMessageBean.class).where("chatGroup", "=", Integer.valueOf(i)).and("uid", "=", Integer.valueOf(i2)).orderBy("messageTimestamp", true).limit(20).offset(0).findAll() : dbManager.selector(ChatMessageBean.class).where("chatGroup", "=", Integer.valueOf(i)).and("uid", "=", Integer.valueOf(i2)).and("messageTimestamp", "<", Long.valueOf(j)).orderBy("messageTimestamp", true).limit(20).offset(0).findAll();
    }

    public static synchronized List<ChatMessageBean> getGroupNewMessage(DbManager dbManager, int i, int i2, long j) throws DbException {
        List findAll;
        synchronized (ChatMessageBean.class) {
            findAll = dbManager.selector(ChatMessageBean.class).where("chatGroup", "=", Integer.valueOf(i)).and("uid", "=", Integer.valueOf(i2)).and("messageTimestamp", ">", Long.valueOf(j)).orderBy("messageTimestamp", true).findAll();
        }
        return findAll;
    }

    public static List<ChatMessageBean> getLastEGroupMessage(DbManager dbManager, int i) throws DbException {
        ArrayList arrayList = new ArrayList();
        if (dbManager.getTable(ChatMessageBean.class).tableIsExist()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SELECT * FROM (SELECT * FROM chat_message where uid = ");
            stringBuilder.append(i);
            stringBuilder.append(" ORDER BY messageTimestamp ASC) as tt GROUP BY tt.chatGroup ORDER BY tt.messageTimestamp DESC");
            Cursor execQuery = dbManager.execQuery(stringBuilder.toString());
            if (execQuery != null) {
                while (execQuery.moveToNext()) {
                    ChatMessageBean chatMessageBean = new ChatMessageBean();
                    chatMessageBean.setMessage(execQuery.getString(execQuery.getColumnIndex("message")));
                    chatMessageBean.setMessageId(execQuery.getString(execQuery.getColumnIndex("messageId")));
                    chatMessageBean.setFromUid(execQuery.getInt(execQuery.getColumnIndex("fromUid")));
                    chatMessageBean.setToUid(execQuery.getInt(execQuery.getColumnIndex("toUid")));
                    chatMessageBean.setMessageTimestamp(execQuery.getLong(execQuery.getColumnIndex("messageTimestamp")));
                    chatMessageBean.setUid(execQuery.getInt(execQuery.getColumnIndex("uid")));
                    chatMessageBean.setChatGroup(execQuery.getInt(execQuery.getColumnIndex("chatGroup")));
                    boolean z = true;
                    if (execQuery.getInt(execQuery.getColumnIndex("isRead")) != 1) {
                        z = false;
                    }
                    chatMessageBean.setRead(z);
                    chatMessageBean.setJumpUrl(execQuery.getString(execQuery.getColumnIndex("jumpUrl")));
                    chatMessageBean.setPicUrl(execQuery.getString(execQuery.getColumnIndex("picUrl")));
                    chatMessageBean.setType(execQuery.getInt(execQuery.getColumnIndex("type")));
                    chatMessageBean.setTitle(execQuery.getString(execQuery.getColumnIndex("title")));
                    arrayList.add(chatMessageBean);
                }
                execQuery.close();
            }
        }
        return arrayList;
    }

    public static void updateGroupLastRed(DbManager dbManager, int i, int i2) throws DbException {
        ChatMessageBean chatMessageBean = (ChatMessageBean) dbManager.selector(ChatMessageBean.class).where("chatGroup", "=", Integer.valueOf(i)).and("uid", "=", Integer.valueOf(i2)).orderBy("messageTimestamp", true).findFirst();
        if (chatMessageBean != null) {
            chatMessageBean.setRead(true);
            dbManager.saveOrUpdate(chatMessageBean);
        }
    }

    public int getChatGroup() {
        return this.chatGroup;
    }

    public int getFromUid() {
        return this.fromUid;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getMessage() {
        return this.message;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public long getMessageTimestamp() {
        return this.messageTimestamp;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public String getTitle() {
        return this.title;
    }

    public int getToUid() {
        return this.toUid;
    }

    public int getType() {
        return this.type;
    }

    public int getUid() {
        return this.uid;
    }

    public boolean isRead() {
        return this.isRead;
    }

    public void setChatGroup(int i) {
        this.chatGroup = i;
    }

    public void setFromUid(int i) {
        this.fromUid = i;
    }

    public void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setMessageTimestamp(long j) {
        this.messageTimestamp = j;
    }

    public void setPicUrl(String str) {
        this.picUrl = str;
    }

    public void setRead(boolean z) {
        this.isRead = z;
    }

    public void setSubTitle(String str) {
        this.subTitle = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setToUid(int i) {
        this.toUid = i;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUid(int i) {
        this.uid = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChatMessageBean{messageId='");
        stringBuilder.append(this.messageId);
        stringBuilder.append('\'');
        stringBuilder.append(", message='");
        stringBuilder.append(this.message);
        stringBuilder.append('\'');
        stringBuilder.append(", fromUid=");
        stringBuilder.append(this.fromUid);
        stringBuilder.append(", toUid=");
        stringBuilder.append(this.toUid);
        stringBuilder.append(", messageTimestamp=");
        stringBuilder.append(this.messageTimestamp);
        stringBuilder.append(", uid=");
        stringBuilder.append(this.uid);
        stringBuilder.append(", chatGroup=");
        stringBuilder.append(this.chatGroup);
        stringBuilder.append(", isRead=");
        stringBuilder.append(this.isRead);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", jumpUrl='");
        stringBuilder.append(this.jumpUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", picUrl='");
        stringBuilder.append(this.picUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", title='");
        stringBuilder.append(this.title);
        stringBuilder.append('\'');
        stringBuilder.append(", subTitle='");
        stringBuilder.append(this.subTitle);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
