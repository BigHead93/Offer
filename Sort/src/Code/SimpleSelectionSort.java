package Code;

/**
 * 从n-1-i次关键字之间的比较，从n-i个记录中选出关键字最小的记录，并和第i个记录交换之。
 */
public class SimpleSelectionSort {

    public static void simpleSelection(int[] numbers) {

        if (numbers == null || numbers.length <= 1)
            return;

        int min;
        for (int i = 0; i < numbers.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[min] > numbers[j]) {
                    min = j;
                }
            }
            if (i != min) {
                swap(numbers, i, min);
            }
        }
    }

    public static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] numbers = {33, 4, 2, 3, 67, 23};
        simpleSelection(numbers);
        for (int i : numbers)
            System.out.print(i + "   ");
    }


}
