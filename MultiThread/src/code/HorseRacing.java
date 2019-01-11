package code;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class HorseRacing {

    private static volatile int winners = 3;
    private static volatile int inited = 0;
    private static Object shoot = new Object();
    private List<String> winnerName = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        new HorseRacing().run();
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            Horses horse = new Horses();
            Thread t = new Thread(horse, "horse" + i);
            t.start();
        }
        while(winners != 0) {

        }
        System.out.println(winnerName.toString());
    }

    class Horses implements Runnable {
        int i = 0;

        @Override
        public void run() {

            try {
                init();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while (winners > 0 && i < 100) {
                i++;
            }
            if (winners > 0) {
                synchronized (HorseRacing.class) {
                    if (winners > 0) {
                        winners--;
                        winnerName.add(Thread.currentThread().getName());
                    }
                }
            }
        }

        public void init() throws InterruptedException {
            Thread.sleep(new Random().nextInt(100));
            synchronized (HorseRacing.class) {
                inited++;
            }
            synchronized (shoot) {
                while (inited < 10) {
                    System.out.println(Thread.currentThread().getName());
                    shoot.wait();
                }
                shoot.notifyAll();
            }
        }
    }
}
