package threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author jamie
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService executorService1 = Executors.newCachedThreadPool(); // 快
        ExecutorService executorService2 = Executors.newFixedThreadPool(10); // 慢
        ExecutorService executorService3 = Executors.newSingleThreadExecutor(); // 最慢
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(10));
        for(int i = 0; i < 100; i++){
            threadPoolExecutor.execute(new MyTask(i));
        }

    }

}

class MyTask implements Runnable {

    int i;

    public MyTask(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--" + i);
        try{
            // 业务逻辑
            Thread.sleep(1000L);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
