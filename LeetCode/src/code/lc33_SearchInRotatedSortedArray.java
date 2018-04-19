package code;

import java.util.concurrent.atomic.AtomicInteger;

public class lc33_SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums = {1,2,3,5,6,7};
		lc33_SearchInRotatedSortedArray ts = new lc33_SearchInRotatedSortedArray();
		int a = ts.search(nums, 4);
		System.out.print(a);

	}

	public int search(int[] nums, int target) {
		int len = nums.length;
		int f = 0;
		int l = len - 1;
		int m;
		AtomicInteger ts = new AtomicInteger();
		ts.incrementAndGet();
//		CopyOnWriteArrayList
		while(f < l) {
			m = (f + l) / 2;
			if(nums[m] == target)
				return m;
			if(nums[f] <= nums[m]) {
				if(nums[f] <= target && target < nums[m]) {
					l = m - 1;
				}else {
					f = m + 1;
				}
			}else {
				if(nums[m] < target && target <= nums[l]) {
					f = m + 1;
				}else {
					l = m - 1;
				}
			}
		}
		return -1;
	}

}
