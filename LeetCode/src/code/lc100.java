package code;

import utils.TreeNode;

public class lc100 {

	public static void main(String[] args) {
		TreeNode p = new TreeNode(1);
		p.left = new TreeNode(2);
		p.left.left = new TreeNode(2);
		p.left.left.left = new TreeNode(2);
		p.right = new TreeNode(3);

		TreeNode q = new TreeNode(1);
		q.left = new TreeNode(2);
		q.left.left = new TreeNode(2);
		q.left.left.left = new TreeNode(22);
		q.right = new TreeNode(3);

		lc100 test = new lc100();
		boolean bl = test.isSameTree(p, q);
		System.out.print(bl);
	}
	

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null) return true;
	    if(p == null || q == null) return false;
	    if(p.val == q.val)
	        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	    return false;
	}
}
