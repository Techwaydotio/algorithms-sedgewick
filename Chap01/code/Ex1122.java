package Chap01.code;

public class Ex1122 {
    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1, 0);
    }

    public static String padLeft(String inputString, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(' ');
        }

        return sb.toString() + inputString;
    }

    public static int rank(int key, int[] a, int lo, int hi, int depth) {
        String out = padLeft(String.format("lo: %d, hi: %d\n", lo, hi), depth);
        System.out.print(out);
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return rank(key, a, lo, mid - 1, depth + 1);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi, depth + 1);
        else return mid;
    }

    public static void main(String[] args) {
        rank(15, new int[]{1,2,3,4,5,6,7,8,9,11,12,13,14,15,16});
    }
}
