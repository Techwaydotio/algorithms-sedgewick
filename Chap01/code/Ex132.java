package Chap01.code;

import java.util.Scanner;

public class Ex132 {
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

    public static void main(String[] args) {
        FixedCapacityStackOfStrings s;
        s = new FixedCapacityStackOfStrings(100);
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] items = line.split("\\s");
            for (String item : items) {
                if (!item.equals("-"))
                    s.push(item);
                else if (!s.isEmpty()) System.out.print(s.pop() + " ");
            }
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
        System.out.println("(" + s.size() + " left on stack)");
    }
}
