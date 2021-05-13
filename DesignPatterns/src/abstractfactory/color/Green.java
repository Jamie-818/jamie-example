package abstractfactory.color;

/**
 * 绿色 实现类
 * @author jamie
 */
public class Green implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }

}
