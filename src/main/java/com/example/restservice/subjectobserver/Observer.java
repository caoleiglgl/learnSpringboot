package com.example.restservice.subjectobserver;

public class Observer implements IObserver {
    private String name;
    private int status;

    public Observer(String name, int status) {
        this.name = name;
        this.status = status;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public int getNotifyState() {
        return this.status;
    }

    @Override
    public void notifyMe() {
        System.out.println(name + "_" + status + "_被通知");
    }
}
