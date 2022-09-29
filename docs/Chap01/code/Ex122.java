package Chap01.code;

import java.util.*;

/**
 * Write an Interval1D client that takes an int value N as command-line argument, 
 * reads N intervals (each defined by a pair of double values) from standard input, 
 * and prints all pairs that intersect.
 */
public class Ex122 {
    static record Interval1D(double start, double end) implements Comparable<Interval1D> {
        @Override
        public int compareTo(Interval1D b) {
            return (int)(this.start - b.start);
        }
    };
    int N;

    public static void main(String[] args) {
        int N = 5;
        var intervals = new Interval1D[N];
        var scanner = new Scanner(System.in);
        for (int i = 0; i < N; i += 1) {
            if (scanner.hasNext()) {
                var first = scanner.nextDouble();
                var second = scanner.nextDouble();
                intervals[i]= new Interval1D(first, second);
            }
        }
        scanner.close();
        for (var i:  overlappingIntervals(intervals)) {
            System.out.println(i);
        }
    }

    static Interval1D[] overlappingIntervals(Interval1D[] intervals) {
        Arrays.sort(intervals);
        var overlapping = new ArrayList<Interval1D>();
        for (var i=1;i<intervals.length;i++) {
            if (intervals[i-1].end > intervals[i].start) {
                overlapping.add(intervals[i-1]);
            }
        }
        Interval1D[] arr = new Interval1D[overlapping.size()];
        return overlapping.toArray(arr);
    }
}
