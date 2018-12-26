package code;

/**
 * http://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html
 * Morris Traversal, 线索二叉树遍历二叉树，时间复杂度O(n),空间复杂度O(1)
 */
public class inorderMorrisTraversal {
    public void solution(TreeNode root) {
        TreeNode cur = root;
        TreeNode prev = null;

        while(cur != null) {
            if(cur.left == null) {
                System.out.println(cur.val);
                cur = cur.right;
            } else {
                prev = cur.left;
                while(prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if(prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    System.out.println(cur.val);
                    cur = cur.right;
                }
            }
        }

    }
}
