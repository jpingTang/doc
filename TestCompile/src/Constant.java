/**
 * Created by zybang on 2016/1/15.
 */
public class Constant extends Expr {
    public Constant(Token token, Type type) {
        super(token, type);
    }

    public Constant(int value) {
        super(new Num(value), Type.INT);
    }

    public static Constant TRUE = new Constant(Word.TRUE, Type.BOOLEAN);
    public static Constant FALSE = new Constant(Word.FALSE, Type.BOOLEAN);
}
