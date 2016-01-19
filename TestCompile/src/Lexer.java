import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.HashMap;

/**
 * Created by cylee on 15/12/20.
 */
public class Lexer {
    private static final char END = (char)-1;
    private InputStream mStream;
    private char c = END;

    long mLine;

    private HashMap<String, Token> mReverts = new HashMap<String, Token>();

    public Lexer(InputStream stream) {
        mStream = new BufferedInputStream(stream);
        init();
    }

    public Lexer(String input) {
        mStream = new BufferedInputStream(new StringBufferInputStream(input));
        init();
    }

    private void init() {
        revert(Word.TRUE);
        revert(Word.FALSE);
        revert(Word.IF);
        revert(Word.ELSE);
        revert(Word.DO);
        revert(Word.WHILE);
        revert(Word.BREAK);
        revert(Word.CONTINUE);

        revert(Type.BOOLEAN);
        revert(Type.INT);
        revert(Type.FLOAT);
        revert(Type.CHAR);
    }

    private void revert(Word word) {
        mReverts.put(word.mLexeme, word);
    }

    char read() {
        try {
            mStream.mark(4);
            c = (char)mStream.read();
        } catch (Exception e) {
            c = END;
        }
        return c;
    }

    void back() {
        try {
            mStream.reset();
        } catch (Exception e) {
        }
    }

    boolean reach(char c) {
        mStream.mark(4);
        read();
        if (this.c == c) {
            return true;
        } else {
            try {
                mStream.reset();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public Token scan() {
        read();
        while (c == ' ' || c == '\t' || c == '\n') {
            if (c == '\n') {
                mLine++;
            }
            read();
        }
        if (c == END) return null;

        Token t = null;
        switch (c) {
            case '&':
                if (reach('&')) {
                    return Word.AND;
                } else {
                    return new Token('&');
                }
            case '|':
                if (reach('|')) {
                    return Word.OR;
                } else {
                    return new Token('|');
                }
            case '>':
                if (reach('=')) {
                    return Word.GE;
                } else {
                    return new Token('>');
                }
            case '!':
                if (reach('=')) {
                    return Word.NE;
                } else {
                    return new Token('!');
                }
            case '<':
                if (reach('=')) {
                    return Word.LE;
                } else {
                    return new Token('<');
                }
            case '=':
                if (reach('=')) {
                    return Word.EQ;
                } else {
                    return new Token('=');
                }
        }

        if (Character.isDigit(c)) {
            int n = 0;
            while (Character.isDigit(c)) {
                n = n*10 + Character.digit(c, 10);
                read();
            }
            if (c != '.') {
                back();
                return new Num(n);
            } else {
                read();
                float f = 0;
                int factor = 0;
                while (Character.isDigit(c)) {
                    int m = factor++;
                    float f2 = Character.digit(c, 10);
                    while (m-- >= 0) {
                        f2 /= 10f;
                    }
                    f += f2;
                    read();
                }
                back();
                return new Real(n + f);
            }
        }

        if (Character.isLetter(c)) {
            StringBuilder sb = new StringBuilder();
            while (Character.isLetterOrDigit(c)) {
                sb.append(c);
                read();
            }
            back();
            String s = sb.toString();
            if (mReverts.containsKey(s)) {
                return mReverts.get(s);
            } else {
                return new Word(Tag.ID, s);
            }
        }

        t = new Token(c);
        return t;
    }
}
