package Chap01.code;

import java.util.Scanner;
import java.util.Stack;

public class Ex1311 {
    static int evaluatePostfix(String input) {
        Stack s = new Stack<Integer>();
        String[] parts = input.split("\\s+");
        for (String part : parts) {
            if (part.equals(" ")) {
                continue;
            }
            if (part.equals("+")) {
                int first = (int)s.pop();
                int second = (int)s.pop();
                s.push(first + second);
            } else if (part.equals("*")) {
                int first = (int)s.pop();
                int second = (int)s.pop();
                s.push(first * second);
            } else {
                s.push(Integer.parseInt(part));
            }
        }
        return (int)s.pop();
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
            String input = s.nextLine();
            System.out.println(evaluatePostfix(input));
        }
    }
}
