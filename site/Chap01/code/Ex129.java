package Chap01.code;

public class Ex129 {
    static class Counter implements Comparable<Counter> {
        private final String name;     // counter name
        private int count = 0;         // current value

        public Counter(String id) {
            name = id;
        }

        public void increment() {
            count++;
        }

        public int tally() {
            return count;
        }

        public String toString() {
            return count + " " + name;
        }

        @Override
        public int compareTo(Counter that) {
            if (this.count < that.count) return -1;
            else if (this.count > that.count) return +1;
            else return 0;
        }
    }

    public static int rank(int key, int[] a, Counter c) {
        return rank(key, a, 0, a.length - 1, c);
    }

    public static int rank(int key, int[] a, int lo, int hi, Counter c) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) {
            c.increment();
            return rank(key, a, lo, mid - 1, c);
        } else if (key > a[mid]) {
            c.increment();
            return rank(key, a, mid + 1, hi, c);
        } else return mid;
    }

    public static void main(String[] args) {
        Counter c = new Counter("BinarySearch");

        int[] arr = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
        rank(9, arr, 0, arr.length, c);
        System.out.printf("Total key comparisons: %d", c.tally());

    }
}
