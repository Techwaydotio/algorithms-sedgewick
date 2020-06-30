package Chap01.code;

public class Ex1113 {
    /*
    Write a code fragment to print the transposition (rows and columns changed)
of a two-dimensional array with M rows and N columns.
     */
    static void printTranspose(int[][] arr) {
        int[][] result = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i += 1) {
            for (int j = 0; j < arr[i].length; j += 1) {
                result[j][i] = arr[i][j];
            }
        }
        for (int i = 0; i < result.length; i += 1) {
            for (int j = 0; j < result[i].length; j += 1) {
                System.out.printf("row: %d, column: %d = %d\n", i, j, result[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3}, {4,5,6}};
        printTranspose(arr);
    }
}
