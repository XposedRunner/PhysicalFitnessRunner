package com.zjwh.android_wh_physicalfitness.entity;

import java.util.List;

public class DueRunComplete {
    private RoomInfoModel roomInfoModel;
    private List<RoomersModel> roomersModelList;

    public RoomInfoModel getRoomInfoModel() {
        return this.roomInfoModel;
    }

    public List<RoomersModel> getRoomersModelList() {
        return this.roomersModelList;
    }

    public void setRoomInfoModel(RoomInfoModel roomInfoModel) {
        this.roomInfoModel = roomInfoModel;
    }

    public void setRoomersModelList(List<RoomersModel> list) {
        this.roomersModelList = list;
    }
}
