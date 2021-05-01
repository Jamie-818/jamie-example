package jamie.example.netty.coder;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Netty服务端
 * @author jamie
 */
public class NettyServer {

    public static void main(String[] args) throws InterruptedException {
        //1.创建bossGroup线程组: 处理网络事件--连接事件 线程数默认为: 2 * 处理器线程数,一般设置成1，因为只是处理连接事件
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        //2.创建workerGroup线程组: 处理网络事件--读写事件 2 * 处理器线程数
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        //3.创建服务端启动助手
        ServerBootstrap bootstrap = new ServerBootstrap();
        //4.设置线程组
        bootstrap.group(bossGroup, workerGroup)
                 //5.设置服务端通道实现;
                 .channel(NioServerSocketChannel.class)
                 //6.参数设置-设置线程队列中等待 连接个数，这里设置的是bossGroup
                 .option(ChannelOption.SO_BACKLOG, 128)
                 //7.参数设置-设置活跃状态,child是设置workerGroup
                 .childOption(ChannelOption.SO_KEEPALIVE, Boolean.TRUE)
                 //8.创建一个通道初始化对象
                 .childHandler(new ChannelInitializer<SocketChannel>() {
                     @Override
                     protected void initChannel(SocketChannel ch) {
                         // 添加解码器
                         ch.pipeline().addLast("messageDecoder", new MessageDecoder());
                         //9.向pipeline中添加自定义业务处理handler
                         ch.pipeline().addLast(new NettyServerHandle());
                     }
                 });
        //10.启动服务端并绑定端口
        ChannelFuture channelFuture = bootstrap.bind(9999);
        // 添加监听器
        channelFuture.addListener((ChannelFutureListener)future -> {
            if(future.isSuccess()){
                System.out.println("端口绑定成功");
            }else{
                System.out.println("端口绑定失败");
            }

        });
        System.out.println("服务器启动成功....");
        //11.关闭通道(并不是真正意义上的关闭,而是监听通道关闭状态)和关闭连接池
        channelFuture.channel().closeFuture().sync();
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }

}
