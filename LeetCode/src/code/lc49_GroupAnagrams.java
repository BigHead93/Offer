package code;

import jdk.nashorn.internal.parser.JSONParser;

import java.util.*;

public class lc49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] inputs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        lc49_GroupAnagrams test = new lc49_GroupAnagrams();
        List<List<String>> result = test.groupAnagrams(inputs);
        for(List list: result) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
