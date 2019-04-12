package Code;

public class HeapSort {
	
	public static void heapSort(int[] numbers){
		
		if(numbers == null || numbers.length <= 1)
			return;
		
		//先构建一个大顶堆
		for(int i = numbers.length/2-1; i >= 0; i--){
			heapAdjust(numbers, i, numbers.length-1); 
		}
		//依次把大的往后放，从小到大排序
		for(int i = numbers.length-1; i > 0; i--){
			swap(numbers, 0, i);
			heapAdjust(numbers, 0, i-1);
		}
	}
	
	public static void heapAdjust(int[] numbers, int start, int end){
		int temp, j;
		temp = numbers[start];
		for(j = 2*start+1; j<=end-1; j = 2*j+1){
			if( j < end && numbers[j] < numbers[j+1]){
				++j;
			}
			if(temp >= numbers[j]){
				break;
			}
			numbers[start] = numbers[j];
			start = j;
		}
		numbers[start] = temp;
	}
	
	public static void swap(int[] numbers, int i, int j){
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] numbers = {33, 4, 2, 13, 67, 54, 22};
		heapSort(numbers);
		for(int i : numbers)
			System.out.print(i + "   ");
	}

}
