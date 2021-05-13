package abstractfactory.shape;

/**
 * 矩形 实现类
 * @author jamie
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }

}
