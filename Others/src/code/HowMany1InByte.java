package code;

/**
 * 求一个整数转换成二进制后的数字"1"的个数
 * 2的n次方(x)，二进制是1个1+n个0， x & (x - 1) == 0
 * 引申：如何判断一个数是不是2的n次方：判断x & (x - 1) == 0
 */
public class HowMany1InByte {
    public int get1CountInByte(int i) {
        int count = 0;
        while(i != 0) {
            i = i & (i-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
//        int i = 13864;
//        System.out.println(Integer.toBinaryString(i));
//
//        HowMany1InByte test = new HowMany1InByte();
//        System.out.println(test.get1CountInByte(i));
        System.out.println(5.5%2);
    }
}
