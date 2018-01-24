package code;

public class LongestContinuousSubarray {
	public int longestContinuousSubarray(int[] array){
		if(array == null) return 0;
		if(array.length == 1) return 1;
		int[] res = {};
		int maxlen = 0;
//		int head = 0;
		int flag = 0;
		for(int i = 0; i < array.length - 1; ){
			if(Math.abs(array[i] - array[i+1]) != 1) continue;
			else{
				flag = array[i + 1] - array[i];
				for(int j = 1; i < array.length - i; j++){
					if(array[i+j] - array[i] == flag * j){
						continue;
					}else{
						maxlen = maxlen > j ? maxlen : j;
						i+= j;
					}
				}
			}
		}
		return maxlen;
	}
}
