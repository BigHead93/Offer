package code;

import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 */
public class lc31_next_permutation {
    public void nextPermulation(int[] nums) {
        int first = -1, second = 0;
        for(int i = nums.length - 1; i > 0 ; i--) {
            if(nums[i-1] < nums[i]) {
                first = i-1;
                second = i;
                break;
            }
        }
        if(first > -1) {
            for(int i = nums.length -1; i >= second; i--) {
                if(nums[i] > nums[first]) {
                    nums[first] = nums[first] + nums[i];
                    nums[i] = nums[first] - nums[i];
                    nums[first] = nums[first] - nums[i];
                    break;
                }
            }
        }
        for(int i = second, j = nums.length -1; i < j; i++, j--) {
            nums[i] = nums[i] + nums[j];
            nums[j] = nums[i] - nums[j];
            nums[i] = nums[i] - nums[j];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        lc31_next_permutation test = new lc31_next_permutation();
        test.nextPermulation(nums);
        System.out.println(Arrays.toString(nums));
    }

}
