package com.zjwh.android_wh_physicalfitness.entity.database;

import com.google.gson.annotations.SerializedName;
import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

@Table(name = "user_info")
public class UserInfo {
    @Column(name = "alias")
    private String alias;
    @SerializedName(alternate = {"bicon"}, value = "bIcon")
    @Column(name = "bIcon")
    private String bIcon;
    @Column(name = "campusId")
    private String campusId;
    @Column(name = "campusName")
    private String campusName;
    @Column(name = "classId")
    private int classId;
    @Column(name = "completeType")
    private int completeType;
    @Column(name = "depart")
    private String depart;
    @Column(name = "departmentId")
    private int departmentId;
    @Column(name = "departmentSecret")
    private int departmentSecret;
    @Column(name = "enrollmentYear")
    private int enrollmentYear;
    private boolean given;
    @Column(name = "gradeClass")
    private String gradeClass;
    @Column(name = "hasEnum")
    private boolean hasEnum;
    @Column(name = "height")
    private float height;
    @Column(name = "icon")
    private String icon;
    @Column(name = "infoComplete")
    private boolean infoComplete;
    @Column(name = "logout")
    private boolean logout;
    @Column(name = "name")
    private String name;
    @Column(name = "nameSecret")
    private int nameSecret;
    @Column(name = "nick")
    private String nick;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "psign")
    private String psign;
    @Column(name = "psw")
    private String psw;
    @Column(name = "registed")
    private boolean registed;
    @Column(name = "role")
    private int role;
    @Column(name = "sex")
    private int sex = -1;
    @Column(name = "showClassEnum")
    private boolean showClassEnum;
    @Column(name = "timestamp")
    private long timestamp;
    @Column(name = "token")
    private String token;
    @Column(autoGen = false, isId = true, name = "uid")
    private int uid;
    @Column(name = "unid")
    private int unid;
    @Column(name = "userTag")
    private String userTag;
    @Column(name = "username")
    private String username;
    @Column(name = "weight")
    private float weight = 0.0f;
    @Column(name = "yearSecret")
    private int yearSecret;

    public String getAlias() {
        return this.alias;
    }

    public String getCampusId() {
        return this.campusId;
    }

    public String getCampusName() {
        return this.campusName;
    }

    public int getClassId() {
        return this.classId;
    }

    public int getCompleteType() {
        return this.completeType;
    }

    public String getDepart() {
        return this.depart;
    }

    public int getDepartmentId() {
        return this.departmentId;
    }

    public int getDepartmentSecret() {
        return this.departmentSecret;
    }

    public int getEnrollmentYear() {
        return this.enrollmentYear;
    }

    public String getGradeClass() {
        return this.gradeClass;
    }

    public float getHeight() {
        return this.height;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getName() {
        return this.name;
    }

    public int getNameSecret() {
        return this.nameSecret;
    }

    public String getNick() {
        return this.nick;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getPsign() {
        return this.psign;
    }

    public String getPsw() {
        return this.psw;
    }

    public int getRole() {
        return this.role;
    }

    public int getSex() {
        return this.sex;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getToken() {
        return this.token;
    }

    public int getUid() {
        return this.uid;
    }

    public int getUnid() {
        return this.unid;
    }

    public String getUserTag() {
        return this.userTag;
    }

    public String getUsername() {
        return this.username;
    }

    public float getWeight() {
        return this.weight;
    }

    public int getYearSecret() {
        return this.yearSecret;
    }

    public String getbIcon() {
        return this.bIcon;
    }

    public boolean isGiven() {
        return this.given;
    }

    public boolean isHasEnum() {
        return this.hasEnum;
    }

    public boolean isInfoComplete() {
        return this.infoComplete;
    }

    public boolean isLogout() {
        return this.logout;
    }

    public boolean isRegisted() {
        return this.registed;
    }

    public boolean isShowClassEnum() {
        return this.showClassEnum;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setCampusId(String str) {
        this.campusId = str;
    }

    public void setCampusName(String str) {
        this.campusName = str;
    }

    public void setClassId(int i) {
        this.classId = i;
    }

    public void setCompleteType(int i) {
        this.completeType = i;
    }

    public void setDepart(String str) {
        this.depart = str;
    }

    public void setDepartmentId(int i) {
        this.departmentId = i;
    }

    public void setDepartmentSecret(int i) {
        this.departmentSecret = i;
    }

    public void setEnrollmentYear(int i) {
        this.enrollmentYear = i;
    }

    public void setGiven(boolean z) {
        this.given = z;
    }

    public void setGradeClass(String str) {
        this.gradeClass = str;
    }

    public void setHasEnum(boolean z) {
        this.hasEnum = z;
    }

    public void setHeight(float f) {
        this.height = f;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setInfoComplete(boolean z) {
        this.infoComplete = z;
    }

    public void setLogout(boolean z) {
        this.logout = z;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNameSecret(int i) {
        this.nameSecret = i;
    }

    public void setNick(String str) {
        this.nick = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setPsign(String str) {
        this.psign = str;
    }

    public void setPsw(String str) {
        this.psw = str;
    }

    public void setRegisted(boolean z) {
        this.registed = z;
    }

    public void setRole(int i) {
        this.role = i;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public void setShowClassEnum(boolean z) {
        this.showClassEnum = z;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setUid(int i) {
        this.uid = i;
    }

    public void setUnid(int i) {
        this.unid = i;
    }

    public void setUserTag(String str) {
        this.userTag = str;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public void setWeight(float f) {
        this.weight = f;
    }

    public void setYearSecret(int i) {
        this.yearSecret = i;
    }

    public void setbIcon(String str) {
        this.bIcon = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UserInfo{campusId='");
        stringBuilder.append(this.campusId);
        stringBuilder.append('\'');
        stringBuilder.append(", depart='");
        stringBuilder.append(this.depart);
        stringBuilder.append('\'');
        stringBuilder.append(", icon='");
        stringBuilder.append(this.icon);
        stringBuilder.append('\'');
        stringBuilder.append(", name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", nick='");
        stringBuilder.append(this.nick);
        stringBuilder.append('\'');
        stringBuilder.append(", nickname='");
        stringBuilder.append(this.nickname);
        stringBuilder.append('\'');
        stringBuilder.append(", psign='");
        stringBuilder.append(this.psign);
        stringBuilder.append('\'');
        stringBuilder.append(", sex=");
        stringBuilder.append(this.sex);
        stringBuilder.append(", uid=");
        stringBuilder.append(this.uid);
        stringBuilder.append(", unid=");
        stringBuilder.append(this.unid);
        stringBuilder.append(", username='");
        stringBuilder.append(this.username);
        stringBuilder.append('\'');
        stringBuilder.append(", timestamp=");
        stringBuilder.append(this.timestamp);
        stringBuilder.append(", token='");
        stringBuilder.append(this.token);
        stringBuilder.append('\'');
        stringBuilder.append(", psw='");
        stringBuilder.append(this.psw);
        stringBuilder.append('\'');
        stringBuilder.append(", logout=");
        stringBuilder.append(this.logout);
        stringBuilder.append(", registed=");
        stringBuilder.append(this.registed);
        stringBuilder.append(", role=");
        stringBuilder.append(this.role);
        stringBuilder.append(", enrollmentYear=");
        stringBuilder.append(this.enrollmentYear);
        stringBuilder.append(", alias='");
        stringBuilder.append(this.alias);
        stringBuilder.append('\'');
        stringBuilder.append(", userTag='");
        stringBuilder.append(this.userTag);
        stringBuilder.append('\'');
        stringBuilder.append(", nameSecret=");
        stringBuilder.append(this.nameSecret);
        stringBuilder.append(", departmentSecret=");
        stringBuilder.append(this.departmentSecret);
        stringBuilder.append(", yearSecret=");
        stringBuilder.append(this.yearSecret);
        stringBuilder.append(", campusName='");
        stringBuilder.append(this.campusName);
        stringBuilder.append('\'');
        stringBuilder.append(", bIcon='");
        stringBuilder.append(this.bIcon);
        stringBuilder.append('\'');
        stringBuilder.append(", infoComplete=");
        stringBuilder.append(this.infoComplete);
        stringBuilder.append(", completeType=");
        stringBuilder.append(this.completeType);
        stringBuilder.append(", departmentId=");
        stringBuilder.append(this.departmentId);
        stringBuilder.append(", hasEnum=");
        stringBuilder.append(this.hasEnum);
        stringBuilder.append(", height=");
        stringBuilder.append(this.height);
        stringBuilder.append(", weight=");
        stringBuilder.append(this.weight);
        stringBuilder.append(", gradeClass='");
        stringBuilder.append(this.gradeClass);
        stringBuilder.append('\'');
        stringBuilder.append(", classId=");
        stringBuilder.append(this.classId);
        stringBuilder.append(", showClassEnum=");
        stringBuilder.append(this.showClassEnum);
        stringBuilder.append(", given=");
        stringBuilder.append(this.given);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
