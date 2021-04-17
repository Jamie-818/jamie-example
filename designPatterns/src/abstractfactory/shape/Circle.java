package abstractfactory.shape;

/**
 * 圆形 实现类
 * @author jamie
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }

}
