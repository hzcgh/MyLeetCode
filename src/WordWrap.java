import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-18-word-wrap/
 * DP solution.
 * f(n) = min{f(n-1)+ (length - last string)^3, f(n-2)+(length-last two strings)^3, ..., f(n-k)+(length-last k strings)^3}
 *          when sum of last k strings' length <= length
 */
public class WordWrap {
    class Lines{
        public int value;
        public List<String> list;

        public Lines(int value, List<String> list)
        {
            this.value=  value;
            this.list = list;
        }
    }

    public List<String> wordWrap(String[] input, int length)
    {
        List<Lines> results = new ArrayList<>();

        for(int i=0;i<input.length;i++)
        {
            String str = input[i];
            if (i==0)
            {
                Lines line = new Lines((int)Math.pow(length-str.length(),3), Arrays.asList(str));
                results.add(line);

            } else{
                int min = Integer.MAX_VALUE;
                List<String> output = new ArrayList<>();
                String partialStr = str;

                for(int j=i; j>=0;j--)
                {
                    if(j!=i)
                    {
                        partialStr = input[j] + " " + partialStr;
                    }

                    if (length - partialStr.length() <0)
                        break;

                    Lines result;
                    if (j-1>=0)
                        result= results.get(j-1);
                    else
                        result  = new Lines(0,new ArrayList<>());
                    int currentMin = result.value;
                    if (currentMin + Math.pow(length - partialStr.length(), 3) < min)
                    {
                        min = (int)( currentMin + Math.pow(length - partialStr.length(), 3));
                        output = new ArrayList<>(result.list);
                        output.add(partialStr);
                    }
                }

                Lines line = new Lines(min, output);
                results.add(line);
            }
        }

        return results.get(input.length-1).list;
    }

    public static void main(String[] args) {
        WordWrap wordWrap = new WordWrap();
        List<String> output = wordWrap.wordWrap(/*new String[]{"aaa","bb","cc","ddddd"}*/"Geeks for Geeks presents word wrap problem".split(" "),15);
        for(String s:output){
            System.out.println(s);
        }
    }
}
