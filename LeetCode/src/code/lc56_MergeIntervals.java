package code;

import java.util.ArrayList;
import java.util.List;

public class lc56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length < 2)
            return intervals;
        List<int[]> list = new ArrayList<>();

        int i = 0, j = 1;
        while(j < intervals.length) {
            if(intervals[i][1] < intervals[j][0]) {
                list.add((intervals[i]));
                i = j;
                j++;
            } else {
                intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
                if(++j == intervals.length) {
                    list.add(intervals[i]);
                }
            }
        }
        int[][] res = new int[list.size()][2];
        for(int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;
    }
}
