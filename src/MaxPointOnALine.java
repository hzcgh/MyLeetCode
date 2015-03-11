import java.util.*;

/**
 * https://oj.leetcode.com/problems/max-points-on-a-line/
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * Created by fchen on 2/26/2015.
 */
public class MaxPointOnALine {
    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }


    public int maxPoints(Point[] points) {
        if (points == null || points.length ==0)
            return 0;

        if (points.length == 1)
            return 1;

        Map<Line, Set<Point>> lines = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Line line = new Line(points[i], points[j]);
                if (lines.get(line) != null) {
                    Set<Point> set = lines.get(line);
                    set.addAll(line.points);
                    lines.put(line, set);
                } else {
                    Set<Point> set = new HashSet<>();
                    set.addAll(line.points);
                    lines.put(line, set);
                }
            }
        }

        List<Map.Entry<Line, Set<Point>>> list = new ArrayList<>(lines.entrySet());
        Collections.sort(list, (Map.Entry<Line, Set<Point>> entry1, Map.Entry<Line, Set<Point>> entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));
        return list.get(0).getValue().size();
    }

    public class Line {
        Double a = 0.0;
        Double b = 0.0;
        Boolean onlyX = false;

        Set<Point> points = new HashSet<>();

        public Line(Point p1, Point p2) {
            int x1 = p1.x;
            int x2 = p2.x;
            int y1 = p1.y;
            int y2 = p2.y;

            if (x1 == x2) {
                this.onlyX = true;
                a = Double.valueOf(x1);
            } else {
                a = 1.0 * (y1 - y2) / (x1 - x2) + 0.0;
                b = 1.0 * (x1 * y2 - x2 * y1) / (x1 - x2) + 0.0;
            }
            points.add(p1);
            points.add(p2);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Line line = (Line) o;

            if (!a.equals(line.a)) return false;
            if (!b.equals(line.b)) return false;
            if (!onlyX.equals(line.onlyX)) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = a.hashCode();
            result = 31 * result + b.hashCode();
            result = 31 * result + onlyX.hashCode();
            return result;
        }

    }

    public static void main(String[] args) {
        MaxPointOnALine m = new MaxPointOnALine();
        System.out.println(m.maxPoints(new Point[]{new Point(0,0),new Point(-1,-1),new Point(2,2)}));

/*        Set<Point> points = new HashSet<>();
        Point  p1 = new Point(0,0);
        Point p2 = new Point(0,0);

        points.add(p1);
        System.out.println(points.contains(p1));
        System.out.println(points.contains(p2));*/

    }
}
