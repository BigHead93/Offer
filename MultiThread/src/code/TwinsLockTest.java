package code;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class TwinsLockTest {

    public static void main(String[] args) {
        TwinsLockTest test = new TwinsLockTest();
        test.test();
    }

//    @Test
    public void test() {
        final Lock lock = new TwinsLock();
        class worker extends Thread {
            public void run() {
                while(true) {
                    lock.lock();
                    try {
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }
        for(int i = 0; i < 10; i++) {
            worker w = new worker();
            w.setDaemon(true);
            w.start();
        }
//        for(int i = 0; i < 10; i++) {
//            SleepUtils.second(1);
//            System.out.println();
//        }
    }
}

class SleepUtils {
    static void second(long timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
