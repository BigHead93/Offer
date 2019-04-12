package code.DynamicProgramming;

public class lc70_ClimbingStairs {

    /**
     * Runtime: 2 ms, faster than 92.65% of Java online submissions for Climbing Stairs.
     * Memory Usage: 36.2 MB, less than 0.99% of Java online submissions for Climbing Stairs.
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        if (n < 3)
            return n == 1 ? 1 : 2;
        int[] steps = new int[n];
        for (int i = 2; i < n; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        return steps[n-1];
    }

    public int climbStairs2(int n) {
        int s = 1;
        int d = 2;
        int i = 3;
        while(i <= n) {
            if(i % 2 == 1)
                s += d;
            else
                d += s;
            i++;
        }
        return n % 2 == 1 ? s : d;
    }

    public static void main(String[] args) {
        lc70_ClimbingStairs test = new lc70_ClimbingStairs();
        System.out.println(test.climbStairs2(17));
    }
}
