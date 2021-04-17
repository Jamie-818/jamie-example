package abstractfactory;

import abstractfactory.color.Blue;
import abstractfactory.color.Color;
import abstractfactory.color.Green;
import abstractfactory.color.Red;
import abstractfactory.shape.Shape;

/**
 * 色彩工厂
 * @author jamie
 */
public class ColorFactory extends AbstractFactory {

    /**
     * 获取形状实例
     * 注意：在色彩工厂是获取不到形状实例的
     * @param shapeType 形状类型
     */
    @Override
    public Shape getShape(String shapeType) {
        return null;
    }

    /**
     * 获取色彩实例
     * @param color 色彩名称
     */
    @Override
    public Color getColor(String color) {
        if(color == null){
            return null;
        }
        if("red".equalsIgnoreCase(color)){
            return new Red();
        }else if("green".equalsIgnoreCase(color)){
            return new Green();
        }else if("blue".equalsIgnoreCase(color)){
            return new Blue();
        }
        return null;
    }

}
