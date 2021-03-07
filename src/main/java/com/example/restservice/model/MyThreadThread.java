package com.example.restservice.model;

public class MyThreadThread extends Thread {
    private  Integer tickets = 4;

    @Override
    public void run() {
//        //synchronized (this) {
//        if (tickets > 0) {   // 还有票
//            try {
//                Thread.sleep(300); // 加入延迟
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            System.out.println(Thread.currentThread().getName() + "-卖票：ticket 还剩 " + tickets--);
//        } else {
//            System.out.println("售尽");
//        }
//        // }
        sale();
    }

    private synchronized void sale() {
        if (tickets > 0) {   // 还有票
            try {
                Thread.sleep(300); // 加入延迟
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "-卖票：ticket 还剩 " + tickets--);
        } else {
            System.out.println("售尽");
        }
    }
}
