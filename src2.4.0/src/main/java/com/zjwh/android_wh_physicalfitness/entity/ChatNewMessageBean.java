package com.zjwh.android_wh_physicalfitness.entity;

import android.content.Context;
import com.zjwh.android_wh_physicalfitness.entity.database.ChatFriendBean;
import com.zjwh.android_wh_physicalfitness.entity.database.ChatMessageBean;
import com.zjwh.android_wh_physicalfitness.entity.database.UserInfo;
import com.zjwh.android_wh_physicalfitness.entity.request.QChatFetch;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O000o000;
import com.zjwh.android_wh_physicalfitness.utils.O00O0o00;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import defpackage.gj;
import defpackage.gk;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.DbManager;
import org.xutils.common.Callback.Cancelable;
import org.xutils.common.Callback.CancelledException;
import org.xutils.ex.DbException;

public class ChatNewMessageBean {
    private List<ChatMessageBean> messages;
    private List<ChatMessageBean> secretary;
    private List<ChatFriendBean> users;

    public interface OnChatMessageGetSuccessListener {
        void onSuccess(Cancelable cancelable, int i);
    }

    private static Cancelable chatConfirm(Context context, DbManager dbManager, int i) {
        long chatLastMessageTime;
        try {
            chatLastMessageTime = ChatMessageBean.getChatLastMessageTime(dbManager, i);
        } catch (DbException e) {
            e.printStackTrace();
            chatLastMessageTime = 0;
        }
        gj gjVar = new gj(gk.O000Ooo);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("timestamp", chatLastMessageTime);
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return HttpUtil.post(context, gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
            }

            public void onFinished() {
            }

            public void onSuccess(String str) {
            }
        });
    }

    public static Cancelable getChatMessageData(Context context, final OnChatMessageGetSuccessListener onChatMessageGetSuccessListener) {
        long chatLastMessageTime;
        List chatFriendUIds;
        DbException e;
        context = (Context) new WeakReference(context).get();
        if (context == null) {
            return null;
        }
        final DbManager O0000O0o = O00Oo0.O0000O0o();
        final UserInfo O00000o0 = O00Oo0.O00000o0();
        if (O00000o0 == null || O00000o0.getRole() == 2) {
            return null;
        }
        gj gjVar = new gj(gk.O000ooo0);
        ArrayList arrayList = new ArrayList();
        try {
            chatLastMessageTime = ChatMessageBean.getChatLastMessageTime(O0000O0o, O00000o0.getUid());
            try {
                chatFriendUIds = ChatFriendBean.getChatFriendUIds(O0000O0o, O00000o0.getUid());
            } catch (DbException e2) {
                e = e2;
            }
        } catch (DbException e3) {
            e = e3;
            chatLastMessageTime = 0;
            e.printStackTrace();
            chatFriendUIds = arrayList;
            gjVar.setBodyContent(O000o000.O000000o().toJson(new QChatFetch(chatLastMessageTime, chatFriendUIds)));
            return HttpUtil.post(context, gjVar, new MyCallback<String>() {
                public void onCancelled(CancelledException cancelledException) {
                }

                public void onError(ResponseError responseError) {
                }

                public void onFinished() {
                }

                public void onSuccess(final String str) {
                    new O00O0o00<Integer>() {
                        public Integer call() throws Exception {
                            int i;
                            ChatNewMessageBean chatNewMessageBean = (ChatNewMessageBean) O000o000.O000000o().fromJson(str, ChatNewMessageBean.class);
                            if (chatNewMessageBean.getUsers() != null) {
                                for (ChatFriendBean chatFriendBean : chatNewMessageBean.getUsers()) {
                                    chatFriendBean.setMyselfUId(O00000o0.getUid());
                                    chatFriendBean.setId(O00Oo0.O0000Oo0());
                                }
                                O0000O0o.saveOrUpdate(chatNewMessageBean.getUsers());
                            }
                            if (chatNewMessageBean.getMessages() == null || chatNewMessageBean.getMessages().size() <= 0) {
                                i = 0;
                            } else {
                                for (ChatMessageBean chatMessageBean : chatNewMessageBean.getMessages()) {
                                    int toUid = O00000o0.getUid() == chatMessageBean.getFromUid() ? chatMessageBean.getToUid() : 0;
                                    if (O00000o0.getUid() == chatMessageBean.getToUid()) {
                                        toUid = chatMessageBean.getFromUid();
                                    }
                                    chatMessageBean.setType(3);
                                    chatMessageBean.setRead(false);
                                    chatMessageBean.setUid(O00000o0.getUid());
                                    chatMessageBean.setChatGroup(toUid);
                                }
                                i = chatNewMessageBean.getMessages().size() + 0;
                                O0000O0o.saveOrUpdate(chatNewMessageBean.getMessages());
                            }
                            if (chatNewMessageBean.getSecretary() != null && chatNewMessageBean.getSecretary().size() > 0) {
                                for (ChatMessageBean chatMessageBean2 : chatNewMessageBean.getSecretary()) {
                                    int toUid2 = O00000o0.getUid() == chatMessageBean2.getFromUid() ? chatMessageBean2.getToUid() : 0;
                                    if (O00000o0.getUid() == chatMessageBean2.getToUid()) {
                                        toUid2 = chatMessageBean2.getFromUid();
                                    }
                                    chatMessageBean2.setRead(false);
                                    chatMessageBean2.setUid(O00000o0.getUid());
                                    chatMessageBean2.setChatGroup(toUid2);
                                }
                                i += chatNewMessageBean.getSecretary().size();
                                O0000O0o.saveOrUpdate(chatNewMessageBean.getSecretary());
                            }
                            return Integer.valueOf(i);
                        }

                        /* Access modifiers changed, original: protected */
                        public void onException(Exception exception) throws RuntimeException {
                            super.onException(exception);
                        }

                        /* Access modifiers changed, original: protected */
                        public void onSuccess(Integer num) throws Exception {
                            super.onSuccess(num);
                            if (onChatMessageGetSuccessListener != null) {
                                onChatMessageGetSuccessListener.onSuccess(ChatNewMessageBean.chatConfirm(context, O0000O0o, O00000o0.getUid()), num.intValue());
                            }
                        }
                    }.execute();
                }
            });
        }
        gjVar.setBodyContent(O000o000.O000000o().toJson(new QChatFetch(chatLastMessageTime, chatFriendUIds)));
        return HttpUtil.post(context, gjVar, /* anonymous class already generated */);
    }

    public List<ChatMessageBean> getMessages() {
        return this.messages;
    }

    public List<ChatMessageBean> getSecretary() {
        return this.secretary;
    }

    public List<ChatFriendBean> getUsers() {
        return this.users;
    }

    public void setMessages(List<ChatMessageBean> list) {
        this.messages = list;
    }

    public void setSecretary(List<ChatMessageBean> list) {
        this.secretary = list;
    }

    public void setUsers(List<ChatFriendBean> list) {
        this.users = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChatNewMessageBean{messages=");
        stringBuilder.append(this.messages);
        stringBuilder.append(", secretary=");
        stringBuilder.append(this.secretary);
        stringBuilder.append(", users=");
        stringBuilder.append(this.users);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
