/**
 * http://www.geeksforgeeks.org/find-the-minimum-distance-between-two-numbers/
 * O(n) time complexity
 */
public class WordDistanceFinder2 {
    public int minDistance(int[] array, int x, int y){
        int min = Integer.MAX_VALUE;
        int prev = -1;
        if (array == null)
            return -1;
        if (x == y)
            return 0;
        for (int i=0;i<array.length;i++){
            if (array[i] == x || array[i] == y){
                if (prev == -1){
                    prev = i;
                } else{
                    if (array[prev] == array[i]) // same element
                    {
                        prev = i;
                    } else if (i-prev<min){
                        min = i-prev;
                    }
                }
            }
        }
        return (min == Integer.MAX_VALUE)? -1: min;
    }

    public static void main(String[] args) {
        WordDistanceFinder2 w = new WordDistanceFinder2();
        System.out.println(w.minDistance( new int []{3, 5, 4, 2, 6, 3, 0, 0, 5, 4, 8, 3}, 3, 6));
    }
}
