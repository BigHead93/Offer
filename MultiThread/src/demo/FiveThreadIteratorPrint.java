package demo;

public class FiveThreadIteratorPrint {

    volatile int flag = 0;
    Object monitor = new Object();

    public static void main(String[] args) {
        FiveThreadIteratorPrint test = new FiveThreadIteratorPrint();
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>(5));
//        for (int i = 0; i < 5; i++) {
//            executor.submit(test.new sub(i));
//        }
        Thread thread1 = new Thread(test.new sub(0));
        Thread thread2 = new Thread(test.new sub(1));
        Thread thread3 = new Thread(test.new sub(2));
        Thread thread4 = new Thread(test.new sub(3));
        Thread thread5 = new Thread(test.new sub(4));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main end");
    }

    void test(){
        sub subtest = new FiveThreadIteratorPrint.sub(1);
    }

    class sub implements Runnable {

        int i;

        sub(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            while (flag < 100) {
                synchronized (monitor) {
                    while (flag % 5 != i && flag < 100) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
//                            e.printStackTrace();
                        }
                    }
                    if (flag < 100) {
                        System.out.println(i + " ~ " + flag);
                        flag++;
                        monitor.notifyAll();
                    }
                }
            }

        }
    }
}
