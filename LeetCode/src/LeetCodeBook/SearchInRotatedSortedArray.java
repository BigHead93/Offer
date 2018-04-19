package LeetCodeBook;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int[] array = {1,3};
		int target = 2;
		SearchInRotatedSortedArray test = new SearchInRotatedSortedArray();
		int index = test.Search(array, target);
		System.out.print(index);

	}
	
	public int Search(int[] nums, int target) {
		if(nums == null || nums.length == 0)
			return -1;
		int start = 0, end = nums.length -1;
		int mid = 0;
		while(start != end) {
			mid = start + (end - start)/2;
			if(nums[mid] == target)
				return mid;
			if(target >= nums[start]) {
				if(nums[mid] >= nums[start] && nums[mid] < target)
					start = mid + 1;
				else
					end = mid;
			}else {
				if(nums[mid] <= nums[end] && nums[mid] > target)
					end = mid - 1;
				else
					start = mid;
			}
		}
		if(nums[start] == target)
			return start;
		return -1;
	}
	

}
