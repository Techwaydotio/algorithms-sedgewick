package Chap01.code;

public class Ex1218 {
    static class Accumulator {
        private double m;
        private double s;
        private int N;

        public void addDataValue(double x) {
            N++;
            s = s + 1.0 * (N - 1) / N * (x - m) * (x - m);
            m = m + (x - m) / N;
        }

        public double mean() {
            return m;
        }

        public double var() {
            return s / (N - 1);
        }

        public double stddev() {
            return Math.sqrt(this.var());
        }
    }

    public static void main(String[] args) {
        Accumulator acc = new Accumulator();
        System.out.println(acc.mean()); // 0.0
        System.out.println(acc.var()); // 0.0
        System.out.println(acc.stddev()); // 0.0

        acc.addDataValue(10);

        System.out.println(acc.mean()); // 10.0
        System.out.println(acc.var()); // NaN
        System.out.println(acc.stddev()); // NaN

        acc.addDataValue(15);

        System.out.println(acc.mean()); // 12.5
        System.out.println(acc.var()); // 12.5
        System.out.println(acc.stddev()); // 3.5355339059327378

        acc.addDataValue(20);

        System.out.println(acc.mean()); // 15
        System.out.println(acc.var()); // 15
        System.out.println(acc.stddev()); // 5
    }
}
