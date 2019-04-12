package code;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCount {
    private int i = 0;
    private AtomicInteger acomicI = new AtomicInteger(0);

    public static void main(String[] args) {
        List<Thread> threadList = new ArrayList<>();
        AtomicCount test = new AtomicCount();
        for(int i = 0; i < 50000; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    test.count();
                    test.actomic();
                }
            });
            threadList.add(thread);
        }
        for(Thread t : threadList)
            t.start();
        for(Thread t : threadList) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(test.i);
        System.out.println(test.acomicI.get());
    }

    public void count() {
        i++;
    }

    public void actomic() {
        while (true) {
            int i = acomicI.get();
            boolean suc = acomicI.compareAndSet(i, i + 1);
            if(suc)
                break;
        }

    }
}
