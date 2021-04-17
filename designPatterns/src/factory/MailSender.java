package factory;

/**
 * 邮箱发送
 * @author jamie
 */
public class MailSender implements Sender {

    /**
     * 发送信息
     */
    @Override
    public void send() {
        System.out.println("邮件消息发送成功");
    }

}
