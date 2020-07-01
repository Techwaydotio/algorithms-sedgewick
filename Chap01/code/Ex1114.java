package Chap01.code;

public class Ex1114 {
    /*
    Write a static method lg() that takes an int value N as argument and returns
the largest int not larger than the base-2 logarithm of N. Do not use Math.
     */

    static int lg(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        int acc = 2;
        int result = 1;
        while (acc * 2 <= n) {
            acc *= 2;
            result += 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lg(3));
        System.out.println(lg(4));
        System.out.println(lg(64));
    }
}
