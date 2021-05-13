package abstractfactory.color;

/**
 * 红色 实现类
 * @author jamie
 */
public class Red implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }

}
