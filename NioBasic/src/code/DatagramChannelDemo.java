package code;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class DatagramChannelDemo {
    public static void main(String[] args) {
        try {
            DatagramChannel channel = DatagramChannel.open();
            channel.socket().bind(new InetSocketAddress(9999));

            ByteBuffer buffer = ByteBuffer.allocate(48);
            buffer.clear();
            channel.receive(buffer);

            String newData = "string to write to datagram channel..." + System.currentTimeMillis();
            buffer.clear();
            buffer.put(newData.getBytes());
            buffer.flip();
            int byteSent = channel.send(buffer, new InetSocketAddress("xxx.com", 80));


            //connect to specific address
            channel.connect(new InetSocketAddress("xxx.com", 80));
            int bytesRead = channel.read(buffer);
            int bytesWritten = channel.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
