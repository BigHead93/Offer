import java.math.BigInteger;

public class Search {

    public static int LinearSearch(int[] nums, int target) {
        if (empty(nums)) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                return i;
        }
        return -1;
    }

    /**
     * 二分，数组里数从小到大排序
     *
     * @param nums
     * @param target
     * @return
     */
    public static int BinarySearch(int[] nums, int target) {
        if (empty(nums)) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                low = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 二分，数组里数总小到大排序
     *
     * @param nums
     * @param target
     * @param low
     * @param high
     * @return
     */
    public static int BinarySearch(int[] nums, int target, int low, int high) {
        if (empty(nums) || low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return BinarySearch(nums, target, low, mid - 1);
        } else if (nums[mid] < target) {
            return BinarySearch(nums, target, mid + 1, high);
        }
        return -1;
    }


    public static boolean empty(int[] array) {
        return array == null && array.length == 0;
    }
}

