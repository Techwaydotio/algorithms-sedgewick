package Chap01.code;

public class Ex126 {
    static boolean isCircular(String a, String b) {
        boolean result = false;
        if (a == null || b == null) {
            return false;
        }
        if (a.length() != b.length()) {
            return false;
        }
        String combined = a + a;
        if (combined.indexOf(b) >= 0) {
            result = true;
        }
        return result;
    }

    public static void main(String[] args) {
        String a = "ACTGACG";
        String b = "TGACGAC";

        System.out.println(isCircular(a, b));
    }
}
