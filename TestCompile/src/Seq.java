/**
 * Created by cylee on 15/12/21.
 */
public class Seq extends Stmt {
    Stmt s1;
    Stmt s2;
    public Seq(Stmt s1, Stmt s2) {
        this.s1 = s1;
        this.s2 = s2;
    }
}
