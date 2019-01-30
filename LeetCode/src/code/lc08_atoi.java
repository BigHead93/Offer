package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc08_atoi {
    public int myAtoi1(String str) {
        if (str == null || str.length() == 0)
            return 0;
        boolean positive = true, isChar = false;
        int i = 0;
        long result = 0;
        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ')
                continue;
            else if (c == '-') {
                positive = false;
                ++i;
                break;
            } else if (c == '+') {
                ++i;
                break;
            } else
                break;
        }

        for (int j = i; j < Math.min(i + 11, str.length()); j++) {
            char c = str.charAt(j);
            if (c >= '0' && c <= '9')
                result = result * 10 + (c - '0');
            else {
                break;
            }
        }
        result = result * (positive ? 1 : -1);
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int) result;

    }

//    public int myAtoi2(String str) {
//        if (str == null || str.trim().length() == 0)
//            return 0;
//        int i = 0;
//        int result = 0;
//        int positive = 1;
//        for (; i < str.length(); i++) {
//            char c = str.charAt(i);
//            if (c == ' ')
//                continue;
//            else if (c == '-') {
//                positive = -1;
//                break;
//            } else if (c == '+')
//                break;
//            else if (c < '0' || c > '9')
//                return 0;
//        }
//        for (; i < str.length(); i++) {
//            char c = str.charAt(i);
//            if (c < '0' || c > '9')
//                break;
//
//            result = result * 10 + (c - '0');
//        }
//        return
//
//
//
//    }

    public static void main(String[] args) {
//        String a = "-2147483649";
//        lc08_atoi test = new lc08_atoi();
//        System.out.println(test.myAtoi1(a));

        List<Integer> fromList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            fromList.add(i);
        }
        List toList = Arrays.asList(fromList);
        toList.add(1);
//        ((ArrayList)toList.get(0)).add(1);
    }
}
