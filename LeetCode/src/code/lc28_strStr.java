package code;

/**
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class lc28_strStr {
    public int strSt1(String haystack, String needle) {
        if(needle.length() == 0)
            return 0;
        if(haystack.length() < needle.length())
            return -1;
        int i = 0, j = 0;
        for(; i < haystack.length() && j < needle.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                j++;
            } else {
                i = i - j;
                j = 0;
            }
        }
        return j == needle.length() ? i - j : -1;
    }

    public int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int strStr3(String haystack, String needle) {
        if(!haystack.contains(needle)) {
            return -1;
        }
        for(int i = 0; i <= haystack.length(); i++) {
            if(haystack.substring(0, i).contains(needle))
                return i - needle.length();
        }
        return 0;
    }


    public static void main(String[] args) {
        String haystack = "aaaab";
        String needle = "b";
        lc28_strStr test = new lc28_strStr();
        int result = test.strStr3(haystack, needle);
        System.out.println(result);
    }
}
