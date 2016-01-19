package main;
import java.io.*;
import java.util.Arrays;

import lexer.*; import parser.*;

public class Main {

	public static void main(String[] args) throws IOException {
//		Lexer lex = new Lexer();
//		Parser parse = new Parser(lex);
//		parse.program();
//		System.out.write('\n');

		String test = "oo|2o";
		String[] ts = test.split("\\|");
		System.out.println(ts[0] +"   "+System.currentTimeMillis());
	}
}
