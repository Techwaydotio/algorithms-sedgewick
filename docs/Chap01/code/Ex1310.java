package Chap01.code;

import java.util.Scanner;
import java.util.Stack;

public class Ex1310 {
    static int precedence(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    static String infixToPostfix(String input) {
        Stack output = new Stack<Character>();
        Stack symbols = new Stack<Character>();
        for (char c : input.toCharArray()){
            if (Character.isLetterOrDigit(c)) {
                output.push(c);
            } else if (c == ' ' || c == '(') {
                symbols.push(c);
            } else if (c == ')') {
                while (!symbols.isEmpty() && (char)symbols.peek() != '(')
                    output.push(symbols.pop());

                if (!symbols.isEmpty() && (char)symbols.peek() != '(')
                    return "Invalid Expression"; // invalid expression
                else
                    symbols.pop();
            } else {
                while (!symbols.isEmpty() && precedence(c) <= precedence((char)symbols.peek())){
                    if((char)symbols.peek() == '(')
                        return "Invalid Expression";
                    output.push(symbols.pop());
                }
                symbols.push(c);
            }
        }

        while(!symbols.empty()) {
            output.push(symbols.pop());
        }

        return output.toString();
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
            String input = s.nextLine();
            System.out.println(infixToPostfix(input));
        }
    }
}
