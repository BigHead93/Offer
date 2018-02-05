package Code;

public class QuickSort {
	
	public void quickSort(int[] array) {
		if(array == null || array.length == 1) return;
		qSort(array, 0, array.length-1);
	}
	
	public void qSort(int[] array, int low, int high) {
		int pivot;
		if(low < high) {
			pivot = partion(array, low, high);
			qSort(array, low, pivot);
			qSort(array, pivot+1, high);
		}
	}
	
	public int partion(int[] array, int low, int high) {
		int pivotkey = array[low];
		while(low < high) {
			while(low < high && pivotkey <= array[high]) {
				high--;
			}
			swap(array, low, high);
			while(low < high && pivotkey >= array[low]) {
				low++;
			}
			swap(array, low, high);
		}
		return low;
	}
	
	public void swap(int[] array, int i, int j) {
		if(i == j) return;
		array[i] = array[i] + array[j];
		array[j] = array[i] - array[j];
		array[i] = array[i] - array[j];
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {5, 1, 7, 5, 2, 9, 8, 3, 5, 6};
		QuickSort qs = new QuickSort();
		qs.quickSort(array);
		for(int i : array) System.out.println(i);
	}

}
