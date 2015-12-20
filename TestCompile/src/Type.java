/**
 * Created by cylee on 15/12/20.
 */
public class Type extends Word{
    int mWidth;
    public Type(int tag, String lexeme, int width) {
        super(tag, lexeme);
        mWidth = width;
    }

    public static final Type INT = new Type(Tag.BASIC, "int", 4);
    public static final Type CHAR = new Type(Tag.BASIC, "char", 1);
    public static final Type BOOLEAN = new Type(Tag.BASIC, "boolean", 1);
    public static final Type FLOAT = new Type(Tag.BASIC, "float", 4);
}
