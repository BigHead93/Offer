import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class test {
    class son {
        class grandson{
            grandson() {
                System.out.println("grandson");
            }
        }
        son(){
            System.out.println("son");
        }
    }
    public test() {
        System.out.println("test");
    }

    public static void main(String[] args) {
        test a = new test();
        test.son son = new a.son;
    }

}
