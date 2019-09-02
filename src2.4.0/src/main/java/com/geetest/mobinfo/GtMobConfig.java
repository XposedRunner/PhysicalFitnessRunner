package com.geetest.mobinfo;

import com.bangcle.andJni.JniLib1557756502;
import java.util.HashMap;
import java.util.Map;

public class GtMobConfig implements ConfigInterface {
    private boolean globalHelper;
    private Map<String, Object> mobDataMap;
    private Map<String, Object> mobDeviceMap;
    private Map<String, Object> mobMap;

    public static class Builder {
        private boolean globalHelper = false;
        private Map<String, Object> mobDataMap = new HashMap();
        private Map<String, Object> mobDeviceMap = new HashMap();
        private Map<String, Object> mobMap = new HashMap();

        public Builder addDataOutParam(String str, Object obj) {
            return (Builder) JniLib1557756502.cL(this, str, obj, Integer.valueOf(101));
        }

        public Builder addDeviceOutParam(String str, Object obj) {
            return (Builder) JniLib1557756502.cL(this, str, obj, Integer.valueOf(102));
        }

        public Builder addParam(String str, Object obj) {
            return (Builder) JniLib1557756502.cL(this, str, obj, Integer.valueOf(103));
        }

        public GtMobConfig build() {
            return new GtMobConfig(this);
        }

        public Builder setGlobalHelper(boolean z) {
            this.globalHelper = z;
            return this;
        }
    }

    private GtMobConfig(Builder builder) {
        this.mobMap = builder.mobMap;
        this.mobDeviceMap = builder.mobDeviceMap;
        this.mobDataMap = builder.mobDataMap;
        this.globalHelper = builder.globalHelper;
    }

    public static Builder builder() {
        return (Builder) JniLib1557756502.cL(Integer.valueOf(104));
    }

    public boolean getGlobalHelper() {
        return this.globalHelper;
    }

    public Map<String, Object> getMobDataMap() {
        return this.mobDataMap;
    }

    public Map<String, Object> getMobDeviceMap() {
        return this.mobDeviceMap;
    }

    public Map<String, Object> getMobMap() {
        return this.mobMap;
    }
}
