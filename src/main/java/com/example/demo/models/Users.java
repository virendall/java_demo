package com.example.demo.models;

public class Users {
    private String name;
    private int age;

    public Users(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void printUserInfo() {
        System.out.println(name + " " + age);
    }

    protected String getName() {
        return name;
    }

    private int getAge() {
        return age;
    }
}
