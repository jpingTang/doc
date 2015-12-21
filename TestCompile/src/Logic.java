/**
 * Created by cylee on 15/12/21.
 */
public class Logic extends Expr{
    Token mOp;
    Expr mE1;
    Expr mE2;

    public Logic(Token op, Expr e1, Expr e2) {
        super(op, null);
        mOp = op;
        mE1 = e1;
        mE2 = e2;
    }
}
