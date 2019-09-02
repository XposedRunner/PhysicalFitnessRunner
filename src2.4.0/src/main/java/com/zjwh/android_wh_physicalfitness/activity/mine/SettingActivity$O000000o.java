package com.zjwh.android_wh_physicalfitness.activity.mine;

import android.content.Context;
import android.os.AsyncTask;
import com.zjwh.android_wh_physicalfitness.utils.O000OOo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import defpackage.O00Oo;
import java.lang.ref.WeakReference;

class SettingActivity$O000000o extends AsyncTask<Void, Void, Void> {
    private WeakReference<SettingActivity> O000000o;

    SettingActivity$O000000o(SettingActivity settingActivity) {
        this.O000000o = new WeakReference(settingActivity);
    }

    /* Access modifiers changed, original: protected|varargs */
    /* renamed from: O000000o */
    public Void doInBackground(Void... voidArr) {
        O00Oo.O00000Oo((Context) this.O000000o.get()).O0000Ooo();
        return null;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: O000000o */
    public void onPostExecute(Void voidR) {
        super.onPostExecute(voidR);
        SettingActivity settingActivity = (SettingActivity) this.O000000o.get();
        if (settingActivity != null && !settingActivity.isFinishing()) {
            O00Oo00.O000000o("清理成功", true);
            settingActivity.O00000Oo.setText(O000OOo0.O000000o().O00000o(settingActivity));
        }
    }
}
