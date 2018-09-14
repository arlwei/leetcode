/**
 * title:
 *  29. Divide Two Integers
 * content:
 *  Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 *  Return the quotient after dividing dividend by divisor.
 *  The integer division should truncate toward zero.
 */
public class DivideTwoIntegers {

    public static void main(String[] args) {
        int r = new DivideTwoIntegers().divide(-2147483648, -2147483648);
        System.out.println(r);
    }

    public int divide(int dividend, int divisor) {
        //The divisor will never be 0, or the max integer is 2**31 − 1
        if(divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        //it may overflow when it is -2147483648
        long m  = Math.abs((long)dividend);
        long n = Math.abs((long)divisor);
        int res = 0;
        boolean sign = (dividend < 0) ^ (divisor < 0) ? false : true;
        if(n == 1)
            return (int)(sign ? m : -m);
        while(m >= n)
        {
            //it may overflow when using operator "<<"
            long tmp = n;
            int step = 1;
            while(m - (tmp<<1) > 0)
            {
                tmp <<= 1;
                step <<= 1;
            }
            m -= tmp;
            res += step;
        }
        return sign ? res : -res;
    }
}
