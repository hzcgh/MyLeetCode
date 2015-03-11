import java.util.*;

/**
 * Created by fchen on 2/16/2015.
 * http://www.careercup.com/question?id=5705985515585536
 */

/**
 * Dynamic programming = bottom-up recursive + memory of the previous results
 */

/**
 * Lesson learned: In java array default equals() is only comparing with identity, not the content
 */
public class MaxLengthPalindrome {
    public static int maxLengthPalindrome(int[] values){
        Map<List<Integer>, Integer> map = new HashMap<>();

        for(int length = 1; length <= values.length;length++){
            for(int i=0;i+length-1 < values.length;i++){
                int j= i + length -1;
                if (i==j) // length == 1
                {
                    List<Integer> key = copyOfRangeInclusiveRightBound(values, i, i);
                    if (map.get(key) == null){
                        map.put(key, 1);
                    }
                } else if (values[i] == values[j]){
                    if (j-i == 1) // length == 2
                    {
                        List<Integer> key = copyOfRangeInclusiveRightBound(values, i, j);
                        if (map.get(key) == null){
                            map.put(key, 2);
                        }
                    } else {
                        Integer newValue = map.get(copyOfRangeInclusiveRightBound(values, i + 1, j - 1)) + 2;
                        List<Integer> key = copyOfRangeInclusiveRightBound(values, i, j);
                        if (map.get(key) == null){
                            map.put(key, newValue);
                        }
                    }
                } else{
                    Integer left  = map.get(copyOfRangeInclusiveRightBound(values, i, j - 1));
                    Integer right = map.get(copyOfRangeInclusiveRightBound(values, i + 1, j));
                    List<Integer> key = copyOfRangeInclusiveRightBound(values, i, j);
                    if (map.get(key) == null){
                        map.put(key, Math.max(left,right));
                    }
                }
            }
        }


        return map.get(copyOfRangeInclusiveRightBound(values,0,values.length -1));
    }

    public static List<Integer> copyOfRangeInclusiveRightBound(int[] array, int from, int to){
        int[] tmp = Arrays.copyOfRange(array,from, to+1);
        List<Integer> list = new ArrayList<>();
        for(int i:tmp){
            list.add(i);
        }
        return list;

    }

    public static void main(String[] args){
        System.out.println(maxLengthPalindrome(new int[] {4,1,2,3,4,5,6,5,4,3,4,4,4,4,4,4,4}));


/*        Map<int[], Integer> map = new HashMap<>();
        map.put(new int[]{1,2},100);
        System.out.println(map.get(new int[]{1,2}));
        System.out.println(map.get(new int[]{1,2,3}));*/

/*        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);

        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(2);
        l2.add(3);

/*        System.out.println(l1.equals(l2));*//*

        int[] a1 = new int[]{1,2,3};
        int[] a2  = new int[]{1,2,3};
        System.out.println(a1.equals(a2));*/
    }
}
