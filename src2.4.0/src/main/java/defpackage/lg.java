package defpackage;

import com.joanzapata.iconify.Icon;

/* compiled from: SWIcon */
/* renamed from: lg */
public enum lg implements Icon {
    edit_clear(59393);
    
    char O00000Oo;

    private lg(char c) {
        this.O00000Oo = c;
    }

    public char character() {
        return this.O00000Oo;
    }

    public String key() {
        return name().replace('_', '-');
    }
}
