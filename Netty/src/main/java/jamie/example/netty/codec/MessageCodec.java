package jamie.example.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import io.netty.util.CharsetUtil;

import java.util.List;

/**
 * 消息编解码器
 * @author jamie
 */
public class MessageCodec extends MessageToMessageCodec<ByteBuf, String> {

    /**
     * 编码
     * @param ctx 内容上下线
     * @param msg 内容消息
     * @param out 传入到下一个handler里面的对象
     */
    @Override
    protected void encode(ChannelHandlerContext ctx, String msg, List<Object> out) {
        System.out.println("正在进行消息编码...");
        ByteBuf byteBuf = Unpooled.copiedBuffer(msg, CharsetUtil.UTF_8);
        out.add(byteBuf);
    }

    /**
     * 解码
     * @param ctx 内容上下线
     * @param msg 内容消息
     * @param out 传入到下一个handler里面的对象
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) {
        System.out.println("正在进行消息解码...");
        out.add(msg.toString(CharsetUtil.UTF_8)); // 传入到下一个handler里面
    }

}
