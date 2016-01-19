/**
 * Created by zybang on 2016/1/19.
 */
public class Minus extends Logic{
    public Minus(Token op, Expr e1, Expr e2) {
        super(op, e1, e2);
    }

    @Override
    public String toString() {
        return mOp+" "+mE1;
    }
}
