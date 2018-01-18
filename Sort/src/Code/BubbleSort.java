package Code;

public class BubbleSort {
	/**
	 * 冒泡法对数组进行从小到大排序
	 * @param numbers
	 */
	public static void bubbleSort(int[] numbers){
		
		if(numbers == null || numbers.length <= 1)
			return;
		
		int size = numbers.length;
		boolean flag = true;
		for(int i = 0; i < size-1 && flag; i++){
			flag = false;
			for(int j = size-2; j >= i; j--){
				if(numbers[j] > numbers[j+1]){
					swap(numbers, j, j+1);
					flag = true;
				}
			}
		}
	}
	
	public static void swap(int[] numbers, int i, int j){
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	
	public static void main(String[] args){
		int[] numbers = {33, 4, 2, 3, 67, 23};
		bubbleSort(numbers);
		for(int i : numbers)
			System.out.print(i + "   ");
	}
}
