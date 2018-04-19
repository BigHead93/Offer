package code;

public class lc69 {

	public static void main(String[] args) {
		lc69 test = new lc69();
//		for(int i = Integer.MAX_VALUE; i >= Integer.MAX_VALUE-10; i--) {
//			System.out.println("     " + i + ": " + test.mySqrt(i));
//		}
		System.out.println(test.mySqrt(1));
	}

	//beat 4%
//	public int mySqrt(int x) {
//		if(x < 2) return x;
//		int i = x;
//		while(x / i < i)
//			i = i / 2;
//		while(i < x / i )
//			i++;
//		if(x / i == i)
//			return i;
//		return --i;
//	}
	// i^2 <= x && (i+1)^2 > x
	public int mySqrt(int x) {
		if(x == 0)
			return 0;
		int left = 1;
		int right = Integer.MAX_VALUE;
		int mid;
		while(true) {
			mid = left + (right - left) / 2;
			if(mid > x/mid) {
				right = mid - 1;
			}else {
				if( mid+1 > x / (mid+1))
					return mid;
				left = mid + 1;
			}
		}
	}
}
