package com.zjwh.android_wh_physicalfitness.entity.database;

import java.util.List;
import org.xutils.DbManager;
import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;
import org.xutils.ex.DbException;

@Table(name = "nearby_school")
public class NearBySchoolBean {
    @Column(name = "campusName")
    private String campusName;
    @Column(autoGen = true, isId = true, name = "id")
    private int id;
    @Column(name = "unid")
    private int unid;
    private int viewType = 2;

    public NearBySchoolBean(int i, String str) {
        this.unid = i;
        this.campusName = str;
    }

    public String getCampusName() {
        return this.campusName;
    }

    public int getId() {
        return this.id;
    }

    public List<NearBySchoolBean> getLeftCampusInfo(DbManager dbManager) throws DbException {
        return dbManager.selector(NearBySchoolBean.class).limit(3).findAll();
    }

    public int getUnid() {
        return this.unid;
    }

    public int getViewType() {
        return this.viewType;
    }

    public void setCampusName(String str) {
        this.campusName = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setUnid(int i) {
        this.unid = i;
    }

    public void setViewType(int i) {
        this.viewType = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NearBySchoolBean{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", unid=");
        stringBuilder.append(this.unid);
        stringBuilder.append(", campusName='");
        stringBuilder.append(this.campusName);
        stringBuilder.append('\'');
        stringBuilder.append(", viewType=");
        stringBuilder.append(this.viewType);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
