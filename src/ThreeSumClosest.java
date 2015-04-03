import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum-closest/
 *
 * It failed at only one test case. Integer overflow?
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);

        Integer delta = Integer.MAX_VALUE;
        Integer closest=0;

        for(int i=0;i<num.length-2;i++){
            List<Integer> result = twoSumClosest(num, i+1, num.length-1, target - num[i]);
            int sum = result.get(0) + result.get(1);
            if (sum+num[i] == target)
                return target;
            else{
                if (Math.abs(sum+num[i] - target) < delta){
                    delta = Math.abs(sum+num[i] - target);
                    closest = sum+num[i];
                }
            }
        }

        return closest;
    }

    public List<Integer> twoSumClosest(int[] num, int start, int end, int target) {
        Integer min = Integer.MAX_VALUE;
        int mStart=start;
        int mEnd = end;
        List<Integer> result = new ArrayList<>();


        while (end > start) {
            if (num[start] + num[end] == target) {
                result.add(num[start]);
                result.add(num[end]);
                return result;

            } else {
                int delta = Math.abs(num[start] + num[end] - target);
                if (delta<min)
                {
                    mStart = start;
                    mEnd = end;
                }

                if (num[start] + num[end] > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        result.add(num[mStart]);
        result.add(num[mEnd]);
        return result;

    }

    public static void main(String[] args) {
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{87,6,-100,-19,10,-8,-58,56,14,-1,-42,-45,-17,10,20,-4,13,-17,0,11,-44,65,74,-48,30,-91,13,-53,76,-69,-19,-69,16,78,-56,27,41,67,-79,-2,30,-13,-60,39,95,64,-12,45,-52,45,-44,73,97,100,-19,-16,-26,58,-61,53,70,1,-83,11,-35,-7,61,30,17,98,29,52,75,-73,-73,-23,-75,91,3,-57,91,50,42,74,-7,62,17,-91,55,94,-21,-36,73,19,-61,-82,73,1,-10,-40,11,54,-81,20,40,-29,96,89,57,10,-16,-34,-56,69,76,49,76,82,80,58,-47,12,17,77,-75,-24,11,-45,60,65,55,-89,49,-19,4}, -275));
    }
}
