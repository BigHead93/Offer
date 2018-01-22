package code;

import java.util.HashMap;
import java.util.Map;

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
	public static int lengthOfLongestSubstring(String s) {
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

	public static void main(String[] args) {
		 String s = "wsslpluuwekuaxt";
//		String s = "abbcd";
		System.out.println(lengthOfLongestSubstring(s));

	}
}
 