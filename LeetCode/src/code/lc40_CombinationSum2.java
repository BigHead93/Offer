package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all
 * unique !!!!
 * combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 */
public class lc40_CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        String a = "xxxx";
        a.length();
        System.out.println(candidates.length);
        getAllHappens(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void getAllHappens(List<List<Integer>> result, List<Integer> entry, int[] candidates, int target, int start) {
        if(target == 0) {
            result.add(new ArrayList<>(entry));
        } else {
            for(int i = start; i < candidates.length && candidates[i] <= target; i++) {
                entry.add(candidates[i]);
                getAllHappens(result, entry, candidates, target - candidates[i], i+1);
                entry.remove(entry.size() - 1);
                while(i+1 < candidates.length && candidates[i] == candidates[i+1]){
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("ab"));
    }
}
