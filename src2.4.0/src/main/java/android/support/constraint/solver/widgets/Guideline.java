package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintAnchor.Type;
import android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour;
import java.util.ArrayList;

public class Guideline extends ConstraintWidget {
    public static final int HORIZONTAL = 0;
    public static final int RELATIVE_BEGIN = 1;
    public static final int RELATIVE_END = 2;
    public static final int RELATIVE_PERCENT = 0;
    public static final int RELATIVE_UNKNWON = -1;
    public static final int VERTICAL = 1;
    private ConstraintAnchor mAnchor = this.mTop;
    private Rectangle mHead;
    private int mHeadSize;
    private boolean mIsPositionRelaxed;
    private int mMinimumPosition;
    private int mOrientation;
    protected int mRelativeBegin = -1;
    protected int mRelativeEnd = -1;
    protected float mRelativePercent = -1.0f;

    public Guideline() {
        int i = 0;
        this.mOrientation = 0;
        this.mIsPositionRelaxed = false;
        this.mMinimumPosition = 0;
        this.mHead = new Rectangle();
        this.mHeadSize = 8;
        this.mAnchors.clear();
        this.mAnchors.add(this.mAnchor);
        int length = this.mListAnchors.length;
        while (i < length) {
            this.mListAnchors[i] = this.mAnchor;
            i++;
        }
    }

    public void addToSolver(LinearSystem linearSystem) {
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) getParent();
        if (constraintWidgetContainer != null) {
            Object anchor = constraintWidgetContainer.getAnchor(Type.LEFT);
            Object anchor2 = constraintWidgetContainer.getAnchor(Type.RIGHT);
            int i = (this.mParent == null || this.mParent.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT) ? 0 : 1;
            if (this.mOrientation == 0) {
                anchor = constraintWidgetContainer.getAnchor(Type.TOP);
                anchor2 = constraintWidgetContainer.getAnchor(Type.BOTTOM);
                i = (this.mParent == null || this.mParent.mListDimensionBehaviors[1] != DimensionBehaviour.WRAP_CONTENT) ? 0 : 1;
            }
            SolverVariable createObjectVariable;
            if (this.mRelativeBegin != -1) {
                createObjectVariable = linearSystem.createObjectVariable(this.mAnchor);
                linearSystem.addEquality(createObjectVariable, linearSystem.createObjectVariable(anchor), this.mRelativeBegin, 6);
                if (i != 0) {
                    linearSystem.addGreaterThan(linearSystem.createObjectVariable(anchor2), createObjectVariable, 0, 5);
                }
            } else if (this.mRelativeEnd != -1) {
                createObjectVariable = linearSystem.createObjectVariable(this.mAnchor);
                SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(anchor2);
                linearSystem.addEquality(createObjectVariable, createObjectVariable2, -this.mRelativeEnd, 6);
                if (i != 0) {
                    linearSystem.addGreaterThan(createObjectVariable, linearSystem.createObjectVariable(anchor), 0, 5);
                    linearSystem.addGreaterThan(createObjectVariable2, createObjectVariable, 0, 5);
                }
            } else if (this.mRelativePercent != -1.0f) {
                linearSystem.addConstraint(LinearSystem.createRowDimensionPercent(linearSystem, linearSystem.createObjectVariable(this.mAnchor), linearSystem.createObjectVariable(anchor), linearSystem.createObjectVariable(anchor2), this.mRelativePercent, this.mIsPositionRelaxed));
            }
        }
    }

    public boolean allowedInBarrier() {
        return true;
    }

    public void analyze(int i) {
        ConstraintWidget parent = getParent();
        if (parent != null) {
            int i2;
            if (getOrientation() == 1) {
                this.mTop.getResolutionNode().dependsOn(1, parent.mTop.getResolutionNode(), 0);
                this.mBottom.getResolutionNode().dependsOn(1, parent.mTop.getResolutionNode(), 0);
                if (this.mRelativeBegin != -1) {
                    this.mLeft.getResolutionNode().dependsOn(1, parent.mLeft.getResolutionNode(), this.mRelativeBegin);
                    this.mRight.getResolutionNode().dependsOn(1, parent.mLeft.getResolutionNode(), this.mRelativeBegin);
                } else if (this.mRelativeEnd != -1) {
                    this.mLeft.getResolutionNode().dependsOn(1, parent.mRight.getResolutionNode(), -this.mRelativeEnd);
                    this.mRight.getResolutionNode().dependsOn(1, parent.mRight.getResolutionNode(), -this.mRelativeEnd);
                } else if (this.mRelativePercent != -1.0f && parent.getHorizontalDimensionBehaviour() == DimensionBehaviour.FIXED) {
                    i2 = (int) (((float) parent.mWidth) * this.mRelativePercent);
                    this.mLeft.getResolutionNode().dependsOn(1, parent.mLeft.getResolutionNode(), i2);
                    this.mRight.getResolutionNode().dependsOn(1, parent.mLeft.getResolutionNode(), i2);
                }
            } else {
                this.mLeft.getResolutionNode().dependsOn(1, parent.mLeft.getResolutionNode(), 0);
                this.mRight.getResolutionNode().dependsOn(1, parent.mLeft.getResolutionNode(), 0);
                if (this.mRelativeBegin != -1) {
                    this.mTop.getResolutionNode().dependsOn(1, parent.mTop.getResolutionNode(), this.mRelativeBegin);
                    this.mBottom.getResolutionNode().dependsOn(1, parent.mTop.getResolutionNode(), this.mRelativeBegin);
                } else if (this.mRelativeEnd != -1) {
                    this.mTop.getResolutionNode().dependsOn(1, parent.mBottom.getResolutionNode(), -this.mRelativeEnd);
                    this.mBottom.getResolutionNode().dependsOn(1, parent.mBottom.getResolutionNode(), -this.mRelativeEnd);
                } else if (this.mRelativePercent != -1.0f && parent.getVerticalDimensionBehaviour() == DimensionBehaviour.FIXED) {
                    i2 = (int) (((float) parent.mHeight) * this.mRelativePercent);
                    this.mTop.getResolutionNode().dependsOn(1, parent.mTop.getResolutionNode(), i2);
                    this.mBottom.getResolutionNode().dependsOn(1, parent.mTop.getResolutionNode(), i2);
                }
            }
        }
    }

    public void cyclePosition() {
        if (this.mRelativeBegin != -1) {
            inferRelativePercentPosition();
        } else if (this.mRelativePercent != -1.0f) {
            inferRelativeEndPosition();
        } else if (this.mRelativeEnd != -1) {
            inferRelativeBeginPosition();
        }
    }

    public ConstraintAnchor getAnchor() {
        return this.mAnchor;
    }

    public ConstraintAnchor getAnchor(Type type) {
        switch (type) {
            case LEFT:
            case RIGHT:
                if (this.mOrientation == 1) {
                    return this.mAnchor;
                }
                break;
            case TOP:
            case BOTTOM:
                if (this.mOrientation == 0) {
                    return this.mAnchor;
                }
                break;
            case BASELINE:
            case CENTER:
            case CENTER_X:
            case CENTER_Y:
            case NONE:
                return null;
        }
        throw new AssertionError(type.name());
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public Rectangle getHead() {
        this.mHead.setBounds(getDrawX() - this.mHeadSize, getDrawY() - (this.mHeadSize * 2), this.mHeadSize * 2, this.mHeadSize * 2);
        if (getOrientation() == 0) {
            this.mHead.setBounds(getDrawX() - (this.mHeadSize * 2), getDrawY() - this.mHeadSize, this.mHeadSize * 2, 2 * this.mHeadSize);
        }
        return this.mHead;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getRelativeBegin() {
        return this.mRelativeBegin;
    }

    public int getRelativeBehaviour() {
        return this.mRelativePercent != -1.0f ? 0 : this.mRelativeBegin != -1 ? 1 : this.mRelativeEnd != -1 ? 2 : -1;
    }

    public int getRelativeEnd() {
        return this.mRelativeEnd;
    }

    public float getRelativePercent() {
        return this.mRelativePercent;
    }

    public String getType() {
        return "Guideline";
    }

    /* Access modifiers changed, original: 0000 */
    public void inferRelativeBeginPosition() {
        int x = getX();
        if (this.mOrientation == 0) {
            x = getY();
        }
        setGuideBegin(x);
    }

    /* Access modifiers changed, original: 0000 */
    public void inferRelativeEndPosition() {
        int width = getParent().getWidth() - getX();
        if (this.mOrientation == 0) {
            width = getParent().getHeight() - getY();
        }
        setGuideEnd(width);
    }

    /* Access modifiers changed, original: 0000 */
    public void inferRelativePercentPosition() {
        float x = ((float) getX()) / ((float) getParent().getWidth());
        if (this.mOrientation == 0) {
            x = ((float) getY()) / ((float) getParent().getHeight());
        }
        setGuidePercent(x);
    }

    public void setDrawOrigin(int i, int i2) {
        if (this.mOrientation == 1) {
            i -= this.mOffsetX;
            if (this.mRelativeBegin != -1) {
                setGuideBegin(i);
                return;
            } else if (this.mRelativeEnd != -1) {
                setGuideEnd(getParent().getWidth() - i);
                return;
            } else if (this.mRelativePercent != -1.0f) {
                setGuidePercent(((float) i) / ((float) getParent().getWidth()));
                return;
            } else {
                return;
            }
        }
        i2 -= this.mOffsetY;
        if (this.mRelativeBegin != -1) {
            setGuideBegin(i2);
        } else if (this.mRelativeEnd != -1) {
            setGuideEnd(getParent().getHeight() - i2);
        } else if (this.mRelativePercent != -1.0f) {
            setGuidePercent(((float) i2) / ((float) getParent().getHeight()));
        }
    }

    public void setGuideBegin(int i) {
        if (i > -1) {
            this.mRelativePercent = -1.0f;
            this.mRelativeBegin = i;
            this.mRelativeEnd = -1;
        }
    }

    public void setGuideEnd(int i) {
        if (i > -1) {
            this.mRelativePercent = -1.0f;
            this.mRelativeBegin = -1;
            this.mRelativeEnd = i;
        }
    }

    public void setGuidePercent(float f) {
        if (f > -1.0f) {
            this.mRelativePercent = f;
            this.mRelativeBegin = -1;
            this.mRelativeEnd = -1;
        }
    }

    public void setGuidePercent(int i) {
        setGuidePercent(((float) i) / 100.0f);
    }

    public void setMinimumPosition(int i) {
        this.mMinimumPosition = i;
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            this.mAnchors.clear();
            if (this.mOrientation == 1) {
                this.mAnchor = this.mLeft;
            } else {
                this.mAnchor = this.mTop;
            }
            this.mAnchors.add(this.mAnchor);
            i = this.mListAnchors.length;
            for (int i2 = 0; i2 < i; i2++) {
                this.mListAnchors[i2] = this.mAnchor;
            }
        }
    }

    public void setPositionRelaxed(boolean z) {
        if (this.mIsPositionRelaxed != z) {
            this.mIsPositionRelaxed = z;
        }
    }

    public void updateFromSolver(LinearSystem linearSystem) {
        if (getParent() != null) {
            int objectVariableValue = linearSystem.getObjectVariableValue(this.mAnchor);
            if (this.mOrientation == 1) {
                setX(objectVariableValue);
                setY(0);
                setHeight(getParent().getHeight());
                setWidth(0);
            } else {
                setX(0);
                setY(objectVariableValue);
                setWidth(getParent().getWidth());
                setHeight(0);
            }
        }
    }
}
