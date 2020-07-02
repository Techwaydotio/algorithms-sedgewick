package Chap01.code;

public class Ex1127 {
    static int nChoseR(int n, int r) {
        // Since nCr is same as nC(n-r)
        // To decrease number of iterations
        if (r > n / 2)
            r = n - r;

        int answer = 1;
        for (int i = 1; i <= r; i++) {
            answer *= (n - r + i);
            answer /= i;
        }

        return answer;
    }

    static float binomialProbability(int n, int k, float p) {
        return nChoseR(n, k) * (float) Math.pow(p, k) *
                (float) Math.pow(1 - p, n - k);
    }
}
