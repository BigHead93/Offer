package code;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileChannelDemo {

    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile("demo", "rw");
            FileChannel channel = file.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(50);
            int bytes = channel.read(buffer);
            while (bytes != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());
                }
                buffer.clear();
                bytes = channel.read(buffer);
            }
            System.out.println();
            channel = channel.truncate(10);
            bytes = channel.read(buffer);
            while (bytes != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    System.out.println((char) buffer.get());
                }
                buffer.clear();
                bytes = channel.read(buffer);
            }

//            String str = "hello nio, hello filechannellllllllll";
//            buffer.put(str.getBytes());
//            buffer.flip();
//
//            while (buffer.hasRemaining()) {
//                long position = channel.position();
//                long fileSize = channel.size();
//                channel.write(buffer, fileSize);
//            }
            channel.close();

            Path path = Paths.get("");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
