package Chap01.code;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;

/**
 * Random matches. Write a BinarySearch client that takes an int value T as command-line argument and runs T trials of the following experiment for N = 103, 104, 105, and 106: generate two arrays of N randomly generated positive six-digit int values, and find the number of values that appear in both arrays. Print a table giving the average value of this quantity over the T trials for each value of N.
 */
public class Ex1139 {
    public static void main(String[] args) {
        // Value of T
        int T = 4;
        int[][] commonsCount = new int[T][];
        // Run T times the following experiment
        for (int i = 0; i < T; i++) {
            commonsCount[i] = runExperiment();   
        }
        var averages = getAverages(commonsCount);
        // Print a table giving the average value of this quantity over the T trials for each value of N
        System.out.println("Average for each value of N");
        System.out.println("===========================");
        System.out.println("N       | 1000 | 10000 | 100000 | 1000000");
        System.out.println("------------------------------------");
        System.out.println("Average | " + averages[0] + " | " + averages[1] + " | " + averages[2] + " | " + averages[3]);
    }

    static double[] getAverages(int[][] a){
        var result = new double[4];
        var transposed = transpose(a);
        for (var i = 0; i < transposed.length; i++) {
            result[i] = average(transposed[i]);
        }
        return result;
    }

    static double average(int[]a) {
        var sum = 0;
        for (var item: a) {
            sum+=item;
        }
        return sum/a.length;
    }

    static int[][] transpose(int[][] arr) {
        int[][] result = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i += 1) {
            for (int j = 0; j < arr[i].length; j += 1) {
                result[j][i] = arr[i][j];
            }
        }
        return result;
    }

    static int[] runExperiment() {
        // Number of trials of the following experiment
        var trials = new int[]{1000, 10000, 100000, 1000000};
        var commonsCount = new int[]{0,0,0,0};
        for (var i=0;i<trials.length; i++) {
            // Generate two arrays of N randomly generated positive six-digit int values
            var a = generateRandomInts(trials[i]);
            var b = generateRandomInts(trials[i]);
            // Find the common elements using binary search
            commonsCount[i] = commonElements(a, b);
        }
        return commonsCount;
    }

    static int commonElements(int[] a, int[] b) {
        var commonsCount = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        for (var item: a) {
            if (Arrays.binarySearch(b, item) >= 0) {
                commonsCount++;
            }
        }
        return commonsCount;
    }

    static int[] generateRandomInts(int size) {
        var result = new int[size];
        for (int i = 0; i < size; i += 1) {
            int randomNum = ThreadLocalRandom.current().nextInt(1, 999999);
            result[i] = randomNum;
        }
        return result;
    }
}
