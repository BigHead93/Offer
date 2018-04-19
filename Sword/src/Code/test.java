package Code;

import java.util.Vector;

public class test {
	protected int a = 5;
	public int b = 5;
	public static int d = 4;
	int c = 5;
	{
		System.out.println("initial part");
	}
	static {
		System.out.println("static part");
	}
	public static void main(String[] args) {

		System.out.print(test.d);
		String a = "aaa";
		test ts = new test();
		ts.change(ts);
		System.out.println();
		System.out.println("t.b :    " + ts.b);
	}
	public void change(test t) {
		t = new test();
		t.b = 10;
	}

	void prints() {
		int a;
		final int b;
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
	static int b = 3;
	protected int c = 4;
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