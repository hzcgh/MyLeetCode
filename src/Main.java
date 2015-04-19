import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by fchen on 2/15/2015.
 */
public class Main {
    int sqrtCounter = 0;

    public static void main(String[] args){
/*        ReversePolishNotation rpn = new ReversePolishNotation();
        System.out.println(rpn.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(rpn.evalRPN(new String[]{"4", "13", "5", "/", "+"}));*/

/*
        Job[] jobs = new Job[10];
        for (int i = 0; i < jobs.length; i++) {
            jobs[i] = new Job(String.valueOf(i),new Date(System.currentTimeMillis() + (i+1)*5*1000 ));
        }
        ScheduledExecutorServiceTest schedule = new ScheduledExecutorServiceTest();
        schedule.execute(jobs);
        schedule.shutdown(10*1000);
*/

/*        List<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add(2,"3");
        System.out.println(String.join(",", list));*/

/*        int[][] a = new int[2][2];
            a[0][0] = 1;
            a[0][1] = 2;
            a[1][0] = 3;
            a[1][1] = 4;
            for (int i=0;i<a.length;i++){
                    int[] row = a[i];
                    for (int j=0;j<row.length;j++){
                            System.out.println(row[j]);
                    }
            }*/


/*        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((Integer i1, Integer i2) -> Integer.compare(i2,i1));
        queue.add(4);
        queue.add(3);
        queue.add(12);
        queue.add(8);

        System.out.println(queue.poll());*/

/*        Double d1 = 11.43;
        Double d2 = 11.43;
        System.out.println(d1.equals(d2));*/

/*        List<String> ret = findRepeatingSubstring("ABCABCA",2);
        for(String s:ret){
            System.out.println(s);
        }*/
/*
        System.out.println(reverse("This is a test"));
*/

/*        Main m = new Main();
        System.out.println(m.sqrt(5, 0.0000001));
        System.out.println(m.sqrtCounter);
        System.out.println(Math.sqrt(5));
        System.out.println(m.sqrt(2147395599));*/

       // System.out.println(square(99));

        Map<String, Integer> map = new HashMap<>();
        map.put("a",200);
        map.put("b", 100);
        map.put("c",50);
        map.put("d", 300);

        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
      //  Collections.sort(list, (Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) ->  entry1.getValue() - entry2.getValue());

/*        list.stream().sorted(( entry1,  entry2) ->  entry1.getValue() - entry2.getValue())
                .limit(10).forEach(System.out::println);*/

/*        List<Integer> intList = Arrays.asList(1,2,3,4);
        Integer[] intArray = new Integer[]{1,2,3,4};
        List<Integer> intList2 = Arrays.stream(intArray).filter((i)->i%2==0).map((i) -> i * i).collect(Collectors.toList());

        intList2.forEach(System.out::println);*/

/*        Stream<List<String>> stream = Stream.of(
                Arrays.asList("s","abc","aszs","1"),
                Arrays.asList("ss","23"),
                Arrays.asList("453","%^&")
        );

        stream.flatMap((stringList) -> stringList.stream()).filter((s) -> !s.contains("s")).sorted().forEach(System.out::println);*/

        String[] strings = new String[]{"a","a","n","c","b"};
/*        Map<String,Integer> map2 = new HashMap<>();
        Arrays.stream(strings).forEach((s)-> {
            if (map2.containsKey(s))
                map2.put(s,map2.get(s)+1);
            else
                map2.put(s,1);
        });*/

        Map<String,Long> counts =  Arrays.stream(strings).collect(Collectors.groupingBy(o -> o, Collectors.counting()));
       // counts.entrySet().forEach(System.out::println);

        Map<String, Integer> testCount = new HashMap<>();
        Arrays.stream(strings).forEach(s->testCount.merge(s,1,(i,j)->i+j));
       // testCount.entrySet().forEach(System.out::println);

        for(String key:testCount.keySet()){
        }

        Integer value = testCount.computeIfPresent("z", (k, v) -> v - 1);
        System.out.println(value);

        IntStream.range(1,9).reduce(1,(a,b)->a*b);

    }

    public double pow(double x, int m) {
        double temp = x;
        if (m == 0)
            return 1;
        temp = pow(x, m / 2);
        if (m % 2 == 0)
            return temp * temp;
        else {
            if (m > 0)
                return x * temp * temp;
            else
                return (temp * temp) / x;
        }
    }

    public static List<String> findRepeatingSubstring(String seq, int length)
    {
        if (seq == null || seq.equals("") || length <=0 || length >= seq.length())
            return null;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i+length-1< seq.length();i++)
        {
            String substr = seq.substring(i, i+length);
            if (map.containsKey(substr))
            {
                int value = map.get(substr);
                map.put(substr,value+1);
            } else
            {
                map.put(substr,1);
            }
        }

        List<String>list  = new ArrayList<>();
        for(String key:map.keySet())
        {
            if (map.get(key)>1)
                list.add(key);
        }

         Collections.sort(list);
        return list;
    }

    public static String reverse(String s){
        if (s.length() == 1)
            return s;
        return s.charAt(s.length()-1)+reverse(s.substring(0,s.length()-1));
    }

    public double sqrt(double x, double delta)
    {
        return sqrt(x, delta, 0, x);
    }

    public double sqrt(double x, double delta, double start, double end){
        sqrtCounter++;

        double mid = (start+end)/2;
        if ( Math.abs(x-mid*mid)<=delta)
            return mid;
        else
        {
            if (mid*mid> x)
            {
                return sqrt(x, delta, start, mid);
            } else
            {
                return sqrt(x, delta, mid, end);
            }
        }
    }

    public int sqrt(int x) {
        if (x == 1) {
            return 1;
        }
        else {
            return sqrt2(x, 0, x, x);
        }
    }

    public int sqrt2(int x, int start, int end, int prev)
    {
        int mid = start + (end - start)/2;

        if (mid == prev)
            return mid;
        if (mid == x/mid)
            return mid;
        else if (mid > x/mid)
        {
            return sqrt2(x, start, mid, mid);
        } else
        {
            return sqrt2(x, mid, end, mid);
        }
    }

    public static long square(Integer num){
        if (num ==0)
            return 0;
        if (num == 1 || num == -1)
            return 1;
        if (num<0)
            num = 0 - num;

        int remain = 0;
        int k = num;

        while(k>1){
            if (k%2 == 1){
                remain+=num;
                k--;
            }
            k>>=1;
            num+=num;
        }
        num+=remain;
        return num;
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null)
            return -1;

        for(int i=0;i<haystack.length() - needle.length();i++) {
            if (haystack.substring(i, i+needle.length()).equals(needle))
                return i;
        }
        return -1;
    }

    public int atoi(String str){
        if (str == null)
            return 0;
        str = str.trim();
        if (str.length() == 0)
            return 0;

        Long ret = null;
        boolean positive = true;

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);

            if (i==0){
                if (c == '+'){
                    positive = true;
                    continue;
                } else if (c == '-'){
                    positive = false;
                    continue;
                }
            }

            if (c>='0' && c<='9'){
                if (ret == null)
                    ret = new Long(0);
                ret = ret*10 + c - '0';

                if (positive && ret > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                else if (!positive && ret*(-1) < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;

            } else{
                if (ret == null)
                    return 0;
                else
                    break;
            }

        }

        if (!positive)
            ret = -1 *ret;

        return ret.intValue();

    }


}

class Parent{

}

class Child extends Parent{

}
