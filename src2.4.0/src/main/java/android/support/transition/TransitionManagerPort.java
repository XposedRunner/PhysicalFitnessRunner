package android.support.transition;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.transition.TransitionPort.TransitionListenerAdapter;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@TargetApi(14)
@RequiresApi(14)
class TransitionManagerPort {
    private static final String[] EMPTY_STRINGS = new String[0];
    private static String LOG_TAG = "TransitionManager";
    private static TransitionPort sDefaultTransition = new AutoTransitionPort();
    static ArrayList<ViewGroup> sPendingTransitions = new ArrayList();
    private static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<TransitionPort>>>> sRunningTransitions = new ThreadLocal();
    ArrayMap<String, ArrayMap<ScenePort, TransitionPort>> mNameSceneTransitions = new ArrayMap();
    ArrayMap<ScenePort, ArrayMap<String, TransitionPort>> mSceneNameTransitions = new ArrayMap();
    ArrayMap<ScenePort, ArrayMap<ScenePort, TransitionPort>> mScenePairTransitions = new ArrayMap();
    ArrayMap<ScenePort, TransitionPort> mSceneTransitions = new ArrayMap();

    private static class MultiListener implements OnAttachStateChangeListener, OnPreDrawListener {
        ViewGroup mSceneRoot;
        TransitionPort mTransition;

        MultiListener(TransitionPort transitionPort, ViewGroup viewGroup) {
            this.mTransition = transitionPort;
            this.mSceneRoot = viewGroup;
        }

        private void removeListeners() {
            this.mSceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
            this.mSceneRoot.removeOnAttachStateChangeListener(this);
        }

        public boolean onPreDraw() {
            removeListeners();
            TransitionManagerPort.sPendingTransitions.remove(this.mSceneRoot);
            final ArrayMap runningTransitions = TransitionManagerPort.getRunningTransitions();
            ArrayList arrayList = (ArrayList) runningTransitions.get(this.mSceneRoot);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                runningTransitions.put(this.mSceneRoot, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.mTransition);
            this.mTransition.addListener(new TransitionListenerAdapter() {
                public void onTransitionEnd(TransitionPort transitionPort) {
                    ((ArrayList) runningTransitions.get(MultiListener.this.mSceneRoot)).remove(transitionPort);
                }
            });
            this.mTransition.captureValues(this.mSceneRoot, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((TransitionPort) it.next()).resume(this.mSceneRoot);
                }
            }
            this.mTransition.playTransition(this.mSceneRoot);
            return true;
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            removeListeners();
            TransitionManagerPort.sPendingTransitions.remove(this.mSceneRoot);
            ArrayList arrayList = (ArrayList) TransitionManagerPort.getRunningTransitions().get(this.mSceneRoot);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((TransitionPort) it.next()).resume(this.mSceneRoot);
                }
            }
            this.mTransition.clearValues(true);
        }
    }

    TransitionManagerPort() {
    }

    public static void beginDelayedTransition(ViewGroup viewGroup) {
        beginDelayedTransition(viewGroup, null);
    }

    public static void beginDelayedTransition(ViewGroup viewGroup, TransitionPort transitionPort) {
        if (!sPendingTransitions.contains(viewGroup) && ViewCompat.isLaidOut(viewGroup)) {
            sPendingTransitions.add(viewGroup);
            if (transitionPort == null) {
                transitionPort = sDefaultTransition;
            }
            transitionPort = transitionPort.clone();
            sceneChangeSetup(viewGroup, transitionPort);
            ScenePort.setCurrentScene(viewGroup, null);
            sceneChangeRunTransition(viewGroup, transitionPort);
        }
    }

    private static void changeScene(ScenePort scenePort, TransitionPort transitionPort) {
        ViewGroup sceneRoot = scenePort.getSceneRoot();
        if (transitionPort != null) {
            transitionPort = transitionPort.clone();
            transitionPort.setSceneRoot(sceneRoot);
        } else {
            transitionPort = null;
        }
        ScenePort currentScene = ScenePort.getCurrentScene(sceneRoot);
        if (currentScene != null && currentScene.isCreatedFromLayoutResource()) {
            transitionPort.setCanRemoveViews(true);
        }
        sceneChangeSetup(sceneRoot, transitionPort);
        scenePort.enter();
        sceneChangeRunTransition(sceneRoot, transitionPort);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public static TransitionPort getDefaultTransition() {
        return sDefaultTransition;
    }

    static ArrayMap<ViewGroup, ArrayList<TransitionPort>> getRunningTransitions() {
        WeakReference weakReference = (WeakReference) sRunningTransitions.get();
        if (weakReference == null || weakReference.get() == null) {
            WeakReference weakReference2 = new WeakReference(new ArrayMap());
            sRunningTransitions.set(weakReference2);
            weakReference = weakReference2;
        }
        return (ArrayMap) weakReference.get();
    }

    private TransitionPort getTransition(ScenePort scenePort) {
        ViewGroup sceneRoot = scenePort.getSceneRoot();
        if (sceneRoot != null) {
            ScenePort currentScene = ScenePort.getCurrentScene(sceneRoot);
            if (currentScene != null) {
                ArrayMap arrayMap = (ArrayMap) this.mScenePairTransitions.get(scenePort);
                if (arrayMap != null) {
                    TransitionPort transitionPort = (TransitionPort) arrayMap.get(currentScene);
                    if (transitionPort != null) {
                        return transitionPort;
                    }
                }
            }
        }
        TransitionPort transitionPort2 = (TransitionPort) this.mSceneTransitions.get(scenePort);
        if (transitionPort2 == null) {
            transitionPort2 = sDefaultTransition;
        }
        return transitionPort2;
    }

    public static void go(ScenePort scenePort) {
        changeScene(scenePort, sDefaultTransition);
    }

    public static void go(ScenePort scenePort, TransitionPort transitionPort) {
        changeScene(scenePort, transitionPort);
    }

    private static void sceneChangeRunTransition(ViewGroup viewGroup, TransitionPort transitionPort) {
        if (transitionPort != null && viewGroup != null) {
            MultiListener multiListener = new MultiListener(transitionPort, viewGroup);
            viewGroup.addOnAttachStateChangeListener(multiListener);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(multiListener);
        }
    }

    private static void sceneChangeSetup(ViewGroup viewGroup, TransitionPort transitionPort) {
        ArrayList arrayList = (ArrayList) getRunningTransitions().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((TransitionPort) it.next()).pause(viewGroup);
            }
        }
        if (transitionPort != null) {
            transitionPort.captureValues(viewGroup, true);
        }
        ScenePort currentScene = ScenePort.getCurrentScene(viewGroup);
        if (currentScene != null) {
            currentScene.exit();
        }
    }

    public TransitionPort getNamedTransition(ScenePort scenePort, String str) {
        ArrayMap arrayMap = (ArrayMap) this.mSceneNameTransitions.get(scenePort);
        return arrayMap != null ? (TransitionPort) arrayMap.get(str) : null;
    }

    public TransitionPort getNamedTransition(String str, ScenePort scenePort) {
        ArrayMap arrayMap = (ArrayMap) this.mNameSceneTransitions.get(str);
        return arrayMap != null ? (TransitionPort) arrayMap.get(scenePort) : null;
    }

    public String[] getTargetSceneNames(ScenePort scenePort) {
        ArrayMap arrayMap = (ArrayMap) this.mSceneNameTransitions.get(scenePort);
        if (arrayMap == null) {
            return EMPTY_STRINGS;
        }
        int size = arrayMap.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = (String) arrayMap.keyAt(i);
        }
        return strArr;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void setDefaultTransition(TransitionPort transitionPort) {
        sDefaultTransition = transitionPort;
    }

    public void setTransition(ScenePort scenePort, ScenePort scenePort2, TransitionPort transitionPort) {
        ArrayMap arrayMap = (ArrayMap) this.mScenePairTransitions.get(scenePort2);
        if (arrayMap == null) {
            arrayMap = new ArrayMap();
            this.mScenePairTransitions.put(scenePort2, arrayMap);
        }
        arrayMap.put(scenePort, transitionPort);
    }

    public void setTransition(ScenePort scenePort, TransitionPort transitionPort) {
        this.mSceneTransitions.put(scenePort, transitionPort);
    }

    public void setTransition(ScenePort scenePort, String str, TransitionPort transitionPort) {
        ArrayMap arrayMap = (ArrayMap) this.mSceneNameTransitions.get(scenePort);
        if (arrayMap == null) {
            arrayMap = new ArrayMap();
            this.mSceneNameTransitions.put(scenePort, arrayMap);
        }
        arrayMap.put(str, transitionPort);
    }

    public void setTransition(String str, ScenePort scenePort, TransitionPort transitionPort) {
        ArrayMap arrayMap = (ArrayMap) this.mNameSceneTransitions.get(str);
        if (arrayMap == null) {
            arrayMap = new ArrayMap();
            this.mNameSceneTransitions.put(str, arrayMap);
        }
        arrayMap.put(scenePort, transitionPort);
    }

    public void transitionTo(ScenePort scenePort) {
        changeScene(scenePort, getTransition(scenePort));
    }
}
