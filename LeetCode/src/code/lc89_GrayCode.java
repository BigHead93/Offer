package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class lc89_GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        backtrack(ans, new int[n], 0, 0);
        return ans;
    }

    private void backtrack(List<Integer> ans, int[] tmp, int start, int init) {

        for(int i = start; i < tmp.length; i++) {
            tmp[i] = tmp[i] == 0 ? 1 : 0;
            init += Math.pow(2, tmp.length-1-i) * (tmp[i] == 0 ? 1 : -1);
            for(int j = i+1; j < tmp.length; j++) {
                ans.add(init);
                tmp[j] = tmp[j] == 0 ? 1 : 0;
                init += Math.pow(2, tmp.length-1-i) * (tmp[i] == 0 ? 1 : -1);
                tmp[j] = tmp[j] == 1 ? 0 : 1;
            }
            init += Math.pow(2, tmp.length-1-i) * (tmp[i] == 0 ? 1 : -1);
            backtrack(ans, tmp, i+1, init);
        }
    }

    public static void main(String[] args) {
        lc89_GrayCode test = new lc89_GrayCode();
        List<Integer> result = test.grayCode(2);
        System.out.println(Arrays.toString(result.toArray()));
    }
}