package code;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class lc17_LetterCombinationsOfPhoneNumber {

    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0)
            return res;
        String[] button = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = digits.charAt(i) - '0';
            while (res.peek().length() == i) {
                String t = res.remove();
                for (char s : button[i].toCharArray())
                    res.add(t + s);
            }
        }
        return res;
    }

    public List<String> letterCombinations2(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0)
            return res;
        String[] buts = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(res, new StringBuilder(), digits, buts, 0);
        return res;
    }

    public void backtrack(List<String> res, StringBuilder tmp, String digits, String[] buts, int start) {
        if(tmp.length() == digits.length()) {
            res.add(tmp.toString());
            return;
        }


        String curStr = buts[digits.charAt(start)-'0'];
        for(int i = 0; i < curStr.length(); i++) {
            tmp.append(curStr.charAt(i));
            backtrack(res, tmp, digits, buts, start+1);
            tmp.deleteCharAt(tmp.length()-1);
        }

    }

    public static void main(String[] args) {
//        String digits = "234";
//        lc17_LetterCombinationsOfPhoneNumber test = new lc17_LetterCombinationsOfPhoneNumber();
//        List<String> res = test.letterCombinations2(digits);
//        System.out.println(Arrays.toString(res.toArray()));
        BigInteger bigInteger = BigInteger.valueOf(1l);
        for(long i = 2; i <= 43; i++) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
            System.out.println(i + "  " + bigInteger.toString());
        }
    }
}
