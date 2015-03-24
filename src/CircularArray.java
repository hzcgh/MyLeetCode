
import java.util.Iterator;

/**
 * Created by Peter on 3/21/2015.
 * Cracking the coding interview (P404)
 * Implement a Circular Array class that supports an array-like data structure which
    can be efficiently rotated. The class should use a generic type, and should support
    iteration via the standard for (Obj o : circuLarArray) notation.
 *
 */
public class CircularArray<T> implements Iterable<T> {
    private T[] array ;
    private int start = -1;

    public CircularArray(T[] array, int start){
        if (array == null || array.length == 0)
            return;

        this.array = array;

        if (start>=0) {
            this.start = start % array.length;
        }
    }


    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {
            int current = start;
            int remain = array.length;

            @Override
            public boolean hasNext() {

                if (array == null || array.length == 0 || start == -1 || remain == 0) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public T next() {
                if (hasNext()) {
                    T ret = array[current%array.length];
                    current++;
                    remain--;
                    return ret;
                }
                return null;
            }
        };

        return iterator;
    }

    public static void main(String[] args) {
        CircularArray<Integer> c = new CircularArray<>(null,0);
        for(Integer i:c){
            System.out.println(i);
        }
    }

}
