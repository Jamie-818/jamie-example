package factory;

/**
 * 发送工厂，获取不同的发送对象
 * @author jamie
 */
public class SenderFactory {

    /**
     * 根据入参获取不同的发送对象
     * @param sendType 发送类型
     */
    public Sender getSender(String sendType) {
        if("".equals(sendType.trim())){
            return null;
        }
        switch(sendType){
            case "sms":
                return new SmsSender();
            case "wechat":
                return new WeChatSender();
            case "mail":
                return new MailSender();
            default:
                return null;
        }
    }

}
