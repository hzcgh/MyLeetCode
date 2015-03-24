import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/insert-interval/
 */
public class InsertInterval {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> newIntervals = new ArrayList<>();
        boolean merged = false;

        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                // no overlap
                newIntervals.add(interval);
            } else if (newInterval.end < interval.start) {
                if (!merged) {
                    newIntervals.add(newInterval);
                    merged = true;
                }
                newIntervals.add(interval);
            } else {
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }

        if (!merged) {
            newIntervals.add(newInterval);
        }

        return newIntervals;

    }
}
