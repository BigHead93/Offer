package code;

import java.util.Arrays;

public class lc66_PlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (digits[len - 1] < 9) {
            digits[len - 1] += 1;
            return digits;
        } else {
            int over = 1;
            for (int i = len - 1; i >= 0; i--) {
                digits[i] = (digits[i] + over ) % 10;
                over = digits[i] == 0 ? 1 : 0;
                if(over == 0)
                    break;
            }
            if(over == 1) {
                int[] newDigits = new int[len+1];
                newDigits[0] = 1;
                for(int i = 0; i < len; i++) {
                    newDigits[i+1] = digits[i];
                }
                return newDigits;
            }
            return digits;
        }
    }

    public int[] plusOne2(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] == 9)
                digits[i] = 0;
            else {
                digits[i]++;
                return digits;
            }
        }
        int[] newDigits = new int[digits.length+1];
        newDigits[0] = 1;
        for(int i = 0; i < digits.length; i++) {
            newDigits[i+1] = digits[i];
        }
        return newDigits;

    }

}
