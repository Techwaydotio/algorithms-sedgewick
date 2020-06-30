package Chap01.code;

public class Ex113 {
    public static void main(String[] args) {
        int first = Integer.parseInt(args[0]);
        int second = Integer.parseInt(args[1]);
        int third = Integer.parseInt(args[2]);

        if (first == second && second == third) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }
}
