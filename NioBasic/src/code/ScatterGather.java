package code;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class ScatterGather {

    public static void main(String[] args) {
        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body = ByteBuffer.allocate(1024);

        ByteBuffer[] bufferArray = {header, body};

        try {
            RandomAccessFile accessFile = new RandomAccessFile("", "rw");
            FileChannel fileChannel = accessFile.getChannel();

            fileChannel.read(bufferArray);
//            fileChannel.write(bufferArray);
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }
}
