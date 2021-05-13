package jamie.example.io.nio.buffer;

import java.nio.ByteBuffer;

/**
 * 创建 Buffer demo
 * @author jamie
 */
public class CreateBufferDemo {

    public static void main(String[] args) {
        //1.创建一个指定长度的缓冲区, 以ByteBuffer为例
        ByteBuffer byteBuffer = ByteBuffer.allocate(5);
        for(int i = 0; i < 5; i++){
            System.out.println(byteBuffer.get());
        }
        //在此调用会报错
        // System.out.println(byteBuffer.get());
        System.out.println("-------------");
        //2.创建一个有内容的缓冲区
        ByteBuffer wrap = ByteBuffer.wrap("jamie".getBytes());
        for(int i = 0; i < 5; i++){
            System.out.println(wrap.get());
        }
        // System.out.println(wrap.get());
    }

}
