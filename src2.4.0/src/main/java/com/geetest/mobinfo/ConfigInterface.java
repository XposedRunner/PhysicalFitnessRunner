package com.geetest.mobinfo;

import java.util.Map;

public interface ConfigInterface {
    boolean getGlobalHelper();

    Map<String, Object> getMobDataMap();

    Map<String, Object> getMobDeviceMap();

    Map<String, Object> getMobMap();
}
