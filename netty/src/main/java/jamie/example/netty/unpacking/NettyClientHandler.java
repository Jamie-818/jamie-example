package jamie.example.netty.unpacking;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * 客户端处理类
 * @author jamie
 */
public class NettyClientHandler implements ChannelInboundHandler {

    /**
     * 通道就绪事件
     * @param ctx
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 重现TCP发送中粘包的情况，因为发送的内容太少，TCP底层会把发送的内容一次性发送过去，导致服务端是收到一次请求，但是是所有数据
        for(int i = 0; i < 10; i++){
            // ctx.writeAndFlush(Unpooled.copiedBuffer("你好呀.我是Netty客户端" + i + "$", CharsetUtil.UTF_8));
            ctx.writeAndFlush(Unpooled.copiedBuffer("你好呀.我是Netty客户端" + i, CharsetUtil.UTF_8));
        }
    }

    /**
     * 通道读就绪事件
     * @param ctx
     * @param msg
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf)msg;
        System.out.println("服务端发送的消息:" + byteBuf.toString(CharsetUtil.UTF_8));
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

    }

}
