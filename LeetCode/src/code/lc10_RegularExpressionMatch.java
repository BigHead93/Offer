package code;

public class lc10_RegularExpressionMatch {
    public boolean isMatch(String s, String p) {
        return match(s, p, 0, 0);
    }

    public boolean match(String s, String p, int ss, int ps) {
        if (ss == s.length() && ps == p.length())
            return true;
        if (ss == s.length() || ps == p.length())
            return false;

        if (ps < p.length() - 1 && p.charAt(ps + 1) == '*') {
            if (p.charAt(ps) == '.') {
                if (ps == p.length() - 2)
                    return true;
                else {
                    boolean res = false;
                    ps = ps + 2;
                    while (!res && ss < s.length()) {
                        if (s.charAt(ss) == p.charAt(ps))
                            res = match(s, p, ss, ps);
                        ss++;
                    }
                    return res;
                }
            } else {
                boolean res = match(s, p, ss, ps + 2);
                if (res || s.charAt(ss) != p.charAt(ps))
                    return res;
                do {
                    res = res || match(s, p, ss + 1, ps + 2);
                    ss++;
                } while (!res && ss < s.length() && s.charAt(ss) == p.charAt(ps));
                return res;
            }
        } else if (p.charAt(ps) == '.')
            return match(s, p, ss + 1, ps + 1);
        else if (p.charAt(ps) == '*')
            return false;
        else {
            if (s.charAt(ss) == p.charAt(ps))
                return match(s, p, ss + 1, ps + 1);
            return false;
        }
    }


    public static void main(String[] args) {
        lc10_RegularExpressionMatch test = new lc10_RegularExpressionMatch();
        boolean res = test.isMatch("a", "ab*");
        System.out.println(res);
    }
}
