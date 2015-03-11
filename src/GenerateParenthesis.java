import java.util.*;

/**
 * https://leetcode.com/problems/generate-parentheses/
 * Solution: Cracking the code interview: P327
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
/*        Map<Integer, Set<String>> map = new HashMap<>();
        map.put(0, new HashSet<String>(){{
            add("");
        }});
        map.put(1, new HashSet<String>(){{
            add("()");
        }});

        for(int i=2;i<=n;i++)
        {
            Set<String> set = new HashSet<>();
            for(int j=0;j<i;j++)
            {
                Set<String> first = map.get(j);
                Set<String> second = map.get(i-1-j);
                for(String s1:first)
                {
                    for(String s2:second)
                    {
                        set.add("("+s1+")"+s2);
                    }
                }
            }
            map.put(i,set);
        }

        return new ArrayList<>( map.get(n));*/

/*        char[] str = new char[n*2];
         ArrayList<String> list = new ArrayList<String>();
         addParen(list, n, n, str, 0);
         return list;*/

        List<String> ret = new ArrayList<>();
        generate(n,n,"",ret);
        return ret;
    }

/*     public void addParen(ArrayList<String> list, int leftRem,
                           int rightRem, char[] str, int count) {
         if (leftRem < 0 || rightRem < leftRem) return; // invalid state

        if (leftRem == 0 && rightRem == 0) { *//* no more parens left *//*
             String s = String.copyValueOf(str);
            list.add(s);
             } else {
             *//* Add left paren, if there are any left parens remaining. *//*
             if (leftRem > 0) {
                 str[count] = '(';
                 addParen(list, leftRem - 1, rightRem, str, count + 1);
                 }

             *//* Add right paren., if expression is valid *//*
             if (rightRem > leftRem) {
                 str[count] = ')';
                 addParen(list, leftRem, rightRem - 1, str, count + 1);
                 }
             }
         }*/

    private void generate(int left, int right, String current, List<String> ret){
        if (left==0 && right==0)
        {
            ret.add(current);
            return;
        }
        if (left >0){
            generate(left-1, right, current+"(", ret);
        }
        if (left<right){
            generate(left, right-1, current+")",ret);
        }
    }

    public static void main(String[] args) {
       // long p = System.currentTimeMillis();
        new GenerateParenthesis().generateParenthesis(3).forEach(System.out::println);
      //  System.out.println((System.currentTimeMillis()-p));
    }
}

