package code;

public class MT2 implements Runnable {

    static volatile int incr = 0;

    synchronized void increase() {
        incr++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            increase();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new MT2());
            thread.start();
        }
        System.out.println(MT2.incr);
    }
}
