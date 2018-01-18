package code;
//import code.List;
public class SequenceList implements List {
	final int defaultSize = 10;  //如果不提供初始化数组的长度，则使用此长度f
	int maxSize;   //数组长度
	int size;      //线性表的长度
	Object[] listArray;
	
	public SequenceList(){
		init(defaultSize);
	}
	
	public SequenceList(int size){
		init(size);
	}
	
	private void init(int size){
		maxSize = size;
		this.size = 0;
		listArray = new Object[size];
		
	}
	
	public void delete(int index) throws Exception{
		if(isEmpty()){
			throw new Exception("顺序表为空，无法删除");
		}
		if(index < 0 || index > size - 1){
			throw new Exception("参数错误");
		}
		for(int i = index; i < size - 1; i++){
			listArray[i] = listArray[i + 1];
		}
		size--;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public Object get(int index) throws Exception{
		if(index < 0 || index >= size){
			throw new Exception("参数错误");
		}
		return listArray[index];
	}
	
	public void insert(int index, Object obj) throws Exception{
		if(size == maxSize){
			throw new Exception("顺序表已满，无法插入");
		}
		if(index < 0 || index > size){
			throw new Exception("参数错误");
		}
		for(int i = size - 1; i >= index; i--){
			listArray[i+1] = listArray[i];
		}
		listArray[index] = obj;
		size++;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
}
