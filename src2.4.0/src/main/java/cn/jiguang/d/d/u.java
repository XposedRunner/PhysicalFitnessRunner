package cn.jiguang.d.d;

import java.util.Comparator;

final class u implements Comparator<n> {
    u() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return (int) (((n) obj).c().lastModified() - ((n) obj2).c().lastModified());
    }
}
