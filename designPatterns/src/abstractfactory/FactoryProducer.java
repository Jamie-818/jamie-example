package abstractfactory;

/**
 * 工厂创建器
 * @author jamie
 */
public class FactoryProducer {

    /**
     * 获取工厂实例
     * @param choice 工厂类型
     */
    public static AbstractFactory getFactory(String choice) {
        if("shape".equalsIgnoreCase(choice)){
            return new ShapeFactory();
        }else if("color".equalsIgnoreCase(choice)){
            return new ColorFactory();
        }
        return null;
    }

}
