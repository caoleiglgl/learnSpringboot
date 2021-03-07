package com.example.restservice.model;

public class Greeting {

    private final long id;
    private final String content;
    private final String city;


    public Greeting(long id, String content, String city) {
        this.id = id;
        this.content = content;
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getCity() {
        return city;
    }
}
