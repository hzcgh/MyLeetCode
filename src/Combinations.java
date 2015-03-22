import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/
 * Similar algorithm as the "Generate Parentheses" problem,
 * Pass the "start" index to avoid duplicate combinations
 *
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k){

        List<List<Integer>> ret = new ArrayList<>();
        create(ret, new ArrayList<>(), 1, k, n);
        return ret;
    }

    public void create(List<List<Integer>> ret, List<Integer> combo, int start, int k, int n){
        if (combo.size() == k)
        {
            ret.add(combo);
            return;
        }

        for(int i=start;i<=n;i++){
            List<Integer> newCombo = new ArrayList<>(combo);
            newCombo.add(i);
            create(ret, newCombo, i+1, k, n);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>>ret = new Combinations().combine(10,7);
        for(List<Integer> combo: ret){
            for(Integer i: combo){
                System.out.print(i+",");
            }
            System.out.println();
        }
    }

}
