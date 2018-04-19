package code;

/**
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * @author I317032
 *
 */
public class lc75 {

	public void sortColors1(int[] nums) {
		int rednum = 0, whitenum = 0, bluenum = 0;
		for (int i : nums) {
			switch (i) {
			case 0:
				rednum++;
				break;
			case 1:
				whitenum++;
				break;
			case 2:
				bluenum++;
				break;
			}
		}
		for (int i = 0; i < rednum; i++) {
			nums[i] = 0;
		}
		for (int i = 0; i < whitenum; i++) {
			nums[i+rednum] = 1;
		}
		for (int i = 0; i < bluenum; i++) {
			nums[i+rednum+whitenum] = 2;
		}
	}

	public void sortColors(int[] nums) {
		int zero = 0;
		int two = nums.length - 1;
		for (int i = 0; i < two; i++) {
			if(nums[i] == 0 && i != zero) {
				swap(nums, i--, zero++);
			}else if(nums[i] == 2 && i != two){
				swap(nums, i--, two--);
			}
		}

	}

	public void swap(int[] nums, int i, int j) {
		nums[i] = nums[i] + nums[j];
		nums[j] = nums[i] - nums[j];
		nums[i] = nums[i] - nums[j];
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 1, 0, 2, 1, 0 };
		lc75 test = new lc75();
		test.sortColors(nums);
		for (int i : nums)
			System.out.print(i + "  ");

	}

}
