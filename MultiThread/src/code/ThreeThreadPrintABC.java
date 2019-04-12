package code;

public class ThreeThreadPrintABC {

    private static final int countEnd = 9;
    private int countStart = 0;
    private Object monitor = new Object();

    public static void main(String[] args) {
        ThreeThreadPrintABC test = new ThreeThreadPrintABC();
        Thread ta = new Thread(test.new InnerPrint('A', 0));
        Thread tb = new Thread(test.new InnerPrint('B', 1));
        Thread tc = new Thread(test.new InnerPrint('C', 2));

        ta.start();
        tb.start();
        tc.start();

    }

    public class InnerPrint implements Runnable {

        private char c;
        private int flag;

        public InnerPrint(char c, int flag) {
            this.c = c;
            this.flag = flag;
        }

        @Override
        public void run() {
            while (countStart < countEnd) {
                synchronized (monitor) {
                    while (countStart < countEnd && countStart % 3 != flag) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if(countStart < countEnd) {
                        System.out.println(c);
                        countStart++;
                        monitor.notifyAll();
                    }
                }
            }
        }
    }
}
