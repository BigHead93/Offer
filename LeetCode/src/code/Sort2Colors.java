package code;

public class Sort2Colors {

	public static void main(String[] args) {
		int[] a = {1,0,1,1,0,0,1,0,0};
		Sort2Colors ts = new Sort2Colors();
		ts.sort2Colors(a);
		for(int i : a)
			System.out.print(i + "  ");
	}
	
	public void sort2Colors(int[] array) {
		int i, j;
		if(array == null || array.length < 2) {
			return;
		}
		i = 0;
		j = array.length - 1;
		while(i < j) {
			while(array[i] == 0)
				i++;
			while(array[j] == 1)
				j--;
			if(i < j) {
				array[i] = array[i] + array[j];
				array[j] = array[i] - array[j];
				array[i] = array[i] - array[j];
			}
		}
	}
	
	

}
