package com.zjwh.android_wh_physicalfitness.entity;

import java.util.List;

public class SignReqModel {
    public int cid;
    public List<SignResModel> stuSignReqModels;

    public SignReqModel(int i, List<SignResModel> list) {
        this.cid = i;
        this.stuSignReqModels = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SignReqModel{cid=");
        stringBuilder.append(this.cid);
        stringBuilder.append(", signResModels=");
        stringBuilder.append(this.stuSignReqModels);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
