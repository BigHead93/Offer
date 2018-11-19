package code;

public class MT1 {
    public volatile int inc = 0;
    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final MT1 test = new MT1();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<100;j++)
                        test.increase();
                };
            }.start();
        }

        if(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);
    }


}
