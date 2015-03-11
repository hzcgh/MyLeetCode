/**
 *  Integer output: https://oj.leetcode.com/problems/sqrtx/
 *  Be aware:
 *  1) Special case for x == 1
 *  2) Integer overflow, when start+end or mid*mid
 *
 *  Double output: http://www.careercup.com/question?id=4419686
 */
public class Sqrt {
    public double sqrt(double x, double delta)
    {
        return sqrt(x, delta, 0, x);
    }

    public double sqrt(double x, double delta, double start, double end){
        double mid = (start+end)/2;
        if ( Math.abs(x-mid*mid)<=delta)
            return mid;
        else
        {
            if (mid*mid> x)
            {
                return sqrt(x, delta, start, mid);
            } else
            {
                return sqrt(x, delta, mid, end);
            }
        }
    }

    public int sqrt(int x) {
        if (x == 1) {
            return 1;
        }
        else {
            return sqrt2(x, 0, x, x);
        }
    }

    public int sqrt2(int x, int start, int end, int prev)
    {
        int mid = start + (end - start)/2;

        if (mid == prev)
            return mid;
        if (mid == x/mid)
            return mid;
        else if (mid > x/mid)
        {
            return sqrt2(x, start, mid, mid);
        } else
        {
            return sqrt2(x, mid, end, mid);
        }
    }
}
