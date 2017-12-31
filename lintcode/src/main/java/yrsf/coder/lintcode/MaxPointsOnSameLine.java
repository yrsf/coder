package yrsf.coder.lintcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * <p>
 * http://www.lintcode.com/en/problem/max-points-on-a-line/
 * <p>
 * Created by yrsf on 12/13/17.
 */
public class MaxPointsOnSameLine {

    /*
     * @param points: an array of point
     * @return: An integer
     */
    public int maxPoints(Point[] points) {
        if (points == null) {
            return 0;
        }

        if (points.length <= 2)
            return points.length;

        int max = 2;

        for (int i = 0; i < points.length; i++) {

            int overlap = 0;

            int counter = 0;

            Map<String, Integer> slopes = new HashMap<>();

            for (int j = i + 1; j < points.length; j++) {


                if (points[j].x == points[i].x && points[j].y == points[i].y) {
                    overlap++;
                    continue;
                }

                String slope = slope(points[j], points[i]);

                if (!slopes.containsKey(slope)) {
                    slopes.put(slope, 0);
                }

                slopes.put(slope, slopes.get(slope) + 1);

                counter = Math.max(counter, slopes.get(slope));
            }

            max = Math.max(max, counter + overlap + 1);
        }

        return max;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    private String slope(Point a, Point b) {

        int dx = a.x - b.x;
        int dy = a.y - b.y;
        int gcd = gcd(dx, dy);

        return dy / gcd + "/" + dx / gcd;
    }

    /*
     * Definition for a point.
     */
    class Point {
        int x;
        int y;
    }
}
