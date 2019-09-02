package com.umeng.commonsdk.statistics.proto;

import com.umeng.commonsdk.proguard.n;

public enum Gender implements n {
    MALE(0),
    FEMALE(1),
    UNKNOWN(2);
    
    private final int value;

    private Gender(int i) {
        this.value = i;
    }

    public static Gender findByValue(int i) {
        switch (i) {
            case 0:
                return MALE;
            case 1:
                return FEMALE;
            case 2:
                return UNKNOWN;
            default:
                return null;
        }
    }

    public int getValue() {
        return this.value;
    }
}
