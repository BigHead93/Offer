package code;

import java.util.concurrent.TimeUnit;

public class InterruptedDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");

        sleepThread.setDaemon(true);
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();

        TimeUnit.SECONDS.sleep(5);

        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("SleepThread is : " + sleepThread.isInterrupted());
        System.out.println("BusyThread is : " + busyThread.isInterrupted());

        TimeUnit.SECONDS.sleep(5);
    }

    static class SleepRunner implements Runnable {

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class BusyRunner implements Runnable {

        @Override
        public void run() {
            while (true) {

            }
        }
    }
}