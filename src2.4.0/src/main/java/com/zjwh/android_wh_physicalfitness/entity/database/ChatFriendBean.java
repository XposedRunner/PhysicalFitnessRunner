package com.zjwh.android_wh_physicalfitness.entity.database;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import org.xutils.DbManager;
import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;
import org.xutils.db.sqlite.WhereBuilder;
import org.xutils.db.table.DbModel;
import org.xutils.ex.DbException;

@Table(name = "chat_friend")
public class ChatFriendBean implements Parcelable {
    public static final Creator<ChatFriendBean> CREATOR = new Creator<ChatFriendBean>() {
        public ChatFriendBean createFromParcel(Parcel parcel) {
            return new ChatFriendBean(parcel);
        }

        public ChatFriendBean[] newArray(int i) {
            return new ChatFriendBean[i];
        }
    };
    public static final int SECRETARY_UID = 217661;
    @Column(name = "avatarUrl")
    private String avatarUrl;
    @Column(name = "forbidden")
    private int forbidden;
    @SerializedName("uid")
    @Column(name = "friendUId")
    private int friendUId;
    @Column(name = "gender")
    private int gender;
    @Column(isId = true, name = "id")
    private String id;
    @Column(name = "interestStatus")
    private int interestStatus;
    @Column(name = "myselfUId")
    private int myselfUId;
    @Column(name = "name")
    private String name;
    @Column(name = "updateTimestamp")
    private long updateTimestamp;

    protected ChatFriendBean(Parcel parcel) {
        this.id = parcel.readString();
        this.avatarUrl = parcel.readString();
        this.gender = parcel.readInt();
        this.interestStatus = parcel.readInt();
        this.name = parcel.readString();
        this.myselfUId = parcel.readInt();
        this.updateTimestamp = parcel.readLong();
        this.friendUId = parcel.readInt();
        this.forbidden = parcel.readInt();
    }

    public static void deleteMessage(DbManager dbManager, int i, int i2) throws DbException {
        dbManager.delete(ChatFriendBean.class, WhereBuilder.b("myselfUId", "=", Integer.valueOf(i)).and("friendUId", "=", Integer.valueOf(i2)));
    }

    public static ChatFriendBean getChatFriendBean(DbManager dbManager, int i, int i2) throws DbException {
        return (ChatFriendBean) dbManager.selector(ChatFriendBean.class).where("myselfUId", "=", Integer.valueOf(i)).and("friendUId", "=", Integer.valueOf(i2)).findFirst();
    }

    public static List<Integer> getChatFriendUIds(DbManager dbManager, int i) throws DbException {
        ArrayList arrayList = new ArrayList();
        List<DbModel> findAll = dbManager.selector(ChatFriendBean.class).select("friendUId").where("myselfUId", "=", Integer.valueOf(i)).findAll();
        if (findAll != null) {
            for (DbModel dbModel : findAll) {
                arrayList.add(Integer.valueOf(dbModel.getInt("friendUId")));
            }
        }
        return arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public int getForbidden() {
        return this.forbidden;
    }

    public int getFriendUId() {
        return this.friendUId;
    }

    public int getGender() {
        return this.gender;
    }

    public String getId() {
        return this.id;
    }

    public int getInterestStatus() {
        return this.interestStatus;
    }

    public int getMyselfUId() {
        return this.myselfUId;
    }

    public String getName() {
        return this.friendUId == SECRETARY_UID ? "小秘书" : this.name;
    }

    public long getUpdateTimestamp() {
        return this.updateTimestamp;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public void setForbidden(int i) {
        this.forbidden = i;
    }

    public void setFriendUId(int i) {
        this.friendUId = i;
    }

    public void setGender(int i) {
        this.gender = i;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setInterestStatus(int i) {
        this.interestStatus = i;
    }

    public void setMyselfUId(int i) {
        this.myselfUId = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setUpdateTimestamp(long j) {
        this.updateTimestamp = j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChatFriendBean{id='");
        stringBuilder.append(this.id);
        stringBuilder.append('\'');
        stringBuilder.append(", avatarUrl='");
        stringBuilder.append(this.avatarUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", gender=");
        stringBuilder.append(this.gender);
        stringBuilder.append(", interestStatus=");
        stringBuilder.append(this.interestStatus);
        stringBuilder.append(", name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", friendUId=");
        stringBuilder.append(this.friendUId);
        stringBuilder.append(", updateTimestamp=");
        stringBuilder.append(this.updateTimestamp);
        stringBuilder.append(", myselfUId=");
        stringBuilder.append(this.myselfUId);
        stringBuilder.append(", forbidden=");
        stringBuilder.append(this.forbidden);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.avatarUrl);
        parcel.writeInt(this.gender);
        parcel.writeInt(this.interestStatus);
        parcel.writeString(this.name);
        parcel.writeInt(this.myselfUId);
        parcel.writeLong(this.updateTimestamp);
        parcel.writeInt(this.friendUId);
        parcel.writeInt(this.forbidden);
    }
}
