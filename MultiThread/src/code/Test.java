package code;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        String[] strs = {"a", "b"};
        entity e = new entity(1, strs, Arrays.asList("c", "d"));
    }

    static class entity {
        int i;
        String[] str;
        List<String> list;

        public entity(int i, String[] str, List<String> list) {
            this.i = i;
            this.str = str;
            this.list = list;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public String[] getStr() {
            return str;
        }

        public void setStr(String[] str) {
            this.str = str;
        }

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }
    }
}
