package code;

import java.util.HashMap;
import java.util.Map;

public class lc01 {
//	method 1
	public static int[] twoSum1(int[] nums, int target) {
		int[] ans = new int[2];
		for(int i = 0; i <= nums.length - 2; i++) {
			for(int j = i+1; j <= nums.length - 1; j++) {
				if(nums[i] + nums[j] == target) {
					ans[0] = i;
					ans[1] = j;
				}
			}
		}
		return ans;
	}
	
//	method 2
	public static int[] twoSum2(int[] nums, int target) {
		int num;
		int[] res = new int[2];
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			hm.put(nums[i], i);
		}
		for(int i = 0; i < nums.length; i++) {
			num = target - nums[i];
			if(hm.containsKey(num) && hm.get(num) != i) {
				res[0] = i;
				res[1] = hm.get(num);
				break;
			}
		}
		return res;
	}
	
//	method 3
	public static int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(hm.containsKey(nums[i])) {
				res[0] = hm.get(nums[i]);
				res[1] = i;
				break;
			}else {
				hm.put(target-nums[i], i);
			}
		}
		return res;
	}
	
	
	public static void main(String args[]) {
		int[] a = {3,4,2};
		int[] b = twoSum(a, 6);
		for(int i : b)
			System.out.print(i);
	}
}
