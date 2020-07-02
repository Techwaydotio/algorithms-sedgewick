package Chap01.code;

import java.util.Arrays;
import java.util.stream.Stream;

public class Ex1128 {
    public static void main(String[] args) {
        int[] whitelist = new int[]{1,2,2,3,4,4,4,5,6,8,10};
        int key = 2;
        int index = Arrays.binarySearch(whitelist, key); // finds index of duplicate
        if (index >= 0) {
            int start = index - 1, end = index + 1;
            // Check left of index
            while (start != 0 && whitelist[start] == key) {
                if (whitelist[start] == key) {
                    start -= 1;
                } else {
                    break;
                }
            }
            // Check right of index
            while (end != whitelist.length - 1) {
                if (whitelist[end] == key) {
                    end += 1;
                } else {
                    break;
                }
            }
            int numOfDuplicates = end - start;
            if (numOfDuplicates > 0) {
                // Copy first part
                int[] first = Arrays.copyOfRange(whitelist, 0, start);
                // Copy second part
                int[] second = Arrays.copyOfRange(whitelist, end + 1, whitelist.length - 1);
                // Create result array with no duplicate keys
                int[] result = new int[first.length + second.length + 1];
                System.arraycopy(first, 0, result, 0, first.length);
                // Assign key in position
                result[first.length] = key;
                // Combine the results
                System.arraycopy(second, 0, result, first.length+1, second.length);
                whitelist = result;
            }
        }

        System.out.print(Arrays.toString(whitelist));
    }
}
