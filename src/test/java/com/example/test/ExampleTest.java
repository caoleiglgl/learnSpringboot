package com.example.test;


import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

import com.example.restservice.model.MyThreadRunnable;
import com.example.restservice.model.MyThreadThread;
import org.junit.jupiter.api.Test;

public class ExampleTest {
    @Test
    public void getTest() {
        HashMap<Integer, String> map = new HashMap();
        map.put(1, "a");
        map.put(1, "b");
    }


    @Test
    public void getTestThread_join() throws InterruptedException {
        Thread t1 = new Thread(new MyThreadRunnable("thread1"));
        t1.start();
        t1.join();
    }

    @Test
    public void getTestThread_syn() throws InterruptedException {
        MyThreadThread mt = new MyThreadThread();

        Thread t1 = new Thread(mt);    // 定义Thread对象
        Thread t2 = new Thread(mt);    // 定义Thread对象
        Thread t3 = new Thread(mt);    // 定义Thread对象
        Thread t4 = new Thread(mt);    // 定义Thread对象
        Thread t5 = new Thread(mt);    // 定义Thread对象
        Thread t6 = new Thread(mt);    // 定义Thread对象
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();
    }

    @Test
    public void getTestThread_cas() throws InterruptedException {
        IntegerTest();
    }

    private static void IntegerTest() throws InterruptedException {

        final Integer[] noncasi = new Integer[]{0};
        AtomicInteger casi = new AtomicInteger();
        casi.set(0);

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    synchronized (this) { //通过synchronized 和 casi.getAndIncrement() 都可实现 到10000
                        for (int j = 0; j < 1000; j++) {

                            noncasi[0]++;
                            //casi.getAndIncrement();
                        }
                    }
                }
            });
            thread.start();
        }

        while (Thread.activeCount() > 2) {
            Thread.sleep(10);
        }
        System.out.println("noncasi:" + noncasi[0]);
        System.out.println("casi:" + casi.get());
    }

    @Test
    public void getTestThread_CountDownLatch() throws InterruptedException {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        final CountDownLatch latch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + "减一");
                        latch.countDown();
                    } catch (Exception ex) {

                    }
                }
            };
            cachedThreadPool.execute(runnable);

//            Thread td = new Thread(runnable);
//            td.start();
        }
        latch.await();
        System.out.println(Thread.currentThread().getName() + "end");

    }

}
