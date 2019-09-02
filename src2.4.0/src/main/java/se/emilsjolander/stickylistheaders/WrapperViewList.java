package se.emilsjolander.stickylistheaders;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.widget.ListView;
import java.lang.reflect.Field;
import java.util.List;

class WrapperViewList extends ListView {
    private boolean mBlockLayoutChildren;
    private boolean mClippingToPadding;
    private List<View> mFooterViews;
    private LifeCycleListener mLifeCycleListener;
    private Field mSelectorPositionField;
    private Rect mSelectorRect;
    private int mTopClippingLength;

    interface LifeCycleListener {
        void onDispatchDrawOccurred(Canvas canvas);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:1:0x0001
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:364)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:60)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    public WrapperViewList(android.content.Context r3) {
        /*
        r2 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: se.emilsjolander.stickylistheaders.WrapperViewList.<init>(android.content.Context):void");
    }

    private void addInternalFooterView(View view) {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:2:0x0002
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:364)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:60)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    private int getSelectorPosition() {
        /*
        r3 = this;
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: se.emilsjolander.stickylistheaders.WrapperViewList.getSelectorPosition():int");
    }

    private void positionSelectorRect() {
    }

    public void addFooterView(View view) {
    }

    public void addFooterView(View view, Object obj, boolean z) {
    }

    /* Access modifiers changed, original: 0000 */
    public boolean containsFooterView(View view) {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void dispatchDraw(Canvas canvas) {
    }

    /* Access modifiers changed, original: 0000 */
    public int getFixedFirstVisibleItem() {
        return 0;
    }

    /* Access modifiers changed, original: protected */
    public void layoutChildren() {
    }

    public boolean performItemClick(View view, int i, long j) {
        return false;
    }

    public boolean removeFooterView(View view) {
        return false;
    }

    public void setBlockLayoutChildren(boolean z) {
    }

    public void setClipToPadding(boolean z) {
    }

    /* Access modifiers changed, original: 0000 */
    public void setLifeCycleListener(LifeCycleListener lifeCycleListener) {
    }

    /* Access modifiers changed, original: 0000 */
    public void setTopClippingLength(int i) {
    }
}
