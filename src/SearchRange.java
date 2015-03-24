/**
 * Created by fchen on 2/21/2015.
 * See the explanation here:
 * https://leetcode.com/discuss/18242/clean-iterative-solution-binary-searches-with-explanation
 *
 */
public class SearchRange {

    public int[] searchRange(int[] A, int target) {
        if (A == null || A.length == 0)
            return new int[]{-1,-1};

        int left = searchLeftRange(A, target);
        if (left == -1)
            return new int[]{-1, -1};

        int right = searchRightRange(A, target);

        return new int[]{left, right};
    }

    public int searchLeftRange(int[] A, int target){
        int start = 0;
        int end = A.length - 1;

        while(end > start){
            int mid = start + (end-start)/2;
            if (A[mid] < target){
                start = mid +1 ;
            } else {
                end = mid;
            }
        }

        return A[end] == target? end: -1;
    }

    public int searchRightRange(int[] A, int target){
        int start = 0;
        int end = A.length -1;

        while(end > start){
            int mid =  start + (end - start)/2 + 1;  // Make mid biased to the right, so that this won't make the search range stuck
            if (A[mid] > target){
                end = mid - 1;
            } else {
                start = mid;
            }
        }

        return A[start] == target? start: -1;
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        int[] ret = (searchRange.searchRange(new int[]{5, 7, 7, 8, 8, 10/*2,2*/},8));
        System.out.println(ret[0]+","+ret[1]);
    }
}
