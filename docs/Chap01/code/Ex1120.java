package Chap01.code;

public class Ex1120 {
    /*
     Write a recursive static method that computes the value of ln (N !)
     */
    static int lnProduct(int n) {
        if (n == 1) {
            return 0;
        }
        return lg(n) + lnProduct(n-1);
    }

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
        System.out.println(lnProduct(5));
    }
}
