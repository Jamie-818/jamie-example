package factory;

/**
 * 微信发送
 * @author jamie
 */
public class WeChatSender implements Sender {

    /**
     * 发送信息
     */
    @Override
    public void send() {
        System.out.println("微信发送成功");
    }

}
