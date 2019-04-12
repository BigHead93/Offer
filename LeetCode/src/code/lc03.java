package code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lc03 {
	
//	method 1
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

	public static int lengthOfLongestSubstring2(String s) {
		if(s.length() == 0) return 0;
		int max = 0;
		Map<Character, Integer> ls = new HashMap<Character, Integer>();
		for(int i = 0, j = 0; i < s.length(); i++) {
			if(ls.containsKey(s.charAt(i))) {
				while(ls.containsKey(s.charAt(i)) && j <= ls.get(s.charAt(i))) {
					ls.remove(s.charAt(j));
					j++;
				}
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
