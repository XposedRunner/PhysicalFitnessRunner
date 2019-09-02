package com.zjwh.android_wh_physicalfitness.entity;

import com.zjwh.android_wh_physicalfitness.entity.database.ChatFriendBean;
import com.zjwh.android_wh_physicalfitness.entity.database.ChatMessageBean;
import java.util.ArrayList;
import java.util.List;
import org.xutils.DbManager;
import org.xutils.ex.DbException;

public class ChatListBean {
    private ChatFriendBean friendBean;
    private boolean isNews;
    private ChatMessageBean messageBean;

    public static void deleteMessage(DbManager dbManager, int i, int i2) throws DbException {
        ChatMessageBean.deleteMessage(dbManager, i, i2);
        ChatFriendBean.deleteMessage(dbManager, i, i2);
    }

    public static List<ChatListBean> getChatList(DbManager dbManager, int i) throws DbException {
        ArrayList arrayList = new ArrayList();
        List<ChatMessageBean> lastEGroupMessage = ChatMessageBean.getLastEGroupMessage(dbManager, i);
        if (lastEGroupMessage != null) {
            for (ChatMessageBean chatMessageBean : lastEGroupMessage) {
                ChatListBean chatListBean = new ChatListBean();
                chatListBean.setMessageBean(chatMessageBean);
                chatListBean.setNews(chatMessageBean.isRead() ^ 1);
                chatListBean.setFriendBean(ChatFriendBean.getChatFriendBean(dbManager, chatMessageBean.getUid(), chatMessageBean.getChatGroup()));
                arrayList.add(chatListBean);
            }
        }
        return arrayList;
    }

    public ChatFriendBean getFriendBean() {
        return this.friendBean;
    }

    public ChatMessageBean getMessageBean() {
        return this.messageBean;
    }

    public boolean isNews() {
        return this.isNews;
    }

    public void setFriendBean(ChatFriendBean chatFriendBean) {
        this.friendBean = chatFriendBean;
    }

    public void setMessageBean(ChatMessageBean chatMessageBean) {
        this.messageBean = chatMessageBean;
    }

    public void setNews(boolean z) {
        this.isNews = z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChatListBean{messageBean=");
        stringBuilder.append(this.messageBean);
        stringBuilder.append(", friendBean=");
        stringBuilder.append(this.friendBean);
        stringBuilder.append(", isNews=");
        stringBuilder.append(this.isNews);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
