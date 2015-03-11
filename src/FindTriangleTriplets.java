import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * http://www.careercup.com/question?id=5863307617501184
 */
public class FindTriangleTriplets {

    public List<Integer[]> findTriplets(Integer[] array){
        if (array.length < 3)
            return null;

        Arrays.sort(array);
        List<Integer[]> results = new ArrayList<>();

        for (int i = 0; i < array.length - 2 ; i++) {
            Integer first = array[i];

            for(int j=i+1;j<array.length - 1;j++){
                Integer second = array[j];

                // Using modified binary search to search for the index which is first element equal or larger than (first+second),
                // O(log n) time complexity
                for(int k = j+1; k<array.length;k++){
                    Integer third = array[k];
                    if (first+second>third){
                        results.add(new Integer[]{first,second,third});
                    }
                }
            }

        }

        return results;

    }

    public static void main(String[] args){
        FindTriangleTriplets f = new FindTriangleTriplets();
        List<Integer[]> results = f.findTriplets(new Integer[]{9,8,10,7});
        for(Integer[] triplets:results){
            System.out.println(triplets[0]+","+triplets[1]+","+triplets[2]);
        }
    }
}
