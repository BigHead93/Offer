package code;

import java.util.Arrays;

public class MissInteger_DuplicateInteger {

    /**
     * 一个无序数组里有99个不重复正整数，范围从1到100，唯独缺少一个整数。如何找出这个缺失的整数？
     */
    public int findMissInteger(int[] array) {
        int res = array[0] ^ 1;
        for (int i = 1; i < array.length; i++) {
            res = res ^ array[i] ^ (i + 1);
        }
        return res;
    }

    /**
     * 一个无序数组里有若干个正整数，范围从1到100，其中99个整数都出现了偶数次，
     * 只有一个整数出现了奇数次（比如1,1,2,2,3,3,4,5,5），如何找到这个出现奇数次的整数
     */
    public int findExistOnceInteger(int[] array) {
        int res = array[0];
        for (int i = 1; i < array.length; i++) {
            res ^= array[i];
        }
        return res;
    }

    /**
     * 一个无序数组里有若干个正整数，范围从1到100，
     * 其中98个整数都出现了偶数次，只有两个整数出现了奇数次（比如1,1,2,2,3,4,5,5），
     * 如何找到这个出现奇数次的整数
     * 思路：设出现奇数次的数为i,j，所有数求异或，值 = i^j，求最后一个1的位置对应的数，所有的数与这个数按位与，可以将所有数分为两批，再分别求异或。
     */
    public int[] findTwoExistOnceInteger(int[] array) {
        int[] res = new int[2];
        Arrays.fill(res, -1);
        int tmp = array[0];
        for (int i = 1; i < array.length; i++) {
            tmp ^= array[i];
        }
        String byteStr = Integer.toBinaryString(tmp);
        int index = byteStr.lastIndexOf("1");
        int flag = 1 << (byteStr.length() - index - 1);
        for (int i = 0; i < array.length; i++) {
            if ((flag & array[i]) == 0)
                res[0] = res[0] == -1 ? array[i] : res[0] ^ array[i];
            else
                res[1] = res[1] == -1 ? array[i] : res[1] ^ array[i];
        }
        return res;
    }

    /**
     * 无序数组里有若干个正整数，范围从1到n，数组长度在[2,10000]
     * 其中一个数字重复，另一个数字缺失，其它数字只出现一次
     * 找到这两个数字
     * 输出顺序先重复的数字，再缺失的数字
     */
    public int[] findErrorIntegers(int[] nums) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0)
                nums[Math.abs(nums[i]) - 1] *= -1;
            else
                res[0] = Math.abs(Math.abs(nums[i]));
        }
        for (int i = 0; i < nums.length; i++)
            if (nums[i] > 0)
                res[1] = i + 1;
        return res;
    }

    public static void main(String[] args) {
        MissInteger_DuplicateInteger test = new MissInteger_DuplicateInteger();

        int[] array = {1, 2, 2, 3};
        int[] res = test.findErrorIntegers(array);

//        int[] array = {1,1,2,2,3,4,5,5};
//        int[] res = test.findTwoExistOnceInteger(array);

        System.out.println(Arrays.toString(res));
    }


}
