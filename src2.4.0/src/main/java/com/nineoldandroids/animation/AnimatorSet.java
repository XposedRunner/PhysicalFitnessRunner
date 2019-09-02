package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class AnimatorSet extends Animator {
    private ValueAnimator mDelayAnim = null;
    private long mDuration = -1;
    private boolean mNeedsSort = true;
    private HashMap<Animator, Node> mNodeMap = new HashMap();
    private ArrayList<Node> mNodes = new ArrayList();
    private ArrayList<Animator> mPlayingSet = new ArrayList();
    private AnimatorSetListener mSetListener = null;
    private ArrayList<Node> mSortedNodes = new ArrayList();
    private long mStartDelay = 0;
    private boolean mStarted = false;
    boolean mTerminated = false;

    private class AnimatorSetListener implements AnimatorListener {
        private AnimatorSet mAnimatorSet;

        AnimatorSetListener(AnimatorSet animatorSet) {
            this.mAnimatorSet = animatorSet;
        }

        public void onAnimationCancel(Animator animator) {
            if (!AnimatorSet.this.mTerminated && AnimatorSet.this.mPlayingSet.size() == 0 && AnimatorSet.this.mListeners != null) {
                int size = AnimatorSet.this.mListeners.size();
                for (int i = 0; i < size; i++) {
                    ((AnimatorListener) AnimatorSet.this.mListeners.get(i)).onAnimationCancel(this.mAnimatorSet);
                }
            }
        }

        public void onAnimationEnd(Animator animator) {
            animator.removeListener(this);
            AnimatorSet.this.mPlayingSet.remove(animator);
            boolean z = true;
            ((Node) this.mAnimatorSet.mNodeMap.get(animator)).done = true;
            if (!AnimatorSet.this.mTerminated) {
                ArrayList access$200 = this.mAnimatorSet.mSortedNodes;
                int size = access$200.size();
                for (int i = 0; i < size; i++) {
                    if (!((Node) access$200.get(i)).done) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    if (AnimatorSet.this.mListeners != null) {
                        access$200 = (ArrayList) AnimatorSet.this.mListeners.clone();
                        int size2 = access$200.size();
                        for (size = 0; size < size2; size++) {
                            ((AnimatorListener) access$200.get(size)).onAnimationEnd(this.mAnimatorSet);
                        }
                    }
                    this.mAnimatorSet.mStarted = false;
                }
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public class Builder {
        private Node mCurrentNode;

        Builder(Animator animator) {
            this.mCurrentNode = (Node) AnimatorSet.this.mNodeMap.get(animator);
            if (this.mCurrentNode == null) {
                this.mCurrentNode = new Node(animator);
                AnimatorSet.this.mNodeMap.put(animator, this.mCurrentNode);
                AnimatorSet.this.mNodes.add(this.mCurrentNode);
            }
        }

        public Builder after(long j) {
            Animator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(j);
            after(ofFloat);
            return this;
        }

        public Builder after(Animator animator) {
            Node node = (Node) AnimatorSet.this.mNodeMap.get(animator);
            if (node == null) {
                node = new Node(animator);
                AnimatorSet.this.mNodeMap.put(animator, node);
                AnimatorSet.this.mNodes.add(node);
            }
            this.mCurrentNode.addDependency(new Dependency(node, 1));
            return this;
        }

        public Builder before(Animator animator) {
            Node node = (Node) AnimatorSet.this.mNodeMap.get(animator);
            if (node == null) {
                node = new Node(animator);
                AnimatorSet.this.mNodeMap.put(animator, node);
                AnimatorSet.this.mNodes.add(node);
            }
            node.addDependency(new Dependency(this.mCurrentNode, 1));
            return this;
        }

        public Builder with(Animator animator) {
            Node node = (Node) AnimatorSet.this.mNodeMap.get(animator);
            if (node == null) {
                node = new Node(animator);
                AnimatorSet.this.mNodeMap.put(animator, node);
                AnimatorSet.this.mNodes.add(node);
            }
            node.addDependency(new Dependency(this.mCurrentNode, 0));
            return this;
        }
    }

    private static class Dependency {
        static final int AFTER = 1;
        static final int WITH = 0;
        public Node node;
        public int rule;

        public Dependency(Node node, int i) {
            this.node = node;
            this.rule = i;
        }
    }

    private static class DependencyListener implements AnimatorListener {
        private AnimatorSet mAnimatorSet;
        private Node mNode;
        private int mRule;

        public DependencyListener(AnimatorSet animatorSet, Node node, int i) {
            this.mAnimatorSet = animatorSet;
            this.mNode = node;
            this.mRule = i;
        }

        private void startIfReady(Animator animator) {
            if (!this.mAnimatorSet.mTerminated) {
                Object obj = null;
                int size = this.mNode.tmpDependencies.size();
                for (int i = 0; i < size; i++) {
                    Dependency dependency = (Dependency) this.mNode.tmpDependencies.get(i);
                    if (dependency.rule == this.mRule && dependency.node.animation == animator) {
                        animator.removeListener(this);
                        obj = dependency;
                        break;
                    }
                }
                this.mNode.tmpDependencies.remove(obj);
                if (this.mNode.tmpDependencies.size() == 0) {
                    this.mNode.animation.start();
                    this.mAnimatorSet.mPlayingSet.add(this.mNode.animation);
                }
            }
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            if (this.mRule == 1) {
                startIfReady(animator);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
            if (this.mRule == 0) {
                startIfReady(animator);
            }
        }
    }

    private static class Node implements Cloneable {
        public Animator animation;
        public ArrayList<Dependency> dependencies = null;
        public boolean done = false;
        public ArrayList<Node> nodeDependencies = null;
        public ArrayList<Node> nodeDependents = null;
        public ArrayList<Dependency> tmpDependencies = null;

        public Node(Animator animator) {
            this.animation = animator;
        }

        public void addDependency(Dependency dependency) {
            if (this.dependencies == null) {
                this.dependencies = new ArrayList();
                this.nodeDependencies = new ArrayList();
            }
            this.dependencies.add(dependency);
            if (!this.nodeDependencies.contains(dependency.node)) {
                this.nodeDependencies.add(dependency.node);
            }
            Node node = dependency.node;
            if (node.nodeDependents == null) {
                node.nodeDependents = new ArrayList();
            }
            node.nodeDependents.add(this);
        }

        public Node clone() {
            try {
                Node node = (Node) super.clone();
                node.animation = this.animation.clone();
                return node;
            } catch (CloneNotSupportedException unused) {
                throw new AssertionError();
            }
        }
    }

    private void sortNodes() {
        int size;
        int i;
        if (this.mNeedsSort) {
            int i2;
            this.mSortedNodes.clear();
            ArrayList arrayList = new ArrayList();
            size = this.mNodes.size();
            for (i2 = 0; i2 < size; i2++) {
                Node node = (Node) this.mNodes.get(i2);
                if (node.dependencies == null || node.dependencies.size() == 0) {
                    arrayList.add(node);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            while (arrayList.size() > 0) {
                i2 = arrayList.size();
                for (i = 0; i < i2; i++) {
                    Node node2 = (Node) arrayList.get(i);
                    this.mSortedNodes.add(node2);
                    if (node2.nodeDependents != null) {
                        int size2 = node2.nodeDependents.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            Node node3 = (Node) node2.nodeDependents.get(i3);
                            node3.nodeDependencies.remove(node2);
                            if (node3.nodeDependencies.size() == 0) {
                                arrayList2.add(node3);
                            }
                        }
                    }
                }
                arrayList.clear();
                arrayList.addAll(arrayList2);
                arrayList2.clear();
            }
            this.mNeedsSort = false;
            if (this.mSortedNodes.size() != this.mNodes.size()) {
                throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
            }
            return;
        }
        int size3 = this.mNodes.size();
        for (size = 0; size < size3; size++) {
            Node node4 = (Node) this.mNodes.get(size);
            if (node4.dependencies != null && node4.dependencies.size() > 0) {
                i = node4.dependencies.size();
                for (int i4 = 0; i4 < i; i4++) {
                    Dependency dependency = (Dependency) node4.dependencies.get(i4);
                    if (node4.nodeDependencies == null) {
                        node4.nodeDependencies = new ArrayList();
                    }
                    if (!node4.nodeDependencies.contains(dependency.node)) {
                        node4.nodeDependencies.add(dependency.node);
                    }
                }
            }
            node4.done = false;
        }
    }

    public void cancel() {
        this.mTerminated = true;
        if (isStarted()) {
            Iterator it;
            ArrayList arrayList = null;
            if (this.mListeners != null) {
                arrayList = (ArrayList) this.mListeners.clone();
                it = arrayList.iterator();
                while (it.hasNext()) {
                    ((AnimatorListener) it.next()).onAnimationCancel(this);
                }
            }
            if (this.mDelayAnim != null && this.mDelayAnim.isRunning()) {
                this.mDelayAnim.cancel();
            } else if (this.mSortedNodes.size() > 0) {
                it = this.mSortedNodes.iterator();
                while (it.hasNext()) {
                    ((Node) it.next()).animation.cancel();
                }
            }
            if (arrayList != null) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((AnimatorListener) it2.next()).onAnimationEnd(this);
                }
            }
            this.mStarted = false;
        }
    }

    public AnimatorSet clone() {
        Node node;
        Node clone;
        Iterator it;
        AnimatorSet animatorSet = (AnimatorSet) super.clone();
        animatorSet.mNeedsSort = true;
        animatorSet.mTerminated = false;
        animatorSet.mStarted = false;
        animatorSet.mPlayingSet = new ArrayList();
        animatorSet.mNodeMap = new HashMap();
        animatorSet.mNodes = new ArrayList();
        animatorSet.mSortedNodes = new ArrayList();
        HashMap hashMap = new HashMap();
        Iterator it2 = this.mNodes.iterator();
        while (it2.hasNext()) {
            node = (Node) it2.next();
            clone = node.clone();
            hashMap.put(node, clone);
            animatorSet.mNodes.add(clone);
            animatorSet.mNodeMap.put(clone.animation, clone);
            ArrayList arrayList = null;
            clone.dependencies = null;
            clone.tmpDependencies = null;
            clone.nodeDependents = null;
            clone.nodeDependencies = null;
            ArrayList listeners = clone.animation.getListeners();
            if (listeners != null) {
                Iterator it3 = listeners.iterator();
                while (it3.hasNext()) {
                    AnimatorListener animatorListener = (AnimatorListener) it3.next();
                    if (animatorListener instanceof AnimatorSetListener) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(animatorListener);
                    }
                }
                if (arrayList != null) {
                    it = arrayList.iterator();
                    while (it.hasNext()) {
                        listeners.remove((AnimatorListener) it.next());
                    }
                }
            }
        }
        it2 = this.mNodes.iterator();
        while (it2.hasNext()) {
            node = (Node) it2.next();
            clone = (Node) hashMap.get(node);
            if (node.dependencies != null) {
                it = node.dependencies.iterator();
                while (it.hasNext()) {
                    Dependency dependency = (Dependency) it.next();
                    clone.addDependency(new Dependency((Node) hashMap.get(dependency.node), dependency.rule));
                }
            }
        }
        return animatorSet;
    }

    public void end() {
        this.mTerminated = true;
        if (isStarted()) {
            Iterator it;
            if (this.mSortedNodes.size() != this.mNodes.size()) {
                sortNodes();
                it = this.mSortedNodes.iterator();
                while (it.hasNext()) {
                    Node node = (Node) it.next();
                    if (this.mSetListener == null) {
                        this.mSetListener = new AnimatorSetListener(this);
                    }
                    node.animation.addListener(this.mSetListener);
                }
            }
            if (this.mDelayAnim != null) {
                this.mDelayAnim.cancel();
            }
            if (this.mSortedNodes.size() > 0) {
                it = this.mSortedNodes.iterator();
                while (it.hasNext()) {
                    ((Node) it.next()).animation.end();
                }
            }
            if (this.mListeners != null) {
                it = ((ArrayList) this.mListeners.clone()).iterator();
                while (it.hasNext()) {
                    ((AnimatorListener) it.next()).onAnimationEnd(this);
                }
            }
            this.mStarted = false;
        }
    }

    public ArrayList<Animator> getChildAnimations() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.mNodes.iterator();
        while (it.hasNext()) {
            arrayList.add(((Node) it.next()).animation);
        }
        return arrayList;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public boolean isRunning() {
        Iterator it = this.mNodes.iterator();
        while (it.hasNext()) {
            if (((Node) it.next()).animation.isRunning()) {
                return true;
            }
        }
        return false;
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    public Builder play(Animator animator) {
        if (animator == null) {
            return null;
        }
        this.mNeedsSort = true;
        return new Builder(animator);
    }

    public void playSequentially(List<Animator> list) {
        if (list != null && list.size() > 0) {
            this.mNeedsSort = true;
            int i = 0;
            if (list.size() == 1) {
                play((Animator) list.get(0));
                return;
            }
            while (i < list.size() - 1) {
                i++;
                play((Animator) list.get(i)).before((Animator) list.get(i));
            }
        }
    }

    public void playSequentially(Animator... animatorArr) {
        if (animatorArr != null) {
            this.mNeedsSort = true;
            int i = 0;
            if (animatorArr.length == 1) {
                play(animatorArr[0]);
                return;
            }
            while (i < animatorArr.length - 1) {
                i++;
                play(animatorArr[i]).before(animatorArr[i]);
            }
        }
    }

    public void playTogether(Collection<Animator> collection) {
        if (collection != null && collection.size() > 0) {
            this.mNeedsSort = true;
            Builder builder = null;
            for (Animator animator : collection) {
                if (builder == null) {
                    builder = play(animator);
                } else {
                    builder.with(animator);
                }
            }
        }
    }

    public void playTogether(Animator... animatorArr) {
        if (animatorArr != null) {
            int i = 1;
            this.mNeedsSort = true;
            Builder play = play(animatorArr[0]);
            while (i < animatorArr.length) {
                play.with(animatorArr[i]);
                i++;
            }
        }
    }

    public AnimatorSet setDuration(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("duration must be a value of zero or greater");
        }
        Iterator it = this.mNodes.iterator();
        while (it.hasNext()) {
            ((Node) it.next()).animation.setDuration(j);
        }
        this.mDuration = j;
        return this;
    }

    public void setInterpolator(Interpolator interpolator) {
        Iterator it = this.mNodes.iterator();
        while (it.hasNext()) {
            ((Node) it.next()).animation.setInterpolator(interpolator);
        }
    }

    public void setStartDelay(long j) {
        this.mStartDelay = j;
    }

    public void setTarget(Object obj) {
        Iterator it = this.mNodes.iterator();
        while (it.hasNext()) {
            Animator animator = ((Node) it.next()).animation;
            if (animator instanceof AnimatorSet) {
                ((AnimatorSet) animator).setTarget(obj);
            } else if (animator instanceof ObjectAnimator) {
                ((ObjectAnimator) animator).setTarget(obj);
            }
        }
    }

    public void setupEndValues() {
        Iterator it = this.mNodes.iterator();
        while (it.hasNext()) {
            ((Node) it.next()).animation.setupEndValues();
        }
    }

    public void setupStartValues() {
        Iterator it = this.mNodes.iterator();
        while (it.hasNext()) {
            ((Node) it.next()).animation.setupStartValues();
        }
    }

    public void start() {
        int i;
        int i2;
        ArrayList arrayList;
        int i3 = 0;
        this.mTerminated = false;
        this.mStarted = true;
        sortNodes();
        int size = this.mSortedNodes.size();
        for (i = 0; i < size; i++) {
            Node node = (Node) this.mSortedNodes.get(i);
            ArrayList listeners = node.animation.getListeners();
            if (listeners != null && listeners.size() > 0) {
                Iterator it = new ArrayList(listeners).iterator();
                while (it.hasNext()) {
                    AnimatorListener animatorListener = (AnimatorListener) it.next();
                    if ((animatorListener instanceof DependencyListener) || (animatorListener instanceof AnimatorSetListener)) {
                        node.animation.removeListener(animatorListener);
                    }
                }
            }
        }
        final ArrayList arrayList2 = new ArrayList();
        for (i2 = 0; i2 < size; i2++) {
            Node node2 = (Node) this.mSortedNodes.get(i2);
            if (this.mSetListener == null) {
                this.mSetListener = new AnimatorSetListener(this);
            }
            if (node2.dependencies == null || node2.dependencies.size() == 0) {
                arrayList2.add(node2);
            } else {
                int size2 = node2.dependencies.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    Dependency dependency = (Dependency) node2.dependencies.get(i4);
                    dependency.node.animation.addListener(new DependencyListener(this, node2, dependency.rule));
                }
                node2.tmpDependencies = (ArrayList) node2.dependencies.clone();
            }
            node2.animation.addListener(this.mSetListener);
        }
        if (this.mStartDelay <= 0) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                Node node3 = (Node) it2.next();
                node3.animation.start();
                this.mPlayingSet.add(node3.animation);
            }
        } else {
            this.mDelayAnim = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mDelayAnim.setDuration(this.mStartDelay);
            this.mDelayAnim.addListener(new AnimatorListenerAdapter() {
                boolean canceled = false;

                public void onAnimationCancel(Animator animator) {
                    this.canceled = true;
                }

                public void onAnimationEnd(Animator animator) {
                    if (!this.canceled) {
                        int size = arrayList2.size();
                        for (int i = 0; i < size; i++) {
                            Node node = (Node) arrayList2.get(i);
                            node.animation.start();
                            AnimatorSet.this.mPlayingSet.add(node.animation);
                        }
                    }
                }
            });
            this.mDelayAnim.start();
        }
        if (this.mListeners != null) {
            arrayList = (ArrayList) this.mListeners.clone();
            i = arrayList.size();
            for (i2 = 0; i2 < i; i2++) {
                ((AnimatorListener) arrayList.get(i2)).onAnimationStart(this);
            }
        }
        if (this.mNodes.size() == 0 && this.mStartDelay == 0) {
            this.mStarted = false;
            if (this.mListeners != null) {
                arrayList = (ArrayList) this.mListeners.clone();
                i = arrayList.size();
                while (i3 < i) {
                    ((AnimatorListener) arrayList.get(i3)).onAnimationEnd(this);
                    i3++;
                }
            }
        }
    }
}
