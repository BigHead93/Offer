package code;

public class lc26 {
	public int removeDuplicates(int[] nums) {
		if(nums == null)
			return 0;
		int tmp = 0;
		for(int i = 1 ; i < nums.length; i++)
			if(nums[i] != nums[tmp]) {
				nums[++tmp] = nums[i];
			}
		
		return tmp+1;
	}

	public static void main(String[] args) {
		lc26 ts = new lc26();
		int[] nums = {1,1,1,2,2,3};
		ts.removeElementTwice(nums);
		for(int i : nums) 
			System.out.print(i + " ");
	}
	
	public int removeElementTwice(int[] nums) {
		if(nums.length <= 2) return nums.length;
		int index = 2;
        for(int i =  2; i < nums.length; i++){
            if(nums[i] != nums[index-2]){
                nums[index++] = nums[i];
            }
        }
        return index;
	}
}
