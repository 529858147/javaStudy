package com.how2j.io.ioStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/28 21:07
 */
public class NIODemo {
    public static void main(String[] args) throws IOException {
        channelDemo();
    }

    //使用Charset定制输入的字符集格式,不然会乱码，当没有读取完中文的全部3个字节也会导致乱码
    public static void channelDemo() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:/text.txt");
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(2);
        while (channel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            System.out.println(Charset.forName("UTF-8").decode(byteBuffer));
            byteBuffer.clear();//清空当前buffer，使得position为0，这样能够让未读取的byte进入缓冲区
        }
        //另一种形式实现channel，StandardOpenOption表示对文件进行读或者是写的枚举类，还有一个入参为FileAttribute
        FileChannel fileChannel = FileChannel.open(Paths.get("D:/text.txt"), StandardOpenOption.READ, StandardOpenOption.WRITE);
        /*第二种创建方式PosixFilePermission指定了被创建文件的读写权限，不适用与Windows系统，StandardOpenOption则指定了通道的读写权限
        HashSet<PosixFilePermission> filePermissionSet = new HashSet<>();
        filePermissionSet.add(PosixFilePermission.OWNER_READ);
        filePermissionSet.add(PosixFilePermission.GROUP_WRITE);
        HashSet<StandardOpenOption> openOptionSet = new HashSet<>();
        openOptionSet.add(StandardOpenOption.READ);
        openOptionSet.add(StandardOpenOption.WRITE);
        FileChannel.open(Paths.get("D:/text.txt"), openOptionSet, PosixFilePermissions.asFileAttribute(filePermissionSet));
        */
        ByteBuffer buffer = ByteBuffer.wrap(new byte[3]);
        while (fileChannel.read(buffer) != -1) {
            buffer.flip();
            System.out.println(Charset.forName("UTF-8").decode(buffer));
            buffer.clear();
        }
    }
}
