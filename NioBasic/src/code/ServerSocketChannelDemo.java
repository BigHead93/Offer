package code;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocketChannelDemo {
    public static void main(String[] args) {
//        try {
//            ServerSocketChannel channel = ServerSocketChannel.open();
//            channel.socket().bind(new InetSocketAddress(9999));
//
//            while (true) {
//                SocketChannel socketChannel = channel.accept();
//                //do something with socketChannel
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        //异步非阻塞模式
        try {
            ServerSocketChannel channel = ServerSocketChannel.open();
            channel.socket().bind(new InetSocketAddress(9999));
            channel.configureBlocking(false);

            while (true) {
                SocketChannel socketChannel = channel.accept();
                if(socketChannel != null) {
                    //do something with socketChannel
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
