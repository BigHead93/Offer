package code;


import java.util.LinkedList;

/**
 * Given an integer array with all positive numbers and no duplicates,
 * find the number of possible combinations that add up to a positive integer target.
 */
public class lc377_CombinationSum4 {

    public int combinationSum4(int[] nums, int target) {
        int[] comb = new int[target + 1];
        comb[0] = 1;
        for (int i = 1; i < comb.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j])
                    comb[i] += comb[i - nums[j]];
            }
        }
        return comb[target];
    }

    public static void main(String[] args) {
        int[] nums = {3, 33, 333};
        int target = 39;
        lc377_CombinationSum4 test = new lc377_CombinationSum4();
        System.out.println(test.combinationSum4(nums, target));
    }

}
