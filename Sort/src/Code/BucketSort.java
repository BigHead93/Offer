package Code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    public double[] bucketSort(double[] array) {
        if(array == null || array.length == 0)
            return array;
        double max = array[0];
        double min = array[0];

        for(int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
            min = Math.min(min, array[i]);
        }

        double gap = max - min;
        int bucketNum = array.length;
        double step = gap / (bucketNum - 1);

        List<List<Double>> bucketList = new ArrayList<>();
        // 这里，桶数量设置为数组长度，可变
        for(int i = 0; i < bucketNum; i++) {
            bucketList.add(new ArrayList<>());
        }

        for(int i = 0; i < array.length; i++) {
            int index = (int)((array[i] - min) / gap);
            bucketList.get(index).add(array[i]);
        }

        for(int i = 0; i < bucketNum; i++) {
            if(bucketList.get(i).size() > 2)
                Collections.sort(bucketList.get(i));
        }

        double[] sortedResult = new double[array.length];
        int index = 0;
        for(List<Double> subList: bucketList) {
            for(double j : subList)
                sortedResult[index++] = j;
        }
        return sortedResult;
    }

    public static void main(String[] args) {
        double[] array = new double[] {4.12,6.421,0.0023,3.0,2.123,8.122,4.12, 10.09};
        BucketSort test = new BucketSort();
        double[] ans = test.bucketSort(array);
        System.out.println(Arrays.toString(ans));
    }
}
