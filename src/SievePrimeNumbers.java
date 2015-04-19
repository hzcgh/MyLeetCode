import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Peter on 4/10/2015.
 */
public class SievePrimeNumbers {
    public int getNumberOfPrimes(int N){
        List<Integer> numbers = IntStream.rangeClosed(2, N).boxed().collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();

        while(!numbers.isEmpty()){
            Integer prime = numbers.get(0);
            result.add(prime);
            numbers = numbers.stream().filter(i -> i%prime!=0).collect(Collectors.toList());
        }
        return result.size();
    }

    public static void main(String[] args) {
        System.out.println(new SievePrimeNumbers().getNumberOfPrimes(1000000));
    }
}
