import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        return subsets(S,0);
    }

    public List<List<Integer>> subsets(int[] S, int start){
        List<List<Integer>> results = new ArrayList<>();

        if (start>=S.length){
            List<Integer> emptyList = new ArrayList<>();
            results.add(emptyList);
            return results;
        }

        List<List<Integer>> oldResults  = subsets(S, start+1);
        results.addAll(oldResults);

        // Lesson learned: new ArrayList<>(list) is doing shallow copy;
        for(List<Integer> list:oldResults){
            List<Integer> tmp = new ArrayList<>(list);
            tmp.add(0, S[start]);
            results.add(tmp);
        }

        return results;
    }

    public static void main(String[] args) {
        List<List<Integer>> ret = new Subsets().subsets(new int[]{1});
        System.out.println();
    }
}
