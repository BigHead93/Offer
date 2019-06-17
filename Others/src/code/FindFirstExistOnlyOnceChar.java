package code;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindFirstExistOnlyOnceChar {

    public int find(char[] str) {
        if (str == null || str.length == 0)
            return -1;
        Map<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            if (map.containsKey(str[i])) {
                if (map.get(str[i])) {
                    map.put(str[i], false);
                }
            } else
                map.put(str[i], true);
        }
        for (int i = 0; i < str.length; i++) {
            if (map.get(str[i]))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FindFirstExistOnlyOnceChar test = new FindFirstExistOnlyOnceChar();
        String str = "abcdabde";
        int i = test.find(str.toCharArray());
        System.out.println(str.charAt(i));
    }

}
