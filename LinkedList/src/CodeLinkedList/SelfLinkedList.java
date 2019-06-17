package CodeLinkedList;

import java.util.*;
/**
 * 无头结点的线性表链式存储结构实现
 * @author I317032
 *
 */
public class SelfLinkedList implements List {

	private int size = 0;
	private Node header = null;

	public SelfLinkedList(){
		this.header = new Node();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	public void add(Object obj) throws Exception{
		if(size == 0){
			header.setElement(obj);
		}else{
			Node newNode = new Node(obj);
			Node last = (Node) get(size - 1);
			last.setNext(newNode);
		}
	}

	@Override
	public void insert(int index, Object obj) throws Exception {
		Node newNode = new Node(obj);
		Node preNode = (Node) get(index-1);
		newNode.setNext(preNode.getNext());
		preNode.setNext(newNode);
		size++;
	}

	@Override
	public void delete(int index) throws Exception {
		// TODO Auto-generated method stub
		Node preNode = (Node)get(index-1);
		preNode.setNext(preNode.getNext().getNext());
		size--;
	}

	@Override
	public Object get(int index) throws Exception {  //index从0开始
		if(index < 0 || index >= size){
			throw new Exception("索引有误");
		}
		Node tem = new Node();
		tem = header;
		int count = 0;
		while(count != index){
			tem = tem.getNext();
			count++;

		}
		return tem;
	}

}
