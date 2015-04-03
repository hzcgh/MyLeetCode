import com.sun.deploy.util.StringUtils;

import java.util.*;

/**
 * https://oj.leetcode.com/problems/3sum/
 * http://blog.csdn.net/linhuanmars/article/details/19711651
 *
 * O(n^2) solution without using HashMap, and no Set is used to avoid duplicate
 *
 * for each element A, run a two sum algorithm on the the elements which are at the right of A, to find all the pairs can be added up to 0-A's value
 *
 */

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] sum) {
        List<List<Integer>> ret = new ArrayList<>();
        if (sum == null || sum.length < 3)
            return ret;

        Arrays.sort(sum);
        for (int i = 0; i < sum.length - 2; i++) {
            if (i>0 && sum[i] == sum[i-1])
                continue;

            List<List<Integer>> results = twoSum(sum, i+1, sum.length-1, 0-sum[i]);
            ret.addAll(results);
        }
        return ret;
    }

    // Modified version of twoSum
    public List<List<Integer>> twoSum(int[] sum, int start, int end, int target) {
        List<List<Integer>> results = new ArrayList<>();
        while (end > start) {
            if (sum[start] + sum[end] == target) {
                List<Integer> result = new ArrayList<>();
                result.add(0-target);
                result.add(sum[start]);
                result.add(sum[end]);
                results.add(result);

                start++;
                end--;

                while(start<end && sum[start] == sum[start-1])
                    start++;
                while(start<end && sum[end] == sum[end+1])
                    end--;

            } else if (sum[start] + sum[end] > target) {
                end--;
            } else {
                start++;
            }
        }
        return results;

    }

    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        List<List<Integer>> ret = t.threeSum(new int[]{-1, 0, 0, 1, 1, 2, -1, -4});
        for (List<Integer> l : ret) {
            System.out.println(l.get(0) + " " + l.get(1) + " " + l.get(2));
        }
    }
}
