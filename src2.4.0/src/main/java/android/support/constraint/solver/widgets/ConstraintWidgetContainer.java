package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.Metrics;
import android.support.constraint.solver.widgets.ConstraintAnchor.Type;
import android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstraintWidgetContainer extends WidgetContainer {
    private static final boolean DEBUG = false;
    static final boolean DEBUG_GRAPH = false;
    private static final boolean DEBUG_LAYOUT = false;
    private static final int MAX_ITERATIONS = 8;
    private static final boolean USE_SNAPSHOT = true;
    int mDebugSolverPassCount;
    public boolean mGroupsWrapOptimized;
    private boolean mHeightMeasuredTooSmall;
    ChainHead[] mHorizontalChainsArray;
    int mHorizontalChainsSize;
    public boolean mHorizontalWrapOptimized;
    private boolean mIsRtl;
    private int mOptimizationLevel;
    int mPaddingBottom;
    int mPaddingLeft;
    int mPaddingRight;
    int mPaddingTop;
    public boolean mSkipSolver;
    private Snapshot mSnapshot;
    protected LinearSystem mSystem;
    ChainHead[] mVerticalChainsArray;
    int mVerticalChainsSize;
    public boolean mVerticalWrapOptimized;
    public List<ConstraintWidgetGroup> mWidgetGroups;
    private boolean mWidthMeasuredTooSmall;
    public int mWrapFixedHeight;
    public int mWrapFixedWidth;

    public ConstraintWidgetContainer() {
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mWidgetGroups = new ArrayList();
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 7;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
    }

    public ConstraintWidgetContainer(int i, int i2) {
        super(i, i2);
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mWidgetGroups = new ArrayList();
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 7;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
    }

    public ConstraintWidgetContainer(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mWidgetGroups = new ArrayList();
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 7;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
    }

    private void addHorizontalChain(ConstraintWidget constraintWidget) {
        if (this.mHorizontalChainsSize + 1 >= this.mHorizontalChainsArray.length) {
            this.mHorizontalChainsArray = (ChainHead[]) Arrays.copyOf(this.mHorizontalChainsArray, this.mHorizontalChainsArray.length * 2);
        }
        this.mHorizontalChainsArray[this.mHorizontalChainsSize] = new ChainHead(constraintWidget, 0, isRtl());
        this.mHorizontalChainsSize++;
    }

    private void addVerticalChain(ConstraintWidget constraintWidget) {
        if (this.mVerticalChainsSize + 1 >= this.mVerticalChainsArray.length) {
            this.mVerticalChainsArray = (ChainHead[]) Arrays.copyOf(this.mVerticalChainsArray, this.mVerticalChainsArray.length * 2);
        }
        this.mVerticalChainsArray[this.mVerticalChainsSize] = new ChainHead(constraintWidget, 1, isRtl());
        this.mVerticalChainsSize++;
    }

    private void resetChains() {
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
    }

    /* Access modifiers changed, original: 0000 */
    public void addChain(ConstraintWidget constraintWidget, int i) {
        if (i == 0) {
            addHorizontalChain(constraintWidget);
        } else if (i == 1) {
            addVerticalChain(constraintWidget);
        }
    }

    public boolean addChildrenToSolver(LinearSystem linearSystem) {
        addToSolver(linearSystem);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i);
            if (constraintWidget instanceof ConstraintWidgetContainer) {
                DimensionBehaviour dimensionBehaviour = constraintWidget.mListDimensionBehaviors[0];
                DimensionBehaviour dimensionBehaviour2 = constraintWidget.mListDimensionBehaviors[1];
                if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setHorizontalDimensionBehaviour(DimensionBehaviour.FIXED);
                }
                if (dimensionBehaviour2 == DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setVerticalDimensionBehaviour(DimensionBehaviour.FIXED);
                }
                constraintWidget.addToSolver(linearSystem);
                if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setHorizontalDimensionBehaviour(dimensionBehaviour);
                }
                if (dimensionBehaviour2 == DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setVerticalDimensionBehaviour(dimensionBehaviour2);
                }
            } else {
                Optimizer.checkMatchParent(this, linearSystem, constraintWidget);
                constraintWidget.addToSolver(linearSystem);
            }
        }
        if (this.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, 0);
        }
        if (this.mVerticalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, 1);
        }
        return true;
    }

    public void analyze(int i) {
        super.analyze(i);
        int size = this.mChildren.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((ConstraintWidget) this.mChildren.get(i2)).analyze(i);
        }
    }

    public void fillMetrics(Metrics metrics) {
        this.mSystem.fillMetrics(metrics);
    }

    public ArrayList<Guideline> getHorizontalGuidelines() {
        ArrayList arrayList = new ArrayList();
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 0) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public int getOptimizationLevel() {
        return this.mOptimizationLevel;
    }

    public LinearSystem getSystem() {
        return this.mSystem;
    }

    public String getType() {
        return "ConstraintLayout";
    }

    public ArrayList<Guideline> getVerticalGuidelines() {
        ArrayList arrayList = new ArrayList();
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 1) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public List<ConstraintWidgetGroup> getWidgetGroups() {
        return this.mWidgetGroups;
    }

    public boolean handlesInternalConstraints() {
        return false;
    }

    public boolean isHeightMeasuredTooSmall() {
        return this.mHeightMeasuredTooSmall;
    }

    public boolean isRtl() {
        return this.mIsRtl;
    }

    public boolean isWidthMeasuredTooSmall() {
        return this.mWidthMeasuredTooSmall;
    }

    /* JADX WARNING: Removed duplicated region for block: B:77:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0276  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x029f  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0292  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02a2  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0276  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0292  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x029f  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02a2  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0276  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x029f  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0292  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02a2  */
    public void layout() {
        /*
        r23 = this;
        r1 = r23;
        r2 = r1.mX;
        r3 = r1.mY;
        r4 = r23.getWidth();
        r5 = 0;
        r4 = java.lang.Math.max(r5, r4);
        r6 = r23.getHeight();
        r6 = java.lang.Math.max(r5, r6);
        r1.mWidthMeasuredTooSmall = r5;
        r1.mHeightMeasuredTooSmall = r5;
        r7 = r1.mParent;
        if (r7 == 0) goto L_0x0046;
    L_0x001f:
        r7 = r1.mSnapshot;
        if (r7 != 0) goto L_0x002a;
    L_0x0023:
        r7 = new android.support.constraint.solver.widgets.Snapshot;
        r7.<init>(r1);
        r1.mSnapshot = r7;
    L_0x002a:
        r7 = r1.mSnapshot;
        r7.updateFrom(r1);
        r7 = r1.mPaddingLeft;
        r1.setX(r7);
        r7 = r1.mPaddingTop;
        r1.setY(r7);
        r23.resetAnchors();
        r7 = r1.mSystem;
        r7 = r7.getCache();
        r1.resetSolverVariables(r7);
        goto L_0x004a;
    L_0x0046:
        r1.mX = r5;
        r1.mY = r5;
    L_0x004a:
        r7 = r1.mOptimizationLevel;
        r8 = 32;
        r9 = 8;
        r10 = 1;
        if (r7 == 0) goto L_0x006a;
    L_0x0053:
        r7 = r1.optimizeFor(r9);
        if (r7 != 0) goto L_0x005c;
    L_0x0059:
        r23.optimizeReset();
    L_0x005c:
        r7 = r1.optimizeFor(r8);
        if (r7 != 0) goto L_0x0065;
    L_0x0062:
        r23.optimize();
    L_0x0065:
        r7 = r1.mSystem;
        r7.graphOptimizer = r10;
        goto L_0x006e;
    L_0x006a:
        r7 = r1.mSystem;
        r7.graphOptimizer = r5;
    L_0x006e:
        r7 = r1.mListDimensionBehaviors;
        r7 = r7[r10];
        r11 = r1.mListDimensionBehaviors;
        r11 = r11[r5];
        r23.resetChains();
        r12 = r1.mWidgetGroups;
        r12 = r12.size();
        if (r12 != 0) goto L_0x0092;
    L_0x0081:
        r12 = r1.mWidgetGroups;
        r12.clear();
        r12 = r1.mWidgetGroups;
        r13 = new android.support.constraint.solver.widgets.ConstraintWidgetGroup;
        r14 = r1.mChildren;
        r13.<init>(r14);
        r12.add(r5, r13);
    L_0x0092:
        r12 = r1.mWidgetGroups;
        r12 = r12.size();
        r13 = r1.mChildren;
        r14 = r23.getHorizontalDimensionBehaviour();
        r15 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r14 == r15) goto L_0x00ad;
    L_0x00a2:
        r14 = r23.getVerticalDimensionBehaviour();
        r15 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r14 != r15) goto L_0x00ab;
    L_0x00aa:
        goto L_0x00ad;
    L_0x00ab:
        r14 = r5;
        goto L_0x00ae;
    L_0x00ad:
        r14 = r10;
    L_0x00ae:
        r15 = r5;
        r16 = r15;
    L_0x00b1:
        if (r15 >= r12) goto L_0x0309;
    L_0x00b3:
        r9 = r1.mSkipSolver;
        if (r9 != 0) goto L_0x0309;
    L_0x00b7:
        r9 = r1.mWidgetGroups;
        r9 = r9.get(r15);
        r9 = (android.support.constraint.solver.widgets.ConstraintWidgetGroup) r9;
        r9 = r9.mSkipSolver;
        if (r9 == 0) goto L_0x00c9;
    L_0x00c3:
        r20 = r3;
        r19 = r12;
        goto L_0x02fb;
    L_0x00c9:
        r9 = r1.optimizeFor(r8);
        if (r9 == 0) goto L_0x00fe;
    L_0x00cf:
        r9 = r23.getHorizontalDimensionBehaviour();
        r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
        if (r9 != r8) goto L_0x00f0;
    L_0x00d7:
        r8 = r23.getVerticalDimensionBehaviour();
        r9 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
        if (r8 != r9) goto L_0x00f0;
    L_0x00df:
        r8 = r1.mWidgetGroups;
        r8 = r8.get(r15);
        r8 = (android.support.constraint.solver.widgets.ConstraintWidgetGroup) r8;
        r8 = r8.getWidgetsToSolve();
        r8 = (java.util.ArrayList) r8;
        r1.mChildren = r8;
        goto L_0x00fe;
    L_0x00f0:
        r8 = r1.mWidgetGroups;
        r8 = r8.get(r15);
        r8 = (android.support.constraint.solver.widgets.ConstraintWidgetGroup) r8;
        r8 = r8.mConstrainedGroup;
        r8 = (java.util.ArrayList) r8;
        r1.mChildren = r8;
    L_0x00fe:
        r23.resetChains();
        r8 = r1.mChildren;
        r8 = r8.size();
        r9 = r5;
    L_0x0108:
        if (r9 >= r8) goto L_0x0120;
    L_0x010a:
        r5 = r1.mChildren;
        r5 = r5.get(r9);
        r5 = (android.support.constraint.solver.widgets.ConstraintWidget) r5;
        r10 = r5 instanceof android.support.constraint.solver.widgets.WidgetContainer;
        if (r10 == 0) goto L_0x011b;
    L_0x0116:
        r5 = (android.support.constraint.solver.widgets.WidgetContainer) r5;
        r5.layout();
    L_0x011b:
        r9 = r9 + 1;
        r5 = 0;
        r10 = 1;
        goto L_0x0108;
    L_0x0120:
        r10 = r16;
        r5 = 1;
        r9 = 0;
    L_0x0124:
        if (r5 == 0) goto L_0x02e8;
    L_0x0126:
        r16 = 1;
        r9 = r9 + 1;
        r17 = r5;
        r5 = r1.mSystem;	 Catch:{ Exception -> 0x0173 }
        r5.reset();	 Catch:{ Exception -> 0x0173 }
        r23.resetChains();	 Catch:{ Exception -> 0x0173 }
        r5 = r1.mSystem;	 Catch:{ Exception -> 0x0173 }
        r1.createObjectVariables(r5);	 Catch:{ Exception -> 0x0173 }
        r5 = 0;
    L_0x013a:
        if (r5 >= r8) goto L_0x0156;
    L_0x013c:
        r18 = r10;
        r10 = r1.mChildren;	 Catch:{ Exception -> 0x0154 }
        r10 = r10.get(r5);	 Catch:{ Exception -> 0x0154 }
        r10 = (android.support.constraint.solver.widgets.ConstraintWidget) r10;	 Catch:{ Exception -> 0x0154 }
        r19 = r12;
        r12 = r1.mSystem;	 Catch:{ Exception -> 0x0171 }
        r10.createObjectVariables(r12);	 Catch:{ Exception -> 0x0171 }
        r5 = r5 + 1;
        r10 = r18;
        r12 = r19;
        goto L_0x013a;
    L_0x0154:
        r0 = move-exception;
        goto L_0x0176;
    L_0x0156:
        r18 = r10;
        r19 = r12;
        r5 = r1.mSystem;	 Catch:{ Exception -> 0x0171 }
        r5 = r1.addChildrenToSolver(r5);	 Catch:{ Exception -> 0x0171 }
        if (r5 == 0) goto L_0x016c;
    L_0x0162:
        r10 = r1.mSystem;	 Catch:{ Exception -> 0x0168 }
        r10.minimize();	 Catch:{ Exception -> 0x0168 }
        goto L_0x016c;
    L_0x0168:
        r0 = move-exception;
        r17 = r5;
        goto L_0x0178;
    L_0x016c:
        r20 = r3;
        r17 = r5;
        goto L_0x0194;
    L_0x0171:
        r0 = move-exception;
        goto L_0x0178;
    L_0x0173:
        r0 = move-exception;
        r18 = r10;
    L_0x0176:
        r19 = r12;
    L_0x0178:
        r5 = r0;
        r5.printStackTrace();
        r10 = java.lang.System.out;
        r12 = new java.lang.StringBuilder;
        r12.<init>();
        r20 = r3;
        r3 = "EXCEPTION : ";
        r12.append(r3);
        r12.append(r5);
        r3 = r12.toString();
        r10.println(r3);
    L_0x0194:
        if (r17 == 0) goto L_0x019f;
    L_0x0196:
        r5 = r1.mSystem;
        r10 = android.support.constraint.solver.widgets.Optimizer.flags;
        r1.updateChildrenFromSolver(r5, r10);
    L_0x019d:
        r10 = 2;
        goto L_0x01e9;
    L_0x019f:
        r5 = r1.mSystem;
        r1.updateFromSolver(r5);
        r5 = 0;
    L_0x01a5:
        if (r5 >= r8) goto L_0x019d;
    L_0x01a7:
        r10 = r1.mChildren;
        r10 = r10.get(r5);
        r10 = (android.support.constraint.solver.widgets.ConstraintWidget) r10;
        r12 = r10.mListDimensionBehaviors;
        r16 = 0;
        r12 = r12[r16];
        r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r12 != r3) goto L_0x01cb;
    L_0x01b9:
        r3 = r10.getWidth();
        r12 = r10.getWrapWidth();
        if (r3 >= r12) goto L_0x01cb;
    L_0x01c3:
        r3 = android.support.constraint.solver.widgets.Optimizer.flags;
        r5 = 2;
        r12 = 1;
        r3[r5] = r12;
        r10 = r5;
        goto L_0x01e9;
    L_0x01cb:
        r12 = 1;
        r3 = r10.mListDimensionBehaviors;
        r3 = r3[r12];
        r12 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r3 != r12) goto L_0x01e5;
    L_0x01d4:
        r3 = r10.getHeight();
        r10 = r10.getWrapHeight();
        if (r3 >= r10) goto L_0x01e5;
    L_0x01de:
        r3 = android.support.constraint.solver.widgets.Optimizer.flags;
        r5 = 1;
        r10 = 2;
        r3[r10] = r5;
        goto L_0x01e9;
    L_0x01e5:
        r10 = 2;
        r5 = r5 + 1;
        goto L_0x01a5;
    L_0x01e9:
        if (r14 == 0) goto L_0x0261;
    L_0x01eb:
        r3 = 8;
        if (r9 >= r3) goto L_0x0261;
    L_0x01ef:
        r5 = android.support.constraint.solver.widgets.Optimizer.flags;
        r5 = r5[r10];
        if (r5 == 0) goto L_0x0261;
    L_0x01f5:
        r5 = 0;
        r10 = 0;
        r12 = 0;
    L_0x01f8:
        if (r5 >= r8) goto L_0x0222;
    L_0x01fa:
        r3 = r1.mChildren;
        r3 = r3.get(r5);
        r3 = (android.support.constraint.solver.widgets.ConstraintWidget) r3;
        r21 = r8;
        r8 = r3.mX;
        r16 = r3.getWidth();
        r8 = r8 + r16;
        r10 = java.lang.Math.max(r10, r8);
        r8 = r3.mY;
        r3 = r3.getHeight();
        r8 = r8 + r3;
        r12 = java.lang.Math.max(r12, r8);
        r5 = r5 + 1;
        r8 = r21;
        r3 = 8;
        goto L_0x01f8;
    L_0x0222:
        r21 = r8;
        r3 = r1.mMinWidth;
        r3 = java.lang.Math.max(r3, r10);
        r5 = r1.mMinHeight;
        r5 = java.lang.Math.max(r5, r12);
        r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r11 != r8) goto L_0x0247;
    L_0x0234:
        r8 = r23.getWidth();
        if (r8 >= r3) goto L_0x0247;
    L_0x023a:
        r1.setWidth(r3);
        r3 = r1.mListDimensionBehaviors;
        r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r10 = 0;
        r3[r10] = r8;
        r3 = 1;
        r10 = 1;
        goto L_0x024a;
    L_0x0247:
        r10 = r18;
        r3 = 0;
    L_0x024a:
        r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r7 != r8) goto L_0x0266;
    L_0x024e:
        r8 = r23.getHeight();
        if (r8 >= r5) goto L_0x0266;
    L_0x0254:
        r1.setHeight(r5);
        r3 = r1.mListDimensionBehaviors;
        r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r8 = 1;
        r3[r8] = r5;
        r3 = 1;
        r10 = 1;
        goto L_0x0266;
    L_0x0261:
        r21 = r8;
        r10 = r18;
        r3 = 0;
    L_0x0266:
        r5 = r1.mMinWidth;
        r8 = r23.getWidth();
        r5 = java.lang.Math.max(r5, r8);
        r8 = r23.getWidth();
        if (r5 <= r8) goto L_0x0282;
    L_0x0276:
        r1.setWidth(r5);
        r3 = r1.mListDimensionBehaviors;
        r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
        r8 = 0;
        r3[r8] = r5;
        r3 = 1;
        r10 = 1;
    L_0x0282:
        r5 = r1.mMinHeight;
        r8 = r23.getHeight();
        r5 = java.lang.Math.max(r5, r8);
        r8 = r23.getHeight();
        if (r5 <= r8) goto L_0x029f;
    L_0x0292:
        r1.setHeight(r5);
        r3 = r1.mListDimensionBehaviors;
        r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
        r8 = 1;
        r3[r8] = r5;
        r3 = r8;
        r10 = r3;
        goto L_0x02a0;
    L_0x029f:
        r8 = 1;
    L_0x02a0:
        if (r10 != 0) goto L_0x02df;
    L_0x02a2:
        r5 = r1.mListDimensionBehaviors;
        r12 = 0;
        r5 = r5[r12];
        r12 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r5 != r12) goto L_0x02c1;
    L_0x02ab:
        if (r4 <= 0) goto L_0x02c1;
    L_0x02ad:
        r5 = r23.getWidth();
        if (r5 <= r4) goto L_0x02c1;
    L_0x02b3:
        r1.mWidthMeasuredTooSmall = r8;
        r3 = r1.mListDimensionBehaviors;
        r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
        r10 = 0;
        r3[r10] = r5;
        r1.setWidth(r4);
        r3 = r8;
        r10 = r3;
    L_0x02c1:
        r5 = r1.mListDimensionBehaviors;
        r5 = r5[r8];
        r12 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r5 != r12) goto L_0x02df;
    L_0x02c9:
        if (r6 <= 0) goto L_0x02df;
    L_0x02cb:
        r5 = r23.getHeight();
        if (r5 <= r6) goto L_0x02df;
    L_0x02d1:
        r1.mHeightMeasuredTooSmall = r8;
        r3 = r1.mListDimensionBehaviors;
        r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
        r3[r8] = r5;
        r1.setHeight(r6);
        r5 = 1;
        r10 = 1;
        goto L_0x02e0;
    L_0x02df:
        r5 = r3;
    L_0x02e0:
        r12 = r19;
        r3 = r20;
        r8 = r21;
        goto L_0x0124;
    L_0x02e8:
        r20 = r3;
        r18 = r10;
        r19 = r12;
        r3 = r1.mWidgetGroups;
        r3 = r3.get(r15);
        r3 = (android.support.constraint.solver.widgets.ConstraintWidgetGroup) r3;
        r3.updateUnresolvedWidgets();
        r16 = r18;
    L_0x02fb:
        r15 = r15 + 1;
        r12 = r19;
        r3 = r20;
        r5 = 0;
        r8 = 32;
        r9 = 8;
        r10 = 1;
        goto L_0x00b1;
    L_0x0309:
        r20 = r3;
        r13 = (java.util.ArrayList) r13;
        r1.mChildren = r13;
        r3 = r1.mParent;
        if (r3 == 0) goto L_0x033f;
    L_0x0313:
        r2 = r1.mMinWidth;
        r3 = r23.getWidth();
        r2 = java.lang.Math.max(r2, r3);
        r3 = r1.mMinHeight;
        r4 = r23.getHeight();
        r3 = java.lang.Math.max(r3, r4);
        r4 = r1.mSnapshot;
        r4.applyTo(r1);
        r4 = r1.mPaddingLeft;
        r2 = r2 + r4;
        r4 = r1.mPaddingRight;
        r2 = r2 + r4;
        r1.setWidth(r2);
        r2 = r1.mPaddingTop;
        r3 = r3 + r2;
        r2 = r1.mPaddingBottom;
        r3 = r3 + r2;
        r1.setHeight(r3);
        goto L_0x0345;
    L_0x033f:
        r1.mX = r2;
        r2 = r20;
        r1.mY = r2;
    L_0x0345:
        if (r16 == 0) goto L_0x0351;
    L_0x0347:
        r2 = r1.mListDimensionBehaviors;
        r3 = 0;
        r2[r3] = r11;
        r2 = r1.mListDimensionBehaviors;
        r3 = 1;
        r2[r3] = r7;
    L_0x0351:
        r2 = r1.mSystem;
        r2 = r2.getCache();
        r1.resetSolverVariables(r2);
        r2 = r23.getRootConstraintContainer();
        if (r1 != r2) goto L_0x0363;
    L_0x0360:
        r23.updateDrawPosition();
    L_0x0363:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.ConstraintWidgetContainer.layout():void");
    }

    public void optimize() {
        if (!optimizeFor(8)) {
            analyze(this.mOptimizationLevel);
        }
        solveGraph();
    }

    public boolean optimizeFor(int i) {
        return (this.mOptimizationLevel & i) == i;
    }

    public void optimizeForDimensions(int i, int i2) {
        if (!(this.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT || this.mResolutionWidth == null)) {
            this.mResolutionWidth.resolve(i);
        }
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.WRAP_CONTENT && this.mResolutionHeight != null) {
            this.mResolutionHeight.resolve(i2);
        }
    }

    public void optimizeReset() {
        int size = this.mChildren.size();
        resetResolutionNodes();
        for (int i = 0; i < size; i++) {
            ((ConstraintWidget) this.mChildren.get(i)).resetResolutionNodes();
        }
    }

    public void preOptimize() {
        optimizeReset();
        analyze(this.mOptimizationLevel);
    }

    public void reset() {
        this.mSystem.reset();
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mWidgetGroups.clear();
        this.mSkipSolver = false;
        super.reset();
    }

    public void resetGraph() {
        ResolutionAnchor resolutionNode = getAnchor(Type.LEFT).getResolutionNode();
        ResolutionAnchor resolutionNode2 = getAnchor(Type.TOP).getResolutionNode();
        resolutionNode.invalidateAnchors();
        resolutionNode2.invalidateAnchors();
        resolutionNode.resolve(null, 0.0f);
        resolutionNode2.resolve(null, 0.0f);
    }

    public void setOptimizationLevel(int i) {
        this.mOptimizationLevel = i;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.mPaddingLeft = i;
        this.mPaddingTop = i2;
        this.mPaddingRight = i3;
        this.mPaddingBottom = i4;
    }

    public void setRtl(boolean z) {
        this.mIsRtl = z;
    }

    public void solveGraph() {
        ResolutionAnchor resolutionNode = getAnchor(Type.LEFT).getResolutionNode();
        ResolutionAnchor resolutionNode2 = getAnchor(Type.TOP).getResolutionNode();
        resolutionNode.resolve(null, 0.0f);
        resolutionNode2.resolve(null, 0.0f);
    }

    public void updateChildrenFromSolver(LinearSystem linearSystem, boolean[] zArr) {
        zArr[2] = false;
        updateFromSolver(linearSystem);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i);
            constraintWidget.updateFromSolver(linearSystem);
            if (constraintWidget.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getWidth() < constraintWidget.getWrapWidth()) {
                zArr[2] = true;
            }
            if (constraintWidget.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getHeight() < constraintWidget.getWrapHeight()) {
                zArr[2] = true;
            }
        }
    }
}
