package jamie.example.io.nio;

import java.nio.ByteBuffer;

/**
 * 添加缓冲区
 * @author jamie
 */
public class PutBufferDemo {

    public static void main(String[] args) {
        //1.创建一个指定长度的缓冲区, 以ByteBuffer为例
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        //0 获取当前索引所在位置
        System.out.println(byteBuffer.position());
        //10 最多能操作到哪个索引
        System.out.println(byteBuffer.limit());
        //10 返回缓冲区总长度
        System.out.println(byteBuffer.capacity());
        //10 还有多少个能操作
        System.out.println(byteBuffer.remaining());

        //        //修改当前索引位置
        //        byteBuffer.position(1);
        //        //修改最多能操作到哪个索引位置
        //        byteBuffer.limit(9);
        //        //1 获取当前索引所在位置
        //        System.out.println(byteBuffer.position());
        //        //9 最多能操作到哪个索引
        //        System.out.println(byteBuffer.limit());
        //        //10 返回缓冲区总长度
        //        System.out.println(byteBuffer.capacity());
        //        //8 还有多少个能操作
        //        System.out.println(byteBuffer.remaining());

        System.out.println("----添加一个字节----");
        //添加一个字节
        byteBuffer.put((byte)97);
        //1 获取当前索引所在位置
        System.out.println(byteBuffer.position());
        //10 最多能操作到哪个索引
        System.out.println(byteBuffer.limit());
        //10 返回缓冲区总长度
        System.out.println(byteBuffer.capacity());
        //9 还有多少个能操作
        System.out.println(byteBuffer.remaining());

        System.out.println("----添加一个字节数组:abc----");
        //添加一个字节数组
        byteBuffer.put("abc".getBytes());
        //4 获取当前索引所在位置
        System.out.println(byteBuffer.position());
        //10 最多能操作到哪个索引
        System.out.println(byteBuffer.limit());
        //10 返回缓冲区总长度
        System.out.println(byteBuffer.capacity());
        //6 还有多少个能操作
        System.out.println(byteBuffer.remaining());

        System.out.println("----当添加超过缓冲区的长度时会报错----");
        //当添加超过缓冲区的长度时会报错
        byteBuffer.put("012345".getBytes());
        //10 获取当前索引所在位置
        System.out.println(byteBuffer.position());
        //10 最多能操作到哪个索引
        System.out.println(byteBuffer.capacity());
        //10  返回缓冲区总长度
        System.out.println(byteBuffer.limit());
        //0 还有多少个能操作
        System.out.println(byteBuffer.remaining());
        //false 是否还能有操作的数组
        System.out.println(byteBuffer.hasRemaining());
        // 如果缓存区存满后, 可以调整position位置可以重复写,这样会覆盖之前存入索引的对应的值
        byteBuffer.position(0);
        byteBuffer.put("012345".getBytes());
    }

}
