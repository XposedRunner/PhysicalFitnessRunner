package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.annotation.CallSuper;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.app.FragmentManager.BackStackEntry;
import android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v4.os.BuildCompat;
import android.support.v4.util.ArraySet;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.LogWriter;
import android.support.v4.util.Pair;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: FragmentManager */
final class FragmentManagerImpl extends FragmentManager implements LayoutInflaterFactory {
    static final Interpolator ACCELERATE_CUBIC = new AccelerateInterpolator(1.5f);
    static final Interpolator ACCELERATE_QUINT = new AccelerateInterpolator(2.5f);
    static final int ANIM_DUR = 220;
    public static final int ANIM_STYLE_CLOSE_ENTER = 3;
    public static final int ANIM_STYLE_CLOSE_EXIT = 4;
    public static final int ANIM_STYLE_FADE_ENTER = 5;
    public static final int ANIM_STYLE_FADE_EXIT = 6;
    public static final int ANIM_STYLE_OPEN_ENTER = 1;
    public static final int ANIM_STYLE_OPEN_EXIT = 2;
    static boolean DEBUG = false;
    static final Interpolator DECELERATE_CUBIC = new DecelerateInterpolator(1.5f);
    static final Interpolator DECELERATE_QUINT = new DecelerateInterpolator(2.5f);
    static final boolean HONEYCOMB = (VERSION.SDK_INT >= 11);
    static final String TAG = "FragmentManager";
    static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    static final String TARGET_STATE_TAG = "android:target_state";
    static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    static final String VIEW_STATE_TAG = "android:view_state";
    static Field sAnimationListenerField;
    ArrayList<Fragment> mActive;
    ArrayList<Fragment> mAdded;
    ArrayList<Integer> mAvailBackStackIndices;
    ArrayList<Integer> mAvailIndices;
    ArrayList<BackStackRecord> mBackStack;
    ArrayList<OnBackStackChangedListener> mBackStackChangeListeners;
    ArrayList<BackStackRecord> mBackStackIndices;
    FragmentContainer mContainer;
    ArrayList<Fragment> mCreatedMenus;
    int mCurState = 0;
    boolean mDestroyed;
    Runnable mExecCommit = new Runnable() {
        public void run() {
            FragmentManagerImpl.this.execPendingActions();
        }
    };
    boolean mExecutingActions;
    boolean mHavePendingDeferredStart;
    FragmentHostCallback mHost;
    private CopyOnWriteArrayList<Pair<FragmentLifecycleCallbacks, Boolean>> mLifecycleCallbacks;
    boolean mNeedMenuInvalidate;
    String mNoTransactionsBecause;
    Fragment mParent;
    ArrayList<OpGenerator> mPendingActions;
    ArrayList<StartEnterTransitionListener> mPostponedTransactions;
    SparseArray<Parcelable> mStateArray = null;
    Bundle mStateBundle = null;
    boolean mStateSaved;
    Runnable[] mTmpActions;
    ArrayList<Fragment> mTmpAddedFragments;
    ArrayList<Boolean> mTmpIsPop;
    ArrayList<BackStackRecord> mTmpRecords;

    /* compiled from: FragmentManager */
    interface OpGenerator {
        boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* compiled from: FragmentManager */
    static class AnimateOnHWLayerIfNeededListener implements AnimationListener {
        private AnimationListener mOriginalListener;
        private boolean mShouldRunOnHWLayer;
        View mView;

        public AnimateOnHWLayerIfNeededListener(View view, Animation animation) {
            if (view != null && animation != null) {
                this.mView = view;
            }
        }

        public AnimateOnHWLayerIfNeededListener(View view, Animation animation, AnimationListener animationListener) {
            if (view != null && animation != null) {
                this.mOriginalListener = animationListener;
                this.mView = view;
                this.mShouldRunOnHWLayer = true;
            }
        }

        @CallSuper
        public void onAnimationEnd(Animation animation) {
            if (this.mView != null && this.mShouldRunOnHWLayer) {
                if (ViewCompat.isAttachedToWindow(this.mView) || BuildCompat.isAtLeastN()) {
                    this.mView.post(new Runnable() {
                        public void run() {
                            ViewCompat.setLayerType(AnimateOnHWLayerIfNeededListener.this.mView, 0, null);
                        }
                    });
                } else {
                    ViewCompat.setLayerType(this.mView, 0, null);
                }
            }
            if (this.mOriginalListener != null) {
                this.mOriginalListener.onAnimationEnd(animation);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            if (this.mOriginalListener != null) {
                this.mOriginalListener.onAnimationRepeat(animation);
            }
        }

        @CallSuper
        public void onAnimationStart(Animation animation) {
            if (this.mOriginalListener != null) {
                this.mOriginalListener.onAnimationStart(animation);
            }
        }
    }

    /* compiled from: FragmentManager */
    static class FragmentTag {
        public static final int[] Fragment = new int[]{16842755, 16842960, 16842961};
        public static final int Fragment_id = 1;
        public static final int Fragment_name = 0;
        public static final int Fragment_tag = 2;

        FragmentTag() {
        }
    }

    /* compiled from: FragmentManager */
    private class PopBackStackState implements OpGenerator {
        final int mFlags;
        final int mId;
        final String mName;

        PopBackStackState(String str, int i, int i2) {
            this.mName = str;
            this.mId = i;
            this.mFlags = i2;
        }

        public boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
            return FragmentManagerImpl.this.popBackStackState(arrayList, arrayList2, this.mName, this.mId, this.mFlags);
        }
    }

    /* compiled from: FragmentManager */
    static class StartEnterTransitionListener implements OnStartEnterTransitionListener {
        private final boolean mIsBack;
        private int mNumPostponed;
        private final BackStackRecord mRecord;

        StartEnterTransitionListener(BackStackRecord backStackRecord, boolean z) {
            this.mIsBack = z;
            this.mRecord = backStackRecord;
        }

        public void cancelTransaction() {
            this.mRecord.mManager.completeExecute(this.mRecord, this.mIsBack, false, false);
        }

        public void completeTransaction() {
            int i = 0;
            int i2 = this.mNumPostponed > 0 ? 1 : 0;
            FragmentManagerImpl fragmentManagerImpl = this.mRecord.mManager;
            int size = fragmentManagerImpl.mAdded.size();
            while (i < size) {
                Fragment fragment = (Fragment) fragmentManagerImpl.mAdded.get(i);
                fragment.setOnStartEnterTransitionListener(null);
                if (i2 != 0 && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
                i++;
            }
            this.mRecord.mManager.completeExecute(this.mRecord, this.mIsBack, i2 ^ 1, true);
        }

        public boolean isReady() {
            return this.mNumPostponed == 0;
        }

        public void onStartEnterTransition() {
            this.mNumPostponed--;
            if (this.mNumPostponed == 0) {
                this.mRecord.mManager.scheduleCommit();
            }
        }

        public void startListening() {
            this.mNumPostponed++;
        }
    }

    FragmentManagerImpl() {
    }

    private void addAddedFragments(ArraySet<Fragment> arraySet) {
        if (this.mCurState >= 1) {
            int min = Math.min(this.mCurState, 4);
            int size = this.mAdded == null ? 0 : this.mAdded.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = (Fragment) this.mAdded.get(i);
                if (fragment.mState < min) {
                    moveToState(fragment, min, fragment.getNextAnim(), fragment.getNextTransition(), false);
                    if (!(fragment.mView == null || fragment.mHidden || !fragment.mIsNewlyAdded)) {
                        arraySet.add(fragment);
                    }
                }
            }
        }
    }

    private void checkStateLoss() {
        if (this.mStateSaved) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.mNoTransactionsBecause != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Can not perform this action inside of ");
            stringBuilder.append(this.mNoTransactionsBecause);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    private void cleanupExec() {
        this.mExecutingActions = false;
        this.mTmpIsPop.clear();
        this.mTmpRecords.clear();
    }

    private void completeExecute(BackStackRecord backStackRecord, boolean z, boolean z2, boolean z3) {
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(backStackRecord);
        arrayList2.add(Boolean.valueOf(z));
        executeOps(arrayList, arrayList2, 0, 1);
        if (z2) {
            FragmentTransition.startTransitions(this, arrayList, arrayList2, 0, 1, true);
        }
        if (z3) {
            moveToState(this.mCurState, true);
        }
        if (this.mActive != null) {
            int size = this.mActive.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = (Fragment) this.mActive.get(i);
                if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && backStackRecord.interactsWith(fragment.mContainerId)) {
                    if (VERSION.SDK_INT >= 11 && fragment.mPostponedAlpha > 0.0f) {
                        fragment.mView.setAlpha(fragment.mPostponedAlpha);
                    }
                    if (z3) {
                        fragment.mPostponedAlpha = 0.0f;
                    } else {
                        fragment.mPostponedAlpha = -1.0f;
                        fragment.mIsNewlyAdded = false;
                    }
                }
            }
        }
    }

    private void endAnimatingAwayFragments() {
        int i = 0;
        int size = this.mActive == null ? 0 : this.mActive.size();
        while (i < size) {
            Fragment fragment = (Fragment) this.mActive.get(i);
            if (!(fragment == null || fragment.getAnimatingAway() == null)) {
                int stateAfterAnimating = fragment.getStateAfterAnimating();
                View animatingAway = fragment.getAnimatingAway();
                fragment.setAnimatingAway(null);
                Animation animation = animatingAway.getAnimation();
                if (animation != null) {
                    animation.cancel();
                }
                moveToState(fragment, stateAfterAnimating, 0, 0, false);
            }
            i++;
        }
    }

    private void ensureExecReady(boolean z) {
        if (this.mExecutingActions) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (Looper.myLooper() != this.mHost.getHandler().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else {
            if (!z) {
                checkStateLoss();
            }
            if (this.mTmpRecords == null) {
                this.mTmpRecords = new ArrayList();
                this.mTmpIsPop = new ArrayList();
            }
            this.mExecutingActions = true;
            try {
                executePostponedTransaction(null, null);
            } finally {
                this.mExecutingActions = false;
            }
        }
    }

    private static void executeOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            BackStackRecord backStackRecord = (BackStackRecord) arrayList.get(i);
            boolean z = true;
            if (((Boolean) arrayList2.get(i)).booleanValue()) {
                backStackRecord.bumpBackStackNesting(-1);
                if (i != i2 - 1) {
                    z = false;
                }
                backStackRecord.executePopOps(z);
            } else {
                backStackRecord.bumpBackStackNesting(1);
                backStackRecord.executeOps();
            }
            i++;
        }
    }

    private void executeOpsTogether(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int i3;
        ArrayList<BackStackRecord> arrayList3 = arrayList;
        ArrayList<Boolean> arrayList4 = arrayList2;
        int i4 = i;
        int i5 = i2;
        boolean z = ((BackStackRecord) arrayList3.get(i4)).mAllowOptimization;
        if (this.mTmpAddedFragments == null) {
            this.mTmpAddedFragments = new ArrayList();
        } else {
            this.mTmpAddedFragments.clear();
        }
        if (this.mAdded != null) {
            this.mTmpAddedFragments.addAll(this.mAdded);
        }
        boolean z2 = false;
        for (int i6 = i4; i6 < i5; i6++) {
            BackStackRecord backStackRecord = (BackStackRecord) arrayList3.get(i6);
            if (((Boolean) arrayList4.get(i6)).booleanValue()) {
                backStackRecord.trackAddedFragmentsInPop(this.mTmpAddedFragments);
            } else {
                backStackRecord.expandReplaceOps(this.mTmpAddedFragments);
            }
            z2 = z2 || backStackRecord.mAddToBackStack;
        }
        this.mTmpAddedFragments.clear();
        if (!z) {
            FragmentTransition.startTransitions(this, arrayList3, arrayList4, i4, i5, false);
        }
        executeOps(arrayList, arrayList2, i, i2);
        if (z) {
            ArraySet arraySet = new ArraySet();
            addAddedFragments(arraySet);
            int postponePostponableTransactions = postponePostponableTransactions(arrayList3, arrayList4, i4, i5, arraySet);
            makeRemovedFragmentsInvisible(arraySet);
            i3 = postponePostponableTransactions;
        } else {
            i3 = i5;
        }
        if (i3 != i4 && z) {
            FragmentTransition.startTransitions(this, arrayList3, arrayList4, i4, i3, true);
            moveToState(this.mCurState, true);
        }
        while (i4 < i5) {
            BackStackRecord backStackRecord2 = (BackStackRecord) arrayList3.get(i4);
            if (((Boolean) arrayList4.get(i4)).booleanValue() && backStackRecord2.mIndex >= 0) {
                freeBackStackIndex(backStackRecord2.mIndex);
                backStackRecord2.mIndex = -1;
            }
            i4++;
        }
        if (z2) {
            reportBackStackChanged();
        }
    }

    private void executePostponedTransaction(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        int size = this.mPostponedTransactions == null ? 0 : this.mPostponedTransactions.size();
        int i = 0;
        while (i < size) {
            int indexOf;
            StartEnterTransitionListener startEnterTransitionListener = (StartEnterTransitionListener) this.mPostponedTransactions.get(i);
            if (!(arrayList == null || startEnterTransitionListener.mIsBack)) {
                indexOf = arrayList.indexOf(startEnterTransitionListener.mRecord);
                if (indexOf != -1 && ((Boolean) arrayList2.get(indexOf)).booleanValue()) {
                    startEnterTransitionListener.cancelTransaction();
                    i++;
                }
            }
            if (startEnterTransitionListener.isReady() || (arrayList != null && startEnterTransitionListener.mRecord.interactsWith(arrayList, 0, arrayList.size()))) {
                this.mPostponedTransactions.remove(i);
                i--;
                size--;
                if (!(arrayList == null || startEnterTransitionListener.mIsBack)) {
                    indexOf = arrayList.indexOf(startEnterTransitionListener.mRecord);
                    if (indexOf != -1 && ((Boolean) arrayList2.get(indexOf)).booleanValue()) {
                        startEnterTransitionListener.cancelTransaction();
                    }
                }
                startEnterTransitionListener.completeTransaction();
            }
            i++;
        }
    }

    private Fragment findFragmentUnder(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        View view = fragment.mView;
        if (viewGroup == null || view == null) {
            return null;
        }
        for (int indexOf = this.mAdded.indexOf(fragment) - 1; indexOf >= 0; indexOf--) {
            Fragment fragment2 = (Fragment) this.mAdded.get(indexOf);
            if (fragment2.mContainer == viewGroup && fragment2.mView != null) {
                return fragment2;
            }
        }
        return null;
    }

    private void forcePostponedTransactions() {
        if (this.mPostponedTransactions != null) {
            while (!this.mPostponedTransactions.isEmpty()) {
                ((StartEnterTransitionListener) this.mPostponedTransactions.remove(0)).completeTransaction();
            }
        }
    }

    /* JADX WARNING: Missing block: B:12:0x0037, code skipped:
            if (r0 <= 0) goto L_0x003a;
     */
    /* JADX WARNING: Missing block: B:13:0x0039, code skipped:
            r1 = true;
     */
    /* JADX WARNING: Missing block: B:14:0x003a, code skipped:
            return r1;
     */
    /* JADX WARNING: Missing block: B:16:0x003c, code skipped:
            return false;
     */
    private boolean generateOpsForPendingActions(java.util.ArrayList<android.support.v4.app.BackStackRecord> r5, java.util.ArrayList<java.lang.Boolean> r6) {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r4.mPendingActions;	 Catch:{ all -> 0x003d }
        r1 = 0;
        if (r0 == 0) goto L_0x003b;
    L_0x0006:
        r0 = r4.mPendingActions;	 Catch:{ all -> 0x003d }
        r0 = r0.size();	 Catch:{ all -> 0x003d }
        if (r0 != 0) goto L_0x000f;
    L_0x000e:
        goto L_0x003b;
    L_0x000f:
        r0 = r4.mPendingActions;	 Catch:{ all -> 0x003d }
        r0 = r0.size();	 Catch:{ all -> 0x003d }
        r2 = r1;
    L_0x0016:
        if (r2 >= r0) goto L_0x0026;
    L_0x0018:
        r3 = r4.mPendingActions;	 Catch:{ all -> 0x003d }
        r3 = r3.get(r2);	 Catch:{ all -> 0x003d }
        r3 = (android.support.v4.app.FragmentManagerImpl.OpGenerator) r3;	 Catch:{ all -> 0x003d }
        r3.generateOps(r5, r6);	 Catch:{ all -> 0x003d }
        r2 = r2 + 1;
        goto L_0x0016;
    L_0x0026:
        r5 = r4.mPendingActions;	 Catch:{ all -> 0x003d }
        r5.clear();	 Catch:{ all -> 0x003d }
        r5 = r4.mHost;	 Catch:{ all -> 0x003d }
        r5 = r5.getHandler();	 Catch:{ all -> 0x003d }
        r6 = r4.mExecCommit;	 Catch:{ all -> 0x003d }
        r5.removeCallbacks(r6);	 Catch:{ all -> 0x003d }
        monitor-exit(r4);	 Catch:{ all -> 0x003d }
        if (r0 <= 0) goto L_0x003a;
    L_0x0039:
        r1 = 1;
    L_0x003a:
        return r1;
    L_0x003b:
        monitor-exit(r4);	 Catch:{ all -> 0x003d }
        return r1;
    L_0x003d:
        r5 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x003d }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentManagerImpl.generateOpsForPendingActions(java.util.ArrayList, java.util.ArrayList):boolean");
    }

    static Animation makeFadeAnimation(Context context, float f, float f2) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(DECELERATE_CUBIC);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    static Animation makeOpenCloseAnimation(Context context, float f, float f2, float f3, float f4) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(DECELERATE_QUINT);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f3, f4);
        alphaAnimation.setInterpolator(DECELERATE_CUBIC);
        alphaAnimation.setDuration(220);
        animationSet.addAnimation(alphaAnimation);
        return animationSet;
    }

    private void makeRemovedFragmentsInvisible(ArraySet<Fragment> arraySet) {
        int size = arraySet.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = (Fragment) arraySet.valueAt(i);
            if (!fragment.mAdded) {
                View view = fragment.getView();
                if (VERSION.SDK_INT < 11) {
                    fragment.getView().setVisibility(4);
                } else {
                    fragment.mPostponedAlpha = view.getAlpha();
                    view.setAlpha(0.0f);
                }
            }
        }
    }

    static boolean modifiesAlpha(Animation animation) {
        if (animation instanceof AlphaAnimation) {
            return true;
        }
        if (animation instanceof AnimationSet) {
            List animations = ((AnimationSet) animation).getAnimations();
            for (int i = 0; i < animations.size(); i++) {
                if (animations.get(i) instanceof AlphaAnimation) {
                    return true;
                }
            }
        }
        return false;
    }

    private void optimizeAndExecuteOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList != null && !arrayList.isEmpty()) {
            if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
                throw new IllegalStateException("Internal error with the back stack records");
            }
            executePostponedTransaction(arrayList, arrayList2);
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                if (!((BackStackRecord) arrayList.get(i)).mAllowOptimization) {
                    if (i2 != i) {
                        executeOpsTogether(arrayList, arrayList2, i2, i);
                    }
                    i2 = i + 1;
                    if (((Boolean) arrayList2.get(i)).booleanValue()) {
                        while (i2 < size && ((Boolean) arrayList2.get(i2)).booleanValue() && !((BackStackRecord) arrayList.get(i2)).mAllowOptimization) {
                            i2++;
                        }
                    }
                    executeOpsTogether(arrayList, arrayList2, i, i2);
                    i = i2 - 1;
                }
                i++;
            }
            if (i2 != size) {
                executeOpsTogether(arrayList, arrayList2, i2, size);
            }
        }
    }

    private boolean popBackStackImmediate(String str, int i, int i2) {
        execPendingActions();
        ensureExecReady(true);
        boolean popBackStackState = popBackStackState(this.mTmpRecords, this.mTmpIsPop, str, i, i2);
        if (popBackStackState) {
            this.mExecutingActions = true;
            try {
                optimizeAndExecuteOps(this.mTmpRecords, this.mTmpIsPop);
            } finally {
                cleanupExec();
            }
        }
        doPendingDeferredStart();
        return popBackStackState;
    }

    private int postponePostponableTransactions(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, ArraySet<Fragment> arraySet) {
        int i3 = i2;
        for (int i4 = i2 - 1; i4 >= i; i4--) {
            BackStackRecord backStackRecord = (BackStackRecord) arrayList.get(i4);
            boolean booleanValue = ((Boolean) arrayList2.get(i4)).booleanValue();
            boolean z = backStackRecord.isPostponed() && !backStackRecord.interactsWith(arrayList, i4 + 1, i2);
            if (z) {
                if (this.mPostponedTransactions == null) {
                    this.mPostponedTransactions = new ArrayList();
                }
                StartEnterTransitionListener startEnterTransitionListener = new StartEnterTransitionListener(backStackRecord, booleanValue);
                this.mPostponedTransactions.add(startEnterTransitionListener);
                backStackRecord.setOnStartPostponedListener(startEnterTransitionListener);
                if (booleanValue) {
                    backStackRecord.executeOps();
                } else {
                    backStackRecord.executePopOps(false);
                }
                i3--;
                if (i4 != i3) {
                    arrayList.remove(i4);
                    arrayList.add(i3, backStackRecord);
                }
                addAddedFragments(arraySet);
            }
        }
        return i3;
    }

    public static int reverseTransit(int i) {
        return i != 4097 ? i != 4099 ? i != 8194 ? 0 : 4097 : 4099 : 8194;
    }

    private void scheduleCommit() {
        synchronized (this) {
            Object obj = null;
            Object obj2 = (this.mPostponedTransactions == null || this.mPostponedTransactions.isEmpty()) ? null : 1;
            if (this.mPendingActions != null && this.mPendingActions.size() == 1) {
                obj = 1;
            }
            if (!(obj2 == null && obj == null)) {
                this.mHost.getHandler().removeCallbacks(this.mExecCommit);
                this.mHost.getHandler().post(this.mExecCommit);
            }
        }
    }

    /* JADX WARNING: Missing block: B:17:0x0048, code skipped:
            return;
     */
    private void setHWLayerAnimListenerIfAlpha(android.view.View r5, android.view.animation.Animation r6) {
        /*
        r4 = this;
        if (r5 == 0) goto L_0x0048;
    L_0x0002:
        if (r6 != 0) goto L_0x0005;
    L_0x0004:
        goto L_0x0048;
    L_0x0005:
        r0 = shouldRunOnHWLayer(r5, r6);
        if (r0 == 0) goto L_0x0047;
    L_0x000b:
        r0 = 0;
        r1 = sAnimationListenerField;	 Catch:{ NoSuchFieldException -> 0x0032, IllegalAccessException -> 0x0029 }
        if (r1 != 0) goto L_0x0020;
    L_0x0010:
        r1 = android.view.animation.Animation.class;
        r2 = "mListener";
        r1 = r1.getDeclaredField(r2);	 Catch:{ NoSuchFieldException -> 0x0032, IllegalAccessException -> 0x0029 }
        sAnimationListenerField = r1;	 Catch:{ NoSuchFieldException -> 0x0032, IllegalAccessException -> 0x0029 }
        r1 = sAnimationListenerField;	 Catch:{ NoSuchFieldException -> 0x0032, IllegalAccessException -> 0x0029 }
        r2 = 1;
        r1.setAccessible(r2);	 Catch:{ NoSuchFieldException -> 0x0032, IllegalAccessException -> 0x0029 }
    L_0x0020:
        r1 = sAnimationListenerField;	 Catch:{ NoSuchFieldException -> 0x0032, IllegalAccessException -> 0x0029 }
        r1 = r1.get(r6);	 Catch:{ NoSuchFieldException -> 0x0032, IllegalAccessException -> 0x0029 }
        r1 = (android.view.animation.Animation.AnimationListener) r1;	 Catch:{ NoSuchFieldException -> 0x0032, IllegalAccessException -> 0x0029 }
        goto L_0x003b;
    L_0x0029:
        r1 = move-exception;
        r2 = "FragmentManager";
        r3 = "Cannot access Animation's mListener field";
        android.util.Log.e(r2, r3, r1);
        goto L_0x003a;
    L_0x0032:
        r1 = move-exception;
        r2 = "FragmentManager";
        r3 = "No field with the name mListener is found in Animation class";
        android.util.Log.e(r2, r3, r1);
    L_0x003a:
        r1 = r0;
    L_0x003b:
        r2 = 2;
        android.support.v4.view.ViewCompat.setLayerType(r5, r2, r0);
        r0 = new android.support.v4.app.FragmentManagerImpl$AnimateOnHWLayerIfNeededListener;
        r0.<init>(r5, r6, r1);
        r6.setAnimationListener(r0);
    L_0x0047:
        return;
    L_0x0048:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentManagerImpl.setHWLayerAnimListenerIfAlpha(android.view.View, android.view.animation.Animation):void");
    }

    static boolean shouldRunOnHWLayer(View view, Animation animation) {
        return VERSION.SDK_INT >= 19 && ViewCompat.getLayerType(view) == 0 && ViewCompat.hasOverlappingRendering(view) && modifiesAlpha(animation);
    }

    private void throwException(RuntimeException runtimeException) {
        Log.e(TAG, runtimeException.getMessage());
        Log.e(TAG, "Activity state:");
        PrintWriter printWriter = new PrintWriter(new LogWriter(TAG));
        if (this.mHost != null) {
            try {
                this.mHost.onDump("  ", null, printWriter, new String[0]);
            } catch (Exception e) {
                Log.e(TAG, "Failed dumping state", e);
            }
        } else {
            try {
                dump("  ", null, printWriter, new String[0]);
            } catch (Exception e2) {
                Log.e(TAG, "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    public static int transitToStyleIndex(int i, boolean z) {
        return i != 4097 ? i != 4099 ? i != 8194 ? -1 : z ? 3 : 4 : z ? 5 : 6 : z ? 1 : 2;
    }

    /* Access modifiers changed, original: 0000 */
    public void addBackStackState(BackStackRecord backStackRecord) {
        if (this.mBackStack == null) {
            this.mBackStack = new ArrayList();
        }
        this.mBackStack.add(backStackRecord);
        reportBackStackChanged();
    }

    public void addFragment(Fragment fragment, boolean z) {
        if (this.mAdded == null) {
            this.mAdded = new ArrayList();
        }
        if (DEBUG) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("add: ");
            stringBuilder.append(fragment);
            Log.v(str, stringBuilder.toString());
        }
        makeActive(fragment);
        if (!fragment.mDetached) {
            if (this.mAdded.contains(fragment)) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Fragment already added: ");
                stringBuilder2.append(fragment);
                throw new IllegalStateException(stringBuilder2.toString());
            }
            this.mAdded.add(fragment);
            fragment.mAdded = true;
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.mNeedMenuInvalidate = true;
            }
            if (z) {
                moveToState(fragment);
            }
        }
    }

    public void addOnBackStackChangedListener(OnBackStackChangedListener onBackStackChangedListener) {
        if (this.mBackStackChangeListeners == null) {
            this.mBackStackChangeListeners = new ArrayList();
        }
        this.mBackStackChangeListeners.add(onBackStackChangedListener);
    }

    public int allocBackStackIndex(BackStackRecord backStackRecord) {
        synchronized (this) {
            int intValue;
            String str;
            StringBuilder stringBuilder;
            if (this.mAvailBackStackIndices != null) {
                if (this.mAvailBackStackIndices.size() > 0) {
                    intValue = ((Integer) this.mAvailBackStackIndices.remove(this.mAvailBackStackIndices.size() - 1)).intValue();
                    if (DEBUG) {
                        str = TAG;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Adding back stack index ");
                        stringBuilder.append(intValue);
                        stringBuilder.append(" with ");
                        stringBuilder.append(backStackRecord);
                        Log.v(str, stringBuilder.toString());
                    }
                    this.mBackStackIndices.set(intValue, backStackRecord);
                    return intValue;
                }
            }
            if (this.mBackStackIndices == null) {
                this.mBackStackIndices = new ArrayList();
            }
            intValue = this.mBackStackIndices.size();
            if (DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Setting back stack index ");
                stringBuilder.append(intValue);
                stringBuilder.append(" to ");
                stringBuilder.append(backStackRecord);
                Log.v(str, stringBuilder.toString());
            }
            this.mBackStackIndices.add(backStackRecord);
            return intValue;
        }
    }

    public void attachController(FragmentHostCallback fragmentHostCallback, FragmentContainer fragmentContainer, Fragment fragment) {
        if (this.mHost != null) {
            throw new IllegalStateException("Already attached");
        }
        this.mHost = fragmentHostCallback;
        this.mContainer = fragmentContainer;
        this.mParent = fragment;
    }

    public void attachFragment(Fragment fragment) {
        String str;
        StringBuilder stringBuilder;
        if (DEBUG) {
            str = TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append("attach: ");
            stringBuilder.append(fragment);
            Log.v(str, stringBuilder.toString());
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                if (this.mAdded == null) {
                    this.mAdded = new ArrayList();
                }
                if (this.mAdded.contains(fragment)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Fragment already added: ");
                    stringBuilder.append(fragment);
                    throw new IllegalStateException(stringBuilder.toString());
                }
                if (DEBUG) {
                    str = TAG;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("add from attach: ");
                    stringBuilder.append(fragment);
                    Log.v(str, stringBuilder.toString());
                }
                this.mAdded.add(fragment);
                fragment.mAdded = true;
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.mNeedMenuInvalidate = true;
                }
            }
        }
    }

    public FragmentTransaction beginTransaction() {
        return new BackStackRecord(this);
    }

    /* Access modifiers changed, original: 0000 */
    public void completeShowHideFragment(Fragment fragment) {
        if (fragment.mView != null) {
            Animation loadAnimation = loadAnimation(fragment, fragment.getNextTransition(), fragment.mHidden ^ 1, fragment.getNextTransitionStyle());
            if (loadAnimation != null) {
                setHWLayerAnimListenerIfAlpha(fragment.mView, loadAnimation);
                fragment.mView.startAnimation(loadAnimation);
                setHWLayerAnimListenerIfAlpha(fragment.mView, loadAnimation);
                loadAnimation.start();
            }
            int i = (!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8;
            fragment.mView.setVisibility(i);
            if (fragment.isHideReplaced()) {
                fragment.setHideReplaced(false);
            }
        }
        if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
            this.mNeedMenuInvalidate = true;
        }
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    public void detachFragment(Fragment fragment) {
        if (DEBUG) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("detach: ");
            stringBuilder.append(fragment);
            Log.v(str, stringBuilder.toString());
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (this.mAdded != null) {
                    if (DEBUG) {
                        String str2 = TAG;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("remove from detach: ");
                        stringBuilder2.append(fragment);
                        Log.v(str2, stringBuilder2.toString());
                    }
                    this.mAdded.remove(fragment);
                }
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.mNeedMenuInvalidate = true;
                }
                fragment.mAdded = false;
            }
        }
    }

    public void dispatchActivityCreated() {
        this.mStateSaved = false;
        this.mExecutingActions = true;
        moveToState(2, false);
        this.mExecutingActions = false;
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        if (this.mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); i++) {
                Fragment fragment = (Fragment) this.mAdded.get(i);
                if (fragment != null) {
                    fragment.performConfigurationChanged(configuration);
                }
            }
        }
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        if (this.mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); i++) {
                Fragment fragment = (Fragment) this.mAdded.get(i);
                if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void dispatchCreate() {
        this.mStateSaved = false;
        this.mExecutingActions = true;
        moveToState(1, false);
        this.mExecutingActions = false;
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z;
        int i = 0;
        ArrayList arrayList = null;
        if (this.mAdded != null) {
            int i2 = 0;
            z = i2;
            while (i2 < this.mAdded.size()) {
                Fragment fragment = (Fragment) this.mAdded.get(i2);
                if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                    z = true;
                }
                i2++;
            }
        } else {
            z = false;
        }
        if (this.mCreatedMenus != null) {
            while (i < this.mCreatedMenus.size()) {
                Fragment fragment2 = (Fragment) this.mCreatedMenus.get(i);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
                i++;
            }
        }
        this.mCreatedMenus = arrayList;
        return z;
    }

    public void dispatchDestroy() {
        this.mDestroyed = true;
        execPendingActions();
        this.mExecutingActions = true;
        moveToState(0, false);
        this.mExecutingActions = false;
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
    }

    public void dispatchDestroyView() {
        this.mExecutingActions = true;
        moveToState(1, false);
        this.mExecutingActions = false;
    }

    public void dispatchLowMemory() {
        if (this.mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); i++) {
                Fragment fragment = (Fragment) this.mAdded.get(i);
                if (fragment != null) {
                    fragment.performLowMemory();
                }
            }
        }
    }

    public void dispatchMultiWindowModeChanged(boolean z) {
        if (this.mAdded != null) {
            for (int size = this.mAdded.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.mAdded.get(size);
                if (fragment != null) {
                    fragment.performMultiWindowModeChanged(z);
                }
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void dispatchOnFragmentActivityCreated(Fragment fragment, Bundle bundle, boolean z) {
        if (this.mParent != null) {
            FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentActivityCreated(fragment, bundle, true);
            }
        }
        if (this.mLifecycleCallbacks != null) {
            Iterator it = this.mLifecycleCallbacks.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (!z || ((Boolean) pair.second).booleanValue()) {
                    ((FragmentLifecycleCallbacks) pair.first).onFragmentActivityCreated(this, fragment, bundle);
                }
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void dispatchOnFragmentAttached(Fragment fragment, Context context, boolean z) {
        if (this.mParent != null) {
            FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentAttached(fragment, context, true);
            }
        }
        if (this.mLifecycleCallbacks != null) {
            Iterator it = this.mLifecycleCallbacks.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (!z || ((Boolean) pair.second).booleanValue()) {
                    ((FragmentLifecycleCallbacks) pair.first).onFragmentAttached(this, fragment, context);
                }
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void dispatchOnFragmentCreated(Fragment fragment, Bundle bundle, boolean z) {
        if (this.mParent != null) {
            FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentCreated(fragment, bundle, true);
            }
        }
        if (this.mLifecycleCallbacks != null) {
            Iterator it = this.mLifecycleCallbacks.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (!z || ((Boolean) pair.second).booleanValue()) {
                    ((FragmentLifecycleCallbacks) pair.first).onFragmentCreated(this, fragment, bundle);
                }
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void dispatchOnFragmentDestroyed(Fragment fragment, boolean z) {
        if (this.mParent != null) {
            FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentDestroyed(fragment, true);
            }
        }
        if (this.mLifecycleCallbacks != null) {
            Iterator it = this.mLifecycleCallbacks.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (!z || ((Boolean) pair.second).booleanValue()) {
                    ((FragmentLifecycleCallbacks) pair.first).onFragmentDestroyed(this, fragment);
                }
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void dispatchOnFragmentDetached(Fragment fragment, boolean z) {
        if (this.mParent != null) {
            FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentDetached(fragment, true);
            }
        }
        if (this.mLifecycleCallbacks != null) {
            Iterator it = this.mLifecycleCallbacks.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (!z || ((Boolean) pair.second).booleanValue()) {
                    ((FragmentLifecycleCallbacks) pair.first).onFragmentDetached(this, fragment);
                }
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void dispatchOnFragmentPaused(Fragment fragment, boolean z) {
        if (this.mParent != null) {
            FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentPaused(fragment, true);
            }
        }
        if (this.mLifecycleCallbacks != null) {
            Iterator it = this.mLifecycleCallbacks.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (!z || ((Boolean) pair.second).booleanValue()) {
                    ((FragmentLifecycleCallbacks) pair.first).onFragmentPaused(this, fragment);
                }
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void dispatchOnFragmentPreAttached(Fragment fragment, Context context, boolean z) {
        if (this.mParent != null) {
            FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentPreAttached(fragment, context, true);
            }
        }
        if (this.mLifecycleCallbacks != null) {
            Iterator it = this.mLifecycleCallbacks.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (!z || ((Boolean) pair.second).booleanValue()) {
                    ((FragmentLifecycleCallbacks) pair.first).onFragmentPreAttached(this, fragment, context);
                }
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void dispatchOnFragmentResumed(Fragment fragment, boolean z) {
        if (this.mParent != null) {
            FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentResumed(fragment, true);
            }
        }
        if (this.mLifecycleCallbacks != null) {
            Iterator it = this.mLifecycleCallbacks.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (!z || ((Boolean) pair.second).booleanValue()) {
                    ((FragmentLifecycleCallbacks) pair.first).onFragmentResumed(this, fragment);
                }
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void dispatchOnFragmentSaveInstanceState(Fragment fragment, Bundle bundle, boolean z) {
        if (this.mParent != null) {
            FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentSaveInstanceState(fragment, bundle, true);
            }
        }
        if (this.mLifecycleCallbacks != null) {
            Iterator it = this.mLifecycleCallbacks.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (!z || ((Boolean) pair.second).booleanValue()) {
                    ((FragmentLifecycleCallbacks) pair.first).onFragmentSaveInstanceState(this, fragment, bundle);
                }
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void dispatchOnFragmentStarted(Fragment fragment, boolean z) {
        if (this.mParent != null) {
            FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentStarted(fragment, true);
            }
        }
        if (this.mLifecycleCallbacks != null) {
            Iterator it = this.mLifecycleCallbacks.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (!z || ((Boolean) pair.second).booleanValue()) {
                    ((FragmentLifecycleCallbacks) pair.first).onFragmentStarted(this, fragment);
                }
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void dispatchOnFragmentStopped(Fragment fragment, boolean z) {
        if (this.mParent != null) {
            FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentStopped(fragment, true);
            }
        }
        if (this.mLifecycleCallbacks != null) {
            Iterator it = this.mLifecycleCallbacks.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (!z || ((Boolean) pair.second).booleanValue()) {
                    ((FragmentLifecycleCallbacks) pair.first).onFragmentStopped(this, fragment);
                }
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void dispatchOnFragmentViewCreated(Fragment fragment, View view, Bundle bundle, boolean z) {
        if (this.mParent != null) {
            FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentViewCreated(fragment, view, bundle, true);
            }
        }
        if (this.mLifecycleCallbacks != null) {
            Iterator it = this.mLifecycleCallbacks.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (!z || ((Boolean) pair.second).booleanValue()) {
                    ((FragmentLifecycleCallbacks) pair.first).onFragmentViewCreated(this, fragment, view, bundle);
                }
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void dispatchOnFragmentViewDestroyed(Fragment fragment, boolean z) {
        if (this.mParent != null) {
            FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentViewDestroyed(fragment, true);
            }
        }
        if (this.mLifecycleCallbacks != null) {
            Iterator it = this.mLifecycleCallbacks.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (!z || ((Boolean) pair.second).booleanValue()) {
                    ((FragmentLifecycleCallbacks) pair.first).onFragmentViewDestroyed(this, fragment);
                }
            }
        }
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        if (this.mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); i++) {
                Fragment fragment = (Fragment) this.mAdded.get(i);
                if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        if (this.mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); i++) {
                Fragment fragment = (Fragment) this.mAdded.get(i);
                if (fragment != null) {
                    fragment.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    public void dispatchPause() {
        this.mExecutingActions = true;
        moveToState(4, false);
        this.mExecutingActions = false;
    }

    public void dispatchPictureInPictureModeChanged(boolean z) {
        if (this.mAdded != null) {
            for (int size = this.mAdded.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.mAdded.get(size);
                if (fragment != null) {
                    fragment.performPictureInPictureModeChanged(z);
                }
            }
        }
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        int i = 0;
        if (this.mAdded == null) {
            return false;
        }
        boolean z = false;
        while (i < this.mAdded.size()) {
            Fragment fragment = (Fragment) this.mAdded.get(i);
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
            i++;
        }
        return z;
    }

    public void dispatchReallyStop() {
        this.mExecutingActions = true;
        moveToState(2, false);
        this.mExecutingActions = false;
    }

    public void dispatchResume() {
        this.mStateSaved = false;
        this.mExecutingActions = true;
        moveToState(5, false);
        this.mExecutingActions = false;
    }

    public void dispatchStart() {
        this.mStateSaved = false;
        this.mExecutingActions = true;
        moveToState(4, false);
        this.mExecutingActions = false;
    }

    public void dispatchStop() {
        this.mStateSaved = true;
        this.mExecutingActions = true;
        moveToState(3, false);
        this.mExecutingActions = false;
    }

    /* Access modifiers changed, original: 0000 */
    public void doPendingDeferredStart() {
        if (this.mHavePendingDeferredStart) {
            int i = 0;
            int i2 = i;
            while (i < this.mActive.size()) {
                Fragment fragment = (Fragment) this.mActive.get(i);
                if (!(fragment == null || fragment.mLoaderManager == null)) {
                    i2 |= fragment.mLoaderManager.hasRunningLoaders();
                }
                i++;
            }
            if (i2 == 0) {
                this.mHavePendingDeferredStart = false;
                startPendingDeferredFragments();
            }
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        Fragment fragment;
        int size2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("    ");
        String stringBuilder2 = stringBuilder.toString();
        int i2 = 0;
        if (this.mActive != null) {
            size = this.mActive.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.mActive.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment);
                    if (fragment != null) {
                        fragment.dump(stringBuilder2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        if (this.mAdded != null) {
            size = this.mAdded.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.mAdded.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.mCreatedMenus != null) {
            size = this.mCreatedMenus.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.mCreatedMenus.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.mBackStack != null) {
            size = this.mBackStack.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    BackStackRecord backStackRecord = (BackStackRecord) this.mBackStack.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(backStackRecord.toString());
                    backStackRecord.dump(stringBuilder2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        synchronized (this) {
            if (this.mBackStackIndices != null) {
                size2 = this.mBackStackIndices.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (int i3 = 0; i3 < size2; i3++) {
                        BackStackRecord backStackRecord2 = (BackStackRecord) this.mBackStackIndices.get(i3);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i3);
                        printWriter.print(": ");
                        printWriter.println(backStackRecord2);
                    }
                }
            }
            if (this.mAvailBackStackIndices != null && this.mAvailBackStackIndices.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.mAvailBackStackIndices.toArray()));
            }
        }
        if (this.mPendingActions != null) {
            size2 = this.mPendingActions.size();
            if (size2 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < size2) {
                    OpGenerator opGenerator = (OpGenerator) this.mPendingActions.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(opGenerator);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.mHost);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.mContainer);
        if (this.mParent != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.mParent);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.mCurState);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.mStateSaved);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.mDestroyed);
        if (this.mNeedMenuInvalidate) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.mNeedMenuInvalidate);
        }
        if (this.mNoTransactionsBecause != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.mNoTransactionsBecause);
        }
        if (this.mAvailIndices != null && this.mAvailIndices.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.mAvailIndices.toArray()));
        }
    }

    public void enqueueAction(OpGenerator opGenerator, boolean z) {
        if (!z) {
            checkStateLoss();
        }
        synchronized (this) {
            if (!this.mDestroyed) {
                if (this.mHost != null) {
                    if (this.mPendingActions == null) {
                        this.mPendingActions = new ArrayList();
                    }
                    this.mPendingActions.add(opGenerator);
                    scheduleCommit();
                }
            }
            throw new IllegalStateException("Activity has been destroyed");
        }
    }

    public boolean execPendingActions() {
        ensureExecReady(true);
        boolean z = false;
        while (generateOpsForPendingActions(this.mTmpRecords, this.mTmpIsPop)) {
            this.mExecutingActions = true;
            try {
                optimizeAndExecuteOps(this.mTmpRecords, this.mTmpIsPop);
                cleanupExec();
                z = true;
            } catch (Throwable th) {
                cleanupExec();
                throw th;
            }
        }
        doPendingDeferredStart();
        return z;
    }

    public void execSingleAction(OpGenerator opGenerator, boolean z) {
        ensureExecReady(z);
        if (opGenerator.generateOps(this.mTmpRecords, this.mTmpIsPop)) {
            this.mExecutingActions = true;
            try {
                optimizeAndExecuteOps(this.mTmpRecords, this.mTmpIsPop);
            } finally {
                cleanupExec();
            }
        }
        doPendingDeferredStart();
    }

    public boolean executePendingTransactions() {
        boolean execPendingActions = execPendingActions();
        forcePostponedTransactions();
        return execPendingActions;
    }

    public Fragment findFragmentById(int i) {
        int size;
        Fragment fragment;
        if (this.mAdded != null) {
            for (size = this.mAdded.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.mAdded.get(size);
                if (fragment != null && fragment.mFragmentId == i) {
                    return fragment;
                }
            }
        }
        if (this.mActive != null) {
            for (size = this.mActive.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.mActive.get(size);
                if (fragment != null && fragment.mFragmentId == i) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public Fragment findFragmentByTag(String str) {
        int size;
        Fragment fragment;
        if (!(this.mAdded == null || str == null)) {
            for (size = this.mAdded.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.mAdded.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (!(this.mActive == null || str == null)) {
            for (size = this.mActive.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.mActive.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public Fragment findFragmentByWho(String str) {
        if (!(this.mActive == null || str == null)) {
            for (int size = this.mActive.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.mActive.get(size);
                if (fragment != null) {
                    fragment = fragment.findFragmentByWho(str);
                    if (fragment != null) {
                        return fragment;
                    }
                }
            }
        }
        return null;
    }

    public void freeBackStackIndex(int i) {
        synchronized (this) {
            this.mBackStackIndices.set(i, null);
            if (this.mAvailBackStackIndices == null) {
                this.mAvailBackStackIndices = new ArrayList();
            }
            if (DEBUG) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Freeing back stack index ");
                stringBuilder.append(i);
                Log.v(str, stringBuilder.toString());
            }
            this.mAvailBackStackIndices.add(Integer.valueOf(i));
        }
    }

    public BackStackEntry getBackStackEntryAt(int i) {
        return (BackStackEntry) this.mBackStack.get(i);
    }

    public int getBackStackEntryCount() {
        return this.mBackStack != null ? this.mBackStack.size() : 0;
    }

    public Fragment getFragment(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.mActive.size()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment no longer exists for key ");
            stringBuilder.append(str);
            stringBuilder.append(": index ");
            stringBuilder.append(i);
            throwException(new IllegalStateException(stringBuilder.toString()));
        }
        Fragment fragment = (Fragment) this.mActive.get(i);
        if (fragment == null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Fragment no longer exists for key ");
            stringBuilder2.append(str);
            stringBuilder2.append(": index ");
            stringBuilder2.append(i);
            throwException(new IllegalStateException(stringBuilder2.toString()));
        }
        return fragment;
    }

    public List<Fragment> getFragments() {
        return this.mActive;
    }

    /* Access modifiers changed, original: 0000 */
    public LayoutInflaterFactory getLayoutInflaterFactory() {
        return this;
    }

    public void hideFragment(Fragment fragment) {
        if (DEBUG) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("hide: ");
            stringBuilder.append(fragment);
            Log.v(str, stringBuilder.toString());
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = 1 ^ fragment.mHiddenChanged;
        }
    }

    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean isStateAtLeast(int i) {
        return this.mCurState >= i;
    }

    /* Access modifiers changed, original: 0000 */
    public Animation loadAnimation(Fragment fragment, int i, boolean z, int i2) {
        Animation onCreateAnimation = fragment.onCreateAnimation(i, z, fragment.getNextAnim());
        if (onCreateAnimation != null) {
            return onCreateAnimation;
        }
        if (fragment.getNextAnim() != 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mHost.getContext(), fragment.getNextAnim());
            if (loadAnimation != null) {
                return loadAnimation;
            }
        }
        if (i == 0) {
            return null;
        }
        i = transitToStyleIndex(i, z);
        if (i < 0) {
            return null;
        }
        switch (i) {
            case 1:
                return makeOpenCloseAnimation(this.mHost.getContext(), 1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return makeOpenCloseAnimation(this.mHost.getContext(), 1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return makeOpenCloseAnimation(this.mHost.getContext(), 0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return makeOpenCloseAnimation(this.mHost.getContext(), 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return makeFadeAnimation(this.mHost.getContext(), 0.0f, 1.0f);
            case 6:
                return makeFadeAnimation(this.mHost.getContext(), 1.0f, 0.0f);
            default:
                if (i2 == 0 && this.mHost.onHasWindowAnimations()) {
                    i2 = this.mHost.onGetWindowAnimations();
                }
                return i2 == 0 ? null : null;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void makeActive(Fragment fragment) {
        if (fragment.mIndex < 0) {
            if (this.mAvailIndices == null || this.mAvailIndices.size() <= 0) {
                if (this.mActive == null) {
                    this.mActive = new ArrayList();
                }
                fragment.setIndex(this.mActive.size(), this.mParent);
                this.mActive.add(fragment);
            } else {
                fragment.setIndex(((Integer) this.mAvailIndices.remove(this.mAvailIndices.size() - 1)).intValue(), this.mParent);
                this.mActive.set(fragment.mIndex, fragment);
            }
            if (DEBUG) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Allocated fragment index ");
                stringBuilder.append(fragment);
                Log.v(str, stringBuilder.toString());
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void makeInactive(Fragment fragment) {
        if (fragment.mIndex >= 0) {
            if (DEBUG) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Freeing fragment index ");
                stringBuilder.append(fragment);
                Log.v(str, stringBuilder.toString());
            }
            this.mActive.set(fragment.mIndex, null);
            if (this.mAvailIndices == null) {
                this.mAvailIndices = new ArrayList();
            }
            this.mAvailIndices.add(Integer.valueOf(fragment.mIndex));
            this.mHost.inactivateFragment(fragment.mWho);
            fragment.initState();
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void moveFragmentToExpectedState(Fragment fragment) {
        if (fragment != null) {
            int i = this.mCurState;
            if (fragment.mRemoving) {
                i = fragment.isInBackStack() ? Math.min(i, 1) : Math.min(i, 0);
            }
            moveToState(fragment, i, fragment.getNextTransition(), fragment.getNextTransitionStyle(), false);
            if (fragment.mView != null) {
                Fragment findFragmentUnder = findFragmentUnder(fragment);
                if (findFragmentUnder != null) {
                    View view = findFragmentUnder.mView;
                    ViewGroup viewGroup = fragment.mContainer;
                    i = viewGroup.indexOfChild(view);
                    int indexOfChild = viewGroup.indexOfChild(fragment.mView);
                    if (indexOfChild < i) {
                        viewGroup.removeViewAt(indexOfChild);
                        viewGroup.addView(fragment.mView, i);
                    }
                }
                if (fragment.mIsNewlyAdded && fragment.mContainer != null) {
                    if (VERSION.SDK_INT < 11) {
                        fragment.mView.setVisibility(0);
                    } else if (fragment.mPostponedAlpha > 0.0f) {
                        fragment.mView.setAlpha(fragment.mPostponedAlpha);
                    }
                    fragment.mPostponedAlpha = 0.0f;
                    fragment.mIsNewlyAdded = false;
                    Animation loadAnimation = loadAnimation(fragment, fragment.getNextTransition(), true, fragment.getNextTransitionStyle());
                    if (loadAnimation != null) {
                        setHWLayerAnimListenerIfAlpha(fragment.mView, loadAnimation);
                        fragment.mView.startAnimation(loadAnimation);
                    }
                }
            }
            if (fragment.mHiddenChanged) {
                completeShowHideFragment(fragment);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void moveToState(int i, boolean z) {
        if (this.mHost == null && i != 0) {
            throw new IllegalStateException("No activity");
        } else if (z || i != this.mCurState) {
            this.mCurState = i;
            if (this.mActive != null) {
                int i2;
                int i3;
                Fragment fragment;
                if (this.mAdded != null) {
                    i = this.mAdded.size();
                    i2 = 0;
                    i3 = i2;
                    while (i2 < i) {
                        fragment = (Fragment) this.mAdded.get(i2);
                        moveFragmentToExpectedState(fragment);
                        if (fragment.mLoaderManager != null) {
                            i3 |= fragment.mLoaderManager.hasRunningLoaders();
                        }
                        i2++;
                    }
                } else {
                    i3 = 0;
                }
                i = this.mActive.size();
                for (i2 = 0; i2 < i; i2++) {
                    fragment = (Fragment) this.mActive.get(i2);
                    if (fragment != null && ((fragment.mRemoving || fragment.mDetached) && !fragment.mIsNewlyAdded)) {
                        moveFragmentToExpectedState(fragment);
                        if (fragment.mLoaderManager != null) {
                            i3 |= fragment.mLoaderManager.hasRunningLoaders();
                        }
                    }
                }
                if (i3 == 0) {
                    startPendingDeferredFragments();
                }
                if (this.mNeedMenuInvalidate && this.mHost != null && this.mCurState == 5) {
                    this.mHost.onSupportInvalidateOptionsMenu();
                    this.mNeedMenuInvalidate = false;
                }
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void moveToState(Fragment fragment) {
        moveToState(fragment, this.mCurState, 0, 0, false);
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x042e  */
    /* JADX WARNING: Missing block: B:74:0x0184, code skipped:
            if (r11 <= 1) goto L_0x0289;
     */
    /* JADX WARNING: Missing block: B:76:0x0188, code skipped:
            if (DEBUG == false) goto L_0x01a0;
     */
    /* JADX WARNING: Missing block: B:77:0x018a, code skipped:
            r0 = TAG;
            r3 = new java.lang.StringBuilder();
            r3.append("moveto ACTIVITY_CREATED: ");
            r3.append(r7);
            android.util.Log.v(r0, r3.toString());
     */
    /* JADX WARNING: Missing block: B:79:0x01a2, code skipped:
            if (r7.mFromLayout != false) goto L_0x0274;
     */
    /* JADX WARNING: Missing block: B:81:0x01a6, code skipped:
            if (r7.mContainerId == 0) goto L_0x0218;
     */
    /* JADX WARNING: Missing block: B:83:0x01ab, code skipped:
            if (r7.mContainerId != -1) goto L_0x01cb;
     */
    /* JADX WARNING: Missing block: B:84:0x01ad, code skipped:
            r3 = new java.lang.StringBuilder();
            r3.append("Cannot create fragment ");
            r3.append(r7);
            r3.append(" for a container view with no id");
            throwException(new java.lang.IllegalArgumentException(r3.toString()));
     */
    /* JADX WARNING: Missing block: B:85:0x01cb, code skipped:
            r0 = (android.view.ViewGroup) r6.mContainer.onFindViewById(r7.mContainerId);
     */
    /* JADX WARNING: Missing block: B:86:0x01d5, code skipped:
            if (r0 != null) goto L_0x0219;
     */
    /* JADX WARNING: Missing block: B:88:0x01d9, code skipped:
            if (r7.mRestored != false) goto L_0x0219;
     */
    /* JADX WARNING: Missing block: B:90:?, code skipped:
            r3 = r17.getResources().getResourceName(r7.mContainerId);
     */
    /* JADX WARNING: Missing block: B:91:0x01e6, code skipped:
            r3 = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
     */
    /* JADX WARNING: Missing block: B:94:0x0218, code skipped:
            r0 = null;
     */
    /* JADX WARNING: Missing block: B:139:0x0305, code skipped:
            if (r11 >= 4) goto L_0x0327;
     */
    /* JADX WARNING: Missing block: B:141:0x0309, code skipped:
            if (DEBUG == false) goto L_0x0321;
     */
    /* JADX WARNING: Missing block: B:142:0x030b, code skipped:
            r0 = TAG;
            r1 = new java.lang.StringBuilder();
            r1.append("movefrom STARTED: ");
            r1.append(r7);
            android.util.Log.v(r0, r1.toString());
     */
    /* JADX WARNING: Missing block: B:143:0x0321, code skipped:
            r17.performStop();
            dispatchOnFragmentStopped(r7, false);
     */
    /* JADX WARNING: Missing block: B:144:0x0327, code skipped:
            if (r11 >= 3) goto L_0x0346;
     */
    /* JADX WARNING: Missing block: B:146:0x032b, code skipped:
            if (DEBUG == false) goto L_0x0343;
     */
    /* JADX WARNING: Missing block: B:147:0x032d, code skipped:
            r0 = TAG;
            r1 = new java.lang.StringBuilder();
            r1.append("movefrom STOPPED: ");
            r1.append(r7);
            android.util.Log.v(r0, r1.toString());
     */
    /* JADX WARNING: Missing block: B:148:0x0343, code skipped:
            r17.performReallyStop();
     */
    /* JADX WARNING: Missing block: B:149:0x0346, code skipped:
            if (r11 >= 2) goto L_0x03cc;
     */
    /* JADX WARNING: Missing block: B:151:0x034a, code skipped:
            if (DEBUG == false) goto L_0x0362;
     */
    /* JADX WARNING: Missing block: B:152:0x034c, code skipped:
            r0 = TAG;
            r1 = new java.lang.StringBuilder();
            r1.append("movefrom ACTIVITY_CREATED: ");
            r1.append(r7);
            android.util.Log.v(r0, r1.toString());
     */
    /* JADX WARNING: Missing block: B:154:0x0364, code skipped:
            if (r7.mView == null) goto L_0x0375;
     */
    /* JADX WARNING: Missing block: B:156:0x036c, code skipped:
            if (r6.mHost.onShouldSaveFragmentState(r7) == false) goto L_0x0375;
     */
    /* JADX WARNING: Missing block: B:158:0x0370, code skipped:
            if (r7.mSavedViewState != null) goto L_0x0375;
     */
    /* JADX WARNING: Missing block: B:159:0x0372, code skipped:
            saveFragmentViewState(r17);
     */
    /* JADX WARNING: Missing block: B:160:0x0375, code skipped:
            r17.performDestroyView();
            dispatchOnFragmentViewDestroyed(r7, false);
     */
    /* JADX WARNING: Missing block: B:161:0x037d, code skipped:
            if (r7.mView == null) goto L_0x03c6;
     */
    /* JADX WARNING: Missing block: B:163:0x0381, code skipped:
            if (r7.mContainer == null) goto L_0x03c6;
     */
    /* JADX WARNING: Missing block: B:165:0x0386, code skipped:
            if (r6.mCurState <= 0) goto L_0x03a3;
     */
    /* JADX WARNING: Missing block: B:167:0x038a, code skipped:
            if (r6.mDestroyed != false) goto L_0x03a3;
     */
    /* JADX WARNING: Missing block: B:169:0x0392, code skipped:
            if (r7.mView.getVisibility() != 0) goto L_0x03a3;
     */
    /* JADX WARNING: Missing block: B:171:0x0398, code skipped:
            if (r7.mPostponedAlpha < 0.0f) goto L_0x03a3;
     */
    /* JADX WARNING: Missing block: B:172:0x039a, code skipped:
            r0 = loadAnimation(r7, r19, false, r20);
     */
    /* JADX WARNING: Missing block: B:173:0x03a3, code skipped:
            r0 = null;
     */
    /* JADX WARNING: Missing block: B:174:0x03a4, code skipped:
            r7.mPostponedAlpha = 0.0f;
     */
    /* JADX WARNING: Missing block: B:175:0x03a6, code skipped:
            if (r0 == null) goto L_0x03bf;
     */
    /* JADX WARNING: Missing block: B:176:0x03a8, code skipped:
            r7.setAnimatingAway(r7.mView);
            r7.setStateAfterAnimating(r11);
            r0.setAnimationListener(new android.support.v4.app.FragmentManagerImpl.AnonymousClass2(r6, r7.mView, r0));
            r7.mView.startAnimation(r0);
     */
    /* JADX WARNING: Missing block: B:177:0x03bf, code skipped:
            r7.mContainer.removeView(r7.mView);
     */
    /* JADX WARNING: Missing block: B:178:0x03c6, code skipped:
            r7.mContainer = null;
            r7.mView = null;
            r7.mInnerView = null;
     */
    /* JADX WARNING: Missing block: B:179:0x03cc, code skipped:
            if (r11 >= 1) goto L_0x0429;
     */
    /* JADX WARNING: Missing block: B:181:0x03d0, code skipped:
            if (r6.mDestroyed == false) goto L_0x03e2;
     */
    /* JADX WARNING: Missing block: B:183:0x03d6, code skipped:
            if (r17.getAnimatingAway() == null) goto L_0x03e2;
     */
    /* JADX WARNING: Missing block: B:184:0x03d8, code skipped:
            r0 = r17.getAnimatingAway();
            r7.setAnimatingAway(null);
            r0.clearAnimation();
     */
    /* JADX WARNING: Missing block: B:186:0x03e6, code skipped:
            if (r17.getAnimatingAway() == null) goto L_0x03ec;
     */
    /* JADX WARNING: Missing block: B:187:0x03e8, code skipped:
            r7.setStateAfterAnimating(r11);
     */
    /* JADX WARNING: Missing block: B:189:0x03ee, code skipped:
            if (DEBUG == false) goto L_0x0406;
     */
    /* JADX WARNING: Missing block: B:190:0x03f0, code skipped:
            r0 = TAG;
            r1 = new java.lang.StringBuilder();
            r1.append("movefrom CREATED: ");
            r1.append(r7);
            android.util.Log.v(r0, r1.toString());
     */
    /* JADX WARNING: Missing block: B:192:0x0408, code skipped:
            if (r7.mRetaining != false) goto L_0x0411;
     */
    /* JADX WARNING: Missing block: B:193:0x040a, code skipped:
            r17.performDestroy();
            dispatchOnFragmentDestroyed(r7, false);
     */
    /* JADX WARNING: Missing block: B:194:0x0411, code skipped:
            r7.mState = 0;
     */
    /* JADX WARNING: Missing block: B:195:0x0413, code skipped:
            r17.performDetach();
            dispatchOnFragmentDetached(r7, false);
     */
    /* JADX WARNING: Missing block: B:196:0x0419, code skipped:
            if (r21 != false) goto L_0x0429;
     */
    /* JADX WARNING: Missing block: B:198:0x041d, code skipped:
            if (r7.mRetaining != false) goto L_0x0423;
     */
    /* JADX WARNING: Missing block: B:199:0x041f, code skipped:
            makeInactive(r17);
     */
    /* JADX WARNING: Missing block: B:200:0x0423, code skipped:
            r7.mHost = null;
            r7.mParentFragment = null;
            r7.mFragmentManager = null;
     */
    public void moveToState(android.support.v4.app.Fragment r17, int r18, int r19, int r20, boolean r21) {
        /*
        r16 = this;
        r6 = r16;
        r7 = r17;
        r0 = r7.mAdded;
        r8 = 1;
        if (r0 == 0) goto L_0x0011;
    L_0x0009:
        r0 = r7.mDetached;
        if (r0 == 0) goto L_0x000e;
    L_0x000d:
        goto L_0x0011;
    L_0x000e:
        r0 = r18;
        goto L_0x0016;
    L_0x0011:
        r0 = r18;
        if (r0 <= r8) goto L_0x0016;
    L_0x0015:
        r0 = r8;
    L_0x0016:
        r1 = r7.mRemoving;
        if (r1 == 0) goto L_0x0020;
    L_0x001a:
        r1 = r7.mState;
        if (r0 <= r1) goto L_0x0020;
    L_0x001e:
        r0 = r7.mState;
    L_0x0020:
        r1 = r7.mDeferStart;
        r9 = 4;
        r10 = 3;
        if (r1 == 0) goto L_0x002e;
    L_0x0026:
        r1 = r7.mState;
        if (r1 >= r9) goto L_0x002e;
    L_0x002a:
        if (r0 <= r10) goto L_0x002e;
    L_0x002c:
        r11 = r10;
        goto L_0x002f;
    L_0x002e:
        r11 = r0;
    L_0x002f:
        r0 = r7.mState;
        r12 = 2;
        r13 = 0;
        r14 = 0;
        if (r0 >= r11) goto L_0x02d7;
    L_0x0036:
        r0 = r7.mFromLayout;
        if (r0 == 0) goto L_0x003f;
    L_0x003a:
        r0 = r7.mInLayout;
        if (r0 != 0) goto L_0x003f;
    L_0x003e:
        return;
    L_0x003f:
        r0 = r17.getAnimatingAway();
        if (r0 == 0) goto L_0x0054;
    L_0x0045:
        r7.setAnimatingAway(r13);
        r2 = r17.getStateAfterAnimating();
        r3 = 0;
        r4 = 0;
        r5 = 1;
        r0 = r6;
        r1 = r7;
        r0.moveToState(r1, r2, r3, r4, r5);
    L_0x0054:
        r0 = r7.mState;
        r1 = 8;
        r2 = 11;
        switch(r0) {
            case 0: goto L_0x005f;
            case 1: goto L_0x0184;
            case 2: goto L_0x0289;
            case 3: goto L_0x028d;
            case 4: goto L_0x02af;
            default: goto L_0x005d;
        };
    L_0x005d:
        goto L_0x0429;
    L_0x005f:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0079;
    L_0x0063:
        r0 = "FragmentManager";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "moveto CREATED: ";
        r3.append(r4);
        r3.append(r7);
        r3 = r3.toString();
        android.util.Log.v(r0, r3);
    L_0x0079:
        r0 = r7.mSavedFragmentState;
        if (r0 == 0) goto L_0x00c1;
    L_0x007d:
        r0 = r7.mSavedFragmentState;
        r3 = r6.mHost;
        r3 = r3.getContext();
        r3 = r3.getClassLoader();
        r0.setClassLoader(r3);
        r0 = r7.mSavedFragmentState;
        r3 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r3);
        r7.mSavedViewState = r0;
        r0 = r7.mSavedFragmentState;
        r3 = "android:target_state";
        r0 = r6.getFragment(r0, r3);
        r7.mTarget = r0;
        r0 = r7.mTarget;
        if (r0 == 0) goto L_0x00ae;
    L_0x00a4:
        r0 = r7.mSavedFragmentState;
        r3 = "android:target_req_state";
        r0 = r0.getInt(r3, r14);
        r7.mTargetRequestCode = r0;
    L_0x00ae:
        r0 = r7.mSavedFragmentState;
        r3 = "android:user_visible_hint";
        r0 = r0.getBoolean(r3, r8);
        r7.mUserVisibleHint = r0;
        r0 = r7.mUserVisibleHint;
        if (r0 != 0) goto L_0x00c1;
    L_0x00bc:
        r7.mDeferStart = r8;
        if (r11 <= r10) goto L_0x00c1;
    L_0x00c0:
        r11 = r10;
    L_0x00c1:
        r0 = r6.mHost;
        r7.mHost = r0;
        r0 = r6.mParent;
        r7.mParentFragment = r0;
        r0 = r6.mParent;
        if (r0 == 0) goto L_0x00d2;
    L_0x00cd:
        r0 = r6.mParent;
        r0 = r0.mChildFragmentManager;
        goto L_0x00d8;
    L_0x00d2:
        r0 = r6.mHost;
        r0 = r0.getFragmentManagerImpl();
    L_0x00d8:
        r7.mFragmentManager = r0;
        r0 = r6.mHost;
        r0 = r0.getContext();
        r6.dispatchOnFragmentPreAttached(r7, r0, r14);
        r7.mCalled = r14;
        r0 = r6.mHost;
        r0 = r0.getContext();
        r7.onAttach(r0);
        r0 = r7.mCalled;
        if (r0 != 0) goto L_0x010e;
    L_0x00f2:
        r0 = new android.support.v4.app.SuperNotCalledException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1.append(r2);
        r1.append(r7);
        r2 = " did not call through to super.onAttach()";
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x010e:
        r0 = r7.mParentFragment;
        if (r0 != 0) goto L_0x0118;
    L_0x0112:
        r0 = r6.mHost;
        r0.onAttachFragment(r7);
        goto L_0x011d;
    L_0x0118:
        r0 = r7.mParentFragment;
        r0.onAttachFragment(r7);
    L_0x011d:
        r0 = r6.mHost;
        r0 = r0.getContext();
        r6.dispatchOnFragmentAttached(r7, r0, r14);
        r0 = r7.mRetaining;
        if (r0 != 0) goto L_0x0135;
    L_0x012a:
        r0 = r7.mSavedFragmentState;
        r7.performCreate(r0);
        r0 = r7.mSavedFragmentState;
        r6.dispatchOnFragmentCreated(r7, r0, r14);
        goto L_0x013c;
    L_0x0135:
        r0 = r7.mSavedFragmentState;
        r7.restoreChildFragmentState(r0);
        r7.mState = r8;
    L_0x013c:
        r7.mRetaining = r14;
        r0 = r7.mFromLayout;
        if (r0 == 0) goto L_0x0184;
    L_0x0142:
        r0 = r7.mSavedFragmentState;
        r0 = r7.getLayoutInflater(r0);
        r3 = r7.mSavedFragmentState;
        r0 = r7.performCreateView(r0, r13, r3);
        r7.mView = r0;
        r0 = r7.mView;
        if (r0 == 0) goto L_0x0182;
    L_0x0154:
        r0 = r7.mView;
        r7.mInnerView = r0;
        r0 = android.os.Build.VERSION.SDK_INT;
        if (r0 < r2) goto L_0x0162;
    L_0x015c:
        r0 = r7.mView;
        android.support.v4.view.ViewCompat.setSaveFromParentEnabled(r0, r14);
        goto L_0x016a;
    L_0x0162:
        r0 = r7.mView;
        r0 = android.support.v4.app.NoSaveStateFrameLayout.wrap(r0);
        r7.mView = r0;
    L_0x016a:
        r0 = r7.mHidden;
        if (r0 == 0) goto L_0x0173;
    L_0x016e:
        r0 = r7.mView;
        r0.setVisibility(r1);
    L_0x0173:
        r0 = r7.mView;
        r3 = r7.mSavedFragmentState;
        r7.onViewCreated(r0, r3);
        r0 = r7.mView;
        r3 = r7.mSavedFragmentState;
        r6.dispatchOnFragmentViewCreated(r7, r0, r3, r14);
        goto L_0x0184;
    L_0x0182:
        r7.mInnerView = r13;
    L_0x0184:
        if (r11 <= r8) goto L_0x0289;
    L_0x0186:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x01a0;
    L_0x018a:
        r0 = "FragmentManager";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "moveto ACTIVITY_CREATED: ";
        r3.append(r4);
        r3.append(r7);
        r3 = r3.toString();
        android.util.Log.v(r0, r3);
    L_0x01a0:
        r0 = r7.mFromLayout;
        if (r0 != 0) goto L_0x0274;
    L_0x01a4:
        r0 = r7.mContainerId;
        if (r0 == 0) goto L_0x0218;
    L_0x01a8:
        r0 = r7.mContainerId;
        r3 = -1;
        if (r0 != r3) goto L_0x01cb;
    L_0x01ad:
        r0 = new java.lang.IllegalArgumentException;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Cannot create fragment ";
        r3.append(r4);
        r3.append(r7);
        r4 = " for a container view with no id";
        r3.append(r4);
        r3 = r3.toString();
        r0.<init>(r3);
        r6.throwException(r0);
    L_0x01cb:
        r0 = r6.mContainer;
        r3 = r7.mContainerId;
        r0 = r0.onFindViewById(r3);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x0219;
    L_0x01d7:
        r3 = r7.mRestored;
        if (r3 != 0) goto L_0x0219;
    L_0x01db:
        r3 = r17.getResources();	 Catch:{ NotFoundException -> 0x01e6 }
        r4 = r7.mContainerId;	 Catch:{ NotFoundException -> 0x01e6 }
        r3 = r3.getResourceName(r4);	 Catch:{ NotFoundException -> 0x01e6 }
        goto L_0x01e8;
    L_0x01e6:
        r3 = "unknown";
    L_0x01e8:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r15 = "No view found for id 0x";
        r5.append(r15);
        r15 = r7.mContainerId;
        r15 = java.lang.Integer.toHexString(r15);
        r5.append(r15);
        r15 = " (";
        r5.append(r15);
        r5.append(r3);
        r3 = ") for fragment ";
        r5.append(r3);
        r5.append(r7);
        r3 = r5.toString();
        r4.<init>(r3);
        r6.throwException(r4);
        goto L_0x0219;
    L_0x0218:
        r0 = r13;
    L_0x0219:
        r7.mContainer = r0;
        r3 = r7.mSavedFragmentState;
        r3 = r7.getLayoutInflater(r3);
        r4 = r7.mSavedFragmentState;
        r3 = r7.performCreateView(r3, r0, r4);
        r7.mView = r3;
        r3 = r7.mView;
        if (r3 == 0) goto L_0x0272;
    L_0x022d:
        r3 = r7.mView;
        r7.mInnerView = r3;
        r3 = android.os.Build.VERSION.SDK_INT;
        if (r3 < r2) goto L_0x023b;
    L_0x0235:
        r2 = r7.mView;
        android.support.v4.view.ViewCompat.setSaveFromParentEnabled(r2, r14);
        goto L_0x0243;
    L_0x023b:
        r2 = r7.mView;
        r2 = android.support.v4.app.NoSaveStateFrameLayout.wrap(r2);
        r7.mView = r2;
    L_0x0243:
        if (r0 == 0) goto L_0x024a;
    L_0x0245:
        r2 = r7.mView;
        r0.addView(r2);
    L_0x024a:
        r0 = r7.mHidden;
        if (r0 == 0) goto L_0x0253;
    L_0x024e:
        r0 = r7.mView;
        r0.setVisibility(r1);
    L_0x0253:
        r0 = r7.mView;
        r1 = r7.mSavedFragmentState;
        r7.onViewCreated(r0, r1);
        r0 = r7.mView;
        r1 = r7.mSavedFragmentState;
        r6.dispatchOnFragmentViewCreated(r7, r0, r1, r14);
        r0 = r7.mView;
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x026e;
    L_0x0269:
        r0 = r7.mContainer;
        if (r0 == 0) goto L_0x026e;
    L_0x026d:
        goto L_0x026f;
    L_0x026e:
        r8 = r14;
    L_0x026f:
        r7.mIsNewlyAdded = r8;
        goto L_0x0274;
    L_0x0272:
        r7.mInnerView = r13;
    L_0x0274:
        r0 = r7.mSavedFragmentState;
        r7.performActivityCreated(r0);
        r0 = r7.mSavedFragmentState;
        r6.dispatchOnFragmentActivityCreated(r7, r0, r14);
        r0 = r7.mView;
        if (r0 == 0) goto L_0x0287;
    L_0x0282:
        r0 = r7.mSavedFragmentState;
        r7.restoreViewState(r0);
    L_0x0287:
        r7.mSavedFragmentState = r13;
    L_0x0289:
        if (r11 <= r12) goto L_0x028d;
    L_0x028b:
        r7.mState = r10;
    L_0x028d:
        if (r11 <= r10) goto L_0x02af;
    L_0x028f:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x02a9;
    L_0x0293:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto STARTED: ";
        r1.append(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02a9:
        r17.performStart();
        r6.dispatchOnFragmentStarted(r7, r14);
    L_0x02af:
        if (r11 <= r9) goto L_0x0429;
    L_0x02b1:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x02cb;
    L_0x02b5:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto RESUMED: ";
        r1.append(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02cb:
        r17.performResume();
        r6.dispatchOnFragmentResumed(r7, r14);
        r7.mSavedFragmentState = r13;
        r7.mSavedViewState = r13;
        goto L_0x0429;
    L_0x02d7:
        r0 = r7.mState;
        if (r0 <= r11) goto L_0x0429;
    L_0x02db:
        r0 = r7.mState;
        switch(r0) {
            case 1: goto L_0x03cc;
            case 2: goto L_0x0346;
            case 3: goto L_0x0327;
            case 4: goto L_0x0305;
            case 5: goto L_0x02e2;
            default: goto L_0x02e0;
        };
    L_0x02e0:
        goto L_0x0429;
    L_0x02e2:
        r0 = 5;
        if (r11 >= r0) goto L_0x0305;
    L_0x02e5:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x02ff;
    L_0x02e9:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom RESUMED: ";
        r1.append(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02ff:
        r17.performPause();
        r6.dispatchOnFragmentPaused(r7, r14);
    L_0x0305:
        if (r11 >= r9) goto L_0x0327;
    L_0x0307:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0321;
    L_0x030b:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STARTED: ";
        r1.append(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0321:
        r17.performStop();
        r6.dispatchOnFragmentStopped(r7, r14);
    L_0x0327:
        if (r11 >= r10) goto L_0x0346;
    L_0x0329:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0343;
    L_0x032d:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STOPPED: ";
        r1.append(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0343:
        r17.performReallyStop();
    L_0x0346:
        if (r11 >= r12) goto L_0x03cc;
    L_0x0348:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0362;
    L_0x034c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom ACTIVITY_CREATED: ";
        r1.append(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0362:
        r0 = r7.mView;
        if (r0 == 0) goto L_0x0375;
    L_0x0366:
        r0 = r6.mHost;
        r0 = r0.onShouldSaveFragmentState(r7);
        if (r0 == 0) goto L_0x0375;
    L_0x036e:
        r0 = r7.mSavedViewState;
        if (r0 != 0) goto L_0x0375;
    L_0x0372:
        r16.saveFragmentViewState(r17);
    L_0x0375:
        r17.performDestroyView();
        r6.dispatchOnFragmentViewDestroyed(r7, r14);
        r0 = r7.mView;
        if (r0 == 0) goto L_0x03c6;
    L_0x037f:
        r0 = r7.mContainer;
        if (r0 == 0) goto L_0x03c6;
    L_0x0383:
        r0 = r6.mCurState;
        r1 = 0;
        if (r0 <= 0) goto L_0x03a3;
    L_0x0388:
        r0 = r6.mDestroyed;
        if (r0 != 0) goto L_0x03a3;
    L_0x038c:
        r0 = r7.mView;
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x03a3;
    L_0x0394:
        r0 = r7.mPostponedAlpha;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 < 0) goto L_0x03a3;
    L_0x039a:
        r0 = r19;
        r2 = r20;
        r0 = r6.loadAnimation(r7, r0, r14, r2);
        goto L_0x03a4;
    L_0x03a3:
        r0 = r13;
    L_0x03a4:
        r7.mPostponedAlpha = r1;
        if (r0 == 0) goto L_0x03bf;
    L_0x03a8:
        r1 = r7.mView;
        r7.setAnimatingAway(r1);
        r7.setStateAfterAnimating(r11);
        r1 = r7.mView;
        r2 = new android.support.v4.app.FragmentManagerImpl$2;
        r2.<init>(r1, r0, r7);
        r0.setAnimationListener(r2);
        r1 = r7.mView;
        r1.startAnimation(r0);
    L_0x03bf:
        r0 = r7.mContainer;
        r1 = r7.mView;
        r0.removeView(r1);
    L_0x03c6:
        r7.mContainer = r13;
        r7.mView = r13;
        r7.mInnerView = r13;
    L_0x03cc:
        if (r11 >= r8) goto L_0x0429;
    L_0x03ce:
        r0 = r6.mDestroyed;
        if (r0 == 0) goto L_0x03e2;
    L_0x03d2:
        r0 = r17.getAnimatingAway();
        if (r0 == 0) goto L_0x03e2;
    L_0x03d8:
        r0 = r17.getAnimatingAway();
        r7.setAnimatingAway(r13);
        r0.clearAnimation();
    L_0x03e2:
        r0 = r17.getAnimatingAway();
        if (r0 == 0) goto L_0x03ec;
    L_0x03e8:
        r7.setStateAfterAnimating(r11);
        goto L_0x042a;
    L_0x03ec:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0406;
    L_0x03f0:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom CREATED: ";
        r1.append(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0406:
        r0 = r7.mRetaining;
        if (r0 != 0) goto L_0x0411;
    L_0x040a:
        r17.performDestroy();
        r6.dispatchOnFragmentDestroyed(r7, r14);
        goto L_0x0413;
    L_0x0411:
        r7.mState = r14;
    L_0x0413:
        r17.performDetach();
        r6.dispatchOnFragmentDetached(r7, r14);
        if (r21 != 0) goto L_0x0429;
    L_0x041b:
        r0 = r7.mRetaining;
        if (r0 != 0) goto L_0x0423;
    L_0x041f:
        r16.makeInactive(r17);
        goto L_0x0429;
    L_0x0423:
        r7.mHost = r13;
        r7.mParentFragment = r13;
        r7.mFragmentManager = r13;
    L_0x0429:
        r8 = r11;
    L_0x042a:
        r0 = r7.mState;
        if (r0 == r8) goto L_0x045d;
    L_0x042e:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveToState: Fragment state for ";
        r1.append(r2);
        r1.append(r7);
        r2 = " not updated inline; ";
        r1.append(r2);
        r2 = "expected state ";
        r1.append(r2);
        r1.append(r8);
        r2 = " found ";
        r1.append(r2);
        r2 = r7.mState;
        r1.append(r2);
        r1 = r1.toString();
        android.util.Log.w(r0, r1);
        r7.mState = r8;
    L_0x045d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentManagerImpl.moveToState(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    public void noteStateNotSaved() {
        this.mStateSaved = false;
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        Fragment fragment = null;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet2.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet2, FragmentTag.Fragment);
        int i = 0;
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        String str2 = attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.isSupportFragmentClass(this.mHost.getContext(), str2)) {
            return null;
        }
        if (view != null) {
            i = view.getId();
        }
        StringBuilder stringBuilder;
        if (i == -1 && resourceId == -1 && string == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(attributeSet.getPositionDescription());
            stringBuilder.append(": Must specify unique android:id, android:tag, or have a parent with an id for ");
            stringBuilder.append(str2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        Fragment fragment2;
        if (resourceId != -1) {
            fragment = findFragmentById(resourceId);
        }
        if (fragment == null && string != null) {
            fragment = findFragmentByTag(string);
        }
        if (fragment == null && i != -1) {
            fragment = findFragmentById(i);
        }
        if (DEBUG) {
            attributeValue = TAG;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("onCreateView: id=0x");
            stringBuilder2.append(Integer.toHexString(resourceId));
            stringBuilder2.append(" fname=");
            stringBuilder2.append(str2);
            stringBuilder2.append(" existing=");
            stringBuilder2.append(fragment);
            Log.v(attributeValue, stringBuilder2.toString());
        }
        if (fragment == null) {
            Fragment instantiate = Fragment.instantiate(context2, str2);
            instantiate.mFromLayout = true;
            instantiate.mFragmentId = resourceId != 0 ? resourceId : i;
            instantiate.mContainerId = i;
            instantiate.mTag = string;
            instantiate.mInLayout = true;
            instantiate.mFragmentManager = this;
            instantiate.mHost = this.mHost;
            instantiate.onInflate(this.mHost.getContext(), attributeSet2, instantiate.mSavedFragmentState);
            addFragment(instantiate, true);
            fragment2 = instantiate;
        } else if (fragment.mInLayout) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(attributeSet.getPositionDescription());
            stringBuilder.append(": Duplicate id 0x");
            stringBuilder.append(Integer.toHexString(resourceId));
            stringBuilder.append(", tag ");
            stringBuilder.append(string);
            stringBuilder.append(", or parent id 0x");
            stringBuilder.append(Integer.toHexString(i));
            stringBuilder.append(" with another fragment for ");
            stringBuilder.append(str2);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else {
            fragment.mInLayout = true;
            fragment.mHost = this.mHost;
            if (!fragment.mRetaining) {
                fragment.onInflate(this.mHost.getContext(), attributeSet2, fragment.mSavedFragmentState);
            }
            fragment2 = fragment;
        }
        if (this.mCurState >= 1 || !fragment2.mFromLayout) {
            moveToState(fragment2);
        } else {
            moveToState(fragment2, 1, 0, 0, false);
        }
        if (fragment2.mView == null) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Fragment ");
            stringBuilder3.append(str2);
            stringBuilder3.append(" did not create a view.");
            throw new IllegalStateException(stringBuilder3.toString());
        }
        if (resourceId != 0) {
            fragment2.mView.setId(resourceId);
        }
        if (fragment2.mView.getTag() == null) {
            fragment2.mView.setTag(string);
        }
        return fragment2.mView;
    }

    public void performPendingDeferredStart(Fragment fragment) {
        if (fragment.mDeferStart) {
            if (this.mExecutingActions) {
                this.mHavePendingDeferredStart = true;
                return;
            }
            fragment.mDeferStart = false;
            moveToState(fragment, this.mCurState, 0, 0, false);
        }
    }

    public void popBackStack() {
        enqueueAction(new PopBackStackState(null, -1, 0), false);
    }

    public void popBackStack(int i, int i2) {
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Bad id: ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        enqueueAction(new PopBackStackState(null, i, i2), false);
    }

    public void popBackStack(String str, int i) {
        enqueueAction(new PopBackStackState(str, -1, i), false);
    }

    public boolean popBackStackImmediate() {
        checkStateLoss();
        return popBackStackImmediate(null, -1, 0);
    }

    public boolean popBackStackImmediate(int i, int i2) {
        checkStateLoss();
        execPendingActions();
        if (i >= 0) {
            return popBackStackImmediate(null, i, i2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bad id: ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public boolean popBackStackImmediate(String str, int i) {
        checkStateLoss();
        return popBackStackImmediate(str, -1, i);
    }

    /* Access modifiers changed, original: 0000 */
    public boolean popBackStackState(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        if (this.mBackStack == null) {
            return false;
        }
        int size;
        if (str == null && i < 0 && (i2 & 1) == 0) {
            size = this.mBackStack.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.mBackStack.remove(size));
            arrayList2.add(Boolean.valueOf(true));
        } else {
            int size2;
            if (str != null || i >= 0) {
                size2 = this.mBackStack.size() - 1;
                while (size2 >= 0) {
                    BackStackRecord backStackRecord = (BackStackRecord) this.mBackStack.get(size2);
                    if ((str != null && str.equals(backStackRecord.getName())) || (i >= 0 && i == backStackRecord.mIndex)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size2--;
                    while (size2 >= 0) {
                        BackStackRecord backStackRecord2 = (BackStackRecord) this.mBackStack.get(size2);
                        if ((str == null || !str.equals(backStackRecord2.getName())) && (i < 0 || i != backStackRecord2.mIndex)) {
                            break;
                        }
                        size2--;
                    }
                }
            } else {
                size2 = -1;
            }
            if (size2 == this.mBackStack.size() - 1) {
                return false;
            }
            for (size = this.mBackStack.size() - 1; size > size2; size--) {
                arrayList.add(this.mBackStack.remove(size));
                arrayList2.add(Boolean.valueOf(true));
            }
        }
        return true;
    }

    public void putFragment(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mIndex < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment ");
            stringBuilder.append(fragment);
            stringBuilder.append(" is not currently in the FragmentManager");
            throwException(new IllegalStateException(stringBuilder.toString()));
        }
        bundle.putInt(str, fragment.mIndex);
    }

    public void registerFragmentLifecycleCallbacks(FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
        if (this.mLifecycleCallbacks == null) {
            this.mLifecycleCallbacks = new CopyOnWriteArrayList();
        }
        this.mLifecycleCallbacks.add(new Pair(fragmentLifecycleCallbacks, Boolean.valueOf(z)));
    }

    public void removeFragment(Fragment fragment) {
        if (DEBUG) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("remove: ");
            stringBuilder.append(fragment);
            stringBuilder.append(" nesting=");
            stringBuilder.append(fragment.mBackStackNesting);
            Log.v(str, stringBuilder.toString());
        }
        int isInBackStack = fragment.isInBackStack() ^ 1;
        if (!fragment.mDetached || isInBackStack != 0) {
            if (this.mAdded != null) {
                this.mAdded.remove(fragment);
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.mNeedMenuInvalidate = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
        }
    }

    public void removeOnBackStackChangedListener(OnBackStackChangedListener onBackStackChangedListener) {
        if (this.mBackStackChangeListeners != null) {
            this.mBackStackChangeListeners.remove(onBackStackChangedListener);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void reportBackStackChanged() {
        if (this.mBackStackChangeListeners != null) {
            for (int i = 0; i < this.mBackStackChangeListeners.size(); i++) {
                ((OnBackStackChangedListener) this.mBackStackChangeListeners.get(i)).onBackStackChanged();
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void restoreAllState(Parcelable parcelable, FragmentManagerNonConfig fragmentManagerNonConfig) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.mActive != null) {
                List childNonConfigs;
                int i;
                if (fragmentManagerNonConfig != null) {
                    List fragments = fragmentManagerNonConfig.getFragments();
                    childNonConfigs = fragmentManagerNonConfig.getChildNonConfigs();
                    int size = fragments != null ? fragments.size() : 0;
                    for (int i2 = 0; i2 < size; i2++) {
                        Fragment fragment = (Fragment) fragments.get(i2);
                        if (DEBUG) {
                            String str = TAG;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("restoreAllState: re-attaching retained ");
                            stringBuilder.append(fragment);
                            Log.v(str, stringBuilder.toString());
                        }
                        FragmentState fragmentState = fragmentManagerState.mActive[fragment.mIndex];
                        fragmentState.mInstance = fragment;
                        fragment.mSavedViewState = null;
                        fragment.mBackStackNesting = 0;
                        fragment.mInLayout = false;
                        fragment.mAdded = false;
                        fragment.mTarget = null;
                        if (fragmentState.mSavedFragmentState != null) {
                            fragmentState.mSavedFragmentState.setClassLoader(this.mHost.getContext().getClassLoader());
                            fragment.mSavedViewState = fragmentState.mSavedFragmentState.getSparseParcelableArray(VIEW_STATE_TAG);
                            fragment.mSavedFragmentState = fragmentState.mSavedFragmentState;
                        }
                    }
                } else {
                    childNonConfigs = null;
                }
                this.mActive = new ArrayList(fragmentManagerState.mActive.length);
                if (this.mAvailIndices != null) {
                    this.mAvailIndices.clear();
                }
                int i3 = 0;
                while (i3 < fragmentManagerState.mActive.length) {
                    FragmentState fragmentState2 = fragmentManagerState.mActive[i3];
                    if (fragmentState2 != null) {
                        FragmentManagerNonConfig fragmentManagerNonConfig2 = (childNonConfigs == null || i3 >= childNonConfigs.size()) ? null : (FragmentManagerNonConfig) childNonConfigs.get(i3);
                        Fragment instantiate = fragmentState2.instantiate(this.mHost, this.mParent, fragmentManagerNonConfig2);
                        if (DEBUG) {
                            String str2 = TAG;
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("restoreAllState: active #");
                            stringBuilder2.append(i3);
                            stringBuilder2.append(": ");
                            stringBuilder2.append(instantiate);
                            Log.v(str2, stringBuilder2.toString());
                        }
                        this.mActive.add(instantiate);
                        fragmentState2.mInstance = null;
                    } else {
                        this.mActive.add(null);
                        if (this.mAvailIndices == null) {
                            this.mAvailIndices = new ArrayList();
                        }
                        if (DEBUG) {
                            String str3 = TAG;
                            StringBuilder stringBuilder3 = new StringBuilder();
                            stringBuilder3.append("restoreAllState: avail #");
                            stringBuilder3.append(i3);
                            Log.v(str3, stringBuilder3.toString());
                        }
                        this.mAvailIndices.add(Integer.valueOf(i3));
                    }
                    i3++;
                }
                if (fragmentManagerNonConfig != null) {
                    List fragments2 = fragmentManagerNonConfig.getFragments();
                    i3 = fragments2 != null ? fragments2.size() : 0;
                    for (int i4 = 0; i4 < i3; i4++) {
                        Fragment fragment2 = (Fragment) fragments2.get(i4);
                        if (fragment2.mTargetIndex >= 0) {
                            if (fragment2.mTargetIndex < this.mActive.size()) {
                                fragment2.mTarget = (Fragment) this.mActive.get(fragment2.mTargetIndex);
                            } else {
                                String str4 = TAG;
                                StringBuilder stringBuilder4 = new StringBuilder();
                                stringBuilder4.append("Re-attaching retained fragment ");
                                stringBuilder4.append(fragment2);
                                stringBuilder4.append(" target no longer exists: ");
                                stringBuilder4.append(fragment2.mTargetIndex);
                                Log.w(str4, stringBuilder4.toString());
                                fragment2.mTarget = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.mAdded != null) {
                    this.mAdded = new ArrayList(fragmentManagerState.mAdded.length);
                    for (i = 0; i < fragmentManagerState.mAdded.length; i++) {
                        StringBuilder stringBuilder5;
                        Fragment fragment3 = (Fragment) this.mActive.get(fragmentManagerState.mAdded[i]);
                        if (fragment3 == null) {
                            stringBuilder5 = new StringBuilder();
                            stringBuilder5.append("No instantiated fragment for index #");
                            stringBuilder5.append(fragmentManagerState.mAdded[i]);
                            throwException(new IllegalStateException(stringBuilder5.toString()));
                        }
                        fragment3.mAdded = true;
                        if (DEBUG) {
                            String str5 = TAG;
                            stringBuilder5 = new StringBuilder();
                            stringBuilder5.append("restoreAllState: added #");
                            stringBuilder5.append(i);
                            stringBuilder5.append(": ");
                            stringBuilder5.append(fragment3);
                            Log.v(str5, stringBuilder5.toString());
                        }
                        if (this.mAdded.contains(fragment3)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.mAdded.add(fragment3);
                    }
                } else {
                    this.mAdded = null;
                }
                if (fragmentManagerState.mBackStack != null) {
                    this.mBackStack = new ArrayList(fragmentManagerState.mBackStack.length);
                    for (i = 0; i < fragmentManagerState.mBackStack.length; i++) {
                        BackStackRecord instantiate2 = fragmentManagerState.mBackStack[i].instantiate(this);
                        if (DEBUG) {
                            String str6 = TAG;
                            StringBuilder stringBuilder6 = new StringBuilder();
                            stringBuilder6.append("restoreAllState: back stack #");
                            stringBuilder6.append(i);
                            stringBuilder6.append(" (index ");
                            stringBuilder6.append(instantiate2.mIndex);
                            stringBuilder6.append("): ");
                            stringBuilder6.append(instantiate2);
                            Log.v(str6, stringBuilder6.toString());
                            PrintWriter printWriter = new PrintWriter(new LogWriter(TAG));
                            instantiate2.dump("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.mBackStack.add(instantiate2);
                        if (instantiate2.mIndex >= 0) {
                            setBackStackIndex(instantiate2.mIndex, instantiate2);
                        }
                    }
                } else {
                    this.mBackStack = null;
                }
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public FragmentManagerNonConfig retainNonConfig() {
        List list;
        List list2;
        if (this.mActive != null) {
            list = null;
            list2 = list;
            for (int i = 0; i < this.mActive.size(); i++) {
                Fragment fragment = (Fragment) this.mActive.get(i);
                if (fragment != null) {
                    boolean z = true;
                    if (fragment.mRetainInstance) {
                        if (list == null) {
                            list = new ArrayList();
                        }
                        list.add(fragment);
                        fragment.mRetaining = true;
                        fragment.mTargetIndex = fragment.mTarget != null ? fragment.mTarget.mIndex : -1;
                        if (DEBUG) {
                            String str = TAG;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("retainNonConfig: keeping retained ");
                            stringBuilder.append(fragment);
                            Log.v(str, stringBuilder.toString());
                        }
                    }
                    if (fragment.mChildFragmentManager != null) {
                        FragmentManagerNonConfig retainNonConfig = fragment.mChildFragmentManager.retainNonConfig();
                        if (retainNonConfig != null) {
                            if (list2 == null) {
                                list2 = new ArrayList();
                                for (int i2 = 0; i2 < i; i2++) {
                                    list2.add(null);
                                }
                            }
                            list2.add(retainNonConfig);
                            if (!(list2 == null || z)) {
                                list2.add(null);
                            }
                        }
                    }
                    z = false;
                    list2.add(null);
                }
            }
        } else {
            list = null;
            list2 = list;
        }
        return (list == null && list2 == null) ? null : new FragmentManagerNonConfig(list, list2);
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0176  */
    public android.os.Parcelable saveAllState() {
        /*
        r11 = this;
        r11.forcePostponedTransactions();
        r11.endAnimatingAwayFragments();
        r11.execPendingActions();
        r0 = HONEYCOMB;
        r1 = 1;
        if (r0 == 0) goto L_0x0010;
    L_0x000e:
        r11.mStateSaved = r1;
    L_0x0010:
        r0 = r11.mActive;
        r2 = 0;
        if (r0 == 0) goto L_0x01c8;
    L_0x0015:
        r0 = r11.mActive;
        r0 = r0.size();
        if (r0 > 0) goto L_0x001f;
    L_0x001d:
        goto L_0x01c8;
    L_0x001f:
        r0 = r11.mActive;
        r0 = r0.size();
        r3 = new android.support.v4.app.FragmentState[r0];
        r4 = 0;
        r5 = r4;
        r6 = r5;
    L_0x002a:
        if (r5 >= r0) goto L_0x00ee;
    L_0x002c:
        r7 = r11.mActive;
        r7 = r7.get(r5);
        r7 = (android.support.v4.app.Fragment) r7;
        if (r7 == 0) goto L_0x00ea;
    L_0x0036:
        r6 = r7.mIndex;
        if (r6 >= 0) goto L_0x005d;
    L_0x003a:
        r6 = new java.lang.IllegalStateException;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "Failure saving state: active ";
        r8.append(r9);
        r8.append(r7);
        r9 = " has cleared index: ";
        r8.append(r9);
        r9 = r7.mIndex;
        r8.append(r9);
        r8 = r8.toString();
        r6.<init>(r8);
        r11.throwException(r6);
    L_0x005d:
        r6 = new android.support.v4.app.FragmentState;
        r6.<init>(r7);
        r3[r5] = r6;
        r8 = r7.mState;
        if (r8 <= 0) goto L_0x00c1;
    L_0x0068:
        r8 = r6.mSavedFragmentState;
        if (r8 != 0) goto L_0x00c1;
    L_0x006c:
        r8 = r11.saveFragmentBasicState(r7);
        r6.mSavedFragmentState = r8;
        r8 = r7.mTarget;
        if (r8 == 0) goto L_0x00c5;
    L_0x0076:
        r8 = r7.mTarget;
        r8 = r8.mIndex;
        if (r8 >= 0) goto L_0x009f;
    L_0x007c:
        r8 = new java.lang.IllegalStateException;
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r10 = "Failure saving state: ";
        r9.append(r10);
        r9.append(r7);
        r10 = " has target not in fragment manager: ";
        r9.append(r10);
        r10 = r7.mTarget;
        r9.append(r10);
        r9 = r9.toString();
        r8.<init>(r9);
        r11.throwException(r8);
    L_0x009f:
        r8 = r6.mSavedFragmentState;
        if (r8 != 0) goto L_0x00aa;
    L_0x00a3:
        r8 = new android.os.Bundle;
        r8.<init>();
        r6.mSavedFragmentState = r8;
    L_0x00aa:
        r8 = r6.mSavedFragmentState;
        r9 = "android:target_state";
        r10 = r7.mTarget;
        r11.putFragment(r8, r9, r10);
        r8 = r7.mTargetRequestCode;
        if (r8 == 0) goto L_0x00c5;
    L_0x00b7:
        r8 = r6.mSavedFragmentState;
        r9 = "android:target_req_state";
        r10 = r7.mTargetRequestCode;
        r8.putInt(r9, r10);
        goto L_0x00c5;
    L_0x00c1:
        r8 = r7.mSavedFragmentState;
        r6.mSavedFragmentState = r8;
    L_0x00c5:
        r8 = DEBUG;
        if (r8 == 0) goto L_0x00e9;
    L_0x00c9:
        r8 = "FragmentManager";
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r10 = "Saved state of ";
        r9.append(r10);
        r9.append(r7);
        r7 = ": ";
        r9.append(r7);
        r6 = r6.mSavedFragmentState;
        r9.append(r6);
        r6 = r9.toString();
        android.util.Log.v(r8, r6);
    L_0x00e9:
        r6 = r1;
    L_0x00ea:
        r5 = r5 + 1;
        goto L_0x002a;
    L_0x00ee:
        if (r6 != 0) goto L_0x00fc;
    L_0x00f0:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x00fb;
    L_0x00f4:
        r0 = "FragmentManager";
        r1 = "saveAllState: no fragments!";
        android.util.Log.v(r0, r1);
    L_0x00fb:
        return r2;
    L_0x00fc:
        r0 = r11.mAdded;
        if (r0 == 0) goto L_0x0171;
    L_0x0100:
        r0 = r11.mAdded;
        r0 = r0.size();
        if (r0 <= 0) goto L_0x0171;
    L_0x0108:
        r1 = new int[r0];
        r5 = r4;
    L_0x010b:
        if (r5 >= r0) goto L_0x0172;
    L_0x010d:
        r6 = r11.mAdded;
        r6 = r6.get(r5);
        r6 = (android.support.v4.app.Fragment) r6;
        r6 = r6.mIndex;
        r1[r5] = r6;
        r6 = r1[r5];
        if (r6 >= 0) goto L_0x0146;
    L_0x011d:
        r6 = new java.lang.IllegalStateException;
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = "Failure saving state: active ";
        r7.append(r8);
        r8 = r11.mAdded;
        r8 = r8.get(r5);
        r7.append(r8);
        r8 = " has cleared index: ";
        r7.append(r8);
        r8 = r1[r5];
        r7.append(r8);
        r7 = r7.toString();
        r6.<init>(r7);
        r11.throwException(r6);
    L_0x0146:
        r6 = DEBUG;
        if (r6 == 0) goto L_0x016e;
    L_0x014a:
        r6 = "FragmentManager";
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = "saveAllState: adding fragment #";
        r7.append(r8);
        r7.append(r5);
        r8 = ": ";
        r7.append(r8);
        r8 = r11.mAdded;
        r8 = r8.get(r5);
        r7.append(r8);
        r7 = r7.toString();
        android.util.Log.v(r6, r7);
    L_0x016e:
        r5 = r5 + 1;
        goto L_0x010b;
    L_0x0171:
        r1 = r2;
    L_0x0172:
        r0 = r11.mBackStack;
        if (r0 == 0) goto L_0x01bc;
    L_0x0176:
        r0 = r11.mBackStack;
        r0 = r0.size();
        if (r0 <= 0) goto L_0x01bc;
    L_0x017e:
        r2 = new android.support.v4.app.BackStackState[r0];
    L_0x0180:
        if (r4 >= r0) goto L_0x01bc;
    L_0x0182:
        r5 = new android.support.v4.app.BackStackState;
        r6 = r11.mBackStack;
        r6 = r6.get(r4);
        r6 = (android.support.v4.app.BackStackRecord) r6;
        r5.<init>(r6);
        r2[r4] = r5;
        r5 = DEBUG;
        if (r5 == 0) goto L_0x01b9;
    L_0x0195:
        r5 = "FragmentManager";
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "saveAllState: adding back stack #";
        r6.append(r7);
        r6.append(r4);
        r7 = ": ";
        r6.append(r7);
        r7 = r11.mBackStack;
        r7 = r7.get(r4);
        r6.append(r7);
        r6 = r6.toString();
        android.util.Log.v(r5, r6);
    L_0x01b9:
        r4 = r4 + 1;
        goto L_0x0180;
    L_0x01bc:
        r0 = new android.support.v4.app.FragmentManagerState;
        r0.<init>();
        r0.mActive = r3;
        r0.mAdded = r1;
        r0.mBackStack = r2;
        return r0;
    L_0x01c8:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentManagerImpl.saveAllState():android.os.Parcelable");
    }

    /* Access modifiers changed, original: 0000 */
    public Bundle saveFragmentBasicState(Fragment fragment) {
        Bundle bundle;
        if (this.mStateBundle == null) {
            this.mStateBundle = new Bundle();
        }
        fragment.performSaveInstanceState(this.mStateBundle);
        dispatchOnFragmentSaveInstanceState(fragment, this.mStateBundle, false);
        if (this.mStateBundle.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.mStateBundle;
            this.mStateBundle = null;
        }
        if (fragment.mView != null) {
            saveFragmentViewState(fragment);
        }
        if (fragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray(VIEW_STATE_TAG, fragment.mSavedViewState);
        }
        if (!fragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean(USER_VISIBLE_HINT_TAG, fragment.mUserVisibleHint);
        }
        return bundle;
    }

    public SavedState saveFragmentInstanceState(Fragment fragment) {
        if (fragment.mIndex < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment ");
            stringBuilder.append(fragment);
            stringBuilder.append(" is not currently in the FragmentManager");
            throwException(new IllegalStateException(stringBuilder.toString()));
        }
        SavedState savedState = null;
        if (fragment.mState <= 0) {
            return null;
        }
        Bundle saveFragmentBasicState = saveFragmentBasicState(fragment);
        if (saveFragmentBasicState != null) {
            savedState = new SavedState(saveFragmentBasicState);
        }
        return savedState;
    }

    /* Access modifiers changed, original: 0000 */
    public void saveFragmentViewState(Fragment fragment) {
        if (fragment.mInnerView != null) {
            if (this.mStateArray == null) {
                this.mStateArray = new SparseArray();
            } else {
                this.mStateArray.clear();
            }
            fragment.mInnerView.saveHierarchyState(this.mStateArray);
            if (this.mStateArray.size() > 0) {
                fragment.mSavedViewState = this.mStateArray;
                this.mStateArray = null;
            }
        }
    }

    public void setBackStackIndex(int i, BackStackRecord backStackRecord) {
        synchronized (this) {
            if (this.mBackStackIndices == null) {
                this.mBackStackIndices = new ArrayList();
            }
            int size = this.mBackStackIndices.size();
            String str;
            StringBuilder stringBuilder;
            if (i < size) {
                if (DEBUG) {
                    str = TAG;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Setting back stack index ");
                    stringBuilder.append(i);
                    stringBuilder.append(" to ");
                    stringBuilder.append(backStackRecord);
                    Log.v(str, stringBuilder.toString());
                }
                this.mBackStackIndices.set(i, backStackRecord);
            } else {
                while (size < i) {
                    this.mBackStackIndices.add(null);
                    if (this.mAvailBackStackIndices == null) {
                        this.mAvailBackStackIndices = new ArrayList();
                    }
                    if (DEBUG) {
                        String str2 = TAG;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Adding available back stack index ");
                        stringBuilder2.append(size);
                        Log.v(str2, stringBuilder2.toString());
                    }
                    this.mAvailBackStackIndices.add(Integer.valueOf(size));
                    size++;
                }
                if (DEBUG) {
                    str = TAG;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Adding back stack index ");
                    stringBuilder.append(i);
                    stringBuilder.append(" with ");
                    stringBuilder.append(backStackRecord);
                    Log.v(str, stringBuilder.toString());
                }
                this.mBackStackIndices.add(backStackRecord);
            }
        }
    }

    public void showFragment(Fragment fragment) {
        if (DEBUG) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("show: ");
            stringBuilder.append(fragment);
            Log.v(str, stringBuilder.toString());
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged ^= 1;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void startPendingDeferredFragments() {
        if (this.mActive != null) {
            for (int i = 0; i < this.mActive.size(); i++) {
                Fragment fragment = (Fragment) this.mActive.get(i);
                if (fragment != null) {
                    performPendingDeferredStart(fragment);
                }
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.mParent != null) {
            DebugUtils.buildShortClassTag(this.mParent, stringBuilder);
        } else {
            DebugUtils.buildShortClassTag(this.mHost, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void unregisterFragmentLifecycleCallbacks(FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        if (this.mLifecycleCallbacks != null) {
            synchronized (this.mLifecycleCallbacks) {
                int size = this.mLifecycleCallbacks.size();
                for (int i = 0; i < size; i++) {
                    if (((Pair) this.mLifecycleCallbacks.get(i)).first == fragmentLifecycleCallbacks) {
                        this.mLifecycleCallbacks.remove(i);
                        break;
                    }
                }
            }
        }
    }
}
