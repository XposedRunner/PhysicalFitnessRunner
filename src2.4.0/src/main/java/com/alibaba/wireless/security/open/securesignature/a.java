package com.alibaba.wireless.security.open.securesignature;

import com.alibaba.wireless.security.mainplugin.SecurityGuardMainPlugin;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent;
import com.taobao.wireless.security.adapter.a.b;
import java.util.HashMap;

public class a implements ISecureSignatureComponent {
    private b a;
    private ISecurityGuardPlugin b = null;

    public a(SecurityGuardMainPlugin securityGuardMainPlugin) {
        init(securityGuardMainPlugin, new Object[0]);
    }

    public String getSafeCookie(String str, String str2, String str3) throws SecException {
        try {
            ISecureSignatureComponent iSecureSignatureComponent = (ISecureSignatureComponent) this.b.getInterface(ISecureSignatureComponent.class);
            IStaticDataEncryptComponent iStaticDataEncryptComponent = (IStaticDataEncryptComponent) this.b.getInterface(IStaticDataEncryptComponent.class);
            HashMap hashMap = new HashMap();
            hashMap.put("INPUT", str);
            SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
            securityGuardParamContext.appKey = str2;
            securityGuardParamContext.paramMap = hashMap;
            securityGuardParamContext.requestType = 3;
            String signRequest = iSecureSignatureComponent.signRequest(securityGuardParamContext, str3);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(signRequest);
            stringBuilder.append(str);
            str = iStaticDataEncryptComponent.staticSafeEncrypt(16, str2, stringBuilder.toString(), str3);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("AE001");
            stringBuilder2.append(str);
            return stringBuilder2.toString();
        } catch (SecException e) {
            if (e.getErrorCode() > 600 && e.getErrorCode() < 699) {
                throw e;
            } else if (e.getErrorCode() == 302) {
                throw new SecException(607);
            } else if (e.getErrorCode() == 303) {
                throw new SecException(608);
            } else if (e.getErrorCode() == 304) {
                throw new SecException(609);
            } else if (e.getErrorCode() == 305) {
                throw new SecException(610);
            } else if (e.getErrorCode() == 306) {
                throw new SecException(611);
            } else if (e.getErrorCode() == 307) {
                throw new SecException(612);
            } else if (e.getErrorCode() == 308) {
                throw new SecException(602);
            } else {
                throw new SecException(699);
            }
        }
    }

    public int init(ISecurityGuardPlugin iSecurityGuardPlugin, Object... objArr) {
        this.a = new b(iSecurityGuardPlugin);
        this.b = iSecurityGuardPlugin;
        return 0;
    }

    public String signRequest(SecurityGuardParamContext securityGuardParamContext, String str) throws SecException {
        return (securityGuardParamContext == null || securityGuardParamContext.paramMap == null) ? null : this.a.a(securityGuardParamContext, str, true);
    }
}
