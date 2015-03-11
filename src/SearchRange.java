/**
 * Created by fchen on 2/21/2015.
 * The solution below is incorrect/inefficient. See http://fihopzz.blogspot.com/2013/07/enter-post-title-here-binary-search-and.html
 *
 */
public class SearchRange {
    public int[] searchRange(int[] A, int target) {
        int index = binaryRangeSearch(A, target, 0, A.length-1);
        if (index == -1)
            return new int[]{-1,-1};

        int start=index;
        int end = index;
        for(;end<A.length;end++)
        {
            if (A[end]!=target)
                break;
        }
        for(;start>=0;start--)
        {
            if(A[start]!=target)
                break;
        }
        return new int[]{start+1, end-1 };
    }

    public int binaryRangeSearch(int[] A, int target, int start, int end)
    {
        if (start>end)
            return -1;
        if (A[start] == A[end])
        {
            if (A[start] == target)
                return start;
            else
                return -1;
        }



        int mid = (start+end)/2;
        if (A[mid] > target)
        {
            return binaryRangeSearch(A, target, start, mid-1);
        } else if (A[mid] < target)
        {
            return binaryRangeSearch(A, target, mid + 1, end);
        }
        else{
            return mid;
        }

    }

/*    public int binarySearchLeftBoundary(int[] A, int target, int start, int end)
    {
        if (start > end)
            return -1;
        int mid  = (start+end)/2;
        if (A[mid] > target ){
            return binarySearchLeftBoundary(A, target, start, mid);
        } else
    }*/

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        int[] ret = (searchRange.searchRange(new int[]{5, 7, 7, 8, 8, 10},8));
        System.out.println(ret[0]+","+ret[1]);
    }
}
