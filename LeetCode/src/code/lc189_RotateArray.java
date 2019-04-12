package code;

import java.util.Arrays;
import java.util.LinkedList;

public class lc189_RotateArray {
    //冒泡
    // public void rotate(int[] nums, int k) {
    //     int len = nums.length;
    //     while(k-- > 0) {
    //         for(int i = len-1; i > 0; i--) {
    //             int tmp = nums[i];
    //             nums[i] = nums[i-1];
    //             nums[i-1] = tmp;
    //         }
    //     }
    // }

    // 顺序往右旋转
    // public void rotate(int[] nums, int k) {
    //     if(nums == null || nums.length < 2)
    //         return;
    //     int len = nums.length;
    //     while(k-- > 0) {
    //         int pre = nums[0];
    //         int now ;
    //         for(int i = 1; i < nums.length; i++) {
    //             now = nums[i];
    //             nums[i] = pre;
    //             pre = now;
    //         }
    //         nums[0] = pre;
    //     }
    // }

    //直接向后移动k个位置
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2)
            return;
        int len = nums.length;
        k %= len;
        int divident = len, dividor = k, left = 0;
        while (divident % dividor != 0) {
            left = divident % dividor;
            divident = dividor;
            dividor = left;
        }
        int times = dividor;
        for (int s = 0; s < times; s++) {
            int pre = s;
            int now = (pre + k) % len;
            int preV = nums[s];
            int nowV;
            while (now != s) {
                nowV = nums[now];
                nums[now] = preV;
                preV = nowV;
                pre = now;
                now = (pre + k) % len;
            }
            nums[now] = preV;
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        lc189_RotateArray test = new lc189_RotateArray();
        test.rotate(nums, 1);
        System.out.println(Arrays.toString(nums));
    }
}
