package code;

import java.util.ArrayList;
import java.util.List;

public class lc22 {
	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		generateOneByOne("", list, n, n);
		return list;
	}

	public void generateOneByOne(String sublist, List<String> list, int left, int right) {
		if (left > right) {
			return;
		}
		if (left > 0) {
			generateOneByOne(sublist + "(", list, left - 1, right);
		}
		if (right > 0) {
			generateOneByOne(sublist + ")", list, left, right - 1);
		}
		if (left == 0 && right == 0) {
			list.add(sublist);
			return;
		}
	}

	public static void main(String[] args) {
//		lc22 test = new lc22();
//		List<String> list = test.generateParenthesis(4);
//		for(String s : list)
//			System.out.println(s);
}
}
