package Code;

public class Au22_Last_k_in_Linklist {
	
	public static class Node{
		public int element;
		public Node next;
		
		public Node(int element){
			this.element = element;
			this.next = null;
		}
		
		public Node(int element, Node next){
			this.element = element;
			this.next = next;
		}
		
		public int getElement(){
			return this.element;
		}
		
		public Node getNext(){
			return this.next;
		}
		
		public void setElement(int element){
			this.element = element;
		}
		
		public void setNext(Node next){
			this.next = next;
		}
		
		public String toString(){
			return Integer.toString(this.element);
		}
	}
	
	public static Node findKToTail(Node head, int k){
		if(head == null){
			System.out.print("empty linklist");
			return null;
		}
		
		if(k <= 0){
			System.out.print("wrong k");
			return null;
		}
		Node last = head;
		Node kth;
		
		for(int i = 1; i <= k-1; i++){
			last = last.next;
			if(last == null){
				System.out.println("short length");
				return null;
			}
		}
		kth = head;
		while(last.next != null){
			last = last.next;
			kth = kth.next;
		}
		return kth;
	}
	public static void main(String[] args) {
		Node head = new Node(1);
		head.setNext(new Node(2));
		
		Node kth = findKToTail(head, 3);
		if(kth != null)
			System.out.print(kth);

	}
	
}
