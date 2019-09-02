package org.apache.commons.codec.language;

import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class DoubleMetaphone implements StringEncoder {
    private static final String[] ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER = new String[]{"ES", "EP", "EB", "EL", "EY", "IB", "IL", "IN", "IE", "EI", "ER"};
    private static final String[] L_R_N_M_B_H_F_V_W_SPACE = new String[]{"L", "R", "N", "M", "B", "H", "F", "V", "W", " "};
    private static final String[] L_T_K_S_N_M_B_Z = new String[]{"L", "T", "K", "S", "N", "M", "B", "Z"};
    private static final String[] SILENT_START = new String[]{"GN", "KN", "PN", "WR", "PS"};
    private static final String VOWELS = "AEIOUY";
    private int maxCodeLen = 4;

    public class DoubleMetaphoneResult {
        private final StringBuilder alternate = new StringBuilder(DoubleMetaphone.this.getMaxCodeLen());
        private final int maxLength;
        private final StringBuilder primary = new StringBuilder(DoubleMetaphone.this.getMaxCodeLen());

        public DoubleMetaphoneResult(int i) {
            this.maxLength = i;
        }

        public void append(char c) {
            appendPrimary(c);
            appendAlternate(c);
        }

        public void append(char c, char c2) {
            appendPrimary(c);
            appendAlternate(c2);
        }

        public void append(String str) {
            appendPrimary(str);
            appendAlternate(str);
        }

        public void append(String str, String str2) {
            appendPrimary(str);
            appendAlternate(str2);
        }

        public void appendAlternate(char c) {
            if (this.alternate.length() < this.maxLength) {
                this.alternate.append(c);
            }
        }

        public void appendAlternate(String str) {
            int length = this.maxLength - this.alternate.length();
            if (str.length() <= length) {
                this.alternate.append(str);
            } else {
                this.alternate.append(str.substring(0, length));
            }
        }

        public void appendPrimary(char c) {
            if (this.primary.length() < this.maxLength) {
                this.primary.append(c);
            }
        }

        public void appendPrimary(String str) {
            int length = this.maxLength - this.primary.length();
            if (str.length() <= length) {
                this.primary.append(str);
            } else {
                this.primary.append(str.substring(0, length));
            }
        }

        public String getAlternate() {
            return this.alternate.toString();
        }

        public String getPrimary() {
            return this.primary.toString();
        }

        public boolean isComplete() {
            return this.primary.length() >= this.maxLength && this.alternate.length() >= this.maxLength;
        }
    }

    private String cleanInput(String str) {
        if (str == null) {
            return null;
        }
        str = str.trim();
        return str.length() == 0 ? null : str.toUpperCase(Locale.ENGLISH);
    }

    private boolean conditionC0(String str, int i) {
        boolean z = true;
        if (contains(str, i, 4, "CHIA")) {
            return true;
        }
        if (i <= 1) {
            return false;
        }
        int i2 = i - 2;
        if (isVowel(charAt(str, i2))) {
            return false;
        }
        if (!contains(str, i - 1, 3, "ACH")) {
            return false;
        }
        char charAt = charAt(str, i + 2);
        if (charAt == 'I' || charAt == 'E') {
            if (!contains(str, i2, 6, "BACHER", "MACHER")) {
                z = false;
            }
        }
        return z;
    }

    private boolean conditionCH0(String str, int i) {
        if (i != 0) {
            return false;
        }
        i++;
        if (!contains(str, i, 5, "HARAC", "HARIS")) {
            if (!contains(str, i, 3, "HOR", "HYM", "HIA", "HEM")) {
                return false;
            }
        }
        return !contains(str, 0, 5, "CHORE");
    }

    private boolean conditionCH1(String str, int i) {
        if (!contains(str, 0, 4, "VAN ", "VON ")) {
            if (!contains(str, 0, 3, "SCH")) {
                if (!contains(str, i - 2, 6, "ORCHES", "ARCHIT", "ORCHID")) {
                    int i2 = i + 2;
                    if (!contains(str, i2, 1, "T", "S")) {
                        if (!contains(str, i - 1, 1, "A", "O", "U", "E") && i != 0) {
                            return false;
                        }
                        if (!(contains(str, i2, 1, L_R_N_M_B_H_F_V_W_SPACE) || i + 1 == str.length() - 1)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /* JADX WARNING: Missing block: B:8:0x004b, code skipped:
            if (contains(r8, r8.length() - 1, 1, "A", "O") != false) goto L_0x004d;
     */
    private boolean conditionL0(java.lang.String r8, int r9) {
        /*
        r7 = this;
        r0 = r8.length();
        r1 = 3;
        r0 = r0 - r1;
        r2 = 4;
        r3 = 2;
        r4 = 0;
        r5 = 1;
        if (r9 != r0) goto L_0x0023;
    L_0x000c:
        r0 = r9 + -1;
        r1 = new java.lang.String[r1];
        r6 = "ILLO";
        r1[r4] = r6;
        r6 = "ILLA";
        r1[r5] = r6;
        r6 = "ALLE";
        r1[r3] = r6;
        r0 = contains(r8, r0, r2, r1);
        if (r0 == 0) goto L_0x0023;
    L_0x0022:
        return r5;
    L_0x0023:
        r0 = r8.length();
        r0 = r0 - r3;
        r1 = new java.lang.String[r3];
        r6 = "AS";
        r1[r4] = r6;
        r6 = "OS";
        r1[r5] = r6;
        r0 = contains(r8, r0, r3, r1);
        if (r0 != 0) goto L_0x004d;
    L_0x0038:
        r0 = r8.length();
        r0 = r0 - r5;
        r1 = new java.lang.String[r3];
        r3 = "A";
        r1[r4] = r3;
        r3 = "O";
        r1[r5] = r3;
        r0 = contains(r8, r0, r5, r1);
        if (r0 == 0) goto L_0x005b;
    L_0x004d:
        r9 = r9 - r5;
        r0 = new java.lang.String[r5];
        r1 = "ALLE";
        r0[r4] = r1;
        r8 = contains(r8, r9, r2, r0);
        if (r8 == 0) goto L_0x005b;
    L_0x005a:
        return r5;
    L_0x005b:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.DoubleMetaphone.conditionL0(java.lang.String, int):boolean");
    }

    /* JADX WARNING: Missing block: B:8:0x002f, code skipped:
            if (contains(r8, r9 + 2, 2, "ER") != false) goto L_0x0033;
     */
    private boolean conditionM0(java.lang.String r8, int r9) {
        /*
        r7 = this;
        r0 = r9 + 1;
        r1 = r7.charAt(r8, r0);
        r2 = 1;
        r3 = 77;
        if (r1 != r3) goto L_0x000c;
    L_0x000b:
        return r2;
    L_0x000c:
        r1 = r9 + -1;
        r3 = 3;
        r4 = new java.lang.String[r2];
        r5 = "UMB";
        r6 = 0;
        r4[r6] = r5;
        r1 = contains(r8, r1, r3, r4);
        if (r1 == 0) goto L_0x0032;
    L_0x001c:
        r1 = r8.length();
        r1 = r1 - r2;
        if (r0 == r1) goto L_0x0033;
    L_0x0023:
        r0 = 2;
        r9 = r9 + r0;
        r1 = new java.lang.String[r2];
        r3 = "ER";
        r1[r6] = r3;
        r8 = contains(r8, r9, r0, r1);
        if (r8 == 0) goto L_0x0032;
    L_0x0031:
        goto L_0x0033;
    L_0x0032:
        r2 = r6;
    L_0x0033:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.DoubleMetaphone.conditionM0(java.lang.String, int):boolean");
    }

    protected static boolean contains(String str, int i, int i2, String... strArr) {
        if (i < 0) {
            return false;
        }
        i2 += i;
        if (i2 > str.length()) {
            return false;
        }
        str = str.substring(i, i2);
        for (Object equals : strArr) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    private int handleAEIOUY(DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (i == 0) {
            doubleMetaphoneResult.append('A');
        }
        return i + 1;
    }

    private int handleC(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (conditionC0(str, i)) {
            doubleMetaphoneResult.append('K');
            i += 2;
        } else {
            if (i == 0) {
                if (contains(str, i, 6, "CAESAR")) {
                    doubleMetaphoneResult.append('S');
                    i += 2;
                }
            }
            if (contains(str, i, 2, "CH")) {
                i = handleCH(str, doubleMetaphoneResult, i);
            } else {
                if (contains(str, i, 2, "CZ")) {
                    if (!contains(str, i - 2, 4, "WICZ")) {
                        doubleMetaphoneResult.append('S', 'X');
                        i += 2;
                    }
                }
                int i2 = i + 1;
                if (contains(str, i2, 3, "CIA")) {
                    doubleMetaphoneResult.append('X');
                    i += 3;
                } else {
                    if (contains(str, i, 2, "CC") && (i != 1 || charAt(str, 0) != 'M')) {
                        return handleCC(str, doubleMetaphoneResult, i);
                    }
                    if (contains(str, i, 2, "CK", "CG", "CQ")) {
                        doubleMetaphoneResult.append('K');
                        i += 2;
                    } else {
                        if (contains(str, i, 2, "CI", "CE", "CY")) {
                            if (contains(str, i, 3, "CIO", "CIE", "CIA")) {
                                doubleMetaphoneResult.append('S', 'X');
                            } else {
                                doubleMetaphoneResult.append('S');
                            }
                            i += 2;
                        } else {
                            doubleMetaphoneResult.append('K');
                            if (contains(str, i2, 2, " C", " Q", " G")) {
                                i += 3;
                            } else {
                                if (contains(str, i2, 1, "C", "K", "Q")) {
                                    if (!contains(str, i2, 2, "CE", "CI")) {
                                        i += 2;
                                    }
                                }
                                i = i2;
                            }
                        }
                    }
                }
            }
        }
        return i;
    }

    private int handleCC(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        int i2 = i + 2;
        if (contains(str, i2, 1, "I", "E", "H")) {
            if (!contains(str, i2, 2, "HU")) {
                if (!(i == 1 && charAt(str, i - 1) == 'A')) {
                    if (!contains(str, i - 1, 5, "UCCEE", "UCCES")) {
                        doubleMetaphoneResult.append('X');
                        return i + 3;
                    }
                }
                doubleMetaphoneResult.append("KS");
                return i + 3;
            }
        }
        doubleMetaphoneResult.append('K');
        return i2;
    }

    private int handleCH(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (i > 0) {
            if (contains(str, i, 4, "CHAE")) {
                doubleMetaphoneResult.append('K', 'X');
                return i + 2;
            }
        }
        if (conditionCH0(str, i)) {
            doubleMetaphoneResult.append('K');
            return i + 2;
        } else if (conditionCH1(str, i)) {
            doubleMetaphoneResult.append('K');
            return i + 2;
        } else {
            if (i > 0) {
                if (contains(str, 0, 2, "MC")) {
                    doubleMetaphoneResult.append('K');
                } else {
                    doubleMetaphoneResult.append('X', 'K');
                }
            } else {
                doubleMetaphoneResult.append('X');
            }
            return i + 2;
        }
    }

    private int handleD(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (contains(str, i, 2, "DG")) {
            int i2 = i + 2;
            if (contains(str, i2, 1, "I", "E", "Y")) {
                doubleMetaphoneResult.append('J');
                return i + 3;
            }
            doubleMetaphoneResult.append("TK");
            return i2;
        }
        if (contains(str, i, 2, "DT", "DD")) {
            doubleMetaphoneResult.append('T');
            return i + 2;
        }
        doubleMetaphoneResult.append('T');
        return i + 1;
    }

    private int handleG(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i, boolean z) {
        int i2 = i + 1;
        if (charAt(str, i2) == 'H') {
            return handleGH(str, doubleMetaphoneResult, i);
        }
        if (charAt(str, i2) == 'N') {
            if (i == 1 && isVowel(charAt(str, 0)) && !z) {
                doubleMetaphoneResult.append("KN", "N");
            } else {
                if (contains(str, i + 2, 2, "EY") || charAt(str, i2) == 'Y' || z) {
                    doubleMetaphoneResult.append("KN");
                } else {
                    doubleMetaphoneResult.append("N", "KN");
                }
            }
            return i + 2;
        }
        if (contains(str, i2, 2, "LI") && !z) {
            doubleMetaphoneResult.append("KL", "L");
            return i + 2;
        } else if (i == 0 && (charAt(str, i2) == 'Y' || contains(str, i2, 2, ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER))) {
            doubleMetaphoneResult.append('K', 'J');
            return i + 2;
        } else {
            if (contains(str, i2, 2, "ER") || charAt(str, i2) == 'Y') {
                if (!contains(str, 0, 6, "DANGER", "RANGER", "MANGER")) {
                    int i3 = i - 1;
                    if (!contains(str, i3, 1, "E", "I")) {
                        if (!contains(str, i3, 3, "RGY", "OGY")) {
                            doubleMetaphoneResult.append('K', 'J');
                            return i + 2;
                        }
                    }
                }
            }
            if (!contains(str, i2, 1, "E", "I", "Y")) {
                if (!contains(str, i - 1, 4, "AGGI", "OGGI")) {
                    if (charAt(str, i2) == 'G') {
                        i2 = i + 2;
                        doubleMetaphoneResult.append('K');
                        return i2;
                    }
                    doubleMetaphoneResult.append('K');
                    return i2;
                }
            }
            if (!contains(str, 0, 4, "VAN ", "VON ")) {
                if (!contains(str, 0, 3, "SCH")) {
                    if (!contains(str, i2, 2, "ET")) {
                        if (contains(str, i2, 3, "IER")) {
                            doubleMetaphoneResult.append('J');
                        } else {
                            doubleMetaphoneResult.append('J', 'K');
                        }
                        return i + 2;
                    }
                }
            }
            doubleMetaphoneResult.append('K');
            return i + 2;
        }
    }

    /* JADX WARNING: Missing block: B:14:0x0047, code skipped:
            if (contains(r10, r12 - 2, 1, "B", "H", "D") == false) goto L_0x0049;
     */
    /* JADX WARNING: Missing block: B:17:0x005f, code skipped:
            if (contains(r10, r12 - 3, 1, "B", "H", "D") == false) goto L_0x0061;
     */
    /* JADX WARNING: Missing block: B:20:0x0073, code skipped:
            if (contains(r10, r12 - 4, 1, "B", "H") != false) goto L_0x0075;
     */
    /* JADX WARNING: Missing block: B:37:?, code skipped:
            return r12 + 2;
     */
    private int handleGH(java.lang.String r10, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult r11, int r12) {
        /*
        r9 = this;
        r0 = 75;
        r1 = 2;
        if (r12 <= 0) goto L_0x0017;
    L_0x0005:
        r2 = r12 + -1;
        r2 = r9.charAt(r10, r2);
        r2 = r9.isVowel(r2);
        if (r2 != 0) goto L_0x0017;
    L_0x0011:
        r11.append(r0);
        r12 = r12 + r1;
        goto L_0x00b7;
    L_0x0017:
        r2 = 73;
        if (r12 != 0) goto L_0x002e;
    L_0x001b:
        r12 = r12 + r1;
        r10 = r9.charAt(r10, r12);
        if (r10 != r2) goto L_0x0029;
    L_0x0022:
        r10 = 74;
        r11.append(r10);
        goto L_0x00b7;
    L_0x0029:
        r11.append(r0);
        goto L_0x00b7;
    L_0x002e:
        r3 = 0;
        r4 = 3;
        r5 = 1;
        if (r12 <= r5) goto L_0x0049;
    L_0x0033:
        r6 = r12 + -2;
        r7 = new java.lang.String[r4];
        r8 = "B";
        r7[r3] = r8;
        r8 = "H";
        r7[r5] = r8;
        r8 = "D";
        r7[r1] = r8;
        r6 = contains(r10, r6, r5, r7);
        if (r6 != 0) goto L_0x0075;
    L_0x0049:
        if (r12 <= r1) goto L_0x0061;
    L_0x004b:
        r6 = r12 + -3;
        r7 = new java.lang.String[r4];
        r8 = "B";
        r7[r3] = r8;
        r8 = "H";
        r7[r5] = r8;
        r8 = "D";
        r7[r1] = r8;
        r6 = contains(r10, r6, r5, r7);
        if (r6 != 0) goto L_0x0075;
    L_0x0061:
        if (r12 <= r4) goto L_0x0077;
    L_0x0063:
        r6 = r12 + -4;
        r7 = new java.lang.String[r1];
        r8 = "B";
        r7[r3] = r8;
        r8 = "H";
        r7[r5] = r8;
        r6 = contains(r10, r6, r5, r7);
        if (r6 == 0) goto L_0x0077;
    L_0x0075:
        r12 = r12 + r1;
        goto L_0x00b7;
    L_0x0077:
        if (r12 <= r1) goto L_0x00a9;
    L_0x0079:
        r6 = r12 + -1;
        r6 = r9.charAt(r10, r6);
        r7 = 85;
        if (r6 != r7) goto L_0x00a9;
    L_0x0083:
        r6 = r12 + -3;
        r7 = 5;
        r7 = new java.lang.String[r7];
        r8 = "C";
        r7[r3] = r8;
        r3 = "G";
        r7[r5] = r3;
        r3 = "L";
        r7[r1] = r3;
        r3 = "R";
        r7[r4] = r3;
        r3 = "T";
        r4 = 4;
        r7[r4] = r3;
        r3 = contains(r10, r6, r5, r7);
        if (r3 == 0) goto L_0x00a9;
    L_0x00a3:
        r10 = 70;
        r11.append(r10);
        goto L_0x00b6;
    L_0x00a9:
        if (r12 <= 0) goto L_0x00b6;
    L_0x00ab:
        r3 = r12 + -1;
        r10 = r9.charAt(r10, r3);
        if (r10 == r2) goto L_0x00b6;
    L_0x00b3:
        r11.append(r0);
    L_0x00b6:
        r12 = r12 + r1;
    L_0x00b7:
        return r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.DoubleMetaphone.handleGH(java.lang.String, org.apache.commons.codec.language.DoubleMetaphone$DoubleMetaphoneResult, int):int");
    }

    private int handleH(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if ((i != 0 && !isVowel(charAt(str, i - 1))) || !isVowel(charAt(str, i + 1))) {
            return i + 1;
        }
        doubleMetaphoneResult.append('H');
        return i + 2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A:{SYNTHETIC, RETURN} */
    private int handleJ(java.lang.String r11, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult r12, int r13, boolean r14) {
        /*
        r10 = this;
        r0 = 1;
        r1 = new java.lang.String[r0];
        r2 = "JOSE";
        r3 = 0;
        r1[r3] = r2;
        r2 = 4;
        r1 = contains(r11, r13, r2, r1);
        r4 = 32;
        r5 = 72;
        r6 = 74;
        if (r1 != 0) goto L_0x0092;
    L_0x0015:
        r1 = new java.lang.String[r0];
        r7 = "SAN ";
        r1[r3] = r7;
        r1 = contains(r11, r3, r2, r1);
        if (r1 == 0) goto L_0x0023;
    L_0x0021:
        goto L_0x0092;
    L_0x0023:
        r1 = 2;
        r7 = 65;
        if (r13 != 0) goto L_0x0038;
    L_0x0028:
        r8 = new java.lang.String[r0];
        r9 = "JOSE";
        r8[r3] = r9;
        r2 = contains(r11, r13, r2, r8);
        if (r2 != 0) goto L_0x0038;
    L_0x0034:
        r12.append(r6, r7);
        goto L_0x0087;
    L_0x0038:
        r2 = r13 + -1;
        r8 = r10.charAt(r11, r2);
        r8 = r10.isVowel(r8);
        if (r8 == 0) goto L_0x005a;
    L_0x0044:
        if (r14 != 0) goto L_0x005a;
    L_0x0046:
        r14 = r13 + 1;
        r8 = r10.charAt(r11, r14);
        if (r8 == r7) goto L_0x0056;
    L_0x004e:
        r14 = r10.charAt(r11, r14);
        r7 = 79;
        if (r14 != r7) goto L_0x005a;
    L_0x0056:
        r12.append(r6, r5);
        goto L_0x0087;
    L_0x005a:
        r14 = r11.length();
        r14 = r14 - r0;
        if (r13 != r14) goto L_0x0065;
    L_0x0061:
        r12.append(r6, r4);
        goto L_0x0087;
    L_0x0065:
        r14 = r13 + 1;
        r4 = L_T_K_S_N_M_B_Z;
        r14 = contains(r11, r14, r0, r4);
        if (r14 != 0) goto L_0x0087;
    L_0x006f:
        r14 = 3;
        r14 = new java.lang.String[r14];
        r4 = "S";
        r14[r3] = r4;
        r3 = "K";
        r14[r0] = r3;
        r3 = "L";
        r14[r1] = r3;
        r14 = contains(r11, r2, r0, r14);
        if (r14 != 0) goto L_0x0087;
    L_0x0084:
        r12.append(r6);
    L_0x0087:
        r12 = r13 + 1;
        r11 = r10.charAt(r11, r12);
        if (r11 != r6) goto L_0x00b8;
    L_0x008f:
        r12 = r13 + 2;
        goto L_0x00b8;
    L_0x0092:
        if (r13 != 0) goto L_0x009c;
    L_0x0094:
        r14 = r13 + 4;
        r14 = r10.charAt(r11, r14);
        if (r14 == r4) goto L_0x00b3;
    L_0x009c:
        r14 = r11.length();
        if (r14 == r2) goto L_0x00b3;
    L_0x00a2:
        r14 = new java.lang.String[r0];
        r1 = "SAN ";
        r14[r3] = r1;
        r11 = contains(r11, r3, r2, r14);
        if (r11 == 0) goto L_0x00af;
    L_0x00ae:
        goto L_0x00b3;
    L_0x00af:
        r12.append(r6, r5);
        goto L_0x00b6;
    L_0x00b3:
        r12.append(r5);
    L_0x00b6:
        r12 = r13 + 1;
    L_0x00b8:
        return r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.DoubleMetaphone.handleJ(java.lang.String, org.apache.commons.codec.language.DoubleMetaphone$DoubleMetaphoneResult, int, boolean):int");
    }

    private int handleL(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        int i2 = i + 1;
        if (charAt(str, i2) == 'L') {
            if (conditionL0(str, i)) {
                doubleMetaphoneResult.appendPrimary('L');
            } else {
                doubleMetaphoneResult.append('L');
            }
            return i + 2;
        }
        doubleMetaphoneResult.append('L');
        return i2;
    }

    private int handleP(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        int i2 = i + 1;
        if (charAt(str, i2) == 'H') {
            doubleMetaphoneResult.append('F');
            return i + 2;
        }
        doubleMetaphoneResult.append('P');
        if (contains(str, i2, 1, "P", "B")) {
            i2 = i + 2;
        }
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003d  */
    private int handleR(java.lang.String r7, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult r8, int r9, boolean r10) {
        /*
        r6 = this;
        r0 = r7.length();
        r1 = 1;
        r0 = r0 - r1;
        r2 = 82;
        r3 = 2;
        if (r9 != r0) goto L_0x0032;
    L_0x000b:
        if (r10 != 0) goto L_0x0032;
    L_0x000d:
        r10 = r9 + -2;
        r0 = new java.lang.String[r1];
        r4 = "IE";
        r5 = 0;
        r0[r5] = r4;
        r10 = contains(r7, r10, r3, r0);
        if (r10 == 0) goto L_0x0032;
    L_0x001c:
        r10 = r9 + -4;
        r0 = new java.lang.String[r3];
        r4 = "ME";
        r0[r5] = r4;
        r4 = "MA";
        r0[r1] = r4;
        r10 = contains(r7, r10, r3, r0);
        if (r10 != 0) goto L_0x0032;
    L_0x002e:
        r8.appendAlternate(r2);
        goto L_0x0035;
    L_0x0032:
        r8.append(r2);
    L_0x0035:
        r8 = r9 + 1;
        r7 = r6.charAt(r7, r8);
        if (r7 != r2) goto L_0x003f;
    L_0x003d:
        r8 = r9 + 2;
    L_0x003f:
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.DoubleMetaphone.handleR(java.lang.String, org.apache.commons.codec.language.DoubleMetaphone$DoubleMetaphoneResult, int, boolean):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0101  */
    /* JADX WARNING: Missing block: B:21:0x009b, code skipped:
            if (contains(r10, r12 + 1, 1, "M", "N", "L", "W") == false) goto L_0x009d;
     */
    private int handleS(java.lang.String r10, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult r11, int r12, boolean r13) {
        /*
        r9 = this;
        r0 = r12 + -1;
        r1 = 2;
        r2 = new java.lang.String[r1];
        r3 = "ISL";
        r4 = 0;
        r2[r4] = r3;
        r3 = "YSL";
        r5 = 1;
        r2[r5] = r3;
        r3 = 3;
        r0 = contains(r10, r0, r3, r2);
        if (r0 == 0) goto L_0x0019;
    L_0x0016:
        r12 = r12 + r5;
        goto L_0x010f;
    L_0x0019:
        r0 = 88;
        r2 = 83;
        if (r12 != 0) goto L_0x0032;
    L_0x001f:
        r6 = 5;
        r7 = new java.lang.String[r5];
        r8 = "SUGAR";
        r7[r4] = r8;
        r6 = contains(r10, r12, r6, r7);
        if (r6 == 0) goto L_0x0032;
    L_0x002c:
        r11.append(r0, r2);
        r12 = r12 + r5;
        goto L_0x010f;
    L_0x0032:
        r6 = new java.lang.String[r5];
        r7 = "SH";
        r6[r4] = r7;
        r6 = contains(r10, r12, r1, r6);
        r7 = 4;
        if (r6 == 0) goto L_0x0063;
    L_0x003f:
        r13 = r12 + 1;
        r6 = new java.lang.String[r7];
        r8 = "HEIM";
        r6[r4] = r8;
        r4 = "HOEK";
        r6[r5] = r4;
        r4 = "HOLM";
        r6[r1] = r4;
        r4 = "HOLZ";
        r6[r3] = r4;
        r10 = contains(r10, r13, r7, r6);
        if (r10 == 0) goto L_0x005d;
    L_0x0059:
        r11.append(r2);
        goto L_0x0060;
    L_0x005d:
        r11.append(r0);
    L_0x0060:
        r12 = r12 + r1;
        goto L_0x010f;
    L_0x0063:
        r6 = new java.lang.String[r1];
        r8 = "SIO";
        r6[r4] = r8;
        r8 = "SIA";
        r6[r5] = r8;
        r6 = contains(r10, r12, r3, r6);
        if (r6 != 0) goto L_0x0105;
    L_0x0073:
        r6 = new java.lang.String[r5];
        r8 = "SIAN";
        r6[r4] = r8;
        r6 = contains(r10, r12, r7, r6);
        if (r6 == 0) goto L_0x0081;
    L_0x007f:
        goto L_0x0105;
    L_0x0081:
        if (r12 != 0) goto L_0x009d;
    L_0x0083:
        r13 = r12 + 1;
        r6 = new java.lang.String[r7];
        r7 = "M";
        r6[r4] = r7;
        r7 = "N";
        r6[r5] = r7;
        r7 = "L";
        r6[r1] = r7;
        r7 = "W";
        r6[r3] = r7;
        r13 = contains(r10, r13, r5, r6);
        if (r13 != 0) goto L_0x00ab;
    L_0x009d:
        r13 = r12 + 1;
        r3 = new java.lang.String[r5];
        r6 = "Z";
        r3[r4] = r6;
        r3 = contains(r10, r13, r5, r3);
        if (r3 == 0) goto L_0x00c0;
    L_0x00ab:
        r11.append(r2, r0);
        r11 = r12 + 1;
        r13 = new java.lang.String[r5];
        r0 = "Z";
        r13[r4] = r0;
        r10 = contains(r10, r11, r5, r13);
        if (r10 == 0) goto L_0x00be;
    L_0x00bc:
        r12 = r12 + r1;
        goto L_0x010f;
    L_0x00be:
        r12 = r11;
        goto L_0x010f;
    L_0x00c0:
        r0 = new java.lang.String[r5];
        r3 = "SC";
        r0[r4] = r3;
        r0 = contains(r10, r12, r1, r0);
        if (r0 == 0) goto L_0x00d1;
    L_0x00cc:
        r12 = r9.handleSC(r10, r11, r12);
        goto L_0x010f;
    L_0x00d1:
        r0 = r10.length();
        r0 = r0 - r5;
        if (r12 != r0) goto L_0x00ee;
    L_0x00d8:
        r0 = r12 + -2;
        r3 = new java.lang.String[r1];
        r6 = "AI";
        r3[r4] = r6;
        r6 = "OI";
        r3[r5] = r6;
        r0 = contains(r10, r0, r1, r3);
        if (r0 == 0) goto L_0x00ee;
    L_0x00ea:
        r11.appendAlternate(r2);
        goto L_0x00f1;
    L_0x00ee:
        r11.append(r2);
    L_0x00f1:
        r11 = new java.lang.String[r1];
        r0 = "S";
        r11[r4] = r0;
        r0 = "Z";
        r11[r5] = r0;
        r10 = contains(r10, r13, r5, r11);
        if (r10 == 0) goto L_0x0103;
    L_0x0101:
        r12 = r12 + r1;
        goto L_0x010f;
    L_0x0103:
        r12 = r13;
        goto L_0x010f;
    L_0x0105:
        if (r13 == 0) goto L_0x010b;
    L_0x0107:
        r11.append(r2);
        goto L_0x010e;
    L_0x010b:
        r11.append(r2, r0);
    L_0x010e:
        r12 = r12 + r3;
    L_0x010f:
        return r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.DoubleMetaphone.handleS(java.lang.String, org.apache.commons.codec.language.DoubleMetaphone$DoubleMetaphoneResult, int, boolean):int");
    }

    private int handleSC(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        int i2 = i + 2;
        if (charAt(str, i2) == 'H') {
            i2 = i + 3;
            if (contains(str, i2, 2, "OO", "ER", "EN", "UY", "ED", "EM")) {
                if (contains(str, i2, 2, "ER", "EN")) {
                    doubleMetaphoneResult.append("X", "SK");
                } else {
                    doubleMetaphoneResult.append("SK");
                }
            } else if (i != 0 || isVowel(charAt(str, 3)) || charAt(str, 3) == 'W') {
                doubleMetaphoneResult.append('X');
            } else {
                doubleMetaphoneResult.append('X', 'S');
            }
        } else {
            if (contains(str, i2, 1, "I", "E", "Y")) {
                doubleMetaphoneResult.append('S');
            } else {
                doubleMetaphoneResult.append("SK");
            }
        }
        return i + 3;
    }

    private int handleT(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (contains(str, i, 4, "TION")) {
            doubleMetaphoneResult.append('X');
            return i + 3;
        }
        if (contains(str, i, 3, "TIA", "TCH")) {
            doubleMetaphoneResult.append('X');
            return i + 3;
        }
        if (!contains(str, i, 2, "TH")) {
            if (!contains(str, i, 3, "TTH")) {
                doubleMetaphoneResult.append('T');
                int i2 = i + 1;
                return contains(str, i2, 1, "T", "D") ? i + 2 : i2;
            }
        }
        i += 2;
        if (!contains(str, i, 2, "OM", "AM")) {
            if (!contains(str, 0, 4, "VAN ", "VON ")) {
                if (!contains(str, 0, 3, "SCH")) {
                    doubleMetaphoneResult.append('0', 'T');
                    return i;
                }
            }
        }
        doubleMetaphoneResult.append('T');
        return i;
    }

    /* JADX WARNING: Missing block: B:8:0x0031, code skipped:
            if (contains(r11, r13, 2, "WH") != false) goto L_0x0033;
     */
    private int handleW(java.lang.String r11, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult r12, int r13) {
        /*
        r10 = this;
        r0 = 1;
        r1 = new java.lang.String[r0];
        r2 = "WR";
        r3 = 0;
        r1[r3] = r2;
        r2 = 2;
        r1 = contains(r11, r13, r2, r1);
        if (r1 == 0) goto L_0x0017;
    L_0x000f:
        r11 = 82;
        r12.append(r11);
        r13 = r13 + r2;
        goto L_0x00a4;
    L_0x0017:
        r1 = 70;
        if (r13 != 0) goto L_0x0048;
    L_0x001b:
        r4 = r13 + 1;
        r5 = r10.charAt(r11, r4);
        r5 = r10.isVowel(r5);
        if (r5 != 0) goto L_0x0033;
    L_0x0027:
        r5 = new java.lang.String[r0];
        r6 = "WH";
        r5[r3] = r6;
        r5 = contains(r11, r13, r2, r5);
        if (r5 == 0) goto L_0x0048;
    L_0x0033:
        r11 = r10.charAt(r11, r4);
        r11 = r10.isVowel(r11);
        r13 = 65;
        if (r11 == 0) goto L_0x0043;
    L_0x003f:
        r12.append(r13, r1);
        goto L_0x0046;
    L_0x0043:
        r12.append(r13);
    L_0x0046:
        r13 = r4;
        goto L_0x00a4;
    L_0x0048:
        r4 = r11.length();
        r4 = r4 - r0;
        if (r13 != r4) goto L_0x005b;
    L_0x004f:
        r4 = r13 + -1;
        r4 = r10.charAt(r11, r4);
        r4 = r10.isVowel(r4);
        if (r4 != 0) goto L_0x00a0;
    L_0x005b:
        r4 = r13 + -1;
        r5 = 5;
        r6 = 4;
        r7 = new java.lang.String[r6];
        r8 = "EWSKI";
        r7[r3] = r8;
        r8 = "EWSKY";
        r7[r0] = r8;
        r8 = "OWSKI";
        r7[r2] = r8;
        r8 = "OWSKY";
        r9 = 3;
        r7[r9] = r8;
        r4 = contains(r11, r4, r5, r7);
        if (r4 != 0) goto L_0x00a0;
    L_0x0078:
        r4 = new java.lang.String[r0];
        r5 = "SCH";
        r4[r3] = r5;
        r4 = contains(r11, r3, r9, r4);
        if (r4 == 0) goto L_0x0085;
    L_0x0084:
        goto L_0x00a0;
    L_0x0085:
        r1 = new java.lang.String[r2];
        r2 = "WICZ";
        r1[r3] = r2;
        r2 = "WITZ";
        r1[r0] = r2;
        r11 = contains(r11, r13, r6, r1);
        if (r11 == 0) goto L_0x009e;
    L_0x0095:
        r11 = "TS";
        r0 = "FX";
        r12.append(r11, r0);
        r13 = r13 + r6;
        goto L_0x00a4;
    L_0x009e:
        r13 = r13 + r0;
        goto L_0x00a4;
    L_0x00a0:
        r12.appendAlternate(r1);
        r13 = r13 + r0;
    L_0x00a4:
        return r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.DoubleMetaphone.handleW(java.lang.String, org.apache.commons.codec.language.DoubleMetaphone$DoubleMetaphoneResult, int):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004f  */
    /* JADX WARNING: Missing block: B:8:0x0036, code skipped:
            if (contains(r7, r9 - 2, 2, "AU", "OU") == false) goto L_0x0038;
     */
    private int handleX(java.lang.String r7, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult r8, int r9) {
        /*
        r6 = this;
        r0 = 1;
        if (r9 != 0) goto L_0x000a;
    L_0x0003:
        r7 = 83;
        r8.append(r7);
        r9 = r9 + r0;
        goto L_0x0052;
    L_0x000a:
        r1 = r7.length();
        r1 = r1 - r0;
        r2 = 0;
        r3 = 2;
        if (r9 != r1) goto L_0x0038;
    L_0x0013:
        r1 = r9 + -3;
        r4 = new java.lang.String[r3];
        r5 = "IAU";
        r4[r2] = r5;
        r5 = "EAU";
        r4[r0] = r5;
        r5 = 3;
        r1 = contains(r7, r1, r5, r4);
        if (r1 != 0) goto L_0x003d;
    L_0x0026:
        r1 = r9 + -2;
        r4 = new java.lang.String[r3];
        r5 = "AU";
        r4[r2] = r5;
        r5 = "OU";
        r4[r0] = r5;
        r1 = contains(r7, r1, r3, r4);
        if (r1 != 0) goto L_0x003d;
    L_0x0038:
        r1 = "KS";
        r8.append(r1);
    L_0x003d:
        r8 = r9 + 1;
        r1 = new java.lang.String[r3];
        r4 = "C";
        r1[r2] = r4;
        r2 = "X";
        r1[r0] = r2;
        r7 = contains(r7, r8, r0, r1);
        if (r7 == 0) goto L_0x0051;
    L_0x004f:
        r9 = r9 + r3;
        goto L_0x0052;
    L_0x0051:
        r9 = r8;
    L_0x0052:
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.DoubleMetaphone.handleX(java.lang.String, org.apache.commons.codec.language.DoubleMetaphone$DoubleMetaphoneResult, int):int");
    }

    private int handleZ(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i, boolean z) {
        int i2 = i + 1;
        if (charAt(str, i2) == 'H') {
            doubleMetaphoneResult.append('J');
            return i + 2;
        }
        if (contains(str, i2, 2, "ZO", "ZI", "ZA") || (z && i > 0 && charAt(str, i - 1) != 'T')) {
            doubleMetaphoneResult.append("S", "TS");
        } else {
            doubleMetaphoneResult.append('S');
        }
        if (charAt(str, i2) == 'Z') {
            i2 = i + 2;
        }
        return i2;
    }

    private boolean isSilentStart(String str) {
        for (String startsWith : SILENT_START) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSlavoGermanic(String str) {
        return str.indexOf(87) > -1 || str.indexOf(75) > -1 || str.indexOf("CZ") > -1 || str.indexOf("WITZ") > -1;
    }

    private boolean isVowel(char c) {
        return VOWELS.indexOf(c) != -1;
    }

    /* Access modifiers changed, original: protected */
    public char charAt(String str, int i) {
        return (i < 0 || i >= str.length()) ? 0 : str.charAt(i);
    }

    public String doubleMetaphone(String str) {
        return doubleMetaphone(str, false);
    }

    /* JADX WARNING: Missing block: B:22:0x005e, code skipped:
            r1 = r3;
     */
    public java.lang.String doubleMetaphone(java.lang.String r8, boolean r9) {
        /*
        r7 = this;
        r8 = r7.cleanInput(r8);
        if (r8 != 0) goto L_0x0008;
    L_0x0006:
        r8 = 0;
        return r8;
    L_0x0008:
        r0 = r7.isSlavoGermanic(r8);
        r1 = r7.isSilentStart(r8);
        r2 = new org.apache.commons.codec.language.DoubleMetaphone$DoubleMetaphoneResult;
        r3 = r7.getMaxCodeLen();
        r2.<init>(r3);
    L_0x0019:
        r3 = r2.isComplete();
        if (r3 != 0) goto L_0x0110;
    L_0x001f:
        r3 = r8.length();
        r3 = r3 + -1;
        if (r1 > r3) goto L_0x0110;
    L_0x0027:
        r3 = r8.charAt(r1);
        r4 = 199; // 0xc7 float:2.79E-43 double:9.83E-322;
        if (r3 == r4) goto L_0x0107;
    L_0x002f:
        r4 = 209; // 0xd1 float:2.93E-43 double:1.033E-321;
        r5 = 78;
        if (r3 == r4) goto L_0x0100;
    L_0x0035:
        r4 = 75;
        r6 = 70;
        switch(r3) {
            case 65: goto L_0x00fa;
            case 66: goto L_0x00e7;
            case 67: goto L_0x00e1;
            case 68: goto L_0x00db;
            case 69: goto L_0x00fa;
            case 70: goto L_0x00cc;
            case 71: goto L_0x00c6;
            case 72: goto L_0x00c0;
            case 73: goto L_0x00fa;
            case 74: goto L_0x00ba;
            case 75: goto L_0x00ab;
            case 76: goto L_0x00a5;
            case 77: goto L_0x0092;
            case 78: goto L_0x0084;
            case 79: goto L_0x00fa;
            case 80: goto L_0x007f;
            case 81: goto L_0x006f;
            case 82: goto L_0x006a;
            case 83: goto L_0x0065;
            case 84: goto L_0x0060;
            case 85: goto L_0x00fa;
            case 86: goto L_0x004e;
            case 87: goto L_0x0049;
            case 88: goto L_0x0044;
            case 89: goto L_0x00fa;
            case 90: goto L_0x003f;
            default: goto L_0x003c;
        };
    L_0x003c:
        r1 = r1 + 1;
        goto L_0x0019;
    L_0x003f:
        r1 = r7.handleZ(r8, r2, r1, r0);
        goto L_0x0019;
    L_0x0044:
        r1 = r7.handleX(r8, r2, r1);
        goto L_0x0019;
    L_0x0049:
        r1 = r7.handleW(r8, r2, r1);
        goto L_0x0019;
    L_0x004e:
        r2.append(r6);
        r3 = r1 + 1;
        r4 = r7.charAt(r8, r3);
        r5 = 86;
        if (r4 != r5) goto L_0x005e;
    L_0x005b:
        r1 = r1 + 2;
        goto L_0x0019;
    L_0x005e:
        r1 = r3;
        goto L_0x0019;
    L_0x0060:
        r1 = r7.handleT(r8, r2, r1);
        goto L_0x0019;
    L_0x0065:
        r1 = r7.handleS(r8, r2, r1, r0);
        goto L_0x0019;
    L_0x006a:
        r1 = r7.handleR(r8, r2, r1, r0);
        goto L_0x0019;
    L_0x006f:
        r2.append(r4);
        r3 = r1 + 1;
        r4 = r7.charAt(r8, r3);
        r5 = 81;
        if (r4 != r5) goto L_0x005e;
    L_0x007c:
        r1 = r1 + 2;
        goto L_0x0019;
    L_0x007f:
        r1 = r7.handleP(r8, r2, r1);
        goto L_0x0019;
    L_0x0084:
        r2.append(r5);
        r3 = r1 + 1;
        r4 = r7.charAt(r8, r3);
        if (r4 != r5) goto L_0x005e;
    L_0x008f:
        r1 = r1 + 2;
        goto L_0x0019;
    L_0x0092:
        r3 = 77;
        r2.append(r3);
        r3 = r7.conditionM0(r8, r1);
        if (r3 == 0) goto L_0x00a1;
    L_0x009d:
        r1 = r1 + 2;
        goto L_0x0019;
    L_0x00a1:
        r1 = r1 + 1;
        goto L_0x0019;
    L_0x00a5:
        r1 = r7.handleL(r8, r2, r1);
        goto L_0x0019;
    L_0x00ab:
        r2.append(r4);
        r3 = r1 + 1;
        r5 = r7.charAt(r8, r3);
        if (r5 != r4) goto L_0x005e;
    L_0x00b6:
        r1 = r1 + 2;
        goto L_0x0019;
    L_0x00ba:
        r1 = r7.handleJ(r8, r2, r1, r0);
        goto L_0x0019;
    L_0x00c0:
        r1 = r7.handleH(r8, r2, r1);
        goto L_0x0019;
    L_0x00c6:
        r1 = r7.handleG(r8, r2, r1, r0);
        goto L_0x0019;
    L_0x00cc:
        r2.append(r6);
        r3 = r1 + 1;
        r4 = r7.charAt(r8, r3);
        if (r4 != r6) goto L_0x005e;
    L_0x00d7:
        r1 = r1 + 2;
        goto L_0x0019;
    L_0x00db:
        r1 = r7.handleD(r8, r2, r1);
        goto L_0x0019;
    L_0x00e1:
        r1 = r7.handleC(r8, r2, r1);
        goto L_0x0019;
    L_0x00e7:
        r3 = 80;
        r2.append(r3);
        r3 = r1 + 1;
        r4 = r7.charAt(r8, r3);
        r5 = 66;
        if (r4 != r5) goto L_0x005e;
    L_0x00f6:
        r1 = r1 + 2;
        goto L_0x0019;
    L_0x00fa:
        r1 = r7.handleAEIOUY(r2, r1);
        goto L_0x0019;
    L_0x0100:
        r2.append(r5);
        r1 = r1 + 1;
        goto L_0x0019;
    L_0x0107:
        r3 = 83;
        r2.append(r3);
        r1 = r1 + 1;
        goto L_0x0019;
    L_0x0110:
        if (r9 == 0) goto L_0x0117;
    L_0x0112:
        r8 = r2.getAlternate();
        goto L_0x011b;
    L_0x0117:
        r8 = r2.getPrimary();
    L_0x011b:
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.DoubleMetaphone.doubleMetaphone(java.lang.String, boolean):java.lang.String");
    }

    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return doubleMetaphone((String) obj);
        }
        throw new EncoderException("DoubleMetaphone encode parameter is not of type String");
    }

    public String encode(String str) {
        return doubleMetaphone(str);
    }

    public int getMaxCodeLen() {
        return this.maxCodeLen;
    }

    public boolean isDoubleMetaphoneEqual(String str, String str2) {
        return isDoubleMetaphoneEqual(str, str2, false);
    }

    public boolean isDoubleMetaphoneEqual(String str, String str2, boolean z) {
        return doubleMetaphone(str, z).equals(doubleMetaphone(str2, z));
    }

    public void setMaxCodeLen(int i) {
        this.maxCodeLen = i;
    }
}
