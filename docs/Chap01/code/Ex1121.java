package Chap01.code;

import java.util.Scanner;

public class Ex1121 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            // Read each line
            String line = input.nextLine();
            // Split into words
            String[] words = line.split(" ");
            // First item is the name
            String name = words[0];
            // Parse first and second name
            double first = Double.parseDouble(words[1]);
            double second = Double.parseDouble(words[2]);
            System.out.printf("Name: %s, Div: %.3f\n", name, first / second);
        }
        input.close();
    }
}
