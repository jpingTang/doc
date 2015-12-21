/**
 * Created by cylee on 15/12/21.
 */
public class Parser {
    private Lexer mLexer;
    private Token mLook;
    public Parser(Lexer lexer) {
        mLexer = lexer;
    }

    private void move() {
        mLook = mLexer.scan();
    }

    private void error(String msg) {
        throw new RuntimeException(msg+" in line "+mLexer.mLine);
    }

    private void match(int i) {
        if (mLook.mTag == i) {
            move();
        } else {
            error("syntax error");
        }
    }

    public void program() {
        Stmt s = block();
    }

    private Stmt block() {
        match('{');
        decls(); Stmt s = stmts();
        match('}');
        return s;
    }

    private void decls() {
        while (mLook.mTag == Tag.BASIC) {
            Type type = type();
            Token c = mLook;
            match(Tag.ID);
            match(';');
        }
    }

    private Type type() {
        Type p = (Type)mLook;
        if (mLook.mTag != '[') {
            return p;
        } else {
            return array(p);
        }
    }

    private Array array(Type type) {
        match('[');
        int num = ((Num)mLook).mValue;
        match(']');
        Array array = new Array(type, num);
        if (mLook.mTag != '[') {
            return array;
        } else {
            return array(array);
        }
    }

    private Stmt stmts() { // stmts--> stmt*
        if (mLook.mTag == '}') return Stmt.Null;
        return new Seq(stmt(), stmts());
    }

    private Stmt stmt() {
        Expr expr;
        Stmt s, s1, s2;
        switch (mLook.mTag) {
            case ';':
                move();
                return Stmt.Null;
            case '{':
                return block();
            case Tag.IF:
                match(Tag.IF);
                match('(');
                expr = bool();
                match(')');
                s = stmt();
                if (mLook.mTag != Tag.ELSE) {
                    return new If(expr, s);
                } else {
                    match(Tag.ELSE);
                    s1 = stmt();
                    return new Else(expr, s, s1);
                }
            case Tag.WHILE:
                match('(');
                expr = bool();
                match(')');
                s = stmt();
                return new While(expr, s);
            case Tag.DO:
                s = stmt();
                match(Tag.WHILE);
                match('(');
                expr = bool();
                match(')');
                match(';');
                return new Do(expr, s);
            default:
                return assign();

        }
    }

    Expr assign() {
        match(Tag.ID);
        match('=');
        Stmt expr = stmt();
    }

    Expr bool() {

    }

}
