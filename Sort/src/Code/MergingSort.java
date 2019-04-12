package Code;

public class MergingSort {

    public int[] mergeSort(int[] list) {
        mSort(list, 0, list.length - 1);
        System.out.println(this);
        return list;
    }

    public void mSort(int[] list, int s, int e) {
        int m = s + (e - s) / 2;
        if (s < e) {
            mSort(list, s, m);
            mSort(list, m + 1, e);
            merge(list, s, m, e);
        }
    }

    public void merge(int[] list, int s, int m, int e) {
        int[] tmp = new int[e - s + 1];
        int k = 0, i = s, j = m + 1;
        for (; i <= m && j <= e; k++) {
            if (list[i] <= list[j])
                tmp[k] = list[i++];
            else
                tmp[k] = list[j++];
        }

        while (i <= m) {
            tmp[k++] = list[i++];
        }
        while (j <= e) {
            tmp[k++] = list[j++];
        }

        for (int l = 0; l < tmp.length; l++) {
            list[l + s] = tmp[l];
        }
    }

    public static void main(String[] args) {
        int[] numbers = {33, 4, 2, 3, 67, 23};
        MergingSort test = new MergingSort();
        test.mergeSort(numbers);
        for (int i : numbers)
            System.out.print(i + "   ");
    }

}
