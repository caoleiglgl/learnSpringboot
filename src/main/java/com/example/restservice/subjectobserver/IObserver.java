package com.example.restservice.subjectobserver;

public interface IObserver {
    int getNotifyState();

    void notifyMe();

    String getName();

    int getStatus();
}
