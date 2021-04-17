package factory;

/**
 * 短信发送
 * @author jamie
 */
public class SmsSender implements Sender {

    /**
     * 短信发送
     */
    @Override
    public void send() {
        System.out.println("短信发送成功");
    }

}
