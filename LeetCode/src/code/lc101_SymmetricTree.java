//package code;
//
//import java.util.Stack;
//
//public class lc101_SymmetricTree {
//    Stack<TreeNode> tree = new Stack<>();
//
//    public boolean isSymmetric(TreeNode root) {
//        if((root.left == null) != (root.right == null) )
//            return false;
//        leftTreePushStack(root.left);
//        return rightTreePopStack(root.right);
//    }
//
//    public void leftTreePushStack(TreeNode root) {
//        if (root == null)
//            return;
//        leftTreePushStack(root.left);
//        tree.push(root);
//        leftTreePushStack(root.right);
//    }
//    public boolean rightTreePopStack(TreeNode root) {
//        if((root == null) != tree.isEmpty())
//            return false;
//        rightTreePopStack(root.left);
//        if(tree.pop().val != root.val)
//            return false;
//        rightTreePopStack(root.right);
//    }
//}
