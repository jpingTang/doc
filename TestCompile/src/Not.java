/**
 * Created by zybang on 2016/1/18.
 */
public class Not extends Logic {
    public Not(Token op, Expr e1) {
        super(op, e1, e1);
    }

    @Override
    public String toString() {
        return mOp+" "+mE1;
    }
}
