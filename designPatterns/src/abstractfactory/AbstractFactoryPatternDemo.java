package abstractfactory;

import abstractfactory.color.Color;
import abstractfactory.shape.Shape;

/**
 * 抽象工厂测试类
 * @author jamie
 */
public class AbstractFactoryPatternDemo {

    public static void main(String[] args) {
        System.out.println("------- shape -------");
        //获取形状工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
        //获取形状为 Circle 的对象
        Shape circle = shapeFactory.getShape("circle");
        //调用 Circle 的 draw 方法
        circle.draw();
        //获取形状为 Rectangle 的对象
        Shape rectangle = shapeFactory.getShape("rectangle");
        //调用 Rectangle 的 draw 方法
        rectangle.draw();
        //获取形状为 Square 的对象
        Shape square = shapeFactory.getShape("square");
        //调用 Square 的 draw 方法
        square.draw();

        System.out.println("------- color -------");
        //获取颜色工厂
        AbstractFactory colorFactory = FactoryProducer.getFactory("color");
        //获取颜色为 Red 的对象
        Color red = colorFactory.getColor("red");
        //调用 Red 的 fill 方法
        red.fill();
        //获取颜色为 Green 的对象
        Color green = colorFactory.getColor("green");
        //调用 Green 的 fill 方法
        green.fill();
        //获取颜色为 Blue 的对象
        Color blue = colorFactory.getColor("blue");
        //调用 Blue 的 fill 方法
        blue.fill();
    }

}

