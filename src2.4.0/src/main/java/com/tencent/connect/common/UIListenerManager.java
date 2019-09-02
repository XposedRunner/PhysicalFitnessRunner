package com.tencent.connect.common;

import android.content.Intent;
import com.tencent.open.a.f;
import com.tencent.open.utils.h;
import com.tencent.open.utils.j;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class UIListenerManager {
    private static UIListenerManager a;
    private Map<String, ApiTask> b = Collections.synchronizedMap(new HashMap());

    /* compiled from: ProGuard */
    public class ApiTask {
        public IUiListener mListener;
        public int mRequestCode;

        public ApiTask(int i, IUiListener iUiListener) {
            this.mRequestCode = i;
            this.mListener = iUiListener;
        }
    }

    private UIListenerManager() {
        if (this.b == null) {
            this.b = Collections.synchronizedMap(new HashMap());
        }
    }

    private IUiListener a(int i, IUiListener iUiListener) {
        if (i == Constants.REQUEST_LOGIN) {
            f.e("openSDK_LOG.UIListenerManager", "登录的接口回调不能重新构建，暂时无法提供，先记录下来这种情况是否存在");
        } else if (i == Constants.REQUEST_SOCIAL_API) {
            f.e("openSDK_LOG.UIListenerManager", "Social Api 的接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
        } else if (i == Constants.REQUEST_SOCIAL_H5) {
            f.e("openSDK_LOG.UIListenerManager", "Social Api 的H5接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
        }
        return iUiListener;
    }

    public static UIListenerManager getInstance() {
        if (a == null) {
            a = new UIListenerManager();
        }
        return a;
    }

    public IUiListener getListnerWithAction(String str) {
        if (str == null) {
            f.e("openSDK_LOG.UIListenerManager", "getListnerWithAction action is null!");
            return null;
        }
        ApiTask apiTask;
        synchronized (this.b) {
            apiTask = (ApiTask) this.b.get(str);
            this.b.remove(str);
        }
        return apiTask == null ? null : apiTask.mListener;
    }

    public IUiListener getListnerWithRequestCode(int i) {
        String a = h.a(i);
        if (a != null) {
            return getListnerWithAction(a);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getListner action is null! rquestCode=");
        stringBuilder.append(i);
        f.e("openSDK_LOG.UIListenerManager", stringBuilder.toString());
        return null;
    }

    public void handleDataToListener(Intent intent, IUiListener iUiListener) {
        f.c("openSDK_LOG.UIListenerManager", "handleDataToListener");
        if (intent == null) {
            iUiListener.onCancel();
            return;
        }
        String stringExtra = intent.getStringExtra(Constants.KEY_ACTION);
        String stringExtra2;
        if ("action_login".equals(stringExtra)) {
            int intExtra = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
            if (intExtra == 0) {
                stringExtra2 = intent.getStringExtra(Constants.KEY_RESPONSE);
                if (stringExtra2 != null) {
                    try {
                        iUiListener.onComplete(j.d(stringExtra2));
                    } catch (JSONException e) {
                        iUiListener.onError(new UiError(-4, Constants.MSG_JSON_ERROR, stringExtra2));
                        f.b("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", e);
                    }
                } else {
                    f.b("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
                    iUiListener.onComplete(new JSONObject());
                }
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("OpenUi, onActivityResult, onError = ");
                stringBuilder.append(intExtra);
                stringBuilder.append("");
                f.e("openSDK_LOG.UIListenerManager", stringBuilder.toString());
                iUiListener.onError(new UiError(intExtra, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL)));
            }
        } else if ("action_share".equals(stringExtra)) {
            stringExtra = intent.getStringExtra("result");
            stringExtra2 = intent.getStringExtra("response");
            StringBuilder stringBuilder2;
            if ("cancel".equals(stringExtra)) {
                iUiListener.onCancel();
            } else if ("error".equals(stringExtra)) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(stringExtra2);
                stringBuilder2.append("");
                iUiListener.onError(new UiError(-6, "unknown error", stringBuilder2.toString()));
            } else if ("complete".equals(stringExtra)) {
                try {
                    iUiListener.onComplete(new JSONObject(stringExtra2 == null ? "{\"ret\": 0}" : stringExtra2));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(stringExtra2);
                    stringBuilder2.append("");
                    iUiListener.onError(new UiError(-4, "json error", stringBuilder2.toString()));
                }
            }
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent, IUiListener iUiListener) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onActivityResult req=");
        stringBuilder.append(i);
        stringBuilder.append(" res=");
        stringBuilder.append(i2);
        f.c("openSDK_LOG.UIListenerManager", stringBuilder.toString());
        IUiListener listnerWithRequestCode = getListnerWithRequestCode(i);
        if (listnerWithRequestCode == null) {
            if (iUiListener != null) {
                listnerWithRequestCode = a(i, iUiListener);
            } else {
                f.e("openSDK_LOG.UIListenerManager", "onActivityResult can't find the listener");
                return false;
            }
        }
        if (i2 != -1) {
            listnerWithRequestCode.onCancel();
        } else if (intent == null) {
            listnerWithRequestCode.onError(new UiError(-6, "onActivityResult intent data is null.", "onActivityResult intent data is null."));
            return true;
        } else {
            String stringExtra = intent.getStringExtra(Constants.KEY_ACTION);
            String stringExtra2;
            if ("action_login".equals(stringExtra)) {
                i = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
                if (i == 0) {
                    stringExtra2 = intent.getStringExtra(Constants.KEY_RESPONSE);
                    if (stringExtra2 != null) {
                        try {
                            listnerWithRequestCode.onComplete(j.d(stringExtra2));
                        } catch (JSONException e) {
                            listnerWithRequestCode.onError(new UiError(-4, Constants.MSG_JSON_ERROR, stringExtra2));
                            f.b("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", e);
                        }
                    } else {
                        f.b("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
                        listnerWithRequestCode.onComplete(new JSONObject());
                    }
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("OpenUi, onActivityResult, onError = ");
                    stringBuilder.append(i);
                    stringBuilder.append("");
                    f.e("openSDK_LOG.UIListenerManager", stringBuilder.toString());
                    listnerWithRequestCode.onError(new UiError(i, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL)));
                }
            } else if ("action_share".equals(stringExtra)) {
                stringExtra = intent.getStringExtra("result");
                String stringExtra3 = intent.getStringExtra("response");
                if ("cancel".equals(stringExtra)) {
                    listnerWithRequestCode.onCancel();
                } else if ("error".equals(stringExtra)) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(stringExtra3);
                    stringBuilder2.append("");
                    listnerWithRequestCode.onError(new UiError(-6, "unknown error", stringBuilder2.toString()));
                } else if ("complete".equals(stringExtra)) {
                    try {
                        listnerWithRequestCode.onComplete(new JSONObject(stringExtra3 == null ? "{\"ret\": 0}" : stringExtra3));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(stringExtra3);
                        stringBuilder.append("");
                        listnerWithRequestCode.onError(new UiError(-4, "json error", stringBuilder.toString()));
                    }
                }
            } else {
                i = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
                if (i == 0) {
                    stringExtra2 = intent.getStringExtra(Constants.KEY_RESPONSE);
                    if (stringExtra2 != null) {
                        try {
                            listnerWithRequestCode.onComplete(j.d(stringExtra2));
                        } catch (JSONException unused) {
                            listnerWithRequestCode.onError(new UiError(-4, Constants.MSG_JSON_ERROR, stringExtra2));
                        }
                    } else {
                        listnerWithRequestCode.onComplete(new JSONObject());
                    }
                } else {
                    listnerWithRequestCode.onError(new UiError(i, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL)));
                }
            }
        }
        return true;
    }

    public Object setListenerWithRequestcode(int i, IUiListener iUiListener) {
        String a = h.a(i);
        if (a == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("setListener action is null! rquestCode=");
            stringBuilder.append(i);
            f.e("openSDK_LOG.UIListenerManager", stringBuilder.toString());
            return null;
        }
        ApiTask apiTask;
        synchronized (this.b) {
            apiTask = (ApiTask) this.b.put(a, new ApiTask(i, iUiListener));
        }
        return apiTask == null ? null : apiTask.mListener;
    }

    public Object setListnerWithAction(String str, IUiListener iUiListener) {
        int a = h.a(str);
        if (a == -1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("setListnerWithAction fail, action = ");
            stringBuilder.append(str);
            f.e("openSDK_LOG.UIListenerManager", stringBuilder.toString());
            return null;
        }
        ApiTask apiTask;
        synchronized (this.b) {
            apiTask = (ApiTask) this.b.put(str, new ApiTask(a, iUiListener));
        }
        return apiTask == null ? null : apiTask.mListener;
    }
}
