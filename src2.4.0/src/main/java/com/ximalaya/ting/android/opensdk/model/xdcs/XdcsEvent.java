package com.ximalaya.ting.android.opensdk.model.xdcs;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class XdcsEvent extends BaseEvent {
    public Map<String, String> props = new HashMap();

    public Map<String, String> getProps() {
        return this.props;
    }

    public void setProps(Map<String, String> map) {
        this.props = map;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("XdcsEvent { ");
        for (Entry entry : this.props.entrySet()) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append((String) entry.getKey());
            stringBuilder2.append(" : ");
            stringBuilder2.append((String) entry.getValue());
            stringBuilder2.append(" ");
            stringBuilder.append(stringBuilder2.toString());
        }
        stringBuilder.append(" } ");
        return stringBuilder.toString();
    }
}
