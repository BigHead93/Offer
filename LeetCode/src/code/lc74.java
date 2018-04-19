package code;

public class lc74 {
	
	public static void main(String[] args) {
		int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		lc74 test = new lc74();
		System.out.println(test.searchMatrix(matrix, 4));
	}
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		int i = 0;
		int m = matrix.length;
		int n = matrix[0].length;
		for(; i < m; i++) {
			if(matrix[i][0] <= target && target <= matrix[i][n-1]) {
				break;
			}
		}
		if(i == m)
			return false;
		return findIndex(matrix[i], 0, n-1, target);
	}
	public boolean findIndex(int[] array, int start, int end, int target) {
		boolean flag = false;
		if(start > end) 
			return false;
		if(target < array[start] || target > array[end])
			return false;
		if(array[start] == target || array[end] == target)
			return true;
		int mid = (start + end) / 2;
		if(array[mid] == target) {
			return true;
		}else if(array[mid] > target) {
			flag = findIndex(array, 0, mid-1, target);
		}else {
			flag = findIndex(array, mid+1, end, target);
		}
		return flag;
	}
}
