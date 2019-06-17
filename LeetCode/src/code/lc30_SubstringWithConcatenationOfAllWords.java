package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc30_SubstringWithConcatenationOfAllWords {


    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0 || s.length() < words.length * words[0].length())
            return ans;

        Map<String, Integer> map = new HashMap<>();
        for (String str : words)
            map.put(str, map.getOrDefault(str, 0) + 1);

        int len = words[0].length();
        for (int i = 0; i <= s.length() - words.length * len; i++) {
            Map<String, Integer> copy = new HashMap<>(map);
            for(int j = 0; j < words.length; j++) {
                String next = s.substring(i + j * len, i + j * len + len);
                if (copy.containsKey(next)) {
                    if (copy.get(next) == 1)
                        copy.remove(next);
                    else
                        copy.put(next, copy.get(next) - 1);
                    if(copy.size() == 0) {
                        ans.add(i);
                        break;
                    }
                } else
                    break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        lc30_SubstringWithConcatenationOfAllWords test = new lc30_SubstringWithConcatenationOfAllWords();

        String s = "barfoothefoobarman";
        String[] words = {"bar", "foo"};

        List<Integer> ans = test.findSubstring(s, words);

        for (Integer i : ans) {
            System.out.println(i);
        }

    }
}
