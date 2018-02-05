package code;

public class lc64 {
	public int minPathSum(int[][] grid) {
		int width = grid[0].length;
		int[] row = new int[width];
		row[0] = grid[0][0];
		for(int j = 1; j < width; j++) {
			row[j] = row[j-1] + grid[0][j];
		}
		for(int i = 1; i < grid.length; i++) {
			for(int j = 0; j < width; j++) {
				if(j == 0) row[j] += grid[i][j];
				else{
					row[j] = row[j] < row[j-1] ? row[j] + grid[i][j] : row[j-1] + grid[i][j];
				}
			}
		}
		return row[width-1];
	}

	public static void main(String[] args) {
//		int[][] a = new int[][] {{1,3,1},{1,5,1},{4,2,1}};
		int[][] a = new int[][] {{1,2},{1,1}};
		lc64 obj = new lc64();
		System.out.println(obj.minPathSum(a));
	}

}
