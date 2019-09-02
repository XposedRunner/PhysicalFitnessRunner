package com.qiyukf.unicorn.api.event;

import android.content.Context;
import com.qiyukf.unicorn.api.event.entry.RequestStaffEntry;

public interface UnicornEventBase<T> {
    void onEvent(T t, Context context, EventCallback<RequestStaffEntry> eventCallback);
}
