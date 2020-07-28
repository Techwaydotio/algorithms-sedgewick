package Chap01.code;

public class Ex1312 {
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

        public static FixedCapacityStackOfStrings copy(FixedCapacityStackOfStrings s) {
            FixedCapacityStackOfStrings copy = new FixedCapacityStackOfStrings(s.size());
            int count = 0;
            while(count != s.size() - 1) {
                // grab the top element
                String top = s.pop();
                // Shift all the other elements into the destination stack
                while(count != s.size()) {
                    copy.push(s.pop());
                }
                // push the top element into the source stack
                s.push(top);
                // Shift the previously shifted elements into the source stack again
                while (!copy.isEmpty()) {
                    s.push(copy.pop());
                }
                count += 1;
            }
            // The items in the source stack are in reverse order here. Push them into the destination to get the original stack
            while(!s.isEmpty()) {
                copy.push(s.pop());
            }

            return copy;
        }
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(10);
        s.push("Hello");
        s.push("World");
        s.push("!");

        FixedCapacityStackOfStrings cp = FixedCapacityStackOfStrings.copy(s);
        System.out.println(cp);
    }
}
