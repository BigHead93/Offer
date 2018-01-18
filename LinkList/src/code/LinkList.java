package code;

import code.List;
import code.Node;

/**
 * 线性表的链式存储结构。有头节点，第一个节点的index为0.
 *
 */
public class LinkList implements List {
	Node head;
	Node current;
	int size;
	
	//初始化一个空链表
	public LinkList(){
		this.head = current = new Node(null);
		this.size = 0;
	}
	
	//定位函数，让current定位到要操作结点的前一个结点。 
	public void index(int index) throws Exception{
		if(index < -1 || index > size - 1){
			throw new Exception("参数错误！");
		}
		//说明在头节点之后操作
		if(index == -1){  //因为第一个数据元素结点的下标是0，那么头结点的下标自然就是-1了
			return;
		}
		current = head.next;
		int j = 0;
		while(current != null && j < index){
			current = current.next;
			j++;
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {		
		return size == 0;
	}

	@Override
	public void insert(int index, Object obj) throws Exception {   //index从0开始
		if(index < 0 || index > size){
			throw new Exception("参数非法");
		}
		index(index - 1);
		current.setNext(new Node(obj,current.next));
		size++;
	}

	@Override
	public void delete(int index) throws Exception {
		
		if(isEmpty()){
			throw new Exception("链表为空，无法删除");
		}
		if(index < 0 || index > size){
			throw new Exception("参数错误");
		}
		index(index - 1);
		current.setNext(current.next.next);
		size--;
	}

	@Override
	public Object get(int index) throws Exception {
		
		if(index < 0 || index > size){
			throw new Exception("参数错误");
		}
		index(index);
		return current.getElement();
	}
	
}
