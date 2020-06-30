package Chap01.code;

public class Ex115 {
    /*
    Write a code fragment that prints true if the double variables x and y are both
strictly between 0 and 1 and false otherwise.
     */
    static boolean areBetween0and1(double x, double y) {
        return isBetween0and1(x) && isBetween0and1(y);
    }

    static boolean isBetween0and1(double x) {
        if (x > 0 && x < 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(areBetween0and1(1, 2));
        System.out.println(areBetween0and1(0.1, .9));

        int sum = 0;
        for (int i = 1; i < 1000; i *= 2)
            for (int j = 0; j < i; j++)
                sum++;
        System.out.println(sum);
    }
}
