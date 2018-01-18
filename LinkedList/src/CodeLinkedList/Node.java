package CodeLinkedList;

public class Node {
	private Object element;
	private Node next;
	
	public Node(){}
	
	public Node(Object obj){
		this.element = obj;
	}
	
	public Node(Object obj, Node next){
		this.element = obj;
		this.next = next;
	}
	
	public Object getElement() {
		return element;
	}
	public void setElement(Object element) {
		this.element = element;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	public String toString(){
		return this.element.toString();
	}
	
}
