package code;

import java.util.HashSet;
import java.util.Set;

public class lc73 {
	
	public static void main(String[] args) {
		int[][] nums = {{0,1,2,3},{1,0,2,3},{1,2,3,0},{1,2,3,4}};
		lc73 test = new lc73();
		test.setZeroes(nums);
		for(int j = 0; j < nums.length; j++) {
			for(int i = 0; i < nums[0].length; i++) {
				System.out.print(nums[j][i] + "  ");
			}
			System.out.println();
		}
	}
	
	public void setZeroes(int[][] matrix) {
		int[] rows = new int[matrix.length];
		int[] cols = new int[matrix[0].length];
		boolean flag = false;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] == 0) {
					rows[i] = 1;
					cols[j] = 1;
					flag = true;
				}
			}
		}
		if(flag == true) {
			for(int i = 0; i < matrix.length; i++) {
				if(rows[i] == 1) {
					for(int j = 0; j < matrix[i].length; j++) {
						matrix[i][j] = 0;
					}
					continue;
				}
				for(int j = 0; j < matrix[i].length; j++) {
					if(cols[j] == 1) {
						matrix[i][j] = 0;
					}
				}
			}
		}
	}
}
