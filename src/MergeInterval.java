import java.util.*;

/**
 * Created by fchen on 2/21/2015.
 */
public class MergeInterval {


    public static class Interval {
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

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null)
            return null;

        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        List<Interval> newList = new LinkedList<>();
        for (Interval interval : intervals) {
            if (newList.size() == 0) {
                newList.add(interval);
            } else {
                Interval prev = newList.get(newList.size() - 1);
                if (prev.end >= interval.start) {
                    if (prev.end < interval.end) {
                        prev.end = interval.end;
                    }
                } else  {
                    newList.add(interval);
                }
            }
        }
        return newList;
    }

    public static void main(String[] args) {
        List<Interval> ret = new MergeInterval().merge(Arrays.asList(new Interval(1,3),new Interval(2,6),new Interval(8,10),new Interval(15,18) ));
        for (Interval i: ret){
            System.out.println(i.start +","+i.end);
        }
    }
}
