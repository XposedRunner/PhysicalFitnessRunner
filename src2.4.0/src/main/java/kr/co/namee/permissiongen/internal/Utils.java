package kr.co.namee.permissiongen.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

public final class Utils {
    private Utils() {
    }

    public static List<Method> findAnnotationMethods(Class cls, Class<? extends Annotation> cls2) {
        return null;
    }

    @TargetApi(23)
    public static List<String> findDeniedPermissions(Activity activity, String... strArr) {
        return null;
    }

    public static <A extends Annotation> Method findMethodPermissionFailWithRequestCode(Class cls, Class<A> cls2, int i) {
        return null;
    }

    public static <A extends Annotation> Method findMethodPermissionSuccessWithRequestCode(Class cls, Class<A> cls2, int i) {
        return null;
    }

    public static <A extends Annotation> Method findMethodWithRequestCode(Class cls, Class<A> cls2, int i) {
        return null;
    }

    public static Activity getActivity(Object obj) {
        return null;
    }

    public static boolean isEqualRequestCodeFromAnntation(Method method, Class cls, int i) {
        return false;
    }

    public static boolean isOverMarshmallow() {
        return false;
    }
}
