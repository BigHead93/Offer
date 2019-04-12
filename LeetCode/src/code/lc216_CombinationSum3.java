package code;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 *
 * Note:
 *
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 */
public class lc216_CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> resultSet = new ArrayList<List<Integer>>();
        getAllHappens(resultSet, new ArrayList<>(), k, n, 1);
        return resultSet;
    }

    private void getAllHappens(List<List<Integer>> resultSet, List<Integer> entry, int leftMemNum, int target, int start) {
        if(leftMemNum == 0) {
            if(target == 0)
                resultSet.add(new ArrayList<>(entry));
            else
                return;
        } else {
            for(int i = start; i < 10; i++) {
                entry.add(i);
                getAllHappens(resultSet, entry, leftMemNum - 1, target - i, i+1);
                entry.remove(entry.size() - 1);
            }
        }

    }
}
