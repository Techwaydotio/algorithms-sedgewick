package Chap01.code;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Ex134 {
//    static boolean areBalanced(String expr) {
//        Stack<Character> stack = new Stack<Character>();
//
//        // Traversing the Expression
//        for (int i = 0; i < expr.length(); i++) {
//            char x = expr.charAt(i);
//
//            if (x == '(' || x == '[' || x == '{') {
//                // Push the element in the stack
//                stack.push(x);
//                continue;
//            }
//
//            if (stack.isEmpty())
//                return false;
//
//            switch (x) {
//                case ')':
//                    stack.pop();
//                    if (x != '(')
//                        return false;
//                    break;
//
//                case '}':
//                    stack.pop();
//                    if (x != '{')
//                        return false;
//                    break;
//
//                case ']':
//                    stack.pop();
//                    if (x != '[')
//                        return false;
//                    break;
//            }
//        }
//
//        return (stack.isEmpty());
//    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        Deque<String> q = new ArrayDeque<String>();
        q.offer("Hello");
        q.offer("World");
        q.offer("This");
        q.offer("Is");
        q.offer("It");
        while (!q.isEmpty())
            stack.push(q.poll()); // reverses order of strings
        while (!stack.isEmpty())
            q.offer(stack.pop()); // put back in reverse order

        while (!q.isEmpty())
            System.out.println(q.poll());
    }
}

