package Chap01.code;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex1138 {

    static int[] readInts(String fileName) {
        List<Integer> whiteList = new ArrayList<>();
        File file = new File(fileName);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            while ((text = reader.readLine()) != null) {
                whiteList.add(Integer.parseInt(text.trim()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }

        return whiteList.stream().mapToInt(i -> i).toArray();
    }

    static int bruteForceSearch(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == k)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] whitelist = readInts(args[0]);
        Arrays.sort(whitelist);

        Scanner s = new Scanner(System.in);
        long startTime = System.nanoTime();
        while (s.hasNext()) {
            int key = s.nextInt();
            if (Arrays.binarySearch(whitelist, key) < 0) {
                System.out.println(key);
            }
        }
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }
}
