/**
 * Created by cylee on 15/12/21.
 */
public class Else extends Stmt {
    Expr mExpr;
    Stmt mS1;
    Stmt mS2;

    public Else(Expr expr, Stmt s1, Stmt s2) {
        mExpr = expr;
        mS1 = s1;
        mS2 = s2;
    }
}
