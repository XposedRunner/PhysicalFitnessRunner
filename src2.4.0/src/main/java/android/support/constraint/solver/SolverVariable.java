package android.support.constraint.solver;

import java.util.Arrays;

public class SolverVariable {
    private static final boolean INTERNAL_DEBUG = false;
    static final int MAX_STRENGTH = 7;
    public static final int STRENGTH_BARRIER = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 6;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    private static int uniqueConstantId = 1;
    private static int uniqueErrorId = 1;
    private static int uniqueId = 1;
    private static int uniqueSlackId = 1;
    private static int uniqueUnrestrictedId = 1;
    public float computedValue;
    int definitionId;
    public int id;
    ArrayRow[] mClientEquations;
    int mClientEquationsCount;
    private String mName;
    Type mType;
    public int strength;
    float[] strengthVector;
    public int usageInRowCount;

    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(Type type, String str) {
        this.id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.strengthVector = new float[7];
        this.mClientEquations = new ArrayRow[8];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.mType = type;
    }

    public SolverVariable(String str, Type type) {
        this.id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.strengthVector = new float[7];
        this.mClientEquations = new ArrayRow[8];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.mName = str;
        this.mType = type;
    }

    private static String getUniqueName(Type type, String str) {
        StringBuilder stringBuilder;
        if (str != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(uniqueErrorId);
            return stringBuilder.toString();
        }
        int i;
        switch (type) {
            case UNRESTRICTED:
                stringBuilder = new StringBuilder();
                stringBuilder.append("U");
                i = uniqueUnrestrictedId + 1;
                uniqueUnrestrictedId = i;
                stringBuilder.append(i);
                return stringBuilder.toString();
            case CONSTANT:
                stringBuilder = new StringBuilder();
                stringBuilder.append("C");
                i = uniqueConstantId + 1;
                uniqueConstantId = i;
                stringBuilder.append(i);
                return stringBuilder.toString();
            case SLACK:
                stringBuilder = new StringBuilder();
                stringBuilder.append("S");
                i = uniqueSlackId + 1;
                uniqueSlackId = i;
                stringBuilder.append(i);
                return stringBuilder.toString();
            case ERROR:
                stringBuilder = new StringBuilder();
                stringBuilder.append("e");
                i = uniqueErrorId + 1;
                uniqueErrorId = i;
                stringBuilder.append(i);
                return stringBuilder.toString();
            case UNKNOWN:
                stringBuilder = new StringBuilder();
                stringBuilder.append("V");
                i = uniqueId + 1;
                uniqueId = i;
                stringBuilder.append(i);
                return stringBuilder.toString();
            default:
                throw new AssertionError(type.name());
        }
    }

    static void increaseErrorId() {
        uniqueErrorId++;
    }

    public final void addToRow(ArrayRow arrayRow) {
        int i = 0;
        while (i < this.mClientEquationsCount) {
            if (this.mClientEquations[i] != arrayRow) {
                i++;
            } else {
                return;
            }
        }
        if (this.mClientEquationsCount >= this.mClientEquations.length) {
            this.mClientEquations = (ArrayRow[]) Arrays.copyOf(this.mClientEquations, this.mClientEquations.length * 2);
        }
        this.mClientEquations[this.mClientEquationsCount] = arrayRow;
        this.mClientEquationsCount++;
    }

    /* Access modifiers changed, original: 0000 */
    public void clearStrengths() {
        for (int i = 0; i < 7; i++) {
            this.strengthVector[i] = 0.0f;
        }
    }

    public String getName() {
        return this.mName;
    }

    public final void removeFromRow(ArrayRow arrayRow) {
        int i = this.mClientEquationsCount;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (this.mClientEquations[i3] == arrayRow) {
                while (i2 < (i - i3) - 1) {
                    int i4 = i3 + i2;
                    this.mClientEquations[i4] = this.mClientEquations[i4 + 1];
                    i2++;
                }
                this.mClientEquationsCount--;
                return;
            }
        }
    }

    public void reset() {
        this.mName = null;
        this.mType = Type.UNKNOWN;
        this.strength = 0;
        this.id = -1;
        this.definitionId = -1;
        this.computedValue = 0.0f;
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setType(Type type, String str) {
        this.mType = type;
    }

    /* Access modifiers changed, original: 0000 */
    public String strengthsToString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this);
        stringBuilder.append("[");
        String stringBuilder2 = stringBuilder.toString();
        int i = 1;
        int i2 = 0;
        int i3 = i2;
        while (i2 < this.strengthVector.length) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(stringBuilder2);
            stringBuilder3.append(this.strengthVector[i2]);
            stringBuilder2 = stringBuilder3.toString();
            if (this.strengthVector[i2] > 0.0f) {
                i3 = 0;
            } else if (this.strengthVector[i2] < 0.0f) {
                i3 = 1;
            }
            if (this.strengthVector[i2] != 0.0f) {
                i = 0;
            }
            if (i2 < this.strengthVector.length - 1) {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(stringBuilder2);
                stringBuilder3.append(", ");
                stringBuilder2 = stringBuilder3.toString();
            } else {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(stringBuilder2);
                stringBuilder3.append("] ");
                stringBuilder2 = stringBuilder3.toString();
            }
            i2++;
        }
        if (i3 != 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append(" (-)");
            stringBuilder2 = stringBuilder.toString();
        }
        if (i == 0) {
            return stringBuilder2;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(stringBuilder2);
        stringBuilder.append(" (*)");
        return stringBuilder.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(this.mName);
        return stringBuilder.toString();
    }

    public final void updateReferencesWithNewDefinition(ArrayRow arrayRow) {
        int i = this.mClientEquationsCount;
        for (int i2 = 0; i2 < i; i2++) {
            this.mClientEquations[i2].variables.updateFromRow(this.mClientEquations[i2], arrayRow, false);
        }
        this.mClientEquationsCount = 0;
    }
}
