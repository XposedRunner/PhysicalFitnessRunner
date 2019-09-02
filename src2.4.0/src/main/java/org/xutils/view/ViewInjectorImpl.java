package org.xutils.view;

import android.app.Activity;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import org.xutils.ViewInjector;
import org.xutils.common.util.LogUtil;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x.Ext;

public final class ViewInjectorImpl implements ViewInjector {
    private static final HashSet<Class<?>> IGNORED = new HashSet();
    private static volatile ViewInjectorImpl instance;
    private static final Object lock = new Object();

    static {
        IGNORED.add(Object.class);
        IGNORED.add(Activity.class);
        IGNORED.add(Fragment.class);
        try {
            IGNORED.add(Class.forName("android.support.v4.app.Fragment"));
            IGNORED.add(Class.forName("android.support.v4.app.FragmentActivity"));
        } catch (Throwable unused) {
        }
    }

    private ViewInjectorImpl() {
    }

    private static ContentView findContentView(Class<?> cls) {
        if (cls == null || IGNORED.contains(cls)) {
            return null;
        }
        ContentView contentView = (ContentView) cls.getAnnotation(ContentView.class);
        return contentView == null ? findContentView(cls.getSuperclass()) : contentView;
    }

    private static void injectObject(Object obj, Class<?> cls, ViewFinder viewFinder) {
        if (cls != null && !IGNORED.contains(cls)) {
            injectObject(obj, cls.getSuperclass(), viewFinder);
            Field[] declaredFields = cls.getDeclaredFields();
            if (declaredFields != null && declaredFields.length > 0) {
                for (Field field : declaredFields) {
                    Class type = field.getType();
                    if (!(Modifier.isStatic(field.getModifiers()) || Modifier.isFinal(field.getModifiers()) || type.isPrimitive() || type.isArray())) {
                        ViewInject viewInject = (ViewInject) field.getAnnotation(ViewInject.class);
                        if (viewInject != null) {
                            try {
                                View findViewById = viewFinder.findViewById(viewInject.value(), viewInject.parentId());
                                if (findViewById != null) {
                                    field.setAccessible(true);
                                    field.set(obj, findViewById);
                                } else {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append("Invalid @ViewInject for ");
                                    stringBuilder.append(cls.getSimpleName());
                                    stringBuilder.append(".");
                                    stringBuilder.append(field.getName());
                                    throw new RuntimeException(stringBuilder.toString());
                                }
                            } catch (Throwable th) {
                                LogUtil.e(th.getMessage(), th);
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            Method[] declaredMethods = cls.getDeclaredMethods();
            if (declaredMethods != null && declaredMethods.length > 0) {
                for (Method method : declaredMethods) {
                    if (!Modifier.isStatic(method.getModifiers()) && Modifier.isPrivate(method.getModifiers())) {
                        Event event = (Event) method.getAnnotation(Event.class);
                        if (event != null) {
                            try {
                                int[] value = event.value();
                                int[] parentId = event.parentId();
                                int length = parentId == null ? 0 : parentId.length;
                                int i = 0;
                                while (i < value.length) {
                                    int i2 = value[i];
                                    if (i2 > 0) {
                                        ViewInfo viewInfo = new ViewInfo();
                                        viewInfo.value = i2;
                                        viewInfo.parentId = length > i ? parentId[i] : 0;
                                        method.setAccessible(true);
                                        EventListenerManager.addEventMethod(viewFinder, viewInfo, event, obj, method);
                                    }
                                    i++;
                                }
                            } catch (Throwable th2) {
                                LogUtil.e(th2.getMessage(), th2);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void registerInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new ViewInjectorImpl();
                }
            }
        }
        Ext.setViewInjector(instance);
    }

    public View inject(Object obj, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Class cls = obj.getClass();
        View view = null;
        try {
            ContentView findContentView = findContentView(cls);
            if (findContentView != null) {
                int value = findContentView.value();
                if (value > 0) {
                    view = layoutInflater.inflate(value, viewGroup, false);
                }
            }
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
        injectObject(obj, cls, new ViewFinder(view));
        return view;
    }

    public void inject(Activity activity) {
        Class cls = activity.getClass();
        try {
            ContentView findContentView = findContentView(cls);
            if (findContentView != null && findContentView.value() > 0) {
                cls.getMethod("setContentView", new Class[]{Integer.TYPE}).invoke(activity, new Object[]{Integer.valueOf(r1)});
            }
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
        injectObject(activity, cls, new ViewFinder(activity));
    }

    public void inject(View view) {
        injectObject(view, view.getClass(), new ViewFinder(view));
    }

    public void inject(Object obj, View view) {
        injectObject(obj, obj.getClass(), new ViewFinder(view));
    }
}
