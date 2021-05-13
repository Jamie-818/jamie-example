package threadpool;

/**
 * Runnable接口实现线程
 * @author jamie
 */
public class RunnableDemo implements Runnable {

    private final String name;

    public RunnableDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name);
    }

    public static void main(String[] args) {
        RunnableDemo runnableDemo = new RunnableDemo("jamie");
        // 实现Runnable接口的子类不像继承Thread类的子类那样有start()方法，可以通过Thread类来启动Runnable线程
        new Thread(runnableDemo).start();
    }

}

