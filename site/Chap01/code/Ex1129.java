package Chap01.code;

import java.util.Arrays;

public class Ex1129 {
    /*
    Returns the
    number of elements that are smaller than the key
     */
    static int rank(int key, int[] a) {
        int index = Arrays.binarySearch(a, key);
        int lessThanCount = 0;
        if (index >= 0) {
            int curr = index - 1;
            while (curr >= 0) {
                if (a[curr] != key) {
                    lessThanCount += 1;
                }
                curr -= 1;
            }
        }
        return lessThanCount;
    }

    /*
        Returns the number of elements equal to the key
     */
    static int count(int key, int[] a) {
        int index = Arrays.binarySearch(a, key);
        int count = 0;
        if (index >= 0) {
            count += 1;
            int start = index - 1, end = index + 1;
            // Check left of index
            while (start >= 0) {
                if (a[start] == key) {
                    start -= 1;
                    count += 1;
                } else {
                    break;
                }
            }
            // Check right of index
            while (end < a.length - 1) {
                if (a[end] == key) {
                    end += 1;
                    count += 1;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] whitelist = new int[]{1, 2, 2, 3, 4, 4, 4, 5, 6, 8, 10};
        int key = 2;

        System.out.print(count(key, whitelist));
    }
}
