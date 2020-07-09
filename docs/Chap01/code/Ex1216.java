package Chap01.code;

public class Ex1216 {
    // Recursive method to return gcd of a and b
    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // method to return LCM of two numbers
    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    static class Rational {
        int numerator;
        int denominator;

        Rational(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        Rational plus(Rational b) {
            if (denominator == b.denominator) {
                return new Rational(numerator + b.numerator, denominator);
            }
            int lcmNumber = lcm(denominator, b.denominator);
            int timesFirst = lcmNumber / denominator;
            int timesSecond = lcmNumber / b.denominator;
            return new Rational((timesFirst * numerator) + (timesSecond * b.numerator), lcmNumber);
        }

        Rational minus(Rational b) {
            if (denominator == b.denominator) {
                return new Rational(numerator - b.numerator, denominator);
            }
            int lcmNumber = lcm(denominator, b.denominator);
            int timesFirst = lcmNumber / denominator;
            int timesSecond = lcmNumber / b.denominator;
            return new Rational((timesFirst * numerator) - (timesSecond * b.numerator), lcmNumber);
        }

        public boolean equals(Rational that) {
            return denominator == that.denominator && numerator == that.numerator;
        }

        Rational times(Rational b) {
            int newNuminator = numerator * b.numerator;
            int newDenuminator = denominator * b.denominator;

            return new Rational(newNuminator, newDenuminator);
        }

        Rational divides(Rational b) {
            Rational reciprocal = new Rational(b.denominator, b.numerator);

            // Ignore simplification step...
            return times(reciprocal);
        }

        @Override
        public String toString() {
            return "Rational{" +
                    "numerator=" + numerator +
                    ", denominator=" + denominator +
                    '}';
        }
    }

    public static void main(String[] args) {
        Rational first = new Rational(5,6);
        System.out.println(first.plus(new Rational(7, 9)));
    }
}
