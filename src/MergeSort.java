import java.util.Arrays;

/**
 * MergeSort: Worst case time complexity O(n log n); Worst case space complexity O(n) auxiliary
 */
public class MergeSort {
    private int[] helper;

    public int[] sort(int[] array){
        this.helper = new int[array.length];
        mergeSort(array, 0, array.length - 1);
        return array;
    }

    private void mergeSort(int[] array, int start, int end){
        if (start == end)
            return;
        int mid = (start+end)/2;
        mergeSort(array, start, mid);
        mergeSort(array, mid+1, end);
        merge(array, start, mid,end);
        return;
    }

    private void merge(int[] array, int start, int mid, int end){
        int i= start;
        int j= mid+1;
        int k = start;

        for(int c=start;c<=end;c++){
            helper[c] = array[c];
        }

        while(i<=mid && j<=end){
            if (helper[i]<=helper[j]){
                array[k] = helper[i];
                k++;
                i++;
            } else{
                array[k] = helper[j];
                k++;
                j++;
            }
        }

        for (;i<=mid;i++,k++){
            array[k] = helper[i];
        }
        for(;j<=end;j++,k++){
            array[k] = helper[j];
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{2,15,20,2,5,2,0,-1,18/*2,3,4,1*/};
        int[] output = new MergeSort().sort(input);
        for (int i:output){
            System.out.println(i);
        }
    }
}
