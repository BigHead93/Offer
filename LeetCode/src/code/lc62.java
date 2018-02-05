package code;

public class lc62 {
	public int uniquePaths(int m, int n) {
		if(m == 1 || n == 1) return 1;
		int[] line = new int[n];
		line[1] = 1;
		for(int row = 1; row <= m; row++) {
			for(int col = 1; col < n; col++) {
				line[col] += line[col-1];
			}
		}
		return line[n-1];
	}
	public static void main(String[] args) {
		lc62 test = new lc62();
		System.out.println(test.uniquePaths(1, 2));
	}
}
