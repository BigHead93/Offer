package code;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelDemo {

    public static void main(String[] args) {
        try {
            SocketChannel channel = SocketChannel.open();
            channel.connect(new InetSocketAddress("http://demo.com", 80));

            ByteBuffer buffer = ByteBuffer.allocate(48);
            int bytesRead = channel.read(buffer);
            channel.close();

            channel.configureBlocking(false); //非阻塞模式，可以异步调用connect，read，write
            channel.connect(new InetSocketAddress("http://demo.com", 80));
            while (!channel.finishConnect()) {
                //wait, or do something else
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
