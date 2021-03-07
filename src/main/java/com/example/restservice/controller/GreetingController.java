package com.example.restservice.controller;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

import com.example.restservice.model.Greeting;
import com.example.restservice.model.MyThreadRunnable;
import com.example.restservice.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Value("${country.city}")
    private String city;

    @Autowired()
    Person pp;
    @Autowired()
    Person pp1;

    @Value("${person.name}")
    private String personName;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        int length = 10;
        int newLength = length >> 1; //=15，ArrayList的扩容

        String name0 = pp.getName();
        int age0 = pp.getAge();
        String name1 = pp1.getName();
        int age1 = pp1.getAge();

        return new Greeting(counter.incrementAndGet(), String.format(template, name), city);
    }

    @GetMapping("/threadtest")
    public String threadtest() {
        Thread t1 = new Thread(new MyThreadRunnable("thread1"));
        Thread t2 = new Thread(new MyThreadRunnable("thread2"));
        t1.start();
        t2.start();
        return "ok;";
    }

    @Bean(name = "pp", initMethod = "init")
    @ConfigurationProperties(prefix = "person")
    public Person getPerson() {
        return new Person();
    }

    @Bean(name = "pp1")
    @ConfigurationProperties(prefix = "person1")
    public Person getPerson1() {
        return new Person();
    }


    @RequestMapping("/{pid}/index.html")
    public ModelAndView index(@PathVariable Integer pid) {
        return new ModelAndView();
    }
}
