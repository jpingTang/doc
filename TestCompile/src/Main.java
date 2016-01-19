import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        String[] testfiles = new String[] {
//                "block1.t",
//                "expr1.t",
//                "expr2.t",
//                "expr3.t",
//                "jump1.t",
                "prog1.t",
        };
        for (int i = 0; i < testfiles.length; i++) {
            FileInputStream fs = new FileInputStream("D:\\tests\\"+testfiles[i]);
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));
            String input = null;
            StringBuilder sb = new StringBuilder();
            while ((input = br.readLine()) != null) {
                sb.append(input);
            }
            Lexer lexer = new Lexer(sb.toString());
            Parser parser = new Parser(lexer);
            parser.program();
        }
    }
}
