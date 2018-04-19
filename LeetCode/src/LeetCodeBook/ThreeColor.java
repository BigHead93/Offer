package LeetCodeBook;

public class ThreeColor {
	public static void main(String[] args) {
		int[] nums = { 1, 0 };
		ThreeColor test = new ThreeColor();
		test.sortColors(nums);
		for (int i : nums) {
			System.out.print(i + "  ");

		}
	}
	
	public void sortColors(int[] nums) {
		if (nums == null || nums.length < 2)
			return;
		int i = 0, j = 0, k = nums.length;
		for (int q = 0; q < nums.length && q < k; q++) {
			if (nums[q] == 0) {
				swap(nums, i++, q);
			} else if (nums[q] == 1) {
				j++;
			} else if (nums[q] == 2) {
				swap(nums, q--, --k);
			}
		}
		TreeMap
	}

	/*
	 * i: the last position of 0, initial -1; j: the length of 1, initial 0; the
	 * last position of 1 is i + j; k: the last position of 2, initial nums.length;
	 */
	public void sortColors2(int[] nums) {
		if (nums == null || nums.length < 2)
			return;
		int i = -1, j = 0, k = nums.length;
		for (int q = 0; q < k; q++) {
			switch (nums[q]) {
			case 2:
				swap(nums, q--, --k);
				break;
			case 1:
				j++;
				break;
			case 0:
				swap(nums, q, ++i);
				break;
			}
		}
	}

	public void swap(int[] nums, int i, int j) {
		int flag = nums[i];
		nums[i] = nums[j];
		nums[j] = flag;
	}
}
