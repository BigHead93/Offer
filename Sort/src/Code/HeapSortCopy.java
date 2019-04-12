package Code;

public class HeapSortCopy {
    //大顶堆
    public void heapSort(int[] nums){
        if(nums == null || nums.length < 2)
            return;
        for(int i = nums.length/2 -1; i >= 0; i--) {
            heapAdjust(nums, i, nums.length-1);
        }
        for(int i = nums.length-1; i >= 0;) {
            HeapSort.swap(nums, 0, i);
            heapAdjust(nums, 0, --i);
        }
    }

//    private void heapAdjust(int[] nums, int start, int end) {
//        int tmp = nums[start];
//        for(int j = 2 * start + 1; j < end; j= 2*j+1) {
//            if(nums[j] < nums[j+1])
//                j++;
//            if(tmp > nums[j])
//                break;
//            nums[start] = nums[j];
//            start = j;
//        }
//        nums[start] = tmp;
//    }

    public void heapAdjust(int[] nums, int start, int end) {
        int tmp = nums[start];
        for(int j = 2 * start + 1; j <= end; j = 2*j+1) {
            if(j < end && nums[j] < nums[j+1])
                j++;
            if(tmp > nums[j])
                break;
            nums[start] = nums[j];
            start = j;
        }
        nums[start] = tmp;
    }

    public static void main(String[] args) {
        int[] numbers = {3,1,2,4};
        HeapSortCopy test = new HeapSortCopy();
        test.heapSort(numbers);
        for(int i : numbers)
            System.out.print(i + "   ");
    }
}
