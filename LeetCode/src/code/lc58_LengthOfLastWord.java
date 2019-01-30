package code;


import java.util.concurrent.locks.ReentrantLock;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p>
 * Hint: "hello world" returns 5, "hello world  " also returns 5
 */
public class lc58_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s.trim().length() == 0)
            return 0;
        if (s.lastIndexOf(" ") == s.length() - 1) {
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.substring(0, i).lastIndexOf(" ") != i) {
                    s = s.substring(0, i);
                    break;
                }
            }
        }
        return s.length() - s.lastIndexOf(" ") - 1;
    }

    public static void main(String[] args) {
        String s = "hello world";
        lc58_LengthOfLastWord test = new lc58_LengthOfLastWord();
        System.out.println(test.lengthOfLastWord(s));
    }
}
