package jamie.example.netty.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;

/**
 * 自定义服务端handle
 * @author jamie
 */
public class NettyServerHandle implements ChannelInboundHandler {

    /**
     * 通道读取事件
     * @param ctx 通道上下文对象
     * @param msg 消息
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("客户端发来消息:" + msg);
    }

    /**
     * 通道读取完毕事件
     * @param ctx 通道上下文对象
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        // 消息出站
        ctx.writeAndFlush("你好,我是Netty服务端.");
    }

    /**
     * 通道异常事件
     * @param ctx   通道上下文对象
     * @param cause 异常对象
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // 输出异常消息并关闭通道
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) {

    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) {

    }

    /*** 通道就绪事件
     *  @param ctx 通道上下文对象
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) {

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {

    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object o) {

    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) {

    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {

    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {

    }

}
