package code;

public class PowerOfInteger {

    public boolean powerOfTwo(int i) {
        return (i & (i-1)) == 0;
    }

    public boolean powerOfThree_solution1(int i) {
        if(i < 1)
            return false;

//        // solution1, O(log3n)
//        while(i % 3 == 0)
//            i /= 3;
//        return i == 1;


        //solution2, O(log3n)
//        return Integer.toString(i, 3).matches("^10*$");

        //solution3, O(1)
        return (Math.log10(i) / Math.log10(3)) % 1 == 0;
    }

    public boolean powerOfFour(int i) {
        if(i < 1)
            return false;

//        //solution 1
//        //先判断是不是2的幂
        if((i & (i-1)) != 0)
            return false;
//        while(i % 4 == 0)
//            i /= 4;
//        return i == 1;

//        //solution 2
//        return Integer.toString(i, 4).matches("^10*$");

        // solution 3
        // 100, 10000, 1000000, 4的幂总是1后跟偶数个0
        return  (Integer.toBinaryString(i).length() & 1) == 1;
    }

    public boolean test() {
        try {
            System.out.println("in try");
            throw new Exception();
        } catch (Exception e) {
            System.out.println("int catch");
            return false;
        } finally {
            System.out.println("in finally");
        }
    }

    public static void main(String[] args) {
        PowerOfInteger test = new PowerOfInteger();
//        System.out.println(test.powerOfFour(64));
        System.out.println(test.test());
    }
}
