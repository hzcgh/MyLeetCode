import java.util.*;

/**
 * Created by Peter on 3/21/2015.
 */
public class Main2 {
    public static void main(String[] args) {
        //Parent parent = new Parent();
/*        Object obj = new Object();
        int a =  (int)obj;
        System.out.println(a);*/

        List<Integer> stack = new ArrayList<>();
        stack.add(1);
        stack.add(null);
        stack.add(null);
        stack.add(2);

        stack.stream().forEach(System.out::println);
    }
}
