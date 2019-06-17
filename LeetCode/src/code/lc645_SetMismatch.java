package code;

public class lc645_SetMismatch {
    //输出顺序答案是先输出存在的再输出缺失的
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0)
                nums[Math.abs(nums[i]) - 1] *= -1;
            else
                res[0] = Math.abs(Math.abs(nums[i]));
        }
        for (int i = 0; i < nums.length; i++)
            if (nums[i] > 0)
                res[1] = i + 1;
        return res;
    }
}
