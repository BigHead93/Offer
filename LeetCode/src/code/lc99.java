package code;

import java.util.ArrayList;
import java.util.List;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * <p>
 * Recover the tree without changing its structure.
 */
public class lc99 {
    static List<TreeNode> nodes = new ArrayList<>(2);

    public void recoverTree(TreeNode root) {
        inOrder(root);
        List<TreeNode> wrongNodes = new ArrayList<>();
        boolean flag = true;
        for(int i = 0; (i < nodes.size() - 1) &&  wrongNodes.size() < 3; i++) {
            if(nodes.get(i).val > nodes.get(i+1).val) {
                wrongNodes.add(nodes.get(i));
                wrongNodes.add(nodes.get(i+1));
            }
        }
        int p1 = 0;
        int p2 = wrongNodes.size() == 2 ? 1 : 3;
        wrongNodes.get(p1).val = wrongNodes.get(p1).val + wrongNodes.get(p2).val;
        wrongNodes.get(p2).val = wrongNodes.get(p1).val - wrongNodes.get(p2).val;
        wrongNodes.get(p1).val = wrongNodes.get(p1).val - wrongNodes.get(p2).val;
    }

    public void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        nodes.add(root);
        inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(3);
        node0.left = new TreeNode(1);
        node0.right = new TreeNode(4);
        node0.right.left = new TreeNode(2);
        lc99 test = new lc99();
        test.recoverTree(node0);
        System.out.println(nodes);
    }
}
