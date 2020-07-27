package Chap01.code;

import java.util.*;

public class Ex139 {
    static String parseExpr(String expr) {
        Stack in = new Stack<Character>();
        Stack out = new Stack<Character>();
        for (char c : expr.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if (c == ')') {
                while(!in.empty()) {
                    out.add(in.pop());
                }
                in.push('(');
                while(!out.empty()) {
                    in.add(out.pop());
                }
            }
            in.push(c);
        }
        return in.toString();
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
            String input = s.nextLine();
            System.out.println(parseExpr(input));
        }
    }
}
