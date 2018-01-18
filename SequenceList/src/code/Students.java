package code;

public final class Students {
	private String id;
	private String name;
	private String gender;
	private int age;
	
	public Students(){}
	
	public Students(String id, String name, String gender, int age){
		this.id = id;
		this.setName(name);
		this.setGender(gender);
		this.setAge(age);
	}
	
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString(){
		return "id: " + this.getId() + " name: " + this.getName() + " gender: " + this.getGender() + " age: " + this.getAge() ;
	}
	
}
