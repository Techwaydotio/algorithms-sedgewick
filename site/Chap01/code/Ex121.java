package Chap01.code;

import java.awt.geom.Point2D;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Ex121 {
    int N;

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Point2D.Double[] points = new Point2D.Double[N];
        for (int i = 0; i < N; i += 1) {
            double x = ThreadLocalRandom.current().nextDouble(0, 400);
            double y = ThreadLocalRandom.current().nextDouble(0, 400);
            points[i] = new Point2D.Double(x, y);
        }

        System.out.println(findClosestPairsBruteForce(points));
    }

    static double dist(Point2D p1, Point2D p2) {
        return Math.sqrt((p1.getX() - p2.getY()) * (p1.getX() - p2.getX()) +
                (p1.getY() - p2.getY()) * (p1.getY() - p2.getY())
        );
    }

    static double findClosestPairsBruteForce(Point2D[] points) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < points.length; i += 1)
            for (int j = i + 1; j < points.length; j += 1)
                if (dist(points[i], points[j]) < min)
                    min = dist(points[i], points[j]);
        return min;
    }
}
