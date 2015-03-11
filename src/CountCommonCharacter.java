import java.util.HashSet;
import java.util.Set;

/**
 * http://www.careercup.com/question?id=6283084039192576
 * Created by fchen on 2/19/2015.
 */
public class CountCommonCharacter {

    int countCommonCharacters(String[] input)
    {
        if (input.length == 0)
            return 0;

        int[] alph = new int[26];

        for(String s:input)
        {
            Set<Character> set = new HashSet<>();
            for(int i=0;i<s.length();i++)
            {
                char c = s.charAt(i);
                if (!set.contains(c)) {
                    alph[c - 'a']++;
                    set.add(c);
                }
            }
        }

        int count = 0;
        for(int c: alph)
        {
            if (c==input.length)
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new CountCommonCharacter().countCommonCharacters(new String[]{"aghkafgklt","dfghako","qwemnaarkf"}));
    }
}
