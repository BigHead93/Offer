package code;

public class Node {
	Object Element; //数据域
	Node next;      //指针域
	
	//头结点的构造方法
	public Node(Node nextval){
		this.next = nextval;
	}
	
	//非头结点的构造方法
	public Node(Object obj, Node nextval){
		this.Element = obj;
		this.next = nextval;
	}
	
	//获得当前结点的指针域
	public Node getNext(){
		return this.next;
	}
	
	//获得当前结点的数据域
	public Object getElement(){
		return this.Element;
	}
	
	//设置当前结点的指针域
	public void setNext(Node nextval){
		this.next = nextval;
	}
	
	//设置当前结点的数据域
	public void setElement(Object obj){
		this.Element = obj;
	}
	
	public String toString(){
		return this.Element.toString();
	}
}
