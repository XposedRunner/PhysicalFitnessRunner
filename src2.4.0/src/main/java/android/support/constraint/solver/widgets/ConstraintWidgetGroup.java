package android.support.constraint.solver.widgets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConstraintWidgetGroup {
    public List<ConstraintWidget> mConstrainedGroup;
    public final int[] mGroupDimensions = new int[]{this.mGroupWidth, this.mGroupHeight};
    int mGroupHeight = -1;
    int mGroupWidth = -1;
    public boolean mSkipSolver = false;
    List<ConstraintWidget> mStartHorizontalWidgets = new ArrayList();
    List<ConstraintWidget> mStartVerticalWidgets = new ArrayList();
    List<ConstraintWidget> mUnresolvedWidgets = new ArrayList();
    HashSet<ConstraintWidget> mWidgetsToSetHorizontal = new HashSet();
    HashSet<ConstraintWidget> mWidgetsToSetVertical = new HashSet();
    List<ConstraintWidget> mWidgetsToSolve = new ArrayList();

    ConstraintWidgetGroup(List<ConstraintWidget> list) {
        this.mConstrainedGroup = list;
    }

    ConstraintWidgetGroup(List<ConstraintWidget> list, boolean z) {
        this.mConstrainedGroup = list;
        this.mSkipSolver = z;
    }

    private void getWidgetsToSolveTraversal(ArrayList<ConstraintWidget> arrayList, ConstraintWidget constraintWidget) {
        if (!constraintWidget.mGroupsToSolver) {
            arrayList.add(constraintWidget);
            constraintWidget.mGroupsToSolver = true;
            if (!constraintWidget.isFullyResolved()) {
                int i = 0;
                if (constraintWidget instanceof Helper) {
                    Helper helper = (Helper) constraintWidget;
                    int i2 = helper.mWidgetsCount;
                    for (int i3 = 0; i3 < i2; i3++) {
                        getWidgetsToSolveTraversal(arrayList, helper.mWidgets[i3]);
                    }
                }
                int length = constraintWidget.mListAnchors.length;
                while (i < length) {
                    ConstraintAnchor constraintAnchor = constraintWidget.mListAnchors[i].mTarget;
                    if (constraintAnchor != null) {
                        ConstraintWidget constraintWidget2 = constraintAnchor.mOwner;
                        if (!(constraintAnchor == null || constraintWidget2 == constraintWidget.getParent())) {
                            getWidgetsToSolveTraversal(arrayList, constraintWidget2);
                        }
                    }
                    i++;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0071  */
    private void updateResolvedDimension(android.support.constraint.solver.widgets.ConstraintWidget r7) {
        /*
        r6 = this;
        r0 = r7.mOptimizerMeasurable;
        if (r0 == 0) goto L_0x00f1;
    L_0x0004:
        r0 = r7.isFullyResolved();
        if (r0 == 0) goto L_0x000b;
    L_0x000a:
        return;
    L_0x000b:
        r0 = r7.mRight;
        r0 = r0.mTarget;
        r1 = 0;
        r2 = 1;
        if (r0 == 0) goto L_0x0015;
    L_0x0013:
        r0 = r2;
        goto L_0x0016;
    L_0x0015:
        r0 = r1;
    L_0x0016:
        if (r0 == 0) goto L_0x001d;
    L_0x0018:
        r3 = r7.mRight;
        r3 = r3.mTarget;
        goto L_0x0021;
    L_0x001d:
        r3 = r7.mLeft;
        r3 = r3.mTarget;
    L_0x0021:
        if (r3 == 0) goto L_0x004b;
    L_0x0023:
        r4 = r3.mOwner;
        r4 = r4.mOptimizerMeasured;
        if (r4 != 0) goto L_0x002e;
    L_0x0029:
        r4 = r3.mOwner;
        r6.updateResolvedDimension(r4);
    L_0x002e:
        r4 = r3.mType;
        r5 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT;
        if (r4 != r5) goto L_0x0040;
    L_0x0034:
        r4 = r3.mOwner;
        r4 = r4.mX;
        r3 = r3.mOwner;
        r3 = r3.getWidth();
        r3 = r3 + r4;
        goto L_0x004c;
    L_0x0040:
        r4 = r3.mType;
        r5 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.LEFT;
        if (r4 != r5) goto L_0x004b;
    L_0x0046:
        r3 = r3.mOwner;
        r3 = r3.mX;
        goto L_0x004c;
    L_0x004b:
        r3 = r1;
    L_0x004c:
        if (r0 == 0) goto L_0x0056;
    L_0x004e:
        r0 = r7.mRight;
        r0 = r0.getMargin();
        r3 = r3 - r0;
        goto L_0x0062;
    L_0x0056:
        r0 = r7.mLeft;
        r0 = r0.getMargin();
        r4 = r7.getWidth();
        r0 = r0 + r4;
        r3 = r3 + r0;
    L_0x0062:
        r0 = r7.getWidth();
        r0 = r3 - r0;
        r7.setHorizontalDimension(r0, r3);
        r0 = r7.mBaseline;
        r0 = r0.mTarget;
        if (r0 == 0) goto L_0x0095;
    L_0x0071:
        r0 = r7.mBaseline;
        r0 = r0.mTarget;
        r1 = r0.mOwner;
        r1 = r1.mOptimizerMeasured;
        if (r1 != 0) goto L_0x0080;
    L_0x007b:
        r1 = r0.mOwner;
        r6.updateResolvedDimension(r1);
    L_0x0080:
        r1 = r0.mOwner;
        r1 = r1.mY;
        r0 = r0.mOwner;
        r0 = r0.mBaselineDistance;
        r1 = r1 + r0;
        r0 = r7.mBaselineDistance;
        r1 = r1 - r0;
        r0 = r7.mHeight;
        r0 = r0 + r1;
        r7.setVerticalDimension(r1, r0);
        r7.mOptimizerMeasured = r2;
        return;
    L_0x0095:
        r0 = r7.mBottom;
        r0 = r0.mTarget;
        if (r0 == 0) goto L_0x009c;
    L_0x009b:
        r1 = r2;
    L_0x009c:
        if (r1 == 0) goto L_0x00a3;
    L_0x009e:
        r0 = r7.mBottom;
        r0 = r0.mTarget;
        goto L_0x00a7;
    L_0x00a3:
        r0 = r7.mTop;
        r0 = r0.mTarget;
    L_0x00a7:
        if (r0 == 0) goto L_0x00d0;
    L_0x00a9:
        r4 = r0.mOwner;
        r4 = r4.mOptimizerMeasured;
        if (r4 != 0) goto L_0x00b4;
    L_0x00af:
        r4 = r0.mOwner;
        r6.updateResolvedDimension(r4);
    L_0x00b4:
        r4 = r0.mType;
        r5 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM;
        if (r4 != r5) goto L_0x00c6;
    L_0x00ba:
        r3 = r0.mOwner;
        r3 = r3.mY;
        r0 = r0.mOwner;
        r0 = r0.getHeight();
        r3 = r3 + r0;
        goto L_0x00d0;
    L_0x00c6:
        r4 = r0.mType;
        r5 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP;
        if (r4 != r5) goto L_0x00d0;
    L_0x00cc:
        r0 = r0.mOwner;
        r3 = r0.mY;
    L_0x00d0:
        if (r1 == 0) goto L_0x00da;
    L_0x00d2:
        r0 = r7.mBottom;
        r0 = r0.getMargin();
        r3 = r3 - r0;
        goto L_0x00e6;
    L_0x00da:
        r0 = r7.mTop;
        r0 = r0.getMargin();
        r1 = r7.getHeight();
        r0 = r0 + r1;
        r3 = r3 + r0;
    L_0x00e6:
        r0 = r7.getHeight();
        r0 = r3 - r0;
        r7.setVerticalDimension(r0, r3);
        r7.mOptimizerMeasured = r2;
    L_0x00f1:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.ConstraintWidgetGroup.updateResolvedDimension(android.support.constraint.solver.widgets.ConstraintWidget):void");
    }

    /* Access modifiers changed, original: 0000 */
    public void addWidgetsToSet(ConstraintWidget constraintWidget, int i) {
        if (i == 0) {
            this.mWidgetsToSetHorizontal.add(constraintWidget);
        } else if (i == 1) {
            this.mWidgetsToSetVertical.add(constraintWidget);
        }
    }

    public List<ConstraintWidget> getStartWidgets(int i) {
        return i == 0 ? this.mStartHorizontalWidgets : i == 1 ? this.mStartVerticalWidgets : null;
    }

    /* Access modifiers changed, original: 0000 */
    public Set<ConstraintWidget> getWidgetsToSet(int i) {
        return i == 0 ? this.mWidgetsToSetHorizontal : i == 1 ? this.mWidgetsToSetVertical : null;
    }

    /* Access modifiers changed, original: 0000 */
    public List<ConstraintWidget> getWidgetsToSolve() {
        if (!this.mWidgetsToSolve.isEmpty()) {
            return this.mWidgetsToSolve;
        }
        int size = this.mConstrainedGroup.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mConstrainedGroup.get(i);
            if (!constraintWidget.mOptimizerMeasurable) {
                getWidgetsToSolveTraversal((ArrayList) this.mWidgetsToSolve, constraintWidget);
            }
        }
        this.mUnresolvedWidgets.clear();
        this.mUnresolvedWidgets.addAll(this.mConstrainedGroup);
        this.mUnresolvedWidgets.removeAll(this.mWidgetsToSolve);
        return this.mWidgetsToSolve;
    }

    /* Access modifiers changed, original: 0000 */
    public void updateUnresolvedWidgets() {
        int size = this.mUnresolvedWidgets.size();
        for (int i = 0; i < size; i++) {
            updateResolvedDimension((ConstraintWidget) this.mUnresolvedWidgets.get(i));
        }
    }
}
