package org.jsoup.parser;

import java.util.Arrays;
import org.jsoup.nodes.DocumentType;

enum TokeniserState {
    Data {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            char O00000o0 = characterReader.O00000o0();
            if (O00000o0 == 0) {
                tokeniser.O00000o0((TokeniserState) this);
                tokeniser.O000000o(characterReader.O00000o());
            } else if (O00000o0 == '&') {
                tokeniser.O00000Oo(CharacterReferenceInData);
            } else if (O00000o0 == '<') {
                tokeniser.O00000Oo(TagOpen);
            } else if (O00000o0 != TokeniserState.O000oOO0) {
                tokeniser.O000000o(characterReader.O0000Oo());
            } else {
                tokeniser.O000000o(new EOF());
            }
        }
    },
    CharacterReferenceInData {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.O00000Oo(tokeniser, Data);
        }
    },
    Rcdata {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            char O00000o0 = characterReader.O00000o0();
            if (O00000o0 == 0) {
                tokeniser.O00000o0((TokeniserState) this);
                characterReader.O00000oo();
                tokeniser.O000000o((char) TokeniserState.O000oO0o);
            } else if (O00000o0 == '&') {
                tokeniser.O00000Oo(CharacterReferenceInRcdata);
            } else if (O00000o0 == '<') {
                tokeniser.O00000Oo(RcdataLessthanSign);
            } else if (O00000o0 != TokeniserState.O000oOO0) {
                tokeniser.O000000o(characterReader.O000000o('&', '<', TokeniserState.O000o0oo));
            } else {
                tokeniser.O000000o(new EOF());
            }
        }
    },
    CharacterReferenceInRcdata {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.O00000Oo(tokeniser, Rcdata);
        }
    },
    Rawtext {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.O00000o(tokeniser, characterReader, this, RawtextLessthanSign);
        }
    },
    ScriptData {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.O00000o(tokeniser, characterReader, this, ScriptDataLessthanSign);
        }
    },
    PLAINTEXT {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            char O00000o0 = characterReader.O00000o0();
            if (O00000o0 == 0) {
                tokeniser.O00000o0((TokeniserState) this);
                characterReader.O00000oo();
                tokeniser.O000000o((char) TokeniserState.O000oO0o);
            } else if (O00000o0 != TokeniserState.O000oOO0) {
                tokeniser.O000000o(characterReader.O00000Oo((char) TokeniserState.O000o0oo));
            } else {
                tokeniser.O000000o(new EOF());
            }
        }
    },
    TagOpen {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            char O00000o0 = characterReader.O00000o0();
            if (O00000o0 == '!') {
                tokeniser.O00000Oo(MarkupDeclarationOpen);
            } else if (O00000o0 == '/') {
                tokeniser.O00000Oo(EndTagOpen);
            } else if (O00000o0 == '?') {
                tokeniser.O00000Oo(BogusComment);
            } else if (characterReader.O0000o()) {
                tokeniser.O000000o(true);
                tokeniser.O000000o(TagName);
            } else {
                tokeniser.O00000o0((TokeniserState) this);
                tokeniser.O000000o('<');
                tokeniser.O000000o(Data);
            }
        }
    },
    EndTagOpen {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.O00000Oo()) {
                tokeniser.O00000o(this);
                tokeniser.O000000o("</");
                tokeniser.O000000o(Data);
            } else if (characterReader.O0000o()) {
                tokeniser.O000000o(false);
                tokeniser.O000000o(TagName);
            } else if (characterReader.O00000o0('>')) {
                tokeniser.O00000o0((TokeniserState) this);
                tokeniser.O00000Oo(Data);
            } else {
                tokeniser.O00000o0((TokeniserState) this);
                tokeniser.O00000Oo(BogusComment);
            }
        }
    },
    TagName {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.O00000o0.O00000Oo(characterReader.O0000OoO());
            switch (characterReader.O00000o()) {
                case 0:
                    tokeniser.O00000o0.O00000Oo(TokeniserState.O000oO);
                    return;
                case 9:
                case 10:
                case 12:
                case 13:
                case ' ':
                    tokeniser.O000000o(BeforeAttributeName);
                    return;
                case '/':
                    tokeniser.O000000o(SelfClosingStartTag);
                    return;
                case '>':
                    tokeniser.O00000o();
                    tokeniser.O000000o(Data);
                    return;
                case 65535:
                    tokeniser.O00000o(this);
                    tokeniser.O000000o(Data);
                    return;
                default:
                    return;
            }
        }
    },
    RcdataLessthanSign {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.O00000o0('/')) {
                tokeniser.O0000Oo0();
                tokeniser.O00000Oo(RCDATAEndTagOpen);
                return;
            }
            if (characterReader.O0000o() && tokeniser.O0000OoO() != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("</");
                stringBuilder.append(tokeniser.O0000OoO());
                if (!characterReader.O00000oo(stringBuilder.toString())) {
                    tokeniser.O00000o0 = tokeniser.O000000o(false).O000000o(tokeniser.O0000OoO());
                    tokeniser.O00000o();
                    characterReader.O00000oO();
                    tokeniser.O000000o(Data);
                    return;
                }
            }
            tokeniser.O000000o("<");
            tokeniser.O000000o(Rcdata);
        }
    },
    RCDATAEndTagOpen {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.O0000o()) {
                tokeniser.O000000o(false);
                tokeniser.O00000o0.O000000o(characterReader.O00000o0());
                tokeniser.O00000Oo.append(characterReader.O00000o0());
                tokeniser.O00000Oo(RCDATAEndTagName);
                return;
            }
            tokeniser.O000000o("</");
            tokeniser.O000000o(Rcdata);
        }
    },
    RCDATAEndTagName {
        private void O00000Oo(Tokeniser tokeniser, CharacterReader characterReader) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("</");
            stringBuilder.append(tokeniser.O00000Oo.toString());
            tokeniser.O000000o(stringBuilder.toString());
            characterReader.O00000oO();
            tokeniser.O000000o(Rcdata);
        }

        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.O0000o()) {
                String O0000o00 = characterReader.O0000o00();
                tokeniser.O00000o0.O00000Oo(O0000o00);
                tokeniser.O00000Oo.append(O0000o00);
                return;
            }
            switch (characterReader.O00000o()) {
                case 9:
                case 10:
                case 12:
                case 13:
                case ' ':
                    if (!tokeniser.O0000Oo()) {
                        O00000Oo(tokeniser, characterReader);
                        break;
                    } else {
                        tokeniser.O000000o(BeforeAttributeName);
                        break;
                    }
                case '/':
                    if (!tokeniser.O0000Oo()) {
                        O00000Oo(tokeniser, characterReader);
                        break;
                    } else {
                        tokeniser.O000000o(SelfClosingStartTag);
                        break;
                    }
                case '>':
                    if (!tokeniser.O0000Oo()) {
                        O00000Oo(tokeniser, characterReader);
                        break;
                    }
                    tokeniser.O00000o();
                    tokeniser.O000000o(Data);
                    break;
                default:
                    O00000Oo(tokeniser, characterReader);
                    break;
            }
        }
    },
    RawtextLessthanSign {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.O00000o0('/')) {
                tokeniser.O0000Oo0();
                tokeniser.O00000Oo(RawtextEndTagOpen);
                return;
            }
            tokeniser.O000000o('<');
            tokeniser.O000000o(Rawtext);
        }
    },
    RawtextEndTagOpen {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.O00000oO(tokeniser, characterReader, RawtextEndTagName, Rawtext);
        }
    },
    RawtextEndTagName {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.O00000Oo(tokeniser, characterReader, Rawtext);
        }
    },
    ScriptDataLessthanSign {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            char O00000o = characterReader.O00000o();
            if (O00000o == '!') {
                tokeniser.O000000o("<!");
                tokeniser.O000000o(ScriptDataEscapeStart);
            } else if (O00000o != '/') {
                tokeniser.O000000o("<");
                characterReader.O00000oO();
                tokeniser.O000000o(ScriptData);
            } else {
                tokeniser.O0000Oo0();
                tokeniser.O000000o(ScriptDataEndTagOpen);
            }
        }
    },
    ScriptDataEndTagOpen {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.O00000oO(tokeniser, characterReader, ScriptDataEndTagName, ScriptData);
        }
    },
    ScriptDataEndTagName {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.O00000Oo(tokeniser, characterReader, ScriptData);
        }
    },
    ScriptDataEscapeStart {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.O00000o0('-')) {
                tokeniser.O000000o('-');
                tokeniser.O00000Oo(ScriptDataEscapeStartDash);
                return;
            }
            tokeniser.O000000o(ScriptData);
        }
    },
    ScriptDataEscapeStartDash {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.O00000o0('-')) {
                tokeniser.O000000o('-');
                tokeniser.O00000Oo(ScriptDataEscapedDashDash);
                return;
            }
            tokeniser.O000000o(ScriptData);
        }
    },
    ScriptDataEscaped {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.O00000Oo()) {
                tokeniser.O00000o(this);
                tokeniser.O000000o(Data);
                return;
            }
            char O00000o0 = characterReader.O00000o0();
            if (O00000o0 == 0) {
                tokeniser.O00000o0((TokeniserState) this);
                characterReader.O00000oo();
                tokeniser.O000000o((char) TokeniserState.O000oO0o);
            } else if (O00000o0 == '-') {
                tokeniser.O000000o('-');
                tokeniser.O00000Oo(ScriptDataEscapedDash);
            } else if (O00000o0 != '<') {
                tokeniser.O000000o(characterReader.O000000o('-', '<', TokeniserState.O000o0oo));
            } else {
                tokeniser.O00000Oo(ScriptDataEscapedLessthanSign);
            }
        }
    },
    ScriptDataEscapedDash {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.O00000Oo()) {
                tokeniser.O00000o(this);
                tokeniser.O000000o(Data);
                return;
            }
            char O00000o = characterReader.O00000o();
            if (O00000o == 0) {
                tokeniser.O00000o0((TokeniserState) this);
                tokeniser.O000000o((char) TokeniserState.O000oO0o);
                tokeniser.O000000o(ScriptDataEscaped);
            } else if (O00000o == '-') {
                tokeniser.O000000o(O00000o);
                tokeniser.O000000o(ScriptDataEscapedDashDash);
            } else if (O00000o != '<') {
                tokeniser.O000000o(O00000o);
                tokeniser.O000000o(ScriptDataEscaped);
            } else {
                tokeniser.O000000o(ScriptDataEscapedLessthanSign);
            }
        }
    },
    ScriptDataEscapedDashDash {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.O00000Oo()) {
                tokeniser.O00000o(this);
                tokeniser.O000000o(Data);
                return;
            }
            char O00000o = characterReader.O00000o();
            if (O00000o == 0) {
                tokeniser.O00000o0((TokeniserState) this);
                tokeniser.O000000o((char) TokeniserState.O000oO0o);
                tokeniser.O000000o(ScriptDataEscaped);
            } else if (O00000o == '-') {
                tokeniser.O000000o(O00000o);
            } else if (O00000o == '<') {
                tokeniser.O000000o(ScriptDataEscapedLessthanSign);
            } else if (O00000o != '>') {
                tokeniser.O000000o(O00000o);
                tokeniser.O000000o(ScriptDataEscaped);
            } else {
                tokeniser.O000000o(O00000o);
                tokeniser.O000000o(ScriptData);
            }
        }
    },
    ScriptDataEscapedLessthanSign {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.O0000o()) {
                tokeniser.O0000Oo0();
                tokeniser.O00000Oo.append(characterReader.O00000o0());
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("<");
                stringBuilder.append(characterReader.O00000o0());
                tokeniser.O000000o(stringBuilder.toString());
                tokeniser.O00000Oo(ScriptDataDoubleEscapeStart);
            } else if (characterReader.O00000o0('/')) {
                tokeniser.O0000Oo0();
                tokeniser.O00000Oo(ScriptDataEscapedEndTagOpen);
            } else {
                tokeniser.O000000o('<');
                tokeniser.O000000o(ScriptDataEscaped);
            }
        }
    },
    ScriptDataEscapedEndTagOpen {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.O0000o()) {
                tokeniser.O000000o(false);
                tokeniser.O00000o0.O000000o(characterReader.O00000o0());
                tokeniser.O00000Oo.append(characterReader.O00000o0());
                tokeniser.O00000Oo(ScriptDataEscapedEndTagName);
                return;
            }
            tokeniser.O000000o("</");
            tokeniser.O000000o(ScriptDataEscaped);
        }
    },
    ScriptDataEscapedEndTagName {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.O00000Oo(tokeniser, characterReader, ScriptDataEscaped);
        }
    },
    ScriptDataDoubleEscapeStart {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.O00000oo(tokeniser, characterReader, ScriptDataDoubleEscaped, ScriptDataEscaped);
        }
    },
    ScriptDataDoubleEscaped {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            char O00000o0 = characterReader.O00000o0();
            if (O00000o0 == 0) {
                tokeniser.O00000o0((TokeniserState) this);
                characterReader.O00000oo();
                tokeniser.O000000o((char) TokeniserState.O000oO0o);
            } else if (O00000o0 == '-') {
                tokeniser.O000000o(O00000o0);
                tokeniser.O00000Oo(ScriptDataDoubleEscapedDash);
            } else if (O00000o0 == '<') {
                tokeniser.O000000o(O00000o0);
                tokeniser.O00000Oo(ScriptDataDoubleEscapedLessthanSign);
            } else if (O00000o0 != TokeniserState.O000oOO0) {
                tokeniser.O000000o(characterReader.O000000o('-', '<', TokeniserState.O000o0oo));
            } else {
                tokeniser.O00000o(this);
                tokeniser.O000000o(Data);
            }
        }
    },
    ScriptDataDoubleEscapedDash {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            char O00000o = characterReader.O00000o();
            if (O00000o == 0) {
                tokeniser.O00000o0((TokeniserState) this);
                tokeniser.O000000o((char) TokeniserState.O000oO0o);
                tokeniser.O000000o(ScriptDataDoubleEscaped);
            } else if (O00000o == '-') {
                tokeniser.O000000o(O00000o);
                tokeniser.O000000o(ScriptDataDoubleEscapedDashDash);
            } else if (O00000o == '<') {
                tokeniser.O000000o(O00000o);
                tokeniser.O000000o(ScriptDataDoubleEscapedLessthanSign);
            } else if (O00000o != TokeniserState.O000oOO0) {
                tokeniser.O000000o(O00000o);
                tokeniser.O000000o(ScriptDataDoubleEscaped);
            } else {
                tokeniser.O00000o(this);
                tokeniser.O000000o(Data);
            }
        }
    },
    ScriptDataDoubleEscapedDashDash {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            char O00000o = characterReader.O00000o();
            if (O00000o == 0) {
                tokeniser.O00000o0((TokeniserState) this);
                tokeniser.O000000o((char) TokeniserState.O000oO0o);
                tokeniser.O000000o(ScriptDataDoubleEscaped);
            } else if (O00000o == '-') {
                tokeniser.O000000o(O00000o);
            } else if (O00000o == '<') {
                tokeniser.O000000o(O00000o);
                tokeniser.O000000o(ScriptDataDoubleEscapedLessthanSign);
            } else if (O00000o == '>') {
                tokeniser.O000000o(O00000o);
                tokeniser.O000000o(ScriptData);
            } else if (O00000o != TokeniserState.O000oOO0) {
                tokeniser.O000000o(O00000o);
                tokeniser.O000000o(ScriptDataDoubleEscaped);
            } else {
                tokeniser.O00000o(this);
                tokeniser.O000000o(Data);
            }
        }
    },
    ScriptDataDoubleEscapedLessthanSign {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.O00000o0('/')) {
                tokeniser.O000000o('/');
                tokeniser.O0000Oo0();
                tokeniser.O00000Oo(ScriptDataDoubleEscapeEnd);
                return;
            }
            tokeniser.O000000o(ScriptDataDoubleEscaped);
        }
    },
    ScriptDataDoubleEscapeEnd {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.O00000oo(tokeniser, characterReader, ScriptDataEscaped, ScriptDataDoubleEscaped);
        }
    },
    BeforeAttributeName {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            char O00000o = characterReader.O00000o();
            switch (O00000o) {
                case 0:
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O00000o0.O0000o0O();
                    characterReader.O00000oO();
                    tokeniser.O000000o(AttributeName);
                    return;
                case 9:
                case 10:
                case 12:
                case 13:
                case ' ':
                    return;
                case '\"':
                case '\'':
                case '<':
                case '=':
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O00000o0.O0000o0O();
                    tokeniser.O00000o0.O00000Oo(O00000o);
                    tokeniser.O000000o(AttributeName);
                    return;
                case '/':
                    tokeniser.O000000o(SelfClosingStartTag);
                    return;
                case '>':
                    tokeniser.O00000o();
                    tokeniser.O000000o(Data);
                    return;
                case 65535:
                    tokeniser.O00000o(this);
                    tokeniser.O000000o(Data);
                    return;
                default:
                    tokeniser.O00000o0.O0000o0O();
                    characterReader.O00000oO();
                    tokeniser.O000000o(AttributeName);
                    return;
            }
        }
    },
    AttributeName {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.O00000o0.O00000o0(characterReader.O00000Oo(TokeniserState.O000oO0));
            char O00000o = characterReader.O00000o();
            switch (O00000o) {
                case 0:
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O00000o0.O00000Oo((char) TokeniserState.O000oO0o);
                    return;
                case 9:
                case 10:
                case 12:
                case 13:
                case ' ':
                    tokeniser.O000000o(AfterAttributeName);
                    return;
                case '\"':
                case '\'':
                case '<':
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O00000o0.O00000Oo(O00000o);
                    return;
                case '/':
                    tokeniser.O000000o(SelfClosingStartTag);
                    return;
                case '=':
                    tokeniser.O000000o(BeforeAttributeValue);
                    return;
                case '>':
                    tokeniser.O00000o();
                    tokeniser.O000000o(Data);
                    return;
                case 65535:
                    tokeniser.O00000o(this);
                    tokeniser.O000000o(Data);
                    return;
                default:
                    return;
            }
        }
    },
    AfterAttributeName {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            char O00000o = characterReader.O00000o();
            switch (O00000o) {
                case 0:
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O00000o0.O00000Oo((char) TokeniserState.O000oO0o);
                    tokeniser.O000000o(AttributeName);
                    return;
                case 9:
                case 10:
                case 12:
                case 13:
                case ' ':
                    return;
                case '\"':
                case '\'':
                case '<':
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O00000o0.O0000o0O();
                    tokeniser.O00000o0.O00000Oo(O00000o);
                    tokeniser.O000000o(AttributeName);
                    return;
                case '/':
                    tokeniser.O000000o(SelfClosingStartTag);
                    return;
                case '=':
                    tokeniser.O000000o(BeforeAttributeValue);
                    return;
                case '>':
                    tokeniser.O00000o();
                    tokeniser.O000000o(Data);
                    return;
                case 65535:
                    tokeniser.O00000o(this);
                    tokeniser.O000000o(Data);
                    return;
                default:
                    tokeniser.O00000o0.O0000o0O();
                    characterReader.O00000oO();
                    tokeniser.O000000o(AttributeName);
                    return;
            }
        }
    },
    BeforeAttributeValue {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            char O00000o = characterReader.O00000o();
            switch (O00000o) {
                case 0:
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O00000o0.O00000o0((char) TokeniserState.O000oO0o);
                    tokeniser.O000000o(AttributeValue_unquoted);
                    return;
                case 9:
                case 10:
                case 12:
                case 13:
                case ' ':
                    return;
                case '\"':
                    tokeniser.O000000o(AttributeValue_doubleQuoted);
                    return;
                case '&':
                    characterReader.O00000oO();
                    tokeniser.O000000o(AttributeValue_unquoted);
                    return;
                case '\'':
                    tokeniser.O000000o(AttributeValue_singleQuoted);
                    return;
                case '<':
                case '=':
                case '`':
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O00000o0.O00000o0(O00000o);
                    tokeniser.O000000o(AttributeValue_unquoted);
                    return;
                case '>':
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O00000o();
                    tokeniser.O000000o(Data);
                    return;
                case 65535:
                    tokeniser.O00000o(this);
                    tokeniser.O00000o();
                    tokeniser.O000000o(Data);
                    return;
                default:
                    characterReader.O00000oO();
                    tokeniser.O000000o(AttributeValue_unquoted);
                    return;
            }
        }
    },
    AttributeValue_doubleQuoted {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            String O000000o = characterReader.O000000o(TokeniserState.O000oO00);
            if (O000000o.length() > 0) {
                tokeniser.O00000o0.O00000o(O000000o);
            } else {
                tokeniser.O00000o0.O0000oOo();
            }
            char O00000o = characterReader.O00000o();
            if (O00000o == 0) {
                tokeniser.O00000o0((TokeniserState) this);
                tokeniser.O00000o0.O00000o0((char) TokeniserState.O000oO0o);
            } else if (O00000o == '\"') {
                tokeniser.O000000o(AfterAttributeValue_quoted);
            } else if (O00000o == '&') {
                int[] O000000o2 = tokeniser.O000000o(Character.valueOf('\"'), true);
                if (O000000o2 != null) {
                    tokeniser.O00000o0.O000000o(O000000o2);
                } else {
                    tokeniser.O00000o0.O00000o0('&');
                }
            } else if (O00000o == TokeniserState.O000oOO0) {
                tokeniser.O00000o(this);
                tokeniser.O000000o(Data);
            }
        }
    },
    AttributeValue_singleQuoted {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            String O000000o = characterReader.O000000o(TokeniserState.O000o);
            if (O000000o.length() > 0) {
                tokeniser.O00000o0.O00000o(O000000o);
            } else {
                tokeniser.O00000o0.O0000oOo();
            }
            char O00000o = characterReader.O00000o();
            if (O00000o == 0) {
                tokeniser.O00000o0((TokeniserState) this);
                tokeniser.O00000o0.O00000o0((char) TokeniserState.O000oO0o);
            } else if (O00000o != TokeniserState.O000oOO0) {
                switch (O00000o) {
                    case '&':
                        int[] O000000o2 = tokeniser.O000000o(Character.valueOf('\''), true);
                        if (O000000o2 != null) {
                            tokeniser.O00000o0.O000000o(O000000o2);
                            return;
                        } else {
                            tokeniser.O00000o0.O00000o0('&');
                            return;
                        }
                    case '\'':
                        tokeniser.O000000o(AfterAttributeValue_quoted);
                        return;
                    default:
                        return;
                }
            } else {
                tokeniser.O00000o(this);
                tokeniser.O000000o(Data);
            }
        }
    },
    AttributeValue_unquoted {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            String O00000Oo = characterReader.O00000Oo(TokeniserState.O000oO0O);
            if (O00000Oo.length() > 0) {
                tokeniser.O00000o0.O00000o(O00000Oo);
            }
            char O00000o = characterReader.O00000o();
            switch (O00000o) {
                case 0:
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O00000o0.O00000o0((char) TokeniserState.O000oO0o);
                    return;
                case 9:
                case 10:
                case 12:
                case 13:
                case ' ':
                    tokeniser.O000000o(BeforeAttributeName);
                    return;
                case '\"':
                case '\'':
                case '<':
                case '=':
                case '`':
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O00000o0.O00000o0(O00000o);
                    return;
                case '&':
                    int[] O000000o = tokeniser.O000000o(Character.valueOf('>'), true);
                    if (O000000o != null) {
                        tokeniser.O00000o0.O000000o(O000000o);
                        return;
                    } else {
                        tokeniser.O00000o0.O00000o0('&');
                        return;
                    }
                case '>':
                    tokeniser.O00000o();
                    tokeniser.O000000o(Data);
                    return;
                case 65535:
                    tokeniser.O00000o(this);
                    tokeniser.O000000o(Data);
                    return;
                default:
                    return;
            }
        }
    },
    AfterAttributeValue_quoted {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            switch (characterReader.O00000o()) {
                case 9:
                case 10:
                case 12:
                case 13:
                case ' ':
                    tokeniser.O000000o(BeforeAttributeName);
                    return;
                case '/':
                    tokeniser.O000000o(SelfClosingStartTag);
                    return;
                case '>':
                    tokeniser.O00000o();
                    tokeniser.O000000o(Data);
                    return;
                case 65535:
                    tokeniser.O00000o(this);
                    tokeniser.O000000o(Data);
                    return;
                default:
                    tokeniser.O00000o0((TokeniserState) this);
                    characterReader.O00000oO();
                    tokeniser.O000000o(BeforeAttributeName);
                    return;
            }
        }
    },
    SelfClosingStartTag {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            char O00000o = characterReader.O00000o();
            if (O00000o == '>') {
                tokeniser.O00000o0.O00000o = true;
                tokeniser.O00000o();
                tokeniser.O000000o(Data);
            } else if (O00000o != TokeniserState.O000oOO0) {
                tokeniser.O00000o0((TokeniserState) this);
                characterReader.O00000oO();
                tokeniser.O000000o(BeforeAttributeName);
            } else {
                tokeniser.O00000o(this);
                tokeniser.O000000o(Data);
            }
        }
    },
    BogusComment {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            characterReader.O00000oO();
            Token comment = new Comment();
            comment.O00000o0 = true;
            comment.O00000Oo.append(characterReader.O00000Oo('>'));
            tokeniser.O000000o(comment);
            tokeniser.O00000Oo(Data);
        }
    },
    MarkupDeclarationOpen {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.O00000o("--")) {
                tokeniser.O00000oO();
                tokeniser.O000000o(CommentStart);
            } else if (characterReader.O00000oO("DOCTYPE")) {
                tokeniser.O000000o(Doctype);
            } else if (characterReader.O00000o("[CDATA[")) {
                tokeniser.O000000o(CdataSection);
            } else {
                tokeniser.O00000o0((TokeniserState) this);
                tokeniser.O00000Oo(BogusComment);
            }
        }
    },
    CommentStart {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            char O00000o = characterReader.O00000o();
            if (O00000o == 0) {
                tokeniser.O00000o0((TokeniserState) this);
                tokeniser.O0000OOo.O00000Oo.append(TokeniserState.O000oO0o);
                tokeniser.O000000o(Comment);
            } else if (O00000o == '-') {
                tokeniser.O000000o(CommentStartDash);
            } else if (O00000o == '>') {
                tokeniser.O00000o0((TokeniserState) this);
                tokeniser.O00000oo();
                tokeniser.O000000o(Data);
            } else if (O00000o != TokeniserState.O000oOO0) {
                tokeniser.O0000OOo.O00000Oo.append(O00000o);
                tokeniser.O000000o(Comment);
            } else {
                tokeniser.O00000o(this);
                tokeniser.O00000oo();
                tokeniser.O000000o(Data);
            }
        }
    },
    CommentStartDash {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            char O00000o = characterReader.O00000o();
            if (O00000o == 0) {
                tokeniser.O00000o0((TokeniserState) this);
                tokeniser.O0000OOo.O00000Oo.append(TokeniserState.O000oO0o);
                tokeniser.O000000o(Comment);
            } else if (O00000o == '-') {
                tokeniser.O000000o(CommentStartDash);
            } else if (O00000o == '>') {
                tokeniser.O00000o0((TokeniserState) this);
                tokeniser.O00000oo();
                tokeniser.O000000o(Data);
            } else if (O00000o != TokeniserState.O000oOO0) {
                tokeniser.O0000OOo.O00000Oo.append(O00000o);
                tokeniser.O000000o(Comment);
            } else {
                tokeniser.O00000o(this);
                tokeniser.O00000oo();
                tokeniser.O000000o(Data);
            }
        }
    },
    Comment {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            char O00000o0 = characterReader.O00000o0();
            if (O00000o0 == 0) {
                tokeniser.O00000o0((TokeniserState) this);
                characterReader.O00000oo();
                tokeniser.O0000OOo.O00000Oo.append(TokeniserState.O000oO0o);
            } else if (O00000o0 == '-') {
                tokeniser.O00000Oo(CommentEndDash);
            } else if (O00000o0 != TokeniserState.O000oOO0) {
                tokeniser.O0000OOo.O00000Oo.append(characterReader.O000000o('-', TokeniserState.O000o0oo));
            } else {
                tokeniser.O00000o(this);
                tokeniser.O00000oo();
                tokeniser.O000000o(Data);
            }
        }
    },
    CommentEndDash {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            char O00000o = characterReader.O00000o();
            if (O00000o == 0) {
                tokeniser.O00000o0((TokeniserState) this);
                StringBuilder stringBuilder = tokeniser.O0000OOo.O00000Oo;
                stringBuilder.append('-');
                stringBuilder.append(TokeniserState.O000oO0o);
                tokeniser.O000000o(Comment);
            } else if (O00000o == '-') {
                tokeniser.O000000o(CommentEnd);
            } else if (O00000o != TokeniserState.O000oOO0) {
                StringBuilder stringBuilder2 = tokeniser.O0000OOo.O00000Oo;
                stringBuilder2.append('-');
                stringBuilder2.append(O00000o);
                tokeniser.O000000o(Comment);
            } else {
                tokeniser.O00000o(this);
                tokeniser.O00000oo();
                tokeniser.O000000o(Data);
            }
        }
    },
    CommentEnd {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            char O00000o = characterReader.O00000o();
            if (O00000o == 0) {
                tokeniser.O00000o0((TokeniserState) this);
                StringBuilder stringBuilder = tokeniser.O0000OOo.O00000Oo;
                stringBuilder.append("--");
                stringBuilder.append(TokeniserState.O000oO0o);
                tokeniser.O000000o(Comment);
            } else if (O00000o == '!') {
                tokeniser.O00000o0((TokeniserState) this);
                tokeniser.O000000o(CommentEndBang);
            } else if (O00000o == '-') {
                tokeniser.O00000o0((TokeniserState) this);
                tokeniser.O0000OOo.O00000Oo.append('-');
            } else if (O00000o == '>') {
                tokeniser.O00000oo();
                tokeniser.O000000o(Data);
            } else if (O00000o != TokeniserState.O000oOO0) {
                tokeniser.O00000o0((TokeniserState) this);
                StringBuilder stringBuilder2 = tokeniser.O0000OOo.O00000Oo;
                stringBuilder2.append("--");
                stringBuilder2.append(O00000o);
                tokeniser.O000000o(Comment);
            } else {
                tokeniser.O00000o(this);
                tokeniser.O00000oo();
                tokeniser.O000000o(Data);
            }
        }
    },
    CommentEndBang {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            char O00000o = characterReader.O00000o();
            if (O00000o == 0) {
                tokeniser.O00000o0((TokeniserState) this);
                StringBuilder stringBuilder = tokeniser.O0000OOo.O00000Oo;
                stringBuilder.append("--!");
                stringBuilder.append(TokeniserState.O000oO0o);
                tokeniser.O000000o(Comment);
            } else if (O00000o == '-') {
                tokeniser.O0000OOo.O00000Oo.append("--!");
                tokeniser.O000000o(CommentEndDash);
            } else if (O00000o == '>') {
                tokeniser.O00000oo();
                tokeniser.O000000o(Data);
            } else if (O00000o != TokeniserState.O000oOO0) {
                StringBuilder stringBuilder2 = tokeniser.O0000OOo.O00000Oo;
                stringBuilder2.append("--!");
                stringBuilder2.append(O00000o);
                tokeniser.O000000o(Comment);
            } else {
                tokeniser.O00000o(this);
                tokeniser.O00000oo();
                tokeniser.O000000o(Data);
            }
        }
    },
    Doctype {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            switch (characterReader.O00000o()) {
                case 9:
                case 10:
                case 12:
                case 13:
                case ' ':
                    tokeniser.O000000o(BeforeDoctypeName);
                    return;
                case '>':
                    break;
                case 65535:
                    tokeniser.O00000o(this);
                    break;
                default:
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O000000o(BeforeDoctypeName);
                    return;
            }
            tokeniser.O00000o0((TokeniserState) this);
            tokeniser.O0000O0o();
            tokeniser.O0000O0o.O00000oo = true;
            tokeniser.O0000OOo();
            tokeniser.O000000o(Data);
        }
    },
    BeforeDoctypeName {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.O0000o()) {
                tokeniser.O0000O0o();
                tokeniser.O000000o(DoctypeName);
                return;
            }
            char O00000o = characterReader.O00000o();
            switch (O00000o) {
                case 0:
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O0000O0o();
                    tokeniser.O0000O0o.O00000Oo.append(TokeniserState.O000oO0o);
                    tokeniser.O000000o(DoctypeName);
                    break;
                case 9:
                case 10:
                case 12:
                case 13:
                case ' ':
                    break;
                case 65535:
                    tokeniser.O00000o(this);
                    tokeniser.O0000O0o();
                    tokeniser.O0000O0o.O00000oo = true;
                    tokeniser.O0000OOo();
                    tokeniser.O000000o(Data);
                    break;
                default:
                    tokeniser.O0000O0o();
                    tokeniser.O0000O0o.O00000Oo.append(O00000o);
                    tokeniser.O000000o(DoctypeName);
                    break;
            }
        }
    },
    DoctypeName {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.O0000o()) {
                tokeniser.O0000O0o.O00000Oo.append(characterReader.O0000o00());
                return;
            }
            char O00000o = characterReader.O00000o();
            switch (O00000o) {
                case 0:
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O0000O0o.O00000Oo.append(TokeniserState.O000oO0o);
                    break;
                case 9:
                case 10:
                case 12:
                case 13:
                case ' ':
                    tokeniser.O000000o(AfterDoctypeName);
                    break;
                case '>':
                    tokeniser.O0000OOo();
                    tokeniser.O000000o(Data);
                    break;
                case 65535:
                    tokeniser.O00000o(this);
                    tokeniser.O0000O0o.O00000oo = true;
                    tokeniser.O0000OOo();
                    tokeniser.O000000o(Data);
                    break;
                default:
                    tokeniser.O0000O0o.O00000Oo.append(O00000o);
                    break;
            }
        }
    },
    AfterDoctypeName {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.O00000Oo()) {
                tokeniser.O00000o(this);
                tokeniser.O0000O0o.O00000oo = true;
                tokeniser.O0000OOo();
                tokeniser.O000000o(Data);
                return;
            }
            if (characterReader.O00000o0(9, 10, 13, 12, ' ')) {
                characterReader.O00000oo();
            } else if (characterReader.O00000o0('>')) {
                tokeniser.O0000OOo();
                tokeniser.O00000Oo(Data);
            } else if (characterReader.O00000oO(DocumentType.O000000o)) {
                tokeniser.O0000O0o.O00000o0 = DocumentType.O000000o;
                tokeniser.O000000o(AfterDoctypePublicKeyword);
            } else if (characterReader.O00000oO(DocumentType.O00000Oo)) {
                tokeniser.O0000O0o.O00000o0 = DocumentType.O00000Oo;
                tokeniser.O000000o(AfterDoctypeSystemKeyword);
            } else {
                tokeniser.O00000o0((TokeniserState) this);
                tokeniser.O0000O0o.O00000oo = true;
                tokeniser.O00000Oo(BogusDoctype);
            }
        }
    },
    AfterDoctypePublicKeyword {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            switch (characterReader.O00000o()) {
                case 9:
                case 10:
                case 12:
                case 13:
                case ' ':
                    tokeniser.O000000o(BeforeDoctypePublicIdentifier);
                    return;
                case '\"':
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O000000o(DoctypePublicIdentifier_doubleQuoted);
                    return;
                case '\'':
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O000000o(DoctypePublicIdentifier_singleQuoted);
                    return;
                case '>':
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O0000O0o.O00000oo = true;
                    tokeniser.O0000OOo();
                    tokeniser.O000000o(Data);
                    return;
                case 65535:
                    tokeniser.O00000o(this);
                    tokeniser.O0000O0o.O00000oo = true;
                    tokeniser.O0000OOo();
                    tokeniser.O000000o(Data);
                    return;
                default:
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O0000O0o.O00000oo = true;
                    tokeniser.O000000o(BogusDoctype);
                    return;
            }
        }
    },
    BeforeDoctypePublicIdentifier {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            switch (characterReader.O00000o()) {
                case 9:
                case 10:
                case 12:
                case 13:
                case ' ':
                    return;
                case '\"':
                    tokeniser.O000000o(DoctypePublicIdentifier_doubleQuoted);
                    return;
                case '\'':
                    tokeniser.O000000o(DoctypePublicIdentifier_singleQuoted);
                    return;
                case '>':
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O0000O0o.O00000oo = true;
                    tokeniser.O0000OOo();
                    tokeniser.O000000o(Data);
                    return;
                case 65535:
                    tokeniser.O00000o(this);
                    tokeniser.O0000O0o.O00000oo = true;
                    tokeniser.O0000OOo();
                    tokeniser.O000000o(Data);
                    return;
                default:
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O0000O0o.O00000oo = true;
                    tokeniser.O000000o(BogusDoctype);
                    return;
            }
        }
    },
    DoctypePublicIdentifier_doubleQuoted {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            char O00000o = characterReader.O00000o();
            if (O00000o == 0) {
                tokeniser.O00000o0((TokeniserState) this);
                tokeniser.O0000O0o.O00000o.append(TokeniserState.O000oO0o);
            } else if (O00000o == '\"') {
                tokeniser.O000000o(AfterDoctypePublicIdentifier);
            } else if (O00000o == '>') {
                tokeniser.O00000o0((TokeniserState) this);
                tokeniser.O0000O0o.O00000oo = true;
                tokeniser.O0000OOo();
                tokeniser.O000000o(Data);
            } else if (O00000o != TokeniserState.O000oOO0) {
                tokeniser.O0000O0o.O00000o.append(O00000o);
            } else {
                tokeniser.O00000o(this);
                tokeniser.O0000O0o.O00000oo = true;
                tokeniser.O0000OOo();
                tokeniser.O000000o(Data);
            }
        }
    },
    DoctypePublicIdentifier_singleQuoted {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            char O00000o = characterReader.O00000o();
            if (O00000o == 0) {
                tokeniser.O00000o0((TokeniserState) this);
                tokeniser.O0000O0o.O00000o.append(TokeniserState.O000oO0o);
            } else if (O00000o == '\'') {
                tokeniser.O000000o(AfterDoctypePublicIdentifier);
            } else if (O00000o == '>') {
                tokeniser.O00000o0((TokeniserState) this);
                tokeniser.O0000O0o.O00000oo = true;
                tokeniser.O0000OOo();
                tokeniser.O000000o(Data);
            } else if (O00000o != TokeniserState.O000oOO0) {
                tokeniser.O0000O0o.O00000o.append(O00000o);
            } else {
                tokeniser.O00000o(this);
                tokeniser.O0000O0o.O00000oo = true;
                tokeniser.O0000OOo();
                tokeniser.O000000o(Data);
            }
        }
    },
    AfterDoctypePublicIdentifier {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            switch (characterReader.O00000o()) {
                case 9:
                case 10:
                case 12:
                case 13:
                case ' ':
                    tokeniser.O000000o(BetweenDoctypePublicAndSystemIdentifiers);
                    return;
                case '\"':
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O000000o(DoctypeSystemIdentifier_doubleQuoted);
                    return;
                case '\'':
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O000000o(DoctypeSystemIdentifier_singleQuoted);
                    return;
                case '>':
                    tokeniser.O0000OOo();
                    tokeniser.O000000o(Data);
                    return;
                case 65535:
                    tokeniser.O00000o(this);
                    tokeniser.O0000O0o.O00000oo = true;
                    tokeniser.O0000OOo();
                    tokeniser.O000000o(Data);
                    return;
                default:
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O0000O0o.O00000oo = true;
                    tokeniser.O000000o(BogusDoctype);
                    return;
            }
        }
    },
    BetweenDoctypePublicAndSystemIdentifiers {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            switch (characterReader.O00000o()) {
                case 9:
                case 10:
                case 12:
                case 13:
                case ' ':
                    return;
                case '\"':
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O000000o(DoctypeSystemIdentifier_doubleQuoted);
                    return;
                case '\'':
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O000000o(DoctypeSystemIdentifier_singleQuoted);
                    return;
                case '>':
                    tokeniser.O0000OOo();
                    tokeniser.O000000o(Data);
                    return;
                case 65535:
                    tokeniser.O00000o(this);
                    tokeniser.O0000O0o.O00000oo = true;
                    tokeniser.O0000OOo();
                    tokeniser.O000000o(Data);
                    return;
                default:
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O0000O0o.O00000oo = true;
                    tokeniser.O000000o(BogusDoctype);
                    return;
            }
        }
    },
    AfterDoctypeSystemKeyword {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            switch (characterReader.O00000o()) {
                case 9:
                case 10:
                case 12:
                case 13:
                case ' ':
                    tokeniser.O000000o(BeforeDoctypeSystemIdentifier);
                    return;
                case '\"':
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O000000o(DoctypeSystemIdentifier_doubleQuoted);
                    return;
                case '\'':
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O000000o(DoctypeSystemIdentifier_singleQuoted);
                    return;
                case '>':
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O0000O0o.O00000oo = true;
                    tokeniser.O0000OOo();
                    tokeniser.O000000o(Data);
                    return;
                case 65535:
                    tokeniser.O00000o(this);
                    tokeniser.O0000O0o.O00000oo = true;
                    tokeniser.O0000OOo();
                    tokeniser.O000000o(Data);
                    return;
                default:
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O0000O0o.O00000oo = true;
                    tokeniser.O0000OOo();
                    return;
            }
        }
    },
    BeforeDoctypeSystemIdentifier {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            switch (characterReader.O00000o()) {
                case 9:
                case 10:
                case 12:
                case 13:
                case ' ':
                    return;
                case '\"':
                    tokeniser.O000000o(DoctypeSystemIdentifier_doubleQuoted);
                    return;
                case '\'':
                    tokeniser.O000000o(DoctypeSystemIdentifier_singleQuoted);
                    return;
                case '>':
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O0000O0o.O00000oo = true;
                    tokeniser.O0000OOo();
                    tokeniser.O000000o(Data);
                    return;
                case 65535:
                    tokeniser.O00000o(this);
                    tokeniser.O0000O0o.O00000oo = true;
                    tokeniser.O0000OOo();
                    tokeniser.O000000o(Data);
                    return;
                default:
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O0000O0o.O00000oo = true;
                    tokeniser.O000000o(BogusDoctype);
                    return;
            }
        }
    },
    DoctypeSystemIdentifier_doubleQuoted {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            char O00000o = characterReader.O00000o();
            if (O00000o == 0) {
                tokeniser.O00000o0((TokeniserState) this);
                tokeniser.O0000O0o.O00000oO.append(TokeniserState.O000oO0o);
            } else if (O00000o == '\"') {
                tokeniser.O000000o(AfterDoctypeSystemIdentifier);
            } else if (O00000o == '>') {
                tokeniser.O00000o0((TokeniserState) this);
                tokeniser.O0000O0o.O00000oo = true;
                tokeniser.O0000OOo();
                tokeniser.O000000o(Data);
            } else if (O00000o != TokeniserState.O000oOO0) {
                tokeniser.O0000O0o.O00000oO.append(O00000o);
            } else {
                tokeniser.O00000o(this);
                tokeniser.O0000O0o.O00000oo = true;
                tokeniser.O0000OOo();
                tokeniser.O000000o(Data);
            }
        }
    },
    DoctypeSystemIdentifier_singleQuoted {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            char O00000o = characterReader.O00000o();
            if (O00000o == 0) {
                tokeniser.O00000o0((TokeniserState) this);
                tokeniser.O0000O0o.O00000oO.append(TokeniserState.O000oO0o);
            } else if (O00000o == '\'') {
                tokeniser.O000000o(AfterDoctypeSystemIdentifier);
            } else if (O00000o == '>') {
                tokeniser.O00000o0((TokeniserState) this);
                tokeniser.O0000O0o.O00000oo = true;
                tokeniser.O0000OOo();
                tokeniser.O000000o(Data);
            } else if (O00000o != TokeniserState.O000oOO0) {
                tokeniser.O0000O0o.O00000oO.append(O00000o);
            } else {
                tokeniser.O00000o(this);
                tokeniser.O0000O0o.O00000oo = true;
                tokeniser.O0000OOo();
                tokeniser.O000000o(Data);
            }
        }
    },
    AfterDoctypeSystemIdentifier {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            switch (characterReader.O00000o()) {
                case 9:
                case 10:
                case 12:
                case 13:
                case ' ':
                    return;
                case '>':
                    tokeniser.O0000OOo();
                    tokeniser.O000000o(Data);
                    return;
                case 65535:
                    tokeniser.O00000o(this);
                    tokeniser.O0000O0o.O00000oo = true;
                    tokeniser.O0000OOo();
                    tokeniser.O000000o(Data);
                    return;
                default:
                    tokeniser.O00000o0((TokeniserState) this);
                    tokeniser.O000000o(BogusDoctype);
                    return;
            }
        }
    },
    BogusDoctype {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            char O00000o = characterReader.O00000o();
            if (O00000o == '>') {
                tokeniser.O0000OOo();
                tokeniser.O000000o(Data);
            } else if (O00000o == TokeniserState.O000oOO0) {
                tokeniser.O0000OOo();
                tokeniser.O000000o(Data);
            }
        }
    },
    CdataSection {
        /* Access modifiers changed, original: 0000 */
        public void O000000o(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.O000000o(characterReader.O000000o("]]>"));
            characterReader.O00000o("]]>");
            tokeniser.O000000o(Data);
        }
    };
    
    private static final char[] O000o = null;
    static final char O000o0oo = '\u0000';
    private static final String O000oO = null;
    private static final char[] O000oO0 = null;
    private static final char[] O000oO00 = null;
    private static final char[] O000oO0O = null;
    private static final char O000oO0o = '�';
    private static final char O000oOO0 = '￿';

    static {
        O000o = new char[]{'\'', '&', O000o0oo};
        O000oO00 = new char[]{'\"', '&', O000o0oo};
        O000oO0 = new char[]{9, 10, 13, 12, ' ', '/', '=', '>', O000o0oo, '\"', '\'', '<'};
        O000oO0O = new char[]{9, 10, 13, 12, ' ', '&', '>', O000o0oo, '\"', '\'', '<', '=', '`'};
        O000oO = String.valueOf(O000oO0o);
        Arrays.sort(O000o);
        Arrays.sort(O000oO00);
        Arrays.sort(O000oO0);
        Arrays.sort(O000oO0O);
    }

    private static void O00000Oo(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState) {
        if (characterReader.O0000o()) {
            String O0000o00 = characterReader.O0000o00();
            tokeniser.O00000o0.O00000Oo(O0000o00);
            tokeniser.O00000Oo.append(O0000o00);
            return;
        }
        Object obj = 1;
        if (tokeniser.O0000Oo() && !characterReader.O00000Oo()) {
            char O00000o = characterReader.O00000o();
            switch (O00000o) {
                case 9:
                case 10:
                case 12:
                case 13:
                case ' ':
                    tokeniser.O000000o(BeforeAttributeName);
                    break;
                case '/':
                    tokeniser.O000000o(SelfClosingStartTag);
                    break;
                case '>':
                    tokeniser.O00000o();
                    tokeniser.O000000o(Data);
                    break;
                default:
                    tokeniser.O00000Oo.append(O00000o);
                    break;
            }
            obj = null;
        }
        if (obj != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("</");
            stringBuilder.append(tokeniser.O00000Oo.toString());
            tokeniser.O000000o(stringBuilder.toString());
            tokeniser.O000000o(tokeniserState);
        }
    }

    private static void O00000Oo(Tokeniser tokeniser, TokeniserState tokeniserState) {
        int[] O000000o = tokeniser.O000000o(null, false);
        if (O000000o == null) {
            tokeniser.O000000o('&');
        } else {
            tokeniser.O000000o(O000000o);
        }
        tokeniser.O000000o(tokeniserState);
    }

    private static void O00000o(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        char O00000o0 = characterReader.O00000o0();
        if (O00000o0 == 0) {
            tokeniser.O00000o0(tokeniserState);
            characterReader.O00000oo();
            tokeniser.O000000o((char) O000oO0o);
        } else if (O00000o0 == '<') {
            tokeniser.O00000Oo(tokeniserState2);
        } else if (O00000o0 != O000oOO0) {
            tokeniser.O000000o(characterReader.O000000o('<', O000o0oo));
        } else {
            tokeniser.O000000o(new EOF());
        }
    }

    private static void O00000oO(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        if (characterReader.O0000o()) {
            tokeniser.O000000o(false);
            tokeniser.O000000o(tokeniserState);
            return;
        }
        tokeniser.O000000o("</");
        tokeniser.O000000o(tokeniserState2);
    }

    private static void O00000oo(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        if (characterReader.O0000o()) {
            String O0000o00 = characterReader.O0000o00();
            tokeniser.O00000Oo.append(O0000o00);
            tokeniser.O000000o(O0000o00);
            return;
        }
        char O00000o = characterReader.O00000o();
        switch (O00000o) {
            case 9:
            case 10:
            case 12:
            case 13:
            case ' ':
            case '/':
            case '>':
                if (tokeniser.O00000Oo.toString().equals("script")) {
                    tokeniser.O000000o(tokeniserState);
                } else {
                    tokeniser.O000000o(tokeniserState2);
                }
                tokeniser.O000000o(O00000o);
                break;
            default:
                characterReader.O00000oO();
                tokeniser.O000000o(tokeniserState2);
                break;
        }
    }

    public abstract void O000000o(Tokeniser tokeniser, CharacterReader characterReader);
}
