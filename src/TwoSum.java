import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/two-sum/
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            map.put(numbers[i],i);
        }

        int index1;
        for(index1=0;index1<numbers.length;index1++){
            if (map.containsKey(target - numbers[index1])){
                if (index1 != map.get(target - numbers[index1]))    // Make sure the index is not itself
                    break;
            }
        }
        int index2 = map.get(target - numbers[index1]);

        index2++;
        index1++;
        return index1<index2? new int[]{index1,index2}:
                            new int[]{index2,index1};
    }

    public int[] twoSumWithPointers(int[] numbers, int target){
        int start = 0;
        int end = numbers.length -1;

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            map.put(numbers[i],i);
        }

        Arrays.sort(numbers);
        while(end > start){
            if (numbers[start]+numbers[end] == target)
                break;
            else if (numbers[start]+numbers[end]> target)
                end--;
            else
                start++;
        }

        int index1 = map.get(numbers[start])+1;
        int index2 = map.get(numbers[end])+1;
        return index1<index2? new int[]{index1,index2}:
                new int[]{index2,index1};
    }

    public static void main(String[] args) {
        TwoSum t = new TwoSum();
        int[] ret = t.twoSum(new int[]{2, 7, 11, 15},9);
        System.out.println(ret[0]);
        System.out.println(ret[1]);
    }
}
