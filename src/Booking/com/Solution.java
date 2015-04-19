package Booking.com;

/**
 * Created by Peter on 4/10/2015.
 */

import java.io.*;
import java.util.*;

public class Solution {
/*    public static void main(String args[] ) throws Exception {
    *//* Enter your code here. Read input from STDIN. Print output to STDOUT *//*
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.valueOf(in.readLine());
        int num = Integer.valueOf(in.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<num;i++){
            int key = Integer.valueOf(in.readLine());
            map.merge(key,1,(k,j)->k+j);
        }

        for(Integer key:map.keySet()){
            if (map.containsKey(target-key)){
                if (key!=target-key || map.get(target-key)>1){
                    System.out.println("1");
                    return;
                }
            }
        }

        System.out.println("0");
    }*/


/*    public static void main(String args[] ) throws Exception {
    *//* Enter your code here. Read input from STDIN. Print output to STDOUT *//*
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.valueOf(in.readLine());
        for(int i=0;i<num;i++){
            int sides[] = Arrays.stream(in.readLine().split(" ")).mapToInt(n->Integer.valueOf(n)).toArray();
            if (sides[0] == sides[1] && sides[1] == sides[2]) {
                System.out.println("Equilateral");
            } else if (sides[0] == sides[1] || sides[1] == sides[2] || sides[0] == sides[2]){
                System.out.println("Isosceles");
            } else
            {
                System.out.println("None of these");
            }
        }

    }*/

    /*public static void main(String args[] ) throws Exception {
        *//* Enter your code here. Read input from STDIN. Print output to STDOUT *//*
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        List<String> input= new ArrayList<>();

        String str;
        Map<String,List<String>> map = new HashMap<>();

        while((str=in.readLine())!=null && str.trim().length()>0){
            input.add(str);
        }

        for(String s:input){
            String key = s.chars().filter(Character::isLetter)
                    .sorted()
                    .collect(StringBuilder::new,
                            StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
            if (map.containsKey(key)){
                List<String> list = map.get(key);
                list.add(s);
                map.put(key, list);

            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }
        }

        List<List<String>> results = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            List<String> list = entry.getValue();
            Collections.sort(list);
            results.add(list);
        }

        Collections.sort(results, (o1, o2) -> o1.get(0).compareTo(o2.get(0)));

        for(List<String> list:results){
            System.out.println(String.join(",",list));
        }
    }*/

    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int numbers[] = Arrays.stream(in.readLine().split(" ")).mapToInt(n -> Integer.valueOf(n)).toArray();
        int prev = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (i == 0) {
                System.out.print(prev);
            } else {
                System.out.print(" ");
                int diff = numbers[i] - prev;
                prev = numbers[i];
                if (diff < -127 || diff > 127)
                    System.out.print("-128 ");
                System.out.print(diff);
            }
        }
    }
}