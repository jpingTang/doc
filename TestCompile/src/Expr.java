/**
 * Created by cylee on 15/12/21.
 */
public class Expr extends Node{
    Token mToken;
    Type mType;

    Expr(Token token, Type type) {
        mToken = token;
        mType = type;
    }
}
