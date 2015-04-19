import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Peter on 4/11/2015.
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        Map<Character,List<String>> map = mapping();
        for(int i=0;i<digits.length();i++){
            ret = product(ret, map.get(digits.charAt(i)));
        }
        return ret;
    }

    public List<String> product(List<String> l1, List<String> l2){
        if (l1.size() == 0)
            return l2;
        if (l2.size() == 0)
            return l1;
        List<String> result = new ArrayList<>();

        for(String s1:l1){
            result.addAll(l2.stream().map(s2 -> s1 + s2).collect(Collectors.toList()));
        }
        return result;
    }

    public Map<Character,List<String>> mapping()
    {
        Map<Character, List<String>> map = new HashMap<>();
        for(char c = '2', letter = 'a';c<='9';c++){
            List<String> list = new ArrayList<>();
            list.add(String.valueOf(letter++));
            list.add(String.valueOf(letter++));
            list.add(String.valueOf(letter++));
            if (c == '7' || c == '9')
                list.add(String.valueOf(letter++));

            map.put(c, list);
        }

        return map;
    }

    public static void main(String[] args) {
        List<String>ret = new LetterCombinationsOfAPhoneNumber().letterCombinations("23");
        ret.forEach(System.out::println);
    }
}
