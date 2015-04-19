import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {
    // 10:00
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>()
        {
            {
                put('I',1);
                put('V',5);
                put('X',10);
                put('L',50);
                put('C',100);
                put('D',500);
                put('M',1000);
            }
        };
        s = s.toUpperCase();

        int result = 0;
        for(int i=0;i<s.length();i++){
            int curr = map.get(s.charAt(i));
            if (i+1<s.length()){
                int next = map.get(s.charAt(i+1));
                if (curr>=next){
                    result+=curr;
                } else{
                    result+=next-curr;
                    i++;
                }

            } else{
                result+=curr;
            }
        }

        return result;
    }
}
