package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc15 {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 2; i++) {
			if(i == 0 || (i > 0 && nums[i] != nums[i-1])) {
				int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
				while(lo < hi) {
					if (nums[lo] + nums[hi] == sum) {
						results.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
						while(lo < hi && nums[lo] == nums[lo+1]) lo++; //lo < hi, 保证lo++上不越界
						while(lo < hi && nums[hi] == nums[hi-1]) hi--; //lo < hi, 保证hi--下不越界
						lo++;
						hi--;
					} else if (nums[lo] + nums[hi] < sum)
						lo++;
					else
						hi--;
				}
			}
		}
		return results;
	}
}
