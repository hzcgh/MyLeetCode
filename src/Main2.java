import utils.ListNode;
import utils.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

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

        boolean[][] tmp = new boolean[1][1];
        System.out.println(tmp[0][0]);
    }

    public static void changeVal(TreeNode t){

        t = new TreeNode(3);
    }
}
