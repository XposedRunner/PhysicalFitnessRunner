package android.support.constraint.solver;

import android.support.constraint.solver.SolverVariable.Type;
import java.io.PrintStream;
import java.util.Arrays;

public class ArrayLinkedVariables {
    private static final boolean DEBUG = false;
    private static final boolean FULL_NEW_CHECK = false;
    private static final int NONE = -1;
    private int ROW_SIZE = 8;
    private SolverVariable candidate = null;
    int currentSize = 0;
    private int[] mArrayIndices = new int[this.ROW_SIZE];
    private int[] mArrayNextIndices = new int[this.ROW_SIZE];
    private float[] mArrayValues = new float[this.ROW_SIZE];
    private final Cache mCache;
    private boolean mDidFillOnce = false;
    private int mHead = -1;
    private int mLast = -1;
    private final ArrayRow mRow;

    ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
    }

    private boolean isNew(SolverVariable solverVariable, LinearSystem linearSystem) {
        return solverVariable.usageInRowCount <= 1;
    }

    /* Access modifiers changed, original: final */
    public final void add(SolverVariable solverVariable, float f, boolean z) {
        if (f != 0.0f) {
            if (this.mHead == -1) {
                this.mHead = 0;
                this.mArrayValues[this.mHead] = f;
                this.mArrayIndices[this.mHead] = solverVariable.id;
                this.mArrayNextIndices[this.mHead] = -1;
                solverVariable.usageInRowCount++;
                solverVariable.addToRow(this.mRow);
                this.currentSize++;
                if (!this.mDidFillOnce) {
                    this.mLast++;
                    if (this.mLast >= this.mArrayIndices.length) {
                        this.mDidFillOnce = true;
                        this.mLast = this.mArrayIndices.length - 1;
                    }
                }
                return;
            }
            int i = this.mHead;
            int i2 = 0;
            int i3 = -1;
            while (i != -1 && i2 < this.currentSize) {
                if (this.mArrayIndices[i] == solverVariable.id) {
                    float[] fArr = this.mArrayValues;
                    fArr[i] = fArr[i] + f;
                    if (this.mArrayValues[i] == 0.0f) {
                        if (i == this.mHead) {
                            this.mHead = this.mArrayNextIndices[i];
                        } else {
                            this.mArrayNextIndices[i3] = this.mArrayNextIndices[i];
                        }
                        if (z) {
                            solverVariable.removeFromRow(this.mRow);
                        }
                        if (this.mDidFillOnce) {
                            this.mLast = i;
                        }
                        solverVariable.usageInRowCount--;
                        this.currentSize--;
                    }
                    return;
                }
                if (this.mArrayIndices[i] < solverVariable.id) {
                    i3 = i;
                }
                i = this.mArrayNextIndices[i];
                i2++;
            }
            int i4 = this.mLast + 1;
            if (this.mDidFillOnce) {
                i4 = this.mArrayIndices[this.mLast] == -1 ? this.mLast : this.mArrayIndices.length;
            }
            if (i4 >= this.mArrayIndices.length && this.currentSize < this.mArrayIndices.length) {
                for (int i5 = 0; i5 < this.mArrayIndices.length; i5++) {
                    if (this.mArrayIndices[i5] == -1) {
                        i4 = i5;
                        break;
                    }
                }
            }
            if (i4 >= this.mArrayIndices.length) {
                i4 = this.mArrayIndices.length;
                this.ROW_SIZE *= 2;
                this.mDidFillOnce = false;
                this.mLast = i4 - 1;
                this.mArrayValues = Arrays.copyOf(this.mArrayValues, this.ROW_SIZE);
                this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
                this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
            }
            this.mArrayIndices[i4] = solverVariable.id;
            this.mArrayValues[i4] = f;
            if (i3 != -1) {
                this.mArrayNextIndices[i4] = this.mArrayNextIndices[i3];
                this.mArrayNextIndices[i3] = i4;
            } else {
                this.mArrayNextIndices[i4] = this.mHead;
                this.mHead = i4;
            }
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.currentSize++;
            if (!this.mDidFillOnce) {
                this.mLast++;
            }
            if (this.mLast >= this.mArrayIndices.length) {
                this.mDidFillOnce = true;
                this.mLast = this.mArrayIndices.length - 1;
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0094 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0094 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004b  */
    public android.support.constraint.solver.SolverVariable chooseSubject(android.support.constraint.solver.LinearSystem r15) {
        /*
        r14 = this;
        r0 = r14.mHead;
        r1 = 0;
        r2 = 0;
        r3 = 0;
        r4 = r1;
        r6 = r2;
        r8 = r6;
        r5 = r3;
        r7 = r5;
    L_0x000a:
        r9 = -1;
        if (r0 == r9) goto L_0x009c;
    L_0x000d:
        r9 = r14.currentSize;
        if (r2 >= r9) goto L_0x009c;
    L_0x0011:
        r9 = r14.mArrayValues;
        r9 = r9[r0];
        r10 = 981668463; // 0x3a83126f float:0.001 double:4.85008663E-315;
        r11 = r14.mCache;
        r11 = r11.mIndexedVariables;
        r12 = r14.mArrayIndices;
        r12 = r12[r0];
        r11 = r11[r12];
        r12 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1));
        if (r12 >= 0) goto L_0x0038;
    L_0x0026:
        r10 = -1165815185; // 0xffffffffba83126f float:-0.001 double:NaN;
        r10 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1));
        if (r10 <= 0) goto L_0x0046;
    L_0x002d:
        r9 = r14.mArrayValues;
        r9[r0] = r3;
        r9 = r14.mRow;
        r11.removeFromRow(r9);
    L_0x0036:
        r9 = r3;
        goto L_0x0046;
    L_0x0038:
        r10 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1));
        if (r10 >= 0) goto L_0x0046;
    L_0x003c:
        r9 = r14.mArrayValues;
        r9[r0] = r3;
        r9 = r14.mRow;
        r11.removeFromRow(r9);
        goto L_0x0036;
    L_0x0046:
        r10 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1));
        r12 = 1;
        if (r10 == 0) goto L_0x0094;
    L_0x004b:
        r10 = r11.mType;
        r13 = android.support.constraint.solver.SolverVariable.Type.UNRESTRICTED;
        if (r10 != r13) goto L_0x0070;
    L_0x0051:
        if (r1 != 0) goto L_0x005b;
    L_0x0053:
        r1 = r14.isNew(r11, r15);
    L_0x0057:
        r6 = r1;
        r5 = r9;
        r1 = r11;
        goto L_0x0094;
    L_0x005b:
        r10 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1));
        if (r10 <= 0) goto L_0x0064;
    L_0x005f:
        r1 = r14.isNew(r11, r15);
        goto L_0x0057;
    L_0x0064:
        if (r6 != 0) goto L_0x0094;
    L_0x0066:
        r10 = r14.isNew(r11, r15);
        if (r10 == 0) goto L_0x0094;
    L_0x006c:
        r5 = r9;
        r1 = r11;
        r6 = r12;
        goto L_0x0094;
    L_0x0070:
        if (r1 != 0) goto L_0x0094;
    L_0x0072:
        r10 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1));
        if (r10 >= 0) goto L_0x0094;
    L_0x0076:
        if (r4 != 0) goto L_0x0080;
    L_0x0078:
        r4 = r14.isNew(r11, r15);
    L_0x007c:
        r8 = r4;
        r7 = r9;
        r4 = r11;
        goto L_0x0094;
    L_0x0080:
        r10 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));
        if (r10 <= 0) goto L_0x0089;
    L_0x0084:
        r4 = r14.isNew(r11, r15);
        goto L_0x007c;
    L_0x0089:
        if (r8 != 0) goto L_0x0094;
    L_0x008b:
        r10 = r14.isNew(r11, r15);
        if (r10 == 0) goto L_0x0094;
    L_0x0091:
        r7 = r9;
        r4 = r11;
        r8 = r12;
    L_0x0094:
        r9 = r14.mArrayNextIndices;
        r0 = r9[r0];
        r2 = r2 + 1;
        goto L_0x000a;
    L_0x009c:
        if (r1 == 0) goto L_0x009f;
    L_0x009e:
        return r1;
    L_0x009f:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.ArrayLinkedVariables.chooseSubject(android.support.constraint.solver.LinearSystem):android.support.constraint.solver.SolverVariable");
    }

    public final void clear() {
        int i = this.mHead;
        int i2 = 0;
        while (i != -1 && i2 < this.currentSize) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[i]];
            if (solverVariable != null) {
                solverVariable.removeFromRow(this.mRow);
            }
            i = this.mArrayNextIndices[i];
            i2++;
        }
        this.mHead = -1;
        this.mLast = -1;
        this.mDidFillOnce = false;
        this.currentSize = 0;
    }

    /* Access modifiers changed, original: final */
    public final boolean containsKey(SolverVariable solverVariable) {
        if (this.mHead == -1) {
            return false;
        }
        int i = this.mHead;
        int i2 = 0;
        while (i != -1 && i2 < this.currentSize) {
            if (this.mArrayIndices[i] == solverVariable.id) {
                return true;
            }
            i = this.mArrayNextIndices[i];
            i2++;
        }
        return false;
    }

    public void display() {
        int i = this.currentSize;
        System.out.print("{ ");
        for (int i2 = 0; i2 < i; i2++) {
            SolverVariable variable = getVariable(i2);
            if (variable != null) {
                PrintStream printStream = System.out;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(variable);
                stringBuilder.append(" = ");
                stringBuilder.append(getVariableValue(i2));
                stringBuilder.append(" ");
                printStream.print(stringBuilder.toString());
            }
        }
        System.out.println(" }");
    }

    /* Access modifiers changed, original: 0000 */
    public void divideByAmount(float f) {
        int i = this.mHead;
        int i2 = 0;
        while (i != -1 && i2 < this.currentSize) {
            float[] fArr = this.mArrayValues;
            fArr[i] = fArr[i] / f;
            i = this.mArrayNextIndices[i];
            i2++;
        }
    }

    public final float get(SolverVariable solverVariable) {
        int i = this.mHead;
        int i2 = 0;
        while (i != -1 && i2 < this.currentSize) {
            if (this.mArrayIndices[i] == solverVariable.id) {
                return this.mArrayValues[i];
            }
            i = this.mArrayNextIndices[i];
            i2++;
        }
        return 0.0f;
    }

    /* Access modifiers changed, original: 0000 */
    public SolverVariable getPivotCandidate() {
        if (this.candidate != null) {
            return this.candidate;
        }
        int i = this.mHead;
        int i2 = 0;
        SolverVariable solverVariable = null;
        while (i != -1 && i2 < this.currentSize) {
            if (this.mArrayValues[i] < 0.0f) {
                SolverVariable solverVariable2 = this.mCache.mIndexedVariables[this.mArrayIndices[i]];
                if (solverVariable == null || solverVariable.strength < solverVariable2.strength) {
                    solverVariable = solverVariable2;
                }
            }
            i = this.mArrayNextIndices[i];
            i2++;
        }
        return solverVariable;
    }

    /* Access modifiers changed, original: 0000 */
    public SolverVariable getPivotCandidate(boolean[] zArr, SolverVariable solverVariable) {
        int i = this.mHead;
        int i2 = 0;
        SolverVariable solverVariable2 = null;
        float f = 0.0f;
        while (i != -1 && i2 < this.currentSize) {
            if (this.mArrayValues[i] < 0.0f) {
                SolverVariable solverVariable3 = this.mCache.mIndexedVariables[this.mArrayIndices[i]];
                if ((zArr == null || !zArr[solverVariable3.id]) && solverVariable3 != solverVariable && (solverVariable3.mType == Type.SLACK || solverVariable3.mType == Type.ERROR)) {
                    float f2 = this.mArrayValues[i];
                    if (f2 < f) {
                        solverVariable2 = solverVariable3;
                        f = f2;
                    }
                }
            }
            i = this.mArrayNextIndices[i];
            i2++;
        }
        return solverVariable2;
    }

    /* Access modifiers changed, original: final */
    public final SolverVariable getVariable(int i) {
        int i2 = this.mHead;
        int i3 = 0;
        while (i2 != -1 && i3 < this.currentSize) {
            if (i3 == i) {
                return this.mCache.mIndexedVariables[this.mArrayIndices[i2]];
            }
            i2 = this.mArrayNextIndices[i2];
            i3++;
        }
        return null;
    }

    /* Access modifiers changed, original: final */
    public final float getVariableValue(int i) {
        int i2 = this.mHead;
        int i3 = 0;
        while (i2 != -1 && i3 < this.currentSize) {
            if (i3 == i) {
                return this.mArrayValues[i2];
            }
            i2 = this.mArrayNextIndices[i2];
            i3++;
        }
        return 0.0f;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean hasAtLeastOnePositiveVariable() {
        int i = this.mHead;
        int i2 = 0;
        while (i != -1 && i2 < this.currentSize) {
            if (this.mArrayValues[i] > 0.0f) {
                return true;
            }
            i = this.mArrayNextIndices[i];
            i2++;
        }
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    public void invert() {
        int i = this.mHead;
        int i2 = 0;
        while (i != -1 && i2 < this.currentSize) {
            float[] fArr = this.mArrayValues;
            fArr[i] = fArr[i] * -1.0f;
            i = this.mArrayNextIndices[i];
            i2++;
        }
    }

    public final void put(SolverVariable solverVariable, float f) {
        if (f == 0.0f) {
            remove(solverVariable, true);
        } else if (this.mHead == -1) {
            this.mHead = 0;
            this.mArrayValues[this.mHead] = f;
            this.mArrayIndices[this.mHead] = solverVariable.id;
            this.mArrayNextIndices[this.mHead] = -1;
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.currentSize++;
            if (!this.mDidFillOnce) {
                this.mLast++;
                if (this.mLast >= this.mArrayIndices.length) {
                    this.mDidFillOnce = true;
                    this.mLast = this.mArrayIndices.length - 1;
                }
            }
        } else {
            int i = this.mHead;
            int i2 = 0;
            int i3 = -1;
            while (i != -1 && i2 < this.currentSize) {
                if (this.mArrayIndices[i] == solverVariable.id) {
                    this.mArrayValues[i] = f;
                    return;
                }
                if (this.mArrayIndices[i] < solverVariable.id) {
                    i3 = i;
                }
                i = this.mArrayNextIndices[i];
                i2++;
            }
            i = this.mLast + 1;
            if (this.mDidFillOnce) {
                i = this.mArrayIndices[this.mLast] == -1 ? this.mLast : this.mArrayIndices.length;
            }
            if (i >= this.mArrayIndices.length && this.currentSize < this.mArrayIndices.length) {
                for (i2 = 0; i2 < this.mArrayIndices.length; i2++) {
                    if (this.mArrayIndices[i2] == -1) {
                        i = i2;
                        break;
                    }
                }
            }
            if (i >= this.mArrayIndices.length) {
                i = this.mArrayIndices.length;
                this.ROW_SIZE *= 2;
                this.mDidFillOnce = false;
                this.mLast = i - 1;
                this.mArrayValues = Arrays.copyOf(this.mArrayValues, this.ROW_SIZE);
                this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
                this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
            }
            this.mArrayIndices[i] = solverVariable.id;
            this.mArrayValues[i] = f;
            if (i3 != -1) {
                this.mArrayNextIndices[i] = this.mArrayNextIndices[i3];
                this.mArrayNextIndices[i3] = i;
            } else {
                this.mArrayNextIndices[i] = this.mHead;
                this.mHead = i;
            }
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.currentSize++;
            if (!this.mDidFillOnce) {
                this.mLast++;
            }
            if (this.currentSize >= this.mArrayIndices.length) {
                this.mDidFillOnce = true;
            }
            if (this.mLast >= this.mArrayIndices.length) {
                this.mDidFillOnce = true;
                this.mLast = this.mArrayIndices.length - 1;
            }
        }
    }

    public final float remove(SolverVariable solverVariable, boolean z) {
        if (this.candidate == solverVariable) {
            this.candidate = null;
        }
        if (this.mHead == -1) {
            return 0.0f;
        }
        int i = this.mHead;
        int i2 = 0;
        int i3 = -1;
        while (i != -1 && i2 < this.currentSize) {
            if (this.mArrayIndices[i] == solverVariable.id) {
                if (i == this.mHead) {
                    this.mHead = this.mArrayNextIndices[i];
                } else {
                    this.mArrayNextIndices[i3] = this.mArrayNextIndices[i];
                }
                if (z) {
                    solverVariable.removeFromRow(this.mRow);
                }
                solverVariable.usageInRowCount--;
                this.currentSize--;
                this.mArrayIndices[i] = -1;
                if (this.mDidFillOnce) {
                    this.mLast = i;
                }
                return this.mArrayValues[i];
            }
            i2++;
            i3 = i;
            i = this.mArrayNextIndices[i];
        }
        return 0.0f;
    }

    /* Access modifiers changed, original: 0000 */
    public int sizeInBytes() {
        return (0 + (3 * (this.mArrayIndices.length * 4))) + 36;
    }

    public String toString() {
        String str = "";
        int i = this.mHead;
        int i2 = 0;
        while (i != -1 && i2 < this.currentSize) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" -> ");
            str = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(this.mArrayValues[i]);
            stringBuilder.append(" : ");
            str = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(this.mCache.mIndexedVariables[this.mArrayIndices[i]]);
            str = stringBuilder.toString();
            i = this.mArrayNextIndices[i];
            i2++;
        }
        return str;
    }

    /* Access modifiers changed, original: final */
    public final void updateFromRow(ArrayRow arrayRow, ArrayRow arrayRow2, boolean z) {
        int i = this.mHead;
        while (true) {
            int i2 = 0;
            while (i != -1 && i2 < this.currentSize) {
                if (this.mArrayIndices[i] == arrayRow2.variable.id) {
                    float f = this.mArrayValues[i];
                    remove(arrayRow2.variable, z);
                    ArrayLinkedVariables arrayLinkedVariables = arrayRow2.variables;
                    int i3 = arrayLinkedVariables.mHead;
                    int i4 = 0;
                    while (i3 != -1 && i4 < arrayLinkedVariables.currentSize) {
                        add(this.mCache.mIndexedVariables[arrayLinkedVariables.mArrayIndices[i3]], arrayLinkedVariables.mArrayValues[i3] * f, z);
                        i3 = arrayLinkedVariables.mArrayNextIndices[i3];
                        i4++;
                    }
                    arrayRow.constantValue += arrayRow2.constantValue * f;
                    if (z) {
                        arrayRow2.variable.removeFromRow(arrayRow);
                    }
                    i = this.mHead;
                } else {
                    i = this.mArrayNextIndices[i];
                    i2++;
                }
            }
            return;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void updateFromSystem(ArrayRow arrayRow, ArrayRow[] arrayRowArr) {
        int i = this.mHead;
        while (true) {
            int i2 = 0;
            while (i != -1 && i2 < this.currentSize) {
                SolverVariable solverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[i]];
                if (solverVariable.definitionId != -1) {
                    float f = this.mArrayValues[i];
                    remove(solverVariable, true);
                    ArrayRow arrayRow2 = arrayRowArr[solverVariable.definitionId];
                    if (!arrayRow2.isSimpleDefinition) {
                        ArrayLinkedVariables arrayLinkedVariables = arrayRow2.variables;
                        int i3 = arrayLinkedVariables.mHead;
                        int i4 = 0;
                        while (i3 != -1 && i4 < arrayLinkedVariables.currentSize) {
                            add(this.mCache.mIndexedVariables[arrayLinkedVariables.mArrayIndices[i3]], arrayLinkedVariables.mArrayValues[i3] * f, true);
                            i3 = arrayLinkedVariables.mArrayNextIndices[i3];
                            i4++;
                        }
                    }
                    arrayRow.constantValue += arrayRow2.constantValue * f;
                    arrayRow2.variable.removeFromRow(arrayRow);
                    i = this.mHead;
                } else {
                    i = this.mArrayNextIndices[i];
                    i2++;
                }
            }
            return;
        }
    }
}
