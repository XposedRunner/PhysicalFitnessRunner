package android.support.v7.widget;

import java.util.List;

class OpReorderer {
    final Callback mCallback;

    interface Callback {
        UpdateOp obtainUpdateOp(int i, int i2, int i3, Object obj);

        void recycleUpdateOp(UpdateOp updateOp);
    }

    public OpReorderer(Callback callback) {
        this.mCallback = callback;
    }

    private int getLastMoveOutOfOrder(List<UpdateOp> list) {
        int i = 0;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (((UpdateOp) list.get(size)).cmd != 8) {
                i = 1;
            } else if (i != 0) {
                return size;
            }
        }
        return -1;
    }

    private void swapMoveAdd(List<UpdateOp> list, int i, UpdateOp updateOp, int i2, UpdateOp updateOp2) {
        int i3 = updateOp.itemCount < updateOp2.positionStart ? -1 : 0;
        if (updateOp.positionStart < updateOp2.positionStart) {
            i3++;
        }
        if (updateOp2.positionStart <= updateOp.positionStart) {
            updateOp.positionStart += updateOp2.itemCount;
        }
        if (updateOp2.positionStart <= updateOp.itemCount) {
            updateOp.itemCount += updateOp2.itemCount;
        }
        updateOp2.positionStart += i3;
        list.set(i, updateOp2);
        list.set(i2, updateOp);
    }

    private void swapMoveOp(List<UpdateOp> list, int i, int i2) {
        UpdateOp updateOp = (UpdateOp) list.get(i);
        UpdateOp updateOp2 = (UpdateOp) list.get(i2);
        int i3 = updateOp2.cmd;
        if (i3 != 4) {
            switch (i3) {
                case 1:
                    swapMoveAdd(list, i, updateOp, i2, updateOp2);
                    return;
                case 2:
                    swapMoveRemove(list, i, updateOp, i2, updateOp2);
                    return;
                default:
                    return;
            }
        }
        swapMoveUpdate(list, i, updateOp, i2, updateOp2);
    }

    /* Access modifiers changed, original: 0000 */
    public void reorderOps(List<UpdateOp> list) {
        while (true) {
            int lastMoveOutOfOrder = getLastMoveOutOfOrder(list);
            if (lastMoveOutOfOrder != -1) {
                swapMoveOp(list, lastMoveOutOfOrder, lastMoveOutOfOrder + 1);
            } else {
                return;
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void swapMoveRemove(List<UpdateOp> list, int i, UpdateOp updateOp, int i2, UpdateOp updateOp2) {
        int i3;
        int i4 = 0;
        if (updateOp.positionStart < updateOp.itemCount) {
            if (updateOp2.positionStart == updateOp.positionStart && updateOp2.itemCount == updateOp.itemCount - updateOp.positionStart) {
                i3 = 0;
                i4 = 1;
            } else {
                i3 = 0;
            }
        } else if (updateOp2.positionStart == updateOp.itemCount + 1 && updateOp2.itemCount == updateOp.positionStart - updateOp.itemCount) {
            i3 = 1;
            i4 = i3;
        } else {
            i3 = 1;
        }
        if (updateOp.itemCount < updateOp2.positionStart) {
            updateOp2.positionStart--;
        } else if (updateOp.itemCount < updateOp2.positionStart + updateOp2.itemCount) {
            updateOp2.itemCount--;
            updateOp.cmd = 2;
            updateOp.itemCount = 1;
            if (updateOp2.itemCount == 0) {
                list.remove(i2);
                this.mCallback.recycleUpdateOp(updateOp2);
            }
            return;
        }
        UpdateOp updateOp3 = null;
        if (updateOp.positionStart <= updateOp2.positionStart) {
            updateOp2.positionStart++;
        } else if (updateOp.positionStart < updateOp2.positionStart + updateOp2.itemCount) {
            updateOp3 = this.mCallback.obtainUpdateOp(2, updateOp.positionStart + 1, (updateOp2.positionStart + updateOp2.itemCount) - updateOp.positionStart, null);
            updateOp2.itemCount = updateOp.positionStart - updateOp2.positionStart;
        }
        if (i4 != 0) {
            list.set(i, updateOp2);
            list.remove(i2);
            this.mCallback.recycleUpdateOp(updateOp);
            return;
        }
        if (i3 != 0) {
            if (updateOp3 != null) {
                if (updateOp.positionStart > updateOp3.positionStart) {
                    updateOp.positionStart -= updateOp3.itemCount;
                }
                if (updateOp.itemCount > updateOp3.positionStart) {
                    updateOp.itemCount -= updateOp3.itemCount;
                }
            }
            if (updateOp.positionStart > updateOp2.positionStart) {
                updateOp.positionStart -= updateOp2.itemCount;
            }
            if (updateOp.itemCount > updateOp2.positionStart) {
                updateOp.itemCount -= updateOp2.itemCount;
            }
        } else {
            if (updateOp3 != null) {
                if (updateOp.positionStart >= updateOp3.positionStart) {
                    updateOp.positionStart -= updateOp3.itemCount;
                }
                if (updateOp.itemCount >= updateOp3.positionStart) {
                    updateOp.itemCount -= updateOp3.itemCount;
                }
            }
            if (updateOp.positionStart >= updateOp2.positionStart) {
                updateOp.positionStart -= updateOp2.itemCount;
            }
            if (updateOp.itemCount >= updateOp2.positionStart) {
                updateOp.itemCount -= updateOp2.itemCount;
            }
        }
        list.set(i, updateOp2);
        if (updateOp.positionStart != updateOp.itemCount) {
            list.set(i2, updateOp);
        } else {
            list.remove(i2);
        }
        if (updateOp3 != null) {
            list.add(i, updateOp3);
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070  */
    public void swapMoveUpdate(java.util.List<android.support.v7.widget.AdapterHelper.UpdateOp> r8, int r9, android.support.v7.widget.AdapterHelper.UpdateOp r10, int r11, android.support.v7.widget.AdapterHelper.UpdateOp r12) {
        /*
        r7 = this;
        r0 = r10.itemCount;
        r1 = r12.positionStart;
        r2 = 4;
        r3 = 0;
        r4 = 1;
        if (r0 >= r1) goto L_0x000f;
    L_0x0009:
        r0 = r12.positionStart;
        r0 = r0 - r4;
        r12.positionStart = r0;
        goto L_0x0028;
    L_0x000f:
        r0 = r10.itemCount;
        r1 = r12.positionStart;
        r5 = r12.itemCount;
        r1 = r1 + r5;
        if (r0 >= r1) goto L_0x0028;
    L_0x0018:
        r0 = r12.itemCount;
        r0 = r0 - r4;
        r12.itemCount = r0;
        r0 = r7.mCallback;
        r1 = r10.positionStart;
        r5 = r12.payload;
        r0 = r0.obtainUpdateOp(r2, r1, r4, r5);
        goto L_0x0029;
    L_0x0028:
        r0 = r3;
    L_0x0029:
        r1 = r10.positionStart;
        r5 = r12.positionStart;
        if (r1 > r5) goto L_0x0035;
    L_0x002f:
        r1 = r12.positionStart;
        r1 = r1 + r4;
        r12.positionStart = r1;
        goto L_0x0056;
    L_0x0035:
        r1 = r10.positionStart;
        r5 = r12.positionStart;
        r6 = r12.itemCount;
        r5 = r5 + r6;
        if (r1 >= r5) goto L_0x0056;
    L_0x003e:
        r1 = r12.positionStart;
        r3 = r12.itemCount;
        r1 = r1 + r3;
        r3 = r10.positionStart;
        r1 = r1 - r3;
        r3 = r7.mCallback;
        r5 = r10.positionStart;
        r5 = r5 + r4;
        r4 = r12.payload;
        r3 = r3.obtainUpdateOp(r2, r5, r1, r4);
        r2 = r12.itemCount;
        r2 = r2 - r1;
        r12.itemCount = r2;
    L_0x0056:
        r8.set(r11, r10);
        r10 = r12.itemCount;
        if (r10 <= 0) goto L_0x0061;
    L_0x005d:
        r8.set(r9, r12);
        goto L_0x0069;
    L_0x0061:
        r8.remove(r9);
        r10 = r7.mCallback;
        r10.recycleUpdateOp(r12);
    L_0x0069:
        if (r0 == 0) goto L_0x006e;
    L_0x006b:
        r8.add(r9, r0);
    L_0x006e:
        if (r3 == 0) goto L_0x0073;
    L_0x0070:
        r8.add(r9, r3);
    L_0x0073:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.OpReorderer.swapMoveUpdate(java.util.List, int, android.support.v7.widget.AdapterHelper$UpdateOp, int, android.support.v7.widget.AdapterHelper$UpdateOp):void");
    }
}
