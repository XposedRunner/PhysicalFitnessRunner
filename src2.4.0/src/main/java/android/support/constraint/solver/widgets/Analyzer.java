package android.support.constraint.solver.widgets;

import android.support.constraint.solver.widgets.ConstraintAnchor.Type;
import android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Analyzer {
    private Analyzer() {
    }

    public static void determineGroups(ConstraintWidgetContainer constraintWidgetContainer) {
        if ((constraintWidgetContainer.getOptimizationLevel() & 32) != 32) {
            singleGroup(constraintWidgetContainer);
            return;
        }
        constraintWidgetContainer.mSkipSolver = true;
        constraintWidgetContainer.mGroupsWrapOptimized = false;
        constraintWidgetContainer.mHorizontalWrapOptimized = false;
        constraintWidgetContainer.mVerticalWrapOptimized = false;
        ArrayList<ConstraintWidget> arrayList = constraintWidgetContainer.mChildren;
        List<ConstraintWidgetGroup> list = constraintWidgetContainer.mWidgetGroups;
        boolean z = constraintWidgetContainer.getHorizontalDimensionBehaviour() == DimensionBehaviour.WRAP_CONTENT;
        boolean z2 = constraintWidgetContainer.getVerticalDimensionBehaviour() == DimensionBehaviour.WRAP_CONTENT;
        boolean z3 = z || z2;
        list.clear();
        for (ConstraintWidget constraintWidget : arrayList) {
            constraintWidget.mBelongingGroup = null;
            constraintWidget.mGroupsToSolver = false;
            constraintWidget.resetResolutionNodes();
        }
        for (ConstraintWidget constraintWidget2 : arrayList) {
            if (constraintWidget2.mBelongingGroup == null && !determineGroups(constraintWidget2, list, z3)) {
                singleGroup(constraintWidgetContainer);
                constraintWidgetContainer.mSkipSolver = false;
                return;
            }
        }
        int i = 0;
        int i2 = i;
        for (ConstraintWidgetGroup constraintWidgetGroup : list) {
            i = Math.max(i, getMaxDimension(constraintWidgetGroup, 0));
            i2 = Math.max(i2, getMaxDimension(constraintWidgetGroup, 1));
        }
        if (z) {
            constraintWidgetContainer.setHorizontalDimensionBehaviour(DimensionBehaviour.FIXED);
            constraintWidgetContainer.setWidth(i);
            constraintWidgetContainer.mGroupsWrapOptimized = true;
            constraintWidgetContainer.mHorizontalWrapOptimized = true;
            constraintWidgetContainer.mWrapFixedWidth = i;
        }
        if (z2) {
            constraintWidgetContainer.setVerticalDimensionBehaviour(DimensionBehaviour.FIXED);
            constraintWidgetContainer.setHeight(i2);
            constraintWidgetContainer.mGroupsWrapOptimized = true;
            constraintWidgetContainer.mVerticalWrapOptimized = true;
            constraintWidgetContainer.mWrapFixedHeight = i2;
        }
        setPosition(list, 0, constraintWidgetContainer.getWidth());
        setPosition(list, 1, constraintWidgetContainer.getHeight());
    }

    private static boolean determineGroups(ConstraintWidget constraintWidget, List<ConstraintWidgetGroup> list, boolean z) {
        ConstraintWidgetGroup constraintWidgetGroup = new ConstraintWidgetGroup(new ArrayList(), true);
        list.add(constraintWidgetGroup);
        return traverse(constraintWidget, constraintWidgetGroup, list, z);
    }

    private static int getMaxDimension(ConstraintWidgetGroup constraintWidgetGroup, int i) {
        int i2 = i * 2;
        List startWidgets = constraintWidgetGroup.getStartWidgets(i);
        int size = startWidgets.size();
        int i3 = 0;
        int i4 = i3;
        while (i3 < size) {
            ConstraintWidget constraintWidget = (ConstraintWidget) startWidgets.get(i3);
            int i5 = i2 + 1;
            boolean z = constraintWidget.mListAnchors[i5].mTarget == null || !(constraintWidget.mListAnchors[i2].mTarget == null || constraintWidget.mListAnchors[i5].mTarget == null);
            i4 = Math.max(i4, getMaxDimensionTraversal(constraintWidget, i, z, 0));
            i3++;
        }
        constraintWidgetGroup.mGroupDimensions[i] = i4;
        return i4;
    }

    private static int getMaxDimensionTraversal(ConstraintWidget constraintWidget, int i, boolean z, int i2) {
        ConstraintWidget constraintWidget2 = constraintWidget;
        int i3 = i;
        boolean z2 = z;
        int i4 = 0;
        if (!constraintWidget2.mOptimizerMeasurable) {
            return 0;
        }
        int baselineDistance;
        int height;
        int i5;
        int i6;
        int i7;
        int i8 = (constraintWidget2.mBaseline.mTarget == null || i3 != 1) ? 0 : 1;
        if (z2) {
            baselineDistance = constraintWidget.getBaselineDistance();
            height = constraintWidget.getHeight() - constraintWidget.getBaselineDistance();
            i5 = i3 * 2;
            i6 = i5 + 1;
        } else {
            baselineDistance = constraintWidget.getHeight() - constraintWidget.getBaselineDistance();
            height = constraintWidget.getBaselineDistance();
            i6 = i3 * 2;
            i5 = i6 + 1;
        }
        if (constraintWidget2.mListAnchors[i6].mTarget == null || constraintWidget2.mListAnchors[i5].mTarget != null) {
            i7 = i6;
            i6 = 1;
        } else {
            i7 = i5;
            i5 = i6;
            i6 = -1;
        }
        int margin = (constraintWidget2.mListAnchors[i5].getMargin() * i6) + getParentBiasOffset(constraintWidget, i);
        int i9 = (i8 != 0 ? i2 - baselineDistance : i2) + margin;
        int width = (i3 == 0 ? constraintWidget.getWidth() : constraintWidget.getHeight()) * i6;
        Iterator it = constraintWidget2.mListAnchors[i5].getResolutionNode().dependents.iterator();
        while (it.hasNext()) {
            i4 = Math.max(i4, getMaxDimensionTraversal(((ResolutionAnchor) ((ResolutionNode) it.next())).myAnchor.mOwner, i3, z2, i9));
        }
        Iterator it2 = constraintWidget2.mListAnchors[i7].getResolutionNode().dependents.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            Iterator it3 = it2;
            i10 = Math.max(i10, getMaxDimensionTraversal(((ResolutionAnchor) ((ResolutionNode) it2.next())).myAnchor.mOwner, i3, z2, width + i9));
            it2 = it3;
        }
        if (i8 != 0) {
            i4 -= baselineDistance;
            i10 += height;
        } else {
            i10 += (i3 == 0 ? constraintWidget.getWidth() : constraintWidget.getHeight()) * i6;
        }
        int i11 = 1;
        int i12;
        if (i3 == 1) {
            it2 = constraintWidget2.mBaseline.getResolutionNode().dependents.iterator();
            int i13 = 0;
            while (it2.hasNext()) {
                Iterator it4 = it2;
                ResolutionAnchor resolutionAnchor = (ResolutionAnchor) ((ResolutionNode) it2.next());
                if (i6 == i11) {
                    i13 = Math.max(i13, getMaxDimensionTraversal(resolutionAnchor.myAnchor.mOwner, i3, z2, baselineDistance + i9));
                    i12 = i7;
                } else {
                    i12 = i7;
                    i13 = Math.max(i13, getMaxDimensionTraversal(resolutionAnchor.myAnchor.mOwner, i3, z2, (height * i6) + i9));
                }
                it2 = it4;
                i7 = i12;
                i11 = 1;
            }
            i12 = i7;
            i11 = i13;
            i8 = (constraintWidget2.mBaseline.getResolutionNode().dependents.size() <= 0 || i8 != 0) ? i11 : i6 == 1 ? i11 + baselineDistance : i11 - height;
        } else {
            i12 = i7;
            i8 = 0;
        }
        margin += Math.max(i4, Math.max(i10, i8));
        i8 = i9 + width;
        if (i6 == -1) {
            int i14 = i9;
            i9 = i8;
            i8 = i14;
        }
        if (z2) {
            Optimizer.setOptimizedWidget(constraintWidget2, i3, i9);
            constraintWidget2.setFrame(i9, i8, i3);
        } else {
            constraintWidget2.mBelongingGroup.addWidgetsToSet(constraintWidget2, i3);
            constraintWidget2.setRelativePositioning(i9, i3);
        }
        if (constraintWidget.getDimensionBehaviour(i) == DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget2.mDimensionRatio != 0.0f) {
            constraintWidget2.mBelongingGroup.addWidgetsToSet(constraintWidget2, i3);
        }
        if (!(constraintWidget2.mListAnchors[i5].mTarget == null || constraintWidget2.mListAnchors[r21].mTarget == null)) {
            ConstraintWidget parent = constraintWidget.getParent();
            if (constraintWidget2.mListAnchors[i5].mTarget.mOwner == parent && constraintWidget2.mListAnchors[r21].mTarget.mOwner == parent) {
                constraintWidget2.mBelongingGroup.addWidgetsToSet(constraintWidget2, i3);
            }
        }
        return margin;
    }

    private static int getParentBiasOffset(ConstraintWidget constraintWidget, int i) {
        int i2 = i * 2;
        ConstraintAnchor constraintAnchor = constraintWidget.mListAnchors[i2];
        ConstraintAnchor constraintAnchor2 = constraintWidget.mListAnchors[i2 + 1];
        if (constraintAnchor.mTarget == null || constraintAnchor.mTarget.mOwner != constraintWidget.mParent || constraintAnchor2.mTarget == null || constraintAnchor2.mTarget.mOwner != constraintWidget.mParent) {
            return 0;
        }
        return (int) (((float) (((constraintWidget.mParent.getLength(i) - constraintAnchor.getMargin()) - constraintAnchor2.getMargin()) - constraintWidget.getLength(i))) * (i == 0 ? constraintWidget.mHorizontalBiasPercent : constraintWidget.mVerticalBiasPercent));
    }

    private static void invalidate(ConstraintWidgetContainer constraintWidgetContainer, ConstraintWidget constraintWidget, ConstraintWidgetGroup constraintWidgetGroup) {
        constraintWidgetGroup.mSkipSolver = false;
        constraintWidgetContainer.mSkipSolver = false;
        constraintWidget.mOptimizerMeasurable = false;
    }

    private static int resolveDimensionRatio(ConstraintWidget constraintWidget) {
        int height;
        if (constraintWidget.getHorizontalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT) {
            height = constraintWidget.mDimensionRatioSide == 0 ? (int) (((float) constraintWidget.getHeight()) * constraintWidget.mDimensionRatio) : (int) (((float) constraintWidget.getHeight()) / constraintWidget.mDimensionRatio);
            constraintWidget.setWidth(height);
            return height;
        } else if (constraintWidget.getVerticalDimensionBehaviour() != DimensionBehaviour.MATCH_CONSTRAINT) {
            return -1;
        } else {
            height = constraintWidget.mDimensionRatioSide == 1 ? (int) (((float) constraintWidget.getWidth()) * constraintWidget.mDimensionRatio) : (int) (((float) constraintWidget.getWidth()) / constraintWidget.mDimensionRatio);
            constraintWidget.setHeight(height);
            return height;
        }
    }

    private static void setConnection(ConstraintAnchor constraintAnchor) {
        ResolutionAnchor resolutionNode = constraintAnchor.getResolutionNode();
        if (constraintAnchor.mTarget != null && constraintAnchor.mTarget.mTarget != constraintAnchor) {
            constraintAnchor.mTarget.getResolutionNode().addDependent(resolutionNode);
        }
    }

    public static void setPosition(List<ConstraintWidgetGroup> list, int i, int i2) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            for (ConstraintWidget constraintWidget : ((ConstraintWidgetGroup) list.get(i3)).getWidgetsToSet(i)) {
                if (constraintWidget.mOptimizerMeasurable) {
                    updateSizeDependentWidgets(constraintWidget, i, i2);
                }
            }
        }
    }

    private static void singleGroup(ConstraintWidgetContainer constraintWidgetContainer) {
        constraintWidgetContainer.mWidgetGroups.clear();
        constraintWidgetContainer.mWidgetGroups.add(0, new ConstraintWidgetGroup(constraintWidgetContainer.mChildren));
    }

    private static boolean traverse(ConstraintWidget constraintWidget, ConstraintWidgetGroup constraintWidgetGroup, List<ConstraintWidgetGroup> list, boolean z) {
        if (constraintWidget == null) {
            return true;
        }
        constraintWidget.mOptimizerMeasured = false;
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget.getParent();
        if (constraintWidget.mBelongingGroup == null) {
            DimensionBehaviour verticalDimensionBehaviour;
            DimensionBehaviour dimensionBehaviour;
            int i;
            constraintWidget.mOptimizerMeasurable = true;
            constraintWidgetGroup.mConstrainedGroup.add(constraintWidget);
            constraintWidget.mBelongingGroup = constraintWidgetGroup;
            if (constraintWidget.mLeft.mTarget == null && constraintWidget.mRight.mTarget == null && constraintWidget.mTop.mTarget == null && constraintWidget.mBottom.mTarget == null && constraintWidget.mBaseline.mTarget == null && constraintWidget.mCenter.mTarget == null) {
                invalidate(constraintWidgetContainer, constraintWidget, constraintWidgetGroup);
                if (z) {
                    return false;
                }
            }
            if (!(constraintWidget.mTop.mTarget == null || constraintWidget.mBottom.mTarget == null)) {
                verticalDimensionBehaviour = constraintWidgetContainer.getVerticalDimensionBehaviour();
                dimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
                if (z) {
                    invalidate(constraintWidgetContainer, constraintWidget, constraintWidgetGroup);
                    return false;
                } else if (!(constraintWidget.mTop.mTarget.mOwner == constraintWidget.getParent() && constraintWidget.mBottom.mTarget.mOwner == constraintWidget.getParent())) {
                    invalidate(constraintWidgetContainer, constraintWidget, constraintWidgetGroup);
                }
            }
            if (!(constraintWidget.mLeft.mTarget == null || constraintWidget.mRight.mTarget == null)) {
                verticalDimensionBehaviour = constraintWidgetContainer.getHorizontalDimensionBehaviour();
                dimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
                if (z) {
                    invalidate(constraintWidgetContainer, constraintWidget, constraintWidgetGroup);
                    return false;
                } else if (!(constraintWidget.mLeft.mTarget.mOwner == constraintWidget.getParent() && constraintWidget.mRight.mTarget.mOwner == constraintWidget.getParent())) {
                    invalidate(constraintWidgetContainer, constraintWidget, constraintWidgetGroup);
                }
            }
            if (((constraintWidget.getHorizontalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT ? 1 : 0) ^ (constraintWidget.getVerticalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT ? 1 : 0)) != 0 && constraintWidget.mDimensionRatio != 0.0f) {
                resolveDimensionRatio(constraintWidget);
            } else if (constraintWidget.getHorizontalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.getVerticalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT) {
                invalidate(constraintWidgetContainer, constraintWidget, constraintWidgetGroup);
                if (z) {
                    return false;
                }
            }
            if (((constraintWidget.mLeft.mTarget == null && constraintWidget.mRight.mTarget == null) || ((constraintWidget.mLeft.mTarget != null && constraintWidget.mLeft.mTarget.mOwner == constraintWidget.mParent && constraintWidget.mRight.mTarget == null) || ((constraintWidget.mRight.mTarget != null && constraintWidget.mRight.mTarget.mOwner == constraintWidget.mParent && constraintWidget.mLeft.mTarget == null) || (constraintWidget.mLeft.mTarget != null && constraintWidget.mLeft.mTarget.mOwner == constraintWidget.mParent && constraintWidget.mRight.mTarget != null && constraintWidget.mRight.mTarget.mOwner == constraintWidget.mParent)))) && constraintWidget.mCenter.mTarget == null && !(constraintWidget instanceof Guideline) && !(constraintWidget instanceof Helper)) {
                constraintWidgetGroup.mStartHorizontalWidgets.add(constraintWidget);
            }
            if (((constraintWidget.mTop.mTarget == null && constraintWidget.mBottom.mTarget == null) || ((constraintWidget.mTop.mTarget != null && constraintWidget.mTop.mTarget.mOwner == constraintWidget.mParent && constraintWidget.mBottom.mTarget == null) || ((constraintWidget.mBottom.mTarget != null && constraintWidget.mBottom.mTarget.mOwner == constraintWidget.mParent && constraintWidget.mTop.mTarget == null) || (constraintWidget.mTop.mTarget != null && constraintWidget.mTop.mTarget.mOwner == constraintWidget.mParent && constraintWidget.mBottom.mTarget != null && constraintWidget.mBottom.mTarget.mOwner == constraintWidget.mParent)))) && constraintWidget.mCenter.mTarget == null && constraintWidget.mBaseline.mTarget == null && !(constraintWidget instanceof Guideline) && !(constraintWidget instanceof Helper)) {
                constraintWidgetGroup.mStartVerticalWidgets.add(constraintWidget);
            }
            if (constraintWidget instanceof Helper) {
                invalidate(constraintWidgetContainer, constraintWidget, constraintWidgetGroup);
                if (z) {
                    return false;
                }
                Helper helper = (Helper) constraintWidget;
                for (i = 0; i < helper.mWidgetsCount; i++) {
                    if (!traverse(helper.mWidgets[i], constraintWidgetGroup, list, z)) {
                        return false;
                    }
                }
            }
            for (ConstraintAnchor constraintAnchor : constraintWidget.mListAnchors) {
                if (!(constraintAnchor.mTarget == null || constraintAnchor.mTarget.mOwner == constraintWidget.getParent())) {
                    if (constraintAnchor.mType == Type.CENTER) {
                        invalidate(constraintWidgetContainer, constraintWidget, constraintWidgetGroup);
                        if (z) {
                            return false;
                        }
                    }
                    setConnection(constraintAnchor);
                    if (!traverse(constraintAnchor.mTarget.mOwner, constraintWidgetGroup, list, z)) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (constraintWidget.mBelongingGroup != constraintWidgetGroup) {
            constraintWidgetGroup.mConstrainedGroup.addAll(constraintWidget.mBelongingGroup.mConstrainedGroup);
            constraintWidgetGroup.mStartHorizontalWidgets.addAll(constraintWidget.mBelongingGroup.mStartHorizontalWidgets);
            constraintWidgetGroup.mStartVerticalWidgets.addAll(constraintWidget.mBelongingGroup.mStartVerticalWidgets);
            if (!constraintWidget.mBelongingGroup.mSkipSolver) {
                constraintWidgetGroup.mSkipSolver = false;
            }
            list.remove(constraintWidget.mBelongingGroup);
            for (ConstraintWidget constraintWidget2 : constraintWidget.mBelongingGroup.mConstrainedGroup) {
                constraintWidget2.mBelongingGroup = constraintWidgetGroup;
            }
        }
        return true;
    }

    private static void updateSizeDependentWidgets(ConstraintWidget constraintWidget, int i, int i2) {
        int i3 = i * 2;
        ConstraintAnchor constraintAnchor = constraintWidget.mListAnchors[i3];
        ConstraintAnchor constraintAnchor2 = constraintWidget.mListAnchors[i3 + 1];
        int i4 = (constraintAnchor.mTarget == null || constraintAnchor2.mTarget == null) ? 0 : 1;
        if (i4 != 0) {
            Optimizer.setOptimizedWidget(constraintWidget, i, getParentBiasOffset(constraintWidget, i) + constraintAnchor.getMargin());
        } else if (constraintWidget.mDimensionRatio == 0.0f || constraintWidget.getDimensionBehaviour(i) != DimensionBehaviour.MATCH_CONSTRAINT) {
            i2 -= constraintWidget.getRelativePositioning(i);
            i3 = i2 - constraintWidget.getLength(i);
            constraintWidget.setFrame(i3, i2, i);
            Optimizer.setOptimizedWidget(constraintWidget, i, i3);
        } else {
            i2 = resolveDimensionRatio(constraintWidget);
            i3 = (int) constraintWidget.mListAnchors[i3].getResolutionNode().resolvedOffset;
            i4 = i3 + i2;
            constraintAnchor2.getResolutionNode().resolvedTarget = constraintAnchor.getResolutionNode();
            constraintAnchor2.getResolutionNode().resolvedOffset = (float) i2;
            constraintAnchor2.getResolutionNode().state = 1;
            constraintWidget.setFrame(i3, i4, i);
        }
    }
}
