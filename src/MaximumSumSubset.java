import java.util.Arrays;

/**
 * Created by fchen on 2/21/2015.
 */
public class MaximumSumSubset {

    // Start 2:30 finish 3:25

// 3, -4 , -1, 4 , 9, 2, 4, 7

// -5 2 -1 3 -1 -1 -1

// 2 -6 4

//Find the maximum sum subset in an array with negative integers

    public static int[] findSumSubset(int[] array)
    {
        int maxSum = 0;
        int sum = 0;
        int maxStart= -1;
        int maxEnd = -1;
        int start = -1;
        int end;

        for(int i=0;i<array.length;i++)
        {
            if (sum == 0 && array[i]>0)
            {
                start  = i;
            }

            sum += array[i];

            if (sum > maxSum)
            {
                maxSum = sum;
                end  = i;
                maxStart = start;
                maxEnd  = end;
            }
            if (sum <0){
                sum = 0;
                start  = -1;
            }

        }

        if (maxStart == -1 || maxEnd == -1)
            return null;

        return Arrays.copyOfRange(array, maxStart, maxEnd+1);
    }

    public static void main(String[] args) {
        int[] array = findSumSubset(new int[]{/*-5, 2, -1, 3, -1, -1, -1*//*2, -6, 4*/ 3, -4 , -1, 4 , 9, 2, 4, 7});
        for(int i:array){
            System.out.println(i);
        }
    }
}
