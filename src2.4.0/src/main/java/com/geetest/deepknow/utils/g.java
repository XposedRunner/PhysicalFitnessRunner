package com.geetest.deepknow.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.bangcle.andJni.JniLib1557756502;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* compiled from: DPSharedPreferencesLoader */
public class g {
    private final Executor a = Executors.newSingleThreadExecutor();

    /* compiled from: DPSharedPreferencesLoader */
    public interface b {
        void a(SharedPreferences sharedPreferences);
    }

    /* compiled from: DPSharedPreferencesLoader */
    private static class a implements Callable<SharedPreferences> {
        private final Context a;
        private final String b;
        private final b c;

        public a(Context context, String str, b bVar) {
            this.a = context;
            this.b = str;
            this.c = bVar;
        }

        /* renamed from: a */
        public SharedPreferences call() {
            return (SharedPreferences) JniLib1557756502.cL(this, Integer.valueOf(83));
        }
    }

    public Future<SharedPreferences> a(Context context, String str, b bVar) {
        return (Future) JniLib1557756502.cL(this, context, str, bVar, Integer.valueOf(84));
    }
}
