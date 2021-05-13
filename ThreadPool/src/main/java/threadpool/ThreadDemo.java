package threadpool;

/**
 * Thread继承实现
 * @author jamie
 */
public class ThreadDemo extends Thread {

    private final String name;

    public ThreadDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name);
    }

    public static void main(String[] args) {
        // run其实是主线程运行的
        new ThreadDemo("jamie").run();
        // start方法才是启动多线程，启动了新的线程去运行重写run方法
        new ThreadDemo("jamie").start();
    }

}
