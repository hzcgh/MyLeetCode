/**
 * https://leetcode.com/problems/sort-colors/
 *
 *  One pass solution, copied from:
 *  https://leetcode.com/discuss/17000/share-my-one-pass-constant-space-10-line-solution
 */
public class SortColors {
    public void sortColors(int[] A) {
        if(A==null || A.length<2) return;
        int low = 0;
        int high = A.length-1;
        for(int i = low; i<=high;) {
            if(A[i]==0) {
                // swap A[i] and A[low] and i,low both ++
                swap(A, i, low);
                i++;low++;
            }else if(A[i]==2) {
                //swap A[i] and A[high] and high--;
                swap(A, i, high);
                high--; /* NOTE: Don't move the i pointer, because the new value after swapping can still be '2' */
            }else {
                i++;
            }
        }
    }

    private void swap(int[] A, int a, int b){
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }

    public static void main(String[] args) {
        int[] A = new int[]{2,1,2};
        new SortColors().sortColors(A);
        for (int i : A) {
            System.out.println(i);
        }
    }
}
