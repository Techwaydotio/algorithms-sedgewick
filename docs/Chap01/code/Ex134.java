package Chap01.code;

import java.util.Stack;

public class Ex134 {
    static boolean areBalanced(String expr) {
        Stack<Character> stack = new Stack<Character>();

        // Traversing the Expression
        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);

            if (x == '(' || x == '[' || x == '{') {
                // Push the element in the stack
                stack.push(x);
                continue;
            }

            if (stack.isEmpty())
                return false;

            switch (x) {
                case ')':
                    stack.pop();
                    if (x != '(')
                        return false;
                    break;

                case '}':
                    stack.pop();
                    if (x != '{')
                        return false;
                    break;

                case ']':
                    stack.pop();
                    if (x != '[')
                        return false;
                    break;
            }
        }

        return (stack.isEmpty());
    }
}
