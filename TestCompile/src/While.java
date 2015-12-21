/**
 * Created by cylee on 15/12/21.
 */
public class While extends Stmt{
    Expr mExpr;
    Stmt mStmt;

    public While(Expr expr, Stmt stmt) {
        mExpr = expr;
        mStmt = stmt;
    }
}
