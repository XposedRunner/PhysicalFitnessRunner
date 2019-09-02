package android.support.constraint.solver;

import android.support.constraint.solver.SolverVariable.Type;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.constraint.solver.widgets.ConstraintWidget;
import cn.jiguang.net.HttpUtils;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;

public class LinearSystem {
    private static final boolean DEBUG = false;
    public static final boolean FULL_DEBUG = false;
    private static int POOL_SIZE = 1000;
    public static Metrics sMetrics;
    private int TABLE_SIZE;
    public boolean graphOptimizer;
    private boolean[] mAlreadyTestedCandidates;
    final Cache mCache;
    private Row mGoal;
    private int mMaxColumns;
    private int mMaxRows;
    int mNumColumns;
    int mNumRows;
    private SolverVariable[] mPoolVariables;
    private int mPoolVariablesCount;
    ArrayRow[] mRows;
    private final Row mTempGoal;
    private HashMap<String, SolverVariable> mVariables;
    int mVariablesID;
    private ArrayRow[] tempClientsCopy;

    interface Row {
        void addError(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr);

        void initFromRow(Row row);

        boolean isEmpty();
    }

    public LinearSystem() {
        this.mVariablesID = 0;
        this.mVariables = null;
        this.TABLE_SIZE = 32;
        this.mMaxColumns = this.TABLE_SIZE;
        this.mRows = null;
        this.graphOptimizer = false;
        this.mAlreadyTestedCandidates = new boolean[this.TABLE_SIZE];
        this.mNumColumns = 1;
        this.mNumRows = 0;
        this.mMaxRows = this.TABLE_SIZE;
        this.mPoolVariables = new SolverVariable[POOL_SIZE];
        this.mPoolVariablesCount = 0;
        this.tempClientsCopy = new ArrayRow[this.TABLE_SIZE];
        this.mRows = new ArrayRow[this.TABLE_SIZE];
        releaseRows();
        this.mCache = new Cache();
        this.mGoal = new GoalRow(this.mCache);
        this.mTempGoal = new ArrayRow(this.mCache);
    }

    private SolverVariable acquireSolverVariable(Type type, String str) {
        SolverVariable solverVariable = (SolverVariable) this.mCache.solverVariablePool.acquire();
        if (solverVariable == null) {
            solverVariable = new SolverVariable(type, str);
            solverVariable.setType(type, str);
        } else {
            solverVariable.reset();
            solverVariable.setType(type, str);
        }
        if (this.mPoolVariablesCount >= POOL_SIZE) {
            POOL_SIZE *= 2;
            this.mPoolVariables = (SolverVariable[]) Arrays.copyOf(this.mPoolVariables, POOL_SIZE);
        }
        SolverVariable[] solverVariableArr = this.mPoolVariables;
        int i = this.mPoolVariablesCount;
        this.mPoolVariablesCount = i + 1;
        solverVariableArr[i] = solverVariable;
        return solverVariable;
    }

    private void addError(ArrayRow arrayRow) {
        arrayRow.addError(this, 0);
    }

    private final void addRow(ArrayRow arrayRow) {
        if (this.mRows[this.mNumRows] != null) {
            this.mCache.arrayRowPool.release(this.mRows[this.mNumRows]);
        }
        this.mRows[this.mNumRows] = arrayRow;
        arrayRow.variable.definitionId = this.mNumRows;
        this.mNumRows++;
        arrayRow.variable.updateReferencesWithNewDefinition(arrayRow);
    }

    private void addSingleError(ArrayRow arrayRow, int i) {
        addSingleError(arrayRow, i, 0);
    }

    private void computeValues() {
        for (int i = 0; i < this.mNumRows; i++) {
            ArrayRow arrayRow = this.mRows[i];
            arrayRow.variable.computedValue = arrayRow.constantValue;
        }
    }

    public static ArrayRow createRowCentering(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2, boolean z) {
        ArrayRow createRow = linearSystem.createRow();
        createRow.createRowCentering(solverVariable, solverVariable2, i, f, solverVariable3, solverVariable4, i2);
        if (z) {
            createRow.addError(linearSystem, 4);
        }
        return createRow;
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, float f, boolean z) {
        ArrayRow createRow = linearSystem.createRow();
        if (z) {
            linearSystem.addError(createRow);
        }
        return createRow.createRowDimensionPercent(solverVariable, solverVariable2, solverVariable3, f);
    }

    public static ArrayRow createRowEquals(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, int i, boolean z) {
        ArrayRow createRow = linearSystem.createRow();
        createRow.createRowEquals(solverVariable, solverVariable2, i);
        if (z) {
            linearSystem.addSingleError(createRow, 1);
        }
        return createRow;
    }

    public static ArrayRow createRowGreaterThan(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, int i, boolean z) {
        SolverVariable createSlackVariable = linearSystem.createSlackVariable();
        ArrayRow createRow = linearSystem.createRow();
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i);
        if (z) {
            linearSystem.addSingleError(createRow, (int) (-1.0f * createRow.variables.get(createSlackVariable)));
        }
        return createRow;
    }

    public static ArrayRow createRowLowerThan(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, int i, boolean z) {
        SolverVariable createSlackVariable = linearSystem.createSlackVariable();
        ArrayRow createRow = linearSystem.createRow();
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i);
        if (z) {
            linearSystem.addSingleError(createRow, (int) (-1.0f * createRow.variables.get(createSlackVariable)));
        }
        return createRow;
    }

    private SolverVariable createVariable(String str, Type type) {
        if (sMetrics != null) {
            Metrics metrics = sMetrics;
            metrics.variables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(type, null);
        acquireSolverVariable.setName(str);
        this.mVariablesID++;
        this.mNumColumns++;
        acquireSolverVariable.id = this.mVariablesID;
        if (this.mVariables == null) {
            this.mVariables = new HashMap();
        }
        this.mVariables.put(str, acquireSolverVariable);
        this.mCache.mIndexedVariables[this.mVariablesID] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    private void displayRows() {
        displaySolverVariables();
        String str = "";
        for (int i = 0; i < this.mNumRows; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(this.mRows[i]);
            str = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("\n");
            str = stringBuilder.toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(this.mGoal);
        stringBuilder2.append("\n");
        System.out.println(stringBuilder2.toString());
    }

    private void displaySolverVariables() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Display Rows (");
        stringBuilder.append(this.mNumRows);
        stringBuilder.append("x");
        stringBuilder.append(this.mNumColumns);
        stringBuilder.append(")\n");
        System.out.println(stringBuilder.toString());
    }

    private int enforceBFS(Row row) throws Exception {
        float f;
        Object obj;
        int i = 0;
        while (true) {
            f = 0.0f;
            if (i >= this.mNumRows) {
                obj = null;
                break;
            } else if (this.mRows[i].variable.mType != Type.UNRESTRICTED && this.mRows[i].constantValue < 0.0f) {
                obj = 1;
                break;
            } else {
                i++;
            }
        }
        if (obj == null) {
            return 0;
        }
        obj = null;
        int i2 = 0;
        while (obj == null) {
            if (sMetrics != null) {
                Metrics metrics = sMetrics;
                metrics.bfs++;
            }
            i2++;
            float f2 = Float.MAX_VALUE;
            int i3 = -1;
            int i4 = i3;
            int i5 = 0;
            int i6 = 0;
            while (i5 < this.mNumRows) {
                ArrayRow arrayRow = this.mRows[i5];
                if (!(arrayRow.variable.mType == Type.UNRESTRICTED || arrayRow.isSimpleDefinition || arrayRow.constantValue >= r4)) {
                    int i7 = 1;
                    while (i7 < this.mNumColumns) {
                        SolverVariable solverVariable = this.mCache.mIndexedVariables[i7];
                        float f3 = arrayRow.variables.get(solverVariable);
                        if (f3 > f) {
                            int i8 = i6;
                            float f4 = f2;
                            int i9 = i4;
                            i4 = i3;
                            i3 = 0;
                            while (i3 < 7) {
                                float f5 = solverVariable.strengthVector[i3] / f3;
                                if ((f5 < f4 && i3 == i8) || i3 > i8) {
                                    i9 = i7;
                                    i4 = i5;
                                    f4 = f5;
                                    i8 = i3;
                                }
                                i3++;
                            }
                            i3 = i4;
                            i4 = i9;
                            f2 = f4;
                            i6 = i8;
                        }
                        i7++;
                        f = 0.0f;
                    }
                }
                i5++;
                f = 0.0f;
            }
            if (i3 != -1) {
                ArrayRow arrayRow2 = this.mRows[i3];
                arrayRow2.variable.definitionId = -1;
                if (sMetrics != null) {
                    Metrics metrics2 = sMetrics;
                    metrics2.pivots++;
                }
                arrayRow2.pivot(this.mCache.mIndexedVariables[i4]);
                arrayRow2.variable.definitionId = i3;
                arrayRow2.variable.updateReferencesWithNewDefinition(arrayRow2);
            } else {
                obj = 1;
            }
            if (i2 > this.mNumColumns / 2) {
                obj = 1;
            }
            f = 0.0f;
        }
        return i2;
    }

    private String getDisplaySize(int i) {
        i *= 4;
        int i2 = i / 1024;
        int i3 = i2 / 1024;
        StringBuilder stringBuilder;
        if (i3 > 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(i3);
            stringBuilder.append(" Mb");
            return stringBuilder.toString();
        } else if (i2 > 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(i2);
            stringBuilder.append(" Kb");
            return stringBuilder.toString();
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("");
            stringBuilder2.append(i);
            stringBuilder2.append(" bytes");
            return stringBuilder2.toString();
        }
    }

    private String getDisplayStrength(int i) {
        return i == 1 ? "LOW" : i == 2 ? "MEDIUM" : i == 3 ? "HIGH" : i == 4 ? "HIGHEST" : i == 5 ? "EQUALITY" : i == 6 ? "FIXED" : "NONE";
    }

    public static Metrics getMetrics() {
        return sMetrics;
    }

    private void increaseTableSize() {
        this.TABLE_SIZE *= 2;
        this.mRows = (ArrayRow[]) Arrays.copyOf(this.mRows, this.TABLE_SIZE);
        this.mCache.mIndexedVariables = (SolverVariable[]) Arrays.copyOf(this.mCache.mIndexedVariables, this.TABLE_SIZE);
        this.mAlreadyTestedCandidates = new boolean[this.TABLE_SIZE];
        this.mMaxColumns = this.TABLE_SIZE;
        this.mMaxRows = this.TABLE_SIZE;
        if (sMetrics != null) {
            Metrics metrics = sMetrics;
            metrics.tableSizeIncrease++;
            sMetrics.maxTableSize = Math.max(sMetrics.maxTableSize, (long) this.TABLE_SIZE);
            sMetrics.lastTableSize = sMetrics.maxTableSize;
        }
    }

    private final int optimize(Row row, boolean z) {
        if (sMetrics != null) {
            Metrics metrics = sMetrics;
            metrics.optimize++;
        }
        for (int i = 0; i < this.mNumColumns; i++) {
            this.mAlreadyTestedCandidates[i] = false;
        }
        boolean z2 = false;
        int i2 = z2;
        while (!z2) {
            if (sMetrics != null) {
                Metrics metrics2 = sMetrics;
                metrics2.iterations++;
            }
            i2++;
            if (i2 >= 2 * this.mNumColumns) {
                return i2;
            }
            if (row.getKey() != null) {
                this.mAlreadyTestedCandidates[row.getKey().id] = true;
            }
            SolverVariable pivotCandidate = row.getPivotCandidate(this, this.mAlreadyTestedCandidates);
            if (pivotCandidate != null) {
                if (this.mAlreadyTestedCandidates[pivotCandidate.id]) {
                    return i2;
                }
                this.mAlreadyTestedCandidates[pivotCandidate.id] = true;
            }
            if (pivotCandidate != null) {
                float f = Float.MAX_VALUE;
                int i3 = -1;
                for (int i4 = 0; i4 < this.mNumRows; i4++) {
                    ArrayRow arrayRow = this.mRows[i4];
                    if (!(arrayRow.variable.mType == Type.UNRESTRICTED || arrayRow.isSimpleDefinition || !arrayRow.hasVariable(pivotCandidate))) {
                        float f2 = arrayRow.variables.get(pivotCandidate);
                        if (f2 < 0.0f) {
                            float f3 = (-arrayRow.constantValue) / f2;
                            if (f3 < f) {
                                i3 = i4;
                                f = f3;
                            }
                        }
                    }
                }
                if (i3 > -1) {
                    ArrayRow arrayRow2 = this.mRows[i3];
                    arrayRow2.variable.definitionId = -1;
                    if (sMetrics != null) {
                        Metrics metrics3 = sMetrics;
                        metrics3.pivots++;
                    }
                    arrayRow2.pivot(pivotCandidate);
                    arrayRow2.variable.definitionId = i3;
                    arrayRow2.variable.updateReferencesWithNewDefinition(arrayRow2);
                }
            }
            z2 = true;
        }
        return i2;
    }

    private void releaseRows() {
        for (int i = 0; i < this.mRows.length; i++) {
            Object obj = this.mRows[i];
            if (obj != null) {
                this.mCache.arrayRowPool.release(obj);
            }
            this.mRows[i] = null;
        }
    }

    private final void updateRowFromVariables(ArrayRow arrayRow) {
        if (this.mNumRows > 0) {
            arrayRow.variables.updateFromSystem(arrayRow, this.mRows);
            if (arrayRow.variables.currentSize == 0) {
                arrayRow.isSimpleDefinition = true;
            }
        }
    }

    public void addCenterPoint(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f, int i) {
        ConstraintWidget constraintWidget3 = constraintWidget;
        ConstraintWidget constraintWidget4 = constraintWidget2;
        SolverVariable createObjectVariable = createObjectVariable(constraintWidget3.getAnchor(ConstraintAnchor.Type.LEFT));
        SolverVariable createObjectVariable2 = createObjectVariable(constraintWidget3.getAnchor(ConstraintAnchor.Type.TOP));
        SolverVariable createObjectVariable3 = createObjectVariable(constraintWidget3.getAnchor(ConstraintAnchor.Type.RIGHT));
        SolverVariable createObjectVariable4 = createObjectVariable(constraintWidget3.getAnchor(ConstraintAnchor.Type.BOTTOM));
        SolverVariable createObjectVariable5 = createObjectVariable(constraintWidget4.getAnchor(ConstraintAnchor.Type.LEFT));
        SolverVariable createObjectVariable6 = createObjectVariable(constraintWidget4.getAnchor(ConstraintAnchor.Type.TOP));
        SolverVariable createObjectVariable7 = createObjectVariable(constraintWidget4.getAnchor(ConstraintAnchor.Type.RIGHT));
        SolverVariable createObjectVariable8 = createObjectVariable(constraintWidget4.getAnchor(ConstraintAnchor.Type.BOTTOM));
        ArrayRow createRow = createRow();
        double d = (double) f;
        SolverVariable solverVariable = createObjectVariable3;
        double d2 = (double) i;
        SolverVariable solverVariable2 = createObjectVariable7;
        createRow.createRowWithAngle(createObjectVariable2, createObjectVariable4, createObjectVariable6, createObjectVariable8, (float) (Math.sin(d) * d2));
        addConstraint(createRow);
        createRow = createRow();
        createRow.createRowWithAngle(createObjectVariable, solverVariable, createObjectVariable5, solverVariable2, (float) (Math.cos(d) * d2));
        addConstraint(createRow);
    }

    public void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2, int i3) {
        int i4 = i3;
        ArrayRow createRow = createRow();
        createRow.createRowCentering(solverVariable, solverVariable2, i, f, solverVariable3, solverVariable4, i2);
        if (i4 != 6) {
            createRow.addError(this, i4);
        }
        addConstraint(createRow);
    }

    public void addConstraint(ArrayRow arrayRow) {
        if (arrayRow != null) {
            if (sMetrics != null) {
                Metrics metrics = sMetrics;
                metrics.constraints++;
                if (arrayRow.isSimpleDefinition) {
                    metrics = sMetrics;
                    metrics.simpleconstraints++;
                }
            }
            if (this.mNumRows + 1 >= this.mMaxRows || this.mNumColumns + 1 >= this.mMaxColumns) {
                increaseTableSize();
            }
            int i = 0;
            if (!arrayRow.isSimpleDefinition) {
                updateRowFromVariables(arrayRow);
                if (!arrayRow.isEmpty()) {
                    arrayRow.ensurePositiveConstant();
                    if (arrayRow.chooseSubject(this)) {
                        SolverVariable createExtraVariable = createExtraVariable();
                        arrayRow.variable = createExtraVariable;
                        addRow(arrayRow);
                        this.mTempGoal.initFromRow(arrayRow);
                        optimize(this.mTempGoal, true);
                        if (createExtraVariable.definitionId == -1) {
                            if (arrayRow.variable == createExtraVariable) {
                                createExtraVariable = arrayRow.pickPivot(createExtraVariable);
                                if (createExtraVariable != null) {
                                    if (sMetrics != null) {
                                        Metrics metrics2 = sMetrics;
                                        metrics2.pivots++;
                                    }
                                    arrayRow.pivot(createExtraVariable);
                                }
                            }
                            if (!arrayRow.isSimpleDefinition) {
                                arrayRow.variable.updateReferencesWithNewDefinition(arrayRow);
                            }
                            this.mNumRows--;
                        }
                        i = 1;
                    }
                    if (!arrayRow.hasKeyVariable()) {
                        return;
                    }
                }
                return;
            }
            if (i == 0) {
                addRow(arrayRow);
            }
        }
    }

    public ArrayRow addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow createRow = createRow();
        createRow.createRowEquals(solverVariable, solverVariable2, i);
        if (i2 != 6) {
            createRow.addError(this, i2);
        }
        addConstraint(createRow);
        return createRow;
    }

    public void addEquality(SolverVariable solverVariable, int i) {
        int i2 = solverVariable.definitionId;
        ArrayRow arrayRow;
        if (solverVariable.definitionId != -1) {
            arrayRow = this.mRows[i2];
            if (arrayRow.isSimpleDefinition) {
                arrayRow.constantValue = (float) i;
                return;
            } else if (arrayRow.variables.currentSize == 0) {
                arrayRow.isSimpleDefinition = true;
                arrayRow.constantValue = (float) i;
                return;
            } else {
                arrayRow = createRow();
                arrayRow.createRowEquals(solverVariable, i);
                addConstraint(arrayRow);
                return;
            }
        }
        arrayRow = createRow();
        arrayRow.createRowDefinition(solverVariable, i);
        addConstraint(arrayRow);
    }

    public void addEquality(SolverVariable solverVariable, int i, int i2) {
        int i3 = solverVariable.definitionId;
        ArrayRow arrayRow;
        if (solverVariable.definitionId != -1) {
            arrayRow = this.mRows[i3];
            if (arrayRow.isSimpleDefinition) {
                arrayRow.constantValue = (float) i;
                return;
            }
            arrayRow = createRow();
            arrayRow.createRowEquals(solverVariable, i);
            arrayRow.addError(this, i2);
            addConstraint(arrayRow);
            return;
        }
        arrayRow = createRow();
        arrayRow.createRowDefinition(solverVariable, i);
        arrayRow.addError(this, i2);
        addConstraint(arrayRow);
    }

    public void addGreaterBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, boolean z) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, 0);
        if (z) {
            addSingleError(createRow, (int) (-1.0f * createRow.variables.get(createSlackVariable)), 1);
        }
        addConstraint(createRow);
    }

    public void addGreaterThan(SolverVariable solverVariable, int i) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, i, createSlackVariable);
        addConstraint(createRow);
    }

    public void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i);
        if (i2 != 6) {
            addSingleError(createRow, (int) (-1.0f * createRow.variables.get(createSlackVariable)), i2);
        }
        addConstraint(createRow);
    }

    public void addLowerBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, boolean z) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, 0);
        if (z) {
            addSingleError(createRow, (int) (-1.0f * createRow.variables.get(createSlackVariable)), 1);
        }
        addConstraint(createRow);
    }

    public void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i);
        if (i2 != 6) {
            addSingleError(createRow, (int) (-1.0f * createRow.variables.get(createSlackVariable)), i2);
        }
        addConstraint(createRow);
    }

    public void addRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f, int i) {
        ArrayRow createRow = createRow();
        createRow.createRowDimensionRatio(solverVariable, solverVariable2, solverVariable3, solverVariable4, f);
        if (i != 6) {
            createRow.addError(this, i);
        }
        addConstraint(createRow);
    }

    /* Access modifiers changed, original: 0000 */
    public void addSingleError(ArrayRow arrayRow, int i, int i2) {
        arrayRow.addSingleError(createErrorVariable(i2, null), i);
    }

    public SolverVariable createErrorVariable(int i, String str) {
        if (sMetrics != null) {
            Metrics metrics = sMetrics;
            metrics.errors++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(Type.ERROR, str);
        this.mVariablesID++;
        this.mNumColumns++;
        acquireSolverVariable.id = this.mVariablesID;
        acquireSolverVariable.strength = i;
        this.mCache.mIndexedVariables[this.mVariablesID] = acquireSolverVariable;
        this.mGoal.addError(acquireSolverVariable);
        return acquireSolverVariable;
    }

    public SolverVariable createExtraVariable() {
        if (sMetrics != null) {
            Metrics metrics = sMetrics;
            metrics.extravariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(Type.SLACK, null);
        this.mVariablesID++;
        this.mNumColumns++;
        acquireSolverVariable.id = this.mVariablesID;
        this.mCache.mIndexedVariables[this.mVariablesID] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    public SolverVariable createObjectVariable(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.getSolverVariable();
            if (solverVariable == null) {
                constraintAnchor.resetSolverVariable(this.mCache);
                solverVariable = constraintAnchor.getSolverVariable();
            }
            if (solverVariable.id == -1 || solverVariable.id > this.mVariablesID || this.mCache.mIndexedVariables[solverVariable.id] == null) {
                if (solverVariable.id != -1) {
                    solverVariable.reset();
                }
                this.mVariablesID++;
                this.mNumColumns++;
                solverVariable.id = this.mVariablesID;
                solverVariable.mType = Type.UNRESTRICTED;
                this.mCache.mIndexedVariables[this.mVariablesID] = solverVariable;
            }
        }
        return solverVariable;
    }

    public ArrayRow createRow() {
        ArrayRow arrayRow = (ArrayRow) this.mCache.arrayRowPool.acquire();
        if (arrayRow == null) {
            arrayRow = new ArrayRow(this.mCache);
        } else {
            arrayRow.reset();
        }
        SolverVariable.increaseErrorId();
        return arrayRow;
    }

    public SolverVariable createSlackVariable() {
        if (sMetrics != null) {
            Metrics metrics = sMetrics;
            metrics.slackvariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(Type.SLACK, null);
        this.mVariablesID++;
        this.mNumColumns++;
        acquireSolverVariable.id = this.mVariablesID;
        this.mCache.mIndexedVariables[this.mVariablesID] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    /* Access modifiers changed, original: 0000 */
    public void displayReadableRows() {
        displaySolverVariables();
        String str = " #  ";
        for (int i = 0; i < this.mNumRows; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(this.mRows[i].toReadableString());
            str = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("\n #  ");
            str = stringBuilder.toString();
        }
        if (this.mGoal != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(this.mGoal);
            stringBuilder2.append("\n");
            str = stringBuilder2.toString();
        }
        System.out.println(str);
    }

    /* Access modifiers changed, original: 0000 */
    public void displaySystemInformations() {
        int i = 0;
        int i2 = i;
        while (i < this.TABLE_SIZE) {
            if (this.mRows[i] != null) {
                i2 += this.mRows[i].sizeInBytes();
            }
            i++;
        }
        i = 0;
        int i3 = i;
        while (i < this.mNumRows) {
            if (this.mRows[i] != null) {
                i3 += this.mRows[i].sizeInBytes();
            }
            i++;
        }
        PrintStream printStream = System.out;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Linear System -> Table size: ");
        stringBuilder.append(this.TABLE_SIZE);
        stringBuilder.append(" (");
        stringBuilder.append(getDisplaySize(this.TABLE_SIZE * this.TABLE_SIZE));
        stringBuilder.append(") -- row sizes: ");
        stringBuilder.append(getDisplaySize(i2));
        stringBuilder.append(", actual size: ");
        stringBuilder.append(getDisplaySize(i3));
        stringBuilder.append(" rows: ");
        stringBuilder.append(this.mNumRows);
        stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
        stringBuilder.append(this.mMaxRows);
        stringBuilder.append(" cols: ");
        stringBuilder.append(this.mNumColumns);
        stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
        stringBuilder.append(this.mMaxColumns);
        stringBuilder.append(" ");
        stringBuilder.append(0);
        stringBuilder.append(" occupied cells, ");
        stringBuilder.append(getDisplaySize(0));
        printStream.println(stringBuilder.toString());
    }

    public void displayVariablesReadableRows() {
        displaySolverVariables();
        String str = "";
        for (int i = 0; i < this.mNumRows; i++) {
            if (this.mRows[i].variable.mType == Type.UNRESTRICTED) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(this.mRows[i].toReadableString());
                str = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("\n");
                str = stringBuilder.toString();
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(this.mGoal);
        stringBuilder2.append("\n");
        System.out.println(stringBuilder2.toString());
    }

    public void fillMetrics(Metrics metrics) {
        sMetrics = metrics;
    }

    public Cache getCache() {
        return this.mCache;
    }

    /* Access modifiers changed, original: 0000 */
    public Row getGoal() {
        return this.mGoal;
    }

    public int getMemoryUsed() {
        int i = 0;
        int i2 = 0;
        while (i < this.mNumRows) {
            if (this.mRows[i] != null) {
                i2 += this.mRows[i].sizeInBytes();
            }
            i++;
        }
        return i2;
    }

    public int getNumEquations() {
        return this.mNumRows;
    }

    public int getNumVariables() {
        return this.mVariablesID;
    }

    public int getObjectVariableValue(Object obj) {
        SolverVariable solverVariable = ((ConstraintAnchor) obj).getSolverVariable();
        return solverVariable != null ? (int) (solverVariable.computedValue + 0.5f) : 0;
    }

    /* Access modifiers changed, original: 0000 */
    public ArrayRow getRow(int i) {
        return this.mRows[i];
    }

    /* Access modifiers changed, original: 0000 */
    public float getValueFor(String str) {
        SolverVariable variable = getVariable(str, Type.UNRESTRICTED);
        return variable == null ? 0.0f : variable.computedValue;
    }

    /* Access modifiers changed, original: 0000 */
    public SolverVariable getVariable(String str, Type type) {
        if (this.mVariables == null) {
            this.mVariables = new HashMap();
        }
        SolverVariable solverVariable = (SolverVariable) this.mVariables.get(str);
        return solverVariable == null ? createVariable(str, type) : solverVariable;
    }

    public void minimize() throws Exception {
        Metrics metrics;
        if (sMetrics != null) {
            metrics = sMetrics;
            metrics.minimize++;
        }
        if (this.graphOptimizer) {
            if (sMetrics != null) {
                metrics = sMetrics;
                metrics.graphOptimizer++;
            }
            Object obj = null;
            for (int i = 0; i < this.mNumRows; i++) {
                if (!this.mRows[i].isSimpleDefinition) {
                    break;
                }
            }
            obj = 1;
            if (obj == null) {
                minimizeGoal(this.mGoal);
                return;
            }
            if (sMetrics != null) {
                metrics = sMetrics;
                metrics.fullySolved++;
            }
            computeValues();
            return;
        }
        minimizeGoal(this.mGoal);
    }

    /* Access modifiers changed, original: 0000 */
    public void minimizeGoal(Row row) throws Exception {
        if (sMetrics != null) {
            Metrics metrics = sMetrics;
            metrics.minimizeGoal++;
            sMetrics.maxVariables = Math.max(sMetrics.maxVariables, (long) this.mNumColumns);
            sMetrics.maxRows = Math.max(sMetrics.maxRows, (long) this.mNumRows);
        }
        updateRowFromVariables((ArrayRow) row);
        enforceBFS(row);
        optimize(row, false);
        computeValues();
    }

    public void reset() {
        int i;
        for (SolverVariable solverVariable : this.mCache.mIndexedVariables) {
            if (solverVariable != null) {
                solverVariable.reset();
            }
        }
        this.mCache.solverVariablePool.releaseAll(this.mPoolVariables, this.mPoolVariablesCount);
        this.mPoolVariablesCount = 0;
        Arrays.fill(this.mCache.mIndexedVariables, null);
        if (this.mVariables != null) {
            this.mVariables.clear();
        }
        this.mVariablesID = 0;
        this.mGoal.clear();
        this.mNumColumns = 1;
        for (i = 0; i < this.mNumRows; i++) {
            this.mRows[i].used = false;
        }
        releaseRows();
        this.mNumRows = 0;
    }
}
