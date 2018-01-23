package code;

public class lc05 {
	
	int start;
	int maxlen;
	
	public String longestPalindrome(String s) {
		if(s == null || s.length() == 1) return s;
		for(int i = 0; i < s.length(); i++) {
			find(s, i, i);
			find(s, i, i+1);
		}
		
		return s.substring(start, start + maxlen);
	}
	
	public void find(String s, int l, int r) {
		while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		if(maxlen < r-l-1) { 
			maxlen = r - l - 1;
			start = l + 1;
		}
	}

	public static void main(String[] args) {
		String s = "abaabd";
		lc05 test = new lc05();
		System.out.println(test.longestPalindrome(s));
	}

}
