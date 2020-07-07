package Chap01.code;

public class Ex1210 {
    static class VisualCounter{
        private final String name;     // counter name
        private int count = 0;         // current value
        private int N = 0;         // maximum number of operations
        private int max = 0;         // maximum absolute value for the counter
        private int opCount = 0;         // current operations count

        public VisualCounter(String id, int N, int max) {
            name = id;
            this.N = N;
            this.max = max;
        }

        public void increment() {
            if (opCount < N && count < max) {
                count++;
                opCount += 1;
            }
        }

        public void decrement() {
            opCount += 1;
            count--;
        }

        public int tally() {
            return count;
        }

        public String toString() {
            return count + " " + name;
        }
    }
}
