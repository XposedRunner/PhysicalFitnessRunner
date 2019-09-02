package org.xutils.view;

final class ViewInfo {
    public int parentId;
    public int value;

    ViewInfo() {
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ViewInfo viewInfo = (ViewInfo) obj;
        if (this.value != viewInfo.value) {
            return false;
        }
        if (this.parentId != viewInfo.parentId) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (31 * this.value) + this.parentId;
    }
}
