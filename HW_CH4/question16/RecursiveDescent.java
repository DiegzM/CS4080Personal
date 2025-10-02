/* a lexical analyzer + recursive-descent parser
for simple arithmetic expressions:
<expr>   -> <term> {(+ | -) <term>}
<term>   -> <factor> {(* | /) <factor>}
<factor> -> id | int_constant | ( <expr> )
*/



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileReader;

public class RecursiveDescent {
    /* ---------- Global declarations ---------- */
    /* Variables */

    public static int charClass;
    public static StringBuilder lexeme = new StringBuilder();
    public static char nextChar;
    public static int lexLen;
    public static int token;
    public static int nextToken;
    public static BufferedReader in_fp;

    /* Character classes */
    public static final int LETTER = 0;
    public static final int DIGIT = 1;
    public static final int UNKNOWN = 99;

    /* Token codes */
    public static final int INT_LIT = 10;
    public static final int IDENT = 11;
    public static final int ASSIGN_OP = 20;
    public static final int ADD_OP = 21;
    public static final int SUB_OP = 22;
    public static final int MULT_OP = 23;
    public static final int DIV_OP = 24;
    public static final int LEFT_PAREN = 25;
    public static final int RIGHT_PAREN = 26;
    public static final int EOF = -1;

    /* ============================================================
    LEXER IMPLEMENTATION
    ============================================================ */

    /* lookup - lookup operators and parentheses and return token */
    public static int lookup(char ch) {
        switch (ch) {
        case '(':
            addChar();
            nextToken = LEFT_PAREN; break;
        case ')':
            addChar();
            nextToken = RIGHT_PAREN; break;
        case '+':
            addChar();
            nextToken = ADD_OP; break;
        case '-':
            addChar();
            nextToken = SUB_OP; break;
        case '*':
            addChar();
            nextToken = MULT_OP; break;
        case '/':
            addChar();
            nextToken = DIV_OP; break;
        default:
            addChar();
            nextToken = EOF;  /* Treat unknown as EOF/error sentinel */
            break;
        }
        return nextToken;
    }

    /* addChar - add nextChar to lexeme */
    public static void addChar() {
        if (lexeme.length() <= 98) {
            lexeme.append(nextChar);
        } else {
            System.out.println("Error - lexeme is too long");
            System.exit(1);
        }
    }

    /* getChar - get next character and set charClass */
    public static void getChar() {
        try {
            int data = in_fp.read();
            if (data != -1) {
                nextChar = (char) data;
                if (Character.isLetter(nextChar))
                    charClass = LETTER;
                else if (Character.isDigit(nextChar))
                    charClass = DIGIT;
                else
                    charClass = UNKNOWN;
            } else {
                charClass = EOF;
            }
        } catch (IOException e) {
            charClass = EOF;
        }
    }

    /* getNonBlank - skip whitespace */
    public static void getNonBlank() {
        while (Character.isWhitespace(nextChar)) {
            getChar();
        }
    }

    /* lex - simple lexical analyzer for arithmetic expressions */
    public static int lex() {
        lexeme.setLength(0);  // reset lexeme
        getNonBlank();
        switch (charClass) {
            /* identifiers */
            case LETTER:
                addChar(); getChar();
                while (charClass == LETTER || charClass == DIGIT) {
                    addChar(); getChar();
                }
                nextToken = IDENT;
                break;
            /* integer literals */
            case DIGIT:
                addChar(); getChar();
                while (charClass == DIGIT) {
                    addChar(); getChar();
                }
                nextToken = INT_LIT;
                break;
            /* operators & parentheses */
            case UNKNOWN:
                lookup(nextChar);
                getChar();
                break;
            /* EOF */
            case EOF:
                nextToken = EOF;
                lexeme.setLength(0);
                lexeme.append("EOF");
                break;
        }
        System.out.printf("Next token is: %d, Next lexeme is %s\n",
                          nextToken, lexeme.toString());
        return nextToken;
    }

    /* ============================================================
    PARSER IMPLEMENTATION (recursive-descent)
    ============================================================ */

    /* expr
        <expr> -> <term> {(+ | -) <term>}
    */
    public static void expr() {
        System.out.println("Enter <expr>"); 
        term();
        while (nextToken == ADD_OP || nextToken == SUB_OP) {
            lex();     /* consume + or - */
            term();
        }
        System.out.println("Exit <expr>");
    }

    /* term
    <term> -> <factor> {(* | /) <factor>}
    */
    public static void term() {
        System.out.println("Enter <term>");
        factor();
        while (nextToken == MULT_OP || nextToken == DIV_OP) {
            lex();     /* consume * or / */
            factor();
        }
        System.out.println("Exit <term>");
    }

    /* factor
    <factor> -> id | int_constant | ( <expr> )
    */
    public static void factor() {
        System.out.println("Enter <factor>");
        if (nextToken == IDENT) {
            lex();  /* consume identifier */
        }
        else if (nextToken == INT_LIT) {
            lex();  /* consume integer literal */
        }
        else if (nextToken == LEFT_PAREN) {
            lex();  /* consume '(' */
            expr(); /* parse subexpression */
            if (nextToken == RIGHT_PAREN) {
                lex(); /* consume ')' */
            }
            else {
                error("Missing right parenthesis");
            }
        }
        else {
            error("Expected identifier, integer literal, or '('");
        }
        System.out.println("Exit <factor>");
    }

    /* Simple error reporter */
    public static void error(String msg) {
        System.err.printf("Syntax error: %s. Offending lexeme: \"%s\"\n",
                          msg, lexeme.toString());
        System.exit(1);
    }

    /* main driver */
    public static void main(String[] args) {
        FileReader fr;
        
        try {
            in_fp = new BufferedReader(new FileReader("question16/front.txt"));
        } catch (IOException e) {
            System.err.println("ERROR - cannot open front.txt");
            return;
        }

        RecursiveDescent.getChar();   // load first character
        RecursiveDescent.lex();       // load first token & print it

        RecursiveDescent.expr();      // kick off parse at <expr>

        if (nextToken != EOF) {
            System.err.printf("Syntax error: extra input after complete <expr>. Token %d, lexeme \"%s\".\n",
                               nextToken, lexeme.toString());
        } else {
            System.out.println("Parse successful.");
        }

        try {
            in_fp.close();
        } catch (IOException e) {
            // ignore
        }
    }
}
