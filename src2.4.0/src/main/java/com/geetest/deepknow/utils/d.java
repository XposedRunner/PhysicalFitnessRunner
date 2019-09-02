package com.geetest.deepknow.utils;

import android.content.SharedPreferences;
import com.bangcle.andJni.JniLib1557756502;
import java.util.concurrent.Future;

/* compiled from: DPPersistentFirstStart */
public class d extends e<Boolean> {
    public d(Future<SharedPreferences> future) {
        super(future, "first_start", new a<Boolean>() {
            /* renamed from: a */
            public Boolean b() {
                return Boolean.valueOf(true);
            }

            /* renamed from: a */
            public Boolean b(String str) {
                return (Boolean) JniLib1557756502.cL(this, str, Integer.valueOf(76));
            }

            public String a(Boolean bool) {
                return (String) JniLib1557756502.cL(this, bool, Integer.valueOf(77));
            }
        });
    }
}
