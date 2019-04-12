package code;

import java.util.HashMap;

public class lc07 {

	public static void main(String[] args) {
//		System.out.println(reverse(1056389759));
//		int a = 214748364;
//		int b = a * 10 + 8;
//		int c = (b - 8);
//		int d = c / 10;
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(c);
//		System.out.println(d);
//		Object
//				String
//		Long
		long a = 1l;
		int b = 1;
		System.out.println(a);
		System.out.println(b);

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

	//负数取余是负数，例-13%10=-3
	public int reverse2(int x) {
		int res = 0;
		while(x != 0) {
			int tmp = res * 10 + x % 10;
			if( (tmp - x % 10)/10 != res )
				return 0;
			x /= 10;
			res = tmp;
		}
		return res;
	}
}