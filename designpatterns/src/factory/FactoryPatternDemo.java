package factory;

/**
 * 工厂模式调用demo
 * @author jamie
 */
public class FactoryPatternDemo {

    public static void main(String[] args) {
        SenderFactory senderFactory = new SenderFactory();
        //获取 短信发送 的对象，并调用它的 send 方法
        Sender sms = senderFactory.getSender("sms");
        //调用 短信发送 的 send 方法
        sms.send();

        //获取 微信推送 的对象，并调用它的 send 方法
        Sender wechat = senderFactory.getSender("wechat");
        //调用 微信推送 的 send 方法
        wechat.send();

        //获取 邮件发送 的对象，并调用它的 send 方法
        Sender sender3 = senderFactory.getSender("mail");
        //调用 邮件发送 的 send 方法
        sender3.send();
    }

}
