package android.support.v7.widget;

import android.support.annotation.NonNull;
import android.support.v4.animation.AnimatorCompatHelper;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DefaultItemAnimator extends SimpleItemAnimator {
    private static final boolean DEBUG = false;
    ArrayList<ViewHolder> mAddAnimations = new ArrayList();
    ArrayList<ArrayList<ViewHolder>> mAdditionsList = new ArrayList();
    ArrayList<ViewHolder> mChangeAnimations = new ArrayList();
    ArrayList<ArrayList<ChangeInfo>> mChangesList = new ArrayList();
    ArrayList<ViewHolder> mMoveAnimations = new ArrayList();
    ArrayList<ArrayList<MoveInfo>> mMovesList = new ArrayList();
    private ArrayList<ViewHolder> mPendingAdditions = new ArrayList();
    private ArrayList<ChangeInfo> mPendingChanges = new ArrayList();
    private ArrayList<MoveInfo> mPendingMoves = new ArrayList();
    private ArrayList<ViewHolder> mPendingRemovals = new ArrayList();
    ArrayList<ViewHolder> mRemoveAnimations = new ArrayList();

    private static class VpaListenerAdapter implements ViewPropertyAnimatorListener {
        VpaListenerAdapter() {
        }

        public void onAnimationCancel(View view) {
        }

        public void onAnimationEnd(View view) {
        }

        public void onAnimationStart(View view) {
        }
    }

    private static class ChangeInfo {
        public int fromX;
        public int fromY;
        public ViewHolder newHolder;
        public ViewHolder oldHolder;
        public int toX;
        public int toY;

        private ChangeInfo(ViewHolder viewHolder, ViewHolder viewHolder2) {
            this.oldHolder = viewHolder;
            this.newHolder = viewHolder2;
        }

        ChangeInfo(ViewHolder viewHolder, ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
            this(viewHolder, viewHolder2);
            this.fromX = i;
            this.fromY = i2;
            this.toX = i3;
            this.toY = i4;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ChangeInfo{oldHolder=");
            stringBuilder.append(this.oldHolder);
            stringBuilder.append(", newHolder=");
            stringBuilder.append(this.newHolder);
            stringBuilder.append(", fromX=");
            stringBuilder.append(this.fromX);
            stringBuilder.append(", fromY=");
            stringBuilder.append(this.fromY);
            stringBuilder.append(", toX=");
            stringBuilder.append(this.toX);
            stringBuilder.append(", toY=");
            stringBuilder.append(this.toY);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    private static class MoveInfo {
        public int fromX;
        public int fromY;
        public ViewHolder holder;
        public int toX;
        public int toY;

        MoveInfo(ViewHolder viewHolder, int i, int i2, int i3, int i4) {
            this.holder = viewHolder;
            this.fromX = i;
            this.fromY = i2;
            this.toX = i3;
            this.toY = i4;
        }
    }

    private void animateRemoveImpl(final ViewHolder viewHolder) {
        final ViewPropertyAnimatorCompat animate = ViewCompat.animate(viewHolder.itemView);
        this.mRemoveAnimations.add(viewHolder);
        animate.setDuration(getRemoveDuration()).alpha(0.0f).setListener(new VpaListenerAdapter() {
            public void onAnimationEnd(View view) {
                animate.setListener(null);
                ViewCompat.setAlpha(view, 1.0f);
                DefaultItemAnimator.this.dispatchRemoveFinished(viewHolder);
                DefaultItemAnimator.this.mRemoveAnimations.remove(viewHolder);
                DefaultItemAnimator.this.dispatchFinishedWhenDone();
            }

            public void onAnimationStart(View view) {
                DefaultItemAnimator.this.dispatchRemoveStarting(viewHolder);
            }
        }).start();
    }

    private void endChangeAnimation(List<ChangeInfo> list, ViewHolder viewHolder) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ChangeInfo changeInfo = (ChangeInfo) list.get(size);
            if (endChangeAnimationIfNecessary(changeInfo, viewHolder) && changeInfo.oldHolder == null && changeInfo.newHolder == null) {
                list.remove(changeInfo);
            }
        }
    }

    private void endChangeAnimationIfNecessary(ChangeInfo changeInfo) {
        if (changeInfo.oldHolder != null) {
            endChangeAnimationIfNecessary(changeInfo, changeInfo.oldHolder);
        }
        if (changeInfo.newHolder != null) {
            endChangeAnimationIfNecessary(changeInfo, changeInfo.newHolder);
        }
    }

    private boolean endChangeAnimationIfNecessary(ChangeInfo changeInfo, ViewHolder viewHolder) {
        boolean z = false;
        if (changeInfo.newHolder == viewHolder) {
            changeInfo.newHolder = null;
        } else if (changeInfo.oldHolder != viewHolder) {
            return false;
        } else {
            changeInfo.oldHolder = null;
            z = true;
        }
        ViewCompat.setAlpha(viewHolder.itemView, 1.0f);
        ViewCompat.setTranslationX(viewHolder.itemView, 0.0f);
        ViewCompat.setTranslationY(viewHolder.itemView, 0.0f);
        dispatchChangeFinished(viewHolder, z);
        return true;
    }

    private void resetAnimation(ViewHolder viewHolder) {
        AnimatorCompatHelper.clearInterpolator(viewHolder.itemView);
        endAnimation(viewHolder);
    }

    public boolean animateAdd(ViewHolder viewHolder) {
        resetAnimation(viewHolder);
        ViewCompat.setAlpha(viewHolder.itemView, 0.0f);
        this.mPendingAdditions.add(viewHolder);
        return true;
    }

    /* Access modifiers changed, original: 0000 */
    public void animateAddImpl(final ViewHolder viewHolder) {
        final ViewPropertyAnimatorCompat animate = ViewCompat.animate(viewHolder.itemView);
        this.mAddAnimations.add(viewHolder);
        animate.alpha(1.0f).setDuration(getAddDuration()).setListener(new VpaListenerAdapter() {
            public void onAnimationCancel(View view) {
                ViewCompat.setAlpha(view, 1.0f);
            }

            public void onAnimationEnd(View view) {
                animate.setListener(null);
                DefaultItemAnimator.this.dispatchAddFinished(viewHolder);
                DefaultItemAnimator.this.mAddAnimations.remove(viewHolder);
                DefaultItemAnimator.this.dispatchFinishedWhenDone();
            }

            public void onAnimationStart(View view) {
                DefaultItemAnimator.this.dispatchAddStarting(viewHolder);
            }
        }).start();
    }

    public boolean animateChange(ViewHolder viewHolder, ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
        if (viewHolder == viewHolder2) {
            return animateMove(viewHolder, i, i2, i3, i4);
        }
        float translationX = ViewCompat.getTranslationX(viewHolder.itemView);
        float translationY = ViewCompat.getTranslationY(viewHolder.itemView);
        float alpha = ViewCompat.getAlpha(viewHolder.itemView);
        resetAnimation(viewHolder);
        int i5 = (int) (((float) (i3 - i)) - translationX);
        int i6 = (int) (((float) (i4 - i2)) - translationY);
        ViewCompat.setTranslationX(viewHolder.itemView, translationX);
        ViewCompat.setTranslationY(viewHolder.itemView, translationY);
        ViewCompat.setAlpha(viewHolder.itemView, alpha);
        if (viewHolder2 != null) {
            resetAnimation(viewHolder2);
            ViewCompat.setTranslationX(viewHolder2.itemView, (float) (-i5));
            ViewCompat.setTranslationY(viewHolder2.itemView, (float) (-i6));
            ViewCompat.setAlpha(viewHolder2.itemView, 0.0f);
        }
        this.mPendingChanges.add(new ChangeInfo(viewHolder, viewHolder2, i, i2, i3, i4));
        return true;
    }

    /* Access modifiers changed, original: 0000 */
    public void animateChangeImpl(final ChangeInfo changeInfo) {
        final ViewPropertyAnimatorCompat duration;
        ViewHolder viewHolder = changeInfo.oldHolder;
        View view = null;
        View view2 = viewHolder == null ? null : viewHolder.itemView;
        ViewHolder viewHolder2 = changeInfo.newHolder;
        if (viewHolder2 != null) {
            view = viewHolder2.itemView;
        }
        if (view2 != null) {
            duration = ViewCompat.animate(view2).setDuration(getChangeDuration());
            this.mChangeAnimations.add(changeInfo.oldHolder);
            duration.translationX((float) (changeInfo.toX - changeInfo.fromX));
            duration.translationY((float) (changeInfo.toY - changeInfo.fromY));
            duration.alpha(0.0f).setListener(new VpaListenerAdapter() {
                public void onAnimationEnd(View view) {
                    duration.setListener(null);
                    ViewCompat.setAlpha(view, 1.0f);
                    ViewCompat.setTranslationX(view, 0.0f);
                    ViewCompat.setTranslationY(view, 0.0f);
                    DefaultItemAnimator.this.dispatchChangeFinished(changeInfo.oldHolder, true);
                    DefaultItemAnimator.this.mChangeAnimations.remove(changeInfo.oldHolder);
                    DefaultItemAnimator.this.dispatchFinishedWhenDone();
                }

                public void onAnimationStart(View view) {
                    DefaultItemAnimator.this.dispatchChangeStarting(changeInfo.oldHolder, true);
                }
            }).start();
        }
        if (view != null) {
            duration = ViewCompat.animate(view);
            this.mChangeAnimations.add(changeInfo.newHolder);
            duration.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new VpaListenerAdapter() {
                public void onAnimationEnd(View view) {
                    duration.setListener(null);
                    ViewCompat.setAlpha(view, 1.0f);
                    ViewCompat.setTranslationX(view, 0.0f);
                    ViewCompat.setTranslationY(view, 0.0f);
                    DefaultItemAnimator.this.dispatchChangeFinished(changeInfo.newHolder, false);
                    DefaultItemAnimator.this.mChangeAnimations.remove(changeInfo.newHolder);
                    DefaultItemAnimator.this.dispatchFinishedWhenDone();
                }

                public void onAnimationStart(View view) {
                    DefaultItemAnimator.this.dispatchChangeStarting(changeInfo.newHolder, false);
                }
            }).start();
        }
    }

    public boolean animateMove(ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        View view = viewHolder.itemView;
        int translationX = (int) (((float) i) + ViewCompat.getTranslationX(viewHolder.itemView));
        int translationY = (int) (((float) i2) + ViewCompat.getTranslationY(viewHolder.itemView));
        resetAnimation(viewHolder);
        i = i3 - translationX;
        i2 = i4 - translationY;
        if (i == 0 && i2 == 0) {
            dispatchMoveFinished(viewHolder);
            return false;
        }
        if (i != 0) {
            ViewCompat.setTranslationX(view, (float) (-i));
        }
        if (i2 != 0) {
            ViewCompat.setTranslationY(view, (float) (-i2));
        }
        this.mPendingMoves.add(new MoveInfo(viewHolder, translationX, translationY, i3, i4));
        return true;
    }

    /* Access modifiers changed, original: 0000 */
    public void animateMoveImpl(ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        View view = viewHolder.itemView;
        final int i5 = i3 - i;
        final int i6 = i4 - i2;
        if (i5 != 0) {
            ViewCompat.animate(view).translationX(0.0f);
        }
        if (i6 != 0) {
            ViewCompat.animate(view).translationY(0.0f);
        }
        final ViewPropertyAnimatorCompat animate = ViewCompat.animate(view);
        this.mMoveAnimations.add(viewHolder);
        final ViewHolder viewHolder2 = viewHolder;
        animate.setDuration(getMoveDuration()).setListener(new VpaListenerAdapter() {
            public void onAnimationCancel(View view) {
                if (i5 != 0) {
                    ViewCompat.setTranslationX(view, 0.0f);
                }
                if (i6 != 0) {
                    ViewCompat.setTranslationY(view, 0.0f);
                }
            }

            public void onAnimationEnd(View view) {
                animate.setListener(null);
                DefaultItemAnimator.this.dispatchMoveFinished(viewHolder2);
                DefaultItemAnimator.this.mMoveAnimations.remove(viewHolder2);
                DefaultItemAnimator.this.dispatchFinishedWhenDone();
            }

            public void onAnimationStart(View view) {
                DefaultItemAnimator.this.dispatchMoveStarting(viewHolder2);
            }
        }).start();
    }

    public boolean animateRemove(ViewHolder viewHolder) {
        resetAnimation(viewHolder);
        this.mPendingRemovals.add(viewHolder);
        return true;
    }

    public boolean canReuseUpdatedViewHolder(@NonNull ViewHolder viewHolder, @NonNull List<Object> list) {
        return !list.isEmpty() || super.canReuseUpdatedViewHolder(viewHolder, list);
    }

    /* Access modifiers changed, original: 0000 */
    public void cancelAll(List<ViewHolder> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ViewCompat.animate(((ViewHolder) list.get(size)).itemView).cancel();
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void dispatchFinishedWhenDone() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
        }
    }

    public void endAnimation(ViewHolder viewHolder) {
        ArrayList arrayList;
        View view = viewHolder.itemView;
        ViewCompat.animate(view).cancel();
        int size = this.mPendingMoves.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (((MoveInfo) this.mPendingMoves.get(size)).holder == viewHolder) {
                ViewCompat.setTranslationY(view, 0.0f);
                ViewCompat.setTranslationX(view, 0.0f);
                dispatchMoveFinished(viewHolder);
                this.mPendingMoves.remove(size);
            }
        }
        endChangeAnimation(this.mPendingChanges, viewHolder);
        if (this.mPendingRemovals.remove(viewHolder)) {
            ViewCompat.setAlpha(view, 1.0f);
            dispatchRemoveFinished(viewHolder);
        }
        if (this.mPendingAdditions.remove(viewHolder)) {
            ViewCompat.setAlpha(view, 1.0f);
            dispatchAddFinished(viewHolder);
        }
        for (size = this.mChangesList.size() - 1; size >= 0; size--) {
            arrayList = (ArrayList) this.mChangesList.get(size);
            endChangeAnimation(arrayList, viewHolder);
            if (arrayList.isEmpty()) {
                this.mChangesList.remove(size);
            }
        }
        for (size = this.mMovesList.size() - 1; size >= 0; size--) {
            arrayList = (ArrayList) this.mMovesList.get(size);
            int size2 = arrayList.size() - 1;
            while (size2 >= 0) {
                if (((MoveInfo) arrayList.get(size2)).holder == viewHolder) {
                    ViewCompat.setTranslationY(view, 0.0f);
                    ViewCompat.setTranslationX(view, 0.0f);
                    dispatchMoveFinished(viewHolder);
                    arrayList.remove(size2);
                    if (arrayList.isEmpty()) {
                        this.mMovesList.remove(size);
                    }
                } else {
                    size2--;
                }
            }
        }
        for (size = this.mAdditionsList.size() - 1; size >= 0; size--) {
            ArrayList arrayList2 = (ArrayList) this.mAdditionsList.get(size);
            if (arrayList2.remove(viewHolder)) {
                ViewCompat.setAlpha(view, 1.0f);
                dispatchAddFinished(viewHolder);
                if (arrayList2.isEmpty()) {
                    this.mAdditionsList.remove(size);
                }
            }
        }
        this.mRemoveAnimations.remove(viewHolder);
        this.mAddAnimations.remove(viewHolder);
        this.mChangeAnimations.remove(viewHolder);
        this.mMoveAnimations.remove(viewHolder);
        dispatchFinishedWhenDone();
    }

    public void endAnimations() {
        int size = this.mPendingMoves.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            MoveInfo moveInfo = (MoveInfo) this.mPendingMoves.get(size);
            View view = moveInfo.holder.itemView;
            ViewCompat.setTranslationY(view, 0.0f);
            ViewCompat.setTranslationX(view, 0.0f);
            dispatchMoveFinished(moveInfo.holder);
            this.mPendingMoves.remove(size);
        }
        for (size = this.mPendingRemovals.size() - 1; size >= 0; size--) {
            dispatchRemoveFinished((ViewHolder) this.mPendingRemovals.get(size));
            this.mPendingRemovals.remove(size);
        }
        size = this.mPendingAdditions.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            ViewHolder viewHolder = (ViewHolder) this.mPendingAdditions.get(size);
            ViewCompat.setAlpha(viewHolder.itemView, 1.0f);
            dispatchAddFinished(viewHolder);
            this.mPendingAdditions.remove(size);
        }
        for (size = this.mPendingChanges.size() - 1; size >= 0; size--) {
            endChangeAnimationIfNecessary((ChangeInfo) this.mPendingChanges.get(size));
        }
        this.mPendingChanges.clear();
        if (isRunning()) {
            ArrayList arrayList;
            for (size = this.mMovesList.size() - 1; size >= 0; size--) {
                ArrayList arrayList2 = (ArrayList) this.mMovesList.get(size);
                for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                    MoveInfo moveInfo2 = (MoveInfo) arrayList2.get(size2);
                    View view2 = moveInfo2.holder.itemView;
                    ViewCompat.setTranslationY(view2, 0.0f);
                    ViewCompat.setTranslationX(view2, 0.0f);
                    dispatchMoveFinished(moveInfo2.holder);
                    arrayList2.remove(size2);
                    if (arrayList2.isEmpty()) {
                        this.mMovesList.remove(arrayList2);
                    }
                }
            }
            for (size = this.mAdditionsList.size() - 1; size >= 0; size--) {
                arrayList = (ArrayList) this.mAdditionsList.get(size);
                for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    ViewHolder viewHolder2 = (ViewHolder) arrayList.get(size3);
                    ViewCompat.setAlpha(viewHolder2.itemView, 1.0f);
                    dispatchAddFinished(viewHolder2);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.mAdditionsList.remove(arrayList);
                    }
                }
            }
            for (size = this.mChangesList.size() - 1; size >= 0; size--) {
                arrayList = (ArrayList) this.mChangesList.get(size);
                for (int size4 = arrayList.size() - 1; size4 >= 0; size4--) {
                    endChangeAnimationIfNecessary((ChangeInfo) arrayList.get(size4));
                    if (arrayList.isEmpty()) {
                        this.mChangesList.remove(arrayList);
                    }
                }
            }
            cancelAll(this.mRemoveAnimations);
            cancelAll(this.mMoveAnimations);
            cancelAll(this.mAddAnimations);
            cancelAll(this.mChangeAnimations);
            dispatchAnimationsFinished();
        }
    }

    public boolean isRunning() {
        return (this.mPendingAdditions.isEmpty() && this.mPendingChanges.isEmpty() && this.mPendingMoves.isEmpty() && this.mPendingRemovals.isEmpty() && this.mMoveAnimations.isEmpty() && this.mRemoveAnimations.isEmpty() && this.mAddAnimations.isEmpty() && this.mChangeAnimations.isEmpty() && this.mMovesList.isEmpty() && this.mAdditionsList.isEmpty() && this.mChangesList.isEmpty()) ? false : true;
    }

    public void runPendingAnimations() {
        int isEmpty = this.mPendingRemovals.isEmpty() ^ 1;
        int isEmpty2 = this.mPendingMoves.isEmpty() ^ 1;
        int isEmpty3 = this.mPendingChanges.isEmpty() ^ 1;
        int isEmpty4 = this.mPendingAdditions.isEmpty() ^ 1;
        if (isEmpty != 0 || isEmpty2 != 0 || isEmpty4 != 0 || isEmpty3 != 0) {
            final ArrayList arrayList;
            Iterator it = this.mPendingRemovals.iterator();
            while (it.hasNext()) {
                animateRemoveImpl((ViewHolder) it.next());
            }
            this.mPendingRemovals.clear();
            if (isEmpty2 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.mPendingMoves);
                this.mMovesList.add(arrayList);
                this.mPendingMoves.clear();
                AnonymousClass1 anonymousClass1 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            MoveInfo moveInfo = (MoveInfo) it.next();
                            DefaultItemAnimator.this.animateMoveImpl(moveInfo.holder, moveInfo.fromX, moveInfo.fromY, moveInfo.toX, moveInfo.toY);
                        }
                        arrayList.clear();
                        DefaultItemAnimator.this.mMovesList.remove(arrayList);
                    }
                };
                if (isEmpty != 0) {
                    ViewCompat.postOnAnimationDelayed(((MoveInfo) arrayList.get(0)).holder.itemView, anonymousClass1, getRemoveDuration());
                } else {
                    anonymousClass1.run();
                }
            }
            if (isEmpty3 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.mPendingChanges);
                this.mChangesList.add(arrayList);
                this.mPendingChanges.clear();
                AnonymousClass2 anonymousClass2 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            DefaultItemAnimator.this.animateChangeImpl((ChangeInfo) it.next());
                        }
                        arrayList.clear();
                        DefaultItemAnimator.this.mChangesList.remove(arrayList);
                    }
                };
                if (isEmpty != 0) {
                    ViewCompat.postOnAnimationDelayed(((ChangeInfo) arrayList.get(0)).oldHolder.itemView, anonymousClass2, getRemoveDuration());
                } else {
                    anonymousClass2.run();
                }
            }
            if (isEmpty4 != 0) {
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.mPendingAdditions);
                this.mAdditionsList.add(arrayList2);
                this.mPendingAdditions.clear();
                AnonymousClass3 anonymousClass3 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            DefaultItemAnimator.this.animateAddImpl((ViewHolder) it.next());
                        }
                        arrayList2.clear();
                        DefaultItemAnimator.this.mAdditionsList.remove(arrayList2);
                    }
                };
                if (isEmpty == 0 && isEmpty2 == 0 && isEmpty3 == 0) {
                    anonymousClass3.run();
                } else {
                    long j = 0;
                    long removeDuration = isEmpty != 0 ? getRemoveDuration() : 0;
                    long moveDuration = isEmpty2 != 0 ? getMoveDuration() : 0;
                    if (isEmpty3 != 0) {
                        j = getChangeDuration();
                    }
                    ViewCompat.postOnAnimationDelayed(((ViewHolder) arrayList2.get(0)).itemView, anonymousClass3, removeDuration + Math.max(moveDuration, j));
                }
            }
        }
    }
}
