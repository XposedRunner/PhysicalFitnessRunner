package com.tencent.mm.opensdk.diffdev.a;

import com.alibaba.wireless.security.SecExceptionCode;

public enum g {
    UUID_EXPIRED(SecExceptionCode.SEC_ERROR_DYN_ENC_NO_MEMORY),
    UUID_CANCELED(SecExceptionCode.SEC_ERROR_DYN_ENC_GET_SYS_PROPERTIES_FAILED),
    UUID_SCANED(404),
    UUID_CONFIRM(SecExceptionCode.SEC_ERROR_DYN_ENC_GET_ENCRYPT_KEY_FAILED),
    UUID_KEEP_CONNECT(408),
    UUID_ERROR(500);
    
    private int code;

    private g(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("UUIDStatusCode:");
        stringBuilder.append(this.code);
        return stringBuilder.toString();
    }
}
