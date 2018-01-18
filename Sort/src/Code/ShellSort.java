package Code;

public class ShellSort {
	
	public static void shellSort(int[] numbers){
		int i,j,temp;
		int increment = numbers.length;
		
		if(numbers == null || numbers.length <= 1)
			return;
		
		do{
			increment = increment/3+1;
			for(i = increment; i < numbers.length; i++){
				if(numbers[i] < numbers[i-increment]){
					temp = numbers[i];
					for(j = i-increment; j>=0 && numbers[j]>temp; j-=increment){
						numbers[j+increment] = numbers[j];
					}
					numbers[j+increment] = temp;
				}
			} 
		}while(increment > 1);
	}
	public static void main(String[] args) {
		int[] numbers = {33, 4, 2, 3, 67, 23};
		shellSort(numbers);
		for(int i : numbers)
			System.out.print(i + "   ");

	}

}
