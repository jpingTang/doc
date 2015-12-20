/**
 * Created by cylee on 15/12/20.
 */
public class Word extends Token {
    public static final Word AND = new Word(Tag.AND, "&&");
    public static final Word OR = new Word(Tag.OR, "||");
    public static final Word EQ = new Word(Tag.EQ, "==");
    public static final Word NE = new Word(Tag.NE, "!=");
    public static final Word LE = new Word(Tag.LE, "<=");
    public static final Word GE = new Word(Tag.GE, ">=");
    public static final Word TRUE = new Word(Tag.TRUE, "true");
    public static final Word FALSE = new Word(Tag.FALSE, "false");
    public static final Word IF = new Word(Tag.FALSE, "if");
    public static final Word ELSE = new Word(Tag.FALSE, "else");
    public static final Word DO = new Word(Tag.FALSE, "do");
    public static final Word WHILE = new Word(Tag.FALSE, "while");
    public static final Word BREAK = new Word(Tag.FALSE, "break");
    public static final Word CONTINUE = new Word(Tag.FALSE, "continue");
    String mLexeme = "";

    public Word(int tag, String lexeme) {
        super(tag);
        mLexeme = lexeme;
    }

    @Override
    public String toString() {
        return mLexeme;
    }
}
