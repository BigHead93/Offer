package code;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class TransferFromTo {

    public static void main(String[] args) {
        try {
            RandomAccessFile fromFile = new RandomAccessFile("", "rw");
            FileChannel fromChannel = fromFile.getChannel();

            RandomAccessFile toFile = new RandomAccessFile("", "rw");
            FileChannel toChannel = toFile.getChannel();

            long position = 0;
            long count = fromChannel.size();

            toChannel.transferFrom(fromChannel, position, count);
            fromChannel.transferTo(position, count, toChannel);
        } catch (IOException e) {

        }
    }
}
