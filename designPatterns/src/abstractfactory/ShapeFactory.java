package abstractfactory;

import abstractfactory.color.Color;
import abstractfactory.shape.Circle;
import abstractfactory.shape.Rectangle;
import abstractfactory.shape.Shape;
import abstractfactory.shape.Square;

/**
 * 形状工厂
 * @author jamie
 */
public class ShapeFactory extends AbstractFactory {

    /**
     * 创建形状实例
     * @param shapeType 形状类型
     */
    @Override
    public Shape getShape(String shapeType) {
        if(shapeType == null){
            return null;
        }
        if("circle".equalsIgnoreCase(shapeType)){
            return new Circle();
        }else if("rectangle".equalsIgnoreCase(shapeType)){
            return new Rectangle();
        }else if("square".equalsIgnoreCase(shapeType)){
            return new Square();
        }
        return null;
    }

    /**
     * 获取颜色实例
     * 注意：在形状工厂是获取不到颜色实例的
     * @param color 颜色
     */
    @Override
    public Color getColor(String color) {
        return null;
    }

}
