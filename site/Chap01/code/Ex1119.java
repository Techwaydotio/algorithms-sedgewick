package Chap01.code;

public class Ex1119 {
    public static long F(long N) {
        if(N <= 1) {
            return N;
        }
        long[] memo = new long[(int)(N + 1)];
        memo[0] = 0;
        memo[1] = 1;
        for(int i=2;i<=N;i += 1) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[(int)N];
    }
    public static void main(String[] args) {
        for (int N = 0; N < 100; N++) {
            System.out.println(N + " " + F(N));
        }
    }
}
