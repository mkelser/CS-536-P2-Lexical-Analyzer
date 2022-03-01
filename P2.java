import java.util.*;
import java.io.*;
import java_cup.runtime.*;  // defines Symbol

/**
 * This program is to be used to test the CSX scanner.
 * This version is set up to test all tokens, but more code is needed to test
 * other aspects of the scanner (e.g., input that causes errors, character
 * numbers, values associated with tokens)
 */
public class P2 {
    public static void main(String[] args) throws IOException {
        // exception may be thrown by yylex
        // test all tokens

        CharNum.num = 1;
        testAllTokens("allTokens", ".in");
	CharNum.num = 1;
	testAllTokens("moreTokens", ".in");
	CharNum.num = 1;
	testAllTokens("allErrors", ".in");
	CharNum.num = 1;
        testAllTokens("eof", ".txt");
    }

    /**
     * testAllTokens
     *
     * Open and read from file allTokens.txt
     * For each token read, write the corresponding string to allTokens.out
     * If the input file contains all tokens, one per line, we can verify
     * correctness of the scanner by comparing the input and output files
     * (e.g., using a 'diff' command).
     * par
     */
    private static void testAllTokens(String name, String ext) throws IOException {
        // open input and output files
        FileReader inFile = null;
        PrintWriter outFile = null;
        try {
            inFile = new FileReader(name + ext);
            outFile = new PrintWriter(new FileWriter(name + ".out"));
        } catch (FileNotFoundException ex) {
            System.err.println("File " + name + ext + " not found.");
            System.exit(-1);
        } catch (IOException ex) {
            System.err.println(name + " cannot be opened.");
            System.exit(-1);
        }

        // create and call the scanner
        Yylex scanner = new Yylex(inFile);
        Symbol token = scanner.next_token();
        while (token.sym != sym.EOF) {
            switch (token.sym) {
                case sym.BOOL:
                    outFile.println("bool at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.INT:
                    outFile.println("int at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.VOID:
                    outFile.println("void at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.TRUE:
                    outFile.println("true at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.FALSE:
                    outFile.println("false at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.STRUCT:
                    outFile.println("struct at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.INPUT:
                    outFile.println("input at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.DISP:
                    outFile.println("disp at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.IF:
                    outFile.println("if at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.ELSE:
                    outFile.println("else at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.WHILE:
                    outFile.println("while at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.RETURN:
                    outFile.println("return at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.ID:
                    outFile.println(((IdTokenVal)token.value).idVal +
                            " at line #: " + (((TokenVal)token.value).lineNum) +
                            " starting with char: " +
                            (((TokenVal)token.value).charNum));
                    break;
                case sym.INTLITERAL:
                    outFile.println(((IntLitTokenVal)token.value).intVal +
                            " at line #: " + (((TokenVal)token.value).lineNum) +
                            " starting with char: " +
                            (((TokenVal)token.value).charNum));
                    break;
                case sym.STRINGLITERAL:
                    outFile.println(((StrLitTokenVal)token.value).strVal +
                            " at line #: " + (((TokenVal)token.value).lineNum) +
                            " starting with char: " +
                            (((TokenVal)token.value).charNum));
                    break;
                case sym.LCURLY:
                    outFile.println("{ at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.RCURLY:
                    outFile.println("} at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.LPAREN:
                    outFile.println("( at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.RPAREN:
                    outFile.println(") at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.SEMICOLON:
                    outFile.println("; at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.COMMA:
                    outFile.println(", at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.DOT:
                    outFile.println(". at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.WRITE:
                    outFile.println("<< at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.READ:
                    outFile.println(">> at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.PLUSPLUS:
                    outFile.println("++ at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.MINUSMINUS:
                    outFile.println("-- at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.PLUS:
                    outFile.println("+ at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.MINUS:
                    outFile.println("- at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.TIMES:
                    outFile.println("* at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.DIVIDE:
                    outFile.println("/ at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.NOT:
                    outFile.println("! at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.AND:
                    outFile.println("&& at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.OR:
                    outFile.println("|| at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.EQUALS:
                    outFile.println("== at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.NOTEQUALS:
                    outFile.println("!= at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.LESS:
                    outFile.println("< at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.GREATER:
                    outFile.println("> at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.LESSEQ:
                    outFile.println("<= at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.GREATEREQ:
                    outFile.println(">= at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                case sym.ASSIGN:
                    outFile.println("= at line #: " +
                            (((TokenVal)token.value).lineNum) + " starting " +
                            "with char: " + (((TokenVal)token.value).charNum));
                    break;
                default:
                    outFile.println("UNKNOWN TOKEN");
            } // end switch
            token = scanner.next_token();
        } // end while
        outFile.close();
    }
}
