package Code;

import java.lang.Thread;

public class ThreadTest {

	public static void main(String[] args) throws Exception {

		// overwrite thread run
		Thread a01 = new testtd0();
		a01.start();

		// usr runnable object
		testtd ru = new testtd();
		Thread aaa = new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(this.currentThread().getName() + "   " + i);
				}
			}

		};
		Thread bbb = new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(this.currentThread().getName() + "   " + i);
				}
			}
		};

		aaa.start();
		bbb.start();

		aaa.join();
		bbb.join();

		

	}

}

class testtd0 extends Thread {
	public void run() {
		System.out.println(this.getName());
		this.currentThread().getName();
	}
}

class testtd implements Runnable {

	int a;
	Object lock = new Object();

	public void run() {
		synchronized (lock) {
			for (int i = 0; i < 10; i++) {
				a++;
			}
		}
	}

}