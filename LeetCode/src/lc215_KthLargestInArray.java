import java.util.Arrays;

public class lc215_KthLargestInArray {

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    /**
     * 方法1：二分快排法，29ms, 36.8%
     */
    public int findKthLargest(int[] nums, int k) {
        int target = quickSort(nums, 0, nums.length-1, k);
        return nums[target];
    }

    public int quickSort(int[] nums, int start, int end, int k) {
        int tmp = nums[start + (end - start) / 2];
        int left = start, right = end;
        while(left < right) {
            while(left < right && nums[left] >= tmp)
                left++;
            swap(nums, left, right);
            while(left < right && nums[right] < tmp)
                right--;
            swap(nums, left, right);
        }
        if(left == k-1)
            return left;
        else if(left < k-1)
            return quickSort(nums, left+1, end, k);
        else
            return quickSort(nums, start, left-1, k);
    }

    public static void main(String[] args) {
        int[] a = {2,44,1,5,6,33,6,2};
        lc215_KthLargestInArray test = new lc215_KthLargestInArray();
        int kth = test.findKthLargest(a, 3);
        System.out.println(Arrays.toString(a));
        System.out.println(kth);
    }
}
