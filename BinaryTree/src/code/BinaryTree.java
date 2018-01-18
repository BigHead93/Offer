package code;
import java.util.Stack;


/**
 * @version 完全二叉树相关操作
 * @author I317032
 *	
 */
public class BinaryTree {
	
	static class Node {
		String data;
		Node left;
		Node right;
		
		Node(String data, Node left, Node right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	/**
	 * 通过数组构造一个完全二叉树， 从index开始
	 * @param array
	 * @param index
	 * @return
	 */
	static Node createBinaryTree(String[] array, int index){
		Node node = null;
		
		if(index < array.length){
			node = new Node(array[index], null, null);
			node.left = createBinaryTree(array, index * 2 + 1);
			node.right = createBinaryTree(array, index * 2 + 2);
		}
		
		return node;
	}
	
	/**
	 * 前序遍历
	 * @param node
	 */
	static void preOrder(Node node){
		if(node == null){
			return;
		}
		System.out.print(node.data + ", ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	/**
	 * 中序遍历
	 * @param node
	 */
	static void inOrder(Node node){
		if(node == null){
			return;
		}
		inOrder(node.left);
		System.out.print(node.data + ", ");
		inOrder(node.right);
	}
	
	/**
	 * 后序遍历
	 * @param node
	 */
	static void postOrder(Node node){
		if(node == null){
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + ", ");
	}
	
	/**
	 * 非递归的前序遍历实现
	 * @param node
	 */
	static void iterativePreOrder(Node node){
		Stack<Node> nodeStack = new Stack<Node>();
		nodeStack.push(node);
		
		while(!nodeStack.isEmpty()){
			Node currentNode = nodeStack.pop();
			System.out.print(currentNode.data + ", ");

			if(currentNode.right != null){
				nodeStack.push(currentNode.right);
			}
			
			if(currentNode.left != null){
				nodeStack.push(currentNode.left);
			}
		}
	}
	
	/**
	 * 非递归的中序遍历实现
	 * @param node
	 */
	static void iterativeInOrder(Node node){
		Stack<Node> nodeStack = new Stack<Node>();
		
		while(node != null){
			nodeStack.add(node);
			while(node.left != null){
				node = node.left;
				nodeStack.add(node);
			}
			
			while(node.right == null && !nodeStack.isEmpty()){
				node = nodeStack.pop();
				System.out.print(node.data + ", ");
			}
			
			if(node != null){
				node = node.right;
			}
		}
	}
	
	/**
	 * 非递归的后序遍历
	 * @param node
	 */
	static void iterativePostOrder(Node node){
		Stack<Node> nodeStack = new Stack<Node>();
		
		Node preNode = null;  //记录上一个处理过的节点
		
		while(true){
			//当前节点的左子树放入栈中
			while(node.left != null){
				nodeStack.add(node);
				node = node.left;
			}
			
			while(node.right == null || preNode == node.right){
				System.out.print(node.data + ", ");
				preNode = node;
				if(nodeStack.isEmpty()){ //终止条件
					return;
				}
				node = nodeStack.pop();
			}	
				
			//处理右节点
			nodeStack.add(node);
			node = node.right;
		}
	}
	
	public static void main(String[] args){
		String[] array = {"A", "B", "C", "D", "E", "F", "G", "H"};
		Node root = createBinaryTree(array, 0);
				
		System.out.println("\n==========非递归实现前序遍历结果===============");
		iterativePreOrder(root);
		
		System.out.println("\n==========非递归实现中序遍历结果===============");
		iterativeInOrder(root);
		
		System.out.println("\n==========非递归实现后序遍历结果===============");
		iterativePostOrder(root);
		
		System.out.println("\n==========递归实现前序遍历结果===============");
		preOrder(root);
		
		System.out.println("\n==========递归实现中序遍历结果===============");
		inOrder(root);
		
		System.out.println("\n==========递归实现后序遍历结果===============");
		postOrder(root);
	}
}