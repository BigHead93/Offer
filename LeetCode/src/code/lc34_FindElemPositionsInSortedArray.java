package code;

import java.util.Arrays;

public class lc34_FindElemPositionsInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int first = 0, end = nums.length - 1, mid;
        while (first <= end) {
            mid = first + (end - first) / 2;
            if (nums[mid] == target) {
                int i = mid;
                while (i > 0 && nums[i - 1] == target) {
                    i--;
                }
                result[0] = i;
                i = mid;
                while (i < nums.length - 1 && nums[i + 1] == target)
                    i++;
                result[1] = i;
                return result;
            } else if (nums[mid] < target)
                first = mid + 1;
            else if (target < nums[mid])
                end = mid - 1;

        }

        return result;
    }

    public int[] searchRange2(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};

        int left = findLeft(nums, target);
        return new int[]{left, left == -1 ? -1 : findRight(nums, target)};
    }

    private int findLeft(int[] nums, int target) {
        int h = 0, t = nums.length - 1, m;
        while(h < t) {
            m = h + (t - h) / 2;
            if(nums[m] == target)
                t = m;
            else if (nums[m] > target)
                t = m - 1;
            else if (nums[m] < target)
                h = m + 1;
        }
        return nums[h] == target ? h : -1;
    }

    private int findRight(int[] nums, int target) {
        int h = 0, t = nums.length - 1, m;
        while (h < t) {
            m = h + (t - h) / 2;
            if(nums[m] == target)
                h = m;
            else if(nums[m]> target)
                t = m - 1;
            else if (nums[m] < target)
                h = m + 1;
        }
        return nums[h] == target ? h : -1;
    }


    public static void main(String[] args) {
        lc34_FindElemPositionsInSortedArray test = new lc34_FindElemPositionsInSortedArray();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 10;
        System.out.println(Arrays.toString(test.searchRange2(nums, target)));
    }
}
