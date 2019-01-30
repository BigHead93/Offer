package code;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {

    private static final int WINNER_AMOUNT = 3;
    private static final int PLAYER_AMOUNT = 5;

    public CountDownLatchDemo() {
    }

    public static void main(String[] args) {
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(WINNER_AMOUNT);

        Player[] players = new Player[PLAYER_AMOUNT];

        for(int i = 0; i < players.length; i++)
            players[i] = new Player(i+1, begin, end);

        ExecutorService exe = Executors.newFixedThreadPool(PLAYER_AMOUNT);
        for(Player player: players)
            exe.execute(player);

        System.out.println("Race begins!");

        begin.countDown();

        try {
            end.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Race ends!");
        }
        exe.shutdownNow();
    }

    static class Player implements Runnable{
        private int id;
        private CountDownLatch begin;
        private CountDownLatch end;

        public Player(int id, CountDownLatch begin, CountDownLatch end) {
            this.id = id;
            this.begin = begin;
            this.end = end;
        }

        @Override
        public void run() {
            try {
                begin.await();
                Thread.sleep((long)(Math.random()*100)*100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Player " + id + " end");
                end.countDown();
            }
        }
    }

}
