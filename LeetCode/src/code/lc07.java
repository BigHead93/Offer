package code;

public class lc07 {

	public static void main(String[] args) {
		System.out.println(reverse(1056389759));
	}

	public static int reverse(int x) {
		int res = 0;
		int flag = x > 0 ? 1 : -1;
		while (x > 9 || x < -9) {
			res = res * 10 + x % 10;
			x = x / 10;
		}
		if (flag > 0) {
			if (Integer.MAX_VALUE / 10 >= res)
				res = Integer.MAX_VALUE - 10 * res > x ? 10 * res + x : 0;
			else
				res = 0;
		} else {
			if (Integer.MIN_VALUE / 10 <= res)
				res = Integer.MIN_VALUE - 10 * res > x ? 0 : 10 * res + x;
			else
				res = 0;
		}
		return res;
	}
}