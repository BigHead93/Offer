package code;

/**
 * 突破点，BST中序遍历的时候是一个递增数组
 */
public class lc98_ValidBinarySearchTree {
    long min = Long.MIN_VALUE;
    boolean flag = true;
    public boolean isValidBST(TreeNode root) {
        checkValid(root);
        return !flag;
    }

    void checkValid(TreeNode root) {
        if(root == null)
            return;
        if(flag == false)
            return;
        checkValid(root.left);
        if(min >= root.val)
            flag = false;
        else
            min = root.val;
        checkValid(root.right);
        return;
    }
}
