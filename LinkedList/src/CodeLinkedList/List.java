package CodeLinkedList;

public interface List {
	public int size();
	
	public boolean isEmpty();
	
	public void insert(int index, Object obj) throws Exception;
	
	public void delete(int index) throws Exception;
	
	public Object get(int index) throws Exception;
}
