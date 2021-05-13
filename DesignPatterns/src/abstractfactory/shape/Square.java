package abstractfactory.shape;

/**
 * 正方形 实现类
 * @author jamie
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }

}
