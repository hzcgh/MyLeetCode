import java.util.ArrayList;
import java.util.List;

/**
 * Created by fchen on 2/23/2015.
 */
public class QuickSort {
    public void quickSort(int[] array, int start, int end){
        if (start >= end)
            return;

        int index = partition(array, start, end);
        quickSort(array,start, index -1);
        quickSort(array, index+1, end);
    }

    private int partition(int[] array, int start, int end){

        int index = choosePivot(start,end);
        int pivot = array[index];

        swap(array,index,end);

        int storeIndex = start;

        for(int i=start;i<=end -1; i++){
            if (array[i]<pivot)
            {
                swap(array,i,storeIndex);
                storeIndex++;
            }
        }


        swap(array,storeIndex,end);
        return storeIndex;

    }


    private void swap(int[]array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private int choosePivot(int start, int end){
        return (start+end)/2;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2,15,20,2,5,2,0,-1,18/*2,3,4,1*/};
        new QuickSort().quickSort(array,0, array.length-1);
        for (int i:array){
            System.out.println(i);
        }    }
}
