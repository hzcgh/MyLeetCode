import java.util.*;

/**
 * Created by fchen on 2/25/2015.
 * https://oj.leetcode.com/problems/permutations-ii/
 *
 * It's essentially a DFS solution
 * Avoid duplicate permutations without using set
 */
public class PermutationII {

    public List<List<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        boolean[] used = new boolean[num.length];
        List<List<Integer>> results = new ArrayList<>();
        permuteUnique(num, new ArrayList<>(), used, results);
        return results;
    }

    public void permuteUnique(int[] num, List<Integer> list, boolean[] used, List<List<Integer>> results){
        if (list.size() == num.length)
        {
            results.add(list);
            return;
        }

        for(int i=0;i<num.length;i++){
            if (!used[i]){
                if (i>0 && num[i] == num[i-1] && !used[i-1])
                    continue;

                List<Integer> newList = new ArrayList(list);
                newList.add(num[i]);
                used[i] = true;
                permuteUnique(num, newList, used, results);
                used[i] = false;
            }
        }
    }

        public static void main(String[] args) {
        List<List<Integer>> results = new PermutationII().permuteUnique(new int[]{1,1,3});
        for (List<Integer> outer:results){
            for (Integer inner:outer){
                System.out.print(inner + " ");
            }
            System.out.println();
        }
    }
}
