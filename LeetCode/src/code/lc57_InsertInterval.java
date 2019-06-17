package code;

public class lc57_InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int curr = 0;

        int left = newInterval[0];
        int right = newInterval[1];
        int len = intervals.length;

        for(int i = 0; i < intervals.length; i++) {
            if(left < intervals[i][0]) {
                if(right < intervals[i][0]) {
                    int[][] res = new int[len+1][2];
                    res[0] = newInterval;
                    for(int j = 0; j < len; j++)
                        res[j+1] = intervals[j];
                    intervals = res;
                    break;
                } else if(intervals[i][0] <= right && right <= intervals[i][1]) {
                    intervals[i][0] = left;
                    break;
                } else {

                }
            } else if(intervals[i][0] <= left && left <= intervals[i][1]) {
                left = intervals[i][0];

            } else {
                curr++;
                if(curr == len) {
                    int[][] res = new int[len + 1][];
                    for(int j = 0; j < len; j++) {
                        res[j] = intervals[j];
                    }
                    res[len] = newInterval;
                    intervals = res;
                    break;
                }
            }
        }

        return intervals;
    }
}
