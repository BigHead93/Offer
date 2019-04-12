package code;

import java.util.Arrays;

public class lc16_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3)
            return 0;
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[nums.length-1];
        int preSum = sum;
        for(int i = 0; i < nums.length-2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            boolean flag = false;
            while(j < k && !flag) {
                int curSum = nums[i] + nums[j] + nums[k];
                if(curSum == target) {
                    sum = curSum;
                    flag = true;
                }
                if(Math.abs(curSum-target) < Math.abs(sum-target)) {
                    sum = curSum;
                }
                preSum = curSum;
                if(curSum < target) {
                    j++;
                } else {
                    k--;
                }
            }
            if(flag)
                break;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,5,10,11};
        lc16_3SumClosest test = new lc16_3SumClosest();
        int sum = test.threeSumClosest(array, 12);
        System.out.println(sum);
    }
}
