package code;

public class LongestContinuousSubarray {
	public int longestContinuousSubarray(int[] array){
		if(array == null) return 0;
		if(array.length == 1) return 1;
		int maxlen = 0;
		int head = 0;
		int flag = 0;
		for(int i = 0; i < array.length - 1; ){
			if(Math.abs(array[i] - array[i+1]) != 1) {i++; continue;}
			else{
				flag = array[i + 1] - array[i];
				for(int j = 1; j < array.length - i; j++){
					if(array[i+j] - array[i] == flag * j){
						continue;
					}else{
						if(maxlen < j) {
							maxlen = j;
							head = i;
						}
						i+= j;
						break;
					}
				}
			}
		}
		System.out.println("head: " + head);
		return maxlen;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,1,5,2,3,4,5,2};
		LongestContinuousSubarray ls = new LongestContinuousSubarray();
		System.out.println(ls.longestContinuousSubarray(a));
	}
}
