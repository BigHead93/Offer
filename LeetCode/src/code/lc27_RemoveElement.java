package code;

public class lc27_RemoveElement {

	public static void main(String[] args) {
		int[] nums = { 2 };
		lc27_RemoveElement test = new lc27_RemoveElement();
		int len = test.removeElement(nums, 3);
		System.out.print(len);
	}

	public int removeElement(int[] nums, int val) {
		int i = 0, j = nums.length - 1;
		int tmp = 0;
		while (i <= j) {
			while (j >= 0 && nums[j] == val) {
				j--;
			}
			while (nums[i] == val && i < j) {
				tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
				j--;
			}
			while (i < nums.length && i <= j && nums[i] != val) {
				i++;
			}
		}
		return i;
	}
	
	public int removeElement2(int[] nums, int val) {
		int i = 0;
		for(int j = 0; j < nums.length; j++) {
			if(nums[j] != val) {
				nums[i++] = nums[j];
			}
		}
		return i;
	}
	
	
}
