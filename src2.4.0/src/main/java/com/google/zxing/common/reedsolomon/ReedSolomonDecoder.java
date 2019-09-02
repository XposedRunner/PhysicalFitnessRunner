package com.google.zxing.common.reedsolomon;

public final class ReedSolomonDecoder {
    private final GenericGF field;

    public ReedSolomonDecoder(GenericGF genericGF) {
        this.field = genericGF;
    }

    private int[] findErrorLocations(GenericGFPoly genericGFPoly) throws ReedSolomonException {
        int degree = genericGFPoly.getDegree();
        int i = 0;
        int i2 = 1;
        if (degree == 1) {
            return new int[]{genericGFPoly.getCoefficient(1)};
        }
        int[] iArr = new int[degree];
        while (i2 < this.field.getSize() && i < degree) {
            if (genericGFPoly.evaluateAt(i2) == 0) {
                iArr[i] = this.field.inverse(i2);
                i++;
            }
            i2++;
        }
        if (i == degree) {
            return iArr;
        }
        throw new ReedSolomonException("Error locator degree does not match number of roots");
    }

    private int[] findErrorMagnitudes(GenericGFPoly genericGFPoly, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            int inverse = this.field.inverse(iArr[i]);
            int i2 = 1;
            for (int i3 = 0; i3 < length; i3++) {
                if (i != i3) {
                    int multiply = this.field.multiply(iArr[i3], inverse);
                    i2 = this.field.multiply(i2, (multiply & 1) == 0 ? multiply | 1 : multiply & -2);
                }
            }
            iArr2[i] = this.field.multiply(genericGFPoly.evaluateAt(inverse), this.field.inverse(i2));
            if (this.field.getGeneratorBase() != 0) {
                iArr2[i] = this.field.multiply(iArr2[i], inverse);
            }
        }
        return iArr2;
    }

    private GenericGFPoly[] runEuclideanAlgorithm(GenericGFPoly genericGFPoly, GenericGFPoly genericGFPoly2, int i) throws ReedSolomonException {
        GenericGFPoly genericGFPoly3;
        if (genericGFPoly.getDegree() < genericGFPoly2.getDegree()) {
            genericGFPoly3 = genericGFPoly2;
            genericGFPoly2 = genericGFPoly;
            genericGFPoly = genericGFPoly3;
        }
        GenericGFPoly zero = this.field.getZero();
        GenericGFPoly one = this.field.getOne();
        genericGFPoly3 = genericGFPoly2;
        genericGFPoly2 = genericGFPoly;
        genericGFPoly = genericGFPoly3;
        while (genericGFPoly.getDegree() >= i / 2) {
            if (genericGFPoly.isZero()) {
                throw new ReedSolomonException("r_{i-1} was zero");
            }
            GenericGFPoly zero2 = this.field.getZero();
            int inverse = this.field.inverse(genericGFPoly.getCoefficient(genericGFPoly.getDegree()));
            while (genericGFPoly2.getDegree() >= genericGFPoly.getDegree() && !genericGFPoly2.isZero()) {
                int degree = genericGFPoly2.getDegree() - genericGFPoly.getDegree();
                int multiply = this.field.multiply(genericGFPoly2.getCoefficient(genericGFPoly2.getDegree()), inverse);
                zero2 = zero2.addOrSubtract(this.field.buildMonomial(degree, multiply));
                genericGFPoly2 = genericGFPoly2.addOrSubtract(genericGFPoly.multiplyByMonomial(degree, multiply));
            }
            zero = zero2.multiply(one).addOrSubtract(zero);
            if (genericGFPoly2.getDegree() >= genericGFPoly.getDegree()) {
                throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
            }
            genericGFPoly3 = genericGFPoly2;
            genericGFPoly2 = genericGFPoly;
            genericGFPoly = genericGFPoly3;
            GenericGFPoly genericGFPoly4 = one;
            one = zero;
            zero = genericGFPoly4;
        }
        i = one.getCoefficient(0);
        if (i == 0) {
            throw new ReedSolomonException("sigmaTilde(0) was zero");
        }
        i = this.field.inverse(i);
        zero = one.multiply(i);
        genericGFPoly = genericGFPoly.multiply(i);
        return new GenericGFPoly[]{zero, genericGFPoly};
    }

    public void decode(int[] iArr, int i) throws ReedSolomonException {
        GenericGFPoly genericGFPoly = new GenericGFPoly(this.field, iArr);
        int[] iArr2 = new int[i];
        int i2 = 0;
        int i3 = 1;
        for (int i4 = 0; i4 < i; i4++) {
            int evaluateAt = genericGFPoly.evaluateAt(this.field.exp(this.field.getGeneratorBase() + i4));
            iArr2[(iArr2.length - 1) - i4] = evaluateAt;
            if (evaluateAt != 0) {
                i3 = 0;
            }
        }
        if (i3 == 0) {
            GenericGFPoly[] runEuclideanAlgorithm = runEuclideanAlgorithm(this.field.buildMonomial(i, 1), new GenericGFPoly(this.field, iArr2), i);
            genericGFPoly = runEuclideanAlgorithm[0];
            GenericGFPoly genericGFPoly2 = runEuclideanAlgorithm[1];
            int[] findErrorLocations = findErrorLocations(genericGFPoly);
            int[] findErrorMagnitudes = findErrorMagnitudes(genericGFPoly2, findErrorLocations);
            while (i2 < findErrorLocations.length) {
                int length = (iArr.length - 1) - this.field.log(findErrorLocations[i2]);
                if (length < 0) {
                    throw new ReedSolomonException("Bad error location");
                }
                iArr[length] = GenericGF.addOrSubtract(iArr[length], findErrorMagnitudes[i2]);
                i2++;
            }
        }
    }
}
