package code;

import java.util.*;

public class lc102_BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> tnodes = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        tnodes.add(root);
        traverse(tnodes, res);
        return res;
    }

    private void traverse(Queue<TreeNode> queue, List<List<Integer>> res) {
        int size = queue.size();
        List<Integer> list = new ArrayList<>();
        while(size-- > 0) {
            TreeNode tmp = queue.remove();
            list.add(tmp.val);
            if(tmp.left != null)
                queue.add(tmp.left);
            if(tmp.right != null)
                queue.add(tmp.right);
        }
        res.add(list);
        if(!queue.isEmpty())
            traverse(queue, res);
    }
}
