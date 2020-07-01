package Chap01.code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex1123 {
    public static int rank(int key, int[] a) { // Array must be sorted.
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) { // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    static int[] readInts(String file) {
        Scanner scanner;
        try {
            scanner = new Scanner(new File(file));
        } catch (FileNotFoundException e) {
            return new int[]{};
        }
        List<Integer> integers = new ArrayList<>();
        int i = 0;
        while(scanner.hasNextInt()) {
            integers.add(scanner.nextInt());
        }

        return convertIntegers(integers);
    }

    public static int[] convertIntegers(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] whitelist = readInts(args[0]);
        boolean printNotFromWhitelist = true;
        if (args[1].equals("+")) {
            printNotFromWhitelist = true;
        }
        if (args[1].equals("-")) {
            printNotFromWhitelist = false;
        }
        Scanner scanner = new Scanner(System.in);
        Arrays.sort(whitelist);
        while (scanner.hasNext()) { // Read key, print if not in whitelist.
            int key = scanner.nextInt();
            boolean notFound = rank(key, whitelist) < 0;
            // Print numbers from standard input that are not in the whitelist
            if (notFound && printNotFromWhitelist) {
                System.out.println(key);
            }

            // Print numbers from standard input that are in the whitelist
            if (!notFound && !printNotFromWhitelist) {
                System.out.println(key);
            }
        }
    }
}
