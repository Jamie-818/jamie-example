package jamie.example.netty.coder;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * 客户端处理类
 * @author jamie
 */
public class NettyClientHandle implements ChannelInboundHandler {

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) {

    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) {

    }

    /**
     * 通道就绪事件
     * @param ctx 通道上下文对象
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ChannelFuture channelFuture = ctx.writeAndFlush(Unpooled.copiedBuffer("你好呀,我是Netty客户端", CharsetUtil.UTF_8));
        channelFuture.addListener((ChannelFutureListener)future -> {
            if(future.isSuccess()){
                System.out.println("数据发送成功");
            }else{
                System.out.println("数据发送失败");
            }

        });

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("服务端发来消息:" + msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {

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

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable throwable) {

    }

}
