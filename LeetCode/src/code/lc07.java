package code;

public class lc07 {

	public static void main(String[] args) {
		System.out.println(reverse(-2147483412));
	}

	public static int reverse(int x) {
		if (x == 0)
			return 0;
		int res = 0;
		char[] positive = Integer.toString(Integer.MAX_VALUE).toCharArray();
		char[] negative = Integer.toString(Integer.MIN_VALUE).toCharArray();
		char[] nums = Integer.toString(x).toCharArray();
		if (x > 0) {
			if (nums.length == positive.length) {
				for (int i = 0; i < positive.length; i++) {
					if (positive[i] == nums[positive.length-i-1]){
						continue;
					}else if(positive[i] > nums[positive.length-i-1]){
						break;
					}else {
						return 0;
					}
				}
			}
			for (int i = nums.length-1; i >= 0; i--) {
				res = res * 10 + (nums[i] - '0');
			}
		}else {
			if(nums.length == negative.length) {
				for(int i = 1; i < negative.length; i++) {
					if(negative[i] == nums[negative.length - i]) {
						continue;
					}else if(negative[i] > nums[negative.length - i]) {
						break;
					}else {
						return 0;
					}
				}
			}
			for(int i = nums.length-1; i > 0; i--) {
				res = res * 10 + (nums[i] - '0');
			}
			res *= -1;
		}
		return res;

	}
}