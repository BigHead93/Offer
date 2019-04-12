package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc54_SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return list;
        int m = matrix.length;
        int n = matrix[0].length;
        int is = 0, js = 0, ie = matrix.length - 1, je = matrix[0].length - 1, i, j;
        while ((is <= ie || js <= je) && list.size() < m * n) {
            if (js <= je) {
                for (j = js; j <= je; j++) {
                    list.add(matrix[is][j]);
                }
                is++;
            }
            if (is <= ie && list.size() < m * n) {
                for (i = is; i <= ie; i++) {
                    list.add(matrix[i][je]);
                }
                je--;
            }
            if (je >= js && list.size() < m * n) {
                for (j = je; j >= js; j--) {
                    list.add(matrix[ie][j]);
                }
                ie--;
            }
            if (ie >= is && list.size() < m * n) {
                for (i = ie; i >= is; i--) {
                    list.add(matrix[i][js]);
                }
                js++;
            }
        }
        return list;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return list;
        int is = 0, js = 0, ie = matrix.length - 1, je = matrix[0].length - 1;
        while (is <= ie && js <= je) {

            for (int t = js; t <= je; t++) {
                list.add(matrix[is][t]);
            }
            for (int t = is + 1; t <= ie; t++) {
                list.add(matrix[t][je]);
            }
            if (is < ie)
                for (int t = je - 1; t >= js; t--) {
                    list.add(matrix[ie][t]);
                }
            if (js < je)
                for (int t = ie - 1; t > is; t--) {
                    list.add(matrix[t][js]);
                }
            is++;
            ie--;
            js++;
            je--;

        }
        return list;

    }

    public static void main(String[] args) {
        int[][] m = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};//, {13, 14, 15, 16}, {17, 18, 19, 20}};
//        int[][] m = {{1, 2, 3}, {4, 5, 6},{ 7, 8,9}};//, 10, 11, 12}, {13, 14, 15, 16}};
        lc54_SpiralMatrix test = new lc54_SpiralMatrix();
        List<Integer> list = test.spiralOrder2(m);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
