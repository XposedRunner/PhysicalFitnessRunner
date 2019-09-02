package com.qiyukf.nimlib.c.a;

import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.qiyukf.basesdk.a.a;

public final class d extends CursorWrapper {
    private Cursor a;

    private d(Cursor cursor) {
        super(cursor);
        this.a = cursor;
    }

    public static d a(Cursor cursor) {
        return cursor == null ? null : new d(cursor);
    }

    private static final boolean a(Exception exception) {
        exception.printStackTrace();
        boolean z = false;
        if (exception instanceof SQLiteException) {
            String message = exception.getMessage();
            if (!TextUtils.isEmpty(message) && message.contains("lock")) {
                z = true;
            }
            if (z) {
                a.e("db", "query locked!");
            }
        }
        return z;
    }

    public final void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                this.a.copyStringToBuffer(i, charArrayBuffer);
            } catch (RuntimeException e) {
                if (!a(e)) {
                    throw e;
                }
            }
        }
    }

    public final byte[] getBlob(int i) {
        int i2 = 0;
        while (i2 < 3) {
            try {
                return this.a.getBlob(i);
            } catch (RuntimeException e) {
                if (a(e)) {
                    i2++;
                } else {
                    throw e;
                }
            }
        }
        return null;
    }

    public final int getColumnCount() {
        int i = 0;
        while (i < 3) {
            try {
                return this.a.getColumnCount();
            } catch (RuntimeException e) {
                if (a(e)) {
                    i++;
                } else {
                    throw e;
                }
            }
        }
        return 0;
    }

    public final int getColumnIndex(String str) {
        int i = 0;
        while (i < 3) {
            try {
                return this.a.getColumnIndex(str);
            } catch (RuntimeException e) {
                if (a(e)) {
                    i++;
                } else {
                    throw e;
                }
            }
        }
        return -1;
    }

    public final int getColumnIndexOrThrow(String str) {
        int i = 0;
        while (i < 3) {
            try {
                return this.a.getColumnIndexOrThrow(str);
            } catch (RuntimeException e) {
                if (a(e)) {
                    i++;
                } else {
                    throw e;
                }
            }
        }
        return -1;
    }

    public final String getColumnName(int i) {
        int i2 = 0;
        while (i2 < 3) {
            try {
                return this.a.getColumnName(i);
            } catch (RuntimeException e) {
                if (a(e)) {
                    i2++;
                } else {
                    throw e;
                }
            }
        }
        return null;
    }

    public final String[] getColumnNames() {
        int i = 0;
        while (i < 3) {
            try {
                return this.a.getColumnNames();
            } catch (RuntimeException e) {
                if (a(e)) {
                    i++;
                } else {
                    throw e;
                }
            }
        }
        return null;
    }

    public final int getCount() {
        int i = 0;
        while (i < 3) {
            try {
                return this.a.getCount();
            } catch (RuntimeException e) {
                if (a(e)) {
                    i++;
                } else {
                    throw e;
                }
            }
        }
        return 0;
    }

    public final double getDouble(int i) {
        int i2 = 0;
        while (i2 < 3) {
            try {
                return this.a.getDouble(i);
            } catch (RuntimeException e) {
                if (a(e)) {
                    i2++;
                } else {
                    throw e;
                }
            }
        }
        return 0.0d;
    }

    public final float getFloat(int i) {
        int i2 = 0;
        while (i2 < 3) {
            try {
                return this.a.getFloat(i);
            } catch (RuntimeException e) {
                if (a(e)) {
                    i2++;
                } else {
                    throw e;
                }
            }
        }
        return 0.0f;
    }

    public final int getInt(int i) {
        int i2 = 0;
        while (i2 < 3) {
            try {
                return this.a.getInt(i);
            } catch (RuntimeException e) {
                if (a(e)) {
                    i2++;
                } else {
                    throw e;
                }
            }
        }
        return 0;
    }

    public final long getLong(int i) {
        int i2 = 0;
        while (i2 < 3) {
            try {
                return this.a.getLong(i);
            } catch (RuntimeException e) {
                if (a(e)) {
                    i2++;
                } else {
                    throw e;
                }
            }
        }
        return 0;
    }

    public final int getPosition() {
        int i = 0;
        while (i < 3) {
            try {
                return this.a.getPosition();
            } catch (RuntimeException e) {
                if (a(e)) {
                    i++;
                } else {
                    throw e;
                }
            }
        }
        return 0;
    }

    public final short getShort(int i) {
        int i2 = 0;
        while (i2 < 3) {
            try {
                return this.a.getShort(i);
            } catch (RuntimeException e) {
                if (a(e)) {
                    i2++;
                } else {
                    throw e;
                }
            }
        }
        return (short) 0;
    }

    public final String getString(int i) {
        int i2 = 0;
        while (i2 < 3) {
            try {
                return this.a.getString(i);
            } catch (RuntimeException e) {
                if (a(e)) {
                    i2++;
                } else {
                    throw e;
                }
            }
        }
        return null;
    }

    public final boolean move(int i) {
        int i2 = 0;
        while (i2 < 3) {
            try {
                return this.a.move(i);
            } catch (RuntimeException e) {
                if (a(e)) {
                    i2++;
                } else {
                    throw e;
                }
            }
        }
        return false;
    }

    public final boolean moveToFirst() {
        int i = 0;
        while (i < 3) {
            try {
                return this.a.moveToFirst();
            } catch (RuntimeException e) {
                if (a(e)) {
                    i++;
                } else {
                    throw e;
                }
            }
        }
        return false;
    }

    public final boolean moveToLast() {
        int i = 0;
        while (i < 3) {
            try {
                return this.a.moveToLast();
            } catch (RuntimeException e) {
                if (a(e)) {
                    i++;
                } else {
                    throw e;
                }
            }
        }
        return false;
    }

    public final boolean moveToNext() {
        int i = 0;
        while (i < 3) {
            try {
                return this.a.moveToNext();
            } catch (RuntimeException e) {
                if (a(e)) {
                    i++;
                } else {
                    throw e;
                }
            }
        }
        return false;
    }

    public final boolean moveToPosition(int i) {
        int i2 = 0;
        while (i2 < 3) {
            try {
                return this.a.moveToPosition(i);
            } catch (RuntimeException e) {
                if (a(e)) {
                    i2++;
                } else {
                    throw e;
                }
            }
        }
        return false;
    }

    public final boolean moveToPrevious() {
        int i = 0;
        while (i < 3) {
            try {
                return this.a.moveToPrevious();
            } catch (RuntimeException e) {
                if (a(e)) {
                    i++;
                } else {
                    throw e;
                }
            }
        }
        return false;
    }
}
