import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/permutation-sequence/
 * The part I got wrong is I didn't pass the list to keep track of the available numbers
 *
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        return getPermutationImpl(n, k, IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList()));
    }

    public String getPermutationImpl(int n, int k, List<Integer> list) {
        if (n == 1) {
            return list.get(0).toString();
        }

        int fact = factorial(n - 1);
        int number = (int) Math.ceil(k * 1.0 / fact);
        int prefix = list.get(number-1);
        list.remove(number-1);
        String result = getPermutationImpl(n - 1, k - fact * (number - 1), list);
        return String.valueOf(prefix) + result;
    }

    private int factorial(int n) {
        return IntStream.rangeClosed(1, n).reduce(1, (a, b) -> a * b);
    }

    public static void main(String[] args) {
        System.out.println(new PermutationSequence().getPermutation(8, 8590));
    }
}

