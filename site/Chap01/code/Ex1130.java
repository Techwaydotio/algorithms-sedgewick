package Chap01.code;

import java.util.Arrays;

public class Ex1130 {
    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        if (a < b) {
            return gcd(b, a);
        }
        return gcd(b, a % b);
    }
    /*
    Creates an N-by-N boolean array
    a[][] such that a[i][j] is true if i and j are relatively prime (have no common factors), and false otherwise.
     */
    static boolean[][] relPrimeTable(int N) {
        boolean[][] result = new boolean[N][N];
        for (int i = 0; i < N; i +=1 ) {
            for (int j = 0; j < N; j +=1 ) {
                result[i][j] = gcd(i, j) == 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        boolean[][] result = relPrimeTable(10);
        for (boolean[] arr: result) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
