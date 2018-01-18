package code;

public class TestSequenceList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SequenceList list = new SequenceList(20);
		
		try{
			list.insert(0, 50);
			list.insert(0, 20);
			list.insert(1, 44);
			
			for(int i = 0; i < list.size; i++){
				System.out.println(i + " : " + list.get(i));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
