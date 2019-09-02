package com.ximalaya.ting.android.opensdk.util;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.gson.Gson;
import java.lang.reflect.Type;

public class AsyncGson<T> extends MyAsyncTask<Object, Void, Object> {
    private IResult<T> iResult;
    private IResult<T> iResultOnThread;

    public interface IResult<T> {
        void postException(Exception exception);

        void postResult(T t);
    }

    /* Access modifiers changed, original: protected */
    public Object doInBackground(Object[] objArr) {
        if (objArr.length == 1) {
            try {
                String toJson = new Gson().toJson(objArr[0]);
                if (this.iResultOnThread != null) {
                    this.iResultOnThread.postResult(toJson);
                }
                return toJson;
            } catch (Exception e) {
                e.printStackTrace();
                if (this.iResultOnThread != null) {
                    this.iResultOnThread.postException(e);
                }
                return e;
            }
        } else if (objArr.length != 2) {
            return new Exception("params is error");
        } else {
            if (objArr[1] instanceof Type) {
                try {
                    return new Gson().fromJson((String) objArr[0], (Type) objArr[1]);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return e2;
                }
            }
            try {
                return new Gson().fromJson((String) objArr[0], (Class) objArr[1]);
            } catch (Exception e22) {
                e22.printStackTrace();
                return e22;
            }
        }
    }

    public void fromJson(String str, Class<T> cls, @NonNull IResult<T> iResult) {
        this.iResult = iResult;
        if (TextUtils.isEmpty(str) || cls == null) {
            iResult.postException(new Exception("IllegalArgument"));
            return;
        }
        myexec(str, cls);
    }

    public void fromJson(String str, Type type, @NonNull IResult<T> iResult) {
        this.iResult = iResult;
        if (TextUtils.isEmpty(str) || type == null) {
            iResult.postException(new Exception("IllegalArgument"));
            return;
        }
        myexec(str, type);
    }

    /* Access modifiers changed, original: protected */
    public void onPostExecute(Object obj) {
        super.onPostExecute(obj);
        if (this.iResult == null) {
            return;
        }
        if (obj instanceof Exception) {
            this.iResult.postException((Exception) obj);
        } else {
            this.iResult.postResult(obj);
        }
    }

    public void toJson(Object obj, @NonNull IResult<T> iResult) {
        this.iResult = iResult;
        if (obj == null) {
            iResult.postException(new Exception("IllegalArgument"));
            return;
        }
        myexec(obj);
    }

    public void toJsonResultOnThread(Object obj, @NonNull IResult iResult) {
        this.iResultOnThread = iResult;
        if (obj == null) {
            iResult.postException(new Exception("IllegalArgument"));
            return;
        }
        myexec(obj);
    }
}
