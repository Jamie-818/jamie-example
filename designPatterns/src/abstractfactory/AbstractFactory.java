package abstractfactory;

import abstractfactory.color.Color;
import abstractfactory.shape.Shape;

/**
 * 抽象工厂
 * @author jamie
 */
public abstract class AbstractFactory {

    /**
     * 获取色彩
     * @param color 色彩入参
     * @return 色彩实例
     */
    public abstract Color getColor(String color);
    /**
     * 获取形状
     * @param shape 形状类型入参
     * @return 形状实例
     */
    public abstract Shape getShape(String shape);

}
