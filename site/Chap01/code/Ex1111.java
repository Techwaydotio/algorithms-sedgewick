package Chap01.code;

public class Ex1111 {
    /*
    Write a code fragment that prints the contents of a two-dimensional boolean
array, using * to represent true and a space to represent false. Include row and column
numbers.
     */

    static void printContents(boolean[][] arr) {
        for (int i = 0; i < arr.length; i += 1) {
            for (int j = 0; j < arr[i].length; j += 1) {
                if (arr[i][j]) {
                    System.out.printf("row: %d, column: %d = *\n", i, j);
                } else {
                    System.out.printf("row: %d, column: %d = \n", i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        boolean[][] arr = {{true, false}, {false, true}, {true, true}};
        printContents(arr);
        int[] a = new int[10];
        for (int i = 0; i < 10; i++)
            a[i] = 9 - i;
        for (int i = 0; i < 10; i++)
            a[i] = a[a[i]];
        for (int i = 0; i < 10; i++)
            System.out.println(i);
    }
}
