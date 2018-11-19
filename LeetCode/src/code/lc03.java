package code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lc03 {
//	method 1
	public static int lengthOfLongestSubstring1(String s) {
		Map<Character, Integer> ls = new HashMap<Character, Integer>();
		int maxsize = 0;
		int head = 0;
		char key;
		for (int i = 0; i < s.length(); i++) {
			key = s.charAt(i);
			if (!ls.containsKey(key)) {
				ls.put(key, i);
				if (ls.size() > maxsize)
					maxsize = ls.size();
			} else {
				if (ls.size() > maxsize) {
					maxsize = ls.size();
				}
				while (ls.containsKey(key) && head < ls.get(key)) {
					ls.remove(s.charAt(head));
					head++;
				}
				head++;
				ls.replace(key, i);
			}
		}
		return maxsize;
	}
	
//	method 2
	public static int lengthOfLongestSubstring2(String s) {
		if(s.length() == 0) return 0;
		int max = 0;
		Map<Character, Integer> ls = new HashMap<Character, Integer>();
		for(int i = 0, j = 0; i < s.length(); i++) {
			if(ls.containsKey(s.charAt(i))) {
				j = Math.max(j, ls.get(s.charAt(i))+1);
			}
			ls.put(s.charAt(i), i);
			max = Math.max(max, i-j+1);
		}
		return max;
	}

	public static int lengthOfLongestSubstring(String s) {
		int result = 0;
		Map<Character, Integer> set = new HashMap<>();
		int head = 0;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(!set.containsKey(c)) {
				result = result >= set.size() ? result : set.size();
				set.put(c, i);
			} else {
				result = result >= set.size() ? result : set.size();
//				while(set.containsKey(c) && head < set.get(c)) {
				while(head < set.get(c)) {
					set.remove(s.charAt(head));
					head++;
				}
				set.replace(c, i);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		 String s = "wsslpluuwekuaxt";
//		String s = "abbcd";
		System.out.println(lengthOfLongestSubstring(s));

	}
}
 