package code;

public class FeiDeMianShiTi {
/**
 * given array a, find array b, b[i] stores the biggest number between a[i] and a[len-1] 
 * @param source
 * @return
 */
	public static int[] createNewArray(int[] source) {
		if(source == null) return null;
//		if(source.length == 1) return source;
		
		int len = source.length;
		int[] res = new int[len];
		res[len-1] = source[len-1];
		for(int i = len-2; i >= 0; i--) {
			res[i] = res[i+1] >= source[i] ? res[i+1] : source[i];
		}
		
		return res;																																																			
	}
	
	public static void main(String[] args) {
		int[] source = {1,2,3,4,5};
		int[] res = createNewArray(source);
		for(int i : res)
			System.out.println(i);

	}

}
