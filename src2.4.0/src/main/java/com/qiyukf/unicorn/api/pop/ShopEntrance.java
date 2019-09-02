package com.qiyukf.unicorn.api.pop;

import java.io.Serializable;

public class ShopEntrance implements Serializable {
    private String logo;
    private String name;

    public static class Builder {
        private ShopEntrance shopEntrance = new ShopEntrance();

        public ShopEntrance build() {
            return this.shopEntrance;
        }

        public Builder setLogo(String str) {
            this.shopEntrance.logo = str;
            return this;
        }

        public Builder setName(String str) {
            this.shopEntrance.name = str;
            return this;
        }
    }

    private ShopEntrance() {
    }

    public String getLogo() {
        return this.logo;
    }

    public String getName() {
        return this.name;
    }
}
