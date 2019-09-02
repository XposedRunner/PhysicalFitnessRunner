package com.zjwh.android_wh_physicalfitness.entity;

import com.zjwh.android_wh_physicalfitness.entity.database.ChatMessageBean;
import java.util.ArrayList;
import java.util.List;
import org.xutils.DbManager;
import org.xutils.ex.DbException;

public class ChatBean {
    public static final int VIEW_TYPE_MYSELF = 4;
    public static final int VIEW_TYPE_OTHER = 3;
    public static final int VIEW_TYPE_PICTURE = 1;
    public static final int VIEW_TYPE_TITLE = 2;
    private String imageUrl;
    private String jumpUrl;
    private String message;
    private String messageId;
    private boolean showTime;
    private Status status;
    private long timestamp;
    private String title;
    private int viewType;

    public enum Status {
        Normal,
        Loading,
        Failed
    }

    public static List<ChatBean> getList(DbManager dbManager, int i, int i2, long j) throws DbException {
        ArrayList arrayList = new ArrayList();
        List groupMessage = ChatMessageBean.getGroupMessage(dbManager, i, i2, j);
        if (groupMessage != null) {
            i2 = groupMessage.size() - 1;
            ChatBean chatBean = null;
            while (i2 >= 0) {
                ChatMessageBean chatMessageBean = (ChatMessageBean) groupMessage.get(i2);
                ChatBean chatBean2 = new ChatBean();
                chatBean2.setMessageId(chatMessageBean.getMessageId());
                if (chatMessageBean.getType() == 0) {
                    chatBean2.setViewType(chatMessageBean.getFromUid() == i ? 3 : 4);
                } else {
                    chatBean2.setViewType(chatMessageBean.getType());
                }
                if (chatMessageBean.getType() == 1) {
                    chatBean2.setMessage(chatMessageBean.getSubTitle());
                } else {
                    chatBean2.setMessage(chatMessageBean.getMessage());
                }
                chatBean2.setTimestamp(chatMessageBean.getMessageTimestamp());
                chatBean2.setStatus(Status.Normal);
                boolean z = chatBean == null || chatBean2.getTimestamp() - chatBean.getTimestamp() > 300000;
                chatBean2.setShowTime(z);
                chatBean2.setTitle(chatMessageBean.getTitle());
                chatBean2.setImageUrl(chatMessageBean.getPicUrl());
                chatBean2.setJumpUrl(chatMessageBean.getJumpUrl());
                arrayList.add(chatBean2);
                i2--;
                chatBean = chatBean2;
            }
        }
        return arrayList;
    }

    public String getImageUrl() {
        return this.imageUrl;
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

    public Status getStatus() {
        return this.status;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getTitle() {
        return this.title;
    }

    public int getViewType() {
        return this.viewType;
    }

    public boolean isShowTime() {
        return this.showTime;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
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

    public void setShowTime(boolean z) {
        this.showTime = z;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setViewType(int i) {
        this.viewType = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChatBean{viewType=");
        stringBuilder.append(this.viewType);
        stringBuilder.append(", message='");
        stringBuilder.append(this.message);
        stringBuilder.append('\'');
        stringBuilder.append(", messageId='");
        stringBuilder.append(this.messageId);
        stringBuilder.append('\'');
        stringBuilder.append(", timestamp=");
        stringBuilder.append(this.timestamp);
        stringBuilder.append(", showTime=");
        stringBuilder.append(this.showTime);
        stringBuilder.append(", status=");
        stringBuilder.append(this.status);
        stringBuilder.append(", title='");
        stringBuilder.append(this.title);
        stringBuilder.append('\'');
        stringBuilder.append(", imageUrl='");
        stringBuilder.append(this.imageUrl);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
