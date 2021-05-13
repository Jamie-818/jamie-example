package abstractfactory.color;

/**
 * 蓝色 实现类
 * @author jamie
 */
public class Blue implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }

}
