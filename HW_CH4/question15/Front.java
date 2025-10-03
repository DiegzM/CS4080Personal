/* imports */
import static java.lang.Character.toString;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;


public class Front {
    public static int charClass;
    public static StringBuilder lexeme = new StringBuilder(100);
    public static char nextChar;
    public static int lexLen;
    public static int token;
    public static int nextToken;
    public static final int EOF = -1;
    public static BufferedReader in_fp = null;

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

    /******************************************************/
    /* main driver */
    public static void main(String[] args) {
        /* Open the input data file and process its contents */
        try {
            in_fp = new BufferedReader(new FileReader("question15/front.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR - cannot open front.txt \n");
            return;
        }

        getChar();
        while (nextToken != EOF) {
            lex();
        }
        try {
            in_fp.close();
        } catch (IOException e) {
            System.out.println("ERROR - cannot close front.txt \n");
            return;
        }
        return;
    }

    /*****************************************************/
    /* lookup - a function to lookup operators and parentheses
    and return the token */

    public static int lookup(char ch) {
        switch (ch) {
            case '(':
                addChar();
                nextToken = LEFT_PAREN;
                break;
            case ')':
                addChar();
                nextToken = RIGHT_PAREN;
                break;
            case '+':
                addChar();
                nextToken = ADD_OP;
                break;
            case '-':
                addChar();
                nextToken = SUB_OP;
                break;
            case '*':
                addChar();
                nextToken = MULT_OP;
                break;
            case '/':
                addChar();
                nextToken = DIV_OP;
                break;
            default:
                addChar();
                nextToken = EOF;
                break;
        }
        return nextToken;
    }

    /*****************************************************/
    /* addChar - a function to add nextChar to lexeme */
    public static void addChar() {
        if (lexeme.length() < 100) {
            lexeme.append(nextChar);
        } else {
            System.out.println("Error - lexeme is too long");
        }
    }

    /*****************************************************/
    /* getChar - a function to get the next character of
    input and determine its character class */
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


    /*****************************************************/
    /* getNonBlank - a function to call getChar until it
    returns a non-whitespace character */
    public static void getNonBlank() {
        while (Character.isWhitespace(nextChar)) {
            getChar();
        }
}

    /*****************************************************/
    /* lex - a simple lexical analyzer for arithmetic
    expressions */
    public static int lex() {
        lexeme.setLength(0);
        lexLen = 0;
        getNonBlank();
        switch (charClass) {
            /* Parse identifiers */
            case LETTER:
                addChar();
                getChar();
                while (charClass == LETTER || charClass == DIGIT) {
                    addChar();
                    getChar();
                }
                nextToken = IDENT;
                break;

            /* Parse integer literals */
            case DIGIT:
                addChar();
                getChar();
                while (charClass == DIGIT) {
                    addChar();
                    getChar();
                }
                nextToken = INT_LIT;
                break;

            /* Parentheses and operators */
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
        } /* End of switch */
        System.out.printf("Next token is: %d, Next lexeme is %s\n", nextToken, lexeme.toString());
        return nextToken;
    }
}
   