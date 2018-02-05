package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc15 {
	public List<List<Integer>> threeSum(int[] nums) {
		if(nums == null || nums.length < 3) return null;
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		Map<Integer, List<Integer>> twoSum = new HashMap<Integer, List<Integer>>();
		for(int i = 0; i < nums.length - 1; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				twoSum.put(nums[i] + nums[j], new ArrayList<Integer>(Arrays.asList(i,j)));
			}
		}
		for(int i : nums) {
			if(twoSum.containsKey(0 - i)) {
				List<Integer> index = twoSum.get(0 - i);
				if(index.contains(i)) continue;
				List<Integer> res = index;
				res.add(i);
				results.add(new ArrayList<Integer>(Arrays.asList(nums[res.get(0)], nums[res.get(1)], nums[res.get(2)])));
			}
		}
		return results;
	}
}
