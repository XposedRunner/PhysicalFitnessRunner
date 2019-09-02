package org.apache.commons.codec.language.bm;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import org.apache.commons.codec.language.bm.Languages.LanguageSet;

public class Rule {
    public static final String ALL = "ALL";
    public static final RPattern ALL_STRINGS_RMATCHER = new RPattern() {
        public boolean isMatch(CharSequence charSequence) {
            return true;
        }
    };
    private static final String DOUBLE_QUOTE = "\"";
    private static final String HASH_INCLUDE = "#include";
    private static final Map<NameType, Map<RuleType, Map<String, Map<String, List<Rule>>>>> RULES = new EnumMap(NameType.class);
    private final RPattern lContext;
    private final String pattern;
    private final PhonemeExpr phoneme;
    private final RPattern rContext;

    public interface RPattern {
        boolean isMatch(CharSequence charSequence);
    }

    public interface PhonemeExpr {
        Iterable<Phoneme> getPhonemes();
    }

    public static final class Phoneme implements PhonemeExpr {
        public static final Comparator<Phoneme> COMPARATOR = new Comparator<Phoneme>() {
            public int compare(Phoneme phoneme, Phoneme phoneme2) {
                for (int i = 0; i < phoneme.phonemeText.length(); i++) {
                    if (i >= phoneme2.phonemeText.length()) {
                        return 1;
                    }
                    int charAt = phoneme.phonemeText.charAt(i) - phoneme2.phonemeText.charAt(i);
                    if (charAt != 0) {
                        return charAt;
                    }
                }
                return phoneme.phonemeText.length() < phoneme2.phonemeText.length() ? -1 : 0;
            }
        };
        private final LanguageSet languages;
        private final StringBuilder phonemeText;

        public Phoneme(CharSequence charSequence, LanguageSet languageSet) {
            this.phonemeText = new StringBuilder(charSequence);
            this.languages = languageSet;
        }

        public Phoneme(Phoneme phoneme, Phoneme phoneme2) {
            this(phoneme.phonemeText, phoneme.languages);
            this.phonemeText.append(phoneme2.phonemeText);
        }

        public Phoneme(Phoneme phoneme, Phoneme phoneme2, LanguageSet languageSet) {
            this(phoneme.phonemeText, languageSet);
            this.phonemeText.append(phoneme2.phonemeText);
        }

        public Phoneme append(CharSequence charSequence) {
            this.phonemeText.append(charSequence);
            return this;
        }

        public LanguageSet getLanguages() {
            return this.languages;
        }

        public CharSequence getPhonemeText() {
            return this.phonemeText;
        }

        public Iterable<Phoneme> getPhonemes() {
            return Collections.singleton(this);
        }

        @Deprecated
        public Phoneme join(Phoneme phoneme) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.phonemeText.toString());
            stringBuilder.append(phoneme.phonemeText.toString());
            return new Phoneme(stringBuilder.toString(), this.languages.restrictTo(phoneme.languages));
        }
    }

    public static final class PhonemeList implements PhonemeExpr {
        private final List<Phoneme> phonemes;

        public PhonemeList(List<Phoneme> list) {
            this.phonemes = list;
        }

        public List<Phoneme> getPhonemes() {
            return this.phonemes;
        }
    }

    static {
        for (NameType nameType : NameType.values()) {
            EnumMap enumMap = new EnumMap(RuleType.class);
            for (RuleType ruleType : RuleType.values()) {
                HashMap hashMap = new HashMap();
                for (String str : Languages.getInstance(nameType).getLanguages()) {
                    try {
                        hashMap.put(str, parseRules(createScanner(nameType, ruleType, str), createResourceName(nameType, ruleType, str)));
                    } catch (IllegalStateException e) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Problem processing ");
                        stringBuilder.append(createResourceName(nameType, ruleType, str));
                        throw new IllegalStateException(stringBuilder.toString(), e);
                    }
                }
                if (!ruleType.equals(RuleType.RULES)) {
                    hashMap.put("common", parseRules(createScanner(nameType, ruleType, "common"), createResourceName(nameType, ruleType, "common")));
                }
                enumMap.put(ruleType, Collections.unmodifiableMap(hashMap));
            }
            RULES.put(nameType, Collections.unmodifiableMap(enumMap));
        }
    }

    public Rule(String str, String str2, String str3, PhonemeExpr phonemeExpr) {
        this.pattern = str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append("$");
        this.lContext = pattern(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("^");
        stringBuilder.append(str3);
        this.rContext = pattern(stringBuilder.toString());
        this.phoneme = phonemeExpr;
    }

    private static boolean contains(CharSequence charSequence, char c) {
        for (int i = 0; i < charSequence.length(); i++) {
            if (charSequence.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }

    private static String createResourceName(NameType nameType, RuleType ruleType, String str) {
        return String.format("org/apache/commons/codec/language/bm/%s_%s_%s.txt", new Object[]{nameType.getName(), ruleType.getName(), str});
    }

    private static Scanner createScanner(String str) {
        str = String.format("org/apache/commons/codec/language/bm/%s.txt", new Object[]{str});
        InputStream resourceAsStream = Languages.class.getClassLoader().getResourceAsStream(str);
        if (resourceAsStream != null) {
            return new Scanner(resourceAsStream, "UTF-8");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to load resource: ");
        stringBuilder.append(str);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private static Scanner createScanner(NameType nameType, RuleType ruleType, String str) {
        String createResourceName = createResourceName(nameType, ruleType, str);
        InputStream resourceAsStream = Languages.class.getClassLoader().getResourceAsStream(createResourceName);
        if (resourceAsStream != null) {
            return new Scanner(resourceAsStream, "UTF-8");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to load resource: ");
        stringBuilder.append(createResourceName);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private static boolean endsWith(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2.length() > charSequence.length()) {
            return false;
        }
        int length = charSequence.length() - 1;
        for (int length2 = charSequence2.length() - 1; length2 >= 0; length2--) {
            if (charSequence.charAt(length) != charSequence2.charAt(length2)) {
                return false;
            }
            length--;
        }
        return true;
    }

    public static List<Rule> getInstance(NameType nameType, RuleType ruleType, String str) {
        return getInstance(nameType, ruleType, LanguageSet.from(new HashSet(Arrays.asList(new String[]{str}))));
    }

    public static List<Rule> getInstance(NameType nameType, RuleType ruleType, LanguageSet languageSet) {
        Map instanceMap = getInstanceMap(nameType, ruleType, languageSet);
        ArrayList arrayList = new ArrayList();
        for (List addAll : instanceMap.values()) {
            arrayList.addAll(addAll);
        }
        return arrayList;
    }

    public static Map<String, List<Rule>> getInstanceMap(NameType nameType, RuleType ruleType, String str) {
        Map map = (Map) ((Map) ((Map) RULES.get(nameType)).get(ruleType)).get(str);
        if (map != null) {
            return map;
        }
        throw new IllegalArgumentException(String.format("No rules found for %s, %s, %s.", new Object[]{nameType.getName(), ruleType.getName(), str}));
    }

    public static Map<String, List<Rule>> getInstanceMap(NameType nameType, RuleType ruleType, LanguageSet languageSet) {
        return getInstanceMap(nameType, ruleType, languageSet.isSingleton() ? languageSet.getAny() : Languages.ANY);
    }

    private static Phoneme parsePhoneme(String str) {
        int indexOf = str.indexOf("[");
        if (indexOf < 0) {
            return new Phoneme((CharSequence) str, Languages.ANY_LANGUAGE);
        }
        if (str.endsWith("]")) {
            return new Phoneme(str.substring(0, indexOf), LanguageSet.from(new HashSet(Arrays.asList(str.substring(indexOf + 1, str.length() - 1).split("[+]")))));
        }
        throw new IllegalArgumentException("Phoneme expression contains a '[' but does not end in ']'");
    }

    private static PhonemeExpr parsePhonemeExpr(String str) {
        if (!str.startsWith("(")) {
            return parsePhoneme(str);
        }
        if (str.endsWith(")")) {
            ArrayList arrayList = new ArrayList();
            str = str.substring(1, str.length() - 1);
            for (String parsePhoneme : str.split("[|]")) {
                arrayList.add(parsePhoneme(parsePhoneme));
            }
            if (str.startsWith("|") || str.endsWith("|")) {
                arrayList.add(new Phoneme((CharSequence) "", Languages.ANY_LANGUAGE));
            }
            return new PhonemeList(arrayList);
        }
        throw new IllegalArgumentException("Phoneme starts with '(' so must end with ')'");
    }

    private static Map<String, List<Rule>> parseRules(Scanner scanner, String str) {
        HashMap hashMap = new HashMap();
        int i = 0;
        int i2 = i;
        while (scanner.hasNextLine()) {
            i++;
            String nextLine = scanner.nextLine();
            if (i2 != 0) {
                if (nextLine.endsWith("*/")) {
                    i2 = 0;
                }
            } else if (nextLine.startsWith("/*")) {
                i2 = 1;
            } else {
                int indexOf = nextLine.indexOf("//");
                String trim = (indexOf >= 0 ? nextLine.substring(0, indexOf) : nextLine).trim();
                if (trim.length() != 0) {
                    String trim2;
                    StringBuilder stringBuilder;
                    if (trim.startsWith(HASH_INCLUDE)) {
                        trim2 = trim.substring(HASH_INCLUDE.length()).trim();
                        if (trim2.contains(" ")) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Malformed import statement '");
                            stringBuilder.append(nextLine);
                            stringBuilder.append("' in ");
                            stringBuilder.append(str);
                            throw new IllegalArgumentException(stringBuilder.toString());
                        }
                        Scanner createScanner = createScanner(trim2);
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(str);
                        stringBuilder2.append("->");
                        stringBuilder2.append(trim2);
                        hashMap.putAll(parseRules(createScanner, stringBuilder2.toString()));
                    } else {
                        String[] split = trim.split("\\s+");
                        if (split.length != 4) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Malformed rule statement split into ");
                            stringBuilder.append(split.length);
                            stringBuilder.append(" parts: ");
                            stringBuilder.append(nextLine);
                            stringBuilder.append(" in ");
                            stringBuilder.append(str);
                            throw new IllegalArgumentException(stringBuilder.toString());
                        }
                        try {
                            final int i3 = i;
                            final String str2 = str;
                            AnonymousClass2 anonymousClass2 = new Rule(stripQuotes(split[0]), stripQuotes(split[1]), stripQuotes(split[2]), parsePhonemeExpr(stripQuotes(split[3]))) {
                                private final String loc = str2;
                                private final int myLine = i3;

                                public String toString() {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append("Rule");
                                    stringBuilder.append("{line=");
                                    stringBuilder.append(this.myLine);
                                    stringBuilder.append(", loc='");
                                    stringBuilder.append(this.loc);
                                    stringBuilder.append('\'');
                                    stringBuilder.append('}');
                                    return stringBuilder.toString();
                                }
                            };
                            trim2 = anonymousClass2.pattern.substring(0, 1);
                            List list = (List) hashMap.get(trim2);
                            if (list == null) {
                                list = new ArrayList();
                                hashMap.put(trim2, list);
                            }
                            list.add(anonymousClass2);
                        } catch (IllegalArgumentException e) {
                            StringBuilder stringBuilder3 = new StringBuilder();
                            stringBuilder3.append("Problem parsing line '");
                            stringBuilder3.append(i);
                            stringBuilder3.append("' in ");
                            stringBuilder3.append(str);
                            throw new IllegalStateException(stringBuilder3.toString(), e);
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    private static RPattern pattern(final String str) {
        boolean startsWith = str.startsWith("^");
        boolean endsWith = str.endsWith("$");
        final String substring = str.substring(startsWith, endsWith ? str.length() - 1 : str.length());
        if (substring.contains("[")) {
            boolean startsWith2 = substring.startsWith("[");
            boolean endsWith2 = substring.endsWith("]");
            if (startsWith2 && endsWith2) {
                substring = substring.substring(1, substring.length() - 1);
                if (!substring.contains("[")) {
                    startsWith2 = substring.startsWith("^");
                    if (startsWith2) {
                        substring = substring.substring(1);
                    }
                    final int i = 1 ^ startsWith2;
                    if (startsWith && endsWith) {
                        return new RPattern() {
                            public boolean isMatch(CharSequence charSequence) {
                                return charSequence.length() == 1 && Rule.contains(substring, charSequence.charAt(0)) == i;
                            }
                        };
                    }
                    if (startsWith) {
                        return new RPattern() {
                            public boolean isMatch(CharSequence charSequence) {
                                return charSequence.length() > 0 && Rule.contains(substring, charSequence.charAt(0)) == i;
                            }
                        };
                    }
                    if (endsWith) {
                        return new RPattern() {
                            public boolean isMatch(CharSequence charSequence) {
                                return charSequence.length() > 0 && Rule.contains(substring, charSequence.charAt(charSequence.length() - 1)) == i;
                            }
                        };
                    }
                }
            }
        } else if (startsWith && endsWith) {
            return substring.length() == 0 ? new RPattern() {
                public boolean isMatch(CharSequence charSequence) {
                    return charSequence.length() == 0;
                }
            } : new RPattern() {
                public boolean isMatch(CharSequence charSequence) {
                    return charSequence.equals(substring);
                }
            };
        } else {
            if ((startsWith || endsWith) && substring.length() == 0) {
                return ALL_STRINGS_RMATCHER;
            }
            if (startsWith) {
                return new RPattern() {
                    public boolean isMatch(CharSequence charSequence) {
                        return Rule.startsWith(charSequence, substring);
                    }
                };
            }
            if (endsWith) {
                return new RPattern() {
                    public boolean isMatch(CharSequence charSequence) {
                        return Rule.endsWith(charSequence, substring);
                    }
                };
            }
        }
        return new RPattern() {
            Pattern pattern = Pattern.compile(str);

            public boolean isMatch(CharSequence charSequence) {
                return this.pattern.matcher(charSequence).find();
            }
        };
    }

    private static boolean startsWith(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2.length() > charSequence.length()) {
            return false;
        }
        for (int i = 0; i < charSequence2.length(); i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private static String stripQuotes(String str) {
        if (str.startsWith(DOUBLE_QUOTE)) {
            str = str.substring(1);
        }
        return str.endsWith(DOUBLE_QUOTE) ? str.substring(0, str.length() - 1) : str;
    }

    public RPattern getLContext() {
        return this.lContext;
    }

    public String getPattern() {
        return this.pattern;
    }

    public PhonemeExpr getPhoneme() {
        return this.phoneme;
    }

    public RPattern getRContext() {
        return this.rContext;
    }

    public boolean patternAndContextMatches(CharSequence charSequence, int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Can not match pattern at negative indexes");
        }
        int length = this.pattern.length() + i;
        return (length <= charSequence.length() && charSequence.subSequence(i, length).equals(this.pattern) && this.rContext.isMatch(charSequence.subSequence(length, charSequence.length()))) ? this.lContext.isMatch(charSequence.subSequence(0, i)) : false;
    }
}
