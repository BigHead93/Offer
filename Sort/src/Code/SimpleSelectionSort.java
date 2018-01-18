package Code;

public class SimpleSelectionSort {
	
	public static void simpleSelection(int[] numbers){
		
		if(numbers == null || numbers.length <= 1)
			return;
		
		int min;
		for(int i = 0; i < numbers.length-1; i++){
			min = i;
			for(int j = i+1; j <= numbers.length-1; j++ ){
				if(numbers[min] > numbers[j]){
					min = j;
				}
			}
			if(i != min){
				swap(numbers, i, min);
			}
		}
	}
	
	public static void swap(int[] numbers, int i, int j){
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {33, 4, 2, 3, 67, 23};
		simpleSelection(numbers);
		for(int i : numbers)
			System.out.print(i + "   ");
	}
	
	
}
