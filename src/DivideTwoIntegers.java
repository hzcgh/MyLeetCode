/**
 * https://leetcode.com/problems/divide-two-integers/
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor){
        long dividendL = dividend;
        long divisorL = divisor;

        if (dividendL == 0)
            return 0;

        boolean negative = false;

        if (dividendL<0)
        {
            negative=!negative;
            dividendL =  Math.abs(dividendL);
        }
        if (divisorL<0){
            negative = !negative;
            divisorL = Math.abs(divisorL);
        }

        if (dividendL<divisorL)
            return 0;

        long result=1;
        long divisorLong = divisorL+divisorL;
        long divisorLongOld = divisorL;
        while(dividendL>=divisorLong){
            result+=result;
            divisorLongOld = divisorLong;
            divisorLong+=divisorLong;
        }
        result+=divide((int)(dividendL - divisorLongOld), (int)divisorL);
        result = negative?0-result:result;

        if (result<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else if (result>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else return (int)result;
    }


    public static void main(String[] args) {
        System.out.println(new DivideTwoIntegers().divide(-2147483648, -1));
    }
}
