package code;

import java.util.ArrayList;

public class lc06 {
	public String convert(String s, int numRows) {
		if(s == null || s.length() <= numRows) return s;
		StringBuilder res = new StringBuilder("");
		StringBuilder[] strs = new StringBuilder[numRows];
		for(StringBuilder str: strs) str = new StringBuilder("");
		int j = 1;
		for(int i = 0; i < s.length(); i++) {
			while(j < numRows-1) {
				strs[j].append(Character.toString(s.charAt(i)));
				j++;
			};
			while(j > 0) {
				strs[j].append(Character.toString(s.charAt(i)));
				j--;
			}
		}
		for(StringBuilder sub : strs) {
			res.append(sub);
		}
		return res.toString();
	}

	public static void main(String[] args) {
		lc06 test = new lc06();
		String str = test.convert("PAYPALISHIRING", 3);
		System.out.println(str);
		
	}

}
