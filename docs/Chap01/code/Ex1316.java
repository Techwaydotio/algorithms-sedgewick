package Chap01.code;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Arrays;

record Date(int day, int month, int year) {};

public class Ex1316 {
    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(readDates(args[0])));
    }

    public static Date[] readDates(String filename) throws IOException {
        Path filePath = Paths.get(filename);
        var scanner = new Scanner(filePath);
        var q = new Queue<Date>();
        while (scanner.hasNext()) {
            q.enqueue(readDate(scanner.next()));
        }
        int N = q.size();
        var a = new Date[N];
        for (int i = 0; i < N; i++)
            a[i] = q.dequeue();
        scanner.close();
        return a;
    }
    public static Date readDate(String date) {
       String[] fields = date.split("/");
       var month = Integer.parseInt(fields[0]);
       var day   = Integer.parseInt(fields[1]);
       var year  = Integer.parseInt(fields[2]);
       return new Date(day,month,year); 
    }
}
