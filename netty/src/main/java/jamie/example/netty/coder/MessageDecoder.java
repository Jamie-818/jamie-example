package jamie.example.netty.coder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.CharsetUtil;

import java.util.List;

/**
 * 消息解码器
 * @author Jmaie
 */
public class MessageDecoder extends MessageToMessageDecoder<ByteBuf> {

    /**
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
