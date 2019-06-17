import java.util.concurrent.TimeUnit;

public class ShutDownHookTest {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("in shut down hook");
        }));

        try {
            while (true) {
                System.out.println(System.currentTimeMillis());
                TimeUnit.SECONDS.sleep(2);
            }
        } catch (Exception e) {
            System.out.println("in catch");
        } finally {
            System.out.println("in finally");
        }
    }
}
