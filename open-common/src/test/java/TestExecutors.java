import javafx.concurrent.Task;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by jj02 on 2017/6/22.
 */
public class TestExecutors {
    @Test
    public void test() throws InterruptedException {
        ExecutorService exec = null;
        exec = Executors.newFixedThreadPool(2);
        int count = 0;
        exec.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                throw new RuntimeException("test exception1!");
            }
        });
        count = ((ThreadPoolExecutor)exec).getActiveCount();
        System.out.println(count);
        System.out.println("-----------------");
        Thread.sleep(100);

        exec.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                throw new RuntimeException("test exception2!");
            }
        });

        count = ((ThreadPoolExecutor)exec).getActiveCount();
        System.out.println(count);
        System.out.println("-----------------");
        Thread.sleep(100);

        exec.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                throw new RuntimeException("test exception3!");
            }
        });

        count = ((ThreadPoolExecutor)exec).getActiveCount();
        System.out.println(count);
        System.out.println("-----------------");
        Thread.sleep(100);



        exec.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        });

        System.out.println("hahaha");
        count = ((ThreadPoolExecutor)exec).getActiveCount();
        int size = ((ThreadPoolExecutor)exec).getCorePoolSize();
        System.out.println(count + ":" + size);
        System.out.println("-----------------");

        exec.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("heiehei");
            }
        });

        count = ((ThreadPoolExecutor)exec).getActiveCount();
        size = ((ThreadPoolExecutor)exec).getCorePoolSize();
        System.out.println(count + ":" + size);
        System.out.println("-----------------");
        Thread.sleep(1000000);
    }

}
