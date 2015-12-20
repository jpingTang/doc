import java.io.FileInputStream;

/**
 * Created by cylee on 15/12/20.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("/Users/cylee/Sources/CompilerFront/tests/prog3.t");
        Lexer lex = new Lexer(fileInputStream);
        Token token = null;
        while ((token = lex.scan()) != null) {
            System.out.println(token);
        }
    }
}
