package code;

import java.util.ArrayList;
import java.util.List;

public class lc93_RestoreIPAddress {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4)
            return res;
        backTrack(res, s, 0, 0, "");
        return res;
    }

    public void backTrack(List<String> res, String s, int start, int count, String curStr) {
        if (count == 4) {
            if (start == s.length())
                res.add(curStr.substring(0, curStr.length() - 1));
            return;
        }
        for (int i = 0; i < 3 && start + i < s.length(); i++) {
            if (i == 1 && s.charAt(start) == '0')
                return;
            else if (i == 2) {
                if (Integer.parseInt(s.substring(start, start + 3)) > 255)
                    return;
            }

            backTrack(res, s, start + i + 1, count + 1, curStr + s.substring(start, start + i + 1) + ".");
        }
    }


    public static void main(String[] args) {
        String s = "25525511135";
        lc93_RestoreIPAddress test = new lc93_RestoreIPAddress();
        List<String> ans = test.restoreIpAddresses(s);
        for (String str : ans) {
            System.out.println(str);
        }
    }
}
