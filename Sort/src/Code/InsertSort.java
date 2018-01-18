package Code;

public class InsertSort {

	public static void insertSort(int[] numbers){
		
		if(numbers == null || numbers.length <= 1)
			return;
		
		int temp;
		for(int i = 1; i < numbers.length; i++){
			temp = numbers[i];
			int j;
			for(j = i-1; j >= 0; j--){
				if(numbers[j] > temp){
					numbers[j+1] = numbers[j];
				}else{
					break;
				}
			}
			numbers[j+1] = temp;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {33, 4, 2, 3, 67, 23};
		insertSort(numbers);
		for(int i : numbers)
			System.out.print(i + "   ");
	}

}
