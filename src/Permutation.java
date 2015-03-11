import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by fchen on 2/25/2015.
 * https://oj.leetcode.com/problems/permutations-ii/
 */
public class Permutation {
    public static List<List<Integer>> permute(int[] num) {
        if (num== null || num.length == 0)
            return null;

        List<List<Integer>> results = new LinkedList<>();
        List<Integer> first = new LinkedList<>();
        first.add(num[0]);
        results.add(first);

        Set<List<Integer>> set = new HashSet<>();

        for(int i=1;i<num.length;i++){
            List<List<Integer>> newResults = new LinkedList<>();
            int value = num[i];
            for(List<Integer> list: results)
            {
                List<Integer> baseList;
                for(int j=0;j<=list.size();j++)
                {
                    baseList = new LinkedList<>(list);
                    baseList.add(j,value);

                    if (!set.contains(baseList)) {
                        set.add(baseList);
                        newResults.add(baseList);
                    }
                }
            }
            results = newResults;
        }

        return results;

    }

    public static void main(String[] args) {
        List<List<Integer>> results = permute(new int[]{1,1,3});
        for (List<Integer> outer:results){
            for (Integer inner:outer){
                System.out.print(inner + " ");
            }
            System.out.println();
        }
    }
}
