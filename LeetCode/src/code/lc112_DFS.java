package code;


import utils.TreeNode;

/**
 * Given a binary tree and a sum,
 * determine if the tree has a root-to-leaf path such
 * that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 */
public class lc112_DFS {

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        sum -= root.val;
        if(root.left == null && root.right == null) {
            return sum == 0;

        } else {
            return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
        }
    }
}

