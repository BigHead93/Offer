package code;

public class QuickSort {
	
	public static void quickSort(int[] array){
		if(array == null || array.length == 1){
			return;
		}
		QSort(array, 0, array.length-1);
	}
	
	public static void QSort(int[] array, int low, int high){
		int pivot;
		if(low < high){
			pivot = Partition(array, low, high);
			QSort(array, low, pivot-1);
			QSort(array, pivot+1, high);
		}
	}
	
	public static int Partition(int[] array, int low, int high){
		int pivotkey;
		pivotkey = array[low];
		while(low < high){
			while(low < high && array[high] >= pivotkey){
				high--;
			}
			swap(array, low, high);
			while(low < high && array[low] <= pivotkey){
				low++;
			}
			swap(array, low, high);
		}
		return low;
	}
	
	public static void swap(int[] array, int i, int j){
		if(i == j)
			return;
		array[i] = array[i] + array[j];
		array[j] = array[i] - array[j];
		array[i] = array[i] - array[j];
	}
	
	public static void main(String[] args) {
		int[] a = {50, 10, 90, 30, 70, 40, 80, 60, 20};
		quickSort(a);
		for(int i : a){
			System.out.print(i + " ");
		}
		
	}
}
