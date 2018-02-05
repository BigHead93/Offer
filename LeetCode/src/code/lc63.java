package code;

public class lc63 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;  		//row
		int n = obstacleGrid[0].length;		//column
		if(obstacleGrid[0][0] == 1) return 0;
		int[] line = new int[n];
		line[0] = 1;
		int row = 1, col = 1;
		for(row = 0; row < m; row++) {
			if(obstacleGrid[row][0] == 1) line[0] = 0;
			for(col = 1; col < n; col++) {
				if(obstacleGrid[row][col] == 1) line[col] = 0;
				else line[col] += line[col-1];
			}
		}
		return line[n-1];
    }
	public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
		int width = obstacleGrid[0].length;
		int[] dp = new int[width];
		dp[0] = 1;
		for(int[] row : obstacleGrid) {
			for(int i = 0; i < width; i++) {
				if(row[i] == 1) dp[i] = 0;
				else if(i > 0) dp[i] += dp[i-1];
			}
		}
		return dp[width-1];
	}
	public static void main(String[] args) {
		lc63 test = new lc63();
		int[][] a = new int[][] {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(test.uniquePathsWithObstacles(a));
	}
}
