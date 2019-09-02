package com.qiyukf.unicorn.api.customization.action;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.InputDeviceCompat;
import com.qiyukf.nim.uikit.session.module.a;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.api.msg.UnicornMessageBuilder;
import java.io.File;
import java.io.Serializable;

public abstract class BaseAction implements Serializable {
    private transient a container;
    private int iconResId;
    private transient int index;
    private int titleId;

    public BaseAction(int i, int i2) {
        this.iconResId = i;
        this.titleId = i2;
    }

    public final IMMessage buidlImageMessage(File file) {
        return UnicornMessageBuilder.buildImageMessage(getAccount(), file, file.getName());
    }

    public final IMMessage buildTextMessage(String str) {
        return UnicornMessageBuilder.buildTextMessage(getAccount(), str);
    }

    public final String getAccount() {
        return this.container.c;
    }

    public int getActionFontColor() {
        return -3407617;
    }

    public final Activity getActivity() {
        return this.container.a;
    }

    public final Fragment getFragment() {
        return this.container.b;
    }

    public int getIconResId() {
        return this.iconResId;
    }

    public int getTitleId() {
        return this.titleId;
    }

    /* Access modifiers changed, original: protected|final */
    public final int makeRequestCode(int i) {
        if ((i & InputDeviceCompat.SOURCE_ANY) == 0) {
            return ((this.index + 1) << 8) + (i & 255);
        }
        throw new IllegalArgumentException("Can only use lower 8 bits for requestCode");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public abstract void onClick();

    public void setContainer(a aVar) {
        this.container = aVar;
    }

    public void setIndex(int i) {
        this.index = i;
    }
}
