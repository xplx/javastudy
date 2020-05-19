package pers.wxp.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/4/1 10:13
 */
public class NioDemo {
    public static void main(String[] args) {
        readData();
    }

    /**
     * nio读取信息
     */
    public static void readData() {
        RandomAccessFile aFile = null;
        try {
            aFile = new RandomAccessFile("F:\\word.txt", "rw");
            FileChannel fileChannel = aFile.getChannel();
            //分配空间
            ByteBuffer buf = ByteBuffer.allocate(1024);
            //写入数据到Buffer,实际上是一个容器
            int bytesRead = fileChannel.read(buf);
            System.out.println(bytesRead);
            while (bytesRead != -1) {
                buf.flip();
                while (buf.hasRemaining()) {
                    //从Buffer中读取数据
                    System.out.print((char) buf.get());
                }
                //调用clear()方法或者compact()方法
                buf.compact();
                bytesRead = fileChannel.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (aFile != null) {
                    aFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
