package code;

public class TestStudents {

	public static void main(String[] args) {
		
		SequenceList list = new SequenceList(100);
		
		try{
			list.insert(list.size, new Students("S0001", "SUSAN", "MALE", 22));
			list.insert(list.size, new Students("S0002", "TOMMY", "MALE", 20));
			list.insert(list.size, new Students("S0003", "LILYI", "FEMA", 18));
			
			for(int i = 0; i < list.size; i++){
				System.out.println(list.get(i));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
