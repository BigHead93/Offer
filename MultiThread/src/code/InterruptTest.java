package code;

public class InterruptTest {

    public static void main(String[] args) {
        InterruptTest test = new InterruptTest();
        test.start();
    }

    public void start() {
        MyThread myThread = new MyThread();
        myThread.start();

        try {
            Thread.sleep(3000);
            myThread.cancel();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class MyThread extends Thread {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println("running");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("stop");
    }

    public void cancel() {
        interrupt();
    }
}
