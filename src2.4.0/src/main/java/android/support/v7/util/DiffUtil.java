package android.support.v7.util;

import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v7.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DiffUtil {
    private static final Comparator<Snake> SNAKE_COMPARATOR = new Comparator<Snake>() {
        public int compare(Snake snake, Snake snake2) {
            int i = snake.x - snake2.x;
            return i == 0 ? snake.y - snake2.y : i;
        }
    };

    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i, int i2);

        public abstract boolean areItemsTheSame(int i, int i2);

        @Nullable
        public Object getChangePayload(int i, int i2) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    public static class DiffResult {
        private static final int FLAG_CHANGED = 2;
        private static final int FLAG_IGNORE = 16;
        private static final int FLAG_MASK = 31;
        private static final int FLAG_MOVED_CHANGED = 4;
        private static final int FLAG_MOVED_NOT_CHANGED = 8;
        private static final int FLAG_NOT_CHANGED = 1;
        private static final int FLAG_OFFSET = 5;
        private final Callback mCallback;
        private final boolean mDetectMoves;
        private final int[] mNewItemStatuses;
        private final int mNewListSize;
        private final int[] mOldItemStatuses;
        private final int mOldListSize;
        private final List<Snake> mSnakes;

        DiffResult(Callback callback, List<Snake> list, int[] iArr, int[] iArr2, boolean z) {
            this.mSnakes = list;
            this.mOldItemStatuses = iArr;
            this.mNewItemStatuses = iArr2;
            Arrays.fill(this.mOldItemStatuses, 0);
            Arrays.fill(this.mNewItemStatuses, 0);
            this.mCallback = callback;
            this.mOldListSize = callback.getOldListSize();
            this.mNewListSize = callback.getNewListSize();
            this.mDetectMoves = z;
            addRootSnake();
            findMatchingItems();
        }

        private void addRootSnake() {
            Snake snake = this.mSnakes.isEmpty() ? null : (Snake) this.mSnakes.get(0);
            if (snake == null || snake.x != 0 || snake.y != 0) {
                snake = new Snake();
                snake.x = 0;
                snake.y = 0;
                snake.removal = false;
                snake.size = 0;
                snake.reverse = false;
                this.mSnakes.add(0, snake);
            }
        }

        private void dispatchAdditions(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i, int i2, int i3) {
            if (this.mDetectMoves) {
                for (i2--; i2 >= 0; i2--) {
                    int i4 = i3 + i2;
                    int i5 = this.mNewItemStatuses[i4] & 31;
                    if (i5 == 0) {
                        listUpdateCallback.onInserted(i, 1);
                        for (PostponedUpdate postponedUpdate : list) {
                            postponedUpdate.currentPos++;
                        }
                    } else if (i5 == 4 || i5 == 8) {
                        int i6 = this.mNewItemStatuses[i4] >> 5;
                        listUpdateCallback.onMoved(removePostponedUpdate(list, i6, true).currentPos, i);
                        if (i5 == 4) {
                            listUpdateCallback.onChanged(i, 1, this.mCallback.getChangePayload(i6, i4));
                        }
                    } else if (i5 != 16) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("unknown flag for pos ");
                        stringBuilder.append(i4);
                        stringBuilder.append(" ");
                        stringBuilder.append(Long.toBinaryString((long) i5));
                        throw new IllegalStateException(stringBuilder.toString());
                    } else {
                        list.add(new PostponedUpdate(i4, i, false));
                    }
                }
                return;
            }
            listUpdateCallback.onInserted(i, i2);
        }

        private void dispatchRemovals(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i, int i2, int i3) {
            if (this.mDetectMoves) {
                for (i2--; i2 >= 0; i2--) {
                    int i4 = i3 + i2;
                    int i5 = this.mOldItemStatuses[i4] & 31;
                    if (i5 == 0) {
                        listUpdateCallback.onRemoved(i + i2, 1);
                        for (PostponedUpdate postponedUpdate : list) {
                            postponedUpdate.currentPos--;
                        }
                    } else if (i5 == 4 || i5 == 8) {
                        int i6 = this.mOldItemStatuses[i4] >> 5;
                        PostponedUpdate removePostponedUpdate = removePostponedUpdate(list, i6, false);
                        listUpdateCallback.onMoved(i + i2, removePostponedUpdate.currentPos - 1);
                        if (i5 == 4) {
                            listUpdateCallback.onChanged(removePostponedUpdate.currentPos - 1, 1, this.mCallback.getChangePayload(i4, i6));
                        }
                    } else if (i5 != 16) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("unknown flag for pos ");
                        stringBuilder.append(i4);
                        stringBuilder.append(" ");
                        stringBuilder.append(Long.toBinaryString((long) i5));
                        throw new IllegalStateException(stringBuilder.toString());
                    } else {
                        list.add(new PostponedUpdate(i4, i + i2, true));
                    }
                }
                return;
            }
            listUpdateCallback.onRemoved(i, i2);
        }

        private void findAddition(int i, int i2, int i3) {
            if (this.mOldItemStatuses[i - 1] == 0) {
                findMatchingItem(i, i2, i3, false);
            }
        }

        private boolean findMatchingItem(int i, int i2, int i3, boolean z) {
            int i4;
            int i5;
            if (z) {
                i2--;
                i4 = i;
                i5 = i2;
            } else {
                i4 = i - 1;
                i5 = i4;
            }
            while (i3 >= 0) {
                Snake snake = (Snake) this.mSnakes.get(i3);
                int i6 = snake.x + snake.size;
                int i7 = snake.y + snake.size;
                int i8 = 4;
                if (z) {
                    for (i4--; i4 >= i6; i4--) {
                        if (this.mCallback.areItemsTheSame(i4, i5)) {
                            if (this.mCallback.areContentsTheSame(i4, i5)) {
                                i8 = 8;
                            }
                            this.mNewItemStatuses[i5] = (i4 << 5) | 16;
                            this.mOldItemStatuses[i4] = (i5 << 5) | i8;
                            return true;
                        }
                    }
                    continue;
                } else {
                    for (i2--; i2 >= i7; i2--) {
                        if (this.mCallback.areItemsTheSame(i5, i2)) {
                            if (this.mCallback.areContentsTheSame(i5, i2)) {
                                i8 = 8;
                            }
                            i--;
                            this.mOldItemStatuses[i] = (i2 << 5) | 16;
                            this.mNewItemStatuses[i2] = (i << 5) | i8;
                            return true;
                        }
                    }
                    continue;
                }
                i4 = snake.x;
                i2 = snake.y;
                i3--;
            }
            return false;
        }

        private void findMatchingItems() {
            int i = this.mOldListSize;
            int i2 = this.mNewListSize;
            for (int size = this.mSnakes.size() - 1; size >= 0; size--) {
                Snake snake = (Snake) this.mSnakes.get(size);
                int i3 = snake.x + snake.size;
                int i4 = snake.y + snake.size;
                if (this.mDetectMoves) {
                    while (i > i3) {
                        findAddition(i, i2, size);
                        i--;
                    }
                    while (i2 > i4) {
                        findRemoval(i, i2, size);
                        i2--;
                    }
                }
                for (i = 0; i < snake.size; i++) {
                    i2 = snake.x + i;
                    i3 = snake.y + i;
                    i4 = this.mCallback.areContentsTheSame(i2, i3) ? 1 : 2;
                    this.mOldItemStatuses[i2] = (i3 << 5) | i4;
                    this.mNewItemStatuses[i3] = (i2 << 5) | i4;
                }
                i = snake.x;
                i2 = snake.y;
            }
        }

        private void findRemoval(int i, int i2, int i3) {
            if (this.mNewItemStatuses[i2 - 1] == 0) {
                findMatchingItem(i, i2, i3, true);
            }
        }

        private static PostponedUpdate removePostponedUpdate(List<PostponedUpdate> list, int i, boolean z) {
            int size = list.size() - 1;
            while (size >= 0) {
                PostponedUpdate postponedUpdate = (PostponedUpdate) list.get(size);
                if (postponedUpdate.posInOwnerList == i && postponedUpdate.removal == z) {
                    list.remove(size);
                    while (size < list.size()) {
                        PostponedUpdate postponedUpdate2 = (PostponedUpdate) list.get(size);
                        postponedUpdate2.currentPos += z ? 1 : -1;
                        size++;
                    }
                    return postponedUpdate;
                }
                size--;
            }
            return null;
        }

        public void dispatchUpdatesTo(ListUpdateCallback listUpdateCallback) {
            BatchingListUpdateCallback batchingListUpdateCallback = listUpdateCallback instanceof BatchingListUpdateCallback ? (BatchingListUpdateCallback) listUpdateCallback : new BatchingListUpdateCallback(listUpdateCallback);
            ArrayList arrayList = new ArrayList();
            int i = this.mOldListSize;
            int i2 = this.mNewListSize;
            for (int size = this.mSnakes.size() - 1; size >= 0; size--) {
                Snake snake = (Snake) this.mSnakes.get(size);
                int i3 = snake.size;
                int i4 = snake.x + i3;
                int i5 = snake.y + i3;
                if (i4 < i) {
                    dispatchRemovals(arrayList, batchingListUpdateCallback, i4, i - i4, i4);
                }
                if (i5 < i2) {
                    dispatchAdditions(arrayList, batchingListUpdateCallback, i4, i2 - i5, i5);
                }
                for (i3--; i3 >= 0; i3--) {
                    if ((this.mOldItemStatuses[snake.x + i3] & 31) == 2) {
                        batchingListUpdateCallback.onChanged(snake.x + i3, 1, this.mCallback.getChangePayload(snake.x + i3, snake.y + i3));
                    }
                }
                i = snake.x;
                i2 = snake.y;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }

        public void dispatchUpdatesTo(final Adapter adapter) {
            dispatchUpdatesTo(new ListUpdateCallback() {
                public void onChanged(int i, int i2, Object obj) {
                    adapter.notifyItemRangeChanged(i, i2, obj);
                }

                public void onInserted(int i, int i2) {
                    adapter.notifyItemRangeInserted(i, i2);
                }

                public void onMoved(int i, int i2) {
                    adapter.notifyItemMoved(i, i2);
                }

                public void onRemoved(int i, int i2) {
                    adapter.notifyItemRangeRemoved(i, i2);
                }
            });
        }

        /* Access modifiers changed, original: 0000 */
        @VisibleForTesting
        public List<Snake> getSnakes() {
            return this.mSnakes;
        }
    }

    private static class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        public PostponedUpdate(int i, int i2, boolean z) {
            this.posInOwnerList = i;
            this.currentPos = i2;
            this.removal = z;
        }
    }

    static class Range {
        int newListEnd;
        int newListStart;
        int oldListEnd;
        int oldListStart;

        public Range(int i, int i2, int i3, int i4) {
            this.oldListStart = i;
            this.oldListEnd = i2;
            this.newListStart = i3;
            this.newListEnd = i4;
        }
    }

    static class Snake {
        boolean removal;
        boolean reverse;
        int size;
        int x;
        int y;

        Snake() {
        }
    }

    private DiffUtil() {
    }

    public static DiffResult calculateDiff(Callback callback) {
        return calculateDiff(callback, true);
    }

    public static DiffResult calculateDiff(Callback callback, boolean z) {
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, oldListSize, 0, newListSize));
        oldListSize = Math.abs(oldListSize - newListSize) + (oldListSize + newListSize);
        newListSize = oldListSize * 2;
        int[] iArr = new int[newListSize];
        int[] iArr2 = new int[newListSize];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake diffPartial = diffPartial(callback, range.oldListStart, range.oldListEnd, range.newListStart, range.newListEnd, iArr, iArr2, oldListSize);
            if (diffPartial != null) {
                if (diffPartial.size > 0) {
                    arrayList.add(diffPartial);
                }
                diffPartial.x += range.oldListStart;
                diffPartial.y += range.newListStart;
                Range range2 = arrayList3.isEmpty() ? new Range() : (Range) arrayList3.remove(arrayList3.size() - 1);
                range2.oldListStart = range.oldListStart;
                range2.newListStart = range.newListStart;
                if (diffPartial.reverse) {
                    range2.oldListEnd = diffPartial.x;
                    range2.newListEnd = diffPartial.y;
                } else if (diffPartial.removal) {
                    range2.oldListEnd = diffPartial.x - 1;
                    range2.newListEnd = diffPartial.y;
                } else {
                    range2.oldListEnd = diffPartial.x;
                    range2.newListEnd = diffPartial.y - 1;
                }
                arrayList2.add(range2);
                if (!diffPartial.reverse) {
                    range.oldListStart = diffPartial.x + diffPartial.size;
                    range.newListStart = diffPartial.y + diffPartial.size;
                } else if (diffPartial.removal) {
                    range.oldListStart = (diffPartial.x + diffPartial.size) + 1;
                    range.newListStart = diffPartial.y + diffPartial.size;
                } else {
                    range.oldListStart = diffPartial.x + diffPartial.size;
                    range.newListStart = (diffPartial.y + diffPartial.size) + 1;
                }
                arrayList2.add(range);
            } else {
                arrayList3.add(range);
            }
        }
        Collections.sort(arrayList, SNAKE_COMPARATOR);
        return new DiffResult(callback, arrayList, iArr, iArr2, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:78:0x0081 A:{SYNTHETIC, EDGE_INSN: B:78:0x0081->B:26:0x0081 ?: BREAK  , EDGE_INSN: B:78:0x0081->B:26:0x0081 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0074 A:{LOOP_END, LOOP:2: B:20:0x0062->B:24:0x0074} */
    /* JADX WARNING: Missing block: B:44:0x00e0, code skipped:
            if (r4[r9 - 1] < r4[r9 + 1]) goto L_0x00f2;
     */
    private static android.support.v7.util.DiffUtil.Snake diffPartial(android.support.v7.util.DiffUtil.Callback r22, int r23, int r24, int r25, int r26, int[] r27, int[] r28, int r29) {
        /*
        r0 = r22;
        r3 = r27;
        r4 = r28;
        r5 = r24 - r23;
        r6 = r26 - r25;
        r7 = 1;
        if (r5 < r7) goto L_0x015a;
    L_0x000d:
        if (r6 >= r7) goto L_0x0011;
    L_0x000f:
        goto L_0x015a;
    L_0x0011:
        r8 = r5 - r6;
        r9 = r5 + r6;
        r9 = r9 + r7;
        r9 = r9 / 2;
        r10 = r29 - r9;
        r10 = r10 - r7;
        r11 = r29 + r9;
        r11 = r11 + r7;
        r12 = 0;
        java.util.Arrays.fill(r3, r10, r11, r12);
        r10 = r10 + r8;
        r11 = r11 + r8;
        java.util.Arrays.fill(r4, r10, r11, r5);
        r10 = r8 % 2;
        if (r10 == 0) goto L_0x002d;
    L_0x002b:
        r10 = r7;
        goto L_0x002e;
    L_0x002d:
        r10 = r12;
    L_0x002e:
        r11 = r12;
    L_0x002f:
        if (r11 > r9) goto L_0x0152;
    L_0x0031:
        r13 = -r11;
        r14 = r13;
    L_0x0033:
        if (r14 > r11) goto L_0x00c0;
    L_0x0035:
        if (r14 == r13) goto L_0x0054;
    L_0x0037:
        if (r14 == r11) goto L_0x0047;
    L_0x0039:
        r15 = r29 + r14;
        r16 = r15 + -1;
        r12 = r3[r16];
        r15 = r15 + r7;
        r7 = r3[r15];
        if (r12 >= r7) goto L_0x0047;
    L_0x0044:
        r17 = 1;
        goto L_0x0056;
    L_0x0047:
        r7 = r29 + r14;
        r17 = 1;
        r7 = r7 + -1;
        r7 = r3[r7];
        r7 = r7 + 1;
        r12 = r17;
        goto L_0x005d;
    L_0x0054:
        r17 = r7;
    L_0x0056:
        r7 = r29 + r14;
        r7 = r7 + 1;
        r7 = r3[r7];
        r12 = 0;
    L_0x005d:
        r15 = r7 - r14;
        r18 = r9;
        r9 = r15;
    L_0x0062:
        if (r7 >= r5) goto L_0x007d;
    L_0x0064:
        if (r9 >= r6) goto L_0x007d;
    L_0x0066:
        r19 = r5;
        r5 = r23 + r7;
        r20 = r6;
        r6 = r25 + r9;
        r5 = r0.areItemsTheSame(r5, r6);
        if (r5 == 0) goto L_0x0081;
    L_0x0074:
        r7 = r7 + 1;
        r9 = r9 + 1;
        r5 = r19;
        r6 = r20;
        goto L_0x0062;
    L_0x007d:
        r19 = r5;
        r20 = r6;
    L_0x0081:
        r5 = r29 + r14;
        r3[r5] = r7;
        if (r10 == 0) goto L_0x00b3;
    L_0x0087:
        r6 = r8 - r11;
        r7 = 1;
        r6 = r6 + r7;
        if (r14 < r6) goto L_0x00b3;
    L_0x008d:
        r6 = r8 + r11;
        r6 = r6 - r7;
        if (r14 > r6) goto L_0x00b3;
    L_0x0092:
        r6 = r3[r5];
        r7 = r4[r5];
        if (r6 < r7) goto L_0x00b3;
    L_0x0098:
        r0 = new android.support.v7.util.DiffUtil$Snake;
        r0.<init>();
        r1 = r4[r5];
        r0.x = r1;
        r1 = r0.x;
        r1 = r1 - r14;
        r0.y = r1;
        r1 = r3[r5];
        r2 = r4[r5];
        r1 = r1 - r2;
        r0.size = r1;
        r0.removal = r12;
        r5 = 0;
        r0.reverse = r5;
        return r0;
    L_0x00b3:
        r5 = 0;
        r14 = r14 + 2;
        r12 = r5;
        r9 = r18;
        r5 = r19;
        r6 = r20;
        r7 = 1;
        goto L_0x0033;
    L_0x00c0:
        r19 = r5;
        r20 = r6;
        r18 = r9;
        r5 = r12;
        r6 = r13;
    L_0x00c8:
        if (r6 > r11) goto L_0x0145;
    L_0x00ca:
        r7 = r6 + r8;
        r9 = r11 + r8;
        if (r7 == r9) goto L_0x00f0;
    L_0x00d0:
        r9 = r13 + r8;
        if (r7 == r9) goto L_0x00e3;
    L_0x00d4:
        r9 = r29 + r7;
        r12 = r9 + -1;
        r12 = r4[r12];
        r17 = 1;
        r9 = r9 + 1;
        r9 = r4[r9];
        if (r12 >= r9) goto L_0x00e5;
    L_0x00e2:
        goto L_0x00f2;
    L_0x00e3:
        r17 = 1;
    L_0x00e5:
        r9 = r29 + r7;
        r9 = r9 + 1;
        r9 = r4[r9];
        r9 = r9 + -1;
        r12 = r17;
        goto L_0x00f9;
    L_0x00f0:
        r17 = 1;
    L_0x00f2:
        r9 = r29 + r7;
        r9 = r9 + -1;
        r9 = r4[r9];
        r12 = r5;
    L_0x00f9:
        r14 = r9 - r7;
    L_0x00fb:
        if (r9 <= 0) goto L_0x0115;
    L_0x00fd:
        if (r14 <= 0) goto L_0x0115;
    L_0x00ff:
        r15 = r23 + r9;
        r5 = r15 + -1;
        r15 = r25 + r14;
        r1 = r15 + -1;
        r1 = r0.areItemsTheSame(r5, r1);
        if (r1 == 0) goto L_0x0115;
    L_0x010d:
        r9 = r9 + -1;
        r14 = r14 + -1;
        r5 = 0;
        r17 = 1;
        goto L_0x00fb;
    L_0x0115:
        r1 = r29 + r7;
        r4[r1] = r9;
        if (r10 != 0) goto L_0x0140;
    L_0x011b:
        if (r7 < r13) goto L_0x0140;
    L_0x011d:
        if (r7 > r11) goto L_0x0140;
    L_0x011f:
        r5 = r3[r1];
        r9 = r4[r1];
        if (r5 < r9) goto L_0x0140;
    L_0x0125:
        r0 = new android.support.v7.util.DiffUtil$Snake;
        r0.<init>();
        r2 = r4[r1];
        r0.x = r2;
        r2 = r0.x;
        r2 = r2 - r7;
        r0.y = r2;
        r2 = r3[r1];
        r1 = r4[r1];
        r2 = r2 - r1;
        r0.size = r2;
        r0.removal = r12;
        r1 = 1;
        r0.reverse = r1;
        return r0;
    L_0x0140:
        r1 = 1;
        r6 = r6 + 2;
        r5 = 0;
        goto L_0x00c8;
    L_0x0145:
        r1 = 1;
        r11 = r11 + 1;
        r7 = r1;
        r9 = r18;
        r5 = r19;
        r6 = r20;
        r12 = 0;
        goto L_0x002f;
    L_0x0152:
        r0 = new java.lang.IllegalStateException;
        r1 = "DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.";
        r0.<init>(r1);
        throw r0;
    L_0x015a:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.util.DiffUtil.diffPartial(android.support.v7.util.DiffUtil$Callback, int, int, int, int, int[], int[], int):android.support.v7.util.DiffUtil$Snake");
    }
}
