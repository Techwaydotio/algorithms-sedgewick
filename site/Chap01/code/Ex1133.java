package Chap01.code;

import java.util.Arrays;

public class Ex1133 {

    public static int[][] mult(int[][] firstMatrix, int[][] secondMatrix) {
        int r1 = firstMatrix.length; // row1
        int r2 = firstMatrix[0].length; // col1
        int q1 = secondMatrix.length; // row2
        int q2 = secondMatrix[0].length; // col2
        int[][] product = new int[r1][q2];
        if (r1 != q2) {
            return product;
        }
        for(int i = 0; i < r1; i++) {
            for (int j = 0; j < q2; j++) {
                for (int k = 0; k < c1; k++) {
                    product[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }
        return product;
    }

    static double dot(double[] x, double[] y) {
        double result = 0;
        for (int k = 0; k < x.length; k++) {
            result += x[k] * y[k];
        }
        return result;
    }

    static int[][] transpose(int[][] arr) {
        int[][] result = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i += 1) {
            for (int j = 0; j < arr[i].length; j += 1) {
                result[j][i] = arr[i][j];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(dot(new double[]{1.0,2.0,3.0}, new double[]{7.0,9.0,11.0}));
    }
}
