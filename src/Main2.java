import utils.ListNode;
import utils.TreeNode;
import utils.Util;

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

/*        List<Integer> stack = new ArrayList<>();
        stack.add(1);
        stack.add(null);
        stack.add(null);
        stack.add(2);

        stack.stream().forEach(System.out::println);

        Set<String> set = new HashSet<>();
        for(String s:set){

        }*/
/*        TreeNode t = null;
        changeVal(t);
        System.out.println(t.val);*/

/*        int i;
        int j=0;
        boolean skip = false;
        for(i=0;i<5 && !skip;i++){
            for(j=0;j<5;j++){
                if (j==3) {
                    skip = true;
                    break;
                }
            }
        }
        System.out.println(i+","+j);*/

/*        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(3);
        queue.add(2);

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }

        boolean[] tmp = new boolean[2];
        System.out.println(tmp[1]);*/

/*        ListNode root = new ListNode(0);
        List<ListNode> list = new ArrayList<>();
        list.add(root);

        List<ListNode> list2 = new ArrayList<>(list);
        //root.val  = 1;

        list.get(0).val = 1;

        System.out.println(list2.get(0).val);*/

/*
     String test =    "dirty room".chars().filter(Character::isLetter).sorted().collect(StringBuilder::new,
             StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();


        String.valueOf('c');
        System.out.println(test);*/

/*        Map<Character, List<String>> map = new HashMap<>();
        for(char c = '2', letter = 'a';c<='9';c++){
            List<String> list = new ArrayList<>();
            list.add(String.valueOf(letter++));
            list.add(String.valueOf(letter++));
            list.add(String.valueOf(letter++));
            if (c == '7' || c == '9')
                list.add(String.valueOf(letter++));

            map.put(c, list);
        }

        map.get('9').forEach(System.out::print);*/

/*        boolean[][] tmp = new boolean[1][1];
        System.out.println(tmp[0][0]);*/
/*
        ListNode head = Util.createListFromArray(new Integer[]{1,2,3,4});
        head = reverseLinkedListRecursive(head);
        Util.printList(head);*/

        System.out.println(reverseString("12345688888x"));

    }

    public static String reverseString(String str){
        int start = 0;
        StringBuilder builder = new StringBuilder();

        while(start<str.length()){
            while(start<str.length() && !Character.isLetter(str.charAt(start))){
                builder.append(str.charAt(start));
                start++;
            }
            if (start<str.length()){
                int end = start;
                while(end+1<str.length() && Character.isLetter(str.charAt(end+1)))
                    end++;
                builder.append(reverseWord(str.substring(start, end+1)));
                start = end+1;
            }
        }
        return builder.toString();
    }

    private static String reverseWord(String word){
        StringBuilder sb = new StringBuilder(word);
        return sb.reverse().toString();
    }


    public static ListNode reverseLinkedListRecursive(ListNode head){
        if (head == null || head.next == null)
            return  head;
        ListNode newHead = reverseLinkedListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;

    }

    public static void changeVal(TreeNode t) {

        t = new TreeNode(3);
    }

    public static int getNthPrime(int n) {
        switch (n) {
            case 1:
                return 2;
            case 2:
                return 3;
        }

        List<Integer> primes = new ArrayList<Integer>() {{
            add(2);
            add(3);
        }};
        int number = 5;

        for (n -= 2; n > 0; number += 2) {
            int tmp = number;
            boolean isPrime = primes.stream().allMatch(i -> tmp % i != 0);
            if (isPrime) {
                primes.add(number);
                n--;
            }
        }
        return primes.get(primes.size() - 1);
    }

    public static void calcPrime(int inp) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(2);
        arr.add(3);

        int counter = 4;

        while(arr.size() < inp) {
            if(counter % 2 != 0 && counter%3 != 0) {
                int temp = 4;
                while(temp*temp <= counter) {
                    if(counter % temp == 0)
                        break;
                    temp ++;
                }
                if(temp*temp > counter) {
                    arr.add(counter);
                }
            }
            counter++;
        }

        System.out.println("finish" +arr.get(inp-1));
    }


}

