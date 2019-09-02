package org.xutils.common;

import java.lang.reflect.Type;

public interface Callback {

    public interface CommonCallback<ResultType> extends Callback {
        void onCancelled(CancelledException cancelledException);

        void onError(Throwable th, boolean z);

        void onFinished();

        void onSuccess(ResultType resultType);
    }

    public interface ProgressCallback<ResultType> extends CommonCallback<ResultType> {
        void onLoading(long j, long j2, boolean z);

        void onStarted();

        void onWaiting();
    }

    public interface CacheCallback<ResultType> extends CommonCallback<ResultType> {
        boolean onCache(ResultType resultType);
    }

    public interface Callable<ResultType> {
        void call(ResultType resultType);
    }

    public interface Cancelable {
        void cancel();

        boolean isCancelled();
    }

    public static class CancelledException extends RuntimeException {
        public CancelledException(String str) {
            super(str);
        }
    }

    public interface GroupCallback<ItemType> extends Callback {
        void onAllFinished();

        void onCancelled(ItemType itemType, CancelledException cancelledException);

        void onError(ItemType itemType, Throwable th, boolean z);

        void onFinished(ItemType itemType);

        void onSuccess(ItemType itemType);
    }

    public interface PrepareCallback<PrepareType, ResultType> extends CommonCallback<ResultType> {
        ResultType prepare(PrepareType prepareType);
    }

    public interface ProxyCacheCallback<ResultType> extends CacheCallback<ResultType> {
        boolean onlyCache();
    }

    public interface TypedCallback<ResultType> extends CommonCallback<ResultType> {
        Type getLoadType();
    }
}
