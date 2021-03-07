package com.example.restservice.subjectobserver;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSubject {
    private List<IObserver> list;
    private int state;

    public AbstractSubject() {
        if (list == null) {
            list = new ArrayList<>();
        }
    }

    public void add(IObserver observer) {
        System.out.println(observer.getName()+"_"+observer.getStatus()+"_加入");
        this.list.add(observer);
    }

    public void remove(IObserver observer) {
        System.out.println(observer.getName()+"_"+observer.getStatus()+"_移除");
        this.list.remove(observer);
    }

    public void notifyObserver() {
        for (IObserver observer : list) {
            if (observer.getNotifyState() == this.state) {
                observer.notifyMe();
            }
        }
    }

    public void changeStatus(int state) {
        this.state = state;
        this.notifyObserver();

    }
}
