/**
 * Created by cylee on 15/12/21.
 */
public class If extends Stmt {
    Expr mExpr;
    Stmt mStmt;

    public If(Expr expr, Stmt stmt) {
        mExpr = expr;
        mStmt = stmt;
        System.out.println("if "+expr+" "+stmt);
    }
}
