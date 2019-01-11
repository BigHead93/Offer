package code;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 */
public class lc78_subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tmp = new ArrayList<>();
            for(List<Integer> subList : result)  {
                List<Integer> a = new ArrayList<>(subList);
                a.add(nums[i]);
                tmp.add(a);
            }
            result.addAll(tmp);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        lc78_subsets test = new lc78_subsets();
        System.out.print( test.subsets(nums) );
    }
}
