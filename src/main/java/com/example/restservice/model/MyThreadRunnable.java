package com.example.restservice.model;

public class MyThreadRunnable implements Runnable {
    private String name;

    public MyThreadRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(10);
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        } catch (Exception ex) {

        }

    }
}
