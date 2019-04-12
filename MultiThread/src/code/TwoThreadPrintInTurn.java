package code;

public class TwoThreadPrintInTurn {

    private boolean flag = false;
    private int count = 1;
    private Object monitor = new Object();

    class run1 implements Runnable {

        boolean innerFlag;

        run1(boolean innerFlag) {
            this.innerFlag = innerFlag;
        }

        @Override
        public void run() {
            while (count < 100) {
                synchronized (monitor) {
                    while (flag != innerFlag && count < 100) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (count < 100) {
                        System.out.println(Thread.currentThread().getName() + "  " + count);
                        flag = flag ^ true;
                        count++;
                        monitor.notify();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        TwoThreadPrintInTurn test = new TwoThreadPrintInTurn();
        Thread t1 = new Thread(test.new run1(true), "Thread-1");
        Thread t2 = new Thread(test.new run1(false), "Thread-2");
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("finish");
    }
}
