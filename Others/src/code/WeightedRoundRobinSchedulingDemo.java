package code;

import java.util.ArrayList;
import java.util.List;

public class WeightedRoundRobinSchedulingDemo {
    private int currentIndex = -1;

    private int currentWeight = 0;

    private int maxWeight;

    private int gcdWeight;

    private int serverCount;

    private List<Server> servers = new ArrayList<>();

    // 辗转相除法，欧几里得算法，原理：两个正整数a和b（a>b），它们的最大公约数等于a除以b的余数c和b之间的最大公约数
    // 缺点：若a,b都较大的时候，取模操作a%b性能较低
//    public int greaterCommonDivisor(int a, int b) {
//        if (a % b == 0)
//            return b;
//        else
//            return greaterCommonDivisor(b, a % b);
//    }
    // 九章算术：两个正整数a和b（a>b），它们的最大公约数等于a-b的差值c和较小数b的最大公约数
    // 缺点：若b==1, a = Math.MAX_VALUE
//    public int greaterCommonDivisor(int a, int b) {
//        if (a == b)
//            return a;
//        if (a < b)
//            return greaterCommonDivisor(a, b - a);
//        else
//            return greaterCommonDivisor(b, a - b);
//
//    }
    // 优化

    /**
     * 当a和b均为偶数，gcb(a,b) = 2*gcb(a/2, b/2) = gcb(a>>1, b>>1)<<1
     * 当a为偶数，b为奇数，gcb(a,b) = gcb(a/2, b) = gcb(a>>1, b)
     * 当a为奇数，b为偶数，gcb(a,b) = gcb(a, b/2) = gcb(a, b>>1)
     * 当a和b均为奇数，利用更相减损术运算一次，gcb(a,b) = gcb(b, a-b)， 此时a-b必然是偶数，又可以继续进行移位运算。
     * @param a
     * @param b
     * @return
     */
    public int greaterCommonDivisor(int a, int b) {
        if(a == b)
            return a;
        if(a < b) //保证 a > b, 方便计算
            return greaterCommonDivisor(b, a);
        else {
            if((a&1) == 0 && (b&1) == 0)
                return greaterCommonDivisor(a >> 1, b >> 1) << 1;
            else if((a&1) == 0 && (b&1) == 1)
                return greaterCommonDivisor(a >> 1, b);
            else if((a&1) == 1 && (b&1) == 0)
                return greaterCommonDivisor(a, b >> 1);
            else
                return greaterCommonDivisor(b, a-b);
        }
    }

    public int greatestCommonDivisor(List<Server> servers) {
        int divisor = 0;
        for (int i = 0; i < servers.size(); i++) {
            if (i == 0)
                divisor = greaterCommonDivisor(servers.get(i).getWeight(), servers.get(i + 1).getWeight());
            else
                divisor = greaterCommonDivisor(divisor, servers.get(i).getWeight());
        }
        return divisor;
    }

    public int greatestWeight(List<Server> servers) {
        int greatestWeight = 0;
        for (Server server : servers) {
            if (greatestWeight < server.getWeight()) {
                greatestWeight = server.getWeight();
            }
        }
        return greatestWeight;
    }

    public Server getServer() {
        while (true) {
            currentIndex = (currentWeight + 1) % serverCount;
            if (currentIndex == 0) {
                currentIndex -= gcdWeight;
                if (currentIndex <= 0) {
                    currentIndex = maxWeight;
                    if (currentIndex == 0)
                        return null;
                }
            }
            if (servers.get(currentIndex).getWeight() >= currentWeight) {
                return servers.get(currentIndex);
            }
        }
    }

    public void init() {
        servers.add(new Server("127.0.0.1", 1));
        servers.add(new Server("127.0.0.2", 2));
        servers.add(new Server("127.0.0.6", 4));
        servers.add(new Server("127.0.0.12", 8));

        maxWeight = greatestWeight(servers);
        gcdWeight = greatestCommonDivisor(servers);
        serverCount = servers.size();
    }

//    public static void main(String[] args) {
//        WeightedRoundRobinSchedulingDemo demo = new WeightedRoundRobinSchedulingDemo();
//        demo.init();
//
//        for
//    }


}

//class Server {
//    private String ip;
//    private int weight;
//
//    public Server() {
//    }
//
//    public Server(String ip, int weight) {
//        this.ip = ip;
//        this.weight = weight;
//    }
//
//    public int getWeight() {
//        return weight;
//    }
//
//    public String getIp() {
//        return ip;
//    }
//
//    public void setIp(String ip) {
//        this.ip = ip;
//    }
//}

