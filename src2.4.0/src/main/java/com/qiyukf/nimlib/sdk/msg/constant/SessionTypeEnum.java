package com.qiyukf.nimlib.sdk.msg.constant;

public enum SessionTypeEnum {
    None(-1),
    P2P(0),
    Team(1),
    Ysf(2),
    System(10001);
    
    private int value;

    private SessionTypeEnum(int i) {
        this.value = i;
    }

    public static SessionTypeEnum typeOfValue(int i) {
        for (SessionTypeEnum sessionTypeEnum : values()) {
            if (sessionTypeEnum.getValue() == i) {
                return sessionTypeEnum;
            }
        }
        return P2P;
    }

    public final int getValue() {
        return this.value;
    }
}
