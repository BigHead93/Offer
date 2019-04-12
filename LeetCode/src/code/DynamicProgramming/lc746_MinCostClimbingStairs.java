package code.DynamicProgramming;

/**
 * F(n) = min( f(n-1) , f(n-2) ) + cost[n]
 */
public class lc746_MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {

        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }

    public static void main(String[] args) {
        int[] a = {0, 0, 0, 1};
//        int[] a = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        lc746_MinCostClimbingStairs test = new lc746_MinCostClimbingStairs();
        System.out.println(test.minCostClimbingStairs(a));
    }
}
