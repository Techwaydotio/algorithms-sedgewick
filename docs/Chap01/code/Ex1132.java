package Chap01.code;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Ex1132 extends Canvas {
    ArrayList nums;
    int N;
    double r;
    double l;

    Ex1132(int N, double r, double l, ArrayList nums) {
        this.N = N;
        this.r = r;
        this.l = l;
        this.nums = nums;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double l = Double.parseDouble(args[1]);
        double r = Double.parseDouble(args[2]);
        ArrayList nums = new ArrayList<Integer>();
        for (int i = 3; i < args.length; i += 1) {
            nums.add(Integer.parseInt(args[i]));
        }

        JFrame frame = new JFrame("Histogram");
        Canvas canvas = new Ex1132(N, l, r, nums);
        canvas.setSize(400, 400);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        int x = 30;
        int height = 400;
        int width = 300;
        // Draw a horizontal base line
        g.drawLine(10, height - 45, width - 10, height - 45);
        int[] count = new int[N];
        for (Iterator i = this.nums.iterator(); i.hasNext(); ) {
            int number = (int) i.next();
            int intervalIndex = number / N;
            count[intervalIndex] += 1;
        }

        // Find the maximum count. The maximum count has the highest bar
        int maxCount = 0;
        for (int i = 0; i < count.length; i++) {
            if (maxCount < count[i])
                maxCount = count[i];
        }
        for (int i = 0; i < count.length; i += 1) {
            // Find the bar height
            int barHeight = (int) (((double) count[i] / (double) maxCount) * (height - 55));


            // Display a bar (i.e. rectangle)
            g.drawRect(x, height - 45 - barHeight, 10, barHeight);
            // Move x for displaying the next character
            x += N;

        }
    }
}
