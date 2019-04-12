package code;

import java.io.IOException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class SelectorDemo {

    public static void main(String[] args)  {
        try {
            SocketChannel channel1 = SocketChannel.open();
            DatagramChannel channel2 = DatagramChannel.open();
            channel1.configureBlocking(false);
            channel2.configureBlocking(false);

            Selector selector = Selector.open();
            SelectionKey key1 = channel1.register(selector, SelectionKey.OP_CONNECT|SelectionKey.OP_READ|SelectionKey.OP_WRITE);
            SelectionKey key2 = channel2.register(selector, SelectionKey.OP_READ);

            while (true) {
                int readyChannels = selector.select();
                if(readyChannels == 0)
                    continue;
                Set selectedKeys = selector.selectedKeys();
                Iterator iterator = selectedKeys.iterator();
                while(iterator.hasNext()) {
                    SelectionKey key = (SelectionKey) iterator.next();
                    if(key.isAcceptable()) {

                    } else if(key.isConnectable()) {

                    } else if(key.isReadable()) {

                    } else if(key.isWritable()) {

                    }
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
