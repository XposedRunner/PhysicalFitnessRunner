package com.ximalaya.ting.android.opensdk.model.live.radio;

import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class RadioListById extends XimalayaResponse {
    private List<Radio> radios;

    public List<Radio> getRadios() {
        return this.radios;
    }

    public void setRadios(List<Radio> list) {
        this.radios = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RadioListById [radios=");
        stringBuilder.append(this.radios);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
