package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc18_4sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 4)
            return result;
        Arrays.sort(nums);
        backtrack(result, new ArrayList<Integer>(), nums, target, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> tmp, int[] nums, int target, int start) {
        if(tmp.size() == 4 && target == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        } else if (tmp.size() == 4 && target != 0)
            return;
        for(int i = start; i < nums.length ; i++) {
            // if(nums[i] == nums[start-1])
            //     continue;
            tmp.add(nums[i]);
            backtrack(result, tmp, nums, target-nums[i], i+1);
            tmp.remove(tmp.size()-1);
            while(i < nums.length-1 && nums[i] == nums[i+1])
                i++;
        }
    }

    public static void main(String[] args) {
        int[] a = {5,5,3,5,1,-5,1,-2};
        lc18_4sum test = new lc18_4sum();
        List<List<Integer>> res = test.fourSum(a, 4);
        for(List<Integer> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }
}
