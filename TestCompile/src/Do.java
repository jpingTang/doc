/**
 * Created by cylee on 15/12/21.
 */
public class Do extends Stmt {
    Expr mExpr;
    Stmt mStmt;

    public Do(Expr expr, Stmt stmt) {
        mExpr = expr;
        mStmt = stmt;
    }
}
