package android.support.constraint;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.support.constraint.solver.Metrics;
import android.support.constraint.solver.widgets.ConstraintAnchor.Strength;
import android.support.constraint.solver.widgets.ConstraintAnchor.Type;
import android.support.constraint.solver.widgets.ConstraintWidget;
import android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour;
import android.support.constraint.solver.widgets.ConstraintWidgetContainer;
import android.support.constraint.solver.widgets.Guideline;
import android.support.v4.internal.view.SupportMenu;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import cn.jiguang.net.HttpUtils;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout extends ViewGroup {
    static final boolean ALLOWS_EMBEDDED = false;
    private static final boolean CACHE_MEASURED_DIMENSION = false;
    private static final boolean DEBUG = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-1.1.3";
    SparseArray<View> mChildrenByIds = new SparseArray();
    private ArrayList<ConstraintHelper> mConstraintHelpers = new ArrayList(4);
    private ConstraintSet mConstraintSet = null;
    private int mConstraintSetId = -1;
    private HashMap<String, Integer> mDesignIds = new HashMap();
    private boolean mDirtyHierarchy = true;
    private int mLastMeasureHeight = -1;
    int mLastMeasureHeightMode = 0;
    int mLastMeasureHeightSize = -1;
    private int mLastMeasureWidth = -1;
    int mLastMeasureWidthMode = 0;
    int mLastMeasureWidthSize = -1;
    ConstraintWidgetContainer mLayoutWidget = new ConstraintWidgetContainer();
    private int mMaxHeight = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int mMaxWidth = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private Metrics mMetrics;
    private int mMinHeight = 0;
    private int mMinWidth = 0;
    private int mOptimizationLevel = 7;
    private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList(100);

    public static class LayoutParams extends MarginLayoutParams {
        public static final int BASELINE = 5;
        public static final int BOTTOM = 4;
        public static final int CHAIN_PACKED = 2;
        public static final int CHAIN_SPREAD = 0;
        public static final int CHAIN_SPREAD_INSIDE = 1;
        public static final int END = 7;
        public static final int HORIZONTAL = 0;
        public static final int LEFT = 1;
        public static final int MATCH_CONSTRAINT = 0;
        public static final int MATCH_CONSTRAINT_PERCENT = 2;
        public static final int MATCH_CONSTRAINT_SPREAD = 0;
        public static final int MATCH_CONSTRAINT_WRAP = 1;
        public static final int PARENT_ID = 0;
        public static final int RIGHT = 2;
        public static final int START = 6;
        public static final int TOP = 3;
        public static final int UNSET = -1;
        public static final int VERTICAL = 1;
        public int baselineToBaseline = -1;
        public int bottomToBottom = -1;
        public int bottomToTop = -1;
        public float circleAngle = 0.0f;
        public int circleConstraint = -1;
        public int circleRadius = 0;
        public boolean constrainedHeight = false;
        public boolean constrainedWidth = false;
        public String dimensionRatio = null;
        int dimensionRatioSide = 1;
        float dimensionRatioValue = 0.0f;
        public int editorAbsoluteX = -1;
        public int editorAbsoluteY = -1;
        public int endToEnd = -1;
        public int endToStart = -1;
        public int goneBottomMargin = -1;
        public int goneEndMargin = -1;
        public int goneLeftMargin = -1;
        public int goneRightMargin = -1;
        public int goneStartMargin = -1;
        public int goneTopMargin = -1;
        public int guideBegin = -1;
        public int guideEnd = -1;
        public float guidePercent = -1.0f;
        public boolean helped = false;
        public float horizontalBias = 0.5f;
        public int horizontalChainStyle = 0;
        boolean horizontalDimensionFixed = true;
        public float horizontalWeight = -1.0f;
        boolean isGuideline = false;
        boolean isHelper = false;
        boolean isInPlaceholder = false;
        public int leftToLeft = -1;
        public int leftToRight = -1;
        public int matchConstraintDefaultHeight = 0;
        public int matchConstraintDefaultWidth = 0;
        public int matchConstraintMaxHeight = 0;
        public int matchConstraintMaxWidth = 0;
        public int matchConstraintMinHeight = 0;
        public int matchConstraintMinWidth = 0;
        public float matchConstraintPercentHeight = 1.0f;
        public float matchConstraintPercentWidth = 1.0f;
        boolean needsBaseline = false;
        public int orientation = -1;
        int resolveGoneLeftMargin = -1;
        int resolveGoneRightMargin = -1;
        int resolvedGuideBegin;
        int resolvedGuideEnd;
        float resolvedGuidePercent;
        float resolvedHorizontalBias = 0.5f;
        int resolvedLeftToLeft = -1;
        int resolvedLeftToRight = -1;
        int resolvedRightToLeft = -1;
        int resolvedRightToRight = -1;
        public int rightToLeft = -1;
        public int rightToRight = -1;
        public int startToEnd = -1;
        public int startToStart = -1;
        public int topToBottom = -1;
        public int topToTop = -1;
        public float verticalBias = 0.5f;
        public int verticalChainStyle = 0;
        boolean verticalDimensionFixed = true;
        public float verticalWeight = -1.0f;
        ConstraintWidget widget = new ConstraintWidget();

        private static class Table {
            public static final int ANDROID_ORIENTATION = 1;
            public static final int LAYOUT_CONSTRAINED_HEIGHT = 28;
            public static final int LAYOUT_CONSTRAINED_WIDTH = 27;
            public static final int LAYOUT_CONSTRAINT_BASELINE_CREATOR = 43;
            public static final int LAYOUT_CONSTRAINT_BASELINE_TO_BASELINE_OF = 16;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_CREATOR = 42;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_BOTTOM_OF = 15;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF = 14;
            public static final int LAYOUT_CONSTRAINT_CIRCLE = 2;
            public static final int LAYOUT_CONSTRAINT_CIRCLE_ANGLE = 4;
            public static final int LAYOUT_CONSTRAINT_CIRCLE_RADIUS = 3;
            public static final int LAYOUT_CONSTRAINT_DIMENSION_RATIO = 44;
            public static final int LAYOUT_CONSTRAINT_END_TO_END_OF = 20;
            public static final int LAYOUT_CONSTRAINT_END_TO_START_OF = 19;
            public static final int LAYOUT_CONSTRAINT_GUIDE_BEGIN = 5;
            public static final int LAYOUT_CONSTRAINT_GUIDE_END = 6;
            public static final int LAYOUT_CONSTRAINT_GUIDE_PERCENT = 7;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_DEFAULT = 32;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_MAX = 37;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_MIN = 36;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_PERCENT = 38;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_BIAS = 29;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_CHAINSTYLE = 47;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_WEIGHT = 45;
            public static final int LAYOUT_CONSTRAINT_LEFT_CREATOR = 39;
            public static final int LAYOUT_CONSTRAINT_LEFT_TO_LEFT_OF = 8;
            public static final int LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF = 9;
            public static final int LAYOUT_CONSTRAINT_RIGHT_CREATOR = 41;
            public static final int LAYOUT_CONSTRAINT_RIGHT_TO_LEFT_OF = 10;
            public static final int LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF = 11;
            public static final int LAYOUT_CONSTRAINT_START_TO_END_OF = 17;
            public static final int LAYOUT_CONSTRAINT_START_TO_START_OF = 18;
            public static final int LAYOUT_CONSTRAINT_TOP_CREATOR = 40;
            public static final int LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF = 13;
            public static final int LAYOUT_CONSTRAINT_TOP_TO_TOP_OF = 12;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_BIAS = 30;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE = 48;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_WEIGHT = 46;
            public static final int LAYOUT_CONSTRAINT_WIDTH_DEFAULT = 31;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MAX = 34;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MIN = 33;
            public static final int LAYOUT_CONSTRAINT_WIDTH_PERCENT = 35;
            public static final int LAYOUT_EDITOR_ABSOLUTEX = 49;
            public static final int LAYOUT_EDITOR_ABSOLUTEY = 50;
            public static final int LAYOUT_GONE_MARGIN_BOTTOM = 24;
            public static final int LAYOUT_GONE_MARGIN_END = 26;
            public static final int LAYOUT_GONE_MARGIN_LEFT = 21;
            public static final int LAYOUT_GONE_MARGIN_RIGHT = 23;
            public static final int LAYOUT_GONE_MARGIN_START = 25;
            public static final int LAYOUT_GONE_MARGIN_TOP = 22;
            public static final int UNUSED = 0;
            public static final SparseIntArray map = new SparseIntArray();

            static {
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                map.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                map.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                map.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
            }

            private Table() {
            }
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (Table.map.get(index)) {
                    case 1:
                        this.orientation = obtainStyledAttributes.getInt(index, this.orientation);
                        break;
                    case 2:
                        this.circleConstraint = obtainStyledAttributes.getResourceId(index, this.circleConstraint);
                        if (this.circleConstraint != -1) {
                            break;
                        }
                        this.circleConstraint = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 3:
                        this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.circleRadius);
                        break;
                    case 4:
                        this.circleAngle = obtainStyledAttributes.getFloat(index, this.circleAngle) % 360.0f;
                        if (this.circleAngle >= 0.0f) {
                            break;
                        }
                        this.circleAngle = (360.0f - this.circleAngle) % 360.0f;
                        break;
                    case 5:
                        this.guideBegin = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideBegin);
                        break;
                    case 6:
                        this.guideEnd = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideEnd);
                        break;
                    case 7:
                        this.guidePercent = obtainStyledAttributes.getFloat(index, this.guidePercent);
                        break;
                    case 8:
                        this.leftToLeft = obtainStyledAttributes.getResourceId(index, this.leftToLeft);
                        if (this.leftToLeft != -1) {
                            break;
                        }
                        this.leftToLeft = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 9:
                        this.leftToRight = obtainStyledAttributes.getResourceId(index, this.leftToRight);
                        if (this.leftToRight != -1) {
                            break;
                        }
                        this.leftToRight = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 10:
                        this.rightToLeft = obtainStyledAttributes.getResourceId(index, this.rightToLeft);
                        if (this.rightToLeft != -1) {
                            break;
                        }
                        this.rightToLeft = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 11:
                        this.rightToRight = obtainStyledAttributes.getResourceId(index, this.rightToRight);
                        if (this.rightToRight != -1) {
                            break;
                        }
                        this.rightToRight = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 12:
                        this.topToTop = obtainStyledAttributes.getResourceId(index, this.topToTop);
                        if (this.topToTop != -1) {
                            break;
                        }
                        this.topToTop = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 13:
                        this.topToBottom = obtainStyledAttributes.getResourceId(index, this.topToBottom);
                        if (this.topToBottom != -1) {
                            break;
                        }
                        this.topToBottom = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 14:
                        this.bottomToTop = obtainStyledAttributes.getResourceId(index, this.bottomToTop);
                        if (this.bottomToTop != -1) {
                            break;
                        }
                        this.bottomToTop = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 15:
                        this.bottomToBottom = obtainStyledAttributes.getResourceId(index, this.bottomToBottom);
                        if (this.bottomToBottom != -1) {
                            break;
                        }
                        this.bottomToBottom = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 16:
                        this.baselineToBaseline = obtainStyledAttributes.getResourceId(index, this.baselineToBaseline);
                        if (this.baselineToBaseline != -1) {
                            break;
                        }
                        this.baselineToBaseline = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 17:
                        this.startToEnd = obtainStyledAttributes.getResourceId(index, this.startToEnd);
                        if (this.startToEnd != -1) {
                            break;
                        }
                        this.startToEnd = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 18:
                        this.startToStart = obtainStyledAttributes.getResourceId(index, this.startToStart);
                        if (this.startToStart != -1) {
                            break;
                        }
                        this.startToStart = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 19:
                        this.endToStart = obtainStyledAttributes.getResourceId(index, this.endToStart);
                        if (this.endToStart != -1) {
                            break;
                        }
                        this.endToStart = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 20:
                        this.endToEnd = obtainStyledAttributes.getResourceId(index, this.endToEnd);
                        if (this.endToEnd != -1) {
                            break;
                        }
                        this.endToEnd = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 21:
                        this.goneLeftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneLeftMargin);
                        break;
                    case 22:
                        this.goneTopMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneTopMargin);
                        break;
                    case 23:
                        this.goneRightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneRightMargin);
                        break;
                    case 24:
                        this.goneBottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBottomMargin);
                        break;
                    case 25:
                        this.goneStartMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneStartMargin);
                        break;
                    case 26:
                        this.goneEndMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneEndMargin);
                        break;
                    case 27:
                        this.constrainedWidth = obtainStyledAttributes.getBoolean(index, this.constrainedWidth);
                        break;
                    case 28:
                        this.constrainedHeight = obtainStyledAttributes.getBoolean(index, this.constrainedHeight);
                        break;
                    case 29:
                        this.horizontalBias = obtainStyledAttributes.getFloat(index, this.horizontalBias);
                        break;
                    case 30:
                        this.verticalBias = obtainStyledAttributes.getFloat(index, this.verticalBias);
                        break;
                    case 31:
                        this.matchConstraintDefaultWidth = obtainStyledAttributes.getInt(index, 0);
                        if (this.matchConstraintDefaultWidth != 1) {
                            break;
                        }
                        Log.e(ConstraintLayout.TAG, "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                        break;
                    case 32:
                        this.matchConstraintDefaultHeight = obtainStyledAttributes.getInt(index, 0);
                        if (this.matchConstraintDefaultHeight != 1) {
                            break;
                        }
                        Log.e(ConstraintLayout.TAG, "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                        break;
                    case 33:
                        try {
                            this.matchConstraintMinWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMinWidth);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMinWidth) != -2) {
                                break;
                            }
                            this.matchConstraintMinWidth = -2;
                            break;
                        }
                    case 34:
                        try {
                            this.matchConstraintMaxWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMaxWidth);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMaxWidth) != -2) {
                                break;
                            }
                            this.matchConstraintMaxWidth = -2;
                            break;
                        }
                    case 35:
                        this.matchConstraintPercentWidth = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.matchConstraintPercentWidth));
                        break;
                    case 36:
                        try {
                            this.matchConstraintMinHeight = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMinHeight);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMinHeight) != -2) {
                                break;
                            }
                            this.matchConstraintMinHeight = -2;
                            break;
                        }
                    case 37:
                        try {
                            this.matchConstraintMaxHeight = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMaxHeight);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMaxHeight) != -2) {
                                break;
                            }
                            this.matchConstraintMaxHeight = -2;
                            break;
                        }
                    case 38:
                        this.matchConstraintPercentHeight = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.matchConstraintPercentHeight));
                        break;
                    case 44:
                        this.dimensionRatio = obtainStyledAttributes.getString(index);
                        this.dimensionRatioValue = Float.NaN;
                        this.dimensionRatioSide = -1;
                        if (this.dimensionRatio == null) {
                            break;
                        }
                        index = this.dimensionRatio.length();
                        int indexOf = this.dimensionRatio.indexOf(44);
                        if (indexOf <= 0 || indexOf >= index - 1) {
                            indexOf = 0;
                        } else {
                            String substring = this.dimensionRatio.substring(0, indexOf);
                            if (substring.equalsIgnoreCase("W")) {
                                this.dimensionRatioSide = 0;
                            } else if (substring.equalsIgnoreCase("H")) {
                                this.dimensionRatioSide = 1;
                            }
                            indexOf++;
                        }
                        int indexOf2 = this.dimensionRatio.indexOf(58);
                        String substring2;
                        if (indexOf2 >= 0 && indexOf2 < index - 1) {
                            substring2 = this.dimensionRatio.substring(indexOf, indexOf2);
                            String substring3 = this.dimensionRatio.substring(indexOf2 + 1);
                            if (substring2.length() > 0 && substring3.length() > 0) {
                                try {
                                    float parseFloat = Float.parseFloat(substring2);
                                    float parseFloat2 = Float.parseFloat(substring3);
                                    if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                        if (this.dimensionRatioSide != 1) {
                                            this.dimensionRatioValue = Math.abs(parseFloat / parseFloat2);
                                            break;
                                        } else {
                                            this.dimensionRatioValue = Math.abs(parseFloat2 / parseFloat);
                                            break;
                                        }
                                    }
                                } catch (NumberFormatException unused5) {
                                    break;
                                }
                            }
                        }
                        substring2 = this.dimensionRatio.substring(indexOf);
                        if (substring2.length() <= 0) {
                            break;
                        }
                        this.dimensionRatioValue = Float.parseFloat(substring2);
                        break;
                        break;
                    case 45:
                        this.horizontalWeight = obtainStyledAttributes.getFloat(index, this.horizontalWeight);
                        break;
                    case 46:
                        this.verticalWeight = obtainStyledAttributes.getFloat(index, this.verticalWeight);
                        break;
                    case 47:
                        this.horizontalChainStyle = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 48:
                        this.verticalChainStyle = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 49:
                        this.editorAbsoluteX = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteX);
                        break;
                    case 50:
                        this.editorAbsoluteY = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteY);
                        break;
                    default:
                        break;
                }
            }
            obtainStyledAttributes.recycle();
            validate();
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.guideBegin = layoutParams.guideBegin;
            this.guideEnd = layoutParams.guideEnd;
            this.guidePercent = layoutParams.guidePercent;
            this.leftToLeft = layoutParams.leftToLeft;
            this.leftToRight = layoutParams.leftToRight;
            this.rightToLeft = layoutParams.rightToLeft;
            this.rightToRight = layoutParams.rightToRight;
            this.topToTop = layoutParams.topToTop;
            this.topToBottom = layoutParams.topToBottom;
            this.bottomToTop = layoutParams.bottomToTop;
            this.bottomToBottom = layoutParams.bottomToBottom;
            this.baselineToBaseline = layoutParams.baselineToBaseline;
            this.circleConstraint = layoutParams.circleConstraint;
            this.circleRadius = layoutParams.circleRadius;
            this.circleAngle = layoutParams.circleAngle;
            this.startToEnd = layoutParams.startToEnd;
            this.startToStart = layoutParams.startToStart;
            this.endToStart = layoutParams.endToStart;
            this.endToEnd = layoutParams.endToEnd;
            this.goneLeftMargin = layoutParams.goneLeftMargin;
            this.goneTopMargin = layoutParams.goneTopMargin;
            this.goneRightMargin = layoutParams.goneRightMargin;
            this.goneBottomMargin = layoutParams.goneBottomMargin;
            this.goneStartMargin = layoutParams.goneStartMargin;
            this.goneEndMargin = layoutParams.goneEndMargin;
            this.horizontalBias = layoutParams.horizontalBias;
            this.verticalBias = layoutParams.verticalBias;
            this.dimensionRatio = layoutParams.dimensionRatio;
            this.dimensionRatioValue = layoutParams.dimensionRatioValue;
            this.dimensionRatioSide = layoutParams.dimensionRatioSide;
            this.horizontalWeight = layoutParams.horizontalWeight;
            this.verticalWeight = layoutParams.verticalWeight;
            this.horizontalChainStyle = layoutParams.horizontalChainStyle;
            this.verticalChainStyle = layoutParams.verticalChainStyle;
            this.constrainedWidth = layoutParams.constrainedWidth;
            this.constrainedHeight = layoutParams.constrainedHeight;
            this.matchConstraintDefaultWidth = layoutParams.matchConstraintDefaultWidth;
            this.matchConstraintDefaultHeight = layoutParams.matchConstraintDefaultHeight;
            this.matchConstraintMinWidth = layoutParams.matchConstraintMinWidth;
            this.matchConstraintMaxWidth = layoutParams.matchConstraintMaxWidth;
            this.matchConstraintMinHeight = layoutParams.matchConstraintMinHeight;
            this.matchConstraintMaxHeight = layoutParams.matchConstraintMaxHeight;
            this.matchConstraintPercentWidth = layoutParams.matchConstraintPercentWidth;
            this.matchConstraintPercentHeight = layoutParams.matchConstraintPercentHeight;
            this.editorAbsoluteX = layoutParams.editorAbsoluteX;
            this.editorAbsoluteY = layoutParams.editorAbsoluteY;
            this.orientation = layoutParams.orientation;
            this.horizontalDimensionFixed = layoutParams.horizontalDimensionFixed;
            this.verticalDimensionFixed = layoutParams.verticalDimensionFixed;
            this.needsBaseline = layoutParams.needsBaseline;
            this.isGuideline = layoutParams.isGuideline;
            this.resolvedLeftToLeft = layoutParams.resolvedLeftToLeft;
            this.resolvedLeftToRight = layoutParams.resolvedLeftToRight;
            this.resolvedRightToLeft = layoutParams.resolvedRightToLeft;
            this.resolvedRightToRight = layoutParams.resolvedRightToRight;
            this.resolveGoneLeftMargin = layoutParams.resolveGoneLeftMargin;
            this.resolveGoneRightMargin = layoutParams.resolveGoneRightMargin;
            this.resolvedHorizontalBias = layoutParams.resolvedHorizontalBias;
            this.widget = layoutParams.widget;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public void reset() {
            if (this.widget != null) {
                this.widget.reset();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0050  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0059  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0062  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x006a  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0072  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0092  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0088  */
        @android.annotation.TargetApi(17)
        public void resolveLayoutDirection(int r6) {
            /*
            r5 = this;
            r0 = r5.leftMargin;
            r1 = r5.rightMargin;
            super.resolveLayoutDirection(r6);
            r6 = -1;
            r5.resolvedRightToLeft = r6;
            r5.resolvedRightToRight = r6;
            r5.resolvedLeftToLeft = r6;
            r5.resolvedLeftToRight = r6;
            r5.resolveGoneLeftMargin = r6;
            r5.resolveGoneRightMargin = r6;
            r2 = r5.goneLeftMargin;
            r5.resolveGoneLeftMargin = r2;
            r2 = r5.goneRightMargin;
            r5.resolveGoneRightMargin = r2;
            r2 = r5.horizontalBias;
            r5.resolvedHorizontalBias = r2;
            r2 = r5.guideBegin;
            r5.resolvedGuideBegin = r2;
            r2 = r5.guideEnd;
            r5.resolvedGuideEnd = r2;
            r2 = r5.guidePercent;
            r5.resolvedGuidePercent = r2;
            r2 = r5.getLayoutDirection();
            r3 = 0;
            r4 = 1;
            if (r4 != r2) goto L_0x0036;
        L_0x0034:
            r2 = r4;
            goto L_0x0037;
        L_0x0036:
            r2 = r3;
        L_0x0037:
            if (r2 == 0) goto L_0x00ac;
        L_0x0039:
            r2 = r5.startToEnd;
            if (r2 == r6) goto L_0x0043;
        L_0x003d:
            r2 = r5.startToEnd;
            r5.resolvedRightToLeft = r2;
        L_0x0041:
            r3 = r4;
            goto L_0x004c;
        L_0x0043:
            r2 = r5.startToStart;
            if (r2 == r6) goto L_0x004c;
        L_0x0047:
            r2 = r5.startToStart;
            r5.resolvedRightToRight = r2;
            goto L_0x0041;
        L_0x004c:
            r2 = r5.endToStart;
            if (r2 == r6) goto L_0x0055;
        L_0x0050:
            r2 = r5.endToStart;
            r5.resolvedLeftToRight = r2;
            r3 = r4;
        L_0x0055:
            r2 = r5.endToEnd;
            if (r2 == r6) goto L_0x005e;
        L_0x0059:
            r2 = r5.endToEnd;
            r5.resolvedLeftToLeft = r2;
            r3 = r4;
        L_0x005e:
            r2 = r5.goneStartMargin;
            if (r2 == r6) goto L_0x0066;
        L_0x0062:
            r2 = r5.goneStartMargin;
            r5.resolveGoneRightMargin = r2;
        L_0x0066:
            r2 = r5.goneEndMargin;
            if (r2 == r6) goto L_0x006e;
        L_0x006a:
            r2 = r5.goneEndMargin;
            r5.resolveGoneLeftMargin = r2;
        L_0x006e:
            r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
            if (r3 == 0) goto L_0x0078;
        L_0x0072:
            r3 = r5.horizontalBias;
            r3 = r2 - r3;
            r5.resolvedHorizontalBias = r3;
        L_0x0078:
            r3 = r5.isGuideline;
            if (r3 == 0) goto L_0x00dc;
        L_0x007c:
            r3 = r5.orientation;
            if (r3 != r4) goto L_0x00dc;
        L_0x0080:
            r3 = r5.guidePercent;
            r4 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
            r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1));
            if (r3 == 0) goto L_0x0092;
        L_0x0088:
            r3 = r5.guidePercent;
            r2 = r2 - r3;
            r5.resolvedGuidePercent = r2;
            r5.resolvedGuideBegin = r6;
            r5.resolvedGuideEnd = r6;
            goto L_0x00dc;
        L_0x0092:
            r2 = r5.guideBegin;
            if (r2 == r6) goto L_0x009f;
        L_0x0096:
            r2 = r5.guideBegin;
            r5.resolvedGuideEnd = r2;
            r5.resolvedGuideBegin = r6;
            r5.resolvedGuidePercent = r4;
            goto L_0x00dc;
        L_0x009f:
            r2 = r5.guideEnd;
            if (r2 == r6) goto L_0x00dc;
        L_0x00a3:
            r2 = r5.guideEnd;
            r5.resolvedGuideBegin = r2;
            r5.resolvedGuideEnd = r6;
            r5.resolvedGuidePercent = r4;
            goto L_0x00dc;
        L_0x00ac:
            r2 = r5.startToEnd;
            if (r2 == r6) goto L_0x00b4;
        L_0x00b0:
            r2 = r5.startToEnd;
            r5.resolvedLeftToRight = r2;
        L_0x00b4:
            r2 = r5.startToStart;
            if (r2 == r6) goto L_0x00bc;
        L_0x00b8:
            r2 = r5.startToStart;
            r5.resolvedLeftToLeft = r2;
        L_0x00bc:
            r2 = r5.endToStart;
            if (r2 == r6) goto L_0x00c4;
        L_0x00c0:
            r2 = r5.endToStart;
            r5.resolvedRightToLeft = r2;
        L_0x00c4:
            r2 = r5.endToEnd;
            if (r2 == r6) goto L_0x00cc;
        L_0x00c8:
            r2 = r5.endToEnd;
            r5.resolvedRightToRight = r2;
        L_0x00cc:
            r2 = r5.goneStartMargin;
            if (r2 == r6) goto L_0x00d4;
        L_0x00d0:
            r2 = r5.goneStartMargin;
            r5.resolveGoneLeftMargin = r2;
        L_0x00d4:
            r2 = r5.goneEndMargin;
            if (r2 == r6) goto L_0x00dc;
        L_0x00d8:
            r2 = r5.goneEndMargin;
            r5.resolveGoneRightMargin = r2;
        L_0x00dc:
            r2 = r5.endToStart;
            if (r2 != r6) goto L_0x012e;
        L_0x00e0:
            r2 = r5.endToEnd;
            if (r2 != r6) goto L_0x012e;
        L_0x00e4:
            r2 = r5.startToStart;
            if (r2 != r6) goto L_0x012e;
        L_0x00e8:
            r2 = r5.startToEnd;
            if (r2 != r6) goto L_0x012e;
        L_0x00ec:
            r2 = r5.rightToLeft;
            if (r2 == r6) goto L_0x00fd;
        L_0x00f0:
            r2 = r5.rightToLeft;
            r5.resolvedRightToLeft = r2;
            r2 = r5.rightMargin;
            if (r2 > 0) goto L_0x010d;
        L_0x00f8:
            if (r1 <= 0) goto L_0x010d;
        L_0x00fa:
            r5.rightMargin = r1;
            goto L_0x010d;
        L_0x00fd:
            r2 = r5.rightToRight;
            if (r2 == r6) goto L_0x010d;
        L_0x0101:
            r2 = r5.rightToRight;
            r5.resolvedRightToRight = r2;
            r2 = r5.rightMargin;
            if (r2 > 0) goto L_0x010d;
        L_0x0109:
            if (r1 <= 0) goto L_0x010d;
        L_0x010b:
            r5.rightMargin = r1;
        L_0x010d:
            r1 = r5.leftToLeft;
            if (r1 == r6) goto L_0x011e;
        L_0x0111:
            r6 = r5.leftToLeft;
            r5.resolvedLeftToLeft = r6;
            r6 = r5.leftMargin;
            if (r6 > 0) goto L_0x012e;
        L_0x0119:
            if (r0 <= 0) goto L_0x012e;
        L_0x011b:
            r5.leftMargin = r0;
            goto L_0x012e;
        L_0x011e:
            r1 = r5.leftToRight;
            if (r1 == r6) goto L_0x012e;
        L_0x0122:
            r6 = r5.leftToRight;
            r5.resolvedLeftToRight = r6;
            r6 = r5.leftMargin;
            if (r6 > 0) goto L_0x012e;
        L_0x012a:
            if (r0 <= 0) goto L_0x012e;
        L_0x012c:
            r5.leftMargin = r0;
        L_0x012e:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.ConstraintLayout$LayoutParams.resolveLayoutDirection(int):void");
        }

        public void validate() {
            this.isGuideline = false;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            if (this.width == -2 && this.constrainedWidth) {
                this.horizontalDimensionFixed = false;
                this.matchConstraintDefaultWidth = 1;
            }
            if (this.height == -2 && this.constrainedHeight) {
                this.verticalDimensionFixed = false;
                this.matchConstraintDefaultHeight = 1;
            }
            if (this.width == 0 || this.width == -1) {
                this.horizontalDimensionFixed = false;
                if (this.width == 0 && this.matchConstraintDefaultWidth == 1) {
                    this.width = -2;
                    this.constrainedWidth = true;
                }
            }
            if (this.height == 0 || this.height == -1) {
                this.verticalDimensionFixed = false;
                if (this.height == 0 && this.matchConstraintDefaultHeight == 1) {
                    this.height = -2;
                    this.constrainedHeight = true;
                }
            }
            if (this.guidePercent != -1.0f || this.guideBegin != -1 || this.guideEnd != -1) {
                this.isGuideline = true;
                this.horizontalDimensionFixed = true;
                this.verticalDimensionFixed = true;
                if (!(this.widget instanceof Guideline)) {
                    this.widget = new Guideline();
                }
                ((Guideline) this.widget).setOrientation(this.orientation);
            }
        }
    }

    public ConstraintLayout(Context context) {
        super(context);
        init(null);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    private final ConstraintWidget getTargetWidget(int i) {
        if (i == 0) {
            return this.mLayoutWidget;
        }
        View view = (View) this.mChildrenByIds.get(i);
        if (view == null) {
            view = findViewById(i);
            if (!(view == null || view == this || view.getParent() != this)) {
                onViewAdded(view);
            }
        }
        if (view == this) {
            return this.mLayoutWidget;
        }
        return view == null ? null : ((LayoutParams) view.getLayoutParams()).widget;
    }

    private void init(AttributeSet attributeSet) {
        this.mLayoutWidget.setCompanionWidget(this);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.mMinWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.mMinHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.mMaxWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.mOptimizationLevel = obtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                } else if (index == R.styleable.ConstraintLayout_Layout_constraintSet) {
                    index = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        this.mConstraintSet = new ConstraintSet();
                        this.mConstraintSet.load(getContext(), index);
                    } catch (NotFoundException unused) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = index;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
    }

    private void internalMeasureChildren(int i, int i2) {
        ConstraintLayout constraintLayout = this;
        int i3 = i;
        int i4 = i2;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = constraintLayout.getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                ConstraintWidget constraintWidget = layoutParams.widget;
                if (!(layoutParams.isGuideline || layoutParams.isHelper)) {
                    Object obj;
                    Object obj2;
                    constraintWidget.setVisibility(childAt.getVisibility());
                    int i6 = layoutParams.width;
                    int i7 = layoutParams.height;
                    Object obj3 = (layoutParams.horizontalDimensionFixed || layoutParams.verticalDimensionFixed || ((!layoutParams.horizontalDimensionFixed && layoutParams.matchConstraintDefaultWidth == 1) || layoutParams.width == -1 || (!layoutParams.verticalDimensionFixed && (layoutParams.matchConstraintDefaultHeight == 1 || layoutParams.height == -1)))) ? 1 : null;
                    if (obj3 != null) {
                        int childMeasureSpec;
                        int childMeasureSpec2;
                        if (i6 == 0) {
                            childMeasureSpec = getChildMeasureSpec(i3, paddingLeft, -2);
                            obj = 1;
                        } else if (i6 == -1) {
                            childMeasureSpec = getChildMeasureSpec(i3, paddingLeft, -1);
                            obj = null;
                        } else {
                            obj = i6 == -2 ? 1 : null;
                            childMeasureSpec = getChildMeasureSpec(i3, paddingLeft, i6);
                        }
                        if (i7 == 0) {
                            obj2 = 1;
                            childMeasureSpec2 = getChildMeasureSpec(i4, paddingTop, -2);
                        } else if (i7 == -1) {
                            childMeasureSpec2 = getChildMeasureSpec(i4, paddingTop, -1);
                            obj2 = null;
                        } else {
                            obj2 = i7 == -2 ? 1 : null;
                            childMeasureSpec2 = getChildMeasureSpec(i4, paddingTop, i7);
                        }
                        childAt.measure(childMeasureSpec, childMeasureSpec2);
                        if (constraintLayout.mMetrics != null) {
                            Metrics metrics = constraintLayout.mMetrics;
                            metrics.measures++;
                        }
                        constraintWidget.setWidthWrapContent(i6 == -2);
                        constraintWidget.setHeightWrapContent(i7 == -2);
                        i6 = childAt.getMeasuredWidth();
                        i7 = childAt.getMeasuredHeight();
                    } else {
                        obj = null;
                        obj2 = null;
                    }
                    constraintWidget.setWidth(i6);
                    constraintWidget.setHeight(i7);
                    if (obj != null) {
                        constraintWidget.setWrapWidth(i6);
                    }
                    if (obj2 != null) {
                        constraintWidget.setWrapHeight(i7);
                    }
                    if (layoutParams.needsBaseline) {
                        int baseline = childAt.getBaseline();
                        if (baseline != -1) {
                            constraintWidget.setBaselineDistance(baseline);
                        }
                    }
                }
            }
            i5++;
            constraintLayout = this;
            i3 = i;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:131:0x02b2  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02a5  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x02b9  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02c3  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x02c1  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x02d7  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02dc  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x02e9  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x02e1  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x02fa  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02f2  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0310  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0305  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02a5  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x02b2  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x02b9  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x02c1  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02c3  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x02d7  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02dc  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x02e1  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x02e9  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02f2  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x02fa  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0305  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0310  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x027e  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x02b2  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02a5  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x02b9  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02c3  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x02c1  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x02d7  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02dc  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x02e9  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x02e1  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x02fa  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02f2  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0310  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0305  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x027e  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02a5  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x02b2  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x02b9  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x02c1  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02c3  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x02d7  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02dc  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x02e1  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x02e9  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02f2  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x02fa  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0305  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0310  */
    private void internalMeasureDimensions(int r27, int r28) {
        /*
        r26 = this;
        r0 = r26;
        r1 = r27;
        r2 = r28;
        r3 = r26.getPaddingTop();
        r4 = r26.getPaddingBottom();
        r3 = r3 + r4;
        r4 = r26.getPaddingLeft();
        r5 = r26.getPaddingRight();
        r4 = r4 + r5;
        r5 = r26.getChildCount();
        r7 = 0;
    L_0x001d:
        r8 = 1;
        r10 = 8;
        r12 = -2;
        if (r7 >= r5) goto L_0x00f8;
    L_0x0024:
        r14 = r0.getChildAt(r7);
        r15 = r14.getVisibility();
        if (r15 != r10) goto L_0x0036;
    L_0x002e:
        r19 = r3;
        r20 = r4;
        r21 = r5;
        goto L_0x00ec;
    L_0x0036:
        r10 = r14.getLayoutParams();
        r10 = (android.support.constraint.ConstraintLayout.LayoutParams) r10;
        r15 = r10.widget;
        r6 = r10.isGuideline;
        if (r6 != 0) goto L_0x002e;
    L_0x0042:
        r6 = r10.isHelper;
        if (r6 == 0) goto L_0x0047;
    L_0x0046:
        goto L_0x002e;
    L_0x0047:
        r6 = r14.getVisibility();
        r15.setVisibility(r6);
        r6 = r10.width;
        r13 = r10.height;
        if (r6 == 0) goto L_0x00d8;
    L_0x0054:
        if (r13 != 0) goto L_0x0058;
    L_0x0056:
        goto L_0x00d8;
    L_0x0058:
        if (r6 != r12) goto L_0x005d;
    L_0x005a:
        r16 = 1;
        goto L_0x005f;
    L_0x005d:
        r16 = 0;
    L_0x005f:
        r11 = getChildMeasureSpec(r1, r4, r6);
        if (r13 != r12) goto L_0x0068;
    L_0x0065:
        r17 = 1;
        goto L_0x006a;
    L_0x0068:
        r17 = 0;
    L_0x006a:
        r12 = getChildMeasureSpec(r2, r3, r13);
        r14.measure(r11, r12);
        r11 = r0.mMetrics;
        if (r11 == 0) goto L_0x0084;
    L_0x0075:
        r11 = r0.mMetrics;
        r19 = r3;
        r2 = r11.measures;
        r20 = r4;
        r21 = r5;
        r4 = r2 + r8;
        r11.measures = r4;
        goto L_0x008a;
    L_0x0084:
        r19 = r3;
        r20 = r4;
        r21 = r5;
    L_0x008a:
        r2 = -2;
        if (r6 != r2) goto L_0x008f;
    L_0x008d:
        r3 = 1;
        goto L_0x0090;
    L_0x008f:
        r3 = 0;
    L_0x0090:
        r15.setWidthWrapContent(r3);
        if (r13 != r2) goto L_0x0097;
    L_0x0095:
        r2 = 1;
        goto L_0x0098;
    L_0x0097:
        r2 = 0;
    L_0x0098:
        r15.setHeightWrapContent(r2);
        r2 = r14.getMeasuredWidth();
        r3 = r14.getMeasuredHeight();
        r15.setWidth(r2);
        r15.setHeight(r3);
        if (r16 == 0) goto L_0x00ae;
    L_0x00ab:
        r15.setWrapWidth(r2);
    L_0x00ae:
        if (r17 == 0) goto L_0x00b3;
    L_0x00b0:
        r15.setWrapHeight(r3);
    L_0x00b3:
        r4 = r10.needsBaseline;
        if (r4 == 0) goto L_0x00c1;
    L_0x00b7:
        r4 = r14.getBaseline();
        r5 = -1;
        if (r4 == r5) goto L_0x00c1;
    L_0x00be:
        r15.setBaselineDistance(r4);
    L_0x00c1:
        r4 = r10.horizontalDimensionFixed;
        if (r4 == 0) goto L_0x00ec;
    L_0x00c5:
        r4 = r10.verticalDimensionFixed;
        if (r4 == 0) goto L_0x00ec;
    L_0x00c9:
        r4 = r15.getResolutionWidth();
        r4.resolve(r2);
        r2 = r15.getResolutionHeight();
        r2.resolve(r3);
        goto L_0x00ec;
    L_0x00d8:
        r19 = r3;
        r20 = r4;
        r21 = r5;
        r2 = r15.getResolutionWidth();
        r2.invalidate();
        r2 = r15.getResolutionHeight();
        r2.invalidate();
    L_0x00ec:
        r7 = r7 + 1;
        r3 = r19;
        r4 = r20;
        r5 = r21;
        r2 = r28;
        goto L_0x001d;
    L_0x00f8:
        r19 = r3;
        r20 = r4;
        r21 = r5;
        r2 = r0.mLayoutWidget;
        r2.solveGraph();
        r2 = r21;
        r3 = 0;
    L_0x0106:
        if (r3 >= r2) goto L_0x0323;
    L_0x0108:
        r4 = r0.getChildAt(r3);
        r5 = r4.getVisibility();
        if (r5 != r10) goto L_0x0120;
    L_0x0112:
        r22 = r2;
        r23 = r3;
        r10 = r19;
        r24 = r20;
        r0 = -2;
        r2 = -1;
        r18 = r8;
        goto L_0x0311;
    L_0x0120:
        r5 = r4.getLayoutParams();
        r5 = (android.support.constraint.ConstraintLayout.LayoutParams) r5;
        r6 = r5.widget;
        r7 = r5.isGuideline;
        if (r7 != 0) goto L_0x0112;
    L_0x012c:
        r7 = r5.isHelper;
        if (r7 == 0) goto L_0x0131;
    L_0x0130:
        goto L_0x0112;
    L_0x0131:
        r7 = r4.getVisibility();
        r6.setVisibility(r7);
        r7 = r5.width;
        r11 = r5.height;
        if (r7 == 0) goto L_0x0141;
    L_0x013e:
        if (r11 == 0) goto L_0x0141;
    L_0x0140:
        goto L_0x0112;
    L_0x0141:
        r12 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.LEFT;
        r12 = r6.getAnchor(r12);
        r12 = r12.getResolutionNode();
        r13 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT;
        r13 = r6.getAnchor(r13);
        r13 = r13.getResolutionNode();
        r14 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.LEFT;
        r14 = r6.getAnchor(r14);
        r14 = r14.getTarget();
        if (r14 == 0) goto L_0x016f;
    L_0x0161:
        r14 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT;
        r14 = r6.getAnchor(r14);
        r14 = r14.getTarget();
        if (r14 == 0) goto L_0x016f;
    L_0x016d:
        r14 = 1;
        goto L_0x0170;
    L_0x016f:
        r14 = 0;
    L_0x0170:
        r15 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP;
        r15 = r6.getAnchor(r15);
        r15 = r15.getResolutionNode();
        r10 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM;
        r10 = r6.getAnchor(r10);
        r10 = r10.getResolutionNode();
        r8 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP;
        r8 = r6.getAnchor(r8);
        r8 = r8.getTarget();
        if (r8 == 0) goto L_0x019e;
    L_0x0190:
        r8 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM;
        r8 = r6.getAnchor(r8);
        r8 = r8.getTarget();
        if (r8 == 0) goto L_0x019e;
    L_0x019c:
        r8 = 1;
        goto L_0x019f;
    L_0x019e:
        r8 = 0;
    L_0x019f:
        if (r7 != 0) goto L_0x01b5;
    L_0x01a1:
        if (r11 != 0) goto L_0x01b5;
    L_0x01a3:
        if (r14 == 0) goto L_0x01b5;
    L_0x01a5:
        if (r8 == 0) goto L_0x01b5;
    L_0x01a7:
        r22 = r2;
        r23 = r3;
        r10 = r19;
        r24 = r20;
        r0 = -2;
        r2 = -1;
        r18 = 1;
        goto L_0x0311;
    L_0x01b5:
        r9 = r0.mLayoutWidget;
        r9 = r9.getHorizontalDimensionBehaviour();
        r22 = r2;
        r2 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r9 == r2) goto L_0x01c3;
    L_0x01c1:
        r2 = 1;
        goto L_0x01c4;
    L_0x01c3:
        r2 = 0;
    L_0x01c4:
        r9 = r0.mLayoutWidget;
        r9 = r9.getVerticalDimensionBehaviour();
        r23 = r3;
        r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r9 == r3) goto L_0x01d2;
    L_0x01d0:
        r3 = 1;
        goto L_0x01d3;
    L_0x01d2:
        r3 = 0;
    L_0x01d3:
        if (r2 != 0) goto L_0x01dc;
    L_0x01d5:
        r9 = r6.getResolutionWidth();
        r9.invalidate();
    L_0x01dc:
        if (r3 != 0) goto L_0x01e5;
    L_0x01de:
        r9 = r6.getResolutionHeight();
        r9.invalidate();
    L_0x01e5:
        if (r7 != 0) goto L_0x0221;
    L_0x01e7:
        if (r2 == 0) goto L_0x0216;
    L_0x01e9:
        r9 = r6.isSpreadWidth();
        if (r9 == 0) goto L_0x0216;
    L_0x01ef:
        if (r14 == 0) goto L_0x0216;
    L_0x01f1:
        r9 = r12.isResolved();
        if (r9 == 0) goto L_0x0216;
    L_0x01f7:
        r9 = r13.isResolved();
        if (r9 == 0) goto L_0x0216;
    L_0x01fd:
        r7 = r13.getResolvedValue();
        r9 = r12.getResolvedValue();
        r7 = r7 - r9;
        r7 = (int) r7;
        r9 = r6.getResolutionWidth();
        r9.resolve(r7);
        r9 = r20;
        r12 = getChildMeasureSpec(r1, r9, r7);
        r13 = r2;
        goto L_0x022d;
    L_0x0216:
        r9 = r20;
        r12 = -2;
        r2 = getChildMeasureSpec(r1, r9, r12);
        r12 = r2;
        r2 = 1;
        r13 = 0;
        goto L_0x023e;
    L_0x0221:
        r9 = r20;
        r12 = -2;
        r13 = -1;
        if (r7 != r13) goto L_0x022f;
    L_0x0227:
        r14 = getChildMeasureSpec(r1, r9, r13);
        r13 = r2;
        r12 = r14;
    L_0x022d:
        r2 = 0;
        goto L_0x023e;
    L_0x022f:
        if (r7 != r12) goto L_0x0233;
    L_0x0231:
        r12 = 1;
        goto L_0x0234;
    L_0x0233:
        r12 = 0;
    L_0x0234:
        r13 = getChildMeasureSpec(r1, r9, r7);
        r25 = r13;
        r13 = r2;
        r2 = r12;
        r12 = r25;
    L_0x023e:
        if (r11 != 0) goto L_0x027e;
    L_0x0240:
        if (r3 == 0) goto L_0x0271;
    L_0x0242:
        r14 = r6.isSpreadHeight();
        if (r14 == 0) goto L_0x0271;
    L_0x0248:
        if (r8 == 0) goto L_0x0271;
    L_0x024a:
        r8 = r15.isResolved();
        if (r8 == 0) goto L_0x0271;
    L_0x0250:
        r8 = r10.isResolved();
        if (r8 == 0) goto L_0x0271;
    L_0x0256:
        r8 = r10.getResolvedValue();
        r10 = r15.getResolvedValue();
        r8 = r8 - r10;
        r11 = (int) r8;
        r8 = r6.getResolutionHeight();
        r8.resolve(r11);
        r10 = r19;
        r8 = r28;
        r14 = getChildMeasureSpec(r8, r10, r11);
        r15 = r3;
        goto L_0x028d;
    L_0x0271:
        r10 = r19;
        r8 = r28;
        r14 = -2;
        r3 = getChildMeasureSpec(r8, r10, r14);
        r14 = r3;
        r3 = 1;
        r15 = 0;
        goto L_0x029e;
    L_0x027e:
        r10 = r19;
        r8 = r28;
        r14 = -2;
        r15 = -1;
        if (r11 != r15) goto L_0x028f;
    L_0x0286:
        r16 = getChildMeasureSpec(r8, r10, r15);
        r15 = r3;
        r14 = r16;
    L_0x028d:
        r3 = 0;
        goto L_0x029e;
    L_0x028f:
        if (r11 != r14) goto L_0x0293;
    L_0x0291:
        r14 = 1;
        goto L_0x0294;
    L_0x0293:
        r14 = 0;
    L_0x0294:
        r15 = getChildMeasureSpec(r8, r10, r11);
        r25 = r15;
        r15 = r3;
        r3 = r14;
        r14 = r25;
    L_0x029e:
        r4.measure(r12, r14);
        r12 = r0.mMetrics;
        if (r12 == 0) goto L_0x02b2;
    L_0x02a5:
        r12 = r0.mMetrics;
        r0 = r12.measures;
        r24 = r9;
        r18 = 1;
        r8 = r0 + r18;
        r12.measures = r8;
        goto L_0x02b6;
    L_0x02b2:
        r24 = r9;
        r18 = 1;
    L_0x02b6:
        r0 = -2;
        if (r7 != r0) goto L_0x02bb;
    L_0x02b9:
        r1 = 1;
        goto L_0x02bc;
    L_0x02bb:
        r1 = 0;
    L_0x02bc:
        r6.setWidthWrapContent(r1);
        if (r11 != r0) goto L_0x02c3;
    L_0x02c1:
        r1 = 1;
        goto L_0x02c4;
    L_0x02c3:
        r1 = 0;
    L_0x02c4:
        r6.setHeightWrapContent(r1);
        r1 = r4.getMeasuredWidth();
        r7 = r4.getMeasuredHeight();
        r6.setWidth(r1);
        r6.setHeight(r7);
        if (r2 == 0) goto L_0x02da;
    L_0x02d7:
        r6.setWrapWidth(r1);
    L_0x02da:
        if (r3 == 0) goto L_0x02df;
    L_0x02dc:
        r6.setWrapHeight(r7);
    L_0x02df:
        if (r13 == 0) goto L_0x02e9;
    L_0x02e1:
        r2 = r6.getResolutionWidth();
        r2.resolve(r1);
        goto L_0x02f0;
    L_0x02e9:
        r1 = r6.getResolutionWidth();
        r1.remove();
    L_0x02f0:
        if (r15 == 0) goto L_0x02fa;
    L_0x02f2:
        r1 = r6.getResolutionHeight();
        r1.resolve(r7);
        goto L_0x0301;
    L_0x02fa:
        r1 = r6.getResolutionHeight();
        r1.remove();
    L_0x0301:
        r1 = r5.needsBaseline;
        if (r1 == 0) goto L_0x0310;
    L_0x0305:
        r1 = r4.getBaseline();
        r2 = -1;
        if (r1 == r2) goto L_0x0311;
    L_0x030c:
        r6.setBaselineDistance(r1);
        goto L_0x0311;
    L_0x0310:
        r2 = -1;
    L_0x0311:
        r3 = r23 + 1;
        r8 = r18;
        r2 = r22;
        r20 = r24;
        r0 = r26;
        r1 = r27;
        r19 = r10;
        r10 = 8;
        goto L_0x0106;
    L_0x0323:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.ConstraintLayout.internalMeasureDimensions(int, int):void");
    }

    private void setChildrenConstraints() {
        int i;
        View childAt;
        String resourceName;
        int indexOf;
        ConstraintWidget viewWidget;
        int i2;
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        boolean z = false;
        if (isInEditMode) {
            for (i = 0; i < childCount; i++) {
                childAt = getChildAt(i);
                try {
                    resourceName = getResources().getResourceName(childAt.getId());
                    setDesignInformation(0, resourceName, Integer.valueOf(childAt.getId()));
                    indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    getTargetWidget(childAt.getId()).setDebugName(resourceName);
                } catch (NotFoundException unused) {
                }
            }
        }
        for (i = 0; i < childCount; i++) {
            viewWidget = getViewWidget(getChildAt(i));
            if (viewWidget != null) {
                viewWidget.reset();
            }
        }
        if (this.mConstraintSetId != -1) {
            for (i = 0; i < childCount; i++) {
                childAt = getChildAt(i);
                if (childAt.getId() == this.mConstraintSetId && (childAt instanceof Constraints)) {
                    this.mConstraintSet = ((Constraints) childAt).getConstraintSet();
                }
            }
        }
        if (this.mConstraintSet != null) {
            this.mConstraintSet.applyToInternal(this);
        }
        this.mLayoutWidget.removeAllChildren();
        i = this.mConstraintHelpers.size();
        if (i > 0) {
            for (i2 = 0; i2 < i; i2++) {
                ((ConstraintHelper) this.mConstraintHelpers.get(i2)).updatePreLayout(this);
            }
        }
        for (i = 0; i < childCount; i++) {
            childAt = getChildAt(i);
            if (childAt instanceof Placeholder) {
                ((Placeholder) childAt).updatePreLayout(this);
            }
        }
        for (i = 0; i < childCount; i++) {
            childAt = getChildAt(i);
            ConstraintWidget viewWidget2 = getViewWidget(childAt);
            if (viewWidget2 != null) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.validate();
                if (layoutParams.helped) {
                    layoutParams.helped = z;
                } else if (isInEditMode) {
                    try {
                        resourceName = getResources().getResourceName(childAt.getId());
                        setDesignInformation(z, resourceName, Integer.valueOf(childAt.getId()));
                        getTargetWidget(childAt.getId()).setDebugName(resourceName.substring(resourceName.indexOf("id/") + 3));
                    } catch (NotFoundException unused2) {
                    }
                }
                viewWidget2.setVisibility(childAt.getVisibility());
                if (layoutParams.isInPlaceholder) {
                    viewWidget2.setVisibility(8);
                }
                viewWidget2.setCompanionWidget(childAt);
                this.mLayoutWidget.add(viewWidget2);
                if (!(layoutParams.verticalDimensionFixed && layoutParams.horizontalDimensionFixed)) {
                    this.mVariableDimensionsWidgets.add(viewWidget2);
                }
                if (layoutParams.isGuideline) {
                    Guideline guideline = (Guideline) viewWidget2;
                    i2 = layoutParams.resolvedGuideBegin;
                    indexOf = layoutParams.resolvedGuideEnd;
                    float f = layoutParams.resolvedGuidePercent;
                    if (VERSION.SDK_INT < 17) {
                        i2 = layoutParams.guideBegin;
                        indexOf = layoutParams.guideEnd;
                        f = layoutParams.guidePercent;
                    }
                    if (f != -1.0f) {
                        guideline.setGuidePercent(f);
                    } else if (i2 != -1) {
                        guideline.setGuideBegin(i2);
                    } else if (indexOf != -1) {
                        guideline.setGuideEnd(indexOf);
                    }
                } else if (layoutParams.leftToLeft != -1 || layoutParams.leftToRight != -1 || layoutParams.rightToLeft != -1 || layoutParams.rightToRight != -1 || layoutParams.startToStart != -1 || layoutParams.startToEnd != -1 || layoutParams.endToStart != -1 || layoutParams.endToEnd != -1 || layoutParams.topToTop != -1 || layoutParams.topToBottom != -1 || layoutParams.bottomToTop != -1 || layoutParams.bottomToBottom != -1 || layoutParams.baselineToBaseline != -1 || layoutParams.editorAbsoluteX != -1 || layoutParams.editorAbsoluteY != -1 || layoutParams.circleConstraint != -1 || layoutParams.width == -1 || layoutParams.height == -1) {
                    int i3;
                    int i4;
                    i2 = layoutParams.resolvedLeftToLeft;
                    indexOf = layoutParams.resolvedLeftToRight;
                    int i5 = layoutParams.resolvedRightToLeft;
                    int i6 = layoutParams.resolvedRightToRight;
                    int i7 = layoutParams.resolveGoneLeftMargin;
                    int i8 = layoutParams.resolveGoneRightMargin;
                    float f2 = layoutParams.resolvedHorizontalBias;
                    if (VERSION.SDK_INT < 17) {
                        i3 = layoutParams.leftToLeft;
                        i2 = layoutParams.leftToRight;
                        i5 = layoutParams.rightToLeft;
                        i6 = layoutParams.rightToRight;
                        int i9 = layoutParams.goneLeftMargin;
                        indexOf = layoutParams.goneRightMargin;
                        f2 = layoutParams.horizontalBias;
                        if (i3 == -1 && i2 == -1) {
                            if (layoutParams.startToStart != -1) {
                                i3 = layoutParams.startToStart;
                            } else if (layoutParams.startToEnd != -1) {
                                i2 = layoutParams.startToEnd;
                            }
                        }
                        int i10 = i2;
                        i2 = i3;
                        i3 = i10;
                        if (i5 == -1 && i6 == -1) {
                            if (layoutParams.endToStart != -1) {
                                i5 = layoutParams.endToStart;
                            } else if (layoutParams.endToEnd != -1) {
                                i6 = layoutParams.endToEnd;
                            }
                        }
                        i8 = i9;
                        i4 = indexOf;
                    } else {
                        i3 = indexOf;
                        i4 = i8;
                        i8 = i7;
                    }
                    i7 = i6;
                    float f3 = f2;
                    int i11 = i5;
                    if (layoutParams.circleConstraint != -1) {
                        ConstraintWidget targetWidget = getTargetWidget(layoutParams.circleConstraint);
                        if (targetWidget != null) {
                            viewWidget2.connectCircularConstraint(targetWidget, layoutParams.circleAngle, layoutParams.circleRadius);
                        }
                    } else {
                        ConstraintWidget targetWidget2;
                        float f4;
                        if (i2 != -1) {
                            targetWidget2 = getTargetWidget(i2);
                            if (targetWidget2 != null) {
                                Type type = Type.LEFT;
                                f4 = f3;
                                Type type2 = Type.LEFT;
                                i3 = i7;
                                viewWidget2.immediateConnect(type, targetWidget2, type2, layoutParams.leftMargin, i8);
                            } else {
                                f4 = f3;
                                i3 = i7;
                            }
                            i2 = i3;
                        } else {
                            f4 = f3;
                            i2 = i7;
                            if (i3 != -1) {
                                targetWidget2 = getTargetWidget(i3);
                                if (targetWidget2 != null) {
                                    viewWidget2.immediateConnect(Type.LEFT, targetWidget2, Type.RIGHT, layoutParams.leftMargin, i8);
                                }
                            }
                        }
                        if (i11 != -1) {
                            targetWidget2 = getTargetWidget(i11);
                            if (targetWidget2 != null) {
                                viewWidget2.immediateConnect(Type.RIGHT, targetWidget2, Type.LEFT, layoutParams.rightMargin, i4);
                            }
                        } else if (i2 != -1) {
                            targetWidget2 = getTargetWidget(i2);
                            if (targetWidget2 != null) {
                                viewWidget2.immediateConnect(Type.RIGHT, targetWidget2, Type.RIGHT, layoutParams.rightMargin, i4);
                            }
                        }
                        if (layoutParams.topToTop != -1) {
                            targetWidget2 = getTargetWidget(layoutParams.topToTop);
                            if (targetWidget2 != null) {
                                viewWidget2.immediateConnect(Type.TOP, targetWidget2, Type.TOP, layoutParams.topMargin, layoutParams.goneTopMargin);
                            }
                        } else if (layoutParams.topToBottom != -1) {
                            targetWidget2 = getTargetWidget(layoutParams.topToBottom);
                            if (targetWidget2 != null) {
                                viewWidget2.immediateConnect(Type.TOP, targetWidget2, Type.BOTTOM, layoutParams.topMargin, layoutParams.goneTopMargin);
                            }
                        }
                        if (layoutParams.bottomToTop != -1) {
                            targetWidget2 = getTargetWidget(layoutParams.bottomToTop);
                            if (targetWidget2 != null) {
                                viewWidget2.immediateConnect(Type.BOTTOM, targetWidget2, Type.TOP, layoutParams.bottomMargin, layoutParams.goneBottomMargin);
                            }
                        } else if (layoutParams.bottomToBottom != -1) {
                            targetWidget2 = getTargetWidget(layoutParams.bottomToBottom);
                            if (targetWidget2 != null) {
                                viewWidget2.immediateConnect(Type.BOTTOM, targetWidget2, Type.BOTTOM, layoutParams.bottomMargin, layoutParams.goneBottomMargin);
                            }
                        }
                        if (layoutParams.baselineToBaseline != -1) {
                            View view = (View) this.mChildrenByIds.get(layoutParams.baselineToBaseline);
                            viewWidget = getTargetWidget(layoutParams.baselineToBaseline);
                            if (!(viewWidget == null || view == null || !(view.getLayoutParams() instanceof LayoutParams))) {
                                LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                                layoutParams.needsBaseline = true;
                                layoutParams2.needsBaseline = true;
                                viewWidget2.getAnchor(Type.BASELINE).connect(viewWidget.getAnchor(Type.BASELINE), 0, -1, Strength.STRONG, 0, true);
                                viewWidget2.getAnchor(Type.TOP).reset();
                                viewWidget2.getAnchor(Type.BOTTOM).reset();
                            }
                        }
                        f2 = f4;
                        if (f2 >= 0.0f && f2 != 0.5f) {
                            viewWidget2.setHorizontalBiasPercent(f2);
                        }
                        if (layoutParams.verticalBias >= 0.0f && layoutParams.verticalBias != 0.5f) {
                            viewWidget2.setVerticalBiasPercent(layoutParams.verticalBias);
                        }
                    }
                    if (isInEditMode && !(layoutParams.editorAbsoluteX == -1 && layoutParams.editorAbsoluteY == -1)) {
                        viewWidget2.setOrigin(layoutParams.editorAbsoluteX, layoutParams.editorAbsoluteY);
                    }
                    if (layoutParams.horizontalDimensionFixed) {
                        viewWidget2.setHorizontalDimensionBehaviour(DimensionBehaviour.FIXED);
                        viewWidget2.setWidth(layoutParams.width);
                    } else if (layoutParams.width == -1) {
                        viewWidget2.setHorizontalDimensionBehaviour(DimensionBehaviour.MATCH_PARENT);
                        viewWidget2.getAnchor(Type.LEFT).mMargin = layoutParams.leftMargin;
                        viewWidget2.getAnchor(Type.RIGHT).mMargin = layoutParams.rightMargin;
                    } else {
                        viewWidget2.setHorizontalDimensionBehaviour(DimensionBehaviour.MATCH_CONSTRAINT);
                        viewWidget2.setWidth(0);
                    }
                    if (layoutParams.verticalDimensionFixed) {
                        z = false;
                        viewWidget2.setVerticalDimensionBehaviour(DimensionBehaviour.FIXED);
                        viewWidget2.setHeight(layoutParams.height);
                    } else if (layoutParams.height == -1) {
                        viewWidget2.setVerticalDimensionBehaviour(DimensionBehaviour.MATCH_PARENT);
                        viewWidget2.getAnchor(Type.TOP).mMargin = layoutParams.topMargin;
                        viewWidget2.getAnchor(Type.BOTTOM).mMargin = layoutParams.bottomMargin;
                        z = false;
                    } else {
                        viewWidget2.setVerticalDimensionBehaviour(DimensionBehaviour.MATCH_CONSTRAINT);
                        z = false;
                        viewWidget2.setHeight(0);
                    }
                    if (layoutParams.dimensionRatio != null) {
                        viewWidget2.setDimensionRatio(layoutParams.dimensionRatio);
                    }
                    viewWidget2.setHorizontalWeight(layoutParams.horizontalWeight);
                    viewWidget2.setVerticalWeight(layoutParams.verticalWeight);
                    viewWidget2.setHorizontalChainStyle(layoutParams.horizontalChainStyle);
                    viewWidget2.setVerticalChainStyle(layoutParams.verticalChainStyle);
                    viewWidget2.setHorizontalMatchStyle(layoutParams.matchConstraintDefaultWidth, layoutParams.matchConstraintMinWidth, layoutParams.matchConstraintMaxWidth, layoutParams.matchConstraintPercentWidth);
                    viewWidget2.setVerticalMatchStyle(layoutParams.matchConstraintDefaultHeight, layoutParams.matchConstraintMinHeight, layoutParams.matchConstraintMaxHeight, layoutParams.matchConstraintPercentHeight);
                }
            }
        }
    }

    private void setSelfDimensionBehaviour(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        i = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        i2 = MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        getLayoutParams();
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                dimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
            } else if (mode == 1073741824) {
                i = Math.min(this.mMaxWidth, i) - paddingLeft;
            }
            i = 0;
        } else {
            dimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
            } else if (mode2 == 1073741824) {
                i2 = Math.min(this.mMaxHeight, i2) - paddingTop;
            }
            i2 = 0;
        } else {
            dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
        }
        this.mLayoutWidget.setMinWidth(0);
        this.mLayoutWidget.setMinHeight(0);
        this.mLayoutWidget.setHorizontalDimensionBehaviour(dimensionBehaviour);
        this.mLayoutWidget.setWidth(i);
        this.mLayoutWidget.setVerticalDimensionBehaviour(dimensionBehaviour2);
        this.mLayoutWidget.setHeight(i2);
        this.mLayoutWidget.setMinWidth((this.mMinWidth - getPaddingLeft()) - getPaddingRight());
        this.mLayoutWidget.setMinHeight((this.mMinHeight - getPaddingTop()) - getPaddingBottom());
    }

    private void updateHierarchy() {
        int childCount = getChildCount();
        Object obj = null;
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).isLayoutRequested()) {
                obj = 1;
                break;
            }
        }
        if (obj != null) {
            this.mVariableDimensionsWidgets.clear();
            setChildrenConstraints();
        }
    }

    private void updatePostMeasures() {
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof Placeholder) {
                ((Placeholder) childAt).updatePostMeasure(this);
            }
        }
        childCount = this.mConstraintHelpers.size();
        if (childCount > 0) {
            while (i < childCount) {
                ((ConstraintHelper) this.mConstraintHelpers.get(i)).updatePostMeasure(this);
                i++;
            }
        }
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = (float) getWidth();
            float height = (float) getHeight();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt.getVisibility() != 8) {
                    Object tag = childAt.getTag();
                    if (tag != null && (tag instanceof String)) {
                        String[] split = ((String) tag).split(",");
                        if (split.length == 4) {
                            int parseInt = Integer.parseInt(split[0]);
                            int parseInt2 = Integer.parseInt(split[1]);
                            parseInt = (int) ((((float) parseInt) / 1080.0f) * width);
                            parseInt2 = (int) ((((float) parseInt2) / 1920.0f) * height);
                            int parseInt3 = (int) ((((float) Integer.parseInt(split[2])) / 1080.0f) * width);
                            int parseInt4 = (int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height);
                            Paint paint = new Paint();
                            paint.setColor(SupportMenu.CATEGORY_MASK);
                            float f = (float) parseInt;
                            float f2 = (float) (parseInt + parseInt3);
                            Canvas canvas2 = canvas;
                            float f3 = (float) parseInt2;
                            float f4 = f;
                            float f5 = f;
                            f = f3;
                            Paint paint2 = paint;
                            float f6 = f2;
                            Paint paint3 = paint2;
                            canvas2.drawLine(f4, f, f6, f3, paint3);
                            float f7 = (float) (parseInt2 + parseInt4);
                            f4 = f2;
                            float f8 = f7;
                            canvas2.drawLine(f4, f, f6, f8, paint3);
                            f = f7;
                            f6 = f5;
                            canvas2.drawLine(f4, f, f6, f8, paint3);
                            f4 = f5;
                            canvas2.drawLine(f4, f, f6, f3, paint3);
                            paint = paint2;
                            paint.setColor(-16711936);
                            Paint paint4 = paint;
                            f6 = f2;
                            paint3 = paint4;
                            canvas2.drawLine(f4, f3, f6, f7, paint3);
                            canvas2.drawLine(f4, f7, f6, f3, paint3);
                        }
                    }
                }
            }
        }
    }

    public void fillMetrics(Metrics metrics) {
        this.mMetrics = metrics;
        this.mLayoutWidget.fillMetrics(metrics);
    }

    /* Access modifiers changed, original: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public Object getDesignInformation(int i, Object obj) {
        if (i == 0 && (obj instanceof String)) {
            String str = (String) obj;
            if (this.mDesignIds != null && this.mDesignIds.containsKey(str)) {
                return this.mDesignIds.get(str);
            }
        }
        return null;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.getOptimizationLevel();
    }

    public View getViewById(int i) {
        return (View) this.mChildrenByIds.get(i);
    }

    public final ConstraintWidget getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        return view == null ? null : ((LayoutParams) view.getLayoutParams()).widget;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        i2 = 0;
        for (i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = layoutParams.widget;
            if ((childAt.getVisibility() != 8 || layoutParams.isGuideline || layoutParams.isHelper || isInEditMode) && !layoutParams.isInPlaceholder) {
                int drawX = constraintWidget.getDrawX();
                int drawY = constraintWidget.getDrawY();
                int width = constraintWidget.getWidth() + drawX;
                int height = constraintWidget.getHeight() + drawY;
                childAt.layout(drawX, drawY, width, height);
                if (childAt instanceof Placeholder) {
                    childAt = ((Placeholder) childAt).getContent();
                    if (childAt != null) {
                        childAt.setVisibility(0);
                        childAt.layout(drawX, drawY, width, height);
                    }
                }
            }
        }
        childCount = this.mConstraintHelpers.size();
        if (childCount > 0) {
            while (i2 < childCount) {
                ((ConstraintHelper) this.mConstraintHelpers.get(i2)).updatePostLayout(this);
                i2++;
            }
        }
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0394  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x03e8  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x03af  */
    public void onMeasure(int r27, int r28) {
        /*
        r26 = this;
        r0 = r26;
        r1 = r27;
        r2 = r28;
        java.lang.System.currentTimeMillis();
        r3 = android.view.View.MeasureSpec.getMode(r27);
        r4 = android.view.View.MeasureSpec.getSize(r27);
        r5 = android.view.View.MeasureSpec.getMode(r28);
        r6 = android.view.View.MeasureSpec.getSize(r28);
        r7 = r26.getPaddingLeft();
        r8 = r26.getPaddingTop();
        r9 = r0.mLayoutWidget;
        r9.setX(r7);
        r9 = r0.mLayoutWidget;
        r9.setY(r8);
        r9 = r0.mLayoutWidget;
        r10 = r0.mMaxWidth;
        r9.setMaxWidth(r10);
        r9 = r0.mLayoutWidget;
        r10 = r0.mMaxHeight;
        r9.setMaxHeight(r10);
        r9 = android.os.Build.VERSION.SDK_INT;
        r10 = 0;
        r11 = 1;
        r12 = 17;
        if (r9 < r12) goto L_0x004f;
    L_0x0041:
        r9 = r0.mLayoutWidget;
        r12 = r26.getLayoutDirection();
        if (r12 != r11) goto L_0x004b;
    L_0x0049:
        r12 = r11;
        goto L_0x004c;
    L_0x004b:
        r12 = r10;
    L_0x004c:
        r9.setRtl(r12);
    L_0x004f:
        r26.setSelfDimensionBehaviour(r27, r28);
        r9 = r0.mLayoutWidget;
        r9 = r9.getWidth();
        r12 = r0.mLayoutWidget;
        r12 = r12.getHeight();
        r13 = r0.mDirtyHierarchy;
        if (r13 == 0) goto L_0x0069;
    L_0x0062:
        r0.mDirtyHierarchy = r10;
        r26.updateHierarchy();
        r13 = r11;
        goto L_0x006a;
    L_0x0069:
        r13 = r10;
    L_0x006a:
        r14 = r0.mOptimizationLevel;
        r15 = 8;
        r14 = r14 & r15;
        if (r14 != r15) goto L_0x0073;
    L_0x0071:
        r14 = r11;
        goto L_0x0074;
    L_0x0073:
        r14 = r10;
    L_0x0074:
        if (r14 == 0) goto L_0x0084;
    L_0x0076:
        r15 = r0.mLayoutWidget;
        r15.preOptimize();
        r15 = r0.mLayoutWidget;
        r15.optimizeForDimensions(r9, r12);
        r26.internalMeasureDimensions(r27, r28);
        goto L_0x0087;
    L_0x0084:
        r26.internalMeasureChildren(r27, r28);
    L_0x0087:
        r26.updatePostMeasures();
        r15 = r26.getChildCount();
        if (r15 <= 0) goto L_0x0097;
    L_0x0090:
        if (r13 == 0) goto L_0x0097;
    L_0x0092:
        r13 = r0.mLayoutWidget;
        android.support.constraint.solver.widgets.Analyzer.determineGroups(r13);
    L_0x0097:
        r13 = r0.mLayoutWidget;
        r13 = r13.mGroupsWrapOptimized;
        if (r13 == 0) goto L_0x00db;
    L_0x009d:
        r13 = r0.mLayoutWidget;
        r13 = r13.mHorizontalWrapOptimized;
        r15 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        if (r13 == 0) goto L_0x00bd;
    L_0x00a5:
        if (r3 != r15) goto L_0x00bd;
    L_0x00a7:
        r13 = r0.mLayoutWidget;
        r13 = r13.mWrapFixedWidth;
        if (r13 >= r4) goto L_0x00b6;
    L_0x00ad:
        r13 = r0.mLayoutWidget;
        r11 = r0.mLayoutWidget;
        r11 = r11.mWrapFixedWidth;
        r13.setWidth(r11);
    L_0x00b6:
        r11 = r0.mLayoutWidget;
        r13 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
        r11.setHorizontalDimensionBehaviour(r13);
    L_0x00bd:
        r11 = r0.mLayoutWidget;
        r11 = r11.mVerticalWrapOptimized;
        if (r11 == 0) goto L_0x00db;
    L_0x00c3:
        if (r5 != r15) goto L_0x00db;
    L_0x00c5:
        r11 = r0.mLayoutWidget;
        r11 = r11.mWrapFixedHeight;
        if (r11 >= r6) goto L_0x00d4;
    L_0x00cb:
        r11 = r0.mLayoutWidget;
        r13 = r0.mLayoutWidget;
        r13 = r13.mWrapFixedHeight;
        r11.setHeight(r13);
    L_0x00d4:
        r11 = r0.mLayoutWidget;
        r13 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
        r11.setVerticalDimensionBehaviour(r13);
    L_0x00db:
        r11 = r0.mOptimizationLevel;
        r13 = 32;
        r11 = r11 & r13;
        r15 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r11 != r13) goto L_0x0137;
    L_0x00e4:
        r11 = r0.mLayoutWidget;
        r11 = r11.getWidth();
        r13 = r0.mLayoutWidget;
        r13 = r13.getHeight();
        r10 = r0.mLastMeasureWidth;
        if (r10 == r11) goto L_0x00fe;
    L_0x00f4:
        if (r3 != r15) goto L_0x00fe;
    L_0x00f6:
        r3 = r0.mLayoutWidget;
        r3 = r3.mWidgetGroups;
        r10 = 0;
        android.support.constraint.solver.widgets.Analyzer.setPosition(r3, r10, r11);
    L_0x00fe:
        r3 = r0.mLastMeasureHeight;
        if (r3 == r13) goto L_0x010c;
    L_0x0102:
        if (r5 != r15) goto L_0x010c;
    L_0x0104:
        r3 = r0.mLayoutWidget;
        r3 = r3.mWidgetGroups;
        r5 = 1;
        android.support.constraint.solver.widgets.Analyzer.setPosition(r3, r5, r13);
    L_0x010c:
        r3 = r0.mLayoutWidget;
        r3 = r3.mHorizontalWrapOptimized;
        if (r3 == 0) goto L_0x0121;
    L_0x0112:
        r3 = r0.mLayoutWidget;
        r3 = r3.mWrapFixedWidth;
        if (r3 <= r4) goto L_0x0121;
    L_0x0118:
        r3 = r0.mLayoutWidget;
        r3 = r3.mWidgetGroups;
        r10 = 0;
        android.support.constraint.solver.widgets.Analyzer.setPosition(r3, r10, r4);
        goto L_0x0122;
    L_0x0121:
        r10 = 0;
    L_0x0122:
        r3 = r0.mLayoutWidget;
        r3 = r3.mVerticalWrapOptimized;
        if (r3 == 0) goto L_0x0137;
    L_0x0128:
        r3 = r0.mLayoutWidget;
        r3 = r3.mWrapFixedHeight;
        if (r3 <= r6) goto L_0x0137;
    L_0x012e:
        r3 = r0.mLayoutWidget;
        r3 = r3.mWidgetGroups;
        r4 = 1;
        android.support.constraint.solver.widgets.Analyzer.setPosition(r3, r4, r6);
        goto L_0x0138;
    L_0x0137:
        r4 = 1;
    L_0x0138:
        r3 = r26.getChildCount();
        if (r3 <= 0) goto L_0x0143;
    L_0x013e:
        r3 = "First pass";
        r0.solveLinearSystem(r3);
    L_0x0143:
        r3 = r0.mVariableDimensionsWidgets;
        r3 = r3.size();
        r5 = r26.getPaddingBottom();
        r8 = r8 + r5;
        r5 = r26.getPaddingRight();
        r7 = r7 + r5;
        if (r3 <= 0) goto L_0x0394;
    L_0x0155:
        r6 = r0.mLayoutWidget;
        r6 = r6.getHorizontalDimensionBehaviour();
        r11 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r6 != r11) goto L_0x0161;
    L_0x015f:
        r6 = r4;
        goto L_0x0162;
    L_0x0161:
        r6 = r10;
    L_0x0162:
        r11 = r0.mLayoutWidget;
        r11 = r11.getVerticalDimensionBehaviour();
        r13 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r11 != r13) goto L_0x016e;
    L_0x016c:
        r11 = r4;
        goto L_0x016f;
    L_0x016e:
        r11 = r10;
    L_0x016f:
        r13 = r0.mLayoutWidget;
        r13 = r13.getWidth();
        r4 = r0.mMinWidth;
        r4 = java.lang.Math.max(r13, r4);
        r13 = r0.mLayoutWidget;
        r13 = r13.getHeight();
        r10 = r0.mMinHeight;
        r10 = java.lang.Math.max(r13, r10);
        r13 = r4;
        r5 = r10;
        r4 = 0;
        r10 = 0;
        r18 = 0;
    L_0x018d:
        r16 = 1;
        if (r4 >= r3) goto L_0x02eb;
    L_0x0191:
        r15 = r0.mVariableDimensionsWidgets;
        r15 = r15.get(r4);
        r15 = (android.support.constraint.solver.widgets.ConstraintWidget) r15;
        r19 = r15.getCompanionWidget();
        r20 = r3;
        r3 = r19;
        r3 = (android.view.View) r3;
        if (r3 != 0) goto L_0x01b3;
    L_0x01a5:
        r25 = r7;
        r24 = r8;
        r22 = r9;
        r23 = r10;
        r21 = r12;
    L_0x01af:
        r3 = r18;
        goto L_0x02d5;
    L_0x01b3:
        r19 = r3.getLayoutParams();
        r21 = r12;
        r12 = r19;
        r12 = (android.support.constraint.ConstraintLayout.LayoutParams) r12;
        r22 = r9;
        r9 = r12.isHelper;
        if (r9 != 0) goto L_0x02cd;
    L_0x01c3:
        r9 = r12.isGuideline;
        if (r9 == 0) goto L_0x01c9;
    L_0x01c7:
        goto L_0x02cd;
    L_0x01c9:
        r9 = r3.getVisibility();
        r23 = r10;
        r10 = 8;
        if (r9 != r10) goto L_0x01d8;
    L_0x01d3:
        r25 = r7;
        r24 = r8;
        goto L_0x01af;
    L_0x01d8:
        if (r14 == 0) goto L_0x01ef;
    L_0x01da:
        r9 = r15.getResolutionWidth();
        r9 = r9.isResolved();
        if (r9 == 0) goto L_0x01ef;
    L_0x01e4:
        r9 = r15.getResolutionHeight();
        r9 = r9.isResolved();
        if (r9 == 0) goto L_0x01ef;
    L_0x01ee:
        goto L_0x01d3;
    L_0x01ef:
        r9 = r12.width;
        r10 = -2;
        if (r9 != r10) goto L_0x01ff;
    L_0x01f4:
        r9 = r12.horizontalDimensionFixed;
        if (r9 == 0) goto L_0x01ff;
    L_0x01f8:
        r9 = r12.width;
        r9 = getChildMeasureSpec(r1, r7, r9);
        goto L_0x0209;
    L_0x01ff:
        r9 = r15.getWidth();
        r10 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r10);
    L_0x0209:
        r10 = r12.height;
        r1 = -2;
        if (r10 != r1) goto L_0x0219;
    L_0x020e:
        r1 = r12.verticalDimensionFixed;
        if (r1 == 0) goto L_0x0219;
    L_0x0212:
        r1 = r12.height;
        r1 = getChildMeasureSpec(r2, r8, r1);
        goto L_0x0223;
    L_0x0219:
        r1 = r15.getHeight();
        r10 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r10);
    L_0x0223:
        r3.measure(r9, r1);
        r1 = r0.mMetrics;
        if (r1 == 0) goto L_0x0237;
    L_0x022a:
        r1 = r0.mMetrics;
        r9 = r1.additionalMeasures;
        r25 = r7;
        r24 = r8;
        r7 = r9 + r16;
        r1.additionalMeasures = r7;
        goto L_0x023b;
    L_0x0237:
        r25 = r7;
        r24 = r8;
    L_0x023b:
        r1 = r3.getMeasuredWidth();
        r7 = r3.getMeasuredHeight();
        r8 = r15.getWidth();
        if (r1 == r8) goto L_0x0273;
    L_0x0249:
        r15.setWidth(r1);
        if (r14 == 0) goto L_0x0255;
    L_0x024e:
        r8 = r15.getResolutionWidth();
        r8.resolve(r1);
    L_0x0255:
        if (r6 == 0) goto L_0x0271;
    L_0x0257:
        r1 = r15.getRight();
        if (r1 <= r13) goto L_0x0271;
    L_0x025d:
        r1 = r15.getRight();
        r8 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT;
        r8 = r15.getAnchor(r8);
        r8 = r8.getMargin();
        r1 = r1 + r8;
        r1 = java.lang.Math.max(r13, r1);
        r13 = r1;
    L_0x0271:
        r23 = 1;
    L_0x0273:
        r1 = r15.getHeight();
        if (r7 == r1) goto L_0x02a3;
    L_0x0279:
        r15.setHeight(r7);
        if (r14 == 0) goto L_0x0285;
    L_0x027e:
        r1 = r15.getResolutionHeight();
        r1.resolve(r7);
    L_0x0285:
        if (r11 == 0) goto L_0x02a1;
    L_0x0287:
        r1 = r15.getBottom();
        if (r1 <= r5) goto L_0x02a1;
    L_0x028d:
        r1 = r15.getBottom();
        r7 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM;
        r7 = r15.getAnchor(r7);
        r7 = r7.getMargin();
        r1 = r1 + r7;
        r1 = java.lang.Math.max(r5, r1);
        r5 = r1;
    L_0x02a1:
        r23 = 1;
    L_0x02a3:
        r1 = r12.needsBaseline;
        if (r1 == 0) goto L_0x02b9;
    L_0x02a7:
        r1 = r3.getBaseline();
        r7 = -1;
        if (r1 == r7) goto L_0x02b9;
    L_0x02ae:
        r7 = r15.getBaselineDistance();
        if (r1 == r7) goto L_0x02b9;
    L_0x02b4:
        r15.setBaselineDistance(r1);
        r23 = 1;
    L_0x02b9:
        r1 = android.os.Build.VERSION.SDK_INT;
        r7 = 11;
        if (r1 < r7) goto L_0x02ca;
    L_0x02bf:
        r1 = r3.getMeasuredState();
        r3 = r18;
        r18 = combineMeasuredStates(r3, r1);
        goto L_0x02d7;
    L_0x02ca:
        r3 = r18;
        goto L_0x02d7;
    L_0x02cd:
        r25 = r7;
        r24 = r8;
        r23 = r10;
        goto L_0x01af;
    L_0x02d5:
        r18 = r3;
    L_0x02d7:
        r10 = r23;
        r4 = r4 + 1;
        r3 = r20;
        r12 = r21;
        r9 = r22;
        r8 = r24;
        r7 = r25;
        r1 = r27;
        r15 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        goto L_0x018d;
    L_0x02eb:
        r20 = r3;
        r25 = r7;
        r24 = r8;
        r22 = r9;
        r23 = r10;
        r21 = r12;
        r3 = r18;
        if (r23 == 0) goto L_0x033a;
    L_0x02fb:
        r1 = r0.mLayoutWidget;
        r4 = r22;
        r1.setWidth(r4);
        r1 = r0.mLayoutWidget;
        r4 = r21;
        r1.setHeight(r4);
        if (r14 == 0) goto L_0x0310;
    L_0x030b:
        r1 = r0.mLayoutWidget;
        r1.solveGraph();
    L_0x0310:
        r1 = "2nd pass";
        r0.solveLinearSystem(r1);
        r1 = r0.mLayoutWidget;
        r1 = r1.getWidth();
        if (r1 >= r13) goto L_0x0324;
    L_0x031d:
        r1 = r0.mLayoutWidget;
        r1.setWidth(r13);
        r11 = 1;
        goto L_0x0325;
    L_0x0324:
        r11 = 0;
    L_0x0325:
        r1 = r0.mLayoutWidget;
        r1 = r1.getHeight();
        if (r1 >= r5) goto L_0x0333;
    L_0x032d:
        r1 = r0.mLayoutWidget;
        r1.setHeight(r5);
        r11 = 1;
    L_0x0333:
        if (r11 == 0) goto L_0x033a;
    L_0x0335:
        r1 = "3rd pass";
        r0.solveLinearSystem(r1);
    L_0x033a:
        r1 = r20;
        r4 = 0;
    L_0x033d:
        if (r4 >= r1) goto L_0x0399;
    L_0x033f:
        r5 = r0.mVariableDimensionsWidgets;
        r5 = r5.get(r4);
        r5 = (android.support.constraint.solver.widgets.ConstraintWidget) r5;
        r6 = r5.getCompanionWidget();
        r6 = (android.view.View) r6;
        if (r6 != 0) goto L_0x0354;
    L_0x034f:
        r8 = 8;
    L_0x0351:
        r9 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        goto L_0x0391;
    L_0x0354:
        r7 = r6.getMeasuredWidth();
        r8 = r5.getWidth();
        if (r7 != r8) goto L_0x0368;
    L_0x035e:
        r7 = r6.getMeasuredHeight();
        r8 = r5.getHeight();
        if (r7 == r8) goto L_0x034f;
    L_0x0368:
        r7 = r5.getVisibility();
        r8 = 8;
        if (r7 == r8) goto L_0x0351;
    L_0x0370:
        r7 = r5.getWidth();
        r9 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r9);
        r5 = r5.getHeight();
        r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r9);
        r6.measure(r7, r5);
        r5 = r0.mMetrics;
        if (r5 == 0) goto L_0x0391;
    L_0x0389:
        r5 = r0.mMetrics;
        r6 = r5.additionalMeasures;
        r10 = r6 + r16;
        r5.additionalMeasures = r10;
    L_0x0391:
        r4 = r4 + 1;
        goto L_0x033d;
    L_0x0394:
        r25 = r7;
        r24 = r8;
        r3 = 0;
    L_0x0399:
        r1 = r0.mLayoutWidget;
        r1 = r1.getWidth();
        r1 = r1 + r25;
        r4 = r0.mLayoutWidget;
        r4 = r4.getHeight();
        r4 = r4 + r24;
        r5 = android.os.Build.VERSION.SDK_INT;
        r6 = 11;
        if (r5 < r6) goto L_0x03e8;
    L_0x03af:
        r5 = r27;
        r1 = resolveSizeAndState(r1, r5, r3);
        r3 = r3 << 16;
        r2 = resolveSizeAndState(r4, r2, r3);
        r3 = 16777215; // 0xffffff float:2.3509886E-38 double:8.2890456E-317;
        r1 = r1 & r3;
        r2 = r2 & r3;
        r3 = r0.mMaxWidth;
        r1 = java.lang.Math.min(r3, r1);
        r3 = r0.mMaxHeight;
        r2 = java.lang.Math.min(r3, r2);
        r3 = r0.mLayoutWidget;
        r3 = r3.isWidthMeasuredTooSmall();
        r4 = 16777216; // 0x1000000 float:2.3509887E-38 double:8.289046E-317;
        if (r3 == 0) goto L_0x03d7;
    L_0x03d6:
        r1 = r1 | r4;
    L_0x03d7:
        r3 = r0.mLayoutWidget;
        r3 = r3.isHeightMeasuredTooSmall();
        if (r3 == 0) goto L_0x03e0;
    L_0x03df:
        r2 = r2 | r4;
    L_0x03e0:
        r0.setMeasuredDimension(r1, r2);
        r0.mLastMeasureWidth = r1;
        r0.mLastMeasureHeight = r2;
        goto L_0x03ef;
    L_0x03e8:
        r0.setMeasuredDimension(r1, r4);
        r0.mLastMeasureWidth = r1;
        r0.mLastMeasureHeight = r4;
    L_0x03ef:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.ConstraintLayout.onMeasure(int, int):void");
    }

    public void onViewAdded(View view) {
        if (VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        ConstraintWidget viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof Guideline)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.widget = new Guideline();
            layoutParams.isGuideline = true;
            ((Guideline) layoutParams.widget).setOrientation(layoutParams.orientation);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.validateParams();
            ((LayoutParams) view.getLayoutParams()).isHelper = true;
            if (!this.mConstraintHelpers.contains(constraintHelper)) {
                this.mConstraintHelpers.add(constraintHelper);
            }
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    public void onViewRemoved(View view) {
        if (VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.mChildrenByIds.remove(view.getId());
        ConstraintWidget viewWidget = getViewWidget(view);
        this.mLayoutWidget.remove(viewWidget);
        this.mConstraintHelpers.remove(view);
        this.mVariableDimensionsWidgets.remove(viewWidget);
        this.mDirtyHierarchy = true;
    }

    public void removeView(View view) {
        super.removeView(view);
        if (VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    public void requestLayout() {
        super.requestLayout();
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        this.mConstraintSet = constraintSet;
    }

    public void setDesignInformation(int i, Object obj, Object obj2) {
        if (i == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.mDesignIds == null) {
                this.mDesignIds = new HashMap();
            }
            obj = (String) obj;
            i = obj.indexOf(HttpUtils.PATHS_SEPARATOR);
            if (i != -1) {
                obj = obj.substring(i + 1);
            }
            this.mDesignIds.put(obj, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    public void setId(int i) {
        this.mChildrenByIds.remove(getId());
        super.setId(i);
        this.mChildrenByIds.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i != this.mMaxHeight) {
            this.mMaxHeight = i;
            requestLayout();
        }
    }

    public void setMaxWidth(int i) {
        if (i != this.mMaxWidth) {
            this.mMaxWidth = i;
            requestLayout();
        }
    }

    public void setMinHeight(int i) {
        if (i != this.mMinHeight) {
            this.mMinHeight = i;
            requestLayout();
        }
    }

    public void setMinWidth(int i) {
        if (i != this.mMinWidth) {
            this.mMinWidth = i;
            requestLayout();
        }
    }

    public void setOptimizationLevel(int i) {
        this.mLayoutWidget.setOptimizationLevel(i);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void solveLinearSystem(String str) {
        this.mLayoutWidget.layout();
        if (this.mMetrics != null) {
            Metrics metrics = this.mMetrics;
            metrics.resolutions++;
        }
    }
}
