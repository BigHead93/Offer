package Code;

/**
 * 将一个记录插入到已经排好序的有序表中，得到一个新的，记录数增1的有序表
 */
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
		int[] numbers = {33, 4, 2, 3, 67, 23};
		insertSort(numbers);
		for(int i : numbers)
			System.out.print(i + "   ");
	}

}
