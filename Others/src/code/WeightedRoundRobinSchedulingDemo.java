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

    public int greaterCommonDivisor(int a, int b) {
        if (a % b == 0)
            return b;
        else
            return greaterCommonDivisor(b, a % b);
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
            if(currentIndex == 0) {
                currentIndex -= gcdWeight;
                if(currentIndex <= 0) {
                    currentIndex = maxWeight;
                    if(currentIndex == 0)
                        return null;
                }
            }
            if(servers.get(currentIndex).getWeight() >= currentWeight) {
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

