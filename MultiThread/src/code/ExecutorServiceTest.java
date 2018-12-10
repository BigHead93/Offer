package code;

import java.util.concurrent.*;

public class ExecutorServiceTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<?> task = es.submit(new MyThread());

        try {
            task.get(5, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            System.out.println("thread over time");
        } catch (ExecutionException | InterruptedException e) {
            System.out.println("exception");
//            throw e;
        } finally {
            boolean mayInterruptIfRunning = true;
            task.cancel(mayInterruptIfRunning);
        }

    }


    private static class MyThread extends Thread {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    System.out.println("running");
                    Thread.sleep(280);
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("stop");
        }

//        public void cancel() {
//            interrupt();
//        }
    }
}