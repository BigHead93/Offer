package code;

public class lc121 {
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2)
            return 0;
        int low = prices[0], high = prices[0], max = 0;
        for (int i : prices) {
            if(i < low)
                low = high = i;
            if(i > high) {
                high = i;
                max = high - low > max ? high - low : max;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
