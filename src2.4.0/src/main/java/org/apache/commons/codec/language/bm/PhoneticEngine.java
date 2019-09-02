package org.apache.commons.codec.language.bm;

import com.umeng.commonsdk.proguard.e;
import defpackage.ah;
import defpackage.db;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.apache.commons.codec.language.bm.Languages.LanguageSet;
import org.apache.commons.codec.language.bm.Rule.Phoneme;
import org.apache.commons.codec.language.bm.Rule.PhonemeExpr;

public class PhoneticEngine {
    private static final int DEFAULT_MAX_PHONEMES = 20;
    private static final Map<NameType, Set<String>> NAME_PREFIXES = new EnumMap(NameType.class);
    private final boolean concat;
    private final Lang lang;
    private final int maxPhonemes;
    private final NameType nameType;
    private final RuleType ruleType;

    static final class PhonemeBuilder {
        private final Set<Phoneme> phonemes;

        private PhonemeBuilder(Set<Phoneme> set) {
            this.phonemes = set;
        }

        private PhonemeBuilder(Phoneme phoneme) {
            this.phonemes = new LinkedHashSet();
            this.phonemes.add(phoneme);
        }

        public static PhonemeBuilder empty(LanguageSet languageSet) {
            return new PhonemeBuilder(new Phoneme((CharSequence) "", languageSet));
        }

        public void append(CharSequence charSequence) {
            for (Phoneme append : this.phonemes) {
                append.append(charSequence);
            }
        }

        public void apply(PhonemeExpr phonemeExpr, int i) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(i);
            loop0:
            for (Phoneme phoneme : this.phonemes) {
                for (Phoneme phoneme2 : phonemeExpr.getPhonemes()) {
                    LanguageSet restrictTo = phoneme.getLanguages().restrictTo(phoneme2.getLanguages());
                    if (!restrictTo.isEmpty()) {
                        Phoneme phoneme3 = new Phoneme(phoneme, phoneme2, restrictTo);
                        if (linkedHashSet.size() < i) {
                            linkedHashSet.add(phoneme3);
                            if (linkedHashSet.size() >= i) {
                                break loop0;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            this.phonemes.clear();
            this.phonemes.addAll(linkedHashSet);
        }

        public Set<Phoneme> getPhonemes() {
            return this.phonemes;
        }

        public String makeString() {
            StringBuilder stringBuilder = new StringBuilder();
            for (Phoneme phoneme : this.phonemes) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append("|");
                }
                stringBuilder.append(phoneme.getPhonemeText());
            }
            return stringBuilder.toString();
        }
    }

    private static final class RulesApplication {
        private final Map<String, List<Rule>> finalRules;
        private boolean found;
        private int i;
        private final CharSequence input;
        private final int maxPhonemes;
        private PhonemeBuilder phonemeBuilder;

        public RulesApplication(Map<String, List<Rule>> map, CharSequence charSequence, PhonemeBuilder phonemeBuilder, int i, int i2) {
            if (map == null) {
                throw new NullPointerException("The finalRules argument must not be null");
            }
            this.finalRules = map;
            this.phonemeBuilder = phonemeBuilder;
            this.input = charSequence;
            this.i = i;
            this.maxPhonemes = i2;
        }

        public int getI() {
            return this.i;
        }

        public PhonemeBuilder getPhonemeBuilder() {
            return this.phonemeBuilder;
        }

        public RulesApplication invoke() {
            int i;
            this.found = false;
            List<Rule> list = (List) this.finalRules.get(this.input.subSequence(this.i, this.i + 1));
            if (list != null) {
                i = 1;
                for (Rule rule : list) {
                    int length = rule.getPattern().length();
                    if (rule.patternAndContextMatches(this.input, this.i)) {
                        this.phonemeBuilder.apply(rule.getPhoneme(), this.maxPhonemes);
                        this.found = true;
                        i = length;
                        break;
                    }
                    i = length;
                }
            } else {
                i = 1;
            }
            if (!this.found) {
                i = 1;
            }
            this.i += i;
            return this;
        }

        public boolean isFound() {
            return this.found;
        }
    }

    static {
        NAME_PREFIXES.put(NameType.ASHKENAZI, Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"bar", "ben", "da", db.O0000Oo, "van", "von"}))));
        NAME_PREFIXES.put(NameType.SEPHARDIC, Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"al", "el", "da", "dal", db.O0000Oo, "del", "dela", "de la", "della", "des", "di", "do", "dos", ah.O000OoO0, "van", "von"}))));
        NAME_PREFIXES.put(NameType.GENERIC, Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"da", "dal", db.O0000Oo, "del", "dela", "de la", "della", "des", "di", "do", "dos", ah.O000OoO0, "van", "von"}))));
    }

    public PhoneticEngine(NameType nameType, RuleType ruleType, boolean z) {
        this(nameType, ruleType, z, 20);
    }

    public PhoneticEngine(NameType nameType, RuleType ruleType, boolean z, int i) {
        if (ruleType == RuleType.RULES) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ruleType must not be ");
            stringBuilder.append(RuleType.RULES);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.nameType = nameType;
        this.ruleType = ruleType;
        this.concat = z;
        this.lang = Lang.instance(nameType);
        this.maxPhonemes = i;
    }

    private PhonemeBuilder applyFinalRules(PhonemeBuilder phonemeBuilder, Map<String, List<Rule>> map) {
        if (map == null) {
            throw new NullPointerException("finalRules can not be null");
        } else if (map.isEmpty()) {
            return phonemeBuilder;
        } else {
            TreeSet treeSet = new TreeSet(Phoneme.COMPARATOR);
            for (Phoneme phoneme : phonemeBuilder.getPhonemes()) {
                PhonemeBuilder empty = PhonemeBuilder.empty(phoneme.getLanguages());
                String charSequence = phoneme.getPhonemeText().toString();
                PhonemeBuilder phonemeBuilder2 = empty;
                int i = 0;
                while (i < charSequence.length()) {
                    RulesApplication invoke = new RulesApplication(map, charSequence, phonemeBuilder2, i, this.maxPhonemes).invoke();
                    boolean isFound = invoke.isFound();
                    phonemeBuilder2 = invoke.getPhonemeBuilder();
                    if (!isFound) {
                        phonemeBuilder2.append(charSequence.subSequence(i, i + 1));
                    }
                    i = invoke.getI();
                }
                treeSet.addAll(phonemeBuilder2.getPhonemes());
            }
            return new PhonemeBuilder(treeSet);
        }
    }

    private static String join(Iterable<String> iterable, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            stringBuilder.append((String) it.next());
        }
        while (it.hasNext()) {
            stringBuilder.append(str);
            stringBuilder.append((String) it.next());
        }
        return stringBuilder.toString();
    }

    public String encode(String str) {
        return encode(str, this.lang.guessLanguages(str));
    }

    public String encode(String str, LanguageSet languageSet) {
        StringBuilder stringBuilder;
        Map instanceMap = Rule.getInstanceMap(this.nameType, RuleType.RULES, languageSet);
        Map instanceMap2 = Rule.getInstanceMap(this.nameType, this.ruleType, "common");
        Map instanceMap3 = Rule.getInstanceMap(this.nameType, this.ruleType, languageSet);
        str = str.toLowerCase(Locale.ENGLISH).replace('-', ' ').trim();
        if (this.nameType == NameType.GENERIC) {
            String stringBuilder2;
            StringBuilder stringBuilder3;
            if (str.length() < 2 || !str.substring(0, 2).equals("d'")) {
                for (String str2 : (Set) NAME_PREFIXES.get(this.nameType)) {
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append(str2);
                    stringBuilder4.append(" ");
                    if (str.startsWith(stringBuilder4.toString())) {
                        str = str.substring(str2.length() + 1);
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(str2);
                        stringBuilder.append(str);
                        stringBuilder2 = stringBuilder.toString();
                        stringBuilder3 = new StringBuilder();
                        stringBuilder3.append("(");
                        stringBuilder3.append(encode(str));
                        stringBuilder3.append(")-(");
                        stringBuilder3.append(encode(stringBuilder2));
                        stringBuilder3.append(")");
                        return stringBuilder3.toString();
                    }
                }
            }
            str = str.substring(2);
            stringBuilder = new StringBuilder();
            stringBuilder.append(e.am);
            stringBuilder.append(str);
            stringBuilder2 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append("(");
            stringBuilder3.append(encode(str));
            stringBuilder3.append(")-(");
            stringBuilder3.append(encode(stringBuilder2));
            stringBuilder3.append(")");
            return stringBuilder3.toString();
        }
        List<String> asList = Arrays.asList(str.split("\\s+"));
        ArrayList<String> arrayList = new ArrayList();
        switch (this.nameType) {
            case SEPHARDIC:
                for (String split : asList) {
                    String[] split2 = split.split("'");
                    arrayList.add(split2[split2.length - 1]);
                }
                arrayList.removeAll((Collection) NAME_PREFIXES.get(this.nameType));
                break;
            case ASHKENAZI:
                arrayList.addAll(asList);
                arrayList.removeAll((Collection) NAME_PREFIXES.get(this.nameType));
                break;
            case GENERIC:
                arrayList.addAll(asList);
                break;
            default:
                stringBuilder = new StringBuilder();
                stringBuilder.append("Unreachable case: ");
                stringBuilder.append(this.nameType);
                throw new IllegalStateException(stringBuilder.toString());
        }
        if (this.concat) {
            str = join(arrayList, " ");
        } else if (arrayList.size() == 1) {
            str = (String) asList.iterator().next();
        } else {
            StringBuilder stringBuilder5 = new StringBuilder();
            for (String str3 : arrayList) {
                stringBuilder5.append("-");
                stringBuilder5.append(encode(str3));
            }
            return stringBuilder5.substring(1);
        }
        PhonemeBuilder empty = PhonemeBuilder.empty(languageSet);
        int i = 0;
        while (i < str.length()) {
            RulesApplication invoke = new RulesApplication(instanceMap, str, empty, i, this.maxPhonemes).invoke();
            i = invoke.getI();
            empty = invoke.getPhonemeBuilder();
        }
        return applyFinalRules(applyFinalRules(empty, instanceMap2), instanceMap3).makeString();
    }

    public Lang getLang() {
        return this.lang;
    }

    public int getMaxPhonemes() {
        return this.maxPhonemes;
    }

    public NameType getNameType() {
        return this.nameType;
    }

    public RuleType getRuleType() {
        return this.ruleType;
    }

    public boolean isConcat() {
        return this.concat;
    }
}
