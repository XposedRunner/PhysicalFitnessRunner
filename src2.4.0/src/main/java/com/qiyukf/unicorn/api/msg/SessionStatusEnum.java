package com.qiyukf.unicorn.api.msg;

import com.alibaba.wireless.security.SecExceptionCode;

public enum SessionStatusEnum {
    NONE(-1),
    IN_SESSION(200),
    IN_QUEUE(SecExceptionCode.SEC_ERROR_STA_STORE_NO_DATA_FILE);
    
    private int value;

    private SessionStatusEnum(int i) {
        this.value = i;
    }

    public static SessionStatusEnum valueOf(int i) {
        for (SessionStatusEnum sessionStatusEnum : values()) {
            if (sessionStatusEnum.value() == i) {
                return sessionStatusEnum;
            }
        }
        return NONE;
    }

    public final int value() {
        return this.value;
    }
}
