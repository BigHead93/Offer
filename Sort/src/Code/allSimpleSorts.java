package Code;

public class allSimpleSorts {
	public static void main(String[] args) {
		int[] array = new int[]{2,1,4,6,3};
//		bubbleSort(array);
//		simpleSelectionSort(array);
//		insertSort(array);
		for(int i : array)
			System.out.println(i);
	}
	
	public static void insertSort(int[] array) {
		if(array == null || array.length == 1) return;
		int temp = 0;
		int i = 0, j = 0;
		for(i = 1; i < array.length; i++) {
			temp = array[i];
			for(j = i-1; j >=0; j--) {
				if(array[j] > temp) {
					array[j+1] = array[j]; 
				}else {
					break;
				}
			}
			array[j+1] = temp;
		}
	}
	
	public static void simpleSelectionSort(int[] array) {
		if(array == null || array.length == 1) return;
		int min = 0;
		for(int i = 0; i < array.length - 1; i++) {
			min = i;
			for(int j = i + 1; j < array.length; j++) {
				min = array[min] > array[j] ? j : min;
			}
			if(min != i)
				swap(array, min, i);
		}
		
	}
	
	public static void bubbleSort(int[] array) {
		if(array == null || array.length == 1) return;
		boolean flag = true;
		for(int i = 0; i < array.length - 1 && flag; i++) {
			flag = false;
			for(int j = array.length - 2; j >= i; j--) {
				if(array[j] > array[j+1]) {
					flag = true;
					swap(array, j, j+1);
				}
			}
		}
	}
	
	public static void swap(int[] array, int i, int j) {
		array[i] = array[i] + array[j];
		array[j] = array[i] - array[j];
		array[i] = array[i] - array[j];
	}
}

