import com.sun.deploy.util.StringUtils;

import java.util.*;

/**
 *  https://oj.leetcode.com/problems/3sum/
 *
 *  FIXME Not correct!
 */

/* Solution Copy from LeetCode forum
The idea is to sort an input array and then run through all indices of a possible first element of a triplet.
For each possible first element we make a standard bi-directional 2Sum sweep of the remaining part of the array.
Also we want to skip equal elements to avoid duplicates in the answer without making a set or smth like that.

public List<List<Integer>> threeSum(int[] num) {
    Arrays.sort(num);
    List<List<Integer>> res = new LinkedList<>();
    for (int i = 0; i < num.length-2; i++) {
        if (i == 0 || (i > 0 && num[i] != num[i-1])) {
            int lo = i+1, hi = num.length-1, sum = 0 - num[i];
            while (lo < hi) {
                if (num[lo] + num[hi] == sum) {
                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
                    while (lo < hi && num[lo] == num[lo+1]) lo++;
                    while (lo < hi && num[hi] == num[hi-1]) hi--;
                    lo++; hi--;
                } else if (num[lo] + num[hi] < sum) lo++;
                else hi--;
           }
        }
    }
    return res;
}
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        if (num.length<3)
            return new ArrayList<>();

        Arrays.sort(num);
        Set<List<Integer>> ret = new HashSet<>();
        int p1 = 0;
        int p2= 1;
        int p3 = num.length-1;

        boolean canP2move = true;

        while(p3>p1 && p3>p2 && p2>p1){
            if (num[p1]+num[p2]+num[p3] == 0){
                List<Integer> sorted = sortedList(num[p1],num[p2],num[p3]);
                ret.add(sorted);
                p3--;
            } else if (num[p1]+num[p2]+num[p3]>0){
                p3--;
            } else {
                if (canP2move){
                    if (p3-p2 > 1)
                        p2++;
                    else {
                        canP2move = false;
                        p1++;
                    }
                } else
                {
                    p1++;
                }
            }
        }

        return new ArrayList<>(ret);
    }

    private List<Integer> sortedList(int a, int b, int c){
        List<Integer> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        List<List<Integer>> ret = t.threeSum(new int[]{-1, 0,0,1, 1, 2 ,-1 ,-4});
        for(List<Integer> l:ret){
            System.out.println(l.get(0)+" "+l.get(1)+" "+l.get(2));
        }
    }
}
