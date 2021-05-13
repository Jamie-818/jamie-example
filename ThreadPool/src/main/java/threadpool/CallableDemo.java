package threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable 实现线程创建
 * @author jamie
 */
public class CallableDemo implements Callable<Integer> {

    private final String name;

    public CallableDemo(String name) {
        this.name = name;
    }

    @Override
    public Integer call() {
        System.out.println(name);
        return 1;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo task = new CallableDemo("jamie");
        FutureTask<Integer> futureTask = new FutureTask<>(task);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println("运行结果(线程返回值)：" + futureTask.get());

    }

}
