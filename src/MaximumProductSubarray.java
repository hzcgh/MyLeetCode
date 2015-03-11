/**
 * http://www.careercup.com/question?id=5655534577385472
 */
public class MaximumProductSubarray {

    // Working solution from leet code
    public int maxProduct(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        int maxherepre = A[0];
        int minherepre = A[0];
        int maxsofar = A[0];
        int maxhere, minhere;

        for (int i = 1; i < A.length; i++) {
            maxhere = Math.max(Math.max(maxherepre * A[i], minherepre * A[i]), A[i]);
            minhere = Math.min(Math.min(maxherepre * A[i], minherepre * A[i]), A[i]);
            maxsofar = Math.max(maxhere, maxsofar);
            maxherepre = maxhere;
            minherepre = minhere;
        }
        return maxsofar;
    }

    public static int findMaximunProductSubset(int[] A)
    {
        int[][] mapping = new int[A.length][A.length];
        int max = Integer.MIN_VALUE;

        for(int length = 0; length < A.length; length++)
        {
            for(int i=0; i+length< A.length; i++)
            {
                int j = i + length;
                int value;
                if (i == j)
                {
                    value  = A[i];
                } else{
                    value = mapping[i][j-1] * A[j];
                }

                mapping[i][j]  = value;
                max = Math.max(max, value);

            }
        }

        return max;

    }


    public static void main(String[] args) {
        System.out.println(new MaximumProductSubarray().maxProduct(new int[]{/*-5, 2, -1, 3, -1, -2, -100*/ 0,-3,4,0,-3}));
    }
}
