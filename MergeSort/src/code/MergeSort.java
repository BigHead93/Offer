package code;

public class MergeSort {
	
	public static void mergeSort(int[] array){
		MSort(array, 0, array.length-1);
	}
	
	public static void MSort(int array[], int left, int right){
		if(left >= right)
			return;
		
		int center = (left + right)/2;
		MSort(array, left, center);
		MSort(array, center+1, right);
		merge(array, left, center, right);
	}
	
	public static void merge(int[] array, int left, int center, int right){
		int[] temp = new int[array.length];
		int start = left;
		int mid = center + 1;
		int tmp = left;
		while(left <= center && mid <= right){
			if(array[left] <= array[mid]){
				temp[start++] = array[left++];
			}else{
				temp[start++] = array[mid++];
			}
		}
		while(left <= center){
			temp[start++] = array[left++];
		}
		while(mid <= right){
			temp[start++] = array[mid++];
		}
		while(tmp <= right){
			array[tmp] = temp[tmp++];
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {50, 10, 90, 30, 70, 40, 80, 60, 20};
		mergeSort(a);
		for(int i : a){
			System.out.print(i + " ");
		}
	}

}
