# 工厂模式

工厂模式（Factory Pattern）是 Java 中最常用的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。

在工厂模式中，我们在创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同的接口来指向新创建的对象。

## 介绍

**意图：**定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类，工厂模式使其创建过程延迟到子类进行。

**主要解决：**主要解决接口选择的问题。

**何时使用：**我们明确地计划不同条件下创建不同实例时。

**如何解决：**让其子类实现工厂接口，返回的也是一个抽象的产品。

**关键代码：**创建过程在其子类执行。

**应用实例：**

1、您需要一辆汽车，可以直接从工厂里面提货，而不用去管这辆汽车是怎么做出来的，以及这个汽车里面的具体实现。

2、Hibernate 换数据库只需换方言和驱动就可以。

**优点：**

1、一个调用者想创建一个对象，只要知道其名称就可以了。

2、扩展性高，如果想增加一个产品，只要扩展一个工厂类就可以。

3、屏蔽产品的具体实现，调用者只关心产品的接口。

**缺点：**每次增加一个产品时，都需要增加一个具体类和对象实现工厂，使得系统中类的个数成倍增加，在一定程度上增加了系统的复杂度，同时也增加了系统具体类的依赖。这并不是什么好事。

**使用场景：**

1、日志记录器：记录可能记录到本地硬盘、系统事件、远程服务器等，用户可以选择记录日志到什么地方。

2、数据库访问，当用户不知道最后系统采用哪一类数据库，以及数据库可能有变化时。

3、设计一个连接服务器的框架，需要三个协议，"POP3"、"IMAP"、"HTTP"，可以把这三个作为产品类，共同实现一个接口。

**注意事项：**作为一种创建类模式，在任何需要生成复杂对象的地方，都可以使用工厂方法模式。有一点需要注意的地方就是复杂对象适合使用工厂模式，而简单对象，特别是只需要通过 new 就可以完成创建的对象，无需使用工厂模式。如果使用工厂模式，就需要引入一个工厂类，会增加系统的复杂度。

## 实现

我们将创建一个 *Sender* 接口和实现 *Sender* 接口的实体类。下一步是定义工厂类 *SenderFactory*。

*FactoryPatternDemo* 类使用 *SenderFactory* 来获取 *Sender* 对象。它将向 *SenderFactory* 传递信息（*sms / wechat/ mail*），以便获取它所需对象的类型。

![image-20210417131613658](https://image-show.oss-cn-shenzhen.aliyuncs.com/typora_img/image-20210417131613658.png)

```
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
```

> 从源码和UML图可以看到，工厂模式的调用流程是
>
> 1、创建工厂类
>
> 2、传入参数给工厂，工厂根据参数创建不同实例
>
> 3、调用实例的方法。

## 源码实现

### 1、创建发送接口

```
/**
 * 发送接口
 * @author jamie
 */
public interface Sender {

    /**
     * 发送方法
     */
    void send();

}
```

### 2、创建接口的实现类

```
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
```

```
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
```

```
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
```

### 3、创建工厂

```
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
```

## 源码测试

```
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
```

```
短信发送成功
微信发送成功
邮件消息发送成功
```

源码地址：https://github.com/Jamie-818/jamie-example/tree/master/designpatterns/src/factory