package code;

public class lc29_DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        long result = divideLong(dividend, divisor);
        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
    }

    public long divideLong(long dividend, long divisor) {
        if(dividend == 0 || divisor == 1)
            return dividend;
        boolean negative = dividend < 0 != divisor < 0 ;

        if(dividend < 0) dividend *= -1;
        if(divisor < 0) divisor *= -1;

        if(dividend < divisor)
            return 0;

        long sum = divisor;
        long divide = 1;
        while((sum + sum) <= dividend) {
            sum += sum;
            divide += divide;
        }

        return negative ? -(divide + divideLong((dividend-sum), divisor)) : (divide + divideLong((dividend-sum), divisor));

    }

    /**
     * LeetCode上超时，不能这样一次一次减，太慢
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide2(int dividend, int divisor) {
        int mark = (dividend > 0 ? 1 : -1) * (divisor > 0 ? 1 : -1);

        long dividendl = dividend;
        long divisorl = divisor;
        if(dividendl < 0) dividendl *= -1;
        if(divisorl < 0) divisorl *= -1;

        long result = 0;
        while(dividendl >= divisorl) {
            dividendl -= divisorl;
            result++;
        }
        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)result * mark;
    }


    public static void main(String[] args) {
        int dividend = Integer.MIN_VALUE;
        int divisor = -1;
        System.out.println(dividend * divisor);
        lc29_DivideTwoIntegers test = new lc29_DivideTwoIntegers();
        System.out.println(test.divide2(dividend, divisor));
    }
}
