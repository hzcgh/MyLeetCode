/**
 * Created by Peter on 4/6/2015.
 */
public class isPalindrome {
    public boolean isPalindrome(String s) {
        if (s==null)
            return false;
        if (s.length()==0)
            return true;

        int start = 0;
        int end = s.length()-1;

        while(start<end){
            char c1 = s.charAt(start);
            char c2 = s.charAt(end);

            while (!isAlphanumeric(c1) && start < end){
                start++;
                c1 = s.charAt(start);
            }
            while(!isAlphanumeric(c2) && start<end){
                end--;
                c2 = s.charAt(end);
            }
            if (start == end)
                break;


            if (Character.isDigit(c1) && Character.isDigit(c2)){
                if (c1 != c2)
                    return false;
            } else if (Character.isDigit(c1) || Character.isDigit(c2)){
                return false;
            } else if (!String.valueOf(c1).equalsIgnoreCase(String.valueOf(c2))){
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    private boolean isAlphanumeric(char c){
        return Character.isDigit(c) || Character.isLetter(c);
    }

    public static void main(String[] args) {
        System.out.println(new isPalindrome().isPalindrome("a.b,."));
    }
}
