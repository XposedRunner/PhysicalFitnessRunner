package org.xutils.view.annotation;

import android.view.View.OnClickListener;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Event {
    String method() default "";

    int[] parentId() default {0};

    String setter() default "";

    Class<?> type() default OnClickListener.class;

    int[] value();
}
