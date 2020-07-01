package Chap01.code;

import java.util.Arrays;

public class Ex1115 {
    /*
    Write a static method histogram() that takes an array a[] of int values and
an integer M as arguments and returns an array of length M whose ith entry is the number of times the integer i appeared in the argument array. If the values in a[] are all
between 0 and M–1, the sum of the values in the returned array should be equal to
a.length.
     */

    static int[] histogram(int[] arr, int M) {
        int[] result = new int[M];
        for (int i: arr) {
            if (i < M) {
                result[i] += 1;
            }
        }
        return result;
    }

    public static int mystery(int a, int b)
    {
        if (b == 0) return 1;
        if (b % 2 == 0) return mystery(a*a, b/2);
        return mystery(a*a, b/2) * a;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(histogram(new int[]{1, 2, 3, 4, 5, 5, 2, 1}, 10)));
        System.out.println(mystery(2, 6));
    }
}
