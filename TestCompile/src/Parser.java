/**
 * Created by cylee on 15/12/21.
 */
public class Parser {
    private Lexer mLexer;
    private Token mLook;
    public Parser(Lexer lexer) {
        mLexer = lexer;
        move();
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
            move();
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

    Stmt assign() {
        Stmt stmt = null;
        if (mLook.mTag == Tag.ID) {
            Id id = new Id((Word)mLook, null);
            move();
            match('=');
            Expr expr = bool();
            match(';');
            stmt = new Assign(id, expr);
        }
        return stmt;
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
                match(Tag.WHILE);
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



    Expr bool() {
        Expr e1 = equal();
        while (mLook.mTag == Tag.AND || mLook.mTag == Tag.OR) {
            Token token = mLook;
            move();
            e1 = new And(token, e1, equal());
        }
        return e1;
    }

    Expr equal() {
        Expr e1 = rel();
        switch (mLook.mTag) {
            case Tag.EQ:
            case Tag.NE:
                Token token = mLook;
                move();
                Expr e2 = rel();
                return new Equal(token, e1, e2);
        }
        return e1;
    }

    Expr rel() {
        Expr e1 = add();
        switch (mLook.mTag) {
            case '>':
            case '<':
            case Tag.LE:
            case Tag.GE:
                Token token = mLook;
                move();
                Expr e2 = add();
                return new Rel(token, e1, e2);
        }
        return e1;
    }

    Expr add() {
        Expr e1 = mul();
        while (mLook.mTag == '+' || mLook.mTag == '-') {
            Token tag = mLook;
            move();
            e1 = new Arith(tag, e1, mul());
        }
        return e1;
    }

    Expr mul() {
        Expr e1 = not();
        while (mLook.mTag == '*' || mLook.mTag == '/') {
            Token tag = mLook;
            move();
            e1 = new Arith(tag, e1, not());
        }
        return e1;
    }

    Expr not() {
        if (mLook.mTag == '~' || mLook.mTag == '!') {
            Token token = mLook;
            move();
            return new Not(token, not());
        }
        return minus();
    }

    Expr minus() {
        if (mLook.mTag == '-') {
            Token token = mLook;
            move();
            Expr expr = factor();
            return new Minus(token, expr, expr);
        }
        return factor();
    }

    Expr factor() {
        Expr x = null;
        switch (mLook.mTag) {
            case '(':
                move();
                x = bool();
                match(')');
                return x;
            case Tag.NUM:
                Num num = (Num) mLook;
                x = new Constant(num.mValue);
                move();
                return x;
            case Tag.REAL:
                x = new Constant(mLook, Type.FLOAT);
                move();
                return x;
            case Tag.TRUE:
                x = Constant.TRUE;
                move();
                return x;
            case Tag.FALSE:
                x = Constant.FALSE;
                move();
                return x;
            case Tag.ID:
                Word word = (Word)mLook;
                x = new Id(word, null);
                move();
                return x;
            default:
                error("syntax error");
        }
        return null;
    }
}
