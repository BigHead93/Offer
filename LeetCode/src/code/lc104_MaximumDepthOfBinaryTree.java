package code;

/**
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 */
public class lc104_MaximumDepthOfBinaryTree {

    int maxDepth = 0;
    public int maxDepth(TreeNode root) {
        findMaxinumDepth(root, maxDepth);
        return maxDepth;
    }

    public void findMaxinumDepth(TreeNode root, int length) {
        if(root == null)
            return;
        length++;
        if(root.left == null && root.right == null) {
            maxDepth = Math.max(maxDepth, length);
            return;
        }
        findMaxinumDepth(root.left, length);
        findMaxinumDepth(root.right, length);
    }
}

/**
 * 时间更长，但是代码更简洁
 */
class Solution2{
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
