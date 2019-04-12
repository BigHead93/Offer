package code;

import java.util.ArrayList;
import java.util.Arrays;

public class lc67_AddBinary {
    public String addBinary(String a, String b) {
        int maxLen = a.length() > b.length() ? a.length() : b.length();
        char[] result = new char[maxLen + 1];
        int i = a.length() - 1, j = b.length() - 1;
        int over = 0;
        for(; maxLen >= 0 ; i--,j--, maxLen--) {
            char ac = i >= 0 ? a.charAt(i) : '0';
            char bc = j >= 0 ? b.charAt(j) : '0';
            int sum = addBinaryChar(ac, bc);
            result[maxLen] = (sum + over)  % 2 == 0 ? '0' : '1';
            over = sum + over > 1 ? 1 : 0;
        }
        String res = new String(result);
        return res.charAt(0) == '0' ? res.substring(1) : res;
    }
    public int addBinaryChar(char c1, char c2) {
        if(c1 == '1' && c2 == '1')
            return 2;
        else if (c1 == '1' || c2 == '1')
            return 1;
        else
            return 0;
    }

    public static void main(String[] args) {
//        lc67_AddBinary test = new lc67_AddBinary();
//        System.out.println(test.addBinary("11100", "11"));
        ArrayList<String> a = new ArrayList<>();
        a.add("a");
        a.add("b");
        a.add("c");
        System.out.println(a.get(1));
    }
}
