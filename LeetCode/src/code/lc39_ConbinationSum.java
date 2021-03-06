package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 */

public class lc39_ConbinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getAllHappens(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void getAllHappens(List<List<Integer>> result, List<Integer> entry, int[] candidates, int target, int start) {
        if(target == 0) {
            result.add(new ArrayList<>(entry));
        } else {
            for(int i = start; i < candidates.length && candidates[i] <= target; i++) {
                entry.add(candidates[i]);
                getAllHappens(result, entry, candidates, target - candidates[i], i);
                entry.remove(entry.size() - 1);
            }
        }
    }
}
