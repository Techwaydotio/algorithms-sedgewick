package Chap01.code;

public class Ex131 {
    public static class FixedCapacityStackOfStrings {
        private String[] a; // stack entries
        private int N; // size

        public FixedCapacityStackOfStrings(int cap) {
            a = new String[cap];
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public boolean isFull() {
            return N == a.length;
        }

        public int size() {
            return N;
        }

        public void push(String item) {
            a[N++] = item;
        }

        public String pop() {
            return a[--N];
        }
    }
}
