package Chap01.code;

import java.util.Scanner;

public class Ex1121 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] words = line.split(" ");
            String name = words[0];
            double first = Double.parseDouble(words[1]);
            double second = Double.parseDouble(words[2]);
            System.out.printf("Name: %s, Div: %.3f\n", name, first / second);
        }
    }
}
