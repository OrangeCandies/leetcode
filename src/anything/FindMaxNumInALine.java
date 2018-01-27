package anything;

import java.util.Map;
import java.util.TreeMap;

public class FindMaxNumInALine {


    public static void main(String[] args) {
        Point[] points = new Point[]{new Point(1, 1), new Point(1, 1), new Point(3, 3)};
        Point[] points1 = new Point[]{new Point(-435, -347), new Point(-435, -347), new Point(609, 613), new Point(-348, -267), new Point(-174, -107), new Point(87, 133), new Point(-87, -27), new Point(-609, -507), new Point(435, 453), new Point(-870, -747), new Point(-783, -667), new Point(0, 53), new Point(-174, -107), new Point(783, 773), new Point(-261, -187), new Point(-609, -507), new Point(-261, -187), new Point(-87, -27), new Point(87, 133), new Point(783, 773), new Point(-783, -667), new Point(-609, -507), new Point(-435, -347), new Point(783, 773), new Point(-870, -747), new Point(87, 133), new Point(87, 133), new Point(870, 853), new Point(696, 693), new Point(0, 53), new Point(174, 213), new Point(-783, -667), new Point(-609, -507), new Point(261, 293), new Point(435, 453), new Point(261, 293), new Point(435, 453)};
        System.out.println(new FindMaxNumInALine().maxPoint(points1));
    }

    public int maxPoint(Point[] points) {
        int maxEqualsY = 0;
        int cnt = 0;
        int maxNum = 0;
        int bound = 0;
        int ans = 0;
        if (points == null || points.length == 0) {
            return 0;
        }
        for (int i = 0; i < points.length; i++) {
            cnt = 1;
            bound = 0;
            maxEqualsY = 0;
            maxNum = 0;
            Map<Double, Integer> keys = new TreeMap<>();
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    bound++;
                } else if (points[i].x == points[j].x && points[i].y != points[j].y) {
                    cnt++;

                } else {
                    double k = (points[i].y - points[j].y) * 1.0 / (points[i].x - points[j].x);

                    if (keys.containsKey(k)) {
                        int num = keys.get(k);
                        num++;

                        keys.put(k + 0.0, num);
                        if (num > maxNum) {
                            maxNum = num;
                        }
                    } else {
                        keys.put(k + 0.0, 2);
                        maxNum = maxNum > 2 ? maxNum : 2;
                    }
                }
            }
            if (cnt > maxEqualsY && cnt >= 2) {
                maxEqualsY = cnt;
            }

            maxNum = maxNum > maxEqualsY ? maxNum : maxEqualsY;
            if (maxNum == 0) {
                maxNum = 1;
            }
            if (ans < maxNum + bound) {

                ans = maxNum + bound;

                maxNum = 0;
                bound = 0;
            }
        }

        return ans;
    }
}
