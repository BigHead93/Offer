package code;

import java.util.concurrent.TimeUnit;

public class MT3 implements Runnable {
    @Override
    public void run() {
        int i = 0;
        while (true) {
            i++;
//            if(i % 10000 == 0)
//                System.out.println(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread test = new Thread(new MT3());
        test.start();

        TimeUnit.SECONDS.sleep(2);

        test.interrupt();
        System.out.println("mt3 interrupted is " + test.isInterrupted());

        TimeUnit.SECONDS.sleep(2);

//        for(int i = 0; i < 10; i++) {
//            MT3 test = new MT3();
//            test.start();
//            System.out.println("id: " + test.getId() + " - "
//                            + "name: " + test.getName() + " - "
//                            + "state: " + test.getState() + " - "
//                            + "priority: " + test.getPriority());
//
//
//        }
    }


}
