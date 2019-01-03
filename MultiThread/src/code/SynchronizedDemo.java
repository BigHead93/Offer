package code;

public class SynchronizedDemo {
    public static void main(String[] args) {
        synchronized(SynchronizedDemo.class) {

        }
        m();
    }

    public static synchronized void m () {

    }
}
