package com.google.zxing.pdf417.decoder.ec;

import com.google.zxing.ChecksumException;

public final class ErrorCorrection {
    private final ModulusGF field = ModulusGF.PDF417_GF;

    private int[] findErrorLocations(ModulusPoly modulusPoly) throws ChecksumException {
        int degree = modulusPoly.getDegree();
        int[] iArr = new int[degree];
        int i = 0;
        for (int i2 = 1; i2 < this.field.getSize() && i < degree; i2++) {
            if (modulusPoly.evaluateAt(i2) == 0) {
                iArr[i] = this.field.inverse(i2);
                i++;
            }
        }
        if (i == degree) {
            return iArr;
        }
        throw ChecksumException.getChecksumInstance();
    }

    private int[] findErrorMagnitudes(ModulusPoly modulusPoly, ModulusPoly modulusPoly2, int[] iArr) {
        int degree = modulusPoly2.getDegree();
        int[] iArr2 = new int[degree];
        for (int i = 1; i <= degree; i++) {
            iArr2[degree - i] = this.field.multiply(i, modulusPoly2.getCoefficient(i));
        }
        modulusPoly2 = new ModulusPoly(this.field, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int inverse = this.field.inverse(iArr[i2]);
            iArr3[i2] = this.field.multiply(this.field.subtract(0, modulusPoly.evaluateAt(inverse)), this.field.inverse(modulusPoly2.evaluateAt(inverse)));
        }
        return iArr3;
    }

    private ModulusPoly[] runEuclideanAlgorithm(ModulusPoly modulusPoly, ModulusPoly modulusPoly2, int i) throws ChecksumException {
        ModulusPoly modulusPoly3;
        if (modulusPoly.getDegree() < modulusPoly2.getDegree()) {
            modulusPoly3 = modulusPoly2;
            modulusPoly2 = modulusPoly;
            modulusPoly = modulusPoly3;
        }
        ModulusPoly zero = this.field.getZero();
        ModulusPoly one = this.field.getOne();
        modulusPoly3 = modulusPoly2;
        modulusPoly2 = modulusPoly;
        modulusPoly = modulusPoly3;
        while (modulusPoly.getDegree() >= i / 2) {
            if (modulusPoly.isZero()) {
                throw ChecksumException.getChecksumInstance();
            }
            ModulusPoly zero2 = this.field.getZero();
            int inverse = this.field.inverse(modulusPoly.getCoefficient(modulusPoly.getDegree()));
            while (modulusPoly2.getDegree() >= modulusPoly.getDegree() && !modulusPoly2.isZero()) {
                int degree = modulusPoly2.getDegree() - modulusPoly.getDegree();
                int multiply = this.field.multiply(modulusPoly2.getCoefficient(modulusPoly2.getDegree()), inverse);
                zero2 = zero2.add(this.field.buildMonomial(degree, multiply));
                modulusPoly2 = modulusPoly2.subtract(modulusPoly.multiplyByMonomial(degree, multiply));
            }
            modulusPoly3 = modulusPoly2;
            modulusPoly2 = modulusPoly;
            modulusPoly = modulusPoly3;
            ModulusPoly modulusPoly4 = one;
            one = zero2.multiply(one).subtract(zero).negative();
            zero = modulusPoly4;
        }
        i = one.getCoefficient(0);
        if (i == 0) {
            throw ChecksumException.getChecksumInstance();
        }
        i = this.field.inverse(i);
        zero = one.multiply(i);
        modulusPoly = modulusPoly.multiply(i);
        return new ModulusPoly[]{zero, modulusPoly};
    }

    public int decode(int[] iArr, int i, int[] iArr2) throws ChecksumException {
        int i2;
        int evaluateAt;
        ModulusPoly modulusPoly = new ModulusPoly(this.field, iArr);
        int[] iArr3 = new int[i];
        int i3 = 0;
        int i4 = 0;
        for (i2 = i; i2 > 0; i2--) {
            evaluateAt = modulusPoly.evaluateAt(this.field.exp(i2));
            iArr3[i - i2] = evaluateAt;
            if (evaluateAt != 0) {
                i4 = 1;
            }
        }
        if (i4 == 0) {
            return 0;
        }
        modulusPoly = this.field.getOne();
        if (iArr2 != null) {
            ModulusPoly modulusPoly2 = modulusPoly;
            for (int evaluateAt2 : iArr2) {
                evaluateAt2 = this.field.exp((iArr.length - 1) - evaluateAt2);
                modulusPoly2 = modulusPoly2.multiply(new ModulusPoly(this.field, new int[]{this.field.subtract(0, evaluateAt2), 1}));
            }
        }
        ModulusPoly[] runEuclideanAlgorithm = runEuclideanAlgorithm(this.field.buildMonomial(i, 1), new ModulusPoly(this.field, iArr3), i);
        ModulusPoly modulusPoly3 = runEuclideanAlgorithm[0];
        ModulusPoly modulusPoly4 = runEuclideanAlgorithm[1];
        int[] findErrorLocations = findErrorLocations(modulusPoly3);
        int[] findErrorMagnitudes = findErrorMagnitudes(modulusPoly4, modulusPoly3, findErrorLocations);
        while (i3 < findErrorLocations.length) {
            int length = (iArr.length - 1) - this.field.log(findErrorLocations[i3]);
            if (length < 0) {
                throw ChecksumException.getChecksumInstance();
            }
            iArr[length] = this.field.subtract(iArr[length], findErrorMagnitudes[i3]);
            i3++;
        }
        return findErrorLocations.length;
    }
}
