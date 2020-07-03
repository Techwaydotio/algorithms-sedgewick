package Chap01.code;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import javax.swing.JFrame;

public class Ex1131 extends Canvas {
    int N;
    double p;

    Ex1131 (int N, double p) {
        this.N = N;
        this.p = p;
    }
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);

        JFrame frame = new JFrame("Random Connections");
        Canvas canvas = new Ex1131(N, p);
        canvas.setSize(400, 400);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        int radius = 100;
        double angle = Math.PI;
        Point2D[] points = new Point2D.Double[N];
        for (int i = 0; i < N; i += 1) {
            angle = angle + Math.PI / N;
            System.out.println(angle);
            double x = radius * Math.cos(angle) + 200;
            double y = radius * Math.sin(angle) + 200;
            g.fillOval((int) x, (int) y, 5, 5);
            points[i] = new Point2D.Double(x, y);
        }

        for (int i = 0; i < N; i += 1) {
            for (int j = i + 1; j < N; j += 1) {
                if (Math.random() < p) {
                    g.drawLine((int) points[i].getX(), (int) points[i].getY(), (int) points[j].getX(), (int) points[j].getY());
                }
            }
        }
    }
}
