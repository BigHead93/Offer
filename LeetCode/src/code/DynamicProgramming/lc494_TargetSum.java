package code.DynamicProgramming;


/**
 * The recursive solution is very slow, because its runtime is exponential
 * <p>
 * The original problem statement is equivalent to:
 * Find a subset of nums that need to be positive, and the rest of them negative, such that the sum is equal to target
 * <p>
 * Let P be the positive subset and N be the negative subset
 * For example:
 * Given nums = [1, 2, 3, 4, 5] and target = 3 then one possible solution is +1-2+3-4+5 = 3
 * Here positive subset is P = [1, 3, 5] and negative subset is N = [2, 4]
 * <p>
 * Then let's see how this can be converted to a subset sum problem:
 * <p>
 * sum(P) - sum(N) = target
 * sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
 * 2 * sum(P) = target + sum(nums)
 * So the original problem has been converted to a subset sum problem as follows:
 * Find a subset P of nums such that sum(P) = (target + sum(nums)) / 2
 */
public class lc494_TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return (sum < S || (sum + S) % 2 == 1) ? 0 : findExists(nums, (sum + S) / 2);
    }

    private int findExists(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for(int i : nums) {
            for(int j = s; j >= i; j--) {
                dp[j] += dp[j-i];
            }
        }
        return dp[s];
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 1};
        lc494_TargetSum test = new lc494_TargetSum();
        System.out.println(test.findTargetSumWays(a, 3));
    }
}
