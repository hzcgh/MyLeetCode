/**
 * https://leetcode.com/problems/integer-to-roman/
 */
public class IntegerToRoman {
    // 10:20
    public String intToRoman(int num) {
        String[] symbols = new String[]{"I","V","X","L","C","D","M"};
        StringBuilder builder = new StringBuilder();

        for(int i=1000;i>0;num%=i, i/=10){
            builder.append(buildString(num, i, symbols));
        }

        return builder.toString();
    }

    private StringBuilder buildString(int num, int divisor, String[] symbols){
        int index = 0;

        switch(divisor){
            case 1:
                index = 0;
                break;
            case 10:
                index = 2;
                break;
            case 100:
                index = 4;
                break;
            case 1000:
                index = 6;
                break;
        }

        int digit = num/divisor;
        StringBuilder ret = new StringBuilder();

        switch(digit){
            case 3:
                ret.append(symbols[index]);
            case 2:
                ret.append(symbols[index]);
            case 1:
                ret.append(symbols[index]);
                break;
            case 4:
                ret.append(symbols[index]).append(symbols[index+1]);
                break;

            case 8:
                ret.append(symbols[index]);
            case 7:
                ret.append(symbols[index]);
            case 6:
                ret.append(symbols[index]);
            case 5:
                ret.append(symbols[index+1]);
                ret.reverse();
                break;

            case 9:
                ret.append(symbols[index]).append(symbols[index+2]);
                break;
        }
        return ret;

    }
}
