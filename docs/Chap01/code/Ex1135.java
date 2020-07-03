package Chap01.code;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class Ex1135 {

    static double[] diceDistr() {
        int SIDES = 6;
        double[] dist = new double[2 * SIDES + 1];
        for (int i = 1; i <= SIDES; i++)
            for (int j = 1; j <= SIDES; j++)
                dist[i + j] += 1.0;
        for (int k = 2; k <= 2 * SIDES; k++)
            dist[k] /= 36.0;

        return dist;
    }

    public static boolean areAllTrue(boolean[] array) {
        for (boolean b : array) if (!b) return false;
        return true;
    }

    public static boolean allSimilar(double[] distr, double[] freq) {
        boolean[] equal = new boolean[distr.length];
        for (int i = 0; i < distr.length; i += 1) {
            BigDecimal aa = new BigDecimal(distr[i]);
            BigDecimal bb = new BigDecimal(freq[i]);
            aa = aa.setScale(3, RoundingMode.HALF_EVEN);
            bb = bb.setScale(3, RoundingMode.HALF_EVEN);
            equal[i] = aa.equals(bb);
        }

        System.out.println(Arrays.toString(equal));
        return areAllTrue(equal);
    }


    public static void main(String[] args) {
        double[] distr = diceDistr();
        double[] freq = new double[13];
        int trials = 1000;
        while (!allSimilar(distr, freq) && trials < 10e6) {
            System.out.println(trials);
            trials += 1000;
            for (int i = 0; i < trials; i += 1) {
                int randomNum1 = ThreadLocalRandom.current().nextInt(1, 7);
                int randomNum2 = ThreadLocalRandom.current().nextInt(1, 7);
                freq[randomNum1 + randomNum2] += 1;
            }
            for (int i = 0; i < freq.length; i += 1) {
                freq[i] /= trials;
            }
        }
        System.out.println(trials);
    }
}
