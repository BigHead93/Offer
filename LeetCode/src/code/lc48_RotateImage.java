package code;

import java.util.Arrays;

public class lc48_RotateImage {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        if(len < 2)
            return;
        int tmp, pre, ni, nj, prei, prej;
        for(int i = 0; i < len/2; i++) {
            for(int j = i; j < len-1-i; j++) {
                pre = matrix[i][j];
                prei = i;
                prej = j;
                do{
                    ni = prej;
                    nj = len - 1 - prei;
                    tmp = matrix[ni][nj];
                    matrix[ni][nj] = pre;
                    pre = tmp;
                    prei = ni;
                    prej = nj;
                }while(ni != i || nj != j);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        lc48_RotateImage test = new lc48_RotateImage();
        test.rotate(matrix);;
        for(int i = 0 ; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
