/**
 * Created by Peter on 4/6/2015.
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        if (s == null)
            return false;
        s = s.trim();
        if (s.length() == 0)
            return false;

        boolean decimalPoint = false;
        boolean exp = false;

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (c>='0' && c<='9')
                continue;

            switch(c){
                case '+':
                case '-':
                    if (i!=0)
                        return false;
                    else break;
                case '.':
                    if (s.length() == 1 || decimalPoint )
                        return false;
                    else{
                        if (i+1<s.length() && s.charAt(i+1) == 'e')
                            return false;
                        decimalPoint = true;
                        break;
                    }
                case 'e':
                    if (i == 0 || i == s.length()-1 || exp)
                        return false;
                    else{
                        if (i+1<s.length() && s.charAt(i+1) == '.')
                            return false;
                        exp = true;
                        break;
                    }
                default:
                    return false;
            }
        }

        return true;
    }
}
