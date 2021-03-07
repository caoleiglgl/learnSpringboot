package com.example.test;

import com.example.restservice.subjectobserver.Observer;
import com.example.restservice.subjectobserver.Subject;
import org.junit.jupiter.api.Test;

public class SubjectObserverTest {
    @Test
    public void getTest() {
        Subject subject = new Subject();
        Observer o1 = new Observer("o1",0);
        Observer o2 = new Observer("o2",1);
        Observer o3 = new Observer("o3",0);
        Observer o4 = new Observer("o4",1);
        Observer o5 = new Observer("o5",2);
        subject.add(o1);
        subject.add(o2);
        subject.add(o3);
        subject.add(o4);
        subject.add(o5);
        subject.notifyObserver();
        subject.remove(o1);
        subject.notifyObserver();
        subject.changeStatus(2);


    }
}