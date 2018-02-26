package Code;

public class test {
	protected int a = 5;
	public int b = 5;
	int c = 5;
	public static void main(String[] args) {

		Child c = new Child();
		System.out.println(c.a);
	}

	void prints() {
		System.out.print("package");
	}

}

class Child extends Father {
	int a = 3;
	protected int b = 5;
	static {
		System.out.println("child STATIC");
	}
	{
		System.out.println("child initialization");
	}
	Child() {
		System.out.println("child constructor");
	}
}

class Father {
	int a = 2;
	static {
		System.out.println("FATHER STATIC");
	}
	{
		System.out.println("father initialization");
	}

	Father() {
		System.out.println("father constructor");
	}
}

class Ext {
	Ext() {
		System.out.println("Ext constructor");
	}
}