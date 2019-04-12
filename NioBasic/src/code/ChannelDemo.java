package code;

import sun.tools.tree.ByteExpression;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelDemo {

    public static void main(String[] args) {
//        try {
//            RandomAccessFile accessFile = new RandomAccessFile("", "rw");
//            FileChannel fileChannel = accessFile.getChannel();
//
//            ByteBuffer buffer = ByteBuffer.allocate(48);
//
//            int bytesRead = fileChannel.read(buffer);
//            while (bytesRead != -1) {
//                System.out.println("read " + bytesRead);
//                buffer.flip();
//                while(buffer.hasRemaining())
//                    System.out.println((char)buffer.get());
//                buffer.clear();
////                buffer.compact()
//                bytesRead = fileChannel.read(buffer);
//            }
//            accessFile.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            RandomAccessFile file = new RandomAccessFile("", "rw");
            FileChannel channel = file.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(48);

            int bytesRead = channel.read(buffer);
            if(bytesRead != -1) {
                buffer.flip();
                if(buffer.hasRemaining()) {
                    System.out.println((char) buffer.get());
                }
                buffer.clear();
                bytesRead = channel.read(buffer);
            }

            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
