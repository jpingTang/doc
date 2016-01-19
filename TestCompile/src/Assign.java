/**
 * Created by zybang on 2016/1/18.
 */
public class Assign extends Stmt{
    Id id;
    Expr expr;
    Assign(Id id, Expr expr) {
        this.id = id;
        this.expr = expr;
        System.out.println(id+" = "+expr);
    }

    @Override
    public String toString() {
        return id + " = "+expr;
    }
}
