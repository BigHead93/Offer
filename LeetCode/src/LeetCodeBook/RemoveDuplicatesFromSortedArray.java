package LeetCodeBook;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//every data appears only once
	public int removeDuplicates(int[] array) {
		if(array == null)
			return 0;
		if(array.length < 2)
			return array.length;
		int i = 0, j = 0;
		for( j = 1; j < array.length; j++) {
			if(array[i] != array[j])
				array[++i] = array[j];
		}
		return i+1;
	}
	
	//every data appears at most twice
	public int removeDuplicatesTwice(int[] array) {
		if(array == null)
			return 0;
		if(array.length < 2)
			return array.length;
		int i = 2;
		for( int j = 2; j < array.length; j++) {
			if(array[j] != array[j-2])
				array[i++] = array[j];
		}
		return i+1;
	}
}
